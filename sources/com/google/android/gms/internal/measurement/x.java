package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x extends zzz.b {
    private final /* synthetic */ zzl c;
    private final /* synthetic */ int d;
    private final /* synthetic */ zzz e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(zzz zzzVar, zzl zzlVar, int i) {
        super(zzzVar);
        this.e = zzzVar;
        this.c = zzlVar;
        this.d = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.e.r;
        zzkVar.getTestFlag(this.c, this.d);
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    protected final void b() {
        this.c.zzb((Bundle) null);
    }
}
