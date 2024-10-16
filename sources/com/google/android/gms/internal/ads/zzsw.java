package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class zzsw implements zzso {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3739a;
    private long b;
    private long c;
    private zzln d = zzln.zzaug;

    public final void start() {
        if (this.f3739a) {
            return;
        }
        this.c = SystemClock.elapsedRealtime();
        this.f3739a = true;
    }

    public final void stop() {
        if (this.f3739a) {
            zzdj(zzdv());
            this.f3739a = false;
        }
    }

    public final void zzdj(long j) {
        this.b = j;
        if (this.f3739a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    public final void zza(zzso zzsoVar) {
        zzdj(zzsoVar.zzdv());
        this.d = zzsoVar.zzhq();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final long zzdv() {
        long j = this.b;
        if (!this.f3739a) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (this.d.zzauh == 1.0f) {
            return j + zzkt.zzea(elapsedRealtime);
        }
        return j + this.d.zzef(elapsedRealtime);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzln zzb(zzln zzlnVar) {
        if (this.f3739a) {
            zzdj(zzdv());
        }
        this.d = zzlnVar;
        return zzlnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzln zzhq() {
        return this.d;
    }
}
