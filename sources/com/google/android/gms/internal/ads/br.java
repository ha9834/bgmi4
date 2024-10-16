package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class br implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzajw f2082a;

    private br(zzajw zzajwVar) {
        this.f2082a = zzajwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzajw zzajwVar) {
        return new br(zzajwVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2082a.destroy();
    }
}
