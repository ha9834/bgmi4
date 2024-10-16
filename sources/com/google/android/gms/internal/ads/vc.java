package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class vc implements zzban<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzckv f2558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vc(zzckv zzckvVar) {
        this.f2558a = zzckvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        zzbrm zzbrmVar;
        zzbrmVar = this.f2558a.d;
        zzbrmVar.onAdFailedToLoad(zzcgm.zze(th));
        zzcya.zzc(th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbnf zzbnfVar) {
        zzbnfVar.zzafl();
    }
}
