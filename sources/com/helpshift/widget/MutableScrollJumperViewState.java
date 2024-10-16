package com.helpshift.widget;

/* loaded from: classes2.dex */
public class MutableScrollJumperViewState extends ScrollJumperViewState {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableScrollJumperViewState(boolean z, boolean z2) {
        super(z, z2);
    }

    public void setVisible(boolean z) {
        if (this.isVisible != z) {
            this.isVisible = z;
            notifyChange(this);
        }
    }

    public void setShouldShowUnreadMessagesIndicator(boolean z) {
        if (this.shouldShowUnreadMessagesIndicator != z) {
            this.shouldShowUnreadMessagesIndicator = z;
            notifyChange(this);
        }
    }
}
