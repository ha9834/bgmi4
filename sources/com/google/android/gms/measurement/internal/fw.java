package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4870a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzn c;
    private final /* synthetic */ zzp d;
    private final /* synthetic */ zzhv e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(zzhv zzhvVar, String str, String str2, zzn zznVar, zzp zzpVar) {
        this.e = zzhvVar;
        this.f4870a = str;
        this.b = str2;
        this.c = zznVar;
        this.d = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzdxVar = this.e.b;
            if (zzdxVar == null) {
                this.e.zzab().zzgk().zza("Failed to get conditional properties", this.f4870a, this.b);
                return;
            }
            ArrayList<Bundle> zzd = zzjs.zzd(zzdxVar.zza(this.f4870a, this.b, this.c));
            this.e.k();
            this.e.zzz().zza(this.d, zzd);
        } catch (RemoteException e) {
            this.e.zzab().zzgk().zza("Failed to get conditional properties", this.f4870a, this.b, e);
        } finally {
            this.e.zzz().zza(this.d, arrayList);
        }
    }
}
