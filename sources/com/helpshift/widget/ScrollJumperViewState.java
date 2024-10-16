package com.helpshift.widget;

/* loaded from: classes2.dex */
public class ScrollJumperViewState extends BaseViewState {
    protected boolean shouldShowUnreadMessagesIndicator;

    /* JADX INFO: Access modifiers changed from: protected */
    public ScrollJumperViewState(boolean z, boolean z2) {
        this.isVisible = z;
        this.shouldShowUnreadMessagesIndicator = z2;
    }

    public boolean shouldShowUnreadMessagesIndicator() {
        return this.shouldShowUnreadMessagesIndicator;
    }
}
