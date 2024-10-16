package com.tencent.imsdk.android.base.push;

import android.content.Context;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.push.IMSDKLocalMessage;
import com.tencent.imsdk.android.api.push.IMSDKPushResult;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.List;

/* loaded from: classes.dex */
public abstract class IMSDKPushBase {
    protected Context mCtx;

    public abstract void registerPush(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener);

    public abstract void unregisterPush(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener);

    private void notSupportWarning(IMSDKResultListener<? super IMSDKPushResult> iMSDKResultListener) {
        IMLogger.d("not support yet");
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(new IMSDKPushResult(7));
        }
    }

    public IMSDKPushBase(Context context) {
        if (this.mCtx == null) {
            this.mCtx = context;
        }
    }

    public void registerPush(String str, String str2, int i, String str3, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void setTags(List<String> list, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void replaceTags(List<String> list, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void deleteTags(List<String> list, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void cleanTags(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void addLocalNotification(IMSDKLocalMessage iMSDKLocalMessage, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void clearLocalNotifications(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }

    public void setNotificationListener(IMSDKResultListener<IMSDKPushResult> iMSDKResultListener) {
        notSupportWarning(iMSDKResultListener);
    }
}
