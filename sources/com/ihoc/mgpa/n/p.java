package com.ihoc.mgpa.n;

import com.amazonaws.services.s3.internal.Constants;

/* loaded from: classes2.dex */
public class p {
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || Constants.NULL_VERSION_ID.equals(str);
    }
}
