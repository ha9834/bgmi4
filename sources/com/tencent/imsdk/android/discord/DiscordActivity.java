package com.tencent.imsdk.android.discord;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.discord.connect.auth.Scope;
import com.discord.connect.auth.a;
import com.discord.connect.b;
import com.discord.connect.d;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.drive.DriveFile;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.login.discord.AccountManager;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class DiscordActivity extends Activity {
    public static IMSDKListener<Map<String, String>> loginInnerListener;
    private boolean isPaused = false;
    private boolean isBackInNewIntent = false;

    private void discordLogin(ArrayList<String> arrayList) {
        IMLogger.d("discordLogin with permissions : " + arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Scope.valueOf(it.next()));
        }
        d.a aVar = new d.a(AccountManager.createOAuth2ClientExchangeRequest(arrayList2));
        AccountManager.discordLoginSessionStart(null, aVar);
        aVar.a(this);
    }

    private void discordCallback(Uri uri, final IMSDKListener<Map<String, String>> iMSDKListener) {
        IMLogger.d("discordCallback with uri : " + uri.toString());
        if (AccountManager.discordLoginSession != null) {
            AccountManager.discordLoginSession.close();
        }
        d.a.AbstractC0081a abstractC0081a = new d.a.AbstractC0081a() { // from class: com.tencent.imsdk.android.discord.DiscordActivity.1
            public void onError(int i, String str) {
                AccountManager.discordLoginSessionInvalidate();
                IMLogger.e("Discord DeeplinkHandler" + String.format("Error[%s] exchanging auth: %s", Integer.valueOf(i), str), new Object[0]);
                IMSDKListener iMSDKListener2 = iMSDKListener;
                if (iMSDKListener2 != null) {
                    iMSDKListener2.onResult(new IMSDKLoginResult(9999, "discord exchange auth error occur", i, str));
                }
                DiscordActivity.this.finish();
            }

            @Override // com.discord.connect.d.a.AbstractC0081a
            public void onTokenGrant(a aVar) {
                AccountManager.discordLoginSessionInvalidate();
                IMLogger.d("Discord DeeplinkHandler Got authorization");
                new b(DiscordActivity.this, DiscordConstants.DISCORD_DB_NAME).a(aVar);
                Map<String, String> sortableMap = T.getSortableMap();
                sortableMap.put("access_token", aVar.a());
                sortableMap.put("refresh_token", aVar.e());
                sortableMap.put("token_type", aVar.c());
                sortableMap.put("expire_in", String.valueOf(aVar.d()));
                sortableMap.put("iChannel", String.valueOf(39));
                iMSDKListener.onNotify(sortableMap);
                DiscordActivity.this.finish();
            }
        };
        if (uri.getQueryParameter("error") != null) {
            if (uri.getQueryParameter("error").equalsIgnoreCase("access_denied")) {
                if (iMSDKListener != null) {
                    iMSDKListener.onResult(new IMSDKResult(2, -1, uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION)));
                }
            } else if (iMSDKListener != null) {
                iMSDKListener.onResult(new IMSDKResult(9999, -1, uri.getQueryParameter("error") + CertificateUtil.DELIMITER + uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION)));
            }
            finish();
            return;
        }
        d.a aVar = AccountManager.discordLoginSessionClientExchange;
        if (aVar == null) {
            IMLogger.e("discord login session is invalid", new Object[0]);
            if (iMSDKListener != null) {
                iMSDKListener.onResult(new IMSDKLoginResult(9999, "discord exchange session is invalid", -1, ""));
            }
            finish();
            return;
        }
        aVar.a(uri, abstractC0081a);
    }

    private void processIntent(Intent intent) {
        IMSDKListener<Map<String, String>> iMSDKListener;
        if (intent == null) {
            finish();
            return;
        }
        IMLogger.d("processIntent data : " + intent.getData());
        Uri data = intent.getData();
        if (data != null) {
            String orMetaData = IMSDKConfig.getOrMetaData(DiscordConstants.IMSDK_DISCORD_SCHEME_PATH, DiscordConstants.IMSDK_DISCORD_SCHEME_PATH, "");
            if (data.getPath() != null && data.getPath().equals(orMetaData) && (iMSDKListener = loginInnerListener) != null) {
                discordCallback(data, iMSDKListener);
                return;
            }
        }
        String stringExtra = intent.getStringExtra(DiscordConstants.IMSDK_DISCORD_INTENT_ACTION);
        if (stringExtra != null && stringExtra.equalsIgnoreCase(DiscordConstants.IMSDK_DISCORD_INTENT_ACTION_LOGIN)) {
            discordLogin(intent.getStringArrayListExtra(DiscordConstants.IMSDK_DISCORD_INTENT_PERMISSIONS));
        } else {
            jumpMainActivity(data);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        processIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.isBackInNewIntent = true;
        processIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.isPaused || this.isBackInNewIntent) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        loginInnerListener = null;
        this.isPaused = false;
        this.isBackInNewIntent = false;
    }

    private void jumpMainActivity(Uri uri) {
        StringBuilder sb = new StringBuilder();
        sb.append("jumpMainActivity with data : ");
        sb.append(uri == null ? "" : uri.toString());
        IMLogger.d(sb.toString());
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        launchIntentForPackage.setFlags(DriveFile.MODE_READ_ONLY);
        launchIntentForPackage.setData(uri);
        startActivity(launchIntentForPackage);
        finish();
    }
}
