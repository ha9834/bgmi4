package com.tencent.imsdk.android.api.lbs;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.anroid.lbs.imsdk.BuildConfig;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKLbs {
    public static final String DEFAULT_PACKAGE_NAME_LBS_FORMAT = "com.tencent.imsdk.android.lbs.%s.%sLbs";
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKLbsBase mLbsImpl;

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        IMSDKResult iMSDKResult;
        if (mLbsImpl == null) {
            IMLogger.e("Need call IMSDKLbs.initialize() first", new Object[0]);
            if (iMSDKResultListener != null) {
                if (mCurCtx == null) {
                    iMSDKResult = new IMSDKResult(17, 17);
                } else if (mCurChannel == null) {
                    iMSDKResult = new IMSDKResult(18, 18);
                } else {
                    iMSDKResult = new IMSDKResult(11, 11);
                }
                iMSDKResultListener.onResult(iMSDKResult);
            }
        }
        return mLbsImpl != null;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            mAPIStatBuilder = new InnerStat.Builder(activity, BuildConfig.VERSION_NAME, IR.MODULE_FRIEND, "Init<IMSDKLbs>");
        }
        return mCurCtx != null;
    }

    private static IMSDKLbsBase getLbsInstance(String str) {
        String format = String.format(DEFAULT_PACKAGE_NAME_LBS_FORMAT, str.toLowerCase(Locale.US), str);
        IMSDKLbsBase iMSDKLbsBase = (IMSDKLbsBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKLbsBase.class, format);
        if (iMSDKLbsBase == null) {
            T.HelperLog.channelSetFailed(str, format);
        }
        return iMSDKLbsBase;
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
        if ((str.length() > 0 && !str.equals(mCurChannel)) || mLbsImpl == null) {
            mLbsImpl = null;
            mLbsImpl = getLbsInstance(str);
            if (mLbsImpl != null) {
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
        return mLbsImpl != null;
    }

    public static void getLocationInfo(IMSDKResultListener<IMSDKLbsResult> iMSDKResultListener) {
        IMSDKLbsBase iMSDKLbsBase = mLbsImpl;
        if (iMSDKLbsBase != null) {
            iMSDKLbsBase.getLocationInfo(iMSDKResultListener);
        } else {
            IMLogger.e(" mLbsImpl is null, plz check ! ", new Object[0]);
        }
    }

    public static void enableGPS(boolean z) {
        IMSDKLbsBase iMSDKLbsBase = mLbsImpl;
        if (iMSDKLbsBase != null) {
            iMSDKLbsBase.setEnableGPS(z);
        } else {
            IMLogger.e(" mLbsImpl is null, plz check ! ", new Object[0]);
        }
    }

    public static void setLanguageTag(String str) {
        IMSDKLbsBase iMSDKLbsBase = mLbsImpl;
        if (iMSDKLbsBase != null) {
            iMSDKLbsBase.setLanTag(str);
        } else {
            IMLogger.e(" mLbsImpl is null, plz check ! ", new Object[0]);
        }
    }
}
