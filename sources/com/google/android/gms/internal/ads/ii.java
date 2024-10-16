package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ii implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcq f2241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ii(zzbcq zzbcqVar) {
        this.f2241a = zzbcqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2241a.a("surfaceDestroyed", new String[0]);
    }
}
