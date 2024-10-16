package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class ed implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4828a;
    private final /* synthetic */ zzfk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(zzfk zzfkVar, zzn zznVar) {
        this.b = zzfkVar;
        this.f4828a = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.b.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.b.f4942a;
        zzjgVar2.c(this.f4828a);
    }
}
