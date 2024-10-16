package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbw f4361a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzae zzaeVar, zzbw zzbwVar) {
        this.b = zzaeVar;
        this.f4361a = zzbwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.f4384a;
        nVar.a(this.f4361a);
    }
}
