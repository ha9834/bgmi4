package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.amazonaws.services.s3.util.Mimetypes;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.mtt.MttTraceEvent;
import com.tencent.mtt.engine.http.HttpUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private Object A;
    private View.OnLongClickListener B;

    /* renamed from: a, reason: collision with root package name */
    int f6488a;
    private final String b;
    private boolean e;
    private IX5WebViewBase f;
    private a g;
    private WebSettings h;
    private Context i;
    private boolean k;
    private i l;
    private boolean m;
    public WebViewCallbackClient mWebViewCallbackClient;
    private WebViewClient q;
    private WebChromeClient r;
    private final int t;
    private final int u;
    private final int v;
    private final String w;
    private final String x;
    private static final Lock c = new ReentrantLock();
    private static OutputStream d = null;
    private static Context j = null;
    private static BroadcastReceiver n = null;
    public static boolean mWebViewCreated = false;
    private static com.tencent.smtt.utils.d o = null;
    private static Method p = null;
    private static String s = null;
    public static boolean mSysWebviewCreated = false;
    private static Paint y = null;
    private static boolean z = true;
    public static int NIGHT_MODE_ALPHA = 153;

    /* loaded from: classes2.dex */
    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    public static int getTbsSDKVersion(Context context) {
        return 43799;
    }

    public boolean showFindDialog(String str, boolean z2) {
        return false;
    }

    /* loaded from: classes2.dex */
    public class WebViewTransport {
        private WebView b;

        public WebViewTransport() {
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }

        public synchronized WebView getWebView() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    public static class HitTestResult {

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;

        /* renamed from: a, reason: collision with root package name */
        private IX5WebViewBase.HitTestResult f6494a;
        private WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.f6494a = null;
            this.b = null;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.f6494a = hitTestResult;
            this.b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.f6494a = null;
            this.b = hitTestResult;
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f6494a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f6494a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : "";
        }
    }

    public WebView(Context context, boolean z2) {
        super(context);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.f6488a = 0;
        this.k = false;
        this.l = null;
        this.m = false;
        this.q = null;
        this.r = null;
        this.t = 1;
        this.u = 2;
        this.v = 3;
        this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.A = null;
        this.B = null;
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z2) {
        this(context, attributeSet, i, null, z2);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z2) {
        super(context, attributeSet, i);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.f6488a = 0;
        this.k = false;
        this.l = null;
        this.m = false;
        this.q = null;
        this.r = null;
        this.t = 1;
        this.u = 2;
        this.v = 3;
        this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.A = null;
        this.B = null;
        mWebViewCreated = true;
        this.l = new i();
        this.l.a("init_all", (byte) 1);
        this.i = context;
        this.f = null;
        this.e = false;
        QbSdk.a(context, "failed to createTBSWebview!");
        this.g = new a(context, attributeSet);
        CookieManager.getInstance().a(context, true, false);
        CookieSyncManager.createInstance(this.i).startSync();
        try {
            Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
            declaredMethod.setAccessible(true);
            ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new d());
            mSysWebviewCreated = true;
        } catch (Exception unused) {
        }
        CookieManager.getInstance().a();
        this.g.setFocusableInTouchMode(true);
        addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        TbsLog.i("WebView", "SystemWebView Created Success! #3");
        TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
        TbsCoreLoadStat.getInstance().a(context, 402, new Throwable());
        b.a(context, this);
        MttTraceEvent.end(256, "WebView.constructor");
    }

    public Object createPrintDocumentAdapter(String str) {
        if (this.e) {
            try {
                return this.f.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return com.tencent.smtt.utils.c.a(this.g, "createPrintDocumentAdapter", (Class<?>[]) new Class[]{String.class}, str);
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.c.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.c.a(this.g, "computeVerticalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.c.a(this.g, "computeVerticalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) com.tencent.smtt.utils.c.a(this.f.getView(), "computeHorizontalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method a2 = com.tencent.smtt.utils.c.a(this.g, "computeHorizontalScrollRange", new Class[0]);
            a2.setAccessible(true);
            return ((Integer) a2.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.c.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) com.tencent.smtt.utils.c.a(this.f.getView(), "computeVerticalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method a2 = com.tencent.smtt.utils.c.a(this.g, "computeVerticalScrollRange", new Class[0]);
            a2.setAccessible(true);
            return ((Integer) a2.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private boolean b(Context context) {
        try {
            return context.getPackageName().indexOf("com.tencent.mobileqq") >= 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 21 || !b(this.i) || !isHardwareAccelerated() || i <= 0 || i2 <= 0) {
            return;
        }
        getLayerType();
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.e) {
            this.f.getView().setScrollBarStyle(i);
        } else {
            this.g.setScrollBarStyle(i);
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z2) {
        if (!this.e) {
            this.g.setHorizontalScrollbarOverlay(z2);
        } else {
            this.f.setHorizontalScrollbarOverlay(z2);
        }
    }

    public void setVerticalScrollbarOverlay(boolean z2) {
        if (!this.e) {
            this.g.setVerticalScrollbarOverlay(z2);
        } else {
            this.f.setVerticalScrollbarOverlay(z2);
        }
    }

    public boolean overlayHorizontalScrollbar() {
        if (!this.e) {
            return this.g.overlayHorizontalScrollbar();
        }
        return this.f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        if (this.e) {
            return this.f.overlayVerticalScrollbar();
        }
        return this.g.overlayVerticalScrollbar();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        if (this.e) {
            View view2 = this.f.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view == this) {
                view = view2;
            }
            return viewGroup.requestChildRectangleOnScreen(view, rect, z2);
        }
        a aVar = this.g;
        if (view == this) {
            view = aVar;
        }
        return aVar.requestChildRectangleOnScreen(view, rect, z2);
    }

    public int getWebScrollX() {
        if (this.e) {
            return this.f.getView().getScrollX();
        }
        return this.g.getScrollX();
    }

    public int getWebScrollY() {
        if (this.e) {
            return this.f.getView().getScrollY();
        }
        return this.g.getScrollY();
    }

    public int getVisibleTitleHeight() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "getVisibleTitleHeight");
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        return this.f.getVisibleTitleHeight();
    }

    public SslCertificate getCertificate() {
        if (!this.e) {
            return this.g.getCertificate();
        }
        return this.f.getCertificate();
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (!this.e) {
            this.g.setCertificate(sslCertificate);
        } else {
            this.f.setCertificate(sslCertificate);
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "savePassword", (Class<?>[]) new Class[]{String.class, String.class, String.class}, str, str2, str3);
        } else {
            this.f.savePassword(str, str2, str3);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (!this.e) {
            this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (!this.e) {
            return this.g.getHttpAuthUsernamePassword(str, str2);
        }
        return this.f.getHttpAuthUsernamePassword(str, str2);
    }

    public void tbsWebviewDestroy(boolean z2) {
        if (!this.e) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, this.g);
                if (invoke != null) {
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception unused) {
            }
            if (z2) {
                this.g.destroy();
            }
            try {
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        } else if (z2) {
            this.f.destroy();
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.smtt.sdk.WebView$1] */
    public void destroy() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        WebView.this.tbsWebviewDestroy(false);
                    }
                }.start();
                if (this.e) {
                    this.f.destroy();
                } else {
                    this.g.destroy();
                }
            } else {
                tbsWebviewDestroy(true);
            }
        } catch (Throwable unused) {
            tbsWebviewDestroy(true);
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        r.a();
        if (r.b()) {
            return;
        }
        com.tencent.smtt.utils.c.a("android.webkit.WebView", "enablePlatformNotifications");
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        r.a();
        if (r.b()) {
            return;
        }
        com.tencent.smtt.utils.c.a("android.webkit.WebView", "disablePlatformNotifications");
    }

    public void setNetworkAvailable(boolean z2) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 3) {
                this.g.setNetworkAvailable(z2);
                return;
            }
            return;
        }
        this.f.setNetworkAvailable(z2);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        if (!this.e) {
            return WebBackForwardList.a(this.g.saveState(bundle));
        }
        return WebBackForwardList.a(this.f.saveState(bundle));
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "savePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.savePicture(bundle, file);
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "restorePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.restorePicture(bundle, file);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        if (!this.e) {
            return WebBackForwardList.a(this.g.restoreState(bundle));
        }
        return WebBackForwardList.a(this.f.restoreState(bundle));
    }

    public JSONObject reportInitPerformance(long j2, int i, long j3, long j4) {
        i iVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IS_X5", this.e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TbsLog.i("sdkreport", "reportInitPerformance initType is " + j2 + " isX5Core is " + this.e + " isPerformanceDataRecorded" + this.m);
        if (this.e && (iVar = this.l) != null && !this.m) {
            iVar.a("init_type", j2);
            this.l.a("time_oncreate", j3);
            this.l.a("webview_type", i);
            this.l.a("time_webaccelerator", j4);
            if (this.l.a(this.f.hashCode(), getUrl())) {
                this.m = true;
            }
            try {
                jSONObject.put("DETAIL", this.l.a());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 8) {
                this.g.loadUrl(str, map);
                return;
            }
            return;
        }
        this.f.loadUrl(str, map);
    }

    public void loadUrl(String str) {
        if (str == null || showDebugView(str)) {
            return;
        }
        MttTraceEvent.begin(256, "WebView.loadUrl");
        if (!this.e) {
            this.g.loadUrl(str);
        } else {
            this.f.loadUrl(str);
        }
        MttTraceEvent.end(256, "WebView.loadUrl");
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            return true;
        }
        if (!lowerCase.startsWith("http://debugx5.qq.com") || this.e) {
            return false;
        }
        loadDataWithBaseURL(null, "<!DOCTYPE html><html><body><head><title>无法打开debugx5</title><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /></head><br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a></body></html>", Mimetypes.MIMETYPE_HTML, HttpUtils.DEFAULT_ENCODE_NAME, null);
        return true;
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (!this.e) {
            this.g.postUrl(str, bArr);
        } else {
            this.f.postUrl(str, bArr);
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (!this.e) {
            this.g.loadData(str, str2, str3);
        } else {
            this.f.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.e) {
            this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 11) {
                com.tencent.smtt.utils.c.a(this.g, "saveWebArchive", (Class<?>[]) new Class[]{String.class}, str);
                return;
            }
            return;
        }
        this.f.saveWebArchive(str);
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z2, ValueCallback<String> valueCallback) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 11) {
                com.tencent.smtt.utils.c.a(this.g, "saveWebArchive", (Class<?>[]) new Class[]{String.class, Boolean.TYPE, android.webkit.ValueCallback.class}, str, Boolean.valueOf(z2), valueCallback);
                return;
            }
            return;
        }
        this.f.saveWebArchive(str, z2, valueCallback);
    }

    public void stopLoading() {
        if (!this.e) {
            this.g.stopLoading();
        } else {
            this.f.stopLoading();
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z2) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a(z2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                p = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                if (p != null) {
                    p.setAccessible(true);
                    p.invoke(null, Boolean.valueOf(z2));
                }
            } catch (Exception e) {
                TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
                e.printStackTrace();
            }
        }
    }

    public void reload() {
        if (!this.e) {
            this.g.reload();
        } else {
            this.f.reload();
        }
    }

    public boolean canGoBack() {
        if (!this.e) {
            return this.g.canGoBack();
        }
        return this.f.canGoBack();
    }

    public void goBack() {
        if (!this.e) {
            this.g.goBack();
        } else {
            this.f.goBack();
        }
    }

    public boolean canGoForward() {
        if (!this.e) {
            return this.g.canGoForward();
        }
        return this.f.canGoForward();
    }

    public void goForward() {
        if (!this.e) {
            this.g.goForward();
        } else {
            this.f.goForward();
        }
    }

    public boolean canGoBackOrForward(int i) {
        if (!this.e) {
            return this.g.canGoBackOrForward(i);
        }
        return this.f.canGoBackOrForward(i);
    }

    public void goBackOrForward(int i) {
        if (!this.e) {
            this.g.goBackOrForward(i);
        } else {
            this.f.goBackOrForward(i);
        }
    }

    public boolean pageUp(boolean z2) {
        if (!this.e) {
            return this.g.pageUp(z2);
        }
        return this.f.pageUp(z2, -1);
    }

    public boolean pageDown(boolean z2) {
        if (!this.e) {
            return this.g.pageDown(z2);
        }
        return this.f.pageDown(z2, -1);
    }

    @Deprecated
    public void clearView() {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "clearView");
        } else {
            this.f.clearView();
        }
    }

    @Deprecated
    public Picture capturePicture() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "capturePicture");
            if (a2 == null) {
                return null;
            }
            return (Picture) a2;
        }
        return this.f.capturePicture();
    }

    @Deprecated
    public float getScale() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "getScale");
            if (a2 == null) {
                return 0.0f;
            }
            return ((Float) a2).floatValue();
        }
        return this.f.getScale();
    }

    public void setInitialScale(int i) {
        if (!this.e) {
            this.g.setInitialScale(i);
        } else {
            this.f.setInitialScale(i);
        }
    }

    public void invokeZoomPicker() {
        if (!this.e) {
            this.g.invokeZoomPicker();
        } else {
            this.f.invokeZoomPicker();
        }
    }

    public HitTestResult getHitTestResult() {
        if (!this.e) {
            return new HitTestResult(this.g.getHitTestResult());
        }
        return new HitTestResult(this.f.getHitTestResult());
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (this.e) {
            return this.f.getHitTestResult();
        }
        return null;
    }

    public void requestFocusNodeHref(Message message) {
        if (!this.e) {
            this.g.requestFocusNodeHref(message);
        } else {
            this.f.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (!this.e) {
            this.g.requestImageRef(message);
        } else {
            this.f.requestImageRef(message);
        }
    }

    public String getUrl() {
        if (!this.e) {
            return this.g.getUrl();
        }
        return this.f.getUrl();
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        if (!this.e) {
            return this.g.getOriginalUrl();
        }
        return this.f.getOriginalUrl();
    }

    public String getTitle() {
        if (!this.e) {
            return this.g.getTitle();
        }
        return this.f.getTitle();
    }

    public Bitmap getFavicon() {
        if (!this.e) {
            return this.g.getFavicon();
        }
        return this.f.getFavicon();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        r.a();
        if (r.b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) com.tencent.smtt.utils.c.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z2) {
        try {
            if (this.e || Build.VERSION.SDK_INT < 26) {
                return;
            }
            com.tencent.smtt.utils.c.a(this.g, "setRendererPriorityPolicy", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRendererRequestedPriority() {
        Object a2;
        try {
            if (!this.e && Build.VERSION.SDK_INT >= 26 && (a2 = com.tencent.smtt.utils.c.a(this.g, "getRendererRequestedPriority")) != null) {
                return ((Integer) a2).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        Object a2;
        try {
            if (!this.e && Build.VERSION.SDK_INT >= 26 && (a2 = com.tencent.smtt.utils.c.a(this.g, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((Boolean) a2).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WebChromeClient getWebChromeClient() {
        return this.r;
    }

    public WebViewClient getWebViewClient() {
        return this.q;
    }

    public int getProgress() {
        if (!this.e) {
            return this.g.getProgress();
        }
        return this.f.getProgress();
    }

    public int getContentHeight() {
        if (!this.e) {
            return this.g.getContentHeight();
        }
        return this.f.getContentHeight();
    }

    public int getContentWidth() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "getContentWidth");
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        return this.f.getContentWidth();
    }

    public void pauseTimers() {
        if (!this.e) {
            this.g.pauseTimers();
        } else {
            this.f.pauseTimers();
        }
    }

    public void resumeTimers() {
        if (!this.e) {
            this.g.resumeTimers();
        } else {
            this.f.resumeTimers();
        }
    }

    public void onPause() {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "onPause");
        } else {
            this.f.onPause();
        }
    }

    public void onResume() {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "onResume");
        } else {
            this.f.onResume();
        }
    }

    @Deprecated
    public void freeMemory() {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "freeMemory");
        } else {
            this.f.freeMemory();
        }
    }

    public void clearCache(boolean z2) {
        if (!this.e) {
            this.g.clearCache(z2);
        } else {
            this.f.clearCache(z2);
        }
    }

    public void clearFormData() {
        if (!this.e) {
            this.g.clearFormData();
        } else {
            this.f.clearFormData();
        }
    }

    public void clearHistory() {
        if (!this.e) {
            this.g.clearHistory();
        } else {
            this.f.clearHistory();
        }
    }

    public void clearSslPreferences() {
        if (!this.e) {
            this.g.clearSslPreferences();
        } else {
            this.f.clearSslPreferences();
        }
    }

    public WebBackForwardList copyBackForwardList() {
        if (this.e) {
            return WebBackForwardList.a(this.f.copyBackForwardList());
        }
        return WebBackForwardList.a(this.g.copyBackForwardList());
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.g.setFindListener(new WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // android.webkit.WebView.FindListener
                    public void onFindResultReceived(int i, int i2, boolean z2) {
                        findListener.onFindResultReceived(i, i2, z2);
                    }
                });
                return;
            }
            return;
        }
        this.f.setFindListener(findListener);
    }

    @TargetApi(3)
    public void findNext(boolean z2) {
        if (!this.e) {
            this.g.findNext(z2);
        } else {
            this.f.findNext(z2);
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.c.a(this.g, "findAll", (Class<?>[]) new Class[]{String.class}, str);
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        return this.f.findAll(str);
    }

    public static String findAddress(String str) {
        r.a();
        if (r.b()) {
            return null;
        }
        return android.webkit.WebView.findAddress(str);
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 16) {
                com.tencent.smtt.utils.c.a(this.g, "findAllAsync", (Class<?>[]) new Class[]{String.class}, str);
                return;
            }
            return;
        }
        this.f.findAllAsync(str);
    }

    @TargetApi(3)
    public void clearMatches() {
        if (!this.e) {
            this.g.clearMatches();
        } else {
            this.f.clearMatches();
        }
    }

    public void documentHasImages(Message message) {
        if (!this.e) {
            this.g.documentHasImages(message);
        } else {
            this.f.documentHasImages(message);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (this.e) {
            this.f.setWebViewClient(webViewClient != null ? new f(r.a().a(true).h(), this, webViewClient) : null);
        } else {
            this.g.setWebViewClient(webViewClient != null ? new SystemWebViewClient(this, webViewClient) : null);
        }
        this.q = webViewClient;
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (!this.e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("flag", true);
        getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
    }

    public void customDiskCachePathEnabled(boolean z2, String str) {
        if (!this.e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z2);
        bundle.putString("path", str);
        getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z2 = this.e;
        if (!z2) {
            this.g.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.3
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 == null) {
                        ApplicationInfo applicationInfo = WebView.this.i == null ? null : WebView.this.i.getApplicationInfo();
                        if (applicationInfo == null || !TbsConfig.APP_WX.equals(applicationInfo.packageName)) {
                            com.tencent.smtt.sdk.a.a.a(WebView.this.i, str, null, null);
                            return;
                        }
                        return;
                    }
                    downloadListener2.onDownloadStart(str, str2, str3, str4, j2);
                }
            });
        } else {
            this.f.setDownloadListener(new com.tencent.smtt.sdk.a(this, downloadListener, z2));
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (this.e) {
            this.f.setWebChromeClient(webChromeClient != null ? new e(r.a().a(true).g(), this, webChromeClient) : null);
        } else {
            this.g.setWebChromeClient(webChromeClient != null ? new SystemWebChromeClient(this, webChromeClient) : null);
        }
        this.r = webChromeClient;
    }

    public void setPictureListener(final PictureListener pictureListener) {
        if (this.e) {
            if (pictureListener == null) {
                this.f.setPictureListener(null);
                return;
            } else {
                this.f.setPictureListener(new IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                    }

                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z2) {
                        WebView.this.a(iX5WebViewBase);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }
                });
                return;
            }
        }
        if (pictureListener == null) {
            this.g.setPictureListener(null);
        } else {
            this.g.setPictureListener(new WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.WebView.PictureListener
                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    WebView.this.a(webView);
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (!this.e) {
            this.g.addJavascriptInterface(obj, str);
        } else {
            this.f.addJavascriptInterface(obj, str);
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (this.e) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.c.a(this.g, "removeJavascriptInterface", (Class<?>[]) new Class[]{String.class}, str);
        } else {
            this.f.removeJavascriptInterface(str);
        }
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.h;
        if (webSettings != null) {
            return webSettings;
        }
        if (this.e) {
            WebSettings webSettings2 = new WebSettings(this.f.getSettings());
            this.h = webSettings2;
            return webSettings2;
        }
        WebSettings webSettings3 = new WebSettings(this.g.getSettings());
        this.h = webSettings3;
        return webSettings3;
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        synchronized (WebView.class) {
            r.a();
            if (r.b()) {
                return null;
            }
            return com.tencent.smtt.utils.c.a("android.webkit.WebView", "getPluginList");
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z2) {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "refreshPlugins", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        } else {
            this.f.refreshPlugins(z2);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z2) {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "setMapTrackballToArrowKeys", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        } else {
            this.f.setMapTrackballToArrowKeys(z2);
        }
    }

    public void flingScroll(int i, int i2) {
        if (!this.e) {
            this.g.flingScroll(i, i2);
        } else {
            this.f.flingScroll(i, i2);
        }
    }

    @Deprecated
    public View getZoomControls() {
        if (!this.e) {
            return (View) com.tencent.smtt.utils.c.a(this.g, "getZoomControls");
        }
        return this.f.getZoomControls();
    }

    @Deprecated
    public boolean canZoomIn() {
        Object a2;
        if (!this.e) {
            if (Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.c.a(this.g, "canZoomIn")) == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.canZoomIn();
    }

    public boolean isPrivateBrowsingEnabled() {
        Object a2;
        if (!this.e) {
            if (Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.c.a(this.g, "isPrivateBrowsingEnabled")) == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.isPrivateBrowsingEnable();
    }

    @Deprecated
    public boolean canZoomOut() {
        Object a2;
        if (!this.e) {
            if (Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.c.a(this.g, "canZoomOut")) == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.canZoomOut();
    }

    public boolean zoomIn() {
        if (!this.e) {
            return this.g.zoomIn();
        }
        return this.f.zoomIn();
    }

    public boolean zoomOut() {
        if (!this.e) {
            return this.g.zoomOut();
        }
        return this.f.zoomOut();
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (!this.e) {
            com.tencent.smtt.utils.c.a(this.g, "dumpViewHierarchyWithProperties", (Class<?>[]) new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
        } else {
            this.f.dumpViewHierarchyWithProperties(bufferedWriter, i);
        }
    }

    public View findHierarchyView(String str, int i) {
        if (!this.e) {
            return (View) com.tencent.smtt.utils.c.a(this.g, "findHierarchyView", (Class<?>[]) new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        }
        return this.f.findHierarchyView(str, i);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.e) {
            this.g.computeScroll();
        } else {
            this.f.computeScroll();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!this.e) {
            this.g.setBackgroundColor(i);
        } else {
            this.f.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    public View getView() {
        if (!this.e) {
            return this.g;
        }
        return this.f.getView();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension();
        }
        return null;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getSettingsExtension();
        }
        return null;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getWebChromeClientExtension();
        }
        return null;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getWebViewClientExtension();
        }
        return null;
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.e) {
            try {
                Method a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                a2.setAccessible(true);
                a2.invoke(this.f.getView(), str, valueCallback);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.g, str, valueCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public boolean setVideoFullScreen(Context context, boolean z2) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z2) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(android.webkit.WebView webView) {
        boolean z2 = this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.webkit.WebView a() {
        if (this.e) {
            return null;
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IX5WebViewBase b() {
        return this.f;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends android.webkit.WebView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            CookieSyncManager.createInstance(WebView.this.i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new d());
                WebView.mSysWebviewCreated = true;
            } catch (Exception unused) {
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.invalidate();
            }
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            Log.d("syswebview", "SystemWebView - onScrollChanged...");
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
            } else {
                super.onScrollChanged(i, i2, i3, i4);
                WebView.this.onScrollChanged(i, i2, i3, i4);
            }
        }

        public void a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            Log.d("syswebview", "SystemWebView - computeScroll...");
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        public void a() {
            Log.d("syswebview", "SystemWebView - super_computeScroll...");
            super.computeScroll();
        }

        @Override // android.webkit.WebView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            Log.d("syswebview", "SystemWebView - onTouchEvent:" + motionEvent);
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean a(MotionEvent motionEvent) {
            Log.d("syswebview", "SystemWebView - super_onTouchEvent...");
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (WebView.z || WebView.y == null) {
                    return;
                }
                canvas.save();
                canvas.drawPaint(WebView.y);
                canvas.restore();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.View
        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        @TargetApi(9)
        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        @Override // android.webkit.WebView, android.view.View
        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @TargetApi(9)
        public void a(int i, int i2, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (Exception unused) {
            }
        }
    }

    public void switchNightMode(boolean z2) {
        if (z2 == z) {
            return;
        }
        z = z2;
        if (z) {
            TbsLog.e("QB_SDK", "deleteNightMode");
            loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
        } else {
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (z) {
            return;
        }
        TbsLog.e("QB_SDK", "switchToNightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }

    public static synchronized void setSysDayOrNight(boolean z2) {
        synchronized (WebView.class) {
            if (z2 == z) {
                return;
            }
            z = z2;
            if (y == null) {
                y = new Paint();
                y.setColor(NIGHT_MODE_COLOR);
            }
            if (!z2) {
                if (y.getAlpha() != NIGHT_MODE_ALPHA) {
                    y.setAlpha(NIGHT_MODE_ALPHA);
                }
            } else if (y.getAlpha() != 255) {
                y.setAlpha(255);
            }
        }
    }

    public void setDayOrNight(boolean z2) {
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z2);
            }
            setSysDayOrNight(z2);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setARModeEnable(boolean z2) {
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isDayMode() {
        return z;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View.OnLongClickListener onLongClickListener = this.B;
        if (onLongClickListener != null) {
            if (onLongClickListener.onLongClick(view)) {
                return true;
            }
            return a(view);
        }
        return a(view);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.e) {
            this.g.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f.getView();
        try {
            if (this.A == null) {
                Method a2 = com.tencent.smtt.utils.c.a(view, "getListenerInfo", new Class[0]);
                a2.setAccessible(true);
                Object invoke = a2.invoke(view, (Object[]) null);
                Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.A = declaredField.get(invoke);
            }
            this.B = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    private int c(Context context) {
        FileLock a2;
        FileOutputStream b = com.tencent.smtt.utils.b.b(context, true, "tbslock.txt");
        if (b == null || (a2 = com.tencent.smtt.utils.b.a(context, b)) == null) {
            return -1;
        }
        if (!c.tryLock()) {
            com.tencent.smtt.utils.b.a(a2, b);
            return -1;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
                if (!file.exists()) {
                    c.unlock();
                    com.tencent.smtt.utils.b.a(a2, b);
                    return -1;
                }
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    String property = properties.getProperty("PV");
                    if (property == null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e.toString());
                        }
                        c.unlock();
                        com.tencent.smtt.utils.b.a(a2, b);
                        return -1;
                    }
                    int parseInt = Integer.parseInt(property);
                    TbsLog.d("getTbsCorePV", "mpv =" + parseInt);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                    }
                    c.unlock();
                    com.tencent.smtt.utils.b.a(a2, b);
                    return parseInt;
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e4.toString());
                        }
                    }
                    c.unlock();
                    com.tencent.smtt.utils.b.a(a2, b);
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e5.toString());
                        }
                    }
                    c.unlock();
                    com.tencent.smtt.utils.b.a(a2, b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public void a(Context context) {
        String str;
        int c2 = c(context);
        if (c2 != -1) {
            str = "PV=" + String.valueOf(c2 + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
        try {
            try {
                file.getParentFile().mkdirs();
                if (!file.isFile() || !file.exists()) {
                    file.createNewFile();
                }
                d = new FileOutputStream(file, false);
                d.write(str.getBytes());
                TbsLog.d("writetbscorepvfile", "writepvfile finish ");
                if (d != null) {
                    d.flush();
                }
            } catch (Throwable th) {
                TbsLog.d("writetbscorepvfile", "writepvfile finish ");
                if (d != null) {
                    d.flush();
                }
                throw th;
            }
        } catch (Throwable th2) {
            TbsLog.d("writetbscorepvfile", "file.getAbsolutePath=" + file.getAbsolutePath() + " Throwable=" + th2);
        }
    }

    private boolean a(View view) {
        Object a2;
        Context context = this.i;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (a2 = com.tencent.smtt.utils.c.a(this.A, "onLongClick", (Class<?>[]) new Class[]{View.class}, view)) != null) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (!this.e) {
            this.g.addView(view);
            return;
        }
        View view2 = this.f.getView();
        try {
            Method a2 = com.tencent.smtt.utils.c.a(view2, "addView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (!this.e) {
            this.g.removeView(view);
            return;
        }
        View view2 = this.f.getView();
        try {
            Method a2 = com.tencent.smtt.utils.c.a(view2, "removeView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public static String getCrashExtraMessage(Context context) {
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:43799;";
        boolean z2 = false;
        if (TbsConfig.APP_WX.equals(context.getApplicationInfo().packageName)) {
            try {
                Class.forName("de.robv.android.xposed.XposedBridge");
                z2 = true;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z2) {
            return str + "isXposed=true;";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c.a(true).d());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && QbSdk.l != null && QbSdk.l.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.l.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.l.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + CertificateUtil.DELIMITER + QbSdk.l.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append("\n");
            sb.append(str2);
        }
        if (sb.length() > 8192) {
            return sb.substring(sb.length() - 8192);
        }
        return sb.toString();
    }

    public static boolean getTbsNeedReboot() {
        c();
        boolean e = c.a(true).e();
        TbsLog.d("TbsNeedReboot", "WebView.getTbsNeedReboot--ret = " + e);
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        try {
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (WebView.j == null) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    c a2 = c.a(true);
                    if (!c.b) {
                        h a3 = h.a(WebView.j);
                        int c2 = a3.c();
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + c2);
                        if (c2 == 2) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                            a2.a(String.valueOf(a3.b()));
                            a2.b(true);
                            return;
                        }
                        int a4 = a3.a("copy_status");
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + a4);
                        if (a4 == 1) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                            a2.a(String.valueOf(a3.b("copy_core_ver")));
                            a2.b(true);
                            return;
                        }
                        r.a();
                        if (r.b()) {
                            return;
                        }
                        if (c2 == 3 || a4 == 3) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                            a2.a(String.valueOf(c.c()));
                            a2.b(true);
                            return;
                        }
                        return;
                    }
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                }
            }).start();
        } catch (Throwable th) {
            TbsLog.e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (!this.e) {
            this.g.a(i, i2, i3, i4);
            return;
        }
        try {
            com.tencent.smtt.utils.c.a(this.f.getView(), "super_onScrollChanged", (Class<?>[]) new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        if (!this.e) {
            return this.g.a(i, i2, i3, i4, i5, i6, i7, i8, z2);
        }
        try {
            Object a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "super_overScrollBy", (Class<?>[]) new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z2));
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z2, boolean z3) {
        if (!this.e) {
            this.g.a(i, i2, z2, z3);
            return;
        }
        try {
            com.tencent.smtt.utils.c.a(this.f.getView(), "super_onOverScrolled", (Class<?>[]) new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.b(motionEvent);
        }
        try {
            Object a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "super_dispatchTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.c(motionEvent);
        }
        try {
            Object a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "super_onInterceptTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.a(motionEvent);
        }
        Log.d("grass", "super_onTouchEvent");
        try {
            Object a2 = com.tencent.smtt.utils.c.a(this.f.getView(), "super_onTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_computeScroll() {
        if (!this.e) {
            this.g.a();
            return;
        }
        try {
            com.tencent.smtt.utils.c.a(this.f.getView(), "super_computeScroll");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i);
    }
}
