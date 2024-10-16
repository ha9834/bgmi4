package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y extends zzz.b {
    private final /* synthetic */ Long c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ Bundle f;
    private final /* synthetic */ boolean g;
    private final /* synthetic */ boolean h;
    private final /* synthetic */ zzz i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(zzz zzzVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzzVar);
        this.i = zzzVar;
        this.c = l;
        this.d = str;
        this.e = str2;
        this.f = bundle;
        this.g = z;
        this.h = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        Long l = this.c;
        long longValue = l == null ? this.f4645a : l.longValue();
        zzkVar = this.i.r;
        zzkVar.logEvent(this.d, this.e, this.f, this.g, this.h, longValue);
    }
}
