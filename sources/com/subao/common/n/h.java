package com.subao.common.n;

import com.amazonaws.services.s3.internal.Constants;
import java.io.Reader;
import java.util.List;

/* loaded from: classes2.dex */
public class h {
    private static char a(int i, int i2) {
        return i < 10 ? (char) (i + 48) : (char) (i2 + (i - 10));
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        return charSequence.equals(charSequence2);
    }

    public static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        boolean a2 = a((CharSequence) str);
        boolean a3 = a((CharSequence) str2);
        if (a2) {
            return a3;
        }
        if (a3) {
            return false;
        }
        return str.equals(str2);
    }

    public static String a(byte[] bArr, int i, int i2, boolean z) {
        if (bArr == null || i >= i2 || bArr.length == 0 || i >= bArr.length) {
            return "";
        }
        return a(new StringBuilder(bArr.length << 1), bArr, i, i2, z ? 'A' : 'a').toString();
    }

    public static String a(byte[] bArr, boolean z) {
        return (bArr == null || bArr.length == 0) ? "" : a(bArr, 0, bArr.length, z);
    }

    private static StringBuilder a(StringBuilder sb, byte[] bArr, int i, int i2, char c) {
        while (i < i2) {
            byte b = bArr[i];
            sb.append(a((b >> 4) & 15, c));
            sb.append(a(b & 15, c));
            i++;
        }
        return sb;
    }

    public static int a(Reader reader, List<String> list, char c) {
        int size = list.size();
        StringBuilder sb = new StringBuilder(32);
        while (true) {
            int read = reader.read();
            if (read < 0) {
                break;
            }
            char c2 = (char) read;
            if (c2 == '\\') {
                int read2 = reader.read();
                if (read2 < 0) {
                    sb.append(c2);
                    break;
                }
                char c3 = (char) read2;
                if (c3 != '\\' && c3 != c) {
                    sb.append('\\');
                }
                sb.append(c3);
            } else if (c2 == c) {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c2);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return list.size() - size;
    }

    public static int a(Reader reader, List<String> list) {
        return a(reader, list, ',');
    }

    public static String a(Object obj) {
        return obj == null ? Constants.NULL_VERSION_ID : obj.toString();
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return Constants.NULL_VERSION_ID;
        }
        int length = bArr.length;
        int min = Math.min(8, length);
        StringBuilder sb = new StringBuilder(128);
        sb.append('[');
        int i = 0;
        while (i < min) {
            sb.append("0x");
            int i2 = i + 1;
            a(sb, bArr, i, i2, 'A');
            if (i >= min - 1) {
                break;
            }
            sb.append(", ");
            i = i2;
        }
        if (min < length) {
            sb.append(", ... (Total ");
            sb.append(length);
            sb.append(" bytes)");
        }
        sb.append(']');
        return sb.toString();
    }
}
