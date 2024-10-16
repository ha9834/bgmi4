package com.xiaomi.boostersdk;

import android.content.Context;

/* loaded from: classes3.dex */
public class GameBoosterManager {
    public static void applyHardwareResource(String str) {
        GameBoosterProxy.applyHardwareResource(str);
    }

    public static boolean checkIfSupportGameBooster() {
        return GameBoosterProxy.checkIfSupportGameBooster();
    }

    public static String getPlatformShareGameData(int i, String str) {
        return GameBoosterProxy.getPlatformShareGameData(i, str);
    }

    public static boolean registerSystemCallback(Context context, SystemCallback systemCallback) {
        return GameBoosterProxy.registerSystemCallback(context, systemCallback);
    }

    public static void registerThermalControlListener(Context context, GameBoosterEngineCallback gameBoosterEngineCallback) {
        GameBoosterProxy.registerThermalControlListener(context, gameBoosterEngineCallback);
    }

    public static boolean unregisterSystemCallback(Context context, SystemCallback systemCallback) {
        return GameBoosterProxy.unregisterSystemCallback(context, systemCallback);
    }

    public static void unregisterThermalControlListener(Context context, GameBoosterEngineCallback gameBoosterEngineCallback) {
        GameBoosterProxy.unregisterThermalControlListener(context, gameBoosterEngineCallback);
    }

    public static void updateGameInfo(String str) {
        GameBoosterProxy.updateGameInfo(str);
    }
}
