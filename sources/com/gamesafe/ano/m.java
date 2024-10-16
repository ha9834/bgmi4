package com.gamesafe.ano;

import android.content.DialogInterface;
import com.gamesafe.ano.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f1101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f1101a = lVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        g.a aVar;
        g.a aVar2;
        aVar = this.f1101a.f;
        if (aVar != null) {
            aVar2 = this.f1101a.f;
            aVar2.a(0);
        }
    }
}
