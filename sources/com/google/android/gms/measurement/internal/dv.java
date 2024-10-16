package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class dv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzai f4819a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzfk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(zzfk zzfkVar, zzai zzaiVar, String str) {
        this.c = zzfkVar;
        this.f4819a = zzaiVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.c.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.c.f4942a;
        zzjgVar2.a(this.f4819a, this.b);
    }
}
