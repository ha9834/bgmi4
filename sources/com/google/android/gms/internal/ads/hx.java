package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class hx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcd f2229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hx(zzbcd zzbcdVar) {
        this.f2229a = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f2229a.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f2229a.r;
            zzbcnVar2.zzhd();
        }
    }
}
