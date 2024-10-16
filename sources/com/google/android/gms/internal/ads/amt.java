package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class amt {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f1976a = {zzsy.zzay("isom"), zzsy.zzay("iso2"), zzsy.zzay("iso3"), zzsy.zzay("iso4"), zzsy.zzay("iso5"), zzsy.zzay("iso6"), zzsy.zzay("avc1"), zzsy.zzay("hvc1"), zzsy.zzay("hev1"), zzsy.zzay("mp41"), zzsy.zzay("mp42"), zzsy.zzay("3g2a"), zzsy.zzay("3g2b"), zzsy.zzay("3gr6"), zzsy.zzay("3gs6"), zzsy.zzay("3ge6"), zzsy.zzay("3gg6"), zzsy.zzay("M4V "), zzsy.zzay("M4A "), zzsy.zzay("f4v "), zzsy.zzay("kddi"), zzsy.zzay("M4VP"), zzsy.zzay("qt  "), zzsy.zzay("MSNV")};

    public static boolean a(zzno zznoVar) throws IOException, InterruptedException {
        boolean z;
        boolean z2;
        long length = zznoVar.getLength();
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i = (int) length;
        zzst zzstVar = new zzst(64);
        int i2 = 0;
        boolean z3 = false;
        while (i2 < i) {
            zzstVar.reset(8);
            zznoVar.zzc(zzstVar.data, 0, 8);
            long zzge = zzstVar.zzge();
            int readInt = zzstVar.readInt();
            int i3 = 16;
            if (zzge == 1) {
                zznoVar.zzc(zzstVar.data, 8, 8);
                zzstVar.zzbo(16);
                zzge = zzstVar.zzgh();
            } else {
                i3 = 8;
            }
            long j = i3;
            if (zzge < j) {
                break;
            }
            i2 += i3;
            if (readInt != amf.v) {
                if (readInt != amf.E && readInt != amf.F) {
                    if ((i2 + zzge) - j >= i) {
                        break;
                    }
                    int i4 = (int) (zzge - j);
                    i2 += i4;
                    if (readInt == amf.f1966a) {
                        if (i4 < 8) {
                            break;
                        }
                        zzstVar.reset(i4);
                        zznoVar.zzc(zzstVar.data, 0, i4);
                        int i5 = i4 / 4;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= i5) {
                                break;
                            }
                            if (i6 == 1) {
                                zzstVar.zzac(4);
                            } else {
                                int readInt2 = zzstVar.readInt();
                                if ((readInt2 >>> 8) != zzsy.zzay("3gp")) {
                                    int[] iArr = f1976a;
                                    int length2 = iArr.length;
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 >= length2) {
                                            z2 = false;
                                            break;
                                        }
                                        if (iArr[i7] == readInt2) {
                                            z2 = true;
                                            break;
                                        }
                                        i7++;
                                    }
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    z3 = true;
                                    break;
                                }
                            }
                            i6++;
                        }
                        if (!z3) {
                            break;
                        }
                    } else if (i4 != 0) {
                        zznoVar.zzar(i4);
                    }
                } else {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z3 && !z;
    }
}
