package com.tdatamaster.tdm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.tdatamaster.tdm.device.DeviceInfo;
import com.tdatamaster.tdm.device.DeviceInfoHolder;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tdatamaster.tdm.device.IDeviceInfoObserver;
import com.tdatamaster.tdm.system.FileUtils;
import com.tdatamaster.tdm.system.TDMLog;
import com.tdatamaster.tdm.system.TDMUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes2.dex */
public class TDataMaster {
    private static TDataMaster Instance = null;
    public static final int TDM_REPORT_SIMPLE_MODE = 1;
    public static final int TDM_REPORT_STANDARD_MODE = 0;
    private static boolean isInitialized = false;
    private static char lifecycle = 0;
    private static Application mApplication = null;
    private static final String tag = "TDataMaster";

    private native void TDMEnableDeviceInfo(boolean z);

    private native void TDMEnableReport(boolean z);

    private native String TDMGetSDKVerision();

    private native String TDMGetUID();

    private native void TDMInit();

    private native void TDMPause();

    private native void TDMReportBinary(String str, byte[] bArr, int i, int i2);

    private native void TDMReportEvent(String str, Map<String, String> map, int i, int i2);

    private native void TDMReportLogin(int i, String str);

    private native void TDMResume();

    private native void TDMSetLogLevel(int i);

    public static native void setAppDir(String str);

    static {
        System.loadLibrary(tag);
        Instance = new TDataMaster();
        lifecycle = (char) 0;
        isInitialized = false;
    }

    private TDataMaster() {
        TDMLog.i(tag, "TDataMaster Construct");
    }

    public static TDataMaster getInstance() {
        return Instance;
    }

    public static Application getApplication() {
        if (mApplication == null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                mApplication = (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, (Object[]) null), (Object[]) null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        return mApplication;
    }

    public boolean initialize() {
        return initialize(getApplication());
    }

    public boolean initialize(Context context) {
        TDMUtils.GetInstance().SaveConfigInfo(context.getApplicationContext());
        int logLevel = TDMLog.getLogLevel();
        if (logLevel <= 1) {
            TDMLog.w(tag, "now Android logLevel is " + logLevel + ", please use warning or error level in production");
        }
        TDMLog.i(tag, "TDataMaster initialize(onCreate), isInitialized: " + isInitialized);
        if (!isInitialized) {
            FileUtils.GetInstance().Initialize(context);
            DeviceInfoHolder.GetInstance().Initialize(context.getApplicationContext());
            TDMUtils.GetInstance().Initialize(context.getApplicationContext());
            TDMInit();
            isInitialized = true;
        }
        TDMUtils.GetInstance().RegisterReceiver();
        return isInitialized;
    }

    public void prepareFileDir(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                if (externalFilesDir.isDirectory() && externalFilesDir.exists()) {
                    setAppDir(externalFilesDir.getAbsolutePath() + "/");
                    return;
                }
                TDMLog.w(tag, "get public dir error!");
                return;
            }
            TDMLog.w(tag, "getExternalFilesDir is null");
            return;
        }
        TDMLog.w(tag, "sdcard is unavailable, state : " + Environment.getExternalStorageState());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        TDMLog.i(tag, "OnActivityResult requestCode:" + i + " resultCode:" + i2);
    }

    public void onStart() {
        TDMLog.i(tag, "OnStart");
        lifecycle = (char) 2;
    }

    public void onResume() {
        TDMLog.i(tag, "onResume");
        if (lifecycle != 4) {
            TDMResume();
        }
        lifecycle = (char) 4;
    }

    public void onPause() {
        TDMLog.i(tag, "onPause");
        if (lifecycle != '\b') {
            TDMPause();
        }
        lifecycle = '\b';
    }

    public void onStop() {
        TDMLog.i(tag, "OnStop");
        lifecycle = (char) 16;
    }

    public void onDestroy() {
        TDMLog.i(tag, "onDestroy");
        TDMUtils.GetInstance().UnregisterReceiver();
        lifecycle = ' ';
    }

    public void onRestart() {
        TDMLog.i(tag, "OnRestart");
        lifecycle = '@';
    }

    public String getTDMUID() {
        TDMLog.d(tag, "getTDMUID");
        return TDMGetUID();
    }

    public void enableReport(boolean z) {
        TDMLog.d(tag, "enableReport");
        TDMEnableReport(z);
    }

    public void setLogLevel(int i) {
        System.out.println("SetLogLevel: " + i);
        TDMUtils.GetInstance().SetLogLevel(i);
        TDMSetLogLevel(i);
    }

    public String getTDMSDKVersion() {
        TDMLog.d(tag, "getTDMSDKVersion");
        return TDMGetSDKVerision();
    }

    public void reportEvent(int i, String str, Map<String, String> map) {
        reportEvent(i, str, map, 0);
    }

    public void reportEvent(int i, String str, Map<String, String> map, int i2) {
        TDMLog.d(tag, "eventName: " + str);
        TDMLog.d(tag, "srcID: " + i);
        if (map == null || map.isEmpty()) {
            TDMLog.e(tag, "eventInfo is null or empty");
        } else {
            TDMReportEvent(str, map, i, i2);
        }
    }

    public void reportBinary(int i, String str, byte[] bArr, int i2) {
        TDMLog.d(tag, "eventName: " + str);
        TDMLog.d(tag, "srcID: " + i);
        if (bArr == null) {
            TDMLog.e(tag, "data is null");
        } else {
            TDMReportBinary(str, bArr, i2, i);
        }
    }

    public void reportLogin(int i, String str) {
        TDMLog.d(tag, "reportLogin, platform:" + i + ", openid" + str);
        TDMReportLogin(i, str);
    }

    public void enableDeviceInfo(boolean z) {
        TDMEnableDeviceInfo(z);
    }

    public void addDeviceInfoObserver(IDeviceInfoObserver iDeviceInfoObserver, String str) {
        DeviceInfoHolder.GetInstance().addDeviceInfoObserver(iDeviceInfoObserver, str);
    }

    public void addDeviceInfoObserver(IDeviceInfoObserver iDeviceInfoObserver) {
        addDeviceInfoObserver(iDeviceInfoObserver, DeviceInfoName.ALL_DEVICE_INFO_STRING);
    }

    public DeviceInfo<Long> getLongDeviceInfo(String str) {
        return DeviceInfoHolder.GetInstance().getLongDeviceInfo(str);
    }

    public DeviceInfo<Boolean> getBoolDeviceInfo(String str) {
        return DeviceInfoHolder.GetInstance().getBoolDeviceInfo(str);
    }

    public DeviceInfo<String> getStringDeviceInfo(String str) {
        return DeviceInfoHolder.GetInstance().getStringDeviceInfo(str);
    }

    public int setDeviceInfo(String str, long j) {
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return 6;
        }
        TDMLog.i(tag, "setDeviceInfo deviceInfoName : " + str + ",deviceInfoValue : " + j);
        if (DeviceInfoHolder.GetInstance().isSynDeviceInfo(str) || DeviceInfoHolder.GetInstance().isAsynDeviceInfo(str)) {
            TDMLog.e(tag, "can't set tdm self field");
            return 6;
        }
        return DeviceInfoHolder.GetInstance().setDeviceInfo(str, j);
    }

    public int setDeviceInfo(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName or deviceInfoValue is empty");
            return 6;
        }
        TDMLog.i(tag, "setDeviceInfo deviceInfoName : " + str + ",deviceInfoValue : " + str2);
        if (DeviceInfoHolder.GetInstance().isSynDeviceInfo(str) || DeviceInfoHolder.GetInstance().isAsynDeviceInfo(str)) {
            TDMLog.e(tag, "can't set tdm self field");
            return 6;
        }
        return DeviceInfoHolder.GetInstance().setDeviceInfo(str, str2);
    }

    public int setDeviceInfo(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            TDMLog.e(tag, "deviceInfoName is empty");
            return 6;
        }
        TDMLog.i(tag, "setDeviceInfo deviceInfoName : " + str + ",deviceInfoValue : " + z);
        if (DeviceInfoHolder.GetInstance().isSynDeviceInfo(str) || DeviceInfoHolder.GetInstance().isAsynDeviceInfo(str)) {
            TDMLog.e(tag, "can't set tdm self field");
            return 6;
        }
        return DeviceInfoHolder.GetInstance().setDeviceInfo(str, z);
    }
}
