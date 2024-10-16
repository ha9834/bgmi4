package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4327a;
    private final /* synthetic */ Runnable b;
    private final /* synthetic */ zzae c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzae zzaeVar, String str, Runnable runnable) {
        this.c = zzaeVar;
        this.f4327a = str;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.c.f4384a;
        nVar.a(this.f4327a);
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
