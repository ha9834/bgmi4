package com.tencent.imsdk.android.login.discord;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.discord.connect.c;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.discord.DiscordActivity;
import com.tencent.imsdk.android.discord.DiscordConstants;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DiscordLogin extends IMSDKLoginBase {
    private Map<String, String> bindResult;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 39;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        return true;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        return iMSDKLoginResult;
    }

    public DiscordLogin(Context context) {
        super(context);
        c.a();
        this.mSTBuilder = new InnerStat.Builder(context, "2.0.1", "1.0.3");
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        if (this.mSTBuilder != null) {
            this.mSTBuilder.setMethod("login2Channel: discord").create().reportEvent();
        }
        IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new AnonymousClass1(iMSDKListener, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.imsdk.android.login.discord.DiscordLogin$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends IMSDKProxyActivity.LifeCycleCallback {
        private final int DISCORD_REQ = 4097;
        boolean bActivityCallbackFlag = false;
        final /* synthetic */ Object[] val$args;
        final /* synthetic */ IMSDKListener val$innerListener;

        @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
        protected boolean onActivityResult(int i, int i2, Intent intent) {
            return true;
        }

        AnonymousClass1(IMSDKListener iMSDKListener, Object[] objArr) {
            this.val$innerListener = iMSDKListener;
            this.val$args = objArr;
        }

        @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
        protected void onActivityCreate(Bundle bundle, Activity activity) {
            DiscordActivity.loginInnerListener = new IMSDKListener<Map<String, String>>() { // from class: com.tencent.imsdk.android.login.discord.DiscordLogin.1.1
                @Override // com.tencent.imsdk.android.base.IMSDKListener
                public void onNotify(Map<String, String> map) {
                    DiscordLogin.this.bindResult = map;
                    AnonymousClass1.this.val$innerListener.onNotify(map);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.bActivityCallbackFlag = true;
                    DiscordLogin.this.bindResult = null;
                }

                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    AnonymousClass1.this.val$innerListener.onResult(iMSDKResult);
                    AnonymousClass1.this.bActivityCallbackFlag = true;
                }
            };
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                if (this.val$args[0] != null && (this.val$args[0] instanceof List)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    try {
                        arrayList2.addAll((List) this.val$args[0]);
                        arrayList = arrayList2;
                    } catch (Exception e) {
                        e = e;
                        arrayList = arrayList2;
                        IMLogger.d("unknown error " + e.getMessage());
                        Intent intent = new Intent(activity, (Class<?>) DiscordActivity.class);
                        intent.putExtra(DiscordConstants.IMSDK_DISCORD_INTENT_ACTION, DiscordConstants.IMSDK_DISCORD_INTENT_ACTION_LOGIN);
                        intent.putStringArrayListExtra(DiscordConstants.IMSDK_DISCORD_INTENT_PERMISSIONS, arrayList);
                        activity.startActivityForResult(intent, 4097);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            Intent intent2 = new Intent(activity, (Class<?>) DiscordActivity.class);
            intent2.putExtra(DiscordConstants.IMSDK_DISCORD_INTENT_ACTION, DiscordConstants.IMSDK_DISCORD_INTENT_ACTION_LOGIN);
            intent2.putStringArrayListExtra(DiscordConstants.IMSDK_DISCORD_INTENT_PERMISSIONS, arrayList);
            activity.startActivityForResult(intent2, 4097);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
        public void onActivityDestroy() {
            super.onActivityDestroy();
            if (this.bActivityCallbackFlag) {
                return;
            }
            this.val$innerListener.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out discord callback"));
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        Map<String, String> map2 = this.bindResult;
        if (map2 != null) {
            map.put("access_token", map2.get("access_token"));
            map.put("refresh_token", this.bindResult.get("refresh_token"));
            map.put("token_type", this.bindResult.get("token_type"));
            map.put("expire_in", this.bindResult.get("expire_in"));
        }
    }
}
