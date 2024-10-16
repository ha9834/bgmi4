package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzth extends zzpe {
    private static final int[] c = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int A;
    private int B;
    private int C;
    private float D;
    private boolean E;
    private int F;
    private long G;
    private int H;
    aoa b;
    private final Context d;
    private final zztl e;
    private final zzto f;
    private final long g;
    private final int h;
    private final boolean i;
    private final long[] j;
    private zzlh[] k;
    private zztj l;
    private Surface m;
    private Surface n;
    private int o;
    private boolean p;
    private long q;
    private long r;
    private int s;
    private int t;
    private int u;
    private float v;
    private int w;
    private int x;
    private int y;
    private float z;

    public zzth(Context context, zzpg zzpgVar, long j, Handler handler, zztn zztnVar, int i) {
        this(context, zzpgVar, 0L, null, false, handler, zztnVar, -1);
    }

    private static boolean b(long j) {
        return j < -30000;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzth(Context context, zzpg zzpgVar, long j, zznj<Object> zznjVar, boolean z, Handler handler, zztn zztnVar, int i) {
        super(2, zzpgVar, null, false);
        boolean z2 = false;
        this.g = 0L;
        this.h = -1;
        this.d = context.getApplicationContext();
        this.e = new zztl(context);
        this.f = new zzto(handler, zztnVar);
        if (zzsy.SDK_INT <= 22 && "foster".equals(zzsy.DEVICE) && "NVIDIA".equals(zzsy.MANUFACTURER)) {
            z2 = true;
        }
        this.i = z2;
        this.j = new long[10];
        this.G = -9223372036854775807L;
        this.q = -9223372036854775807L;
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.o = 1;
        o();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final int a(zzpg zzpgVar, zzlh zzlhVar) throws zzpk {
        boolean z;
        String str = zzlhVar.zzatq;
        if (!zzsp.zzbf(str)) {
            return 0;
        }
        zzne zzneVar = zzlhVar.zzatr;
        if (zzneVar != null) {
            z = false;
            for (int i = 0; i < zzneVar.zzazg; i++) {
                z |= zzneVar.zzap(i).zzazh;
            }
        } else {
            z = false;
        }
        zzpd zze = zzpgVar.zze(str, z);
        if (zze == null) {
            return 1;
        }
        boolean zzat = zze.zzat(zzlhVar.zzatn);
        if (zzat && zzlhVar.width > 0 && zzlhVar.height > 0) {
            if (zzsy.SDK_INT >= 21) {
                zzat = zze.zza(zzlhVar.width, zzlhVar.height, zzlhVar.zzats);
            } else {
                zzat = zzlhVar.width * zzlhVar.height <= zzpi.zziw();
                if (!zzat) {
                    int i2 = zzlhVar.width;
                    int i3 = zzlhVar.height;
                    String str2 = zzsy.zzbnq;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(i3);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        return (zzat ? 3 : 2) | (zze.zzabo ? 8 : 4) | (zze.zzawy ? 16 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void a(boolean z) throws zzku {
        super.a(z);
        this.F = d().zzaul;
        this.E = this.F != 0;
        this.f.zzc(this.f3703a);
        this.e.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public final void a(zzlh[] zzlhVarArr, long j) throws zzku {
        this.k = zzlhVarArr;
        if (this.G == -9223372036854775807L) {
            this.G = j;
        } else {
            int i = this.H;
            long[] jArr = this.j;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.H = i + 1;
            }
            this.j[this.H - 1] = j;
        }
        super.a(zzlhVarArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void a(long j, boolean z) throws zzku {
        super.a(j, z);
        n();
        this.t = 0;
        int i = this.H;
        if (i != 0) {
            this.G = this.j[i - 1];
            this.H = 0;
        }
        if (z) {
            m();
        } else {
            this.q = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzlo
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.p || (((surface = this.n) != null && this.m == surface) || j() == null))) {
            this.q = -9223372036854775807L;
            return true;
        }
        if (this.q == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.q) {
            return true;
        }
        this.q = -9223372036854775807L;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void a() {
        super.a();
        this.s = 0;
        this.r = SystemClock.elapsedRealtime();
        this.q = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void b() {
        r();
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void c() {
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.G = -9223372036854775807L;
        this.H = 0;
        o();
        n();
        this.e.disable();
        this.b = null;
        this.E = false;
        try {
            super.c();
        } finally {
            this.f3703a.zzdk();
            this.f.zzd(this.f3703a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzkx
    public final void zza(int i, Object obj) throws zzku {
        if (i != 1) {
            if (i == 4) {
                this.o = ((Integer) obj).intValue();
                MediaCodec j = j();
                if (j != null) {
                    j.setVideoScalingMode(this.o);
                    return;
                }
                return;
            }
            super.zza(i, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.n;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzpd k = k();
                if (k != null && b(k.zzaer)) {
                    this.n = zztd.zzc(this.d, k.zzaer);
                    surface = this.n;
                }
            }
        }
        if (this.m != surface) {
            this.m = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec j2 = j();
                if (zzsy.SDK_INT >= 23 && j2 != null && surface != null) {
                    j2.setOutputSurface(surface);
                } else {
                    l();
                    i();
                }
            }
            if (surface != null && surface != this.n) {
                q();
                n();
                if (state == 2) {
                    m();
                    return;
                }
                return;
            }
            o();
            n();
            return;
        }
        if (surface == null || surface == this.n) {
            return;
        }
        q();
        if (this.p) {
            this.f.zzc(this.m);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean a(zzpd zzpdVar) {
        return this.m != null || b(zzpdVar.zzaer);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(zzpd zzpdVar, MediaCodec mediaCodec, zzlh zzlhVar, MediaCrypto mediaCrypto) throws zzpk {
        zztj zztjVar;
        Point point;
        zzlh[] zzlhVarArr = this.k;
        int i = zzlhVar.width;
        int i2 = zzlhVar.height;
        int b = b(zzlhVar);
        if (zzlhVarArr.length == 1) {
            zztjVar = new zztj(i, i2, b);
        } else {
            int i3 = i2;
            int i4 = b;
            boolean z = false;
            int i5 = i;
            for (zzlh zzlhVar2 : zzlhVarArr) {
                if (a(zzpdVar.zzabo, zzlhVar, zzlhVar2)) {
                    z |= zzlhVar2.width == -1 || zzlhVar2.height == -1;
                    i5 = Math.max(i5, zzlhVar2.width);
                    int max = Math.max(i3, zzlhVar2.height);
                    i4 = Math.max(i4, b(zzlhVar2));
                    i3 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i5);
                sb.append("x");
                sb.append(i3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzlhVar.height > zzlhVar.width;
                int i6 = z2 ? zzlhVar.height : zzlhVar.width;
                int i7 = z2 ? zzlhVar.width : zzlhVar.height;
                float f = i7 / i6;
                int[] iArr = c;
                int length = iArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        point = null;
                        break;
                    }
                    int i9 = iArr[i8];
                    int i10 = (int) (i9 * f);
                    if (i9 <= i6 || i10 <= i7) {
                        break;
                    }
                    int i11 = i6;
                    int i12 = i7;
                    if (zzsy.SDK_INT >= 21) {
                        int i13 = z2 ? i10 : i9;
                        if (!z2) {
                            i9 = i10;
                        }
                        Point zze = zzpdVar.zze(i13, i9);
                        if (zzpdVar.zza(zze.x, zze.y, zzlhVar.zzats)) {
                            point = zze;
                            break;
                        } else {
                            i8++;
                            i6 = i11;
                            i7 = i12;
                        }
                    } else {
                        int zzb = zzsy.zzb(i9, 16) << 4;
                        int zzb2 = zzsy.zzb(i10, 16) << 4;
                        if (zzb * zzb2 <= zzpi.zziw()) {
                            int i14 = z2 ? zzb2 : zzb;
                            if (z2) {
                                zzb2 = zzb;
                            }
                            point = new Point(i14, zzb2);
                        } else {
                            i8++;
                            i6 = i11;
                            i7 = i12;
                        }
                    }
                }
                point = null;
                if (point != null) {
                    i5 = Math.max(i5, point.x);
                    i3 = Math.max(i3, point.y);
                    i4 = Math.max(i4, a(zzlhVar.zzatq, i5, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i5);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zztjVar = new zztj(i5, i3, i4);
        }
        this.l = zztjVar;
        zztj zztjVar2 = this.l;
        boolean z3 = this.i;
        int i15 = this.F;
        MediaFormat zzen = zzlhVar.zzen();
        zzen.setInteger("max-width", zztjVar2.width);
        zzen.setInteger("max-height", zztjVar2.height);
        if (zztjVar2.zzbpb != -1) {
            zzen.setInteger("max-input-size", zztjVar2.zzbpb);
        }
        if (z3) {
            zzen.setInteger("auto-frc", 0);
        }
        if (i15 != 0) {
            zzen.setFeatureEnabled("tunneled-playback", true);
            zzen.setInteger("audio-session-id", i15);
        }
        if (this.m == null) {
            zzsk.checkState(b(zzpdVar.zzaer));
            if (this.n == null) {
                this.n = zztd.zzc(this.d, zzpdVar.zzaer);
            }
            this.m = this.n;
        }
        mediaCodec.configure(zzen, this.m, (MediaCrypto) null, 0);
        if (zzsy.SDK_INT < 23 || !this.E) {
            return;
        }
        this.b = new aoa(this, mediaCodec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe
    public final void l() {
        try {
            super.l();
        } finally {
            Surface surface = this.n;
            if (surface != null) {
                if (this.m == surface) {
                    this.m = null;
                }
                this.n.release();
                this.n = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(String str, long j, long j2) {
        this.f.zzc(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe
    public final void a(zzlh zzlhVar) throws zzku {
        super.a(zzlhVar);
        this.f.zzc(zzlhVar);
        this.v = zzlhVar.zzaft == -1.0f ? 1.0f : zzlhVar.zzaft;
        this.u = c(zzlhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(zznd zzndVar) {
        if (zzsy.SDK_INT >= 23 || !this.E) {
            return;
        }
        g();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        }
        this.w = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
        this.x = integer2;
        this.z = this.v;
        if (zzsy.SDK_INT >= 21) {
            int i = this.u;
            if (i == 90 || i == 270) {
                int i2 = this.w;
                this.w = this.x;
                this.x = i2;
                this.z = 1.0f / this.z;
            }
        } else {
            this.y = this.u;
        }
        mediaCodec.setVideoScalingMode(this.o);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean a(MediaCodec mediaCodec, boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        return a(z, zzlhVar, zzlhVar2) && zzlhVar2.width <= this.l.width && zzlhVar2.height <= this.l.height && zzlhVar2.zzafs <= this.l.zzbpb;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.H;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.j;
            if (j3 < jArr[0]) {
                break;
            }
            this.G = jArr[0];
            this.H = i3 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.H);
        }
        long j4 = j3 - this.G;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.m == this.n) {
            if (!b(j5)) {
                return false;
            }
            a(mediaCodec, i, j4);
            return true;
        }
        if (!this.p) {
            if (zzsy.SDK_INT >= 21) {
                a(mediaCodec, i, j4, System.nanoTime());
            } else {
                b(mediaCodec, i, j4);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime();
        long zzg = this.e.zzg(j3, (elapsedRealtime * 1000) + nanoTime);
        long j6 = (zzg - nanoTime) / 1000;
        if (b(j6)) {
            zzsx.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzsx.endSection();
            this.f3703a.zzabm++;
            this.s++;
            this.t++;
            this.f3703a.zzazd = Math.max(this.t, this.f3703a.zzazd);
            if (this.s == this.h) {
                r();
            }
            return true;
        }
        if (zzsy.SDK_INT >= 21) {
            if (j6 < 50000) {
                a(mediaCodec, i, j4, zzg);
                return true;
            }
        } else if (j6 < 30000) {
            if (j6 > 11000) {
                try {
                    Thread.sleep((j6 - LogUtils.LOG_FUSE_TIME) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            b(mediaCodec, i, j4);
            return true;
        }
        return false;
    }

    private final void a(MediaCodec mediaCodec, int i, long j) {
        zzsx.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzsx.endSection();
        this.f3703a.zzabl++;
    }

    private final void b(MediaCodec mediaCodec, int i, long j) {
        p();
        zzsx.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzsx.endSection();
        this.f3703a.zzabk++;
        this.t = 0;
        g();
    }

    @TargetApi(21)
    private final void a(MediaCodec mediaCodec, int i, long j, long j2) {
        p();
        zzsx.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzsx.endSection();
        this.f3703a.zzabk++;
        this.t = 0;
        g();
    }

    private final boolean b(boolean z) {
        if (zzsy.SDK_INT < 23 || this.E) {
            return false;
        }
        return !z || zztd.zzc(this.d);
    }

    private final void m() {
        this.q = this.g > 0 ? SystemClock.elapsedRealtime() + this.g : -9223372036854775807L;
    }

    private final void n() {
        MediaCodec j;
        this.p = false;
        if (zzsy.SDK_INT < 23 || !this.E || (j = j()) == null) {
            return;
        }
        this.b = new aoa(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.f.zzc(this.m);
    }

    private final void o() {
        this.A = -1;
        this.B = -1;
        this.D = -1.0f;
        this.C = -1;
    }

    private final void p() {
        if (this.A == this.w && this.B == this.x && this.C == this.y && this.D == this.z) {
            return;
        }
        this.f.zzb(this.w, this.x, this.y, this.z);
        this.A = this.w;
        this.B = this.x;
        this.C = this.y;
        this.D = this.z;
    }

    private final void q() {
        if (this.A == -1 && this.B == -1) {
            return;
        }
        this.f.zzb(this.w, this.x, this.y, this.z);
    }

    private final void r() {
        if (this.s > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f.zzg(this.s, elapsedRealtime - this.r);
            this.s = 0;
            this.r = elapsedRealtime;
        }
    }

    private static int b(zzlh zzlhVar) {
        if (zzlhVar.zzafs != -1) {
            return zzlhVar.zzafs;
        }
        return a(zzlhVar.zzatq, zzlhVar.width, zzlhVar.height);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str, int i, int i2) {
        char c2;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                i3 = i * i2;
                i4 = 2;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(zzsy.MODEL)) {
                    i3 = ((zzsy.zzb(i, 16) * zzsy.zzb(i2, 16)) << 4) << 4;
                    i4 = 2;
                    break;
                } else {
                    return -1;
                }
            case 3:
                i3 = i * i2;
                i4 = 2;
                break;
            case 4:
            case 5:
                i3 = i * i2;
                break;
            default:
                return -1;
        }
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean a(boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        if (!zzlhVar.zzatq.equals(zzlhVar2.zzatq) || c(zzlhVar) != c(zzlhVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzlhVar.width == zzlhVar2.width && zzlhVar.height == zzlhVar2.height;
    }

    private static int c(zzlh zzlhVar) {
        if (zzlhVar.zzatt == -1) {
            return 0;
        }
        return zzlhVar.zzatt;
    }
}
