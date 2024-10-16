package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends zzz.b {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzgk c;
    private final /* synthetic */ zzz d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zzz zzzVar, com.google.android.gms.measurement.internal.zzgk zzgkVar) {
        super(zzzVar);
        this.d = zzzVar;
        this.c = zzgkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.d.r;
        zzkVar.setEventInterceptor(new zzz.a(this.c));
    }
}
