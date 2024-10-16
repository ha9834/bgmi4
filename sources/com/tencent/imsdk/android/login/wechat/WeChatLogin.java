package com.tencent.imsdk.android.login.wechat;

import android.content.Context;
import com.tencent.imsdk.android.WeChatHelper;
import com.tencent.imsdk.android.agent.wechat.WeChatAgentActivity;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class WeChatLogin extends IMSDKLoginBase {
    private SendAuth.Resp mRespAuth;
    private InnerStat.Builder mSTBuilder;
    private IWXAPI mWXApi;
    private List<String> mWXPermissionList;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return true;
    }

    public WeChatLogin(Context context) {
        super(context);
        this.mWXPermissionList = new ArrayList();
        this.mWXApi = null;
        initWeChat(context);
    }

    private void initWeChat(Context context) {
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

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        IMLogger.d(" WeChat login2Channel " + loginAction + " start !");
        if (WeChatHelper.checkWeChatEnvError(this.mWXApi, iMSDKListener)) {
            IMLogger.e("Wechat log2Channel checkWeChatEnvError error !", new Object[0]);
            iMSDKListener.onResult(new IMSDKLoginResult(3, IMSDKErrCode.getMessageByCode(3), 3, "Wechat log2Channel checkWeChatEnvError error "));
            return;
        }
        try {
            if (objArr[0] != null && (objArr[0] instanceof List)) {
                StringBuilder fillLoginPermissions = fillLoginPermissions(objArr[0]);
                setWeChatLoginCallback(iMSDKListener);
                sendReqToWeChat(iMSDKListener, fillLoginPermissions);
            } else {
                IMLogger.e("Wechat log2Channel permission must not be null !", new Object[0]);
                iMSDKListener.onResult(new IMSDKLoginResult(11, IMSDKErrCode.getMessageByCode(11), 11, "Wechat log2Channel permission must not be null "));
            }
        } catch (Exception e) {
            IMLogger.e("Wechat login2Channel exception error !", new Object[0]);
            iMSDKListener.onResult(new IMSDKLoginResult(3, IMSDKErrCode.getMessageByCode(3), 3, "Wechat login2Channel exception error " + e.getMessage()));
        }
    }

    private StringBuilder fillLoginPermissions(Object obj) {
        StringBuilder sb = new StringBuilder();
        this.mWXPermissionList = (List) obj;
        if (this.mWXPermissionList.size() == 0) {
            this.mWXPermissionList.add("snsapi_userinfo");
            this.mWXPermissionList.add("snsapi_friend");
            this.mWXPermissionList.add("snsapi_message");
        }
        int i = 0;
        while (i < this.mWXPermissionList.size()) {
            sb.append(this.mWXPermissionList.get(i));
            i++;
            if (i < this.mWXPermissionList.size()) {
                sb.append(",");
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

    private void sendReqToWeChat(IMSDKListener<Map<String, String>> iMSDKListener, StringBuilder sb) {
        if (this.mWXApi != null) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = sb.toString();
            req.state = "WeChatLogin";
            if (this.mWXApi.sendReq(req)) {
                return;
            }
            iMSDKListener.onResult(new IMSDKLoginResult(11, IMSDKErrCode.getMessageByCode(11), 11, "may be permission scope error"));
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        map.put("BindGrant_type", "authorization_code");
        SendAuth.Resp resp = this.mRespAuth;
        map.put("BindCode", resp == null ? "" : resp.code);
    }

    private void setWeChatLoginCallback(final IMSDKListener<Map<String, String>> iMSDKListener) {
        WeChatAgentActivity.mWeChatMessagesQueue.put(3, new IWXAPIEventHandler() { // from class: com.tencent.imsdk.android.login.wechat.WeChatLogin.1
            public void onReq(BaseReq baseReq) {
                WeChatAgentActivity.mWeChatMessagesQueue.delete(3);
            }

            public void onResp(BaseResp baseResp) {
                WeChatAgentActivity.mWeChatMessagesQueue.delete(3);
                WeChatLogin.this.mRespAuth = (SendAuth.Resp) baseResp;
                Map<String, String> sortableMap = T.getSortableMap();
                int i = baseResp.errCode;
                if (i == -2) {
                    iMSDKListener.onResult(new IMSDKLoginResult(2, IMSDKErrCode.getMessageByCode(2), baseResp.errCode, baseResp.errStr));
                    return;
                }
                if (i == 0) {
                    sortableMap.put("iChannel", "4");
                    sortableMap.put(OAuthConstants.PARAM_GRANT_TYPE, "authorization_code");
                    sortableMap.put("code", WeChatLogin.this.mRespAuth.code);
                    iMSDKListener.onNotify(sortableMap);
                    return;
                }
                iMSDKListener.onResult(new IMSDKLoginResult(9999, IMSDKErrCode.getMessageByCode(9999), baseResp.errCode, baseResp.errStr));
            }
        });
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        iMSDKLoginResult.channelPermissions = this.mWXPermissionList;
        iMSDKLoginResult.channel = WeChatAgentActivity.CHANNEL;
        iMSDKLoginResult.channelId = getChannelId();
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return Integer.parseInt("4");
    }
}
