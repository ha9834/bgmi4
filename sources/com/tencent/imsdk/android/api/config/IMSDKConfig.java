package com.tencent.imsdk.android.api.config;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.tencent.imsdk.android.base.config.IMSDKConfigManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.FileLogger;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.HashMap;

/* loaded from: classes.dex */
public class IMSDKConfig {
    private static InnerStat.Builder mAPIStatBuilder;
    private static IMSDKConfigManager mConfigImpl;
    private static Context mCurCtx;

    public static boolean initialize(final Activity activity) {
        T.mGlobalActivityUpToDate = activity;
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mConfigImpl = new IMSDKConfigManager(mCurCtx);
            FileLogger.getInstance().initialize(mCurCtx);
            T.Device.syncGoogleAdId(mCurCtx);
            IMSDKErrCode.initialize(mCurCtx);
            getConfigs(new IMSDKResultListener() { // from class: com.tencent.imsdk.android.api.config.IMSDKConfig.1
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    IMLogger.d("get config result : " + iMSDKResult.imsdkRetCode);
                    InnerStat.Builder unused = IMSDKConfig.mAPIStatBuilder = new InnerStat.Builder(activity, "2.10.1", IR.MODULE_AUTH, "Init<IMSDKConfig>");
                    IMSDKConfig.mAPIStatBuilder.setChannel(IR.def.IMSDK_KEYWORD).setStage("end").setResult("finish").setMethod(ConfigDBHelper.TABLE_NAME_CONFIG).create().reportEvent();
                }
            });
        }
        IMLogger.d("config initialize success");
        return mConfigImpl != null;
    }

    public static boolean isInit() {
        return (mConfigImpl == null || mCurCtx == null) ? false : true;
    }

    public static String getOrDefault(String str, String str2) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        return iMSDKConfigManager != null ? iMSDKConfigManager.getOrDefault(str, str2) : str2;
    }

    public static int getOrDefault(String str, int i) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        return iMSDKConfigManager != null ? iMSDKConfigManager.getOrDefault(str, i) : i;
    }

    public static String getOrMetaData(String str, String str2) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        String orDefault = iMSDKConfigManager != null ? iMSDKConfigManager.getOrDefault(str, "") : "";
        return T.ckIsEmpty(orDefault) ? T.Meta.readFromApplication(mCurCtx, str2, "") : orDefault;
    }

    public static String getOrMetaData(String str, String str2, String str3) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        String orDefault = iMSDKConfigManager != null ? iMSDKConfigManager.getOrDefault(str, "") : str3;
        return T.ckIsEmpty(orDefault) ? T.Meta.readFromApplication(mCurCtx, str2, str3) : orDefault;
    }

    public static int getOrMetaData(String str, String str2, int i) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        String orDefault = iMSDKConfigManager != null ? iMSDKConfigManager.getOrDefault(str, "") : "";
        if (T.ckIsEmpty(orDefault)) {
            return T.Meta.readFromApplication(mCurCtx, str2, i);
        }
        try {
            return Integer.valueOf(orDefault).intValue();
        } catch (NumberFormatException e) {
            IMLogger.e("getOrMetaData()", e.getMessage());
            return i;
        }
    }

    public static boolean getOrMetaData(String str, String str2, boolean z) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        String orDefault = iMSDKConfigManager != null ? iMSDKConfigManager.getOrDefault(str, "") : "";
        if (T.ckIsEmpty(orDefault)) {
            return T.Meta.readFromApplication(mCurCtx, str2, z);
        }
        return Boolean.valueOf(orDefault).booleanValue();
    }

    public static void getConfigs() {
        getConfigs(null);
    }

    public static void getConfigs(IMSDKResultListener iMSDKResultListener) {
        if (mConfigImpl == null) {
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(17));
            }
        } else {
            if (isConfigEnable()) {
                mConfigImpl.getConfigs(iMSDKResultListener);
                return;
            }
            IMLogger.w("No meta value of 'IMSDK_SERVER_CONFIG' found in AndroidManifest.xml", new Object[0]);
            if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKResult(19));
            }
        }
    }

    public static boolean isConfigEnable() {
        return (mConfigImpl == null || T.ckIsEmpty(T.Meta.readFromApplication(mCurCtx, IR.meta.IMSDK_SERVER_CONFIG, ""))) ? false : true;
    }

    public static boolean isFinishPullConfig() {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        return iMSDKConfigManager != null && iMSDKConfigManager.isConfigProcessed();
    }

    public static boolean updateConfigs(HashMap<String, String> hashMap, boolean z) {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        if (iMSDKConfigManager != null && iMSDKConfigManager.updateUserDB(hashMap) && z) {
            IMLogger.i("cleanup local auth and login data cache", new Object[0]);
            IMSDKDB4Login.clearDB(mCurCtx);
            IMSDKDB4Login.cleanSavedLoginData(mCurCtx, "5");
            return true;
        }
        IMLogger.w("warning : not clear local cache", new Object[0]);
        return false;
    }

    public static boolean updateConfigs(HashMap<String, String> hashMap) {
        return updateConfigs(hashMap, true);
    }

    public static void resetConfigs() {
        IMSDKConfigManager iMSDKConfigManager = mConfigImpl;
        if (iMSDKConfigManager != null) {
            iMSDKConfigManager.clearUserDB();
        } else {
            IMLogger.e("please call initialize first", new Object[0]);
            T.HelperLog.channelInstanceIsNull();
        }
    }
}
