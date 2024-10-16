package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzs extends ef {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f4958a;
    private hc b;
    private Boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzfj zzfjVar) {
        super(zzfjVar);
        this.b = hd.f4902a;
        zzak.a(zzfjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(hc hcVar) {
        this.b = hcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return zzak.zzgf.get(null);
    }

    public final int zzi(String str) {
        return zzb(str, zzak.zzgt);
    }

    public final long zzao() {
        zzae();
        return 16250L;
    }

    public final boolean zzbn() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.c = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.c == null) {
                        this.c = Boolean.TRUE;
                        zzab().zzgk().zzao("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.c.booleanValue();
    }

    public final long zza(String str, zzdu<Long> zzduVar) {
        if (str == null) {
            return zzduVar.get(null).longValue();
        }
        String zzb = this.b.zzb(str, zzduVar.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzduVar.get(null).longValue();
        }
        try {
            return zzduVar.get(Long.valueOf(Long.parseLong(zzb))).longValue();
        } catch (NumberFormatException unused) {
            return zzduVar.get(null).longValue();
        }
    }

    public final int zzb(String str, zzdu<Integer> zzduVar) {
        if (str == null) {
            return zzduVar.get(null).intValue();
        }
        String zzb = this.b.zzb(str, zzduVar.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzduVar.get(null).intValue();
        }
        try {
            return zzduVar.get(Integer.valueOf(Integer.parseInt(zzb))).intValue();
        } catch (NumberFormatException unused) {
            return zzduVar.get(null).intValue();
        }
    }

    public final double zzc(String str, zzdu<Double> zzduVar) {
        if (str == null) {
            return zzduVar.get(null).doubleValue();
        }
        String zzb = this.b.zzb(str, zzduVar.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzduVar.get(null).doubleValue();
        }
        try {
            return zzduVar.get(Double.valueOf(Double.parseDouble(zzb))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzduVar.get(null).doubleValue();
        }
    }

    public final boolean zzd(String str, zzdu<Boolean> zzduVar) {
        if (str == null) {
            return zzduVar.get(null).booleanValue();
        }
        String zzb = this.b.zzb(str, zzduVar.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzduVar.get(null).booleanValue();
        }
        return zzduVar.get(Boolean.valueOf(Boolean.parseBoolean(zzb))).booleanValue();
    }

    public final boolean zze(String str, zzdu<Boolean> zzduVar) {
        return zzd(str, zzduVar);
    }

    public final boolean zza(zzdu<Boolean> zzduVar) {
        return zzd(null, zzduVar);
    }

    @VisibleForTesting
    private final Bundle d() {
        try {
            if (getContext().getPackageManager() == null) {
                zzab().zzgk().zzao("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzab().zzgk().zzao("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzab().zzgk().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean a(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle d = d();
        if (d == null) {
            zzab().zzgk().zzao("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (d.containsKey(str)) {
            return Boolean.valueOf(d.getBoolean(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final List<String> b(String str) {
        Integer valueOf;
        Preconditions.checkNotEmpty(str);
        Bundle d = d();
        if (d == null) {
            zzab().zzgk().zzao("Failed to load metadata: Metadata bundle is null");
            valueOf = null;
        } else {
            valueOf = !d.containsKey(str) ? null : Integer.valueOf(d.getInt(str));
        }
        if (valueOf == null) {
            return null;
        }
        try {
            String[] stringArray = getContext().getResources().getStringArray(valueOf.intValue());
            if (stringArray == null) {
                return null;
            }
            return Arrays.asList(stringArray);
        } catch (Resources.NotFoundException e) {
            zzab().zzgk().zza("Failed to load string array from metadata: resource not found", e);
            return null;
        }
    }

    public final boolean zzbp() {
        zzae();
        Boolean a2 = a("firebase_analytics_collection_deactivated");
        return a2 != null && a2.booleanValue();
    }

    public final Boolean zzbq() {
        zzae();
        return a("firebase_analytics_collection_enabled");
    }

    public final Boolean zzbr() {
        zzm();
        Boolean a2 = a("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(a2 == null || a2.booleanValue());
    }

    public static long zzbs() {
        return zzak.zzhi.get(null).longValue();
    }

    public static long zzbt() {
        return zzak.zzgi.get(null).longValue();
    }

    public final String zzbu() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e) {
            zzab().zzgk().zza("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            zzab().zzgk().zza("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            zzab().zzgk().zza("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            zzab().zzgk().zza("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static boolean zzbv() {
        return zzak.zzge.get(null).booleanValue();
    }

    public final boolean zzl(String str) {
        return "1".equals(this.b.zzb(str, "gaia_collection_enabled"));
    }

    public final boolean zzm(String str) {
        return "1".equals(this.b.zzb(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(String str) {
        return zzd(str, zzak.zzhs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(String str) {
        return zzd(str, zzak.zzhm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e(String str) {
        zzdu<String> zzduVar = zzak.zzhn;
        if (str == null) {
            return zzduVar.get(null);
        }
        return zzduVar.get(this.b.zzb(str, zzduVar.getKey()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(String str) {
        return zzd(str, zzak.zzht);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(String str) {
        return zzd(str, zzak.zzhu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(String str) {
        return zzd(str, zzak.zzhv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i(String str) {
        return zzd(str, zzak.zzhx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        if (this.f4958a == null) {
            this.f4958a = a("app_measurement_lite");
            if (this.f4958a == null) {
                this.f4958a = false;
            }
        }
        return this.f4958a.booleanValue() || !this.v.zzia();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j(String str) {
        return zzd(str, zzak.zzhw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return zzak.zzhy.get(null).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(String str) {
        return zzd(str, zzak.zzhz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l(String str) {
        return zzd(str, zzak.zzia);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(String str) {
        return zzd(str, zzak.zzib);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n(String str) {
        return zzd(str, zzak.zzic);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean o(String str) {
        return zzd(str, zzak.zzih);
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
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
