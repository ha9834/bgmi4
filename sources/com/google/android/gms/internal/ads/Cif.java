package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.if, reason: invalid class name */
/* loaded from: classes2.dex */
final /* synthetic */ class Cif implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzbco f2238a;

    private Cif(zzbco zzbcoVar) {
        this.f2238a = zzbcoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbco zzbcoVar) {
        return new Cif(zzbcoVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2238a.stop();
    }
}
