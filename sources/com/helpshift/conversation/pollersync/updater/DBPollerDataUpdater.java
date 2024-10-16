package com.helpshift.conversation.pollersync.updater;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.dao.DAOResult;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.pollersync.exception.PollerSyncException;
import com.helpshift.conversation.pollersync.merger.ConversationDataMerger;
import com.helpshift.conversation.pollersync.merger.MessagesDataMerger;
import com.helpshift.conversation.pollersync.model.ConversationsDiff;
import com.helpshift.conversation.pollersync.model.ConversationsLookup;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class DBPollerDataUpdater implements PollerDataUpdater {
    private static final String TAG = "HS_DBPollerDataUpdater";
    private ConversationDAO conversationDAO;
    private ConversationDataMerger conversationDataMerger;
    private MessagesDataMerger messagesDataMerger;
    private Platform platform;
    private PollerSyncDataProvider syncDataProvider;
    private UserDM userDM;

    public DBPollerDataUpdater(Platform platform, Domain domain, UserDM userDM, PollerSyncDataProvider pollerSyncDataProvider) {
        this.platform = platform;
        this.userDM = userDM;
        this.conversationDataMerger = new ConversationDataMerger(platform, domain.getSDKConfigurationDM());
        this.messagesDataMerger = new MessagesDataMerger(pollerSyncDataProvider);
        this.conversationDAO = platform.getConversationDAO();
        this.syncDataProvider = pollerSyncDataProvider;
    }

    @Override // com.helpshift.conversation.pollersync.updater.PollerDataUpdater
    public ConversationsDiff updateData(List<Conversation> list) throws PollerSyncException {
        HSLogger.d(TAG, "Starting with updating the fetched data in DB, conversations size: " + list.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        List<Conversation> readConversationsWithoutMessagesFromDB = readConversationsWithoutMessagesFromDB();
        ArrayList deepClone = CloneUtil.deepClone(readConversationsWithoutMessagesFromDB);
        ConversationsLookup conversationsLookup = new ConversationsLookup(readConversationsWithoutMessagesFromDB, this.syncDataProvider);
        int i = 0;
        while (i < list.size()) {
            Conversation conversation = list.get(i);
            ValuePair<ConversationsLookup.MatchingID, Conversation> find = conversationsLookup.find(conversation);
            if (find == null) {
                HSLogger.d(TAG, "Matching conversation not found from DB, processing as new conversation");
                deriveConversationPropertiesForNewConversations(conversation, i == list.size() - 1);
                arrayList.add(conversation);
            } else {
                HSLogger.d(TAG, "Matching conversation found from DB, processing as updated conversation");
                ConversationsLookup.MatchingID matchingID = find.first;
                Conversation conversation2 = find.second;
                if (matchingID == ConversationsLookup.MatchingID.PREISSUE_REQUEST_ID) {
                    deleteLocalMessagesForPreIssue(conversation2);
                }
                this.conversationDataMerger.mergeProperties(conversation2, conversation);
                if (!ListUtils.isEmpty(conversation.messageDMs)) {
                    hashMap.put(conversation2, this.messagesDataMerger.mergeMessages(conversation2, readMessagesFromDB(conversation2), conversation.messageDMs));
                }
                arrayList2.add(conversation2);
            }
            i++;
        }
        removeConvertedPreIssueConversations(arrayList);
        ConversationsDiff conversationsDiff = new ConversationsDiff(deepClone, arrayList, arrayList2, hashMap);
        writeToDB(conversationsDiff);
        return conversationsDiff;
    }

    private void deleteLocalMessagesForPreIssue(Conversation conversation) {
        this.conversationDAO.deleteMessagesForConversation(conversation.localId.longValue());
    }

    private void writeToDB(ConversationsDiff conversationsDiff) throws PollerSyncException {
        HSLogger.d(TAG, "Writing data to DAO, updated conversations size: " + conversationsDiff.updatedConversations.size());
        if (!this.conversationDAO.updateConversations(conversationsDiff.messagesDiffMap, conversationsDiff.updatedConversations)) {
            throw new PollerSyncException("Exception occurred while updating conversations in DB");
        }
        HSLogger.d(TAG, "Writing data to DAO, new conversations size: " + conversationsDiff.newConversations.size());
        if (!this.conversationDAO.insertConversations(conversationsDiff.newConversations)) {
            throw new PollerSyncException("Exception occurred while inserting conversations in DB");
        }
    }

    private List<Conversation> readConversationsWithoutMessagesFromDB() throws PollerSyncException {
        DAOResult<List<Conversation>> readConversationsWithoutMessages = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue());
        if (!readConversationsWithoutMessages.isSuccess()) {
            throw new PollerSyncException("Exception occurred while reading conversations from DB");
        }
        return readConversationsWithoutMessages.getData();
    }

    private List<MessageDM> readMessagesFromDB(Conversation conversation) throws PollerSyncException {
        DAOResult<List<MessageDM>> readMessages = this.conversationDAO.readMessages(conversation.localId.longValue());
        if (!readMessages.isSuccess()) {
            throw new PollerSyncException("Exception occurred while reading messages from DB");
        }
        return readMessages.getData();
    }

    void deriveConversationPropertiesForNewConversations(Conversation conversation, boolean z) {
        setUserLocalId(conversation);
        checkAndUpdateLastUserActivityTime(conversation);
        checkAndUpdateStateToResolutionExpired(conversation);
        checkAndUpdateStateToResolutionAccepted(conversation);
        checkAndUpdateStartNewConversationClickedFlag(conversation, z);
        checkAndUpdateCSATStateToExpired(conversation);
    }

    private void setUserLocalId(Conversation conversation) {
        conversation.userLocalId = this.userDM.getLocalId().longValue();
    }

    private void checkAndUpdateLastUserActivityTime(Conversation conversation) {
        if (conversation.isInPreIssueMode()) {
            conversation.lastUserActivityTime = System.currentTimeMillis();
        }
    }

    private void checkAndUpdateStateToResolutionAccepted(Conversation conversation) {
        if (conversation.state == IssueState.RESOLUTION_REQUESTED) {
            if (conversation.isInPreIssueMode() || conversation.isRedacted) {
                conversation.state = IssueState.RESOLUTION_ACCEPTED;
            }
        }
    }

    private void checkAndUpdateStateToResolutionExpired(Conversation conversation) {
        if (ConversationUtil.isResolutionQuestionExpired(this.platform, conversation)) {
            conversation.state = IssueState.RESOLUTION_EXPIRED;
        }
    }

    private void checkAndUpdateCSATStateToExpired(Conversation conversation) {
        if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
            conversation.csatState = ConversationCSATState.EXPIRED;
        }
    }

    private void checkAndUpdateStartNewConversationClickedFlag(Conversation conversation, boolean z) {
        boolean z2 = false;
        switch (conversation.state) {
            case RESOLUTION_ACCEPTED:
            case RESOLUTION_REJECTED:
            case RESOLUTION_EXPIRED:
            case REJECTED:
            case ARCHIVED:
                if (!z || conversation.isRedacted) {
                    z2 = true;
                    break;
                }
                break;
        }
        conversation.isStartNewConversationClicked = z2;
    }

    void removeConvertedPreIssueConversations(List<Conversation> list) {
        if (list.size() <= 1) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Conversation conversation = (Conversation) arrayList.get(size);
            if (!conversation.isInPreIssueMode()) {
                int i = size - 1;
                while (true) {
                    if (i >= 0) {
                        Conversation conversation2 = (Conversation) arrayList.get(i);
                        if (!StringUtils.isEmpty(conversation.preConversationServerId) && conversation.preConversationServerId.equals(conversation2.preConversationServerId) && conversation.serverId.equals(conversation2.serverId)) {
                            conversation.messageDMs.addAll(conversation2.messageDMs);
                            list.remove(conversation2);
                            break;
                        }
                        i--;
                    }
                }
            }
        }
    }
}
