package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class aqj extends aqo<zzaab> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2050a;
    private final /* synthetic */ zzyh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqj(zzyh zzyhVar, Context context) {
        this.b = zzyhVar;
        this.f2050a = context;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzaab a() {
        zzyh.b(this.f2050a, "mobile_ads_settings");
        return new zzabr();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaab b() throws RemoteException {
        zzabk zzabkVar;
        zzabkVar = this.b.c;
        return zzabkVar.zzi(this.f2050a);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaab a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.wrap(this.f2050a), 15000000);
    }
}
