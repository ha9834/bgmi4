package com.tencent.hawk.utils;

import android.os.Build;
import android.os.Process;
import com.tencent.hawk.bridge.HawkLogger;

/* loaded from: classes2.dex */
public class StartupHelper {
    public static long getStartupTime() {
        try {
            if (Build.VERSION.SDK_INT > 24) {
                return Process.getStartElapsedRealtime();
            }
            return 0L;
        } catch (Exception e) {
            HawkLogger.e("get startUpTime error: " + e.getMessage());
            return 0L;
        }
    }
}
