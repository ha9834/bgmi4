package com.tencent.imsdk.android.login.line;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.Scopes;
import com.linecorp.linesdk.LineAccessToken;
import com.linecorp.linesdk.LineApiResponseCode;
import com.linecorp.linesdk.LineCredential;
import com.linecorp.linesdk.Scope;
import com.linecorp.linesdk.api.LineApiClient;
import com.linecorp.linesdk.api.LineApiClientBuilder;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.auth.LineLoginApi;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.tencent.imsdk.android.IR;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LineLogin extends IMSDKLoginBase {
    private final String CHANNEL;
    private final int CHANNEL_ID;
    private final String IMSDK_LINE_CHANEL;
    private LineApiClient mLineApiClient;
    private String mLineChannel;
    private LineLoginResult mLineLoginResult;
    private List<String> mLinePermissionList;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 36;
    }

    public LineLogin(Context context) {
        super(context);
        this.CHANNEL_ID = 36;
        this.CHANNEL = "Line";
        this.mLinePermissionList = new ArrayList();
        this.IMSDK_LINE_CHANEL = "IMSDK_LINE_CHANEL";
        this.mLineChannel = "";
        this.mSTBuilder = new InnerStat.Builder(context, "2.6.1", "5.4.0");
        this.mLineChannel = IMSDKConfig.getOrMetaData("IMSDK_LINE_CHANEL", "IMSDK_LINE_CHANEL", "");
        if (T.ckIsEmpty(this.mLineChannel)) {
            IMLogger.e("IMSDK_LINE_CHANEL is empty, add meta config in your AndroidManifest.xml", new Object[0]);
        }
        try {
            this.mLineApiClient = new LineApiClientBuilder(this.mCurCtx, this.mLineChannel).build();
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        LineAccessToken lineAccessToken;
        try {
            if (this.mLineApiClient != null && this.mLineApiClient.getCurrentAccessToken() != null && this.mLineApiClient.getCurrentAccessToken().isSuccess() && (lineAccessToken = (LineAccessToken) this.mLineApiClient.getCurrentAccessToken().getResponseData()) != null) {
                if (lineAccessToken.getEstimatedExpirationTimeMillis() > System.currentTimeMillis()) {
                    return true;
                }
            }
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithLineLoginResult(IMSDKListener<Map<String, String>> iMSDKListener, LineLoginResult lineLoginResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("iChannel", String.valueOf(36));
        try {
            if (lineLoginResult.getLineCredential() != null) {
                if (lineLoginResult.getLineCredential().getAccessToken() != null) {
                    String tokenString = lineLoginResult.getLineCredential().getAccessToken().getTokenString();
                    if (!T.ckIsEmpty(tokenString)) {
                        this.mLineLoginResult = lineLoginResult;
                        hashMap.put(SDKConstants.PARAM_ACCESS_TOKEN, tokenString);
                        iMSDKListener.onNotify(hashMap);
                    } else {
                        iMSDKListener.onResult(new IMSDKLoginResult(9999, -1, "line access token is empty"));
                    }
                } else {
                    iMSDKListener.onResult(new IMSDKLoginResult(9999, -1, "line access token is null"));
                }
            } else {
                iMSDKListener.onResult(new IMSDKLoginResult(9999, -1, "line credential is null"));
            }
        } catch (Exception e) {
            iMSDKListener.onResult(new IMSDKLoginResult(3, -1, e.getMessage()));
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        final List<Scope> fillLoginPermissions = fillLoginPermissions(objArr);
        IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.line.LineLogin.1
            private final int LOGIN_REQUEST_CODE = 1;
            boolean bActivityCallbackFlag = false;

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle, Activity activity) {
                try {
                    activity.startActivityForResult(LineLoginApi.getLoginIntent(activity, LineLogin.this.mLineChannel, new LineAuthenticationParams.Builder().scopes(fillLoginPermissions).build()), 1);
                } catch (Exception e) {
                    this.bActivityCallbackFlag = true;
                    iMSDKListener.onResult(new IMSDKLoginResult(3, -1, e.getMessage()));
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i, int i2, Intent intent) {
                if (i == 1) {
                    try {
                        LineLoginResult loginResultFromIntent = LineLoginApi.getLoginResultFromIntent(intent);
                        if (loginResultFromIntent != null) {
                            switch (AnonymousClass3.$SwitchMap$com$linecorp$linesdk$LineApiResponseCode[loginResultFromIntent.getResponseCode().ordinal()]) {
                                case 1:
                                    LineLogin.this.fillParamsWithLineLoginResult(iMSDKListener, loginResultFromIntent);
                                    break;
                                case 2:
                                    iMSDKListener.onResult(new IMSDKLoginResult(2, -1));
                                    break;
                                case 3:
                                    iMSDKListener.onResult(new IMSDKLoginResult(2, -1, "line authentication agent error"));
                                    break;
                                case 4:
                                    iMSDKListener.onResult(new IMSDKLoginResult(4, -1, "line network error"));
                                    break;
                                case 5:
                                    iMSDKListener.onResult(new IMSDKLoginResult(9999, -1, "line internal error"));
                                    break;
                                default:
                                    iMSDKListener.onResult(new IMSDKLoginResult(9999, -1, "line unknown error" + loginResultFromIntent.getResponseCode()));
                                    break;
                            }
                        } else {
                            iMSDKListener.onResult(new IMSDKLoginResult(9999, -1, "line login result is empty"));
                        }
                    } catch (Exception e) {
                        iMSDKListener.onResult(new IMSDKLoginResult(3, -1, e.getMessage()));
                    }
                    this.bActivityCallbackFlag = true;
                }
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            public void onActivityDestroy() {
                super.onActivityDestroy();
                if (this.bActivityCallbackFlag) {
                    return;
                }
                iMSDKListener.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out line callback"));
            }
        });
    }

    /* renamed from: com.tencent.imsdk.android.login.line.LineLogin$3, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$linecorp$linesdk$LineApiResponseCode = new int[LineApiResponseCode.values().length];

        static {
            try {
                $SwitchMap$com$linecorp$linesdk$LineApiResponseCode[LineApiResponseCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$linecorp$linesdk$LineApiResponseCode[LineApiResponseCode.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$linecorp$linesdk$LineApiResponseCode[LineApiResponseCode.AUTHENTICATION_AGENT_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$linecorp$linesdk$LineApiResponseCode[LineApiResponseCode.SERVER_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$linecorp$linesdk$LineApiResponseCode[LineApiResponseCode.INTERNAL_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private List<Scope> fillLoginPermissions(Object... objArr) {
        try {
            this.mLinePermissionList.clear();
            if (objArr[0] != null && (objArr[0] instanceof List)) {
                this.mLinePermissionList = new ArrayList();
                this.mLinePermissionList.addAll((List) objArr[0]);
            }
        } catch (Exception e) {
            IMLogger.d("unknown error " + e.getMessage());
        }
        List<Scope> arrayList = new ArrayList<>();
        if (this.mLinePermissionList.size() == 0) {
            arrayList.add(Scope.PROFILE);
            arrayList.add(Scope.OPENID_CONNECT);
            this.mLinePermissionList.add(Scopes.PROFILE);
            this.mLinePermissionList.add("openid");
        } else {
            try {
                arrayList = Scope.convertToScopeList(this.mLinePermissionList);
            } catch (Exception e2) {
                IMLogger.e("catch exception : " + e2.getMessage(), new Object[0]);
            }
        }
        IMLogger.d("Line permissions :" + this.mLinePermissionList);
        return arrayList;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        LineCredential lineCredential;
        iMSDKLoginResult.channel = "Line";
        iMSDKLoginResult.channelId = 36;
        try {
            if (this.mLineLoginResult.getLineProfile() != null) {
                iMSDKLoginResult.channelUserId = this.mLineLoginResult.getLineProfile().getUserId();
            }
            if (this.mLineLoginResult != null && this.mLineLoginResult.getLineCredential() != null && (lineCredential = this.mLineLoginResult.getLineCredential()) != null) {
                iMSDKLoginResult.channelToken = lineCredential.getAccessToken().getTokenString();
                iMSDKLoginResult.channelTokenExpire = lineCredential.getAccessToken().getEstimatedExpirationTimeMillis() / 1000;
                iMSDKLoginResult.channelPermissions = this.mLinePermissionList;
            }
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        map.put(IR.account.ACCOUNT_BINDID, String.valueOf(36));
        try {
            LineCredential lineCredential = this.mLineLoginResult.getLineCredential();
            if (lineCredential != null) {
                map.put(SDKConstants.PARAM_ACCESS_TOKEN, lineCredential.getAccessToken().getTokenString());
            }
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        super.logout(iMSDKResultListener);
        if (this.mLineApiClient != null) {
            new Thread(new Runnable() { // from class: com.tencent.imsdk.android.login.line.LineLogin.2
                @Override // java.lang.Runnable
                public void run() {
                    LineLogin.this.mLineApiClient.logout();
                }
            }).start();
        }
    }
}
