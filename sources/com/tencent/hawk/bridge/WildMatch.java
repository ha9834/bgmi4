package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class WildMatch {
    public static boolean isMatch(String str, String str2) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i < str.length()) {
            if (i2 < str2.length() && (str.charAt(i) == str2.charAt(i2) || str2.charAt(i2) == '?')) {
                i2++;
                i++;
            } else if (i2 < str2.length() && str2.charAt(i2) == '*') {
                i4 = i;
                i3 = i2;
                i2++;
            } else {
                if (i3 == -1) {
                    return false;
                }
                i2 = i3 + 1;
                i4++;
                i = i4;
            }
        }
        while (i2 < str2.length() && str2.charAt(i2) == '*') {
            i2++;
        }
        return i2 == str2.length();
    }
}
