package com.xiaomi.boostersdk;

import android.content.Context;
import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GameBoosterProxy {
    private static final String RESULT = "result";
    private static final String TAG = "GameBoosterProxy";
    private static boolean mHasRegisterThermalListener;

    public static void applyHardwareResource(String str) {
        if (!GameHandleController.checkIfSupportGameBooster()) {
            Log.e(TAG, "the system dont support the gamebooster");
            return;
        }
        try {
            ReflectUtil.callStaticObjectMethod(Class.forName("com.xiaomi.joyose.JoyoseManager"), "handleGameBoosterForOneway", new Class[]{Integer.TYPE, String.class}, 2, str);
        } catch (Exception e) {
            Log.e(TAG, "the call throw an exception " + e.toString());
        }
    }

    public static boolean checkIfSupportGameBooster() {
        Boolean bool = false;
        if (!GameHandleController.checkIfSupportGameBooster()) {
            Log.e(TAG, "the system dont support the gamebooster");
            return false;
        }
        try {
            String str = (String) ReflectUtil.callStaticObjectMethod(Class.forName("com.xiaomi.joyose.JoyoseManager"), "handleGameBoosterForSync", new Class[]{Integer.TYPE, String.class}, 1001, null);
            if (str != null) {
                bool = Boolean.valueOf(new JSONObject(str).optBoolean(RESULT, false));
            }
        } catch (Exception e) {
            Log.e(TAG, "the call throw an exception " + e.toString());
        }
        return bool.booleanValue();
    }

    public static String getPlatformShareGameData(int i, String str) {
        if (i <= 0) {
            Log.e(TAG, "the cmd id is invalid");
            return null;
        }
        if (!GameHandleController.checkIfSupportGameBooster()) {
            Log.e(TAG, "the system dont support the gamebooster");
            return null;
        }
        try {
            return (String) ReflectUtil.callStaticObjectMethod(Class.forName("com.xiaomi.joyose.JoyoseManager"), "handleGameBoosterForSync", new Class[]{Integer.TYPE, String.class}, Integer.valueOf(i), str);
        } catch (Exception e) {
            Log.e(TAG, "the call throw an exception " + e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean registerSystemCallback(Context context, SystemCallback systemCallback) {
        return GameHandleController.registerSystemCallback(context, systemCallback);
    }

    public static void registerThermalControlListener(Context context, GameBoosterEngineCallback gameBoosterEngineCallback) {
        GameHandleController.registerThermalControlListener(context, gameBoosterEngineCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean unregisterSystemCallback(Context context, SystemCallback systemCallback) {
        return GameHandleController.unregisterSystemCallback(context, systemCallback);
    }

    public static void unregisterThermalControlListener(Context context, GameBoosterEngineCallback gameBoosterEngineCallback) {
        GameHandleController.unregisterThermalControlListener(context, gameBoosterEngineCallback);
    }

    public static void updateGameInfo(String str) {
        if (!GameHandleController.checkIfSupportGameBooster()) {
            Log.e(TAG, "the system dont support the gamebooster");
            return;
        }
        try {
            ReflectUtil.callStaticObjectMethod(Class.forName("com.xiaomi.joyose.JoyoseManager"), "handleGameBoosterForOneway", new Class[]{Integer.TYPE, String.class}, 1, str);
        } catch (Exception e) {
            Log.e(TAG, "the call throw an exception " + e.toString());
        }
    }
}
