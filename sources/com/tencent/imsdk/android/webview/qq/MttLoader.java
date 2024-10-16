package com.tencent.imsdk.android.webview.qq;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class MttLoader {
    private static final int BROWSER_MTT = 2;
    private static final int BROWSER_NONE = -1;
    private static final int BROWSER_QBX = 0;
    private static final int BROWSER_QBX5 = 1;

    @Deprecated
    public static final String KEY_ACTIVITY_NAME = "KEY_ACT";

    @Deprecated
    public static final String KEY_APP_NAME = "KEY_APPNAME";
    public static final String KEY_EUSESTAT = "KEY_EUSESTAT";

    @Deprecated
    public static final String KEY_PACKAGE = "KEY_PKG";
    public static final String KEY_PID = "KEY_PID";
    public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
    private static final String MTT_PACKAGE_MTT = "com.tencent.mtt";
    private static final String MTT_PACKAGE_MTT_X86 = "com.tencent.mtt.x86";
    private static final String MTT_PACKAGE_QBX = "com.tencent.qbx";
    private static final String MTT_PACKAGE_QBX5 = "com.tencent.qbx5";
    public static final String PID_MOBILE_QQ = "50079";
    public static final String PID_QQPIM = "50190";
    public static final String QQBROWSER_DOWNLOAD_URL = "http://mdc.html5.qq.com/mh?channel_id=21380&u=";
    public static final int RESULT_INVALID_CONTEXT = 3;
    public static final int RESULT_INVALID_URL = 2;
    public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
    public static final int RESULT_OK = 0;
    public static final int RESULT_QQBROWSER_LOW = 5;
    public static final int RESULT_UNKNOWN = 1;
    private static final int SUPPORT_3RD_PARTY_CALL_VERSION = 33;
    private static final int SUPPORT_QB_SCHEME_VERSION = 42;
    private static final int VERSION_420 = 420000;

    /* loaded from: classes.dex */
    public static class BrowserInfo {
        public int browserType = -1;
        public int ver = -1;
        public String quahead = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BrowserPackageInfo {
        public String classname;
        public String packagename;

        private BrowserPackageInfo() {
            this.classname = "";
            this.packagename = "";
        }
    }

    public static String getValidQBUrl(Context context, String str) {
        if (str.toLowerCase(Locale.getDefault()).startsWith("qb://")) {
            BrowserInfo browserInfo = getBrowserInfo(context);
            boolean z = true;
            if (browserInfo.browserType != -1 && (browserInfo.browserType != 2 || browserInfo.ver >= 33)) {
                z = false;
            }
            if (z) {
                return getDownloadUrlWithQb(str);
            }
        }
        return str;
    }

    public static String getDownloadUrlWithQb(String str) {
        try {
            return "http://mdc.html5.qq.com/mh?channel_id=21380&u=" + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "http://mdc.html5.qq.com/mh?channel_id=21380&u=";
        }
    }

    public static boolean isSupportQBScheme(Context context) {
        BrowserInfo browserInfo = getBrowserInfo(context);
        if (browserInfo.browserType == -1) {
            return false;
        }
        return browserInfo.browserType != 2 || browserInfo.ver >= 42;
    }

    public static int loadUrl(Activity activity, String str, HashMap<String, String> hashMap) {
        Set<String> keySet;
        if (activity == null) {
            return 3;
        }
        if (!hasValidProtocal(str)) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            if (parse.getScheme().toLowerCase(Locale.getDefault()).equals("qb") && !isSupportQBScheme(activity)) {
                parse = Uri.parse("http://mdc.html5.qq.com/mh?channel_id=21380&u=" + URLEncoder.encode(str, "UTF-8"));
            }
            BrowserInfo browserInfo = getBrowserInfo(activity);
            if (browserInfo.browserType == -1) {
                return 4;
            }
            if (browserInfo.browserType == 2 && browserInfo.ver < 33) {
                return 5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (browserInfo.browserType == 2) {
                if (browserInfo.ver >= 33 && browserInfo.ver <= 39) {
                    intent.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
                } else if (browserInfo.ver >= 40 && browserInfo.ver <= 45) {
                    intent.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                } else if (browserInfo.ver >= 46) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    BrowserPackageInfo chooseClassName = chooseClassName(activity, parse);
                    if (chooseClassName != null && !TextUtils.isEmpty(chooseClassName.classname)) {
                        intent.setClassName(chooseClassName.packagename, chooseClassName.classname);
                    }
                }
            } else if (browserInfo.browserType == 1) {
                if (browserInfo.ver == 1) {
                    intent.setClassName(MTT_PACKAGE_QBX5, "com.tencent.qbx5.MainActivity");
                } else if (browserInfo.ver == 2) {
                    intent.setClassName(MTT_PACKAGE_QBX5, "com.tencent.qbx5.SplashActivity");
                }
            } else if (browserInfo.browserType == 0) {
                if (browserInfo.ver >= 4 && browserInfo.ver <= 6) {
                    intent.setClassName(MTT_PACKAGE_QBX, "com.tencent.qbx.SplashActivity");
                } else if (browserInfo.ver > 6) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    BrowserPackageInfo chooseClassName2 = chooseClassName(activity, parse);
                    if (chooseClassName2 != null && !TextUtils.isEmpty(chooseClassName2.classname)) {
                        intent.setClassName(chooseClassName2.packagename, chooseClassName2.classname);
                    }
                }
            } else {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                BrowserPackageInfo chooseClassName3 = chooseClassName(activity, parse);
                if (chooseClassName3 != null && !TextUtils.isEmpty(chooseClassName3.classname)) {
                    intent.setClassName(chooseClassName3.packagename, chooseClassName3.classname);
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
                activity.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException unused) {
                return 4;
            }
        } catch (Exception unused2) {
            return 2;
        }
    }

    private static BrowserPackageInfo chooseClassName(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        BrowserPackageInfo browserPackageInfo = new BrowserPackageInfo();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains("com.tencent.mtt")) {
                browserPackageInfo.classname = resolveInfo.activityInfo.name;
                browserPackageInfo.packagename = resolveInfo.activityInfo.packageName;
                return browserPackageInfo;
            }
            if (str.contains(MTT_PACKAGE_QBX)) {
                browserPackageInfo.classname = resolveInfo.activityInfo.name;
                browserPackageInfo.packagename = resolveInfo.activityInfo.packageName;
            }
        }
        return browserPackageInfo;
    }

    public static BrowserInfo getBrowserInfo(Context context) {
        BrowserInfo browserInfo = new BrowserInfo();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                browserInfo.browserType = 2;
                browserInfo.quahead = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > VERSION_420) {
                    browserInfo.ver = packageInfo.versionCode;
                    browserInfo.quahead += packageInfo.versionName.replaceAll("\\.", "");
                    return browserInfo;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            try {
                try {
                    try {
                        try {
                            try {
                                packageInfo = packageManager.getPackageInfo(MTT_PACKAGE_QBX, 0);
                                browserInfo.browserType = 0;
                                browserInfo.quahead = "ADRQBX_";
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            BrowserPackageInfo chooseClassName = chooseClassName(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=21380&u="));
                            if (chooseClassName != null && !TextUtils.isEmpty(chooseClassName.packagename)) {
                                PackageInfo packageInfo2 = packageManager.getPackageInfo(chooseClassName.packagename, 0);
                                try {
                                    browserInfo.browserType = 2;
                                    browserInfo.quahead = "ADRQB_";
                                    packageInfo = packageInfo2;
                                } catch (Exception unused4) {
                                    packageInfo = packageInfo2;
                                }
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused5) {
                        packageInfo = packageManager.getPackageInfo(MTT_PACKAGE_QBX5, 0);
                        browserInfo.browserType = 1;
                        browserInfo.quahead = "ADRQBX5_";
                    }
                } catch (PackageManager.NameNotFoundException unused6) {
                    packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                    browserInfo.browserType = 2;
                    browserInfo.quahead = "ADRQB_";
                }
            } catch (PackageManager.NameNotFoundException unused7) {
                packageInfo = packageManager.getPackageInfo(MTT_PACKAGE_MTT_X86, 0);
                browserInfo.browserType = 2;
                browserInfo.quahead = "ADRQB_";
            }
            if (packageInfo != null) {
                browserInfo.ver = packageInfo.versionCode;
                browserInfo.quahead += packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception unused8) {
        }
        return browserInfo;
    }

    private static boolean hasValidProtocal(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase(Locale.getDefault()).indexOf("://");
        int indexOf2 = trim.toLowerCase(Locale.getDefault()).indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            return trim.toLowerCase(Locale.getDefault()).contains("://");
        }
        return false;
    }

    public static boolean isBrowserInstalled(Context context) {
        return getBrowserInfo(context).browserType != -1;
    }
}
