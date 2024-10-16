package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ajh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzhu f1912a;
    private final /* synthetic */ zzgn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajh(zzgn zzgnVar, zzhu zzhuVar) {
        this.b = zzgnVar;
        this.f1912a = zzhuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgq zzgqVar;
        zzgqVar = this.b.b;
        zzgqVar.zza(this.f1912a);
    }
}
