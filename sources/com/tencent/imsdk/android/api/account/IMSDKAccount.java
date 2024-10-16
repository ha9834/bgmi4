package com.tencent.imsdk.android.api.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.account.IMSDKAccountManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class IMSDKAccount {
    private static InnerStat mAPIStat;
    private static IMSDKAccountManager mAccountImpl;
    private static Context mCurCtx;

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAccountImpl = new IMSDKAccountManager(mCurCtx);
            mAPIStat = new InnerStat.Builder(activity, "2.10.1", IR.MODULE_ACCOUNT, "Init<IMSDKAccount>").create();
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

    public static void getAreaCode(IMSDKResultListener iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mAccountImpl.getAllAreaCodes(IR.path.ACCOUNT_AREA_CODE, iMSDKResultListener);
        }
    }

    public static IMSDKResult getLoginResult(String str) {
        return IMSDKDB4Login.getLoginResult(mCurCtx, str);
    }

    public static void bind(String str, String str2, String str3, String str4, IMSDKResultListener iMSDKResultListener, String str5) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.accountBind(IR.path.ACCOUNT_AUTO_BIND, str, str2, str3, str4, proxyListener4EventReport, str5);
        }
    }

    public static void login(String str, String str2, String str3, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener<IMSDKLoginResult> proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.accountLogin(IR.path.ACCOUNT_LOGIN, str, str2, str3, proxyListener4EventReport);
        }
    }

    public static void resetPassword(String str, String str2, String str3, String str4, String str5, IMSDKResultListener iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.resetPassword(IR.path.ACCOUNT_RESET_PASSWORD, str, str2, str3, str4, str5, proxyListener4EventReport, new Object[0]);
        }
    }

    public static void getVerifyCode(String str, String str2, String str3, IMSDKResultListener iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(null, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(proxyListener4EventReport)) {
            mAccountImpl.getVerifyCode(IR.path.ACCOUNT_VERIFY_CODE, str, str2, str3, proxyListener4EventReport);
        }
    }

    public static void getAllAreaCodes(IMSDKResultListener iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mAccountImpl.getAllAreaCodes(IR.path.ACCOUNT_AREA_CODE, iMSDKResultListener);
        }
    }

    public static boolean checkVerifyCode(String str, String str2, String str3) {
        return mAccountImpl.checkVerifyCode(str, str2, str3);
    }

    public static void getRecoveryCode(IMSDKResultListener iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mAccountImpl.getRecoveryCode(IR.path.ACCOUNT_GET_RECOVERY_CODE, iMSDKResultListener);
        }
    }

    public static void checkRecoveryCode(String str, String str2, IMSDKResultListener iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInit(iMSDKResultListener)) {
            mAccountImpl.checkRecoveryCode(IR.path.ACCOUNT_CHECK_RECOVERY_CODE, str, str2, iMSDKResultListener);
        }
    }
}
