package com.helpshift.conversation.activeconversation.usersetup;

/* loaded from: classes2.dex */
public interface ConversationSetupRenderer {
    void hideNoInternetView();

    void hideProgressBar();

    void hideProgressDescription();

    void onAuthenticationFailure();

    void onConversationSetupComplete();

    void showNoInternetView();

    void showProgressBar();

    void showProgressDescription();
}
