package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzawv f2171a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(zzawv zzawvVar) {
        this.f2171a = zzawvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2171a.b = Thread.currentThread();
        this.f2171a.zzto();
    }
}
