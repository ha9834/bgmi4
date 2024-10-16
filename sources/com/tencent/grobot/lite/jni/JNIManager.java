package com.tencent.grobot.lite.jni;

import com.tencent.grobot.lite.common.TLog;

/* loaded from: classes2.dex */
public class JNIManager {
    public static JNIManager sInstance;

    public static native void onGRobotClose();

    public static native void onGRobotShow();

    public static native void onUrlCallBack(String str);

    public static synchronized JNIManager getsInstance() {
        JNIManager jNIManager;
        synchronized (JNIManager.class) {
            if (sInstance == null) {
                sInstance = new JNIManager();
            }
            jNIManager = sInstance;
        }
        return jNIManager;
    }

    static {
        try {
            TLog.e("vlink_so", "load library!");
            System.loadLibrary("vlink");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
