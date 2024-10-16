package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b extends zzz.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Bundle e;
    private final /* synthetic */ zzz f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(zzz zzzVar, String str, String str2, Bundle bundle) {
        super(zzzVar);
        this.f = zzzVar;
        this.c = str;
        this.d = str2;
        this.e = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f.r;
        zzkVar.clearConditionalUserProperty(this.c, this.d, this.e);
    }
}
