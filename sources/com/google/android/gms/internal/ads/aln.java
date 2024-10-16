package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class aln implements zzmn {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzms f1956a;

    private aln(zzms zzmsVar) {
        this.f1956a = zzmsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmn
    public final void zzag(int i) {
        zzms.a(this.f1956a).zzah(i);
        zzms.a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzmn
    public final void zzgt() {
        zzms.g();
        zzms.a(this.f1956a, true);
    }

    @Override // com.google.android.gms.internal.ads.zzmn
    public final void zze(int i, long j, long j2) {
        zzms.a(this.f1956a).zzd(i, j, j2);
        zzms.a(i, j, j2);
    }
}
