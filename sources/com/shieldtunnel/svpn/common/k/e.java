package com.shieldtunnel.svpn.common.k;

import android.os.Build;
import android.text.TextUtils;
import com.amazonaws.services.s3.internal.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5856a = new byte[0];
    private static final Charset b;

    static {
        Charset defaultCharset;
        if (Build.VERSION.SDK_INT >= 19) {
            defaultCharset = StandardCharsets.UTF_8;
        } else {
            try {
                defaultCharset = Charset.forName("UTF-8");
            } catch (UnsupportedOperationException unused) {
                defaultCharset = Charset.defaultCharset();
            }
        }
        b = defaultCharset;
    }

    private static byte a(byte b2) {
        return (b2 < 65 || b2 > 90) ? b2 : (byte) (b2 + 32);
    }

    private static char a(int i, int i2) {
        return i < 10 ? (char) (i + 48) : (char) (i2 + (i - 10));
    }

    public static String a(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : new String(bArr, b);
    }

    public static String b(String str) {
        return str == null ? "" : str;
    }

    public static String b(byte[] bArr) {
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

    public static boolean c(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return f5856a;
        }
        return str.getBytes(b);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || (length = bArr.length) != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            byte b3 = bArr2[i];
            if (b2 != b3 && a(b2) != a(b3)) {
                return false;
            }
        }
        return true;
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
            byte b2 = bArr[i];
            sb.append(a((b2 >> 4) & 15, c));
            sb.append(a(b2 & 15, c));
            i++;
        }
        return sb;
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String a(Object obj) {
        return obj == null ? Constants.NULL_VERSION_ID : obj.toString();
    }
}
