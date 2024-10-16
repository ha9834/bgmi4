package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes2.dex */
public final class zzcok implements zzcjv<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3348a;
    private final zzboc b;
    private final zzado c;
    private final zzbbl d;
    private final zzczt e;

    public zzcok(Context context, zzboc zzbocVar, zzczt zzcztVar, zzbbl zzbblVar, zzado zzadoVar) {
        this.f3348a = context;
        this.b = zzbocVar;
        this.e = zzcztVar;
        this.d = zzbblVar;
        this.c = zzadoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (this.c == null || zzcxmVar.zzgke == null || zzcxmVar.zzgke.zzdkp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbnf> zzb(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzbng zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new ww(this, new View(this.f3348a), null, wu.f2597a, zzcxmVar.zzgkg.get(0)));
        final zzadj zzadjVar = new zzadj(zza.zzaea(), zzcxmVar.zzgke.zzdkn, zzcxmVar.zzgke.zzdkp);
        return this.e.zzv(zzczs.CUSTOM_RENDER_SYN).zza(new zzczd(this, zzadjVar) { // from class: com.google.android.gms.internal.ads.wv

            /* renamed from: a, reason: collision with root package name */
            private final zzcok f2598a;
            private final zzadj b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2598a = this;
                this.b = zzadjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczd
            public final void run() {
                this.f2598a.a(this.b);
            }
        }, this.d).zzx(zzczs.CUSTOM_RENDER_ACK).zzb(zzbar.zzm(zza.zzadx())).zzane();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzadj zzadjVar) throws Exception {
        this.c.zza(zzadjVar);
    }
}
