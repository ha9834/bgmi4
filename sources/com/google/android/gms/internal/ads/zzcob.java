package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcob implements zzdti<zzcnw> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3342a;
    private final zzdtu<Executor> b;
    private final zzdtu<zzcdf> c;

    public zzcob(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzcdf> zzdtuVar3) {
        this.f3342a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcnw(this.f3342a.get(), this.b.get(), this.c.get());
    }
}
