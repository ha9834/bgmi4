package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;

    /* renamed from: a, reason: collision with root package name */
    CopyOnWriteArrayList<b> f6416a;
    String b;
    a c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = true;

    /* loaded from: classes2.dex */
    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f6418a;
        String b;
        String c;
        ValueCallback<Boolean> d;
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (d == null) {
            synchronized (CookieManager.class) {
                if (d == null) {
                    d = new CookieManager();
                }
            }
        }
        return d;
    }

    public void removeSessionCookie() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        } else {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public void removeAllCookie() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f6416a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().d();
        } else {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f6416a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public void flush() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "flush", (Class<?>[]) new Class[0], new Object[0]);
        }
    }

    public void removeExpiredCookie() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        } else {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } else {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            Object returnNull = a2.c().a().returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (returnNull == null) {
                return true;
            }
            return ((Boolean) returnNull).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        Object a3 = com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class}, webView.getView());
        if (a3 == null) {
            return false;
        }
        return ((Boolean) a3).booleanValue();
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        android.webkit.CookieManager.getInstance().setCookie(str, str2);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
    }

    public boolean hasCookies() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().f();
        }
        return android.webkit.CookieManager.getInstance().hasCookies();
    }

    public boolean acceptCookie() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().c();
        }
        return android.webkit.CookieManager.getInstance().acceptCookie();
    }

    public String getCookie(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            Log.i(LOGTAG, "getX5cookie");
            return a2.c().a(str);
        }
        Log.i(LOGTAG, "getSyscookie");
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setCookies(Map<String, String[]> map) {
        r a2 = r.a();
        if ((a2 == null || !r.b()) ? false : a2.c().a(map)) {
            return;
        }
        for (String str : map.keySet()) {
            for (String str2 : map.get(str)) {
                setCookie(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a() {
        this.f = true;
        if (this.f6416a != null && this.f6416a.size() != 0) {
            if (r.a() != null && r.b()) {
                Iterator<b> it = this.f6416a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    switch (next.f6418a) {
                        case 1:
                            setCookie(next.b, next.c, next.d);
                            break;
                        case 2:
                            setCookie(next.b, next.c);
                            break;
                    }
                }
            } else {
                Iterator<b> it2 = this.f6416a.iterator();
                while (it2.hasNext()) {
                    b next2 = it2.next();
                    switch (next2.f6418a) {
                        case 1:
                            if (Build.VERSION.SDK_INT < 21) {
                                break;
                            } else {
                                com.tencent.smtt.utils.c.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, next2.b, next2.c, next2.d);
                                break;
                            }
                        case 2:
                            android.webkit.CookieManager.getInstance().setCookie(next2.b, next2.c);
                            break;
                    }
                }
            }
            this.f6416a.clear();
        }
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            return false;
        }
        this.c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (this.c != a.MODE_NONE && z && !r.a().d()) {
            r.a().a(context, null);
        }
        Log.i(LOGTAG, "setKeyCookies,timeused:" + (System.currentTimeMillis() - currentTimeMillis) + ", cookieCompatiableMode:" + this.c.ordinal());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(Context context, boolean z, boolean z2) {
        int i;
        int i2;
        int parseInt;
        boolean z3 = true;
        boolean z4 = false;
        if (this.c != a.MODE_NONE && context != null && TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) && !this.e) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (!z && !QbSdk.getIsSysWebViewForcedByOuter() && !QbSdk.f6432a) {
                r.a().a(context, null);
                return;
            }
            if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.f6432a) {
                z2 = false;
            }
            boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
            TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
            TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
            if (canUseFunction == z2) {
                Log.i(LOGTAG, "not switch ,canuseX5:" + z2);
                return;
            }
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            if (!TextUtils.isEmpty(this.b)) {
                if (j.a().b(context) > 0 && j.a().b(context) < 36001) {
                    return;
                }
                if (canUseFunction) {
                    i = g.d(context);
                    Log.i(LOGTAG, "x5->sys,from:" + i);
                    if (i > 0) {
                        i2 = getROMCookieDBVersion(context);
                        Log.i(LOGTAG, "x5->sys,to:" + i2);
                        if (i2 <= 0) {
                            z4 = true;
                        }
                    } else {
                        i2 = 0;
                    }
                } else {
                    int d2 = g.d(context);
                    Log.i(LOGTAG, "sys->x5,from:" + d2);
                    if (d2 > 0) {
                        String a2 = j.a().a(context, "cookies_database_version");
                        if (!TextUtils.isEmpty(a2)) {
                            try {
                                parseInt = Integer.parseInt(a2);
                            } catch (Exception e) {
                                Log.i(LOGTAG, "cannot cast toVersion:0,e:" + e.toString());
                            }
                            Log.i(LOGTAG, "sys->x5,to:" + parseInt);
                            i2 = parseInt;
                            i = d2;
                        }
                        parseInt = 0;
                        Log.i(LOGTAG, "sys->x5,to:" + parseInt);
                        i2 = parseInt;
                        i = d2;
                    } else {
                        i = d2;
                        i2 = 0;
                    }
                }
                if (!z4 && (i <= 0 || i2 <= 0)) {
                    Log.i(LOGTAG, "INFO_COOKIE_SWITCH_VERSION_ERROR:");
                    tbsLogInfo.setErrorCode(702);
                } else if (i2 >= i) {
                    Log.i(LOGTAG, "INFO_COOKIE_SWITCH_NONEED, from :" + i + ",to:" + i2);
                    tbsLogInfo.setErrorCode(703);
                } else {
                    g.a(context, this.c, this.b, z4, z2);
                    tbsLogInfo.setErrorCode(TbsListener.ErrorCode.INFO_COOKIE_SWITCH_TRANSFER);
                    j = System.currentTimeMillis() - currentTimeMillis;
                    Log.i(LOGTAG, "compatiableCookieDatabaseIfNeed,timeused:" + j);
                }
            } else {
                tbsLogInfo.setErrorCode(701);
                i = 0;
                i2 = 0;
            }
            tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i + " to:" + i2 + ",timeused:" + j);
            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
            return;
        }
        String str = LOGTAG;
        StringBuilder sb = new StringBuilder();
        sb.append("compatiableCookieDatabaseIfNeed noneedCompatiable,context is null:");
        if (context != null) {
            z3 = false;
        }
        sb.append(z3);
        sb.append("= or canUseFunction is false,isCompatiableed:");
        sb.append(this.e);
        Log.i(str, sb.toString());
    }

    public static int getROMCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        return sharedPreferences.getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("db_version", i);
        edit.commit();
    }
}
