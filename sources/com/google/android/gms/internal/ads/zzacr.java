package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzacr implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context g;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2699a = new Object();
    private final ConditionVariable b = new ConditionVariable();
    private volatile boolean c = false;

    @VisibleForTesting
    private volatile boolean d = false;
    private SharedPreferences e = null;
    private Bundle f = new Bundle();
    private JSONObject h = new JSONObject();

    public final void initialize(Context context) {
        if (this.c) {
            return;
        }
        synchronized (this.f2699a) {
            if (this.c) {
                return;
            }
            if (!this.d) {
                this.d = true;
            }
            this.g = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                this.f = Wrappers.packageManager(this.g).getApplicationInfo(this.g.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                    remoteContext = context;
                }
                if (remoteContext == null) {
                    return;
                }
                zzyt.zzpc();
                this.e = remoteContext.getSharedPreferences("google_ads_flags", 0);
                if (this.e != null) {
                    this.e.registerOnSharedPreferenceChangeListener(this);
                }
                b();
                this.c = true;
            } finally {
                this.d = false;
                this.b.open();
            }
        }
    }

    public final <T> T zzd(zzacj<T> zzacjVar) {
        if (!this.b.block(5000L)) {
            synchronized (this.f2699a) {
                if (!this.d) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.c || this.e == null) {
            synchronized (this.f2699a) {
                if (this.c && this.e != null) {
                }
                return zzacjVar.zzqm();
            }
        }
        if (zzacjVar.getSource() == 2) {
            Bundle bundle = this.f;
            if (bundle == null) {
                return zzacjVar.zzqm();
            }
            return zzacjVar.zza(bundle);
        }
        if (zzacjVar.getSource() == 1 && this.h.has(zzacjVar.getKey())) {
            return zzacjVar.a(this.h);
        }
        return (T) zzazl.zza(this.g, new r(this, zzacjVar));
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            b();
        }
    }

    private final void b() {
        if (this.e == null) {
            return;
        }
        try {
            this.h = new JSONObject((String) zzazl.zza(this.g, new Callable(this) { // from class: com.google.android.gms.internal.ads.q

                /* renamed from: a, reason: collision with root package name */
                private final zzacr f2430a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2430a = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2430a.a();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String a() throws Exception {
        return this.e.getString("flag_configuration", "{}");
    }
}
