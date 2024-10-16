package com.shieldtunnel.svpn;

import com.shieldtunnel.svpn.common.jni.JniCallback;

/* loaded from: classes2.dex */
public class Jni {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f5768a;
    private static JniCallback b;

    private Jni() {
    }

    public static native void addDirectDomain(int i, byte[] bArr);

    public static native void defineConst(int i, byte[] bArr, byte[] bArr2);

    public static native void dialUpByIdList(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static native void dialUpByRegion(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static JniCallback getCallback() {
        return b;
    }

    public static void getConnectionOwnerUid(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        b.a(i, bArr, i2, bArr2, i3, i4);
    }

    public static native int getInt(int i, byte[] bArr, byte[] bArr2);

    public static native int getScriptBit(int i);

    public static native byte[] getString(int i, byte[] bArr, byte[] bArr2);

    public static void httpRequest(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        b.a(i, i2, bArr, bArr2, bArr3, bArr4);
    }

    public static native void httpResponse(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int init(int i, byte[] bArr, int i2, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static native void injectPCode(int i, byte[] bArr);

    public static native void listFolderResult(int i, int i2, byte[] bArr);

    public static native void loadDataResult(int i, int i2, byte[] bArr);

    public static native byte[] loadEcode();

    public static void onDeleteData(int i, byte[] bArr, byte[] bArr2) {
        b.a(i, bArr, bArr2);
    }

    public static native void onGetConnectionUidResult(int i, int i2);

    public static void onListFolder(int i, byte[] bArr) {
        b.a(i, bArr);
    }

    public static void onLoadData(int i, byte[] bArr, byte[] bArr2) {
        b.b(i, bArr, bArr2);
    }

    public static void onLuaError(int i, byte[] bArr) {
        b.a(bArr);
    }

    public static void onNodeDetectResult(int i, int i2, byte[] bArr) {
        b.a(i, i2, bArr);
    }

    public static void onSaveData(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        b.a(i, bArr, bArr2, bArr3, z);
    }

    public static void onTunnelEvent(int i, int i2, byte[] bArr) {
        b.b(i2, bArr);
    }

    public static native void processEvent();

    public static int protectFD(int i) {
        return b.a(i);
    }

    public static native void proxyLoop(int i, boolean z);

    public static JniCallback setCallback(JniCallback jniCallback) {
        JniCallback jniCallback2 = b;
        b = jniCallback;
        return jniCallback2;
    }

    public static native void setInt(int i, byte[] bArr, int i2);

    public static native void setString(int i, byte[] bArr, byte[] bArr2);

    public static void setUp(JniCallback jniCallback) {
        boolean z;
        synchronized (Jni.class) {
            z = f5768a;
            f5768a = true;
        }
        if (!z) {
            System.loadLibrary("st-engine");
        }
        b = jniCallback;
    }

    public static native void setVpnFd(int i, int i2);

    public static native void startNodeDetect(int i, byte[] bArr);

    public static native void stop(int i, boolean z);

    public static native void tearDown(int i);
}
