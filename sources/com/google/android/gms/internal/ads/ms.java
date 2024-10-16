package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ms implements zzcdg {

    /* renamed from: a, reason: collision with root package name */
    private zzbtv f2352a;
    private zzcyg b;
    private zzcyo c;
    private zzbqy d;
    private zzcfp e;
    private zzbpx f;
    private zzbqt g;
    private final /* synthetic */ zzbkc h;

    private ms(zzbkc zzbkcVar) {
        this.h = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdg
    public final zzcdf zzaeh() {
        zzdto.zza(this.f2352a, (Class<zzbtv>) zzbtv.class);
        if (this.b == null) {
            this.b = new zzcyg();
        }
        if (this.c == null) {
            this.c = new zzcyo();
        }
        zzdto.zza(this.d, (Class<zzbqy>) zzbqy.class);
        if (this.e == null) {
            this.e = new zzcfp();
        }
        if (this.f == null) {
            this.f = new zzbpx();
        }
        if (this.g == null) {
            this.g = new zzbqt();
        }
        return new mt(this.h, this.f2352a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    @Override // com.google.android.gms.internal.ads.zzcdg
    public final /* synthetic */ zzcdg zzd(zzbqy zzbqyVar) {
        this.d = (zzbqy) zzdto.checkNotNull(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcdg
    public final /* synthetic */ zzcdg zzd(zzbtv zzbtvVar) {
        this.f2352a = (zzbtv) zzdto.checkNotNull(zzbtvVar);
        return this;
    }
}
