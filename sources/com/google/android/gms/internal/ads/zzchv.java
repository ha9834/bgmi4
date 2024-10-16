package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzchv extends zzchx {
    public zzchv(Context context) {
        this.f = new zzarf(context, zzk.zzlu().zzwr(), this, this);
    }

    public final zzbbh<InputStream> zzf(zzarx zzarxVar) {
        synchronized (this.b) {
            if (this.c) {
                return this.f3266a;
            }
            this.c = true;
            this.e = zzarxVar;
            this.f.checkAvailabilityAndConnect();
            this.f3266a.zza(new Runnable(this) { // from class: com.google.android.gms.internal.ads.tq

                /* renamed from: a, reason: collision with root package name */
                private final zzchv f2524a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2524a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2524a.a();
                }
            }, zzbbm.zzeaf);
            return this.f3266a;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchx, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzawz.zzdp("Cannot connect to remote service, fallback to local instance.");
        this.f3266a.setException(new zzcie(0));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.b) {
            if (!this.d) {
                this.d = true;
                try {
                    this.f.zztr().zza(this.e, new zzchy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.f3266a.setException(new zzcie(0));
                } catch (Throwable th) {
                    zzk.zzlk().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.f3266a.setException(new zzcie(0));
                }
            }
        }
    }
}
