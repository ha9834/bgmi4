package com.tencent.grobot.lite.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes2.dex */
public class SystemUtils {
    private static final int HUAWEI = 1;
    private static final int OPPO = 4;
    private static final int SAMSUNG = 5;
    private static final String TAG = "SystemUtils";
    private static final int VIVO = 3;
    private static final int XIAOMI = 2;
    private static int phoneType = -1;
    private static int sNotchFlag = -1;
    private static int statusHeight = -1;

    public SystemUtils() {
        throw new UnsupportedOperationException("Can not create an object of the clazz.");
    }

    public static void closeKeybord(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void doGC() {
        System.gc();
        System.runFinalization();
        System.gc();
    }

    public static void doGCDelay(long j) {
        ThreadManager.get().postDelayToUiThread(new GCRunnable(), j);
    }

    public static boolean hasNotch(Context context) {
        int i = sNotchFlag;
        if (i != -1) {
            return i != 0;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowInsets rootWindowInsets = ((Activity) context).getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets == null) {
                return false;
            }
            DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
            if (displayCutout == null) {
                sNotchFlag = 0;
            } else {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                sNotchFlag = (boundingRects == null || boundingRects.size() == 0) ? 0 : 1;
            }
        } else if (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) {
            if (isEmui()) {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    Method declaredMethod = loadClass.getDeclaredMethod("hasNotchInScreen", new Class[0]);
                    declaredMethod.setAccessible(true);
                    sNotchFlag = ((Boolean) declaredMethod.invoke(loadClass, new Object[0])).booleanValue() ? 1 : 0;
                } catch (Exception e) {
                    TLog.e(TAG, "Huawei hasNotch failed, " + e.getMessage());
                    sNotchFlag = 0;
                }
            } else if (isOppo()) {
                sNotchFlag = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism") ? 1 : 0;
            } else if (isVivo()) {
                try {
                    Class<?> loadClass2 = context.getClassLoader().loadClass("android.util.FtFeature");
                    Method declaredMethod2 = loadClass2.getDeclaredMethod("isFeatureSupport", Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    sNotchFlag = ((Boolean) declaredMethod2.invoke(loadClass2, 32)).booleanValue() ? 1 : 0;
                } catch (Exception e2) {
                    Log.e(TAG, "Vivo hasNotch failed, " + e2.getMessage());
                    sNotchFlag = 0;
                }
            } else if (isMiui()) {
                try {
                    Class<?> loadClass3 = context.getClassLoader().loadClass("android.os.SystemProperties");
                    Method declaredMethod3 = loadClass3.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                    declaredMethod3.setAccessible(true);
                    sNotchFlag = ((Integer) declaredMethod3.invoke(loadClass3, "ro.miui.notch", 0)).intValue() == 1 ? 1 : 0;
                } catch (Exception e3) {
                    TLog.e(TAG, "Xiaomi hasNotch failed, " + e3.getMessage());
                    sNotchFlag = 0;
                }
            } else {
                sNotchFlag = 0;
            }
        } else {
            sNotchFlag = 0;
        }
        return sNotchFlag != 0;
    }

    public static int getStatusBarHeight(Context context) {
        int ceil;
        if (statusHeight == -1) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if ((identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0) <= 0) {
                ceil = ViewUtils.dip2px(context, 25.0f);
            } else {
                ceil = (int) Math.ceil((r0 * 1.0f) + 0.5f);
            }
            statusHeight = ceil;
        }
        return statusHeight;
    }

    @TargetApi(28)
    public static DisplayCutout getDisplayCutout(Context context) {
        return ((Activity) context).getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
    }

    public static int getSafeInsetLeft(Context context) {
        DisplayCutout displayCutout = getDisplayCutout(context);
        if (displayCutout != null) {
            return displayCutout.getSafeInsetLeft();
        }
        return 0;
    }

    public static int getSafeInsetRight(Context context) {
        DisplayCutout displayCutout = getDisplayCutout(context);
        if (displayCutout != null) {
            return displayCutout.getSafeInsetRight();
        }
        return ViewUtils.getScreenWidthPixels(context);
    }

    public static boolean isEmui() {
        getPhoneType();
        return phoneType == 1;
    }

    public static boolean isMiui() {
        getPhoneType();
        return phoneType == 2;
    }

    public static boolean isVivo() {
        getPhoneType();
        return phoneType == 3;
    }

    public static boolean isOppo() {
        getPhoneType();
        return phoneType == 4;
    }

    public static boolean isSumsumg() {
        getPhoneType();
        return phoneType == 5;
    }

    private static void getPhoneType() {
        if (phoneType == -1) {
            String upperCase = Build.BRAND.trim().toUpperCase();
            if (upperCase.equals("HUAWEI")) {
                phoneType = 1;
                return;
            }
            if (upperCase.equals("XIAOMI")) {
                phoneType = 2;
                return;
            }
            if (upperCase.equals("VIVO")) {
                phoneType = 3;
            } else if (upperCase.equals("OPPO")) {
                phoneType = 4;
            } else if (upperCase.equals("SAMSUNG")) {
                phoneType = 5;
            }
        }
    }

    public static String getPhoneBrand() {
        return Build.BRAND.trim().toLowerCase();
    }

    public static String getPhoneModel() {
        return Build.MODEL.trim().toLowerCase();
    }

    public static String getNetworkType() {
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) GRobotApplication.self().getSystemService("connectivity");
        if (connectivityManager == null) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "NONE";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "wifi";
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 == null) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        NetworkInfo.State state2 = networkInfo2.getState();
        String subtypeName = networkInfo2.getSubtypeName();
        if (state2 == null) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        if (state2 != NetworkInfo.State.CONNECTED && state2 != NetworkInfo.State.CONNECTING) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3g" : GameParameters.SOURCE_MOBILE;
        }
    }

    /* loaded from: classes2.dex */
    private static final class GCRunnable implements Runnable {
        private GCRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TLog.d(SystemUtils.TAG, "doGc in runnable.");
            SystemUtils.doGC();
        }
    }
}
