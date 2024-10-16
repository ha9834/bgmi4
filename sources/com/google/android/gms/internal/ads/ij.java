package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ij implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f2242a;
    private final /* synthetic */ zzbcq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ij(zzbcq zzbcqVar, boolean z) {
        this.b = zzbcqVar;
        this.f2242a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a("windowVisibilityChanged", "isVisible", String.valueOf(this.f2242a));
    }
}
