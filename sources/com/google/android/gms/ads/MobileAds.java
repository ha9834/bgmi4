package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzabe;
import com.google.android.gms.internal.ads.zzabi;

/* loaded from: classes.dex */
public class MobileAds {
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzabe.zzqf().zza(context, str, settings == null ? null : settings.a(), null);
    }

    /* loaded from: classes.dex */
    public static final class Settings {

        /* renamed from: a, reason: collision with root package name */
        private final zzabi f1126a = new zzabi();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        final zzabi a() {
            return this.f1126a;
        }
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzabe.zzqf().getRewardedVideoAdInstance(context);
    }

    public static void setAppVolume(float f) {
        zzabe.zzqf().setAppVolume(f);
    }

    public static void setAppMuted(boolean z) {
        zzabe.zzqf().setAppMuted(z);
    }

    public static void openDebugMenu(Context context, String str) {
        zzabe.zzqf().openDebugMenu(context, str);
    }

    @KeepForSdk
    public static String getVersionString() {
        return zzabe.zzqf().getVersionString();
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzabe.zzqf().registerRtbAdapter(cls);
    }

    private MobileAds() {
    }
}
