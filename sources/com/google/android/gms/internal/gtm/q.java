package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ n f4372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.f4372a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4372a.c();
    }
}
