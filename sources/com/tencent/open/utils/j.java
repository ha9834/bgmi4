package com.tencent.open.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.webkit.WebSettings;
import com.adjust.sdk.Constants;
import com.tencent.open.log.SLog;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class j {
    public static String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        return split2.length > i ? -1 : 0;
    }

    public static boolean a(Context context, String str, String str2) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (l.g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String b(Context context, String str) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            String a2 = l.a(messageDigest.digest());
            messageDigest.reset();
            SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a2);
            messageDigest.update(l.j(packageName + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + a2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + ""));
            str2 = l.a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            SLog.v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static String a(Activity activity, String str) {
        if (activity == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] a2 = e.a(str);
            if (a2 == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(a2, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(a2, 8, bArr2, 0, 16);
            return e.a(activity.getPackageName(), e.a(bArr2), bArr);
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static boolean a(Context context, Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, com.tencent.connect.common.Constants.PACKAGE_TIM), str);
    }

    public static int e(Context context, String str) {
        return a(a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.lang.String r9, java.lang.String r10, int r11) {
        /*
            java.lang.String r0 = "openSDK_LOG.SystemUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "-->extractSecureLib, libName: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.tencent.open.log.SLog.i(r0, r1)
            android.content.Context r0 = com.tencent.open.utils.g.a()
            r1 = 0
            if (r0 != 0) goto L25
            java.lang.String r9 = "openSDK_LOG.SystemUtils"
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            com.tencent.open.log.SLog.i(r9, r10)
            return r1
        L25:
            java.lang.String r2 = "secure_lib"
            android.content.SharedPreferences r2 = r0.getSharedPreferences(r2, r1)
            java.io.File r3 = new java.io.File
            java.io.File r4 = r0.getFilesDir()
            r3.<init>(r4, r10)
            boolean r4 = r3.exists()
            r5 = 1
            if (r4 != 0) goto L50
            java.io.File r4 = r3.getParentFile()
            if (r4 == 0) goto L77
            boolean r4 = r4.mkdirs()
            if (r4 == 0) goto L77
            r3.createNewFile()     // Catch: java.io.IOException -> L4b
            goto L77
        L4b:
            r3 = move-exception
            r3.printStackTrace()
            goto L77
        L50:
            java.lang.String r3 = "version"
            int r3 = r2.getInt(r3, r1)
            java.lang.String r4 = "openSDK_LOG.SystemUtils"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "-->extractSecureLib, libVersion: "
            r6.append(r7)
            r6.append(r11)
            java.lang.String r7 = " | oldVersion: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            com.tencent.open.log.SLog.i(r4, r6)
            if (r11 != r3) goto L77
            return r5
        L77:
            r3 = 0
            android.content.res.AssetManager r4 = r0.getAssets()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            java.io.InputStream r9 = r4.open(r9)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            java.io.FileOutputStream r3 = r0.openFileOutput(r10, r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            a(r9, r3)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            android.content.SharedPreferences$Editor r10 = r2.edit()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r0 = "version"
            r10.putInt(r0, r11)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r10.commit()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r9 == 0) goto L9a
            r9.close()     // Catch: java.io.IOException -> L99
            goto L9a
        L99:
        L9a:
            if (r3 == 0) goto L9f
            r3.close()     // Catch: java.io.IOException -> L9f
        L9f:
            return r5
        La0:
            r10 = move-exception
            goto Lc4
        La2:
            r10 = move-exception
            r8 = r3
            r3 = r9
            r9 = r8
            goto Lac
        La7:
            r10 = move-exception
            r9 = r3
            goto Lc4
        Laa:
            r10 = move-exception
            r9 = r3
        Lac:
            java.lang.String r11 = "openSDK_LOG.SystemUtils"
            java.lang.String r0 = "-->extractSecureLib, when copy lib execption."
            com.tencent.open.log.SLog.e(r11, r0, r10)     // Catch: java.lang.Throwable -> Lc0
            if (r3 == 0) goto Lba
            r3.close()     // Catch: java.io.IOException -> Lb9
            goto Lba
        Lb9:
        Lba:
            if (r9 == 0) goto Lbf
            r9.close()     // Catch: java.io.IOException -> Lbf
        Lbf:
            return r1
        Lc0:
            r10 = move-exception
            r8 = r3
            r3 = r9
            r9 = r8
        Lc4:
            if (r9 == 0) goto Lcb
            r9.close()     // Catch: java.io.IOException -> Lca
            goto Lcb
        Lca:
        Lcb:
            if (r3 == 0) goto Ld0
            r3.close()     // Catch: java.io.IOException -> Ld0
        Ld0:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.j.a(java.lang.String, java.lang.String, int):boolean");
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    public static int a(String str) {
        if ("shareToQQ".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_QQ_SHARE;
        }
        if ("shareToQzone".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_QZONE_SHARE;
        }
        if ("addToQQFavorites".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_LOGIN;
        }
        if ("action_request".equals(str)) {
            return com.tencent.connect.common.Constants.REQUEST_API;
        }
        return -1;
    }

    public static boolean b(Context context) {
        boolean f = f(context, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + f);
        return f;
    }

    public static boolean c(Context context) {
        boolean f = f(context, "com.tencent.mobileqq");
        boolean f2 = f(context, com.tencent.connect.common.Constants.PACKAGE_TIM);
        boolean f3 = f(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD);
        boolean f4 = f(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED);
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq=" + f + ", tim=" + f2 + ", pad=" + f3 + ", speed=" + f4);
        return f || f2 || f3 || f4;
    }

    private static boolean f(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            SLog.e("openSDK_LOG.SystemUtils", "PackageManager.NameNotFoundException " + str, e);
            return false;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
            return false;
        }
    }

    public static String a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
            return null;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
            return null;
        }
    }

    public static boolean d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !a();
    }

    private static boolean a() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException unused) {
            return false;
        } catch (NoSuchMethodException unused2) {
            return false;
        } catch (InvocationTargetException unused3) {
            return false;
        }
    }

    public static void a(WebSettings webSettings) {
        try {
            webSettings.setSavePassword(false);
            webSettings.setAllowFileAccess(false);
            if (Build.VERSION.SDK_INT >= 16) {
                webSettings.setAllowFileAccessFromFileURLs(false);
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e);
        }
    }
}
