package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes2.dex */
public class CC {
    private static final int MASK_SEG_LEN = 15;
    public static boolean extEnabled = false;
    public static boolean isTApmEnabled = true;
    private static int sApmVersion = 0;
    private static String sArch = null;
    private static int sBlockMask = -1;
    private static int sCfgVersion = 0;
    private static int sFBCheckFuncGray = 0;
    private static int sGameVersion = 0;
    private static long sIpAddr = 0;
    private static long sMacAddr = 0;
    private static String sManu = null;
    private static String sModel = null;
    private static int sOslevel = 0;
    private static int sPssManualMode = 0;
    private static int sVmpStatusSwitch = 1;
    private static Strategy sCCStrategy = new Strategy();
    private static CC sInstance = null;

    /* loaded from: classes2.dex */
    public static class Strategy {
        private int sFileBuffer = 0;
        private int sNativePssIntervals = 0;
        private int sJavaPssIntervals = 0;
        private int sJavaLevelPssGrayRand = 100;
        private int sZipZagGrayRand = 100;
        private int sFlashExternalInfoRand = 0;
        private int sTencentQemuHardwareRandBlock = 0;
        public boolean isBatteryEnabled = true;
        public boolean isLifecycleEnabled = true;
        public boolean isStepEventEnabled = true;
        public boolean isCoordinatetEnabled = true;
        public int mCpuFreqInterval = 1;
        public int mStartupTimeGraySeed = 100;

        public boolean isExternalFlashInfoEnabled() {
            int random = ((int) (Math.random() * 100.0d)) + 1;
            HawkLogger.d("External Flash Seed is :" + this.sFlashExternalInfoRand + " " + random);
            return random < this.sFlashExternalInfoRand;
        }

        public boolean ismStartupTimeEnabled() {
            return ((int) (Math.random() * 100.0d)) - 1 < this.mStartupTimeGraySeed;
        }

        public int getVbufferSz() {
            return this.sFileBuffer * 32;
        }

        public int getCpuFreqIntervals() {
            return this.mCpuFreqInterval;
        }

        public int getNativePssIntervals() {
            int i = this.sNativePssIntervals;
            if (i >= 10) {
                return 1;
            }
            return i * 16;
        }

        public int getJavaPssIntervals() {
            int i = this.sJavaPssIntervals;
            if (i == 0) {
                return 16;
            }
            if (i >= 10) {
                return 1;
            }
            return i * 16;
        }

        public int getBatteryFetchIntervals() {
            int i = this.sJavaPssIntervals;
            if (i == 0) {
                return 5;
            }
            if (i >= 10) {
                return 1;
            }
            return i * 16;
        }

        public boolean isJavaLevelPssEnabled() {
            return ((int) (Math.random() * 100.0d)) < this.sJavaLevelPssGrayRand;
        }

        public boolean isZigzagCompressEnabled() {
            return ((int) (Math.random() * 100.0d)) < this.sZipZagGrayRand;
        }

        public boolean isCCBatteryEnabled() {
            return this.isBatteryEnabled;
        }

        public boolean isCCLifecycleEnabled() {
            return this.isLifecycleEnabled;
        }

        public boolean isCCStepEventEnabled() {
            return this.isStepEventEnabled;
        }

        public boolean isCCCoordinatetEnabled() {
            return this.isCoordinatetEnabled;
        }

        public boolean isTencentQemuHardwareBlocked() {
            return ((int) (Math.random() * 100.0d)) < this.sTencentQemuHardwareRandBlock;
        }

        public String toString() {
            return "CCstrategy: \nsFileBuffer: " + this.sFileBuffer + "\nNativePssIntervals: " + this.sNativePssIntervals + "\nsJavaPssIntervals: " + this.sJavaPssIntervals + "\nsJavaLevelPssRand: " + this.sJavaLevelPssGrayRand + "\nsZipZagGray: " + this.sZipZagGrayRand + "\nsFlashExternalInfoRand: " + this.sFlashExternalInfoRand + "\nisBatteryEnabled: " + this.isBatteryEnabled + "\nisLifecycleEnabled: " + this.isLifecycleEnabled + "\nisStepEventEnabled: " + this.isStepEventEnabled + "\nisCoordinatetEnabled: " + this.isCoordinatetEnabled + "\n";
        }
    }

    public static Strategy getStrategy() {
        return sCCStrategy;
    }

    public static int getFBCheckGray() {
        return sFBCheckFuncGray;
    }

    public static int getBlockMask() {
        return sBlockMask;
    }

    public static int getCfgVersion() {
        return sCfgVersion;
    }

    public static void initCC(String str, String str2, String str3, long j, long j2, int i, int i2, int i3) {
        sManu = str;
        sModel = str2;
        sArch = str3;
        sMacAddr = j;
        sIpAddr = j2;
        sGameVersion = i;
        sApmVersion = i2;
        sOslevel = i3;
    }

    public static boolean isCCfileExisted(Context context, String str) {
        File fileStreamPath;
        return (context == null || (fileStreamPath = context.getFileStreamPath(Constant.CFG_NAME)) == null || !fileStreamPath.exists()) ? false : true;
    }

    public static String readCCIden(Context context) {
        if (new File(Constant.APM_AL_FILE).exists()) {
            HawkLogger.e("===========FOUND APM_CC in TMP==========");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.APM_AL_FILE)));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    HawkLogger.e(e.getMessage());
                                }
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            HawkLogger.e(e2.getMessage());
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                HawkLogger.e(e3.getMessage());
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            HawkLogger.e(e4.getMessage());
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                return sb.toString();
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
                HawkLogger.e(e5.getMessage());
                return null;
            }
        }
        try {
            FileInputStream openFileInput = context.openFileInput(Constant.CFG_NAME);
            if (openFileInput == null) {
                return null;
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(openFileInput));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                try {
                    try {
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 != null) {
                            sb2.append(readLine2);
                        } else {
                            try {
                                break;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                HawkLogger.e(e6.getMessage());
                            }
                        }
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        HawkLogger.e(e7.getMessage());
                        try {
                            bufferedReader2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            HawkLogger.e(e8.getMessage());
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        HawkLogger.e(e9.getMessage());
                    }
                    throw th2;
                }
            }
            bufferedReader2.close();
            return sb2.toString();
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            HawkLogger.e(e10.getMessage());
            return null;
        }
    }

    public static boolean isMaskValid(String str) {
        String[] split;
        int i;
        if (str == null || (split = str.toString().split(";")) == null || split.length != 15) {
            return false;
        }
        try {
            long parseLong = Long.parseLong(split[14]);
            int lastIndexOf = str.lastIndexOf(";");
            return lastIndexOf != -1 && str.length() > (i = lastIndexOf + 1) && HashGen.oneWayHash(str.substring(0, i), 3) == parseLong;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isVmpStatusPostEnabled() {
        return sVmpStatusSwitch == 0;
    }

    public static boolean isPssManualModeEnabled() {
        return sPssManualMode == 0;
    }

    private static boolean isFirstLaunch(Context context) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences == null || sharedPreferences.getInt(Constant.APM_INITIAL_LAUNCH, 0) != 0 || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        edit.putInt(Constant.APM_INITIAL_LAUNCH, 1);
        edit.commit();
        return true;
    }

    public static boolean checkHawkEnabled(Context context, String str, String str2, String str3) {
        int i;
        int i2;
        boolean z;
        int random;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null) {
            return false;
        }
        if (isFirstLaunch(context) && !isCCfileExisted(context, str)) {
            HawkLogger.e("=====first luanch====");
            sBlockMask = 112;
            sFBCheckFuncGray = 32512;
            String str4 = Build.MODEL;
            return str4 == null || !(str4.equalsIgnoreCase("goodgrades") || str4.equalsIgnoreCase("Le X820") || str4.equalsIgnoreCase("MuMu"));
        }
        if (!isCCfileExisted(context, str)) {
            HawkLogger.e("cc file not found");
            return false;
        }
        String readCCIden = readCCIden(context);
        if (readCCIden == null || readCCIden.length() == 0) {
            HawkLogger.e("ccIden is null or length is 0");
            return false;
        }
        HawkLogger.i("CCIden : " + readCCIden);
        if (!isMaskValid(readCCIden)) {
            HawkLogger.e("mask invalid");
            return false;
        }
        String[] split = readCCIden.split(";");
        if (split == null) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            int i3 = parseInt2 & 255;
            int i4 = (parseInt2 >> 16) & 255;
            sPssManualMode = (i4 >> 3) & 1;
            sVmpStatusSwitch = (i4 >> 4) & 1;
            int parseInt3 = Integer.parseInt(split[2]);
            int parseInt4 = Integer.parseInt(split[12]);
            int parseInt5 = Integer.parseInt(split[13]);
            sFBCheckFuncGray = parseInt;
            int i5 = (sFBCheckFuncGray >> 16) & 255;
            HawkLogger.d("qcc blocker value: " + i5);
            if (i5 != 0 && context != null && (sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
                edit.putInt(Constant.APM_QCC_GRAY_KEY, i5);
                edit.commit();
            }
            int i6 = 100 - ((sFBCheckFuncGray >> 24) & 255);
            int i7 = i6 < 0 ? 0 : i6;
            HawkLogger.d("Emulator gray : " + i7);
            String str5 = split[3];
            String str6 = split[4];
            String str7 = split[5];
            String str8 = split[6];
            String str9 = split[7];
            String str10 = split[8];
            String str11 = split[9];
            String str12 = split[10];
            String str13 = split[11];
            if (str11 != null) {
                try {
                    i = Integer.parseInt(str11);
                } catch (Exception e) {
                    HawkLogger.e("Mac Seed Parse Error " + e.getMessage());
                    i = 0;
                }
                int i8 = i & 255;
                sCCStrategy.sFileBuffer = i8 & 15;
                int i9 = (i8 >> 4) & 15;
                sCCStrategy.isBatteryEnabled = (i9 & 1) == 0;
                sCCStrategy.isLifecycleEnabled = ((i9 >> 1) & 1) == 0;
                sCCStrategy.isStepEventEnabled = ((i9 >> 2) & 1) == 0;
                sCCStrategy.isCoordinatetEnabled = ((i9 >> 3) & 1) == 0;
                int i10 = (i >> 8) & 255;
                sCCStrategy.sJavaPssIntervals = i10 & 15;
                sCCStrategy.sNativePssIntervals = (i10 >> 4) & 15;
                sCCStrategy.sZipZagGrayRand = 100 - ((i >> 16) & 255);
                sCCStrategy.sJavaLevelPssGrayRand = 100 - ((i >> 24) & 255);
            }
            if (str5 != null) {
                try {
                    sCCStrategy.mStartupTimeGraySeed = 100 - Integer.parseInt(str5);
                } catch (Exception e2) {
                    HawkLogger.e("parse startup time seed error: " + e2.getMessage());
                }
            }
            if (str9 != null) {
                try {
                    sCCStrategy.mCpuFreqInterval = Integer.parseInt(str9);
                    if (sCCStrategy.mCpuFreqInterval == 0) {
                        sCCStrategy.mCpuFreqInterval = 2;
                    }
                } catch (Exception e3) {
                    HawkLogger.e("parse cpu freq interval error: " + e3.getMessage());
                }
            }
            if (str10 != null) {
                try {
                    i2 = Integer.parseInt(str10);
                } catch (Exception unused) {
                    i2 = 0;
                }
                sCCStrategy.sFlashExternalInfoRand = (i2 >> 8) & 255;
                sCCStrategy.sTencentQemuHardwareRandBlock = (i2 >> 16) & 255;
            }
            HawkLogger.d("x86Gray : " + i3);
            HawkLogger.i(sCCStrategy.toString());
            if (parseInt3 < 0 || parseInt3 >= 512) {
                return false;
            }
            sBlockMask = parseInt3;
            CCMask.initCCMask(parseInt5);
            if (!CCMask.isGrayEnabled()) {
                HawkLogger.e("gray disabled");
                return false;
            }
            if (CCMask.isOsVersionEnabled() && ActionCtrl.isOSVersionBlk(str6, sOslevel)) {
                HawkLogger.e("os Version disabled");
                return false;
            }
            if (CCMask.isManuEnabled() && ActionCtrl.isManuBlk(str7, sManu)) {
                HawkLogger.e("manu disabled");
                return false;
            }
            if (CCMask.isModelEnabled() && ActionCtrl.isModelBlk(str8, sModel)) {
                HawkLogger.e("model disabled");
                return false;
            }
            String str14 = sArch;
            if (str14 != null && str14.toLowerCase(Locale.getDefault()).contains("x86")) {
                int random2 = (int) (Math.random() * 100.0d);
                HawkLogger.w("x86 seed is " + random2 + ", x86 pb set is " + i3);
                if (random2 < i3) {
                    HawkLogger.w("x86 rand enabled");
                    return true;
                }
                HawkLogger.w("x86 rand disabled");
                return false;
            }
            if (i7 < 100 && QccHandler.isEmulator(str2, str3) && (random = (int) (Math.random() * 100.0d)) < i7) {
                HawkLogger.e("Emulator blocked " + random + " " + i7);
                return false;
            }
            if (CCMask.isRandPbEnabled()) {
                int random3 = (int) (Math.random() * 100.0d);
                HawkLogger.w("seed is " + random3 + ", pb set is " + parseInt4);
                if (random3 < parseInt4) {
                    HawkLogger.w("rand enabled");
                    return true;
                }
                z = true;
            } else {
                z = true;
            }
            if (CCMask.isGrayManuEnabled() && ActionCtrl.isGrayManu(str12, sManu)) {
                HawkLogger.w("manu enabled");
                return z;
            }
            if (CCMask.isGrayModelEnabled() && ActionCtrl.isGrayModel(str13, sModel)) {
                HawkLogger.w("model enabled");
                return z;
            }
            HawkLogger.w("AB disabled");
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            HawkLogger.e("number pasre exception");
            return false;
        }
    }

    private CC() {
    }

    public static CC getInstance() {
        if (sInstance == null) {
            sInstance = new CC();
        }
        return sInstance;
    }
}
