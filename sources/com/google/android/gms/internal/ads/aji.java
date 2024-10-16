package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class aji implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzhv f1913a;
    private final /* synthetic */ zzgn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aji(zzgn zzgnVar, zzhv zzhvVar) {
        this.b = zzgnVar;
        this.f1913a = zzhvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgq zzgqVar;
        zzgqVar = this.b.b;
        zzgqVar.zza(this.f1913a);
    }
}
