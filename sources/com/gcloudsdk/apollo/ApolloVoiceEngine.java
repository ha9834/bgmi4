package com.gcloudsdk.apollo;

/* loaded from: classes.dex */
public class ApolloVoiceEngine {
    public static final native String GetDeviceBrand();

    public static final native String GetDeviceModel();

    public static final native boolean GetHeadsetVoipState();

    public static final native boolean IsPause();

    public static final native void OnEvent(int i, String str);

    public static final native int Pause();

    public static final native int Resume();

    public static final native void SetBluetoothState(boolean z);

    public static final native void SetHeadSetState(boolean z);

    public static final native int StartBlueTooth();

    public static final native int StopBlueTooth();

    static {
        try {
            System.loadLibrary("GCloudVoice");
        } catch (UnsatisfiedLinkError unused) {
            System.err.println("load library failed!!!");
        }
    }
}
