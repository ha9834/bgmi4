package com.helpshift.conversation.activeconversation.message;

import com.helpshift.conversation.activeconversation.message.Author;
import com.tencent.grobot.lite.GameParameters;

/* loaded from: classes2.dex */
public class SystemMessageDM extends MessageDM {
    @Override // com.helpshift.conversation.activeconversation.message.MessageDM
    public boolean isUISupportedMessage() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemMessageDM(String str, String str2, long j, MessageType messageType) {
        super(str, str2, j, new Author(GameParameters.SOURCE_MOBILE, "", Author.AuthorRole.SYSTEM), false, messageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SystemMessageDM(SystemMessageDM systemMessageDM) {
        super(systemMessageDM);
    }

    @Override // com.helpshift.conversation.activeconversation.message.MessageDM, com.helpshift.util.HSCloneable
    public SystemMessageDM deepClone() {
        return new SystemMessageDM(this);
    }
}
