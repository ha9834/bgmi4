package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class id implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcd f2236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public id(zzbcd zzbcdVar) {
        this.f2236a = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f2236a.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f2236a.r;
            zzbcnVar2.zzxm();
        }
    }
}
