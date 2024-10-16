package com.subao.vpn;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.subao.common.j.f;
import com.subao.common.k.g;

/* loaded from: classes2.dex */
public class VPNJni {

    /* renamed from: a, reason: collision with root package name */
    private static volatile JniCallback f6147a;
    private static boolean b;
    private static String c;

    public static native void addAccelAddress(int i, int i2, String str, int i3);

    public static native void addLobbyAddress(int i, int i2, String str, int i3);

    public static native void addNewArenaAddress(int i, int i2, String str, int i3);

    public static native void answerLteInfo(int i, int i2, String str);

    public static native void clearAccelAddresses(int i);

    public static native void closeQosAccelResult(int i, int i2);

    public static native void defineConst(int i, byte[] bArr, byte[] bArr2);

    public static native int getAccelRecommendation(int i);

    public static native String getAccelRecommendationData(int i, int i2);

    public static native int getAccelerationStatus(int i);

    public static native String getBaseUrl(int i);

    public static native int getIOThreadID(int i);

    public static native int getInt(int i, String str, String str2);

    public static native int getLobbyIsProxy(int i, String str, int i2);

    public static native boolean getProxyIsStart(int i);

    public static native boolean getSDKUDPIsProxy(int i);

    public static native int getScriptBit(int i);

    public static native String getVIPValidTime(int i);

    public static native String getWebUIUrl(int i, int i2);

    public static native void httpResponse(int i, int i2, String str);

    public static native boolean init(int i, byte[] bArr, int i2, int i3, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7);

    public static native void injectPCode(int i, byte[] bArr);

    public static native boolean isNodeDetected(int i, int i2);

    public static native void linkAuthResult(int i, boolean z, int i2, byte[] bArr, byte[] bArr2, int i3);

    public static native byte[] loadEcode();

    public static native void modifyQosAccelResult(int i, int i2, int i3);

    public static native int networkCheck(int i);

    public static native void onAccelRecommendationResult(int i, int i2, boolean z);

    public static native void onEnableMTKNDPPResult(int i, boolean z);

    public static native void onLoadDataResult(int i, byte[] bArr);

    public static native void onMTKAuthResult(int i, boolean z);

    public static native void onMTKStartMobileAccelResult(int i, boolean z);

    public static native void onMTKStartNDPPResult(int i, boolean z);

    public static native void onMTKStopMobileAccelResult(int i, boolean z);

    public static native void onMTKStopNDPPResult(int i, boolean z);

    public static native void onMTKUpdateLinkResult(int i, boolean z);

    public static native void onNDPPStateChanged(int i, int i2);

    public static native void onNetDelayQuality4(int i, float f, float f2);

    public static native void onUDPDelay(int i, int i2);

    public static native void openQosAccelResult(int i, byte[] bArr, byte[] bArr2, int i2);

    public static native void processEvent();

    public static native void proxyLoop(int i, boolean z);

    public static native void qosPrepareResult(int i, String str, String str2);

    public static native void refreshUserState(int i, int i2);

    public static native void requestMobileFDResult(int i, int i2, int i3, int i4, boolean z);

    public static native void setInt(int i, byte[] bArr, int i2);

    public static native void setIsMTKNDPPEnable(int i, boolean z);

    public static native void setRecommendationGameIP(int i, byte[] bArr, int i2);

    public static native void setString(int i, byte[] bArr, byte[] bArr2);

    public static native void setUDPEchoPort(int i, int i2);

    public static native void setUserToken(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int shouldRemindPurchase();

    public static native void startNodeDetect(int i, int i2);

    public static native boolean startProxy(int i);

    private static native boolean startVPN(int i, int i2);

    public static native void stopProxy(int i);

    private static native void stopVPN(int i);

    public static native void userAuthResult(int i, boolean z, int i2, byte[] bArr, int i3, byte[] bArr2, int i4, byte[] bArr3, byte[] bArr4, int i5, int i6, int i7, int i8, byte[] bArr5, byte[] bArr6);

    public static native void userConfigResult(int i, boolean z, int i2, byte[] bArr);

    public static native void userStateResult(int i, boolean z, int i2, int i3, byte[] bArr, byte[] bArr2);

    private VPNJni() {
    }

    public static void loadLibrary(JniCallback jniCallback, String str) {
        f6147a = jniCallback;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (VPNJni.class) {
            if (b) {
                return;
            }
            b = true;
            System.loadLibrary(str);
        }
    }

    public static void loadMTKLibrary() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                System.loadLibrary("npps-jni");
            } catch (Error | Exception e) {
                e.printStackTrace();
                c = "mtk_so_loading_error";
            }
        }
    }

    public static String getOtherLibraryLoadingError() {
        return c;
    }

    public static void resetOtherLibraryLoadingError() {
        c = null;
    }

    public static JniCallback setCallback(JniCallback jniCallback) {
        JniCallback jniCallback2 = f6147a;
        f6147a = jniCallback;
        return jniCallback2;
    }

    public static JniCallback getCallback() {
        return f6147a;
    }

    public static boolean doStartVPN(int i) {
        return startVPN(0, i);
    }

    public static void doStopVPN() {
        stopVPN(0);
    }

    public static void onProxyActive(int i, boolean z) {
        f6147a.a(z);
    }

    public static void userAuth(int i, int i2, String str, String str2, String str3) {
        f6147a.a(i, i2, str, str2, str3);
    }

    public static void linkAuth(int i, int i2, String str) {
        f6147a.a(i, f.c(f.b(i2)), str);
    }

    public static void userConfig(int i, String str, String str2) {
        f6147a.b(i, str, str2);
    }

    public static void userState(int i, int i2, String str, String str2) {
        f6147a.a(i, i2, str, str2);
    }

    public static void onLuaError(int i, String str) {
        f6147a.b(str);
    }

    public static void requestMobileFD(int i, String str, int i2, int i3) {
        if (i3 == g.MOBILE.c) {
            f6147a.a(i);
        } else {
            f6147a.b(i);
        }
    }

    public static void onLinkMessage(int i, String str, String str2, boolean z) {
        f6147a.a(str, str2, z);
    }

    public static void onQosMessage(int i, String str) {
        f6147a.c(str);
    }

    public static void getISP(int i) {
        f6147a.c(i);
    }

    public static void onReportEvent(int i, String str) {
        f6147a.a(str);
    }

    public static void onAccelInfoUpload(int i, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            Log.w("SubaoProxy", "onAccelInfoUpload, userId is empty");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("SubaoProxy", "onAccelInfoUpload, content is empty");
        } else {
            f6147a.a(str, str2, str3);
        }
    }

    public static void onCacheData(int i, String str, String str2) {
        f6147a.a(str, str2);
    }

    public static void onLoadData(int i, String str) {
        f6147a.a(i, str);
    }

    public static void requestBeaconCounter(int i, String str) {
        f6147a.b(i, str);
    }

    public static int protectFD(int i) {
        return f6147a.d(i);
    }

    public static void onQPPVicePathFlow(int i, int i2, String str, int i3, int i4, int i5) {
        f6147a.a(i2, str, i3, i4, i5);
    }

    public static void updateState(String str, int i) {
        f6147a.a(str, i);
    }

    public static void onCouponExchange(int i, String str, String str2, String str3) {
        f6147a.b(str, str2, str3);
    }

    public static void createOrders(int i, String str, int i2, String str2) {
        f6147a.a(i, str, i2, str2);
    }

    public static void httpRequest(int i, int i2, String str, String str2, String str3, String str4) {
        f6147a.a(i, i2, str, str2, str3, str4);
    }

    public static void qosPrepare(int i, String str, String str2, String str3, int i2) {
        f6147a.a(i, str, str2, str3, i2);
    }

    public static void askLteInfo(int i) {
        f6147a.e(i);
    }

    public static void updateLinkForNDPP(int i, String str, int i2, String str2, int i3, int i4) {
        f6147a.a(i, str, i2, str2, i3, i4);
    }

    public static void startMTKAuth(int i, String str, String str2, String str3) {
        f6147a.a(i, str, str2, str3);
    }

    public static void startNetworkLatencyOptimization(int i, int i2, String str, String str2, int i3, int i4) {
        Log.d("SubaoParallel", String.format("startNetworkLatencyOptimization, cid = %d, mode = %d, pkg = %s, timetou = %d, rc = %d", Integer.valueOf(i), Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i4)));
        f6147a.a(i, i2, str, str2, i3, i4);
    }

    public static void stopNetworkLatencyOptimization(int i, int i2) {
        f6147a.a(i, i2);
    }

    public static void enableDuplicatePacketPredictionCapability(int i, int i2) {
        f6147a.b(i, i2);
    }

    public static void disableDuplicatePacketPredictionCapability(int i) {
        f6147a.f(i);
    }

    public static void isDupPacketPredictionEnabled(int i) {
        f6147a.g(i);
    }

    public static void startDuplicatePacketPrediction(int i) {
        f6147a.h(i);
    }

    public static void stopDuplicatePacketPrediction(int i) {
        f6147a.i(i);
    }
}
