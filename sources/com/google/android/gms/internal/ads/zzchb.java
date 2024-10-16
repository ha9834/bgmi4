package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzchb implements zzdti<zzbbh<String>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzdh> f3253a;
    private final zzdtu<Context> b;
    private final zzdtu<zzbbl> c;

    private zzchb(zzdtu<zzdh> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzbbl> zzdtuVar3) {
        this.f3253a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzchb zzm(zzdtu<zzdh> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzbbl> zzdtuVar3) {
        return new zzchb(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzdh zzdhVar = this.f3253a.get();
        final Context context = this.b.get();
        return (zzbbh) zzdto.zza(this.c.get().submit(new Callable(zzdhVar, context) { // from class: com.google.android.gms.internal.ads.th

            /* renamed from: a, reason: collision with root package name */
            private final zzdh f2515a;
            private final Context b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2515a = zzdhVar;
                this.b = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdh zzdhVar2 = this.f2515a;
                return zzdhVar2.zzcg().zza(this.b);
            }
        }), "Cannot return null from a non-@Nullable @Provides method");
    }
}
