package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4862a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzhv c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(zzhv zzhvVar, zzn zznVar, boolean z) {
        this.c = zzhvVar;
        this.f4862a = zznVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzdxVar = this.c.b;
        if (zzdxVar == null) {
            this.c.zzab().zzgk().zzao("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzdxVar.zza(this.f4862a);
            if (this.b) {
                this.c.zzu().zzgi();
            }
            this.c.a(zzdxVar, (AbstractSafeParcelable) null, this.f4862a);
            this.c.k();
        } catch (RemoteException e) {
            this.c.zzab().zzgk().zza("Failed to send app launch to the service", e);
        }
    }
}
