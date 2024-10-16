package com.ihoc.mgpa.n;

/* loaded from: classes2.dex */
public class o {
    public static String a(String str, String str2) {
        return (a.a() == null || str == null) ? str2 : a.a().getSharedPreferences("tgpa", 0).getString(str, str2);
    }

    public static void b(String str, String str2) {
        if (a.a() == null || str == null) {
            return;
        }
        a.a().getSharedPreferences("tgpa", 0).edit().putString(str, str2).apply();
    }
}
