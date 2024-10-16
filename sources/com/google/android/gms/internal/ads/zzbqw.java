package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbqw implements zzdti<zzbam<zzcxm, zzayb>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3018a;
    private final zzdtu<zzbai> b;
    private final zzdtu<zzcxv> c;

    public zzbqw(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.f3018a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final Context context = this.f3018a.get();
        final zzbai zzbaiVar = this.b.get();
        final zzcxv zzcxvVar = this.c.get();
        return (zzbam) zzdto.zza(new zzbam(context, zzbaiVar, zzcxvVar) { // from class: com.google.android.gms.internal.ads.nw

            /* renamed from: a, reason: collision with root package name */
            private final Context f2382a;
            private final zzbai b;
            private final zzcxv c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2382a = context;
                this.b = zzbaiVar;
                this.c = zzcxvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                Context context2 = this.f2382a;
                zzbai zzbaiVar2 = this.b;
                zzcxv zzcxvVar2 = this.c;
                zzcxm zzcxmVar = (zzcxm) obj;
                zzayb zzaybVar = new zzayb(context2);
                zzaybVar.zzee(zzcxmVar.zzdno);
                zzaybVar.zzef(zzcxmVar.zzgkj.toString());
                zzaybVar.zzp(zzbaiVar2.zzbsx);
                zzaybVar.setAdUnitId(zzcxvVar2.zzglb);
                return zzaybVar;
            }
        }, "Cannot return null from a non-@Nullable @Provides method");
    }
}
