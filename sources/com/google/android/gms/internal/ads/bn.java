package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class bn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzajw f2078a;

    private bn(zzajw zzajwVar) {
        this.f2078a = zzajwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzajw zzajwVar) {
        return new bn(zzajwVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2078a.destroy();
    }
}
