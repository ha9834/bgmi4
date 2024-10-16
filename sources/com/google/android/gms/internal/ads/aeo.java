package com.google.android.gms.internal.ads;

import com.google.android.gms.games.Notifications;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aeo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, aep aepVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aepVar.f1835a = b;
            return i2;
        }
        return a(b, bArr, i2, aepVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, aep aepVar) {
        int i3 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aepVar.f1835a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            aepVar.f1835a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            aepVar.f1835a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            aepVar.f1835a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                aepVar.f1835a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, aep aepVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            aepVar.b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        aepVar.b = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(byte[] bArr, int i, aep aepVar) throws zzdok {
        int a2 = a(bArr, i, aepVar);
        int i2 = aepVar.f1835a;
        if (i2 < 0) {
            throw zzdok.b();
        }
        if (i2 == 0) {
            aepVar.c = "";
            return a2;
        }
        aepVar.c = new String(bArr, a2, i2, zzdod.f3593a);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, aep aepVar) throws zzdok {
        int a2 = a(bArr, i, aepVar);
        int i2 = aepVar.f1835a;
        if (i2 < 0) {
            throw zzdok.b();
        }
        if (i2 == 0) {
            aepVar.c = "";
            return a2;
        }
        aepVar.c = ahv.b(bArr, a2, i2);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, aep aepVar) throws zzdok {
        int a2 = a(bArr, i, aepVar);
        int i2 = aepVar.f1835a;
        if (i2 < 0) {
            throw zzdok.b();
        }
        if (i2 > bArr.length - a2) {
            throw zzdok.a();
        }
        if (i2 == 0) {
            aepVar.c = zzdmr.zzhcr;
            return a2;
        }
        aepVar.c = zzdmr.zzi(bArr, a2, i2);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(agx agxVar, byte[] bArr, int i, int i2, aep aepVar) throws IOException {
        int i3;
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            int a2 = a(i5, bArr, i4, aepVar);
            i5 = aepVar.f1835a;
            i3 = a2;
        } else {
            i3 = i4;
        }
        if (i5 < 0 || i5 > i2 - i3) {
            throw zzdok.a();
        }
        Object a3 = agxVar.a();
        int i6 = i5 + i3;
        agxVar.a(a3, bArr, i3, i6, aepVar);
        agxVar.c(a3);
        aepVar.c = a3;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(agx agxVar, byte[] bArr, int i, int i2, int i3, aep aepVar) throws IOException {
        agl aglVar = (agl) agxVar;
        Object a2 = aglVar.a();
        int a3 = aglVar.a((agl) a2, bArr, i, i2, i3, aepVar);
        aglVar.c((agl) a2);
        aepVar.c = a2;
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzdoj<?> zzdojVar, aep aepVar) {
        afr afrVar = (afr) zzdojVar;
        int a2 = a(bArr, i2, aepVar);
        afrVar.zzgp(aepVar.f1835a);
        while (a2 < i3) {
            int a3 = a(bArr, a2, aepVar);
            if (i != aepVar.f1835a) {
                break;
            }
            a2 = a(bArr, a3, aepVar);
            afrVar.zzgp(aepVar.f1835a);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(byte[] bArr, int i, zzdoj<?> zzdojVar, aep aepVar) throws IOException {
        afr afrVar = (afr) zzdojVar;
        int a2 = a(bArr, i, aepVar);
        int i2 = aepVar.f1835a + a2;
        while (a2 < i2) {
            a2 = a(bArr, a2, aepVar);
            afrVar.zzgp(aepVar.f1835a);
        }
        if (a2 == i2) {
            return a2;
        }
        throw zzdok.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(agx<?> agxVar, int i, byte[] bArr, int i2, int i3, zzdoj<?> zzdojVar, aep aepVar) throws IOException {
        int a2 = a(agxVar, bArr, i2, i3, aepVar);
        zzdojVar.add(aepVar.c);
        while (a2 < i3) {
            int a3 = a(bArr, a2, aepVar);
            if (i != aepVar.f1835a) {
                break;
            }
            a2 = a(agxVar, bArr, a3, i3, aepVar);
            zzdojVar.add(aepVar.c);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, byte[] bArr, int i2, int i3, zzdqu zzdquVar, aep aepVar) throws zzdok {
        if ((i >>> 3) == 0) {
            throw zzdok.d();
        }
        int i4 = i & 7;
        if (i4 != 5) {
            switch (i4) {
                case 0:
                    int b = b(bArr, i2, aepVar);
                    zzdquVar.a(i, Long.valueOf(aepVar.b));
                    return b;
                case 1:
                    zzdquVar.a(i, Long.valueOf(b(bArr, i2)));
                    return i2 + 8;
                case 2:
                    int a2 = a(bArr, i2, aepVar);
                    int i5 = aepVar.f1835a;
                    if (i5 < 0) {
                        throw zzdok.b();
                    }
                    if (i5 > bArr.length - a2) {
                        throw zzdok.a();
                    }
                    if (i5 == 0) {
                        zzdquVar.a(i, zzdmr.zzhcr);
                    } else {
                        zzdquVar.a(i, zzdmr.zzi(bArr, a2, i5));
                    }
                    return a2 + i5;
                case 3:
                    zzdqu a3 = zzdqu.a();
                    int i6 = (i & (-8)) | 4;
                    int i7 = 0;
                    while (true) {
                        if (i2 < i3) {
                            int a4 = a(bArr, i2, aepVar);
                            int i8 = aepVar.f1835a;
                            if (i8 != i6) {
                                i7 = i8;
                                i2 = a(i8, bArr, a4, i3, a3, aepVar);
                            } else {
                                i7 = i8;
                                i2 = a4;
                            }
                        }
                    }
                    if (i2 > i3 || i7 != i6) {
                        throw zzdok.g();
                    }
                    zzdquVar.a(i, a3);
                    return i2;
                default:
                    throw zzdok.d();
            }
        }
        zzdquVar.a(i, Integer.valueOf(a(bArr, i2)));
        return i2 + 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, byte[] bArr, int i2, int i3, aep aepVar) throws zzdok {
        if ((i >>> 3) == 0) {
            throw zzdok.d();
        }
        int i4 = i & 7;
        if (i4 == 5) {
            return i2 + 4;
        }
        switch (i4) {
            case 0:
                return b(bArr, i2, aepVar);
            case 1:
                return i2 + 8;
            case 2:
                return a(bArr, i2, aepVar) + aepVar.f1835a;
            case 3:
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = a(bArr, i2, aepVar);
                    i6 = aepVar.f1835a;
                    if (i6 == i5) {
                        if (i2 <= i3 || i6 != i5) {
                            throw zzdok.g();
                        }
                        return i2;
                    }
                    i2 = a(i6, bArr, i2, i3, aepVar);
                }
                if (i2 <= i3) {
                }
                throw zzdok.g();
            default:
                throw zzdok.d();
        }
    }
}
