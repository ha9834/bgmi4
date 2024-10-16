package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzpe extends zzks {
    private static final byte[] b = zzsy.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;

    /* renamed from: a, reason: collision with root package name */
    protected zznc f3703a;
    private final zzpg c;
    private final zznj<Object> d;
    private final boolean e;
    private final zznd f;
    private final zznd g;
    private final zzlj h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private zzlh k;
    private zznh<Object> l;
    private zznh<Object> m;
    private MediaCodec n;
    private zzpd o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    public zzpe(int i, zzpg zzpgVar, zznj<Object> zznjVar, boolean z) {
        super(i);
        zzsk.checkState(zzsy.SDK_INT >= 16);
        this.c = (zzpg) zzsk.checkNotNull(zzpgVar);
        this.d = zznjVar;
        this.e = z;
        this.f = new zznd(0);
        this.g = new zznd(0);
        this.h = new zzlj();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.F = 0;
        this.G = 0;
    }

    protected abstract int a(zzpg zzpgVar, zzlh zzlhVar) throws zzpk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void a() {
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
    }

    protected void a(zznd zzndVar) {
    }

    protected abstract void a(zzpd zzpdVar, MediaCodec mediaCodec, zzlh zzlhVar, MediaCrypto mediaCrypto) throws zzpk;

    protected void a(String str, long j, long j2) {
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzku;

    protected boolean a(MediaCodec mediaCodec, boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        return false;
    }

    protected boolean a(zzpd zzpdVar) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void b() {
    }

    protected void h() throws zzku {
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzlp
    public final int zzgp() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final int zza(zzlh zzlhVar) throws zzku {
        try {
            return a(this.c, zzlhVar);
        } catch (zzpk e) {
            throw zzku.zza(e, e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzpd a(zzpg zzpgVar, zzlh zzlhVar, boolean z) throws zzpk {
        return zzpgVar.zze(zzlhVar.zzatq, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() throws zzku {
        zzlh zzlhVar;
        if (this.n != null || (zzlhVar = this.k) == null) {
            return;
        }
        this.l = this.m;
        String str = zzlhVar.zzatq;
        zznh<Object> zznhVar = this.l;
        if (zznhVar != null) {
            int state = zznhVar.getState();
            if (state == 0) {
                throw zzku.zza(this.l.zzif(), e());
            }
            if (state == 3 || state == 4) {
                this.l.zzie();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.o == null) {
            try {
                this.o = a(this.c, this.k, false);
            } catch (zzpk e) {
                a(new zzpf(this.k, (Throwable) e, false, -49998));
            }
            if (this.o == null) {
                a(new zzpf(this.k, (Throwable) null, false, -49999));
            }
        }
        if (a(this.o)) {
            String str2 = this.o.name;
            this.p = zzsy.SDK_INT < 21 && this.k.zzafw.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.q = zzsy.SDK_INT < 18 || (zzsy.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzsy.SDK_INT == 19 && zzsy.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.r = zzsy.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzsy.DEVICE) || "flounder_lte".equals(zzsy.DEVICE) || "grouper".equals(zzsy.DEVICE) || "tilapia".equals(zzsy.DEVICE));
            this.s = zzsy.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.t = (zzsy.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzsy.SDK_INT <= 19 && "hb2000".equals(zzsy.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.u = zzsy.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
            this.v = zzsy.SDK_INT <= 18 && this.k.zzafu == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String valueOf = String.valueOf(str2);
                zzsx.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                this.n = MediaCodec.createByCodecName(str2);
                zzsx.endSection();
                zzsx.beginSection("configureCodec");
                a(this.o, this.n, this.k, (MediaCrypto) null);
                zzsx.endSection();
                zzsx.beginSection("startCodec");
                this.n.start();
                zzsx.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.y = this.n.getInputBuffers();
                this.z = this.n.getOutputBuffers();
            } catch (Exception e2) {
                a(new zzpf(this.k, (Throwable) e2, false, str2));
            }
            this.A = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.M = true;
            this.f3703a.zzaza++;
        }
    }

    private final void a(zzpf zzpfVar) throws zzku {
        throw zzku.zza(zzpfVar, e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec j() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzpd k() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void a(boolean z) throws zzku {
        this.f3703a = new zznc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void a(long j, boolean z) throws zzku {
        this.J = false;
        this.K = false;
        if (this.n != null) {
            this.A = -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.M = true;
            this.L = false;
            this.D = false;
            this.i.clear();
            this.w = false;
            this.x = false;
            if (this.q || (this.t && this.I)) {
                l();
                i();
            } else if (this.G != 0) {
                l();
                i();
            } else {
                this.n.flush();
                this.H = false;
            }
            if (!this.E || this.k == null) {
                return;
            }
            this.F = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void c() {
        this.k = null;
        try {
            l();
            try {
                if (this.l != null) {
                    this.d.zza(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.zza(this.m);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.zza(this.m);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.d.zza(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.zza(this.m);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.zza(this.m);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.A = -9223372036854775807L;
        this.B = -1;
        this.C = -1;
        this.L = false;
        this.D = false;
        this.i.clear();
        this.y = null;
        this.z = null;
        this.o = null;
        this.E = false;
        this.H = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.I = false;
        this.F = 0;
        this.G = 0;
        this.f.zzde = null;
        if (this.n != null) {
            this.f3703a.zzazb++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                    this.n = null;
                    zznh<Object> zznhVar = this.l;
                    if (zznhVar == null || this.m == zznhVar) {
                        return;
                    }
                    try {
                        this.d.zza(zznhVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.n = null;
                    zznh<Object> zznhVar2 = this.l;
                    if (zznhVar2 != null && this.m != zznhVar2) {
                        try {
                            this.d.zza(zznhVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    zznh<Object> zznhVar3 = this.l;
                    if (zznhVar3 != null && this.m != zznhVar3) {
                        try {
                            this.d.zza(zznhVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    zznh<Object> zznhVar4 = this.l;
                    if (zznhVar4 != null && this.m != zznhVar4) {
                        try {
                            this.d.zza(zznhVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzc(long j, long j2) throws zzku {
        if (this.K) {
            h();
            return;
        }
        if (this.k == null) {
            this.g.clear();
            int a2 = a(this.h, this.g, true);
            if (a2 != -5) {
                if (a2 == -4) {
                    zzsk.checkState(this.g.zzic());
                    this.J = true;
                    m();
                    return;
                }
                return;
            }
            a(this.h.zzaue);
        }
        i();
        if (this.n != null) {
            zzsx.beginSection("drainAndFeed");
            do {
            } while (a(j, j2));
            do {
            } while (g());
            zzsx.endSection();
        } else {
            a(j);
            this.g.clear();
            int a3 = a(this.h, this.g, false);
            if (a3 == -5) {
                a(this.h.zzaue);
            } else if (a3 == -4) {
                zzsk.checkState(this.g.zzic());
                this.J = true;
                m();
            }
        }
        this.f3703a.zzdk();
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x014b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean g() throws com.google.android.gms.internal.ads.zzku {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.g():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzlh zzlhVar) throws zzku {
        MediaCodec mediaCodec;
        zzlh zzlhVar2 = this.k;
        this.k = zzlhVar;
        if (!zzsy.zza(this.k.zzatr, zzlhVar2 == null ? null : zzlhVar2.zzatr)) {
            if (this.k.zzatr != null) {
                zznj<Object> zznjVar = this.d;
                if (zznjVar == null) {
                    throw zzku.zza(new IllegalStateException("Media requires a DrmSessionManager"), e());
                }
                this.m = zznjVar.zza(Looper.myLooper(), this.k.zzatr);
                zznh<Object> zznhVar = this.m;
                if (zznhVar == this.l) {
                    this.d.zza(zznhVar);
                }
            } else {
                this.m = null;
            }
        }
        if (this.m == this.l && (mediaCodec = this.n) != null && a(mediaCodec, this.o.zzabo, zzlhVar2, this.k)) {
            this.E = true;
            this.F = 1;
            this.w = this.r && this.k.width == zzlhVar2.width && this.k.height == zzlhVar2.height;
        } else if (this.H) {
            this.G = 1;
        } else {
            l();
            i();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public boolean zzdx() {
        return this.K;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public boolean isReady() {
        if (this.k == null || this.L) {
            return false;
        }
        if (f() || this.C >= 0) {
            return true;
        }
        return this.A != -9223372036854775807L && SystemClock.elapsedRealtime() < this.A;
    }

    private final boolean a(long j, long j2) throws zzku {
        boolean a2;
        boolean z;
        if (this.C < 0) {
            if (this.u && this.I) {
                try {
                    this.C = this.n.dequeueOutputBuffer(this.j, 0L);
                } catch (IllegalStateException unused) {
                    m();
                    if (this.K) {
                        l();
                    }
                    return false;
                }
            } else {
                this.C = this.n.dequeueOutputBuffer(this.j, 0L);
            }
            int i = this.C;
            if (i < 0) {
                if (i != -2) {
                    if (i == -3) {
                        this.z = this.n.getOutputBuffers();
                        return true;
                    }
                    if (this.s && (this.J || this.G == 2)) {
                        m();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.n.getOutputFormat();
                if (this.r && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
                    this.x = true;
                } else {
                    if (this.v) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    a(this.n, outputFormat);
                }
                return true;
            }
            if (this.x) {
                this.x = false;
                this.n.releaseOutputBuffer(i, false);
                this.C = -1;
                return true;
            }
            if ((this.j.flags & 4) != 0) {
                m();
                this.C = -1;
                return false;
            }
            ByteBuffer byteBuffer = this.z[this.C];
            if (byteBuffer != null) {
                byteBuffer.position(this.j.offset);
                byteBuffer.limit(this.j.offset + this.j.size);
            }
            long j3 = this.j.presentationTimeUs;
            int size = this.i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (this.i.get(i2).longValue() == j3) {
                    this.i.remove(i2);
                    z = true;
                    break;
                }
                i2++;
            }
            this.D = z;
        }
        if (this.u && this.I) {
            try {
                a2 = a(j, j2, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
            } catch (IllegalStateException unused2) {
                m();
                if (this.K) {
                    l();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.n;
            ByteBuffer[] byteBufferArr = this.z;
            int i3 = this.C;
            a2 = a(j, j2, mediaCodec, byteBufferArr[i3], i3, this.j.flags, this.j.presentationTimeUs, this.D);
        }
        if (!a2) {
            return false;
        }
        long j4 = this.j.presentationTimeUs;
        this.C = -1;
        return true;
    }

    private final void m() throws zzku {
        if (this.G == 2) {
            l();
            i();
        } else {
            this.K = true;
            h();
        }
    }
}
