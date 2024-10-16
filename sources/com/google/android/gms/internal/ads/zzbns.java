package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzbns implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2957a;
    private final zzdtu<Context> b;
    private final zzdtu<zzbai> c;
    private final zzdtu<zzcxm> d;
    private final zzdtu<zzcxv> e;

    public zzbns(zzbnk zzbnkVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzcxv> zzdtuVar4) {
        this.f2957a = zzbnkVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
        this.d = zzdtuVar3;
        this.e = zzdtuVar4;
    }

    public static zzbuz<zzbsr> zza(zzbnk zzbnkVar, final Context context, final zzbai zzbaiVar, final zzcxm zzcxmVar, final zzcxv zzcxvVar) {
        return (zzbuz) zzdto.zza(new zzbuz(new zzbsr(context, zzbaiVar, zzcxmVar, zzcxvVar) { // from class: com.google.android.gms.internal.ads.nj

            /* renamed from: a, reason: collision with root package name */
            private final Context f2369a;
            private final zzbai b;
            private final zzcxm c;
            private final zzcxv d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2369a = context;
                this.b = zzbaiVar;
                this.c = zzcxmVar;
                this.d = zzcxvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbsr
            public final void onAdLoaded() {
                zzk.zzlq().zzb(this.f2369a, this.b.zzbsx, this.c.zzgkj.toString(), this.d.zzglb);
            }
        }, zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2957a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
