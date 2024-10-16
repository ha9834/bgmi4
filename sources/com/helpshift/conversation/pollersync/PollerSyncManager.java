package com.helpshift.conversation.pollersync;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.pollersync.exception.PollerSyncException;
import com.helpshift.conversation.pollersync.listener.DBPollerDataChangeListener;
import com.helpshift.conversation.pollersync.listener.IMPollerDataChangeListener;
import com.helpshift.conversation.pollersync.listener.PollerDataChangeListener;
import com.helpshift.conversation.pollersync.model.ConversationsDiff;
import com.helpshift.conversation.pollersync.model.ConversationsLookup;
import com.helpshift.conversation.pollersync.model.MessagesDiff;
import com.helpshift.conversation.pollersync.updater.DBPollerDataUpdater;
import com.helpshift.conversation.pollersync.updater.IMPollerDataUpdater;
import com.helpshift.conversation.pollersync.updater.PollerDataUpdater;
import com.helpshift.conversation.util.predicate.ConversationPredicates;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.Filters;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class PollerSyncManager {
    private static final String TAG = "HS_PollerSyncManager";
    private ConversationManager conversationManager;
    private PollerDataChangeListener dbDataChangeListener;
    private PollerDataUpdater dbDataUpdater;
    private PollerDataChangeListener imDataChangeListener;
    private PollerDataUpdater imDataUpdater;
    private PollerSyncDataProvider syncDataProvider;

    public PollerSyncManager(Domain domain, Platform platform, UserDM userDM, PollerSyncDataProvider pollerSyncDataProvider, ConversationManager conversationManager) {
        this.conversationManager = conversationManager;
        this.syncDataProvider = pollerSyncDataProvider;
        this.dbDataUpdater = new DBPollerDataUpdater(platform, domain, userDM, pollerSyncDataProvider);
        this.imDataUpdater = new IMPollerDataUpdater(platform, domain, pollerSyncDataProvider);
        this.dbDataChangeListener = new DBPollerDataChangeListener(conversationManager, pollerSyncDataProvider);
        this.imDataChangeListener = new IMPollerDataChangeListener(domain, platform, conversationManager, pollerSyncDataProvider);
    }

    public void sync(List<Conversation> list, boolean z) throws PollerSyncException {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        List<Conversation> filterAndSort = filterAndSort(list);
        if (ListUtils.isEmpty(filterAndSort)) {
            return;
        }
        Iterator<List<Conversation>> it = divideIntoChunksIfNeeded(filterAndSort, z).iterator();
        while (it.hasNext()) {
            syncInternal(it.next());
        }
    }

    private void syncInternal(List<Conversation> list) throws PollerSyncException {
        ConversationsDiff updateData = this.dbDataUpdater.updateData(list);
        dispatchListenerCallbacks(this.dbDataChangeListener, updateData);
        if (this.syncDataProvider.getAliveViewableConversation() != null) {
            List<Conversation> createRemoteConversationsForIMDataUpdater = createRemoteConversationsForIMDataUpdater(updateData);
            if (!ListUtils.isEmpty(createRemoteConversationsForIMDataUpdater)) {
                dispatchListenerCallbacks(this.imDataChangeListener, this.imDataUpdater.updateData(createRemoteConversationsForIMDataUpdater));
            }
        }
        onConversationsSyncComplete(list, updateData);
    }

    private List<List<Conversation>> divideIntoChunksIfNeeded(List<Conversation> list, boolean z) {
        boolean z2;
        if (!z) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            Iterator<Conversation> it = list.iterator();
            while (true) {
                z2 = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Conversation next = it.next();
                if (!StringUtils.isEmpty(next.preConversationServerId)) {
                    if (hashSet.contains(next.preConversationServerId)) {
                        break;
                    }
                    hashSet.add(next.preConversationServerId);
                }
                if (!StringUtils.isEmpty(next.serverId)) {
                    if (hashSet2.contains(next.serverId)) {
                        break;
                    }
                    hashSet2.add(next.serverId);
                }
            }
            if (z2) {
                HSLogger.d(TAG, "Found duplicate conversations in same response, will chunk the data for processing");
                return ListUtils.unflatten(list);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(list);
        return arrayList;
    }

    private void dispatchListenerCallbacks(PollerDataChangeListener pollerDataChangeListener, ConversationsDiff conversationsDiff) {
        if (pollerDataChangeListener == null || conversationsDiff == null) {
            return;
        }
        List<Conversation> list = conversationsDiff.existingConversations;
        List<Conversation> list2 = conversationsDiff.updatedConversations;
        ConversationsLookup conversationsLookup = new ConversationsLookup(list, this.syncDataProvider);
        for (Conversation conversation : list2) {
            ValuePair<ConversationsLookup.MatchingID, Conversation> find = conversationsLookup.find(conversation);
            if (find != null) {
                pollerDataChangeListener.onConversationUpdated(find.second, conversation);
            }
            MessagesDiff messagesDiff = conversationsDiff.messagesDiffMap.get(conversation);
            if (messagesDiff != null) {
                List<MessageDM> list3 = messagesDiff.newMessages;
                if (!ListUtils.isEmpty(list3)) {
                    pollerDataChangeListener.onMessagesAdded(conversation, list3);
                }
                List<MessageDM> list4 = messagesDiff.updatedMessages;
                if (!ListUtils.isEmpty(list4)) {
                    pollerDataChangeListener.onMessagesUpdated(messagesDiff.existingMessages, list4);
                }
            }
        }
    }

    private List<Conversation> createRemoteConversationsForIMDataUpdater(ConversationsDiff conversationsDiff) {
        ArrayList arrayList = new ArrayList();
        for (Conversation conversation : conversationsDiff.updatedConversations) {
            Conversation deepClone = conversation.deepClone();
            MessagesDiff messagesDiff = conversationsDiff.messagesDiffMap.get(conversation);
            if (messagesDiff != null) {
                deepClone.messageDMs.addAll(CloneUtil.deepClone(messagesDiff.updatedMessages));
                deepClone.messageDMs.addAll(CloneUtil.deepClone(messagesDiff.newMessages));
            }
            arrayList.add(deepClone);
        }
        return arrayList;
    }

    private List<Conversation> filterAndSort(List<Conversation> list) {
        List<Conversation> filter = Filters.filter(list, ConversationPredicates.allMessagesAfterLastMessageInDbPredicate(this.conversationManager));
        ConversationUtil.sortConversationsBasedOnCreatedAt(filter);
        return filter;
    }

    private void onConversationsSyncComplete(List<Conversation> list, ConversationsDiff conversationsDiff) {
        this.conversationManager.clearRequestIdForPendingCreateConversationCalls(list);
        for (Map.Entry<Conversation, MessagesDiff> entry : conversationsDiff.messagesDiffMap.entrySet()) {
            this.conversationManager.clearRequestIdForPendingSendMessageCalls(entry.getKey(), entry.getValue().updatedMessages);
        }
    }
}
