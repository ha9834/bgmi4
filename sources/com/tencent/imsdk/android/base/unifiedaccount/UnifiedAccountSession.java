package com.tencent.imsdk.android.base.unifiedaccount;

import android.content.Context;
import com.tencent.imsdk.android.api.login.IMSDKLogin;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.tools.PreferencesUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class UnifiedAccountSession {
    private static final String PREF_FILE = "imsdk_unified_account";
    private static UnifiedAccountToken cachedToken;

    public static boolean updateToken(Context context, String str, int i) {
        return true;
    }

    private static PreferencesUtils getPrefUtil() {
        PreferencesUtils preferencesUtils = new PreferencesUtils();
        preferencesUtils.setPreferenceFileName(PREF_FILE);
        return preferencesUtils;
    }

    private static String getAccountKey(String str, int i) {
        IMSDKLoginResult loginResult = IMSDKLogin.getLoginResult();
        if (loginResult != null && loginResult.imsdkRetCode == 1 && loginResult.openId != null) {
            return IMSDKLogin.getLoginResult().openId;
        }
        IMLogger.w("current channel is not login yet " + loginResult.channel + ", " + loginResult.openId, new Object[0]);
        return null;
    }

    public static boolean setToken(Context context, UnifiedAccountToken unifiedAccountToken) {
        PreferencesUtils prefUtil;
        String accountKey;
        try {
            prefUtil = getPrefUtil();
            accountKey = getAccountKey(unifiedAccountToken.account, unifiedAccountToken.accountType);
        } catch (Exception e) {
            IMLogger.e("cache token failed : " + e.getMessage(), new Object[0]);
        }
        if (accountKey != null) {
            String unityString = unifiedAccountToken.toUnityString();
            IMLogger.d("set unified account login cache : " + accountKey + "->" + unityString);
            return prefUtil.putString(context, accountKey, unityString);
        }
        cachedToken = unifiedAccountToken;
        return false;
    }

    public static UnifiedAccountToken getToken(Context context, String str, int i) {
        try {
            String accountKey = getAccountKey(str, i);
            if (accountKey != null) {
                String string = getPrefUtil().getString(context, accountKey, "");
                IMLogger.d("get cached unified account : " + accountKey + "->" + string);
                UnifiedAccountToken unifiedAccountToken = new UnifiedAccountToken(string);
                if (unifiedAccountToken.account != null && unifiedAccountToken.account.equals(str) && unifiedAccountToken.accountType == i && !T.ckIsEmpty(unifiedAccountToken.uid) && !T.ckIsEmpty(unifiedAccountToken.token)) {
                    return unifiedAccountToken;
                }
            } else {
                IMLogger.e("cannot get unified account key !", new Object[0]);
            }
            return null;
        } catch (Exception e) {
            IMLogger.e("get saved token failed : " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static boolean updateToken(Context context) {
        UnifiedAccountToken unifiedAccountToken = cachedToken;
        if (unifiedAccountToken == null) {
            return false;
        }
        boolean token = setToken(context, unifiedAccountToken);
        cachedToken = null;
        return token;
    }

    public static void cleanToken(Context context, String str, int i) {
        try {
            PreferencesUtils prefUtil = getPrefUtil();
            String accountKey = getAccountKey(str, i);
            if (accountKey != null) {
                prefUtil.remove(context, accountKey);
            }
        } catch (Exception e) {
            IMLogger.e("clean token failed : " + e.getMessage(), new Object[0]);
        }
    }
}
