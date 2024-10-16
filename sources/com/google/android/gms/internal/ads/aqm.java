package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class aqm extends aqo<zzasw> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2053a;
    private final /* synthetic */ zzamp b;
    private final /* synthetic */ zzyh c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqm(zzyh zzyhVar, Context context, zzamp zzampVar) {
        this.c = zzyhVar;
        this.f2053a = context;
        this.b = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzasw a() {
        zzyh.b(this.f2053a, "rewarded_video");
        return new zzabx();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzasw b() throws RemoteException {
        zzatf zzatfVar;
        zzatfVar = this.c.e;
        return zzatfVar.zza(this.f2053a, this.b);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzasw a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.wrap(this.f2053a), this.b, 15000000);
    }
}
