package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzanl extends zzamt {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2763a;
    private zzano b;
    private zzatk c;
    private IObjectWrapper d;
    private MediationRewardedAd e;

    public zzanl(MediationAdapter mediationAdapter) {
        this.f2763a = mediationAdapter;
    }

    public zzanl(Adapter adapter) {
        this.f2763a = adapter;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper zzse() throws RemoteException {
        Object obj = this.f2763a;
        if (!(obj instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        zza(iObjectWrapper, zzydVar, zzxzVar, str, null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        if (!(this.f2763a instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f2763a;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzano(zzamvVar), a(str, zzxzVar, str2), com.google.android.gms.ads.zzb.zza(zzydVar.width, zzydVar.height, zzydVar.zzaap), new zzank(zzxzVar.zzcgn == -1 ? null : new Date(zzxzVar.zzcgn), zzxzVar.zzcgo, zzxzVar.zzcgp != null ? new HashSet(zzxzVar.zzcgp) : null, zzxzVar.zzmw, a(zzxzVar), zzxzVar.zzcgr, zzxzVar.zzcha, zzxzVar.zzchc, a(str, zzxzVar)), zzxzVar.zzcgv != null ? zzxzVar.zzcgv.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsh() {
        Object obj = this.f2763a;
        if (!(obj instanceof zzbjk)) {
            String canonicalName = zzbjk.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            return new Bundle();
        }
        return ((zzbjk) obj).zzsh();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        zza(iObjectWrapper, zzxzVar, str, (String) null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        if (!(this.f2763a instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f2763a;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzano(zzamvVar), a(str, zzxzVar, str2), new zzank(zzxzVar.zzcgn == -1 ? null : new Date(zzxzVar.zzcgn), zzxzVar.zzcgo, zzxzVar.zzcgp != null ? new HashSet(zzxzVar.zzcgp) : null, zzxzVar.zzmw, a(zzxzVar), zzxzVar.zzcgr, zzxzVar.zzcha, zzxzVar.zzchc, a(str, zzxzVar)), zzxzVar.zzcgv != null ? zzxzVar.zzcgv.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.f2763a;
        if (!(obj instanceof zzbjl)) {
            String canonicalName = zzbjl.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            return new Bundle();
        }
        return ((zzbjl) obj).getInterstitialAdapterInfo();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) throws RemoteException {
        Object obj = this.f2763a;
        if (!(obj instanceof MediationNativeAdapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
            zzans zzansVar = new zzans(zzxzVar.zzcgn == -1 ? null : new Date(zzxzVar.zzcgn), zzxzVar.zzcgo, zzxzVar.zzcgp != null ? new HashSet(zzxzVar.zzcgp) : null, zzxzVar.zzmw, a(zzxzVar), zzxzVar.zzcgr, zzadyVar, list, zzxzVar.zzcha, zzxzVar.zzchc, a(str, zzxzVar));
            Bundle bundle = zzxzVar.zzcgv != null ? zzxzVar.zzcgv.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.b = new zzano(zzamvVar);
            mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.b, a(str, zzxzVar, str2), zzansVar, bundle);
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
    public final zzana zzsf() {
        NativeAdMapper zzsr = this.b.zzsr();
        if (zzsr instanceof NativeAppInstallAdMapper) {
            return new zzanq((NativeAppInstallAdMapper) zzsr);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang zzsl() {
        UnifiedNativeAdMapper zzss = this.b.zzss();
        if (zzss != null) {
            return new zzaoi(zzss);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand zzsg() {
        NativeAdMapper zzsr = this.b.zzsr();
        if (zzsr instanceof NativeContentAdMapper) {
            return new zzanr((NativeContentAdMapper) zzsr);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzafe zzsk() {
        NativeCustomTemplateAd zzst = this.b.zzst();
        if (zzst instanceof zzafh) {
            return ((zzafh) zzst).zzrn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean zzsj() {
        return this.f2763a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
        zzank zzankVar;
        Bundle bundle;
        Object obj = this.f2763a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f2763a;
                Bundle a2 = a(str2, zzxzVar, null);
                if (zzxzVar != null) {
                    zzank zzankVar2 = new zzank(zzxzVar.zzcgn == -1 ? null : new Date(zzxzVar.zzcgn), zzxzVar.zzcgo, zzxzVar.zzcgp != null ? new HashSet(zzxzVar.zzcgp) : null, zzxzVar.zzmw, a(zzxzVar), zzxzVar.zzcgr, zzxzVar.zzcha, zzxzVar.zzchc, a(str2, zzxzVar));
                    if (zzxzVar.zzcgv != null) {
                        bundle = zzxzVar.zzcgv.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                        zzankVar = zzankVar2;
                    } else {
                        bundle = null;
                        zzankVar = zzankVar2;
                    }
                } else {
                    zzankVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzankVar, str, new zzatn(zzatkVar), a2, bundle);
                return;
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
        if (!(obj instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        this.d = iObjectWrapper;
        this.c = zzatkVar;
        zzatkVar.zzae(ObjectWrapper.wrap(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) throws RemoteException {
        if (!(this.f2763a instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzbad.zzdp("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f2763a;
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next(), null, null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzatn(zzatkVar), arrayList);
        } catch (Throwable th) {
            zzbad.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzxz zzxzVar, String str) throws RemoteException {
        zza(zzxzVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzxz zzxzVar, String str, String str2) throws RemoteException {
        Bundle bundle;
        String str3;
        Object obj = this.f2763a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f2763a;
                zzank zzankVar = new zzank(zzxzVar.zzcgn == -1 ? null : new Date(zzxzVar.zzcgn), zzxzVar.zzcgo, zzxzVar.zzcgp != null ? new HashSet(zzxzVar.zzcgp) : null, zzxzVar.zzmw, a(zzxzVar), zzxzVar.zzcgr, zzxzVar.zzcha, zzxzVar.zzchc, a(str, zzxzVar));
                if (zzxzVar.zzcgv != null) {
                    bundle = zzxzVar.zzcgv.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                    str3 = str2;
                } else {
                    bundle = null;
                    str3 = str2;
                }
                mediationRewardedVideoAdAdapter.loadAd(zzankVar, a(str, zzxzVar, str3), bundle);
                return;
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
        if (!(obj instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzb(this.d, zzxzVar, str, new zzanp((Adapter) obj, this.c));
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() throws RemoteException {
        Object obj = this.f2763a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f2763a).showVideo();
                return;
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
        if (!(obj instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        MediationRewardedAd mediationRewardedAd = this.e;
        if (mediationRewardedAd != null) {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.d));
        } else {
            zzbad.zzen("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() throws RemoteException {
        Object obj = this.f2763a;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.zzdp("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f2763a).isInitialized();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return this.c != null;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.f2763a.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbad.zzep(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzb(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Bundle bundle;
        if (!(this.f2763a instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzbad.zzdp("Requesting rewarded ad from adapter.");
        try {
            Adapter adapter = (Adapter) this.f2763a;
            adapter.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", a(str, zzxzVar, null), (zzxzVar.zzcgv == null || (bundle = zzxzVar.zzcgv.getBundle(this.f2763a.getClass().getName())) == null) ? new Bundle() : bundle, a(zzxzVar), zzxzVar.zzmw, zzxzVar.zzcgr, zzxzVar.zzchc, a(str, zzxzVar)), new cs(this, zzamvVar, adapter));
        } catch (Exception e) {
            zzbad.zzc("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (!(this.f2763a instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzbad.zzdp("Show rewarded ad from adapter.");
        MediationRewardedAd mediationRewardedAd = this.e;
        if (mediationRewardedAd != null) {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } else {
            zzbad.zzen("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.f2763a;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbad.zzc("", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() {
        Object obj = this.f2763a;
        if (!(obj instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        if (!(this.f2763a instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f2763a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        }
        zzbad.zzdp("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f2763a).showInterstitial();
        } catch (Throwable th) {
            zzbad.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        Object obj = this.f2763a;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        Object obj = this.f2763a;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        Object obj = this.f2763a;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzbad.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.f2763a;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
        AdFormat adFormat;
        if (!(this.f2763a instanceof Adapter)) {
            throw new RemoteException();
        }
        ct ctVar = new ct(this, zzaiqVar);
        ArrayList arrayList = new ArrayList();
        for (zzaiw zzaiwVar : list) {
            String str = zzaiwVar.zzdbd;
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
                    throw new RemoteException();
            }
            arrayList.add(new MediationConfiguration(adFormat, zzaiwVar.extras));
        }
        ((Adapter) this.f2763a).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), ctVar, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Bundle a(String str, zzxz zzxzVar, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzbad.zzdp(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.f2763a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzxzVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzxzVar.zzcgr);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
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

    private static String a(String str, zzxz zzxzVar) {
        String str2 = zzxzVar.zzchd;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }
}
