package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bw implements zzbbv<zzalf> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzakw f2086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(zzakw zzakwVar) {
        this.f2086a = zzakwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbv
    public final /* synthetic */ void zzh(zzalf zzalfVar) {
        zzala zzalaVar;
        zzawz.zzds("Releasing engine reference.");
        zzalaVar = this.f2086a.b;
        zzalaVar.a();
    }
}
