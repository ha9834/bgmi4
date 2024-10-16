package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class dn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f4811a;
    private final /* synthetic */ zzfk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(zzfk zzfkVar, zzq zzqVar) {
        this.b = zzfkVar;
        this.f4811a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.b.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.b.f4942a;
        zzjgVar2.b(this.f4811a);
    }
}
