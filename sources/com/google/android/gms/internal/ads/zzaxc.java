package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes.dex */
public final class zzaxc implements zzaxb {
    private boolean b;
    private zzbbh<?> d;

    @GuardedBy("lock")
    @Nullable
    private SharedPreferences f;

    @GuardedBy("lock")
    @Nullable
    private SharedPreferences.Editor g;

    @GuardedBy("lock")
    @Nullable
    private String j;

    @GuardedBy("lock")
    @Nullable
    private String k;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2822a = new Object();
    private final List<Runnable> c = new ArrayList();

    @GuardedBy("lock")
    @Nullable
    private zzuu e = null;

    @GuardedBy("lock")
    private boolean h = false;

    @GuardedBy("lock")
    private boolean i = true;

    @GuardedBy("lock")
    private boolean l = false;

    @GuardedBy("lock")
    private String m = "";

    @GuardedBy("lock")
    private long n = 0;

    @GuardedBy("lock")
    private long o = 0;

    @GuardedBy("lock")
    private long p = 0;

    @GuardedBy("lock")
    private int q = -1;

    @GuardedBy("lock")
    private int r = 0;

    @GuardedBy("lock")
    private Set<String> s = Collections.emptySet();

    @GuardedBy("lock")
    private JSONObject t = new JSONObject();

    @GuardedBy("lock")
    private boolean u = true;

    @GuardedBy("lock")
    private boolean v = true;

    @GuardedBy("lock")
    private String w = null;

    public final void zza(final Context context, String str, boolean z) {
        final String concat;
        if (str == null) {
            concat = "admob";
        } else {
            String valueOf = String.valueOf("admob__");
            String valueOf2 = String.valueOf(str);
            concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.d = zzaxg.zzc(new Runnable(this, context, concat) { // from class: com.google.android.gms.internal.ads.fk

            /* renamed from: a, reason: collision with root package name */
            private final zzaxc f2173a;
            private final Context b;
            private final String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2173a = this;
                this.b = context;
                this.c = concat;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2173a.a(this.b, this.c);
            }
        });
        this.b = z;
    }

    private final void a() {
        zzbbh<?> zzbbhVar = this.d;
        if (zzbbhVar == null || zzbbhVar.isDone()) {
            return;
        }
        try {
            this.d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzawz.zzd("Interrupted while waiting for preferences loaded.", e);
        } catch (CancellationException e2) {
            e = e2;
            zzawz.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e3) {
            e = e3;
            zzawz.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e4) {
            e = e4;
            zzawz.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.f2822a) {
            bundle.putBoolean("use_https", this.i);
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            bundle.putBoolean("auto_collect_location", this.l);
            bundle.putInt("version_code", this.r);
            bundle.putStringArray("never_pool_slots", (String[]) this.s.toArray(new String[0]));
            bundle.putString("app_settings_json", this.m);
            bundle.putLong("app_settings_last_update_ms", this.n);
            bundle.putLong("app_last_background_time_ms", this.o);
            bundle.putInt("request_in_session_count", this.q);
            bundle.putLong("first_ad_req_time_ms", this.p);
            bundle.putString("native_advanced_settings", this.t.toString());
            bundle.putString("display_cutout", this.w);
            if (this.j != null) {
                bundle.putString("content_url_hashes", this.j);
            }
            if (this.k != null) {
                bundle.putString("content_vertical_hashes", this.k);
            }
        }
        return bundle;
    }

    private final void a(Bundle bundle) {
        zzaxg.zzdvp.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.fl

            /* renamed from: a, reason: collision with root package name */
            private final zzaxc f2174a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2174a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2174a.zzvk();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    @Nullable
    public final zzuu zzvk() {
        if (!this.b || !PlatformVersion.isAtLeastIceCreamSandwich()) {
            return null;
        }
        if (zzvl() && zzvn()) {
            return null;
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcna)).booleanValue()) {
            return null;
        }
        synchronized (this.f2822a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.e == null) {
                this.e = new zzuu();
            }
            this.e.zzmv();
            zzawz.zzeo("start fetching content...");
            return this.e;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzai(boolean z) {
        a();
        synchronized (this.f2822a) {
            if (this.u == z) {
                return;
            }
            this.u = z;
            if (this.g != null) {
                this.g.putBoolean("content_url_opted_out", z);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final boolean zzvl() {
        boolean z;
        a();
        synchronized (this.f2822a) {
            z = this.u;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzdt(@Nullable String str) {
        a();
        synchronized (this.f2822a) {
            if (str != null) {
                if (!str.equals(this.j)) {
                    this.j = str;
                    if (this.g != null) {
                        this.g.putString("content_url_hashes", str);
                        this.g.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_url_hashes", str);
                    a(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    @Nullable
    public final String zzvm() {
        String str;
        a();
        synchronized (this.f2822a) {
            str = this.j;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzaj(boolean z) {
        a();
        synchronized (this.f2822a) {
            if (this.v == z) {
                return;
            }
            this.v = z;
            if (this.g != null) {
                this.g.putBoolean("content_vertical_opted_out", z);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final boolean zzvn() {
        boolean z;
        a();
        synchronized (this.f2822a) {
            z = this.v;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzdu(@Nullable String str) {
        a();
        synchronized (this.f2822a) {
            if (str != null) {
                if (!str.equals(this.k)) {
                    this.k = str;
                    if (this.g != null) {
                        this.g.putString("content_vertical_hashes", str);
                        this.g.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_vertical_hashes", str);
                    a(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    @Nullable
    public final String zzvo() {
        String str;
        a();
        synchronized (this.f2822a) {
            str = this.k;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzak(boolean z) {
        a();
        synchronized (this.f2822a) {
            if (this.l == z) {
                return;
            }
            this.l = z;
            if (this.g != null) {
                this.g.putBoolean("auto_collect_location", z);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final boolean zzvp() {
        boolean z;
        a();
        synchronized (this.f2822a) {
            z = this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzct(int i) {
        a();
        synchronized (this.f2822a) {
            if (this.r == i) {
                return;
            }
            this.r = i;
            if (this.g != null) {
                this.g.putInt("version_code", i);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final int zzvq() {
        int i;
        a();
        synchronized (this.f2822a) {
            i = this.r;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzdv(String str) {
        a();
        synchronized (this.f2822a) {
            long currentTimeMillis = zzk.zzln().currentTimeMillis();
            this.n = currentTimeMillis;
            if (str != null && !str.equals(this.m)) {
                this.m = str;
                if (this.g != null) {
                    this.g.putString("app_settings_json", str);
                    this.g.putLong("app_settings_last_update_ms", currentTimeMillis);
                    this.g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", str);
                bundle.putLong("app_settings_last_update_ms", currentTimeMillis);
                a(bundle);
                Iterator<Runnable> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final zzawl zzvr() {
        zzawl zzawlVar;
        a();
        synchronized (this.f2822a) {
            zzawlVar = new zzawl(this.m, this.n);
        }
        return zzawlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzb(Runnable runnable) {
        this.c.add(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzfc(long j) {
        a();
        synchronized (this.f2822a) {
            if (this.o == j) {
                return;
            }
            this.o = j;
            if (this.g != null) {
                this.g.putLong("app_last_background_time_ms", j);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final long zzvs() {
        long j;
        a();
        synchronized (this.f2822a) {
            j = this.o;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzcu(int i) {
        a();
        synchronized (this.f2822a) {
            if (this.q == i) {
                return;
            }
            this.q = i;
            if (this.g != null) {
                this.g.putInt("request_in_session_count", i);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final int zzvt() {
        int i;
        a();
        synchronized (this.f2822a) {
            i = this.q;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzfd(long j) {
        a();
        synchronized (this.f2822a) {
            if (this.p == j) {
                return;
            }
            this.p = j;
            if (this.g != null) {
                this.g.putLong("first_ad_req_time_ms", j);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final long zzvu() {
        long j;
        a();
        synchronized (this.f2822a) {
            j = this.p;
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzc(String str, String str2, boolean z) {
        a();
        synchronized (this.f2822a) {
            JSONArray optJSONArray = this.t.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null) {
                    return;
                }
                if (str2.equals(optJSONObject.optString("template_id"))) {
                    if (z && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzk.zzln().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.t.put(str, optJSONArray);
            } catch (JSONException e) {
                zzawz.zzd("Could not update native advanced settings", e);
            }
            if (this.g != null) {
                this.g.putString("native_advanced_settings", this.t.toString());
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.t.toString());
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final JSONObject zzvv() {
        JSONObject jSONObject;
        a();
        synchronized (this.f2822a) {
            jSONObject = this.t;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzvw() {
        a();
        synchronized (this.f2822a) {
            this.t = new JSONObject();
            if (this.g != null) {
                this.g.remove("native_advanced_settings");
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final String zzvx() {
        String str;
        a();
        synchronized (this.f2822a) {
            str = this.w;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void zzdw(String str) {
        a();
        synchronized (this.f2822a) {
            if (TextUtils.equals(this.w, str)) {
                return;
            }
            this.w = str;
            if (this.g != null) {
                this.g.putString("display_cutout", str);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("display_cutout", str);
            a(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.f2822a) {
            this.f = sharedPreferences;
            this.g = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.h = z;
            this.i = this.f.getBoolean("use_https", this.i);
            this.u = this.f.getBoolean("content_url_opted_out", this.u);
            this.j = this.f.getString("content_url_hashes", this.j);
            this.l = this.f.getBoolean("auto_collect_location", this.l);
            this.v = this.f.getBoolean("content_vertical_opted_out", this.v);
            this.k = this.f.getString("content_vertical_hashes", this.k);
            this.r = this.f.getInt("version_code", this.r);
            this.m = this.f.getString("app_settings_json", this.m);
            this.n = this.f.getLong("app_settings_last_update_ms", this.n);
            this.o = this.f.getLong("app_last_background_time_ms", this.o);
            this.q = this.f.getInt("request_in_session_count", this.q);
            this.p = this.f.getLong("first_ad_req_time_ms", this.p);
            this.s = this.f.getStringSet("never_pool_slots", this.s);
            this.w = this.f.getString("display_cutout", this.w);
            try {
                this.t = new JSONObject(this.f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzawz.zzd("Could not convert native advanced settings to json object", e);
            }
            a(b());
        }
    }
}
