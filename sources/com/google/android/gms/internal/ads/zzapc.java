package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzapc extends zzaow {

    /* renamed from: a, reason: collision with root package name */
    private final RtbAdapter f2772a;
    private MediationInterstitialAd b;
    private MediationRewardedAd c;

    public zzapc(RtbAdapter rtbAdapter) {
        this.f2772a = rtbAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zzx(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException {
        try {
            this.f2772a.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, a(str2), b(zzxzVar), a(zzxzVar), zzxzVar.zzmw, zzxzVar.zzcgr, zzxzVar.zzchc, a(str2, zzxzVar), com.google.android.gms.ads.zzb.zza(zzydVar.width, zzydVar.height, zzydVar.zzaap)), new di(this, zzaojVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException {
        try {
            this.f2772a.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, a(str2), b(zzxzVar), a(zzxzVar), zzxzVar.zzmw, zzxzVar.zzcgr, zzxzVar.zzchc, a(str2, zzxzVar)), new dj(this, zzaomVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException {
        try {
            this.f2772a.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, a(str2), b(zzxzVar), a(zzxzVar), zzxzVar.zzmw, zzxzVar.zzcgr, zzxzVar.zzchc, a(str2, zzxzVar)), new dk(this, zzaosVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException {
        try {
            this.f2772a.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, a(str2), b(zzxzVar), a(zzxzVar), zzxzVar.zzmw, zzxzVar.zzcgr, zzxzVar.zzchc, a(str2, zzxzVar)), new dl(this, zzaopVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.b;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.c;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzaar getVideoController() {
        MediationExtrasReceiver mediationExtrasReceiver = this.f2772a;
        if (!(mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException {
        AdFormat adFormat;
        try {
            dm dmVar = new dm(this, zzaoyVar);
            RtbAdapter rtbAdapter = this.f2772a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1396342996) {
                if (hashCode != -1052618729) {
                    if (hashCode != -239580146) {
                        if (hashCode == 604727084 && str.equals("interstitial")) {
                            c = 1;
                        }
                    } else if (str.equals("rewarded")) {
                        c = 2;
                    }
                } else if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                    c = 3;
                }
            } else if (str.equals("banner")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    adFormat = AdFormat.BANNER;
                    break;
                case 1:
                    adFormat = AdFormat.INTERSTITIAL;
                    break;
                case 2:
                    adFormat = AdFormat.REWARDED;
                    break;
                case 3:
                    adFormat = AdFormat.NATIVE;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), new MediationConfiguration(adFormat, bundle2), bundle, com.google.android.gms.ads.zzb.zza(zzydVar.width, zzydVar.height, zzydVar.zzaap)), dmVar);
        } catch (Throwable th) {
            zzbad.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj zzsx() throws RemoteException {
        return zzapj.zza(this.f2772a.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj zzsy() throws RemoteException {
        return zzapj.zza(this.f2772a.getSDKVersionInfo());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bundle a(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbad.zzep(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbad.zzc("", e);
            throw new RemoteException();
        }
    }

    private static boolean a(zzxz zzxzVar) {
        if (zzxzVar.zzcgq) {
            return true;
        }
        zzyt.zzpa();
        return zzazt.zzwx();
    }

    @Nullable
    private static String a(String str, zzxz zzxzVar) {
        String str2 = zzxzVar.zzchd;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    private final Bundle b(zzxz zzxzVar) {
        Bundle bundle;
        return (zzxzVar.zzcgv == null || (bundle = zzxzVar.zzcgv.getBundle(this.f2772a.getClass().getName())) == null) ? new Bundle() : bundle;
    }
}
