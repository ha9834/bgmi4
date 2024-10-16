package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzgv f1914a;
    private final /* synthetic */ zzgr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajj(zzgr zzgrVar, zzgv zzgvVar) {
        this.b = zzgrVar;
        this.f1914a = zzgvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgw zzgwVar;
        zzgwVar = this.b.i;
        zzgwVar.zzb(this.f1914a);
    }
}
