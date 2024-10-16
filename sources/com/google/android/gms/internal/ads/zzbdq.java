package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import javax.annotation.ParametersAreNonnullByDefault;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.SideEffectFree;

@zzard
@ParametersAreNonnullByDefault
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzbdq extends zzbco implements TextureView.SurfaceTextureListener {
    private int A;
    private final zzgh B;
    private final zzhh C;
    private final zzgq D;
    private float c;
    private final zzbdf d;
    private final Context e;
    private final int f;
    private final zzbdg g;
    private final boolean h;
    private final zzbde i;
    private zzbcn j;
    private Surface k;
    private zzbdk l;
    private zzge m;
    private zzhd n;
    private zzgn o;
    private String p;
    private boolean q;
    private int r;
    private zzbdd s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private float y;
    private int z;

    public zzbdq(Context context, zzbdg zzbdgVar, zzbdf zzbdfVar, int i, boolean z, boolean z2, zzbde zzbdeVar) {
        super(context);
        this.r = 1;
        this.B = new jh(this);
        this.C = new ji(this);
        this.D = new jj(this);
        this.e = context;
        this.h = z2;
        this.d = zzbdfVar;
        this.f = i;
        this.g = zzbdgVar;
        this.t = z;
        this.i = zzbdeVar;
        setSurfaceTextureListener(this);
        this.g.zzb(this);
    }

    @EnsuresNonNullIf(expression = {"mPlayer"}, result = true)
    private final boolean g() {
        return (this.m == null || this.q) ? false : true;
    }

    @EnsuresNonNullIf(expression = {"mPlayer"}, result = true)
    private final boolean h() {
        return g() && this.r != 1;
    }

    private final void i() {
        String str;
        zzhn zzigVar;
        zzjp zzjpVar;
        zzig zzigVar2;
        if (this.m != null || (str = this.p) == null || this.k == null) {
            return;
        }
        zzbdk zzbdkVar = null;
        if (str.startsWith("cache:")) {
            zzbft zzet = this.d.zzet(this.p);
            if (zzet != null && (zzet instanceof zzbgl)) {
                zzbgl zzbglVar = (zzbgl) zzet;
                zzbglVar.zzzx();
                zzbdkVar = zzbglVar.zzzy();
                zzbdkVar.zza(this.B, this.C, this.D);
            } else if (zzet instanceof zzbgg) {
                zzbgg zzbggVar = (zzbgg) zzet;
                ByteBuffer byteBuffer = zzbggVar.getByteBuffer();
                String url = zzbggVar.getUrl();
                boolean zzzv = zzbggVar.zzzv();
                zzbdk zzbdkVar2 = new zzbdk();
                zzid zzjgVar = "video/webm".equals(null) ? new zzjg() : new zziv();
                if (zzzv && byteBuffer.limit() > 0) {
                    byte[] bArr = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr);
                    zzigVar2 = new zzig(Uri.parse(url), new zzjo(bArr), zzjgVar, 2, this.i.zzeee);
                } else {
                    zzjt zzjtVar = new zzjt(this.d.getContext(), zzk.zzlg().zzq(this.d.getContext(), this.d.zzyh().zzbsx));
                    zzjp zzbehVar = ((Boolean) zzyt.zzpe().zzd(zzacu.zzctr)).booleanValue() ? new zzbeh(this.e, zzjtVar, new zzbei(this) { // from class: com.google.android.gms.internal.ads.iv

                        /* renamed from: a, reason: collision with root package name */
                        private final zzbdq f2250a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2250a = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbei
                        public final void zzd(final boolean z, final long j) {
                            final zzbdq zzbdqVar = this.f2250a;
                            zzbbm.zzeae.execute(new Runnable(zzbdqVar, z, j) { // from class: com.google.android.gms.internal.ads.ix

                                /* renamed from: a, reason: collision with root package name */
                                private final zzbdq f2252a;
                                private final boolean b;
                                private final long c;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f2252a = zzbdqVar;
                                    this.b = z;
                                    this.c = j;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f2252a.a(this.b, this.c);
                                }
                            });
                        }
                    }) : zzjtVar;
                    if (byteBuffer.limit() > 0) {
                        byte[] bArr2 = new byte[byteBuffer.limit()];
                        byteBuffer.get(bArr2);
                        zzjpVar = new jk(new zzjo(bArr2), bArr2.length, zzbehVar);
                    } else {
                        zzjpVar = zzbehVar;
                    }
                    zzigVar2 = new zzig(Uri.parse(url), zzjpVar, zzjgVar, 2, this.i.zzeee);
                }
                zzbdkVar2.zza(this.B, this.C, this.D);
                if (!zzbdkVar2.zza(zzigVar2)) {
                    b("AdExoPlayerHelper Error", "Prepare from ByteBuffer failed.");
                }
                zzbdkVar = zzbdkVar2;
            } else {
                String valueOf = String.valueOf(this.p);
                zzawz.zzep(valueOf.length() != 0 ? "Source is MD5 but not found in cache. Source: ".concat(valueOf) : new String("Source is MD5 but not found in cache. Source: "));
            }
        } else {
            int i = this.f;
            if (i == 1) {
                zzigVar = new zzgl(this.d.getContext(), Uri.parse(this.p), null, 2);
            } else {
                Preconditions.checkArgument(i == 2);
                zzjp zzjtVar2 = new zzjt(this.d.getContext(), zzk.zzlg().zzq(this.d.getContext(), this.d.zzyh().zzbsx));
                zzigVar = new zzig(Uri.parse(this.p), ((Boolean) zzyt.zzpe().zzd(zzacu.zzctr)).booleanValue() ? new zzbeh(this.e, zzjtVar2, new zzbei(this) { // from class: com.google.android.gms.internal.ads.iu

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbdq f2249a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2249a = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbei
                    public final void zzd(final boolean z, final long j) {
                        final zzbdq zzbdqVar = this.f2249a;
                        zzbbm.zzeae.execute(new Runnable(zzbdqVar, z, j) { // from class: com.google.android.gms.internal.ads.iy

                            /* renamed from: a, reason: collision with root package name */
                            private final zzbdq f2253a;
                            private final boolean b;
                            private final long c;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f2253a = zzbdqVar;
                                this.b = z;
                                this.c = j;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f2253a.b(this.b, this.c);
                            }
                        });
                    }
                }) : zzjtVar2, "video/webm".equals(null) ? new zzjg() : new zziv(), 2, this.i.zzeee);
            }
            zzbdkVar = new zzbdk();
            zzbdkVar.zza(this.B, this.C, this.D);
            if (!zzbdkVar.zza(zzigVar)) {
                b("AdExoPlayerHelper Error", "Prepare failed.");
            }
        }
        this.l = zzbdkVar;
        zzbdk zzbdkVar3 = this.l;
        if (zzbdkVar3 == null) {
            String valueOf2 = String.valueOf(this.p);
            zzawz.zzep(valueOf2.length() != 0 ? "AdExoPlayerHelper is null. Source: ".concat(valueOf2) : new String("AdExoPlayerHelper is null. Source: "));
            return;
        }
        this.m = zzbdkVar3.zzys();
        this.n = this.l.zzyt();
        this.o = this.l.zzyu();
        if (this.m != null) {
            a(this.k, false);
            this.r = this.m.getPlaybackState();
            if (this.r == 4) {
                j();
            }
        }
    }

    @SideEffectFree
    private final void a(Surface surface, boolean z) {
        zzhd zzhdVar;
        zzge zzgeVar = this.m;
        if (zzgeVar == null || (zzhdVar = this.n) == null) {
            zzawz.zzep("Trying to set surface before player and renderers are initalized.");
        } else if (z) {
            zzgeVar.zzb(zzhdVar, 1, surface);
        } else {
            zzgeVar.zza(zzhdVar, 1, surface);
        }
    }

    @SideEffectFree
    private final void a(float f, boolean z) {
        zzgn zzgnVar;
        zzge zzgeVar = this.m;
        if (zzgeVar == null || (zzgnVar = this.o) == null) {
            zzawz.zzep("Trying to set volume before player and renderers are initalized.");
        } else if (z) {
            zzgeVar.zzb(zzgnVar, 1, Float.valueOf(f));
        } else {
            zzgeVar.zza(zzgnVar, 1, Float.valueOf(f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco, com.google.android.gms.internal.ads.ip
    public final void zzxk() {
        a(this.b.getVolume(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2, float f) {
        float f2 = i2 == 0 ? 1.0f : (i * f) / i2;
        if (this.c != f2) {
            this.c = f2;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.u) {
            return;
        }
        this.u = true;
        zzawz.zzds("Video is ready.");
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.iz

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2254a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2254a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2254a.f();
            }
        });
        zzxk();
        this.g.zzhd();
        if (this.v) {
            play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        zzawz.zzds("Video ended.");
        if (this.i.zzeec) {
            m();
        }
        this.g.zzym();
        this.b.zzym();
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ja

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2256a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2256a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2256a.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final String str, final String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(str2).length());
        sb.append("Error received: ");
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        zzawz.zzep(sb.toString());
        this.q = true;
        if (this.i.zzeec) {
            m();
        }
        zzaxi.zzdvv.post(new Runnable(this, str, str2) { // from class: com.google.android.gms.internal.ads.jb

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2257a;
            private final String b;
            private final String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2257a = this;
                this.b = str;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2257a.a(this.b, this.c);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String zzxg() {
        String str;
        int i = this.f;
        if (i == 1) {
            str = "/Framework";
        } else if (i == 2) {
            StringBuilder sb = new StringBuilder(String.valueOf((Object) null).length() + 12);
            sb.append("/Extractor(");
            sb.append((String) null);
            sb.append(")");
            str = sb.toString();
        } else {
            str = "/Unknown";
        }
        String str2 = this.t ? " spherical" : "";
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str2).length());
        sb2.append("ExoPlayer/1");
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zza(zzbcn zzbcnVar) {
        this.j = zzbcnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void setVideoPath(String str) {
        if (str != null) {
            this.p = str;
            i();
        } else {
            zzawz.zzep("Path is null.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void play() {
        if (h()) {
            if (this.i.zzeec) {
                l();
            }
            this.m.zzd(true);
            this.g.zzyl();
            this.b.zzyl();
            this.f2854a.zzxm();
            zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jc

                /* renamed from: a, reason: collision with root package name */
                private final zzbdq f2258a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2258a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2258a.d();
                }
            });
            return;
        }
        this.v = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void stop() {
        if (g()) {
            this.m.stop();
            if (this.m != null) {
                a((Surface) null, true);
                zzbdk zzbdkVar = this.l;
                if (zzbdkVar != null) {
                    zzbdkVar.zzyr();
                    this.l = null;
                }
                this.m = null;
                this.n = null;
                this.o = null;
                this.r = 1;
                this.q = false;
                this.u = false;
                this.v = false;
            }
        }
        this.g.zzym();
        this.b.zzym();
        this.g.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void pause() {
        if (h()) {
            if (this.i.zzeec) {
                m();
            }
            this.m.zzd(false);
            this.g.zzym();
            this.b.zzym();
            zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jd

                /* renamed from: a, reason: collision with root package name */
                private final zzbdq f2259a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2259a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2259a.c();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void seekTo(int i) {
        if (h()) {
            this.m.seekTo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zza(float f, float f2) {
        zzbdd zzbddVar = this.s;
        if (zzbddVar != null) {
            zzbddVar.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getCurrentPosition() {
        if (h()) {
            return (int) this.m.zzdn();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getDuration() {
        if (h()) {
            return (int) this.m.getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoWidth() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoHeight() {
        return this.x;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.c;
        if (f != 0.0f && this.s == null) {
            float f2 = measuredWidth;
            float f3 = measuredHeight;
            float f4 = (f / (f2 / f3)) - 1.0f;
            if (f4 > 0.01f) {
                measuredHeight = (int) (f2 / f);
            } else if (f4 < -0.01f) {
                measuredWidth = (int) (f3 * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbdd zzbddVar = this.s;
        if (zzbddVar != null) {
            zzbddVar.zzm(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i4 = this.z;
            if (((i4 > 0 && i4 != measuredWidth) || ((i3 = this.A) > 0 && i3 != measuredHeight)) && this.h && g() && this.m.zzdn() > 0 && !this.m.zzdm()) {
                a(0.0f, true);
                this.m.zzd(true);
                long zzdn = this.m.zzdn();
                long currentTimeMillis = zzk.zzln().currentTimeMillis();
                while (g() && this.m.zzdn() == zzdn && zzk.zzln().currentTimeMillis() - currentTimeMillis <= 250) {
                }
                if (g()) {
                    this.m.zzd(false);
                }
                zzxk();
            }
            this.z = measuredWidth;
            this.A = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        int i3;
        if (this.t) {
            this.s = new zzbdd(getContext());
            this.s.zza(surfaceTexture, i, i2);
            this.s.start();
            SurfaceTexture zzxy = this.s.zzxy();
            if (zzxy != null) {
                surfaceTexture = zzxy;
            } else {
                this.s.zzxx();
                this.s = null;
            }
        }
        this.k = new Surface(surfaceTexture);
        if (this.m == null) {
            i();
        } else {
            a(this.k, true);
            if (!this.i.zzeec) {
                l();
            }
        }
        float f = 1.0f;
        int i4 = this.w;
        if (i4 != 0 && (i3 = this.x) != 0) {
            f = this.y;
            i = i4;
            i2 = i3;
        }
        a(i, i2, f);
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.je

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2260a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2260a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2260a.b();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzbdd zzbddVar = this.s;
        if (zzbddVar != null) {
            zzbddVar.zzm(i, i2);
        }
        zzaxi.zzdvv.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.jf

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2261a;
            private final int b;
            private final int c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2261a = this;
                this.b = i;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2261a.a(this.b, this.c);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.zzds("Surface destroyed");
        pause();
        zzbdd zzbddVar = this.s;
        if (zzbddVar != null) {
            zzbddVar.zzxx();
            this.s = null;
        }
        if (this.m != null) {
            m();
            Surface surface = this.k;
            if (surface != null) {
                surface.release();
            }
            this.k = null;
            a((Surface) null, true);
        }
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jg

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2262a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2262a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2262a.a();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.g.zzc(this);
        this.f2854a.zza(surfaceTexture, this.j);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView1 window visibility changed to ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        zzaxi.zzdvv.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.iw

            /* renamed from: a, reason: collision with root package name */
            private final zzbdq f2251a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2251a = this;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2251a.a(this.b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    private final void l() {
        zzge zzgeVar = this.m;
        if (zzgeVar != null) {
            zzgeVar.zzc(0, true);
        }
    }

    private final void m() {
        zzge zzgeVar = this.m;
        if (zzgeVar != null) {
            zzgeVar.zzc(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i) {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzxo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, int i2) {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzk(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzxl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.onPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d() {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzxm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, String str2) {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzl(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzxn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f() {
        zzbcn zzbcnVar = this.j;
        if (zzbcnVar != null) {
            zzbcnVar.zzhd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z, long j) {
        this.d.zza(z, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(boolean z, long j) {
        this.d.zza(z, j);
    }
}
