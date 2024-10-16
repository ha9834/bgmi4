package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzjg implements zzid {
    private int A;
    private int B;
    private long C;
    private boolean D;
    private boolean E;
    private zzif F;

    /* renamed from: a, reason: collision with root package name */
    private final akl f3660a;
    private final akn b;
    private final zzkm c;
    private final zzkm d;
    private final zzkm e;
    private long f;
    private long g;
    private long h;
    private long i;
    private akq j;
    private akq k;
    private akq l;
    private boolean m;
    private int n;
    private long o;
    private boolean p;
    private long q;
    private long r;
    private int s;
    private long t;
    private zzkk u;
    private zzkk v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public zzjg() {
        this(new aki());
    }

    private zzjg(akl aklVar) {
        this.f = -1L;
        this.g = -1L;
        this.h = 1000000L;
        this.i = -1L;
        this.q = -1L;
        this.r = -1L;
        this.s = 0;
        this.t = -1L;
        this.f3660a = aklVar;
        this.f3660a.a(new akp(this));
        this.b = new akn();
        this.c = new zzkm(4);
        this.d = new zzkm(ByteBuffer.allocate(4).putInt(-1).array());
        this.e = new zzkm(4);
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void zza(zzif zzifVar) {
        this.F = zzifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void zzfh() {
        this.t = -1L;
        this.y = 0;
        this.f3660a.a();
        this.b.a();
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zza(zzie zzieVar, zzij zzijVar) throws IOException, InterruptedException {
        boolean z;
        this.D = false;
        boolean z2 = true;
        while (z2 && !this.D) {
            z2 = this.f3660a.a(zzieVar);
            if (z2) {
                long position = zzieVar.getPosition();
                if (this.p) {
                    this.r = position;
                    zzijVar.zzahv = this.q;
                    this.s = 1;
                    this.p = false;
                    z = true;
                } else {
                    if (this.s == 2) {
                        long j = this.r;
                        if (j != -1) {
                            zzijVar.zzahv = j;
                            this.r = -1L;
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
    public final void a(int i, long j, long j2) throws zzhl {
        if (i == 160) {
            this.E = false;
            return;
        }
        if (i == 174) {
            this.j = new akq();
            return;
        }
        if (i == 187) {
            this.w = false;
            return;
        }
        if (i == 19899) {
            this.n = -1;
            this.o = -1L;
            return;
        }
        if (i == 20533) {
            this.j.d = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                if (this.f != -1) {
                    throw new zzhl("Multiple Segment elements not supported");
                }
                this.f = j;
                this.g = j2;
                return;
            }
            if (i == 475249515) {
                this.u = new zzkk();
                this.v = new zzkk();
            } else if (i == 524531317 && this.s == 0 && this.q != -1) {
                this.p = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) throws zzhl {
        zzhj zza;
        zzhj zzb;
        if (i == 160) {
            if (this.y != 2) {
                return;
            }
            if (!this.E) {
                this.B |= 1;
            }
            akq akqVar = this.k;
            a(((akqVar == null || this.A != akqVar.b) ? this.l : this.k).m);
            return;
        }
        if (i == 174) {
            if (this.j.b == -1 || this.j.c == -1) {
                throw new zzhl("Mandatory element TrackNumber or TrackType not found");
            }
            if ((this.j.c == 2 && this.k != null) || (this.j.c == 1 && this.l != null)) {
                this.j = null;
                return;
            }
            if (this.j.c == 2 && a(this.j.f1937a)) {
                this.k = this.j;
                akq akqVar2 = this.k;
                akqVar2.m = this.F.zzs(akqVar2.b);
                zzip zzipVar = this.k.m;
                akq akqVar3 = this.k;
                if (akqVar3 != null && "A_VORBIS".equals(akqVar3.f1937a)) {
                    zzb = zzhj.zzb("audio/vorbis", 8192, this.i, this.k.h, this.k.i, a());
                } else {
                    akq akqVar4 = this.k;
                    if (akqVar4 != null && "A_OPUS".equals(akqVar4.f1937a)) {
                        ArrayList arrayList = new ArrayList(3);
                        arrayList.add(this.k.j);
                        arrayList.add(ByteBuffer.allocate(64).putLong(this.k.k).array());
                        arrayList.add(ByteBuffer.allocate(64).putLong(this.k.l).array());
                        zzb = zzhj.zzb("audio/opus", 5760, this.i, this.k.h, this.k.i, arrayList);
                    } else {
                        throw new zzhl("Unable to build format");
                    }
                }
                zzipVar.zza(zzb);
            } else if (this.j.c == 1 && a(this.j.f1937a)) {
                this.l = this.j;
                akq akqVar5 = this.l;
                akqVar5.m = this.F.zzs(akqVar5.b);
                zzip zzipVar2 = this.l.m;
                akq akqVar6 = this.l;
                if (akqVar6 != null && "V_VP8".equals(akqVar6.f1937a)) {
                    zza = zzhj.zza("video/x-vnd.on2.vp8", -1, this.i, this.l.f, this.l.g, null);
                } else {
                    akq akqVar7 = this.l;
                    if (akqVar7 != null && "V_VP9".equals(akqVar7.f1937a)) {
                        zza = zzhj.zza("video/x-vnd.on2.vp9", -1, this.i, this.l.f, this.l.g, null);
                    } else {
                        throw new zzhl("Unable to build format");
                    }
                }
                zzipVar2.zza(zza);
            }
            this.j = null;
            return;
        }
        if (i == 19899) {
            int i2 = this.n;
            if (i2 != -1) {
                long j = this.o;
                if (j != -1) {
                    if (i2 == 475249515) {
                        this.q = j;
                        return;
                    }
                    return;
                }
            }
            throw new zzhl("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            if (!this.j.d) {
                throw new zzhl("Found an unsupported ContentEncoding");
            }
            if (this.j.e == null) {
                throw new zzhl("Encrypted Track found but ContentEncKeyID was not found");
            }
            if (this.m) {
                return;
            }
            this.F.zzb(new zzhy("video/webm", this.j.e));
            this.m = true;
            return;
        }
        if (i != 374648427) {
            if (i != 475249515 || this.s == 2) {
                return;
            }
            zzif zzifVar = this.F;
            if (this.f == -1) {
                throw new zzhl("Segment start/end offsets unknown");
            }
            if (this.i == -1) {
                throw new zzhl("Duration unknown");
            }
            zzkk zzkkVar = this.u;
            if (zzkkVar == null || this.v == null || zzkkVar.size() == 0 || this.u.size() != this.v.size()) {
                throw new zzhl("Invalid/missing cue points");
            }
            int size = this.u.size();
            int[] iArr = new int[size];
            long[] jArr = new long[size];
            long[] jArr2 = new long[size];
            long[] jArr3 = new long[size];
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                jArr3[i4] = this.u.get(i4);
                jArr[i4] = this.f + this.v.get(i4);
            }
            while (true) {
                int i5 = size - 1;
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                    jArr2[i3] = jArr3[i6] - jArr3[i3];
                    i3 = i6;
                } else {
                    iArr[i5] = (int) ((this.f + this.g) - jArr[i5]);
                    jArr2[i5] = this.i - jArr3[i5];
                    this.u = null;
                    this.v = null;
                    zzifVar.zza(new zzia(iArr, jArr, jArr2, jArr3));
                    this.s = 2;
                    return;
                }
            }
        } else {
            if (this.l == null && this.k == null) {
                throw new zzhl("No valid tracks were found");
            }
            this.F.zzfi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, long j) throws zzhl {
        switch (i) {
            case 131:
                this.j.c = (int) j;
                return;
            case 159:
                this.j.h = (int) j;
                return;
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                this.j.f = (int) j;
                return;
            case 179:
                this.u.add(a(j));
                return;
            case 186:
                this.j.g = (int) j;
                return;
            case TbsListener.ErrorCode.COPY_EXCEPTION /* 215 */:
                this.j.b = (int) j;
                return;
            case 231:
                this.t = a(j);
                return;
            case 241:
                if (this.w) {
                    return;
                }
                this.v.add(j);
                this.w = true;
                return;
            case 251:
                this.E = true;
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb = new StringBuilder(53);
                    sb.append("DocTypeReadVersion ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new zzhl(sb.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("EBMLReadVersion ");
                sb2.append(j);
                sb2.append(" not supported");
                throw new zzhl(sb2.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(49);
                sb3.append("ContentEncAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new zzhl(sb3.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder(56);
                sb4.append("AESSettingsCipherMode ");
                sb4.append(j);
                sb4.append(" not supported");
                throw new zzhl(sb4.toString());
            case 20529:
                if (j == 0) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(55);
                sb5.append("ContentEncodingOrder ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new zzhl(sb5.toString());
            case 20530:
                if (j == 1) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzhl(sb6.toString());
            case 20531:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(54);
                sb7.append("ContentEncodingType ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new zzhl(sb7.toString());
            case 21420:
                this.o = j + this.f;
                return;
            case 22186:
                this.j.k = j;
                return;
            case 22203:
                this.j.l = j;
                return;
            case 2807729:
                this.h = j;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, double d) {
        if (i == 181) {
            this.j.i = (int) d;
        } else {
            if (i != 17545) {
                return;
            }
            this.i = a((long) d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, String str) throws zzhl {
        if (i != 134) {
            if (i == 17026 && !"webm".equals(str)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
                sb.append("DocType ");
                sb.append(str);
                sb.append(" not supported");
                throw new zzhl(sb.toString());
            }
            return;
        }
        this.j.f1937a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, int i2, zzie zzieVar) throws IOException, InterruptedException {
        akq akqVar;
        boolean z;
        akq akqVar2;
        if (i != 161 && i != 163) {
            if (i == 18402) {
                akq akqVar3 = this.j;
                akqVar3.e = new byte[i2];
                zzieVar.readFully(akqVar3.e, 0, i2);
                return;
            } else {
                if (i == 21419) {
                    Arrays.fill(this.e.data, (byte) 0);
                    zzieVar.readFully(this.e.data, 4 - i2, i2);
                    this.e.setPosition(0);
                    this.n = (int) this.e.zzge();
                    return;
                }
                if (i == 25506) {
                    akq akqVar4 = this.j;
                    akqVar4.j = new byte[i2];
                    zzieVar.readFully(akqVar4.j, 0, i2);
                    return;
                } else {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("Unexpected id: ");
                    sb.append(i);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        if (this.y == 0) {
            this.A = (int) this.b.a(zzieVar, false, true);
            this.x = this.b.b();
            this.y = 1;
        }
        akq akqVar5 = this.k;
        if ((akqVar5 != null && this.l != null && akqVar5.b != this.A && this.l.b != this.A) || (((akqVar = this.k) != null && this.l == null && akqVar.b != this.A) || (this.k == null && (akqVar2 = this.l) != null && akqVar2.b != this.A))) {
            zzieVar.zzr(i2 - this.x);
            this.y = 0;
            return;
        }
        akq akqVar6 = this.k;
        akq akqVar7 = (akqVar6 == null || this.A != akqVar6.b) ? this.l : this.k;
        zzip zzipVar = akqVar7.m;
        if (this.y == 1) {
            byte[] bArr = this.c.data;
            int i3 = akqVar7.d ? 4 : 3;
            zzieVar.readFully(bArr, 0, i3);
            this.x += i3;
            this.C = this.t + a((bArr[0] << 8) | (bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
            int i4 = (bArr[2] & 6) >> 1;
            if (i4 != 0) {
                StringBuilder sb2 = new StringBuilder(38);
                sb2.append("Lacing mode not supported: ");
                sb2.append(i4);
                throw new zzhl(sb2.toString());
            }
            boolean z2 = (bArr[2] & 8) == 8;
            int i5 = (i == 163 && (bArr[2] & 128) == 128) ? 1 : 0;
            if (!akqVar7.d) {
                z = false;
            } else {
                if ((bArr[3] & 128) == 128) {
                    throw new zzhl("Extension bit is set in signal byte");
                }
                z = (bArr[3] & 1) == 1;
            }
            this.B = (z2 ? 134217728 : 0) | i5 | (z ? 2 : 0);
            this.z = i2 - this.x;
            if (z) {
                this.c.data[0] = 8;
                this.c.setPosition(0);
                zzipVar.zza(this.c, 1);
                this.z++;
            }
            this.y = 2;
        }
        while (true) {
            int i6 = this.x;
            if (i6 >= i2) {
                break;
            } else {
                this.x = i6 + zzipVar.zza(zzieVar, i2 - i6);
            }
        }
        if ("A_VORBIS".equals(akqVar7.f1937a)) {
            this.d.setPosition(0);
            zzipVar.zza(this.d, 4);
            this.z += 4;
        }
        if (i == 163) {
            a(zzipVar);
        }
    }

    private final void a(zzip zzipVar) {
        zzipVar.zza(this.C, this.B, this.z, 0, null);
        this.y = 0;
        this.D = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ArrayList<byte[]> a() throws zzhl {
        try {
            byte[] bArr = this.k.j;
            if (bArr[0] != 2) {
                throw new zzhl("Error parsing vorbis codec private");
            }
            int i = 1;
            int i2 = 0;
            while (bArr[i] == -1) {
                i2 += 255;
                i++;
            }
            int i3 = i + 1;
            int i4 = i2 + bArr[i];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new zzhl("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzhl("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzhl("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList<byte[]> arrayList = new ArrayList<>(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhl("Error parsing vorbis codec private");
        }
    }

    private final long a(long j) {
        return TimeUnit.NANOSECONDS.toMicros(j * this.h);
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str);
    }
}
