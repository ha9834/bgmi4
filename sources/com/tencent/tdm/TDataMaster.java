package com.tencent.tdm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.tencent.tdm.device.DeviceInfo;
import com.tencent.tdm.device.IDeviceInfoObserver;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class TDataMaster {
    protected static TDataMaster instance = new TDataMaster();

    private TDataMaster() {
    }

    public static TDataMaster getInstance() {
        return instance;
    }

    public static Application getApplication() {
        return com.tdatamaster.tdm.TDataMaster.getApplication();
    }

    public boolean initialize() {
        return com.tdatamaster.tdm.TDataMaster.getInstance().initialize();
    }

    public boolean initialize(Context context) {
        return com.tdatamaster.tdm.TDataMaster.getInstance().initialize(context);
    }

    public void prepareFileDir(Context context) {
        com.tdatamaster.tdm.TDataMaster.getInstance().prepareFileDir(context);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tdatamaster.tdm.TDataMaster.getInstance().onActivityResult(i, i2, intent);
    }

    public void onStart() {
        com.tdatamaster.tdm.TDataMaster.getInstance().onStart();
    }

    public void onResume() {
        com.tdatamaster.tdm.TDataMaster.getInstance().onResume();
    }

    public void onPause() {
        com.tdatamaster.tdm.TDataMaster.getInstance().onPause();
    }

    public void onStop() {
        com.tdatamaster.tdm.TDataMaster.getInstance().onStop();
    }

    public void onDestroy() {
        com.tdatamaster.tdm.TDataMaster.getInstance().onDestroy();
    }

    public void onRestart() {
        com.tdatamaster.tdm.TDataMaster.getInstance().onRestart();
    }

    public String getTDMUID() {
        return com.tdatamaster.tdm.TDataMaster.getInstance().getTDMUID();
    }

    public void enableReport(boolean z) {
        com.tdatamaster.tdm.TDataMaster.getInstance().enableReport(z);
    }

    public void setLogLevel(int i) {
        com.tdatamaster.tdm.TDataMaster.getInstance().setLogLevel(i);
    }

    public String getTDMSDKVersion() {
        return com.tdatamaster.tdm.TDataMaster.getInstance().getTDMSDKVersion();
    }

    public void reportEvent(int i, String str, Map<String, String> map) {
        com.tdatamaster.tdm.TDataMaster.getInstance().reportEvent(i, str, map);
    }

    public void reportEvent(int i, String str, Map<String, String> map, int i2) {
        com.tdatamaster.tdm.TDataMaster.getInstance().reportEvent(i, str, map, i2);
    }

    public void reportBinary(int i, String str, byte[] bArr, int i2) {
        com.tdatamaster.tdm.TDataMaster.getInstance().reportBinary(i, str, bArr, i2);
    }

    public void reportLogin(int i, String str) {
        com.tdatamaster.tdm.TDataMaster.getInstance().reportLogin(i, str);
    }

    public void enableDeviceInfo(boolean z) {
        com.tdatamaster.tdm.TDataMaster.getInstance().enableDeviceInfo(z);
    }

    public void addDeviceInfoObserver(IDeviceInfoObserver iDeviceInfoObserver, String str) {
        com.tdatamaster.tdm.TDataMaster.getInstance().addDeviceInfoObserver(iDeviceInfoObserver, str);
    }

    public void addDeviceInfoObserver(IDeviceInfoObserver iDeviceInfoObserver) {
        com.tdatamaster.tdm.TDataMaster.getInstance().addDeviceInfoObserver(iDeviceInfoObserver);
    }

    public DeviceInfo<Long> getLongDeviceInfo(String str) {
        com.tdatamaster.tdm.device.DeviceInfo<Long> longDeviceInfo = com.tdatamaster.tdm.TDataMaster.getInstance().getLongDeviceInfo(str);
        if (longDeviceInfo == null) {
            return null;
        }
        return new DeviceInfo<>((com.tdatamaster.tdm.device.DeviceInfo) longDeviceInfo);
    }

    public DeviceInfo<Boolean> getBoolDeviceInfo(String str) {
        com.tdatamaster.tdm.device.DeviceInfo<Boolean> boolDeviceInfo = com.tdatamaster.tdm.TDataMaster.getInstance().getBoolDeviceInfo(str);
        if (boolDeviceInfo == null) {
            return null;
        }
        return new DeviceInfo<>((com.tdatamaster.tdm.device.DeviceInfo) boolDeviceInfo);
    }

    public DeviceInfo<String> getStringDeviceInfo(String str) {
        com.tdatamaster.tdm.device.DeviceInfo<String> stringDeviceInfo = com.tdatamaster.tdm.TDataMaster.getInstance().getStringDeviceInfo(str);
        if (stringDeviceInfo == null) {
            return null;
        }
        return new DeviceInfo<>((com.tdatamaster.tdm.device.DeviceInfo) stringDeviceInfo);
    }

    public int setDeviceInfo(String str, long j) {
        return com.tdatamaster.tdm.TDataMaster.getInstance().setDeviceInfo(str, j);
    }

    public int setDeviceInfo(String str, String str2) {
        return com.tdatamaster.tdm.TDataMaster.getInstance().setDeviceInfo(str, str2);
    }

    public int setDeviceInfo(String str, boolean z) {
        return com.tdatamaster.tdm.TDataMaster.getInstance().setDeviceInfo(str, z);
    }
}
