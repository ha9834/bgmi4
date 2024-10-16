package com.tencent.imsdk.android.login.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.imsdk.android.QQAgent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.tauth.Tencent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class QQLogin extends IMSDKLoginBase {
    private Context mCtx;
    private QQLoginListener mQQLoginListener;
    private List<String> mQQPermissionList;
    private Tencent mTencent;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return true;
    }

    public QQLogin(Context context) {
        super(context);
        this.mQQPermissionList = new ArrayList();
        this.mCtx = null;
        this.mTencent = null;
        this.mQQLoginListener = null;
        this.mCtx = context;
        if (this.mTencent == null) {
            if (IMSDKConfig.getOrMetaData(QQAgent.IMSDK_QQ_SET_PERMISSION_GRANTED, QQAgent.IMSDK_QQ_SET_PERMISSION_GRANTED, true)) {
                Tencent.setIsPermissionGranted(true);
            }
            this.mTencent = Tencent.createInstance(QQAgent.getQQAppId(context), context.getApplicationContext());
            this.mSTBuilder = new InnerStat.Builder(context, "2.6.1", Constants.SDK_VERSION);
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        this.mTencent.logout(this.mCtx);
        IMLogger.d(getClass().getSimpleName() + " logout success");
        super.logout(iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, final Object... objArr) {
        IMLogger.d("QQLogin...");
        if (this.mTencent.isSessionValid()) {
            IMLogger.d("Tencent session valid, Already login...");
            String accessToken = this.mTencent.getAccessToken();
            String openId = this.mTencent.getOpenId();
            IMLogger.d("token = " + accessToken);
            IMLogger.d("openId = " + openId);
            fillParamsWithAccessToken(iMSDKListener, accessToken, openId);
            return;
        }
        IMSDKProxyActivity.registerLifeCycle(this.mCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.qq.QQLogin.1
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle, Activity activity) {
                QQLogin qQLogin = QQLogin.this;
                qQLogin.mQQLoginListener = new QQLoginListener(2, activity, iMSDKListener);
                StringBuilder sb = new StringBuilder();
                try {
                    if (objArr != null) {
                        int i = 0;
                        if (objArr[0] != null && (objArr[0] instanceof List)) {
                            QQLogin.this.mQQPermissionList = (List) objArr[0];
                            if (QQLogin.this.mQQPermissionList.size() == 0) {
                                QQLogin.this.mQQPermissionList.add("get_simple_userinfo");
                            }
                            while (i < QQLogin.this.mQQPermissionList.size()) {
                                sb.append((String) QQLogin.this.mQQPermissionList.get(i));
                                i++;
                                if (i < QQLogin.this.mQQPermissionList.size()) {
                                    sb.append(",");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    IMLogger.d("parse permission error occur, " + e.getMessage());
                }
                if (QQLogin.this.mSTBuilder != null) {
                    InnerStat.Builder builder = QQLogin.this.mSTBuilder;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("login QQ with permissions ");
                    sb2.append(sb.length() != 0 ? sb.toString() : "Empty");
                    builder.setMethod(sb2.toString()).create().reportEvent();
                }
                String sb3 = sb.length() != 0 ? sb.toString() : "get_simple_userinfo";
                IMLogger.d("QQ permissions : " + sb3);
                QQLogin.this.mTencent.login(activity, sb3, QQLogin.this.mQQLoginListener);
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i, int i2, Intent intent) {
                IMLogger.d("onActivityResult, requestCode=" + i + " resultCode=" + i2);
                if (i != 11101) {
                    return true;
                }
                Tencent.onActivityResultData(i, i2, intent, QQLogin.this.mQQLoginListener);
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            public void onActivityDestroy() {
                super.onActivityDestroy();
                IMLogger.d("onActivityDestroy");
            }
        });
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        iMSDKLoginResult.channelPermissions = this.mQQPermissionList;
        iMSDKLoginResult.channel = "QQ";
        iMSDKLoginResult.channelId = getChannelId();
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return Integer.valueOf(QQAgent.QQ_CHANNEL_ID).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithAccessToken(IMSDKListener<Map<String, String>> iMSDKListener, String str, String str2) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("sOpenKey", str);
        sortableMap.put("sOpenId", str2);
        sortableMap.put("iChannel", QQAgent.QQ_CHANNEL_ID);
        IMLogger.d(getClass().getSimpleName() + " login completed, return data " + sortableMap.toString());
        if (iMSDKListener != null) {
            iMSDKListener.onNotify(sortableMap);
        } else {
            IMLogger.e("listener is null...", new Object[0]);
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        map.put("sOpenKey", this.mTencent.getAccessToken());
        map.put("sOpenId", this.mTencent.getOpenId());
        map.put("iChannel", QQAgent.QQ_CHANNEL_ID);
    }

    /* loaded from: classes.dex */
    private class QQLoginListener extends QQAgent.QQListener {
        public QQLoginListener(int i, Activity activity, IMSDKListener<Map<String, String>> iMSDKListener) {
            super(i, activity, iMSDKListener);
        }

        @Override // com.tencent.imsdk.android.QQAgent.QQListener
        protected void doReceiveData(JSONObject jSONObject) {
            IMLogger.d("doReceiveData, jsonData = " + jSONObject.toString());
            try {
                String string = jSONObject.getString("expires_in");
                String string2 = jSONObject.getString("access_token");
                String string3 = jSONObject.getString("openid");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string3)) {
                    QQLogin.this.mTencent.setAccessToken(string2, string);
                    QQLogin.this.mTencent.setOpenId(string3);
                }
                IMLogger.d("token = " + string2);
                IMLogger.d("openId = " + string3);
                QQLogin.this.fillParamsWithAccessToken(this.imsdkListener, string2, string3);
            } catch (Exception e) {
                IMLogger.e("get key from json error, e=" + e.getMessage(), new Object[0]);
                if (this.imsdkListener != null) {
                    this.imsdkListener.onResult(new IMSDKLoginResult(9999, "QQ login error occur", 11, e.getMessage()));
                }
            }
        }
    }
}
