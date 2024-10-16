package com.tencent.imsdk.android.friend.email;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.InnerStat;

/* loaded from: classes.dex */
public class EmailFriend extends IntentFriend {
    private static final String EMAIL_CHANNEL = "Email";
    private static final String EMAIL_URI = "mailto:";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return "Email";
    }

    public EmailFriend(Context context) {
        super(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendTextIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKListener<Intent> iMSDKListener, Object... objArr) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.SUBJECT", iMSDKFriendReqInfo.title);
        intent.putExtra("android.intent.extra.TEXT", iMSDKFriendReqInfo.content);
        iMSDKListener.onNotify(intent);
    }
}
