package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzbxv implements zzdti<zzcyb<zzccj>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzccj> f3112a;
    private final zzdtu<zzbbl> b;

    public zzbxv(zzdtu<zzccj> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.f3112a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzdtu<zzccj> zzdtuVar = this.f3112a;
        return (zzcyb) zzdto.zza(new zzcyb(new Callable(zzdtuVar) { // from class: com.google.android.gms.internal.ads.px

            /* renamed from: a, reason: collision with root package name */
            private final zzdtu f2428a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2428a = zzdtuVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzccj zzccjVar = (zzccj) this.f2428a.get();
                zzccjVar.zzajj();
                return zzccjVar;
            }
        }, this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
