package com.tencent.imsdk.android.login.migrate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MigrateLogin extends IMSDKLoginBase {
    private static final String IMSDK_EXTRA_JSON_TAG = "retExtraJson";
    private static final String IMSDK_GUEST_CHANNEL = "Guest";
    private static final String IMSDK_GUEST_CHANNEL_KEY = "com.tencent.imsdk.android.base.login.GuestLogin";
    private static final String IMSDK_MIGRATE_ACCOUNT_PATH = "account/migrateAccount";
    private static final String IMSDK_MIGRATE_METHOD_TAG = "isMigrateMethod";
    private static final String IMSDK_MIGRATE_SERVER_RESP_CODE_KEY = "code";
    private static final int IMSDK_MIGRATE_SERVER_SUCCESS_CODE = 7;
    private String mLoggedInChannel;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 0;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return true;
    }

    public MigrateLogin(Context context) {
        super(context);
        IMLogger.d("MigrateLogin initialized ");
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        if (!T.ckIsEmpty(str)) {
            this.mLoggedInChannel = str;
            IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
            if (loginResult != null && loginResult.imsdkRetCode == 1001) {
                IMLogger.e("no login data, please login first ", new Object[0]);
                iMSDKListener.onResult(getLoginResultWithMethodTag(10, 10, "no login data"));
                return;
            } else {
                IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.migrate.MigrateLogin.1
                    public static final int REQUEST_MIGRATE_LOGIN = 1002;
                    public boolean alreadyCallBack = false;

                    @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                    protected void onActivityCreate(Bundle bundle, Activity activity) {
                        activity.startActivityForResult(new Intent(activity, (Class<?>) MigrateWebActivity.class), 1002);
                    }

                    @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                    protected boolean onActivityResult(int i, int i2, Intent intent) {
                        IMLogger.d("onActivityResult resultcode: " + i + " resultcode: " + i2);
                        if (i != 1002) {
                            return true;
                        }
                        if (i2 == 0) {
                            iMSDKListener.onResult(MigrateLogin.this.getLoginResultWithMethodTag(2, 2, "user cancel"));
                            return true;
                        }
                        if (intent == null || intent.getExtras() == null) {
                            iMSDKListener.onResult(MigrateLogin.this.getLoginResultWithMethodTag(11, 11, "migrate web callback data error"));
                            return true;
                        }
                        if (intent.getExtras().getInt("ret") != 0) {
                            iMSDKListener.onResult(MigrateLogin.this.getLoginResultWithMethodTag(11, 11, "migrate web callback data error"));
                            return true;
                        }
                        IMLogger.d("migrate web login success");
                        MigrateWebAuthData migrateWebAuthData = new MigrateWebAuthData();
                        migrateWebAuthData.openid = intent.getExtras().getString("openid");
                        migrateWebAuthData.innertoken = intent.getExtras().getString(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_INNER_TOKEN);
                        migrateWebAuthData.gameid = intent.getExtras().getString(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID);
                        migrateWebAuthData.channelId = intent.getExtras().getString("channelId");
                        MigrateLogin.this.connectIMSDK(false, MigrateLogin.IMSDK_MIGRATE_ACCOUNT_PATH, MigrateLogin.this.fillParamsWithData(migrateWebAuthData), (IMSDKResultListener) iMSDKListener);
                        return true;
                    }
                });
                return;
            }
        }
        IMLogger.e("please specify the current logged in channel as the subchannel parameters ", new Object[0]);
        iMSDKListener.onResult(getLoginResultWithMethodTag(11, 11, "subchannel is empty"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> fillParamsWithData(MigrateWebAuthData migrateWebAuthData) {
        IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
        IMLogger.d("get login result in MigrateLogin: " + loginResult);
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iChannel", loginResult.channelId + "");
        sortableMap.put("iOpenid", loginResult.openId);
        sortableMap.put("sInnerToken", loginResult.innerToken);
        sortableMap.put("iSrcGameId", migrateWebAuthData.gameid);
        sortableMap.put("iSrcOpenid", migrateWebAuthData.openid);
        sortableMap.put("iSrcChannel", migrateWebAuthData.channelId);
        sortableMap.put("sSrcInnerToken", migrateWebAuthData.innertoken);
        return sortableMap;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public String getSqlChannelKey() {
        String str;
        if (T.ckIsEmpty(this.mLoggedInChannel) || this.mLoggedInChannel.equals(IMSDK_GUEST_CHANNEL)) {
            str = IMSDK_GUEST_CHANNEL_KEY;
        } else {
            str = "com.tencent.imsdk.android.login." + this.mLoggedInChannel.toLowerCase() + "." + this.mLoggedInChannel + "Login";
        }
        IMLogger.d("MigrateLogin get channel key is: " + str);
        return str;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        IMLogger.d("modifyLoginResultAsChannel " + iMSDKLoginResult);
        IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
        if (iMSDKLoginResult.imsdkRetCode == 1) {
            IMLogger.d("serverLoginResult RetCode: " + iMSDKLoginResult.imsdkRetCode);
            loginResult.imsdkRetCode = 1;
            loginResult.openId = iMSDKLoginResult.openId;
            loginResult.innerToken = iMSDKLoginResult.innerToken;
            loginResult.innerTokenExpire = iMSDKLoginResult.innerTokenExpire;
            loginResult.retExtraJson = iMSDKLoginResult.retExtraJson;
        }
        return loginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase, com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        if (str == IMSDK_MIGRATE_ACCOUNT_PATH) {
            str = "user/login";
            try {
                JSONObject jSONObject = new JSONObject(IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey()).retExtraJson);
                jSONObject.put(IMSDK_MIGRATE_METHOD_TAG, 1);
                JSONObject jSONObject2 = new JSONObject(bArr != null ? new String(bArr, "UTF-8") : "");
                if (jSONObject2.getInt(IMSDK_MIGRATE_SERVER_RESP_CODE_KEY) == 7) {
                    IMLogger.d("migrate retCode is 7, transfer to success code");
                    jSONObject2.remove(IMSDK_MIGRATE_SERVER_RESP_CODE_KEY);
                    jSONObject2.put(IMSDK_MIGRATE_SERVER_RESP_CODE_KEY, 1);
                }
                jSONObject2.put(IMSDK_EXTRA_JSON_TAG, jSONObject.toString());
                bArr = jSONObject2.toString().getBytes();
            } catch (UnsupportedEncodingException | JSONException e) {
                IMLogger.e("json parse error: " + e.getMessage(), new Object[0]);
            }
        }
        return super.handleServerData(str, bArr, map);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        CookieManager cookieManager = CookieManager.getInstance();
        for (String str : Arrays.asList(this.mCurCtx.getResources().getStringArray(MigrateResourceUtil.getArrayId(this.mCurCtx, MigrateWebConsts.MIGRATE_DOMAIN_ARRAY)))) {
            IMLogger.d("cookie for " + str + " before clear\n" + cookieManager.getCookie(str));
            clearCookiesForDomain(this.mCurCtx, str);
            IMLogger.d("cookie for " + str + " after clear\n" + cookieManager.getCookie(str));
        }
        iMSDKResultListener.onResult(getLoginResultWithMethodTag(1, 1, "logout success"));
    }

    private static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            String[] split = str2.split("=");
            if (split.length > 0) {
                cookieManager.setCookie(str, split[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        cookieManager.removeExpiredCookie();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IMSDKLoginResult getLoginResultWithMethodTag(int i, int i2, String str) {
        IMSDKLoginResult iMSDKLoginResult = new IMSDKLoginResult(i, i2, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IMSDK_MIGRATE_METHOD_TAG, 1);
        } catch (JSONException e) {
            IMLogger.e("json parse error : " + e.getMessage(), new Object[0]);
        }
        iMSDKLoginResult.retExtraJson = jSONObject.toString();
        return iMSDKLoginResult;
    }
}
