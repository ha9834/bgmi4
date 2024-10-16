package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzhr f4865a;
    private final /* synthetic */ zzhv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(zzhv zzhvVar, zzhr zzhrVar) {
        this.b = zzhvVar;
        this.f4865a = zzhrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.b.b;
        if (zzdxVar == null) {
            this.b.zzab().zzgk().zzao("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f4865a == null) {
                zzdxVar.zza(0L, (String) null, (String) null, this.b.getContext().getPackageName());
            } else {
                zzdxVar.zza(this.f4865a.zzqw, this.f4865a.zzqu, this.f4865a.zzqv, this.b.getContext().getPackageName());
            }
            this.b.k();
        } catch (RemoteException e) {
            this.b.zzab().zzgk().zza("Failed to send current screen to the service", e);
        }
    }
}
