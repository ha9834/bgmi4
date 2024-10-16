package com.tencent.imsdk.android.tools.log;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.DigestUtils;
import com.tencent.imsdk.android.tools.FileUtils;
import com.tencent.imsdk.android.tools.IMSDKContext;
import com.tencent.imsdk.android.tools.T;
import java.io.File;

/* loaded from: classes.dex */
public class LogUtils {
    private static final String FILE_TIME_FORMAT = "yyyyMMddHHmmss";
    private static final String LOCAL_LOG_BEGIN = "197001010800";
    private static final int LOCAL_LOG_DISABLE = 0;
    private static final String LOCAL_LOG_END = "197001010801";
    private static final String LOCAL_LOG_MAXFILESIZE = "204800";
    private static final String LOCAL_LOG_MAXLOGSIZE = "10485760";
    public static final String LOG_EXT = ".log";
    public static final long LOG_FUSE_TIME = 10000;
    private static final String LOG_SEPARATE = "_";
    private static String mDirPath = "";
    private static volatile String mFileTime;
    private static long[] mHits = new long[5];

    public static String getLogStartTimeLimit() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_LOCAL_LOG_BEGIN.toUpperCase(), IR.meta.IMSDK_LOCAL_LOG_BEGIN, LOCAL_LOG_BEGIN);
    }

    public static String getLogEndTimeLimit() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_LOCAL_LOG_END.toUpperCase(), IR.meta.IMSDK_LOCAL_LOG_END, LOCAL_LOG_END);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isFileLoggable() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_LOCAL_LOG_ENABLE.toUpperCase(), IR.meta.IMSDK_LOCAL_LOG_ENABLE, 0) != 0;
    }

    protected static long getLogDirSizeLimit() {
        return Long.valueOf(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_LOCAL_LOG_MAXLOGSIZE.toUpperCase(), IR.meta.IMSDK_LOCAL_LOG_MAXLOGSIZE, LOCAL_LOG_MAXLOGSIZE)).longValue();
    }

    protected static long getLogFileSizeLimit() {
        return Long.valueOf(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_LOCAL_LOG_MAXFILESIZE.toUpperCase(), IR.meta.IMSDK_LOCAL_LOG_MAXFILESIZE, LOCAL_LOG_MAXFILESIZE)).longValue();
    }

    private static String getFileTime() {
        if (!T.ckIsEmpty(mFileTime)) {
            return mFileTime;
        }
        return TimeUtils.getCurTime(FILE_TIME_FORMAT);
    }

    private static String getFilePrefix() {
        int i;
        String str = "unknown-device-id";
        if (IMSDKContext.getAppContext() != null) {
            str = DeviceUtils.getDeviceUuid(IMSDKContext.getAppContext());
            i = IMSDKConfig.getOrMetaData(IR.meta.GAME_ID, IR.meta.GAME_ID, 11);
        } else {
            i = 9999;
        }
        return "2_" + str + "_" + i + "_" + getFileTime();
    }

    private static String getFileName() {
        return getFilePrefix() + LOG_EXT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getLogFilePath() {
        return getLogDirPath() + File.separator + getFileName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setLogDirPath(String str) {
        mDirPath = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getLogDirPath() {
        if (!T.ckIsEmpty(mDirPath)) {
            return mDirPath;
        }
        Log.d(FileUtils.LOG_TAG, " getLogDirPath dirpath is null , plz init !!");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void createNewLogFile() {
        if (isFileLoggable()) {
            mFileTime = TimeUtils.getCurTime(FILE_TIME_FORMAT);
            String lineOneSecret = getLineOneSecret();
            if (T.ckIsEmpty(lineOneSecret)) {
                return;
            }
            FileUtils.insert(getLogFilePath(), 0L, lineOneSecret + System.getProperty("line.separator"));
        }
    }

    private static String getLineOneSecret() {
        return DigestUtils.getAESEncryptKey(DigestUtils.PUBLIC_KEY, DigestUtils.getAESSecretKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean checkAndCreateLogFile(String str) {
        if (FileUtils.calSize(str) <= getLogFileSizeLimit()) {
            return true;
        }
        zipLogFiles();
        if (isCreateFileTooQuick()) {
            return false;
        }
        createNewLogFile();
        return true;
    }

    private static boolean isCreateFileTooQuick() {
        long[] jArr = mHits;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = mHits;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        return SystemClock.uptimeMillis() - mHits[0] < LOG_FUSE_TIME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zipLogFiles() {
        try {
            File[] logFiles = FileUtils.getLogFiles(new File(getLogDirPath()));
            if (logFiles == null || logFiles.length <= 0) {
                return;
            }
            for (File file : logFiles) {
                FileUtils.zipLogs(file);
            }
        } catch (Exception e) {
            Log.d(FileUtils.LOG_TAG, " zipLogFiles exception = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkAndDeleteFiles(String str) {
        try {
            File file = new File(str);
            long logDirSizeLimit = getLogDirSizeLimit();
            if (!file.exists() || FileUtils.calSize(file) <= logDirSizeLimit) {
                return;
            }
            File[] listFiles = file.listFiles();
            FileUtils.sortByModifyDateDesc(listFiles);
            for (File file2 : listFiles) {
                if (FileUtils.calSize(file) > logDirSizeLimit / 2) {
                    FileUtils.deleteFile(file2.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            Log.d(FileUtils.LOG_TAG, " checkAndDeleteFiles exception = " + e.getMessage());
        }
    }
}
