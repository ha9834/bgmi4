package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class xm implements zzban<zzcdb> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcdf f2614a;
    private final /* synthetic */ zzcqf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xm(zzcqf zzcqfVar, zzcdf zzcdfVar) {
        this.b = zzcqfVar;
        this.f2614a = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        synchronized (this.b) {
            zzcqf.a(this.b, (zzbbh) null);
            this.f2614a.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzcya.zzc(th, "NonagonRewardedAdImpl.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzcdb zzcdbVar) {
        zzcdb zzcdbVar2 = zzcdbVar;
        synchronized (this.b) {
            zzcqf.a(this.b, (zzbbh) null);
            this.b.b = zzcdbVar2;
            zzcdbVar2.zzafl();
        }
    }
}
