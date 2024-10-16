package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class ve implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzced f2560a;

    private ve(zzced zzcedVar) {
        this.f2560a = zzcedVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzced zzcedVar) {
        return new ve(zzcedVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2560a.zzajo();
    }
}
