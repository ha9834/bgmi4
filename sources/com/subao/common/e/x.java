package com.subao.common.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static final int f6012a = 28;

    public static List<a> a(Context context, boolean z) {
        List<ApplicationInfo> installedApplications;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (installedApplications = packageManager.getInstalledApplications(0)) == null || installedApplications.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(installedApplications.size());
        for (ApplicationInfo applicationInfo : installedApplications) {
            if (z || (com.subao.common.e.a(applicationInfo.uid) && (applicationInfo.flags & 1) == 0)) {
                if (!com.subao.common.e.a(packageName, applicationInfo.packageName)) {
                    arrayList.add(new a(applicationInfo, applicationInfo.loadLabel(packageManager).toString(), a(packageManager, applicationInfo.packageName)));
                }
            }
        }
        return arrayList;
    }

    public static boolean a(PackageManager packageManager, String str) {
        String[] strArr;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 4096);
            if (packageInfo == null || (strArr = packageInfo.requestedPermissions) == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (str2 != null && str2.length() >= f6012a && str2.startsWith("com.subao.permission.USE_SDK")) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ApplicationInfo f6013a;
        private final String b;
        private final boolean c;

        public a(ApplicationInfo applicationInfo, String str, boolean z) {
            this.f6013a = applicationInfo;
            this.b = str;
            this.c = z;
        }

        public String a() {
            return this.f6013a.packageName;
        }

        public int b() {
            return this.f6013a.uid;
        }

        public String c() {
            return this.b;
        }
    }
}
