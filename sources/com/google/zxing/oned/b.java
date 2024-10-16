package com.google.zxing.oned;

/* loaded from: classes2.dex */
public final class b extends m {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5414a = {'A', 'B', 'C', 'D'};
    private static final char[] b = {'T', 'N', '*', 'E'};
    private static final char[] c = {'/', ':', '+', '.'};
    private static final char d = f5414a[0];

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int i;
        if (str.length() < 2) {
            str = d + str + d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a2 = a.a(f5414a, upperCase);
            boolean a3 = a.a(f5414a, upperCase2);
            boolean a4 = a.a(b, upperCase);
            boolean a5 = a.a(b, upperCase2);
            if (a2) {
                if (!a3) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (!a4) {
                if (a3 || a5) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
                str = d + str + d;
            } else if (!a5) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else {
                if (!a.a(c, str.charAt(i3))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
                }
                i2 += 10;
            }
        }
        boolean[] zArr = new boolean[i2 + (str.length() - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                if (i6 >= a.f5413a.length) {
                    i = 0;
                    break;
                }
                if (upperCase3 == a.f5413a[i6]) {
                    i = a.b[i6];
                    break;
                }
                i6++;
            }
            int i7 = i4;
            int i8 = 0;
            boolean z = true;
            int i9 = 0;
            while (i8 < 7) {
                zArr[i7] = z;
                i7++;
                if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                    z = !z;
                    i8++;
                    i9 = 0;
                } else {
                    i9++;
                }
            }
            if (i5 < str.length() - 1) {
                zArr[i7] = false;
                i7++;
            }
            i4 = i7;
        }
        return zArr;
    }
}
