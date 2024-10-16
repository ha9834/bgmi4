package com.tencent.midas.comm;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.File;

/* loaded from: classes.dex */
public class APLogInfo {
    public static final String LOG_TAG = "MidasComm<Log>";
    public static final int LOG_VERSION_CODE = 41;
    public static final String LOG_VERSION_NAME = "1.02.25";
    private Context context = null;
    private String logTag = "TencentPay";
    private boolean logEnable = true;
    private String logPath = "";
    private boolean hasWritePermission = false;
    private String pkgName = "";
    private String processName = "";
    private boolean writeLog = true;
    private boolean printLog = false;
    private boolean compressLog = true;
    private boolean encryptLog = true;
    private boolean autoFlush = true;

    public void init() {
        if (this.context == null) {
            Log.e(LOG_TAG, "APLogInfo init failed because of null context");
            return;
        }
        initPkgName();
        initPermission();
        initProcessName();
        initLogPath();
        Log.i(LOG_TAG, "Log lib versionName: 1.02.25 versionCode: 41");
    }

    private void initPkgName() {
        Context context = this.context;
        if (context == null) {
            return;
        }
        try {
            this.pkgName = context.getPackageManager().getPackageInfo(this.context.getApplicationContext().getPackageName(), 0).packageName;
        } catch (Throwable th) {
            Log.w(LOG_TAG, "getPackage: " + th.toString());
        }
        Log.w(LOG_TAG, "get pkgName: " + this.pkgName);
    }

    private void initPermission() {
        this.hasWritePermission = this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pkgName) == 0;
        Log.d(LOG_TAG, "has WRITE_EXTERNAL_STORAGE? : " + this.hasWritePermission);
    }

    private void initProcessName() {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String[] split = runningAppProcessInfo.processName.split(CertificateUtil.DELIMITER);
                        if (split.length > 1) {
                            this.processName = split[1];
                        } else {
                            this.processName = "";
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.w(LOG_TAG, "get process: " + th.toString());
        }
        Log.w(LOG_TAG, "get process name: " + this.processName);
    }

    private void initLogPath() {
        try {
            if (!this.hasWritePermission) {
                File externalFilesDir = this.context.getExternalFilesDir("midas" + File.separator + "log" + File.separator);
                this.logPath = externalFilesDir == null ? "" : externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.logPath) || !new File(this.logPath).canWrite()) {
                this.logPath = Environment.getExternalStorageDirectory() + File.separator + "BGMI" + File.separator + "BMI" + File.separator + "Log" + File.separator;
            }
        } catch (Throwable th) {
            Log.w(LOG_TAG, "init log path error: " + th.getMessage());
            this.logPath = Environment.getExternalStorageDirectory() + File.separator + "BGMI" + File.separator + "BMI" + File.separator + "Log" + File.separator;
            th.printStackTrace();
        }
    }

    public boolean isAutoFlush() {
        return this.autoFlush;
    }

    public void setAutoFlush(boolean z) {
        this.autoFlush = z;
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public Context getContext() {
        return this.context;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void setLogEnable(boolean z) {
        this.logEnable = z;
    }

    public boolean isLogEnable() {
        return this.logEnable;
    }

    public void setLogTag(String str) {
        this.logTag = str;
    }

    public String getLogTag() {
        return this.logTag;
    }

    public void setLogParamFromServer(String str) {
        setLogWrite(str);
    }

    public void setLogWrite(String str) {
        int i;
        try {
            i = Integer.valueOf(str).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            i = 3;
        }
        setPrintLog((i & 1) == 1);
        setWriteLog((i & 2) == 2);
    }

    private void setWriteLog(boolean z) {
        this.writeLog = z;
        Log.d(LOG_TAG, "set write log: " + z);
    }

    public boolean isWriteLog() {
        return this.writeLog;
    }

    private void setPrintLog(boolean z) {
        this.printLog = z;
        Log.d(LOG_TAG, "set print log: " + z);
    }

    public boolean isPrintLog() {
        return this.printLog;
    }

    public boolean shouldPrintLog() {
        return this.logEnable || this.printLog || APLogFileUtil.isDebugMode(APLogFileInfo.dirName);
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProcessName() {
        return this.processName;
    }

    public boolean isHasWritePermission() {
        return this.hasWritePermission;
    }

    public void setCompressLog(boolean z) {
        this.compressLog = z;
        Log.d(LOG_TAG, "set compress log: " + z);
    }

    public boolean isCompressLog() {
        return this.compressLog;
    }

    public void setEncryptLog(boolean z) {
        this.encryptLog = z;
        Log.d(LOG_TAG, "set encrypt log: " + z);
    }

    public boolean isEncryptLog() {
        return this.encryptLog;
    }

    public void setEncryptKey(String str) {
        APLogEncryptor.setEncryptKey(str);
    }

    public void setEncryptProtocolVersion(byte b) {
        APLogEncryptor.setProtocolVersion(b);
    }

    public void setLogFileSizeMB(int i) {
        APLogFileUtil.maxLogFileSizeMB = i;
        Log.d(LOG_TAG, "set log file size: " + i + " MB");
    }

    public void setLogFileNum(int i) {
        APLogFileUtil.maxLogFileNum = i;
        Log.d(LOG_TAG, "set log file num: " + i);
    }

    public void setLogFileKeepDays(int i) {
        APLogFileUtil.maxLogKeepDays = i;
        Log.d(LOG_TAG, "set log file keep days: " + i);
    }
}
