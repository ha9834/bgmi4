package com.tencent.imsdk.android.api.help;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.help.IMSDKHelpBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKHelp {
    private static final int HELP_GET = 2;
    private static final int HELP_OTHER = 0;
    private static final int HELP_SHOW = 1;
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKHelpBase mHelpImpl;

    private static boolean isInit(int i, IMSDKResultListener iMSDKResultListener) {
        int i2;
        JsonSerializable iMSDKHelpShowResult;
        if (mHelpImpl == null) {
            T.HelperLog.channelInstanceIsNull();
            if (iMSDKResultListener != null) {
                if (mCurCtx == null) {
                    i2 = 17;
                    T.HelperLog.contextIsNull();
                } else if (mCurChannel == null) {
                    T.HelperLog.channelInstanceIsNull();
                    i2 = 18;
                } else {
                    i2 = 11;
                }
                switch (i) {
                    case 1:
                        iMSDKHelpShowResult = new IMSDKHelpShowResult(i2, -1);
                        break;
                    case 2:
                        iMSDKHelpShowResult = new IMSDKHelpGetResult(i2, -1);
                        break;
                    default:
                        iMSDKHelpShowResult = new IMSDKResult(i2, -1);
                        break;
                }
                iMSDKResultListener.onResult(iMSDKHelpShowResult);
            } else {
                IMLogger.w("IMSDKHelp listener is null", new Object[0]);
            }
        }
        return mHelpImpl != null;
    }

    private static boolean notFused(int i, IMSDKResultListener iMSDKResultListener) {
        JsonSerializable iMSDKHelpShowResult;
        if (IMSDKFuse.isAvailable(IR.fuse.IMSDK_FUSE_HELP) && IMSDKFuse.isAvailable(IR.fuse.IMSDK_FUSE_HELP, mCurChannel)) {
            return true;
        }
        T.HelperLog.moduleIsFused();
        if (iMSDKResultListener == null) {
            return false;
        }
        switch (i) {
            case 1:
                iMSDKHelpShowResult = new IMSDKHelpShowResult(19, -1);
                break;
            case 2:
                iMSDKHelpShowResult = new IMSDKHelpGetResult(19, -1);
                break;
            default:
                iMSDKHelpShowResult = new IMSDKResult(19, -1);
                break;
        }
        iMSDKResultListener.onResult(iMSDKHelpShowResult);
        return false;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(mCurCtx, "2.10.1", IR.MODULE_GAME, "Init<IMSDKGameService>");
        }
        return mCurCtx != null;
    }

    public static boolean setChannel(String str) {
        if (mCurCtx == null) {
            T.HelperLog.contextIsNull();
            return false;
        }
        if (T.ckIsEmpty(str)) {
            T.HelperLog.channelIsNullOrEmpty();
            return false;
        }
        if (str != null && str.length() != 0 && !str.equals(mCurChannel) && mHelpImpl == null) {
            String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_HELP_FORMAT, str.toLowerCase(Locale.US), str);
            mHelpImpl = (IMSDKHelpBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKHelpBase.class, format);
            if (mHelpImpl != null) {
                mCurChannel = str;
                InnerStat.Builder builder = mAPIStatBuilder;
                if (builder != null) {
                    builder.setChannel(mCurChannel);
                }
            } else {
                IMLogger.e("get channel instance of " + str + " fail when setChannel()", new Object[0]);
                T.HelperLog.channelSetFailed(str, format);
            }
        }
        return mHelpImpl != null;
    }

    public static String getChannel() {
        return mCurChannel;
    }

    public static void showHelpCenter(IMSDKResultListener<IMSDKHelpShowResult> iMSDKResultListener, String str) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener) && notFused(1, iMSDKResultListener)) {
            mHelpImpl.showHelpCenter(iMSDKResultListener, str);
        }
    }

    public static void showFAQ(IMSDKResultListener<IMSDKHelpShowResult> iMSDKResultListener, String str) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener) && notFused(1, iMSDKResultListener)) {
            mHelpImpl.showFAQ(iMSDKResultListener, str);
        }
    }

    public static void showCustomerService(IMSDKResultListener<IMSDKHelpShowResult> iMSDKResultListener, String str) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener) && notFused(1, iMSDKResultListener)) {
            mHelpImpl.showCustomerService(iMSDKResultListener, str);
        }
    }

    public static void getNewMessages(IMSDKResultListener<IMSDKHelpGetResult> iMSDKResultListener, String str) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(2, iMSDKResultListener) && notFused(2, iMSDKResultListener)) {
            mHelpImpl.getNewMessages(iMSDKResultListener, str);
        }
    }

    public static void sendFeedback(IMSDKResultListener iMSDKResultListener, String str) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(0, iMSDKResultListener) && notFused(0, iMSDKResultListener)) {
            mHelpImpl.sendFeedback(iMSDKResultListener, str);
        }
    }

    public static void setLanguage(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setLanguage(str);
        }
    }

    public static void setZone(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setZone(str);
        }
    }

    public static void setCharacter(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setCharacter(str);
        }
    }

    public static void setLevel(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setLevel(str);
        }
    }

    public static void setServerName(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setServerName(str);
        }
    }

    public static void setServerId(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setServerId(str);
        }
    }

    public static void setRoleName(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setRoleName(str);
        }
    }

    public static void setRoleId(String str) {
        if (isInit(0, null) && notFused(0, null)) {
            mHelpImpl.setRoleId(str);
        }
    }

    public static String getLanguage() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getLanguage() : "";
    }

    public static String getZone() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getZone() : "";
    }

    public static String getCharacter() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getCharacter() : "";
    }

    public static String getLevel() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getLevel() : "";
    }

    public static String getServerName() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getServerName() : "";
    }

    public static String getServerId() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getServerId() : "";
    }

    public static String getRoleName() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getRoleName() : "";
    }

    public static String getRoleId() {
        return (isInit(0, null) && notFused(0, null)) ? mHelpImpl.getRoleId() : "";
    }
}
