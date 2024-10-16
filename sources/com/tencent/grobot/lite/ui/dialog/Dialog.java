package com.tencent.grobot.lite.ui.dialog;

import android.content.Context;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class Dialog {
    protected DialogContainer container;
    protected Context context;
    View v;

    /* JADX INFO: Access modifiers changed from: protected */
    public int heigth() {
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAttach() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetach() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View view();

    /* JADX INFO: Access modifiers changed from: protected */
    public int width() {
        return -2;
    }

    public Dialog(DialogContainer dialogContainer) {
        this.context = dialogContainer.getContext();
        this.container = dialogContainer;
    }

    public final void attach(boolean z) {
        this.container.addDialog(this, z);
    }

    public final void dismiss() {
        this.container.removeDialog(this);
    }
}
