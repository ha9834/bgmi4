package com.tencent.grobot.lite.image.upload.cos.utils;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class StringUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || !(charSequence == null || charSequence2 == null || (!((charSequence instanceof String) && (charSequence2 instanceof String)) ? regionMatches(charSequence, false, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length())) : charSequence.equals(charSequence2)));
    }

    public static byte[] getBytesUTF8(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static String newStringUTF8(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i5 = i + 1;
            char charAt = charSequence.charAt(i);
            int i6 = i2 + 1;
            char charAt2 = charSequence2.charAt(i2);
            if (charAt != charAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                    return false;
                }
            }
            i = i5;
            i3 = i4;
            i2 = i6;
        }
    }
}
