package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class gp extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(go goVar, String str) {
        this.f2196a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzbah().zzed(this.f2196a);
    }
}
