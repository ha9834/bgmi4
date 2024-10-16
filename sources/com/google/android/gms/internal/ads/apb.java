package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class apb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzvn f2024a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public apb(zzvn zzvnVar) {
        this.f2024a = zzvnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2024a.b();
    }
}
