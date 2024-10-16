package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r extends zzz.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ zzl f;
    private final /* synthetic */ zzz g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(zzz zzzVar, String str, String str2, boolean z, zzl zzlVar) {
        super(zzzVar);
        this.g = zzzVar;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = zzlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.g.r;
        zzkVar.getUserProperties(this.c, this.d, this.e, this.f);
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    protected final void b() {
        this.f.zzb((Bundle) null);
    }
}
