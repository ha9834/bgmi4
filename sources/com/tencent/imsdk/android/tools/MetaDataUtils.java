package com.tencent.imsdk.android.tools;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class MetaDataUtils {
    public static String readFromApplication(Context context, String str, String str2) {
        PackageManager packageManager;
        if (context == null) {
            context = IMSDKContext.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return str2;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            return ((PackageItemInfo) applicationInfo).metaData != null ? ((PackageItemInfo) applicationInfo).metaData.getString(str, str2) : str2;
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return str2;
        }
    }

    public static boolean readFromApplication(Context context, String str, boolean z) {
        PackageManager packageManager;
        if (context == null) {
            context = IMSDKContext.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return z;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            return ((PackageItemInfo) applicationInfo).metaData != null ? ((PackageItemInfo) applicationInfo).metaData.getBoolean(str, z) : z;
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return z;
        }
    }

    public static int readFromApplication(Context context, String str, int i) {
        PackageManager packageManager;
        if (context == null) {
            context = IMSDKContext.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return i;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            return ((PackageItemInfo) applicationInfo).metaData != null ? ((PackageItemInfo) applicationInfo).metaData.getInt(str, i) : i;
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return i;
        }
    }

    public static String readFromActivity(Context context, String str, String str2) {
        if (context == null) {
            context = IMSDKContext.getAppContext();
        }
        if (context == null) {
            return str2;
        }
        PackageManager packageManager = context.getPackageManager();
        if (!(context instanceof Activity)) {
            return str2;
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(((Activity) context).getComponentName(), 128);
            return ((PackageItemInfo) activityInfo).metaData != null ? ((PackageItemInfo) activityInfo).metaData.getString(str, str2) : str2;
        } catch (Exception e) {
            IMLogger.w(e.getMessage(), new Object[0]);
            return str2;
        }
    }
}
