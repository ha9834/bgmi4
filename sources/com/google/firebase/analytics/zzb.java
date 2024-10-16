package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzfj;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
final class zzb implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzaca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zzaca = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String zzi;
        boolean z;
        zzfj zzfjVar;
        String zzy;
        zzz zzzVar;
        zzi = this.zzaca.zzi();
        if (zzi != null) {
            return zzi;
        }
        z = this.zzaca.zzl;
        if (z) {
            zzzVar = this.zzaca.zzabu;
            zzy = zzzVar.getAppInstanceId();
        } else {
            zzfjVar = this.zzaca.zzj;
            zzy = zzfjVar.zzq().zzy(120000L);
        }
        if (zzy == null) {
            throw new TimeoutException();
        }
        this.zzaca.zzbg(zzy);
        return zzy;
    }
}
