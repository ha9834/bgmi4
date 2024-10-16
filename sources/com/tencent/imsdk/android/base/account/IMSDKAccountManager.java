package com.tencent.imsdk.android.base.account;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLogin;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.base.IMSDKValidKeyCalcUnit;
import com.tencent.imsdk.android.tools.AccountUtils;
import com.tencent.imsdk.android.tools.DigestUtils;
import com.tencent.imsdk.android.tools.EmailUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKAccountManager extends IMSDKManagerBase {
    private static final String[] ACCOUNT_PASSWORD_URL = {IR.path.ACCOUNT_LOGIN, IR.path.ACCOUNT_AUTO_BIND, IR.path.ACCOUNT_RESET_PASSWORD};
    private static final String[] ACCOUNT_VERIFYDATA_URL = {IR.path.ACCOUNT_AUTO_BIND, IR.path.ACCOUNT_RESET_PASSWORD, IR.path.ACCOUNT_VERIFY_CODE};
    private static final String RECOVERY_OPENID = "openId";
    private static final String RECOVER_CODE = "recoveryCode";
    private static final String TYPE_OLD_PWD = "1";
    private IMSDKResultListener accountLoginCallbackListener;
    public IMSDKResult mAreaCodeAll;
    public Map<String, String> mValidKeyMap;

    public IMSDKAccountManager(Context context) {
        super(context);
        this.mValidKeyMap = new HashMap();
        this.accountLoginCallbackListener = null;
        if (this.mCurCtx != context) {
            this.mCurCtx = context;
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_ACCOUNT, "Init<IMSDKAccountManager>");
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        try {
            if (str.equals(IR.path.ACCOUNT_LOGIN)) {
                String str2 = bArr != null ? new String(bArr, "UTF-8") : "";
                IMLogger.d("IMSDKACCOUNT handleServerData togetherLogin path = " + str + " result = " + str2);
                IMSDKResult iMSDKResult = new IMSDKResult(str2);
                if (iMSDKResult.thirdRetCode == 1 && str.equals(IR.path.ACCOUNT_LOGIN) && !T.ckIsEmpty(iMSDKResult.retExtraJson) && this.accountLoginCallbackListener != null) {
                    IMSDKResult fillSuccessResult = fillSuccessResult(iMSDKResult);
                    accountLoginResult2IMSDKLogin(str, this.accountLoginCallbackListener, map, fillSuccessResult);
                    return fillSuccessResult;
                }
                IMLogger.d(" handleServerData account login fail or accountLoginCallbackListener is null , plz check !");
                return new IMSDKResult(11, " handleServerData account login fail or accountLoginCallbackListener is null , plz check !");
            }
            String str3 = bArr != null ? new String(bArr, "UTF-8") : "";
            IMLogger.d("IMSDKACCOUNT handleServerData action=" + str + " result = " + str3);
            IMSDKResult iMSDKResult2 = new IMSDKResult(str3);
            if (iMSDKResult2.thirdRetCode == 1) {
                IMSDKResult fillSuccessResult2 = fillSuccessResult(iMSDKResult2);
                if (str.equals(IR.path.ACCOUNT_VERIFY_CODE) && !T.ckIsEmpty(fillSuccessResult2.retExtraJson)) {
                    this.mValidKeyMap.put(new JSONObject(fillSuccessResult2.retExtraJson).getString(IR.account.ACCOUNT_VERIFY_CODE), fillSuccessResult2.retExtraJson);
                }
                if (!str.equals(IR.path.ACCOUNT_AREA_CODE) || T.ckIsEmpty(fillSuccessResult2.retExtraJson)) {
                    return fillSuccessResult2;
                }
                this.mAreaCodeAll = fillSuccessResult2;
                return fillSuccessResult2;
            }
            return fillErrorResult(iMSDKResult2);
        } catch (Exception e) {
            return new IMSDKResult(3, -1, e.getMessage());
        }
    }

    private void accountLoginResult2IMSDKLogin(String str, IMSDKResultListener iMSDKResultListener, Map<String, String> map, IMSDKResult iMSDKResult) throws JSONException {
        if (T.mGlobalActivityUpToDate != null) {
            IMSDKLogin.initialize(T.mGlobalActivityUpToDate);
            String string = new JSONObject(iMSDKResult.retExtraJson).getString(IR.account.ACCOUNT_TYPE);
            if (string.equals("1")) {
                accountloginResult2IMSDKLoginReq(str, iMSDKResultListener, map, iMSDKResult, IR.account.EMAIL_CHANNEL_NAME);
                return;
            } else if (string.equals("2")) {
                accountloginResult2IMSDKLoginReq(str, iMSDKResultListener, map, iMSDKResult, IR.account.PHONE_CHANNEL_NAME);
                return;
            } else {
                retByError(str, 11, -1, "accountLoginResult2IMSDKLogin plz check you account ,The accountType error !", iMSDKResultListener);
                return;
            }
        }
        retByError(str, 17, -1, "accountLoginResult2IMSDKLogin you must init activity first!", iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return new IMSDKResult(iMSDKResult.imsdkRetCode, iMSDKResult.imsdkRetMsg, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        return "https://" + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI) + "/v" + IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0") + "/" + str + "?";
    }

    public void accountBind(String str, String str2, String str3, String str4, String str5, IMSDKResultListener iMSDKResultListener, String str6) {
        IMLogger.d("IMSDKACCOUNT accountBind start");
        if (!T.ckNonEmpty(str2, str3)) {
            IMLogger.d("IMSDKACCOUNT accountBind account = " + str2 + " verifyData = " + str4 + " areaCode = " + str5);
            if (AccountUtils.isPasswordStandard(str3)) {
                accountBind2IMSDK(str, str2, str3, str4, str5, iMSDKResultListener, str6);
            } else {
                retByError(str, 11, 11, "accountBind2IMSDK you password format error!!", iMSDKResultListener);
            }
        } else {
            retByError(str, 11, 11, "account or password is null!!", iMSDKResultListener);
        }
        IMLogger.d("IMSDKACCOUNT accountBind over");
    }

    public void accountLogin(String str, String str2, String str3, String str4, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        IMLogger.d("IMSDKACCOUNT accountLogin start");
        if (!T.ckNonEmpty(str2, str3)) {
            IMLogger.d("IMSDKACCOUNT accountLogin account = " + str2 + " areaCode = " + str4);
            accountLogin2IMSDK(str, str2, str3, str4, iMSDKResultListener);
        } else {
            retByError(str, 11, 11, "account or password is null!!", iMSDKResultListener);
        }
        IMLogger.d("IMSDKACCOUNT accountLogin over");
    }

    public void resetPassword(String str, String str2, String str3, String str4, String str5, String str6, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        IMLogger.d("IMSDKACCOUNT resetPassword start");
        if (!T.ckNonEmpty(str2, str3, str4, str5)) {
            IMLogger.d("IMSDKACCOUNT resetPassword account = " + str2 + " verifyType = " + str3);
            if (AccountUtils.isPasswordStandard(str5)) {
                resetPwd2IMSDK(str, str2, str3, str4, str5, str6, iMSDKResultListener);
            } else {
                retByError(str, 11, 11, "resetPassword you password format error!!", iMSDKResultListener);
            }
        } else {
            retByError(str, 11, 11, "resetPassword req params is null!!", iMSDKResultListener);
        }
        IMLogger.d("IMSDKACCOUNT resetPassword over");
    }

    public void getAllAreaCodes(String str, IMSDKResultListener iMSDKResultListener) {
        IMLogger.d("IMSDKACCOUNT getAllAreaCodes start ");
        if (this.mAreaCodeAll != null) {
            IMLogger.d("IMSDKACCOUNT areaCodes has cache = " + this.mAreaCodeAll);
            iMSDKResultListener.onResult(this.mAreaCodeAll);
        } else {
            Map<String, String> sortableMap = T.getSortableMap();
            sortableMap.put("iChannel", "26");
            connectIMSDK(str, sortableMap, iMSDKResultListener);
        }
        IMLogger.d("IMSDKACCOUNT getAllAreaCodes over");
    }

    public void getVerifyCode(String str, String str2, String str3, String str4, IMSDKResultListener iMSDKResultListener) {
        IMLogger.d("IMSDKACCOUNT getVerifyCode start ");
        if (!T.ckNonEmpty(str2, str3)) {
            IMLogger.d("IMSDKACCOUNT getVerifyCode account = " + str2 + " codeType = " + str3 + " areaCode = " + str4);
            getVerifyCode2IMSDK(str, str2, str3, str4, iMSDKResultListener);
        } else {
            retByError(str, 11, 11, "getVerifyCode req params is null!!", iMSDKResultListener);
        }
        IMLogger.d("IMSDKACCOUNT getVerifyCode over");
    }

    public boolean checkVerifyCode(String str, String str2, String str3) {
        IMLogger.d("IMSDKACCOUNT checkVerifyCode start ");
        Map<String, String> map = this.mValidKeyMap;
        if (map != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : this.mValidKeyMap.entrySet()) {
                if (DigestUtils.getMD5(str).equals(entry.getKey())) {
                    try {
                        JSONObject jSONObject = new JSONObject(entry.getValue());
                        String string = jSONObject.getString(IR.account.ACCOUNT_USERNAME);
                        String accountType = getAccountType(str2);
                        boolean checkVerifyCodeTimeout = checkVerifyCodeTimeout(jSONObject.getString(IR.account.ACCOUNT_AREACODE_TIME));
                        if (accountType.equals("2")) {
                            String string2 = jSONObject.getString(IR.account.ACCOUNT_AREACODE);
                            IMLogger.d("checkVerifyCode phone account =" + str2 + " accountCache = " + string + " istimeout = " + checkVerifyCodeTimeout + "areaCode = " + str3 + "areaCodeCache = " + string2);
                            return str2.equals(string) && str3.equals(string2) && checkVerifyCodeTimeout;
                        }
                        IMLogger.d("checkVerifyCode email account =" + str2 + " accountCache = " + string + " istimeout = " + checkVerifyCodeTimeout);
                        return str2.equals(string) && checkVerifyCodeTimeout;
                    } catch (JSONException e) {
                        IMLogger.d("IMSDKACCOUNT checkVerifyCode Jsonerror = " + e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public void getRecoveryCode(String str, IMSDKResultListener iMSDKResultListener) {
        IMSDKLoginResult loginResult = IMSDKLogin.getLoginResult();
        IMLogger.d("IMSDKACCOUNT getRecoveryCode IMSDKLoginResult  = " + loginResult.toString());
        if (!T.ckIsEmpty(loginResult.openId) && !T.ckIsEmpty(loginResult.innerToken)) {
            Map<String, String> sortableMap = T.getSortableMap();
            sortableMap.put("iOpenid", loginResult.openId);
            sortableMap.put("sInnerToken", loginResult.innerToken);
            sortableMap.put("iChannel", String.valueOf(loginResult.channelId));
            connectIMSDK(str, sortableMap, iMSDKResultListener);
            return;
        }
        retByError(str, 11, 11, "getRecoveryCode you must login imsdk first!!", iMSDKResultListener);
    }

    public void checkRecoveryCode(String str, String str2, String str3, IMSDKResultListener iMSDKResultListener) {
        IMLogger.d("IMSDKACCOUNT checkRecoveryCode openId = " + str2 + " recoveryCode = " + str3);
        if (!T.ckIsEmpty(str2) && !T.ckIsEmpty(str3)) {
            Map<String, String> sortableMap = T.getSortableMap();
            sortableMap.put("iOpenid", str2);
            sortableMap.put(IR.account.ACCOUNT_RECOVERY_CODE, str3);
            sortableMap.put("iChannel", "5");
            connectIMSDK(str, sortableMap, iMSDKResultListener);
            return;
        }
        retByError(str, 11, 11, "checkRecoveryCode req params is null!!", iMSDKResultListener);
    }

    private void getVerifyCode2IMSDK(String str, String str2, String str3, String str4, IMSDKResultListener iMSDKResultListener) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put(IR.account.ACCOUNT_USERNAME, str2);
        sortableMap.put(IR.account.ACCOUNT_TYPE, fillPhoneChannelAreaCode(str2, str4, sortableMap));
        sortableMap.put(IR.account.ACCOUNT_CODE_TYPE, str3);
        sortableMap.put(IR.account.ACCOUNT_VERIFY_CODE_TIME, String.valueOf(getNowTime()));
        sortableMap.put("iChannel", "26");
        connectIMSDK(str, sortableMap, iMSDKResultListener);
    }

    private boolean checkVerifyCodeTimeout(String str) {
        Long valueOf = Long.valueOf(Long.parseLong(str));
        Long valueOf2 = Long.valueOf(getNowTime() / 1000);
        IMLogger.d(" checkVerifyCodeTimeout areCodeSecond =  " + valueOf + " nowSecond = " + valueOf2);
        return valueOf2.longValue() - valueOf.longValue() < 600;
    }

    private long getNowTime() {
        return System.currentTimeMillis();
    }

    private void resetPwd2IMSDK(String str, String str2, String str3, String str4, String str5, String str6, IMSDKResultListener iMSDKResultListener) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iChannel", "26");
        sortableMap.put(IR.account.ACCOUNT_USERNAME, str2);
        sortableMap.put(IR.account.ACCOUNT_TYPE, fillPhoneChannelAreaCode(str2, str6, sortableMap));
        sortableMap.put(IR.account.ACCOUNT_VERIFY_TYPE, str3);
        if (str3.equals("1")) {
            sortableMap.put(IR.account.ACCOUNT_VERIFY_DATA, DigestUtils.getMD5(str4));
        } else {
            sortableMap.put(IR.account.ACCOUNT_VERIFY_DATA, str4);
        }
        sortableMap.put(IR.account.ACCOUNT_PASSWORD, DigestUtils.getMD5(str5));
        connectIMSDK(enableHttps(), str, sortableMap, iMSDKResultListener);
    }

    protected void retByError(String str, int i, int i2, String str2, IMSDKResultListener iMSDKResultListener) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(createIMSDKResult(str, i, i2, str2));
        } else {
            IMLogger.e(str2, new Object[0]);
        }
    }

    private void accountLogin2IMSDK(String str, String str2, String str3, String str4, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        this.accountLoginCallbackListener = iMSDKResultListener;
        connectIMSDK(enableHttps(), str, fillLoginParams(str2, str3, str4, iMSDKResultListener), iMSDKResultListener);
    }

    private Map<String, String> fillLoginParams(String str, String str2, String str3, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iChannel", "26");
        sortableMap.put(IR.account.ACCOUNT_USERNAME, str);
        sortableMap.put(IR.account.ACCOUNT_TYPE, fillPhoneChannelAreaCode(str, str3, sortableMap));
        sortableMap.put(IR.account.ACCOUNT_PASSWORD, DigestUtils.getMD5(str2));
        return sortableMap;
    }

    private String fillPhoneChannelAreaCode(String str, String str2, Map<String, String> map) {
        String accountType = getAccountType(str);
        if (accountType.equals("2")) {
            map.put(IR.account.ACCOUNT_AREACODE, str2);
        }
        return accountType;
    }

    private String getAccountType(String str) {
        return str.contains(IR.account.EMAIL_TAG) ? "1" : "2";
    }

    private void accountBind2IMSDK(String str, String str2, String str3, String str4, String str5, IMSDKResultListener iMSDKResultListener, String str6) {
        if (EmailUtils.isEmail(str2) || AccountUtils.isMobile(str2)) {
            if (!T.ckIsEmpty(str6) && str6.contains(RECOVERY_OPENID) && str6.contains(RECOVER_CODE)) {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    String string = jSONObject.getString(RECOVERY_OPENID);
                    String string2 = jSONObject.getString(RECOVER_CODE);
                    if (!T.ckIsEmpty(string) && !T.ckIsEmpty(string2)) {
                        connectIMSDK(enableHttps(), str, fillGuestBindParams(str2, str3, str4, str5, string, string2), iMSDKResultListener);
                    } else {
                        retByError(str, 11, 11, "accountBind2IMSDK you extras is null!!", iMSDKResultListener);
                    }
                    return;
                } catch (JSONException e) {
                    IMLogger.d(" accountBind2IMSDK exception = " + e.getMessage());
                    return;
                }
            }
            IMSDKLoginResult loginResult = IMSDKLogin.getLoginResult();
            IMLogger.d("IMSDKACCOUNT accountBind2IMSDK IMSDKLoginResult result = " + loginResult.toString());
            if (!T.ckIsEmpty(loginResult.openId) && !T.ckIsEmpty(loginResult.innerToken)) {
                connectIMSDK(enableHttps(), str, fillBind2IMSDKParams(str2, str3, str4, str5, loginResult), iMSDKResultListener);
                return;
            } else {
                retByError(str, 11, 11, "accountBind2IMSDK you must login imsdk first!!", iMSDKResultListener);
                return;
            }
        }
        retByError(str, 11, 11, "accountBind2IMSDK you phone or account id is error!!", iMSDKResultListener);
    }

    private Map<String, String> fillGuestBindParams(String str, String str2, String str3, String str4, String str5, String str6) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put(IR.account.ACCOUNT_TYPE, fillPhoneChannelAreaCode(str, str4, sortableMap));
        sortableMap.put("iOpenid", str5);
        sortableMap.put(IR.account.ACCOUNT_RECOVERY_CODE, str6);
        sortableMap.put("iChannel", "5");
        sortableMap.put(IR.account.ACCOUNT_USERNAME, str);
        sortableMap.put(IR.account.ACCOUNT_PASSWORD, DigestUtils.getMD5(str2));
        sortableMap.put(IR.account.ACCOUNT_VERIFY_DATA, str3);
        sortableMap.put(IR.account.ACCOUNT_BINDID, "26");
        return sortableMap;
    }

    private Map<String, String> fillBind2IMSDKParams(String str, String str2, String str3, String str4, IMSDKLoginResult iMSDKLoginResult) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put(IR.account.ACCOUNT_TYPE, fillPhoneChannelAreaCode(str, str4, sortableMap));
        sortableMap.put("iOpenid", iMSDKLoginResult.openId);
        sortableMap.put("sInnerToken", iMSDKLoginResult.innerToken);
        sortableMap.put("iChannel", String.valueOf(iMSDKLoginResult.channelId));
        sortableMap.put(IR.account.ACCOUNT_USERNAME, str);
        sortableMap.put(IR.account.ACCOUNT_PASSWORD, DigestUtils.getMD5(str2));
        sortableMap.put(IR.account.ACCOUNT_VERIFY_DATA, str3);
        sortableMap.put(IR.account.ACCOUNT_BINDID, "26");
        return sortableMap;
    }

    private IMSDKResult fillSuccessResult(IMSDKResult iMSDKResult) {
        iMSDKResult.imsdkRetCode = 1;
        iMSDKResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(1);
        return iMSDKResult;
    }

    private IMSDKResult fillErrorResult(IMSDKResult iMSDKResult) {
        iMSDKResult.imsdkRetCode = 5;
        iMSDKResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(5);
        return iMSDKResult;
    }

    private void accountloginResult2IMSDKLoginReq(final String str, final IMSDKResultListener iMSDKResultListener, final Map<String, String> map, IMSDKResult iMSDKResult, String str2) {
        IMSDKDB4Login.saveLoginData(this.mCurCtx, iMSDKResult, str2);
        boolean channel = IMSDKLogin.setChannel(str2);
        StringBuilder sb = new StringBuilder();
        sb.append("set channel to ");
        sb.append(str2);
        sb.append(channel ? " success" : " fail");
        IMLogger.d(sb.toString());
        IMSDKLogin.login(str2, false, new ArrayList(), new IMSDKResultListener<IMSDKLoginResult>() { // from class: com.tencent.imsdk.android.base.account.IMSDKAccountManager.1
            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKLoginResult iMSDKLoginResult) {
                IMLogger.d("IMSDKACCOUNT togetherLogin imsdkLogin result = " + iMSDKLoginResult);
                IMSDKAccountManager.this.reportResult(str, map, iMSDKLoginResult);
                iMSDKResultListener.onResult(iMSDKLoginResult);
            }
        });
    }

    private IMSDKResult createIMSDKResult(String str, int i, int i2, String str2) {
        if (i != 1) {
            this.mSTBuilder.setMethod(str).setStage("exception").setResult("thirdCode=" + i2 + ", thirdMsg=" + str2).create().reportEvent();
        }
        return new IMSDKResult(i, i2, str2);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public void connectIMSDK(boolean z, String str, Map<String, String> map, IMSDKResultListener iMSDKResultListener) {
        IMSDKResultListener proxyListener4EventReport;
        if (z && isPathPresent(str, ACCOUNT_PASSWORD_URL)) {
            IMSDKValidKeyCalcUnit.getIns(this.mCurCtx).fillFixedParamsAndValidKey(map);
            String url = getUrl(str);
            if (this.mSTBuilder == null) {
                proxyListener4EventReport = iMSDKResultListener;
            } else {
                proxyListener4EventReport = this.mSTBuilder.create().proxyListener4EventReport("http-" + str, iMSDKResultListener);
            }
            String str2 = url + encodeParams(map);
            Map<String, String> pwdMap = getPwdMap(str, map);
            post2IMSDKServer(str, pwdMap, str2, proxyListener4EventReport, pwdMap);
            return;
        }
        super.connectIMSDK(z, str, map, iMSDKResultListener);
    }

    public Map<String, String> getPwdMap(String str, Map<String, String> map) {
        String str2 = "";
        String str3 = "";
        for (String str4 : map.keySet()) {
            if (str4.equals(IR.account.ACCOUNT_PASSWORD)) {
                str2 = map.get(str4);
            }
            if (str4.equals(IR.account.ACCOUNT_VERIFY_DATA)) {
                str3 = map.get(str4);
            }
        }
        Map<String, String> sortableMap = T.getSortableMap();
        if (isPathPresent(str, ACCOUNT_PASSWORD_URL)) {
            sortableMap.put(IR.account.ACCOUNT_PASSWORD, str2);
        }
        if (isPathPresent(str, ACCOUNT_VERIFYDATA_URL)) {
            sortableMap.put(IR.account.ACCOUNT_VERIFY_DATA, str3);
        }
        return sortableMap;
    }
}
