package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.games.Notifications;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class be {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, bd bdVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            bdVar.f4042a = b;
            return i2;
        }
        return a(b, bArr, i2, bdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, bd bdVar) {
        int i3 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            bdVar.f4042a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            bdVar.f4042a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            bdVar.f4042a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            bdVar.f4042a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                bdVar.f4042a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, bd bdVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            bdVar.b = j;
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
        bdVar.b = j2;
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
    public static int c(byte[] bArr, int i, bd bdVar) throws zzhm {
        int a2 = a(bArr, i, bdVar);
        int i2 = bdVar.f4042a;
        if (i2 < 0) {
            throw zzhm.b();
        }
        if (i2 == 0) {
            bdVar.c = "";
            return a2;
        }
        bdVar.c = new String(bArr, a2, i2, zzhi.f4184a);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, bd bdVar) throws zzhm {
        int a2 = a(bArr, i, bdVar);
        int i2 = bdVar.f4042a;
        if (i2 < 0) {
            throw zzhm.b();
        }
        if (i2 == 0) {
            bdVar.c = "";
            return a2;
        }
        bdVar.c = ej.b(bArr, a2, i2);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, bd bdVar) throws zzhm {
        int a2 = a(bArr, i, bdVar);
        int i2 = bdVar.f4042a;
        if (i2 < 0) {
            throw zzhm.b();
        }
        if (i2 > bArr.length - a2) {
            throw zzhm.a();
        }
        if (i2 == 0) {
            bdVar.c = zzfx.zzow;
            return a2;
        }
        bdVar.c = zzfx.zzb(bArr, a2, i2);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(dm dmVar, byte[] bArr, int i, int i2, bd bdVar) throws IOException {
        int i3;
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            int a2 = a(i5, bArr, i4, bdVar);
            i5 = bdVar.f4042a;
            i3 = a2;
        } else {
            i3 = i4;
        }
        if (i5 < 0 || i5 > i2 - i3) {
            throw zzhm.a();
        }
        Object a3 = dmVar.a();
        int i6 = i5 + i3;
        dmVar.a(a3, bArr, i3, i6, bdVar);
        dmVar.c(a3);
        bdVar.c = a3;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(dm dmVar, byte[] bArr, int i, int i2, int i3, bd bdVar) throws IOException {
        cz czVar = (cz) dmVar;
        Object a2 = czVar.a();
        int a3 = czVar.a((cz) a2, bArr, i, i2, i3, bdVar);
        czVar.c((cz) a2);
        bdVar.c = a2;
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzhn<?> zzhnVar, bd bdVar) {
        ch chVar = (ch) zzhnVar;
        int a2 = a(bArr, i2, bdVar);
        chVar.b(bdVar.f4042a);
        while (a2 < i3) {
            int a3 = a(bArr, a2, bdVar);
            if (i != bdVar.f4042a) {
                break;
            }
            a2 = a(bArr, a3, bdVar);
            chVar.b(bdVar.f4042a);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(byte[] bArr, int i, zzhn<?> zzhnVar, bd bdVar) throws IOException {
        ch chVar = (ch) zzhnVar;
        int a2 = a(bArr, i, bdVar);
        int i2 = bdVar.f4042a + a2;
        while (a2 < i2) {
            a2 = a(bArr, a2, bdVar);
            chVar.b(bdVar.f4042a);
        }
        if (a2 == i2) {
            return a2;
        }
        throw zzhm.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(dm<?> dmVar, int i, byte[] bArr, int i2, int i3, zzhn<?> zzhnVar, bd bdVar) throws IOException {
        int a2 = a(dmVar, bArr, i2, i3, bdVar);
        zzhnVar.add(bdVar.c);
        while (a2 < i3) {
            int a3 = a(bArr, a2, bdVar);
            if (i != bdVar.f4042a) {
                break;
            }
            a2 = a(dmVar, bArr, a3, i3, bdVar);
            zzhnVar.add(bdVar.c);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, byte[] bArr, int i2, int i3, zzjw zzjwVar, bd bdVar) throws zzhm {
        if ((i >>> 3) == 0) {
            throw zzhm.d();
        }
        int i4 = i & 7;
        if (i4 != 5) {
            switch (i4) {
                case 0:
                    int b = b(bArr, i2, bdVar);
                    zzjwVar.a(i, Long.valueOf(bdVar.b));
                    return b;
                case 1:
                    zzjwVar.a(i, Long.valueOf(b(bArr, i2)));
                    return i2 + 8;
                case 2:
                    int a2 = a(bArr, i2, bdVar);
                    int i5 = bdVar.f4042a;
                    if (i5 < 0) {
                        throw zzhm.b();
                    }
                    if (i5 > bArr.length - a2) {
                        throw zzhm.a();
                    }
                    if (i5 == 0) {
                        zzjwVar.a(i, zzfx.zzow);
                    } else {
                        zzjwVar.a(i, zzfx.zzb(bArr, a2, i5));
                    }
                    return a2 + i5;
                case 3:
                    zzjw a3 = zzjw.a();
                    int i6 = (i & (-8)) | 4;
                    int i7 = 0;
                    while (true) {
                        if (i2 < i3) {
                            int a4 = a(bArr, i2, bdVar);
                            int i8 = bdVar.f4042a;
                            if (i8 != i6) {
                                i7 = i8;
                                i2 = a(i8, bArr, a4, i3, a3, bdVar);
                            } else {
                                i7 = i8;
                                i2 = a4;
                            }
                        }
                    }
                    if (i2 > i3 || i7 != i6) {
                        throw zzhm.h();
                    }
                    zzjwVar.a(i, a3);
                    return i2;
                default:
                    throw zzhm.d();
            }
        }
        zzjwVar.a(i, Integer.valueOf(a(bArr, i2)));
        return i2 + 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, byte[] bArr, int i2, int i3, bd bdVar) throws zzhm {
        if ((i >>> 3) == 0) {
            throw zzhm.d();
        }
        int i4 = i & 7;
        if (i4 == 5) {
            return i2 + 4;
        }
        switch (i4) {
            case 0:
                return b(bArr, i2, bdVar);
            case 1:
                return i2 + 8;
            case 2:
                return a(bArr, i2, bdVar) + bdVar.f4042a;
            case 3:
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = a(bArr, i2, bdVar);
                    i6 = bdVar.f4042a;
                    if (i6 == i5) {
                        if (i2 <= i3 || i6 != i5) {
                            throw zzhm.h();
                        }
                        return i2;
                    }
                    i2 = a(i6, bArr, i2, i3, bdVar);
                }
                if (i2 <= i3) {
                }
                throw zzhm.h();
            default:
                throw zzhm.d();
        }
    }
}
