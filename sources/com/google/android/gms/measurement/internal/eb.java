package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class eb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzjn f4826a;
    private final /* synthetic */ zzn b;
    private final /* synthetic */ zzfk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(zzfk zzfkVar, zzjn zzjnVar, zzn zznVar) {
        this.c = zzfkVar;
        this.f4826a = zzjnVar;
        this.b = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.c.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.c.f4942a;
        zzjgVar2.a(this.f4826a, this.b);
    }
}
