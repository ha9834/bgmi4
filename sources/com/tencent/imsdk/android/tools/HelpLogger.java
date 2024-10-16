package com.tencent.imsdk.android.tools;

import android.app.Activity;
import android.net.Uri;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class HelpLogger {
    public static void contextIsNull() {
        IMLogger.e("Context is null, this usually happens if you forgot to call initialize() function. Be sure to call initialise function for every module.", new Object[0]);
    }

    public static void activityIsNull(Activity activity) {
        IMLogger.e("Activity is null, this usually happens if you forgot to call initialize() function, or your app has been restart. Be sure to call initialise on every game start and restart for every module.", new Object[0]);
    }

    public static void channelIsNullOrEmpty() {
        IMLogger.e("Your channel string is empty. iMSDK's modules usually have 1+  plugin(s). You should call setChannel() before you call other functions. If you use modules such as Login, Relation(Friend), which have more than one channel, you should always be sure what channel you are in, and call setChannel() to switch between the channels.", new Object[0]);
    }

    public static void channelInstanceNotInit() {
        IMLogger.e("Channel instance is null because You did not call initialize(), or initialize failed", new Object[0]);
    }

    public static void channelSetFailed(String str, String str2) {
        IMLogger.e("setChanel('" + str + "') error, can't create module instance '" + str2 + "'. This happens because you give the wrong channel, or don't have the plugin, or need dependence files.", new Object[0]);
    }

    public static void channelInstanceIsNull() {
        IMLogger.e("Your channel instance is null. This will happen if you forget to call setChannel(), or set channel wrong string, or don't have the plugin.", new Object[0]);
    }

    public static void configMetaIsNullOrEmpty(String str, String str2) {
        IMLogger.e("can't not read meta key '" + str2 + "' from AndroidManifest.xml or iMSDK configure server. Update your configure and try again.", new Object[0]);
    }

    public static void moduleIsFused() {
        IMLogger.e("This module has been disable by iMSDK. Contact us for more information", new Object[0]);
    }

    public static void gameIdDefault() {
        IMLogger.w("You are using iMSDK test game ID 11. Do you forget to change game ID meta IMSDK_GAME_ID in AndroidManifest.xml ?", new Object[0]);
    }

    public static void gameIdError() {
        IMLogger.e("Game ID configure meta IMSDK_GAME_ID in AndroidManifest.xml is error, it should be a number like : 1xxx", new Object[0]);
    }

    public static void resultCheck(String str, IMSDKResult iMSDKResult) {
        if (iMSDKResult.imsdkRetCode != 1) {
            Uri.Builder encodedPath = new Uri.Builder().encodedPath(IMSDKConfig.getOrDefault(IR.config.IMSDK_DOCS_TOOL_URL, IR.url.IMSDK_DOCS_TOOL_URL));
            encodedPath.appendQueryParameter(IR.path.DOCS_IMSDK_CHANNEL, str);
            encodedPath.appendQueryParameter(IR.path.DOCS_IMSDK_CODE, String.valueOf(iMSDKResult.imsdkRetCode));
            encodedPath.appendQueryParameter(IR.path.DOCS_THIRD_CODE, String.valueOf(iMSDKResult.thirdRetCode));
            try {
                if (iMSDKResult.thirdRetMsg != null) {
                    encodedPath.appendQueryParameter(IR.path.DOCS_THIRD_MSG, URLEncoder.encode(iMSDKResult.thirdRetMsg, "UTF-8"));
                }
                if (iMSDKResult.retExtraJson != null) {
                    encodedPath.appendQueryParameter(IR.path.DOCS_EXTRA_MSG, URLEncoder.encode(iMSDKResult.retExtraJson, "UTF-8"));
                }
            } catch (Exception e) {
                IMLogger.e(e.getMessage(), new Object[0]);
            }
            IMLogger.w("Get error : " + iMSDKResult.imsdkRetCode + ", " + iMSDKResult.imsdkRetMsg + ". For more information, please check : " + System.getProperty("line.separator") + encodedPath.build().toString(), new Object[0]);
        }
    }

    public static void guestWillLost() {
        IMLogger.w("You are using install id as guest id. It means users will get a new guest id after they clean app's data or delete & install your app. You can change this behavior by modify meta IMSDK_GUEST_RESTORE to 'true' in AndroidManifest.xml", new Object[0]);
    }

    public static void guestWillRestore() {
        IMLogger.w("You are using multi device fingerprints as guest id. It mean iMSDK will TRY to restore the last guest id after users clean app's data or delete & install your app, and user MAY STILL lost their guest account.", new Object[0]);
    }
}
