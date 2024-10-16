package com.tencent.imsdk.android.discord;

import com.tencent.imsdk.android.api.config.IMSDKConfig;

/* loaded from: classes.dex */
public class DiscordConstants {
    public static final int DISCORD_CHANNEL_ID = 39;
    public static String DISCORD_DB_NAME = "imsdk_discord";
    public static String IMSDK_DISCORD_APP_ID = "IMSDK_DISCORD_APP_ID";
    public static String IMSDK_DISCORD_CALLBACK_URL = "IMSDK_DISCORD_CALLBACK_URL";
    public static String IMSDK_DISCORD_INTENT_ACTION = "action";
    public static String IMSDK_DISCORD_INTENT_ACTION_LOGIN = "discord_login";
    public static String IMSDK_DISCORD_INTENT_PERMISSIONS = "permissions";
    public static String IMSDK_DISCORD_SCHEME = "IMSDK_DISCORD_SCHEME";
    public static String IMSDK_DISCORD_SCHEME_PATH = "IMSDK_DISCORD_SCHEME_PATH";

    public static String getDiscordApId() {
        String str = IMSDK_DISCORD_APP_ID;
        return IMSDKConfig.getOrMetaData(str, str, "");
    }

    public static String getCallbackUriClientExchange(boolean z) {
        String orMetaData;
        if (z) {
            String str = IMSDK_DISCORD_SCHEME;
            orMetaData = IMSDKConfig.getOrMetaData(str, str, "");
        } else {
            String str2 = IMSDK_DISCORD_CALLBACK_URL;
            orMetaData = IMSDKConfig.getOrMetaData(str2, str2, "");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(orMetaData);
        String str3 = IMSDK_DISCORD_SCHEME_PATH;
        sb.append(IMSDKConfig.getOrMetaData(str3, str3, ""));
        return sb.toString();
    }
}
