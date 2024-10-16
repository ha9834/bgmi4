package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class xi implements zzban<zzbpc> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbxo f2610a;
    private final /* synthetic */ zzcpp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xi(zzcpp zzcppVar, zzbxo zzbxoVar) {
        this.b = zzcppVar;
        this.f2610a = zzbxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        this.f2610a.zzadb().onAdFailedToLoad(zzcgm.zze(th));
        zzcya.zzc(th, "AdLoaderShim.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbpc zzbpcVar) {
        zzbpc zzbpcVar2 = zzbpcVar;
        synchronized (this.b) {
            this.b.h = zzbpcVar2.getMediationAdapterClassName();
            this.b.i = zzbpcVar2.zzpj();
            zzbpcVar2.zzafl();
        }
    }
}
