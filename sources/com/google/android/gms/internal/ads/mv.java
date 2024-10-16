package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class mv implements zzcqp {

    /* renamed from: a, reason: collision with root package name */
    private zzcyo f2357a;
    private zzbqy b;
    private zzcqt c;
    private zzcfp d;
    private final /* synthetic */ zzbkc e;

    private mv(zzbkc zzbkcVar) {
        this.e = zzbkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqp
    public final zzcqo zzaem() {
        if (this.f2357a == null) {
            this.f2357a = new zzcyo();
        }
        zzdto.zza(this.b, (Class<zzbqy>) zzbqy.class);
        zzdto.zza(this.c, (Class<zzcqt>) zzcqt.class);
        if (this.d == null) {
            this.d = new zzcfp();
        }
        return new mw(this.e, this.f2357a, this.b, this.c, this.d);
    }

    @Override // com.google.android.gms.internal.ads.zzcqp
    public final /* synthetic */ zzcqp zza(zzcqt zzcqtVar) {
        this.c = (zzcqt) zzdto.checkNotNull(zzcqtVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcqp
    public final /* synthetic */ zzcqp zze(zzbqy zzbqyVar) {
        this.b = (zzbqy) zzdto.checkNotNull(zzbqyVar);
        return this;
    }
}
