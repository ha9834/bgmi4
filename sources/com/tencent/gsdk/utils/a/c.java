package com.tencent.gsdk.utils.a;

import java.util.Map;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f6236a;

    static {
        e.a(2);
    }

    public static void a(boolean z) {
        f6236a = z;
    }

    public static void a(String str, Map<String, String> map) {
        if (f6236a) {
            com.tencent.gsdk.utils.g.b("Try to report " + str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                com.tencent.gsdk.utils.g.b("\t" + entry.getKey() + ": " + entry.getValue());
            }
        }
        e.a(str, map);
    }
}
