package com.tencent.midas.comm.log.internal;

import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import java.util.Locale;

/* loaded from: classes.dex */
public class APLogger {
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_SILENT = 6;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    private APLogAppender appender = null;

    private APLogger() {
    }

    private void openAppender() {
        this.appender = APLogAppender.open();
    }

    public static APLogger open() {
        APLogger aPLogger = new APLogger();
        aPLogger.openAppender();
        return aPLogger;
    }

    public void flush() {
        try {
            if (this.appender != null) {
                this.appender.flushAndWrite();
            }
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "flush log error: %s\n, stackTrace: %s", th.toString(), th.getStackTrace()[3]));
        }
    }

    public void write(String str) {
        this.appender.append(str);
    }

    public static void log(int i, String str, String str2) {
        String substring;
        int i2 = 0;
        while (i2 < str2.length()) {
            try {
                int i3 = i2 + 3600;
                if (str2.length() <= i3) {
                    substring = str2.substring(i2);
                } else {
                    substring = str2.substring(i2, i3);
                }
                switch (i) {
                    case 1:
                        Log.v(str, substring);
                        break;
                    case 2:
                        Log.d(str, substring);
                        break;
                    case 3:
                        Log.i(str, substring);
                        break;
                    case 4:
                        Log.w(str, substring);
                        break;
                    case 5:
                        Log.e(str, substring);
                        break;
                    case 6:
                        Log.e(str, substring);
                        break;
                }
                i2 = i3;
            } catch (Throwable th) {
                Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "print log error: <%s>%s", th.getClass().getName(), th.getMessage()));
                return;
            }
        }
    }
}
