package com.helpshift.conversation.loaders;

import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ConversationDBLoader {
    protected ConversationDAO conversationDAO;
    private boolean hasMoreMessages = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int compareEpochTime(long j, long j2) {
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public abstract List<Conversation> fetchMessages(String str, String str2, long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public ConversationDBLoader(ConversationDAO conversationDAO) {
        this.conversationDAO = conversationDAO;
    }

    public boolean hasMoreMessages() {
        return this.hasMoreMessages;
    }

    public void setHasMoreMessages(boolean z) {
        this.hasMoreMessages = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<MessageDM> filterMessages(String str, long j, List<MessageDM> list) {
        List<MessageDM> arrayList;
        if (ListUtils.isEmpty(list) || j < 1) {
            return new ArrayList();
        }
        ConversationUtil.sortMessagesBasedOnCreatedAt(list);
        if (StringUtils.isEmpty(str)) {
            arrayList = list;
        } else {
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(str);
            arrayList = new ArrayList<>();
            for (MessageDM messageDM : list) {
                if (convertToEpochTime <= messageDM.getEpochCreatedAtTime()) {
                    break;
                }
                arrayList.add(messageDM);
            }
            if (ListUtils.isEmpty(arrayList)) {
                return new ArrayList();
            }
        }
        int size = arrayList.size();
        return arrayList.subList(Math.max(0, (int) (size - j)), size);
    }
}
