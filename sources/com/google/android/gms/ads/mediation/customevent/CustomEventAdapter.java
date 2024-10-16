package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbad;

@KeepForSdkWithMembers
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a, reason: collision with root package name */
    private View f1173a;

    @VisibleForTesting
    private CustomEventBanner b;

    @VisibleForTesting
    private CustomEventInterstitial c;

    @VisibleForTesting
    private CustomEventNative d;

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbad.zzep(sb.toString());
            return null;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class a implements CustomEventBannerListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1174a;
        private final MediationBannerListener b;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f1174a = customEventAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzbad.zzdp("Custom event adapter called onAdLoaded.");
            this.f1174a.a(view);
            this.b.onAdLoaded(this.f1174a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzbad.zzdp("Custom event adapter called onAdFailedToLoad.");
            this.b.onAdFailedToLoad(this.f1174a, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzbad.zzdp("Custom event adapter called onAdClicked.");
            this.b.onAdClicked(this.f1174a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzbad.zzdp("Custom event adapter called onAdOpened.");
            this.b.onAdOpened(this.f1174a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzbad.zzdp("Custom event adapter called onAdClosed.");
            this.b.onAdClosed(this.f1174a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzbad.zzdp("Custom event adapter called onAdLeftApplication.");
            this.b.onAdLeftApplication(this.f1174a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    class b implements CustomEventInterstitialListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1175a;
        private final MediationInterstitialListener b;

        public b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f1175a = customEventAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onAdLoaded() {
            zzbad.zzdp("Custom event adapter called onReceivedAd.");
            this.b.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onAdFailedToLoad(this.f1175a, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzbad.zzdp("Custom event adapter called onAdClicked.");
            this.b.onAdClicked(this.f1175a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzbad.zzdp("Custom event adapter called onAdOpened.");
            this.b.onAdOpened(this.f1175a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzbad.zzdp("Custom event adapter called onAdClosed.");
            this.b.onAdClosed(this.f1175a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzbad.zzdp("Custom event adapter called onAdLeftApplication.");
            this.b.onAdLeftApplication(this.f1175a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static class c implements CustomEventNativeListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1176a;
        private final MediationNativeListener b;

        public c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f1176a = customEventAdapter;
            this.b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzbad.zzdp("Custom event adapter called onAdLoaded.");
            this.b.onAdLoaded(this.f1176a, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzbad.zzdp("Custom event adapter called onAdLoaded.");
            this.b.onAdLoaded(this.f1176a, unifiedNativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzbad.zzdp("Custom event adapter called onAdFailedToLoad.");
            this.b.onAdFailedToLoad(this.f1176a, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzbad.zzdp("Custom event adapter called onAdOpened.");
            this.b.onAdOpened(this.f1176a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzbad.zzdp("Custom event adapter called onAdClicked.");
            this.b.onAdClicked(this.f1176a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzbad.zzdp("Custom event adapter called onAdClosed.");
            this.b.onAdClosed(this.f1176a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzbad.zzdp("Custom event adapter called onAdLeftApplication.");
            this.b.onAdLeftApplication(this.f1176a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdImpression() {
            zzbad.zzdp("Custom event adapter called onAdImpression.");
            this.b.onAdImpression(this.f1176a);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.d;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.d;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.d;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.f1173a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = (CustomEventBanner) a(bundle.getString("class_name"));
        if (this.b == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.b.requestBannerAd(context, new a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.c = (CustomEventInterstitial) a(bundle.getString("class_name"));
        if (this.c == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.c.requestInterstitialAd(context, new b(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.d = (CustomEventNative) a(bundle.getString("class_name"));
        if (this.d == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.d.requestNativeAd(context, new c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        this.f1173a = view;
    }
}
