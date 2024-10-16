package com.subao.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
public class e {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException | RuntimeException unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static long a(byte[] bArr, int i, int i2, long j) {
        if (i2 > bArr.length) {
            i2 = bArr.length;
        }
        while (i < i2) {
            byte b = bArr[i];
            if (Character.isDigit(b)) {
                long j2 = b - 48;
                for (int i3 = i + 1; i3 < i2; i3++) {
                    if (!Character.isDigit(bArr[i3])) {
                        break;
                    }
                    j2 = (j2 * 10) + (r0 - 48);
                }
                return j2;
            }
            i++;
        }
        return j;
    }

    public static boolean a(int i) {
        int i2 = i % 100000;
        return i2 >= 10000 && i2 <= 19999;
    }

    public static <T> boolean a(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return t.equals(t2);
    }

    public static String a(String str) {
        return a(str, "UTF-8");
    }

    public static String a(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
