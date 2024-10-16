package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzcjk implements zzczz {

    /* renamed from: a, reason: collision with root package name */
    private final zzcji f3285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjk(zzcji zzcjiVar) {
        this.f3285a = zzcjiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzb(zzczs zzczsVar, String str) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzczs.RENDERER == zzczsVar) {
            this.f3285a.zzfh(zzk.zzln().elapsedRealtime());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zza(zzczs zzczsVar, String str, Throwable th) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzczs.RENDERER == zzczsVar && this.f3285a.zzakm() != 0) {
            this.f3285a.zzev(zzk.zzln().elapsedRealtime() - this.f3285a.zzakm());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void zzc(zzczs zzczsVar, String str) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzczs.RENDERER == zzczsVar && this.f3285a.zzakm() != 0) {
            this.f3285a.zzev(zzk.zzln().elapsedRealtime() - this.f3285a.zzakm());
        }
    }
}
