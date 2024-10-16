package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ia implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcd f2233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(zzbcd zzbcdVar) {
        this.f2233a = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f2233a.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f2233a.r;
            zzbcnVar2.zzxl();
        }
    }
}
