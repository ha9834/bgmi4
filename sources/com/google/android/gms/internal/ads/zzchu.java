package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzchu implements zzdti<zzchq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3265a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzcxv> c;
    private final zzdtu<Executor> d;

    private zzchu(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4) {
        this.f3265a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static zzchu zzd(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4) {
        return new zzchu(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzchq(this.f3265a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
