package com.tencent.imsdk.android.api.unifiedaccount;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.unifiedaccount.IMSDKUnifiedAccountManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class IMSDKUnifiedAccount {
    private static InnerStat mAPIStat;
    private static IMSDKUnifiedAccountManager mAccountImpl;
    private static Context mCurCtx;

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAccountImpl = IMSDKUnifiedAccountManager.getInstance();
            mAPIStat = new InnerStat.Builder(activity, "2.10.1", IR.MODULE_ACCOUNT, "Init<IMSDKUnifiedAccount>").create();
        }
        return mAccountImpl != null;
    }

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        if (mAccountImpl == null) {
            T.HelperLog.channelInstanceNotInit();
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(17, -1));
            }
        }
        return mAccountImpl != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestVerifyCode(String str, int i, int i2, String str2, String str3, IMSDKResultListener iMSDKResultListener, String str4) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.requestVerifyCode(str, i, i2, str2, str3, proxyListener4EventReport, str4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void changePassword(String str, int i, String str2, String str3, String str4, String str5, IMSDKResultListener iMSDKResultListener, String str6) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.changePassword(str, i, str2, str3, str4, str5, proxyListener4EventReport, str6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void modifyAccountInfo(String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6, String str7, IMSDKResultListener iMSDKResultListener, String str8) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.modifyAccountInfo(str, i, i2, str2, str3, str4, str5, i3, str6, str7, proxyListener4EventReport, str8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void checkIsRegisted(String str, int i, String str2, String str3, IMSDKResultListener iMSDKResultListener, String str4) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.checkIsRegisted(str, i, str2, str3, proxyListener4EventReport, str4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void checkVerifyCodeValid(String str, int i, String str2, String str3, int i2, String str4, IMSDKResultListener iMSDKResultListener, String str5) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.checkVerifyCodeValid(str, i, str2, str3, i2, str4, proxyListener4EventReport, str5);
        }
    }
}
