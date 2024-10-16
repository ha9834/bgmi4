package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class nu implements zzban<zzbpc> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzban f2380a;
    private final /* synthetic */ zzbpk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nu(zzbpk zzbpkVar, zzban zzbanVar) {
        this.b = zzbpkVar;
        this.f2380a = zzbanVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        this.f2380a.zzb(th);
        this.b.a();
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbpc zzbpcVar) {
        this.f2380a.zzk(zzbpcVar);
        this.b.a();
    }
}
