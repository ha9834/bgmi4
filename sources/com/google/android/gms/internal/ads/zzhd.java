package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzhd extends zzgr {
    private final zzhi b;
    private final zzhh c;
    private final long d;
    private final int e;
    private final int f;
    private Surface g;
    private boolean h;
    private boolean i;
    private long j;
    private long k;
    private int l;
    private int m;
    private int n;
    private float o;
    private int p;
    private int q;
    private float r;

    public zzhd(zzhn zzhnVar, int i, long j, Handler handler, zzhh zzhhVar, int i2) {
        this(zzhnVar, null, true, 1, 0L, null, handler, zzhhVar, -1);
    }

    private zzhd(zzhn zzhnVar, zzhz zzhzVar, boolean z, int i, long j, zzhi zzhiVar, Handler handler, zzhh zzhhVar, int i2) {
        super(zzhnVar, null, true, handler, zzhhVar);
        this.e = 1;
        this.d = 0L;
        this.b = null;
        this.c = zzhhVar;
        this.f = -1;
        this.j = -1L;
        this.m = -1;
        this.n = -1;
        this.o = -1.0f;
        this.p = -1;
        this.q = -1;
        this.r = -1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean a(String str) {
        return zzkl.zzau(str).equals("video") && super.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void a(long j, boolean z) {
        super.a(j, z);
        this.i = false;
        if (!z || this.d <= 0) {
            return;
        }
        this.j = (SystemClock.elapsedRealtime() * 1000) + this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void a(long j) throws zzgd {
        super.a(j);
        this.i = false;
        this.j = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final boolean e() {
        if (super.e() && (this.i || !i() || n() == 2)) {
            this.j = -1L;
            return true;
        }
        if (this.j == -1) {
            return false;
        }
        if (SystemClock.elapsedRealtime() * 1000 < this.j) {
            return true;
        }
        this.j = -1L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void b() {
        super.b();
        this.l = 0;
        this.k = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void c() {
        this.j = -1L;
        v();
        super.c();
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void zzdz() {
        this.m = -1;
        this.n = -1;
        this.o = -1.0f;
        this.p = -1;
        this.q = -1;
        this.r = -1.0f;
        super.zzdz();
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzgf
    public final void zza(int i, Object obj) throws zzgd {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (this.g != surface) {
                this.g = surface;
                this.h = false;
                int o = o();
                if (o == 2 || o == 3) {
                    j();
                    g();
                    return;
                }
                return;
            }
            return;
        }
        super.zza(i, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean h() {
        Surface surface;
        return super.h() && (surface = this.g) != null && surface.isValid();
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, this.g, mediaCrypto, 0);
        mediaCodec.setVideoScalingMode(this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void a(zzhk zzhkVar) throws zzgd {
        super.a(zzhkVar);
        this.o = zzhkVar.zzado.zzaft == -1.0f ? 1.0f : zzhkVar.zzado.zzaft;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void a(zzhj zzhjVar, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        }
        this.m = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
        this.n = integer2;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean a(MediaCodec mediaCodec, boolean z, zzhj zzhjVar, zzhj zzhjVar2) {
        if (!zzhjVar2.mimeType.equals(zzhjVar.mimeType)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzhjVar.width == zzhjVar2.width && zzhjVar.height == zzhjVar2.height;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i, boolean z) {
        if (z) {
            zzkp.beginSection("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzkp.endSection();
            this.zzadf.zzabl++;
            return true;
        }
        long elapsedRealtime = (bufferInfo.presentationTimeUs - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime() + (elapsedRealtime * 1000);
        if (elapsedRealtime < -30000) {
            zzkp.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzkp.endSection();
            this.zzadf.zzabm++;
            this.l++;
            if (this.l == this.f) {
                v();
            }
            return true;
        }
        if (!this.i) {
            a(mediaCodec, i);
            return true;
        }
        if (o() != 3) {
            return false;
        }
        if (zzkq.SDK_INT >= 21) {
            if (elapsedRealtime < 50000) {
                t();
                zzkp.beginSection("releaseOutputBufferTimed");
                mediaCodec.releaseOutputBuffer(i, nanoTime);
                zzkp.endSection();
                this.zzadf.zzabk++;
                this.i = true;
                u();
                return true;
            }
        } else if (elapsedRealtime < 30000) {
            if (elapsedRealtime > 11000) {
                try {
                    Thread.sleep((elapsedRealtime - LogUtils.LOG_FUSE_TIME) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            a(mediaCodec, i);
            return true;
        }
        return false;
    }

    private final void a(MediaCodec mediaCodec, int i) {
        t();
        zzkp.beginSection("renderVideoBufferImmediate");
        mediaCodec.releaseOutputBuffer(i, true);
        zzkp.endSection();
        this.zzadf.zzabk++;
        this.i = true;
        u();
    }

    private final void t() {
        if (this.f3641a == null || this.c == null) {
            return;
        }
        if (this.p == this.m && this.q == this.n && this.r == this.o) {
            return;
        }
        int i = this.m;
        int i2 = this.n;
        float f = this.o;
        this.f3641a.post(new ajq(this, i, i2, f));
        this.p = i;
        this.q = i2;
        this.r = f;
    }

    private final void u() {
        if (this.f3641a == null || this.c == null || this.h) {
            return;
        }
        this.f3641a.post(new ajr(this, this.g));
        this.h = true;
    }

    private final void v() {
        if (this.f3641a == null || this.c == null || this.l == 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f3641a.post(new ajs(this, this.l, elapsedRealtime - this.k));
        this.l = 0;
        this.k = elapsedRealtime;
    }
}
