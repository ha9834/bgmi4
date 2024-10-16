package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class nt implements zzban<zzbph> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzban f2379a;
    private final /* synthetic */ zzbpk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nt(zzbpk zzbpkVar, zzban zzbanVar) {
        this.b = zzbpkVar;
        this.f2379a = zzbanVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        this.f2379a.zzb(th);
        this.b.a();
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbph zzbphVar) {
        this.b.a(zzbphVar.zzfiv, this.f2379a);
    }
}
