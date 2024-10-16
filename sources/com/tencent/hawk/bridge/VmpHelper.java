package com.tencent.hawk.bridge;

import android.content.Context;
import com.huawei.game.gamekit.b.a;
import com.tdatamaster.tdm.device.DeviceInfoName;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class VmpHelper {
    public static final int APM_KEY = 9;
    public static final int DynamicSetting = 6;
    public static final int FpsDirty = 1;
    public static final int GPU_FAMILY = 10;
    public static final int HighFrameMode = 4;
    public static final int MapID = 0;
    public static final int MatchState = 5;
    public static final int MobileType = 8;
    public static final int PicQuality = 2;
    public static final int Resolution = 3;
    private static final String TGPACALLBACK = "com.tencent.vmp.GCallback";
    private static final int TGPAKeyRequestResource = 4;
    private static final String TGPAMAINENTRY = "com.tencent.kgvmp.PerformanceAdjuster";
    public static final int UserCount = 7;
    private static final int VMP_DEVICE_IDEN = 12;
    private static final int VMP_SDK_TYPE = 13;
    private static final int VMP_STATUS_CALLBACK = 11;
    private static final int VMP_STATUS_GUARANTEE_STEP = 7;
    private static boolean isDeviceIdenSet = false;
    private static boolean isSDKTypeSet = false;
    private static boolean isTGPAEnabled = false;
    private static Method sCheckDeviceIsRealMethod = null;
    private static Method sGetDataFromTGPAMethod = null;
    private static Method sGetIdenMethod = null;
    private static Method sGetNativeSDKNameMethod = null;
    private static Method sGetOptCfgStrMethod = null;
    public static boolean sIsTGPAInit = false;
    private static Class<?> sTGPAClass = null;
    private static String sTGPAGpuInfo = "NA";
    private static Object sTGPAInstance = null;
    private static Method sUpdateGameInfoIS = null;
    private static Method sUpdateGameInfoSS = null;
    private static final String tgpaFPSKey = "FPS";
    private static Object conditionObject = new Object();
    private static volatile int threadNeedSleep = 0;

    /* loaded from: classes2.dex */
    public enum ENGINE {
        UNITY,
        UNRAL
    }

    /* loaded from: classes2.dex */
    private static class Reflection {
        private Reflection() {
        }

        private static Object getStaticField(String str, String str2, Object obj) {
            Field declaredField;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null || (declaredField = cls.getDeclaredField(str2)) == null) {
                    return null;
                }
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        private static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) {
            Method declaredMethod;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null || (declaredMethod = cls.getDeclaredMethod(str2, clsArr)) == null) {
                    return null;
                }
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                HawkLogger.e("ClassNotFoundException " + e.getMessage());
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                HawkLogger.e("localIllegalAccessException " + e2.getMessage());
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                HawkLogger.e("localNoSuchMethodException " + e3.getMessage());
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                HawkLogger.e("localInvocationTargetException " + e4.getMessage());
                return null;
            } catch (Exception e5) {
                e5.printStackTrace();
                HawkLogger.e("localException " + e5.getMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object newInstance(String str, Object[] objArr, Class<?>[] clsArr) {
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null) {
                    return null;
                }
                if (objArr == null) {
                    return cls.newInstance();
                }
                Constructor<?> constructor = cls.getConstructor(clsArr);
                if (constructor == null) {
                    return null;
                }
                return constructor.newInstance(objArr);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                HawkLogger.e("Ref ClassNotFoundException");
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                HawkLogger.e("Ref IllegalAccessException");
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                HawkLogger.e("Ref InstantiationException");
                return null;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                HawkLogger.e("Ref NoSuchMethodException");
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                HawkLogger.e("Ref InvocationTargetException");
                return null;
            } catch (Exception e6) {
                e6.printStackTrace();
                HawkLogger.e("Ref other exception");
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postVmpStatusLocked(int i, int i2, int i3, int i4, String str) {
        if (CC.isVmpStatusPostEnabled()) {
            HawkNative.postVmpStatus(i, i2, i3, i4, str);
        }
    }

    public static void notifyThreadAwake() {
        if (isTGPAEnabled && sIsTGPAInit) {
            HawkLogger.w("begin to notify awake");
            if (threadNeedSleep == 1) {
                synchronized (conditionObject) {
                    if (threadNeedSleep == 1) {
                        threadNeedSleep = 0;
                        conditionObject.notify();
                    }
                }
                return;
            }
            HawkLogger.w("current thread is awake");
        }
    }

    public static void notifyThreadSleep() {
        if (isTGPAEnabled) {
            HawkLogger.w("begin to notify sleep");
            synchronized (conditionObject) {
                threadNeedSleep = 1;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class TGPAFpsReporter implements Runnable {
        private Method mFpsReportMethod;
        private Class<?> mPfaClass;
        private Object mPfaInstance;

        public TGPAFpsReporter(Class<?> cls, Object obj) {
            this.mPfaClass = null;
            this.mPfaInstance = null;
            this.mFpsReportMethod = null;
            this.mPfaClass = cls;
            this.mPfaInstance = obj;
            try {
                this.mFpsReportMethod = this.mPfaClass.getDeclaredMethod("updateGameInfo", String.class, String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                HawkLogger.e("cannot find setFpsDataReport " + e.getMessage());
                this.mFpsReportMethod = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VmpHelper.isTGPAEnabled) {
                if (this.mFpsReportMethod == null) {
                    HawkLogger.e("FpsReportMethod is null");
                    return;
                }
                int i = 0;
                while (this.mFpsReportMethod != null && CC.isTApmEnabled) {
                    if (VmpHelper.threadNeedSleep == 1) {
                        synchronized (VmpHelper.conditionObject) {
                            try {
                                try {
                                    HawkLogger.w("VMP Report FPS sleep");
                                    while (VmpHelper.threadNeedSleep == 1) {
                                        VmpHelper.conditionObject.wait();
                                    }
                                    HawkLogger.w("VMP Report FPS thread awake");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                    int frames = HawkNative.getFrames();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    int frames2 = HawkNative.getFrames();
                    i = frames == frames2 ? i + 1 : 0;
                    if (i > 10) {
                        HawkLogger.w("fps is consecutive Zeros");
                        return;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 0) {
                        int i2 = frames2 - frames;
                        float f = i2 / (((float) currentTimeMillis2) / 1000.0f);
                        if (i2 > 0) {
                            try {
                                this.mFpsReportMethod.invoke(this.mPfaInstance, VmpHelper.tgpaFPSKey, String.valueOf(f));
                                HawkLogger.d("begin to ayncUploadFPS :" + f);
                            } catch (IllegalAccessException e3) {
                                e3.printStackTrace();
                                return;
                            } catch (IllegalArgumentException e4) {
                                e4.printStackTrace();
                                return;
                            } catch (InvocationTargetException e5) {
                                e5.printStackTrace();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        HawkLogger.e("TGPAFpsReporter time error");
                    }
                }
            }
        }
    }

    private static boolean checkTGPAEnabled(String str) {
        if (sTGPAClass != null && sTGPAInstance != null && isTGPAEnabled) {
            return true;
        }
        HawkLogger.e("TGPA is not inited: " + str);
        return false;
    }

    public static String getDataFromTGPA(String str, String str2) {
        if (!checkTGPAEnabled("getDataFromTGPA")) {
            return Constant.APM_CFG_GPU_NA;
        }
        if (sGetDataFromTGPAMethod == null) {
            try {
                sGetDataFromTGPAMethod = sTGPAClass.getDeclaredMethod("getDataFromTGPA", String.class, String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                HawkLogger.e("cannot reflect getDataFromTGPA");
                return Constant.APM_CFG_GPU_NA;
            }
        }
        Method method = sGetDataFromTGPAMethod;
        if (method == null) {
            return Constant.APM_CFG_GPU_NA;
        }
        try {
            Object invoke = method.invoke(sTGPAInstance, str, str2);
            return invoke != null ? String.valueOf(invoke) : Constant.APM_CFG_GPU_NA;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            e2.printStackTrace();
            HawkLogger.e("cannot invoke sGetDataFromTGPAMethod");
            return Constant.APM_CFG_GPU_NA;
        }
    }

    public static String getXid() {
        if (sTGPAClass == null) {
            try {
                sTGPAClass = Class.forName(TGPAMAINENTRY);
            } catch (ClassNotFoundException e) {
                HawkLogger.e("Cannot reflect PerformanceAdjuster: " + e.getMessage());
            }
        }
        Class<?> cls = sTGPAClass;
        if (cls == null) {
            HawkLogger.e("cannot find: com.tencent.kgvmp.PerformanceAdjuster");
            return Constant.APM_CFG_GPU_NA;
        }
        if (sGetDataFromTGPAMethod == null) {
            try {
                sGetDataFromTGPAMethod = cls.getDeclaredMethod("getDataFromTGPA", String.class, String.class);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                HawkLogger.e("cannot reflect getDataFromTGPA");
                return Constant.APM_CFG_GPU_NA;
            }
        }
        if (sGetDataFromTGPAMethod == null) {
            return Constant.APM_CFG_GPU_NA;
        }
        sTGPAInstance = Reflection.newInstance(TGPAMAINENTRY, new Object[0], new Class[0]);
        Object obj = sTGPAInstance;
        if (obj == null) {
            HawkLogger.e("TGPAInstance is NULL");
            return Constant.APM_CFG_GPU_NA;
        }
        try {
            Object invoke = sGetDataFromTGPAMethod.invoke(obj, "XID", "");
            return invoke != null ? String.valueOf(invoke) : Constant.APM_CFG_GPU_NA;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            e3.printStackTrace();
            HawkLogger.e("cannot invoke GetDataFromTGPAMethod");
            return Constant.APM_CFG_GPU_NA;
        }
    }

    public static String getOAID() {
        if (sTGPAClass == null) {
            try {
                sTGPAClass = Class.forName(TGPAMAINENTRY);
            } catch (ClassNotFoundException e) {
                HawkLogger.e("Cannot reflect PerformanceAdjuster: " + e.getMessage());
            }
        }
        Class<?> cls = sTGPAClass;
        if (cls == null) {
            HawkLogger.e("cannot find: com.tencent.kgvmp.PerformanceAdjuster");
            return Constant.APM_CFG_GPU_NA;
        }
        if (sGetDataFromTGPAMethod == null) {
            try {
                sGetDataFromTGPAMethod = cls.getDeclaredMethod("getDataFromTGPA", String.class, String.class);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                HawkLogger.e("cannot reflect getDataFromTGPA");
                return Constant.APM_CFG_GPU_NA;
            }
        }
        if (sGetDataFromTGPAMethod == null) {
            return Constant.APM_CFG_GPU_NA;
        }
        sTGPAInstance = Reflection.newInstance(TGPAMAINENTRY, new Object[0], new Class[0]);
        Object obj = sTGPAInstance;
        if (obj == null) {
            HawkLogger.e("TGPAInstance is NULL");
            return Constant.APM_CFG_GPU_NA;
        }
        try {
            Object invoke = sGetDataFromTGPAMethod.invoke(obj, DeviceInfoName.OAID_STRING, "");
            return invoke != null ? String.valueOf(invoke) : Constant.APM_CFG_GPU_NA;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            e3.printStackTrace();
            HawkLogger.e("cannot invoke GetDataFromTGPAMethod");
            return Constant.APM_CFG_GPU_NA;
        }
    }

    public static void initTGPA(Context context) {
        if (context == null) {
            return;
        }
        if (sTGPAClass == null) {
            try {
                sTGPAClass = Class.forName(TGPAMAINENTRY);
            } catch (ClassNotFoundException e) {
                HawkLogger.e("Cannot reflect PerformanceAdjuster: " + e.getMessage());
            }
        }
        if (sTGPAClass == null) {
            HawkLogger.e("cannot find: com.tencent.kgvmp.PerformanceAdjuster");
            return;
        }
        if (sTGPAInstance == null) {
            sTGPAInstance = Reflection.newInstance(TGPAMAINENTRY, new Object[0], new Class[0]);
        }
        if (sTGPAInstance == null) {
            HawkLogger.e("TGPAInstance is NULL");
            return;
        }
        try {
            Method declaredMethod = sTGPAClass.getDeclaredMethod("init", Context.class, String.class);
            if (declaredMethod == null) {
                return;
            }
            try {
                declaredMethod.invoke(sTGPAInstance, context, "apm");
                isTGPAEnabled = true;
                updateGameInfoToTGPASS("GPU", sTGPAGpuInfo);
                try {
                    Method declaredMethod2 = sTGPAClass.getDeclaredMethod("checkSdkCanWork", new Class[0]);
                    if (declaredMethod2 == null) {
                        return;
                    }
                    try {
                        Object invoke = declaredMethod2.invoke(sTGPAInstance, new Object[0]);
                        if (invoke != null) {
                            if (Boolean.parseBoolean(String.valueOf(invoke))) {
                                Thread thread = new Thread(new TGPAFpsReporter(sTGPAClass, sTGPAInstance));
                                thread.setName("VmpFpsThread");
                                thread.start();
                                HawkLogger.w("TGPA ENABLED, Start TGPA Thread");
                                return;
                            }
                            HawkLogger.w("TGPA not work");
                            return;
                        }
                        HawkLogger.w("No TGPA Thread");
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                        HawkLogger.e("cannot invoke checkSdkCanWork");
                    }
                } catch (NoSuchMethodException unused2) {
                    HawkLogger.e("Cannot reflect checkSdkCanWork");
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                e2.printStackTrace();
                HawkLogger.e("Cannot invoke TGPA init");
            }
        } catch (NoSuchMethodException unused3) {
            HawkLogger.e("Cannot reflect TGPAinit");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0062 A[Catch: InvocationTargetException -> 0x00c8, IllegalArgumentException -> 0x00ca, IllegalAccessException -> 0x00cc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, TryCatch #4 {IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, blocks: (B:21:0x0054, B:23:0x0062, B:25:0x0068, B:27:0x006c, B:28:0x0075, B:30:0x007d, B:35:0x008d, B:36:0x0094, B:38:0x00ba), top: B:20:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[Catch: InvocationTargetException -> 0x00c8, IllegalArgumentException -> 0x00ca, IllegalAccessException -> 0x00cc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, TryCatch #4 {IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, blocks: (B:21:0x0054, B:23:0x0062, B:25:0x0068, B:27:0x006c, B:28:0x0075, B:30:0x007d, B:35:0x008d, B:36:0x0094, B:38:0x00ba), top: B:20:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d A[Catch: InvocationTargetException -> 0x00c8, IllegalArgumentException -> 0x00ca, IllegalAccessException -> 0x00cc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, TryCatch #4 {IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, blocks: (B:21:0x0054, B:23:0x0062, B:25:0x0068, B:27:0x006c, B:28:0x0075, B:30:0x007d, B:35:0x008d, B:36:0x0094, B:38:0x00ba), top: B:20:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[Catch: InvocationTargetException -> 0x00c8, IllegalArgumentException -> 0x00ca, IllegalAccessException -> 0x00cc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, TRY_LEAVE, TryCatch #4 {IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00ce, blocks: (B:21:0x0054, B:23:0x0062, B:25:0x0068, B:27:0x006c, B:28:0x0075, B:30:0x007d, B:35:0x008d, B:36:0x0094, B:38:0x00ba), top: B:20:0x0054 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean registerTGPACallback(final com.tencent.hawk.bridge.VmpHelper.ENGINE r7, final com.tencent.hawk.bridge.VmpGCallbackWrapper r8) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.VmpHelper.registerTGPACallback(com.tencent.hawk.bridge.VmpHelper$ENGINE, com.tencent.hawk.bridge.VmpGCallbackWrapper):boolean");
    }

    public static void tgpaUpdateGameInfo(int i, String str) {
        String str2;
        if (i == 10) {
            sTGPAGpuInfo = str;
        }
        if (checkTGPAEnabled("tgpaUpdateGameInfo")) {
            if (str == null) {
                str = a.f5471a;
            }
            HawkLogger.d("Try to setDataReport " + i + " " + str);
            switch (i) {
                case 0:
                    str2 = "MapID";
                    break;
                case 1:
                    str2 = "FpsDirty";
                    break;
                case 2:
                    str2 = "PicQuality";
                    break;
                case 3:
                    str2 = "Resolution";
                    break;
                case 4:
                    str2 = "HighFrameMode";
                    break;
                case 5:
                    str2 = "MatchState";
                    break;
                case 6:
                    str2 = "DynamicSetting";
                    break;
                case 7:
                    str2 = "UserCount";
                    break;
                case 8:
                    str2 = "MobileType";
                    break;
                case 9:
                    str2 = "apmKey";
                    break;
                case 10:
                    str2 = "GPU";
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (str2 == null) {
                str2 = String.valueOf(i);
            }
            if (str2 == null) {
                HawkLogger.e("key is null " + i);
                return;
            }
            updateGameInfoToTGPASS(str2, str);
        }
    }

    private static void setVmpStatus() {
        if (isTGPAEnabled) {
            if (!isDeviceIdenSet) {
                postVmpStatusLocked(12, 0, 0, 0, getTGPADeviceIden());
                isDeviceIdenSet = true;
            }
            if (isSDKTypeSet) {
                return;
            }
            postVmpStatusLocked(13, 0, 0, 0, getVmpSDKName());
            isSDKTypeSet = true;
        }
    }

    public static void requestResourceGuarantee(int i) {
        if (checkTGPAEnabled("RequestResourceGuarantee")) {
            setVmpStatus();
            postVmpStatusLocked(7, i, 0, 0, null);
            HawkLogger.d("try to requestResourceGuarantee " + i);
            updateGameInfoToTGPAIS(4, String.valueOf(i));
        }
    }

    public static String getTGPADeviceIden() {
        if (!checkTGPAEnabled("GetTGPADeviceIden")) {
            return Constant.APM_CFG_GPU_NA;
        }
        if (sGetIdenMethod == null) {
            try {
                sGetIdenMethod = sTGPAClass.getDeclaredMethod("getVmpNumber", new Class[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                HawkLogger.e("cannot reflect getVmpNumber");
                return Constant.APM_CFG_GPU_NA;
            }
        }
        Method method = sGetIdenMethod;
        if (method == null) {
            return Constant.APM_CFG_GPU_NA;
        }
        try {
            Object invoke = method.invoke(sTGPAInstance, new Object[0]);
            return invoke != null ? String.valueOf(invoke) : Constant.APM_CFG_GPU_NA;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            e2.printStackTrace();
            HawkLogger.e("cannot invoke GetIdenMethod");
            return Constant.APM_CFG_GPU_NA;
        }
    }

    public static String checkDeviceIsReal() {
        if (!checkTGPAEnabled("CheckDeviceIsReal")) {
            return "{\"result\":-1}";
        }
        if (sCheckDeviceIsRealMethod == null) {
            try {
                sCheckDeviceIsRealMethod = sTGPAClass.getDeclaredMethod("checkDeviceIsReal", new Class[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                HawkLogger.e("cannot reflect CheckDeviceIsRealMethod");
                return "{\"result\":-3}";
            }
        }
        Method method = sCheckDeviceIsRealMethod;
        if (method == null) {
            return "{\"result\":-3}";
        }
        try {
            Object invoke = method.invoke(sTGPAInstance, new Object[0]);
            return invoke != null ? String.valueOf(invoke) : "{\"result\":-4}";
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            e2.printStackTrace();
            HawkLogger.e("cannot invoke CheckDeviceIsReal");
            return "{\"result\":-5}";
        }
    }

    public static String getVmpSDKName() {
        if (!checkTGPAEnabled("GetVmpSDKName")) {
            return Constant.APM_CFG_GPU_NA;
        }
        if (sGetNativeSDKNameMethod == null) {
            try {
                sGetNativeSDKNameMethod = sTGPAClass.getDeclaredMethod("getSdkType", new Class[0]);
            } catch (NoSuchMethodException e) {
                HawkLogger.e("Cannot reflect getSdkType: " + e.getMessage());
                return Constant.APM_CFG_GPU_NA;
            }
        }
        Method method = sGetNativeSDKNameMethod;
        if (method == null) {
            return Constant.APM_CFG_GPU_NA;
        }
        try {
            Object invoke = method.invoke(sTGPAInstance, new Object[0]);
            if (invoke == null) {
                return Constant.APM_CFG_GPU_NA;
            }
            String valueOf = String.valueOf(invoke);
            HawkLogger.d("VMP SDK Type: " + valueOf);
            return valueOf;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            HawkLogger.e("cannot invoke getSdkType");
            return Constant.APM_CFG_GPU_NA;
        }
    }

    public static void updateGameInfoToTGPASS(String str, String str2) {
        if (str.equals("GPU")) {
            sTGPAGpuInfo = str2;
        }
        if (checkTGPAEnabled("updateGameInfoToTGPASS")) {
            if (sUpdateGameInfoSS == null) {
                try {
                    sUpdateGameInfoSS = sTGPAClass.getDeclaredMethod("updateGameInfo", String.class, String.class);
                } catch (NoSuchMethodException unused) {
                    HawkLogger.e("Cannot reflect sUpdateGameInfoII");
                    return;
                }
            }
            Method method = sUpdateGameInfoSS;
            if (method == null) {
                return;
            }
            try {
                method.invoke(sTGPAInstance, str, str2);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                HawkLogger.e("Cannot invoke UpdateGameInfoII");
            }
        }
    }

    public static void updateGameInfoToTGPAIS(int i, String str) {
        if (checkTGPAEnabled("UpdateGameInfoToTGPAIS")) {
            if (sUpdateGameInfoIS == null) {
                try {
                    sUpdateGameInfoIS = sTGPAClass.getDeclaredMethod("updateGameInfo", Integer.TYPE, String.class);
                } catch (NoSuchMethodException unused) {
                    HawkLogger.e("Cannot reflect UpdateGameInfoIS");
                    return;
                }
            }
            Method method = sUpdateGameInfoIS;
            if (method == null) {
                return;
            }
            try {
                method.invoke(sTGPAInstance, Integer.valueOf(i), str);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                HawkLogger.e("Cannot invoke UpdateGameInfoIS: " + e.getMessage());
            }
        }
    }

    public static void enableTGPALog() {
        if (checkTGPAEnabled("enableTGPALog")) {
            try {
                Method declaredMethod = sTGPAClass.getDeclaredMethod("setLogAble", Boolean.TYPE);
                if (declaredMethod == null) {
                    return;
                }
                try {
                    declaredMethod.invoke(sTGPAInstance, true);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    HawkLogger.e("Cannot invoke setLogAble");
                }
            } catch (NoSuchMethodException unused2) {
                HawkLogger.e("Cannot reflect enableTGPALog");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getCurrentThreadTid() {
        if (!checkTGPAEnabled("getCurrentThreadTid")) {
            return -1;
        }
        try {
            Method declaredMethod = sTGPAClass.getDeclaredMethod("getCurrentThreadTid", new Class[0]);
            if (declaredMethod == null) {
                return -1;
            }
            try {
                Object invoke = declaredMethod.invoke(sTGPAInstance, new Object[0]);
                if (invoke == null) {
                    return -1;
                }
                try {
                    return Integer.parseInt(invoke.toString());
                } catch (Exception unused) {
                    HawkLogger.e("Tid Parse Error: " + invoke.toString());
                    return -1;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                HawkLogger.e("Cannot invoke getCurrentThreadTid");
                return -1;
            }
        } catch (NoSuchMethodException unused3) {
            HawkLogger.e("Cannot reflect getCurrentThreadTid");
            return -1;
        }
    }

    public static void reportGameUserInfoToTGPA(Context context, HashMap<String, String> hashMap) {
        if (checkTGPAEnabled("reportGameUserInfoToTGPA")) {
            try {
                Method declaredMethod = sTGPAClass.getDeclaredMethod("reportGameUserInfo", Context.class, HashMap.class);
                if (declaredMethod == null) {
                    return;
                }
                try {
                    declaredMethod.invoke(sTGPAInstance, context, hashMap);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    HawkLogger.e("Cannot invoke reportGameUserInfo");
                }
            } catch (NoSuchMethodException unused2) {
                HawkLogger.e("Cannot reflect reportGameUserInfo");
            }
        }
    }

    public static void reportMapToTGPA(String str, HashMap<String, String> hashMap) {
        if (checkTGPAEnabled("reportMapToTGPA")) {
            try {
                Method declaredMethod = sTGPAClass.getDeclaredMethod("updateGameInfo", String.class, HashMap.class);
                if (declaredMethod == null) {
                    return;
                }
                try {
                    declaredMethod.invoke(sTGPAInstance, str, hashMap);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    HawkLogger.e("Cannot invoke reportMapToTGPA");
                }
            } catch (NoSuchMethodException unused2) {
                HawkLogger.e("Cannot reflect reportMapToTGPA");
            }
        }
    }

    public static String getOptCfgStr() {
        if (!checkTGPAEnabled("getOptCfgStr")) {
            return Constant.APM_CFG_GPU_NA;
        }
        if (sGetOptCfgStrMethod == null) {
            try {
                sGetOptCfgStrMethod = sTGPAClass.getDeclaredMethod("getOptCfgStr", new Class[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                HawkLogger.e("cannot reflect getOptCfgStr");
                return Constant.APM_CFG_GPU_NA;
            }
        }
        Method method = sGetOptCfgStrMethod;
        if (method == null) {
            return Constant.APM_CFG_GPU_NA;
        }
        try {
            Object invoke = method.invoke(sTGPAInstance, new Object[0]);
            return invoke != null ? String.valueOf(invoke) : Constant.APM_CFG_GPU_NA;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            e2.printStackTrace();
            HawkLogger.e("cannot invoke getOptCfgStr");
            return Constant.APM_CFG_GPU_NA;
        }
    }
}
