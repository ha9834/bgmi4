package com.android.billingclient.api;

/* loaded from: classes.dex */
final class as implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f952a;
    final /* synthetic */ at b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(at atVar, aa aaVar) {
        this.b = atVar;
        this.f952a = aaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.a(this.f952a.a(), this.f952a.b());
    }
}
