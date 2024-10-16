package com.tencent.ieg.gpc.globalization.utils;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class ReflectUtil {
    private static final String TAG = "ReflectUtil";
    private static HashMap<String, Object> mModules = new HashMap<>();

    public static Object createInstance(Class cls, String str) {
        return createInstance(cls, str, true);
    }

    public static Object createInstance(Class cls, String str, boolean z) {
        try {
            return cls.cast(getModule(str, z));
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if (r6 != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object getModule(java.lang.String r5, boolean r6) {
        /*
            java.lang.String r0 = "ReflectUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "get module : "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.tencent.ieg.gpc.globalization.utils.GGLog.d(r0, r1)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = com.tencent.ieg.gpc.globalization.utils.ReflectUtil.mModules
            java.lang.Object r0 = r0.get(r5)
            if (r0 != 0) goto L5c
            java.lang.Class r1 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.Object r0 = r1.newInstance()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r0 == 0) goto L5c
            if (r6 == 0) goto L5c
        L2a:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = com.tencent.ieg.gpc.globalization.utils.ReflectUtil.mModules
            r6.put(r5, r0)
            goto L5c
        L30:
            r1 = move-exception
            goto L52
        L32:
            r1 = move-exception
            java.lang.String r2 = "ReflectUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            java.lang.String r4 = "can't get instance of '"
            r3.append(r4)     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L30
            r3.append(r1)     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L30
            com.tencent.ieg.gpc.globalization.utils.GGLog.e(r2, r1)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L5c
            if (r6 == 0) goto L5c
            goto L2a
        L52:
            if (r0 == 0) goto L5b
            if (r6 == 0) goto L5b
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = com.tencent.ieg.gpc.globalization.utils.ReflectUtil.mModules
            r6.put(r5, r0)
        L5b:
            throw r1
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ieg.gpc.globalization.utils.ReflectUtil.getModule(java.lang.String, boolean):java.lang.Object");
    }
}
