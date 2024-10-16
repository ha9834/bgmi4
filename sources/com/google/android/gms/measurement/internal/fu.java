package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4868a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzq c;
    private final /* synthetic */ zzn d;
    private final /* synthetic */ zzq e;
    private final /* synthetic */ zzhv f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(zzhv zzhvVar, boolean z, boolean z2, zzq zzqVar, zzn zznVar, zzq zzqVar2) {
        this.f = zzhvVar;
        this.f4868a = z;
        this.b = z2;
        this.c = zzqVar;
        this.d = zznVar;
        this.e = zzqVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.f.b;
        if (zzdxVar == null) {
            this.f.zzab().zzgk().zzao("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f4868a) {
            this.f.a(zzdxVar, this.b ? null : this.c, this.d);
        } else {
            try {
                if (TextUtils.isEmpty(this.e.packageName)) {
                    zzdxVar.zza(this.c, this.d);
                } else {
                    zzdxVar.zzb(this.c);
                }
            } catch (RemoteException e) {
                this.f.zzab().zzgk().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.f.k();
    }
}
