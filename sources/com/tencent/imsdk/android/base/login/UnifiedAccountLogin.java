package com.tencent.imsdk.android.base.login;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager;
import com.tencent.imsdk.android.base.unifiedaccount.UnifiedAccountSession;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UnifiedAccountLogin extends IMSDKLoginBase {
    private static final int UNIFIED_ACCOUNT_RESPONSE_SUCCESS = 0;
    private static String mToken = "";
    private static String mUid = "";
    private InnerStat.Builder mSTBuilder;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return true;
    }

    public UnifiedAccountLogin(Context context) {
        super(context);
        this.mSTBuilder = new InnerStat.Builder(context, "2.10.1", "");
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void bind(IMSDKLoginResult iMSDKLoginResult, String str, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, Object... objArr) {
        logout(new IMSDKResultListener<IMSDKResult>() { // from class: com.tencent.imsdk.android.base.login.UnifiedAccountLogin.1
            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                IMLogger.d("UnifiedAccount logout before bind...");
            }
        });
        super.bind(iMSDKLoginResult, str, iMSDKResultListener, objArr);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase, com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        IMSDKResult handleServerData = super.handleServerData(str, bArr, map);
        if ((handleServerData instanceof IMSDKLoginResult) && handleServerData.imsdkRetCode == 1) {
            UnifiedAccountSession.updateToken(this.mCurCtx);
        }
        return handleServerData;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        if (objArr.length > 1) {
            boolean z = loginAction == IMSDKLoginBase.LoginAction.BIND;
            String str2 = "";
            if (objArr[1].getClass().getName().equals("java.lang.String")) {
                str2 = objArr[1].toString();
            } else if (objArr[1].getClass().getName().equals("[Ljava.lang.Object;")) {
                str2 = String.valueOf(((Object[]) objArr[1])[0]);
            }
            dealUnifiedAccount(z, new IMSDKResultListener<IMSDKLoginResult>() { // from class: com.tencent.imsdk.android.base.login.UnifiedAccountLogin.2
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKLoginResult iMSDKLoginResult) {
                    if (iMSDKLoginResult.imsdkRetCode != 1) {
                        iMSDKListener.onResult(iMSDKLoginResult);
                        return;
                    }
                    String str3 = iMSDKLoginResult.retExtraJson;
                    if (T.ckIsEmpty(str3)) {
                        iMSDKListener.onResult(new IMSDKLoginResult(5, 4));
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        int i = jSONObject.has("ret") ? jSONObject.getInt("ret") : -1;
                        if (i == 0) {
                            String string = jSONObject.has("token") ? jSONObject.getString("token") : "";
                            String string2 = jSONObject.has("uid") ? jSONObject.getString("uid") : "";
                            if (!T.ckIsEmpty(string) && !T.ckIsEmpty(string2)) {
                                Map<String, String> sortableMap = T.getSortableMap();
                                sortableMap.put("uid", string2);
                                sortableMap.put("token", string);
                                sortableMap.put("iChannel", String.valueOf(UnifiedAccountLogin.this.getChannelId()));
                                String unused = UnifiedAccountLogin.mToken = string;
                                String unused2 = UnifiedAccountLogin.mUid = string2;
                                if (UnifiedAccountLogin.this.mSTBuilder != null) {
                                    UnifiedAccountLogin.this.mSTBuilder.setExtraProp(sortableMap).setMethod("login2Channel(UnifiedAccount)").create().reportEvent();
                                }
                                iMSDKListener.onNotify(sortableMap);
                                return;
                            }
                            IMLogger.e("unifiedAccount return empty token or uid", new Object[0]);
                            iMSDKListener.onResult(new IMSDKLoginResult(-1, "unifiedAccount return empty token or uid: token = " + string + ", uid = " + string2, i, ""));
                            return;
                        }
                        IMSDKLoginResult iMSDKLoginResult2 = new IMSDKLoginResult(str3);
                        iMSDKLoginResult2.imsdkRetCode = 9999;
                        iMSDKLoginResult2.thirdRetCode = i;
                        iMSDKLoginResult2.thirdRetMsg = jSONObject.has("msg") ? jSONObject.getString("msg") : "";
                        iMSDKListener.onResult(iMSDKLoginResult2);
                    } catch (JSONException e) {
                        IMLogger.e("onNotify parse result jsonException : " + e.getMessage(), new Object[0]);
                        iMSDKListener.onResult(new IMSDKLoginResult(-1, "parse result jsonException : " + e.getMessage(), 0, str3));
                    }
                }
            }, str2);
            return;
        }
        IMLogger.e("unifiedAccount login2Channel with empty account info", new Object[0]);
        iMSDKListener.onResult(new IMSDKResult(11, "unifiedAccount login2Channel with empty account info"));
    }

    private void dealUnifiedAccount(boolean z, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str) {
        if (T.ckIsEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE) ? jSONObject.getString(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE) : "";
            if (!string.equals("register") && !string.equals(FirebaseAnalytics.Event.LOGIN) && !string.equals("loginWithCode")) {
                IMLogger.e("IMSDK dealUnifiedAccount with invalid actionType", new Object[0]);
                iMSDKResultListener.onResult(new IMSDKLoginResult(9999, 11, "make sure your account info correct"));
                return;
            }
            String string2 = jSONObject.has(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME) ? jSONObject.getString(IR.unifiedAccount.UNIFIED_ACCOUNT_USERNAME) : "";
            int i = jSONObject.has("accountType") ? jSONObject.getInt("accountType") : -1;
            String string3 = jSONObject.has(IR.unifiedAccount.UNIFIED_ACCOUNT_PASSWORD) ? jSONObject.getString(IR.unifiedAccount.UNIFIED_ACCOUNT_PASSWORD) : "";
            String string4 = jSONObject.has("verifyCode") ? jSONObject.getString("verifyCode") : "";
            String string5 = jSONObject.has("areaCode") ? jSONObject.getString("areaCode") : "";
            String string6 = jSONObject.has("langType") ? jSONObject.getString("langType") : "";
            int i2 = jSONObject.has("isReceiveEmail") ? jSONObject.getInt("isReceiveEmail") : 0;
            IMSDKUnifiedAccountManager iMSDKUnifiedAccountManager = IMSDKUnifiedAccountManager.getInstance();
            if (string.equals("register") && !T.ckIsEmpty(string2) && !T.ckIsEmpty(string3) && i != -1) {
                iMSDKUnifiedAccountManager.registerAccount(string2, i, string3, string4, string5, string6, z, iMSDKResultListener, "");
                return;
            }
            if (string.equals(FirebaseAnalytics.Event.LOGIN) && !T.ckIsEmpty(string2) && !T.ckIsEmpty(string3) && i != -1) {
                iMSDKUnifiedAccountManager.login(string2, i, string3, string5, string6, z, iMSDKResultListener, "");
                return;
            }
            if (string.equals("loginWithCode") && !T.ckIsEmpty(string2) && !T.ckIsEmpty(string4) && i != -1) {
                iMSDKUnifiedAccountManager.loginWithCode(string2, i, string4, string5, string6, i2, z, iMSDKResultListener, "");
            } else {
                IMLogger.e("IMSDK dealUnifiedAccount invalid extraJson, check your account info", new Object[0]);
                iMSDKResultListener.onResult(new IMSDKLoginResult(9999, 11, "make sure your account info correct"));
            }
        } catch (JSONException e) {
            IMLogger.e("dealUnifiedAccount catch jsonException : " + e.getMessage(), new Object[0]);
            iMSDKResultListener.onResult(new IMSDKLoginResult(9999, 0, "catch jsonException : " + e.getMessage()));
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        if (T.ckIsEmpty(mToken) || T.ckIsEmpty(mUid)) {
            return;
        }
        map.put("token", mToken);
        map.put("uid", mUid);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        iMSDKLoginResult.channel = getChannel();
        iMSDKLoginResult.channelId = getChannelId();
        if (!T.ckIsEmpty(mToken)) {
            iMSDKLoginResult.channelToken = mToken;
        }
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_UNIFIED_ACCOUNT_CHANNEL_ID, IR.meta.IMSDK_UNIFIED_ACCOUNT_CHANNEL_ID, 0);
    }
}
