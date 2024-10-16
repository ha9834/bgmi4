package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class dx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzjn f4821a;
    private final /* synthetic */ zzn b;
    private final /* synthetic */ zzfk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(zzfk zzfkVar, zzjn zzjnVar, zzn zznVar) {
        this.c = zzfkVar;
        this.f4821a = zzjnVar;
        this.b = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.c.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.c.f4942a;
        zzjgVar2.b(this.f4821a, this.b);
    }
}
