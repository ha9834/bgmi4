package com.tencent.imsdk.android.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AccountUtils {
    public static boolean isMobile(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isPasswordStandard(String str) {
        return !hasChinese(str) && str.matches("\\w{6,18}+");
    }

    public static boolean hasChinese(String str) {
        Matcher matcher = Pattern.compile("([\\u4E00-\\u9FA5]*+)").matcher(str);
        boolean z = false;
        while (matcher.find()) {
            if (!"".equals(matcher.group(1))) {
                z = true;
            }
        }
        return z;
    }
}
