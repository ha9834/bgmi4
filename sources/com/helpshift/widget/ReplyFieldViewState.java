package com.helpshift.widget;

/* loaded from: classes2.dex */
public class ReplyFieldViewState extends HSBaseObservable {
    protected boolean isEnabled;
    protected String replyText = "";

    public String getReplyText() {
        return this.replyText;
    }

    @Override // com.helpshift.widget.HSBaseObservable
    protected void notifyInitialState() {
        notifyChange(this);
    }
}
