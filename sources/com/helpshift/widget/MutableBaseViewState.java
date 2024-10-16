package com.helpshift.widget;

/* loaded from: classes2.dex */
public class MutableBaseViewState extends BaseViewState {
    public void setEnabled(boolean z) {
        if (z != this.isEnabled) {
            this.isEnabled = z;
            notifyChange(this);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.isVisible) {
            this.isVisible = z;
            notifyChange(this);
        }
    }
}
