package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.zzk;
import java.nio.ByteBuffer;
import java.util.Arrays;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbek extends zzbco implements TextureView.SurfaceTextureListener, zzbfi {
    private final zzbdf c;
    private final zzbdg d;
    private final boolean e;
    private final zzbde f;
    private zzbcn g;
    private Surface h;
    private zzbfa i;
    private String j;
    private String[] k;
    private boolean l;
    private int m;
    private zzbdd n;
    private final boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private float v;

    public zzbek(Context context, zzbdg zzbdgVar, zzbdf zzbdfVar, boolean z, boolean z2, zzbde zzbdeVar) {
        super(context);
        this.m = 1;
        this.e = z2;
        this.c = zzbdfVar;
        this.d = zzbdgVar;
        this.o = z;
        this.f = zzbdeVar;
        setSurfaceTextureListener(this);
        this.d.zzb(this);
    }

    private final zzbfa g() {
        return new zzbfa(this.c.getContext(), this.f);
    }

    private final String h() {
        return zzk.zzlg().zzq(this.c.getContext(), this.c.zzyh().zzbsx);
    }

    private final boolean i() {
        return (this.i == null || this.l) ? false : true;
    }

    private final boolean j() {
        return i() && this.m != 1;
    }

    private final void k() {
        String str;
        if (this.i != null || (str = this.j) == null || this.h == null) {
            return;
        }
        if (str.startsWith("cache:")) {
            zzbft zzet = this.c.zzet(this.j);
            if (zzet instanceof zzbgp) {
                this.i = ((zzbgp) zzet).zzaaa();
            } else if (zzet instanceof zzbgo) {
                zzbgo zzbgoVar = (zzbgo) zzet;
                String h = h();
                ByteBuffer byteBuffer = zzbgoVar.getByteBuffer();
                boolean zzzv = zzbgoVar.zzzv();
                String url = zzbgoVar.getUrl();
                if (url == null) {
                    zzawz.zzep("Stream cache URL is null.");
                    return;
                } else {
                    this.i = g();
                    this.i.zza(new Uri[]{Uri.parse(url)}, h, byteBuffer, zzzv);
                }
            } else {
                String valueOf = String.valueOf(this.j);
                zzawz.zzep(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                return;
            }
        } else {
            this.i = g();
            String h2 = h();
            Uri[] uriArr = new Uri[this.k.length];
            int i = 0;
            while (true) {
                String[] strArr = this.k;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.i.zza(uriArr, h2);
        }
        this.i.zza(this);
        a(this.h, false);
        this.m = this.i.zzzt().getPlaybackState();
        if (this.m == 3) {
            l();
        }
    }

    private final void a(Surface surface, boolean z) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.a(surface, z);
        } else {
            zzawz.zzep("Trying to set surface before player is initalized.");
        }
    }

    private final void a(float f, boolean z) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.a(f, z);
        } else {
            zzawz.zzep("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco, com.google.android.gms.internal.ads.ip
    public final void zzxk() {
        a(this.b.getVolume(), false);
    }

    private final void l() {
        if (this.p) {
            return;
        }
        this.p = true;
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jl

            /* renamed from: a, reason: collision with root package name */
            private final zzbek f2267a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2267a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2267a.f();
            }
        });
        zzxk();
        this.d.zzhd();
        if (this.q) {
            play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String zzxg() {
        String valueOf = String.valueOf("ExoPlayer/3");
        String valueOf2 = String.valueOf(this.o ? " spherical" : "");
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zza(zzbcn zzbcnVar) {
        this.g = zzbcnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void setVideoPath(String str) {
        if (str != null) {
            this.j = str;
            this.k = new String[]{str};
            k();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.j = str;
            this.k = (String[]) Arrays.copyOf(strArr, strArr.length);
            k();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void play() {
        if (j()) {
            if (this.f.zzeec) {
                n();
            }
            this.i.zzzt().zzd(true);
            this.d.zzyl();
            this.b.zzyl();
            this.f2854a.zzxm();
            zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jo

                /* renamed from: a, reason: collision with root package name */
                private final zzbek f2270a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2270a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2270a.d();
                }
            });
            return;
        }
        this.q = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void stop() {
        if (i()) {
            this.i.zzzt().stop();
            if (this.i != null) {
                a((Surface) null, true);
                zzbfa zzbfaVar = this.i;
                if (zzbfaVar != null) {
                    zzbfaVar.zza((zzbfi) null);
                    this.i.release();
                    this.i = null;
                }
                this.m = 1;
                this.l = false;
                this.p = false;
                this.q = false;
            }
        }
        this.d.zzym();
        this.b.zzym();
        this.d.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void pause() {
        if (j()) {
            if (this.f.zzeec) {
                o();
            }
            this.i.zzzt().zzd(false);
            this.d.zzym();
            this.b.zzym();
            zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jp

                /* renamed from: a, reason: collision with root package name */
                private final zzbek f2271a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2271a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2271a.c();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void seekTo(int i) {
        if (j()) {
            this.i.zzzt().seekTo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzcy(int i) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.zzzu().zzdg(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzcz(int i) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.zzzu().zzdh(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzda(int i) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.zzzu().zzda(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzdb(int i) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.zzzu().zzdb(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zzdc(int i) {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.zzdc(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zza(float f, float f2) {
        zzbdd zzbddVar = this.n;
        if (zzbddVar != null) {
            zzbddVar.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getCurrentPosition() {
        if (j()) {
            return (int) this.i.zzzt().zzdn();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getDuration() {
        if (j()) {
            return (int) this.i.zzzt().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoWidth() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoHeight() {
        return this.s;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.v;
        if (f != 0.0f && this.n == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            float f4 = this.v;
            if (f4 < f3) {
                measuredWidth = (int) (measuredHeight * f4);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbdd zzbddVar = this.n;
        if (zzbddVar != null) {
            zzbddVar.zzm(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i4 = this.t;
            if (((i4 > 0 && i4 != measuredWidth) || ((i3 = this.u) > 0 && i3 != measuredHeight)) && this.e && i()) {
                zzkv zzzt = this.i.zzzt();
                if (zzzt.zzdn() > 0 && !zzzt.zzdm()) {
                    a(0.0f, true);
                    zzzt.zzd(true);
                    long zzdn = zzzt.zzdn();
                    long currentTimeMillis = zzk.zzln().currentTimeMillis();
                    while (i() && zzzt.zzdn() == zzdn && zzk.zzln().currentTimeMillis() - currentTimeMillis <= 250) {
                    }
                    zzzt.zzd(false);
                    zzxk();
                }
            }
            this.t = measuredWidth;
            this.u = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.o) {
            this.n = new zzbdd(getContext());
            this.n.zza(surfaceTexture, i, i2);
            this.n.start();
            SurfaceTexture zzxy = this.n.zzxy();
            if (zzxy != null) {
                surfaceTexture = zzxy;
            } else {
                this.n.zzxx();
                this.n = null;
            }
        }
        this.h = new Surface(surfaceTexture);
        if (this.i == null) {
            k();
        } else {
            a(this.h, true);
            if (!this.f.zzeec) {
                n();
            }
        }
        if (this.r == 0 || this.s == 0) {
            b(i, i2);
        } else {
            m();
        }
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jq

            /* renamed from: a, reason: collision with root package name */
            private final zzbek f2272a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2272a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2272a.b();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzbdd zzbddVar = this.n;
        if (zzbddVar != null) {
            zzbddVar.zzm(i, i2);
        }
        zzaxi.zzdvv.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.jr

            /* renamed from: a, reason: collision with root package name */
            private final zzbek f2273a;
            private final int b;
            private final int c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2273a = this;
                this.b = i;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2273a.a(this.b, this.c);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d.zzc(this);
        this.f2854a.zza(surfaceTexture, this.g);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbdd zzbddVar = this.n;
        if (zzbddVar != null) {
            zzbddVar.zzxx();
            this.n = null;
        }
        if (this.i != null) {
            o();
            Surface surface = this.h;
            if (surface != null) {
                surface.release();
            }
            this.h = null;
            a((Surface) null, true);
        }
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.js

            /* renamed from: a, reason: collision with root package name */
            private final zzbek f2274a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2274a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2274a.a();
            }
        });
        return true;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        zzaxi.zzdvv.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.jt

            /* renamed from: a, reason: collision with root package name */
            private final zzbek f2275a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2275a = this;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2275a.a(this.b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzd(final boolean z, final long j) {
        if (this.c != null) {
            zzbbm.zzeae.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.ju

                /* renamed from: a, reason: collision with root package name */
                private final zzbek f2276a;
                private final boolean b;
                private final long c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2276a = this;
                    this.b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2276a.a(this.b, this.c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzde(int i) {
        if (this.m != i) {
            this.m = i;
            switch (i) {
                case 3:
                    l();
                    return;
                case 4:
                    if (this.f.zzeec) {
                        o();
                    }
                    this.d.zzym();
                    this.b.zzym();
                    zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jm

                        /* renamed from: a, reason: collision with root package name */
                        private final zzbek f2268a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2268a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2268a.e();
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzo(int i, int i2) {
        this.r = i;
        this.s = i2;
        m();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(message);
        final String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzawz.zzep(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.l = true;
        if (this.f.zzeec) {
            o();
        }
        zzaxi.zzdvv.post(new Runnable(this, sb2) { // from class: com.google.android.gms.internal.ads.jn

            /* renamed from: a, reason: collision with root package name */
            private final zzbek f2269a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2269a = this;
                this.b = sb2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2269a.a(this.b);
            }
        });
    }

    private final void m() {
        b(this.r, this.s);
    }

    private final void b(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.v != f) {
            this.v = f;
            requestLayout();
        }
    }

    private final void n() {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.a(true);
        }
    }

    private final void o() {
        zzbfa zzbfaVar = this.i;
        if (zzbfaVar != null) {
            zzbfaVar.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z, long j) {
        this.c.zza(z, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i) {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzxo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, int i2) {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzk(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzxl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.onPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d() {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzxm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzl("ExoPlayerAdapter error", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzxn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f() {
        zzbcn zzbcnVar = this.g;
        if (zzbcnVar != null) {
            zzbcnVar.zzhd();
        }
    }
}
