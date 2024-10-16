package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aql extends aqo<zzaer> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f2052a;
    private final /* synthetic */ HashMap b;
    private final /* synthetic */ HashMap c;
    private final /* synthetic */ zzyh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aql(zzyh zzyhVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.d = zzyhVar;
        this.f2052a = view;
        this.b = hashMap;
        this.c = hashMap2;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzaer a() {
        zzyh.b(this.f2052a.getContext(), "native_ad_view_holder_delegate");
        return new zzabu();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaer b() throws RemoteException {
        zzagl zzaglVar;
        zzaglVar = this.d.h;
        return zzaglVar.zzb(this.f2052a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaer a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.wrap(this.f2052a), ObjectWrapper.wrap(this.b), ObjectWrapper.wrap(this.c));
    }
}
