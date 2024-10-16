package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class hy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcd f2230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hy(zzbcd zzbcdVar) {
        this.f2230a = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f2230a.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f2230a.r;
            zzbcnVar2.zzxn();
        }
    }
}
