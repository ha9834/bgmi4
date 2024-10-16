package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ic implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcd f2235a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ic(zzbcd zzbcdVar) {
        this.f2235a = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcn zzbcnVar3;
        zzbcnVar = this.f2235a.r;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f2235a.r;
            zzbcnVar2.onPaused();
            zzbcnVar3 = this.f2235a.r;
            zzbcnVar3.zzxo();
        }
    }
}
