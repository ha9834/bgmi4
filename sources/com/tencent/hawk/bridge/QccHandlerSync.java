package com.tencent.hawk.bridge;

import android.content.Context;
import android.os.Build;
import com.huawei.game.gamekit.b.a;
import com.tencent.hawk.bridge.GpuInfoHandler;
import com.tencent.hawk.bridge.QCCJudgerMultiVersion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class QccHandlerSync {
    private String mAppId;
    private Context mContext;
    private QCCJudgerMultiVersion.QCCParam mDeviceParam = null;

    public QccHandlerSync(Context context, String str) {
        this.mAppId = null;
        this.mContext = null;
        this.mContext = context;
        this.mAppId = str;
    }

    private void initConfigParam(String str, String str2) {
        this.mDeviceParam = new QCCJudgerMultiVersion.QCCParam();
        this.mDeviceParam.manu = Build.BRAND.trim().toLowerCase(Locale.ENGLISH);
        if (this.mDeviceParam.manu == null) {
            this.mDeviceParam.manu = "na";
        }
        this.mDeviceParam.model = Build.MODEL.trim().toLowerCase(Locale.ENGLISH);
        if (this.mDeviceParam.model == null) {
            this.mDeviceParam.model = "na";
        }
        if (str != null) {
            this.mDeviceParam.gpuVendor = str.trim().toLowerCase(Locale.ENGLISH);
        }
        if (str2 != null) {
            this.mDeviceParam.gpuRenderer = str2.trim().toLowerCase(Locale.ENGLISH);
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
        QCCJudgerMultiVersion.QCCParam qCCParam = this.mDeviceParam;
        qCCParam.socPlat = qCCParam.socPlat.trim().toLowerCase(Locale.ENGLISH);
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

    public synchronized int checkDCLSByQccSync(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT < 11) {
            HawkLogger.e("QccSYNC, SDK_INT less than 11, return 0");
            return -1;
        }
        if (this.mAppId == null) {
            HawkLogger.e("QccSYNC, AppId not set ");
            return -2;
        }
        if (this.mContext == null) {
            HawkLogger.e("QccSYNC, Context not set ");
            return -3;
        }
        QCCFetcherSync qCCFetcherSync = new QCCFetcherSync(this.mContext, this.mAppId);
        if (!qCCFetcherSync.fetchFileWithRedirect()) {
            HawkLogger.e("QccSYNC, cannot fetch or parse target qcc config, return 0");
            return qCCFetcherSync.getErrorCode() * 10;
        }
        if (this.mDeviceParam == null) {
            initConfigParam(str2, str3);
        }
        String fetchedLocalFileName = qCCFetcherSync.getFetchedLocalFileName();
        if (fetchedLocalFileName.equals(a.f5471a)) {
            HawkLogger.e("QccHanlder, invalid file");
            return -4;
        }
        try {
            FileInputStream openFileInput = this.mContext.openFileInput(fetchedLocalFileName);
            QCCJudgerMultiVersion qCCJudgerMultiVersion = new QCCJudgerMultiVersion();
            if (!qCCJudgerMultiVersion.parseQccFile(openFileInput)) {
                HawkLogger.e("QccHanlder, parse file failed");
                this.mContext.deleteFile(fetchedLocalFileName);
                return qCCJudgerMultiVersion.getErrorCode() * 100;
            }
            HashMap hashMap = new HashMap();
            qCCJudgerMultiVersion.judgeDclsBatch(this.mDeviceParam, hashMap);
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            }
            if (hashMap.containsKey(str)) {
                int intValue = hashMap.get(str).intValue();
                this.mContext.deleteFile(fetchedLocalFileName);
                return intValue;
            }
            HawkLogger.e("QccHanlder, ConfigList does not contain target configure: " + str);
            this.mContext.deleteFile(fetchedLocalFileName);
            return -6;
        } catch (FileNotFoundException e) {
            HawkLogger.e("QccHanlder, cannot open asset_qcc_file" + e.getMessage());
            return -5;
        }
    }

    public static boolean isEmulator(String str, String str2) {
        if (str == null || str2 == null || str.equals(Constant.APM_CFG_GPU_NA) || str2.equals(Constant.APM_CFG_GPU_NA)) {
            return false;
        }
        HawkLogger.d("vender : " + str + " renderer:" + str2);
        return HawkNative.checkEmulator(str, str2) > 1;
    }
}
