package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends zzz.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ zzl e;
    private final /* synthetic */ zzz f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(zzz zzzVar, String str, String str2, zzl zzlVar) {
        super(zzzVar);
        this.f = zzzVar;
        this.c = str;
        this.d = str2;
        this.e = zzlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f.r;
        zzkVar.getConditionalUserProperties(this.c, this.d, this.e);
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    protected final void b() {
        this.e.zzb((Bundle) null);
    }
}
