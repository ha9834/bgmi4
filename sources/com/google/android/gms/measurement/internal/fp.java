package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4863a;
    private final /* synthetic */ zzp b;
    private final /* synthetic */ zzhv c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(zzhv zzhvVar, zzn zznVar, zzp zzpVar) {
        this.c = zzhvVar;
        this.f4863a = zznVar;
        this.b = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        try {
            zzdxVar = this.c.b;
            if (zzdxVar == null) {
                this.c.zzab().zzgk().zzao("Failed to get app instance id");
                return;
            }
            String zzc = zzdxVar.zzc(this.f4863a);
            if (zzc != null) {
                this.c.zzq().a(zzc);
                this.c.zzac().j.zzau(zzc);
            }
            this.c.k();
            this.c.zzz().zzb(this.b, zzc);
        } catch (RemoteException e) {
            this.c.zzab().zzgk().zza("Failed to get app instance id", e);
        } finally {
            this.c.zzz().zzb(this.b, null);
        }
    }
}
