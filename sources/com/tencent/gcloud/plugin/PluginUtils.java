package com.tencent.gcloud.plugin;

import android.util.Log;

/* loaded from: classes2.dex */
public class PluginUtils {
    private static final String LOG_TAG = "GCloudCore";
    private static boolean hasGCloudCoreLoaded;
    private static long nativePluginManager;
    private static long nativeServiceManager;

    private static native void nativePostStartup();

    private static native void nativePreShutdown();

    private static native void nativeShutdown();

    private static native void nativeStartup();

    public static void loadLibrary(String str) {
        if (!hasGCloudCoreLoaded) {
            Log.i(LOG_TAG, "try to load libgcloudcore.so for the first time");
            System.loadLibrary("gcloudcore");
            hasGCloudCoreLoaded = true;
        }
        Log.i(LOG_TAG, "GCloudUtils.loadLibrary:lib" + str + ".so");
        System.loadLibrary(str);
    }

    public static void SetNativePluginManager(long j) {
        Log.i(LOG_TAG, "SetNativePluginManager:" + Long.toHexString(j));
        nativePluginManager = j;
    }

    public static void SetNativeServiceManager(long j) {
        Log.i(LOG_TAG, "SetNativeServiceManager:" + Long.toHexString(j));
        nativeServiceManager = j;
    }

    public static long GetNativePluginManager() {
        Log.i(LOG_TAG, "GetNativePluginManager nativePluginManager:" + Long.toHexString(nativePluginManager));
        return nativePluginManager;
    }

    public static long GetNativeServiceManager() {
        Log.i(LOG_TAG, "GetNativeServiceManager nativeServiceManager:" + Long.toHexString(nativeServiceManager));
        return nativeServiceManager;
    }

    public static void Startup() {
        nativeStartup();
    }

    public static void PostStartup() {
        nativePostStartup();
    }

    public static void PreShutdown() {
        nativePreShutdown();
    }

    public static void Shutdown() {
        nativeShutdown();
    }
}
