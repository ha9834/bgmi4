package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e extends zzz.b {
    private final /* synthetic */ zzz c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zzz zzzVar) {
        super(zzzVar);
        this.c = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.c.r;
        zzkVar.resetAnalyticsData(this.f4645a);
    }
}
