package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class apg implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzwb f2029a;
    private final /* synthetic */ zzvv b;
    private final /* synthetic */ zzbbr c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public apg(zzwb zzwbVar, zzvv zzvvVar, zzbbr zzbbrVar) {
        this.f2029a = zzwbVar;
        this.b = zzvvVar;
        this.c = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        boolean z;
        final zzvu zzvuVar;
        obj = this.f2029a.d;
        synchronized (obj) {
            z = this.f2029a.b;
            if (z) {
                return;
            }
            zzwb.a(this.f2029a, true);
            zzvuVar = this.f2029a.f3765a;
            if (zzvuVar == null) {
                return;
            }
            final zzvv zzvvVar = this.b;
            final zzbbr zzbbrVar = this.c;
            final zzbbh<?> zzc = zzaxg.zzc(new Runnable(this, zzvuVar, zzvvVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.aph

                /* renamed from: a, reason: collision with root package name */
                private final apg f2030a;
                private final zzvu b;
                private final zzvv c;
                private final zzbbr d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2030a = this;
                    this.b = zzvuVar;
                    this.c = zzvvVar;
                    this.d = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    apg apgVar = this.f2030a;
                    zzvu zzvuVar2 = this.b;
                    zzvv zzvvVar2 = this.c;
                    zzbbr zzbbrVar2 = this.d;
                    try {
                        zzvs zza = zzvuVar2.zznk().zza(zzvvVar2);
                        if (!zza.zznh()) {
                            zzbbrVar2.setException(new RuntimeException("No entry contents."));
                            apgVar.f2029a.a();
                            return;
                        }
                        apj apjVar = new apj(apgVar, zza.zzni(), 1);
                        int read = apjVar.read();
                        if (read == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        apjVar.unread(read);
                        zzbbrVar2.set(apjVar);
                    } catch (RemoteException | IOException e) {
                        zzawz.zzc("Unable to obtain a cache service instance.", e);
                        zzbbrVar2.setException(e);
                        apgVar.f2029a.a();
                    }
                }
            });
            zzbbr zzbbrVar2 = this.c;
            final zzbbr zzbbrVar3 = this.c;
            zzbbrVar2.zza(new Runnable(zzbbrVar3, zzc) { // from class: com.google.android.gms.internal.ads.api

                /* renamed from: a, reason: collision with root package name */
                private final zzbbr f2031a;
                private final Future b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2031a = zzbbrVar3;
                    this.b = zzc;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbr zzbbrVar4 = this.f2031a;
                    Future future = this.b;
                    if (zzbbrVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzbbm.zzeaf);
        }
    }
}
