package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzbwd implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3078a;
    private final zzdtu<Context> b;
    private final zzdtu<zzbai> c;
    private final zzdtu<zzcxm> d;
    private final zzdtu<zzcxv> e;

    private zzbwd(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzcxv> zzdtuVar4) {
        this.f3078a = zzbvzVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
        this.d = zzdtuVar3;
        this.e = zzdtuVar4;
    }

    public static zzbwd zza(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzcxv> zzdtuVar4) {
        return new zzbwd(zzbvzVar, zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final Context context = this.b.get();
        final zzbai zzbaiVar = this.c.get();
        final zzcxm zzcxmVar = this.d.get();
        final zzcxv zzcxvVar = this.e.get();
        return (zzbuz) zzdto.zza(new zzbuz(new zzbsr(context, zzbaiVar, zzcxmVar, zzcxvVar) { // from class: com.google.android.gms.internal.ads.pt

            /* renamed from: a, reason: collision with root package name */
            private final Context f2425a;
            private final zzbai b;
            private final zzcxm c;
            private final zzcxv d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2425a = context;
                this.b = zzbaiVar;
                this.c = zzcxmVar;
                this.d = zzcxvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbsr
            public final void onAdLoaded() {
                zzk.zzlq().zzb(this.f2425a, this.b.zzbsx, this.c.zzgkj.toString(), this.d.zzglb);
            }
        }, zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
