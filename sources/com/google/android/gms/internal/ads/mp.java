package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class mp implements zzbwt {

    /* renamed from: a, reason: collision with root package name */
    private zzbtv f2348a;
    private zzcyg b;
    private zzcyo c;
    private zzbqy d;
    private zzcfp e;
    private zzbpx f;
    private zzbqt g;
    private zzcow h;
    private final /* synthetic */ zzbkc i;

    private mp(zzbkc zzbkcVar) {
        this.i = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final zzbws zzaed() {
        zzdto.zza(this.f2348a, (Class<zzbtv>) zzbtv.class);
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
        zzdto.zza(this.h, (Class<zzcow>) zzcow.class);
        return new mq(this.i, this.f2348a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final /* synthetic */ zzbwt zzb(zzcow zzcowVar) {
        this.h = (zzcow) zzdto.checkNotNull(zzcowVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final /* synthetic */ zzbwt zzc(zzbqy zzbqyVar) {
        this.d = (zzbqy) zzdto.checkNotNull(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final /* synthetic */ zzbwt zzc(zzbtv zzbtvVar) {
        this.f2348a = (zzbtv) zzdto.checkNotNull(zzbtvVar);
        return this;
    }
}
