package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbwn implements zzdti<zzbuz<zzbto>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3086a;
    private final zzdtu<Executor> b;

    private zzbwn(zzbvz zzbvzVar, zzdtu<Executor> zzdtuVar) {
        this.f3086a = zzbvzVar;
        this.b = zzdtuVar;
    }

    public static zzbwn zzd(zzbvz zzbvzVar, zzdtu<Executor> zzdtuVar) {
        return new zzbwn(zzbvzVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzbvz zzbvzVar = this.f3086a;
        return (zzbuz) zzdto.zza(new zzbuz(new zzbto(zzbvzVar) { // from class: com.google.android.gms.internal.ads.pu

            /* renamed from: a, reason: collision with root package name */
            private final zzbvz f2426a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2426a = zzbvzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbto
            public final void zzafq() {
                this.f2426a.a();
            }
        }, this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
