package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzant<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzamt {

    /* renamed from: a, reason: collision with root package name */
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f2769a;
    private final NETWORK_EXTRAS b;

    public zzant(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f2769a = mediationAdapter;
        this.b = network_extras;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzxz zzxzVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzxz zzxzVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzb(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana zzsf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand zzsg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean zzsj() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzafe zzsk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang zzsl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper zzse() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f2769a;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        zza(iObjectWrapper, zzydVar, zzxzVar, str, null, zzamvVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f2769a;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f2769a;
            zzanu zzanuVar = new zzanu(zzamvVar);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            SERVER_PARAMETERS a2 = a(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzydVar.width && adSizeArr[i].getHeight() == zzydVar.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(com.google.android.gms.ads.zzb.zza(zzydVar.width, zzydVar.height, zzydVar.zzaap));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzanuVar, activity, a2, adSize, zzaog.zza(zzxzVar, a(zzxzVar)), this.b);
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsh() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        zza(iObjectWrapper, zzxzVar, str, (String) null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f2769a;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f2769a).requestInterstitialAd(new zzanu(zzamvVar), (Activity) ObjectWrapper.unwrap(iObjectWrapper), a(str), zzaog.zza(zzxzVar, a(zzxzVar)), this.b);
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.f2769a;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbad.zzep(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbad.zzdp("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f2769a).showInterstitial();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsi() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        try {
            this.f2769a.destroy();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final SERVER_PARAMETERS a(String str) throws RemoteException {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.f2769a.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
            newInstance.load(hashMap);
            return newInstance;
        } catch (Throwable th) {
            zzbad.zzc("", th);
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
}
