package com.tencent.imsdk.android.login.vk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.vk.IMSDKVKHelper;
import com.vk.api.sdk.auth.VKScope;
import com.vk.api.sdk.auth.a;
import com.vk.api.sdk.b;
import com.vk.api.sdk.exceptions.VKAuthException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class VKLogin extends IMSDKLoginBase {
    private final List<String> mPermissionsList;
    private a mVKAccessToken;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public String getChannel() {
        return IMSDKVKHelper.CHANNEL;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 14;
    }

    public VKLogin(Context context) {
        super(context);
        this.mPermissionsList = new ArrayList();
        IMLogger.d("VKLogin init");
        IMSDKVKHelper.initVKSdk(context);
        this.mSTBuilder = new InnerStat.Builder(context, "2.10.1", b.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithAccessToken(IMSDKListener<Map<String, String>> iMSDKListener, a aVar) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("access_token", aVar.b());
        sortableMap.put("iChannel", String.valueOf(14));
        iMSDKListener.onNotify(sortableMap);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        a aVar = this.mVKAccessToken;
        if (aVar == null) {
            IMLogger.w("vk not login!", new Object[0]);
        } else {
            map.put("BindAccess_token", aVar.b());
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return b.c();
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        this.mVKAccessToken = null;
        fillPermissionsList(objArr.length > 0 ? objArr[0] : null);
        final String[] fillPermissionsArray = fillPermissionsArray();
        IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.vk.VKLogin.1
            boolean bActivityCallbackFlag = false;

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle, Activity activity) {
                IMSDKDB4Login.cleanSavedLoginData(VKLogin.this.mCurCtx, VKLogin.this.getSqlChannelKey());
                ArrayList arrayList = new ArrayList();
                for (String str2 : fillPermissionsArray) {
                    arrayList.add(VKScope.valueOf(str2));
                }
                b.a(activity, arrayList);
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i, int i2, Intent intent) {
                this.bActivityCallbackFlag = true;
                b.a(i, i2, intent, new com.vk.api.sdk.auth.b() { // from class: com.tencent.imsdk.android.login.vk.VKLogin.1.1
                    @Override // com.vk.api.sdk.auth.b
                    public void onLogin(a aVar) {
                        VKLogin.this.mVKAccessToken = aVar;
                        VKLogin.this.fillParamsWithAccessToken(iMSDKListener, aVar);
                    }

                    @Override // com.vk.api.sdk.auth.b
                    public void onLoginFailed(VKAuthException vKAuthException) {
                        iMSDKListener.onResult(VKLogin.this.makeThirdError(vKAuthException));
                    }
                });
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            public void onActivityDestroy() {
                super.onActivityDestroy();
                if (this.bActivityCallbackFlag) {
                    return;
                }
                iMSDKListener.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out vk callback"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IMSDKResult makeThirdError(VKAuthException vKAuthException) {
        if (vKAuthException != null) {
            if (vKAuthException.c()) {
                return new IMSDKLoginResult(2, -1);
            }
            return new IMSDKLoginResult(9999, "vk error occur", vKAuthException.a(), vKAuthException.b());
        }
        return new IMSDKLoginResult(9999, "vk error occur", -1, "VKError return null");
    }

    private String[] fillPermissionsArray() {
        if (this.mPermissionsList.size() <= 0) {
            return null;
        }
        String[] strArr = new String[this.mPermissionsList.size()];
        this.mPermissionsList.toArray(strArr);
        return strArr;
    }

    private void fillPermissionsList(Object obj) {
        this.mPermissionsList.clear();
        if (obj != null) {
            try {
                if (obj instanceof List) {
                    this.mPermissionsList.addAll((List) obj);
                }
            } catch (Exception e) {
                IMLogger.d("unknown error " + e.getMessage());
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("facebook permission list : ");
        sb.append(this.mPermissionsList.size() != 0 ? Arrays.deepToString(this.mPermissionsList.toArray()) : "Empty");
        IMLogger.d(sb.toString());
        if (this.mPermissionsList.contains(VKScope.OFFLINE.name())) {
            return;
        }
        IMLogger.i("add missing permission:" + VKScope.OFFLINE, new Object[0]);
        this.mPermissionsList.add(VKScope.OFFLINE.name());
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        a aVar = this.mVKAccessToken;
        if (aVar != null) {
            iMSDKLoginResult.channelToken = aVar.b();
            iMSDKLoginResult.channelTokenExpire = 2147483647L;
            iMSDKLoginResult.channelUserId = String.valueOf(this.mVKAccessToken.a());
            if (iMSDKLoginResult.channelPermissions == null) {
                iMSDKLoginResult.channelPermissions = new ArrayList();
            }
            iMSDKLoginResult.channelPermissions.addAll(this.mPermissionsList);
        }
        return iMSDKLoginResult;
    }

    private boolean isChannelInstalled() {
        return IMSDKVKHelper.isVKInstalled(this.mCurCtx);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        super.logout(iMSDKResultListener);
        b.b();
    }

    private static Integer getIntResByName(Context context, String str) {
        try {
            return Integer.valueOf(context.getResources().getInteger(context.getResources().getIdentifier(str, "integer", context.getPackageName())));
        } catch (Exception unused) {
            return 0;
        }
    }
}
