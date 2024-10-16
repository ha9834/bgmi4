package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class zzcrh implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcxv f3392a;

    public zzcrh(zzcxv zzcxvVar) {
        Preconditions.checkNotNull(zzcxvVar, "the targeting must not be null");
        this.f3392a = zzcxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzxz zzxzVar = this.f3392a.zzghg;
        bundle2.putString("slotname", this.f3392a.zzglb);
        if (this.f3392a.zzglj.contains("new_rewarded")) {
            bundle2.putBoolean("is_new_rewarded", true);
        }
        zzcxz.zza(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzxzVar.zzcgn)), zzxzVar.zzcgn != -1);
        zzcxz.zza(bundle2, AppLinkData.ARGUMENTS_EXTRAS_KEY, zzxzVar.extras);
        zzcxz.zza(bundle2, "cust_gender", Integer.valueOf(zzxzVar.zzcgo), zzxzVar.zzcgo != -1);
        zzcxz.zza(bundle2, "kw", zzxzVar.zzcgp);
        zzcxz.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzxzVar.zzcgr), zzxzVar.zzcgr != -1);
        if (zzxzVar.zzcgq) {
            bundle2.putBoolean("test_request", zzxzVar.zzcgq);
        }
        zzcxz.zza(bundle2, "d_imp_hdr", (Integer) 1, zzxzVar.versionCode >= 2 && zzxzVar.zzbqn);
        zzcxz.zza(bundle2, "ppid", zzxzVar.zzcgs, zzxzVar.versionCode >= 2 && !TextUtils.isEmpty(zzxzVar.zzcgs));
        if (zzxzVar.zzmw != null) {
            Location location = zzxzVar.zzmw;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong("lat", valueOf3.longValue());
            bundle3.putLong(Constants.LONG, valueOf4.longValue());
            bundle3.putLong("time", valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzcxz.zza(bundle2, "url", zzxzVar.zzcgu);
        zzcxz.zza(bundle2, "custom_targeting", zzxzVar.zzcgw);
        zzcxz.zza(bundle2, "category_exclusions", zzxzVar.zzcgx);
        zzcxz.zza(bundle2, "request_agent", zzxzVar.zzcgy);
        zzcxz.zza(bundle2, "request_pkg", zzxzVar.zzcgz);
        zzcxz.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzxzVar.zzcha), zzxzVar.versionCode >= 7);
        if (zzxzVar.versionCode >= 8) {
            zzcxz.zza(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzxzVar.zzchc), zzxzVar.zzchc != -1);
            zzcxz.zza(bundle2, "max_ad_content_rating", zzxzVar.zzchd);
        }
    }
}
