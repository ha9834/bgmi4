package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbio extends zzbiz implements zzbii {

    /* renamed from: a, reason: collision with root package name */
    protected zzbgz f2879a;
    private zzxr d;
    private com.google.android.gms.ads.internal.overlay.zzo e;
    private zzbij f;
    private zzbik g;
    private zzagv h;
    private zzagx i;
    private zzbil j;
    private volatile boolean l;

    @GuardedBy("lock")
    private boolean m;

    @GuardedBy("lock")
    private boolean n;
    private com.google.android.gms.ads.internal.overlay.zzu o;
    private zzaqa p;
    private com.google.android.gms.ads.internal.zzb q;
    private zzapr r;
    private zzavb s;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private View.OnAttachStateChangeListener x;
    private final Object c = new Object();
    private boolean k = false;
    private final zzaju<zzbgz> b = new zzaju<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzbgz zzbgzVar, boolean z) {
        zzaqa zzaqaVar = new zzaqa(zzbgzVar, zzbgzVar.zzaad(), new zzacf(zzbgzVar.getContext()));
        this.f2879a = zzbgzVar;
        this.l = z;
        this.p = zzaqaVar;
        this.r = null;
        this.b.zzg((zzaju<zzbgz>) zzbgzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(int i, int i2, boolean z) {
        this.p.zzj(i, i2);
        zzapr zzaprVar = this.r;
        if (zzaprVar != null) {
            zzaprVar.zza(i, i2, false);
        }
    }

    public final void zza(String str, zzaho<? super zzbgz> zzahoVar) {
        this.b.zza(str, zzahoVar);
    }

    public final void zzb(String str, zzaho<? super zzbgz> zzahoVar) {
        this.b.zzb(str, zzahoVar);
    }

    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.b.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(zzxr zzxrVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzagx zzagxVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar, boolean z, zzahp zzahpVar, com.google.android.gms.ads.internal.zzb zzbVar, zzaqc zzaqcVar, zzavb zzavbVar) {
        if (zzbVar == null) {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.f2879a.getContext(), zzavbVar, null);
        }
        this.r = new zzapr(this.f2879a, zzaqcVar);
        this.s = zzavbVar;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcov)).booleanValue()) {
            zza("/adMetadata", new zzagu(zzagvVar));
        }
        zza("/appEvent", new zzagw(zzagxVar));
        zza("/backButton", zzagz.zzczz);
        zza("/refresh", zzagz.zzdaa);
        zza("/canOpenURLs", zzagz.zzczq);
        zza("/canOpenIntents", zzagz.zzczr);
        zza("/click", zzagz.zzczs);
        zza("/close", zzagz.zzczt);
        zza("/customClose", zzagz.zzczu);
        zza("/instrument", zzagz.zzdad);
        zza("/delayPageLoaded", zzagz.zzdaf);
        zza("/delayPageClosed", zzagz.zzdag);
        zza("/getLocationInfo", zzagz.zzdah);
        zza("/httpTrack", zzagz.zzczv);
        zza("/log", zzagz.zzczw);
        zza("/mraid", new zzahr(zzbVar, this.r, zzaqcVar));
        zza("/mraidLoaded", this.p);
        zza("/open", new zzahs(zzbVar, this.r));
        zza("/precache", new zzbgc());
        zza("/touch", zzagz.zzczy);
        zza("/video", zzagz.zzdab);
        zza("/videoMeta", zzagz.zzdac);
        if (zzk.zzme().zzx(this.f2879a.getContext())) {
            zza("/logScionEvent", new zzahq(this.f2879a.getContext()));
        }
        this.d = zzxrVar;
        this.e = zzoVar;
        this.h = zzagvVar;
        this.i = zzagxVar;
        this.o = zzuVar;
        this.q = zzbVar;
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final com.google.android.gms.ads.internal.zzb zzaax() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final boolean zzaay() {
        return this.l;
    }

    public final boolean zzaaz() {
        boolean z;
        synchronized (this.c) {
            z = this.m;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaba() {
        synchronized (this.c) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzabb() {
        synchronized (this.c) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final void zza(zzbja zzbjaVar) {
        this.t = true;
        zzbik zzbikVar = this.g;
        if (zzbikVar != null) {
            zzbikVar.zzrw();
            this.g = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view, zzavb zzavbVar, int i) {
        if (!zzavbVar.zzud() || i <= 0) {
            return;
        }
        zzavbVar.zzj(view);
        if (zzavbVar.zzud()) {
            zzaxi.zzdvv.postDelayed(new lt(this, view, zzavbVar, i), 100L);
        }
    }

    private final void a() {
        if (this.x == null) {
            return;
        }
        this.f2879a.getView().removeOnAttachStateChangeListener(this.x);
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabd() {
        zzavb zzavbVar = this.s;
        if (zzavbVar != null) {
            WebView webView = this.f2879a.getWebView();
            if (androidx.core.f.v.A(webView)) {
                a(webView, zzavbVar, 10);
                return;
            }
            a();
            this.x = new lu(this, zzavbVar);
            this.f2879a.getView().addOnAttachStateChangeListener(this.x);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabe() {
        synchronized (this.c) {
            this.n = true;
        }
        this.v++;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabf() {
        this.v--;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabg() {
        this.u = true;
        b();
    }

    private final void b() {
        if (this.f != null && ((this.t && this.v <= 0) || this.u)) {
            this.f.zzae(!this.u);
            this.f = null;
        }
        this.f2879a.zzaas();
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zzaan = this.f2879a.zzaan();
        a(new AdOverlayInfoParcel(zzcVar, (!zzaan || this.f2879a.zzaag().zzabx()) ? this.d : null, zzaan ? null : this.e, this.o, this.f2879a.zzyh()));
    }

    public final void zzc(boolean z, int i) {
        zzxr zzxrVar = (!this.f2879a.zzaan() || this.f2879a.zzaag().zzabx()) ? this.d : null;
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.e;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.o;
        zzbgz zzbgzVar = this.f2879a;
        a(new AdOverlayInfoParcel(zzxrVar, zzoVar, zzuVar, zzbgzVar, z, i, zzbgzVar.zzyh()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzaan = this.f2879a.zzaan();
        zzxr zzxrVar = (!zzaan || this.f2879a.zzaag().zzabx()) ? this.d : null;
        lv lvVar = zzaan ? null : new lv(this.f2879a, this.e);
        zzagv zzagvVar = this.h;
        zzagx zzagxVar = this.i;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.o;
        zzbgz zzbgzVar = this.f2879a;
        a(new AdOverlayInfoParcel(zzxrVar, lvVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i, str, zzbgzVar.zzyh()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzaan = this.f2879a.zzaan();
        zzxr zzxrVar = (!zzaan || this.f2879a.zzaag().zzabx()) ? this.d : null;
        lv lvVar = zzaan ? null : new lv(this.f2879a, this.e);
        zzagv zzagvVar = this.h;
        zzagx zzagxVar = this.i;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.o;
        zzbgz zzbgzVar = this.f2879a;
        a(new AdOverlayInfoParcel(zzxrVar, lvVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i, str, str2, zzbgzVar.zzyh()));
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzapr zzaprVar = this.r;
        boolean zztb = zzaprVar != null ? zzaprVar.zztb() : false;
        zzk.zzlf();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.f2879a.getContext(), adOverlayInfoParcel, zztb ? false : true);
        if (this.s != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdkl != null) {
                str = adOverlayInfoParcel.zzdkl.url;
            }
            this.s.zzdk(str);
        }
    }

    public final void destroy() {
        zzavb zzavbVar = this.s;
        if (zzavbVar != null) {
            zzavbVar.zzuf();
            this.s = null;
        }
        a();
        this.b.reset();
        this.b.zzg((zzaju<zzbgz>) null);
        synchronized (this.c) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.o = null;
            this.j = null;
            if (this.r != null) {
                this.r.zzw(true);
                this.r = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(zzbij zzbijVar) {
        this.f = zzbijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(zzbik zzbikVar) {
        this.g = zzbikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final void zzb(zzbja zzbjaVar) {
        this.b.zzg(zzbjaVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final boolean zzc(zzbja zzbjaVar) {
        String valueOf = String.valueOf(zzbjaVar.url);
        zzawz.zzds(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbjaVar.uri;
        if (this.b.zzg(uri)) {
            return true;
        }
        if (this.k) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzxr zzxrVar = this.d;
                if (zzxrVar != null) {
                    zzxrVar.onAdClicked();
                    zzavb zzavbVar = this.s;
                    if (zzavbVar != null) {
                        zzavbVar.zzdk(zzbjaVar.url);
                    }
                    this.d = null;
                }
                return false;
            }
        }
        if (!this.f2879a.getWebView().willNotDraw()) {
            try {
                zzdh zzaal = this.f2879a.zzaal();
                if (zzaal != null && zzaal.zzc(uri)) {
                    uri = zzaal.zza(uri, this.f2879a.getContext(), this.f2879a.getView(), this.f2879a.zzyd());
                }
            } catch (zzdi unused) {
                String valueOf2 = String.valueOf(zzbjaVar.url);
                zzawz.zzep(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            com.google.android.gms.ads.internal.zzb zzbVar = this.q;
            if (zzbVar == null || zzbVar.zzkx()) {
                zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.q.zzbk(zzbjaVar.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbjaVar.url);
            zzawz.zzep(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final WebResourceResponse zzd(zzbja zzbjaVar) {
        String str;
        WebResourceResponse zzd;
        zzvs zza;
        zzavb zzavbVar = this.s;
        if (zzavbVar != null) {
            zzavbVar.zza(zzbjaVar.url, zzbjaVar.zzab, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(zzbjaVar.url).getName())) {
            zzth();
            if (this.f2879a.zzaag().zzabx()) {
                str = (String) zzyt.zzpe().zzd(zzacu.zzcmu);
            } else if (this.f2879a.zzaan()) {
                str = (String) zzyt.zzpe().zzd(zzacu.zzcmt);
            } else {
                str = (String) zzyt.zzpe().zzd(zzacu.zzcms);
            }
            zzk.zzlg();
            zzd = zzaxi.zzd(this.f2879a.getContext(), this.f2879a.zzyh().zzbsx, str);
        } else {
            zzd = null;
        }
        if (zzd != null) {
            return zzd;
        }
        try {
            if (!zzavx.zzd(zzbjaVar.url, this.f2879a.getContext(), this.w).equals(zzbjaVar.url)) {
                return a(zzbjaVar);
            }
            zzvv zzbo = zzvv.zzbo(zzbjaVar.url);
            if (zzbo != null && (zza = zzk.zzlm().zza(zzbo)) != null && zza.zznh()) {
                return new WebResourceResponse("", "", zza.zzni());
            }
            if (zzazx.isEnabled()) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqc)).booleanValue()) {
                    return a(zzbjaVar);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzk.zzlk().zza(e, "AdWebViewClient.interceptRequest");
            return c();
        }
    }

    private static WebResourceResponse c() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcom)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e9, code lost:
    
        com.google.android.gms.ads.internal.zzk.zzlg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f0, code lost:
    
        return com.google.android.gms.internal.ads.zzaxi.zzd(r3);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse a(com.google.android.gms.internal.ads.zzbja r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbio.a(com.google.android.gms.internal.ads.zzbja):android.webkit.WebResourceResponse");
    }

    public final void zzao(boolean z) {
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final zzavb zzabj() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzth() {
        synchronized (this.c) {
            this.k = false;
            this.l = true;
            zzbbm.zzeae.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ls

                /* renamed from: a, reason: collision with root package name */
                private final zzbio f2326a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2326a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbio zzbioVar = this.f2326a;
                    zzbioVar.f2879a.zzaar();
                    com.google.android.gms.ads.internal.overlay.zzd zzaae = zzbioVar.f2879a.zzaae();
                    if (zzaae != null) {
                        zzaae.zzth();
                    }
                }
            });
        }
    }

    public final void zzat(boolean z) {
        this.w = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzi(int i, int i2) {
        zzapr zzaprVar = this.r;
        if (zzaprVar != null) {
            zzaprVar.zzi(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzau(boolean z) {
        synchronized (this.c) {
            this.m = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzh(Uri uri) {
        this.b.zzh(uri);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.f2879a.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
