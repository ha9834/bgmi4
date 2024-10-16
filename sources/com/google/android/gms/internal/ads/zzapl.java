package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

@zzard
/* loaded from: classes2.dex */
public final class zzapl implements MediationInterstitialAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f2774a;
    private MediationInterstitialListener b;
    private Uri c;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = mediationInterstitialListener;
        if (this.b == null) {
            zzbad.zzep("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzbad.zzep("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.b.onAdFailedToLoad(this, 0);
            return;
        }
        if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzads.zzj(context))) {
            zzbad.zzep("Default browser does not support custom tabs. Bailing out.");
            this.b.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            zzbad.zzep("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.b.onAdFailedToLoad(this, 0);
        } else {
            this.f2774a = (Activity) context;
            this.c = Uri.parse(string);
            this.b.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        androidx.browser.customtabs.c a2 = new c.a().a();
        a2.f400a.setData(this.c);
        zzaxi.zzdvv.post(new dp(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzc(a2.f400a), null, new Cdo(this), null, new zzbai(0, 0, false))));
        zzk.zzlk().zzuy();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbad.zzdp("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbad.zzdp("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbad.zzdp("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
