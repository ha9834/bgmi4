package com.tencent.imsdk.android.api.push;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.push.IMSDKPushBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKPush {
    private static InnerStat.Builder mAPIStatBuilder = null;
    private static String mCurChannel = "";
    private static Context mCurCtx;
    private static IMSDKPushBase mPushImpl;

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        IMSDKPushResult iMSDKPushResult;
        if (mPushImpl == null) {
            IMLogger.e("Need call IMSDKPush.initialize() first", new Object[0]);
            T.HelperLog.channelInstanceIsNull();
            if (iMSDKResultListener != null) {
                if (mCurCtx == null) {
                    iMSDKPushResult = new IMSDKPushResult(17, -1);
                } else if (T.ckIsEmpty(mCurChannel)) {
                    iMSDKPushResult = new IMSDKPushResult(18, -1);
                } else {
                    iMSDKPushResult = new IMSDKPushResult(11, -1);
                }
                iMSDKResultListener.onResult(iMSDKPushResult);
            }
        }
        return mPushImpl != null;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx == null) {
            mCurCtx = activity.getApplicationContext();
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(mCurCtx, "2.10.1", IR.MODULE_PUSH, "Init<IMSDKPush>");
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
        if ((str.length() > 0 && !str.equals(mCurChannel)) || mPushImpl == null) {
            mPushImpl = null;
            Object[] objArr = new Object[2];
            objArr[0] = str.toLowerCase(Locale.getDefault());
            objArr[1] = str.equalsIgnoreCase(IR.def.IMSDK_KEYWORD) ? IR.def.IMSDK_KEYWORD : str;
            String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_PUSH_FORMAT, objArr);
            IMLogger.d(format);
            mPushImpl = (IMSDKPushBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKPushBase.class, format);
            if (mPushImpl != null) {
                mCurChannel = str;
                InnerStat.Builder builder = mAPIStatBuilder;
                if (builder != null) {
                    builder.setChannel(mCurChannel);
                }
            } else {
                IMLogger.e("get channel instance of " + str + " fail when setChannel()", new Object[0]);
            }
        }
        return mPushImpl != null;
    }

    public static void setNotificationActionListener(IMSDKResultListener<IMSDKPushResult> iMSDKResultListener) {
        if (isInit(iMSDKResultListener)) {
            mPushImpl.setNotificationListener(iMSDKResultListener);
        }
    }

    public static void registerPush() {
        registerPush((IMSDKResultListener<IMSDKResult>) null);
    }

    public static void registerPush(String str) {
        registerPush(str, null);
    }

    public static void registerPush(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        registerPush(null, iMSDKResultListener);
    }

    public static void registerPush(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.registerPush(str, iMSDKResultListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void registerPush(String str, String str2, int i, String str3, IMSDKResultListener iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        IMSDKResultListener proxyListener4EventReport = builder != null ? builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mPushImpl.registerPush(str, str2, i, str3, proxyListener4EventReport);
        }
    }

    public static void unregisterPush(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        unregisterPush("", iMSDKResultListener);
    }

    public static void unregisterPush(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(null)) {
            mPushImpl.unregisterPush(str, iMSDKResultListener);
        }
    }

    public static void setTag(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        setTags(arrayList, iMSDKResultListener);
    }

    public static void setTags(List<String> list, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.setTags(list, iMSDKResultListener);
        }
    }

    public static void replaceTags(List<String> list, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.replaceTags(list, iMSDKResultListener);
        }
    }

    public static void deleteTag(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        deleteTags(arrayList, iMSDKResultListener);
    }

    public static void deleteTags(List<String> list, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.deleteTags(list, iMSDKResultListener);
        }
    }

    public static void cleanTags(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.cleanTags(iMSDKResultListener);
        }
    }

    public static void addLocalNotification(IMSDKLocalMessage iMSDKLocalMessage, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.addLocalNotification(iMSDKLocalMessage, iMSDKResultListener);
        }
    }

    public static void clearLocalNotifications(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mPushImpl.clearLocalNotifications(iMSDKResultListener);
        }
    }
}
