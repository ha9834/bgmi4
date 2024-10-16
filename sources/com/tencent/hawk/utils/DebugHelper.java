package com.tencent.hawk.utils;

import android.content.Context;
import com.tencent.hawk.bridge.Constant;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.HawkNative;
import java.io.File;

/* loaded from: classes2.dex */
public class DebugHelper {
    private static void turnOnTMode() {
        HawkLogger.w("TMODE");
        HawkLogger.enableDebug();
        HawkNative.enableLogPrint();
        HawkLogger.enableTMode();
        HawkNative.enableTMode();
    }

    private static void checkTMode() {
        if (new File("/data/local/tmp/__apmtmode").exists()) {
            turnOnTMode();
        }
    }

    public static void checkTransparentMode(Context context) {
        File fileStreamPath = context.getFileStreamPath(Constant.APM_T_MODE);
        if (fileStreamPath != null && fileStreamPath.exists()) {
            turnOnTMode();
        } else {
            checkTMode();
        }
    }
}
