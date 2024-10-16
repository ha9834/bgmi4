package com.tencent.imsdk.android.login.facebook;

import android.content.Context;
import android.content.Intent;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class FacebookLogin extends IMSDKLoginBase {
    private static final int FACEBOOK_CHANNEL_ID = 1;
    private static final String IMSDK_FACEBOOK_AUTO_LOGOUT = "IMSDK_FACEBOOK_AUTO_LOGOUT";
    private CallbackManager mCallbackManager;
    private InnerStat.Builder mSTBuilder;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 1;
    }

    public FacebookLogin(Context context) {
        super(context);
        this.mCallbackManager = null;
        if (!FacebookSdk.isInitialized()) {
            FacebookSdk.sdkInitialize(context);
        }
        this.mSTBuilder = new InnerStat.Builder(context, BuildConfig.VERSION_NAME, FacebookSdk.getSdkVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithAccessToken(IMSDKListener<Map<String, String>> iMSDKListener, AccessToken accessToken) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("Access_Token", accessToken.getToken());
        sortableMap.put("iChannel", String.valueOf(1));
        iMSDKListener.onNotify(sortableMap);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        map.put("BindAccess_token", AccessToken.getCurrentAccessToken().getToken());
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.isExpired()) ? false : true;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, final Object... objArr) {
        if (IMSDKConfig.getOrMetaData(IMSDK_FACEBOOK_AUTO_LOGOUT, IMSDK_FACEBOOK_AUTO_LOGOUT, false)) {
            LoginManager.getInstance().logOut();
        }
        IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.facebook.FacebookLogin.1
            boolean bActivityCallbackFlag = false;

            /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0053  */
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onActivityCreate(android.os.Bundle r7, android.app.Activity r8) {
                /*
                    r6 = this;
                    r7 = 0
                    java.lang.Object[] r0 = r2     // Catch: java.lang.Exception -> L25
                    r1 = 0
                    r0 = r0[r1]     // Catch: java.lang.Exception -> L25
                    if (r0 == 0) goto L3e
                    java.lang.Object[] r0 = r2     // Catch: java.lang.Exception -> L25
                    r0 = r0[r1]     // Catch: java.lang.Exception -> L25
                    boolean r0 = r0 instanceof java.util.List     // Catch: java.lang.Exception -> L25
                    if (r0 == 0) goto L3e
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L25
                    r0.<init>()     // Catch: java.lang.Exception -> L25
                    java.lang.Object[] r7 = r2     // Catch: java.lang.Exception -> L20
                    r7 = r7[r1]     // Catch: java.lang.Exception -> L20
                    java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> L20
                    r0.addAll(r7)     // Catch: java.lang.Exception -> L20
                    r7 = r0
                    goto L3e
                L20:
                    r7 = move-exception
                    r5 = r0
                    r0 = r7
                    r7 = r5
                    goto L26
                L25:
                    r0 = move-exception
                L26:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "unknown error "
                    r1.append(r2)
                    java.lang.String r0 = r0.getMessage()
                    r1.append(r0)
                    java.lang.String r0 = r1.toString()
                    com.tencent.imsdk.android.tools.log.IMLogger.d(r0)
                L3e:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "facebook permission list : "
                    r0.append(r1)
                    if (r7 == 0) goto L53
                    java.lang.Object[] r1 = r7.toArray()
                    java.lang.String r1 = java.util.Arrays.deepToString(r1)
                    goto L55
                L53:
                    java.lang.String r1 = "Empty"
                L55:
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.tencent.imsdk.android.tools.log.IMLogger.d(r0)
                    com.tencent.imsdk.android.login.facebook.FacebookLogin r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.this
                    com.tencent.imsdk.android.tools.InnerStat$Builder r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.access$000(r0)
                    if (r0 == 0) goto L96
                    com.tencent.imsdk.android.login.facebook.FacebookLogin r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.this
                    com.tencent.imsdk.android.tools.InnerStat$Builder r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.access$000(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "login facebook with permissions "
                    r1.append(r2)
                    if (r7 == 0) goto L82
                    java.lang.Object[] r2 = r7.toArray()
                    java.lang.String r2 = java.util.Arrays.deepToString(r2)
                    goto L84
                L82:
                    java.lang.String r2 = ""
                L84:
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    com.tencent.imsdk.android.tools.InnerStat$Builder r0 = r0.setMethod(r1)
                    com.tencent.imsdk.android.tools.InnerStat r0 = r0.create()
                    r0.reportEvent()
                L96:
                    com.tencent.imsdk.android.login.facebook.FacebookLogin r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.this
                    android.content.Context r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.access$100(r0)
                    com.tencent.imsdk.android.login.facebook.FacebookLogin r1 = com.tencent.imsdk.android.login.facebook.FacebookLogin.this
                    java.lang.String r1 = r1.getSqlChannelKey()
                    com.tencent.imsdk.android.base.IMSDKDB4Login.cleanSavedLoginData(r0, r1)
                    com.tencent.imsdk.android.login.facebook.FacebookLogin r0 = com.tencent.imsdk.android.login.facebook.FacebookLogin.this
                    com.facebook.CallbackManager r1 = com.facebook.CallbackManager.Factory.create()
                    com.tencent.imsdk.android.login.facebook.FacebookLogin.access$202(r0, r1)
                    com.facebook.login.LoginManager r0 = com.facebook.login.LoginManager.getInstance()
                    com.tencent.imsdk.android.login.facebook.FacebookLogin r1 = com.tencent.imsdk.android.login.facebook.FacebookLogin.this
                    com.facebook.CallbackManager r1 = com.tencent.imsdk.android.login.facebook.FacebookLogin.access$200(r1)
                    com.tencent.imsdk.android.login.facebook.FacebookLogin$1$1 r2 = new com.tencent.imsdk.android.login.facebook.FacebookLogin$1$1
                    r2.<init>()
                    r0.registerCallback(r1, r2)
                    com.facebook.login.LoginManager r0 = com.facebook.login.LoginManager.getInstance()     // Catch: java.lang.Exception -> Lc8
                    r0.logInWithPublishPermissions(r8, r7)     // Catch: java.lang.Exception -> Lc8
                    goto Leb
                Lc8:
                    com.facebook.login.LoginManager r0 = com.facebook.login.LoginManager.getInstance()     // Catch: java.lang.Exception -> Ld0
                    r0.logInWithReadPermissions(r8, r7)     // Catch: java.lang.Exception -> Ld0
                    goto Leb
                Ld0:
                    r7 = move-exception
                    com.tencent.imsdk.android.base.IMSDKListener r0 = r3
                    com.tencent.imsdk.android.api.login.IMSDKLoginResult r1 = new com.tencent.imsdk.android.api.login.IMSDKLoginResult
                    r2 = 9999(0x270f, float:1.4012E-41)
                    java.lang.String r3 = "facebook error occur"
                    r4 = 11
                    java.lang.String r7 = r7.getMessage()
                    r1.<init>(r2, r3, r4, r7)
                    r0.onResult(r1)
                    r7 = 1
                    r6.bActivityCallbackFlag = r7
                    r8.finish()
                Leb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.login.facebook.FacebookLogin.AnonymousClass1.onActivityCreate(android.os.Bundle, android.app.Activity):void");
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            public boolean onActivityResult(int i, int i2, Intent intent) {
                this.bActivityCallbackFlag = true;
                FacebookLogin.this.mCallbackManager.onActivityResult(i, i2, intent);
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            public void onActivityDestroy() {
                super.onActivityDestroy();
                if (this.bActivityCallbackFlag) {
                    return;
                }
                iMSDKListener.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out facebook callback"));
            }
        });
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null) {
            iMSDKLoginResult.channelToken = currentAccessToken.getToken();
            iMSDKLoginResult.channelTokenExpire = currentAccessToken.getExpires().getTime() / 1000;
            iMSDKLoginResult.channelUserId = currentAccessToken.getUserId();
            if (iMSDKLoginResult.channelPermissions == null) {
                iMSDKLoginResult.channelPermissions = new ArrayList();
            }
            iMSDKLoginResult.channelPermissions.addAll(currentAccessToken.getPermissions());
        }
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        LoginManager.getInstance().logOut();
        super.logout(iMSDKResultListener);
    }
}
