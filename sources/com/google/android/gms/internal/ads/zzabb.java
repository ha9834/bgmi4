package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
/* loaded from: classes2.dex */
public final class zzabb {

    /* renamed from: a, reason: collision with root package name */
    private final zzamo f2685a;
    private final zzyc b;
    private final AtomicBoolean c;
    private final VideoController d;

    @VisibleForTesting
    private final zzyv e;
    private zzxr f;
    private AdListener g;
    private AdSize[] h;
    private AppEventListener i;
    private Correlator j;
    private zzzk k;
    private OnCustomRenderedAdLoadedListener l;
    private VideoOptions m;
    private String n;
    private ViewGroup o;
    private int p;
    private boolean q;

    private static boolean a(int i) {
        return i == 1;
    }

    public zzabb(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzyc.zzche, 0);
    }

    public zzabb(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzyc.zzche, i);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzyc.zzche, 0);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzyc.zzche, i);
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzycVar, zzzk zzzkVar, int i) {
        this.f2685a = new zzamo();
        this.d = new VideoController();
        this.e = new a(this);
        this.o = viewGroup;
        this.b = zzycVar;
        this.k = null;
        this.c = new AtomicBoolean(false);
        this.p = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzyg zzygVar = new zzyg(context, attributeSet);
                this.h = zzygVar.zzs(z);
                this.n = zzygVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzazt zzpa = zzyt.zzpa();
                    AdSize adSize = this.h[0];
                    int i2 = this.p;
                    zzyd zzydVar = new zzyd(context, adSize);
                    zzydVar.zzchi = a(i2);
                    zzpa.zza(viewGroup, zzydVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzyt.zzpa().zza(viewGroup, new zzyd(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzycVar, int i) {
        this(viewGroup, attributeSet, z, zzycVar, null, i);
    }

    public final void destroy() {
        try {
            if (this.k != null) {
                this.k.destroy();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.g;
    }

    public final AdSize getAdSize() {
        zzyd zzpn;
        try {
            if (this.k != null && (zzpn = this.k.zzpn()) != null) {
                return com.google.android.gms.ads.zzb.zza(zzpn.width, zzpn.height, zzpn.zzaap);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.h;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.h;
    }

    public final String getAdUnitId() {
        zzzk zzzkVar;
        if (this.n == null && (zzzkVar = this.k) != null) {
            try {
                this.n = zzzkVar.getAdUnitId();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
        return this.n;
    }

    public final AppEventListener getAppEventListener() {
        return this.i;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.l;
    }

    public final void zza(zzaaz zzaazVar) {
        zzzk a2;
        try {
            if (this.k == null) {
                if ((this.h == null || this.n == null) && this.k == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.o.getContext();
                zzyd a3 = a(context, this.h, this.p);
                if ("search_v2".equals(a3.zzaap)) {
                    a2 = new aqg(zzyt.zzpb(), context, a3, this.n).a(context, false);
                } else {
                    a2 = new aqe(zzyt.zzpb(), context, a3, this.n, this.f2685a).a(context, false);
                }
                this.k = a2;
                this.k.zzb(new zzxv(this.e));
                if (this.f != null) {
                    this.k.zza(new zzxs(this.f));
                }
                if (this.i != null) {
                    this.k.zza(new zzyf(this.i));
                }
                if (this.l != null) {
                    this.k.zza(new zzadr(this.l));
                }
                if (this.j != null) {
                    this.k.zzb(this.j.zzdf());
                }
                if (this.m != null) {
                    this.k.zza(new zzacd(this.m));
                }
                this.k.setManualImpressionsEnabled(this.q);
                try {
                    IObjectWrapper zzpl = this.k.zzpl();
                    if (zzpl != null) {
                        this.o.addView((View) ObjectWrapper.unwrap(zzpl));
                    }
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.k.zzb(zzyc.zza(this.o.getContext(), zzaazVar))) {
                this.f2685a.zzf(zzaazVar.zzqa());
            }
        } catch (RemoteException e2) {
            zzbad.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void pause() {
        try {
            if (this.k != null) {
                this.k.pause();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (this.c.getAndSet(true)) {
            return;
        }
        try {
            if (this.k != null) {
                this.k.zzpm();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void resume() {
        try {
            if (this.k != null) {
                this.k.resume();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.g = adListener;
        this.e.zza(adListener);
    }

    public final void zza(zzxr zzxrVar) {
        try {
            this.f = zzxrVar;
            if (this.k != null) {
                this.k.zza(zzxrVar != null ? new zzxs(zzxrVar) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public final void zza(AdSize... adSizeArr) {
        this.h = adSizeArr;
        try {
            if (this.k != null) {
                this.k.zza(a(this.o.getContext(), this.h, this.p));
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        this.o.requestLayout();
    }

    public final void setAdUnitId(String str) {
        if (this.n != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.n = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.i = appEventListener;
            if (this.k != null) {
                this.k.zza(appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.l = onCustomRenderedAdLoadedListener;
        try {
            if (this.k != null) {
                this.k.zza(onCustomRenderedAdLoadedListener != null ? new zzadr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.q = z;
        try {
            if (this.k != null) {
                this.k.setManualImpressionsEnabled(this.q);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.j = correlator;
        try {
            if (this.k != null) {
                this.k.zzb(this.j == null ? null : this.j.zzdf());
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.k != null) {
                return this.k.zzpj();
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.k != null) {
                return this.k.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final VideoController getVideoController() {
        return this.d;
    }

    public final zzaar zzdh() {
        zzzk zzzkVar = this.k;
        if (zzzkVar == null) {
            return null;
        }
        try {
            return zzzkVar.getVideoController();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.m = videoOptions;
        try {
            if (this.k != null) {
                this.k.zza(videoOptions == null ? null : new zzacd(videoOptions));
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions getVideoOptions() {
        return this.m;
    }

    public final boolean zza(zzzk zzzkVar) {
        if (zzzkVar == null) {
            return false;
        }
        try {
            IObjectWrapper zzpl = zzzkVar.zzpl();
            if (zzpl == null || ((View) ObjectWrapper.unwrap(zzpl)).getParent() != null) {
                return false;
            }
            this.o.addView((View) ObjectWrapper.unwrap(zzpl));
            this.k = zzzkVar;
            return true;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzyd a(Context context, AdSize[] adSizeArr, int i) {
        zzyd zzydVar = new zzyd(context, adSizeArr);
        zzydVar.zzchi = a(i);
        return zzydVar;
    }
}
