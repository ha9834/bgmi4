package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4799a;
    private final /* synthetic */ cx b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cx cxVar, boolean z) {
        this.b = cxVar;
        this.f4799a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjgVar = this.b.b;
        zzjgVar.a(this.f4799a);
    }
}
