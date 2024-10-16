package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4858a;
    private final /* synthetic */ zzjn b;
    private final /* synthetic */ zzn c;
    private final /* synthetic */ zzhv d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(zzhv zzhvVar, boolean z, zzjn zzjnVar, zzn zznVar) {
        this.d = zzhvVar;
        this.f4858a = z;
        this.b = zzjnVar;
        this.c = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.d.b;
        if (zzdxVar == null) {
            this.d.zzab().zzgk().zzao("Discarding data. Failed to set user attribute");
        } else {
            this.d.a(zzdxVar, this.f4858a ? null : this.b, this.c);
            this.d.k();
        }
    }
}
