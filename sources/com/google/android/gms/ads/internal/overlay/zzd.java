package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.util.Mimetypes;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzaqb;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzwj;
import com.google.android.gms.internal.ads.zzyt;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.Collections;

@zzard
/* loaded from: classes.dex */
public class zzd extends zzaqh implements zzx {

    @VisibleForTesting
    private static final int e = Color.argb(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    protected final Activity f1156a;

    @VisibleForTesting
    AdOverlayInfoParcel b;

    @VisibleForTesting
    zzbgz c;

    @VisibleForTesting
    private zzj f;

    @VisibleForTesting
    private zzp g;

    @VisibleForTesting
    private FrameLayout i;

    @VisibleForTesting
    private WebChromeClient.CustomViewCallback j;

    @VisibleForTesting
    private d m;
    private Runnable p;
    private boolean q;
    private boolean r;

    @VisibleForTesting
    private boolean h = false;

    @VisibleForTesting
    private boolean k = false;

    @VisibleForTesting
    private boolean l = false;

    @VisibleForTesting
    private boolean n = false;

    @VisibleForTesting
    int d = 0;
    private final Object o = new Object();
    private boolean s = false;
    private boolean t = false;
    private boolean u = true;

    public zzd(Activity activity) {
        this.f1156a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onRestart() {
    }

    public final void close() {
        this.d = 2;
        this.f1156a.finish();
    }

    public final void zzte() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel != null && this.h) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.i != null) {
            this.f1156a.setContentView(this.m);
            this.r = true;
            this.i.removeAllViews();
            this.i = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.j;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.j = null;
        }
        this.h = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zztf() {
        this.d = 1;
        this.f1156a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onBackPressed() {
        this.d = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final boolean zztg() {
        this.d = 0;
        zzbgz zzbgzVar = this.c;
        if (zzbgzVar == null) {
            return true;
        }
        boolean zzaap = zzbgzVar.zzaap();
        if (!zzaap) {
            this.c.zza("onbackblocked", Collections.emptyMap());
        }
        return zzaap;
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public void onCreate(Bundle bundle) {
        this.f1156a.requestWindowFeature(1);
        this.k = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.b = AdOverlayInfoParcel.zzc(this.f1156a.getIntent());
            if (this.b == null) {
                throw new zzh("Could not get info for ad overlay.");
            }
            if (this.b.zzbtc.zzdzd > 7500000) {
                this.d = 3;
            }
            if (this.f1156a.getIntent() != null) {
                this.u = this.f1156a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.b.zzdkt != null) {
                this.l = this.b.zzdkt.zzbre;
            } else {
                this.l = false;
            }
            if (this.l && this.b.zzdkt.zzbrj != -1) {
                new e(this).zzvi();
            }
            if (bundle == null) {
                if (this.b.zzdkm != null && this.u) {
                    this.b.zzdkm.zzta();
                }
                if (this.b.zzdkr != 1 && this.b.zzcgi != null) {
                    this.b.zzcgi.onAdClicked();
                }
            }
            this.m = new d(this.f1156a, this.b.zzdks, this.b.zzbtc.zzbsx);
            this.m.setId(1000);
            zzk.zzli().zzg(this.f1156a);
            switch (this.b.zzdkr) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.f = new zzj(this.b.zzdbs);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                default:
                    throw new zzh("Could not determine ad overlay type.");
            }
        } catch (zzh e2) {
            zzawz.zzep(e2.getMessage());
            this.d = 3;
            this.f1156a.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStart() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue()) {
            zzbgz zzbgzVar = this.c;
            if (zzbgzVar != null && !zzbgzVar.isDestroyed()) {
                zzk.zzli();
                zzaxo.zzb(this.c);
            } else {
                zzawz.zzep("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onResume() {
        if (this.b.zzdkm != null) {
            this.b.zzdkm.onResume();
        }
        a(this.f1156a.getResources().getConfiguration());
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue()) {
            return;
        }
        zzbgz zzbgzVar = this.c;
        if (zzbgzVar != null && !zzbgzVar.isDestroyed()) {
            zzk.zzli();
            zzaxo.zzb(this.c);
        } else {
            zzawz.zzep("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onPause() {
        zzte();
        if (this.b.zzdkm != null) {
            this.b.zzdkm.onPause();
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue() && this.c != null && (!this.f1156a.isFinishing() || this.f == null)) {
            zzk.zzli();
            zzaxo.zza(this.c);
        }
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzac(IObjectWrapper iObjectWrapper) {
        a((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.k);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onStop() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue() && this.c != null && (!this.f1156a.isFinishing() || this.f == null)) {
            zzk.zzli();
            zzaxo.zza(this.c);
        }
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void onDestroy() {
        zzbgz zzbgzVar = this.c;
        if (zzbgzVar != null) {
            this.m.removeView(zzbgzVar.getView());
        }
        b();
    }

    private final void a(boolean z) {
        int intValue = ((Integer) zzyt.zzpe().zzd(zzacu.zzcuk)).intValue();
        g gVar = new g();
        gVar.e = 50;
        gVar.f1154a = z ? intValue : 0;
        gVar.b = z ? 0 : intValue;
        gVar.c = 0;
        gVar.d = intValue;
        this.g = new zzp(this.f1156a, gVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.b.zzdko);
        this.m.addView(this.g, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzaqg
    public final void zzdd() {
        this.r = true;
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcpe)).booleanValue() && (adOverlayInfoParcel2 = this.b) != null && adOverlayInfoParcel2.zzdkt != null && this.b.zzdkt.zzbrl;
        boolean z5 = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcpf)).booleanValue() && (adOverlayInfoParcel = this.b) != null && adOverlayInfoParcel.zzdkt != null && this.b.zzdkt.zzbrm;
        if (z && z2 && z4 && !z5) {
            new zzaqb(this.c, "useCustomClose").zzdh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzp zzpVar = this.g;
        if (zzpVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzpVar.zzaf(z3);
        }
    }

    public final void zzth() {
        this.m.removeView(this.g);
        a(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.f1156a.getApplicationInfo().targetSdkVersion >= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwg)).intValue()) {
            if (this.f1156a.getApplicationInfo().targetSdkVersion <= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwh)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwi)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwj)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.f1156a.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzk.zzlk().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.i = new FrameLayout(this.f1156a);
        this.i.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.i.addView(view, -1, -1);
        this.f1156a.setContentView(this.i);
        this.r = true;
        this.j = customViewCallback;
        this.h = true;
    }

    private final void b(boolean z) throws zzh {
        if (!this.r) {
            this.f1156a.requestWindowFeature(1);
        }
        Window window = this.f1156a.getWindow();
        if (window == null) {
            throw new zzh("Invalid activity, no window available.");
        }
        zzbii zzaai = this.b.zzdbs != null ? this.b.zzdbs.zzaai() : null;
        boolean z2 = zzaai != null && zzaai.zzaay();
        this.n = false;
        if (z2) {
            int i = this.b.orientation;
            zzk.zzli();
            if (i == 6) {
                this.n = this.f1156a.getResources().getConfiguration().orientation == 1;
            } else {
                int i2 = this.b.orientation;
                zzk.zzli();
                if (i2 == 7) {
                    this.n = this.f1156a.getResources().getConfiguration().orientation == 2;
                }
            }
        }
        boolean z3 = this.n;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Delay onShow to next orientation change: ");
        sb.append(z3);
        zzawz.zzdp(sb.toString());
        setRequestedOrientation(this.b.orientation);
        zzk.zzli();
        window.setFlags(SpecialCallActivity.FLAG_HARDWARE_ACCELERATED, SpecialCallActivity.FLAG_HARDWARE_ACCELERATED);
        zzawz.zzdp("Hardware acceleration on the AdActivity window enabled.");
        if (!this.l) {
            this.m.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        } else {
            this.m.setBackgroundColor(e);
        }
        this.f1156a.setContentView(this.m);
        this.r = true;
        if (z) {
            try {
                zzk.zzlh();
                this.c = zzbhf.zza(this.f1156a, this.b.zzdbs != null ? this.b.zzdbs.zzaag() : null, this.b.zzdbs != null ? this.b.zzdbs.zzaah() : null, true, z2, null, this.b.zzbtc, null, null, this.b.zzdbs != null ? this.b.zzdbs.zzye() : null, zzwj.zznl());
                this.c.zzaai().zza(null, this.b.zzczo, null, this.b.zzczp, this.b.zzdkq, true, null, this.b.zzdbs != null ? this.b.zzdbs.zzaai().zzaax() : null, null, null);
                this.c.zzaai().zza(new zzbij(this) { // from class: com.google.android.gms.ads.internal.overlay.a

                    /* renamed from: a, reason: collision with root package name */
                    private final zzd f1149a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1149a = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbij
                    public final void zzae(boolean z4) {
                        zzd zzdVar = this.f1149a;
                        if (zzdVar.c != null) {
                            zzdVar.c.zztl();
                        }
                    }
                });
                if (this.b.url != null) {
                    this.c.loadUrl(this.b.url);
                } else if (this.b.zzdkp != null) {
                    this.c.loadDataWithBaseURL(this.b.zzdkn, this.b.zzdkp, Mimetypes.MIMETYPE_HTML, "UTF-8", null);
                } else {
                    throw new zzh("No URL or HTML to display in ad overlay.");
                }
                if (this.b.zzdbs != null) {
                    this.b.zzdbs.zzb(this);
                }
            } catch (Exception e2) {
                zzawz.zzc("Error obtaining webview.", e2);
                throw new zzh("Could not obtain webview for the overlay.");
            }
        } else {
            this.c = this.b.zzdbs;
            this.c.zzbn(this.f1156a);
        }
        this.c.zza(this);
        if (this.b.zzdbs != null) {
            a(this.b.zzdbs.zzaam(), this.m);
        }
        ViewParent parent = this.c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.c.getView());
        }
        if (this.l) {
            this.c.zzaau();
        }
        this.m.addView(this.c.getView(), -1, -1);
        if (!z && !this.n) {
            c();
        }
        a(z2);
        if (this.c.zzaak()) {
            zza(z2, true);
        }
    }

    private final void b() {
        if (!this.f1156a.isFinishing() || this.s) {
            return;
        }
        this.s = true;
        zzbgz zzbgzVar = this.c;
        if (zzbgzVar != null) {
            zzbgzVar.zzdi(this.d);
            synchronized (this.o) {
                if (!this.q && this.c.zzaaq()) {
                    this.p = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.b

                        /* renamed from: a, reason: collision with root package name */
                        private final zzd f1150a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f1150a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1150a.a();
                        }
                    };
                    zzaxi.zzdvv.postDelayed(this.p, ((Long) zzyt.zzpe().zzd(zzacu.zzcpd)).longValue());
                    return;
                }
            }
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a() {
        if (this.t) {
            return;
        }
        this.t = true;
        zzbgz zzbgzVar = this.c;
        if (zzbgzVar != null) {
            this.m.removeView(zzbgzVar.getView());
            zzj zzjVar = this.f;
            if (zzjVar != null) {
                this.c.zzbn(zzjVar.zzlj);
                this.c.zzaq(false);
                this.f.parent.addView(this.c.getView(), this.f.index, this.f.zzdkh);
                this.f = null;
            } else if (this.f1156a.getApplicationContext() != null) {
                this.c.zzbn(this.f1156a.getApplicationContext());
            }
            this.c = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzdkm != null) {
            this.b.zzdkm.zzsz();
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
        if (adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdbs == null) {
            return;
        }
        a(this.b.zzdbs.zzaam(), this.b.zzdbs.getView());
    }

    private static void a(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper == null || view == null) {
            return;
        }
        zzk.zzlv().zza(iObjectWrapper, view);
    }

    public final void zztk() {
        if (this.n) {
            this.n = false;
            c();
        }
    }

    private final void c() {
        this.c.zztl();
    }

    public final void zztm() {
        this.m.f1151a = true;
    }

    public final void zztn() {
        synchronized (this.o) {
            this.q = true;
            if (this.p != null) {
                zzaxi.zzdvv.removeCallbacks(this.p);
                zzaxi.zzdvv.post(this.p);
            }
        }
    }

    private final void a(Configuration configuration) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = this.b.zzdkt != null && this.b.zzdkt.zzbrf;
        boolean zza = zzk.zzli().zza(this.f1156a, configuration);
        if ((this.l && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && this.b.zzdkt != null && this.b.zzdkt.zzbrk) {
            z2 = true;
        }
        Window window = this.f1156a.getWindow();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcpg)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (z) {
            window.addFlags(1024);
            window.clearFlags(ProgressEvent.PART_COMPLETED_EVENT_CODE);
            if (Build.VERSION.SDK_INT < 19 || !z2) {
                return;
            }
            window.getDecorView().setSystemUiVisibility(4098);
            return;
        }
        window.addFlags(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        window.clearFlags(1024);
    }
}
