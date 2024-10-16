package com.tencent.imsdk.android.tools;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class DeviceUtils {
    private static final String DECORATE_SYMBOL = "|";
    private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static final float DEFAULT_SCREEN_DPI = 0.0f;
    private static final String DEFAULT_SCREEN_RESOLUTION = "0.0*0.0";
    private static final String PREFS_COMBINE_UNIQUE_ID = "uuid";
    private static final String PREFS_FILE = "device_id";
    private static final String PREFS_GUEST_RECOVER = "recover";
    private static final String PREFS_INSTALL_ID = "install";
    private static final String PREFS_RANDOM_ID = "random";
    private static final Object mLock = new Object();
    private static final Object mRecoverLock = new Object();
    private static PreferencesUtils mPreferencesUtils = new PreferencesUtils();
    private static volatile String mUuid = null;
    private static volatile String mInstallId = null;
    private static volatile String mRecoverId = null;
    private static volatile boolean mRecoverIdReadPrefOnce = false;
    private static String mExtra = null;
    private static String mRandom = null;
    private static volatile DisplayMetrics mCurDisplayMetrics = null;
    private static String mGoogleAdId = "";

    public static String getDeviceExtra(Context context) {
        String str;
        synchronized (mLock) {
            if (mRandom == null) {
                mRandom = mPreferencesUtils.getString(context, PREFS_RANDOM_ID, "");
            }
            if (mExtra == null) {
                StringBuilder sb = new StringBuilder();
                if (IMSDKConfig.getOrMetaData(IR.meta.IMSDK_GUEST_EXTRA_INFO, IR.meta.IMSDK_GUEST_EXTRA_INFO, false)) {
                    IMLogger.d("get extra guest info");
                    sb.append(getAndroidId(context));
                    sb.append(DECORATE_SYMBOL);
                    sb.append(getSerial());
                    sb.append(DECORATE_SYMBOL);
                    sb.append(getIMEI(context));
                    sb.append(DECORATE_SYMBOL);
                    sb.append(getMac(context));
                    sb.append(DECORATE_SYMBOL);
                    sb.append(mRandom);
                    sb.append(DECORATE_SYMBOL);
                    sb.append(Build.FINGERPRINT);
                    sb.append(DECORATE_SYMBOL);
                    sb.append(getBuildAttribute("HOST"));
                    sb.append(DECORATE_SYMBOL);
                    sb.append(getRadioVersion());
                    sb.append(DECORATE_SYMBOL);
                    sb.append(getBuildAttribute("HARDWARE"));
                }
                if (IMSDKConfig.getOrMetaData(IR.meta.IMSDK_GOOGLE_ADID_ENABLE, IR.meta.IMSDK_GOOGLE_ADID_ENABLE, true)) {
                    IMLogger.d("get google ad id");
                    if (sb.length() > 0) {
                        sb.append(DECORATE_SYMBOL);
                    }
                    sb.append(getGoogleAdId(context));
                }
                mExtra = sb.toString();
                IMLogger.d("device extra : " + mExtra);
            }
            str = mExtra == null ? "" : mExtra;
        }
        return str;
    }

    private static void saveRandom(Context context, String str) {
        mPreferencesUtils.putString(context, PREFS_RANDOM_ID, str);
    }

    public static String getDeviceUuid(Context context) {
        synchronized (mLock) {
            if (mRecoverId == null) {
                mRecoverId = getRecoverId(context);
            }
            if (mRecoverId != null && mRecoverId.length() > 0) {
                return mRecoverId;
            }
            return getOriginalDeviceUuid(context);
        }
    }

    public static String getOriginalDeviceUuid(Context context) {
        synchronized (mLock) {
            if (mUuid != null) {
                return mUuid;
            }
            mPreferencesUtils.setPreferenceFileName(PREFS_FILE);
            mUuid = mPreferencesUtils.getString(context, "uuid", null);
            if (mUuid == null) {
                String[] strArr = {getAndroidId(context), getSerial(), getIMEI(context), getMac(context)};
                IMLogger.d("androidId : " + strArr[0] + ", seriesId : " + strArr[1] + ", deviceId : " + strArr[2] + ", mac :" + strArr[3]);
                boolean orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_GUEST_RESTORE, IR.meta.IMSDK_GUEST_RESTORE, true);
                if (orMetaData) {
                    T.HelperLog.guestWillRestore();
                } else {
                    T.HelperLog.guestWillLost();
                }
                if (orMetaData && (!T.ckIsEmpty(strArr[2]) || !T.ckIsEmpty(strArr[3]))) {
                    mUuid = DigestUtils.getMD5(strArr[0] + strArr[1] + strArr[2] + strArr[3]);
                    saveRandom(context, "");
                    String aESSecretKey = DigestUtils.getAESSecretKey();
                    String encryptAES = DigestUtils.encryptAES(strArr[0] + "," + strArr[1] + "," + strArr[2] + "," + strArr[3], aESSecretKey);
                    HashMap hashMap = new HashMap();
                    hashMap.put("IMSDKEncryptKey", DigestUtils.getAESEncryptKey(DigestUtils.PUBLIC_KEY, aESSecretKey));
                    hashMap.put("IDs", encryptAES);
                    new InnerStat.Builder(context, "2.10.1").setChannel(IR.def.IMSDK_KEYWORD).setStage("getDeviceUuid").setMethod("Hardware Guest").setExtraProp(hashMap).setResult("SUCCESS").create().reportEvent();
                    mPreferencesUtils.putString(context, "uuid", mUuid);
                }
                UUID randomUUID = UUID.randomUUID();
                mUuid = DigestUtils.getMD5(strArr[0] + strArr[1] + strArr[2] + strArr[3] + randomUUID.toString());
                saveRandom(context, randomUUID.toString());
                String aESSecretKey2 = DigestUtils.getAESSecretKey();
                String encryptAES2 = DigestUtils.encryptAES(strArr[0] + "," + strArr[1] + "," + strArr[2] + "," + strArr[3] + "," + randomUUID.toString(), aESSecretKey2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("IMSDKEncryptKey", DigestUtils.getAESEncryptKey(DigestUtils.PUBLIC_KEY, aESSecretKey2));
                hashMap2.put("IDs", encryptAES2);
                new InnerStat.Builder(context, "2.10.1").setChannel(IR.def.IMSDK_KEYWORD).setStage("getDeviceUuid").setMethod("Random Guest").setExtraProp(hashMap2).setResult("WARNING").create().reportEvent();
                mPreferencesUtils.putString(context, "uuid", mUuid);
            }
            IMLogger.d("Current uuid = " + mUuid);
            return mUuid;
        }
    }

    private static String getMacAfterAndroidM(String str) throws SocketException {
        NetworkInterface byName;
        byte[] bArr;
        if (!IMSDKConfig.getOrMetaData(IR.meta.IMSDK_MAC_ADDRESS_FIX_ENABLE, IR.meta.IMSDK_MAC_ADDRESS_FIX_ENABLE, true) || (byName = NetworkInterface.getByName(str)) == null) {
            return "";
        }
        try {
            bArr = (byte[]) Class.forName("java.net.NetworkInterface").getMethod("getHardwareAddress", new Class[0]).invoke(byName, new Object[0]);
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
            bArr = null;
        }
        if (bArr == null) {
            return "";
        }
        Formatter formatter = new Formatter();
        String str2 = "";
        int i = 0;
        while (i < bArr.length) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Byte.valueOf(bArr[i]);
            objArr[1] = i < bArr.length - 1 ? CertificateUtil.DELIMITER : "";
            str2 = formatter.format(locale, "%02X%s", objArr).toString();
            i++;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getMac(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.DeviceUtils.getMac(android.content.Context):java.lang.String");
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static String getSerial() {
        if (!IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERIAL_ENABLE, IR.meta.IMSDK_SERIAL_ENABLE, true)) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Class<?> cls = Class.forName("android.os.Build");
                return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
            } catch (Exception e) {
                IMLogger.w("get serial failed : " + e.getMessage(), new Object[0]);
                return "";
            }
        }
        try {
            Field field = Class.forName("android.os.Build").getField("SERIAL");
            return field.getType().equals(String.class) ? (String) field.get(null) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getInstallId(Context context) {
        synchronized (mLock) {
            if (mInstallId != null) {
                return mInstallId;
            }
            mPreferencesUtils.setPreferenceFileName(PREFS_FILE);
            mInstallId = mPreferencesUtils.getString(context, PREFS_INSTALL_ID, null);
            if (mInstallId == null) {
                mInstallId = UUID.randomUUID().toString();
                if (mInstallId != null) {
                    if (mInstallId.length() > 0) {
                        mPreferencesUtils.putString(context, PREFS_INSTALL_ID, mInstallId);
                    } else {
                        mInstallId = null;
                    }
                }
            }
            IMLogger.d("Current install id = " + mInstallId);
            return mInstallId;
        }
    }

    public static boolean setRecoverId(Context context, String str) {
        try {
        } catch (Exception e) {
            IMLogger.e("set recover id failed : " + e.getMessage(), new Object[0]);
        }
        synchronized (mRecoverLock) {
            if (str != null) {
                if (str.length() > 0) {
                    IMLogger.i("set recover id : " + str, new Object[0]);
                    mRecoverId = str;
                    mPreferencesUtils.setPreferenceFileName(PREFS_FILE);
                    return mPreferencesUtils.putString(context, PREFS_GUEST_RECOVER, mRecoverId);
                }
            }
            IMLogger.e("recover id error : " + str, new Object[0]);
            return false;
        }
    }

    public static String getRecoverId(Context context) {
        try {
            if (!mRecoverIdReadPrefOnce) {
                synchronized (mRecoverLock) {
                    if (mRecoverId != null && mRecoverId.length() > 0) {
                        return mRecoverId;
                    }
                    mPreferencesUtils.setPreferenceFileName(PREFS_FILE);
                    mRecoverId = mPreferencesUtils.getString(context, PREFS_GUEST_RECOVER, null);
                    IMLogger.d("Current recover id = " + mRecoverId);
                    mRecoverIdReadPrefOnce = true;
                    return mRecoverId;
                }
            }
        } catch (Exception e) {
            IMLogger.e("get recover id failed : " + e.getMessage(), new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0045 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getAndroidId(android.content.Context r7) {
        /*
            java.lang.String r0 = "IMSDK_ANDROID_ID_ENABLE"
            java.lang.String r1 = "IMSDK_ANDROID_ID_ENABLE"
            r2 = 1
            boolean r0 = com.tencent.imsdk.android.api.config.IMSDKConfig.getOrMetaData(r0, r1, r2)
            if (r0 == 0) goto L42
            if (r7 == 0) goto L42
            r0 = 0
            java.lang.String r1 = "android.provider.Settings$Secure"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L38
            java.lang.String r3 = "getString"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L38
            java.lang.Class<android.content.ContentResolver> r6 = android.content.ContentResolver.class
            r5[r0] = r6     // Catch: java.lang.Exception -> L38
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r2] = r6     // Catch: java.lang.Exception -> L38
            java.lang.reflect.Method r3 = r1.getMethod(r3, r5)     // Catch: java.lang.Exception -> L38
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L38
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Exception -> L38
            r4[r0] = r7     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = "android_id"
            r4[r2] = r7     // Catch: java.lang.Exception -> L38
            java.lang.Object r7 = r3.invoke(r1, r4)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L38
            goto L43
        L38:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.tencent.imsdk.android.tools.log.IMLogger.e(r7, r0)
        L42:
            r7 = 0
        L43:
            if (r7 != 0) goto L47
            java.lang.String r7 = ""
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.DeviceUtils.getAndroidId(android.content.Context):java.lang.String");
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(Context context) {
        String str = "";
        if (IMSDKConfig.getOrMetaData(IR.meta.IMSDK_DEVICE_ID_ENABLE, IR.meta.IMSDK_DEVICE_ID_ENABLE, true)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = (String) Class.forName("android.telephony.TelephonyManager").getMethod(IStat.STAT_GET_DEVICE_ID, new Class[0]).invoke(telephonyManager, new Object[0]);
                }
            } catch (Exception e) {
                IMLogger.w(e.getMessage(), new Object[0]);
            }
        }
        return (str == null || str.equals("000000000000000") || str.equals("012345678912345")) ? "" : str;
    }

    public static void syncGoogleAdId(Context context) {
        IMLogger.d("get google ad id ...");
        getGoogleAdId(context);
    }

    private static String getGoogleAdId(Context context) {
        synchronized (mLock) {
            if (mGoogleAdId != null && mGoogleAdId.length() > 0) {
                return mGoogleAdId;
            }
            try {
                getGoogleAdIdAnsyc(context, new IMSDKListener<String>() { // from class: com.tencent.imsdk.android.tools.DeviceUtils.1
                    @Override // com.tencent.imsdk.android.base.IMSDKListener
                    public void onNotify(String str) {
                        IMLogger.d("Current google ad id = " + str);
                        String unused = DeviceUtils.mGoogleAdId = str;
                    }

                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKResult iMSDKResult) {
                        IMLogger.d("should not run this code : " + iMSDKResult.imsdkRetCode);
                    }
                });
            } catch (Exception e) {
                IMLogger.d("get google ad id error : " + e.getClass().getName() + ", " + e.getMessage());
                mGoogleAdId = "";
            }
            return mGoogleAdId;
        }
    }

    public static void getGoogleAdIdAnsyc(final Context context, final IMSDKListener<String> iMSDKListener) {
        if (IMSDKConfig.getOrMetaData(IR.meta.IMSDK_GOOGLE_ADID_ENABLE, IR.meta.IMSDK_GOOGLE_ADID_ENABLE, true)) {
            synchronized (mLock) {
                if (T.ckIsEmpty(mGoogleAdId)) {
                    new Thread(new Runnable() { // from class: com.tencent.imsdk.android.tools.DeviceUtils.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                                Object invoke = cls.getDeclaredMethod("getAdvertisingIdInfo", Context.class).invoke(cls.getConstructor(Context.class).newInstance(context), context);
                                Object invoke2 = invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                                if (invoke2 != null) {
                                    iMSDKListener.onNotify(invoke2.toString());
                                } else {
                                    iMSDKListener.onNotify("");
                                }
                            } catch (InvocationTargetException e) {
                                IMLogger.d("get google ad id failed : " + e.getTargetException().getClass().getName() + ", " + e.getTargetException().getMessage());
                                iMSDKListener.onNotify("");
                            } catch (Exception e2) {
                                IMLogger.d("get google ad id failed : " + e2.getClass().getName() + ", " + e2.getMessage());
                                iMSDKListener.onNotify("");
                            }
                        }
                    }).start();
                } else {
                    iMSDKListener.onNotify(mGoogleAdId);
                }
            }
        }
    }

    public static String getLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String getCountry() {
        String str = "";
        try {
            str = Locale.getDefault().getCountry();
            IMLogger.d("country is : " + str);
            return str;
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return str;
        }
    }

    public static String getPhoneName() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return "";
        }
        try {
            return defaultAdapter.getName();
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static int getNetworkType(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static String getAppVersion(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String getAppVersion(Context context, String str) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e) {
            IMLogger.i("get app version failed : " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            IMLogger.w("catch NameNotFoundException : " + e.getMessage(), new Object[0]);
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static String getBuildAttribute(String str) {
        try {
            Field field = Class.forName("android.os.Build").getField(str);
            return field.getType().equals(String.class) ? (String) field.get(null) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getRadioVersion() {
        try {
            Class<?> cls = Class.forName("android.os.Build");
            return (String) cls.getMethod("getRadioVersion", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String getSimOperator(Context context) {
        if (!hasSim(context)) {
            return "unknown";
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception e) {
            IMLogger.e("error when get actual operator : " + e.getMessage(), new Object[0]);
            return "unknown";
        }
    }

    private static boolean hasSim(Context context) {
        try {
            return !T.ckIsEmpty(((TelephonyManager) context.getSystemService("phone")).getSimOperator());
        } catch (Exception e) {
            IMLogger.e("error when checking sim : " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static float getScreenDPI(Context context) {
        if (mCurDisplayMetrics == null) {
            mCurDisplayMetrics = context.getResources().getDisplayMetrics();
        }
        return mCurDisplayMetrics == null ? DEFAULT_SCREEN_DPI : mCurDisplayMetrics.density;
    }

    public static String getScreenResolution(Context context) {
        if (mCurDisplayMetrics == null) {
            mCurDisplayMetrics = context.getResources().getDisplayMetrics();
        }
        if (mCurDisplayMetrics == null) {
            return DEFAULT_SCREEN_RESOLUTION;
        }
        return mCurDisplayMetrics.widthPixels + "*" + mCurDisplayMetrics.heightPixels;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getBrand() {
        return Build.BRAND;
    }
}
