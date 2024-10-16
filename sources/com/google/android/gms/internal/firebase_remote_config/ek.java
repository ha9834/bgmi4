package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class ek extends el {
    @Override // com.google.android.gms.internal.firebase_remote_config.el
    final int a(int i, byte[] bArr, int i2, int i3) {
        int d;
        int d2;
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b < -16) {
                    if (i4 < i3 - 1) {
                        int i5 = i4 + 1;
                        byte b2 = bArr[i4];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i2 = i5 + 1;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    }
                    d = ej.d(bArr, i4, i3);
                    return d;
                }
                if (i4 < i3 - 2) {
                    int i6 = i4 + 1;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            int i8 = i7 + 1;
                            if (bArr[i7] <= -65) {
                                i2 = i8;
                            }
                        }
                    }
                    return -1;
                }
                d2 = ej.d(bArr, i4, i3);
                return d2;
            }
            i2 = i4;
        }
        return 0;
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
            byte b = bArr[i];
            d3 = ei.d(b);
            if (!d3) {
                break;
            }
            i++;
            ei.b(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            d = ei.d(b2);
            if (d) {
                int i7 = i5 + 1;
                ei.b(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    d2 = ei.d(b3);
                    if (!d2) {
                        break;
                    }
                    i6++;
                    ei.b(b3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                e = ei.e(b2);
                if (!e) {
                    f = ei.f(b2);
                    if (f) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            ei.b(b2, bArr[i6], bArr[i8], cArr, i5);
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
                        byte b4 = bArr[i6];
                        int i10 = i9 + 1;
                        ei.b(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else if (i6 < i3) {
                    ei.b(b2, bArr[i6], cArr, i5);
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
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.firebase_remote_config.el
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.ek.a(java.lang.CharSequence, byte[], int, int):int");
    }
}
