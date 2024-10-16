package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.shieldtunnel.svpn.common.ErrorCode;
import com.tencent.hawk.bridge.GpuInfoHandler;
import com.tencent.hawk.bridge.QCCJudgerMultiVersion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* loaded from: classes2.dex */
public class QccHandler {
    private String mAppId;
    private Context mContext;
    private QCCFetcher mQccFetcherOnce = null;
    private Map<String, Integer> mSessionCachedQualityMap = null;
    private QCCJudgerMultiVersion.QCCParam mDeviceParam = null;
    private QCCJudgerMultiVersion mJudger = null;

    public QccHandler(Context context, String str) {
        this.mAppId = null;
        this.mContext = null;
        this.mContext = context;
        this.mAppId = str;
    }

    public synchronized int checkDCLSByQcc(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        if (this.mSessionCachedQualityMap != null) {
            if (this.mSessionCachedQualityMap.containsKey(str)) {
                r1 = this.mSessionCachedQualityMap.get(str).intValue();
                HawkLogger.d("find cached quality " + str + " " + r1);
            } else {
                HawkLogger.e("does not find matched config " + str);
                EventDispatcher.dispatchEvent(1011, str);
            }
            HawkLogger.w("Qcc judge value cached: " + str + " " + r1);
            return r1;
        }
        this.mSessionCachedQualityMap = new HashMap();
        if (Build.VERSION.SDK_INT < 11) {
            HawkLogger.e("SDK_INT less than 11, return 0");
            EventDispatcher.dispatchEvent(1002, "Qcc");
            return 0;
        }
        if (this.mAppId == null) {
            HawkLogger.e("AppId not set ");
            EventDispatcher.dispatchEvent(1003, "Qcc");
            return 0;
        }
        if (this.mContext == null) {
            HawkLogger.e("Context not set ");
            EventDispatcher.dispatchEvent(1004, "Qcc");
            return 0;
        }
        if (this.mQccFetcherOnce == null && this.mAppId != null && this.mContext != null) {
            this.mQccFetcherOnce = new QCCFetcher(this.mContext, this.mAppId, Constant.APM_QCC_FILENAME_PREONCE_CACHE, Constant.APM_QCC_FILENAME_PREONCE);
            File fileStreamPath = this.mContext.getFileStreamPath(Constant.APM_QCC_FILENAME_PREONCE);
            boolean checkQccEnable = checkQccEnable();
            HawkLogger.w("qcc enabled status: " + checkQccEnable);
            if (checkQccEnable && fileStreamPath.exists()) {
                this.mQccFetcherOnce.setQccFileReady();
            }
        }
        HawkLogger.d("Begin to check device class");
        if (this.mDeviceParam == null) {
            this.mDeviceParam = new QCCJudgerMultiVersion.QCCParam();
            this.mDeviceParam.manu = Build.BRAND.trim().toLowerCase(Locale.ENGLISH);
            if (this.mDeviceParam.manu == null) {
                this.mDeviceParam.manu = "na";
            }
            this.mDeviceParam.model = Build.MODEL.trim().toLowerCase(Locale.ENGLISH);
            if (this.mDeviceParam.model == null) {
                this.mDeviceParam.model = "na";
            }
            if (str2 != null) {
                this.mDeviceParam.gpuVendor = str2.trim().toLowerCase(Locale.ENGLISH);
            }
            if (str3 != null) {
                this.mDeviceParam.gpuRenderer = str3.trim().toLowerCase(Locale.ENGLISH);
            }
            if (this.mDeviceParam.gpuVendor == null || this.mDeviceParam.gpuRenderer == null) {
                GpuInfoHandler.GpuInfo readGpuInfoByCache = GpuInfoHandler.readGpuInfoByCache(this.mContext);
                if (!readGpuInfoByCache.isValid()) {
                    readGpuInfoByCache = GpuInfoHandler.getGpuInfoByGLES();
                    if (readGpuInfoByCache.isValid()) {
                        GpuInfoHandler.writeGpuInfoInCache(this.mContext, readGpuInfoByCache);
                    }
                }
                this.mDeviceParam.gpuVendor = readGpuInfoByCache.getVendor().trim().toLowerCase(Locale.ENGLISH);
                this.mDeviceParam.gpuRenderer = readGpuInfoByCache.getRender().trim().toLowerCase(Locale.ENGLISH);
            }
            if (this.mDeviceParam.gpuVendor == null) {
                this.mDeviceParam.gpuVendor = "na";
            }
            if (this.mDeviceParam.gpuRenderer == null) {
                this.mDeviceParam.gpuRenderer = "na";
            }
            HawkLogger.w(String.format("Vendor: %s, Render: %s", this.mDeviceParam.gpuVendor, this.mDeviceParam.gpuRenderer));
            this.mDeviceParam.socPlat = HawkNative.getPlatformInfo();
            if (this.mDeviceParam.socPlat != null && this.mDeviceParam.socPlat.equalsIgnoreCase(Constant.APM_CFG_GPU_NA)) {
                this.mDeviceParam.socPlat = DevPacket.getHardwareInfo();
            }
            if (this.mDeviceParam.socPlat == null) {
                this.mDeviceParam.socPlat = "na";
            }
            this.mDeviceParam.socPlat = this.mDeviceParam.socPlat.trim().toLowerCase(Locale.ENGLISH);
            this.mDeviceParam.ram = ((DevPacket.getMemory() + 1023) / 1024) * 1024;
            this.mDeviceParam.cpuCore = DevPacket.getCpuCoreNum();
            Pair<Float, Float> cpuFreq = DevPacket.getCpuFreq(this.mDeviceParam.cpuCore);
            if (this.mAppId.equals("APM_NBORN")) {
                this.mDeviceParam.cpuFreq = (int) (cpuFreq.getRight().floatValue() * 1000.0f);
            } else {
                this.mDeviceParam.cpuFreq = (int) (cpuFreq.getLeft().floatValue() * 1000.0f);
            }
            if (this.mDeviceParam.cpuFreq < 100) {
                this.mDeviceParam.cpuFreq = 3000;
            }
            this.mDeviceParam.resolution = DevPacket.getMaxPixelsInDpy(this.mContext);
            HawkLogger.d(this.mDeviceParam.toString());
        }
        FileInputStream fileInputStream2 = null;
        if (this.mQccFetcherOnce != null && this.mQccFetcherOnce.checkQccFileReady() && FileUtil.checkFileExists(this.mContext, Constant.APM_QCC_FILENAME_PREONCE)) {
            HawkLogger.d("local tmp once file exists");
            FileUtil.cpFileWithCtx(this.mContext, Constant.APM_QCC_FILENAME_PREONCE, Constant.APM_QCC_FINALLY);
            FileUtil.cpFileWithCtx(this.mContext, Constant.APM_QCC_FILENAME_PREONCE, Constant.APM_QCC_FILENAME);
            if (!this.mContext.getFileStreamPath(Constant.APM_QCC_FILENAME_PREONCE).delete()) {
                HawkLogger.e("Delete APM_QCC_FILENAME_PREONCE file failed");
                EventDispatcher.dispatchEvent(1005, "Qcc");
            }
            HawkLogger.d("Use qcc file");
            try {
                fileInputStream = this.mContext.openFileInput(Constant.APM_QCC_FILENAME);
            } catch (FileNotFoundException unused) {
                HawkLogger.e("open apm_qcc failed ");
                EventDispatcher.dispatchEvent(1006, "Qcc");
                fileInputStream = null;
            }
        } else {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            try {
                HawkLogger.d("Use local finally file");
                fileInputStream = this.mContext.openFileInput(Constant.APM_QCC_FINALLY);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                HawkLogger.e("open apm_qcc_finally failed");
                EventDispatcher.dispatchEvent(1007, "Qcc");
                fileInputStream = null;
            }
        }
        if (fileInputStream == null) {
            HawkLogger.e("open apm_qcc_finally failed, return cached quality");
            if (!QCCFetcher.isQccFileFetchInSession && this.mQccFetcherOnce != null) {
                EventDispatcher.dispatchEvent(1008, "Qcc");
                this.mQccFetcherOnce.asynFetchQcc(0);
            }
            return 0;
        }
        if (this.mJudger == null) {
            this.mJudger = new QCCJudgerMultiVersion();
            if (!this.mJudger.parseQccFile(fileInputStream)) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                EventDispatcher.dispatchEvent(ErrorCode.INTERNAL_ERROR, "Qcc");
                HawkLogger.i("PARSE QCC FILE ERROR");
                FileUtil.cpAssetFile(this.mContext, Constant.QUALITY_CONTROL_PREFIX + this.mAppId, Constant.APM_QCC_FINALLY);
                this.mJudger.clearContext();
                try {
                    HawkLogger.d("USE PACKED FILE");
                    fileInputStream2 = this.mContext.openFileInput(Constant.APM_QCC_FINALLY);
                } catch (FileNotFoundException unused3) {
                    HawkLogger.e("open apm_qcc_finally failed");
                    EventDispatcher.dispatchEvent(1018, "Qcc");
                }
                if (fileInputStream2 == null) {
                    HawkLogger.e("PACKET FILE NULL ERROR, DEFAULT: 0");
                    EventDispatcher.dispatchEvent(1022, "Qcc");
                    if (!QCCFetcher.isQccFileFetchInSession && this.mQccFetcherOnce != null) {
                        this.mQccFetcherOnce.asynFetchQcc(0);
                    }
                    return 0;
                }
                if (!this.mJudger.parseQccFile(fileInputStream2)) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    HawkLogger.e("Parse file failed");
                    EventDispatcher.dispatchEvent(ErrorCode.SOCKET_ERROR, "Qcc");
                    if (!QCCFetcher.isQccFileFetchInSession && this.mQccFetcherOnce != null) {
                        this.mQccFetcherOnce.asynFetchQcc(0);
                        EventDispatcher.dispatchEvent(ErrorCode.SOCKET_REGISTER_ERROR, "Qcc");
                    }
                    return 0;
                }
                fileInputStream = fileInputStream2;
            }
            int qccVersion = this.mJudger.getQccVersion();
            if (!QCCFetcher.isQccFileFetchInSession && this.mQccFetcherOnce != null) {
                this.mQccFetcherOnce.asynFetchQcc(qccVersion);
            }
        }
        this.mJudger.judgeDclsBatch(this.mDeviceParam, this.mSessionCachedQualityMap);
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
        }
        r1 = this.mSessionCachedQualityMap.containsKey(str) ? this.mSessionCachedQualityMap.get(str).intValue() : 0;
        HawkLogger.w("Qcc judge value : " + str + " " + r1);
        return r1;
    }

    private synchronized boolean checkQccEnable() {
        if (this.mContext == null) {
            return false;
        }
        int nextInt = (new Random().nextInt() % 100) - 1;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences != null) {
            return nextInt <= 100 - sharedPreferences.getInt(Constant.APM_QCC_GRAY_KEY, 0);
        }
        HawkLogger.e("apm cfg shared prefs is null");
        return false;
    }

    public static boolean isEmulator(String str, String str2) {
        if (str == null || str2 == null || str.equals(Constant.APM_CFG_GPU_NA) || str2.equals(Constant.APM_CFG_GPU_NA)) {
            return false;
        }
        HawkLogger.d("vender : " + str + " renderer:" + str2);
        return HawkNative.checkEmulator(str, str2) > 1;
    }
}
