package com.tencent.imsdk.android.api.gameservice;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.gameservice.IMSDKGameServiceManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKGameService {
    private static final String SPECIAL_CHANNEL = "Google";
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKGameServiceManager mGameImpl;

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(mCurCtx, "2.10.1", IR.MODULE_GAME, "Init<IMSDKGameService>");
        }
        return mCurCtx != null;
    }

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        IMSDKResult iMSDKResult;
        if (mGameImpl == null && iMSDKResultListener != null) {
            if (mCurCtx == null) {
                iMSDKResult = new IMSDKResult(17, 17);
                T.HelperLog.channelInstanceNotInit();
            } else if (mCurChannel == null) {
                iMSDKResult = new IMSDKResult(18, 18);
                T.HelperLog.channelInstanceIsNull();
            } else {
                iMSDKResult = new IMSDKResult(11, 11);
            }
            iMSDKResultListener.onResult(iMSDKResult);
        }
        return mGameImpl != null;
    }

    private static boolean notFused(IMSDKResultListener iMSDKResultListener) {
        if (IMSDKFuse.isAvailable(IR.fuse.IMSDK_FUSE_GAME) && IMSDKFuse.isAvailable(IR.fuse.IMSDK_FUSE_GAME, mCurChannel)) {
            return true;
        }
        T.HelperLog.moduleIsFused();
        if (iMSDKResultListener == null) {
            return false;
        }
        iMSDKResultListener.onResult(new IMSDKResult(19, 19));
        return false;
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
        if (str.length() != 0 && !str.equals(mCurChannel) && mGameImpl == null) {
            Object[] objArr = new Object[2];
            objArr[0] = str.toLowerCase(Locale.US);
            objArr[1] = str.equalsIgnoreCase(SPECIAL_CHANNEL) ? SPECIAL_CHANNEL : str;
            String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_GAME_SERVICE_FORMAT, objArr);
            mGameImpl = (IMSDKGameServiceManager) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKGameServiceManager.class, format);
            if (mGameImpl != null) {
                mCurChannel = str;
                InnerStat.Builder builder = mAPIStatBuilder;
                if (builder != null) {
                    builder.setChannel(mCurChannel);
                }
            } else {
                T.HelperLog.channelSetFailed(str, format);
            }
        }
        return mGameImpl != null;
    }

    public static String getChannel() {
        return mCurChannel;
    }

    public static void setup(IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mGameImpl.setup(iMSDKResultListener, objArr);
        }
    }

    public static void setScore(String str, int i, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mGameImpl.setScore(str, i, iMSDKResultListener, objArr);
        }
    }

    public static void showLeaderBoard(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mGameImpl.showLeaderBoard(str, iMSDKResultListener, objArr);
        }
    }

    public static void unlockAchieve(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mGameImpl.unlockAchieve(str, iMSDKResultListener, objArr);
        }
    }

    public static void increaseAchieve(String str, int i, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mGameImpl.increaseAchieve(str, i, iMSDKResultListener, objArr);
        }
    }

    public static void showAchievement(IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener) && notFused(iMSDKResultListener)) {
            mGameImpl.showAchievement(iMSDKResultListener, objArr);
        }
    }
}
