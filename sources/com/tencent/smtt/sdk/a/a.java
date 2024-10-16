package com.tencent.smtt.sdk.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.drive.DriveFile;
import com.tencent.mtt.spcialcall.sdk.MttLoader;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.tencent.smtt.sdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0214a {

        /* renamed from: a, reason: collision with root package name */
        public int f6502a = -1;
        public int b = -1;
        public String c = "";
        public String d = "0";
        public String e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f6503a;
        public String b;

        private b() {
            this.f6503a = "";
            this.b = "";
        }
    }

    public static boolean a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        Set<String> keySet;
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                for (String str3 : keySet) {
                    String str4 = hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        intent.putExtra(str3, str4);
                    }
                }
            }
            new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            Uri a2 = a(context, str);
            if (a2 == null) {
                return false;
            }
            intent.setDataAndType(a2, "mtt/" + str2);
            intent.putExtra("loginType", d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Uri a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap) {
        boolean z;
        Set<String> keySet;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.setDataAndType(parse, "video/*");
        if (hashMap != null && (keySet = hashMap.keySet()) != null) {
            for (String str2 : keySet) {
                String str3 = hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", d(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|(3:7|8|(8:10|11|12|(1:14)|15|(1:17)(1:21)|18|19))|25|11|12|(0)|15|(0)(0)|18|19) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r4, java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.String> r6, java.lang.String r7, com.tencent.smtt.sdk.WebView r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L1d
            java.lang.String r3 = "com.tencent.mtt"
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r1)     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L1d
            int r2 = r2.versionCode     // Catch: java.lang.Throwable -> L1f
            r3 = 601000(0x92ba8, float:8.4218E-40)
            if (r2 <= r3) goto L1d
            r2 = 1
            goto L20
        L1d:
            r2 = 0
            goto L20
        L1f:
            r2 = 0
        L20:
            java.lang.String r3 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r5, r3)     // Catch: java.lang.Exception -> L2a
            if (r2 == 0) goto L29
            r5 = r1
        L29:
            r1 = r2
        L2a:
            if (r1 == 0) goto L2f
            java.lang.String r1 = ",encoded=1"
            goto L31
        L2f:
            java.lang.String r1 = ""
        L31:
            java.lang.String r2 = "mttbrowser://url="
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = ",product="
            r0.append(r5)
            java.lang.String r5 = "TBS"
            r0.append(r5)
            java.lang.String r5 = ",packagename="
            r0.append(r5)
            java.lang.String r5 = r4.getPackageName()
            r0.append(r5)
            java.lang.String r5 = ",from="
            r0.append(r5)
            r0.append(r7)
            java.lang.String r5 = ",version="
            r0.append(r5)
            java.lang.String r5 = "1.4.0.0001"
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            int r4 = a(r4, r5, r6, r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.a.a(android.content.Context, java.lang.String, java.util.HashMap, java.lang.String, com.tencent.smtt.sdk.WebView):int");
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        Set<String> keySet;
        if (context == null) {
            return 3;
        }
        if (!a(str)) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            C0214a a2 = a(context);
            if (a2.f6502a == -1) {
                return 4;
            }
            if (a2.f6502a == 2 && a2.b < 33) {
                return 5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (a2.f6502a == 2) {
                if (a2.b >= 33 && a2.b <= 39) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                } else if (a2.b >= 40 && a2.b <= 45) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                } else if (a2.b >= 46) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b a3 = a(context, parse);
                    if (a3 != null && !TextUtils.isEmpty(a3.f6503a)) {
                        intent.setClassName(a3.b, a3.f6503a);
                    }
                }
            } else if (a2.f6502a == 1) {
                if (a2.b == 1) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                } else if (a2.b == 2) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                }
            } else if (a2.f6502a == 0) {
                if (a2.b >= 4 && a2.b <= 6) {
                    intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                } else if (a2.b > 6) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b a4 = a(context, parse);
                    if (a4 != null && !TextUtils.isEmpty(a4.f6503a)) {
                        intent.setClassName(a4.b, a4.f6503a);
                    }
                }
            } else {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                b a5 = a(context, parse);
                if (a5 != null && !TextUtils.isEmpty(a5.f6503a)) {
                    intent.setClassName(a5.b, a5.f6503a);
                }
            }
            intent.setData(parse);
            if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                for (String str2 : keySet) {
                    String str3 = hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra(str2, str3);
                    }
                }
            }
            try {
                intent.putExtra("loginType", d(context));
                intent.addFlags(DriveFile.MODE_READ_ONLY);
                if (webView != null) {
                    intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                    intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                }
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException unused) {
                return 4;
            }
        } catch (Exception unused2) {
            return 2;
        }
    }

    private static int d(Context context) {
        String str = context.getApplicationInfo().processName;
        if (str.equals("com.tencent.mobileqq")) {
            return 13;
        }
        if (str.equals("com.qzone")) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals(TbsConfig.APP_WX) ? 24 : 26;
    }

    private static b a(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.f6503a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
                return bVar;
            }
            if (str.contains("com.tencent.qbx")) {
                bVar.f6503a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
            }
        }
        return bVar;
    }

    public static C0214a a(Context context) {
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        C0214a c0214a = new C0214a();
        if (z) {
            return c0214a;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                c0214a.f6502a = 2;
                c0214a.e = TbsConfig.APP_QB;
                c0214a.c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    c0214a.b = packageInfo.versionCode;
                    c0214a.c += packageInfo.versionName.replaceAll("\\.", "");
                    c0214a.d = packageInfo.versionName.replaceAll("\\.", "");
                    return c0214a;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            try {
                try {
                    try {
                        try {
                            try {
                                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                                c0214a.f6502a = 0;
                                c0214a.e = "com.tencent.qbx";
                                c0214a.c = "ADRQBX_";
                            } catch (PackageManager.NameNotFoundException unused2) {
                                packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                                c0214a.e = "com.tencent.mtt.x86";
                                c0214a.f6502a = 2;
                                c0214a.c = "ADRQB_";
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                            packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                            c0214a.e = TbsConfig.APP_QB;
                            c0214a.f6502a = 2;
                            c0214a.c = "ADRQB_";
                        }
                    } catch (PackageManager.NameNotFoundException unused4) {
                        packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                        c0214a.f6502a = 1;
                        c0214a.e = "com.tencent.qbx5";
                        c0214a.c = "ADRQBX5_";
                    }
                } catch (Exception unused5) {
                    b a2 = a(context, Uri.parse(MttLoader.QQBROWSER_DOWNLOAD_URL));
                    if (a2 != null && !TextUtils.isEmpty(a2.b)) {
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(a2.b, 0);
                        try {
                            c0214a.e = a2.b;
                            c0214a.f6502a = 2;
                            c0214a.c = "ADRQB_";
                            packageInfo = packageInfo2;
                        } catch (Exception unused6) {
                            packageInfo = packageInfo2;
                        }
                    }
                }
            } catch (Exception unused7) {
            }
            if (packageInfo != null) {
                c0214a.b = packageInfo.versionCode;
                c0214a.c += packageInfo.versionName.replaceAll("\\.", "");
                c0214a.d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception unused8) {
        }
        return c0214a;
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            return trim.toLowerCase().contains("://");
        }
        return false;
    }

    public static boolean b(Context context) {
        return a(context).f6502a != -1;
    }

    public static boolean c(Context context) {
        C0214a a2 = a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a2.d).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (a2.b >= 601500) {
            return true;
        }
        return z;
    }

    public static boolean a(Context context, long j, long j2) {
        boolean z = false;
        try {
            if (Long.valueOf(a(context).d).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (r5.b >= j2) {
            return true;
        }
        return z;
    }
}
