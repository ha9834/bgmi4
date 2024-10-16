package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ih implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcq f2240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ih(zzbcq zzbcqVar) {
        this.f2240a = zzbcqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2240a.a("surfaceCreated", new String[0]);
    }
}
