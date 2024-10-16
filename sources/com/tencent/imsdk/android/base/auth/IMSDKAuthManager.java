package com.tencent.imsdk.android.base.auth;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.auth.IMSDKAuthConnectResult;
import com.tencent.imsdk.android.api.auth.IMSDKAuthMigrateResult;
import com.tencent.imsdk.android.api.auth.IMSDKAuthResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.IMSDKValidKeyCalcUnit;
import com.tencent.imsdk.android.base.interfaces.IAppAvailable;
import com.tencent.imsdk.android.base.interfaces.IConnectable;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKAuthManager extends IMSDKManagerBase {
    private String mConfirmCodeCache;
    private IConnectable mDeviceLogin;
    private String mMigrateCodeCache;
    private String mNeed2SaveDataChannelId;
    private IConnectable mThirdLoginIns;
    private static final String[] NEED_CONFIRM_CODE = {IR.path.RECONNECT_PATH, IR.path.RESTORE_PATH};
    private static final String[] NEED_MIGRATE_CODE = {IR.path.GET_MIGRATE_INFO_PATH, IR.path.MIGRATE_PATH};
    private static final String[] NEED_LOGOUT = {IR.path.DISCONNECT_PATH, IR.path.DELETE_ALL_ACCOUNT_PATH, IR.path.DELETE_DEVICE_ACCOUNT_PATH};
    private static final String[] NEED_CHANNEL_ID = {IR.path.DISCONNECT_PATH, IR.path.CONNECT_PATH};
    private static final String[] RETURN_AUTH_RESULT = {"user/login", IR.path.MIGRATE_PATH, IR.path.RESTORE_PATH, IR.path.RECOVER_PATH, "bind/bindRelationInfo"};
    private static final String[] RETURN_AUTH_CONNECT_RESULT = {IR.path.CONNECT_PATH};
    private static final String[] RETURN_AUTH_MIGRATE_RESULT = {IR.path.GET_MIGRATE_CODE_PATH, IR.path.GET_MIGRATE_INFO_PATH};

    private IMSDKResult createIMSDKResult(String str, int i, int i2, String str2) {
        if (i != 1) {
            this.mSTBuilder.setMethod(str).setStage("exception").setResult("thirdCode=" + i2 + ", thirdMsg=" + str2).create().reportEvent();
        }
        if (isPathPresent(str, RETURN_AUTH_RESULT)) {
            return new IMSDKAuthResult(i, i2, str2);
        }
        if (isPathPresent(str, RETURN_AUTH_CONNECT_RESULT)) {
            return new IMSDKAuthConnectResult(i, i2, str2);
        }
        if (isPathPresent(str, RETURN_AUTH_MIGRATE_RESULT)) {
            IMSDKAuthMigrateResult iMSDKAuthMigrateResult = new IMSDKAuthMigrateResult(i, i2, str2);
            this.mMigrateCodeCache = iMSDKAuthMigrateResult.migrateCode;
            return iMSDKAuthMigrateResult;
        }
        return new IMSDKResult(i, i2, str2);
    }

    private void retByError(String str, IMSDKResultListener iMSDKResultListener, int i, int i2, String str2) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(createIMSDKResult(str, i, i2, str2));
        } else {
            IMLogger.e(str2, new Object[0]);
        }
    }

    private IMSDKResult initChannelInstance(String str, String str2) {
        if (T.ckIsEmpty(str2)) {
            return createIMSDKResult(str, 11, -1, "argument 'channel' must not null");
        }
        String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_AUTH_FORMAT, str2.toLowerCase(Locale.US), str2);
        IMLogger.d("get '" + format + "' channel instance");
        this.mThirdLoginIns = (IConnectable) IMSDKModules.getInstance(this.mCurCtx).getChannelInstance(IConnectable.class, format);
        if (this.mThirdLoginIns != null) {
            return null;
        }
        return createIMSDKResult(str, 9, -1, "can not find '" + format + "', or '" + format + "' not implements IConnectable");
    }

    private boolean isAppEnvAvailable(String str, IMSDKResultListener iMSDKResultListener) {
        IConnectable iConnectable = this.mThirdLoginIns;
        if (iConnectable == null || !(iConnectable instanceof IAppAvailable)) {
            return true;
        }
        IAppAvailable iAppAvailable = (IAppAvailable) iConnectable;
        if (!iAppAvailable.isApplicationInstalled()) {
            retByError(str, iMSDKResultListener, 15, -1, "");
            IMLogger.w("application not installed", new Object[0]);
            return false;
        }
        if (iAppAvailable.isApplicationSupported()) {
            return true;
        }
        retByError(str, iMSDKResultListener, 16, -1, "");
        IMLogger.w("current version of application not support this function", new Object[0]);
        return false;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(enableHttps() ? "https" : "http");
        sb.append("://");
        sb.append(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI));
        sb.append("/v");
        sb.append(IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0"));
        sb.append("/");
        sb.append(str);
        sb.append("?");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fillParamsByPath(String str, Map<String, String> map, String str2, String str3, IMSDKResultListener iMSDKResultListener) {
        if (IR.path.RECOVER_PATH.equals(str)) {
            return true;
        }
        IMSDKValidKeyCalcUnit ins = IMSDKValidKeyCalcUnit.getIns(this.mCurCtx);
        IMSDKAuthResult authResult = getAuthResult();
        ins.putIfAbsence(map, "iOpenid", authResult.openId);
        ins.putIfAbsence(map, "sInnerToken", authResult.innerToken);
        ins.putIfAbsence(map, "sGuestId", DeviceUtils.getDeviceUuid(this.mCurCtx));
        if ("bind/bindRelationInfo".equals(str)) {
            ins.putIfAbsence(map, "iChannel", "5");
        }
        if (str != null) {
            if (!T.ckIsEmpty(str2) && isPathPresent(str, NEED_CHANNEL_ID)) {
                IMSDKResult initChannelInstance = initChannelInstance(str, str2);
                if (initChannelInstance != null) {
                    if (iMSDKResultListener != null) {
                        iMSDKResultListener.onResult(initChannelInstance);
                    }
                    return false;
                }
                IConnectable iConnectable = this.mThirdLoginIns;
                if (iConnectable != null) {
                    ins.putIfAbsence(map, "iChannel", iConnectable.getChannelId());
                } else {
                    IMLogger.e("mThirdLoginIns is null", new Object[0]);
                }
            }
            if (isPathPresent(str, NEED_CONFIRM_CODE)) {
                if (T.ckIsEmpty(str3)) {
                    str3 = this.mConfirmCodeCache;
                }
                ins.putIfAbsence(map, "sConfirmCode", str3);
            } else if (isPathPresent(str, NEED_MIGRATE_CODE)) {
                if (T.ckIsEmpty(str3)) {
                    str3 = this.mMigrateCodeCache;
                }
                ins.putIfAbsence(map, "sMigrateCode", str3);
            }
        }
        return authResult.imsdkRetCode == 1;
    }

    private void convertAuth2LoginAndStoreInDB(IMSDKLoginResult iMSDKLoginResult) throws JSONException {
        IMSDKLoginBase iMSDKLoginBase;
        if (iMSDKLoginResult == null || iMSDKLoginResult.thirdRetCode != 1 || T.ckIsEmpty(iMSDKLoginResult.innerToken)) {
            return;
        }
        iMSDKLoginResult.imsdkRetCode = 1;
        iMSDKLoginResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(1);
        String channelId = this.mThirdLoginIns.getChannelId();
        String str = null;
        if ("1".equals(channelId)) {
            str = String.format(IR.def.DEFAULT_PACKAGE_NAME_LOGIN_FORMAT, "facebook", "Facebook");
        } else if ("3".equals(channelId)) {
            str = String.format(IR.def.DEFAULT_PACKAGE_NAME_LOGIN_FORMAT, Constants.REFERRER_API_GOOGLE, "Google");
        }
        IMLogger.d("packageName = " + str);
        if (T.ckIsEmpty(str) || (iMSDKLoginBase = (IMSDKLoginBase) IMSDKModules.getInstance(this.mCurCtx).getChannelInstance(IMSDKLoginBase.class, str)) == null || T.ckIsEmpty(iMSDKLoginBase.getSqlChannelKey())) {
            return;
        }
        IMSDKLoginResult modifyLoginResultAsChannel = iMSDKLoginBase.modifyLoginResultAsChannel(iMSDKLoginResult);
        IMSDKDB4Login.saveLoginData(this.mCurCtx, modifyLoginResultAsChannel, iMSDKLoginBase.getSqlChannelKey());
        IMLogger.d("loginResult save in DB : " + modifyLoginResultAsChannel.toJSONString());
    }

    public IMSDKAuthManager(Context context) {
        super(context);
        this.mThirdLoginIns = null;
        if (this.mCurCtx != context) {
            this.mCurCtx = context;
            this.mDeviceLogin = new IMSDKGuest(this.mCurCtx);
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_AUTH, "Init<IMSDKAuthManager>");
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public void connectIMSDK(boolean z, String str, Map<String, String> map, IMSDKResultListener iMSDKResultListener) {
        this.mNeed2SaveDataChannelId = map.get("iChannel");
        if (this.mNeed2SaveDataChannelId == null) {
            this.mNeed2SaveDataChannelId = "5";
        }
        super.connectIMSDK(z, str, map, iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return createIMSDKResult(str, iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        IMSDKResult iMSDKResult;
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
        IMSDKLoginResult iMSDKLoginResult = null;
        if (isPathPresent(str, RETURN_AUTH_RESULT)) {
            iMSDKResult = new IMSDKAuthResult(str2);
        } else if (isPathPresent(str, RETURN_AUTH_CONNECT_RESULT)) {
            iMSDKLoginResult = new IMSDKLoginResult(str2);
            iMSDKResult = new IMSDKAuthConnectResult(str2);
            this.mConfirmCodeCache = ((IMSDKAuthConnectResult) iMSDKResult).confirmCode;
        } else if (isPathPresent(str, RETURN_AUTH_MIGRATE_RESULT)) {
            iMSDKResult = new IMSDKAuthMigrateResult(str2);
            this.mMigrateCodeCache = ((IMSDKAuthMigrateResult) iMSDKResult).migrateCode;
        } else {
            iMSDKResult = new IMSDKResult(str2);
        }
        if (iMSDKResult.thirdRetCode == 1) {
            iMSDKResult.imsdkRetCode = 1;
            if (isPathPresent(str, RETURN_AUTH_RESULT) && !"bind/bindRelationInfo".equals(str)) {
                IMSDKDB4Login.saveLoginData(this.mCurCtx, iMSDKResult, "5");
            }
            if (IR.path.CONNECT_PATH.equals(str)) {
                if (this.mThirdLoginIns != null) {
                    IMSDKDB4ConnectResult.saveData(this.mCurCtx, this.mThirdLoginIns.getChannelUserId(), iMSDKResult, this.mThirdLoginIns.getChannelId());
                }
                convertAuth2LoginAndStoreInDB(iMSDKLoginResult);
            }
        } else {
            iMSDKResult.imsdkRetCode = 5;
        }
        iMSDKResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKResult.imsdkRetCode);
        return iMSDKResult;
    }

    public void auth(final IMSDKResultListener iMSDKResultListener) {
        this.mSTBuilder.setMethod("auth").setStage("start").setResult("success").create().reportEvent();
        IConnectable iConnectable = this.mDeviceLogin;
        if (iConnectable != null) {
            iConnectable.login("user/login", new IMSDKListener<Map<String, String>>() { // from class: com.tencent.imsdk.android.base.auth.IMSDKAuthManager.1
                @Override // com.tencent.imsdk.android.base.IMSDKListener
                public void onNotify(Map<String, String> map) {
                    IMSDKAuthManager.this.connectIMSDK("user/login", map, iMSDKResultListener);
                }

                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    iMSDKResultListener.onResult(iMSDKResult);
                }
            }, new Object[0]);
        }
    }

    public void loginChannel(String str, String str2, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        loginChannel(str, str2, "", iMSDKResultListener, objArr);
    }

    public void loginChannel(final String str, final String str2, String str3, final IMSDKResultListener iMSDKResultListener, Object... objArr) {
        this.mSTBuilder.setMethod(str).setStage("start").setResult("success").setChannel(str2).create().reportEvent();
        IMSDKAuthResult authResult = getAuthResult();
        if (authResult.imsdkRetCode != 1) {
            retByError(str, iMSDKResultListener, authResult.imsdkRetCode, -1, "need auth first");
            return;
        }
        IMSDKResult initChannelInstance = initChannelInstance(str, str2);
        if (initChannelInstance != null) {
            iMSDKResultListener.onResult(initChannelInstance);
            return;
        }
        if (isAppEnvAvailable(str, iMSDKResultListener)) {
            if (!T.ckIsEmpty(str3)) {
                Map<String, String> sortableMap = T.getSortableMap();
                fillParamsByPath(str, sortableMap, str2, null, null);
                sortableMap.put("sConfirmCode", str3);
                connectIMSDK(str, String.format(IR.def.DEFAULT_PACKAGE_NAME_AUTH_FORMAT, str2.toLowerCase(Locale.US), str2), sortableMap, iMSDKResultListener);
                return;
            }
            IConnectable iConnectable = this.mThirdLoginIns;
            if (iConnectable != null) {
                iConnectable.login(str, new IMSDKListener<Map<String, String>>() { // from class: com.tencent.imsdk.android.base.auth.IMSDKAuthManager.2
                    @Override // com.tencent.imsdk.android.base.IMSDKListener
                    public void onNotify(Map<String, String> map) {
                        IMSDKAuthManager.this.fillParamsByPath(str, map, str2, null, null);
                        IMSDKAuthManager.this.connectIMSDK(str, String.format(IR.def.DEFAULT_PACKAGE_NAME_AUTH_FORMAT, str2.toLowerCase(Locale.US), str2), map, iMSDKResultListener);
                    }

                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKResult iMSDKResult) {
                        iMSDKResultListener.onResult(iMSDKResult);
                    }
                }, objArr);
            } else {
                IMLogger.e("Unknown error happen , try again", new Object[0]);
            }
        }
    }

    public void logout(String str, final IMSDKResultListener iMSDKResultListener) {
        IConnectable iConnectable;
        if (T.ckIsEmpty(str)) {
            iConnectable = this.mDeviceLogin;
        } else {
            initChannelInstance("", str);
            iConnectable = this.mThirdLoginIns;
        }
        if (iConnectable != null) {
            iConnectable.logout(new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.base.auth.IMSDKAuthManager.3
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    iMSDKResultListener.onResult(iMSDKResult);
                }
            });
        }
    }

    public void optAccount(String str, String str2, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        optAccount(str, "", str2, iMSDKResultListener, objArr);
    }

    public void optAccount(String str, final String str2, String str3, final IMSDKResultListener iMSDKResultListener, Object... objArr) {
        this.mSTBuilder.setMethod(str).setStage("start with params " + str3).setResult("success").create().reportEvent();
        if (isPathPresent(str, NEED_MIGRATE_CODE) && this.mMigrateCodeCache == null && T.ckIsEmpty(str3)) {
            retByError(str, iMSDKResultListener, 11, -1, "MigrateCode must not be null or empty");
            return;
        }
        if (isPathPresent(str, NEED_CONFIRM_CODE) && this.mConfirmCodeCache == null && T.ckIsEmpty(str3)) {
            retByError(str, iMSDKResultListener, 11, -1, "ConfirmCode must not be null or empty");
            return;
        }
        Map<String, String> sortableMap = T.getSortableMap();
        if (fillParamsByPath(str, sortableMap, str2, str3, iMSDKResultListener)) {
            if (isPathPresent(str, NEED_LOGOUT)) {
                connectIMSDK(str, sortableMap, new IMSDKResultListener() { // from class: com.tencent.imsdk.android.base.auth.IMSDKAuthManager.4
                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKResult iMSDKResult) {
                        if (iMSDKResult.imsdkRetCode == 1) {
                            IMSDKAuthManager.this.logout(str2, iMSDKResultListener);
                            return;
                        }
                        IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                        if (iMSDKResultListener2 != null) {
                            iMSDKResultListener2.onResult(iMSDKResult);
                        }
                    }
                });
                return;
            } else {
                connectIMSDK(str, sortableMap, iMSDKResultListener);
                return;
            }
        }
        retByError(str, iMSDKResultListener, 10, -1, "need auth first");
    }

    public IMSDKAuthResult getAuthResult() {
        IMLogger.d("activity = " + this.mCurCtx);
        IMSDKAuthResult loginData = IMSDKDB4Login.getLoginData(this.mCurCtx, "5");
        if (loginData != null) {
            return loginData.tokenExpireTime < System.currentTimeMillis() / 1000 ? new IMSDKAuthResult(1002, -1, "local cache expired") : loginData;
        }
        return new IMSDKAuthResult(1001, -1, "no local cache data");
    }
}
