package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4290a;
    private final /* synthetic */ zzae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzae zzaeVar, int i) {
        this.b = zzaeVar;
        this.f4290a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.b.f4384a;
        nVar.a(this.f4290a * 1000);
    }
}
