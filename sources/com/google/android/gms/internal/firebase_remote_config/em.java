package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class em extends el {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0061, code lost:
    
        return -1;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.el
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.em.a(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.el
    public final String a(byte[] bArr, int i, int i2) throws zzhm {
        boolean d;
        boolean d2;
        boolean e;
        boolean f;
        boolean d3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte a2 = eh.a(bArr, i);
            d3 = ei.d(a2);
            if (!d3) {
                break;
            }
            i++;
            ei.b(a2, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte a3 = eh.a(bArr, i);
            d = ei.d(a3);
            if (d) {
                int i7 = i5 + 1;
                ei.b(a3, cArr, i5);
                while (i6 < i3) {
                    byte a4 = eh.a(bArr, i6);
                    d2 = ei.d(a4);
                    if (!d2) {
                        break;
                    }
                    i6++;
                    ei.b(a4, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                e = ei.e(a3);
                if (!e) {
                    f = ei.f(a3);
                    if (f) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            ei.b(a3, eh.a(bArr, i6), eh.a(bArr, i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw zzhm.i();
                        }
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzhm.i();
                        }
                        int i9 = i6 + 1;
                        byte a5 = eh.a(bArr, i6);
                        int i10 = i9 + 1;
                        ei.b(a3, a5, eh.a(bArr, i9), eh.a(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else if (i6 < i3) {
                    ei.b(a3, eh.a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzhm.i();
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.el
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        char charAt;
        long j = i;
        long j2 = i2 + j;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
            eh.a(bArr, j, (byte) charAt);
            i4++;
            j = 1 + j;
        }
        if (i4 == length) {
            return (int) j;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 < 128 && j < j2) {
                eh.a(bArr, j, (byte) charAt3);
                j++;
            } else if (charAt3 < 2048 && j <= j2 - 2) {
                long j3 = j + 1;
                eh.a(bArr, j, (byte) ((charAt3 >>> 6) | 960));
                j = j3 + 1;
                eh.a(bArr, j3, (byte) ((charAt3 & '?') | 128));
            } else {
                if ((charAt3 >= 55296 && 57343 >= charAt3) || j > j2 - 3) {
                    if (j <= j2 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j4 = j + 1;
                                eh.a(bArr, j, (byte) ((codePoint >>> 18) | 240));
                                long j5 = j4 + 1;
                                eh.a(bArr, j4, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j5 + 1;
                                eh.a(bArr, j5, (byte) (((codePoint >>> 6) & 63) | 128));
                                j = j6 + 1;
                                eh.a(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            }
                        } else {
                            i5 = i4;
                        }
                        throw new zzkj(i5 - 1, length);
                    }
                    if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        throw new zzkj(i4, length);
                    }
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(charAt3);
                    sb2.append(" at index ");
                    sb2.append(j);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
                long j7 = j + 1;
                eh.a(bArr, j, (byte) ((charAt3 >>> '\f') | 480));
                long j8 = j7 + 1;
                eh.a(bArr, j7, (byte) (((charAt3 >>> 6) & 63) | 128));
                eh.a(bArr, j8, (byte) ((charAt3 & '?') | 128));
                j = j8 + 1;
            }
            i4++;
        }
        return (int) j;
    }

    private static int a(byte[] bArr, int i, long j, int i2) {
        int b;
        int b2;
        int b3;
        switch (i2) {
            case 0:
                b = ej.b(i);
                return b;
            case 1:
                b2 = ej.b(i, eh.a(bArr, j));
                return b2;
            case 2:
                b3 = ej.b(i, eh.a(bArr, j), eh.a(bArr, j + 1));
                return b3;
            default:
                throw new AssertionError();
        }
    }
}
