package com.tencent.crashsight.core.tools;

/* loaded from: classes2.dex */
public class NDKHelper {
    private static final String coreSoName = "CrashSightCore";
    private static boolean mIsLoadedSO;
    private static boolean mIsLoadingSO;

    public static boolean loadSO() {
        if (!mIsLoadedSO && !mIsLoadingSO) {
            mIsLoadingSO = true;
            UQMLog.d("try to load CrashSightCore");
            if (loadPluginByReflection()) {
                mIsLoadedSO = true;
            } else {
                UQMLog.d("CrashSightCore.so loading failed.");
            }
        } else {
            UQMLog.d("CrashSightCore.so have been loaded");
        }
        mIsLoadingSO = false;
        return mIsLoadedSO;
    }

    public static boolean checkSOLoaded() {
        if (mIsLoadedSO || !mIsLoadingSO) {
            return true;
        }
        UQMLog.e("--------------------------------------------\n.so has not been loaded. To use JNI helper, please initialize with \nUQMPlatform.initialize (Activity activity);\n--------------------------------------------\n");
        return false;
    }

    private static boolean loadPluginByReflection() {
        try {
            System.loadLibrary(coreSoName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
