package com.xiaomi.boostersdk;

/* loaded from: classes3.dex */
public class SystemProperties {
    public static String get(String str) {
        return get(str, "");
    }

    public static String get(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
