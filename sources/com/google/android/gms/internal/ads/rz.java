package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class rz implements com.google.android.gms.ads.internal.overlay.zzu {

    /* renamed from: a, reason: collision with root package name */
    private final zzbse f2480a;

    private rz(zzbse zzbseVar) {
        this.f2480a = zzbseVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.ads.internal.overlay.zzu a(zzbse zzbseVar) {
        return new rz(zzbseVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzu
    public final void zztq() {
        this.f2480a.onAdLeftApplication();
    }
}
