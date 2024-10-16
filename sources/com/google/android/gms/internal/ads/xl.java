package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class xl implements zzban<zzbvx> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbws f2613a;
    private final /* synthetic */ zzcqd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xl(zzcqd zzcqdVar, zzbws zzbwsVar) {
        this.b = zzcqdVar;
        this.f2613a = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        synchronized (this.b) {
            zzcqd.a(this.b, (zzbbh) null);
            this.f2613a.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzcya.zzc(th, "InterstitialAdManagerShim.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbvx zzbvxVar) {
        zzbvx zzbvxVar2 = zzbvxVar;
        synchronized (this.b) {
            zzcqd.a(this.b, (zzbbh) null);
            this.b.i = zzbvxVar2;
            zzbvxVar2.zzafl();
        }
    }
}
