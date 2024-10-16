package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aoi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zznc f2005a;
    private final /* synthetic */ zzto b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aoi(zzto zztoVar, zznc zzncVar) {
        this.b = zztoVar;
        this.f2005a = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        this.f2005a.zzdk();
        zztnVar = this.b.b;
        zztnVar.zzf(this.f2005a);
    }
}
