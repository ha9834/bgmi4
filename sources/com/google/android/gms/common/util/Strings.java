package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public class Strings {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f1507a = Pattern.compile("\\$\\{(.*?)\\}");

    private Strings() {
    }

    @KeepForSdk
    public static String emptyToNull(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @KeepForSdk
    public static boolean isEmptyOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }
}
