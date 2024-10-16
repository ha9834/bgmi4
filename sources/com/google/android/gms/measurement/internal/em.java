package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class em implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzgk f4835a;
    private final /* synthetic */ zzgp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(zzgp zzgpVar, zzgk zzgkVar) {
        this.b = zzgpVar;
        this.f4835a = zzgkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.zza(this.f4835a);
    }
}
