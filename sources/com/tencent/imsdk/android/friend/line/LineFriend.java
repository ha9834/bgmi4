package com.tencent.imsdk.android.friend.line;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;

/* loaded from: classes.dex */
public class LineFriend extends IntentFriend {
    static String[] LINE_ACTIVITY_LIST = {"com.linecorp.line.share.common.view.FullPickerLaunchActivity", "jp.naver.line.android.activity.selectchat.SelectChatActivityLaunchActivity", "jp.naver.line.android.activity.selectchat.SelectChatActivity"};
    private static final String LINE_CHANNEL = "Line";
    private static final String LINE_PACKAGE_NAME = "jp.naver.line.android";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return LINE_CHANNEL;
    }

    public LineFriend(Context context) {
        super(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    protected boolean isAppInstalled() {
        return DeviceUtils.isAppInstalled(this.mCurCtx, LINE_PACKAGE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendTextIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendTextIntent(iMSDKFriendReqInfo, newListener(iMSDKListener), objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendImageIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        super.sendImageIntent(iMSDKFriendReqInfo, newListener(iMSDKListener), objArr);
    }

    private IMSDKListener<Intent> newListener(final IMSDKListener<Intent> iMSDKListener) {
        return new IMSDKListener<Intent>() { // from class: com.tencent.imsdk.android.friend.line.LineFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKListener
            public void onNotify(Intent intent) {
                for (String str : LineFriend.LINE_ACTIVITY_LIST) {
                    intent.setComponent(new ComponentName(LineFriend.LINE_PACKAGE_NAME, str));
                    if (LineFriend.this.checkLineActivityExist(intent)) {
                        iMSDKListener.onNotify(intent);
                        return;
                    }
                }
                iMSDKListener.onResult(new IMSDKResult(15, 15));
            }

            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                iMSDKListener.onResult(iMSDKResult);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkLineActivityExist(Intent intent) {
        return this.mCurCtx.getPackageManager().queryIntentActivities(intent, 0).size() != 0;
    }
}
