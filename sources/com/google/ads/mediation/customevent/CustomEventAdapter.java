package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbad;

@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {

    /* renamed from: a, reason: collision with root package name */
    private View f1113a;

    @VisibleForTesting
    private CustomEventBanner b;

    @VisibleForTesting
    private CustomEventInterstitial c;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class a implements CustomEventBannerListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1114a;
        private final MediationBannerListener b;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f1114a = customEventAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public final void onReceivedAd(View view) {
            zzbad.zzdp("Custom event adapter called onReceivedAd.");
            this.f1114a.a(view);
            this.b.onReceivedAd(this.f1114a);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onFailedToReceiveAd() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onFailedToReceiveAd(this.f1114a, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public final void onClick() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onClick(this.f1114a);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onPresentScreen() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onPresentScreen(this.f1114a);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onDismissScreen() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onDismissScreen(this.f1114a);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onLeaveApplication() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onLeaveApplication(this.f1114a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public class b implements CustomEventInterstitialListener {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1115a;
        private final MediationInterstitialListener b;

        public b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f1115a = customEventAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onReceivedAd() {
            zzbad.zzdp("Custom event adapter called onReceivedAd.");
            this.b.onReceivedAd(CustomEventAdapter.this);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onFailedToReceiveAd() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.b.onFailedToReceiveAd(this.f1115a, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onPresentScreen() {
            zzbad.zzdp("Custom event adapter called onPresentScreen.");
            this.b.onPresentScreen(this.f1115a);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onDismissScreen() {
            zzbad.zzdp("Custom event adapter called onDismissScreen.");
            this.b.onDismissScreen(this.f1115a);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onLeaveApplication() {
            zzbad.zzdp("Custom event adapter called onLeaveApplication.");
            this.b.onLeaveApplication(this.f1115a);
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public final void destroy() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.f1113a;
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.b = (CustomEventBanner) a(customEventServerParameters.className);
        if (this.b == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.b.requestBannerAd(new a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.c = (CustomEventInterstitial) a(customEventServerParameters.className);
        if (this.c == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.c.requestInterstitialAd(new b(this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        this.f1113a = view;
    }
}
