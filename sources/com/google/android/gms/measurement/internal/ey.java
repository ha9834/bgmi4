package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ey implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4847a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ey(zzgp zzgpVar, boolean z) {
        this.b = zzgpVar;
        this.f4847a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4847a);
    }
}
