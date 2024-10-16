package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzai f4864a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzp c;
    private final /* synthetic */ zzhv d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(zzhv zzhvVar, zzai zzaiVar, String str, zzp zzpVar) {
        this.d = zzhvVar;
        this.f4864a = zzaiVar;
        this.b = str;
        this.c = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        try {
            zzdxVar = this.d.b;
            if (zzdxVar == null) {
                this.d.zzab().zzgk().zzao("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza = zzdxVar.zza(this.f4864a, this.b);
            this.d.k();
            this.d.zzz().zza(this.c, zza);
        } catch (RemoteException e) {
            this.d.zzab().zzgk().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.d.zzz().zza(this.c, (byte[]) null);
        }
    }
}
