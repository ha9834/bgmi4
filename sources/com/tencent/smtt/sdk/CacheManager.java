package com.tencent.smtt.sdk;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes2.dex */
public final class CacheManager {
    @Deprecated
    public static File getCacheFileBaseDir() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return (File) a2.c().e();
        }
        return (File) com.tencent.smtt.utils.c.a("android.webkit.CacheManager", "getCacheFileBaseDir");
    }

    @Deprecated
    public static boolean cacheDisabled() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return ((Boolean) a2.c().b()).booleanValue();
        }
        Object a3 = com.tencent.smtt.utils.c.a("android.webkit.CacheManager", "cacheDisabled");
        if (a3 == null) {
            return false;
        }
        return ((Boolean) a3).booleanValue();
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().e();
        }
        try {
            return com.tencent.smtt.utils.c.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
        } catch (Exception unused) {
            return null;
        }
    }

    public static InputStream getCacheFile(String str, boolean z) {
        r a2 = r.a();
        if (a2 == null || !r.b()) {
            return null;
        }
        return a2.c().a(str, z);
    }
}
