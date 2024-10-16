package com.tencent.hawk.bridge;

import android.content.Context;
import android.os.Build;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MetaInfo {
    private static String mAbi = null;
    private static int mBuildInt = 0;
    private static String mBuildStr = null;
    private static int mCpuCore = 0;
    private static int mCpuFreqMax = 0;
    private static int mCpuFreqMin = 0;
    private static long mImei = 0;
    private static boolean mInitFlag = false;
    private static long mIpAddr = 0;
    private static boolean mIsAvm = false;
    private static long mMacAddr = 0;
    private static String mManu = null;
    private static String mModel = null;
    private static int mNetworkType = 0;
    private static int mOsLevel = 0;
    private static String mPkgName = null;
    private static int mRam = 0;
    private static int mRandSeed = 0;
    private static String sAndroidId = null;
    private static String sExtDir = "";

    public static int getRandSeed() {
        return mRandSeed;
    }

    public static void setRandSeed(int i) {
        mRandSeed = i;
    }

    public static long getMacAddr() {
        return mMacAddr;
    }

    public static void setMacAddr(long j) {
        mMacAddr = j;
    }

    public static long getImei() {
        return mImei;
    }

    public static void setImei(long j) {
        mImei = j;
    }

    public static String getPkgName() {
        return mPkgName;
    }

    public static void setPkgName(String str) {
        mPkgName = str;
    }

    public static int getBuildInt() {
        return mBuildInt;
    }

    public static void setBuildInt(int i) {
        mBuildInt = i;
    }

    public static String getBuildStr() {
        return mBuildStr;
    }

    public static void setBuildStr(String str) {
        mBuildStr = str;
    }

    public static String getManu() {
        return mManu;
    }

    public static void setManu(String str) {
        mManu = str;
    }

    public static String getModel() {
        return mModel;
    }

    public static void setModel(String str) {
        mModel = str;
    }

    public static String getAbi() {
        return mAbi;
    }

    public static void setmAbi(String str) {
        mAbi = str;
    }

    public static int getRam() {
        return mRam;
    }

    public static void setRam(int i) {
        mRam = i;
    }

    public static int getCpuCore() {
        return mCpuCore;
    }

    public static void setCpuCore(int i) {
        mCpuCore = i;
    }

    public static int getCpuFreqMax() {
        return mCpuFreqMax;
    }

    public static int getCpuFreqMin() {
        return mCpuFreqMin;
    }

    public static String getAndroidId(Context context) {
        if (sAndroidId == null) {
            sAndroidId = DevPacket.getAndroidId(context);
        }
        return sAndroidId;
    }

    public static int getOsLevel() {
        return mOsLevel;
    }

    public static void setOsLevel(int i) {
        mOsLevel = i;
    }

    public static int getNetworkType() {
        return mNetworkType;
    }

    public static long getIpAddr() {
        return mIpAddr;
    }

    public static boolean isInitSuccessed() {
        return mInitFlag;
    }

    public static long parseMacAddr(String str) {
        if (str == null) {
            return 0L;
        }
        String[] split = str.toUpperCase(Locale.getDefault()).split(CertificateUtil.DELIMITER);
        if (split == null || split.length != 6) {
            return 2L;
        }
        int parseInt = Integer.parseInt(split[0], 16);
        int parseInt2 = Integer.parseInt(split[1], 16);
        return ((Integer.parseInt(split[3], 16) & 255) << 16) | ((Integer.parseInt(split[2], 16) & 255) << 24) | ((parseInt & 255) << 40) | ((parseInt2 & 255) << 32) | ((Integer.parseInt(split[4], 16) & 255) << 8) | (Integer.parseInt(split[5], 16) & 255);
    }

    public static long parseImei(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean isAvm() {
        return mIsAvm;
    }

    public static String toMsg() {
        if (!mInitFlag) {
            return "not initialized";
        }
        return mPkgName + mBuildStr + mManu + mModel + mAbi;
    }

    public static String getExternalFilePath() {
        return sExtDir;
    }

    public static void initMetaCtx(Context context) {
        if (context == null) {
            return;
        }
        mCpuCore = DevPacket.getCpuCoreNum();
        mRam = DevPacket.getMemory();
        mCpuFreqMax = (int) (DevPacket.getCpuFreq(mCpuCore).getLeft().floatValue() * 1000.0f);
        mCpuFreqMin = (int) (DevPacket.getCpuFreq(mCpuCore).getRight().floatValue() * 1000.0f);
        mOsLevel = Build.VERSION.SDK_INT;
        mPkgName = context.getApplicationInfo() == null ? "ERROR" : context.getApplicationInfo().packageName;
        Pair<String, Integer> pkgVersionInfo = DevPacket.getPkgVersionInfo(context);
        mBuildStr = pkgVersionInfo.getLeft();
        mBuildInt = pkgVersionInfo.getRight().intValue();
        mManu = DevPacket.getManu();
        mModel = DevPacket.getModel();
        mAbi = DevPacket.getCpuABI();
        mNetworkType = NetworkUtil.getNetworkState(context);
        mIpAddr = NetworkUtil.getIpAddr();
        mImei = DevPacket.getIMEI(context);
        String macAddr = DevPacket.getMacAddr(context);
        HawkLogger.d(macAddr);
        mMacAddr = parseMacAddr(macAddr);
        if (mPkgName == null) {
            mPkgName = Constant.strError;
        }
        if (mBuildStr == null) {
            mBuildStr = Constant.strError;
        }
        if (mManu == null) {
            mManu = Constant.strError;
        }
        if (mModel == null) {
            mModel = Constant.strError;
        }
        if (mAbi == null) {
            mAbi = Constant.strError;
        }
        if (mManu.equals(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || mManu.contains("iToolsAVM")) {
            mIsAvm = true;
        }
        try {
            File externalFilesDir = context.getExternalFilesDir("");
            if (externalFilesDir != null) {
                sExtDir = externalFilesDir.getPath();
            }
        } catch (Exception unused) {
            sExtDir = "";
        }
        mInitFlag = true;
    }
}
