package com.tencent.imsdk.android.stat.adjust;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.LogLevel;
import com.adjust.sdk.OnDeeplinkResponseListener;
import com.amazonaws.services.s3.internal.Constants;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.base.stat.IMSDKStatEventParams;
import com.tencent.imsdk.android.base.stat.IMSDKStatUserAttribute;
import com.tencent.imsdk.android.extend.adjust.AdjustExtend;
import com.tencent.imsdk.android.tools.APKUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public class AdjustStat implements Application.ActivityLifecycleCallbacks, IStat {
    private static final String ADJUST_APP_TOKEN = "IMSDK_STAT_ADJUST_APP_TOKEN";
    private static final String IMSDK_ADJUST_DEFERED_REATTRIBUTION = "IMSDK_ADJUST_DEFERED_REATTRIBUTION";
    private static final String IMSDK_ADJUST_INFO1 = "IMSDK_ADJUST_INFO1";
    private static final String IMSDK_ADJUST_INFO2 = "IMSDK_ADJUST_INFO2";
    private static final String IMSDK_ADJUST_INFO3 = "IMSDK_ADJUST_INFO3";
    private static final String IMSDK_ADJUST_INFO4 = "IMSDK_ADJUST_INFO4";
    private static final String IMSDK_ADJUST_LAUNCH_DEEP_LINKING = "IMSDK_ADJUST_LAUNCH_DEEP_LINKING";
    private static final String IMSDK_ADJUST_PREINSTALL_TRACKING = "IMSDK_ADJUST_PREINSTALL_TRACKING";
    private static final String IMSDK_ADJUST_SECRETID = "IMSDK_ADJUST_SECRETID";
    private static final String IMSDK_ADJUST_URL_STRATEGY = "IMSDK_ADJUST_URL_STRATEGY";
    private static final String IMSDK_FIREBASE_SENDER_ID = "IMSDK_FIREBASE_SENDER_ID";
    private Context mCtx;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public AdjustStat(Context context) {
        IMLogger.d("AdjustStat start");
        if (this.mCtx == null) {
            this.mCtx = context;
            new InnerStat.Builder(context, BuildConfig.VERSION_NAME, getAdjustSDKVersion());
            boolean isDebug = T.isDebug();
            AdjustConfig adjustConfig = new AdjustConfig(this.mCtx, IMSDKConfig.getOrMetaData(ADJUST_APP_TOKEN, ADJUST_APP_TOKEN, ""), isDebug ? AdjustConfig.ENVIRONMENT_SANDBOX : AdjustConfig.ENVIRONMENT_PRODUCTION);
            String orMetaData = IMSDKConfig.getOrMetaData(IMSDK_ADJUST_URL_STRATEGY, IMSDK_ADJUST_URL_STRATEGY, "");
            if (orMetaData != null && orMetaData.length() > 0) {
                adjustConfig.setUrlStrategy(orMetaData);
                IMLogger.i("Adjust setUrlStrategy " + orMetaData, new Object[0]);
            }
            if (Boolean.valueOf(IMSDKConfig.getOrMetaData(IMSDK_ADJUST_PREINSTALL_TRACKING, IMSDK_ADJUST_PREINSTALL_TRACKING, false)).booleanValue()) {
                adjustConfig.setPreinstallTrackingEnabled(true);
                IMLogger.i("Adjust setPreinstallTrackingEnabled", new Object[0]);
            }
            String packageChannelId = APKUtils.getPackageChannelId(context, null);
            IMLogger.d("store tracker = " + packageChannelId);
            if (!T.ckIsEmpty(packageChannelId)) {
                adjustConfig.setDefaultTracker(packageChannelId);
            }
            adjustConfig.setLogLevel(isDebug ? LogLevel.VERBOSE : LogLevel.ERROR);
            setDeepLinking(adjustConfig);
            setAppSecret(adjustConfig);
            Adjust.onCreate(adjustConfig);
            Adjust.onResume();
            if (T.mGlobalActivityUpToDate != null && Build.VERSION.SDK_INT >= 14) {
                T.mGlobalActivityUpToDate.getApplication().registerActivityLifecycleCallbacks(this);
            }
            IMLogger.d(this.mCtx instanceof Activity ? "registerActivityLifecycleCallbacks success" : "registerActivityLifecycleCallbacks fail, maybe you need monitor activityResumed and activityPaused manually");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Adjust.onResume();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Adjust.onPause();
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public void setAttribute(String str, IMSDKStatUserAttribute iMSDKStatUserAttribute) {
        IMLogger.w("not support " + str, new Object[0]);
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public <T> T getAttribute(Class<?> cls, String str, Object... objArr) {
        IMLogger.w("not support " + str, new Object[0]);
        return null;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IStat
    public void reportEvent(String str, IMSDKStatEventParams iMSDKStatEventParams) {
        if (T.ckIsEmpty(iMSDKStatEventParams.eventName)) {
            IMLogger.e("must identify a event token in params.eventName ", new Object[0]);
            return;
        }
        IMLogger.d(str + " " + iMSDKStatEventParams.eventName + " is executing");
        if (IStat.STAT_EVENT_REPORT.equals(str) || IStat.STAT_EVENT_PURCHASE_REPORT.equals(str) || IStat.STAT_EVENT_APP_LAUNCH.equals(str) || IStat.STAT_EVENT_USER_LOGIN.equals(str) || IStat.STAT_EVENT_USER_REGISTER.equals(str)) {
            AdjustEvent adjustEvent = new AdjustEvent(iMSDKStatEventParams.eventName);
            if (IStat.STAT_EVENT_PURCHASE_REPORT.equals(str)) {
                try {
                    adjustEvent.setRevenue(Float.parseFloat(iMSDKStatEventParams.expense), iMSDKStatEventParams.currencyCode);
                } catch (ClassCastException e) {
                    IMLogger.e(e.getMessage(), new Object[0]);
                }
                if (!T.ckIsEmpty(iMSDKStatEventParams.eventBody)) {
                    adjustEvent.setOrderId(iMSDKStatEventParams.eventBody);
                }
            }
            if (iMSDKStatEventParams.extraParams != null && !iMSDKStatEventParams.extraParams.isEmpty()) {
                for (Map.Entry<String, String> entry : iMSDKStatEventParams.extraParams.entrySet()) {
                    adjustEvent.addCallbackParameter(entry.getKey(), entry.getValue());
                }
            }
            Adjust.trackEvent(adjustEvent);
            return;
        }
        IMLogger.w("not support " + str, new Object[0]);
    }

    private void setAppSecret(AdjustConfig adjustConfig) {
        long appSecretConfig = getAppSecretConfig(IMSDK_ADJUST_SECRETID, -1L);
        if (appSecretConfig > 0) {
            long appSecretConfig2 = getAppSecretConfig(IMSDK_ADJUST_INFO1, -1L);
            long appSecretConfig3 = getAppSecretConfig(IMSDK_ADJUST_INFO2, -1L);
            long appSecretConfig4 = getAppSecretConfig(IMSDK_ADJUST_INFO3, -1L);
            long appSecretConfig5 = getAppSecretConfig(IMSDK_ADJUST_INFO4, -1L);
            IMLogger.d("set adjust app secret, secretId is : " + appSecretConfig + " info1 is : " + appSecretConfig2 + " info2 is : " + appSecretConfig3 + " info3 is : " + appSecretConfig4 + " info4 is : " + appSecretConfig5);
            try {
                adjustConfig.setAppSecret(appSecretConfig, appSecretConfig2, appSecretConfig3, appSecretConfig4, appSecretConfig5);
            } catch (Exception e) {
                IMLogger.e(e.getMessage(), new Object[0]);
            }
        }
    }

    private void setDeepLinking(AdjustConfig adjustConfig) {
        try {
            adjustConfig.setOnDeeplinkResponseListener(new OnDeeplinkResponseListener() { // from class: com.tencent.imsdk.android.stat.adjust.AdjustStat.1
                @Override // com.adjust.sdk.OnDeeplinkResponseListener
                public boolean launchReceivedDeeplink(Uri uri) {
                    try {
                        if (AdjustExtend.addDeferredDeepLink(uri)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("add adjust deep link : ");
                            sb.append(uri == null ? Constants.NULL_VERSION_ID : uri.toString());
                            IMLogger.i(sb.toString(), new Object[0]);
                        }
                        if (IMSDKConfig.getOrMetaData(AdjustStat.IMSDK_ADJUST_DEFERED_REATTRIBUTION, AdjustStat.IMSDK_ADJUST_DEFERED_REATTRIBUTION, false)) {
                            AdjustStat.this.appWillOpenUrlCompat(uri);
                        }
                    } catch (Exception e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("adjust open deep link ");
                        sb2.append(uri == null ? Constants.NULL_VERSION_ID : uri.toString());
                        sb2.append(" failed : ");
                        sb2.append(e.getMessage());
                        IMLogger.e(sb2.toString(), new Object[0]);
                    }
                    return IMSDKConfig.getOrMetaData(AdjustStat.IMSDK_ADJUST_LAUNCH_DEEP_LINKING, AdjustStat.IMSDK_ADJUST_LAUNCH_DEEP_LINKING, false);
                }
            });
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
    }

    private long getAppSecretConfig(String str, long j) {
        String orMetaData = IMSDKConfig.getOrMetaData(str, str, "");
        if (T.ckIsEmpty(orMetaData)) {
            return j;
        }
        try {
            return Long.valueOf(orMetaData.trim()).longValue();
        } catch (NumberFormatException e) {
            IMLogger.w("adjust secret info should be numeric string : " + e.getMessage(), new Object[0]);
            return j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appWillOpenUrlCompat(Uri uri) {
        try {
            try {
                Method method = Class.forName("com.adjust.sdk.Adjust").getMethod("appWillOpenUrl", Uri.class, Context.class);
                if (method != null) {
                    method.invoke(null, uri, this.mCtx);
                    return;
                }
            } catch (IllegalAccessException e) {
                IMLogger.e("IllegalAccessException : " + e.getMessage(), new Object[0]);
            } catch (NoSuchMethodException e2) {
                IMLogger.i("adjust sdk has newer version : " + e2.getMessage(), new Object[0]);
            } catch (InvocationTargetException e3) {
                IMLogger.e("InvocationTargetException : " + e3.getMessage(), new Object[0]);
            }
        } catch (ClassNotFoundException e4) {
            IMLogger.e("need adjust sdk : " + e4.getMessage(), new Object[0]);
        }
        Adjust.appWillOpenUrl(uri);
    }

    private String getAdjustSDKVersion() {
        try {
            Field field = Class.forName("com.adjust.sdk.Constants").getField("CLIENT_SDK");
            if (field == null) {
                return "";
            }
            Object obj = field.get(null);
            return obj instanceof String ? (String) obj : "";
        } catch (ClassNotFoundException e) {
            IMLogger.e("need adjust sdk : " + e.getMessage(), new Object[0]);
            return "";
        } catch (IllegalAccessException e2) {
            IMLogger.w("adjust sdk get version filed, IllegalAccessException : " + e2.getMessage(), new Object[0]);
            return "";
        } catch (NoSuchFieldException e3) {
            IMLogger.w("adjust sdk get version filed, NoSuchFieldException : " + e3.getMessage(), new Object[0]);
            return "";
        }
    }
}
