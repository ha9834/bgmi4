package com.tencent.kgvmp;

import android.app.Activity;
import android.content.Context;
import com.ihoc.mgpa.IMGPAService;
import com.ihoc.mgpa.MgpaManager;
import com.ihoc.mgpa.m.b;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PerformanceAdjuster {
    private MgpaManager mgpaManager = new MgpaManager();

    public static void setTuringShieldMonitorWrapper(IMGPAService.TouchEventWrapper touchEventWrapper) {
        b.b().a(touchEventWrapper);
    }

    public boolean checkSdkCanWork() {
        return this.mgpaManager.checkSdkCanWork();
    }

    public void enableDebugMode() {
        this.mgpaManager.enableDebugMode();
    }

    public int getCurrentThreadTid() {
        return this.mgpaManager.getCurrentThreadTid();
    }

    public String getDataFromTGPA(String str, String str2) {
        return this.mgpaManager.getDataFromTGPA(str, str2);
    }

    public String getSdkType() {
        return this.mgpaManager.getSdkType();
    }

    public int getVersionCode() {
        return this.mgpaManager.getVersionCode();
    }

    public String getVersionName() {
        return this.mgpaManager.getVersionName();
    }

    public String getVmpNumber() {
        return this.mgpaManager.getVmpNumber();
    }

    public void init(Activity activity, String str) {
        this.mgpaManager.init(activity, str);
    }

    public synchronized void init(Context context) {
        this.mgpaManager.init(context);
    }

    public void init(Context context, String str) {
        this.mgpaManager.init(context, str);
    }

    public void initForCocos() {
        this.mgpaManager.initForCocos();
    }

    public void initForUE4() {
        this.mgpaManager.initForUE4();
    }

    public void initForUFO() {
        this.mgpaManager.initForUFO();
    }

    public void initForUnity() {
        this.mgpaManager.initForUnity();
    }

    public native void nativeNotifySystemInfo(String str);

    public void postGameMatchFPS(int i, ArrayList<Float> arrayList) {
        this.mgpaManager.postGameMatchFPS(i, arrayList);
    }

    public void registerCallback() {
        this.mgpaManager.registerCallback();
    }

    public void registerCallback(VmpCallback vmpCallback) {
        this.mgpaManager.registerCallback(vmpCallback);
    }

    public void registerCallbackForUnity() {
        this.mgpaManager.registerCallbackForUnity();
    }

    public void reportGameUserInfo(Context context, HashMap<String, String> hashMap) {
        this.mgpaManager.reportGameUserInfo(context, hashMap);
    }

    public void setLogAble(boolean z) {
        this.mgpaManager.setLogAble(z);
    }

    public void updateGameInfo(int i, float f) {
        this.mgpaManager.updateGameInfo(i, f);
    }

    public void updateGameInfo(int i, int i2) {
        this.mgpaManager.updateGameInfo(i, i2);
    }

    public void updateGameInfo(int i, String str) {
        this.mgpaManager.updateGameInfo(i, str);
    }

    public void updateGameInfo(int i, float[] fArr) {
        this.mgpaManager.updateGameInfo(i, fArr);
    }

    public void updateGameInfo(String str, String str2) {
        this.mgpaManager.updateGameInfo(str, str2);
    }

    public void updateGameInfo(String str, HashMap<String, String> hashMap) {
        this.mgpaManager.updateGameInfo(str, hashMap);
    }
}
