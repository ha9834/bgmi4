package com.shieldtunnel.svpn.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {
    static {
        new SecureRandom();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException | RuntimeException unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
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

    public static boolean a(Map<String, String> map, Map<String, String> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!a(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
