package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Notifications;
import com.intlgame.core.INTLMethodID;
import com.tencent.abase.utils.ConstantUtils;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbha extends WebViewClient implements zzbii {
    private static final String[] c = {ConstantUtils.NET_UNKNOWN, "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] d = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private View.OnAttachStateChangeListener A;

    /* renamed from: a, reason: collision with root package name */
    protected zzbgz f2872a;
    protected zzavb b;
    private final zzwj e;
    private final HashMap<String, List<zzaho<? super zzbgz>>> f;
    private final Object g;
    private zzxr h;
    private com.google.android.gms.ads.internal.overlay.zzo i;
    private zzbij j;
    private zzbik k;
    private zzagv l;
    private zzagx m;
    private zzbil n;
    private boolean o;

    @GuardedBy("lock")
    private boolean p;

    @GuardedBy("lock")
    private boolean q;

    @GuardedBy("lock")
    private boolean r;
    private com.google.android.gms.ads.internal.overlay.zzu s;
    private final zzaqa t;
    private com.google.android.gms.ads.internal.zzb u;
    private zzapr v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public zzbha(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        this(zzbgzVar, zzwjVar, z, new zzaqa(zzbgzVar, zzbgzVar.zzaad(), new zzacf(zzbgzVar.getContext())), null);
    }

    @VisibleForTesting
    private zzbha(zzbgz zzbgzVar, zzwj zzwjVar, boolean z, zzaqa zzaqaVar, zzapr zzaprVar) {
        this.f = new HashMap<>();
        this.g = new Object();
        this.o = false;
        this.e = zzwjVar;
        this.f2872a = zzbgzVar;
        this.p = z;
        this.t = zzaqaVar;
        this.v = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(int i, int i2, boolean z) {
        this.t.zzj(i, i2);
        zzapr zzaprVar = this.v;
        if (zzaprVar != null) {
            zzaprVar.zza(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(zzxr zzxrVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzagx zzagxVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar, boolean z, zzahp zzahpVar, com.google.android.gms.ads.internal.zzb zzbVar, zzaqc zzaqcVar, zzavb zzavbVar) {
        if (zzbVar == null) {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.f2872a.getContext(), zzavbVar, null);
        }
        this.v = new zzapr(this.f2872a, zzaqcVar);
        this.b = zzavbVar;
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
        zza("/mraid", new zzahr(zzbVar, this.v, zzaqcVar));
        zza("/mraidLoaded", this.t);
        zza("/open", new zzahs(zzbVar, this.v));
        zza("/precache", new zzbgc());
        zza("/touch", zzagz.zzczy);
        zza("/video", zzagz.zzdab);
        zza("/videoMeta", zzagz.zzdac);
        if (zzk.zzme().zzx(this.f2872a.getContext())) {
            zza("/logScionEvent", new zzahq(this.f2872a.getContext()));
        }
        this.h = zzxrVar;
        this.i = zzoVar;
        this.l = zzagvVar;
        this.m = zzagxVar;
        this.s = zzuVar;
        this.u = zzbVar;
        this.o = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final com.google.android.gms.ads.internal.zzb zzaax() {
        return this.u;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final boolean zzaay() {
        boolean z;
        synchronized (this.g) {
            z = this.p;
        }
        return z;
    }

    public final boolean zzaaz() {
        boolean z;
        synchronized (this.g) {
            z = this.q;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaba() {
        synchronized (this.g) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzabb() {
        synchronized (this.g) {
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.g) {
            if (this.f2872a.isDestroyed()) {
                zzawz.zzds("Blank page loaded, 1...");
                this.f2872a.zzaao();
                return;
            }
            this.w = true;
            zzbik zzbikVar = this.k;
            if (zzbikVar != null) {
                zzbikVar.zzrw();
                this.k = null;
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view, zzavb zzavbVar, int i) {
        if (!zzavbVar.zzud() || i <= 0) {
            return;
        }
        zzavbVar.zzj(view);
        if (zzavbVar.zzud()) {
            zzaxi.zzdvv.postDelayed(new ld(this, view, zzavbVar, i), 100L);
        }
    }

    private final void a() {
        if (this.A == null) {
            return;
        }
        this.f2872a.getView().removeOnAttachStateChangeListener(this.A);
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabd() {
        zzavb zzavbVar = this.b;
        if (zzavbVar != null) {
            WebView webView = this.f2872a.getWebView();
            if (androidx.core.f.v.A(webView)) {
                a(webView, zzavbVar, 10);
                return;
            }
            a();
            this.A = new le(this, zzavbVar);
            this.f2872a.getView().addOnAttachStateChangeListener(this.A);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabe() {
        synchronized (this.g) {
            this.r = true;
        }
        this.y++;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabf() {
        this.y--;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzabg() {
        this.x = true;
        b();
    }

    private final void b() {
        if (this.j != null && ((this.w && this.y <= 0) || this.x)) {
            this.j.zzae(!this.x);
            this.j = null;
        }
        this.f2872a.zzaas();
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zzaan = this.f2872a.zzaan();
        a(new AdOverlayInfoParcel(zzcVar, (!zzaan || this.f2872a.zzaag().zzabx()) ? this.h : null, zzaan ? null : this.i, this.s, this.f2872a.zzyh()));
    }

    public final void zzc(boolean z, int i) {
        zzxr zzxrVar = (!this.f2872a.zzaan() || this.f2872a.zzaag().zzabx()) ? this.h : null;
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.i;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.s;
        zzbgz zzbgzVar = this.f2872a;
        a(new AdOverlayInfoParcel(zzxrVar, zzoVar, zzuVar, zzbgzVar, z, i, zzbgzVar.zzyh()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzaan = this.f2872a.zzaan();
        zzxr zzxrVar = (!zzaan || this.f2872a.zzaag().zzabx()) ? this.h : null;
        lf lfVar = zzaan ? null : new lf(this.f2872a, this.i);
        zzagv zzagvVar = this.l;
        zzagx zzagxVar = this.m;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.s;
        zzbgz zzbgzVar = this.f2872a;
        a(new AdOverlayInfoParcel(zzxrVar, lfVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i, str, zzbgzVar.zzyh()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzaan = this.f2872a.zzaan();
        zzxr zzxrVar = (!zzaan || this.f2872a.zzaag().zzabx()) ? this.h : null;
        lf lfVar = zzaan ? null : new lf(this.f2872a, this.i);
        zzagv zzagvVar = this.l;
        zzagx zzagxVar = this.m;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.s;
        zzbgz zzbgzVar = this.f2872a;
        a(new AdOverlayInfoParcel(zzxrVar, lfVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i, str, str2, zzbgzVar.zzyh()));
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzapr zzaprVar = this.v;
        boolean zztb = zzaprVar != null ? zzaprVar.zztb() : false;
        zzk.zzlf();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.f2872a.getContext(), adOverlayInfoParcel, zztb ? false : true);
        if (this.b != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdkl != null) {
                str = adOverlayInfoParcel.zzdkl.url;
            }
            this.b.zzdk(str);
        }
    }

    public final void zza(String str, zzaho<? super zzbgz> zzahoVar) {
        synchronized (this.g) {
            List<zzaho<? super zzbgz>> list = this.f.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.f.put(str, list);
            }
            list.add(zzahoVar);
        }
    }

    public final void zzb(String str, zzaho<? super zzbgz> zzahoVar) {
        synchronized (this.g) {
            List<zzaho<? super zzbgz>> list = this.f.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzahoVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        synchronized (this.g) {
            List<zzaho<? super zzbgz>> list = this.f.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzaho<? super zzbgz> zzahoVar : list) {
                if (predicate.apply(zzahoVar)) {
                    arrayList.add(zzahoVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void reset() {
        zzavb zzavbVar = this.b;
        if (zzavbVar != null) {
            zzavbVar.zzuf();
            this.b = null;
        }
        a();
        synchronized (this.g) {
            this.f.clear();
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = null;
            this.n = null;
            if (this.v != null) {
                this.v.zzw(true);
                this.v = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(zzbij zzbijVar) {
        this.j = zzbijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zza(zzbik zzbikVar) {
        this.k = zzbikVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzawz.zzds(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf;
        if (i < 0) {
            int i2 = (-i) - 1;
            String[] strArr = c;
            if (i2 < strArr.length) {
                valueOf = strArr[i2];
                a(this.f2872a.getContext(), "http_err", valueOf, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        valueOf = String.valueOf(i);
        a(this.f2872a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String valueOf;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0) {
                String[] strArr = d;
                if (primaryError < strArr.length) {
                    valueOf = strArr[primaryError];
                    Context context = this.f2872a.getContext();
                    zzk.zzli();
                    a(context, "ssl_err", valueOf, sslError.getUrl());
                }
            }
            valueOf = String.valueOf(primaryError);
            Context context2 = this.f2872a.getContext();
            zzk.zzli();
            a(context2, "ssl_err", valueOf, sslError.getUrl());
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    private final void a(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqo)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    zzk.zzlg().zza(context, this.f2872a.zzyh().zzbsx, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            zzk.zzlg().zza(context, this.f2872a.zzyh().zzbsx, "gmob-apps", bundle, true);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzawz.zzds(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else {
            if (this.o && webView == this.f2872a.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzxr zzxrVar = this.h;
                    if (zzxrVar != null) {
                        zzxrVar.onAdClicked();
                        zzavb zzavbVar = this.b;
                        if (zzavbVar != null) {
                            zzavbVar.zzdk(str);
                        }
                        this.h = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.f2872a.getWebView().willNotDraw()) {
                try {
                    zzdh zzaal = this.f2872a.zzaal();
                    if (zzaal != null && zzaal.zzc(parse)) {
                        parse = zzaal.zza(parse, this.f2872a.getContext(), this.f2872a.getView(), this.f2872a.zzyd());
                    }
                } catch (zzdi unused) {
                    String valueOf2 = String.valueOf(str);
                    zzawz.zzep(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.u;
                if (zzbVar == null || zzbVar.zzkx()) {
                    zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                } else {
                    this.u.zzbk(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzawz.zzep(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(str, Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebResourceResponse a(String str, Map<String, String> map) {
        zzvs zza;
        try {
            String zzd = zzavx.zzd(str, this.f2872a.getContext(), this.z);
            if (!zzd.equals(str)) {
                return b(zzd, map);
            }
            zzvv zzbo = zzvv.zzbo(str);
            if (zzbo != null && (zza = zzk.zzlm().zza(zzbo)) != null && zza.zznh()) {
                return new WebResourceResponse("", "", zza.zzni());
            }
            if (!zzazx.isEnabled()) {
                return null;
            }
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqc)).booleanValue()) {
                return b(str, map);
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

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e5, code lost:
    
        com.google.android.gms.ads.internal.zzk.zzlg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
    
        return com.google.android.gms.internal.ads.zzaxi.zzd(r2);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse b(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbha.b(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    public final void zzao(boolean z) {
        this.o = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final zzavb zzabj() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzth() {
        synchronized (this.g) {
            this.o = false;
            this.p = true;
            zzbbm.zzeae.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.lc

                /* renamed from: a, reason: collision with root package name */
                private final zzbha f2310a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2310a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbha zzbhaVar = this.f2310a;
                    zzbhaVar.f2872a.zzaar();
                    com.google.android.gms.ads.internal.overlay.zzd zzaae = zzbhaVar.f2872a.zzaae();
                    if (zzaae != null) {
                        zzaae.zzth();
                    }
                }
            });
        }
    }

    public final void zzat(boolean z) {
        this.z = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzi(int i, int i2) {
        zzapr zzaprVar = this.v;
        if (zzaprVar != null) {
            zzaprVar.zzi(i, i2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case Notifications.NOTIFICATION_TYPES_ALL /* 127 */:
                    case 128:
                    case 129:
                    case INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN /* 130 */:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzaho<? super zzbgz>> list = this.f.get(path);
        if (list != null) {
            zzk.zzlg();
            Map<String, String> zzi = zzaxi.zzi(uri);
            if (zzawz.isLoggable(2)) {
                String valueOf = String.valueOf(path);
                zzawz.zzds(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
                for (String str : zzi.keySet()) {
                    String str2 = zzi.get(str);
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length());
                    sb.append("  ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    zzawz.zzds(sb.toString());
                }
            }
            Iterator<zzaho<? super zzbgz>> it = list.iterator();
            while (it.hasNext()) {
                it.next().zza(this.f2872a, zzi);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb2.append("No GMSG handler found for GMSG: ");
        sb2.append(valueOf2);
        zzawz.zzds(sb2.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void zzau(boolean z) {
        synchronized (this.g) {
            this.q = true;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.f2872a.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
