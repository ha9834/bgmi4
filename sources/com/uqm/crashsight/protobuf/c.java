package com.uqm.crashsight.protobuf;

import com.google.android.gms.games.Notifications;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.uqm.crashsight.protobuf.Internal;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6808a;
        public long b;
        public Object c;
        public final ExtensionRegistryLite d;

        a() {
            this.d = ExtensionRegistryLite.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(ExtensionRegistryLite extensionRegistryLite) {
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            this.d = extensionRegistryLite;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
            return i2;
        }
        return a(b, bArr, i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, a aVar) {
        int i3 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.f6808a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            aVar.f6808a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            aVar.f6808a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            aVar.f6808a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                aVar.f6808a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            aVar.b = j;
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
        aVar.b = j2;
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
    public static int c(byte[] bArr, int i, a aVar) throws InvalidProtocolBufferException {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (i3 == 0) {
            aVar.c = "";
            return i2;
        }
        aVar.c = new String(bArr, i2, i3, Internal.f6726a);
        return i2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, a aVar) throws InvalidProtocolBufferException {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (i3 == 0) {
            aVar.c = "";
            return i2;
        }
        aVar.c = Utf8.b(bArr, i2, i3);
        return i2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, a aVar) throws InvalidProtocolBufferException {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (i3 > bArr.length - i2) {
            throw InvalidProtocolBufferException.c();
        }
        if (i3 == 0) {
            aVar.c = ByteString.f6635a;
            return i2;
        }
        aVar.c = ByteString.a(bArr, i2, i3);
        return i2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ao aoVar, byte[] bArr, int i, int i2, a aVar) throws IOException {
        int i3;
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < 0) {
            int a2 = a(i5, bArr, i4, aVar);
            i5 = aVar.f6808a;
            i3 = a2;
        } else {
            i3 = i4;
        }
        if (i5 < 0 || i5 > i2 - i3) {
            throw InvalidProtocolBufferException.c();
        }
        Object a3 = aoVar.a();
        int i6 = i5 + i3;
        aoVar.a(a3, bArr, i3, i6, aVar);
        aoVar.d(a3);
        aVar.c = a3;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ao aoVar, byte[] bArr, int i, int i2, int i3, a aVar) throws IOException {
        ab abVar = (ab) aoVar;
        Object a2 = abVar.a();
        int a3 = abVar.a((ab) a2, bArr, i, i2, i3, aVar);
        abVar.d((ab) a2);
        aVar.c = a2;
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        q qVar = (q) protobufList;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i4 = a(b, bArr, i4, aVar);
        }
        qVar.d(aVar.f6808a);
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                aVar.f6808a = b2;
            } else {
                i5 = a(b2, bArr, i5, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            i4 = i5 + 1;
            byte b3 = bArr[i5];
            if (b3 >= 0) {
                aVar.f6808a = b3;
            } else {
                i4 = a(b3, bArr, i4, aVar);
            }
            qVar.d(aVar.f6808a);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        s sVar = (s) protobufList;
        int b = b(bArr, i2, aVar);
        sVar.a(aVar.b);
        while (b < i3) {
            int i4 = b + 1;
            byte b2 = bArr[b];
            if (b2 >= 0) {
                aVar.f6808a = b2;
            } else {
                i4 = a(b2, bArr, i4, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            b = b(bArr, i4, aVar);
            sVar.a(aVar.b);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        q qVar = (q) protobufList;
        qVar.d(a(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b = bArr[i4];
            if (b >= 0) {
                aVar.f6808a = b;
            } else {
                i5 = a(b, bArr, i5, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            qVar.d(a(bArr, i5));
            i4 = i5 + 4;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        s sVar = (s) protobufList;
        sVar.a(b(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b = bArr[i4];
            if (b >= 0) {
                aVar.f6808a = b;
            } else {
                i5 = a(b, bArr, i5, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            sVar.a(b(bArr, i5));
            i4 = i5 + 8;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        o oVar = (o) protobufList;
        oVar.a(Float.intBitsToFloat(a(bArr, i2)));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b = bArr[i4];
            if (b >= 0) {
                aVar.f6808a = b;
            } else {
                i5 = a(b, bArr, i5, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            oVar.a(Float.intBitsToFloat(a(bArr, i5)));
            i4 = i5 + 4;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        i iVar = (i) protobufList;
        iVar.a(Double.longBitsToDouble(b(bArr, i2)));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b = bArr[i4];
            if (b >= 0) {
                aVar.f6808a = b;
            } else {
                i5 = a(b, bArr, i5, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            iVar.a(Double.longBitsToDouble(b(bArr, i5)));
            i4 = i5 + 8;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        e eVar = (e) protobufList;
        int b = b(bArr, i2, aVar);
        eVar.a(aVar.b != 0);
        while (b < i3) {
            int i4 = b + 1;
            byte b2 = bArr[b];
            if (b2 >= 0) {
                aVar.f6808a = b2;
            } else {
                i4 = a(b2, bArr, i4, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            b = b(bArr, i4, aVar);
            eVar.a(aVar.b != 0);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        q qVar = (q) protobufList;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i4 = a(b, bArr, i4, aVar);
        }
        qVar.d(CodedInputStream.e(aVar.f6808a));
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                aVar.f6808a = b2;
            } else {
                i5 = a(b2, bArr, i5, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            i4 = i5 + 1;
            byte b3 = bArr[i5];
            if (b3 >= 0) {
                aVar.f6808a = b3;
            } else {
                i4 = a(b3, bArr, i4, aVar);
            }
            qVar.d(CodedInputStream.e(aVar.f6808a));
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) {
        s sVar = (s) protobufList;
        int b = b(bArr, i2, aVar);
        sVar.a(CodedInputStream.a(aVar.b));
        while (b < i3) {
            int i4 = b + 1;
            byte b2 = bArr[b];
            if (b2 >= 0) {
                aVar.f6808a = b2;
            } else {
                i4 = a(b2, bArr, i4, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            b = b(bArr, i4, aVar);
            sVar.a(CodedInputStream.a(aVar.b));
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        q qVar = (q) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                aVar.f6808a = b2;
                i2 = i4;
            } else {
                i2 = a(b2, bArr, i4, aVar);
            }
            qVar.d(aVar.f6808a);
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int b(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        s sVar = (s) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            i2 = b(bArr, i2, aVar);
            sVar.a(aVar.b);
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int c(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        q qVar = (q) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            qVar.d(a(bArr, i2));
            i2 += 4;
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int d(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        s sVar = (s) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            sVar.a(b(bArr, i2));
            i2 += 8;
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int e(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        o oVar = (o) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            oVar.a(Float.intBitsToFloat(a(bArr, i2)));
            i2 += 4;
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int f(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        i iVar = (i) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            iVar.a(Double.longBitsToDouble(b(bArr, i2)));
            i2 += 8;
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int g(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        e eVar = (e) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            i2 = b(bArr, i2, aVar);
            eVar.a(aVar.b != 0);
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int h(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        q qVar = (q) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                aVar.f6808a = b2;
                i2 = i4;
            } else {
                i2 = a(b2, bArr, i4, aVar);
            }
            qVar.d(CodedInputStream.e(aVar.f6808a));
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int i(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        s sVar = (s) protobufList;
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i2 = a(b, bArr, i2, aVar);
        }
        int i3 = aVar.f6808a + i2;
        while (i2 < i3) {
            i2 = b(bArr, i2, aVar);
            sVar.a(CodedInputStream.a(aVar.b));
        }
        if (i2 == i3) {
            return i2;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int j(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) throws InvalidProtocolBufferException {
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i4 = a(b, bArr, i4, aVar);
        }
        int i5 = aVar.f6808a;
        if (i5 < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (i5 == 0) {
            protobufList.add("");
        } else {
            protobufList.add(new String(bArr, i4, i5, Internal.f6726a));
            i4 += i5;
        }
        while (i4 < i3) {
            int a2 = a(bArr, i4, aVar);
            if (i != aVar.f6808a) {
                break;
            }
            i4 = a(bArr, a2, aVar);
            int i6 = aVar.f6808a;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            if (i6 == 0) {
                protobufList.add("");
            } else {
                protobufList.add(new String(bArr, i4, i6, Internal.f6726a));
                i4 += i6;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int k(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) throws InvalidProtocolBufferException {
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i4 = a(b, bArr, i4, aVar);
        }
        int i5 = aVar.f6808a;
        if (i5 < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (i5 == 0) {
            protobufList.add("");
        } else {
            int i6 = i4 + i5;
            if (!Utf8.a(bArr, i4, i6)) {
                throw InvalidProtocolBufferException.l();
            }
            protobufList.add(new String(bArr, i4, i5, Internal.f6726a));
            i4 = i6;
        }
        while (i4 < i3) {
            int a2 = a(bArr, i4, aVar);
            if (i != aVar.f6808a) {
                break;
            }
            i4 = a(bArr, a2, aVar);
            int i7 = aVar.f6808a;
            if (i7 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            if (i7 == 0) {
                protobufList.add("");
            } else {
                int i8 = i4 + i7;
                if (!Utf8.a(bArr, i4, i8)) {
                    throw InvalidProtocolBufferException.l();
                }
                protobufList.add(new String(bArr, i4, i7, Internal.f6726a));
                i4 = i8;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int l(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) throws InvalidProtocolBufferException {
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.f6808a = b;
        } else {
            i4 = a(b, bArr, i4, aVar);
        }
        int i5 = aVar.f6808a;
        if (i5 < 0) {
            throw InvalidProtocolBufferException.d();
        }
        if (i5 > bArr.length - i4) {
            throw InvalidProtocolBufferException.c();
        }
        if (i5 == 0) {
            protobufList.add(ByteString.f6635a);
        } else {
            protobufList.add(ByteString.a(bArr, i4, i5));
            i4 += i5;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                aVar.f6808a = b2;
            } else {
                i6 = a(b2, bArr, i6, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            i4 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                aVar.f6808a = b3;
            } else {
                i4 = a(b3, bArr, i4, aVar);
            }
            int i7 = aVar.f6808a;
            if (i7 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            if (i7 > bArr.length - i4) {
                throw InvalidProtocolBufferException.c();
            }
            if (i7 == 0) {
                protobufList.add(ByteString.f6635a);
            } else {
                protobufList.add(ByteString.a(bArr, i4, i7));
                i4 += i7;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ao<?> aoVar, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        int a2 = a(aoVar, bArr, i2, i3, aVar);
        protobufList.add(aVar.c);
        while (a2 < i3) {
            int i4 = a2 + 1;
            byte b = bArr[a2];
            if (b >= 0) {
                aVar.f6808a = b;
            } else {
                i4 = a(b, bArr, i4, aVar);
            }
            if (i != aVar.f6808a) {
                break;
            }
            a2 = a(aoVar, bArr, i4, i3, aVar);
            protobufList.add(aVar.c);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(ao aoVar, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        int i4 = (i & (-8)) | 4;
        int a2 = a(aoVar, bArr, i2, i3, i4, aVar);
        protobufList.add(aVar.c);
        while (a2 < i3) {
            int i5 = a2 + 1;
            byte b = bArr[a2];
            if (b >= 0) {
                aVar.f6808a = b;
            } else {
                i5 = a(b, bArr, i5, aVar);
            }
            int i6 = i5;
            if (i != aVar.f6808a) {
                break;
            }
            a2 = a(aoVar, bArr, i6, i3, i4, aVar);
            protobufList.add(aVar.c);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x011c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r7, byte[] r8, int r9, int r10, java.lang.Object r11, com.uqm.crashsight.protobuf.MessageLite r12, com.uqm.crashsight.protobuf.at<com.uqm.crashsight.protobuf.UnknownFieldSetLite, com.uqm.crashsight.protobuf.UnknownFieldSetLite> r13, com.uqm.crashsight.protobuf.c.a r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.c.a(int, byte[], int, int, java.lang.Object, com.uqm.crashsight.protobuf.MessageLite, com.uqm.crashsight.protobuf.at, com.uqm.crashsight.protobuf.c$a):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, byte[] bArr, int i2, int i3, UnknownFieldSetLite unknownFieldSetLite, a aVar) throws InvalidProtocolBufferException {
        int a2;
        if (WireFormat.b(i) == 0) {
            throw InvalidProtocolBufferException.f();
        }
        int a3 = WireFormat.a(i);
        if (a3 != 5) {
            switch (a3) {
                case 0:
                    int b = b(bArr, i2, aVar);
                    unknownFieldSetLite.a(i, Long.valueOf(aVar.b));
                    return b;
                case 1:
                    unknownFieldSetLite.a(i, Long.valueOf(b(bArr, i2)));
                    return i2 + 8;
                case 2:
                    int i4 = i2 + 1;
                    byte b2 = bArr[i2];
                    if (b2 >= 0) {
                        aVar.f6808a = b2;
                    } else {
                        i4 = a(b2, bArr, i4, aVar);
                    }
                    int i5 = aVar.f6808a;
                    if (i5 < 0) {
                        throw InvalidProtocolBufferException.d();
                    }
                    if (i5 > bArr.length - i4) {
                        throw InvalidProtocolBufferException.c();
                    }
                    if (i5 == 0) {
                        unknownFieldSetLite.a(i, ByteString.f6635a);
                    } else {
                        unknownFieldSetLite.a(i, ByteString.a(bArr, i4, i5));
                    }
                    return i4 + i5;
                case 3:
                    UnknownFieldSetLite b3 = UnknownFieldSetLite.b();
                    int i6 = (i & (-8)) | 4;
                    int i7 = 0;
                    while (true) {
                        if (i2 < i3) {
                            int i8 = i2 + 1;
                            byte b4 = bArr[i2];
                            if (b4 >= 0) {
                                aVar.f6808a = b4;
                                a2 = i8;
                            } else {
                                a2 = a(b4, bArr, i8, aVar);
                            }
                            int i9 = aVar.f6808a;
                            if (i9 != i6) {
                                i7 = i9;
                                i2 = a(i9, bArr, a2, i3, b3, aVar);
                            } else {
                                i7 = i9;
                                i2 = a2;
                            }
                        }
                    }
                    if (i2 > i3 || i7 != i6) {
                        throw InvalidProtocolBufferException.k();
                    }
                    unknownFieldSetLite.a(i, b3);
                    return i2;
                default:
                    throw InvalidProtocolBufferException.f();
            }
        }
        unknownFieldSetLite.a(i, Integer.valueOf(a(bArr, i2)));
        return i2 + 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, byte[] bArr, int i2, int i3, a aVar) throws InvalidProtocolBufferException {
        if (WireFormat.b(i) == 0) {
            throw InvalidProtocolBufferException.f();
        }
        int a2 = WireFormat.a(i);
        if (a2 == 5) {
            return i2 + 4;
        }
        switch (a2) {
            case 0:
                return b(bArr, i2, aVar);
            case 1:
                return i2 + 8;
            case 2:
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    aVar.f6808a = b;
                } else {
                    i4 = a(b, bArr, i4, aVar);
                }
                return i4 + aVar.f6808a;
            case 3:
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    int i7 = i2 + 1;
                    byte b2 = bArr[i2];
                    if (b2 >= 0) {
                        aVar.f6808a = b2;
                        i2 = i7;
                    } else {
                        i2 = a(b2, bArr, i7, aVar);
                    }
                    i6 = aVar.f6808a;
                    if (i6 == i5) {
                        if (i2 <= i3 || i6 != i5) {
                            throw InvalidProtocolBufferException.k();
                        }
                        return i2;
                    }
                    i2 = a(i6, bArr, i2, i3, aVar);
                }
                if (i2 <= i3) {
                }
                throw InvalidProtocolBufferException.k();
            default:
                throw InvalidProtocolBufferException.f();
        }
    }
}
