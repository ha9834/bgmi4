package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzx;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class zzfj implements eg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzfj f4941a;
    private long A;
    private volatile Boolean B;

    @VisibleForTesting
    private Boolean C;

    @VisibleForTesting
    private Boolean D;
    private int E;
    private final long G;
    private final Context b;
    private final String c;
    private final String d;
    private final String e;
    private final boolean f;
    private final zzr g;
    private final zzs h;
    private final cz i;
    private final zzef j;
    private final zzfc k;
    private final zziw l;
    private final zzjs m;
    private final zzed n;
    private final Clock o;
    private final zzhq p;
    private final zzgp q;
    private final zza r;
    private final zzhl s;
    private zzeb t;
    private zzhv u;
    private zzac v;
    private zzdy w;
    private zzeu x;
    private Boolean z;
    private boolean y = false;
    private AtomicInteger F = new AtomicInteger(0);

    private zzfj(zzgm zzgmVar) {
        boolean z = false;
        Preconditions.checkNotNull(zzgmVar);
        this.g = new zzr(zzgmVar.f4943a);
        zzak.a(this.g);
        this.b = zzgmVar.f4943a;
        this.c = zzgmVar.b;
        this.d = zzgmVar.c;
        this.e = zzgmVar.d;
        this.f = zzgmVar.h;
        this.B = zzgmVar.e;
        zzx zzxVar = zzgmVar.g;
        if (zzxVar != null && zzxVar.zzw != null) {
            Object obj = zzxVar.zzw.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zzxVar.zzw.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        zzcm.zzr(this.b);
        this.o = DefaultClock.getInstance();
        this.G = this.o.currentTimeMillis();
        this.h = new zzs(this);
        cz czVar = new cz(this);
        czVar.initialize();
        this.i = czVar;
        zzef zzefVar = new zzef(this);
        zzefVar.initialize();
        this.j = zzefVar;
        zzjs zzjsVar = new zzjs(this);
        zzjsVar.initialize();
        this.m = zzjsVar;
        zzed zzedVar = new zzed(this);
        zzedVar.initialize();
        this.n = zzedVar;
        this.r = new zza(this);
        zzhq zzhqVar = new zzhq(this);
        zzhqVar.initialize();
        this.p = zzhqVar;
        zzgp zzgpVar = new zzgp(this);
        zzgpVar.initialize();
        this.q = zzgpVar;
        zziw zziwVar = new zziw(this);
        zziwVar.initialize();
        this.l = zziwVar;
        zzhl zzhlVar = new zzhl(this);
        zzhlVar.initialize();
        this.s = zzhlVar;
        zzfc zzfcVar = new zzfc(this);
        zzfcVar.initialize();
        this.k = zzfcVar;
        if (zzgmVar.g != null && zzgmVar.g.zzs != 0) {
            z = true;
        }
        boolean z2 = !z;
        zzr zzrVar = this.g;
        if (this.b.getApplicationContext() instanceof Application) {
            zzgp zzq = zzq();
            if (zzq.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzq.getContext().getApplicationContext();
                if (zzq.f4944a == null) {
                    zzq.f4944a = new fb(zzq, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzq.f4944a);
                    application.registerActivityLifecycleCallbacks(zzq.f4944a);
                    zzq.zzab().zzgs().zzao("Registered activity lifecycle callback");
                }
            }
        } else {
            zzab().zzgn().zzao("Application context is not an Application");
        }
        this.k.zza(new dk(this, zzgmVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzgm zzgmVar) {
        zzeh zzgq;
        String concat;
        zzaa().zzo();
        zzs.a();
        zzac zzacVar = new zzac(this);
        zzacVar.initialize();
        this.v = zzacVar;
        zzdy zzdyVar = new zzdy(this, zzgmVar.f);
        zzdyVar.initialize();
        this.w = zzdyVar;
        zzeb zzebVar = new zzeb(this);
        zzebVar.initialize();
        this.t = zzebVar;
        zzhv zzhvVar = new zzhv(this);
        zzhvVar.initialize();
        this.u = zzhvVar;
        this.m.zzbj();
        this.i.zzbj();
        this.x = new zzeu(this);
        this.w.zzbj();
        zzab().zzgq().zza("App measurement is starting up, version", Long.valueOf(this.h.zzao()));
        zzr zzrVar = this.g;
        zzab().zzgq().zzao("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzr zzrVar2 = this.g;
        String c = zzdyVar.c();
        if (TextUtils.isEmpty(this.c)) {
            if (zzz().f(c)) {
                zzgq = zzab().zzgq();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzgq = zzab().zzgq();
                String valueOf = String.valueOf(c);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            zzgq.zzao(concat);
        }
        zzab().zzgr().zzao("Debug-level message logging enabled");
        if (this.E != this.F.get()) {
            zzab().zzgk().zza("Not all components initialized", Integer.valueOf(this.E), Integer.valueOf(this.F.get()));
        }
        this.y = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        zzaa().zzo();
        if (zzac().c.get() == 0) {
            zzac().c.set(this.o.currentTimeMillis());
        }
        if (Long.valueOf(zzac().h.get()).longValue() == 0) {
            zzab().zzgs().zza("Persisting first open", Long.valueOf(this.G));
            zzac().h.set(this.G);
        }
        if (!g()) {
            if (isEnabled()) {
                if (!zzz().d("android.permission.INTERNET")) {
                    zzab().zzgk().zzao("App is missing INTERNET permission");
                }
                if (!zzz().d("android.permission.ACCESS_NETWORK_STATE")) {
                    zzab().zzgk().zzao("App is missing ACCESS_NETWORK_STATE permission");
                }
                zzr zzrVar = this.g;
                if (!Wrappers.packageManager(this.b).isCallerInstantApp() && !this.h.b()) {
                    if (!zzez.zzl(this.b)) {
                        zzab().zzgk().zzao("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzjs.a(this.b, false)) {
                        zzab().zzgk().zzao("AppMeasurementService not registered/enabled");
                    }
                }
                zzab().zzgk().zzao("Uploading is not possible. App measurement disabled");
            }
        } else {
            zzr zzrVar2 = this.g;
            if (!TextUtils.isEmpty(zzr().d()) || !TextUtils.isEmpty(zzr().e())) {
                zzz();
                if (zzjs.a(zzr().d(), zzac().c(), zzr().e(), zzac().d())) {
                    zzab().zzgq().zzao("Rechecking which service to use due to a GMP App Id change");
                    zzac().f();
                    zzu().resetAnalyticsData();
                    this.u.disconnect();
                    this.u.f();
                    zzac().h.set(this.G);
                    zzac().j.zzau(null);
                }
                zzac().c(zzr().d());
                zzac().d(zzr().e());
            }
            zzq().a(zzac().j.zzho());
            zzr zzrVar3 = this.g;
            if (!TextUtils.isEmpty(zzr().d()) || !TextUtils.isEmpty(zzr().e())) {
                boolean isEnabled = isEnabled();
                if (!zzac().j() && !this.h.zzbp()) {
                    zzac().d(!isEnabled);
                }
                if (isEnabled) {
                    zzq().zzim();
                }
                zzs().zza(new AtomicReference<>());
            }
        }
        zzac().o.set(this.h.zza(zzak.zziu));
        zzac().p.set(this.h.zza(zzak.zziv));
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final zzr zzae() {
        return this.g;
    }

    public final zzs zzad() {
        return this.h;
    }

    public final cz zzac() {
        a((ef) this.i);
        return this.i;
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final zzef zzab() {
        b(this.j);
        return this.j;
    }

    public final zzef zzhs() {
        zzef zzefVar = this.j;
        if (zzefVar == null || !zzefVar.k()) {
            return null;
        }
        return this.j;
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final zzfc zzaa() {
        b(this.k);
        return this.k;
    }

    public final zziw zzv() {
        b(this.l);
        return this.l;
    }

    public final zzeu zzht() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfc b() {
        return this.k;
    }

    public final zzgp zzq() {
        b(this.q);
        return this.q;
    }

    public final zzjs zzz() {
        a((ef) this.m);
        return this.m;
    }

    public final zzed zzy() {
        a((ef) this.n);
        return this.n;
    }

    public final zzeb zzu() {
        b(this.t);
        return this.t;
    }

    private final zzhl h() {
        b(this.s);
        return this.s;
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final Context getContext() {
        return this.b;
    }

    public final boolean zzhw() {
        return TextUtils.isEmpty(this.c);
    }

    public final String zzhx() {
        return this.c;
    }

    public final String zzhy() {
        return this.d;
    }

    public final String zzhz() {
        return this.e;
    }

    public final boolean zzia() {
        return this.f;
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final Clock zzx() {
        return this.o;
    }

    public final zzhq zzt() {
        b(this.p);
        return this.p;
    }

    public final zzhv zzs() {
        b(this.u);
        return this.u;
    }

    public final zzac zzw() {
        b(this.v);
        return this.v;
    }

    public final zzdy zzr() {
        b(this.w);
        return this.w;
    }

    public final zza zzp() {
        zza zzaVar = this.r;
        if (zzaVar != null) {
            return zzaVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @VisibleForTesting
    public static zzfj zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new zzx(0L, 0L, true, null, null, null, bundle));
    }

    public static zzfj zza(Context context, zzx zzxVar) {
        if (zzxVar != null && (zzxVar.origin == null || zzxVar.zzv == null)) {
            zzxVar = new zzx(zzxVar.zzr, zzxVar.zzs, zzxVar.zzt, zzxVar.zzu, null, null, zzxVar.zzw);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f4941a == null) {
            synchronized (zzfj.class) {
                if (f4941a == null) {
                    f4941a = new zzfj(new zzgm(context, zzxVar));
                }
            }
        } else if (zzxVar != null && zzxVar.zzw != null && zzxVar.zzw.containsKey("dataCollectionDefaultEnabled")) {
            f4941a.a(zzxVar.zzw.getBoolean("dataCollectionDefaultEnabled"));
        }
        return f4941a;
    }

    private final void i() {
        if (!this.y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void b(ee eeVar) {
        if (eeVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (eeVar.k()) {
            return;
        }
        String valueOf = String.valueOf(eeVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void b(dz dzVar) {
        if (dzVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (dzVar.i()) {
            return;
        }
        String valueOf = String.valueOf(dzVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void a(ef efVar) {
        if (efVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.B = Boolean.valueOf(z);
    }

    public final boolean zzib() {
        return this.B != null && this.B.booleanValue();
    }

    public final boolean isEnabled() {
        boolean z;
        zzaa().zzo();
        i();
        if (this.h.zza(zzak.zzil)) {
            if (this.h.zzbp()) {
                return false;
            }
            Boolean bool = this.D;
            if (bool != null && bool.booleanValue()) {
                return false;
            }
            Boolean g = zzac().g();
            if (g != null) {
                return g.booleanValue();
            }
            Boolean zzbq = this.h.zzbq();
            if (zzbq != null) {
                return zzbq.booleanValue();
            }
            Boolean bool2 = this.C;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                return false;
            }
            if (!this.h.zza(zzak.zzig) || this.B == null) {
                return true;
            }
            return this.B.booleanValue();
        }
        if (this.h.zzbp()) {
            return false;
        }
        Boolean zzbq2 = this.h.zzbq();
        if (zzbq2 != null) {
            z = zzbq2.booleanValue();
        } else {
            z = !GoogleServices.isMeasurementExplicitlyDisabled();
            if (z && this.B != null && zzak.zzig.get(null).booleanValue()) {
                z = this.B.booleanValue();
            }
        }
        return zzac().c(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long c() {
        Long valueOf = Long.valueOf(zzac().h.get());
        if (valueOf.longValue() == 0) {
            return this.G;
        }
        return Math.min(this.G, valueOf.longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        zzr zzrVar = this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        zzr zzrVar = this.g;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ee eeVar) {
        this.E++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(dz dzVar) {
        this.E++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        this.F.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g() {
        i();
        zzaa().zzo();
        Boolean bool = this.z;
        if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.o.elapsedRealtime() - this.A) > 1000)) {
            this.A = this.o.elapsedRealtime();
            zzr zzrVar = this.g;
            boolean z = true;
            this.z = Boolean.valueOf(zzz().d("android.permission.INTERNET") && zzz().d("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.b).isCallerInstantApp() || this.h.b() || (zzez.zzl(this.b) && zzjs.a(this.b, false))));
            if (this.z.booleanValue()) {
                if (!zzz().c(zzr().d(), zzr().e()) && TextUtils.isEmpty(zzr().e())) {
                    z = false;
                }
                this.z = Boolean.valueOf(z);
            }
        }
        return this.z.booleanValue();
    }

    public final void zza(final zzp zzpVar) {
        zzaa().zzo();
        b(h());
        String c = zzr().c();
        Pair<String, Boolean> a2 = zzac().a(c);
        if (!this.h.zzbr().booleanValue() || ((Boolean) a2.second).booleanValue()) {
            zzab().zzgr().zzao("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            zzz().zzb(zzpVar, "");
            return;
        }
        if (!h().zzgv()) {
            zzab().zzgn().zzao("Network is not available for Deferred Deep Link request. Skipping");
            zzz().zzb(zzpVar, "");
            return;
        }
        URL zza = zzz().zza(zzr().zzad().zzao(), c, (String) a2.first);
        zzhl h = h();
        fc fcVar = new fc(this, zzpVar) { // from class: com.google.android.gms.measurement.internal.dj

            /* renamed from: a, reason: collision with root package name */
            private final zzfj f4807a;
            private final zzp b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4807a = this;
                this.b = zzpVar;
            }

            @Override // com.google.android.gms.measurement.internal.fc
            public final void a(String str, int i, Throwable th, byte[] bArr, Map map) {
                this.f4807a.a(this.b, str, i, th, bArr, map);
            }
        };
        h.zzo();
        h.l();
        Preconditions.checkNotNull(zza);
        Preconditions.checkNotNull(fcVar);
        h.zzaa().zzb(new fe(h, c, zza, null, null, fcVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzp zzpVar, String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzab().zzgn().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            zzz().zzb(zzpVar, "");
            return;
        }
        if (bArr.length == 0) {
            zzz().zzb(zzpVar, "");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString(Constants.DEEPLINK, "");
            String optString2 = jSONObject.optString("gclid", "");
            zzjs zzz = zzz();
            zzz.zzm();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzz.getContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzab().zzgn().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                zzz().zzb(zzpVar, "");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.DEEPLINK, optString);
            bundle.putString("gclid", optString2);
            this.q.logEvent("auto", "_cmp", bundle);
            zzz().zzb(zzpVar, optString);
        } catch (JSONException e) {
            zzab().zzgk().zza("Failed to parse the Deferred Deep Link response. exception", e);
            zzz().zzb(zzpVar, "");
        }
    }
}
