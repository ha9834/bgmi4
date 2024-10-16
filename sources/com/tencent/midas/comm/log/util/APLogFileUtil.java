package com.tencent.midas.comm.log.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.oversea.comm.APSPTools;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class APLogFileUtil {
    private static final String DEBUG_CONF = "MidasLogDebug.ini";
    private static final int DEFAULT_MAX_LOG_FILE_NUM = 2;
    private static final int DEFAULT_MAX_LOG_FILE_SIZE_MB = 1;
    private static final int DEFAULT_MAX_LOG_KEEP_DAYS = 15;
    public static final String SEPARATOR_LINE = "\r\n";
    public static final String SEPARATOR_LOG = " | ";
    public static int minSDCardSpace = 20;
    public static int maxLogKeepDays = 15;
    public static int maxLogFileNum = 2;
    public static int maxLogFileSizeMB = 1;
    private static int maxDirSizeMB = (maxLogKeepDays * maxLogFileNum) * maxLogFileSizeMB;

    public static double getFileOrFilesSize(String str) {
        long j;
        File file = new File(str);
        try {
            if (file.isDirectory()) {
                j = getFileSizes(file);
            } else {
                j = getFileSize(file);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            j = 0;
        }
        return (j / 1024) / 1024;
    }

    private static long getFileSize(File file) {
        long j = 0;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                j = fileInputStream.available();
                fileInputStream.close();
            } else {
                file.createNewFile();
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    private static long getFileSizes(File file) {
        long fileSize;
        File[] listFiles = file.listFiles();
        long j = 0;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                fileSize = getFileSizes(listFiles[i]);
            } else {
                fileSize = getFileSize(listFiles[i]);
            }
            j += fileSize;
        }
        return j;
    }

    public static double getSDCardSpace() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j = ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Throwable th) {
            Log.i(APLogInfo.LOG_TAG, "getSDCardSpace: " + th.toString());
            j = 0;
        }
        return j;
    }

    public static void deleteOldFileToday(String str) {
        deleteOldFileToday(str, maxLogFileNum);
    }

    public static void deleteOldFileToday(String str, int i) {
        ArrayList<File> logFiles = getLogFiles(str, getToday() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        int size = logFiles.size();
        if (size < i || i <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            File file = logFiles.get(i2);
            if (file != null) {
                Log.w(APLogInfo.LOG_TAG, "get: " + file.getName());
                if (i2 < size - i) {
                    Log.w(APLogInfo.LOG_TAG, "delete: " + file.getName());
                    file.delete();
                }
            }
        }
    }

    public static String getLastLogFileName(String str) {
        ArrayList<File> logFiles = getLogFiles(str, getToday());
        return logFiles.size() > 0 ? logFiles.get(logFiles.size() - 1).getName() : "";
    }

    public static ArrayList<File> getLogFiles(String str, final String str2) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.midas.comm.log.util.APLogFileUtil.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str3) {
                    return str3.startsWith(str2);
                }
            });
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.midas.comm.log.util.APLogFileUtil.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return extractNumber(file2.getName()) - extractNumber(file3.getName());
                }

                private int extractNumber(String str3) {
                    try {
                        return Integer.parseInt(str3.substring(str3.indexOf(95) + 1, str3.lastIndexOf(46)));
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            return new ArrayList<>(Arrays.asList(listFiles));
        }
        return new ArrayList<>();
    }

    public static String getToday() {
        return new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }

    public static void deleteFileUpMaxInDir(String str, long j, long j2, int i) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isFile()) {
                double fileOrFilesSize = getFileOrFilesSize(str);
                boolean z = fileOrFilesSize >= ((double) j2);
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (!file2.getName().equals("MidasLog.mmap") && file2.isFile() && (z || currentTimeMillis - lastModified > i * 24 * 3600 * 1000 || (getFileSize(file2) / 1024) / 1024 >= j)) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean initLogDir(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                Log.i(APLogInfo.LOG_TAG, "create log dir result: " + mkdirs);
                return mkdirs;
            }
            deleteFileUpMaxInDir(str, maxLogFileSizeMB, maxDirSizeMB, maxLogKeepDays);
            deleteOldFileToday(str, maxLogFileNum);
            return true;
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, "init log dir error: " + th.toString());
            return false;
        }
    }

    public static boolean isDebugMode(String str) {
        return new File(str + DEBUG_CONF).exists();
    }

    private static int getConfValue(SharedPreferences sharedPreferences, String str, int i) {
        String string = sharedPreferences.getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        try {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "Read log conf[%s]: %s", str, string));
            int parseInt = Integer.parseInt(string);
            return parseInt > 0 ? parseInt : i;
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "Read log conf[%s] error: %s", str, th.getMessage()));
            return i;
        }
    }

    public static void readLogKeepConf(Context context) {
        int i = maxLogFileSizeMB;
        if (i <= 0) {
            i = 1;
        }
        maxLogFileSizeMB = i;
        int i2 = maxLogFileNum;
        if (i2 <= 0) {
            i2 = 2;
        }
        maxLogFileNum = i2;
        int i3 = maxLogKeepDays;
        if (i3 <= 0) {
            i3 = 15;
        }
        maxLogKeepDays = i3;
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * maxLogKeepDays;
        Log.d(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "current config: max log size: %d MB, max log num: %d, max keep %d DAYS", Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays)));
        SharedPreferences sharedPreferences = context.getSharedPreferences(APSPTools.SP_NAME, 4);
        maxLogFileSizeMB = getConfValue(sharedPreferences, "size", maxLogFileSizeMB);
        maxLogFileNum = getConfValue(sharedPreferences, "num", maxLogFileNum);
        maxLogKeepDays = getConfValue(sharedPreferences, "log_keep_time", maxLogKeepDays);
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * maxLogKeepDays;
        Log.d(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "final config: max log size: %d MB, max log num: %d, max keep %d DAYS", Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays)));
    }
}
