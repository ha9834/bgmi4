package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class aba implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private zzdba f1775a;
    private final String b;
    private final String c;
    private final LinkedBlockingQueue<zzbp.zza> d;
    private final HandlerThread e = new HandlerThread("GassClient");

    public aba(Context context, String str, String str2) {
        this.b = str;
        this.c = str2;
        this.e.start();
        this.f1775a = new zzdba(context, this.e.getLooper(), this, this);
        this.d = new LinkedBlockingQueue<>();
        this.f1775a.checkAvailabilityAndConnect();
    }

    public final zzbp.zza a(int i) {
        zzbp.zza zzaVar;
        try {
            zzaVar = this.d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVar = null;
        }
        return zzaVar == null ? c() : zzaVar;
    }

    private final zzdbf a() {
        try {
            return this.f1775a.zzanm();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.d.put(c());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdbf a2 = a();
        try {
            if (a2 != null) {
                try {
                    try {
                        this.d.put(a2.zza(new zzdbb(this.b, this.c)).zzann());
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable unused2) {
                    this.d.put(c());
                }
            }
        } finally {
            b();
            this.e.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.d.put(c());
        } catch (InterruptedException unused) {
        }
    }

    private final void b() {
        zzdba zzdbaVar = this.f1775a;
        if (zzdbaVar != null) {
            if (zzdbaVar.isConnected() || this.f1775a.isConnecting()) {
                this.f1775a.disconnect();
            }
        }
    }

    @VisibleForTesting
    private static zzbp.zza c() {
        return (zzbp.zza) ((zzdob) zzbp.zza.zzam().zzau(32768L).zzaya());
    }
}
