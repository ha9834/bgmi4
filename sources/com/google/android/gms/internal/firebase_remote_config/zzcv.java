package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public abstract class zzcv extends zzcr {
    protected abstract int a(CharSequence charSequence, int i, int i2);

    protected abstract char[] a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(String str, int i) {
        int i2;
        int length = str.length();
        char[] a2 = s.a();
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            if (i < length) {
                int i5 = i + 1;
                char charAt = str.charAt(i);
                int i6 = charAt;
                if (charAt >= 55296) {
                    i6 = charAt;
                    if (charAt <= 57343) {
                        if (charAt > 56319) {
                            StringBuilder sb = new StringBuilder(82);
                            sb.append("Unexpected low surrogate character '");
                            sb.append(charAt);
                            sb.append("' with value ");
                            sb.append((int) charAt);
                            sb.append(" at index ");
                            sb.append(i5 - 1);
                            throw new IllegalArgumentException(sb.toString());
                        }
                        if (i5 == length) {
                            i6 = -charAt;
                        } else {
                            char charAt2 = str.charAt(i5);
                            if (Character.isLowSurrogate(charAt2)) {
                                i6 = Character.toCodePoint(charAt, charAt2);
                            } else {
                                StringBuilder sb2 = new StringBuilder(83);
                                sb2.append("Expected low surrogate but got char '");
                                sb2.append(charAt2);
                                sb2.append("' with value ");
                                sb2.append((int) charAt2);
                                sb2.append(" at index ");
                                sb2.append(i5);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                        }
                    }
                }
                if (i6 < 0) {
                    throw new IllegalArgumentException("Trailing high surrogate at end of input");
                }
                char[] a3 = a(i6);
                int i7 = (Character.isSupplementaryCodePoint(i6) ? 2 : 1) + i;
                if (a3 != null) {
                    int i8 = i - i3;
                    int i9 = i4 + i8;
                    int length2 = a3.length + i9;
                    if (a2.length < length2) {
                        a2 = a(a2, i4, ((length2 + length) - i) + 32);
                    }
                    if (i8 > 0) {
                        str.getChars(i3, i, a2, i4);
                        i4 = i9;
                    }
                    if (a3.length > 0) {
                        System.arraycopy(a3, 0, a2, i4, a3.length);
                        i4 += a3.length;
                    }
                    i3 = i7;
                }
                i = a(str, i7, length);
            } else {
                throw new IndexOutOfBoundsException("Index exceeds specified range");
            }
        }
        int i10 = length - i3;
        if (i10 > 0) {
            i2 = i10 + i4;
            if (a2.length < i2) {
                a2 = a(a2, i4, i2);
            }
            str.getChars(i3, length, a2, i4);
        } else {
            i2 = i4;
        }
        return new String(a2, 0, i2);
    }

    private static char[] a(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
