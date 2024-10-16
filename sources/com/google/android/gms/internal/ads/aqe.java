package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aqe extends aqo<zzzk> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2045a;
    private final /* synthetic */ zzyd b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzamp d;
    private final /* synthetic */ zzyh e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqe(zzyh zzyhVar, Context context, zzyd zzydVar, String str, zzamp zzampVar) {
        this.e = zzyhVar;
        this.f2045a = context;
        this.b = zzydVar;
        this.c = str;
        this.d = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzk a() {
        zzyh.b(this.f2045a, "banner");
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzk b() throws RemoteException {
        zzxx zzxxVar;
        zzxxVar = this.e.f3782a;
        return zzxxVar.zza(this.f2045a, this.b, this.c, this.d, 1);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzk a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.wrap(this.f2045a), this.b, this.c, this.d, 15000000);
    }
}
