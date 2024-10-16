package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzkl {
    public static String zzau(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
        }
        return str.substring(0, indexOf);
    }

    public static boolean zzav(String str) {
        return zzau(str).equals("audio");
    }

    public static boolean zzaw(String str) {
        return "audio/ac3".equals(str) || "audio/eac3".equals(str);
    }
}
