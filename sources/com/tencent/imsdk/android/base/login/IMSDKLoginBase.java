package com.tencent.imsdk.android.base.login;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKBindInfoResult;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONException;

@Keep
/* loaded from: classes.dex */
public abstract class IMSDKLoginBase extends IMSDKManagerBase {
    private String mCurrentChannel;
    private IMSDKLoginResult mScrLoginResultCacheWhenBind;
    private IMSDKLoginResult mScrLoginResultCacheWhenRefresh;

    @Keep
    /* loaded from: classes.dex */
    public enum LoginAction {
        LOGIN,
        BIND
    }

    public abstract int getChannelId();

    public abstract boolean isChannelLogin();

    public abstract void login2Channel(LoginAction loginAction, String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr);

    public abstract IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult);

    public IMSDKLoginBase(Context context) {
        super(context);
        this.mCurCtx = context;
        this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_LOGIN, "Init<IMSDKLoginBase>");
    }

    private IMSDKResult createIMSDKResult(String str, int i, int i2, String str2) {
        if (str.equals(IR.path.LOGOUT_PATH)) {
            return new IMSDKResult(i, i2, str2);
        }
        if (str.equals("bind/bindRelationInfo")) {
            return new IMSDKBindInfoResult(i, i2, str2);
        }
        return new IMSDKLoginResult(i, i2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithResult(IMSDKLoginResult iMSDKLoginResult, Map<String, String> map) {
        if (iMSDKLoginResult == null || iMSDKLoginResult.imsdkRetCode != 1) {
            return;
        }
        map.put("sInnerToken", iMSDKLoginResult.innerToken);
        map.put("iOpenid", iMSDKLoginResult.openId);
        map.put("iChannel", String.valueOf(iMSDKLoginResult.channelId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnLRByError(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, IMSDKResult iMSDKResult) {
        if (iMSDKResult instanceof IMSDKLoginResult) {
            iMSDKResultListener.onResult((IMSDKLoginResult) iMSDKResult);
        } else {
            iMSDKResultListener.onResult(new IMSDKLoginResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg));
        }
    }

    private IMSDKLoginResult modifyLoginResultWhenProcessBind(String str, IMSDKLoginResult iMSDKLoginResult) {
        if (this.mScrLoginResultCacheWhenBind != null && str.equals("bind/bindRelationInfo") && iMSDKLoginResult.channelId == this.mScrLoginResultCacheWhenBind.channelId) {
            iMSDKLoginResult.channel = this.mScrLoginResultCacheWhenBind.channel;
            iMSDKLoginResult.channelToken = this.mScrLoginResultCacheWhenBind.channelToken;
            iMSDKLoginResult.channelUserId = this.mScrLoginResultCacheWhenBind.channelUserId;
            iMSDKLoginResult.channelTokenExpire = this.mScrLoginResultCacheWhenBind.channelTokenExpire;
            iMSDKLoginResult.channelPermissions = this.mScrLoginResultCacheWhenBind.channelPermissions;
        }
        return iMSDKLoginResult;
    }

    private IMSDKLoginResult modifyLoginResultWhenProcessRefresh(String str, IMSDKLoginResult iMSDKLoginResult) {
        if (this.mScrLoginResultCacheWhenRefresh != null && str.equals(IR.path.REFRESH_LOGIN_PATH)) {
            this.mScrLoginResultCacheWhenRefresh.innerTokenExpire = iMSDKLoginResult.innerTokenExpire;
        }
        return this.mScrLoginResultCacheWhenRefresh;
    }

    private void loginWithConfirmCode(String str, String str2, IMSDKResultListener iMSDKResultListener) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("sConfirmCode", str);
        sortableMap.put("iChannel", String.valueOf(getChannelId()));
        connectIMSDK(str2, sortableMap, iMSDKResultListener);
    }

    private void needAutoLogoutWhileBind(String str) {
        if (IR.path.BIND_PATH.equals(str) && !isLogin() && isChannelLogin()) {
            logout(new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.base.login.IMSDKLoginBase.1
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    IMLogger.d("Auto logout while bind " + iMSDKResult.imsdkRetMsg);
                }
            });
        }
    }

    public void setChannel(String str) {
        this.mCurrentChannel = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getChannel() {
        return this.mCurrentChannel;
    }

    private boolean checkChannelLoginStatus() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_CHECK_CHANNEL_LOGIN_STATUS, IR.meta.IMSDK_CHECK_CHANNEL_LOGIN_STATUS, true);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        IMSDKResult iMSDKLoginResult;
        if (bArr != null) {
            try {
                str2 = new String(bArr, "UTF-8");
            } catch (JSONException e) {
                return createIMSDKResult(str, 5, -1, e.getMessage());
            } catch (Exception e2) {
                return createIMSDKResult(str, 3, -1, e2.getMessage());
            }
        } else {
            str2 = "";
        }
        IMLogger.d("raw string = " + str2);
        IMLogger.json(str2);
        if (str.equals(IR.path.LOGOUT_PATH)) {
            iMSDKLoginResult = new IMSDKResult(str2);
        } else if (str.equals("bind/bindRelationInfo")) {
            iMSDKLoginResult = new IMSDKBindInfoResult(str2);
        } else {
            iMSDKLoginResult = new IMSDKLoginResult(str2);
            if (iMSDKLoginResult.thirdRetCode != 1) {
                needAutoLogoutWhileBind(str);
            }
        }
        if (iMSDKLoginResult.thirdRetCode == 1) {
            iMSDKLoginResult.imsdkRetCode = 1;
            iMSDKLoginResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(1);
            if (iMSDKLoginResult instanceof IMSDKLoginResult) {
                ((IMSDKLoginResult) iMSDKLoginResult).channel = getChannel();
                iMSDKLoginResult = modifyLoginResultAsChannel((IMSDKLoginResult) iMSDKLoginResult);
                if (str.equalsIgnoreCase(IR.path.BIND_PATH)) {
                    iMSDKLoginResult = modifyLoginResultWhenProcessBind(str, (IMSDKLoginResult) iMSDKLoginResult);
                }
                if (str.equalsIgnoreCase(IR.path.REFRESH_LOGIN_PATH)) {
                    iMSDKLoginResult = modifyLoginResultWhenProcessRefresh(str, (IMSDKLoginResult) iMSDKLoginResult);
                }
            }
            if (str.equals("user/login") || str.equals(IR.path.CHECK_LOGIN_PATH) || str.equals(IR.path.REFRESH_LOGIN_PATH) || str.equals(IR.path.BIND_PATH)) {
                IMSDKDB4Login.saveLoginData(this.mCurCtx, iMSDKLoginResult, getSqlChannelKey());
            }
        } else {
            iMSDKLoginResult.imsdkRetCode = 5;
        }
        iMSDKLoginResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKLoginResult.imsdkRetCode);
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        if (str.equals(IR.path.LOGOUT_PATH)) {
            return iMSDKResult;
        }
        if (str.equals("bind/bindRelationInfo")) {
            return new IMSDKBindInfoResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
        }
        return new IMSDKLoginResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public String getUrl(String str) {
        return "https://" + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI) + "/v" + IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0") + "/" + str + "?";
    }

    public String getSqlChannelKey() {
        return getClass().getName();
    }

    public void login(String str, final String str2, String str3, final IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, Object... objArr) {
        if (!T.ckIsEmpty(str)) {
            loginWithConfirmCode(str, str2, iMSDKResultListener);
        } else {
            login2Channel(LoginAction.LOGIN, str3, new IMSDKListener<Map<String, String>>() { // from class: com.tencent.imsdk.android.base.login.IMSDKLoginBase.2
                @Override // com.tencent.imsdk.android.base.IMSDKListener
                public void onNotify(Map<String, String> map) {
                    IMSDKLoginBase.this.connectIMSDK(str2, map, iMSDKResultListener);
                }

                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    IMSDKLoginBase.this.returnLRByError(iMSDKResultListener, iMSDKResult);
                }
            }, objArr);
        }
    }

    public void refreshLogin(IMSDKLoginResult iMSDKLoginResult, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        if (iMSDKLoginResult == null || iMSDKLoginResult.imsdkRetCode != 1) {
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKLoginResult(10, -1));
                return;
            }
            return;
        }
        this.mScrLoginResultCacheWhenRefresh = iMSDKLoginResult;
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iOpenid", iMSDKLoginResult.openId);
        sortableMap.put("sInnerToken", iMSDKLoginResult.innerToken);
        sortableMap.put("iGameId", String.valueOf(iMSDKLoginResult.gameId));
        sortableMap.put("iChannel", String.valueOf(iMSDKLoginResult.channelId));
        sortableMap.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        connectIMSDK(IR.path.REFRESH_LOGIN_PATH, sortableMap, iMSDKResultListener);
    }

    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
        Map<String, String> sortableMap = T.getSortableMap();
        fillParamsWithResult(loginResult, sortableMap);
        if (loginResult.imsdkRetCode == 1) {
            connectIMSDK(IR.path.LOGOUT_PATH, sortableMap, iMSDKResultListener);
            IMLogger.d("logout with callback by server");
        } else {
            IMLogger.w("logout without proper login state : " + loginResult.imsdkRetCode, new Object[0]);
            iMSDKResultListener.onResult(new IMSDKResult(10, -1));
        }
        IMSDKDB4Login.cleanSavedLoginData(this.mCurCtx, getSqlChannelKey());
    }

    public void logoutAll(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
        Map<String, String> sortableMap = T.getSortableMap();
        fillParamsWithResult(loginResult, sortableMap);
        if (loginResult.imsdkRetCode == 1) {
            connectIMSDK(IR.path.LOGOUT_ALL_PATH, sortableMap, iMSDKResultListener);
            IMLogger.d("logout all with callback by server");
        } else {
            IMLogger.w("logout all without proper login state : " + loginResult.imsdkRetCode, new Object[0]);
            iMSDKResultListener.onResult(new IMSDKResult(10, -1));
        }
        IMSDKDB4Login.cleanSavedLoginData(this.mCurCtx, getSqlChannelKey());
    }

    public boolean isLogin() {
        boolean isChannelLogin = isChannelLogin();
        IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
        boolean z = loginResult.imsdkRetCode == 1 && loginResult.innerTokenExpire >= System.currentTimeMillis() / 1000;
        return checkChannelLoginStatus() ? isChannelLogin && z : z;
    }

    public void quickLogin(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        IMSDKLoginResult loginResult = IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey());
        if (!isLogin() && loginResult.imsdkRetCode != 10) {
            loginResult = new IMSDKLoginResult(1002, 1002);
        }
        iMSDKResultListener.onResult(loginResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindChannel2Server(final IMSDKLoginResult iMSDKLoginResult, String str, final Map<String, String> map, final IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, Object... objArr) {
        login2Channel(LoginAction.BIND, str, new IMSDKListener<Map<String, String>>() { // from class: com.tencent.imsdk.android.base.login.IMSDKLoginBase.3
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Map<String, String> map2) {
                try {
                    IMSDKLoginBase.this.fillParamsWithResult(iMSDKLoginResult, map);
                    map.put(IR.account.ACCOUNT_BINDID, String.valueOf(IMSDKLoginBase.this.getChannelId()));
                    IMSDKLoginBase.this.addExtraBindParams(map);
                    IMSDKLoginBase.this.connectIMSDK(IR.path.BIND_PATH, map, iMSDKResultListener);
                } catch (Exception e) {
                    IMLogger.d("failed to bind : " + e.getMessage());
                }
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                IMSDKLoginBase.this.returnLRByError(iMSDKResultListener, iMSDKResult);
                IMSDKLoginBase.this.logout(new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.base.login.IMSDKLoginBase.3.1
                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKResult iMSDKResult2) {
                        IMLogger.d("bind error, try to logout and reset the environment");
                    }
                });
            }
        }, objArr);
    }

    public void bind(final IMSDKLoginResult iMSDKLoginResult, final String str, final IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, final Object... objArr) {
        final Map<String, String> sortableMap = T.getSortableMap();
        this.mScrLoginResultCacheWhenBind = iMSDKLoginResult;
        boolean orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_BIND_FORCE_TARGET_LOGOUT, IR.meta.IMSDK_BIND_FORCE_TARGET_LOGOUT, false);
        IMLogger.d("foreLogoutBeforeBind : " + orMetaData);
        if (orMetaData) {
            logout(new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.base.login.IMSDKLoginBase.4
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    IMSDKLoginBase.this.bindChannel2Server(iMSDKLoginResult, str, sortableMap, iMSDKResultListener, objArr);
                }
            });
            return;
        }
        if (isLogin()) {
            IMLogger.d("already logged in, try bind ...");
            fillParamsWithResult(iMSDKLoginResult, sortableMap);
            sortableMap.put(IR.account.ACCOUNT_BINDID, String.valueOf(getChannelId()));
            addExtraBindParams(sortableMap);
            connectIMSDK(IR.path.BIND_PATH, sortableMap, iMSDKResultListener);
            return;
        }
        bindChannel2Server(iMSDKLoginResult, str, sortableMap, iMSDKResultListener, objArr);
    }

    public void bind(String str, IMSDKLoginResult iMSDKLoginResult, String str2, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, Object... objArr) {
        if (!T.ckIsEmpty(str)) {
            Map<String, String> sortableMap = T.getSortableMap();
            fillParamsWithResult(iMSDKLoginResult, sortableMap);
            sortableMap.put(IR.account.ACCOUNT_BINDID, String.valueOf(getChannelId()));
            addExtraBindParams(sortableMap);
            connectIMSDK(IR.path.BIND_PATH, sortableMap, iMSDKResultListener);
            return;
        }
        bind(iMSDKLoginResult, str2, iMSDKResultListener, objArr);
    }

    public void getBindInfo(IMSDKResultListener<IMSDKBindInfoResult> iMSDKResultListener, Object... objArr) {
        if (isLogin()) {
            Map<String, String> sortableMap = T.getSortableMap();
            fillParamsWithResult(IMSDKDB4Login.getLoginResult(this.mCurCtx, getSqlChannelKey()), sortableMap);
            connectIMSDK("bind/bindRelationInfo", sortableMap, iMSDKResultListener);
            return;
        }
        iMSDKResultListener.onResult(new IMSDKBindInfoResult(10, 10));
    }

    public void addExtraBindParams(Map<String, String> map) {
        IMLogger.d("add bind params according to the channel");
    }
}
