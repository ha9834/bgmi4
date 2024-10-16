package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class alf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zznc f1950a;
    private final /* synthetic */ zzma b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public alf(zzma zzmaVar, zznc zzncVar) {
        this.b = zzmaVar;
        this.f1950a = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        this.f1950a.zzdk();
        zzlzVar = this.b.b;
        zzlzVar.zzb(this.f1950a);
    }
}
