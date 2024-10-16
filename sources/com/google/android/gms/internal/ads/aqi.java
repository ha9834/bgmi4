package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aqi extends aqo<zzzf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2049a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzamp c;
    private final /* synthetic */ zzyh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqi(zzyh zzyhVar, Context context, String str, zzamp zzampVar) {
        this.d = zzyhVar;
        this.f2049a = context;
        this.b = str;
        this.c = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzzf a() {
        zzyh.b(this.f2049a, "native_ad");
        return new zzabl();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzf b() throws RemoteException {
        zzxw zzxwVar;
        zzxwVar = this.d.b;
        return zzxwVar.zza(this.f2049a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzf a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.wrap(this.f2049a), this.b, this.c, 15000000);
    }
}
