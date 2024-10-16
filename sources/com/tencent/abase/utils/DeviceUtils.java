package com.tencent.abase.utils;

/* loaded from: classes2.dex */
public class DeviceUtils {
    private static native String nativeGetCpuArch();

    static {
        try {
            System.loadLibrary("gcloudarch");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static String getCpuArch() {
        try {
            return nativeGetCpuArch();
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }
}
