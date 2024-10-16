package com.tencent.imsdk.android.base;

import android.content.Context;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.HashMap;

/* loaded from: classes.dex */
public class IMSDKModules {
    private static Context mCtx;
    private static HashMap<String, Object> mModules = new HashMap<>();

    private IMSDKModules() {
    }

    /* loaded from: classes.dex */
    private static final class Holder {
        static final IMSDKModules instance = new IMSDKModules();

        private Holder() {
        }
    }

    public static IMSDKModules getInstance(Context context) {
        mCtx = context;
        return Holder.instance;
    }

    public <T> T getChannelInstance(Class<?> cls, String str) {
        return (T) getChannelInstance(cls, str, true);
    }

    public <T> T getChannelInstance(Class<?> cls, String str, boolean z) {
        try {
            return (T) cls.cast(getModule(str, z));
        } catch (ClassCastException e) {
            IMLogger.e("Get '" + cls.getName() + "' instance failed : " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a4, code lost:
    
        if (r9 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getModule(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "try to get module : "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.tencent.imsdk.android.tools.log.IMLogger.d(r0)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = com.tencent.imsdk.android.base.IMSDKModules.mModules
            java.lang.Object r0 = r0.get(r8)
            if (r0 != 0) goto Lb6
            r1 = 0
            r2 = 0
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r2] = r6     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.reflect.Constructor r1 = r3.getDeclaredConstructor(r5)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r1 == 0) goto L3c
            r1.setAccessible(r4)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            android.content.Context r4 = com.tencent.imsdk.android.base.IMSDKModules.mCtx     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r3[r2] = r4     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.Object r0 = r1.newInstance(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
        L3c:
            if (r1 == 0) goto L41
            r1.setAccessible(r2)
        L41:
            if (r0 == 0) goto Lb6
            if (r9 == 0) goto Lb6
        L45:
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = com.tencent.imsdk.android.base.IMSDKModules.mModules
            r9.put(r8, r0)
            goto Lb6
        L4b:
            r3 = move-exception
            goto La7
        L4d:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r4.<init>()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "can't get instance of '"
            r4.append(r5)     // Catch: java.lang.Throwable -> L4b
            r4.append(r8)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "' : "
            r4.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = r3.getMessage()     // Catch: java.lang.Throwable -> L4b
            r4.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4b
            com.tencent.imsdk.android.tools.log.IMLogger.e(r4, r5)     // Catch: java.lang.Throwable -> L4b
            boolean r4 = r3 instanceof java.lang.reflect.InvocationTargetException     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L9d
            r4 = r3
            java.lang.reflect.InvocationTargetException r4 = (java.lang.reflect.InvocationTargetException) r4     // Catch: java.lang.Throwable -> L4b
            java.lang.Throwable r4 = r4.getTargetException()     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L9d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r4.<init>()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "taget exception : "
            r4.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.InvocationTargetException r3 = (java.lang.reflect.InvocationTargetException) r3     // Catch: java.lang.Throwable -> L4b
            java.lang.Throwable r3 = r3.getTargetException()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L4b
            r4.append(r3)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4b
            com.tencent.imsdk.android.tools.log.IMLogger.e(r3, r4)     // Catch: java.lang.Throwable -> L4b
        L9d:
            if (r1 == 0) goto La2
            r1.setAccessible(r2)
        La2:
            if (r0 == 0) goto Lb6
            if (r9 == 0) goto Lb6
            goto L45
        La7:
            if (r1 == 0) goto Lac
            r1.setAccessible(r2)
        Lac:
            if (r0 == 0) goto Lb5
            if (r9 == 0) goto Lb5
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = com.tencent.imsdk.android.base.IMSDKModules.mModules
            r9.put(r8, r0)
        Lb5:
            throw r3
        Lb6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.IMSDKModules.getModule(java.lang.String, boolean):java.lang.Object");
    }

    public Object getModule(Class cls) {
        return getModule(cls.getName(), true);
    }
}
