package com.tencent.hawk.bridge;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;

/* loaded from: classes2.dex */
public class PssFetcher {
    private static ActivityManager sActivityMgr;
    private static int sPid;

    public static int getPssMemorySize(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        try {
            if (sActivityMgr == null) {
                sActivityMgr = (ActivityManager) context.getSystemService("activity");
            }
            if (sPid == 0) {
                sPid = Process.myPid();
            }
            if (sActivityMgr == null || sPid == 0 || (processMemoryInfo = sActivityMgr.getProcessMemoryInfo(new int[]{sPid})) == null || processMemoryInfo.length <= 0) {
                return 0;
            }
            return processMemoryInfo[0].getTotalPss();
        } catch (Exception e) {
            HawkLogger.e("PSS fetch error: " + e.getMessage());
            return 0;
        }
    }
}
