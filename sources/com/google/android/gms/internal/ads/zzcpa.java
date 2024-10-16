package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes2.dex */
public final class zzcpa implements zzcou<zzbvx> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3357a;
    private final zzbws b;

    public zzcpa(Context context, zzbws zzbwsVar) {
        this.f3357a = context;
        this.b = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcou
    public final /* synthetic */ zzbvx zza(zzcxu zzcxuVar, zzcxm zzcxmVar, View view, zzcoz zzcozVar) {
        zzbvy zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new xb(this, xa.f2603a));
        zzcozVar.zza(new xc(this, zza));
        return zza.zzaee();
    }
}
