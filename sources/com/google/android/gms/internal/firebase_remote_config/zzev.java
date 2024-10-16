package com.google.android.gms.internal.firebase_remote_config;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;

/* loaded from: classes2.dex */
public final class zzev {

    /* renamed from: a, reason: collision with root package name */
    private static final Date f4164a = new Date(-1);
    public static final Date zzln = new Date(-1);
    private final SharedPreferences b;
    private final Object c = new Object();
    private final Object d = new Object();

    public zzev(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
    }

    public final boolean isDeveloperModeEnabled() {
        return this.b.getBoolean("is_developer_mode_enabled", false);
    }

    public final long getFetchTimeoutInSeconds() {
        return this.b.getLong("fetch_timeout_in_seconds", 5L);
    }

    public final long getMinimumFetchIntervalInSeconds() {
        return this.b.getLong("minimum_fetch_interval_in_seconds", zzeq.zzkv);
    }

    public final Date zzcz() {
        return new Date(this.b.getLong("last_fetch_time_in_millis", -1L));
    }

    public final String zzda() {
        return this.b.getString("last_fetch_etag", null);
    }

    public final void zzb(boolean z) {
        synchronized (this.c) {
            this.b.edit().putBoolean("is_developer_mode_enabled", z).apply();
        }
    }

    public final void zzc(long j) {
        synchronized (this.c) {
            this.b.edit().putLong("fetch_timeout_in_seconds", j).apply();
        }
    }

    public final void zzd(long j) {
        synchronized (this.c) {
            this.b.edit().putLong("minimum_fetch_interval_in_seconds", j).apply();
        }
    }

    public final void zzm(int i) {
        synchronized (this.c) {
            this.b.edit().putInt("last_fetch_status", i).apply();
        }
    }

    public final void zzd(Date date) {
        synchronized (this.c) {
            this.b.edit().putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    public final void zzbd(String str) {
        this.b.edit().putString("last_fetch_etag", str).apply();
    }

    public final void clear() {
        this.b.edit().clear().commit();
    }

    public final FirebaseRemoteConfigInfo getInfo() {
        zzez zzde;
        synchronized (this.c) {
            long j = this.b.getLong("last_fetch_time_in_millis", -1L);
            int i = this.b.getInt("last_fetch_status", 0);
            zzde = new zzfb().a(i).zze(j).a(new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(this.b.getBoolean("is_developer_mode_enabled", false)).setFetchTimeoutInSeconds(this.b.getLong("fetch_timeout_in_seconds", 5L)).setMinimumFetchIntervalInSeconds(this.b.getLong("minimum_fetch_interval_in_seconds", zzeq.zzkv)).build()).zzde();
        }
        return zzde;
    }

    public final av zzdb() {
        av avVar;
        synchronized (this.d) {
            avVar = new av(this.b.getInt("num_failed_fetches", 0), new Date(this.b.getLong("backoff_end_time_in_millis", -1L)));
        }
        return avVar;
    }

    public final void zza(int i, Date date) {
        synchronized (this.d) {
            this.b.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }
}
