package com.tencent.imsdk.android.agent.wechat;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.imsdk.android.tools.MetaDataUtils;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* loaded from: classes.dex */
public class WeChatAgentActivity extends Activity implements IWXAPIEventHandler {
    public static final String CHANNEL = "WeChat";
    public static final String CHANNEL_ID = "4";
    public static final String WECHAT_APP_ID = "IMSDK_WECHAT_APP_ID";
    public static final int WECHAT_AUTH_CALLBACK = 1;
    public static final int WECHAT_FRIEND_CALLBACK = 2;
    public static final int WECHAT_LOGIN_CALLBACK = 3;
    public static SparseArray<IWXAPIEventHandler> mWeChatMessagesQueue = new SparseArray<>();
    private IWXAPI mWXApi;

    public void onReq(BaseReq baseReq) {
        IMLogger.d("onReq");
        for (int i = 0; i < mWeChatMessagesQueue.size(); i++) {
            IWXAPIEventHandler valueAt = mWeChatMessagesQueue.valueAt(i);
            if (valueAt != null) {
                valueAt.onReq(baseReq);
            }
        }
        finish();
    }

    public void onResp(BaseResp baseResp) {
        IMLogger.d("onResp");
        for (int i = 0; i < mWeChatMessagesQueue.size(); i++) {
            IWXAPIEventHandler valueAt = mWeChatMessagesQueue.valueAt(i);
            if (valueAt != null) {
                valueAt.onResp(baseResp);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IMLogger.d("wechat client execute success ...");
        String readFromApplication = MetaDataUtils.readFromApplication(this, WECHAT_APP_ID, "");
        this.mWXApi = WXAPIFactory.createWXAPI(this, readFromApplication);
        if (!this.mWXApi.registerApp(readFromApplication)) {
            IMLogger.e("register wechat error , current app id is " + readFromApplication, new Object[0]);
            finish();
        }
        this.mWXApi.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IMLogger.d("onNewIntent");
        setIntent(intent);
        this.mWXApi.handleIntent(intent, this);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IMLogger.d("onConfigurationChanged");
    }
}
