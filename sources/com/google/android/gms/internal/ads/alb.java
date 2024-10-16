package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class alb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zznc f1946a;
    private final /* synthetic */ zzma b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public alb(zzma zzmaVar, zznc zzncVar) {
        this.b = zzmaVar;
        this.f1946a = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.b.b;
        zzlzVar.zza(this.f1946a);
    }
}
