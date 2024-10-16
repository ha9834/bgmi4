package com.tencent.crashsight.core.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import com.tencent.crashsight.core.tools.NDKHelper;
import com.tencent.crashsight.core.tools.UQMLog;

/* loaded from: classes2.dex */
public class CrashSightPlatform {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Activity mActivityCached;

    @SuppressLint({"StaticFieldLeak"})
    private static Activity mActivityCur;

    public static boolean initialize(Activity activity) {
        mActivityCached = activity;
        if (!NDKHelper.loadSO()) {
            return true;
        }
        UQMLog.e("so library is loaded");
        return true;
    }

    public static boolean loadCrashSightCoreSo() {
        if (NDKHelper.loadSO()) {
            UQMLog.i("so library is loaded");
            if (UQMApplications.context() != null) {
                return true;
            }
            UQMLog.e("cache context error!");
            return false;
        }
        UQMLog.i("fail to load libUQMCore.so");
        return false;
    }

    public static void setActivityCur(Activity activity) {
        mActivityCur = activity;
    }

    public static Context getActivityCur() {
        Activity activity = mActivityCur;
        if (activity != null) {
            return activity;
        }
        if (mActivityCached != null) {
            return mActivityCached;
        }
        return UQMApplications.context();
    }

    public static Context getActivity() {
        if (mActivityCached != null) {
            return mActivityCached;
        }
        return UQMApplications.context();
    }
}
