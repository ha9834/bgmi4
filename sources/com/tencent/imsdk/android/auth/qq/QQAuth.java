package com.tencent.imsdk.android.auth.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.imsdk.android.QQAgent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.auth.IMSDKAuthConnectResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.interfaces.IAppAvailable;
import com.tencent.imsdk.android.base.interfaces.IConnectable;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.tauth.Tencent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class QQAuth implements IAppAvailable, IConnectable {
    private Context mCtx;
    private InnerStat.Builder mSTBuilder;
    private Tencent mTencent;
    private List<String> mQQPermissionList = new ArrayList();
    private QQAuthListener mQQAuthListener = null;

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public String getChannelId() {
        return QQAgent.QQ_CHANNEL_ID;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IAppAvailable
    public boolean isApplicationInstalled() {
        return true;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IAppAvailable
    public boolean isApplicationSupported() {
        return true;
    }

    public QQAuth(Context context) {
        this.mCtx = null;
        this.mTencent = null;
        this.mCtx = context;
        if (this.mTencent == null) {
            if (IMSDKConfig.getOrMetaData(QQAgent.IMSDK_QQ_SET_PERMISSION_GRANTED, QQAgent.IMSDK_QQ_SET_PERMISSION_GRANTED, true)) {
                Tencent.setIsPermissionGranted(true);
            }
            this.mTencent = Tencent.createInstance(QQAgent.getQQAppId(context), context.getApplicationContext());
            this.mSTBuilder = new InnerStat.Builder(context, "2.6.1", Constants.SDK_VERSION);
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public void login(String str, final IMSDKListener<Map<String, String>> iMSDKListener, final Object... objArr) {
        IMLogger.d("QQAuth login...");
        if (this.mTencent.isSessionValid()) {
            IMLogger.d("Tencent session is valid...");
            String accessToken = this.mTencent.getAccessToken();
            String openId = this.mTencent.getOpenId();
            IMLogger.d("token = " + accessToken);
            IMLogger.d("openId = " + openId);
            fillParamsWithAccessToken(iMSDKListener, accessToken, openId);
            return;
        }
        IMSDKProxyActivity.registerLifeCycle(this.mCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.auth.qq.QQAuth.1
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle, Activity activity) {
                QQAuth qQAuth = QQAuth.this;
                qQAuth.mQQAuthListener = new QQAuthListener(1, activity, iMSDKListener);
                StringBuilder sb = new StringBuilder();
                try {
                    if (objArr != null) {
                        int i = 0;
                        if (objArr[0] != null && (objArr[0] instanceof List)) {
                            QQAuth.this.mQQPermissionList = (List) objArr[0];
                            if (QQAuth.this.mQQPermissionList.size() == 0) {
                                QQAuth.this.mQQPermissionList.add("get_simple_userinfo");
                            }
                            while (i < QQAuth.this.mQQPermissionList.size()) {
                                sb.append((String) QQAuth.this.mQQPermissionList.get(i));
                                i++;
                                if (i < QQAuth.this.mQQPermissionList.size()) {
                                    sb.append(",");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    IMLogger.d("parse permission error occur, " + e.getMessage());
                }
                if (QQAuth.this.mSTBuilder != null) {
                    InnerStat.Builder builder = QQAuth.this.mSTBuilder;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("auth QQ with permissions ");
                    sb2.append(sb.length() != 0 ? sb.toString() : "Empty");
                    builder.setMethod(sb2.toString()).create().reportEvent();
                }
                String sb3 = sb.length() != 0 ? sb.toString() : "get_simple_userinfo";
                IMLogger.d("QQ permissions : " + sb3);
                QQAuth.this.mTencent.login(activity, sb3, QQAuth.this.mQQAuthListener);
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i, int i2, Intent intent) {
                IMLogger.d("onActivityResult, requestCode=" + i + " resultCode=" + i2);
                if (i != 11101) {
                    return true;
                }
                Tencent.onActivityResultData(i, i2, intent, QQAuth.this.mQQAuthListener);
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

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public void logout(IMSDKResultListener iMSDKResultListener) {
        this.mTencent.logout(this.mCtx);
        IMLogger.d(getClass().getSimpleName() + " logout success");
        iMSDKResultListener.onResult(new IMSDKResult(1, 1));
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public String getChannelUserId() {
        return this.mTencent.getOpenId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithAccessToken(IMSDKListener<Map<String, String>> iMSDKListener, String str, String str2) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("sOpenKey", str);
        sortableMap.put("sOpenId", str2);
        sortableMap.put("iChannel", QQAgent.QQ_CHANNEL_ID);
        IMLogger.d(getClass().getSimpleName() + " auth completed, return data " + sortableMap.toString());
        if (iMSDKListener != null) {
            iMSDKListener.onNotify(sortableMap);
        } else {
            IMLogger.e("listener is null...", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    private class QQAuthListener extends QQAgent.QQListener {
        public QQAuthListener(int i, Activity activity, IMSDKListener<Map<String, String>> iMSDKListener) {
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
                    QQAuth.this.mTencent.setAccessToken(string2, string);
                    QQAuth.this.mTencent.setOpenId(string3);
                }
                IMLogger.d("token = " + string2);
                IMLogger.d("openId = " + string3);
                QQAuth.this.fillParamsWithAccessToken(this.imsdkListener, string2, string3);
            } catch (Exception e) {
                IMLogger.e("get key from json error, e=" + e.getMessage(), new Object[0]);
                if (this.imsdkListener != null) {
                    this.imsdkListener.onResult(new IMSDKAuthConnectResult(9999, "QQ auth error occur", 11, e.getMessage()));
                }
            }
        }
    }
}
