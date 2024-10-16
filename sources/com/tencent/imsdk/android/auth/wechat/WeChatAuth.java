package com.tencent.imsdk.android.auth.wechat;

import android.content.Context;
import com.tencent.imsdk.android.WeChatHelper;
import com.tencent.imsdk.android.agent.wechat.WeChatAgentActivity;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.auth.IMSDKAuthConnectResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.interfaces.IAppAvailable;
import com.tencent.imsdk.android.base.interfaces.IConnectable;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.MetaDataUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import java.util.Map;

/* loaded from: classes.dex */
public class WeChatAuth implements IAppAvailable, IConnectable {
    private InnerStat.Builder mSTBuilder;
    private IWXAPI mWXApi;

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public String getChannelId() {
        return "4";
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public String getChannelUserId() {
        return "";
    }

    public WeChatAuth(Context context) {
        this.mWXApi = null;
        if (this.mWXApi == null) {
            String readFromApplication = MetaDataUtils.readFromApplication(context, WeChatAgentActivity.WECHAT_APP_ID, "");
            IMLogger.d("WeChat appId = " + readFromApplication);
            this.mWXApi = WXAPIFactory.createWXAPI(context, readFromApplication);
            if (!this.mWXApi.registerApp(readFromApplication)) {
                IMLogger.e("register wechat error , current app id is " + readFromApplication, new Object[0]);
            }
            this.mSTBuilder = new InnerStat.Builder(context, "2.6.1");
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public void login(String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        if (WeChatHelper.checkWeChatEnvError(this.mWXApi, iMSDKListener)) {
            return;
        }
        StringBuilder fillLoginPermissions = fillLoginPermissions(objArr);
        setWeChatLoginCallback(iMSDKListener);
        sendReqToWeChat(fillLoginPermissions);
    }

    private StringBuilder fillLoginPermissions(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        if (objArr != null && objArr.length > 0) {
            int i = 0;
            while (i < objArr.length) {
                sb.append(objArr[i]);
                i++;
                if (i < objArr.length) {
                    sb.append(",");
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("wechat permissions : ");
        sb2.append(sb.length() != 0 ? sb.toString() : "Empty");
        IMLogger.d(sb2.toString());
        InnerStat.Builder builder = this.mSTBuilder;
        if (builder != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("login wechat with permissions ");
            sb3.append(sb.length() != 0 ? sb.toString() : "Empty");
            builder.setMethod(sb3.toString()).create().reportEvent();
        }
        return sb;
    }

    private void setWeChatLoginCallback(final IMSDKListener<Map<String, String>> iMSDKListener) {
        WeChatAgentActivity.mWeChatMessagesQueue.put(1, new IWXAPIEventHandler() { // from class: com.tencent.imsdk.android.auth.wechat.WeChatAuth.1
            public void onReq(BaseReq baseReq) {
                WeChatAgentActivity.mWeChatMessagesQueue.delete(1);
            }

            public void onResp(BaseResp baseResp) {
                WeChatAgentActivity.mWeChatMessagesQueue.delete(1);
                SendAuth.Resp resp = (SendAuth.Resp) baseResp;
                Map<String, String> sortableMap = T.getSortableMap();
                int i = baseResp.errCode;
                if (i == -2) {
                    iMSDKListener.onResult(new IMSDKAuthConnectResult(2, IMSDKErrCode.getMessageByCode(2), baseResp.errCode, baseResp.errStr));
                    return;
                }
                if (i == 0) {
                    sortableMap.put("iChannel", "4");
                    sortableMap.put(OAuthConstants.PARAM_GRANT_TYPE, "authorization_code");
                    sortableMap.put("code", resp.code);
                    iMSDKListener.onNotify(sortableMap);
                    return;
                }
                iMSDKListener.onResult(new IMSDKAuthConnectResult(9999, IMSDKErrCode.getMessageByCode(9999), baseResp.errCode, baseResp.errStr));
            }
        });
    }

    private void sendReqToWeChat(StringBuilder sb) {
        if (this.mWXApi != null) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = sb.length() != 0 ? sb.toString() : "snsapi_userinfo";
            req.state = "WeChatAuth";
            this.mWXApi.sendReq(req);
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IConnectable
    public void logout(IMSDKResultListener iMSDKResultListener) {
        IWXAPI iwxapi = this.mWXApi;
        if (iwxapi != null) {
            iwxapi.unregisterApp();
            iMSDKResultListener.onResult(new IMSDKResult(1, 1));
        }
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IAppAvailable
    public boolean isApplicationInstalled() {
        return WeChatHelper.isApplicationInstalled(this.mWXApi);
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IAppAvailable
    public boolean isApplicationSupported() {
        return WeChatHelper.isApplicationSupported(this.mWXApi);
    }
}
