package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class amc {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    public zznw N;
    public int O;
    private String P;

    /* renamed from: a */
    public String f1963a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public byte[] f;
    public zznx g;
    public byte[] h;
    public zzne i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public float y;
    public float z;

    private amc() {
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = null;
        this.p = -1;
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = 1000;
        this.v = 200;
        this.w = -1.0f;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = 1;
        this.H = -1;
        this.I = 8000;
        this.J = 0L;
        this.K = 0L;
        this.M = true;
        this.P = "eng";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(zznp zznpVar, int i) throws zzlm {
        char c;
        String str;
        List<byte[]> list;
        int i2;
        int i3;
        zzlh zza;
        zztb zztbVar;
        int i4;
        String str2 = this.f1963a;
        int i5 = 3;
        switch (str2.hashCode()) {
            case -2095576542:
                if (str2.equals("V_MPEG4/ISO/AP")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str2.equals("V_MPEG4/ISO/SP")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str2.equals("A_MS/ACM")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str2.equals("A_TRUEHD")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str2.equals("A_VORBIS")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str2.equals("A_MPEG/L2")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str2.equals("A_MPEG/L3")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str2.equals("V_MS/VFW/FOURCC")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str2.equals("S_DVBSUB")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str2.equals("V_MPEG4/ISO/ASP")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str2.equals("V_MPEG4/ISO/AVC")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str2.equals("S_VOBSUB")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str2.equals("A_DTS/LOSSLESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str2.equals("A_AAC")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str2.equals("A_AC3")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str2.equals("A_DTS")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str2.equals("V_VP8")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str2.equals("V_VP9")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str2.equals("S_HDMV/PGS")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str2.equals("V_THEORA")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str2.equals("A_DTS/EXPRESS")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str2.equals("A_PCM/INT/LIT")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str2.equals("V_MPEGH/ISO/HEVC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str2.equals("S_TEXT/UTF8")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str2.equals("V_MPEG2")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str2.equals("A_EAC3")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str2.equals("A_FLAC")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str2.equals("A_OPUS")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        byte[] bArr = null;
        switch (c) {
            case 0:
                str = "video/x-vnd.on2.vp8";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 1:
                str = "video/x-vnd.on2.vp9";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 2:
                str = "video/mpeg2";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 3:
            case 4:
            case 5:
                byte[] bArr2 = this.h;
                list = bArr2 == null ? null : Collections.singletonList(bArr2);
                str = "video/mp4v-es";
                i2 = -1;
                i3 = -1;
                break;
            case 6:
                zzta zzf = zzta.zzf(new zzst(this.h));
                List<byte[]> list2 = zzf.zzafw;
                this.O = zzf.zzamf;
                str = "video/avc";
                list = list2;
                i2 = -1;
                i3 = -1;
                break;
            case 7:
                zztg zzh = zztg.zzh(new zzst(this.h));
                List<byte[]> list3 = zzh.zzafw;
                this.O = zzh.zzamf;
                str = "video/hevc";
                list = list3;
                i2 = -1;
                i3 = -1;
                break;
            case '\b':
                List<byte[]> a2 = a(new zzst(this.h));
                if (a2 == null) {
                    Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str = "video/x-unknown";
                    i2 = -1;
                    i3 = -1;
                    list = a2;
                    break;
                } else {
                    str = "video/wvc1";
                    i2 = -1;
                    i3 = -1;
                    list = a2;
                    break;
                }
            case '\t':
                str = "video/x-unknown";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case '\n':
                str = "audio/vorbis";
                list = a(this.h);
                i2 = 8192;
                i3 = -1;
                break;
            case 11:
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(this.h);
                arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                str = "audio/opus";
                list = arrayList;
                i2 = 5760;
                i3 = -1;
                break;
            case '\f':
                list = Collections.singletonList(this.h);
                str = "audio/mp4a-latm";
                i2 = -1;
                i3 = -1;
                break;
            case '\r':
                str = "audio/mpeg-L2";
                list = null;
                i2 = 4096;
                i3 = -1;
                break;
            case 14:
                str = "audio/mpeg";
                list = null;
                i2 = 4096;
                i3 = -1;
                break;
            case 15:
                str = "audio/ac3";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 16:
                str = "audio/eac3";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 17:
                str = "audio/true-hd";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 18:
            case 19:
                str = "audio/vnd.dts";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 20:
                str = "audio/vnd.dts.hd";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 21:
                list = Collections.singletonList(this.h);
                str = "audio/x-flac";
                i2 = -1;
                i3 = -1;
                break;
            case 22:
                if (b(new zzst(this.h))) {
                    int zzbs = zzsy.zzbs(this.H);
                    if (zzbs != 0) {
                        str = "audio/raw";
                        i3 = zzbs;
                        list = null;
                        i2 = -1;
                        break;
                    } else {
                        int i6 = this.H;
                        StringBuilder sb = new StringBuilder(String.valueOf("audio/x-unknown").length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i6);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                        str = "audio/x-unknown";
                        list = null;
                        i2 = -1;
                        i3 = -1;
                        break;
                    }
                } else {
                    String valueOf = String.valueOf("audio/x-unknown");
                    Log.w("MatroskaExtractor", valueOf.length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat(valueOf) : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                    str = "audio/x-unknown";
                    list = null;
                    i2 = -1;
                    i3 = -1;
                    break;
                }
            case 23:
                int zzbs2 = zzsy.zzbs(this.H);
                if (zzbs2 != 0) {
                    str = "audio/raw";
                    i3 = zzbs2;
                    list = null;
                    i2 = -1;
                    break;
                } else {
                    int i7 = this.H;
                    StringBuilder sb2 = new StringBuilder(String.valueOf("audio/x-unknown").length() + 60);
                    sb2.append("Unsupported PCM bit depth: ");
                    sb2.append(i7);
                    sb2.append(". Setting mimeType to ");
                    sb2.append("audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    str = "audio/x-unknown";
                    list = null;
                    i2 = -1;
                    i3 = -1;
                    break;
                }
            case 24:
                str = "application/x-subrip";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 25:
                list = Collections.singletonList(this.h);
                str = "application/vobsub";
                i2 = -1;
                i3 = -1;
                break;
            case 26:
                str = "application/pgs";
                list = null;
                i2 = -1;
                i3 = -1;
                break;
            case 27:
                byte[] bArr3 = this.h;
                list = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str = "application/dvbsubs";
                i2 = -1;
                i3 = -1;
                break;
            default:
                throw new zzlm("Unrecognized codec identifier.");
        }
        int i8 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
        if (zzsp.zzav(str)) {
            zza = zzlh.zza(Integer.toString(i), str, null, -1, i2, this.G, this.I, i3, list, this.i, i8, this.P);
            i5 = 1;
        } else if (zzsp.zzbf(str)) {
            if (this.n == 0) {
                int i9 = this.l;
                if (i9 == -1) {
                    i9 = this.j;
                }
                this.l = i9;
                int i10 = this.m;
                if (i10 == -1) {
                    i10 = this.k;
                }
                this.m = i10;
            }
            float f = (this.l == -1 || (i4 = this.m) == -1) ? -1.0f : (this.k * r1) / (this.j * i4);
            if (this.q) {
                if (this.w != -1.0f && this.x != -1.0f && this.y != -1.0f && this.z != -1.0f && this.A != -1.0f && this.B != -1.0f && this.C != -1.0f && this.D != -1.0f && this.E != -1.0f && this.F != -1.0f) {
                    bArr = new byte[25];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.put((byte) 0);
                    wrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
                    wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
                    wrap.putShort((short) (this.E + 0.5f));
                    wrap.putShort((short) (this.F + 0.5f));
                    wrap.putShort((short) this.u);
                    wrap.putShort((short) this.v);
                }
                zztbVar = new zztb(this.r, this.t, this.s, bArr);
            } else {
                zztbVar = null;
            }
            zza = zzlh.zza(Integer.toString(i), str, null, -1, i2, this.j, this.k, -1.0f, list, -1, f, this.o, this.p, zztbVar, this.i);
            i5 = 2;
        } else if ("application/x-subrip".equals(str)) {
            zza = zzlh.zza(Integer.toString(i), str, (String) null, -1, i8, this.P, this.i);
        } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            zza = zzlh.zza(Integer.toString(i), str, (String) null, -1, list, this.P, this.i);
        } else {
            throw new zzlm("Unexpected MIME type.");
        }
        this.N = zznpVar.zzd(this.b, i5);
        this.N.zze(zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static List<byte[]> a(zzst zzstVar) throws zzlm {
        try {
            zzstVar.zzac(16);
            if (zzstVar.zzkb() != 826496599) {
                return null;
            }
            byte[] bArr = zzstVar.data;
            for (int position = zzstVar.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzlm("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing FourCC VC1 codec private");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static List<byte[]> a(byte[] bArr) throws zzlm {
        try {
            if (bArr[0] != 2) {
                throw new zzlm("Error parsing vorbis codec private");
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
                throw new zzlm("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzlm("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzlm("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing vorbis codec private");
        }
    }

    private static boolean b(zzst zzstVar) throws zzlm {
        UUID uuid;
        UUID uuid2;
        try {
            int zzka = zzstVar.zzka();
            if (zzka == 1) {
                return true;
            }
            if (zzka != 65534) {
                return false;
            }
            zzstVar.setPosition(24);
            long readLong = zzstVar.readLong();
            uuid = zzod.d;
            if (readLong == uuid.getMostSignificantBits()) {
                long readLong2 = zzstVar.readLong();
                uuid2 = zzod.d;
                if (readLong2 == uuid2.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing MS/ACM codec private");
        }
    }

    public /* synthetic */ amc(ama amaVar) {
        this();
    }

    public static /* synthetic */ String a(amc amcVar, String str) {
        amcVar.P = str;
        return str;
    }
}
