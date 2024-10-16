package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ml implements zzbod {

    /* renamed from: a, reason: collision with root package name */
    private zzbtv f2343a;
    private zzcyg b;
    private zzcyo c;
    private zzbqy d;
    private zzcfp e;
    private zzbnc f;
    private zzbpx g;
    private zzbqt h;
    private zzbox i;
    private zzcow j;
    private zzbxk k;
    private final /* synthetic */ zzbkc l;

    private ml(zzbkc zzbkcVar) {
        this.l = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final zzboc zzads() {
        zzdto.zza(this.f2343a, (Class<zzbtv>) zzbtv.class);
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
        zzdto.zza(this.f, (Class<zzbnc>) zzbnc.class);
        if (this.g == null) {
            this.g = new zzbpx();
        }
        if (this.h == null) {
            this.h = new zzbqt();
        }
        zzdto.zza(this.i, (Class<zzbox>) zzbox.class);
        zzdto.zza(this.j, (Class<zzcow>) zzcow.class);
        zzdto.zza(this.k, (Class<zzbxk>) zzbxk.class);
        return new mm(this.l, this.f2343a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod zzb(zzbxk zzbxkVar) {
        this.k = (zzbxk) zzdto.checkNotNull(zzbxkVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod zza(zzbnc zzbncVar) {
        this.f = (zzbnc) zzdto.checkNotNull(zzbncVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod zza(zzbox zzboxVar) {
        this.i = (zzbox) zzdto.checkNotNull(zzboxVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod zza(zzcow zzcowVar) {
        this.j = (zzcow) zzdto.checkNotNull(zzcowVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod zzb(zzbqy zzbqyVar) {
        this.d = (zzbqy) zzdto.checkNotNull(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final /* synthetic */ zzbod zzb(zzbtv zzbtvVar) {
        this.f2343a = (zzbtv) zzdto.checkNotNull(zzbtvVar);
        return this;
    }
}
