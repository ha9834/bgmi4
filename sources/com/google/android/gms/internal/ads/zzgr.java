package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzgr extends zzhp {
    private boolean A;
    private boolean B;
    private boolean C;
    private long D;

    /* renamed from: a, reason: collision with root package name */
    protected final Handler f3641a;
    private final zzhz b;
    private final boolean c;
    private final zzhn d;
    private final zzhm e;
    private final zzhk f;
    private final List<Long> g;
    private final MediaCodec.BufferInfo h;
    private final zzgw i;
    private zzhj j;
    private zzhw k;
    private MediaCodec l;
    private boolean m;
    private ByteBuffer[] n;
    private ByteBuffer[] o;
    private long p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private boolean z;
    public final zzga zzadf;

    public zzgr(zzhn zzhnVar, zzhz zzhzVar, boolean z, Handler handler, zzgw zzgwVar) {
        zzkh.checkState(zzkq.SDK_INT >= 16);
        this.d = zzhnVar;
        this.b = null;
        this.c = true;
        this.f3641a = handler;
        this.i = zzgwVar;
        this.zzadf = new zzga();
        this.e = new zzhm(0);
        this.f = new zzhk();
        this.g = new ArrayList();
        this.h = new MediaCodec.BufferInfo();
        this.u = 0;
        this.v = 0;
    }

    protected void a(zzhj zzhjVar, MediaFormat mediaFormat) {
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i, boolean z) throws zzgd;

    protected boolean a(MediaCodec mediaCodec, boolean z, zzhj zzhjVar, zzhj zzhjVar2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void c() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzhp
    protected final int b(long j) throws zzgd {
        try {
            if (!this.d.zzdg(j)) {
                return 0;
            }
            for (int i = 0; i < this.d.getTrackCount(); i++) {
                if (a(this.d.zzo(i).mimeType)) {
                    this.x = i;
                    return 1;
                }
            }
            return -1;
        } catch (IOException e) {
            throw new zzgd(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void a(long j, boolean z) {
        this.d.zza(this.x, j);
        this.y = 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.D = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgc a(String str, boolean z) throws zzgz {
        return zzgx.zzc(str, z);
    }

    protected void a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() throws zzgd {
        MediaCrypto mediaCrypto;
        zzgc zzgcVar;
        if (h()) {
            String str = this.j.mimeType;
            boolean z = false;
            zzhw zzhwVar = this.k;
            if (zzhwVar != null) {
                zzhz zzhzVar = this.b;
                if (zzhzVar == null) {
                    throw new zzgd("Media requires a DrmSessionManager");
                }
                if (!this.s) {
                    zzhzVar.zza(zzhwVar);
                    this.s = true;
                }
                int state = this.b.getState();
                if (state == 0) {
                    throw new zzgd(this.b.zzfb());
                }
                if (state != 3 && state != 4) {
                    return;
                }
                mediaCrypto = this.b.zzfa();
                z = this.b.requiresSecureDecoderComponent(str);
            } else {
                mediaCrypto = null;
            }
            try {
                zzgcVar = a(str, z);
            } catch (zzgz e) {
                a(new zzgv(this.j, e, -49998));
                zzgcVar = null;
            }
            if (zzgcVar == null) {
                a(new zzgv(this.j, (Throwable) null, -49999));
            }
            String str2 = zzgcVar.name;
            this.m = zzgcVar.zzabo;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.l = MediaCodec.createByCodecName(str2);
                a(this.l, str2, this.j.zzen(), mediaCrypto);
                this.l.start();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j = elapsedRealtime2 - elapsedRealtime;
                if (this.f3641a != null && this.i != null) {
                    this.f3641a.post(new ajl(this, str2, elapsedRealtime2, j));
                }
                this.n = this.l.getInputBuffers();
                this.o = this.l.getOutputBuffers();
            } catch (Exception e2) {
                a(new zzgv(this.j, e2, str2));
            }
            this.p = o() == 3 ? SystemClock.elapsedRealtime() : -1L;
            this.q = -1;
            this.r = -1;
            this.C = true;
            this.zzadf.zzabg++;
        }
    }

    private final void a(zzgv zzgvVar) throws zzgd {
        Handler handler = this.f3641a;
        if (handler != null && this.i != null) {
            handler.post(new ajj(this, zzgvVar));
        }
        throw new zzgd(zzgvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        return this.l == null && this.j != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean i() {
        return this.l != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void zzdz() {
        this.j = null;
        this.k = null;
        try {
            j();
            try {
                if (this.s) {
                    this.b.close();
                    this.s = false;
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                if (this.s) {
                    this.b.close();
                    this.s = false;
                }
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        if (this.l != null) {
            this.p = -1L;
            this.q = -1;
            this.r = -1;
            this.B = false;
            this.g.clear();
            this.n = null;
            this.o = null;
            this.t = false;
            this.w = false;
            this.m = false;
            this.u = 0;
            this.v = 0;
            this.zzadf.zzabh++;
            try {
                this.l.stop();
                try {
                    this.l.release();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    this.l.release();
                    throw th;
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final void k() {
        this.d.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public long f() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final long l() {
        return this.d.zzo(this.x).zzack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final long m() {
        long zzdu = this.d.zzdu();
        return (zzdu == -1 || zzdu == -3) ? zzdu : Math.max(zzdu, f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void a(long j) throws zzgd {
        this.D = j;
        this.d.zzdi(j);
        this.y = 0;
        this.z = false;
        this.A = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r17.l != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r17.A != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (r17.r >= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        r17.r = r17.l.dequeueOutputBuffer(r17.h, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r17.r != (-2)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        a(r17.j, r17.l.getOutputFormat());
        r17.zzadf.zzabi++;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0118, code lost:
    
        if (r14 != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011e, code lost:
    
        if (a(true) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0125, code lost:
    
        if (a(false) != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
    
        if (r17.r != (-3)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        r17.o = r17.l.getOutputBuffers();
        r17.zzadf.zzabj++;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a5, code lost:
    
        if (r17.r < 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
    
        if ((r17.h.flags & 4) == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b2, code lost:
    
        if (r17.v != 2) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
    
        j();
        g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bd, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bb, code lost:
    
        r17.A = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bf, code lost:
    
        r0 = r17.h.presentationTimeUs;
        r2 = r17.g.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cb, code lost:
    
        if (r3 >= r2) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00db, code lost:
    
        if (r17.g.get(r3).longValue() != r0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00df, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00dd, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e3, code lost:
    
        r6 = r17.l;
        r7 = r17.o[r17.r];
        r8 = r17.h;
        r9 = r17.r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ef, code lost:
    
        if (r0 == (-1)) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f1, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0103, code lost:
    
        if (a(r18, r20, r6, r7, r8, r9, r16) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0105, code lost:
    
        if (r0 == (-1)) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0107, code lost:
    
        r17.g.remove(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0113, code lost:
    
        r17.r = -1;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x010d, code lost:
    
        r17.D = r17.h.presentationTimeUs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f4, code lost:
    
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e2, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0117, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0127, code lost:
    
        r17.zzadf.zzdk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x012c, code lost:
    
        return;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r18, long r20) throws com.google.android.gms.internal.ads.zzgd {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.a(long, long):void");
    }

    private final void t() throws zzgd {
        this.p = -1L;
        this.q = -1;
        this.r = -1;
        this.C = true;
        this.B = false;
        this.g.clear();
        if (zzkq.SDK_INT >= 18 && this.v == 0) {
            this.l.flush();
            this.w = false;
        } else {
            j();
            g();
        }
        if (!this.t || this.j == null) {
            return;
        }
        this.u = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0120 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean a(boolean r18) throws java.io.IOException, com.google.android.gms.internal.ads.zzgd {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.a(boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzhk zzhkVar) throws zzgd {
        zzhj zzhjVar = this.j;
        this.j = zzhkVar.zzado;
        this.k = zzhkVar.zzadp;
        MediaCodec mediaCodec = this.l;
        if (mediaCodec != null && a(mediaCodec, this.m, zzhjVar, this.j)) {
            this.t = true;
            this.u = 1;
        } else if (this.w) {
            this.v = 1;
        } else {
            j();
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public boolean d() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public boolean e() {
        if (this.j != null && !this.B) {
            if (this.y == 0 && this.r < 0) {
                if (SystemClock.elapsedRealtime() < this.p + 1000) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int n() {
        return this.y;
    }

    private final void a(MediaCodec.CryptoException cryptoException) {
        Handler handler = this.f3641a;
        if (handler == null || this.i == null) {
            return;
        }
        handler.post(new ajk(this, cryptoException));
    }
}
