package com.tencent.imsdk.android.api.notice;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.notice.IMSDKNoticeBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKNotice {
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKNoticeBase mNoticeImpl;

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        IMSDKNoticeResult iMSDKNoticeResult;
        if (mNoticeImpl == null) {
            T.HelperLog.channelInstanceIsNull();
            if (iMSDKResultListener != null) {
                if (mCurCtx == null) {
                    iMSDKNoticeResult = new IMSDKNoticeResult(17, -1);
                } else if (mCurChannel == null) {
                    iMSDKNoticeResult = new IMSDKNoticeResult(18, -1);
                } else {
                    iMSDKNoticeResult = new IMSDKNoticeResult(11, -1);
                }
                iMSDKResultListener.onResult(iMSDKNoticeResult);
            }
        }
        return mNoticeImpl != null;
    }

    private static boolean notFused(IMSDKResultListener iMSDKResultListener) {
        if (IMSDKFuse.isAvailable(IR.fuse.IMSDK_FUSE_NOTICE) && IMSDKFuse.isAvailable(IR.fuse.IMSDK_FUSE_NOTICE, mCurChannel)) {
            return true;
        }
        T.HelperLog.moduleIsFused();
        if (iMSDKResultListener == null) {
            return false;
        }
        iMSDKResultListener.onResult(new IMSDKNoticeResult(19, -1));
        return false;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(mCurCtx, "2.10.1", IR.MODULE_NOTICE, "Init<IMSDKNotice>");
        }
        return mCurCtx != null;
    }

    public static String getChannel() {
        return mCurChannel;
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
        if (str.length() > 0 && !str.equals(mCurChannel) && mNoticeImpl == null) {
            Object[] objArr = new Object[2];
            objArr[0] = str.toLowerCase(Locale.US);
            objArr[1] = str.equalsIgnoreCase(IR.def.IMSDK_KEYWORD) ? IR.def.IMSDK_KEYWORD : str;
            String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_NOTICE_FORMAT, objArr);
            mNoticeImpl = (IMSDKNoticeBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKNoticeBase.class, format);
            if (mNoticeImpl != null) {
                mCurChannel = str;
                InnerStat.Builder builder = mAPIStatBuilder;
                if (builder != null) {
                    builder.setChannel(mCurChannel);
                }
            } else {
                T.HelperLog.channelSetFailed(str, format);
            }
        }
        return mNoticeImpl != null;
    }

    public static void showNotice(String str, int i, String str2, IMSDKResultListener<IMSDKNoticeResult> iMSDKResultListener, String str3) {
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mNoticeImpl.showNotice(str, i, str2, iMSDKResultListener, str3);
        }
    }

    public static void loadNoticeData(String str, int i, String str2, int i2, IMSDKResultListener<IMSDKNoticeResult> iMSDKResultListener, String str3) {
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mNoticeImpl.loadNoticeData(str, i, str2, i2, iMSDKResultListener, str3);
        }
    }

    public static void loadNoticeData(String str, String str2, int i, int i2, boolean z, int i3, IMSDKResultListener<IMSDKNoticeResult> iMSDKResultListener, String str3) {
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mNoticeImpl.loadNoticeData(str, str2, i, i2, z, i3, iMSDKResultListener, str3);
        }
    }

    public void setUserData(String str, IMSDKResultListener<IMSDKNoticeResult> iMSDKResultListener, String str2) {
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mNoticeImpl.setUserData(str, iMSDKResultListener, str2);
        }
    }

    public void syncUserDataToSvr(IMSDKResultListener<IMSDKNoticeResult> iMSDKResultListener, String str) {
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mNoticeImpl.syncUserDataToSvr(iMSDKResultListener, str);
        }
    }

    public void closeNotice(String str, int i, IMSDKResultListener<IMSDKNoticeResult> iMSDKResultListener, String str2) {
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mNoticeImpl.closeNotice(str, i, iMSDKResultListener, str2);
        }
    }
}
