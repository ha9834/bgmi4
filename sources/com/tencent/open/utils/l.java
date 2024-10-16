package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import com.adjust.sdk.Constants;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.nearby.messages.Message;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.open.log.SLog;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.uqm.crashsight.CrashSight;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static String f6411a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static int e = -1;
    private static String f = "0123456789ABCDEF";

    private static char a(int i) {
        int i2 = i & 15;
        return i2 < 10 ? (char) (i2 + 48) : (char) ((i2 - 10) + 97);
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] a2 = a(str2, "=");
                if (a2.length == 2) {
                    bundle.putString(URLDecoder.decode(a2[0]), URLDecoder.decode(a2[1]));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    try {
                        try {
                            split[0] = URLDecoder.decode(split[0]);
                            split[1] = URLDecoder.decode(split[1]);
                        } catch (JSONException e2) {
                            SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                        }
                    } catch (Exception unused) {
                    }
                    jSONObject.put(split[0], split[1]);
                }
            }
        }
        return jSONObject;
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle a2 = a(url.getQuery());
            a2.putAll(a(url.getRef()));
            return a2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject a2 = a((JSONObject) null, url.getQuery());
            a(a2, url.getRef());
            return a2;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals(CrashSight.SDK_IS_DEV)) {
            str = "{value : false}";
        }
        if (str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(TbsConfig.APP_QB, 64);
            String str = packageInfo.versionName;
            if (j.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                    messageDigest.update(signatureArr[0].toByteArray());
                    String a2 = a(messageDigest.digest());
                    messageDigest.reset();
                    if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        boolean z;
        try {
            z = g(context);
        } catch (Exception unused) {
            z = false;
        }
        try {
            if (z) {
                a(context, TbsConfig.APP_QB, "com.tencent.mtt.MainActivity", str);
            } else {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
            }
            return true;
        } catch (Exception unused2) {
            if (z) {
                try {
                    try {
                        try {
                            a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        } catch (Exception unused3) {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (Exception unused4) {
                        return false;
                    }
                } catch (Exception unused5) {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                }
            }
            try {
                try {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                } catch (Exception unused6) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            } catch (Exception unused7) {
                return false;
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e2);
            return "";
        }
    }

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(j(str));
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(a(b2 >>> 4));
                sb.append(a(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            String num = Integer.toString(b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final boolean h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static boolean i(String str) {
        return str != null && new File(str).exists();
    }

    public static final String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return true;
        }
        if ((Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo.length == 0) {
            return true;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString(com.tencent.connect.common.Constants.PARAM_PLATFORM, "1");
        return bundle;
    }

    public static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            b = packageInfo.versionName;
            f6411a = b.substring(0, b.lastIndexOf(46));
            d = b.substring(b.lastIndexOf(46) + 1, b.length());
            e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (Exception e3) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f6411a;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        c = d(context, str);
        return c;
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e2);
            return new byte[0];
        }
    }

    public static boolean c(Context context) {
        double d2;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return d2 > 6.5d;
    }

    public static boolean f(Context context, String str) {
        boolean z = !c(context) || j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && j.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        if (z && j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        return z ? j.c(context, str) < 0 : z;
    }

    public static boolean g(Context context, String str) {
        boolean z = !c(context) || j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        return z ? j.c(context, str) < 0 : z;
    }

    public static boolean a(Context context, boolean z) {
        return (c(context) && j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) || j.c(context, "4.1") >= 0 || j.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null || j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    public static boolean d(Context context) {
        return j.c(context, "8.1.5") >= 0;
    }

    public static boolean e(Context context) {
        return j.c(context, "8.1.8") >= 0;
    }

    public static boolean f(Context context) {
        return j.c(context, "5.9.5") >= 0 || j.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    public static long a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        if (query != null) {
            try {
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.Util", "cursor exception", e2);
            }
            if (query.getCount() != 0) {
                try {
                    try {
                        r0 = query.moveToFirst() ? query.getLong(query.getColumnIndexOrThrow("_size")) : 0L;
                        query.close();
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.Util", "cursor exception", e3);
                        query.close();
                    }
                    return r0;
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.Util", "cursor exception", e4);
                    }
                    throw th;
                }
            }
        }
        return 0L;
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            }
            if (!"com.android.providers.media.documents".equals(authority)) {
                return null;
            }
            String[] split2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
            String str2 = split2[0];
            if ("image".equals(str2)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str2)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                if (!"audio".equals(str2)) {
                    return null;
                }
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
        }
        String scheme = uri.getScheme();
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            return c(context, uri);
        }
        if (TransferTable.COLUMN_FILE.equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r9, android.net.Uri r10) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.l.c(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(a(str.getBytes(), "JCPTZXEZ"), 3);
    }

    private static byte[] a(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr2[i] = (byte) (bArr[i] ^ charArray[i % charArray.length]);
                }
                return bArr2;
            } catch (Throwable th) {
                SLog.e("Util", "xor Exception! ", th);
            }
        }
        return bArr;
    }

    public static String l(String str) {
        return a(str, 2);
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), i);
        } catch (UnsupportedEncodingException e2) {
            SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable a(String str, Context context) {
        InputStream inputStream;
        String str2;
        StringBuilder sb;
        Drawable drawable = null;
        if (context == null) {
            SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    drawable = Drawable.createFromStream(inputStream, str);
                } catch (IOException e2) {
                    e = e2;
                    SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        str2 = "openSDK_LOG.Util";
                        sb = new StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        SLog.e(str2, sb.toString());
                        return drawable;
                    }
                    return drawable;
                }
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    str2 = "openSDK_LOG.Util";
                    sb = new StringBuilder();
                    sb.append("inputStream close exception: ");
                    sb.append(e.getMessage());
                    SLog.e(str2, sb.toString());
                    return drawable;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    inputStream.close();
                } catch (Exception e5) {
                    SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e5.getMessage());
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            inputStream.close();
            throw th;
        }
        return drawable;
    }

    public static File h(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            File[] externalFilesDirs = context.getExternalFilesDirs(str);
            if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
                return null;
            }
            return externalFilesDirs[0];
        }
        return context.getExternalFilesDir(str);
    }

    public static String b() {
        File e2 = g.e();
        if (e2 == null) {
            return null;
        }
        if (!e2.exists()) {
            e2.mkdirs();
        }
        return e2.toString();
    }

    public static boolean c() {
        Context a2 = g.a();
        return a2 != null && a2.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", a2.getPackageName()) == 0;
    }

    public static File m(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                } else {
                    SLog.d("openSDK_LOG.Util", "createFile failed" + str);
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static boolean b(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return a(file, m(str2));
            } catch (IOException e2) {
                SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e2);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0057 -> B:25:0x00ad). Please report as a decompilation issue!!! */
    public static boolean a(File file, File file2) {
        FileOutputStream fileOutputStream;
        int read;
        FileOutputStream fileOutputStream2;
        boolean z = false;
        FileOutputStream fileOutputStream3 = null;
        FileOutputStream fileOutputStream4 = null;
        FileOutputStream fileOutputStream5 = null;
        fileOutputStream3 = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream((File) file2);
                    try {
                        file2 = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e2) {
                        e = e2;
                        file2 = 0;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        file2 = 0;
                    } catch (Throwable th) {
                        th = th;
                        file2 = 0;
                    }
                } catch (IOException e4) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e4);
                    fileOutputStream3 = "copyFile error, ";
                    file2 = "openSDK_LOG.Util";
                }
            } catch (IOException e5) {
                e = e5;
                file2 = 0;
            } catch (OutOfMemoryError e6) {
                e = e6;
                file2 = 0;
            } catch (Throwable th2) {
                th = th2;
                file2 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            byte[] bArr = new byte[Message.MAX_CONTENT_SIZE_BYTES];
            while (true) {
                read = file2.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            }
            z = true;
            try {
                fileOutputStream.close();
                fileOutputStream2 = read;
            } catch (IOException e7) {
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e7);
                fileOutputStream2 = "openSDK_LOG.Util";
            }
            file2.close();
            fileOutputStream3 = fileOutputStream2;
            file2 = file2;
        } catch (IOException e8) {
            e = e8;
            fileOutputStream4 = fileOutputStream;
            file2 = file2;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            fileOutputStream3 = fileOutputStream4;
            if (fileOutputStream4 != null) {
                try {
                    fileOutputStream4.close();
                    fileOutputStream3 = fileOutputStream4;
                } catch (IOException e9) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e9);
                    fileOutputStream3 = "openSDK_LOG.Util";
                }
            }
            if (file2 != 0) {
                file2.close();
                fileOutputStream3 = fileOutputStream3;
                file2 = file2;
            }
            return z;
        } catch (OutOfMemoryError e10) {
            e = e10;
            fileOutputStream5 = fileOutputStream;
            file2 = file2;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            fileOutputStream3 = fileOutputStream5;
            if (fileOutputStream5 != null) {
                try {
                    fileOutputStream5.close();
                    fileOutputStream3 = fileOutputStream5;
                } catch (IOException e11) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e11);
                    fileOutputStream3 = "openSDK_LOG.Util";
                }
            }
            if (file2 != 0) {
                file2.close();
                fileOutputStream3 = fileOutputStream3;
                file2 = file2;
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream3 = fileOutputStream;
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                } catch (IOException e12) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e12);
                }
            }
            if (file2 == 0) {
                throw th;
            }
            try {
                file2.close();
                throw th;
            } catch (IOException e13) {
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e13);
                throw th;
            }
        }
        return z;
    }

    public static boolean a(Context context, String str, String str2) {
        boolean b2;
        if (Build.VERSION.SDK_INT < 19) {
            b2 = context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0 ? b(str, str2) : false;
        } else {
            b2 = b(str, str2);
        }
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + b2);
        return b2;
    }

    public static boolean n(String str) {
        String b2 = b();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(b2) || !str.contains(b2)) ? false : true;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        String str3;
        try {
            boolean n = n(str2);
            SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + n + ",hasSDPermission=" + c());
            if (!n) {
                File a2 = g.a("Images");
                if (a2 != null) {
                    str3 = a2.getAbsolutePath() + File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    File cacheDir = g.a().getCacheDir();
                    if (cacheDir == null) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = b(absolutePath, str4) ? str4 : null;
            }
            Uri a3 = a(activity, str, str2);
            if (a3 == null) {
                return null;
            }
            return a3.toString();
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e2);
            return null;
        }
    }

    public static boolean a(Map<String, Object> map, String str, boolean z) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        }
        if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z;
        }
        Object obj = map.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        }
        if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        }
        Object obj = map.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public static Uri a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission(com.tencent.connect.common.Constants.PACKAGE_TIM, uriForFile, 3);
            activity.grantUriPermission(com.tencent.connect.common.Constants.PACKAGE_QQ_PAD, uriForFile, 3);
            activity.grantUriPermission(com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED, uriForFile, 3);
            return uriForFile;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e2);
            return null;
        }
    }
}
