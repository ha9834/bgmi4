package com.tencent.imsdk.android.friend.whatsapp;

import android.content.Context;
import android.content.Intent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;

/* loaded from: classes.dex */
public class WhatsAppFriend extends IntentFriend {
    private static final String CHANNEL = "WhatsApp";
    private static final String PACKAGE = "com.whatsapp";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return CHANNEL;
    }

    public WhatsAppFriend(Context context) {
        super(context);
        if (context != null) {
            this.mSTBuilder = new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    protected boolean isAppInstalled() {
        return DeviceUtils.isAppInstalled(this.mCurCtx, PACKAGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendTextIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendTextIntent(iMSDKFriendReqInfo, new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.whatsapp.WhatsAppFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                if (intent != null) {
                    intent.setPackage(WhatsAppFriend.PACKAGE);
                }
                iMSDKListener.onNotify(intent);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        }, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendImageIntent(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendImageIntent(iMSDKFriendReqInfo, new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.whatsapp.WhatsAppFriend.2
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                if (intent != null) {
                    intent.setPackage(WhatsAppFriend.PACKAGE);
                    if (!T.ckIsEmpty(iMSDKFriendReqInfo.content)) {
                        intent.putExtra("android.intent.extra.TEXT", iMSDKFriendReqInfo.content);
                    }
                }
                iMSDKListener.onNotify(intent);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        }, objArr);
    }
}
