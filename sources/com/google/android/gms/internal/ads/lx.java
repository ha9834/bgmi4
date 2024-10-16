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
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@VisibleForTesting
@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class lx extends zzbjb implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzajq, zzbgz {
    private zzadg A;
    private zzadg B;
    private zzadh C;
    private WeakReference<View.OnClickListener> D;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzd E;
    private zzazs F;
    private final AtomicReference<IObjectWrapper> G;
    private int H;
    private int I;
    private int J;
    private int K;
    private Map<String, zzbft> L;
    private final WindowManager M;

    /* renamed from: a, reason: collision with root package name */
    private final zzbim f2331a;
    private final zzbio b;
    private final zzdh c;
    private final zzbai d;
    private final zzj e;
    private final com.google.android.gms.ads.internal.zza f;
    private final DisplayMetrics g;
    private final zzwj h;

    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzd i;

    @GuardedBy("this")
    private zzbin j;

    @GuardedBy("this")
    private String k;

    @GuardedBy("this")
    private boolean l;

    @GuardedBy("this")
    private boolean m;

    @GuardedBy("this")
    private boolean n;

    @GuardedBy("this")
    private int o;

    @GuardedBy("this")
    private boolean p;

    @GuardedBy("this")
    private boolean q;

    @GuardedBy("this")
    private String r;

    @GuardedBy("this")
    private zzbhq s;

    @GuardedBy("this")
    private boolean t;

    @GuardedBy("this")
    private boolean u;

    @GuardedBy("this")
    private zzadx v;

    @GuardedBy("this")
    private zzadv w;

    @GuardedBy("this")
    private int x;

    @GuardedBy("this")
    private int y;
    private zzadg z;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public lx(zzbim zzbimVar, zzbio zzbioVar, zzbin zzbinVar, String str, boolean z, boolean z2, zzdh zzdhVar, zzbai zzbaiVar, zzadi zzadiVar, zzj zzjVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar) {
        super(zzbimVar, zzbioVar);
        this.p = true;
        this.q = false;
        this.r = "";
        this.G = new AtomicReference<>();
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.f2331a = zzbimVar;
        this.b = zzbioVar;
        this.j = zzbinVar;
        this.k = str;
        this.m = z;
        this.o = -1;
        this.c = zzdhVar;
        this.d = zzbaiVar;
        this.e = zzjVar;
        this.f = zzaVar;
        this.M = (WindowManager) getContext().getSystemService("window");
        zzk.zzlg();
        this.g = zzaxi.zza(this.M);
        this.h = zzwjVar;
        this.F = new zzazs(this.f2331a.zzyd(), this, this, null);
        zzk.zzlg().zza(zzbimVar, zzbaiVar.zzbsx, getSettings());
        setDownloadListener(this);
        d();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbht.zzc(this), "googleAdsJsInterface");
        }
        h();
        this.C = new zzadh(new zzadi(true, "make_wv", this.k));
        this.C.zzqw().zzc(zzadiVar);
        this.A = zzadb.zzb(this.C.zzqw());
        this.C.zza("native:view_create", this.A);
        this.B = null;
        this.z = null;
        zzk.zzli().zzay(zzbimVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbih
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, Map map) {
        zzajr.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, com.google.android.gms.internal.ads.zzbgz
    public final void zzaao() {
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzaaw() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zzi(String str, String str2) {
        zzajr.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbcw zzya() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final com.google.android.gms.ads.internal.zza zzye() {
        return this.f;
    }

    private final boolean b() {
        int i;
        int i2;
        if (!this.b.zzaay() && !this.b.zzaaz()) {
            return false;
        }
        zzyt.zzpa();
        DisplayMetrics displayMetrics = this.g;
        int zzb = zzazt.zzb(displayMetrics, displayMetrics.widthPixels);
        zzyt.zzpa();
        DisplayMetrics displayMetrics2 = this.g;
        int zzb2 = zzazt.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzyd = this.f2331a.zzyd();
        if (zzyd == null || zzyd.getWindow() == null) {
            i = zzb;
            i2 = zzb2;
        } else {
            zzk.zzlg();
            int[] zzd = zzaxi.zzd(zzyd);
            zzyt.zzpa();
            int zzb3 = zzazt.zzb(this.g, zzd[0]);
            zzyt.zzpa();
            i2 = zzazt.zzb(this.g, zzd[1]);
            i = zzb3;
        }
        if (this.I == zzb && this.H == zzb2 && this.J == i && this.K == i2) {
            return false;
        }
        boolean z = (this.I == zzb && this.H == zzb2) ? false : true;
        this.I = zzb;
        this.H = zzb2;
        this.J = i;
        this.K = i2;
        new zzaqb(this).zza(zzb, zzb2, i, i2, this.g.density, this.M.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzb(String str, String str2, String str3) {
        super.loadDataWithBaseURL(str, ((Boolean) zzyt.zzpe().zzd(zzacu.zzcok)).booleanValue() ? zzbid.zzf(str2, zzbid.zzabt()) : str2, Mimetypes.MIMETYPE_HTML, "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, com.google.android.gms.internal.ads.ma, com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final synchronized void zzco(String str) {
        if (!isDestroyed()) {
            super.zzco(str);
        } else {
            zzawz.zzep("The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaab() {
        c();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.d.zzbsx);
        zzajr.zza(this, "onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzdi(int i) {
        if (i == 0) {
            zzadb.zza(this.C.zzqw(), this.A, "aebb2");
        }
        c();
        if (this.C.zzqw() != null) {
            this.C.zzqw().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.d.zzbsx);
        zzajr.zza(this, "onhide", hashMap);
    }

    private final void c() {
        zzadb.zza(this.C.zzqw(), this.A, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zztl() {
        if (this.z == null) {
            zzadb.zza(this.C.zzqw(), this.A, "aes2");
            this.z = zzadb.zzb(this.C.zzqw());
            this.C.zza("native:view_show", this.z);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.d.zzbsx);
        zzajr.zza(this, "onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaac() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzk.zzll().zzpr()));
        hashMap.put("app_volume", String.valueOf(zzk.zzll().zzpq()));
        hashMap.put("device_volume", String.valueOf(zzaya.zzba(getContext())));
        zzajr.zza(this, "volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzajr.zza(this, "onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzaae() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final IObjectWrapper zzaam() {
        return this.G.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd zzaaf() {
        return this.E;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbie
    public final synchronized zzbin zzaag() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized String zzaah() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebViewClient zzaaj() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean zzaak() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbif
    public final zzdh zzaal() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbig
    public final zzbai zzyh() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbhy
    public final synchronized boolean zzaan() {
        return this.m;
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

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b.zzaaz()) {
            synchronized (this) {
                if (this.v != null) {
                    this.v.zzc(motionEvent);
                }
            }
        } else {
            zzdh zzdhVar = this.c;
            if (zzdhVar != null) {
                zzdhVar.zza(motionEvent);
            }
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d8 A[Catch: all -> 0x01f3, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0155, B:94:0x0172, B:96:0x01cf, B:97:0x01d3, B:100:0x01d8, B:102:0x01de, B:103:0x01e1, B:109:0x01ee), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141 A[Catch: all -> 0x01f3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0155, B:94:0x0172, B:96:0x01cf, B:97:0x01d3, B:100:0x01d8, B:102:0x01de, B:103:0x01e1, B:109:0x01ee), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0172 A[Catch: all -> 0x01f3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:40:0x0084, B:45:0x0080, B:47:0x0091, B:49:0x0099, B:51:0x00ab, B:54:0x00b2, B:56:0x00ca, B:57:0x00d9, B:60:0x00d5, B:61:0x00de, B:64:0x00e3, B:66:0x00eb, B:69:0x00f8, B:76:0x011e, B:78:0x0125, B:82:0x012f, B:84:0x0141, B:86:0x0155, B:94:0x0172, B:96:0x01cf, B:97:0x01d3, B:100:0x01d8, B:102:0x01de, B:103:0x01e1, B:109:0x01ee), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.lx.onMeasure(int, int):void");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean b = b();
        com.google.android.gms.ads.internal.overlay.zzd zzaae = zzaae();
        if (zzaae == null || !b) {
            return;
        }
        zzaae.zztk();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.i = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.G.set(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.E = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(zzbin zzbinVar) {
        this.j = zzbinVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzaq(boolean z) {
        boolean z2 = z != this.m;
        this.m = z;
        d();
        if (z2) {
            new zzaqb(this).zzdj(z ? "expanded" : com.huawei.game.gamekit.b.a.f5471a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaar() {
        this.F.zzwt();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.F.onAttachedToWindow();
        }
        boolean z = this.t;
        if (this.b != null && this.b.zzaaz()) {
            if (!this.u) {
                this.b.zzaba();
                this.b.zzabb();
                this.u = true;
            }
            b();
            z = true;
        }
        b(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.F.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.u && this.b != null && this.b.zzaaz() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.b.zzaba();
                this.b.zzabb();
                this.u = false;
            }
        }
        b(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzbn(Context context) {
        this.f2331a.setBaseContext(context);
        this.F.zzh(this.f2331a.zzyd());
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzaf(boolean z) {
        if (this.i != null) {
            this.i.zza(this.b.zzaay(), z);
        } else {
            this.l = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void setRequestedOrientation(int i) {
        this.o = i;
        if (this.i != null) {
            this.i.setRequestedOrientation(this.o);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    public final Activity zzyd() {
        return this.f2331a.zzyd();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final Context zzaad() {
        return this.f2331a.zzaad();
    }

    private final synchronized void d() {
        if (!this.m && !this.j.zzabx()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzawz.zzdp("Disabling hardware acceleration on an AdView.");
                e();
                return;
            } else {
                zzawz.zzdp("Enabling hardware acceleration on an AdView.");
                f();
                return;
            }
        }
        zzawz.zzdp("Enabling hardware acceleration on an overlay.");
        f();
    }

    private final synchronized void e() {
        if (!this.n) {
            zzk.zzli();
            setLayerType(1, null);
        }
        this.n = true;
    }

    private final synchronized void f() {
        if (this.n) {
            zzk.zzli();
            setLayerType(0, null);
        }
        this.n = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbjb
    protected final synchronized void a(boolean z) {
        if (!z) {
            h();
            this.F.zzwu();
            if (this.i != null) {
                this.i.close();
                this.i.onDestroy();
                this.i = null;
            }
        }
        this.G.set(null);
        this.b.destroy();
        zzk.zzmc();
        zzbfs.zzc(this);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, android.view.View
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaas() {
        if (this.B == null) {
            this.B = zzadb.zzb(this.C.zzqw());
            this.C.zza("native:view_load", this.B);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzawz.zzc("Could not pause webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void onResume() {
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
        this.b.zzat(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzawz.zzc("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzar(boolean z) {
        this.p = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean zzaap() {
        return this.p;
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final synchronized void zzlc() {
        this.q = true;
        if (this.e != null) {
            this.e.zzlc();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final synchronized void zzld() {
        this.q = false;
        if (this.e != null) {
            this.e.zzld();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void g() {
        if (this.L != null) {
            Iterator<zzbft> it = this.L.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.L = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized void zza(String str, zzbft zzbftVar) {
        if (this.L == null) {
            this.L = new HashMap();
        }
        this.L.put(str, zzbftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized zzbft zzet(String str) {
        if (this.L == null) {
            return null;
        }
        return this.L.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized String zzyf() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzadg zzyc() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzadh zzyg() {
        return this.C;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.D = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(zzadx zzadxVar) {
        this.v = zzadxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized zzadx zzaat() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized void zzyk() {
        if (this.w != null) {
            this.w.zzre();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zza(zzadv zzadvVar) {
        this.w = zzadvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized zzbhq zzyb() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized void zza(zzbhq zzbhqVar) {
        if (this.s != null) {
            zzawz.zzen("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.s = zzbhqVar;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean zzaaq() {
        return this.x > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void zzas(boolean z) {
        this.x += z ? 1 : -1;
        if (this.x <= 0 && this.i != null) {
            this.i.zztn();
        }
    }

    private final void h() {
        zzadi zzqw;
        zzadh zzadhVar = this.C;
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
        this.b.zzao(z);
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
        this.b.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zzc(boolean z, int i) {
        this.b.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(boolean z, int i, String str) {
        this.b.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(boolean z, int i, String str, String str2) {
        this.b.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void zza(zzud zzudVar) {
        synchronized (this) {
            this.t = zzudVar.zzbtk;
        }
        b(zzudVar.zzbtk);
    }

    private final void b(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzajr.zza(this, "onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(String str, zzaho<? super zzbgz> zzahoVar) {
        zzbio zzbioVar = this.b;
        if (zzbioVar != null) {
            zzbioVar.zza(str, zzahoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzb(String str, zzaho<? super zzbgz> zzahoVar) {
        zzbio zzbioVar = this.b;
        if (zzbioVar != null) {
            zzbioVar.zzb(str, zzahoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        zzbio zzbioVar = this.b;
        if (zzbioVar != null) {
            zzbioVar.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzb(final boolean z, final int i) {
        destroy();
        this.h.zza(new zzwk(z, i) { // from class: com.google.android.gms.internal.ads.ly

            /* renamed from: a, reason: collision with root package name */
            private final boolean f2332a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2332a = z;
                this.b = i;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void zza(zzxn zzxnVar) {
                lx.a(this.f2332a, this.b, zzxnVar);
            }
        });
        this.h.zza(zzwl.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final /* synthetic */ zzbii zzaai() {
        return this.b;
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
