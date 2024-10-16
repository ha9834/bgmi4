package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class dw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzai f4820a;
    private final /* synthetic */ zzn b;
    private final /* synthetic */ zzfk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(zzfk zzfkVar, zzai zzaiVar, zzn zznVar) {
        this.c = zzfkVar;
        this.f4820a = zzaiVar;
        this.b = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzai a2 = this.c.a(this.f4820a, this.b);
        zzjgVar = this.c.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.c.f4942a;
        zzjgVar2.a(a2, this.b);
    }
}
