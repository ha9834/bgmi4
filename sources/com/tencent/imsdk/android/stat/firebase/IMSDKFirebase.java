package com.tencent.imsdk.android.stat.firebase;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class IMSDKFirebase {
    private static Context mCurCtx;

    public static void initialize(Context context) {
        mCurCtx = context;
        IMLogger.d("IMSDKFirebase initialize");
    }

    public static String getInstanceID() {
        if (mCurCtx == null) {
            return "";
        }
        IMLogger.d("IMSDKFirebase getInstanceID invoked");
        String firebaseInstanceId = FirebaseAnalytics.getInstance(mCurCtx).getFirebaseInstanceId();
        return !T.ckIsEmpty(firebaseInstanceId) ? firebaseInstanceId : "";
    }
}
