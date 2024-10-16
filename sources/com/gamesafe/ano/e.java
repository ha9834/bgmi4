package com.gamesafe.ano;

import android.content.DialogInterface;
import com.gamesafe.ano.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1095a = dVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        g.a aVar;
        g.a aVar2;
        aVar = this.f1095a.i;
        if (aVar != null) {
            aVar2 = this.f1095a.i;
            aVar2.a(0);
        }
    }
}
