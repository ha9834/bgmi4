package com.tencent.imsdk.android.friend.instagram;

import android.content.Context;
import android.content.Intent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;

/* loaded from: classes.dex */
public class InstagramFriend extends IntentFriend {
    private static final String INSTAGRAM_CHANNEL = "Instagram";
    private static final String INSTAGRAM_PACKAGE_NAME = "com.instagram.android";
    private static final int InstagramFRIEND_INTENT = 0;

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return INSTAGRAM_CHANNEL;
    }

    public InstagramFriend(Context context) {
        super(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    protected boolean isAppInstalled() {
        return DeviceUtils.isAppInstalled(this.mCurCtx, INSTAGRAM_PACKAGE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendTextIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendTextIntent(iMSDKFriendReqInfo, new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.instagram.InstagramFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                intent.setPackage(InstagramFriend.INSTAGRAM_PACKAGE_NAME);
                iMSDKListener.onNotify(intent);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        }, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendImageIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendImageIntent(iMSDKFriendReqInfo, new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.instagram.InstagramFriend.2
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                intent.setPackage(InstagramFriend.INSTAGRAM_PACKAGE_NAME);
                iMSDKListener.onNotify(intent);
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        }, new Object[0]);
    }
}
