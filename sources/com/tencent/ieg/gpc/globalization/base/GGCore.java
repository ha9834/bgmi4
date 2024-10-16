package com.tencent.ieg.gpc.globalization.base;

import android.app.Activity;
import android.content.Intent;
import com.tencent.ieg.gpc.globalization.base.social.GGShare;
import com.tencent.ieg.gpc.globalization.base.social.GGShareManager;
import com.tencent.ieg.gpc.globalization.utils.GGLog;

/* loaded from: classes2.dex */
public class GGCore {
    private static String TAG = "GGCore";
    private static String mIMSDKChannelId = "";
    private static String mIMSDKGameId = "";
    private static String mOpenid = "";
    private static String mToken = "";
    private static GGShareManager shareManager;

    public static void initialize(Activity activity) {
        GGConfig.initialize(activity);
        if (shareManager == null) {
            shareManager = new GGShareManager(activity);
        }
    }

    public static void setAccountInfo(String str, String str2, String str3) {
        GGLog.d(TAG, "in setupAccountInfo  openid=" + str + " token=" + str2);
        mOpenid = str;
        mToken = str2;
    }

    public static String getOpenid() {
        return mOpenid;
    }

    public static String getToken() {
        return mToken;
    }

    public static void activityResultHandler(int i, int i2, Intent intent) {
        GGShare currentShare;
        GGShareManager gGShareManager = shareManager;
        if (gGShareManager == null || (currentShare = gGShareManager.getCurrentShare()) == null) {
            return;
        }
        currentShare.activityResultHandler(i, i2, intent);
    }

    public static GGShareManager getShareManager() {
        GGShareManager gGShareManager = shareManager;
        if (gGShareManager != null) {
            return gGShareManager;
        }
        GGLog.e(TAG, "Call GGCore.initialize first please!!!");
        return null;
    }
}
