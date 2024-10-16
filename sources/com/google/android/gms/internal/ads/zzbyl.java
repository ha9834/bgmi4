package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbyl implements zzdti<zzbmy> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzty> f3125a;
    private final zzdtu<Executor> b;
    private final zzdtu<Context> c;
    private final zzdtu<Clock> d;

    public zzbyl(zzdtu<zzty> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<Context> zzdtuVar3, zzdtu<Clock> zzdtuVar4) {
        this.f3125a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzty zztyVar = this.f3125a.get();
        Executor executor = this.b.get();
        Context context = this.c.get();
        return (zzbmy) zzdto.zza(new zzbmy(executor, new zzbml(context, zztyVar), this.d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
