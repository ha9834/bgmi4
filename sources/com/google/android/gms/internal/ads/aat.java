package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [O] */
/* loaded from: classes2.dex */
final class aat<O> implements zzban<O> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcze f1768a;
    private final /* synthetic */ zzczl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aat(zzczl zzczlVar, zzcze zzczeVar) {
        this.b = zzczlVar;
        this.f1768a = zzczeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzk(O o) {
        this.b.f3519a.d.zzc(this.f1768a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        this.b.f3519a.d.zza(this.f1768a, th);
    }
}
