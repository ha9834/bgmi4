package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f5428a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, JceStruct.SIMPLE_LIST, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, JceStruct.SIMPLE_LIST, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] c = new byte[128];
    private static final byte[] d = new byte[128];
    private static final Charset e = StandardCharsets.ISO_8859_1;

    private static boolean a(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean b(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean c(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean f(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }

    static {
        Arrays.fill(c, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = f5428a;
            if (i2 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr2 = b;
            if (i >= bArr2.length) {
                return;
            }
            byte b3 = bArr2[i];
            if (b3 > 0) {
                d[b3] = (byte) i;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI a2;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = e;
        } else if (!e.equals(charset) && (a2 = CharacterSetECI.a(charset.name())) != null) {
            a(a2.a(), sb);
        }
        int length = str.length();
        switch (compaction) {
            case TEXT:
                a(str, 0, length, sb, 0);
                break;
            case BYTE:
                byte[] bytes = str.getBytes(charset);
                a(bytes, 0, bytes.length, 1, sb);
                break;
            case NUMERIC:
                sb.append((char) 902);
                a(str, 0, length, sb);
                break;
            default:
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < length) {
                    int a3 = a(str, i);
                    if (a3 >= 13) {
                        sb.append((char) 902);
                        i3 = 2;
                        a(str, i, a3, sb);
                        i += a3;
                        i2 = 0;
                    } else {
                        int b2 = b(str, i);
                        if (b2 >= 5 || a3 == length) {
                            if (i3 != 0) {
                                sb.append((char) 900);
                                i2 = 0;
                                i3 = 0;
                            }
                            i2 = a(str, i, b2, sb, i2);
                            i += b2;
                        } else {
                            int a4 = a(str, i, charset);
                            if (a4 == 0) {
                                a4 = 1;
                            }
                            int i4 = a4 + i;
                            byte[] bytes2 = str.substring(i, i4).getBytes(charset);
                            if (bytes2.length == 1 && i3 == 0) {
                                a(bytes2, 0, 1, 0, sb);
                            } else {
                                a(bytes2, 0, bytes2.length, i3, sb);
                                i2 = 0;
                                i3 = 1;
                            }
                            i = i4;
                        }
                    }
                }
                break;
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ed, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ef, code lost:
    
        if (r7 < r18) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f1, code lost:
    
        r0 = r3.length();
        r1 = 0;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f7, code lost:
    
        if (r1 >= r0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fb, code lost:
    
        if ((r1 % 2) == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fd, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0100, code lost:
    
        if (r9 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0102, code lost:
    
        r7 = (char) ((r7 * 30) + r3.charAt(r1));
        r19.append(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0112, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010e, code lost:
    
        r7 = r3.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ff, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
    
        if ((r0 % 2) == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0118, code lost:
    
        r19.append((char) ((r7 * 30) + 29));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011f, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.f.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + (bArr[i4 + i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (j % 900);
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
            i4++;
        }
    }

    private static void a(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    private static boolean d(char c2) {
        return c[c2] != -1;
    }

    private static boolean e(char c2) {
        return d[c2] != -1;
    }

    private static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (a(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int b(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 >= r0) goto L37
            char r2 = r6.charAt(r1)
            r3 = 0
        Lc:
            r4 = 13
            if (r3 >= r4) goto L23
            boolean r5 = a(r2)
            if (r5 == 0) goto L23
            if (r1 >= r0) goto L23
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Lc
            char r2 = r6.charAt(r1)
            goto Lc
        L23:
            if (r3 < r4) goto L28
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L28:
            if (r3 > 0) goto L5
            char r2 = r6.charAt(r1)
            boolean r2 = f(r2)
            if (r2 == 0) goto L37
            int r1 = r1 + 1
            goto L5
        L37:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.f.b(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0028, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.google.zxing.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 >= r0) goto L57
            char r2 = r5.charAt(r1)
            r3 = 0
        L10:
            r4 = 13
            if (r3 >= r4) goto L25
            boolean r2 = a(r2)
            if (r2 == 0) goto L25
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 >= r0) goto L25
            char r2 = r5.charAt(r2)
            goto L10
        L25:
            if (r3 < r4) goto L29
            int r1 = r1 - r6
            return r1
        L29:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L36
            int r1 = r1 + 1
            goto L9
        L36:
            com.google.zxing.WriterException r5 = new com.google.zxing.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L57:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.f.a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    private static void a(int i, StringBuilder sb) throws WriterException {
        if (i >= 0 && i < 900) {
            sb.append((char) 927);
            sb.append((char) i);
        } else if (i < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i / 900) - 1));
            sb.append((char) (i % 900));
        } else {
            if (i < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i));
                return;
            }
            throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
        }
    }
}
