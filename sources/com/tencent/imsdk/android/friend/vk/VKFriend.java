package com.tencent.imsdk.android.friend.vk;

import android.content.Context;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.vk.api.sdk.b;

/* loaded from: classes.dex */
public class VKFriend extends VKIntentBase {
    private static final String VK_CHANNEL = "VK";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return "VK";
    }

    public VKFriend(Context context) {
        super(context);
        initVKSdk(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.10.1");
        }
    }

    public static void initVKSdk(Context context) {
        if (b.b(context) <= 0) {
            IMLogger.e("please config com_vk_sdk_AppId in resource file !", new Object[0]);
        } else {
            b.a(context);
        }
    }
}
