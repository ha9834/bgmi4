package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class HawkNative {
    public static native void beginHawk();

    public static native void beginTupleWrap(String str);

    public static native void beignExclude();

    public static native int checkEmulator(String str, String str2);

    public static native void disableOpts(int i);

    public static native void enableLogPrint();

    public static native void enableTMode();

    public static native void enableTrackState();

    public static native void endExclude();

    public static native void endHawk();

    public static native void endTupleWrap();

    public static native int getFrames();

    public static native float getInstantFps();

    public static native String getPlatformInfo();

    public static native String getRomInfo();

    public static native float getSceneAvgFps();

    public static native float getSceneMeanFps(String str);

    public static native void initNativeDeviceInfo(long j, long j2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, int i4, int i5, String str7, String str8, int i6, int i7, int i8, int i9, String str9, String str10, int i10, int i11, float f, float f2);

    public static native void initNativeSession(String str, int i, String str2, int i2, int i3, int i4, String str3, String str4, int i5, String str5, String str6, long j, long j2, String str7, long j3, long j4);

    public static native void launchStreamEvent(String str);

    public static native void levelControl(int i, int i2, int i3, String str);

    public static native byte[] nativePackStepEventInfo(String str, int i, int i2, int i3, String str2, int i4, long j, int i5, int i6, String str3, String str4, String str5, String str6);

    public static native void packetAndSendByTDM(String str, int i, int i2, int i3, String str2, int i4, long j, int i5, int i6, String str3, String str4, String str5, String str6);

    public static native void postBatteryInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void postCpuCurFreqs(int[] iArr);

    public static native void postEvent(int i, String str);

    public static native void postFbStatus(int i, String str);

    public static native void postFrame(float f);

    public static native void postLagStatus(int i);

    public static native void postLargeValueS(String str, String str2, String str3);

    public static native void postMsgExt(int i, int i2, int i3, int i4, String str);

    public static native void postNTL(int i, int i2);

    public static native void postNTL2(int i, long j);

    public static native void postPssValue(int i);

    public static native void postStreamEvent(int i, int i2, int i3, String str, int i4);

    public static native void postTrackState(float f, float f2, float f3, float f4, float f5, float f6);

    public static native void postValue1F(String str, String str2, float f);

    public static native void postValue1I(String str, String str2, int i);

    public static native void postValue2F(String str, String str2, float f, float f2);

    public static native void postValue2I(String str, String str2, int i, int i2);

    public static native void postValue3F(String str, String str2, float f, float f2, float f3);

    public static native void postValue3I(String str, String str2, int i, int i2, int i3);

    public static native void postValueS(String str, String str2, String str3);

    public static native void postVmpStatus(int i, int i2, int i3, int i4, String str);

    public static native void processCCQualityCallback(int i);

    public static native void processRomCallback(int i);

    public static native int registerFBCallBack();

    public static native void requestPssSample();

    public static native void setAppStartupTime(int i);

    public static native void setDeviceClass(int i);

    public static native void setGQuality(int i);

    public static native void setGfxInfo(String str, String str2, String str3);

    public static native void setIdentifier(int i, String str);

    public static native void setLocale(String str, int i);

    public static native void setPssManualMode();

    public static native void setQccFetherTime(int i);

    public static native void setRevisedVersion(String str);

    public static native void setStrategy(int i, int i2, boolean z, boolean z2, boolean z3);

    public static native void setTargetFramerate(int i);

    public static native void setTencentQemuBlocked();

    public static native void setUserId(String str);

    public static native void setXid(String str, String str2);

    public static native void startNativeMonitoring();

    static {
        System.loadLibrary("cubehawk");
    }
}
