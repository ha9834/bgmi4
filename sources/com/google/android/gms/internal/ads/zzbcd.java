package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.android.vending.billing.util.IabHelper;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.zzk;
import com.tencent.imsdk.android.IR;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbcd extends zzbco implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> c = new HashMap();
    private final zzbdg d;
    private final boolean e;
    private int f;
    private int g;
    private MediaPlayer h;
    private Uri i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private zzbdd o;
    private boolean p;
    private int q;
    private zzbcn r;

    public zzbcd(Context context, boolean z, boolean z2, zzbde zzbdeVar, zzbdg zzbdgVar) {
        super(context);
        this.f = 0;
        this.g = 0;
        setSurfaceTextureListener(this);
        this.d = zzbdgVar;
        this.p = z;
        this.e = z2;
        this.d.zzb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String zzxg() {
        String valueOf = String.valueOf(this.p ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zza(zzbcn zzbcnVar) {
        this.r = zzbcnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzvv zze = zzvv.zze(parse);
        if (zze == null || zze.url != null) {
            if (zze != null) {
                parse = Uri.parse(zze.url);
            }
            this.i = parse;
            this.q = 0;
            a();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void stop() {
        zzawz.zzds("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.h.release();
            this.h = null;
            b(0);
            this.g = 0;
        }
        this.d.onStop();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzawz.zzds(sb.toString());
        this.j = mediaPlayer.getVideoWidth();
        this.k = mediaPlayer.getVideoHeight();
        if (this.j == 0 || this.k == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzawz.zzds("AdMediaPlayerView prepared");
        b(2);
        this.d.zzhd();
        zzaxi.zzdvv.post(new hx(this));
        this.j = mediaPlayer.getVideoWidth();
        this.k = mediaPlayer.getVideoHeight();
        int i = this.q;
        if (i != 0) {
            seekTo(i);
        }
        b();
        int i2 = this.j;
        int i3 = this.k;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzawz.zzeo(sb.toString());
        if (this.g == 3) {
            play();
        }
        zzxk();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzawz.zzds("AdMediaPlayerView completion");
        b(5);
        this.g = 5;
        zzaxi.zzdvv.post(new hy(this));
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = c.get(Integer.valueOf(i));
        String str2 = c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str2);
        zzawz.zzds(sb.toString());
        return true;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = c.get(Integer.valueOf(i));
        String str2 = c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str2);
        zzawz.zzep(sb.toString());
        b(-1);
        this.g = -1;
        zzaxi.zzdvv.post(new hz(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.l = i;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawz.zzds("AdMediaPlayerView surface created");
        a();
        zzaxi.zzdvv.post(new ia(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawz.zzds("AdMediaPlayerView surface changed");
        boolean z = this.g == 3;
        boolean z2 = this.j == i && this.k == i2;
        if (this.h != null && z && z2) {
            int i3 = this.q;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbdd zzbddVar = this.o;
        if (zzbddVar != null) {
            zzbddVar.zzm(i, i2);
        }
        zzaxi.zzdvv.post(new ib(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.zzds("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null && this.q == 0) {
            this.q = mediaPlayer.getCurrentPosition();
        }
        zzbdd zzbddVar = this.o;
        if (zzbddVar != null) {
            zzbddVar.zzxx();
        }
        zzaxi.zzdvv.post(new ic(this));
        a(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d.zzc(this);
        this.f2854a.zza(surfaceTexture, this.r);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        zzaxi.zzdvv.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.hw

            /* renamed from: a, reason: collision with root package name */
            private final zzbcd f2228a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2228a = this;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2228a.a(this.b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int defaultSize = getDefaultSize(this.j, i);
        int defaultSize2 = getDefaultSize(this.k, i2);
        if (this.j <= 0 || this.k <= 0 || this.o != null) {
            i3 = defaultSize;
        } else {
            int mode = View.MeasureSpec.getMode(i);
            i3 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.j;
                int i6 = i5 * size;
                int i7 = this.k;
                if (i6 < i3 * i7) {
                    defaultSize2 = size;
                    i3 = (i5 * size) / i7;
                } else {
                    if (i5 * size > i3 * i7) {
                        defaultSize2 = (i7 * i3) / i5;
                    }
                    defaultSize2 = size;
                }
            } else if (mode == 1073741824) {
                int i8 = (this.k * i3) / this.j;
                if (mode2 != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize2 = i8;
                }
                defaultSize2 = size;
            } else if (mode2 == 1073741824) {
                int i9 = (this.j * size) / this.k;
                if (mode != Integer.MIN_VALUE || i9 <= i3) {
                    i3 = i9;
                }
                defaultSize2 = size;
            } else {
                int i10 = this.j;
                int i11 = this.k;
                if (mode2 != Integer.MIN_VALUE || i11 <= size) {
                    defaultSize2 = i11;
                } else {
                    i10 = (i10 * size) / i11;
                    defaultSize2 = size;
                }
                if (mode != Integer.MIN_VALUE || i10 <= i3) {
                    i3 = i10;
                } else {
                    defaultSize2 = (this.k * i3) / this.j;
                }
            }
        }
        setMeasuredDimension(i3, defaultSize2);
        zzbdd zzbddVar = this.o;
        if (zzbddVar != null) {
            zzbddVar.zzm(i3, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i12 = this.m;
            if ((i12 > 0 && i12 != i3) || ((i4 = this.n) > 0 && i4 != defaultSize2)) {
                b();
            }
            this.m = i3;
            this.n = defaultSize2;
        }
    }

    @Override // android.view.View
    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append(IR.account.EMAIL_TAG);
        sb.append(hexString);
        return sb.toString();
    }

    private final void a() {
        zzawz.zzds("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.i == null || surfaceTexture == null) {
            return;
        }
        a(false);
        try {
            zzk.zzlw();
            this.h = new MediaPlayer();
            this.h.setOnBufferingUpdateListener(this);
            this.h.setOnCompletionListener(this);
            this.h.setOnErrorListener(this);
            this.h.setOnInfoListener(this);
            this.h.setOnPreparedListener(this);
            this.h.setOnVideoSizeChangedListener(this);
            this.l = 0;
            if (this.p) {
                this.o = new zzbdd(getContext());
                this.o.zza(surfaceTexture, getWidth(), getHeight());
                this.o.start();
                SurfaceTexture zzxy = this.o.zzxy();
                if (zzxy != null) {
                    surfaceTexture = zzxy;
                } else {
                    this.o.zzxx();
                    this.o = null;
                }
            }
            this.h.setDataSource(getContext(), this.i);
            zzk.zzlx();
            this.h.setSurface(new Surface(surfaceTexture));
            this.h.setAudioStreamType(3);
            this.h.setScreenOnWhilePlaying(true);
            this.h.prepareAsync();
            b(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            String valueOf = String.valueOf(this.i);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(valueOf);
            zzawz.zzd(sb.toString(), e);
            onError(this.h, 1, 0);
        }
    }

    private final void b() {
        if (this.e && c() && this.h.getCurrentPosition() > 0 && this.g != 3) {
            zzawz.zzds("AdMediaPlayerView nudging MediaPlayer");
            a(0.0f);
            this.h.start();
            int currentPosition = this.h.getCurrentPosition();
            long currentTimeMillis = zzk.zzln().currentTimeMillis();
            while (c() && this.h.getCurrentPosition() == currentPosition && zzk.zzln().currentTimeMillis() - currentTimeMillis <= 250) {
            }
            this.h.pause();
            zzxk();
        }
    }

    private final void a(boolean z) {
        zzawz.zzds("AdMediaPlayerView release");
        zzbdd zzbddVar = this.o;
        if (zzbddVar != null) {
            zzbddVar.zzxx();
            this.o = null;
        }
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.h.release();
            this.h = null;
            b(0);
            if (z) {
                this.g = 0;
                this.g = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void play() {
        zzawz.zzds("AdMediaPlayerView play");
        if (c()) {
            this.h.start();
            b(3);
            this.f2854a.zzxm();
            zzaxi.zzdvv.post(new id(this));
        }
        this.g = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void pause() {
        zzawz.zzds("AdMediaPlayerView pause");
        if (c() && this.h.isPlaying()) {
            this.h.pause();
            b(4);
            zzaxi.zzdvv.post(new ie(this));
        }
        this.g = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getDuration() {
        if (c()) {
            return this.h.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getCurrentPosition() {
        if (c()) {
            return this.h.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        if (c()) {
            this.h.seekTo(i);
            this.q = 0;
        } else {
            this.q = i;
        }
    }

    private final boolean c() {
        int i;
        return (this.h == null || (i = this.f) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void zza(float f, float f2) {
        zzbdd zzbddVar = this.o;
        if (zzbddVar != null) {
            zzbddVar.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco, com.google.android.gms.internal.ads.ip
    public final void zzxk() {
        a(this.b.getVolume());
    }

    private final void a(float f) {
        MediaPlayer mediaPlayer = this.h;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzawz.zzep("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void b(int i) {
        if (i == 3) {
            this.d.zzyl();
            this.b.zzyl();
        } else if (this.f == 3) {
            this.d.zzym();
            this.b.zzym();
        }
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i) {
        zzbcn zzbcnVar = this.r;
        if (zzbcnVar != null) {
            zzbcnVar.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            c.put(Integer.valueOf(IabHelper.IABHELPER_SEND_INTENT_FAILED), "MEDIA_ERROR_IO");
            c.put(Integer.valueOf(IabHelper.IABHELPER_MISSING_TOKEN), "MEDIA_ERROR_MALFORMED");
            c.put(Integer.valueOf(IabHelper.IABHELPER_INVALID_CONSUMPTION), "MEDIA_ERROR_UNSUPPORTED");
            c.put(-110, "MEDIA_ERROR_TIMED_OUT");
            c.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        c.put(100, "MEDIA_ERROR_SERVER_DIED");
        c.put(1, "MEDIA_ERROR_UNKNOWN");
        c.put(1, "MEDIA_INFO_UNKNOWN");
        c.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        c.put(701, "MEDIA_INFO_BUFFERING_START");
        c.put(702, "MEDIA_INFO_BUFFERING_END");
        c.put(Integer.valueOf(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_BAD_INTERLEAVING), "MEDIA_INFO_BAD_INTERLEAVING");
        c.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        c.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            c.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            c.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
