package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class xq implements zzban<zzcdb> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcdf f2618a;
    private final /* synthetic */ zzcqj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xq(zzcqj zzcqjVar, zzcdf zzcdfVar) {
        this.b = zzcqjVar;
        this.f2618a = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        synchronized (this.b) {
            zzcqj.a(this.b, (zzbbh) null);
            this.f2618a.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzcya.zzc(th, "NonagonRewardedVideoAdImpl.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzcdb zzcdbVar) {
        zzcdb zzcdbVar2 = zzcdbVar;
        synchronized (this.b) {
            zzcqj.a(this.b, (zzbbh) null);
            this.b.b = zzcdbVar2;
            zzcdbVar2.zzafl();
        }
    }
}
