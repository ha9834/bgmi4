package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class QbSdk {
    public static final String FILERADER_MENUDATA = "menuData";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final int QBMODE = 2;
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean b = false;
    static boolean c = false;
    static long d = 0;
    static long e = 0;
    private static String m = "";
    private static boolean n = false;
    private static String o = "UNKNOWN";
    static Object f = new Object();
    public static boolean isDefaultDialog = false;
    private static boolean p = false;
    static boolean g = true;
    static boolean h = true;
    static boolean i = false;
    private static String q = null;
    private static String r = null;

    /* renamed from: a, reason: collision with root package name */
    static boolean f6432a = false;
    static volatile boolean j = f6432a;
    private static boolean s = true;
    private static TbsListener t = null;
    private static TbsListener u = null;
    private static boolean v = false;
    private static boolean w = false;
    static TbsListener k = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.5
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i2) {
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i2) {
            if (QbSdk.t != null) {
                QbSdk.t.onInstallFinish(i2);
            }
            if (QbSdk.u != null) {
                QbSdk.u.onInstallFinish(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i2) {
            if (QbSdk.u != null) {
                QbSdk.u.onDownloadProgress(i2);
            }
            if (QbSdk.t != null) {
                QbSdk.t.onDownloadProgress(i2);
            }
        }
    };
    public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    static Map<String, Object> l = null;

    /* loaded from: classes2.dex */
    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static boolean a(Context context) {
        return false;
    }

    static boolean a(Context context, boolean z, boolean z2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b() {
        return null;
    }

    public static boolean canLoadVideo(Context context) {
        return false;
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        return false;
    }

    public static boolean canOpenWebPlus(Context context) {
        return false;
    }

    public static boolean canUseVideoFeatrue(Context context, int i2) {
        return false;
    }

    public static void clear(Context context) {
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        return false;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        return false;
    }

    public static void disableAutoCreateX5Webview() {
    }

    public static long getApkFileSize(Context context) {
        return 0L;
    }

    public static String getMiniQBVersion(Context context) {
        return null;
    }

    public static int getTbsSdkVersion() {
        return 43799;
    }

    public static int getTbsVersion(Context context) {
        return 0;
    }

    public static int getTbsVersionForCrash(Context context) {
        return 0;
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        return false;
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        return false;
    }

    public static boolean isX5DisabledSync(Context context) {
        return true;
    }

    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        return -100;
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, android.webkit.ValueCallback<String> valueCallback) {
        return PresenterCode.Code_Encoder_PkgReqBody_Error;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        return false;
    }

    public static boolean useSoftWare() {
        return false;
    }

    public static boolean startQBToLoadurl(Context context, String str, int i2, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return com.tencent.smtt.sdk.a.a.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQBForVideo(Context context, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return com.tencent.smtt.sdk.a.a.a(context, str, (HashMap<String, String>) hashMap);
    }

    public static boolean startQBForDoc(Context context, String str, int i2, int i3, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return com.tencent.smtt.sdk.a.a.a(context, str, i3, str2, hashMap, bundle);
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(Context context, boolean z) {
        TbsLog.initIfNeed(context);
        return false;
    }

    public static void setOnlyDownload(boolean z) {
        i = z;
    }

    public static boolean getOnlyDownload() {
        return i;
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !a(context, false) ? false : false;
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            q = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static String getTID() {
        return q;
    }

    public static void setQQBuildNumber(String str) {
        r = str;
    }

    public static String getQQBuildNumber() {
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (f6432a) {
                TbsLog.d("QbSdk", "already forced: " + o);
                return;
            }
            f6432a = true;
            o = "forceSysWebViewInner: " + str;
            TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + o);
            TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(o));
        }
    }

    public static void forceSysWebView() {
        b = true;
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.smtt.sdk.QbSdk$1] */
    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                r a2 = r.a();
                a2.a(context, null);
                final boolean a3 = r.b() ? a2.c().a(context, str) : false;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        valueCallback.onReceiveValue(Boolean.valueOf(a3));
                    }
                });
            }
        }.start();
    }

    public static void closeFileReader(Context context) {
        r a2 = r.a();
        a2.a(context, null);
        if (r.b()) {
            a2.c().m();
        }
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static String getCurrentProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static synchronized void preInit(final Context context, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
            TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            j = f6432a;
            if (!n) {
                final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        s c2;
                        switch (message.what) {
                            case 1:
                                if (QbSdk.h && (c2 = r.a().c()) != null) {
                                    c2.a(context);
                                }
                                PreInitCallback preInitCallback2 = preInitCallback;
                                if (preInitCallback2 != null) {
                                    preInitCallback2.onViewInitFinished(true);
                                }
                                TbsLog.writeLogToDisk();
                                return;
                            case 2:
                                PreInitCallback preInitCallback3 = preInitCallback;
                                if (preInitCallback3 != null) {
                                    preInitCallback3.onViewInitFinished(false);
                                }
                                TbsLog.writeLogToDisk();
                                return;
                            case 3:
                                PreInitCallback preInitCallback4 = preInitCallback;
                                if (preInitCallback4 != null) {
                                    preInitCallback4.onCoreInitFinished();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        int a2 = j.a().a(true, context);
                        TbsLog.i("QbSdk", "QbSdk preinit ver is " + a2);
                        if (a2 == 0) {
                            j.a().a(context, true);
                        }
                        handler.sendEmptyMessage(2);
                    }
                };
                thread.setName("tbs_preinit");
                thread.setPriority(10);
                thread.start();
                n = true;
            }
        }
    }

    public static boolean isTbsCoreInited() {
        c a2 = c.a(false);
        return a2 != null && a2.f();
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        if (context == null) {
            TbsLog.e("QbSdk", "initX5Environment,context=null");
            return;
        }
        a(context);
        u = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.4
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i2) {
                QbSdk.preInit(context, preInitCallback);
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            j.a().a(context, c.f6514a == 0);
        }
        preInitCallback.onCoreInitFinished();
        preInitCallback.onViewInitFinished(false);
    }

    public static void setTbsListener(TbsListener tbsListener) {
        t = tbsListener;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        v = z;
    }

    public static boolean getDownloadWithoutWifi() {
        return v;
    }

    public static void setTBSInstallingStatus(boolean z) {
        w = z;
    }

    public static boolean getTBSInstalling() {
        return w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return m;
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    public static void reset(Context context, boolean z) {
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        if (z) {
            try {
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    j.a().a(context);
                    j.a().b(context);
                }
            } catch (Throwable th) {
                TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
                return;
            }
        }
        com.tencent.smtt.utils.b.a(getTbsFolderDir(context), false, "core_share_decouple");
        TbsLog.i("QbSdk", "delete downloaded apk success", true);
        j.f6525a.set(0);
        File file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void clearAllWebViewCache(android.content.Context r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.clearAllWebViewCache(android.content.Context, boolean):void");
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i2) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i2, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static boolean checkContentProviderPrivilage(Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 24 || Build.VERSION.SDK_INT < 24 || "com.tencent.mobileqq".equals(context.getApplicationInfo().packageName)) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "androidx.core.content.FileProvider"), 0).authority)) {
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getApplicationInfo().packageName + ".provider", 128);
        if (resolveContentProvider == null) {
            Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
        return resolveContentProvider != null;
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, Bundle bundle, ValueCallback<String> valueCallback) {
        if (context == null || context.getApplicationInfo().packageName.equals(Constants.PACKAGE_QIM) || context.getApplicationInfo().packageName.equals(Constants.PACKAGE_TIM) || context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
        }
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isSuportOpenFile(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {"rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        String[] strArr2 = {"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub"};
        switch (i2) {
            case 1:
                return Arrays.asList(strArr2).contains(str.toLowerCase());
            case 2:
                return Arrays.asList(strArr).contains(str.toLowerCase());
            default:
                return false;
        }
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    public static void openBrowserList(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        if (context == null) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(str));
        String c2 = com.tencent.smtt.sdk.b.a.d.c(str);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, c2, string);
        String a2 = cVar.a();
        if (a2 != null && !TextUtils.isEmpty(a2)) {
            if (TbsConfig.APP_QB.equals(a2)) {
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
            }
            intent.setPackage(a2);
            intent.putExtra("big_brother_source_key", string);
            context.startActivity(intent);
            if (valueCallback != null) {
                valueCallback.onReceiveValue("default browser:" + a2);
                return;
            }
            return;
        }
        if (isDefaultDialog) {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
            if (valueCallback != null) {
                valueCallback.onReceiveValue("can not open");
                return;
            }
            return;
        }
        cVar.show();
        cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ValueCallback valueCallback2 = ValueCallback.this;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                }
            }
        });
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Map<String, Object> map2 = l;
        if (map2 == null) {
            l = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Map<String, Object> getSettings() {
        return l;
    }

    public static boolean isNeedInitX5FirstTime() {
        return p;
    }

    public static File getTbsFolderDir(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (com.tencent.smtt.utils.a.a()) {
                return context.getDir("tbs_64", 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return context.getDir("tbs", 0);
    }
}
