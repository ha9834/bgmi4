package com.tencent.imsdk.android.friend.system;

import android.content.Context;
import android.content.Intent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.InnerStat;

/* loaded from: classes.dex */
public class SystemFriend extends IntentFriend {
    private static final String CHANNEL = "System";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return CHANNEL;
    }

    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    protected boolean isAppInstalled() {
        return true;
    }

    public SystemFriend(Context context) {
        super(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendTextIntent(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendTextIntent(iMSDKFriendReqInfo, new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.system.SystemFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                iMSDKListener.onNotify(Intent.createChooser(intent, iMSDKFriendReqInfo.title == null ? "" : iMSDKFriendReqInfo.title));
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        }, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendImageIntent(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendImageIntent(iMSDKFriendReqInfo, new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.system.SystemFriend.2
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                iMSDKListener.onNotify(Intent.createChooser(intent, iMSDKFriendReqInfo.title == null ? "" : iMSDKFriendReqInfo.title));
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        }, new Object[0]);
    }
}
