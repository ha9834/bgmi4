package com.tencent.imsdk.android.base.unifiedaccount;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.api.unifiedaccount.IMSDKUnifiedAccountPopupStatusResult;
import com.tencent.imsdk.android.api.unifiedaccount.IMSDKUnifiedAccountResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKValidKeyCalcUnit;
import com.tencent.imsdk.android.tools.DigestUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKUnifiedAccountManager {
    private static volatile IMSDKUnifiedAccountManager instance;
    private static Context mCurCtx;
    private IMSDKHttpClient mClient;
    private final String IMSDK_WEB_VERIFY_CLASS = "com.tencent.imsdk.android.login.webverify.IMSDKWebVerify";
    public final int UNIFIED_ACCOUNT_SUCCESS = 0;
    private final String PASSWORD_FORMAT = "[a-zA-Z0-9!@#$%^&*()+=\\\\-_/?<>,.:;|]+";
    private InnerStat.Builder mSTBuilder = new InnerStat.Builder(mCurCtx, "2.10.1", IR.MODULE_ACCOUNT, "Init<IMSDKUnifiedAccountManager>");
    private BigInteger mSid = getSid();

    public static IMSDKUnifiedAccountManager getInstance() {
        mCurCtx = T.mGlobalActivityUpToDate;
        if (instance == null) {
            synchronized (IMSDKUnifiedAccountManager.class) {
                if (instance == null) {
                    instance = new IMSDKUnifiedAccountManager();
                }
            }
        }
        return instance;
    }

    private IMSDKUnifiedAccountManager() {
        this.mClient = null;
        this.mClient = new IMSDKHttpClient(mCurCtx);
    }

    public void requestVerifyCode(String str, int i, int i2, String str2, String str3, IMSDKResultListener<IMSDKUnifiedAccountResult> iMSDKResultListener, String str4) {
        IMLogger.d("IMSDKUnifiedAccountManager::getVerifyCode(account=%s, accountType=%d, areaCode=%s, langType=%s, listener, extraJson=%s)", str, Integer.valueOf(i), str2, str3, str4);
        this.mSTBuilder.setMethod("requestVerifyCode").create().reportEvent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str2);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_CODE_TYPE, i2);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str4);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
        } catch (JSONException e) {
            IMLogger.e("requestVerifyCode jsonException : " + e.getMessage(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        requestWithUrl(getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_VERIFY_CODE_PATH, jSONObject2, str3), IR.path.UNIFIED_ACCOUNT_VERIFY_CODE_PATH, jSONObject2, iMSDKResultListener);
    }

    public void changePassword(String str, int i, String str2, String str3, String str4, String str5, IMSDKResultListener<IMSDKUnifiedAccountResult> iMSDKResultListener, String str6) {
        IMLogger.d("IMSDKUnifiedAccountManager::changePassword(account=%s, accountType=%d, verifyCode=%s, areaCode=%s, newPassword=%s, langType=%s, listener, extraJson=%s)", str, Integer.valueOf(i), str2, str3, str4, str5, str6);
        this.mSTBuilder.setMethod("changePassword").create().reportEvent();
        if (!checkIsValidPassword(str3)) {
            iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(11, "newPassword is invalid"));
            return;
        }
        if (!checkIsNumberString(str2)) {
            iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(11, "verifyCode is invalid"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str4);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str6);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_PASSWORD, getSecurePSWString(str3));
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_CODE, Integer.valueOf(str2));
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
        } catch (JSONException e) {
            IMLogger.e("changePassword jsonException : " + e.getMessage(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        requestWithUrl(getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_CHANGE_PASSWORD_PATH, jSONObject2, str5), IR.path.UNIFIED_ACCOUNT_CHANGE_PASSWORD_PATH, jSONObject2, iMSDKResultListener);
    }

    public void modifyAccountInfo(String str, int i, int i2, String str2, String str3, String str4, final String str5, final int i3, String str6, String str7, final IMSDKResultListener<IMSDKUnifiedAccountResult> iMSDKResultListener, String str8) {
        IMLogger.d("IMSDKUnifiedAccountManager::modifyAccountInfo(account=%s, accountType=%d, verifyType=%d, areaCode=%s, langType=%s, modifyAccount=%s, modifyAccountType=%s, modifyVerifyCode=%s, modifyAreaCode=%s, listener, extraJson=%s)", str, Integer.valueOf(i), Integer.valueOf(i2), str3, str4, str5, Integer.valueOf(i3), str6, str7, str8);
        this.mSTBuilder.setMethod("modifyAccountInfo").create().reportEvent();
        if (!checkIsNumberString(str6)) {
            iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(11, "modifyVerifyCode is invalid"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str3);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str8);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_ACCOUNT_MODIFY, str5);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_ACCOUNT_TYPE_MODIFY, i3);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE_MODIFY, str7);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_CODE_MODIFY, Integer.valueOf(str6));
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_TYPE, i2);
            switch (i2) {
                case 1:
                    if (!checkIsNumberString(str2)) {
                        iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(11, "verifyCode is invalid"));
                        return;
                    } else {
                        jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_CODE, Integer.valueOf(str2));
                        break;
                    }
                case 2:
                    if (T.ckIsEmpty(str2)) {
                        iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(11, "password is invalid"));
                        return;
                    } else {
                        jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_PASSWORD, str2);
                        break;
                    }
                default:
                    UnifiedAccountToken token = UnifiedAccountSession.getToken(mCurCtx, str, i);
                    if (token != null && token.isValid()) {
                        jSONObject.put("uid", token.uid);
                        jSONObject.put("token", token.token);
                        break;
                    }
                    iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(10, "account not login yet"));
                    return;
            }
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
        } catch (JSONException e) {
            IMLogger.e("modifyAccountInfo jsonException : " + e.getMessage(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        requestWithUrl(getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_MODIFY_PATH, jSONObject2, str4), IR.path.UNIFIED_ACCOUNT_MODIFY_PATH, jSONObject2, new IMSDKResultListener<IMSDKUnifiedAccountResult>() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.1
            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKUnifiedAccountResult iMSDKUnifiedAccountResult) {
                if (iMSDKUnifiedAccountResult.imsdkRetCode == 1) {
                    UnifiedAccountSession.updateToken(IMSDKUnifiedAccountManager.mCurCtx, str5, i3);
                }
                iMSDKResultListener.onResult(iMSDKUnifiedAccountResult);
            }
        });
    }

    public void checkIsRegisted(String str, int i, String str2, String str3, IMSDKResultListener<IMSDKUnifiedAccountResult> iMSDKResultListener, String str4) {
        IMLogger.d("IMSDKUnifiedAccountManager::checkIsRegisted(account=%s, accountType=%d, areaCode=%s, langType=%s, listener, extraJson=%s)", str, Integer.valueOf(i), str2, str3, str4);
        this.mSTBuilder.setMethod("checkIsRegisted").create().reportEvent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str2);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str4);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
        } catch (JSONException e) {
            IMLogger.e("checkIsRegisted jsonException : " + e.getMessage(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        requestWithUrl(getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_REGISTER_STATUS_PATH, jSONObject2, str3), IR.path.UNIFIED_ACCOUNT_REGISTER_STATUS_PATH, jSONObject2, iMSDKResultListener);
    }

    public void checkVerifyCodeValid(String str, int i, String str2, String str3, int i2, String str4, IMSDKResultListener<IMSDKUnifiedAccountResult> iMSDKResultListener, String str5) {
        IMLogger.d("IMSDKUnifiedAccountManager::requestVerifyCodeStatus(account=%s, accountType=%d, verifyCode=%s, areaCode=%s, langType=%s, listener, extraJson=%s)", str, Integer.valueOf(i), str3, str2, str4, str5);
        this.mSTBuilder.setMethod("requestVerifyCodeStatus").create().reportEvent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str2);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_CODE_TYPE, i2);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str5);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_CODE, Integer.valueOf(str3));
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
        } catch (JSONException e) {
            IMLogger.e("checkVerifyCodeValid jsonException : " + e.getMessage(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        requestWithUrl(getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_VERIFY_CODE_STATUS_PATH, jSONObject2, str4), IR.path.UNIFIED_ACCOUNT_VERIFY_CODE_STATUS_PATH, jSONObject2, iMSDKResultListener);
    }

    public void registerAccount(String str, int i, String str2, String str3, String str4, String str5, boolean z, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str6) {
        IMLogger.d("IMSDKUnifiedAccountManager::registerAccount(account=%s, accountType=%d, password, verifyCode=%s, areaCode=%s, langType=%s, isBind=%b, listener, extraJson=%s)", str, Integer.valueOf(i), str3, str4, str5, Boolean.valueOf(z), str6);
        this.mSTBuilder.setMethod("registerAccount").create().reportEvent();
        if (!checkIsValidPassword(str2)) {
            iMSDKResultListener.onResult(new IMSDKLoginResult(11, 11, "password invalid, check its length and format"));
            return;
        }
        if (!checkIsNumberString(str3)) {
            iMSDKResultListener.onResult(new IMSDKLoginResult(11, 11, "verifyCode invalid, must be numbers"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            try {
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str4);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str6);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_PASSWORD, getSecurePSWString(str2));
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_CODE, Integer.valueOf(str3));
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
            } catch (JSONException e) {
                e = e;
                IMLogger.e("registerAccount jsonException : " + e.getMessage(), new Object[0]);
                String jSONObject2 = jSONObject.toString();
                loginWithUrl(str, i, getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_REGISTER_PATH, jSONObject2, str5), IR.path.UNIFIED_ACCOUNT_REGISTER_PATH, z, jSONObject2, iMSDKResultListener);
            }
        } catch (JSONException e2) {
            e = e2;
        }
        String jSONObject22 = jSONObject.toString();
        loginWithUrl(str, i, getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_REGISTER_PATH, jSONObject22, str5), IR.path.UNIFIED_ACCOUNT_REGISTER_PATH, z, jSONObject22, iMSDKResultListener);
    }

    public void login(String str, int i, String str2, String str3, String str4, boolean z, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str5) {
        IMLogger.d("IMSDKUnifiedAccountManager::login(account=%s, accountType=%d, password, areaCode=%s, langType=%s, isBind=%b, listener, extraJson=%s)", str, Integer.valueOf(i), str3, str4, Boolean.valueOf(z), str5);
        this.mSTBuilder.setMethod(FirebaseAnalytics.Event.LOGIN).create().reportEvent();
        if (!checkIsValidPassword(str2)) {
            iMSDKResultListener.onResult(new IMSDKLoginResult(11, 11, "password invalid, check its length and format"));
        } else {
            checkPopupStatus(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_ACCOUNT_CHECK_POPUP_STATUS_ENABLE, IR.meta.IMSDK_ACCOUNT_CHECK_POPUP_STATUS_ENABLE, false), str, i, str2, str3, str4, z, iMSDKResultListener, str5);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkPopupStatus(boolean z, final String str, final int i, final String str2, final String str3, final String str4, final boolean z2, final IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, final String str5) {
        boolean orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_ACCOUNT_VERIFY_OPT_SID_ENABLE, IR.meta.IMSDK_ACCOUNT_VERIFY_OPT_SID_ENABLE, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RecommendParams.KEY_UIN, getUin(str));
            if (orMetaData) {
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_SESSION_ID, this.mSid.toString());
            }
        } catch (JSONException unused) {
            IMLogger.e("json parsing error when constructing uin and sid", new Object[0]);
        }
        final String jSONObject2 = jSONObject.toString();
        if (z) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
            } catch (JSONException e) {
                IMLogger.e("login jsonException : " + e.getMessage(), new Object[0]);
            }
            String jSONObject4 = jSONObject3.toString();
            this.mClient.post(getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_POPSTATUS_PATH, jSONObject4, str4), jSONObject4, new IMSDKListener<String>() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.2
                @Override // com.tencent.imsdk.android.base.IMSDKListener
                public void onNotify(String str6) {
                    IMLogger.d("onNotify raw string = " + str6);
                    IMLogger.json(str6);
                    try {
                        IMSDKUnifiedAccountPopupStatusResult iMSDKUnifiedAccountPopupStatusResult = new IMSDKUnifiedAccountPopupStatusResult(str6);
                        if (iMSDKUnifiedAccountPopupStatusResult.imsdkRetCode != 1) {
                            IMSDKUnifiedAccountManager.this.renderWebVerify(new IMSDKWebVerifyListener() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.2.2
                                @Override // com.tencent.imsdk.android.base.unifiedaccount.IMSDKWebVerifyListener
                                public void execute(String str7) {
                                    IMSDKUnifiedAccountManager.this.performAccountLogin(str, i, str2, str3, str4, z2, iMSDKResultListener, str5, str7, "");
                                }
                            }, iMSDKResultListener, jSONObject2);
                        } else {
                            final String str7 = iMSDKUnifiedAccountPopupStatusResult.pTicket;
                            if (iMSDKUnifiedAccountPopupStatusResult.needPopup == 1) {
                                IMSDKUnifiedAccountManager.this.renderWebVerify(new IMSDKWebVerifyListener() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.2.1
                                    @Override // com.tencent.imsdk.android.base.unifiedaccount.IMSDKWebVerifyListener
                                    public void execute(String str8) {
                                        IMSDKUnifiedAccountManager.this.performAccountLogin(str, i, str2, str3, str4, z2, iMSDKResultListener, str5, str8, str7);
                                    }
                                }, iMSDKResultListener, jSONObject2);
                            } else {
                                IMSDKUnifiedAccountManager.this.performAccountLogin(str, i, str2, str3, str4, z2, iMSDKResultListener, str5, "", str7);
                            }
                        }
                    } catch (JSONException unused2) {
                        IMLogger.e("error when parsing IMSDKInnerUnifiedAccountResult", new Object[0]);
                    }
                }

                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    if (IMSDKUnifiedAccountManager.this.mSTBuilder != null) {
                        IMSDKUnifiedAccountManager.this.mSTBuilder.setMethod(IR.path.UNIFIED_ACCOUNT_POPSTATUS_PATH).setStage("network response error").setResult(iMSDKResult.thirdRetMsg).setCrypt(true).create().reportEvent();
                    }
                    if (iMSDKResultListener != null) {
                        iMSDKResultListener.onResult(new IMSDKLoginResult(iMSDKResult.imsdkRetCode, iMSDKResult.imsdkRetMsg, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg));
                    }
                }
            });
            return;
        }
        renderWebVerify(new IMSDKWebVerifyListener() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.3
            @Override // com.tencent.imsdk.android.base.unifiedaccount.IMSDKWebVerifyListener
            public void execute(String str6) {
                IMSDKUnifiedAccountManager.this.performAccountLogin(str, i, str2, str3, str4, z2, iMSDKResultListener, str5, str6, "");
            }
        }, iMSDKResultListener, jSONObject2);
    }

    private BigInteger getSid() {
        return new BigInteger(DigestUtils.getMD5(UUID.randomUUID().toString()).substring(16), 16);
    }

    public static final BigDecimal readUnsignedLong(long j) throws IOException {
        if (j >= 0) {
            return new BigDecimal(j);
        }
        return BigDecimal.valueOf(j & Long.MAX_VALUE).add(BigDecimal.valueOf(Long.MAX_VALUE)).add(BigDecimal.valueOf(1L));
    }

    private String getUin(String str) {
        if (T.ckIsEmpty(str)) {
            return "";
        }
        return DigestUtils.getMD5(str + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_APP_ID, IR.meta.IMSDK_UNIFIED_ACCOUNT_APP_ID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public void performAccountLogin(String str, int i, String str2, String str3, String str4, boolean z, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str5, String str6, String str7) {
        boolean orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_ACCOUNT_VERIFY_OPT_SID_ENABLE, IR.meta.IMSDK_ACCOUNT_VERIFY_OPT_SID_ENABLE, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str3);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str5);
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_PASSWORD, getSecurePSWString(str2));
            if (!T.ckIsEmpty(str6)) {
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_QCAPTCHA, new JSONObject(str6));
            }
            if (orMetaData) {
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_SESSION_ID, this.mSid);
            }
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_PTICKET, str7);
        } catch (JSONException e2) {
            e = e2;
            IMLogger.e("login jsonException : " + e.getMessage(), new Object[0]);
            String jSONObject2 = jSONObject.toString();
            loginWithUrl(str, i, getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_LOGIN_PATH, jSONObject2, str4), IR.path.UNIFIED_ACCOUNT_LOGIN_PATH, z, jSONObject2, iMSDKResultListener);
        }
        String jSONObject22 = jSONObject.toString();
        loginWithUrl(str, i, getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_LOGIN_PATH, jSONObject22, str4), IR.path.UNIFIED_ACCOUNT_LOGIN_PATH, z, jSONObject22, iMSDKResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderWebVerify(IMSDKWebVerifyListener iMSDKWebVerifyListener, IMSDKResultListener iMSDKResultListener, String str) {
        try {
            Class.forName("com.tencent.imsdk.android.login.webverify.IMSDKWebVerify").getMethod("renderWebVerifyActivity", Context.class, IMSDKWebVerifyListener.class, IMSDKResultListener.class, String.class).invoke(null, mCurCtx, iMSDKWebVerifyListener, iMSDKResultListener, str);
        } catch (Exception e) {
            IMLogger.e("class not found, actions with password must integrate imsdkwebverify plugin: " + e.getMessage(), new Object[0]);
            iMSDKResultListener.onResult(new IMSDKLoginResult(9, 9, "actions with password must integrate imsdkwebverify plugin"));
        }
    }

    public void loginWithCode(String str, int i, String str2, String str3, String str4, int i2, boolean z, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str5) {
        IMLogger.d("IMSDKUnifiedAccountManager::loginWithCode(account=%s, accountType=%d, verifyCode=%s, areaCode=%s, langType=%s, isReceiveEmail=%d, isBind=%b, listener, extraJson=%s)", str, Integer.valueOf(i), str2, str3, str4, Integer.valueOf(i2), Boolean.valueOf(z), str5);
        this.mSTBuilder.setMethod("loginWithCode").create().reportEvent();
        if (!checkIsNumberString(str2)) {
            iMSDKResultListener.onResult(new IMSDKLoginResult(11, 11, "verifyCode invalid, must be numbers"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME, str);
            try {
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_TYPE, i);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_AREA_CODE, str3);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_EXTRA, str5);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_IS_RECEIVE_EMAIL, i2);
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_VERIFY_CODE, Integer.valueOf(str2));
                jSONObject.put(IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoJson(mCurCtx));
            } catch (JSONException e) {
                e = e;
                IMLogger.e("registerAccount jsonException : " + e.getMessage(), new Object[0]);
                String jSONObject2 = jSONObject.toString();
                loginWithUrl(str, i, getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_LOGIN_WITH_CODE_PATH, jSONObject2, str4), IR.path.UNIFIED_ACCOUNT_LOGIN_WITH_CODE_PATH, z, jSONObject2, iMSDKResultListener);
            }
        } catch (JSONException e2) {
            e = e2;
        }
        String jSONObject22 = jSONObject.toString();
        loginWithUrl(str, i, getUnifiedAccountURL(IR.path.UNIFIED_ACCOUNT_LOGIN_WITH_CODE_PATH, jSONObject22, str4), IR.path.UNIFIED_ACCOUNT_LOGIN_WITH_CODE_PATH, z, jSONObject22, iMSDKResultListener);
    }

    private String getUnifiedAccountURL(String str, String str2, String str3) {
        Context context;
        String str4 = "https://" + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_UNIFIED_ACCOUNT.toUpperCase(), IR.meta.IMSDK_SERVER_UNIFIED_ACCOUNT);
        String str5 = "account_plat_type=" + accountPlatformType() + "&appid=" + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_APP_ID, IR.meta.IMSDK_UNIFIED_ACCOUNT_APP_ID) + "&lang_type=" + str3 + "&os=1";
        String orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_SDK_KEY, IR.meta.IMSDK_UNIFIED_ACCOUNT_SDK_KEY);
        if (T.ckIsEmpty(orMetaData) && (context = mCurCtx) != null) {
            orMetaData = IMSDKValidKeyCalcUnit.getIns(context).getApplicationSignature();
        }
        return str4 + "/" + str + "?" + str5 + "&sig=" + DigestUtils.getMD5("/" + str + "?" + str5 + str2 + orMetaData);
    }

    private void requestWithUrl(String str, final String str2, String str3, final IMSDKResultListener<IMSDKUnifiedAccountResult> iMSDKResultListener) {
        this.mClient.post(str, str3, new IMSDKListener<String>() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.4
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(String str4) {
                IMSDKUnifiedAccountResult iMSDKUnifiedAccountResult;
                IMLogger.d("onNotify raw string = " + str4);
                IMLogger.json(str4);
                if (T.ckIsEmpty(str4)) {
                    iMSDKUnifiedAccountResult = new IMSDKUnifiedAccountResult(5, 4);
                } else {
                    try {
                        iMSDKUnifiedAccountResult = new IMSDKUnifiedAccountResult(str4);
                        if (iMSDKUnifiedAccountResult.retCode == 0) {
                            iMSDKUnifiedAccountResult.imsdkRetCode = 1;
                            iMSDKUnifiedAccountResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKUnifiedAccountResult.imsdkRetCode);
                        } else {
                            iMSDKUnifiedAccountResult.imsdkRetCode = 5;
                            iMSDKUnifiedAccountResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKUnifiedAccountResult.imsdkRetCode);
                            iMSDKUnifiedAccountResult.thirdRetCode = iMSDKUnifiedAccountResult.retCode;
                            iMSDKUnifiedAccountResult.thirdRetMsg = iMSDKUnifiedAccountResult.retMsg;
                        }
                    } catch (JSONException e) {
                        IMLogger.e("onNotify parse result jsonException : " + e.getMessage(), new Object[0]);
                        iMSDKUnifiedAccountResult = new IMSDKUnifiedAccountResult(-1, "onNotify parse result jsonException : " + e.getMessage(), 0, "");
                    }
                }
                if (IMSDKUnifiedAccountManager.this.mSTBuilder != null) {
                    IMSDKUnifiedAccountManager.this.mSTBuilder.setMethod(str2).setStage("network response success").setResult(iMSDKUnifiedAccountResult.thirdRetMsg).create().reportEvent();
                }
                IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                if (iMSDKResultListener2 != null) {
                    iMSDKResultListener2.onResult(iMSDKUnifiedAccountResult);
                }
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                if (IMSDKUnifiedAccountManager.this.mSTBuilder != null) {
                    IMSDKUnifiedAccountManager.this.mSTBuilder.setMethod(str2).setStage("network response error").setResult(iMSDKResult.thirdRetMsg).setCrypt(true).create().reportEvent();
                }
                if (iMSDKResultListener != null) {
                    iMSDKResultListener.onResult(new IMSDKUnifiedAccountResult(iMSDKResult.imsdkRetCode, iMSDKResult.imsdkRetMsg, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg));
                }
            }
        });
    }

    private void loginWithUrl(final String str, final int i, String str2, final String str3, boolean z, String str4, final IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        this.mClient.post(str2, str4, new IMSDKListener<String>() { // from class: com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager.5
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(String str5) {
                IMSDKLoginResult iMSDKLoginResult = new IMSDKLoginResult(1, 0);
                iMSDKLoginResult.retExtraJson = str5;
                try {
                    JSONObject jSONObject = new JSONObject(iMSDKLoginResult.retExtraJson);
                    if (jSONObject.get("uid") != null && jSONObject.get("token") != null) {
                        UnifiedAccountToken unifiedAccountToken = new UnifiedAccountToken();
                        unifiedAccountToken.account = str;
                        unifiedAccountToken.accountType = i;
                        unifiedAccountToken.uid = jSONObject.getString("uid");
                        unifiedAccountToken.token = jSONObject.getString("token");
                        unifiedAccountToken.expire = jSONObject.getLong(IR.unifiedAccount.UNIFIED_ACCOUNT_EXPIRE);
                        UnifiedAccountSession.cleanToken(IMSDKUnifiedAccountManager.mCurCtx, str, i);
                        UnifiedAccountSession.setToken(IMSDKUnifiedAccountManager.mCurCtx, unifiedAccountToken);
                    }
                } catch (Exception e) {
                    IMLogger.e("failed to cache token : " + e.getMessage(), new Object[0]);
                }
                iMSDKResultListener.onResult(iMSDKLoginResult);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                if (IMSDKUnifiedAccountManager.this.mSTBuilder != null) {
                    IMSDKUnifiedAccountManager.this.mSTBuilder.setMethod(str3).setStage("network response error").setResult(iMSDKResult.thirdRetMsg).setCrypt(true).create().reportEvent();
                }
                iMSDKResultListener.onResult(new IMSDKLoginResult(iMSDKResult.imsdkRetCode, iMSDKResult.imsdkRetMsg, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg));
            }
        });
    }

    private int accountPlatformType() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_PLATFORM_TYPE, IR.meta.IMSDK_UNIFIED_ACCOUNT_PLATFORM_TYPE, 0);
    }

    private int channelId() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_CHANNEL_ID, IR.meta.IMSDK_UNIFIED_ACCOUNT_CHANNEL_ID, 0);
    }

    private boolean checkIsNumberString(String str) {
        if (T.ckIsEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]+").matcher(str).matches();
    }

    private boolean checkIsValidPassword(String str) {
        boolean orMetaData = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_CHECK_PASSWORD, IR.meta.IMSDK_UNIFIED_ACCOUNT_CHECK_PASSWORD, false);
        IMLogger.d("needCheckLength is: %b", Boolean.valueOf(orMetaData));
        if (!orMetaData) {
            return true;
        }
        if (str.length() < 8 || str.length() > 20) {
            IMLogger.e("password length invalid", new Object[0]);
            return false;
        }
        return Pattern.compile("[a-zA-Z0-9!@#$%^&*()+=\\\\-_/?<>,.:;|]+").matcher(str).matches();
    }

    private String getSecurePSWString(String str) {
        return DigestUtils.getMD5(str);
    }

    private JSONObject getDeviceInfoJson(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (IMSDKConfig.getOrMetaData(IR.meta.IMSDK_DEVICE_INFO_ENABLE, IR.meta.IMSDK_DEVICE_INFO_ENABLE, true)) {
            try {
                jSONObject.put("nt", T.Device.getNetworkType(context));
                jSONObject.put("so", T.Device.getSimOperator(context));
                jSONObject.put("mdl", T.Device.getModel());
                jSONObject.put("dl", T.Device.getLanguage());
                jSONObject.put("av", T.Device.getAppVersion(context));
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("sd", T.Device.getScreenDPI(context));
                jSONObject.put("sr", T.Device.getScreenResolution(context));
                jSONObject.put("brd", T.Device.getBrand());
            } catch (JSONException unused) {
                IMLogger.e("json parsing error", new Object[0]);
            }
        }
        return jSONObject;
    }
}
