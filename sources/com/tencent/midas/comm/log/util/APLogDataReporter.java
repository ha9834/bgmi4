package com.tencent.midas.comm.log.util;

import android.util.Log;
import com.tencent.midas.comm.APLogInfo;

/* loaded from: classes.dex */
public class APLogDataReporter {
    public static final String MIDAS_LOG_ERROR_APPEND = "sdk.log.error.append";
    public static final String MIDAS_LOG_ERROR_CLOSE = "sdk.log.error.close";
    public static final String MIDAS_LOG_ERROR_FLUSH = "sdk.log.error.flush";
    public static final String MIDAS_LOG_ERROR_INIT = "sdk.log.error.init";
    public static final String MIDAS_LOG_ERROR_MMAP_OPEN = "sdk.log.error.mmap.open";
    public static final String MIDAS_LOG_ERROR_PRINT = "sdk.log.error.print";
    public static final String MIDAS_LOG_ERROR_PROCESS = "sdk.log.error.process";
    public static final String MIDAS_LOG_ERROR_WRITE = "sdk.log.error.write";
    public static final String MIDAS_LOG_INIT = "sdk.log.init";
    private Reporter reporter;

    /* loaded from: classes.dex */
    public interface Reporter {
        void report(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static class Holder {
        private static final APLogDataReporter INSTANCE = new APLogDataReporter();

        private Holder() {
        }
    }

    private APLogDataReporter() {
    }

    public static APLogDataReporter getInstance() {
        return Holder.INSTANCE;
    }

    public Reporter getReporter() {
        return this.reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void report(String str, String str2) {
        report("launchpay", str, str2);
    }

    public void report(String str, String str2, String str3) {
        try {
            if (this.reporter != null) {
                this.reporter.report(str, str2, str3);
            }
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, "report error: " + th.getMessage());
            th.printStackTrace();
        }
    }

    public void reportTimeEx(String str, long j) {
        report(str, String.valueOf(System.currentTimeMillis() - j));
    }
}
