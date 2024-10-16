package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cz extends ee {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final Pair<String, Long> f4797a = new Pair<>("", 0L);
    public zzes b;
    public final zzet c;
    public final zzet d;
    public final zzet e;
    public final zzet f;
    public final zzet g;
    public final zzet h;
    public final zzet i;
    public final zzev j;
    public final zzet k;
    public final zzet l;
    public final zzeq m;
    public final zzev n;
    public final zzeq o;
    public final zzeq p;
    public final zzet q;
    public final zzet r;
    public boolean s;
    public zzeq t;
    public zzet u;
    private SharedPreferences w;
    private String x;
    private boolean y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> a(String str) {
        zzo();
        long elapsedRealtime = zzx().elapsedRealtime();
        String str2 = this.x;
        if (str2 != null && elapsedRealtime < this.z) {
            return new Pair<>(str2, Boolean.valueOf(this.y));
        }
        this.z = elapsedRealtime + zzad().zza(str, zzak.zzgg);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.x = advertisingIdInfo.getId();
                this.y = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.x == null) {
                this.x = "";
            }
        } catch (Exception e) {
            zzab().zzgr().zza("Unable to get advertising id", e);
            this.x = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.x, Boolean.valueOf(this.y));
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b(String str) {
        zzo();
        String str2 = (String) a(str).first;
        MessageDigest d = zzjs.d();
        if (d == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, d.digest(str2.getBytes())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(zzfj zzfjVar) {
        super(zzfjVar);
        this.c = new zzet(this, "last_upload", 0L);
        this.d = new zzet(this, "last_upload_attempt", 0L);
        this.e = new zzet(this, "backoff", 0L);
        this.f = new zzet(this, "last_delete_stale", 0L);
        this.k = new zzet(this, "time_before_start", LogUtils.LOG_FUSE_TIME);
        this.l = new zzet(this, "session_timeout", 1800000L);
        this.m = new zzeq(this, "start_new_session", true);
        this.q = new zzet(this, "last_pause_time", 0L);
        this.r = new zzet(this, "time_active", 0L);
        this.n = new zzev(this, "non_personalized_ads", null);
        this.o = new zzeq(this, "use_dynamite_api", false);
        this.p = new zzeq(this, "allow_remote_dynamite", false);
        this.g = new zzet(this, "midnight_offset", 0L);
        this.h = new zzet(this, "first_open_time", 0L);
        this.i = new zzet(this, "app_install_time", 0L);
        this.j = new zzev(this, "app_instance_id", null);
        this.t = new zzeq(this, "app_backgrounded", false);
        this.u = new zzet(this, "deep_link_last_retrieved", -1L);
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final void b() {
        this.w = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.s = this.w.getBoolean("has_been_opened", false);
        if (!this.s) {
            SharedPreferences.Editor edit = this.w.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.b = new zzes(this, "health_monitor", Math.max(0L, zzak.zzgh.get(null).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences m() {
        zzo();
        l();
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str) {
        zzo();
        SharedPreferences.Editor edit = m().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        zzo();
        return m().getString("gmp_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        zzo();
        SharedPreferences.Editor edit = m().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        zzo();
        return m().getString("admob_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean e() {
        zzo();
        if (m().contains("use_service")) {
            return Boolean.valueOf(m().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        zzo();
        zzab().zzgs().zza("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        zzo();
        zzab().zzgs().zzao("Clearing collection preferences.");
        if (zzad().zza(zzak.zzil)) {
            Boolean g = g();
            SharedPreferences.Editor edit = m().edit();
            edit.clear();
            edit.apply();
            if (g != null) {
                b(g.booleanValue());
                return;
            }
            return;
        }
        boolean contains = m().contains("measurement_enabled");
        boolean c = contains ? c(true) : true;
        SharedPreferences.Editor edit2 = m().edit();
        edit2.clear();
        edit2.apply();
        if (contains) {
            b(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(boolean z) {
        zzo();
        zzab().zzgs().zza("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(boolean z) {
        zzo();
        return m().getBoolean("measurement_enabled", z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean g() {
        zzo();
        if (m().contains("measurement_enabled")) {
            return Boolean.valueOf(m().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String h() {
        zzo();
        String string = m().getString("previous_os_version", null);
        zzw().l();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = m().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(boolean z) {
        zzo();
        zzab().zzgs().zza("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        zzo();
        return m().getBoolean("deferred_analytics_collection", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j() {
        return this.w.contains("deferred_analytics_collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(long j) {
        return j - this.l.get() > this.q.get();
    }
}
