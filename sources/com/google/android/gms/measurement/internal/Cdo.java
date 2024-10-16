package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.do, reason: invalid class name */
/* loaded from: classes2.dex */
final class Cdo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f4812a;
    private final /* synthetic */ zzn b;
    private final /* synthetic */ zzfk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(zzfk zzfkVar, zzq zzqVar, zzn zznVar) {
        this.c = zzfkVar;
        this.f4812a = zzqVar;
        this.b = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.c.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.c.f4942a;
        zzjgVar2.a(this.f4812a, this.b);
    }
}
