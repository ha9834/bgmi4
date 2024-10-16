package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzce f4365a;
    private final /* synthetic */ zzav b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzav zzavVar, zzce zzceVar) {
        this.b = zzavVar;
        this.f4365a = zzceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.f4391a.isConnected()) {
            return;
        }
        this.b.f4391a.zzr("Connected to service after a timeout");
        zzat.a(this.b.f4391a, this.f4365a);
    }
}
