package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzsp {
    public static boolean zzav(String str) {
        return "audio".equals(a(str));
    }

    public static boolean zzbf(String str) {
        return "video".equals(a(str));
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
        }
        return str.substring(0, indexOf);
    }
}
