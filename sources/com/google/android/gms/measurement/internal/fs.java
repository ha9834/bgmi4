package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4866a;
    private final /* synthetic */ zzhv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(zzhv zzhvVar, zzn zznVar) {
        this.b = zzhvVar;
        this.f4866a = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.b.b;
        if (zzdxVar == null) {
            this.b.zzab().zzgk().zzao("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzdxVar.zzb(this.f4866a);
            this.b.k();
        } catch (RemoteException e) {
            this.b.zzab().zzgk().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
