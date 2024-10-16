package com.tencent.imsdk.android.extend.admob;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLogin;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdmobExtend {
    private static final String DEAULT_TEST_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    private static final String IMSDK_ADMOB_TEST_DEVICE = "IMSDK_ADMOB_TEST_DEVICE";
    private static final String IMSDK_ADMOB_UNIT_ID = "IMSDK_ADMOB_UNIT_ID";
    private static final int UNKNOWN_GMS_ERROR = -1;
    private static IMSDKResultListener<IMSDKResult> mActionListener;
    private static String mAdUnitId;
    private static Context mContext;
    private static IMSDKResultListener<IMSDKResult> mLoadListener;
    private static RewardedVideoAd mRewardedVideoAd;

    /* loaded from: classes.dex */
    public class ActionType {
        public static final int CLOSE = 5;
        public static final int COMPLETE = 3;
        public static final int LEFT = 6;
        public static final int OPEN = 1;
        public static final int REWARD = 4;
        public static final int START = 2;

        public ActionType() {
        }
    }

    private static int isGooglePlayServicesAvailable(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        } catch (Exception e) {
            IMLogger.e("check gms error : " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    private static String getGooglePlayServicesErrorString(Context context, int i) {
        if (context == null) {
            return "";
        }
        try {
            return GoogleApiAvailability.getInstance().getErrorString(i);
        } catch (Exception e) {
            IMLogger.e("check gms error : " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static boolean initailize(Context context) {
        mContext = context;
        IMSDKErrCode.initialize(context);
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            IMLogger.e("get gms status error " + isGooglePlayServicesAvailable + " : " + getGooglePlayServicesErrorString(context, isGooglePlayServicesAvailable), new Object[0]);
            return false;
        }
        MobileAds.initialize(context);
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context);
        RewardedVideoAd rewardedVideoAd = mRewardedVideoAd;
        if (rewardedVideoAd == null) {
            return true;
        }
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() { // from class: com.tencent.imsdk.android.extend.admob.AdmobExtend.1
            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoAdLoaded() {
                IMLogger.d("onRewardedVideoAdLoaded");
                if (AdmobExtend.mLoadListener != null) {
                    AdmobExtend.mLoadListener.onResult(new IMSDKResult(1, 1, "admob load success"));
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoAdFailedToLoad(int i) {
                IMLogger.d("onRewardedVideoAdFailedToLoad : " + i);
                if (AdmobExtend.mLoadListener != null) {
                    AdmobExtend.mLoadListener.onResult(new IMSDKResult(9999, i, "admob load failed : " + i));
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoStarted() {
                IMLogger.d("onRewardedVideoStarted");
                if (AdmobExtend.mActionListener != null) {
                    AdmobExtend.mActionListener.onResult(new IMSDKResult(1, 2, "admob reward video started"));
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoAdOpened() {
                IMLogger.d("onRewardedVideoAdOpened");
                if (AdmobExtend.mActionListener != null) {
                    AdmobExtend.mActionListener.onResult(new IMSDKResult(1, 1, "admob reward video opened"));
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoAdClosed() {
                IMLogger.d("onRewardedVideoAdClosed");
                if (AdmobExtend.mActionListener != null) {
                    AdmobExtend.mActionListener.onResult(new IMSDKResult(1, 5, "admob reward video closed"));
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoAdLeftApplication() {
                IMLogger.d("onRewardedVideoAdLeftApplication");
                if (AdmobExtend.mActionListener != null) {
                    AdmobExtend.mActionListener.onResult(new IMSDKResult(1, 6, "admob reward video left application"));
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewarded(RewardItem rewardItem) {
                IMLogger.d("onRewarded : " + rewardItem.getType() + ", " + rewardItem.getAmount());
                if (AdmobExtend.mActionListener != null) {
                    IMSDKResult iMSDKResult = new IMSDKResult(1, 4, "admob on rewarded");
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("rewardType", rewardItem.getType());
                        jSONObject.put("rewardAmount", rewardItem.getAmount());
                        iMSDKResult.retExtraJson = jSONObject.toString();
                    } catch (JSONException unused) {
                        IMLogger.e("get reward item failed", new Object[0]);
                    }
                    AdmobExtend.mActionListener.onResult(iMSDKResult);
                }
            }

            @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
            public void onRewardedVideoCompleted() {
                IMLogger.d("onRewardedVideoCompleted");
                if (AdmobExtend.mActionListener != null) {
                    AdmobExtend.mActionListener.onResult(new IMSDKResult(1, 3, "admob reward video completed"));
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void autoFixUserId() {
        IMSDKLoginResult loginResult;
        RewardedVideoAd rewardedVideoAd = mRewardedVideoAd;
        if (rewardedVideoAd != null && T.ckIsEmpty(rewardedVideoAd.getUserId()) && (loginResult = IMSDKLogin.getLoginResult()) != null && loginResult.imsdkRetCode == 1 && T.ckIsEmpty(loginResult.openId)) {
            IMLogger.i("admob using default login openid : " + loginResult.openId, new Object[0]);
            setUserId(loginResult.openId);
        }
    }

    public static void setUserId(final String str) {
        if (mRewardedVideoAd == null || T.mGlobalActivityUpToDate == null) {
            return;
        }
        T.mGlobalActivityUpToDate.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.extend.admob.AdmobExtend.2
            @Override // java.lang.Runnable
            public void run() {
                AdmobExtend.mRewardedVideoAd.setUserId(str);
                IMLogger.d("admob set user id : " + AdmobExtend.mRewardedVideoAd.getUserId());
            }
        });
    }

    public static void loadRewardedVideoAd(final String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(mContext);
        if (isGooglePlayServicesAvailable != 0) {
            IMLogger.e("get gms status error " + isGooglePlayServicesAvailable + " : " + getGooglePlayServicesErrorString(mContext, isGooglePlayServicesAvailable), new Object[0]);
            iMSDKResultListener.onResult(new IMSDKResult(15, isGooglePlayServicesAvailable(mContext), getGooglePlayServicesErrorString(mContext, isGooglePlayServicesAvailable)));
            return;
        }
        mLoadListener = iMSDKResultListener;
        if (T.mGlobalActivityUpToDate != null) {
            T.mGlobalActivityUpToDate.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.extend.admob.AdmobExtend.3
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    AdRequest.Builder builder = new AdRequest.Builder();
                    if (IMSDKConfig.getOrMetaData(AdmobExtend.IMSDK_ADMOB_TEST_DEVICE, AdmobExtend.IMSDK_ADMOB_TEST_DEVICE, false)) {
                        String upperCase = T.Digest.getMD5(DeviceUtils.getAndroidId(AdmobExtend.mContext)).toUpperCase();
                        IMLogger.w("you are using TESTING mode, admob will automatically add test device md5(ANDROID_ID): " + upperCase, new Object[0]);
                        builder.addTestDevice(upperCase);
                    }
                    if (T.ckIsEmpty(str)) {
                        String unused = AdmobExtend.mAdUnitId = IMSDKConfig.getOrMetaData(AdmobExtend.IMSDK_ADMOB_UNIT_ID, AdmobExtend.IMSDK_ADMOB_UNIT_ID, "");
                        if (T.ckIsEmpty(AdmobExtend.mAdUnitId)) {
                            IMLogger.e("default admob unit id is empty, using TESTING unit id. please add IMSDK_ADMOB_UNIT_ID meta data in your AndroidManifest.xml", new Object[0]);
                            str2 = AdmobExtend.DEAULT_TEST_UNIT_ID;
                        } else {
                            IMLogger.d("use default admob unit id " + AdmobExtend.mAdUnitId);
                            str2 = AdmobExtend.mAdUnitId;
                        }
                    } else {
                        IMLogger.d("use user admob unit id " + str);
                        str2 = str;
                    }
                    AdmobExtend.autoFixUserId();
                    IMLogger.d("load admob reward ad : " + str2);
                    AdmobExtend.mRewardedVideoAd.loadAd(str2, builder.build());
                }
            });
        } else {
            iMSDKResultListener.onResult(new IMSDKResult(17));
        }
    }

    public static void show(final IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(mContext);
        if (isGooglePlayServicesAvailable != 0) {
            IMLogger.e("get gms status error : " + isGooglePlayServicesAvailable + " : " + getGooglePlayServicesErrorString(mContext, isGooglePlayServicesAvailable), new Object[0]);
            iMSDKResultListener.onResult(new IMSDKResult(15, isGooglePlayServicesAvailable(mContext), getGooglePlayServicesErrorString(mContext, isGooglePlayServicesAvailable)));
            return;
        }
        mActionListener = iMSDKResultListener;
        if (T.mGlobalActivityUpToDate != null) {
            T.mGlobalActivityUpToDate.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.extend.admob.AdmobExtend.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AdmobExtend.mRewardedVideoAd.isLoaded()) {
                        AdmobExtend.autoFixUserId();
                        AdmobExtend.mRewardedVideoAd.show();
                    } else {
                        IMSDKResultListener.this.onResult(new IMSDKResult(17, -1, "admob load no data"));
                    }
                }
            });
        } else {
            iMSDKResultListener.onResult(new IMSDKResult(17));
        }
    }

    public static void onResume() {
        if (mRewardedVideoAd == null || mContext == null) {
            return;
        }
        IMLogger.d("admob onResume");
        mRewardedVideoAd.resume(mContext);
    }

    public static void onPause() {
        if (mRewardedVideoAd == null || mContext == null) {
            return;
        }
        IMLogger.d("admob onPause");
        mRewardedVideoAd.pause(mContext);
    }

    public static void onDestroy() {
        if (mRewardedVideoAd == null || mContext == null) {
            return;
        }
        IMLogger.d("admob onDestroy");
        mRewardedVideoAd.destroy(mContext);
    }
}
