package com.google.android.gms.internal.ads;

import android.location.Location;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.tencent.connect.common.Constants;
import com.uqm.crashsight.CrashSight;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzans implements NativeMediationAdRequest {

    /* renamed from: a, reason: collision with root package name */
    private final Date f2768a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final zzady g;
    private final boolean i;
    private final int k;
    private final String l;
    private final List<String> h = new ArrayList();
    private final Map<String, Boolean> j = new HashMap();

    public zzans(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzady zzadyVar, List<String> list, boolean z2, int i3, String str) {
        this.f2768a = date;
        this.b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = zzadyVar;
        this.i = z2;
        this.k = i3;
        this.l = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(CertificateUtil.DELIMITER, 3);
                    if (split.length == 3) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(split[2])) {
                            this.j.put(split[1], true);
                        } else if (CrashSight.SDK_IS_DEV.equals(split[2])) {
                            this.j.put(split[1], false);
                        }
                    }
                } else {
                    this.h.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.f2768a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.f;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        if (this.g == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.g.zzcym).setImageOrientation(this.g.zzbqc).setRequestMultipleImages(this.g.zzbqe);
        if (this.g.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.g.zzbqf);
        }
        if (this.g.versionCode >= 3 && this.g.zzcyn != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.g.zzcyn));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzabe.zzqf().zzpr();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzabe.zzqf().zzpq();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.h;
        if (list != null) {
            return list.contains("2") || this.h.contains(Constants.VIA_SHARE_TYPE_INFO);
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.h;
        return list != null && list.contains(Constants.VIA_SHARE_TYPE_INFO);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.h;
        if (list != null) {
            return list.contains("1") || this.h.contains(Constants.VIA_SHARE_TYPE_INFO);
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzsu() {
        List<String> list = this.h;
        return list != null && list.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzsv() {
        return this.j;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.i;
    }
}
