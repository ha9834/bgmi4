package com.gamesafe.ano;

import android.content.DialogInterface;
import android.widget.Button;

/* loaded from: classes.dex */
class n implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f1102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f1102a = lVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Button button = this.f1102a.f1100a.getButton(-3);
        if (button != null) {
            button.setTextSize(2, 18.0f);
        }
    }
}
