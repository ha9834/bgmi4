package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zza extends bu {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f4922a;
    private final Map<String, Integer> b;
    private long c;

    public zza(zzfj zzfjVar) {
        super(zzfjVar);
        this.b = new androidx.b.a();
        this.f4922a = new androidx.b.a();
    }

    public final void beginAdUnitExposure(String str, long j) {
        if (str == null || str.length() == 0) {
            zzab().zzgk().zzao("Ad unit id must be a non-empty string");
        } else {
            zzaa().zza(new at(this, str, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, long j) {
        zzm();
        zzo();
        Preconditions.checkNotEmpty(str);
        if (this.b.isEmpty()) {
            this.c = j;
        }
        Integer num = this.b.get(str);
        if (num != null) {
            this.b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.b.size() >= 100) {
            zzab().zzgn().zzao("Too many ads visible");
        } else {
            this.b.put(str, 1);
            this.f4922a.put(str, Long.valueOf(j));
        }
    }

    public final void endAdUnitExposure(String str, long j) {
        if (str == null || str.length() == 0) {
            zzab().zzgk().zzao("Ad unit id must be a non-empty string");
        } else {
            zzaa().zza(new s(this, str, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str, long j) {
        zzm();
        zzo();
        Preconditions.checkNotEmpty(str);
        Integer num = this.b.get(str);
        if (num != null) {
            zzhr zzin = zzt().zzin();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.b.remove(str);
                Long l = this.f4922a.get(str);
                if (l == null) {
                    zzab().zzgk().zzao("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.f4922a.remove(str);
                    a(str, longValue, zzin);
                }
                if (this.b.isEmpty()) {
                    long j2 = this.c;
                    if (j2 == 0) {
                        zzab().zzgk().zzao("First ad exposure time was never set");
                        return;
                    } else {
                        a(j - j2, zzin);
                        this.c = 0L;
                        return;
                    }
                }
                return;
            }
            this.b.put(str, Integer.valueOf(intValue));
            return;
        }
        zzab().zzgk().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void a(long j, zzhr zzhrVar) {
        if (zzhrVar == null) {
            zzab().zzgs().zzao("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzab().zzgs().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zzhq.zza(zzhrVar, bundle, true);
        zzq().logEvent("am", "_xa", bundle);
    }

    private final void a(String str, long j, zzhr zzhrVar) {
        if (zzhrVar == null) {
            zzab().zzgs().zzao("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzab().zzgs().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zzhq.zza(zzhrVar, bundle, true);
        zzq().logEvent("am", "_xu", bundle);
    }

    public final void zzc(long j) {
        zzhr zzin = zzt().zzin();
        for (String str : this.f4922a.keySet()) {
            a(str, j - this.f4922a.get(str).longValue(), zzin);
        }
        if (!this.f4922a.isEmpty()) {
            a(j - this.c, zzin);
        }
        a(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j) {
        Iterator<String> it = this.f4922a.keySet().iterator();
        while (it.hasNext()) {
            this.f4922a.put(it.next(), Long.valueOf(j));
        }
        if (this.f4922a.isEmpty()) {
            return;
        }
        this.c = j;
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
