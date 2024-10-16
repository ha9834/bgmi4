package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbcy {
    private long b;

    /* renamed from: a, reason: collision with root package name */
    private final long f2857a = TimeUnit.MILLISECONDS.toNanos(((Long) zzyt.zzpe().zzd(zzacu.zzcme)).longValue());
    private boolean c = true;

    public final void zzxm() {
        this.c = true;
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbcn zzbcnVar) {
        if (zzbcnVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.c || Math.abs(timestamp - this.b) >= this.f2857a) {
            this.c = false;
            this.b = timestamp;
            zzaxi.zzdvv.post(new ik(this, zzbcnVar));
        }
    }
}
