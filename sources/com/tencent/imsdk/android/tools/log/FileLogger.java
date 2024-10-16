package com.tencent.imsdk.android.tools.log;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKValidKeyCalcUnit;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.DigestUtils;
import com.tencent.imsdk.android.tools.FileUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import com.tencent.imsdk.android.tools.net.volley.upload.UploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FileLogger {
    private static final String LOG_DIR_NAME = "iMSDK";
    private static final String LOG_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private Context mContext;
    private IMSDKHttpClient mHttpClient;
    private static final ExecutorService sExecutorService = Executors.newFixedThreadPool(1);
    private static final String PRINT_FILE_FORMAT = " [%1$s] %2$s %3$s %4$s %5$s " + System.getProperty("line.separator");

    private FileLogger() {
    }

    public static FileLogger getInstance() {
        return SingletonHolder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SingletonHolder {
        private static final FileLogger sInstance = new FileLogger();

        private SingletonHolder() {
        }
    }

    public void initialize(Context context) {
        if (this.mContext == context || context == null) {
            return;
        }
        this.mContext = context;
        this.mHttpClient = new IMSDKHttpClient(this.mContext);
        String str = context.getFilesDir().getAbsolutePath() + File.separator + "iMSDK";
        LogUtils.setLogDirPath(str);
        LogUtils.zipLogFiles();
        LogUtils.checkAndDeleteFiles(str);
        LogUtils.createNewLogFile();
        uploadFile();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void saveLogToFile(int i, String str) {
        if (LogUtils.isFileLoggable()) {
            writeToFile(decorateMsgForFile(i, str));
        }
    }

    private synchronized void writeToFile(final String str) {
        sExecutorService.execute(new Runnable() { // from class: com.tencent.imsdk.android.tools.log.FileLogger.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Boolean.valueOf(LogUtils.checkAndCreateLogFile(LogUtils.getLogFilePath())).booleanValue()) {
                        FileUtils.writeFile(LogUtils.getLogFilePath(), DigestUtils.encryptAES(str, DigestUtils.getAESSecretKey()) + System.getProperty("line.separator"), true);
                    }
                } catch (Exception e) {
                    Log.d("iMSDK", "writeToFile Exception = " + e.getMessage());
                }
            }
        });
    }

    private synchronized void uploadFile() {
        sExecutorService.execute(new Runnable() { // from class: com.tencent.imsdk.android.tools.log.FileLogger.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileLogger.this.postFileToServer(FileLogger.this.checkUploadFiles());
                } catch (Exception e) {
                    Log.d("iMSDK", "Exception = " + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> checkUploadFiles() {
        File[] zipFiles = FileUtils.getZipFiles(new File(LogUtils.getLogDirPath()));
        if (zipFiles == null) {
            return new ArrayList();
        }
        return FileUtils.getConformFiles(LogUtils.getLogStartTimeLimit(), LogUtils.getLogEndTimeLimit(), zipFiles);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postFileToServer(List<File> list) {
        if (!isWifiState() && !isEmulator()) {
            Log.d("iMSDK", "current network is not Wi-Fi");
            return;
        }
        if (fileListNotNull(list)) {
            for (int i = 0; i < list.size(); i++) {
                final File file = list.get(i);
                String md5ByFile = FileUtils.getMd5ByFile(file);
                long calSize = FileUtils.calSize(file);
                Map<String, String> sortableMap = T.getSortableMap();
                sortableMap.put("iFileMd5", md5ByFile);
                sortableMap.put("iFileSize", String.valueOf(calSize));
                String fillFixedParamsAndValidKey = IMSDKValidKeyCalcUnit.getIns(this.mContext).fillFixedParamsAndValidKey(sortableMap);
                Map<String, String> requestParams = IMSDKValidKeyCalcUnit.getIns(this.mContext).getRequestParams(sortableMap);
                requestParams.put("log_file", file);
                requestParams.put("sValidKey", fillFixedParamsAndValidKey);
                this.mHttpClient.upload(IMSDKConfig.getOrDefault(IR.config.IMSDK_SERVER_LOG_URL, IR.url.IMSDK_SERVER_LOG_URL), requestParams, new UploadCallback() { // from class: com.tencent.imsdk.android.tools.log.FileLogger.3
                    @Override // com.tencent.imsdk.android.tools.net.volley.upload.UploadCallback
                    public void onSucceed(String str) {
                        Log.d("iMSDK", "onSucceed = " + str + ", file name = " + file.getName());
                        if (str.contains("SUCCESS")) {
                            FileUtils.deleteFile(file.getAbsolutePath());
                        }
                    }

                    @Override // com.tencent.imsdk.android.tools.net.volley.upload.UploadCallback
                    public void onFail(String str) {
                        Log.d("iMSDK", "onFail = " + str + ", file name = " + file.getName());
                    }
                });
            }
            return;
        }
        Log.d("iMSDK", "file list is empty");
    }

    private boolean isWifiState() {
        return DeviceUtils.getNetworkType(this.mContext) == 1;
    }

    private static boolean isEmulator() {
        return Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || "google_sdk".equals(Build.PRODUCT);
    }

    private boolean fileListNotNull(List<File> list) {
        return (list == null || list.size() == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
    
        r1 = "(" + r7.getFileName() + com.facebook.internal.security.CertificateUtil.DELIMITER + r7.getLineNumber() + ") " + r7.getMethodName();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String decorateMsgForFile(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r0 = com.tencent.imsdk.android.tools.log.TimeUtils.getCurTime(r0)
            java.lang.String r1 = "-"
            java.lang.String r2 = "-"
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3 = 3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L83
            r4.<init>()     // Catch: java.lang.Exception -> L83
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L83
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = "-"
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            int r5 = android.os.Process.myTid()     // Catch: java.lang.Exception -> L83
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L83
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch: java.lang.Exception -> L83
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()     // Catch: java.lang.Exception -> L83
            java.lang.Class r5 = r9.getClass()     // Catch: java.lang.Exception -> L83
            java.lang.Package r5 = r5.getPackage()     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L83
            r6 = 3
        L44:
            int r7 = r4.length     // Catch: java.lang.Exception -> L83
            if (r6 >= r7) goto L83
            r7 = r4[r6]     // Catch: java.lang.Exception -> L83
            java.lang.String r8 = r7.toString()     // Catch: java.lang.Exception -> L83
            boolean r8 = r8.contains(r5)     // Catch: java.lang.Exception -> L83
            if (r8 == 0) goto L56
            int r6 = r6 + 1
            goto L44
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L83
            r4.<init>()     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = "("
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = r7.getFileName()     // Catch: java.lang.Exception -> L83
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = ":"
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            int r5 = r7.getLineNumber()     // Catch: java.lang.Exception -> L83
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = ") "
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = r7.getMethodName()     // Catch: java.lang.Exception -> L83
            r4.append(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L83
        L83:
            java.lang.String r4 = com.tencent.imsdk.android.tools.log.FileLogger.PRINT_FILE_FORMAT
            r5 = 5
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r0
            r0 = 1
            r5[r0] = r2
            r0 = 2
            r5[r0] = r10
            r5[r3] = r1
            r10 = 4
            r5[r10] = r11
            java.lang.String r10 = java.lang.String.format(r4, r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.log.FileLogger.decorateMsgForFile(int, java.lang.String):java.lang.String");
    }
}
