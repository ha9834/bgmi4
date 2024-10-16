package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcpj implements zzdti<zzcpf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzclc> f3360a;
    private final zzdtu<Executor> b;
    private final zzdtu<Context> c;

    public zzcpj(zzdtu<zzclc> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.f3360a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcpf(this.f3360a.get(), this.b.get(), this.c.get());
    }
}
