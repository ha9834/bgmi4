package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes2.dex */
public final class zzbxh implements zzdti<zzbxg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzavf> f3102a;
    private final zzdtu<Context> b;
    private final zzdtu<zzavg> c;
    private final zzdtu<View> d;
    private final zzdtu<Integer> e;

    private zzbxh(zzdtu<zzavf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzavg> zzdtuVar3, zzdtu<View> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        this.f3102a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzbxh zzd(zzdtu<zzavf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzavg> zzdtuVar3, zzdtu<View> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        return new zzbxh(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxg(this.f3102a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get().intValue());
    }
}
