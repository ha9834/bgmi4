package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.ads.zzpo;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class ami {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1968a = zzsy.zzay("vide");
    private static final int b = zzsy.zzay("soun");
    private static final int c = zzsy.zzay("text");
    private static final int d = zzsy.zzay("sbtl");
    private static final int e = zzsy.zzay("subt");
    private static final int f = zzsy.zzay("clcp");
    private static final int g = zzsy.zzay("cenc");
    private static final int h = zzsy.zzay("meta");

    /* JADX WARN: Removed duplicated region for block: B:265:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0699 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzpa a(com.google.android.gms.internal.ads.amg r43, com.google.android.gms.internal.ads.amh r44, long r45, com.google.android.gms.internal.ads.zzne r47, boolean r48) throws com.google.android.gms.internal.ads.zzlm {
        /*
            Method dump skipped, instructions count: 1902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ami.a(com.google.android.gms.internal.ads.amg, com.google.android.gms.internal.ads.amh, long, com.google.android.gms.internal.ads.zzne, boolean):com.google.android.gms.internal.ads.zzpa");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static amu a(zzpa zzpaVar, amg amgVar, zznr zznrVar) throws zzlm {
        amk amnVar;
        boolean z;
        int i;
        int i2;
        int i3;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i4;
        long j;
        int[] iArr3;
        boolean z2;
        long[] jArr3;
        int[] iArr4;
        int[] iArr5;
        int i5;
        int[] iArr6;
        int i6;
        int i7;
        amk amkVar;
        int i8;
        int i9;
        int i10;
        int i11;
        zzpa zzpaVar2 = zzpaVar;
        amh d2 = amgVar.d(amf.aa);
        if (d2 != null) {
            amnVar = new amm(d2);
        } else {
            amh d3 = amgVar.d(amf.ab);
            if (d3 == null) {
                throw new zzlm("Track has no sample table size information");
            }
            amnVar = new amn(d3);
        }
        int a2 = amnVar.a();
        if (a2 == 0) {
            return new amu(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        amh d4 = amgVar.d(amf.ac);
        if (d4 == null) {
            d4 = amgVar.d(amf.ad);
            z = true;
        } else {
            z = false;
        }
        zzst zzstVar = d4.az;
        zzst zzstVar2 = amgVar.d(amf.Z).az;
        zzst zzstVar3 = amgVar.d(amf.W).az;
        amh d5 = amgVar.d(amf.X);
        zzst zzstVar4 = d5 != null ? d5.az : null;
        amh d6 = amgVar.d(amf.Y);
        zzst zzstVar5 = d6 != null ? d6.az : null;
        amj amjVar = new amj(zzstVar2, zzstVar, z);
        zzstVar3.setPosition(12);
        int zzgg = zzstVar3.zzgg() - 1;
        int zzgg2 = zzstVar3.zzgg();
        int zzgg3 = zzstVar3.zzgg();
        if (zzstVar5 != null) {
            zzstVar5.setPosition(12);
            i = zzstVar5.zzgg();
        } else {
            i = 0;
        }
        int i12 = -1;
        if (zzstVar4 != null) {
            zzstVar4.setPosition(12);
            i2 = zzstVar4.zzgg();
            if (i2 > 0) {
                i12 = zzstVar4.zzgg() - 1;
            } else {
                zzstVar4 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(amnVar.c() && "audio/raw".equals(zzpaVar2.zzaue.zzatq) && zzgg == 0 && i == 0 && i2 == 0)) {
            jArr = new long[a2];
            iArr = new int[a2];
            jArr2 = new long[a2];
            int i13 = i2;
            iArr2 = new int[a2];
            int i14 = i13;
            int i15 = zzgg3;
            int i16 = i;
            int i17 = i12;
            long j3 = 0;
            long j4 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = zzgg2;
            int i23 = zzgg;
            int i24 = 0;
            while (i24 < a2) {
                long j5 = j3;
                int i25 = i18;
                while (i25 == 0) {
                    zzsk.checkState(amjVar.a());
                    j5 = amjVar.d;
                    i25 = amjVar.c;
                    i23 = i23;
                    i15 = i15;
                }
                int i26 = i23;
                int i27 = i15;
                if (zzstVar5 != null) {
                    while (i21 == 0 && i16 > 0) {
                        i21 = zzstVar5.zzgg();
                        i20 = zzstVar5.readInt();
                        i16--;
                    }
                    i21--;
                    i6 = i20;
                } else {
                    i6 = i20;
                }
                jArr[i24] = j5;
                iArr[i24] = amnVar.b();
                if (iArr[i24] > i19) {
                    i7 = a2;
                    i19 = iArr[i24];
                    amkVar = amnVar;
                } else {
                    i7 = a2;
                    amkVar = amnVar;
                }
                jArr2[i24] = j4 + i6;
                iArr2[i24] = zzstVar4 == null ? 1 : 0;
                if (i24 == i17) {
                    iArr2[i24] = 1;
                    int i28 = i14 - 1;
                    if (i28 > 0) {
                        i8 = i28;
                        i9 = zzstVar4.zzgg() - 1;
                        i10 = i27;
                    } else {
                        i8 = i28;
                        i9 = i17;
                        i10 = i27;
                    }
                } else {
                    i8 = i14;
                    i9 = i17;
                    i10 = i27;
                }
                j4 += i10;
                i22--;
                if (i22 != 0 || i26 <= 0) {
                    i11 = i26;
                } else {
                    i11 = i26 - 1;
                    i22 = zzstVar3.zzgg();
                    i10 = zzstVar3.zzgg();
                }
                int i29 = i11;
                long j6 = j5 + iArr[i24];
                i24++;
                i17 = i9;
                a2 = i7;
                i18 = i25 - 1;
                i20 = i6;
                i23 = i29;
                j3 = j6;
                amk amkVar2 = amkVar;
                i15 = i10;
                i14 = i8;
                amnVar = amkVar2;
            }
            i3 = a2;
            int i30 = i23;
            zzsk.checkArgument(i21 == 0);
            while (i16 > 0) {
                zzsk.checkArgument(zzstVar5.zzgg() == 0);
                zzstVar5.readInt();
                i16--;
            }
            if (i14 == 0 && i22 == 0 && i18 == 0 && i30 == 0) {
                zzpaVar2 = zzpaVar;
            } else {
                int i31 = i14;
                zzpaVar2 = zzpaVar;
                int i32 = zzpaVar2.id;
                StringBuilder sb = new StringBuilder(TbsListener.ErrorCode.COPY_EXCEPTION);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i32);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i31);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i22);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i18);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i30);
                Log.w("AtomParsers", sb.toString());
            }
            j = j4;
            i4 = i19;
        } else {
            i3 = a2;
            amk amkVar3 = amnVar;
            long[] jArr4 = new long[amjVar.f1969a];
            int[] iArr7 = new int[amjVar.f1969a];
            while (amjVar.a()) {
                jArr4[amjVar.b] = amjVar.d;
                iArr7[amjVar.b] = amjVar.c;
            }
            int b2 = amkVar3.b();
            long j7 = zzgg3;
            int i33 = 8192 / b2;
            int i34 = 0;
            for (int i35 : iArr7) {
                i34 += zzsy.zzb(i35, i33);
            }
            long[] jArr5 = new long[i34];
            int[] iArr8 = new int[i34];
            long[] jArr6 = new long[i34];
            int[] iArr9 = new int[i34];
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            while (i36 < iArr7.length) {
                int i40 = iArr7[i36];
                long j8 = jArr4[i36];
                int i41 = i37;
                int i42 = i39;
                while (i40 > 0) {
                    int min = Math.min(i33, i40);
                    jArr5[i38] = j8;
                    iArr8[i38] = b2 * min;
                    i42 = Math.max(i42, iArr8[i38]);
                    jArr6[i38] = i41 * j7;
                    iArr9[i38] = 1;
                    j8 += iArr8[i38];
                    i41 += min;
                    i40 -= min;
                    i38++;
                    jArr4 = jArr4;
                    iArr7 = iArr7;
                }
                i36++;
                i39 = i42;
                i37 = i41;
            }
            zzou zzouVar = new zzou(jArr5, iArr8, i39, jArr6, iArr9);
            jArr = zzouVar.zzahq;
            iArr = zzouVar.zzahp;
            int i43 = zzouVar.zzbet;
            jArr2 = zzouVar.zzbeu;
            iArr2 = zzouVar.zzajr;
            i4 = i43;
            j = 0;
        }
        if (zzpaVar2.zzbgm == null || zznrVar.zzii()) {
            int[] iArr10 = iArr;
            zzsy.zza(jArr2, 1000000L, zzpaVar2.zzcs);
            return new amu(jArr, iArr10, i4, jArr2, iArr2);
        }
        if (zzpaVar2.zzbgm.length == 1 && zzpaVar2.type == 1 && jArr2.length >= 2) {
            long j9 = zzpaVar2.zzbgn[0];
            long zza = zzsy.zza(zzpaVar2.zzbgm[0], zzpaVar2.zzcs, zzpaVar2.zzbgj) + j9;
            if (jArr2[0] <= j9 && j9 < jArr2[1] && jArr2[jArr2.length - 1] < zza && zza <= j) {
                long j10 = j - zza;
                long zza2 = zzsy.zza(j9 - jArr2[0], zzpaVar2.zzaue.zzafv, zzpaVar2.zzcs);
                long zza3 = zzsy.zza(j10, zzpaVar2.zzaue.zzafv, zzpaVar2.zzcs);
                if ((zza2 != 0 || zza3 != 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zznrVar.zzaty = (int) zza2;
                    zznrVar.zzatz = (int) zza3;
                    zzsy.zza(jArr2, 1000000L, zzpaVar2.zzcs);
                    return new amu(jArr, iArr, i4, jArr2, iArr2);
                }
            }
        }
        if (zzpaVar2.zzbgm.length == 1) {
            char c2 = 0;
            if (zzpaVar2.zzbgm[0] == 0) {
                int i44 = 0;
                while (i44 < jArr2.length) {
                    jArr2[i44] = zzsy.zza(jArr2[i44] - zzpaVar2.zzbgn[c2], 1000000L, zzpaVar2.zzcs);
                    i44++;
                    c2 = 0;
                }
                return new amu(jArr, iArr, i4, jArr2, iArr2);
            }
        }
        boolean z3 = zzpaVar2.type == 1;
        int i45 = 0;
        boolean z4 = false;
        int i46 = 0;
        int i47 = 0;
        while (i45 < zzpaVar2.zzbgm.length) {
            long j11 = zzpaVar2.zzbgn[i45];
            if (j11 != -1) {
                iArr6 = iArr;
                long zza4 = zzsy.zza(zzpaVar2.zzbgm[i45], zzpaVar2.zzcs, zzpaVar2.zzbgj);
                int zzb = zzsy.zzb(jArr2, j11, true, true);
                int zzb2 = zzsy.zzb(jArr2, j11 + zza4, z3, false);
                i46 += zzb2 - zzb;
                z4 |= i47 != zzb;
                i47 = zzb2;
            } else {
                iArr6 = iArr;
            }
            i45++;
            iArr = iArr6;
        }
        int[] iArr11 = iArr;
        boolean z5 = (i46 != i3) | z4;
        long[] jArr7 = z5 ? new long[i46] : jArr;
        int[] iArr12 = z5 ? new int[i46] : iArr11;
        if (z5) {
            i4 = 0;
        }
        int[] iArr13 = z5 ? new int[i46] : iArr2;
        long[] jArr8 = new long[i46];
        int i48 = i4;
        int i49 = 0;
        int i50 = 0;
        while (i49 < zzpaVar2.zzbgm.length) {
            long j12 = zzpaVar2.zzbgn[i49];
            long j13 = zzpaVar2.zzbgm[i49];
            if (j12 != -1) {
                int[] iArr14 = iArr13;
                i5 = i49;
                long zza5 = zzsy.zza(j13, zzpaVar2.zzcs, zzpaVar2.zzbgj) + j12;
                int zzb3 = zzsy.zzb(jArr2, j12, true, true);
                int zzb4 = zzsy.zzb(jArr2, zza5, z3, false);
                if (z5) {
                    int i51 = zzb4 - zzb3;
                    System.arraycopy(jArr, zzb3, jArr7, i50, i51);
                    iArr3 = iArr11;
                    System.arraycopy(iArr3, zzb3, iArr12, i50, i51);
                    z2 = z3;
                    iArr5 = iArr14;
                    System.arraycopy(iArr2, zzb3, iArr5, i50, i51);
                } else {
                    iArr3 = iArr11;
                    z2 = z3;
                    iArr5 = iArr14;
                }
                int i52 = i48;
                while (zzb3 < zzb4) {
                    long[] jArr9 = jArr;
                    int[] iArr15 = iArr2;
                    long j14 = j12;
                    jArr8[i50] = zzsy.zza(j2, 1000000L, zzpaVar2.zzbgj) + zzsy.zza(jArr2[zzb3] - j12, 1000000L, zzpaVar2.zzcs);
                    if (z5 && iArr12[i50] > i52) {
                        i52 = iArr3[zzb3];
                    }
                    i50++;
                    zzb3++;
                    jArr = jArr9;
                    j12 = j14;
                    iArr2 = iArr15;
                }
                jArr3 = jArr;
                iArr4 = iArr2;
                i48 = i52;
            } else {
                iArr3 = iArr11;
                z2 = z3;
                jArr3 = jArr;
                iArr4 = iArr2;
                iArr5 = iArr13;
                i5 = i49;
            }
            j2 += j13;
            i49 = i5 + 1;
            iArr13 = iArr5;
            jArr = jArr3;
            iArr2 = iArr4;
            z3 = z2;
            iArr11 = iArr3;
        }
        int[] iArr16 = iArr13;
        boolean z6 = false;
        for (int i53 = 0; i53 < iArr16.length && !z6; i53++) {
            z6 |= (iArr16[i53] & 1) != 0;
        }
        if (!z6) {
            throw new zzlm("The edited sample sequence does not contain a sync sample.");
        }
        return new amu(jArr7, iArr12, i48, jArr8, iArr16);
    }

    public static zzpo a(amh amhVar, boolean z) {
        if (z) {
            return null;
        }
        zzst zzstVar = amhVar.az;
        zzstVar.setPosition(8);
        while (zzstVar.zzjz() >= 8) {
            int position = zzstVar.getPosition();
            int readInt = zzstVar.readInt();
            if (zzstVar.readInt() == amf.al) {
                zzstVar.setPosition(position);
                int i = position + readInt;
                zzstVar.zzac(12);
                while (true) {
                    if (zzstVar.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzstVar.getPosition();
                    int readInt2 = zzstVar.readInt();
                    if (zzstVar.readInt() == amf.am) {
                        zzstVar.setPosition(position2);
                        int i2 = position2 + readInt2;
                        zzstVar.zzac(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzstVar.getPosition() < i2) {
                            zzpo.zza a2 = amq.a(zzstVar);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzpo(arrayList);
                        }
                    } else {
                        zzstVar.zzac(readInt2 - 8);
                    }
                }
                return null;
            }
            zzstVar.zzac(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> a(zzst zzstVar, int i) {
        zzstVar.setPosition(i + 8 + 4);
        zzstVar.zzac(1);
        a(zzstVar);
        zzstVar.zzac(2);
        int readUnsignedByte = zzstVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzstVar.zzac(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzstVar.zzac(zzstVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzstVar.zzac(2);
        }
        zzstVar.zzac(1);
        a(zzstVar);
        String str = null;
        switch (zzstVar.readUnsignedByte()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case TbsListener.ErrorCode.STARTDOWNLOAD_6 /* 165 */:
                str = "audio/ac3";
                break;
            case TbsListener.ErrorCode.STARTDOWNLOAD_7 /* 166 */:
                str = "audio/eac3";
                break;
            case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                return Pair.create("audio/vnd.dts", null);
            case TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE /* 170 */:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /* 171 */:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        zzstVar.zzac(12);
        zzstVar.zzac(1);
        int a2 = a(zzstVar);
        byte[] bArr = new byte[a2];
        zzstVar.zzb(bArr, 0, a2);
        return Pair.create(str, bArr);
    }

    private static int a(zzst zzstVar, int i, int i2, aml amlVar, int i3) {
        zzpb zzpbVar;
        int position = zzstVar.getPosition();
        while (true) {
            if (position - i >= i2) {
                return 0;
            }
            zzstVar.setPosition(position);
            int readInt = zzstVar.readInt();
            zzsk.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzstVar.readInt() == amf.M) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzpb zzpbVar2 = null;
                boolean z = false;
                while (i4 - position < readInt) {
                    zzstVar.setPosition(i4);
                    int readInt2 = zzstVar.readInt();
                    int readInt3 = zzstVar.readInt();
                    if (readInt3 == amf.S) {
                        num = Integer.valueOf(zzstVar.readInt());
                    } else if (readInt3 == amf.N) {
                        zzstVar.zzac(4);
                        z = zzstVar.readInt() == g;
                    } else if (readInt3 == amf.O) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzpbVar = null;
                                break;
                            }
                            zzstVar.setPosition(i5);
                            int readInt4 = zzstVar.readInt();
                            if (zzstVar.readInt() == amf.P) {
                                zzstVar.zzac(6);
                                boolean z2 = zzstVar.readUnsignedByte() == 1;
                                int readUnsignedByte = zzstVar.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzstVar.zzb(bArr, 0, 16);
                                zzpbVar = new zzpb(z2, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        zzpbVar2 = zzpbVar;
                    }
                    i4 += readInt2;
                }
                if (z) {
                    zzsk.checkArgument(num != null, "frma atom is mandatory");
                    zzsk.checkArgument(zzpbVar2 != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzpbVar2);
                }
                if (pair != null) {
                    amlVar.f1970a[i3] = (zzpb) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }

    private static int a(zzst zzstVar) {
        int readUnsignedByte = zzstVar.readUnsignedByte();
        int i = readUnsignedByte & Notifications.NOTIFICATION_TYPES_ALL;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzstVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & Notifications.NOTIFICATION_TYPES_ALL);
        }
        return i;
    }
}
