package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbkn {

    /* renamed from: a, reason: collision with root package name */
    private zzcye f2899a;
    private zzbjn b;
    private zzbld c;
    private zzbkw d;
    private zzdac e;

    private zzbkn() {
    }

    public final zzbjm zzaec() {
        if (this.f2899a == null) {
            this.f2899a = new zzcye();
        }
        zzdto.zza(this.b, (Class<zzbjn>) zzbjn.class);
        if (this.c == null) {
            this.c = new zzbld();
        }
        zzdto.zza(this.d, (Class<zzbkw>) zzbkw.class);
        if (this.e == null) {
            this.e = new zzdac();
        }
        return new zzbkc(this.f2899a, this.b, this.c, this.d, this.e);
    }

    public final zzbkn zzc(zzbjn zzbjnVar) {
        this.b = (zzbjn) zzdto.checkNotNull(zzbjnVar);
        return this;
    }

    public final zzbkn zza(zzbkw zzbkwVar) {
        this.d = (zzbkw) zzdto.checkNotNull(zzbkwVar);
        return this;
    }
}
