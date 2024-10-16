package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aqn extends aqo<zzatt> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2054a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzamp c;
    private final /* synthetic */ zzyh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqn(zzyh zzyhVar, Context context, String str, zzamp zzampVar) {
        this.d = zzyhVar;
        this.f2054a = context;
        this.b = str;
        this.c = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzatt a() {
        zzyh.b(this.f2054a, "rewarded");
        return new zzabv();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzatt b() throws RemoteException {
        return zzauj.zzd(this.f2054a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzatt a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzb(ObjectWrapper.wrap(this.f2054a), this.b, this.c, 15000000);
    }
}
