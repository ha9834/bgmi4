package com.helpshift;

import android.net.Uri;
import com.helpshift.conversation.activeconversation.model.ActionType;
import com.helpshift.delegate.AuthenticationFailureReason;
import com.helpshift.support.Support;
import com.helpshift.util.HSLogger;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes2.dex */
class HelpshiftUE4Delegates implements Support.Delegate {
    private static final String TAG = "Helpshift_CocosDeleg";
    static HashSet<String> supportedFileFormats;

    @Override // com.helpshift.delegate.RootDelegate
    public void authenticationFailed(HelpshiftUser helpshiftUser, AuthenticationFailureReason authenticationFailureReason) {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void conversationEnded() {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void didReceiveNotification(int i) {
    }

    @Override // com.helpshift.support.Support.Delegate
    public void displayAttachmentFile(Uri uri) {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void displayAttachmentFile(File file) {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void newConversationStarted(String str) {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void userClickOnAction(ActionType actionType, String str) {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void userCompletedCustomerSatisfactionSurvey(int i, String str) {
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void userRepliedToConversation(String str) {
    }

    public static void setSupportedFileFormats(String[] strArr) {
        HSLogger.d(TAG, "Setting supported file formats to : " + Arrays.asList(strArr));
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        supportedFileFormats = new HashSet<>(Arrays.asList(strArr));
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void sessionBegan() {
        HelpshiftBridge.helpshiftSessionBegan(HelpshiftBridge.mSessionBeganPointer);
    }

    @Override // com.helpshift.delegate.RootDelegate
    public void sessionEnded() {
        HelpshiftBridge.helpshiftSessionEnded(HelpshiftBridge.mSessionEndPointer);
    }
}
