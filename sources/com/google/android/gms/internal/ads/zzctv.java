package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzctv implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3434a;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) || set.contains("banner");
    }

    public zzctv(String str) {
        this.f3434a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        zzcxz.zza(bundle, "omid_v", this.f3434a);
    }
}
