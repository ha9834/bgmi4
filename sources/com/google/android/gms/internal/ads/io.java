package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
@zzard
/* loaded from: classes2.dex */
public final class io implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private zzbcq f2245a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public io(zzbcq zzbcqVar) {
        this.f2245a = zzbcqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b) {
            return;
        }
        this.f2245a.a();
        c();
    }

    public final void a() {
        this.b = true;
        this.f2245a.a();
    }

    public final void b() {
        this.b = false;
        c();
    }

    private final void c() {
        zzaxi.zzdvv.removeCallbacks(this);
        zzaxi.zzdvv.postDelayed(this, 250L);
    }
}
