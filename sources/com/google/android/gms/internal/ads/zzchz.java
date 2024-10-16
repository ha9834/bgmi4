package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzchz extends zzchx {
    public zzchz(Context context) {
        this.f = new zzarf(context, zzk.zzlu().zzwr(), this, this);
    }

    public final zzbbh<InputStream> zzg(zzarx zzarxVar) {
        synchronized (this.b) {
            if (this.c) {
                return this.f3266a;
            }
            this.c = true;
            this.e = zzarxVar;
            this.f.checkAvailabilityAndConnect();
            this.f3266a.zza(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ts

                /* renamed from: a, reason: collision with root package name */
                private final zzchz f2526a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2526a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2526a.a();
                }
            }, zzbbm.zzeaf);
            return this.f3266a;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.b) {
            if (!this.d) {
                this.d = true;
                try {
                    this.f.zztr().zzb(this.e, new zzchy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.f3266a.setException(new zzcie(0));
                } catch (Throwable th) {
                    zzk.zzlk().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.f3266a.setException(new zzcie(0));
                }
            }
        }
    }
}
