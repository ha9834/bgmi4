package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class mg implements zzbxp {

    /* renamed from: a, reason: collision with root package name */
    private zzcyo f2337a;
    private zzbqy b;
    private zzcfp c;
    private zzbpx d;
    private zzbqt e;
    private zzbtv f;
    private zzbxk g;
    private zzcyg h;
    private final /* synthetic */ zzbkc i;

    private mg(zzbkc zzbkcVar) {
        this.i = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final zzbxo zzacy() {
        if (this.f2337a == null) {
            this.f2337a = new zzcyo();
        }
        zzdto.zza(this.b, (Class<zzbqy>) zzbqy.class);
        if (this.c == null) {
            this.c = new zzcfp();
        }
        if (this.d == null) {
            this.d = new zzbpx();
        }
        if (this.e == null) {
            this.e = new zzbqt();
        }
        zzdto.zza(this.f, (Class<zzbtv>) zzbtv.class);
        zzdto.zza(this.g, (Class<zzbxk>) zzbxk.class);
        if (this.h == null) {
            this.h = new zzcyg();
        }
        return new mh(this.i, this.f2337a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final /* synthetic */ zzbxp zza(zzbxk zzbxkVar) {
        this.g = (zzbxk) zzdto.checkNotNull(zzbxkVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final /* synthetic */ zzbxp zza(zzbqy zzbqyVar) {
        this.b = (zzbqy) zzdto.checkNotNull(zzbqyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final /* synthetic */ zzbxp zza(zzbtv zzbtvVar) {
        this.f = (zzbtv) zzdto.checkNotNull(zzbtvVar);
        return this;
    }
}
