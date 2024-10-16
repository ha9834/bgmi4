package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzxr;
import com.google.android.gms.internal.ads.zzyt;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@zzard
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbjl {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmd;
    private InterstitialAd zzme;
    private AdLoader zzmf;
    private Context zzmg;
    private InterstitialAd zzmh;
    private MediationRewardedVideoAdListener zzmi;

    @VisibleForTesting
    private final RewardedVideoAdListener zzmj = new com.google.ads.mediation.a(this);

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    private final AdRequest zza(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                builder.addKeyword(it.next());
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzyt.zzpa();
            builder.addTestDevice(zzazt.zzbe(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class d extends AdListener implements AppEventListener, zzxr {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f1107a;

        @VisibleForTesting
        private final com.google.android.gms.ads.mediation.MediationBannerListener b;

        public d(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener) {
            this.f1107a = abstractAdViewAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.b.onAdLoaded(this.f1107a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.b.onAdFailedToLoad(this.f1107a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.b.onAdOpened(this.f1107a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.b.onAdClosed(this.f1107a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.b.onAdLeftApplication(this.f1107a);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzxr
        public final void onAdClicked() {
            this.b.onAdClicked(this.f1107a);
        }

        @Override // com.google.android.gms.ads.doubleclick.AppEventListener
        public final void onAppEvent(String str, String str2) {
            this.b.zza(this.f1107a, str, str2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class e extends AdListener implements zzxr {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f1108a;

        @VisibleForTesting
        private final com.google.android.gms.ads.mediation.MediationInterstitialListener b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener) {
            this.f1108a = abstractAdViewAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.b.onAdLoaded(this.f1108a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.b.onAdFailedToLoad(this.f1108a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.b.onAdOpened(this.f1108a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.b.onAdClosed(this.f1108a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.b.onAdLeftApplication(this.f1108a);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzxr
        public final void onAdClicked() {
            this.b.onAdClicked(this.f1108a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class f extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f1109a;

        @VisibleForTesting
        private final MediationNativeListener b;

        public f(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f1109a = abstractAdViewAdapter;
            this.b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.b.onAdFailedToLoad(this.f1109a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.b.onAdOpened(this.f1109a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.b.onAdClosed(this.f1109a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.b.onAdLeftApplication(this.f1109a);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzxr
        public final void onAdClicked() {
            this.b.onAdClicked(this.f1109a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdImpression() {
            this.b.onAdImpression(this.f1109a);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.b.onAdLoaded(this.f1109a, new a(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.b.onAdLoaded(this.f1109a, new c(unifiedNativeAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.b.onAdLoaded(this.f1109a, new b(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.b.zza(this.f1109a, nativeCustomTemplateAd);
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.b.zza(this.f1109a, nativeCustomTemplateAd, str);
        }
    }

    /* loaded from: classes.dex */
    static class b extends NativeContentAdMapper {
        private final NativeContentAd e;

        public b(NativeContentAd nativeContentAd) {
            this.e = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.e);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbql.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.e);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c extends UnifiedNativeAdMapper {

        /* renamed from: a, reason: collision with root package name */
        private final UnifiedNativeAd f1106a;

        public c(UnifiedNativeAd unifiedNativeAd) {
            this.f1106a = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzp(unifiedNativeAd.zzkv());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.f1106a);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbql.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.f1106a);
            }
        }
    }

    /* loaded from: classes.dex */
    static class a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd e;

        public a(NativeAppInstallAd nativeAppInstallAd) {
            this.e = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.e);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbql.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        AdView adView = this.zzmd;
        if (adView != null) {
            adView.destroy();
            this.zzmd = null;
        }
        if (this.zzme != null) {
            this.zzme = null;
        }
        if (this.zzmf != null) {
            this.zzmf = null;
        }
        if (this.zzmh != null) {
            this.zzmh = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        AdView adView = this.zzmd;
        if (adView != null) {
            adView.pause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        AdView adView = this.zzmd;
        if (adView != null) {
            adView.resume();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmd = new AdView(context);
        this.zzmd.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmd.setAdUnitId(getAdUnitId(bundle));
        this.zzmd.setAdListener(new d(this, mediationBannerListener));
        this.zzmd.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzmd;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener, Bundle bundle, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzme = new InterstitialAd(context);
        this.zzme.setAdUnitId(getAdUnitId(bundle));
        this.zzme.setAdListener(new e(this, mediationInterstitialListener));
        this.zzme.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzme;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzmh;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.zza
    public zzaar getVideoController() {
        VideoController videoController;
        AdView adView = this.zzmd;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdh();
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzme.show();
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdj(1).zzacc();
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        f fVar = new f(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(fVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(fVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(fVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(fVar);
        }
        if (nativeMediationAdRequest.zzsu()) {
            for (String str : nativeMediationAdRequest.zzsv().keySet()) {
                withAdListener.forCustomTemplateAd(str, fVar, nativeMediationAdRequest.zzsv().get(str).booleanValue() ? fVar : null);
            }
        }
        this.zzmf = withAdListener.build();
        this.zzmf.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmg = context.getApplicationContext();
        this.zzmi = mediationRewardedVideoAdListener;
        this.zzmi.onInitializationSucceeded(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzmg;
        if (context == null || this.zzmi == null) {
            zzbad.zzen("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzmh = new InterstitialAd(context);
        this.zzmh.zzc(true);
        this.zzmh.setAdUnitId(getAdUnitId(bundle));
        this.zzmh.setRewardedVideoAdListener(this.zzmj);
        this.zzmh.setAdMetadataListener(new com.google.ads.mediation.b(this));
        this.zzmh.loadAd(zza(this.zzmg, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzmh.show();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzmi != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InterstitialAd zza(AbstractAdViewAdapter abstractAdViewAdapter, InterstitialAd interstitialAd) {
        abstractAdViewAdapter.zzmh = null;
        return null;
    }
}
