package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class az extends zzbiz {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzajj f2063a;

    private az(zzajj zzajjVar) {
        this.f2063a = zzajjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final void zza(zzbja zzbjaVar) {
        if (zzajj.a(this.f2063a) != null) {
            zzajj.a(this.f2063a).zzrv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final void zzb(zzbja zzbjaVar) {
        this.f2063a.zzg(zzbjaVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final boolean zzc(zzbja zzbjaVar) {
        return this.f2063a.zzg(zzbjaVar.uri);
    }
}
