package com.helpshift.conversation.loaders;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConversationHistoryDBLoader extends ConversationDBLoader {
    private UserDM userDM;

    public ConversationHistoryDBLoader(UserDM userDM, ConversationDAO conversationDAO) {
        super(conversationDAO);
        this.userDM = userDM;
    }

    @Override // com.helpshift.conversation.loaders.ConversationDBLoader
    public List<Conversation> fetchMessages(String str, String str2, long j) {
        List<Conversation> filterOutMultipleOpenConversations;
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (data.isEmpty()) {
            return new ArrayList();
        }
        ConversationUtil.sortConversationsBasedOnCreatedAt(data);
        boolean isEmpty = StringUtils.isEmpty(str);
        ArrayList arrayList = new ArrayList();
        if (!isEmpty) {
            data = filterOutConversationCreatedAfterCursor(str, data);
            if (!ListUtils.isEmpty(data)) {
                Conversation conversation = data.get(data.size() - 1);
                if (conversation.getCreatedAt().equals(str)) {
                    List<MessageDM> filterMessages = filterMessages(str2, j, this.conversationDAO.readMessages(conversation.localId.longValue()).getData());
                    if (!ListUtils.isEmpty(filterMessages)) {
                        conversation.setMessageDMs(filterMessages);
                        arrayList.add(conversation);
                        j -= filterMessages.size();
                    }
                    data.remove(conversation);
                }
            }
        }
        if (j < 1) {
            return arrayList;
        }
        if (isEmpty) {
            int size = data.size();
            if (size > 1) {
                int i = size - 1;
                Conversation conversation2 = data.get(i);
                data = filterOutFullPrivacyEnabledConversations(data.subList(0, i));
                data.add(conversation2);
            }
        } else {
            data = filterOutFullPrivacyEnabledConversations(data);
        }
        List<Conversation> filterOutRejectedEmptyPreIssues = filterOutRejectedEmptyPreIssues(data);
        if (isEmpty) {
            Conversation lastOpenConversation = getLastOpenConversation(filterOutRejectedEmptyPreIssues);
            filterOutMultipleOpenConversations = filterOutMultipleOpenConversations(filterOutRejectedEmptyPreIssues);
            if (lastOpenConversation != null) {
                filterOutMultipleOpenConversations.add(lastOpenConversation);
            }
        } else {
            filterOutMultipleOpenConversations = filterOutMultipleOpenConversations(filterOutRejectedEmptyPreIssues);
        }
        List<Conversation> filterOutConversationsForWhichMessagesLimitExceed = filterOutConversationsForWhichMessagesLimitExceed(j, filterOutMultipleOpenConversations);
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Conversation conversation3 : filterOutConversationsForWhichMessagesLimitExceed) {
            arrayList2.add(conversation3.localId);
            hashMap.put(conversation3.localId, conversation3);
        }
        for (MessageDM messageDM : this.conversationDAO.readMessagesForConversations(arrayList2)) {
            if (hashMap.containsKey(messageDM.conversationLocalId)) {
                ((Conversation) hashMap.get(messageDM.conversationLocalId)).messageDMs.add(messageDM);
            }
        }
        int i2 = 0;
        for (int size2 = filterOutConversationsForWhichMessagesLimitExceed.size() - 1; size2 >= 0; size2--) {
            Conversation conversation4 = filterOutConversationsForWhichMessagesLimitExceed.get(size2);
            if (conversation4.messageDMs.size() + i2 > j) {
                ConversationUtil.sortMessagesBasedOnCreatedAt(conversation4.messageDMs);
                ArrayList arrayList3 = new ArrayList(conversation4.messageDMs);
                conversation4.messageDMs.clear();
                conversation4.messageDMs.addAll(arrayList3.subList(arrayList3.size() - ((int) (j - i2)), arrayList3.size()));
            } else {
                i2 += conversation4.messageDMs.size();
            }
        }
        arrayList.addAll(0, filterOutConversationsForWhichMessagesLimitExceed);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ConversationUtil.sortMessagesBasedOnCreatedAt(((Conversation) it.next()).messageDMs);
        }
        return arrayList;
    }

    private List<Conversation> filterOutConversationsForWhichMessagesLimitExceed(long j, List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Conversation> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().localId);
        }
        Map<Long, Integer> messagesCountForConversations = this.conversationDAO.getMessagesCountForConversations(arrayList);
        int i = 0;
        ArrayList arrayList2 = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Conversation conversation = list.get(size);
            int intValue = messagesCountForConversations.get(conversation.localId).intValue();
            arrayList2.add(conversation);
            i += intValue;
            if (i >= j) {
                break;
            }
        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    private List<Conversation> filterOutConversationCreatedAfterCursor(String str, List<Conversation> list) {
        if (ListUtils.isEmpty(list) || StringUtils.isEmpty(str)) {
            return list;
        }
        long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(str);
        ArrayList arrayList = new ArrayList();
        for (Conversation conversation : list) {
            if (compareEpochTime(conversation.getEpochCreatedAtTime(), convertToEpochTime) > 0) {
                break;
            }
            arrayList.add(conversation);
        }
        return arrayList;
    }

    private List<Conversation> filterOutFullPrivacyEnabledConversations(List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Conversation conversation = list.get(i);
            if (!conversation.wasFullPrivacyEnabledAtCreation) {
                arrayList.add(conversation);
            }
        }
        return arrayList;
    }

    private List<Conversation> filterOutRejectedEmptyPreIssues(List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Conversation conversation : list) {
            if (conversation.state == IssueState.REJECTED && IssueType.PRE_ISSUE.equals(conversation.issueType)) {
                arrayList2.add(conversation.localId);
            }
        }
        if (arrayList2.isEmpty()) {
            arrayList.addAll(list);
            return arrayList;
        }
        Map<Long, Integer> userMessageCountForConversationLocalIds = ConversationUtil.getUserMessageCountForConversationLocalIds(this.conversationDAO, arrayList2);
        for (Conversation conversation2 : list) {
            Integer num = userMessageCountForConversationLocalIds.get(conversation2.localId);
            if (num == null || num.intValue() != 0) {
                arrayList.add(conversation2);
            }
        }
        return arrayList;
    }

    private List<Conversation> filterOutMultipleOpenConversations(List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (Conversation conversation : list) {
            if (!conversation.isIssueInProgress()) {
                arrayList.add(conversation);
            }
        }
        return arrayList;
    }

    private Conversation getLastOpenConversation(List<Conversation> list) {
        Conversation conversation = null;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        for (Conversation conversation2 : list) {
            if (conversation2.isIssueInProgress()) {
                conversation = conversation2;
            }
        }
        return conversation;
    }
}
