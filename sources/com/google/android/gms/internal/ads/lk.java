package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazonaws.services.s3.util.Mimetypes;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class lk extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbgz {

    @GuardedBy("this")
    private zzadx A;

    @GuardedBy("this")
    private zzadv B;

    @GuardedBy("this")
    private int C;

    @GuardedBy("this")
    private int D;
    private zzadg E;
    private zzadg F;
    private zzadg G;
    private zzadh H;
    private WeakReference<View.OnClickListener> I;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzd J;

    @GuardedBy("this")
    private boolean K;
    private zzazs L;
    private int M;
    private int N;
    private int O;
    private int P;
    private Map<String, zzbft> Q;
    private final WindowManager R;
    private final zzwj S;

    /* renamed from: a, reason: collision with root package name */
    private final zzbim f2318a;
    private final zzdh b;
    private final zzbai c;
    private final zzj d;
    private final com.google.android.gms.ads.internal.zza e;
    private final DisplayMetrics f;
    private final float g;
    private boolean h;
    private boolean i;
    private zzbha j;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzd k;

    @GuardedBy("this")
    private IObjectWrapper l;

    @GuardedBy("this")
    private zzbin m;

    @GuardedBy("this")
    private String n;

    @GuardedBy("this")
    private boolean o;

    @GuardedBy("this")
    private boolean p;

    @GuardedBy("this")
    private boolean q;

    @GuardedBy("this")
    private boolean r;

    @GuardedBy("this")
    private Boolean s;

    @GuardedBy("this")
    private int t;

    @GuardedBy("this")
    private boolean u;

    @GuardedBy("this")
    private boolean v;

    @GuardedBy("this")
    private String w;

    @GuardedBy("this")
    private zzbhq x;

    @GuardedBy("this")
    private boolean y;

    @GuardedBy("this")
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static lk a(Context context, zzbin zzbinVar, String str, boolean z, boolean z2, zzdh zzdhVar, zzbai zzbaiVar, zzadi zzadiVar, zzj zzjVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar) {
        return new lk(new zzbim(context), zzbinVar, str, z, z2, zzdhVar, zzbaiVar, zzadiVar, zzjVar, zzaVar, zzwjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbih
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzaaw() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbcw zzya() {
        return null;
    }

    @VisibleForTesting
    private lk(zzbim zzbimVar, zzbin zzbinVar, String str, boolean z, boolean z2, zzdh zzdhVar, zzbai zzbaiVar, zzadi zzadiVar, zzj zzjVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar) {
        super(zzbimVar);
        this.h = false;
        this.i = false;
        this.u = true;
        this.v = false;
        this.w = "";
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.P = -1;
        this.f2318a = zzbimVar;
        this.m = zzbinVar;
        this.n = str;
        this.q = z;
        this.t = -1;
        this.b = zzdhVar;
        this.c = zzbaiVar;
        this.d = zzjVar;
        this.e = zzaVar;
        this.R = (WindowManager) getContext().getSystemService("window");
        zzk.zzlg();
        this.f = zzaxi.zza(this.R);
        this.g = this.f.density;
        this.S = zzwjVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzawz.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzk.zzlg().zza(zzbimVar, zzbaiVar.zzbsx, settings);
        zzk.zzli().zza(getContext(), settings);
        setDownloadListener(this);
        e();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbht.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.L = new zzazs(this.f2318a.zzyd(), this, this, null);
        j();
        this.H = new zzadh(new zzadi(true, "make_wv", this.n));
        this.H.zzqw().zzc(zzadiVar);
        this.F = zzadb.zzb(this.H.zzqw());
        this.H.zza("native:view_create", this.F);
        this.G = null;
        this.E = null;
        zzk.zzli().zzay(zzbimVar);
        zzk.zzlk().zzuz();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbha) {
            this.j = (zzbha) webViewClient;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final com.google.android.gms.ads.internal.zza zzye() {
        return this.e;
    }

    private final boolean a() {
        int i;
        int i2;
        if (!this.j.zzaay() && !this.j.zzaaz()) {
            return false;
        }
        zzyt.zzpa();
        DisplayMetrics displayMetrics = this.f;
        int zzb = zzazt.zzb(displayMetrics, displayMetrics.widthPixels);
        zzyt.zzpa();
        DisplayMetrics displayMetrics2 = this.f;
        int zzb2 = zzazt.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzyd = this.f2318a.zzyd();
        if (zzyd == null || zzyd.getWindow() == null) {
            i = zzb;
            i2 = zzb2;
        } else {
            zzk.zzlg();
            int[] zzd = zzaxi.zzd(zzyd);
            zzyt.zzpa();
            int zzb3 = zzazt.zzb(this.f, zzd[0]);
            zzyt.zzpa();
            i2 = zzazt.zzb(this.f, zzd[1]);
            i = zzb3;
        }
        if (this.N == zzb && this.M == zzb2 && this.O == i && this.P == i2) {
            return false;
        }
        boolean z = (this.N == zzb && this.M == zzb2) ? false : true;
        this.N = zzb;
        this.M = zzb2;
        this.O = i;
        this.P = i2;
        new zzaqb(this).zza(zzb, zzb2, i, i2, this.f.density, this.R.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, zzk.zzlg().zzi(map));
        } catch (JSONException unused) {
            zzawz.zzep("Could not convert parameters to JSON.");
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzawz.zzer("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    private final synchronized void a(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzk.zzlk().zza(e, "AdWebViewImpl.loadUrl");
                zzawz.zzd("Could not call loadUrl. ", e);
                return;
            }
        }
        zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
    }

    private final synchronized void b(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzk.zzlk().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzawz.zzd("Could not call loadUrl. ", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzb(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, ((Boolean) zzyt.zzpe().zzd(zzacu.zzcok)).booleanValue() ? zzbid.zzf(str2, zzbid.zzabt()) : str2, Mimetypes.MIMETYPE_HTML, "UTF-8", str3);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @TargetApi(19)
    private final synchronized void a(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzawz.zzep("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void c(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (c() == null) {
                b();
            }
            if (c().booleanValue()) {
                a(str, (ValueCallback<String>) null);
                return;
            } else {
                String valueOf = String.valueOf(str);
                a(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
                return;
            }
        }
        String valueOf2 = String.valueOf(str);
        a(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzco(String str) {
        c(str);
    }

    private final synchronized void b() {
        this.s = zzk.zzlk().zzux();
        if (this.s == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                a((Boolean) true);
            } catch (IllegalStateException unused) {
                a((Boolean) false);
            }
        }
    }

    @VisibleForTesting
    private final void a(Boolean bool) {
        synchronized (this) {
            this.s = bool;
        }
        zzk.zzlk().zza(bool);
    }

    @VisibleForTesting
    private final synchronized Boolean c() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        c(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzawz.zzdp(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        c(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaab() {
        d();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.c.zzbsx);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzdi(int i) {
        if (i == 0) {
            zzadb.zza(this.H.zzqw(), this.F, "aebb2");
        }
        d();
        if (this.H.zzqw() != null) {
            this.H.zzqw().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.c.zzbsx);
        zza("onhide", hashMap);
    }

    private final void d() {
        zzadb.zza(this.H.zzqw(), this.F, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zztl() {
        if (this.E == null) {
            zzadb.zza(this.H.zzqw(), this.F, "aes2");
            this.E = zzadb.zzb(this.H.zzqw());
            this.H.zza("native:view_show", this.E);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.c.zzbsx);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaac() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzk.zzll().zzpr()));
        hashMap.put("app_volume", String.valueOf(zzk.zzll().zzpq()));
        hashMap.put("device_volume", String.valueOf(zzaya.zzba(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzaae() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized IObjectWrapper zzaam() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzaaf() {
        return this.J;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbie
    public final synchronized zzbin zzaag() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized String zzaah() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebViewClient zzaaj() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean zzaak() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbif
    public final zzdh zzaal() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbig
    public final zzbai zzyh() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbhy
    public final synchronized boolean zzaan() {
        return this.q;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzk.zzlg();
            zzaxi.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzawz.zzdp(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j.zzaaz()) {
            synchronized (this) {
                if (this.A != null) {
                    this.A.zzc(motionEvent);
                }
            }
        } else {
            zzdh zzdhVar = this.b;
            if (zzdhVar != null) {
                zzdhVar.zza(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d7 A[Catch: all -> 0x01ff, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ce, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0151, B:93:0x016c, B:95:0x01c1, B:96:0x01c5, B:98:0x01cc, B:103:0x01d7, B:105:0x01dd, B:106:0x01e0, B:108:0x01e4, B:109:0x01ed, B:115:0x01fa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141 A[Catch: all -> 0x01ff, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ce, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0151, B:93:0x016c, B:95:0x01c1, B:96:0x01c5, B:98:0x01cc, B:103:0x01d7, B:105:0x01dd, B:106:0x01e0, B:108:0x01e4, B:109:0x01ed, B:115:0x01fa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016c A[Catch: all -> 0x01ff, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ce, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0151, B:93:0x016c, B:95:0x01c1, B:96:0x01c5, B:98:0x01cc, B:103:0x01d7, B:105:0x01dd, B:106:0x01e0, B:108:0x01e4, B:109:0x01ed, B:115:0x01fa), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.lk.onMeasure(int, int):void");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean a2 = a();
        com.google.android.gms.ads.internal.overlay.zzd zzaae = zzaae();
        if (zzaae == null || !a2) {
            return;
        }
        zzaae.zztk();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.k = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzam(IObjectWrapper iObjectWrapper) {
        this.l = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.J = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(zzbin zzbinVar) {
        this.m = zzbinVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzaq(boolean z) {
        boolean z2 = z != this.q;
        this.q = z;
        e();
        if (z2) {
            new zzaqb(this).zzdj(z ? "expanded" : com.huawei.game.gamekit.b.a.f5471a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaar() {
        this.L.zzwt();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.L.onAttachedToWindow();
        }
        boolean z = this.y;
        if (this.j != null && this.j.zzaaz()) {
            if (!this.z) {
                this.j.zzaba();
                this.j.zzabb();
                this.z = true;
            }
            a();
            z = true;
        }
        a(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.L.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.z && this.j != null && this.j.zzaaz() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.j.zzaba();
                this.j.zzabb();
                this.z = false;
            }
        }
        a(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzbn(Context context) {
        this.f2318a.setBaseContext(context);
        this.L.zzh(this.f2318a.zzyd());
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzaf(boolean z) {
        if (this.k != null) {
            this.k.zza(this.j.zzaay(), z);
        } else {
            this.o = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void setRequestedOrientation(int i) {
        this.t = i;
        if (this.k != null) {
            this.k.setRequestedOrientation(this.t);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    public final Activity zzyd() {
        return this.f2318a.zzyd();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final Context zzaad() {
        return this.f2318a.zzaad();
    }

    private final synchronized void e() {
        if (!this.q && !this.m.zzabx()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzawz.zzdp("Disabling hardware acceleration on an AdView.");
                f();
                return;
            } else {
                zzawz.zzdp("Enabling hardware acceleration on an AdView.");
                g();
                return;
            }
        }
        zzawz.zzdp("Enabling hardware acceleration on an overlay.");
        g();
    }

    private final synchronized void f() {
        if (!this.r) {
            zzk.zzli();
            setLayerType(1, null);
        }
        this.r = true;
    }

    private final synchronized void g() {
        if (this.r) {
            zzk.zzli();
            setLayerType(0, null);
        }
        this.r = false;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final synchronized void destroy() {
        j();
        this.L.zzwu();
        if (this.k != null) {
            this.k.close();
            this.k.onDestroy();
            this.k = null;
        }
        this.l = null;
        this.j.reset();
        if (this.p) {
            return;
        }
        zzk.zzmc();
        zzbfs.zzc(this);
        i();
        this.p = true;
        zzawz.zzds("Initiating WebView self destruct sequence in 3...");
        zzawz.zzds("Loading blank page in WebView, 2...");
        b("about:blank");
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.p) {
                    this.j.reset();
                    zzk.zzmc();
                    zzbfs.zzc(this);
                    i();
                    h();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzaao() {
        zzawz.zzds("Destroying WebView!");
        h();
        zzaxi.zzdvv.post(new ln(this));
    }

    private final synchronized void h() {
        if (!this.K) {
            this.K = true;
            zzk.zzlk().zzva();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean isDestroyed() {
        return this.p;
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaas() {
        if (this.G == null) {
            this.G = zzadb.zzb(this.H.zzqw());
            this.H.zza("native:view_load", this.G);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzawz.zzc("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            zzawz.zzc("Could not resume webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaav() {
        zzawz.zzds("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzat(boolean z) {
        this.j.zzat(z);
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzawz.zzc("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzar(boolean z) {
        this.u = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean zzaap() {
        return this.u;
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final synchronized void zzlc() {
        this.v = true;
        if (this.d != null) {
            this.d.zzlc();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final synchronized void zzld() {
        this.v = false;
        if (this.d != null) {
            this.d.zzld();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void i() {
        if (this.Q != null) {
            Iterator<zzbft> it = this.Q.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.Q = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized void zza(String str, zzbft zzbftVar) {
        if (this.Q == null) {
            this.Q = new HashMap();
        }
        this.Q.put(str, zzbftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized zzbft zzet(String str) {
        if (this.Q == null) {
            return null;
        }
        return this.Q.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized String zzyf() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized void zzyk() {
        if (this.B != null) {
            this.B.zzre();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(zzadv zzadvVar) {
        this.B = zzadvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzadg zzyc() {
        return this.F;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzadh zzyg() {
        return this.H;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.I = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(zzadx zzadxVar) {
        this.A = zzadxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized zzadx zzaat() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized zzbhq zzyb() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized void zza(zzbhq zzbhqVar) {
        if (this.x != null) {
            zzawz.zzen("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.x = zzbhqVar;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean zzaaq() {
        return this.C > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzas(boolean z) {
        this.C += z ? 1 : -1;
        if (this.C <= 0 && this.k != null) {
            this.k.zztn();
        }
    }

    private final void j() {
        zzadi zzqw;
        zzadh zzadhVar = this.H;
        if (zzadhVar == null || (zzqw = zzadhVar.zzqw()) == null || zzk.zzlk().zzuw() == null) {
            return;
        }
        zzk.zzlk().zzuw().zza(zzqw);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaau() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzao(boolean z) {
        this.j.zzao(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zztm() {
        com.google.android.gms.ads.internal.overlay.zzd zzaae = zzaae();
        if (zzaae != null) {
            zzaae.zztm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int zzyi() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int zzyj() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.j.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zzc(boolean z, int i) {
        this.j.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(boolean z, int i, String str) {
        this.j.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(boolean z, int i, String str, String str2) {
        this.j.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void zza(zzud zzudVar) {
        synchronized (this) {
            this.y = zzudVar.zzbtk;
        }
        a(zzudVar.zzbtk);
    }

    private final void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(String str, zzaho<? super zzbgz> zzahoVar) {
        zzbha zzbhaVar = this.j;
        if (zzbhaVar != null) {
            zzbhaVar.zza(str, zzahoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzb(String str, zzaho<? super zzbgz> zzahoVar) {
        zzbha zzbhaVar = this.j;
        if (zzbhaVar != null) {
            zzbhaVar.zzb(str, zzahoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        zzbha zzbhaVar = this.j;
        if (zzbhaVar != null) {
            zzbhaVar.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzb(final boolean z, final int i) {
        destroy();
        this.S.zza(new zzwk(z, i) { // from class: com.google.android.gms.internal.ads.ll

            /* renamed from: a, reason: collision with root package name */
            private final boolean f2319a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2319a = z;
                this.b = i;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void zza(zzxn zzxnVar) {
                lk.a(this.f2319a, this.b, zzxnVar);
            }
        });
        this.S.zza(zzwl.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final /* synthetic */ zzbii zzaai() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(boolean z, int i, zzxn zzxnVar) {
        zzwt.zzv.zza zzop = zzwt.zzv.zzop();
        if (zzop.zzoo() != z) {
            zzop.zzr(z);
        }
        zzop.zzcm(i);
        zzxnVar.zzcfn = (zzwt.zzv) ((zzdob) zzop.zzaya());
    }
}
