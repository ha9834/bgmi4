package com.tencent.imsdk.android;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.auth.IMSDKAuthConnectResult;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.tools.MetaDataUtils;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class QQAgent {
    public static final String CHANNEL = "QQ";
    public static final String IMSDK_QQ_SET_PERMISSION_GRANTED = "IMSDK_QQ_SET_PERMISSION_GRANTED";
    public static final int LABEL_AUTH = 1;
    public static final int LABEL_LOGIN = 2;
    private static final String QQ_APP_ID = "IMSDK_QQ_APP_ID";
    public static final String QQ_CHANNEL_ID = "31";

    public static String getQQAppId(Context context) {
        String readFromApplication = MetaDataUtils.readFromApplication(context, QQ_APP_ID, "");
        IMLogger.d("QQ appId = " + readFromApplication);
        return readFromApplication;
    }

    public static boolean isQQClientAvailable(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class QQListener implements IUiListener {
        Activity imsdkActivity;
        protected IMSDKListener<Map<String, String>> imsdkListener;
        int labelType;

        protected void doReceiveData(JSONObject jSONObject) {
        }

        public QQListener(int i, Activity activity, IMSDKListener<Map<String, String>> iMSDKListener) {
            this.labelType = i;
            this.imsdkActivity = activity;
            this.imsdkListener = iMSDKListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            IMLogger.d("onComplete");
            if (obj != null) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() != 0) {
                    doReceiveData(jSONObject);
                }
            } else {
                IMSDKListener<Map<String, String>> iMSDKListener = this.imsdkListener;
                if (iMSDKListener != null) {
                    iMSDKListener.onResult(QQAgent.createIMSDKResult(this.labelType, 9999, 11, "QQ login return response null in onComplete"));
                }
            }
            Activity activity = this.imsdkActivity;
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IMLogger.e("onError, code=" + uiError.errorCode + ", msg=" + uiError.errorMessage + ", detail=" + uiError.errorDetail, new Object[0]);
            IMSDKListener<Map<String, String>> iMSDKListener = this.imsdkListener;
            if (iMSDKListener != null) {
                iMSDKListener.onResult(QQAgent.createIMSDKResult(this.labelType, 9999, "QQ login error occur", -1, uiError.errorMessage));
            }
            Activity activity = this.imsdkActivity;
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IMLogger.w("onCancel", new Object[0]);
            IMSDKListener<Map<String, String>> iMSDKListener = this.imsdkListener;
            if (iMSDKListener != null) {
                iMSDKListener.onResult(QQAgent.createIMSDKResult(this.labelType, 2, -1));
            }
            Activity activity = this.imsdkActivity;
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            IMLogger.e("get QQ onWarning : " + i, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IMSDKResult createIMSDKResult(int i, int i2, int i3) {
        switch (i) {
            case 1:
                return new IMSDKAuthConnectResult(i2, i3);
            case 2:
                return new IMSDKLoginResult(i2, i3);
            default:
                return new IMSDKLoginResult(11, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IMSDKResult createIMSDKResult(int i, int i2, int i3, String str) {
        switch (i) {
            case 1:
                return new IMSDKAuthConnectResult(i2, i3, str);
            case 2:
                return new IMSDKLoginResult(i2, i3, str);
            default:
                return new IMSDKLoginResult(11, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IMSDKResult createIMSDKResult(int i, int i2, String str, int i3, String str2) {
        switch (i) {
            case 1:
                return new IMSDKAuthConnectResult(i2, str, i3, str2);
            case 2:
                return new IMSDKLoginResult(i2, str, i3, str2);
            default:
                return new IMSDKLoginResult(11, -1);
        }
    }
}
