package com.uqm.crashsight.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.uqm.crashsight.CrashModule;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.b;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.crashreport.crash.CrashSightBroadcastReceiver;
import com.uqm.crashsight.crashreport.crash.c;
import com.uqm.crashsight.crashreport.crash.d;
import com.uqm.crashsight.crashreport.crash.h5.H5JavaScriptInterface;
import com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler;
import com.uqm.crashsight.proguard.e;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.n;
import com.uqm.crashsight.proguard.q;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class CrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static Context f6547a = null;
    private static int b = 65536;

    /* loaded from: classes.dex */
    public static class CrashHandleCallback extends CrashSightStrategy.a {
    }

    /* loaded from: classes.dex */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        return false;
    }

    public static void enableCrashSight(boolean z) {
        b.f6546a = z;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f6547a = context;
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f6547a = context;
        b.a(CrashModule.getInstance());
        b.a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        if (context != null) {
            f6547a = context;
            b.a(CrashModule.getInstance());
            b.a(context, str, z, null);
        }
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f6547a = context;
        b.a(CrashModule.getInstance());
        b.a(context, str, z, userStrategy);
    }

    public static void reRegistNativeReport() {
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.reStartNativeMonitor();
        } else {
            m.e("CrashSight not init", new Object[0]);
        }
    }

    public static String getCrashSightVersion(Context context) {
        if (context == null) {
            m.d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(context).c();
    }

    public static void testJavaCrash() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not test Java crash because crashSight is disable.");
        } else {
            if (!CrashModule.getInstance().hasInitialized()) {
                Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                return;
            }
            com.uqm.crashsight.crashreport.common.info.a b2 = com.uqm.crashsight.crashreport.common.info.a.b();
            if (b2 != null) {
                b2.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to CrashSight see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not test native crash because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            m.a("start to create a native crash for test!", new Object[0]);
            c.a().a(z, z2, z3);
        }
    }

    public static void testANRCrash() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not test ANR crash because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            m.a("start to create a anr crash for test!", new Object[0]);
            c.a().j();
        }
    }

    public static void testOomCrash() {
        NativeCrashHandler.getInstance().testNativeOomCrash();
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not post crash caught because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            d.a(thread, i, str, str2, str3, map);
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not post crash caught because crashSight is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            m.d("throwable is null, just return", new Object[0]);
        } else {
            c.a().a(thread == null ? Thread.currentThread() : thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void closeNativeReport() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not close native report because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            c.a().g();
        }
    }

    public static void startCrashReport() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not start crash report because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            c.a().c();
        }
    }

    public static void closeCrashReport() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not close crash report because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            c.a().d();
        }
    }

    public static void closeCrashSight() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not close crashSight because crashSight is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (f6547a == null) {
            return;
        }
        CrashSightBroadcastReceiver crashSightBroadcastReceiver = CrashSightBroadcastReceiver.getInstance();
        if (crashSightBroadcastReceiver != null) {
            crashSightBroadcastReceiver.unregister(f6547a);
        }
        closeCrashReport();
        com.uqm.crashsight.crashreport.biz.b.a(f6547a);
        k a2 = k.a();
        if (a2 != null) {
            a2.b();
        }
    }

    public static void setUserSceneTagStr(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set user scene tag str because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserSceneTagStr(f6547a, str);
        }
    }

    public static void setUserSceneTagStr(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set user scene tag caught because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.e(m.f6622a, "setUserSceneTagStr args context should not be null");
        } else if (str == null || str.length() == 0) {
            m.d("setUserSceneTagStr args userSceneTagStr is empty", new Object[0]);
        } else {
            com.uqm.crashsight.crashreport.common.info.a.a(context).h(str);
            m.b("[param] set user scene tag: %s", str);
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set tag caught because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.e(m.f6622a, "setTag args context should not be null");
            return;
        }
        if (i <= 0) {
            m.d("setTag args tagId should > 0", new Object[0]);
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).a(i);
        m.b("[param] set user scene tag: %d", Integer.valueOf(i));
    }

    public static void setUserSceneTag(int i) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set user scene tag because crashSight is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserSceneTag(f6547a, i);
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get user scene tag because crashSight is disable.");
            return -1;
        }
        if (context == null) {
            Log.e(m.f6622a, "getUserSceneTagId args context should not be null");
            return -1;
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(context).E();
    }

    public static String getUserData(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get user data because crashSight is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(m.f6622a, "getUserDataValue args context should not be null");
            return "unknown";
        }
        if (q.a(str)) {
            return null;
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(context).g(str);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not put user data because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.w(m.f6622a, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            String str3 = str;
            m.d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            String str4 = str2;
            m.d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 1000) {
            m.d("user data value length over limit %d, it will be cutted!", 1000);
            str2 = str2.substring(0, 1000);
        }
        com.uqm.crashsight.crashreport.common.info.a a2 = com.uqm.crashsight.crashreport.common.info.a.a(context);
        if (a2.A().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            com.uqm.crashsight.crashreport.common.info.a.a(context).b(str, str2);
            m.c("replace KV %s %s", str, str2);
            return;
        }
        if (a2.z() >= 10000) {
            m.d("user data size is over limit %d, it will be cutted!", 10000);
            return;
        }
        if (str.length() > 100) {
            m.d("user data key length over limit %d , will drop this new key %s", 100, str);
            str = str.substring(0, 100);
        }
        int length = b + str.length() + str2.length();
        b = length;
        if (length > 131072) {
            m.d("user data size is over limit %d, dropped", 131072);
            return;
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).b(str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not remove user data because crashSight is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(m.f6622a, "removeUserData args context should not be null");
            return "unknown";
        }
        if (q.a(str)) {
            return null;
        }
        m.b("[param] remove user data: %s", str);
        return com.uqm.crashsight.crashreport.common.info.a.a(context).f(str);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get all keys of user data because crashSight is disable.");
            return new HashSet();
        }
        if (context == null) {
            Log.e(m.f6622a, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(context).A();
    }

    public static int getUserDatasSize(Context context) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get size of user data because crashSight is disable.");
            return -1;
        }
        if (context == null) {
            Log.e(m.f6622a, "getUserDatasSize args context should not be null");
            return -1;
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(context).z();
    }

    public static String getAppID() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get App ID because crashSight is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(f6547a).f();
    }

    public static void setAppID(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App ID because crashSight is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
        com.uqm.crashsight.crashreport.common.info.a.a(f6547a).a(str);
        com.uqm.crashsight.crashreport.biz.b.f6555a.a(5, true, 0L);
    }

    public static void entrySubMap(String str) {
        postException(Thread.currentThread(), 1000, str, str, str, null);
    }

    public static void setUserId(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set user ID because crashSight is disable.");
            return;
        }
        Context context = f6547a;
        if (context == null) {
            m.d("CrashReport has not been initialed! but continue to set user id", new Object[0]);
            com.uqm.crashsight.crashreport.common.info.a.b(str);
        } else {
            setUserId(context, str);
        }
    }

    public static void setUserId(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set user ID because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.e(m.f6622a, "Context should not be null when crashSight has not been initialed!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            m.d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            m.d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context);
        if (str.equals(com.uqm.crashsight.crashreport.common.info.a.g())) {
            return;
        }
        com.uqm.crashsight.crashreport.common.info.a.b(str);
        m.b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            com.uqm.crashsight.crashreport.biz.b.a();
        }
    }

    public static String getUserId() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get user ID because crashSight is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        com.uqm.crashsight.crashreport.common.info.a.a(f6547a);
        return com.uqm.crashsight.crashreport.common.info.a.g();
    }

    public static String getAppVer() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get app version because crashSight is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(f6547a).k;
    }

    public static String getAppChannel() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get App channel because crashSight is disable.");
            return "unknown";
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(f6547a).m;
    }

    public static void setContext(Context context) {
        f6547a = context;
    }

    public static boolean isLastSessionCrash() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "The info 'isLastSessionCrash' is not accurate because crashSight is disable.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        }
        return c.a().b();
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not put SDK extra data because crashSight is disable.");
        } else {
            if (context == null || q.a(str) || q.a(str2)) {
                return;
            }
            com.uqm.crashsight.crashreport.common.info.a.a(context).a(str, str2);
        }
    }

    public static Map<String, String> getSdkExtraData() {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get SDK extra data because crashSight is disable.");
            return new HashMap();
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(f6547a).C;
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not get SDK extra data because crashSight is disable.");
            return new HashMap();
        }
        if (context == null) {
            m.d("Context should not be null.", new Object[0]);
            return null;
        }
        return com.uqm.crashsight.crashreport.common.info.a.a(context).C;
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || q.a(str) || q.a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(m.f6622a, String.format("putSdkData key length over limit %d, will be cutted.", 100));
            replace = replace.substring(0, 100);
        }
        if (str2.length() > 500) {
            Log.w(m.f6622a, String.format("putSdkData value length over limit %d, will be cutted!", 1000));
            str2 = str2.substring(0, 1000);
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).c(replace, str2);
        m.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void setIsAppForeground(boolean z) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set 'isAppForeground' because crashSight is disable.");
            return;
        }
        if (z) {
            m.c("App is in foreground.", new Object[0]);
        } else {
            m.c("App is in background.", new Object[0]);
        }
        com.uqm.crashsight.crashreport.common.info.a b2 = com.uqm.crashsight.crashreport.common.info.a.b();
        if (b2 != null) {
            b2.a(z);
        } else {
            l.d("setIsAppForeground failed: comInfoManager is null", new Object[0]);
        }
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set 'isAppForeground' because crashSight is disable.");
            return;
        }
        if (context == null) {
            m.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            m.c("App is in foreground.", new Object[0]);
        } else {
            m.c("App is in background.", new Object[0]);
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).a(z);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set 'isDevelopmentDevice' because crashSight is disable.");
            return;
        }
        if (context == null) {
            m.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            m.c("This is a development device.", new Object[0]);
        } else {
            m.c("This is not a development device.", new Object[0]);
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).A = z;
    }

    public static void setSessionIntervalMills(long j) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set 'SessionIntervalMills' because crashSight is disable.");
        } else {
            com.uqm.crashsight.crashreport.biz.b.a(j);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App version because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.w(m.f6622a, "setAppVersion args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(m.f6622a, "App version is null, will not set");
            return;
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).k = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setAppVersion(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set 'isAppForeground' because crashSight is disable.");
            return;
        }
        if (str == null) {
            m.e("set app version as null", new Object[0]);
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(m.f6622a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setAppVersion(f6547a, str);
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App channel because CrashSight is disable.");
            return;
        }
        if (context == null) {
            Log.w(m.f6622a, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(m.f6622a, "App channel is null, will not set");
            return;
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).m = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App package because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.w(m.f6622a, "setAppPackage args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(m.f6622a, "App package is null, will not set");
            return;
        }
        com.uqm.crashsight.crashreport.common.info.a.a(context).c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setCrashFilter(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App package because crashSight is disable.");
            return;
        }
        Log.i(m.f6622a, "Set crash stack filter: " + str);
        c.n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App package because crashSight is disable.");
            return;
        }
        Log.i(m.f6622a, "Set crash stack filter: " + str);
        c.o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set App package because crashSight is disable.");
            return;
        }
        Log.i(m.f6622a, "Should handle native crash in Java profile after handled in native profile: " + z);
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setCrashSightDbName(String str) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set DB name because crashSight is disable.");
            return;
        }
        Log.i(m.f6622a, "Set CrashSight DB name: " + str);
        e.f6613a = str;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!b.f6546a) {
            Log.w(m.f6622a, "Can not set DB name because crashSight is disable.");
            return;
        }
        if (context == null) {
            Log.w(m.f6622a, "enableObtainId args context should not be null");
            return;
        }
        Log.i(m.f6622a, "Enable identification obtaining? " + z);
        com.uqm.crashsight.crashreport.common.info.a.a(context).b(z);
    }

    public static void setServerUrl(String str) {
        if (q.a(str) || !q.c(str)) {
            Log.i(m.f6622a, "URL is invalid.");
            return;
        }
        com.uqm.crashsight.crashreport.common.strategy.a.a(str);
        StrategyBean.f6574a = str;
        StrategyBean.b = str;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static void setHttpProxy(String str, int i) {
        n.a(str, i);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        n.a(inetAddress, i);
    }

    public static Proxy getHttpProxy() {
        return n.a();
    }

    /* loaded from: classes.dex */
    public static class UserStrategy extends CrashSightStrategy {
        private CrashHandleCallback d;

        public UserStrategy(Context context) {
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized void setCallBackType(int i) {
            this.f6545a = i;
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized int getCallBackType() {
            return this.f6545a;
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized void setCrashHandleTimeout(int i) {
            this.c = i;
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized int getCrashHandleTimeout() {
            return this.c;
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.b = z;
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.b;
        }

        @Override // com.uqm.crashsight.CrashSightStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.d;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.d = crashHandleCallback;
        }
    }

    public static void setSessionUUID(String str) {
        com.uqm.crashsight.crashreport.common.info.b.a().a(str);
    }

    public static void setTraceUUID(String str) {
        com.uqm.crashsight.crashreport.common.info.b.a().b(str);
    }

    public static void setMatchUUID(String str) {
        com.uqm.crashsight.crashreport.common.info.b.a().c(str);
    }
}
