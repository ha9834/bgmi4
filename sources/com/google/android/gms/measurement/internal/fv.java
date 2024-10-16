package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4869a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzai c;
    private final /* synthetic */ zzn d;
    private final /* synthetic */ String e;
    private final /* synthetic */ zzhv f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(zzhv zzhvVar, boolean z, boolean z2, zzai zzaiVar, zzn zznVar, String str) {
        this.f = zzhvVar;
        this.f4869a = z;
        this.b = z2;
        this.c = zzaiVar;
        this.d = zznVar;
        this.e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.f.b;
        if (zzdxVar == null) {
            this.f.zzab().zzgk().zzao("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f4869a) {
            this.f.a(zzdxVar, this.b ? null : this.c, this.d);
        } else {
            try {
                if (TextUtils.isEmpty(this.e)) {
                    zzdxVar.zza(this.c, this.d);
                } else {
                    zzdxVar.zza(this.c, this.e, this.f.zzab().zzgu());
                }
            } catch (RemoteException e) {
                this.f.zzab().zzgk().zza("Failed to send event to the service", e);
            }
        }
        this.f.k();
    }
}
