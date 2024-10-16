package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;

/* loaded from: classes2.dex */
public final class zzex implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzeu f4938a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzex(zzeu zzeuVar, String str) {
        this.f4938a = zzeuVar;
        this.b = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f4938a.f4936a.zzab().zzgn().zzao("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzf zza = zze.zza(iBinder);
            if (zza == null) {
                this.f4938a.f4936a.zzab().zzgn().zzao("Install Referrer Service implementation was not found");
            } else {
                this.f4938a.f4936a.zzab().zzgq().zzao("Install Referrer Service connected");
                this.f4938a.f4936a.zzaa().zza(new dc(this, zza, this));
            }
        } catch (Exception e) {
            this.f4938a.f4936a.zzab().zzgn().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f4938a.f4936a.zzab().zzgq().zzao("Install Referrer Service disconnected");
    }
}
