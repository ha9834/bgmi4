package com.google.androidgamesdk;

/* loaded from: classes2.dex */
public class GameSdkDeviceInfoJni {
    private static Throwable initializationExceptionOrError;

    private static native byte[] getProtoSerialized();

    static {
        try {
            System.loadLibrary("game_sdk_device_info_jni");
        } catch (Error e) {
            initializationExceptionOrError = e;
        } catch (Exception e2) {
            initializationExceptionOrError = e2;
        }
    }

    public static byte[] tryGetProtoSerialized() {
        if (initializationExceptionOrError != null) {
            return null;
        }
        return getProtoSerialized();
    }

    public static Throwable getInitializationExceptionOrError() {
        return initializationExceptionOrError;
    }

    private GameSdkDeviceInfoJni() {
    }
}
