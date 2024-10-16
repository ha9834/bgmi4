package com.tencent.imsdk.android.friend.discord;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.HelpLogger;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class DiscordFriend extends IntentFriend {
    private static final String DISCORD_APP_PACKAGE = "com.discord";
    private static final String DISCORD_CHANNEL = "Discord";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return DISCORD_CHANNEL;
    }

    public DiscordFriend(Context context) {
        super(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    protected void sendIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (this.mCurCtx == null) {
            HelpLogger.activityIsNull(T.mGlobalActivityUpToDate);
            iMSDKResultListener.onResult(new IMSDKResult(17, 17));
            return;
        }
        if (iMSDKFriendReqInfo == null) {
            retByIMSDK(11, 11, "info is null", iMSDKResultListener);
            return;
        }
        if (iMSDKFriendReqInfo.type == 1) {
            try {
                if (T.ckIsEmpty(iMSDKFriendReqInfo.content)) {
                    retByIMSDK(11, 11, "content is empty", iMSDKResultListener);
                    return;
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setPackage(DISCORD_APP_PACKAGE);
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", iMSDKFriendReqInfo.content);
                intent.addFlags(DriveFile.MODE_READ_ONLY);
                this.mCurCtx.startActivity(intent);
                iMSDKResultListener.onResult(new IMSDKResult(1, 1));
                return;
            } catch (ActivityNotFoundException e) {
                IMLogger.w("catch ActivityNotFoundException : " + e.getMessage(), new Object[0]);
                retByIMSDK(15, 15, e.getMessage(), iMSDKResultListener);
                return;
            } catch (Exception e2) {
                IMLogger.w("catch exception : " + e2.getMessage(), new Object[0]);
                retByIMSDK(3, 3, e2.getMessage(), iMSDKResultListener);
                return;
            }
        }
        retByIMSDK(7, 7, "not support " + iMSDKFriendReqInfo.type, iMSDKResultListener);
    }
}
