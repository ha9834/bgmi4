package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzawr {

    @VisibleForTesting
    private final String g;
    private final zzaxb h;

    @VisibleForTesting
    private long b = -1;

    @VisibleForTesting
    private long c = -1;

    @VisibleForTesting
    @GuardedBy("lock")
    private int d = -1;

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    int f2817a = -1;

    @VisibleForTesting
    private long e = 0;
    private final Object f = new Object();

    @VisibleForTesting
    @GuardedBy("lock")
    private int i = 0;

    @VisibleForTesting
    @GuardedBy("lock")
    private int j = 0;

    public zzawr(String str, zzaxb zzaxbVar) {
        this.g = str;
        this.h = zzaxbVar;
    }

    public final void zzuk() {
        synchronized (this.f) {
            this.i++;
        }
    }

    public final void zzuj() {
        synchronized (this.f) {
            this.j++;
        }
    }

    public final void zza(zzxz zzxzVar, long j) {
        synchronized (this.f) {
            long zzvs = this.h.zzvs();
            long currentTimeMillis = zzk.zzln().currentTimeMillis();
            if (this.c == -1) {
                if (currentTimeMillis - zzvs > ((Long) zzyt.zzpe().zzd(zzacu.zzcoy)).longValue()) {
                    this.f2817a = -1;
                } else {
                    this.f2817a = this.h.zzvt();
                }
                this.c = j;
                this.b = this.c;
            } else {
                this.b = j;
            }
            if (zzxzVar == null || zzxzVar.extras == null || zzxzVar.extras.getInt("gw", 2) != 1) {
                this.d++;
                this.f2817a++;
                if (this.f2817a == 0) {
                    this.e = 0L;
                    this.h.zzfd(currentTimeMillis);
                } else {
                    this.e = currentTimeMillis - this.h.zzvu();
                }
            }
        }
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.f) {
            bundle = new Bundle();
            bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.g);
            bundle.putLong("basets", this.c);
            bundle.putLong("currts", this.b);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.d);
            bundle.putInt("preqs_in_session", this.f2817a);
            bundle.putLong("time_in_session", this.e);
            bundle.putInt("pclick", this.i);
            bundle.putInt("pimp", this.j);
            bundle.putBoolean("support_transparent_background", a(context));
        }
        return bundle;
    }

    private static boolean a(Context context) {
        Context zzw = zzasq.zzw(context);
        int identifier = zzw.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            zzawz.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzw.getPackageManager().getActivityInfo(new ComponentName(zzw.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzawz.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzawz.zzep("Fail to fetch AdActivity theme");
            zzawz.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
