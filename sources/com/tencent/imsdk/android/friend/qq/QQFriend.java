package com.tencent.imsdk.android.friend.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.connect.common.Constants;
import com.tencent.imsdk.android.QQAgent;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.relation.IMSDKFriendBase;
import com.tencent.imsdk.android.qq.QQFileProvider;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class QQFriend extends IMSDKFriendBase {
    private static final int TYPE_PUBLISH_TO_QZONE = 3;
    private static final int TYPE_SHARE_TO_QQ = 1;
    private static final int TYPE_SHARE_TO_QZONE = 2;
    private QQShareListener mQQShareListener;
    private Tencent mTencent;

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return QQAgent.QQ_CHANNEL_ID;
    }

    public QQFriend(Context context) {
        super(context);
        this.mTencent = null;
        this.mQQShareListener = null;
        if (this.mTencent == null) {
            if (IMSDKConfig.getOrMetaData(QQAgent.IMSDK_QQ_SET_PERMISSION_GRANTED, QQAgent.IMSDK_QQ_SET_PERMISSION_GRANTED, true)) {
                Tencent.setIsPermissionGranted(true);
            }
            this.mTencent = Tencent.createInstance(QQAgent.getQQAppId(context), context.getApplicationContext(), QQFileProvider.getFileProviderAuthority(context));
            this.mSTBuilder = new InnerStat.Builder(context, "2.6.1", Constants.SDK_VERSION);
        }
    }

    private void reportEvent(String str, String str2, String str3) {
        if (this.mSTBuilder != null) {
            this.mSTBuilder.setMethod(str).setStage(str2).setResult(str3).create().reportEvent();
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void invite(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (iMSDKFriendReqInfo.type != 1 && iMSDKFriendReqInfo.type != 5 && iMSDKFriendReqInfo.type != 3) {
            iMSDKFriendReqInfo.type = 1;
        }
        handleQQMessage(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        handleQZoneMessage(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        handleQQMessage(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
    }

    private void handleQQMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        IMLogger.d("handleQQMessage info = " + iMSDKFriendReqInfo.toString());
        if (!QQAgent.isQQClientAvailable(this.mCurCtx)) {
            iMSDKResultListener.onResult(new IMSDKResult(7, 0, "need install QQ app when use QQFriend"));
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("title", iMSDKFriendReqInfo.title);
            bundle.putString("summary", iMSDKFriendReqInfo.content);
            int i = iMSDKFriendReqInfo.type;
            if (i == 1) {
                iMSDKResultListener.onResult(new IMSDKResult(7, 0, "QQ sendMessage only support text with link"));
                return;
            }
            int i2 = 5;
            if (i == 3) {
                bundle.putString("targetUrl", iMSDKFriendReqInfo.link);
                if (!T.ckIsEmpty(iMSDKFriendReqInfo.imagePath)) {
                    bundle.putString("imageUrl", iMSDKFriendReqInfo.imagePath);
                }
                i2 = 1;
            } else if (i == 5) {
                bundle.putString("imageLocalUrl", iMSDKFriendReqInfo.imagePath);
            } else {
                iMSDKResultListener.onResult(new IMSDKResult(7));
                return;
            }
            bundle.putInt("req_type", i2);
            sendMessageToQQ(1, bundle, iMSDKResultListener);
        } catch (Exception e) {
            IMLogger.d("unknown exception : " + e.getMessage());
            reportEvent("handleQQMessage", "exception happen, , info.type=" + iMSDKFriendReqInfo.type, e.getMessage());
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(11, -1, e.getMessage()));
            }
        }
    }

    private void handleQZoneMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        IMLogger.d("handleQZoneMessage info = " + iMSDKFriendReqInfo.toString());
        if (!QQAgent.isQQClientAvailable(this.mCurCtx)) {
            iMSDKResultListener.onResult(new IMSDKResult(7, 0, "need install QQ app when use QQFriend"));
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("title", iMSDKFriendReqInfo.title);
            bundle.putString("summary", iMSDKFriendReqInfo.content);
            ArrayList<String> arrayList = new ArrayList<>();
            int i = iMSDKFriendReqInfo.type;
            int i2 = 1;
            if (i == 1) {
                i2 = 3;
            } else if (i == 3) {
                bundle.putString("targetUrl", iMSDKFriendReqInfo.link);
                if (!T.ckIsEmpty(iMSDKFriendReqInfo.imagePath)) {
                    arrayList.add(iMSDKFriendReqInfo.imagePath);
                }
                bundle.putStringArrayList("imageUrl", arrayList);
            } else if (i == 5) {
                arrayList.clear();
                if (!T.ckIsEmpty(iMSDKFriendReqInfo.imagePath)) {
                    arrayList.add(iMSDKFriendReqInfo.imagePath);
                }
                bundle.putStringArrayList("imageUrl", arrayList);
                i2 = 3;
            } else {
                iMSDKResultListener.onResult(new IMSDKResult(7));
                return;
            }
            bundle.putInt("req_type", i2);
            if (i2 == 3) {
                sendMessageToQQ(3, bundle, iMSDKResultListener);
            } else {
                sendMessageToQQ(2, bundle, iMSDKResultListener);
            }
        } catch (Exception e) {
            IMLogger.d("unknown exception : " + e.getMessage());
            reportEvent("handleQZoneMessage", "exception happen, , info.type=" + iMSDKFriendReqInfo.type, e.getMessage());
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(11, -1, e.getMessage()));
            }
        }
    }

    private void sendMessageToQQ(final int i, final Bundle bundle, final IMSDKResultListener iMSDKResultListener) {
        IMLogger.d("sendType = " + i + ", paras = " + bundle.toString());
        IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.friend.qq.QQFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle2, Activity activity) {
                QQFriend.this.mQQShareListener = new QQShareListener(iMSDKResultListener, activity);
                switch (i) {
                    case 1:
                        QQFriend.this.mTencent.shareToQQ(activity, bundle, QQFriend.this.mQQShareListener);
                        return;
                    case 2:
                        QQFriend.this.mTencent.shareToQzone(activity, bundle, QQFriend.this.mQQShareListener);
                        return;
                    case 3:
                        QQFriend.this.mTencent.publishToQzone(activity, bundle, QQFriend.this.mQQShareListener);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i2, int i3, Intent intent) {
                IMLogger.d("onActivityResult, requestCode=" + i2 + " resultCode=" + i3);
                if (i2 != 10103 && i2 != 10104) {
                    return true;
                }
                Tencent.onActivityResultData(i2, i3, intent, QQFriend.this.mQQShareListener);
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            public void onActivityDestroy() {
                super.onActivityDestroy();
                IMLogger.d("onActivityDestroy");
            }
        });
    }

    /* loaded from: classes.dex */
    static class QQShareListener implements IUiListener {
        Activity imsdkActivity;
        IMSDKResultListener imsdkListener;

        public QQShareListener(IMSDKResultListener iMSDKResultListener, Activity activity) {
            this.imsdkListener = iMSDKResultListener;
            this.imsdkActivity = activity;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            IMLogger.d("onComplete, response = " + obj.toString());
            IMSDKResultListener iMSDKResultListener = this.imsdkListener;
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(1, 1, obj.toString()));
            }
            Activity activity = this.imsdkActivity;
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IMLogger.e("onError, code=" + uiError.errorCode + ", msg=" + uiError.errorMessage + ", detail=" + uiError.errorDetail, new Object[0]);
            IMSDKResultListener iMSDKResultListener = this.imsdkListener;
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(9999, "QQ Share error occur", uiError.errorCode, uiError.errorMessage));
            }
            Activity activity = this.imsdkActivity;
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IMLogger.w("onCancel", new Object[0]);
            IMSDKResultListener iMSDKResultListener = this.imsdkListener;
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(2, -1));
            }
            Activity activity = this.imsdkActivity;
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            IMLogger.e("get QQ onWarning : " + i, new Object[0]);
        }
    }
}
