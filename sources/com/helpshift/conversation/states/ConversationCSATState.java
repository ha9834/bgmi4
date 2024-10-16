package com.helpshift.conversation.states;

/* loaded from: classes2.dex */
public enum ConversationCSATState {
    NONE(0),
    SUBMITTED_NOT_SYNCED(1),
    SUBMITTED_SYNCED(2),
    EXPIRED(3);

    private final int value;

    ConversationCSATState(int i) {
        this.value = i;
    }

    public static ConversationCSATState fromInt(int i) {
        ConversationCSATState conversationCSATState;
        ConversationCSATState[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                conversationCSATState = null;
                break;
            }
            conversationCSATState = values[i2];
            if (conversationCSATState.value == i) {
                break;
            }
            i2++;
        }
        return conversationCSATState == null ? NONE : conversationCSATState;
    }

    public int getValue() {
        return this.value;
    }
}
