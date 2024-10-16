package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4860a;
    private final /* synthetic */ zzhv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(zzhv zzhvVar, zzn zznVar) {
        this.b = zzhvVar;
        this.f4860a = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.b.b;
        if (zzdxVar == null) {
            this.b.zzab().zzgk().zzao("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzdxVar.zzd(this.f4860a);
        } catch (RemoteException e) {
            this.b.zzab().zzgk().zza("Failed to reset data on the service", e);
        }
        this.b.k();
    }
}
