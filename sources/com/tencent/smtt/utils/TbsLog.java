package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6536a = true;
    private static boolean b = true;
    private static TbsLogClient c;
    public static List<String> sTbsLogList = new LinkedList();
    public static int sLogMaxCount = 10;

    public static void setWriteLogJIT(boolean z) {
        b = z;
        if (c == null) {
            return;
        }
        TbsLogClient.setWriteLogJIT(z);
    }

    public static void app_extra(String str, Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            int i = 0;
            String[] strArr = {TbsConfig.APP_DEMO, TbsConfig.APP_QB, TbsConfig.APP_WX, "com.tencent.mobileqq", TbsConfig.APP_DEMO_TEST, "com.qzone"};
            String[] strArr2 = {"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (true) {
                if (i >= strArr.length) {
                    break;
                }
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == strArr.length) {
                i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
        } catch (Throwable th) {
            w(str, "app_extra exception:" + Log.getStackTraceString(th));
        }
    }

    public static void i(String str, String str2) {
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.i(str, "TBS:" + str2);
        c.writeLog("(I)-" + str + "-TBS:" + str2);
    }

    public static void i(String str, String str2, boolean z) {
        i(str, str2);
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f6536a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void e(String str, String str2) {
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.e(str, "TBS:" + str2);
        c.writeLog("(E)-" + str + "-TBS:" + str2);
    }

    public static void e(String str, String str2, boolean z) {
        e(str, str2);
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f6536a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void w(String str, String str2) {
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.w(str, "TBS:" + str2);
        c.writeLog("(W)-" + str + "-TBS:" + str2);
    }

    public static void w(String str, String str2, boolean z) {
        w(str, str2);
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f6536a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void d(String str, String str2) {
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.d(str, "TBS:" + str2);
        c.writeLog("(D)-" + str + "-TBS:" + str2);
    }

    public static void d(String str, String str2, boolean z) {
        d(str, str2);
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f6536a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void v(String str, String str2) {
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.v(str, "TBS:" + str2);
        c.writeLog("(V)-" + str + "-TBS:" + str2);
    }

    public static void v(String str, String str2, boolean z) {
        v(str, str2);
        TbsLogClient tbsLogClient = c;
        if (tbsLogClient != null && f6536a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void setLogView(TextView textView) {
        TbsLogClient tbsLogClient;
        if (textView == null || (tbsLogClient = c) == null) {
            return;
        }
        tbsLogClient.setLogView(textView);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        c = tbsLogClient;
        TbsLogClient tbsLogClient2 = c;
        TbsLogClient.setWriteLogJIT(b);
        return true;
    }

    public static String getTbsLogFilePath() {
        if (TbsLogClient.c != null) {
            return TbsLogClient.c.getAbsolutePath();
        }
        return null;
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            if (c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
        }
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            if (c != null) {
                c.writeLogToDisk();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void addLog(int i, String str, Object... objArr) {
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i2;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception unused) {
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", Long.valueOf(System.currentTimeMillis()), 1, '0', Integer.valueOf(i), str2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
