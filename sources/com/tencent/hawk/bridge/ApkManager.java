package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

/* loaded from: classes2.dex */
public class ApkManager {
    public static PackageInfo getPackageInfoByPackageName(Context context, String str) {
        PackageManager packageManager;
        List<PackageInfo> installedPackages;
        if (context == null || str == null || (packageManager = context.getPackageManager()) == null || (installedPackages = packageManager.getInstalledPackages(0)) == null) {
            return null;
        }
        for (PackageInfo packageInfo : installedPackages) {
            if (str.equals(packageInfo.applicationInfo.packageName)) {
                return packageInfo;
            }
        }
        return null;
    }
}
