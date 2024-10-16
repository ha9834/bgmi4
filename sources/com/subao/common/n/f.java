package com.subao.common.n;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class f {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length > 1) {
            return b(split[1]);
        }
        return null;
    }

    static String b(String str) {
        try {
            return a(Base64.decode(str, 8));
        } catch (UnsupportedEncodingException | RuntimeException unused) {
            return null;
        }
    }

    private static String a(byte[] bArr) {
        return new String(bArr, "UTF-8");
    }
}
