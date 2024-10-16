package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aqf extends aqo<zzaqg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2046a;
    private final /* synthetic */ zzyh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqf(zzyh zzyhVar, Activity activity) {
        this.b = zzyhVar;
        this.f2046a = activity;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzaqg a() {
        zzyh.b(this.f2046a, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaqg b() throws RemoteException {
        zzaqf zzaqfVar;
        zzaqfVar = this.b.g;
        return zzaqfVar.zzc(this.f2046a);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaqg a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzf(ObjectWrapper.wrap(this.f2046a));
    }
}
