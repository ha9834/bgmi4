package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.tencent.smtt.export.external.UselessClass;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private UselessClass f6534a;

    public UselessClass a() {
        return this.f6534a;
    }

    public Object b() {
        return this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    public boolean c() {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public void d() {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    public boolean a(Map<String, String[]> map) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public void a(boolean z) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tencent.smtt.export.external.interfaces.IX5WebViewBase a(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "TbsWizard.createSDKWebview"
            r1 = 256(0x100, float:3.59E-43)
            com.tencent.mtt.MttTraceEvent.begin(r1, r0)
            com.tencent.smtt.export.external.UselessClass r0 = r9.f6534a
            java.lang.String r2 = "com.tencent.tbs.tbsshell.WebCoreProxy"
            java.lang.String r3 = "createSDKWebview"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r7] = r10
            java.lang.Object r0 = r0.returnNull(r2, r3, r5, r4)
            r2 = 325(0x145, float:4.55E-43)
            r3 = 0
            if (r0 != 0) goto L57
            com.tencent.smtt.export.external.UselessClass r4 = r9.f6534a     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = "com.tencent.tbs.tbsshell.TBSShell"
            java.lang.String r6 = "getLoadFailureDetails"
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L74
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L74
            java.lang.Object r4 = r4.returnNull(r5, r6, r8, r7)     // Catch: java.lang.Exception -> L74
            if (r4 == 0) goto L40
            boolean r5 = r4 instanceof java.lang.Throwable     // Catch: java.lang.Exception -> L74
            if (r5 == 0) goto L40
            com.tencent.smtt.sdk.TbsCoreLoadStat r5 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance()     // Catch: java.lang.Exception -> L74
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch: java.lang.Exception -> L74
            r5.a(r10, r2, r6)     // Catch: java.lang.Exception -> L74
        L40:
            if (r4 == 0) goto L54
            boolean r5 = r4 instanceof java.lang.String     // Catch: java.lang.Exception -> L74
            if (r5 == 0) goto L54
            com.tencent.smtt.sdk.TbsCoreLoadStat r5 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance()     // Catch: java.lang.Exception -> L74
            java.lang.Throwable r6 = new java.lang.Throwable     // Catch: java.lang.Exception -> L74
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L74
            r6.<init>(r4)     // Catch: java.lang.Exception -> L74
            r5.a(r10, r2, r6)     // Catch: java.lang.Exception -> L74
        L54:
            r0 = r3
            r4 = r0
            goto L79
        L57:
            r4 = r0
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase r4 = (com.tencent.smtt.export.external.interfaces.IX5WebViewBase) r4     // Catch: java.lang.Exception -> L74
            if (r4 == 0) goto L79
            android.view.View r5 = r4.getView()     // Catch: java.lang.Exception -> L72
            if (r5 != 0) goto L79
            com.tencent.smtt.sdk.TbsCoreLoadStat r5 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance()     // Catch: java.lang.Exception -> L72
            java.lang.Throwable r6 = new java.lang.Throwable     // Catch: java.lang.Exception -> L72
            java.lang.String r7 = "x5webview.getView is null!"
            r6.<init>(r7)     // Catch: java.lang.Exception -> L72
            r5.a(r10, r2, r6)     // Catch: java.lang.Exception -> L72
            r0 = r3
            goto L79
        L72:
            r10 = move-exception
            goto L76
        L74:
            r10 = move-exception
            r4 = r3
        L76:
            r10.printStackTrace()
        L79:
            if (r0 != 0) goto L7c
            return r3
        L7c:
            java.lang.String r10 = "TbsWizard.createSDKWebview"
            com.tencent.mtt.MttTraceEvent.end(r1, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.s.a(android.content.Context):com.tencent.smtt.export.external.interfaces.IX5WebViewBase");
    }

    public String a(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public InputStream a(String str, boolean z) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (returnNull == null) {
            return null;
        }
        return (InputStream) returnNull;
    }

    public Object e() {
        return this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    public boolean f() {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public IX5WebChromeClient g() {
        Object returnNull;
        UselessClass uselessClass = this.f6534a;
        if (uselessClass == null || (returnNull = uselessClass.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0])) == null) {
            return null;
        }
        return (IX5WebChromeClient) returnNull;
    }

    public IX5WebViewClient h() {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (returnNull == null) {
            return null;
        }
        return (IX5WebViewClient) returnNull;
    }

    public void b(String str) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    public Uri[] a(int i, Intent intent) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        if (returnNull == null) {
            return null;
        }
        return (Uri[]) returnNull;
    }

    public void i() {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    public void a(String str, IconListener iconListener) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    public void c(String str) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    public void d(String str) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    public void j() {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    public boolean b(Context context) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public void c(Context context) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    public boolean d(Context context) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public void e(Context context) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    public boolean f(Context context) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public void g(Context context) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    public void a(android.webkit.ValueCallback<Map> valueCallback) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    public void a(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void b(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void a(String str, long j) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
    }

    public void e(String str) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    public void k() {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    public IX5DateSorter h(Context context) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (returnNull == null) {
            return null;
        }
        return (IX5DateSorter) returnNull;
    }

    public void b(android.webkit.ValueCallback<Set<String>> valueCallback) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    public void c(String str, android.webkit.ValueCallback<Boolean> valueCallback) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void f(String str) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
    }

    public void g(String str) {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
    }

    public void l() {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    }

    public String h(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public boolean i(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public String j(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public boolean k(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public String l(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public String m(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public String a(String str, String str2, String str3) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public byte[] a(byte[] bArr) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (returnNull == null) {
            return null;
        }
        return (byte[]) returnNull;
    }

    public boolean n(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean o(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean p(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean q(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean r(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean s(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean t(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean u(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean v(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean w(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean x(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (returnNull == null) {
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public String y(String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public String b(String str, String str2, String str3) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (returnNull == null) {
            return null;
        }
        return (String) returnNull;
    }

    public void a(Context context, boolean z) {
        TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            return;
        }
        try {
            this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
        } catch (Exception unused) {
            Log.d("X5CoreWizard", " tbsWizard clearAllX5CacheExceptCookie");
            this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.f6534a.returnNull("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            TbsLog.d("X5CoreWizard", "clearAllCache - 清除LocalStorage");
            this.f6534a.returnNull("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            TbsLog.d("X5CoreWizard", "clearAllX5CacheExceptCookie - 清除DNS");
            Object returnNull = this.f6534a.returnNull("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (returnNull != null) {
                this.f6534a.returnNull(returnNull, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            Object returnNull2 = this.f6534a.returnNull("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (returnNull2 != null) {
                this.f6534a.returnNull(returnNull2, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        }
    }

    public boolean a(Context context, String str) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (returnNull instanceof Boolean) {
            return ((Boolean) returnNull).booleanValue();
        }
        return false;
    }

    public void m() {
        this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }

    public String i(Context context) {
        Object returnNull = this.f6534a.returnNull("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (returnNull instanceof String) {
            return (String) returnNull;
        }
        return null;
    }
}
