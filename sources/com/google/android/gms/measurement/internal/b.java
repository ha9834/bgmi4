package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ eg f4749a;
    private final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, eg egVar) {
        this.b = aVar;
        this.f4749a = egVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4749a.zzae();
        if (zzr.isMainThread()) {
            this.f4749a.zzaa().zza(this);
            return;
        }
        boolean b = this.b.b();
        a.a(this.b, 0L);
        if (b) {
            this.b.a();
        }
    }
}
