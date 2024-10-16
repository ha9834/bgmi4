package com.tencent.imsdk.android.login.webverify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.unifiedaccount.IMSDKWebVerifyListener;
import com.tencent.imsdk.android.tools.log.IMLogger;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKWebVerify {
    private static final int REQUEST_WEB_VERIFY_CODE = 136;

    public static void renderWebVerifyActivity(final Context context, final IMSDKWebVerifyListener iMSDKWebVerifyListener, final IMSDKResultListener iMSDKResultListener, final String str) {
        if (context != null) {
            IMSDKProxyActivity.registerLifeCycle(context, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.webverify.IMSDKWebVerify.1
                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected void onActivityCreate(Bundle bundle, Activity activity) {
                    Intent intent = new Intent(context, (Class<?>) WebVerifyActivity.class);
                    intent.putExtra(WebVerifyConst.IMSDK_VERIFY_OPTIONS, str);
                    activity.startActivityForResult(intent, 136);
                }

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected boolean onActivityResult(int i, int i2, Intent intent) {
                    if (i != 136) {
                        return true;
                    }
                    if (i2 == 0) {
                        IMLogger.d("user canceled");
                        iMSDKResultListener.onResult(new IMSDKLoginResult(2, 2, "user canceled"));
                        return true;
                    }
                    if (intent == null) {
                        IMLogger.d("web verify data is null");
                        iMSDKResultListener.onResult(new IMSDKLoginResult(2, 2, "web verify data is null"));
                        return true;
                    }
                    int intExtra = intent.getIntExtra("ret", 2);
                    String stringExtra = intent.getStringExtra("msg");
                    if (intExtra == 1) {
                        String stringExtra2 = intent.getStringExtra(WebVerifyConst.IMSDK_WEB_VERIFY_CAPTCHA);
                        new JSONObject();
                        if (iMSDKWebVerifyListener != null) {
                            IMLogger.d("start invoking webVerifyListener.execute logic");
                            iMSDKWebVerifyListener.execute(stringExtra2);
                            return true;
                        }
                        IMLogger.d("need to pass webVerifyListener callback");
                        return true;
                    }
                    IMLogger.d("user cancel from web verify");
                    iMSDKResultListener.onResult(new IMSDKLoginResult(2, intExtra, stringExtra));
                    return true;
                }
            });
        }
    }
}
