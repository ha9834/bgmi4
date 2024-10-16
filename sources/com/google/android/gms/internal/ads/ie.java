package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ie implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcd f2237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ie(zzbcd zzbcdVar) {
        this.f2237a = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f2237a.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f2237a.r;
            zzbcnVar2.onPaused();
        }
    }
}
