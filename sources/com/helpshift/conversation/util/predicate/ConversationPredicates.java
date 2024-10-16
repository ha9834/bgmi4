package com.helpshift.conversation.util.predicate;

import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.Predicate;

/* loaded from: classes2.dex */
public class ConversationPredicates {
    public static Predicate<Conversation> newSyncedConversationPredicate(final ConversationManager conversationManager) {
        return new Predicate<Conversation>() { // from class: com.helpshift.conversation.util.predicate.ConversationPredicates.1
            @Override // com.helpshift.util.Predicate
            public boolean matches(Conversation conversation) {
                return ConversationManager.this.isSynced(conversation);
            }
        };
    }

    public static Predicate<Conversation> newInProgressConversationPredicate() {
        return new Predicate<Conversation>() { // from class: com.helpshift.conversation.util.predicate.ConversationPredicates.2
            @Override // com.helpshift.util.Predicate
            public boolean matches(Conversation conversation) {
                return conversation.isIssueInProgress();
            }
        };
    }

    public static Predicate<Conversation> allMessagesAfterLastMessageInDbPredicate(final ConversationManager conversationManager) {
        return new Predicate<Conversation>() { // from class: com.helpshift.conversation.util.predicate.ConversationPredicates.3
            @Override // com.helpshift.util.Predicate
            public boolean matches(Conversation conversation) {
                return !ConversationManager.this.filterMessagesOlderThanLastMessageInDb(conversation);
            }
        };
    }
}
