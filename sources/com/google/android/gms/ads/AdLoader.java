package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzxv;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyt;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzf;

/* loaded from: classes.dex */
public class AdLoader {

    /* renamed from: a, reason: collision with root package name */
    private final zzyc f1119a;
    private final Context b;
    private final zzzc c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1120a;
        private final zzzf b;

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzyt.zzpb().zzb(context, str, new zzamo()));
        }

        private Builder(Context context, zzzf zzzfVar) {
            this.f1120a = context;
            this.b = zzzfVar;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.b.zza(new zzagn(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.b.zza(new zzagm(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.b.zza(new zzags(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.b.zza(str, new zzagp(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzago(onCustomClickListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.b.zza(new zzagq(onPublisherAdViewLoadedListener), new zzyd(this.f1120a, adSizeArr));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.b.zza(new zzxv(adListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.b.zza(new zzady(nativeAdOptions));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.b.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzbad.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }

        public Builder withCorrelator(Correlator correlator) {
            Preconditions.checkNotNull(correlator);
            try {
                this.b.zza(correlator.f1124a);
            } catch (RemoteException e) {
                zzbad.zzd("Failed to set correlator.", e);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.f1120a, this.b.zzpk());
            } catch (RemoteException e) {
                zzbad.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzzc zzzcVar) {
        this(context, zzzcVar, zzyc.zzche);
    }

    private AdLoader(Context context, zzzc zzzcVar, zzyc zzycVar) {
        this.b = context;
        this.c = zzzcVar;
        this.f1119a = zzycVar;
    }

    private final void a(zzaaz zzaazVar) {
        try {
            this.c.zza(zzyc.zza(this.b, zzaazVar));
        } catch (RemoteException e) {
            zzbad.zzc("Failed to load ad.", e);
        }
    }

    public void loadAd(AdRequest adRequest) {
        a(adRequest.zzde());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.c.zza(zzyc.zza(this.b, adRequest.zzde()), i);
        } catch (RemoteException e) {
            zzbad.zzc("Failed to load ads.", e);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        a(publisherAdRequest.zzde());
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.c.zzpj();
        } catch (RemoteException e) {
            zzbad.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.c.isLoading();
        } catch (RemoteException e) {
            zzbad.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
