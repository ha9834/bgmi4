package com.tencent.grobot.lite.common;

/* loaded from: classes2.dex */
public class Const {
    public static final String BROADCAST_ACTION_CLOSE = "com.tencent.grobot.internal.action_close";
    public static final String BROADCAST_ACTION_CONFIGURATION_CHANGE = "android.intent.action.CONFIGURATION_CHANGED";
    public static final String GAME_AREA_KEY = "XIAOYUE_PREF_AREA";
    public static final String GAME_LOCALE_KEY = "XIAOYUE_PREF_LOCALE";
    public static final String GAME_PARAMETERS_KEY = "XIAOYUE_PREF_GAME_PARAMETERS";
    public static final String PREFERENCE_NAME = "XIAOYUE_PREF";
    public static final String VER_NAME = "2.2.0";

    public static String getSDKVersion() {
        return VER_NAME;
    }
}
