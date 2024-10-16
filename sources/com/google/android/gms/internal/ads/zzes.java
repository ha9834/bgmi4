package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzbp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzes extends zzfk {
    public zzes(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        super(zzdyVar, str, str2, c0092zza, i, 24);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    /* renamed from: zzcz */
    public final Void call() throws Exception {
        if (this.f3634a.isInitialized()) {
            return super.call();
        }
        if (!this.f3634a.zzcl()) {
            return null;
        }
        b();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.f3634a.zzcl()) {
            b();
            return;
        }
        synchronized (this.b) {
            this.b.zzaf((String) this.c.invoke(null, this.f3634a.getContext()));
        }
    }

    private final void b() {
        AdvertisingIdClient zzct = this.f3634a.zzct();
        if (zzct == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzct.getInfo();
            String zzap = zzef.zzap(info.getId());
            if (zzap != null) {
                synchronized (this.b) {
                    this.b.zzaf(zzap);
                    this.b.zzb(info.isLimitAdTrackingEnabled());
                    this.b.zzb(zzbp.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfk, java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return call();
    }
}
