package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzh;

/* loaded from: classes2.dex */
public final class zziw extends dz {

    /* renamed from: a, reason: collision with root package name */
    private Handler f4951a;

    @VisibleForTesting
    private long b;

    @VisibleForTesting
    private long c;
    private final a d;
    private final a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(zzfj zzfjVar) {
        super(zzfjVar);
        this.d = new gj(this, this.v);
        this.e = new gi(this, this.v);
        this.b = zzx().elapsedRealtime();
        this.c = this.b;
    }

    @Override // com.google.android.gms.measurement.internal.dz
    protected final boolean a() {
        return false;
    }

    private final void f() {
        synchronized (this) {
            if (this.f4951a == null) {
                this.f4951a = new zzh(Looper.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        zzo();
        this.d.c();
        this.e.c();
        this.b = 0L;
        this.c = this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j) {
        zzo();
        f();
        if (zzad().zze(zzr().c(), zzak.zzid)) {
            zzac().t.set(false);
        }
        zzab().zzgs().zza("Activity resumed, time", Long.valueOf(j));
        this.b = j;
        this.c = this.b;
        if (this.v.isEnabled()) {
            if (zzad().m(zzr().c())) {
                a(zzx().currentTimeMillis(), false);
                return;
            }
            this.d.c();
            this.e.c();
            if (zzac().a(zzx().currentTimeMillis())) {
                zzac().m.set(true);
                zzac().r.set(0L);
            }
            if (zzac().m.get()) {
                this.d.a(Math.max(0L, zzac().k.get() - zzac().r.get()));
            } else {
                this.e.a(Math.max(0L, 3600000 - zzac().r.get()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j, boolean z) {
        zzo();
        f();
        this.d.c();
        this.e.c();
        if (zzac().a(j)) {
            zzac().m.set(true);
            zzac().r.set(0L);
        }
        if (z && zzad().n(zzr().c())) {
            zzac().q.set(j);
        }
        if (zzac().m.get()) {
            c(j);
        } else {
            this.e.a(Math.max(0L, 3600000 - zzac().r.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(long j) {
        zzo();
        f();
        if (zzad().zze(zzr().c(), zzak.zzid)) {
            zzac().t.set(true);
        }
        this.d.c();
        this.e.c();
        zzab().zzgs().zza("Activity paused, time", Long.valueOf(j));
        if (this.b != 0) {
            zzac().r.set(zzac().r.get() + (j - this.b));
        }
    }

    private final void c(long j) {
        zzo();
        zzab().zzgs().zza("Session started, time", Long.valueOf(zzx().elapsedRealtime()));
        Long valueOf = zzad().k(zzr().c()) ? Long.valueOf(j / 1000) : null;
        zzq().a("auto", "_sid", valueOf, j);
        zzac().m.set(false);
        Bundle bundle = new Bundle();
        if (zzad().k(zzr().c())) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        zzq().a("auto", "_s", j, bundle);
        zzac().q.set(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void d() {
        zzo();
        c(zzx().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final long e() {
        long elapsedRealtime = zzx().elapsedRealtime();
        long j = elapsedRealtime - this.c;
        this.c = elapsedRealtime;
        return j;
    }

    public final boolean zza(boolean z, boolean z2) {
        zzo();
        j();
        long elapsedRealtime = zzx().elapsedRealtime();
        zzac().q.set(zzx().currentTimeMillis());
        long j = elapsedRealtime - this.b;
        if (!z && j < 1000) {
            zzab().zzgs().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
            return false;
        }
        zzac().r.set(j);
        zzab().zzgs().zza("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzhq.zza(zzt().zzin(), bundle, true);
        if (zzad().o(zzr().c())) {
            if (zzad().zze(zzr().c(), zzak.zzii)) {
                if (!z2) {
                    e();
                }
            } else if (z2) {
                bundle.putLong("_fr", 1L);
            } else {
                e();
            }
        }
        if (!zzad().zze(zzr().c(), zzak.zzii) || !z2) {
            zzq().logEvent("auto", "_e", bundle);
        }
        this.b = elapsedRealtime;
        this.e.c();
        this.e.a(Math.max(0L, 3600000 - zzac().r.get()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        zzo();
        zza(false, false);
        zzp().zzc(zzx().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
