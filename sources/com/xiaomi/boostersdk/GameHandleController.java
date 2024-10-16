package com.xiaomi.boostersdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/* loaded from: classes3.dex */
public class GameHandleController {
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String SERVICE_NAME = "miui.whetstone";
    private static final String TAG = "GameHandleController";
    private static boolean mHasRegisterThermalListener;
    private static boolean mSetting;
    private static GameBoosterEngineCallback sCallBack;
    private static boolean sSupport;
    private static SystemCallback sSystemCallback;
    private static BroadcastReceiver mThermalControlReceiver = new BroadcastReceiver() { // from class: com.xiaomi.boostersdk.GameHandleController.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !Constants.ACTION_THERMAL_CONTROL_CHANGE.equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra(Constants.INTENT_EXTRA_CUR_THERMAL_LEVEL, 0);
            if (GameHandleController.sCallBack == null || !GameHandleController.mHasRegisterThermalListener) {
                return;
            }
            GameHandleController.sCallBack.onThermalControlChanged(intExtra);
        }
    };
    private static boolean sHasRegisterSystemCallback = false;
    private static BroadcastReceiver sSystemCallbackReceiver = new BroadcastReceiver() { // from class: com.xiaomi.boostersdk.GameHandleController.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !Constants.ACTION_SYSTEM_CALLBACK.equals(intent.getAction())) {
                return;
            }
            String stringExtra = intent.getStringExtra(Constants.INTENT_EXTRA_SYSTEM_CALLBACK_KEY);
            String stringExtra2 = intent.getStringExtra(Constants.INTENT_EXTRA_SYSTEM_CALLBACK_VALUE);
            if (GameHandleController.sSystemCallback == null || !GameHandleController.sHasRegisterSystemCallback) {
                return;
            }
            GameHandleController.sSystemCallback.systemCallback(stringExtra, stringExtra2);
        }
    };

    public static boolean checkIfSupportGameBooster() {
        if (!mSetting) {
            sSupport = (SystemProperties.get(KEY_MIUI_VERSION_CODE, null) == null && SystemProperties.get(KEY_MIUI_VERSION_NAME, null) == null && SystemProperties.get(KEY_MIUI_INTERNAL_STORAGE, null) == null) ? false : true;
            mSetting = true;
        }
        return sSupport;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean registerSystemCallback(Context context, SystemCallback systemCallback) {
        String str;
        String str2;
        if (sHasRegisterSystemCallback) {
            str = TAG;
            str2 = "registerSystemCallback failed! you have registered SystemCallback.";
        } else {
            if (checkIfSupportGameBooster()) {
                context.registerReceiver(sSystemCallbackReceiver, new IntentFilter(Constants.ACTION_SYSTEM_CALLBACK));
                sSystemCallback = systemCallback;
                sHasRegisterSystemCallback = true;
                return true;
            }
            str = TAG;
            str2 = "registerSystemCallback failed! The system isn't supported.";
        }
        Log.w(str, str2);
        return false;
    }

    public static void registerThermalControlListener(Context context, GameBoosterEngineCallback gameBoosterEngineCallback) {
        if (mHasRegisterThermalListener || !checkIfSupportGameBooster()) {
            return;
        }
        context.registerReceiver(mThermalControlReceiver, new IntentFilter(Constants.ACTION_THERMAL_CONTROL_CHANGE));
        sCallBack = gameBoosterEngineCallback;
        mHasRegisterThermalListener = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean unregisterSystemCallback(Context context, SystemCallback systemCallback) {
        if (!sHasRegisterSystemCallback) {
            Log.w(TAG, "unregisterSystemCallback failed! you haven't registered SystemCallback.");
            return false;
        }
        context.unregisterReceiver(sSystemCallbackReceiver);
        sHasRegisterSystemCallback = false;
        return true;
    }

    public static void unregisterThermalControlListener(Context context, GameBoosterEngineCallback gameBoosterEngineCallback) {
        if (mHasRegisterThermalListener) {
            context.unregisterReceiver(mThermalControlReceiver);
            mHasRegisterThermalListener = false;
        }
    }
}
