package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w extends zzz.b {
    private final /* synthetic */ boolean c;
    private final /* synthetic */ zzz d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(zzz zzzVar, boolean z) {
        super(zzzVar);
        this.d = zzzVar;
        this.c = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.d.r;
        zzkVar.setDataCollectionEnabled(this.c);
    }
}
