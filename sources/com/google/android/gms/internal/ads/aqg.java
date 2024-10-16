package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aqg extends aqo<zzzk> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2047a;
    private final /* synthetic */ zzyd b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzyh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqg(zzyh zzyhVar, Context context, zzyd zzydVar, String str) {
        this.d = zzyhVar;
        this.f2047a = context;
        this.b = zzydVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzk a() {
        zzyh.b(this.f2047a, FirebaseAnalytics.Event.SEARCH);
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzk b() throws RemoteException {
        zzxx zzxxVar;
        zzxxVar = this.d.f3782a;
        return zzxxVar.zza(this.f2047a, this.b, this.c, null, 3);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzzk a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.wrap(this.f2047a), this.b, this.c, 15000000);
    }
}
