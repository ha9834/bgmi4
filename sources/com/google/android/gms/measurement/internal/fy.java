package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4872a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ zzn d;
    private final /* synthetic */ zzp e;
    private final /* synthetic */ zzhv f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(zzhv zzhvVar, String str, String str2, boolean z, zzn zznVar, zzp zzpVar) {
        this.f = zzhvVar;
        this.f4872a = str;
        this.b = str2;
        this.c = z;
        this.d = zznVar;
        this.e = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        Bundle bundle = new Bundle();
        try {
            zzdxVar = this.f.b;
            if (zzdxVar == null) {
                this.f.zzab().zzgk().zza("Failed to get user properties", this.f4872a, this.b);
                return;
            }
            Bundle zzc = zzjs.zzc(zzdxVar.zza(this.f4872a, this.b, this.c, this.d));
            this.f.k();
            this.f.zzz().zza(this.e, zzc);
        } catch (RemoteException e) {
            this.f.zzab().zzgk().zza("Failed to get user properties", this.f4872a, e);
        } finally {
            this.f.zzz().zza(this.e, bundle);
        }
    }
}
