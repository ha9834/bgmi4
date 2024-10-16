package com.google.zxing.datamatrix.encoder;

import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(char c) {
        return c >= '0' && c <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean d(char c) {
        if (c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    private static boolean e(char c) {
        if (c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    private static boolean g(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    private static boolean h(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean i(char c) {
        return false;
    }

    private static char a(char c, int i) {
        int i2 = c + ((i * TbsListener.ErrorCode.NEEDDOWNLOAD_10) % 253) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    public static String a(String str, SymbolShapeHint symbolShapeHint, com.google.zxing.a aVar, com.google.zxing.a aVar2) {
        int i = 0;
        g[] gVarArr = {new a(), new c(), new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.a(symbolShapeHint);
        hVar.a(aVar, aVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.a((char) 236);
            hVar.a(2);
            hVar.f5409a += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.a((char) 237);
            hVar.a(2);
            hVar.f5409a += 7;
        }
        while (hVar.g()) {
            gVarArr[i].a(hVar);
            if (hVar.e() >= 0) {
                i = hVar.e();
                hVar.f();
            }
        }
        int d = hVar.d();
        hVar.j();
        int f = hVar.i().f();
        if (d < f && i != 0 && i != 5 && i != 4) {
            hVar.a((char) 254);
        }
        StringBuilder c = hVar.c();
        if (c.length() < f) {
            c.append((char) 129);
        }
        while (c.length() < f) {
            c.append(a((char) 129, c.length() + 1));
        }
        return hVar.c().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        char c;
        if (i >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int a2 = a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int a3 = a(bArr);
                if (iArr[0] == a2) {
                    return 0;
                }
                if (a3 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (a3 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (a3 != 1 || bArr[2] <= 0) {
                    return (a3 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence.charAt(i4);
            i3++;
            if (a(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (b(charAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (d(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (e(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (f(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (h(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (b(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (i(charAt)) {
                c = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i3 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int a4 = a(bArr2);
                if (iArr2[0] < iArr2[c] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (a4 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (a4 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (a4 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i5 = i + i3 + 1; i5 < charSequence.length(); i5++) {
                            char charAt2 = charSequence.charAt(i5);
                            if (g(charAt2)) {
                                return 3;
                            }
                            if (!f(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil(fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    private static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    private static boolean f(char c) {
        if (g(c) || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static int a(CharSequence charSequence, int i) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
