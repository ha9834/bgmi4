package com.tencent.imsdk.android.api.relation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.common.IMSDKLaunchResult;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.interfaces.IAppAvailable;
import com.tencent.imsdk.android.base.interfaces.ILauncher;
import com.tencent.imsdk.android.base.relation.IMSDKFriendBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKFriend {
    private static final int BASE_RESULT = 0;
    private static final int FRIENDS_DEFAULT = 0;
    private static final int FRIENDS_INVITE = 1;
    private static final int FRIENDS_RESULT = 1;
    private static final int LAUNCH_RESULT = 2;
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKFriendBase mFriendImpl;

    private static boolean isInit(int i, IMSDKResultListener iMSDKResultListener) {
        JsonSerializable iMSDKFriendListResult;
        if (mFriendImpl == null) {
            T.HelperLog.channelInstanceIsNull();
            int i2 = 18;
            int i3 = 11;
            if (mCurCtx == null) {
                i2 = 17;
                i3 = 17;
            } else if (mCurChannel == null) {
                i3 = 18;
            } else {
                i2 = 11;
            }
            if (iMSDKResultListener != null) {
                switch (i) {
                    case 1:
                        iMSDKFriendListResult = new IMSDKFriendListResult(i2, i3);
                        break;
                    case 2:
                        iMSDKFriendListResult = new IMSDKLaunchResult(i2, i3);
                        break;
                    default:
                        iMSDKFriendListResult = new IMSDKResult(i2, i3);
                        break;
                }
                iMSDKResultListener.onResult(iMSDKFriendListResult);
            }
        }
        return mFriendImpl != null;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(activity, "2.10.1", IR.MODULE_FRIEND, "Init<IMSDKFriend>");
        }
        return mCurCtx != null;
    }

    private static IMSDKFriendBase getInstance(String str) {
        String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_FRIEND_FORMAT, str.toLowerCase(Locale.US), str);
        IMSDKFriendBase iMSDKFriendBase = (IMSDKFriendBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKFriendBase.class, format);
        if (iMSDKFriendBase == null) {
            T.HelperLog.channelSetFailed(str, format);
        }
        return iMSDKFriendBase;
    }

    public static boolean setChannel(String str) {
        if (mCurCtx == null) {
            T.HelperLog.contextIsNull();
            return false;
        }
        if (str.length() <= 0) {
            T.HelperLog.channelIsNullOrEmpty();
            return false;
        }
        if ((str.length() > 0 && !str.equals(mCurChannel)) || mFriendImpl == null) {
            mFriendImpl = null;
            mFriendImpl = getInstance(str);
            if (mFriendImpl != null) {
                mCurChannel = str;
                InnerStat.Builder builder = mAPIStatBuilder;
                if (builder != null) {
                    builder.setChannel(mCurChannel);
                }
            } else {
                IMLogger.e("get channel instance of " + str + " fail when setChannel()", new Object[0]);
            }
        }
        InnerStat.Builder builder2 = mAPIStatBuilder;
        if (builder2 != null) {
            builder2.setChannel(mCurChannel);
        }
        return mFriendImpl != null;
    }

    public static String getChannel() {
        return mCurChannel;
    }

    public static void invite(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(0, iMSDKResultListener)) {
            mFriendImpl.invite(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
        }
    }

    public static void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(0, iMSDKResultListener)) {
            mFriendImpl.share(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
        }
    }

    public static void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(0, iMSDKResultListener)) {
            mFriendImpl.sendMessage(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
        }
    }

    public static boolean isChannelInstalled() {
        Object obj = mFriendImpl;
        return obj != null && (obj instanceof IAppAvailable) && ((IAppAvailable) obj).isApplicationInstalled();
    }

    public static void getFriendList(String str, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener)) {
            mFriendImpl.getFriendList(str, iMSDKResultListener);
        }
    }

    public static void getFriendList(final String str, final int i, final int i2, int i3, String str2, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        final IMSDKResultListener<IMSDKFriendListResult> proxyListener4EventReport = mAPIStatBuilder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        if (isInit(1, proxyListener4EventReport)) {
            if (!T.ckIsEmpty(str) && !str.equalsIgnoreCase(mCurChannel)) {
                getFriendList(str, new IMSDKResultListener<IMSDKFriendListResult>() { // from class: com.tencent.imsdk.android.api.relation.IMSDKFriend.1
                    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                    public void onResult(IMSDKFriendListResult iMSDKFriendListResult) {
                        if (iMSDKFriendListResult.imsdkRetCode == 7) {
                            IMSDKFriend.mFriendImpl.getFriendList(str, i, i2, proxyListener4EventReport);
                        } else {
                            proxyListener4EventReport.onResult(iMSDKFriendListResult);
                        }
                    }
                });
            } else if (i3 != 1) {
                mFriendImpl.getFriends(i, i2, proxyListener4EventReport);
            } else {
                mFriendImpl.getInviteFriends(i, i2, str2, proxyListener4EventReport);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:10:0x006a). Please report as a decompilation issue!!! */
    public static void handleLaunchData(String str, Intent intent, IMSDKResultListener<IMSDKLaunchResult> iMSDKResultListener) {
        if (!T.ckNonEmpty(str)) {
            InnerStat.Builder builder = mAPIStatBuilder;
            if (builder != null) {
                iMSDKResultListener = builder.create().proxyListener4EventReport(str, iMSDKResultListener);
            }
            try {
                Object iMSDKFriend = getInstance(str);
                if (iMSDKFriend instanceof ILauncher) {
                    ((ILauncher) iMSDKFriend).handleLaunchData(intent, iMSDKResultListener);
                } else {
                    iMSDKResultListener.onResult(new IMSDKLaunchResult(7, 7));
                }
            } catch (Exception e) {
                IMLogger.w("get exception : " + e.getMessage(), new Object[0]);
                iMSDKResultListener.onResult(new IMSDKLaunchResult(3, 3, e.getMessage()));
            }
            return;
        }
        IMLogger.w("launch channel is empty", new Object[0]);
        iMSDKResultListener.onResult(new IMSDKLaunchResult(11, 11));
    }
}
