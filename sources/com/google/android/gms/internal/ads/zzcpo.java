package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzcpo extends zzzg {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3365a;
    private final zzbjm b;

    @VisibleForTesting
    private final zzcxx c = new zzcxx();

    @VisibleForTesting
    private final zzbze d = new zzbze();
    private zzyz e;

    public zzcpo(zzbjm zzbjmVar, Context context, String str) {
        this.b = zzbjmVar;
        this.c.zzft(str);
        this.f3365a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final zzzc zzpk() {
        zzbzc zzaip = this.d.zzaip();
        this.c.zzb(zzaip.zzain());
        this.c.zzc(zzaip.zzaio());
        zzcxx zzcxxVar = this.c;
        if (zzcxxVar.zzpn() == null) {
            zzcxxVar.zzd(zzyd.zzg(this.f3365a));
        }
        return new zzcpp(this.f3365a, this.b, this.c, zzaip, this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzyz zzyzVar) {
        this.e = zzyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafi zzafiVar) {
        this.d.zzb(zzafiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafx zzafxVar) {
        this.d.zzb(zzafxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafl zzaflVar) {
        this.d.zzb(zzaflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(String str, zzafr zzafrVar, zzafo zzafoVar) {
        this.d.zzb(str, zzafrVar, zzafoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzady zzadyVar) {
        this.c.zzb(zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzaiy zzaiyVar) {
        this.c.zzb(zzaiyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzaje zzajeVar) {
        this.d.zzb(zzajeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzzy zzzyVar) {
        this.c.zzd(zzzyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafu zzafuVar, zzyd zzydVar) {
        this.d.zza(zzafuVar);
        this.c.zzd(zzydVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.c.zzb(publisherAdViewOptions);
    }
}
