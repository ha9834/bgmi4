package com.helpshift.support.conversations;

import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.support.Faq;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface NewConversationRouter {
    void exitNewConversationView();

    void onAuthenticationFailure();

    void showAttachmentPreviewScreenFromDraft(AttachmentPickerFile attachmentPickerFile);

    void showConversationScreen();

    void showSearchResultFragment(ArrayList<Faq> arrayList);
}
