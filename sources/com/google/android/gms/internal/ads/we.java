package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class we implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzced f2581a;

    private we(zzced zzcedVar) {
        this.f2581a = zzcedVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzced zzcedVar) {
        return new we(zzcedVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2581a.zzajo();
    }
}
