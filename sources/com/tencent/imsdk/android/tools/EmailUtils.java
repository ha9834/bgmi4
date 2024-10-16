package com.tencent.imsdk.android.tools;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class EmailUtils {
    private static final int CODE_LENGTH = 6;
    private static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    private static final String REGEX_EMAIL_PLATFORM = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
    private static final String REGEX_POSITIVE_INTEGER = "^[1-9]\\d*$";

    public static boolean isEmail(CharSequence charSequence) {
        return isMatch(REGEX_EMAIL_PLATFORM, charSequence);
    }

    public static boolean isEmailCode(CharSequence charSequence, CharSequence charSequence2) {
        return isEmail(charSequence) && isCode(charSequence2);
    }

    public static boolean isCode(CharSequence charSequence) {
        return isMatch(REGEX_POSITIVE_INTEGER, charSequence) && charSequence.length() == 6;
    }

    private static boolean isMatch(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }
}
