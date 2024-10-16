package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ahv {

    /* renamed from: a, reason: collision with root package name */
    private static final ahx f1886a;

    public static boolean a(byte[] bArr) {
        return f1886a.a(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean a(byte[] bArr, int i, int i2) {
        return f1886a.a(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return b(b);
            case 1:
                return b(b, bArr[i]);
            case 2:
                return b(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zzdrf(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f1886a.a(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(byte[] bArr, int i, int i2) throws zzdok {
        return f1886a.b(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        ahx ahxVar = f1886a;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            ahxVar.a(charSequence, byteBuffer);
        } else {
            ahx.b(charSequence, byteBuffer);
        }
    }

    static {
        ahx ahyVar;
        if ((ahs.a() && ahs.b()) && !aen.a()) {
            ahyVar = new ahz();
        } else {
            ahyVar = new ahy();
        }
        f1886a = ahyVar;
    }
}
