package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@zzard
/* loaded from: classes2.dex */
public final class zzaii implements zzm {

    /* renamed from: a, reason: collision with root package name */
    private volatile zzahz f2738a;
    private final Context b;

    public zzaii(Context context) {
        this.b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzm
    public final zzp zzc(zzr<?> zzrVar) throws zzaf {
        zzaia zzh = zzaia.zzh(zzrVar);
        long elapsedRealtime = zzk.zzln().elapsedRealtime();
        try {
            zzbbr zzbbrVar = new zzbbr();
            this.f2738a = new zzahz(this.b, zzk.zzlu().zzwr(), new as(this, zzbbrVar), new at(this, zzbbrVar));
            this.f2738a.checkAvailabilityAndConnect();
            zzbbh zza = zzbar.zza(zzbar.zza(zzbbrVar, new ap(this, zzh), zzaxg.zzdvp), ((Integer) zzyt.zzpe().zzd(zzacu.zzctx)).intValue(), TimeUnit.MILLISECONDS, zzaxg.zzdvr);
            zza.zza(new ar(this), zzaxg.zzdvp);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzawz.zzds(sb.toString());
            zzaic zzaicVar = (zzaic) new zzaru(parcelFileDescriptor).zza(zzaic.CREATOR);
            if (zzaicVar == null) {
                return null;
            }
            if (zzaicVar.zzdav) {
                throw new zzaf(zzaicVar.zzdaw);
            }
            if (zzaicVar.zzdat.length != zzaicVar.zzdau.length) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < zzaicVar.zzdat.length; i++) {
                hashMap.put(zzaicVar.zzdat[i], zzaicVar.zzdau[i]);
            }
            return new zzp(zzaicVar.statusCode, zzaicVar.data, hashMap, zzaicVar.zzac, zzaicVar.zzad);
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(elapsedRealtime3);
            sb2.append("ms");
            zzawz.zzds(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime4 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime4);
            sb3.append("ms");
            zzawz.zzds(sb3.toString());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        if (this.f2738a == null) {
            return;
        }
        this.f2738a.disconnect();
        Binder.flushPendingCommands();
    }
}
