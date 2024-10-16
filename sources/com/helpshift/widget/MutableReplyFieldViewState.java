package com.helpshift.widget;

/* loaded from: classes2.dex */
public class MutableReplyFieldViewState extends ReplyFieldViewState {
    public void clearReplyText() {
        this.replyText = "";
        notifyChange(this);
    }

    public void setReplyText(String str) {
        if (str == null || str.equals(this.replyText)) {
            return;
        }
        this.replyText = str;
        notifyChange(this);
    }
}
