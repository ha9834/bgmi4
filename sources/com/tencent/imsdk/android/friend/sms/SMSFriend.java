package com.tencent.imsdk.android.friend.sms;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.gms.drive.DriveFile;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.friend.intent.IntentFriend;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class SMSFriend extends IntentFriend {
    private static final String BODY_KEY = "sms_body";
    private static final String CHANNEL = "SMS";
    private static final String SMS_URI = "smsto:";

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return CHANNEL;
    }

    public SMSFriend(Context context) {
        super(context);
        if (context != null) {
            new InnerStat.Builder(context.getApplicationContext(), "2.5.1");
        }
    }

    @Override // com.tencent.imsdk.android.friend.intent.IntentFriend
    public void sendIntent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (this.mCurCtx == null) {
            retByIMSDK(17, 17, "context is null", iMSDKResultListener);
            return;
        }
        if (iMSDKFriendReqInfo == null) {
            IMLogger.w("info is null", new Object[0]);
            retByIMSDK(11, 11, "info is null", iMSDKResultListener);
            return;
        }
        IMLogger.d("sendMessage " + iMSDKFriendReqInfo.content);
        if (iMSDKFriendReqInfo.type == 1) {
            try {
                if (T.ckIsEmpty(iMSDKFriendReqInfo.content)) {
                    IMLogger.w("content is empty", new Object[0]);
                    retByIMSDK(1, 1, "content is empty", iMSDKResultListener);
                } else {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(SMS_URI));
                    intent.putExtra(BODY_KEY, iMSDKFriendReqInfo.content);
                    PackageManager packageManager = this.mCurCtx.getPackageManager();
                    if (packageManager != null && intent.resolveActivity(packageManager) != null) {
                        intent.addFlags(DriveFile.MODE_READ_ONLY);
                        this.mCurCtx.startActivity(intent);
                        retByIMSDK(1, 1, "start activity success", iMSDKResultListener);
                    } else {
                        retByIMSDK(1, 1, "need sms app", iMSDKResultListener);
                    }
                }
                return;
            } catch (Exception e) {
                IMLogger.w("catch exception : " + e.getMessage(), new Object[0]);
                retByIMSDK(3, 3, e.getMessage(), iMSDKResultListener);
                return;
            }
        }
        IMLogger.w("incorrect type of : " + iMSDKFriendReqInfo.type, new Object[0]);
        retByIMSDK(7, 7, "unsupported type " + iMSDKFriendReqInfo.type, iMSDKResultListener);
    }
}
