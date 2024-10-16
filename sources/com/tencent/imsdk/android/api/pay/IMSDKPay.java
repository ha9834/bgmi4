package com.tencent.imsdk.android.api.pay;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.pay.IMSDKPayBase;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKPay {
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKPayBase mPayImpl;

    public static boolean initialize(Activity activity) {
        T.mGlobalActivityUpToDate = activity;
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMSDKErrCode.initialize(mCurCtx);
        } else {
            IMLogger.d("current mCurCtx is not null : " + mCurCtx + " and parameter is " + activity);
        }
        return IMSDKConfig.initialize(activity);
    }

    public static boolean setChannel(String str) {
        if ((str.length() > 0 && !str.equals(mCurChannel)) || mPayImpl == null) {
            mPayImpl = null;
            mPayImpl = getPayInstance(str);
            if (mPayImpl != null) {
                mCurChannel = str;
            } else {
                IMLogger.e("get channel instance of " + str + " fail when setChannel()", new Object[0]);
            }
        }
        return mPayImpl != null;
    }

    private static IMSDKPayBase getPayInstance(String str) {
        String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_PAY_FORMAT, str.toLowerCase(Locale.US), str);
        IMLogger.d("get '" + format + "' channel instance");
        return (IMSDKPayBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKPayBase.class, format);
    }

    private static boolean isInit(IMSDKResultListener iMSDKResultListener) {
        if (mPayImpl == null) {
            IMLogger.e("Need call IMSDKPay.initialize() first", new Object[0]);
        }
        return mPayImpl != null;
    }

    public static void prepare(IMPayMidasReq iMPayMidasReq) {
        if (mPayImpl != null) {
            prepare(iMPayMidasReq, false, null);
        }
    }

    public static void prepare(IMPayMidasReq iMPayMidasReq, boolean z, IMSDKResultListener<IMPayMidasUpdateResp> iMSDKResultListener) {
        if (isInit(iMSDKResultListener)) {
            mPayImpl.prepareFromMidas(iMPayMidasReq, z, iMSDKResultListener);
        }
    }

    public static void pay(IMPayMidasReq iMPayMidasReq, IMSDKResultListener iMSDKResultListener) {
        if (isInit(iMSDKResultListener)) {
            mPayImpl.payFromMidas(iMPayMidasReq, iMSDKResultListener);
        }
    }

    public static void getProductInfo(IMPayMidasReq iMPayMidasReq, IMSDKResultListener iMSDKResultListener) {
        if (isInit(iMSDKResultListener)) {
            mPayImpl.getProductInfoFromMidas(iMPayMidasReq, iMSDKResultListener);
        }
    }

    public static void getMp(IMPayMidasReq iMPayMidasReq, IMSDKResultListener iMSDKResultListener) {
        if (isInit(iMSDKResultListener)) {
            mPayImpl.netFromMidas(iMPayMidasReq, iMSDKResultListener);
        }
    }

    public static void setEnv(String str) {
        if (mPayImpl == null || T.ckIsEmpty(str)) {
            return;
        }
        mPayImpl.setEnv(str);
    }

    public static void setIdc(String str) {
        if (mPayImpl == null || T.ckIsEmpty(str)) {
            return;
        }
        mPayImpl.setReleaseIDC(str);
    }

    public static void setLogEnable(boolean z) {
        IMSDKPayBase iMSDKPayBase = mPayImpl;
        if (iMSDKPayBase != null) {
            iMSDKPayBase.setLogEnable(z);
        }
    }

    public static void deinit() {
        IMSDKPayBase iMSDKPayBase = mPayImpl;
        if (iMSDKPayBase != null) {
            iMSDKPayBase.deinit();
        }
    }

    public static void setScreenType(boolean z) {
        IMSDKPayBase iMSDKPayBase = mPayImpl;
        if (iMSDKPayBase != null) {
            iMSDKPayBase.setScreenType(z);
        }
    }
}
