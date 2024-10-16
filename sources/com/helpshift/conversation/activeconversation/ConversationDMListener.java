package com.helpshift.conversation.activeconversation;

import com.helpshift.conversation.dto.IssueState;

/* loaded from: classes2.dex */
public interface ConversationDMListener {
    void onIssueStatusChange(IssueState issueState);
}
