package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends zzz.b {
    private final /* synthetic */ zzl c;
    private final /* synthetic */ zzz d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(zzz zzzVar, zzl zzlVar) {
        super(zzzVar);
        this.d = zzzVar;
        this.c = zzlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.d.r;
        zzkVar.getCurrentScreenClass(this.c);
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    protected final void b() {
        this.c.zzb((Bundle) null);
    }
}
