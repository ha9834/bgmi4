package com.tencent.midas.comm.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;

/* loaded from: classes.dex */
public class APLogFileInfo {
    public static String dirName = "";
    public static String fileName = "";
    public static String mmapName = "";

    public static void create() {
        try {
            dirName = buildDirName();
            fileName = buildFileName(true);
            mmapName = buildMmapName();
            Log.d(APLogInfo.LOG_TAG, "log dir: " + dirName);
            Log.d(APLogInfo.LOG_TAG, "log file: " + fileName);
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, "file info create error: " + th.toString());
        }
    }

    private static String buildMmapName() {
        return dirName + File.separator + "MidasLog.mmap";
    }

    private static String buildDirName() {
        APLogInfo logInfo = APLog.getLogInfo();
        if (logInfo != null && logInfo.getLogPath() != null) {
            String logPath = logInfo.getLogPath();
            if (!logPath.endsWith(File.separator)) {
                logPath = logPath + File.separator;
            }
            String str = logPath + logInfo.getPkgName() + File.separator;
            if (TextUtils.isEmpty(logInfo.getProcessName())) {
                return str;
            }
            return str + logInfo.getProcessName() + File.separator;
        }
        Log.e(APLogInfo.LOG_TAG, "log info is null");
        return "";
    }

    private static int buildFileNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            String[] split = str.split(APLogFileUtil.getToday() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            if (split.length > 1) {
                return Integer.parseInt(split[1].split(".txt")[0]) + 1;
            }
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(APLogInfo.LOG_TAG, "build file number error: " + th.getMessage());
            return 1;
        }
    }

    public static void updateFileName() {
        fileName = buildFileName(false);
        Log.d(APLogInfo.LOG_TAG, "update file name: " + fileName);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String buildFileName(boolean r4) {
        /*
            r0 = 0
            java.lang.String r1 = com.tencent.midas.comm.log.APLogFileInfo.dirName     // Catch: java.lang.Throwable -> L52
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L6d
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = com.tencent.midas.comm.log.APLogFileInfo.dirName     // Catch: java.lang.Throwable -> L52
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = com.tencent.midas.comm.log.APLogFileInfo.dirName     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Throwable -> L4f
            boolean r0 = r0.endsWith(r2)     // Catch: java.lang.Throwable -> L4f
            if (r0 != 0) goto L1f
            java.lang.String r0 = java.io.File.separator     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
        L1f:
            java.lang.String r0 = com.tencent.midas.comm.log.APLogFileInfo.dirName     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = com.tencent.midas.comm.log.util.APLogFileUtil.getLastLogFileName(r0)     // Catch: java.lang.Throwable -> L4f
            if (r4 == 0) goto L35
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L4f
            if (r4 != 0) goto L35
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            return r4
        L35:
            java.lang.String r4 = com.tencent.midas.comm.log.util.APLogFileUtil.getToday()     // Catch: java.lang.Throwable -> L4f
            r1.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = "_"
            r1.append(r4)     // Catch: java.lang.Throwable -> L4f
            int r4 = buildFileNumber(r0)     // Catch: java.lang.Throwable -> L4f
            r1.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = ".txt"
            r1.append(r4)     // Catch: java.lang.Throwable -> L4f
            r0 = r1
            goto L6d
        L4f:
            r4 = move-exception
            r0 = r1
            goto L53
        L52:
            r4 = move-exception
        L53:
            java.lang.String r1 = "MidasComm<Log>"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "create log file name error:"
            r2.append(r3)
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            android.util.Log.i(r1, r4)
        L6d:
            if (r0 != 0) goto L72
            java.lang.String r4 = ""
            goto L76
        L72:
            java.lang.String r4 = r0.toString()
        L76:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.comm.log.APLogFileInfo.buildFileName(boolean):java.lang.String");
    }
}
