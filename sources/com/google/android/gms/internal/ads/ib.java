package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ib implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2234a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zzbcd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ib(zzbcd zzbcdVar, int i, int i2) {
        this.c = zzbcdVar;
        this.f2234a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.c.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.c.r;
            zzbcnVar2.zzk(this.f2234a, this.b);
        }
    }
}
