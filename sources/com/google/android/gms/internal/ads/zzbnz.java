package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbnz implements zzdti<zzbuz<zzbto>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2964a;
    private final zzdtu<zzbtb> b;

    public zzbnz(zzbnk zzbnkVar, zzdtu<zzbtb> zzdtuVar) {
        this.f2964a = zzbnkVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzbtb zzbtbVar = this.b.get();
        return (zzbuz) zzdto.zza(new zzbuz(new zzbto(zzbtbVar) { // from class: com.google.android.gms.internal.ads.nk

            /* renamed from: a, reason: collision with root package name */
            private final zzbtb f2370a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2370a = zzbtbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbto
            public final void zzafq() {
                this.f2370a.zzagi();
            }
        }, zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
