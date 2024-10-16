package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdtv {

    /* renamed from: a, reason: collision with root package name */
    private static String f3627a;

    public static String zzbu(Context context) {
        String str = f3627a;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str2 = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("androidx.browser.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f3627a = null;
        } else if (arrayList.size() == 1) {
            f3627a = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str2) && !a(context, intent) && arrayList.contains(str2)) {
            f3627a = str2;
        } else if (arrayList.contains("com.android.chrome")) {
            f3627a = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            f3627a = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            f3627a = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            f3627a = "com.google.android.apps.chrome";
        }
        return f3627a;
    }

    private static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException unused) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
