package com.tencent.imsdk.android.login.hms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class HMSLogin extends IMSDKLoginBase {
    private static final int HMS_CHANNEL_ID = 44;
    private static final String HMS_PACKAGE_NAME = "com.huawei.hwid";
    private static final String IMSDK_HMS_AUTH_REQ_PARAMS = "IMSDK_HMS_AUTH_REQ_PARAMS";
    private static final String IMSDK_HMS_QUICK_LOGIN_FIX = "IMSDK_HMS_QUICK_LOGIN_FIX";
    private HuaweiIdAuthService mAuthManager;
    private HuaweiIdAuthParams mAuthParam;
    private boolean mQuickLoginFlag;
    private InnerStat.Builder mSTBuilder;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 44;
    }

    public HMSLogin(Context context) {
        super(context);
        this.mQuickLoginFlag = false;
        initHMSAuth(context);
    }

    private void initHMSAuth(Context context) {
        IMLogger.d("Initialize HMS, load configuration from agconnect-services.json");
        if (this.mAuthManager == null) {
            this.mSTBuilder = new InnerStat.Builder(context, "2.0.0", String.valueOf(30000000));
            AGConnectServicesConfig.fromContext(context).overlayWith(new LazyInputStream(context) { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.1
                public InputStream get(Context context2) {
                    try {
                        InputStream open = context2.getAssets().open("agconnect-services.json");
                        if (open != null) {
                            IMLogger.d("success get config file");
                        } else {
                            IMLogger.d("cannot get config file");
                        }
                        return open;
                    } catch (IOException unused) {
                        IMLogger.e("cannot not read agconnect-services.json configuration, please make sure you put it into the assets folder", new Object[0]);
                        return null;
                    }
                }
            });
            HuaweiIdAuthParams huaweiIdAuthParams = HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM;
            if (IMSDKConfig.getOrMetaData(IMSDK_HMS_AUTH_REQ_PARAMS, IMSDK_HMS_AUTH_REQ_PARAMS, true)) {
                huaweiIdAuthParams = HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM_GAME;
            }
            this.mAuthParam = new HuaweiIdAuthParamsHelper(huaweiIdAuthParams).setIdToken().setAccessToken().setAuthorizationCode().setUid().setId().setIdToken().createParams();
            this.mAuthManager = HuaweiIdAuthManager.getService(this.mCurCtx, this.mAuthParam);
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void quickLogin(final IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        if (this.mAuthManager != null) {
            super.quickLogin(new IMSDKResultListener<IMSDKLoginResult>() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.2
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(final IMSDKLoginResult iMSDKLoginResult) {
                    Task silentSignIn = HMSLogin.this.mAuthManager.silentSignIn();
                    silentSignIn.addOnSuccessListener(new OnSuccessListener<AuthHuaweiId>() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.2.1
                        public void onSuccess(AuthHuaweiId authHuaweiId) {
                            if (IMSDKConfig.getOrMetaData(HMSLogin.IMSDK_HMS_QUICK_LOGIN_FIX, HMSLogin.IMSDK_HMS_QUICK_LOGIN_FIX, false)) {
                                HMSLogin.this.connectIMSDK(false, "user/login", HMSLogin.this.fillParamsWithAuthHuaweiId(authHuaweiId), iMSDKResultListener);
                            } else if (iMSDKLoginResult.imsdkRetCode == 1 && iMSDKLoginResult.channelUserId.equals(authHuaweiId.getOpenId())) {
                                IMLogger.d("same user, success");
                                iMSDKResultListener.onResult(iMSDKLoginResult);
                            } else {
                                iMSDKResultListener.onResult(iMSDKLoginResult);
                            }
                        }
                    });
                    silentSignIn.addOnFailureListener(new OnFailureListener() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.2.2
                        public void onFailure(Exception exc) {
                            if (exc instanceof ApiException) {
                                ApiException apiException = (ApiException) exc;
                                iMSDKResultListener.onResult(new IMSDKLoginResult(9999, apiException.getStatusCode(), apiException.getMessage()));
                            } else {
                                iMSDKResultListener.onResult(new IMSDKLoginResult(9999, -1, exc.getMessage()));
                            }
                        }
                    });
                    if (HMSLogin.this.mSTBuilder != null) {
                        HMSLogin.this.mSTBuilder.setMethod("quickLogin").create().reportEvent();
                    }
                }
            });
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        AuthHuaweiId authResult = HuaweiIdAuthManager.getAuthResult();
        return (this.mAuthManager == null || authResult == null || authResult.isExpired()) ? false : true;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        IMLogger.d("login2Channel HMS");
        if (!DeviceUtils.isAppInstalled(this.mCurCtx, HMS_PACKAGE_NAME)) {
            iMSDKListener.onResult(new IMSDKResult(15, 15, "need hms install"));
            IMLogger.d("need hms install");
            return;
        }
        HuaweiIdAuthService huaweiIdAuthService = this.mAuthManager;
        if (huaweiIdAuthService != null) {
            Task silentSignIn = huaweiIdAuthService.silentSignIn();
            silentSignIn.addOnSuccessListener(new OnSuccessListener<AuthHuaweiId>() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.3
                public void onSuccess(AuthHuaweiId authHuaweiId) {
                    iMSDKListener.onNotify(HMSLogin.this.fillParamsWithAuthHuaweiId(authHuaweiId));
                }
            });
            silentSignIn.addOnFailureListener(new OnFailureListener() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.4
                public void onFailure(Exception exc) {
                    IMSDKProxyActivity.registerLifeCycle(HMSLogin.this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.4.1
                        public static final int REQUEST_SIGN_IN_LOGIN = 1002;
                        public boolean alreadyCallBack = false;

                        @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                        protected void onActivityCreate(Bundle bundle, Activity activity) {
                            activity.startActivityForResult(HMSLogin.this.mAuthManager.getSignInIntent(), 1002);
                            this.alreadyCallBack = false;
                            if (HMSLogin.this.mSTBuilder != null) {
                                HMSLogin.this.mSTBuilder.setMethod("login2Channel").create().reportEvent();
                            }
                        }

                        @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                        protected boolean onActivityResult(int i, int i2, Intent intent) {
                            IMLogger.d("onActivityResult, requestCode=" + i + " resultCode=" + i2);
                            if (i == 1002) {
                                IMLogger.d("login with result code: " + i2 + " data: " + intent.toString());
                                Task parseAuthResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
                                if (parseAuthResultFromIntent.isSuccessful()) {
                                    iMSDKListener.onNotify(HMSLogin.this.fillParamsWithAuthHuaweiId((AuthHuaweiId) parseAuthResultFromIntent.getResult()));
                                } else {
                                    try {
                                        ApiException exception = parseAuthResultFromIntent.getException();
                                        if (exception.getStatusCode() == 2012) {
                                            iMSDKListener.onResult(new IMSDKResult(2, exception.getStatusCode(), exception.getMessage()));
                                        } else {
                                            iMSDKListener.onResult(new IMSDKResult(9999, exception.getStatusCode(), exception.getMessage()));
                                        }
                                        IMLogger.d("sign in failed : " + exception.getStatusCode() + ", " + exception.getMessage());
                                    } catch (Exception e) {
                                        iMSDKListener.onResult(new IMSDKResult(3, -1, e.getMessage()));
                                        IMLogger.d("sign in failed : " + e.getMessage());
                                    }
                                }
                                this.alreadyCallBack = true;
                            }
                            return true;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                        public void onActivityDestroy() {
                            if (iMSDKListener == null || this.alreadyCallBack) {
                                return;
                            }
                            iMSDKListener.onResult(new IMSDKResult(2, 2));
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> fillParamsWithAuthHuaweiId(AuthHuaweiId authHuaweiId) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("iChannel", String.valueOf(44));
        sortableMap.put("sCode", authHuaweiId.getAuthorizationCode());
        sortableMap.put("sUnionId", authHuaweiId.getUnionId());
        sortableMap.put("sOpenId", authHuaweiId.getOpenId());
        return sortableMap;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        iMSDKLoginResult.channel = getChannel();
        iMSDKLoginResult.channelId = getChannelId();
        AuthHuaweiId authResult = HuaweiIdAuthManager.getAuthResult();
        if (authResult != null) {
            iMSDKLoginResult.channelToken = authResult.getAccessToken();
            iMSDKLoginResult.channelTokenExpire = authResult.getExpirationTimeSecs();
            if (iMSDKLoginResult.channelPermissions == null) {
                iMSDKLoginResult.channelPermissions = new ArrayList();
            }
            Set authorizedScopes = authResult.getAuthorizedScopes();
            if (authorizedScopes != null) {
                Iterator it = authorizedScopes.iterator();
                while (it.hasNext()) {
                    iMSDKLoginResult.channelPermissions.add(((Scope) it.next()).getScopeUri());
                }
            }
        }
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        map.put("sCode", HuaweiIdAuthManager.getAuthResult().getAuthorizationCode());
        map.put("sUnionId", HuaweiIdAuthManager.getAuthResult().getUnionId());
        map.put("sOpenId", HuaweiIdAuthManager.getAuthResult().getOpenId());
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(final IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        HuaweiIdAuthService huaweiIdAuthService = this.mAuthManager;
        if (huaweiIdAuthService != null) {
            huaweiIdAuthService.signOut().addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.6
                public void onSuccess(Void r5) {
                    iMSDKResultListener.onResult(new IMSDKResult(1, 0, ""));
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.tencent.imsdk.android.login.hms.HMSLogin.5
                public void onFailure(Exception exc) {
                    iMSDKResultListener.onResult(new IMSDKResult(9999, -1, exc.getMessage()));
                }
            });
            InnerStat.Builder builder = this.mSTBuilder;
            if (builder != null) {
                builder.setMethod("logout").create().reportEvent();
            }
        }
        super.logout(iMSDKResultListener);
    }
}
