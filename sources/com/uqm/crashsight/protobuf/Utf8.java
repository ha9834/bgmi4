package com.uqm.crashsight.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Utf8 {

    /* renamed from: a, reason: collision with root package name */
    private static final b f6778a;

    static /* synthetic */ int a(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    static /* synthetic */ int a(int i, int i2) {
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

    static /* synthetic */ int c(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                if (b2 > -12) {
                    return -1;
                }
                return b2;
            case 1:
                byte b3 = bArr[i];
                if (b2 > -12 || b3 > -65) {
                    return -1;
                }
                return (b3 << 8) ^ b2;
            case 2:
                return b(b2, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    static {
        f6778a = (!d.a() || com.uqm.crashsight.protobuf.b.a()) ? new c() : new d();
    }

    public static boolean a(byte[] bArr) {
        return f6778a.a(bArr, 0, bArr.length);
    }

    public static boolean a(byte[] bArr, int i, int i2) {
        return f6778a.a(bArr, i, i2);
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        return f6778a.a(i, bArr, i2, i3);
    }

    /* loaded from: classes3.dex */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
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
                                throw new UnpairedSurrogateException(i2, length2);
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i3 + 4294967296L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f6778a.a(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        return f6778a.a(byteBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return f6778a.b(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class b {
        abstract int a(int i, byte[] bArr, int i2, int i3);

        abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        abstract String b(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

        abstract String b(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        b() {
        }

        final boolean a(byte[] bArr, int i, int i2) {
            return a(0, bArr, i, i2) == 0;
        }

        final String a(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            }
            if (byteBuffer.isDirect()) {
                return b(byteBuffer, i, i2);
            }
            return c(byteBuffer, i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String c(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = byteBuffer.get(i);
                if (!a.a(b)) {
                    break;
                }
                i++;
                a.a(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = byteBuffer.get(i);
                if (a.a(b2)) {
                    int i7 = i5 + 1;
                    a.a(b2, cArr, i5);
                    while (i6 < i3) {
                        byte b3 = byteBuffer.get(i6);
                        if (!a.a(b3)) {
                            break;
                        }
                        i6++;
                        a.a(b3, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else if (a.b(b2)) {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.l();
                    }
                    a.a(b2, byteBuffer.get(i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else if (a.c(b2)) {
                    if (i6 >= i3 - 1) {
                        throw InvalidProtocolBufferException.l();
                    }
                    int i8 = i6 + 1;
                    a.a(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                    i = i8 + 1;
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw InvalidProtocolBufferException.l();
                    }
                    int i9 = i6 + 1;
                    byte b4 = byteBuffer.get(i6);
                    int i10 = i9 + 1;
                    a.a(b2, b4, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                    i = i10 + 1;
                    i5 = i5 + 1 + 1;
                }
            }
            return new String(cArr, 0, i5);
        }
    }

    /* loaded from: classes3.dex */
    static final class c extends b {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        
            if (r13[r14] > (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x007e, code lost:
        
            if (r13[r14] > (-65)) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0043, code lost:
        
            if (r13[r14] > (-65)) goto L27;
         */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int a(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.Utf8.c.a(int, byte[], int, int):int");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        final String b(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!a.a(b)) {
                    break;
                }
                i++;
                a.a(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (a.a(b2)) {
                    int i7 = i5 + 1;
                    a.a(b2, cArr, i5);
                    while (i6 < i3) {
                        byte b3 = bArr[i6];
                        if (!a.a(b3)) {
                            break;
                        }
                        i6++;
                        a.a(b3, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else if (a.b(b2)) {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.l();
                    }
                    a.a(b2, bArr[i6], cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else if (a.c(b2)) {
                    if (i6 >= i3 - 1) {
                        throw InvalidProtocolBufferException.l();
                    }
                    int i8 = i6 + 1;
                    a.a(b2, bArr[i6], bArr[i8], cArr, i5);
                    i = i8 + 1;
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw InvalidProtocolBufferException.l();
                    }
                    int i9 = i6 + 1;
                    byte b4 = bArr[i6];
                    int i10 = i9 + 1;
                    a.a(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                    i = i10 + 1;
                    i5 = i5 + 1 + 1;
                }
            }
            return new String(cArr, 0, i5);
        }

        @Override // com.uqm.crashsight.protobuf.Utf8.b
        final String b(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            return c(byteBuffer, i, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.Utf8.c.a(java.lang.CharSequence, byte[], int, int):int");
        }
    }

    /* loaded from: classes3.dex */
    static final class d extends b {
        d() {
        }

        static boolean a() {
            return aw.a() && aw.b();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            if (com.uqm.crashsight.protobuf.aw.a(r13, r2) > (-65)) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
        
            if (com.uqm.crashsight.protobuf.aw.a(r13, r2) > (-65)) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
        
            if (com.uqm.crashsight.protobuf.aw.a(r13, r2) > (-65)) goto L55;
         */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int a(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 199
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.Utf8.d.a(int, byte[], int, int):int");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        final String b(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte a2 = aw.a(bArr, i);
                if (!a.a(a2)) {
                    break;
                }
                i++;
                a.a(a2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte a3 = aw.a(bArr, i);
                if (a.a(a3)) {
                    int i7 = i5 + 1;
                    a.a(a3, cArr, i5);
                    while (i6 < i3) {
                        byte a4 = aw.a(bArr, i6);
                        if (!a.a(a4)) {
                            break;
                        }
                        i6++;
                        a.a(a4, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else if (a.b(a3)) {
                    if (i6 >= i3) {
                        throw InvalidProtocolBufferException.l();
                    }
                    a.a(a3, aw.a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else if (a.c(a3)) {
                    if (i6 >= i3 - 1) {
                        throw InvalidProtocolBufferException.l();
                    }
                    int i8 = i6 + 1;
                    a.a(a3, aw.a(bArr, i6), aw.a(bArr, i8), cArr, i5);
                    i = i8 + 1;
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw InvalidProtocolBufferException.l();
                    }
                    int i9 = i6 + 1;
                    byte a5 = aw.a(bArr, i6);
                    int i10 = i9 + 1;
                    a.a(a3, a5, aw.a(bArr, i9), aw.a(bArr, i10), cArr, i5);
                    i = i10 + 1;
                    i5 = i5 + 1 + 1;
                }
            }
            return new String(cArr, 0, i5);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        final String b(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            long a2 = aw.a(byteBuffer) + i;
            long j = i2 + a2;
            char[] cArr = new char[i2];
            int i3 = 0;
            while (a2 < j) {
                byte a3 = aw.a(a2);
                if (!a.a(a3)) {
                    break;
                }
                a2++;
                a.a(a3, cArr, i3);
                i3++;
            }
            int i4 = i3;
            while (a2 < j) {
                long j2 = a2 + 1;
                byte a4 = aw.a(a2);
                if (a.a(a4)) {
                    int i5 = i4 + 1;
                    a.a(a4, cArr, i4);
                    while (j2 < j) {
                        byte a5 = aw.a(j2);
                        if (!a.a(a5)) {
                            break;
                        }
                        j2++;
                        a.a(a5, cArr, i5);
                        i5++;
                    }
                    i4 = i5;
                    a2 = j2;
                } else if (a.b(a4)) {
                    if (j2 >= j) {
                        throw InvalidProtocolBufferException.l();
                    }
                    a2 = j2 + 1;
                    a.a(a4, aw.a(j2), cArr, i4);
                    i4++;
                } else if (a.c(a4)) {
                    if (j2 >= j - 1) {
                        throw InvalidProtocolBufferException.l();
                    }
                    long j3 = j2 + 1;
                    a.a(a4, aw.a(j2), aw.a(j3), cArr, i4);
                    i4++;
                    a2 = j3 + 1;
                } else {
                    if (j2 >= j - 2) {
                        throw InvalidProtocolBufferException.l();
                    }
                    long j4 = j2 + 1;
                    byte a6 = aw.a(j2);
                    long j5 = j4 + 1;
                    byte a7 = aw.a(j4);
                    a2 = j5 + 1;
                    a.a(a4, a6, a7, aw.a(j5), cArr, i4);
                    i4 = i4 + 1 + 1;
                }
            }
            return new String(cArr, 0, i4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.Utf8.b
        final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            char charAt;
            long j = i;
            long j2 = i2 + j;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                aw.a(bArr, j, (byte) charAt);
                i4++;
                j = 1 + j;
            }
            if (i4 == length) {
                return (int) j;
            }
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 < 128 && j < j2) {
                    aw.a(bArr, j, (byte) charAt2);
                    j++;
                } else if (charAt2 < 2048 && j <= j2 - 2) {
                    long j3 = j + 1;
                    aw.a(bArr, j, (byte) ((charAt2 >>> 6) | 960));
                    j = j3 + 1;
                    aw.a(bArr, j3, (byte) ((charAt2 & '?') | 128));
                } else {
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || j > j2 - 3) {
                        if (j <= j2 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j4 = j + 1;
                                    aw.a(bArr, j, (byte) ((codePoint >>> 18) | 240));
                                    long j5 = j4 + 1;
                                    aw.a(bArr, j4, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j6 = j5 + 1;
                                    aw.a(bArr, j5, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j = j6 + 1;
                                    aw.a(bArr, j6, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                }
                            } else {
                                i5 = i4;
                            }
                            throw new UnpairedSurrogateException(i5 - 1, length);
                        }
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new UnpairedSurrogateException(i4, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j);
                    }
                    long j7 = j + 1;
                    aw.a(bArr, j, (byte) ((charAt2 >>> '\f') | 480));
                    long j8 = j7 + 1;
                    aw.a(bArr, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                    aw.a(bArr, j8, (byte) ((charAt2 & '?') | 128));
                    j = j8 + 1;
                }
                i4++;
            }
            return (int) j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x004f, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int a(byte[] r11, long r12, int r14) {
            /*
                r0 = 0
                r1 = 1
                r3 = 16
                if (r14 >= r3) goto L9
                r3 = 0
                goto L1b
            L9:
                r4 = r12
                r3 = 0
            Lb:
                if (r3 >= r14) goto L1a
                long r6 = r4 + r1
                byte r4 = com.uqm.crashsight.protobuf.aw.a(r11, r4)
                if (r4 >= 0) goto L16
                goto L1b
            L16:
                int r3 = r3 + 1
                r4 = r6
                goto Lb
            L1a:
                r3 = r14
            L1b:
                int r14 = r14 - r3
                long r3 = (long) r3
                long r12 = r12 + r3
            L1e:
                r3 = 0
            L1f:
                if (r14 <= 0) goto L2f
                long r3 = r12 + r1
                byte r12 = com.uqm.crashsight.protobuf.aw.a(r11, r12)
                if (r12 < 0) goto L32
                int r14 = r14 + (-1)
                r9 = r3
                r3 = r12
                r12 = r9
                goto L1f
            L2f:
                r9 = r12
                r12 = r3
                r3 = r9
            L32:
                if (r14 != 0) goto L35
                return r0
            L35:
                int r14 = r14 + (-1)
                r13 = -32
                r5 = -65
                r6 = -1
                if (r12 >= r13) goto L50
                if (r14 != 0) goto L41
                return r12
            L41:
                int r14 = r14 + (-1)
                r13 = -62
                if (r12 < r13) goto L4f
                long r12 = r3 + r1
                byte r3 = com.uqm.crashsight.protobuf.aw.a(r11, r3)
                if (r3 <= r5) goto L1e
            L4f:
                return r6
            L50:
                r7 = -16
                if (r12 >= r7) goto L7b
                r7 = 2
                if (r14 >= r7) goto L5c
                int r11 = a(r11, r12, r3, r14)
                return r11
            L5c:
                int r14 = r14 + (-2)
                long r7 = r3 + r1
                byte r3 = com.uqm.crashsight.protobuf.aw.a(r11, r3)
                if (r3 > r5) goto L7a
                r4 = -96
                if (r12 != r13) goto L6c
                if (r3 < r4) goto L7a
            L6c:
                r13 = -19
                if (r12 != r13) goto L72
                if (r3 >= r4) goto L7a
            L72:
                long r12 = r7 + r1
                byte r3 = com.uqm.crashsight.protobuf.aw.a(r11, r7)
                if (r3 <= r5) goto L1e
            L7a:
                return r6
            L7b:
                r13 = 3
                if (r14 >= r13) goto L83
                int r11 = a(r11, r12, r3, r14)
                return r11
            L83:
                int r14 = r14 + (-3)
                long r7 = r3 + r1
                byte r13 = com.uqm.crashsight.protobuf.aw.a(r11, r3)
                if (r13 > r5) goto Laa
                int r12 = r12 << 28
                int r13 = r13 + 112
                int r12 = r12 + r13
                int r12 = r12 >> 30
                if (r12 != 0) goto Laa
                long r12 = r7 + r1
                byte r3 = com.uqm.crashsight.protobuf.aw.a(r11, r7)
                if (r3 > r5) goto Laa
                long r3 = r12 + r1
                byte r12 = com.uqm.crashsight.protobuf.aw.a(r11, r12)
                if (r12 <= r5) goto La7
                goto Laa
            La7:
                r12 = r3
                goto L1e
            Laa:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.Utf8.d.a(byte[], long, int):int");
        }

        private static int a(byte[] bArr, int i, long j, int i2) {
            switch (i2) {
                case 0:
                    return Utf8.a(i);
                case 1:
                    return Utf8.a(i, aw.a(bArr, j));
                case 2:
                    return Utf8.b(i, aw.a(bArr, j), aw.a(bArr, j + 1));
                default:
                    throw new AssertionError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        static /* synthetic */ boolean a(byte b) {
            return b >= 0;
        }

        static /* synthetic */ boolean b(byte b) {
            return b < -32;
        }

        static /* synthetic */ boolean c(byte b) {
            return b < -16;
        }

        static /* synthetic */ void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!(b2 > -65) && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                if (!(b3 > -65)) {
                    if (!(b4 > -65)) {
                        int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                        cArr[i] = (char) ((i2 >>> 10) + 55232);
                        cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                        return;
                    }
                }
            }
            throw InvalidProtocolBufferException.l();
        }

        static /* synthetic */ void a(byte b, byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!(b2 > -65) && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                if (!(b3 > -65)) {
                    cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                    return;
                }
            }
            throw InvalidProtocolBufferException.l();
        }

        static /* synthetic */ void a(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b >= -62) {
                if (!(b2 > -65)) {
                    cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
                    return;
                }
            }
            throw InvalidProtocolBufferException.l();
        }

        static /* synthetic */ void a(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }
    }
}
