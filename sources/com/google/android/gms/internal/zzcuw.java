package com.google.android.gms.internal;

import android.os.ParcelUuid;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zzm;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Hide
/* loaded from: classes.dex */
public final class zzcuw {

    /* renamed from: a, reason: collision with root package name */
    private static final ParcelUuid f4706a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int b;
    private final List<ParcelUuid> c;
    private final SparseArray<byte[]> d;
    private final Map<ParcelUuid, byte[]> e;
    private final int f;
    private final String g;
    private final byte[] h;

    private zzcuw(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.c = list;
        this.d = sparseArray;
        this.e = map;
        this.g = str;
        this.b = i;
        this.f = i2;
        this.h = bArr;
    }

    private static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(a(a(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static ParcelUuid a(byte[] bArr) {
        long j;
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("uuidBytes length invalid - ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        }
        if (length == 2) {
            j = (bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
        } else {
            j = ((bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) + (bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) + ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        }
        return new ParcelUuid(new UUID(f4706a.getUuid().getMostSignificantBits() + (j << 32), f4706a.getUuid().getLeastSignificantBits()));
    }

    private static <T> String a(Map<T, byte[]> map) {
        StringBuilder sb = new StringBuilder();
        if (map.keySet().size() <= 0) {
            return "{}";
        }
        sb.append('{');
        int i = 0;
        for (Map.Entry<T, byte[]> entry : map.entrySet()) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            byte[] value = entry.getValue();
            sb.append(value == null ? null : zzm.zzm(value));
            i++;
        }
        sb.append('}');
        return sb.toString();
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    @com.google.android.gms.common.internal.Hide
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.zzcuw zzu(byte[] r13) {
        /*
            r0 = 0
            if (r13 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = -1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r11 = r0
            r9 = -1
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
        L1b:
            int r2 = r13.length     // Catch: java.lang.Exception -> L99
            if (r1 >= r2) goto L88
            int r2 = r1 + 1
            r1 = r13[r1]     // Catch: java.lang.Exception -> L99
            r4 = 255(0xff, float:3.57E-43)
            r1 = r1 & r4
            if (r1 == 0) goto L88
            int r1 = r1 + (-1)
            int r5 = r2 + 1
            r2 = r13[r2]     // Catch: java.lang.Exception -> L99
            r2 = r2 & r4
            r6 = 22
            r12 = 2
            if (r2 == r6) goto L73
            if (r2 == r4) goto L5c
            switch(r2) {
                case 1: goto L57;
                case 2: goto L53;
                case 3: goto L53;
                case 4: goto L4e;
                case 5: goto L4e;
                case 6: goto L48;
                case 7: goto L48;
                case 8: goto L3d;
                case 9: goto L3d;
                case 10: goto L39;
                default: goto L38;
            }     // Catch: java.lang.Exception -> L99
        L38:
            goto L86
        L39:
            r2 = r13[r5]     // Catch: java.lang.Exception -> L99
            r10 = r2
            goto L86
        L3d:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L99
            byte[] r4 = a(r13, r5, r1)     // Catch: java.lang.Exception -> L99
            r2.<init>(r4)     // Catch: java.lang.Exception -> L99
            r11 = r2
            goto L86
        L48:
            r2 = 16
            a(r13, r5, r1, r2, r3)     // Catch: java.lang.Exception -> L99
            goto L86
        L4e:
            r2 = 4
            a(r13, r5, r1, r2, r3)     // Catch: java.lang.Exception -> L99
            goto L86
        L53:
            a(r13, r5, r1, r12, r3)     // Catch: java.lang.Exception -> L99
            goto L86
        L57:
            r2 = r13[r5]     // Catch: java.lang.Exception -> L99
            r2 = r2 & r4
            r9 = r2
            goto L86
        L5c:
            int r2 = r5 + 1
            r2 = r13[r2]     // Catch: java.lang.Exception -> L99
            r2 = r2 & r4
            int r2 = r2 << 8
            r6 = r13[r5]     // Catch: java.lang.Exception -> L99
            r4 = r4 & r6
            int r2 = r2 + r4
            int r4 = r5 + 2
            int r6 = r1 + (-2)
            byte[] r4 = a(r13, r4, r6)     // Catch: java.lang.Exception -> L99
            r7.put(r2, r4)     // Catch: java.lang.Exception -> L99
            goto L86
        L73:
            byte[] r2 = a(r13, r5, r12)     // Catch: java.lang.Exception -> L99
            android.os.ParcelUuid r2 = a(r2)     // Catch: java.lang.Exception -> L99
            int r4 = r5 + 2
            int r6 = r1 + (-2)
            byte[] r4 = a(r13, r4, r6)     // Catch: java.lang.Exception -> L99
            r8.put(r2, r4)     // Catch: java.lang.Exception -> L99
        L86:
            int r1 = r1 + r5
            goto L1b
        L88:
            boolean r1 = r3.isEmpty()     // Catch: java.lang.Exception -> L99
            if (r1 == 0) goto L90
            r6 = r0
            goto L91
        L90:
            r6 = r3
        L91:
            com.google.android.gms.internal.zzcuw r1 = new com.google.android.gms.internal.zzcuw     // Catch: java.lang.Exception -> L99
            r5 = r1
            r12 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L99
            return r1
        L99:
            r1 = move-exception
            java.lang.String r2 = "BleRecord"
            java.lang.String r3 = "Unable to parse scan record: "
            java.lang.String r13 = java.util.Arrays.toString(r13)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r4 = r13.length()
            if (r4 == 0) goto Lb1
            java.lang.String r13 = r3.concat(r13)
            goto Lb6
        Lb1:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r3)
        Lb6:
            android.util.Log.w(r2, r13, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcuw.zzu(byte[]):com.google.android.gms.internal.zzcuw");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcuw) {
            return Arrays.equals(this.h, ((zzcuw) obj).h);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.h);
    }

    public final String toString() {
        String sb;
        int i = this.b;
        String valueOf = String.valueOf(this.c);
        SparseArray<byte[]> sparseArray = this.d;
        StringBuilder sb2 = new StringBuilder();
        if (sparseArray.size() <= 0) {
            sb = "{}";
        } else {
            sb2.append('{');
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (i2 > 0) {
                    sb2.append(", ");
                }
                int keyAt = sparseArray.keyAt(i2);
                byte[] valueAt = sparseArray.valueAt(i2);
                sb2.append(keyAt);
                sb2.append('=');
                sb2.append(valueAt == null ? null : zzm.zzm(valueAt));
            }
            sb2.append('}');
            sb = sb2.toString();
        }
        String a2 = a(this.e);
        int i3 = this.f;
        String str = this.g;
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + TwitterApiConstants.Errors.ALREADY_FAVORITED + String.valueOf(sb).length() + String.valueOf(a2).length() + String.valueOf(str).length());
        sb3.append("BleRecord [mAdvertiseFlags=");
        sb3.append(i);
        sb3.append(", mServiceUuids=");
        sb3.append(valueOf);
        sb3.append(", mManufacturerSpecificData=");
        sb3.append(sb);
        sb3.append(", mServiceData=");
        sb3.append(a2);
        sb3.append(", mTxPowerLevel=");
        sb3.append(i3);
        sb3.append(", mDeviceName=");
        sb3.append(str);
        sb3.append("]");
        return sb3.toString();
    }
}
