package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes2.dex */
final class w extends zzadc {
    @Override // com.google.android.gms.internal.ads.zzadc
    public final String zzg(String str, String str2) {
        String a2 = a(str);
        String a3 = a(str2);
        if (TextUtils.isEmpty(a2)) {
            return a3;
        }
        if (TextUtils.isEmpty(a3)) {
            return a2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 1 + String.valueOf(a3).length());
        sb.append(a2);
        sb.append(",");
        sb.append(a3);
        return sb.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }
}
