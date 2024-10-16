package com.helpshift.conversation.pollersync.merger;

import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.pollersync.model.MessagesDiff;
import com.helpshift.conversation.pollersync.model.MessagesLookup;
import com.helpshift.util.CloneUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MessagesDataMerger {
    private PollerSyncDataProvider syncDataProvider;

    public MessagesDataMerger(PollerSyncDataProvider pollerSyncDataProvider) {
        this.syncDataProvider = pollerSyncDataProvider;
    }

    public MessagesDiff mergeMessages(Conversation conversation, List<MessageDM> list, List<MessageDM> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList deepClone = CloneUtil.deepClone(list);
        MessagesLookup messagesLookup = new MessagesLookup(conversation, list, this.syncDataProvider);
        for (MessageDM messageDM : list2) {
            MessageDM find = messagesLookup.find(messageDM);
            if (find == null) {
                deriveMessagePropertiesForNewMessages(conversation, messageDM);
                arrayList.add(messageDM);
            } else {
                mergeProperties(find, messageDM);
                arrayList2.add(find);
            }
        }
        return new MessagesDiff(deepClone, arrayList, arrayList2);
    }

    private void deriveMessagePropertiesForNewMessages(Conversation conversation, MessageDM messageDM) {
        messageDM.conversationLocalId = conversation.localId;
    }

    private void mergeProperties(MessageDM messageDM, MessageDM messageDM2) {
        messageDM.merge(messageDM2);
    }
}
