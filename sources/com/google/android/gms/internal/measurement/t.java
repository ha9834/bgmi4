package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t extends zzz.b {
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ zzl d;
    private final /* synthetic */ zzz e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(zzz zzzVar, Bundle bundle, zzl zzlVar) {
        super(zzzVar);
        this.e = zzzVar;
        this.c = bundle;
        this.d = zzlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.e.r;
        zzkVar.performAction(this.c, this.d, this.f4645a);
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    protected final void b() {
        this.d.zzb((Bundle) null);
    }
}
