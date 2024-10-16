package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzhq extends dz {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    protected zzhr f4946a;
    private volatile zzhr b;
    private zzhr c;
    private final Map<Activity, zzhr> d;
    private zzhr e;
    private String f;

    public zzhq(zzfj zzfjVar) {
        super(zzfjVar);
        this.d = new androidx.b.a();
    }

    @Override // com.google.android.gms.measurement.internal.dz
    protected final boolean a() {
        return false;
    }

    public final zzhr zzin() {
        j();
        zzo();
        return this.f4946a;
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.b == null) {
            zzab().zzgp().zzao("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.d.get(activity) == null) {
            zzab().zzgp().zzao("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = a(activity.getClass().getCanonicalName());
        }
        boolean equals = this.b.zzqv.equals(str2);
        boolean d = zzjs.d(this.b.zzqu, str);
        if (equals && d) {
            zzab().zzgp().zzao("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            zzab().zzgp().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            zzab().zzgp().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzab().zzgs().zza("Setting current screen to name, class", str == null ? Constants.NULL_VERSION_ID : str, str2);
        zzhr zzhrVar = new zzhr(str, str2, zzz().zzjv());
        this.d.put(activity, zzhrVar);
        a(activity, zzhrVar, true);
    }

    public final zzhr zzio() {
        zzm();
        return this.b;
    }

    private final void a(Activity activity, zzhr zzhrVar, boolean z) {
        zzhr zzhrVar2 = this.b == null ? this.c : this.b;
        if (zzhrVar.zzqv == null) {
            zzhrVar = new zzhr(zzhrVar.zzqu, a(activity.getClass().getCanonicalName()), zzhrVar.zzqw);
        }
        this.c = this.b;
        this.b = zzhrVar;
        zzaa().zza(new fh(this, z, zzhrVar2, zzhrVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzhr zzhrVar, boolean z) {
        zzp().zzc(zzx().elapsedRealtime());
        if (zzv().zza(zzhrVar.f4947a, z)) {
            zzhrVar.f4947a = false;
        }
    }

    public static void zza(zzhr zzhrVar, Bundle bundle, boolean z) {
        if (bundle != null && zzhrVar != null && (!bundle.containsKey("_sc") || z)) {
            if (zzhrVar.zzqu != null) {
                bundle.putString("_sn", zzhrVar.zzqu);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzhrVar.zzqv);
            bundle.putLong("_si", zzhrVar.zzqw);
            return;
        }
        if (bundle != null && zzhrVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzhr zzhrVar) {
        zzo();
        synchronized (this) {
            if (this.f == null || this.f.equals(str) || zzhrVar != null) {
                this.f = str;
                this.e = zzhrVar;
            }
        }
    }

    @VisibleForTesting
    private static String a(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzhr a(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzhr zzhrVar = this.d.get(activity);
        if (zzhrVar != null) {
            return zzhrVar;
        }
        zzhr zzhrVar2 = new zzhr(null, a(activity.getClass().getCanonicalName()), zzz().zzjv());
        this.d.put(activity, zzhrVar2);
        return zzhrVar2;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.d.put(activity, new zzhr(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void onActivityResumed(Activity activity) {
        a(activity, a(activity), false);
        zza zzp = zzp();
        zzp.zzaa().zza(new cq(zzp, zzp.zzx().elapsedRealtime()));
    }

    public final void onActivityPaused(Activity activity) {
        zzhr a2 = a(activity);
        this.c = this.b;
        this.b = null;
        zzaa().zza(new fg(this, a2));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzhr zzhrVar;
        if (bundle == null || (zzhrVar = this.d.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzhrVar.zzqw);
        bundle2.putString("name", zzhrVar.zzqu);
        bundle2.putString("referrer_name", zzhrVar.zzqv);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.d.remove(activity);
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
