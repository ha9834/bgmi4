package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzne;
import com.google.firebase.FirebaseError;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzod implements zznn {

    /* renamed from: a, reason: collision with root package name */
    private static final zznq f3697a = new ama();
    private static final byte[] b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID d = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private zzsn F;
    private zzsn G;
    private boolean H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int[] N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private byte W;
    private int X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private zznp ac;
    private final aly e;
    private final ame f;
    private final SparseArray<amc> g;
    private final boolean h;
    private final zzst i;
    private final zzst j;
    private final zzst k;
    private final zzst l;
    private final zzst m;
    private final zzst n;
    private final zzst o;
    private final zzst p;
    private final zzst q;
    private ByteBuffer r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private amc x;
    private boolean y;
    private int z;

    public zzod() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
            case 179:
            case 186:
            case TbsListener.ErrorCode.COPY_EXCEPTION /* 215 */:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE /* 134 */:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 2274716:
                return 3;
            case TbsListener.ErrorCode.STARTDOWNLOAD_1 /* 160 */:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
            case 183:
            case 187:
            case TbsListener.ErrorCode.EXCEED_INCR_UPDATE /* 224 */:
            case TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR /* 225 */:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case TbsListener.ErrorCode.STARTDOWNLOAD_2 /* 161 */:
            case TbsListener.ErrorCode.STARTDOWNLOAD_4 /* 163 */:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void release() {
    }

    private zzod(int i) {
        this(new alv(), 0);
    }

    private zzod(aly alyVar, int i) {
        this.t = -1L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.e = alyVar;
        this.e.a(new amb(this, null));
        this.h = true;
        this.f = new ame();
        this.g = new SparseArray<>();
        this.k = new zzst(4);
        this.l = new zzst(ByteBuffer.allocate(4).putInt(-1).array());
        this.m = new zzst(4);
        this.i = new zzst(zzsq.zzaqt);
        this.j = new zzst(4);
        this.n = new zzst();
        this.o = new zzst();
        this.p = new zzst(8);
        this.q = new zzst();
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean zza(zzno zznoVar) throws IOException, InterruptedException {
        return new amd().a(zznoVar);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zza(zznp zznpVar) {
        this.ac = zznpVar;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zzd(long j, long j2) {
        this.E = -9223372036854775807L;
        this.I = 0;
        this.e.a();
        this.f.a();
        b();
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final int zza(zzno zznoVar, zznt zzntVar) throws IOException, InterruptedException {
        boolean z;
        this.aa = false;
        boolean z2 = true;
        while (z2 && !this.aa) {
            z2 = this.e.a(zznoVar);
            if (z2) {
                long position = zznoVar.getPosition();
                if (this.B) {
                    this.D = position;
                    zzntVar.zzahv = this.C;
                    this.B = false;
                    z = true;
                } else {
                    if (this.y) {
                        long j = this.D;
                        if (j != -1) {
                            zzntVar.zzahv = j;
                            this.D = -1L;
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    return 1;
                }
            }
        }
        return z2 ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, long j, long j2) throws zzlm {
        if (i == 160) {
            this.ab = false;
            return;
        }
        if (i == 174) {
            this.x = new amc(null);
            return;
        }
        if (i == 187) {
            this.H = false;
            return;
        }
        if (i == 19899) {
            this.z = -1;
            this.A = -1L;
            return;
        }
        if (i == 20533) {
            this.x.e = true;
            return;
        }
        if (i == 21968) {
            this.x.q = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                long j3 = this.t;
                if (j3 != -1 && j3 != j) {
                    throw new zzlm("Multiple Segment elements not supported");
                }
                this.t = j;
                this.s = j2;
                return;
            }
            if (i == 475249515) {
                this.F = new zzsn();
                this.G = new zzsn();
            } else if (i == 524531317 && !this.y) {
                if (this.h && this.C != -1) {
                    this.B = true;
                } else {
                    this.ac.zza(new zznv(this.w));
                    this.y = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i) throws zzlm {
        zznu zznvVar;
        zzsn zzsnVar;
        zzsn zzsnVar2;
        int i2;
        if (i == 160) {
            if (this.I != 2) {
                return;
            }
            if (!this.ab) {
                this.Q |= 1;
            }
            a(this.g.get(this.O), this.J);
            this.I = 0;
            return;
        }
        if (i == 174) {
            String str = this.x.f1963a;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                amc amcVar = this.x;
                amcVar.a(this.ac, amcVar.b);
                this.g.put(this.x.b, this.x);
            }
            this.x = null;
            return;
        }
        if (i == 19899) {
            int i3 = this.z;
            if (i3 != -1) {
                long j = this.A;
                if (j != -1) {
                    if (i3 == 475249515) {
                        this.C = j;
                        return;
                    }
                    return;
                }
            }
            throw new zzlm("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            if (this.x.e) {
                if (this.x.g == null) {
                    throw new zzlm("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.x.i = new zzne(new zzne.zza(zzkt.zzarg, "video/webm", this.x.g.zzazq));
                return;
            }
            return;
        }
        if (i == 28032) {
            if (this.x.e && this.x.f != null) {
                throw new zzlm("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.u == -9223372036854775807L) {
                this.u = 1000000L;
            }
            long j2 = this.v;
            if (j2 != -9223372036854775807L) {
                this.w = a(j2);
                return;
            }
            return;
        }
        if (i != 374648427) {
            if (i == 475249515 && !this.y) {
                zznp zznpVar = this.ac;
                if (this.t == -1 || this.w == -9223372036854775807L || (zzsnVar = this.F) == null || zzsnVar.size() == 0 || (zzsnVar2 = this.G) == null || zzsnVar2.size() != this.F.size()) {
                    this.F = null;
                    this.G = null;
                    zznvVar = new zznv(this.w);
                } else {
                    int size = this.F.size();
                    int[] iArr = new int[size];
                    long[] jArr = new long[size];
                    long[] jArr2 = new long[size];
                    long[] jArr3 = new long[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        jArr3[i4] = this.F.get(i4);
                        jArr[i4] = this.t + this.G.get(i4);
                    }
                    while (true) {
                        i2 = size - 1;
                        if (r1 >= i2) {
                            break;
                        }
                        int i5 = r1 + 1;
                        iArr[r1] = (int) (jArr[i5] - jArr[r1]);
                        jArr2[r1] = jArr3[i5] - jArr3[r1];
                        r1 = i5;
                    }
                    iArr[i2] = (int) ((this.t + this.s) - jArr[i2]);
                    jArr2[i2] = this.w - jArr3[i2];
                    this.F = null;
                    this.G = null;
                    zznvVar = new zznl(iArr, jArr, jArr2, jArr3);
                }
                zznpVar.zza(zznvVar);
                this.y = true;
                return;
            }
            return;
        }
        if (this.g.size() == 0) {
            throw new zzlm("No valid tracks were found");
        }
        this.ac.zzfi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, long j) throws zzlm {
        switch (i) {
            case 131:
                this.x.c = (int) j;
                return;
            case 136:
                this.x.L = j == 1;
                return;
            case 155:
                this.K = a(j);
                return;
            case 159:
                this.x.G = (int) j;
                return;
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                this.x.j = (int) j;
                return;
            case 179:
                this.F.add(a(j));
                return;
            case 186:
                this.x.k = (int) j;
                return;
            case TbsListener.ErrorCode.COPY_EXCEPTION /* 215 */:
                this.x.b = (int) j;
                return;
            case 231:
                this.E = a(j);
                return;
            case 241:
                if (this.H) {
                    return;
                }
                this.G.add(j);
                this.H = true;
                return;
            case 251:
                this.ab = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb = new StringBuilder(50);
                sb.append("ContentCompAlgo ");
                sb.append(j);
                sb.append(" not supported");
                throw new zzlm(sb.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("DocTypeReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzlm(sb2.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("EBMLReadVersion ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new zzlm(sb3.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder(49);
                sb4.append("ContentEncAlgo ");
                sb4.append(j);
                sb4.append(" not supported");
                throw new zzlm(sb4.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(56);
                sb5.append("AESSettingsCipherMode ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new zzlm(sb5.toString());
            case 20529:
                if (j == 0) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingOrder ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzlm(sb6.toString());
            case 20530:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(55);
                sb7.append("ContentEncodingScope ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new zzlm(sb7.toString());
            case 21420:
                this.A = j + this.t;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 3) {
                    this.x.p = 1;
                    return;
                }
                if (i2 != 15) {
                    switch (i2) {
                        case 0:
                            this.x.p = 0;
                            return;
                        case 1:
                            this.x.p = 2;
                            return;
                        default:
                            return;
                    }
                }
                this.x.p = 3;
                return;
            case 21680:
                this.x.l = (int) j;
                return;
            case 21682:
                this.x.n = (int) j;
                return;
            case 21690:
                this.x.m = (int) j;
                return;
            case 21930:
                this.x.M = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.x.t = 2;
                        return;
                    case 2:
                        this.x.t = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int i3 = (int) j;
                if (i3 != 1) {
                    if (i3 == 16) {
                        this.x.s = 6;
                        return;
                    } else if (i3 == 18) {
                        this.x.s = 7;
                        return;
                    } else {
                        switch (i3) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    }
                }
                this.x.s = 3;
                return;
            case 21947:
                amc amcVar = this.x;
                amcVar.q = true;
                int i4 = (int) j;
                if (i4 == 1) {
                    amcVar.r = 1;
                    return;
                } else {
                    if (i4 != 9) {
                        switch (i4) {
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                amcVar.r = 2;
                                return;
                            default:
                                return;
                        }
                    }
                    amcVar.r = 6;
                    return;
                }
            case 21948:
                this.x.u = (int) j;
                return;
            case 21949:
                this.x.v = (int) j;
                return;
            case 22186:
                this.x.J = j;
                return;
            case 22203:
                this.x.K = j;
                return;
            case 25188:
                this.x.H = (int) j;
                return;
            case 2352003:
                this.x.d = (int) j;
                return;
            case 2807729:
                this.u = j;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, double d2) {
        if (i == 181) {
            this.x.I = (int) d2;
            return;
        }
        if (i == 17545) {
            this.v = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                this.x.w = (float) d2;
                return;
            case 21970:
                this.x.x = (float) d2;
                return;
            case 21971:
                this.x.y = (float) d2;
                return;
            case 21972:
                this.x.z = (float) d2;
                return;
            case 21973:
                this.x.A = (float) d2;
                return;
            case 21974:
                this.x.B = (float) d2;
                return;
            case 21975:
                this.x.C = (float) d2;
                return;
            case 21976:
                this.x.D = (float) d2;
                return;
            case 21977:
                this.x.E = (float) d2;
                return;
            case 21978:
                this.x.F = (float) d2;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, String str) throws zzlm {
        if (i == 134) {
            this.x.f1963a = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            amc.a(this.x, str);
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzlm(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0205, code lost:
    
        throw new com.google.android.gms.internal.ads.zzlm("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r20, int r21, com.google.android.gms.internal.ads.zzno r22) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzod.a(int, int, com.google.android.gms.internal.ads.zzno):void");
    }

    private final void a(amc amcVar, long j) {
        byte[] zzbh;
        if ("S_TEXT/UTF8".equals(amcVar.f1963a)) {
            byte[] bArr = this.o.data;
            long j2 = this.K;
            if (j2 == -9223372036854775807L) {
                zzbh = c;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (i * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i2);
                zzbh = zzsy.zzbh(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * r4)) / 1000))));
            }
            System.arraycopy(zzbh, 0, bArr, 19, 12);
            zznw zznwVar = amcVar.N;
            zzst zzstVar = this.o;
            zznwVar.zza(zzstVar, zzstVar.limit());
            this.Z += this.o.limit();
        }
        amcVar.N.zza(j, this.Q, this.Z, 0, amcVar.g);
        this.aa = true;
        b();
    }

    private final void b() {
        this.R = 0;
        this.Z = 0;
        this.Y = 0;
        this.S = false;
        this.T = false;
        this.V = false;
        this.X = 0;
        this.W = (byte) 0;
        this.U = false;
        this.n.reset();
    }

    private final void a(zzno zznoVar, int i) throws IOException, InterruptedException {
        if (this.k.limit() >= i) {
            return;
        }
        if (this.k.capacity() < i) {
            zzst zzstVar = this.k;
            zzstVar.zzb(Arrays.copyOf(zzstVar.data, Math.max(this.k.data.length << 1, i)), this.k.limit());
        }
        zznoVar.readFully(this.k.data, this.k.limit(), i - this.k.limit());
        this.k.zzbo(i);
    }

    private final void a(zzno zznoVar, amc amcVar, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(amcVar.f1963a)) {
            int length = b.length + i;
            if (this.o.capacity() < length) {
                this.o.data = Arrays.copyOf(b, length + i);
            }
            zznoVar.readFully(this.o.data, b.length, i);
            this.o.setPosition(0);
            this.o.zzbo(length);
            return;
        }
        zznw zznwVar = amcVar.N;
        if (!this.S) {
            if (amcVar.e) {
                this.Q &= -1073741825;
                if (!this.T) {
                    zznoVar.readFully(this.k.data, 0, 1);
                    this.R++;
                    if ((this.k.data[0] & 128) == 128) {
                        throw new zzlm("Extension bit is set in signal byte");
                    }
                    this.W = this.k.data[0];
                    this.T = true;
                }
                byte b2 = this.W;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.U) {
                        zznoVar.readFully(this.p.data, 0, 8);
                        this.R += 8;
                        this.U = true;
                        this.k.data[0] = (byte) ((z ? 128 : 0) | 8);
                        this.k.setPosition(0);
                        zznwVar.zza(this.k, 1);
                        this.Z++;
                        this.p.setPosition(0);
                        zznwVar.zza(this.p, 8);
                        this.Z += 8;
                    }
                    if (z) {
                        if (!this.V) {
                            zznoVar.readFully(this.k.data, 0, 1);
                            this.R++;
                            this.k.setPosition(0);
                            this.X = this.k.readUnsignedByte();
                            this.V = true;
                        }
                        int i3 = this.X << 2;
                        this.k.reset(i3);
                        zznoVar.readFully(this.k.data, 0, i3);
                        this.R += i3;
                        short s = (short) ((this.X / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.r;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.r = ByteBuffer.allocate(i4);
                        }
                        this.r.position(0);
                        this.r.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.X;
                            if (i5 >= i2) {
                                break;
                            }
                            int zzgg = this.k.zzgg();
                            if (i5 % 2 == 0) {
                                this.r.putShort((short) (zzgg - i6));
                            } else {
                                this.r.putInt(zzgg - i6);
                            }
                            i5++;
                            i6 = zzgg;
                        }
                        int i7 = (i - this.R) - i6;
                        if (i2 % 2 == 1) {
                            this.r.putInt(i7);
                        } else {
                            this.r.putShort((short) i7);
                            this.r.putInt(0);
                        }
                        this.q.zzb(this.r.array(), i4);
                        zznwVar.zza(this.q, i4);
                        this.Z += i4;
                    }
                }
            } else if (amcVar.f != null) {
                this.n.zzb(amcVar.f, amcVar.f.length);
            }
            this.S = true;
        }
        int limit = i + this.n.limit();
        if (!"V_MPEG4/ISO/AVC".equals(amcVar.f1963a) && !"V_MPEGH/ISO/HEVC".equals(amcVar.f1963a)) {
            while (true) {
                int i8 = this.R;
                if (i8 >= limit) {
                    break;
                } else {
                    a(zznoVar, zznwVar, limit - i8);
                }
            }
        } else {
            byte[] bArr = this.j.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i9 = amcVar.O;
            int i10 = 4 - amcVar.O;
            while (this.R < limit) {
                int i11 = this.Y;
                if (i11 == 0) {
                    int min = Math.min(i9, this.n.zzjz());
                    zznoVar.readFully(bArr, i10 + min, i9 - min);
                    if (min > 0) {
                        this.n.zzb(bArr, i10, min);
                    }
                    this.R += i9;
                    this.j.setPosition(0);
                    this.Y = this.j.zzgg();
                    this.i.setPosition(0);
                    zznwVar.zza(this.i, 4);
                    this.Z += 4;
                } else {
                    this.Y = i11 - a(zznoVar, zznwVar, i11);
                }
            }
        }
        if ("A_VORBIS".equals(amcVar.f1963a)) {
            this.l.setPosition(0);
            zznwVar.zza(this.l, 4);
            this.Z += 4;
        }
    }

    private final int a(zzno zznoVar, zznw zznwVar, int i) throws IOException, InterruptedException {
        int zza;
        int zzjz = this.n.zzjz();
        if (zzjz > 0) {
            zza = Math.min(i, zzjz);
            zznwVar.zza(this.n, zza);
        } else {
            zza = zznwVar.zza(zznoVar, i, false);
        }
        this.R += zza;
        this.Z += zza;
        return zza;
    }

    private final long a(long j) throws zzlm {
        long j2 = this.u;
        if (j2 == -9223372036854775807L) {
            throw new zzlm("Can't scale timecode prior to timecodeScale being set.");
        }
        return zzsy.zza(j, j2, 1000L);
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }
}
