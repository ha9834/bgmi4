package com.gcloudsdk.apollo;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class ApolloVoiceUDID {
    private static Context mainContext;
    private static String sAppVersion;
    private static String sBrand;
    private static String sBundleId;
    private static String sModel;
    private static String sOsVersion;

    public static void SetContext(Context context) {
        mainContext = context;
    }

    public static String BundleID() {
        String str = sBundleId;
        if (str != null) {
            return str;
        }
        Context context = mainContext;
        if (context != null) {
            try {
                sBundleId = context.getPackageName();
            } catch (Exception e) {
                ApolloVoiceLog.LogE("GetBundleId Exception: " + e);
            }
        }
        if (sBundleId == null) {
            sBundleId = "Unknown";
        }
        return sBundleId;
    }

    public static String Model() {
        String str = sModel;
        if (str != null) {
            return str;
        }
        sModel = ApolloVoiceEngine.GetDeviceModel();
        ApolloVoiceLog.LogI("Get model : " + sModel);
        if (sModel == null) {
            sModel = "Unknown";
        }
        return sModel;
    }

    public static String Brand() {
        String str = sBrand;
        if (str != null) {
            return str;
        }
        sBrand = ApolloVoiceEngine.GetDeviceBrand();
        ApolloVoiceLog.LogI("Get brand : " + sBrand);
        if (sBrand == null) {
            sBrand = "Unknown";
        }
        return sBrand;
    }

    public static String OSVersion() {
        String str = sOsVersion;
        if (str != null) {
            return str;
        }
        sOsVersion = Build.VERSION.RELEASE;
        if (sOsVersion == null) {
            sOsVersion = "Unknown";
        }
        return sOsVersion;
    }

    public static String AppVersion() {
        String str = sAppVersion;
        if (str != null) {
            return str;
        }
        Context context = mainContext;
        if (context != null) {
            try {
                sAppVersion = context.getPackageManager().getPackageInfo(mainContext.getPackageName(), 1).versionName;
            } catch (Exception e) {
                ApolloVoiceLog.LogE("GetAppVersion Exception: " + e);
            }
        }
        if (sAppVersion == null) {
            sAppVersion = "Unknown";
        }
        return sAppVersion;
    }
}
