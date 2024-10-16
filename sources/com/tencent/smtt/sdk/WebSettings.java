package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;

/* loaded from: classes2.dex */
public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* renamed from: a, reason: collision with root package name */
    private IX5WebSettings f6486a;
    private android.webkit.WebSettings b;
    private boolean c;

    /* loaded from: classes2.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* loaded from: classes2.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: classes2.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* loaded from: classes2.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);

        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes2.dex */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(IX5WebSettings iX5WebSettings) {
        this.f6486a = null;
        this.b = null;
        this.c = false;
        this.f6486a = iX5WebSettings;
        this.b = null;
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(android.webkit.WebSettings webSettings) {
        this.f6486a = null;
        this.b = null;
        this.c = false;
        this.f6486a = null;
        this.b = webSettings;
        this.c = false;
    }

    public void setNavDump(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setNavDump(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.c.a(webSettings, "setNavDump", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized int getMixedContentMode() {
        int i = -1;
        if (this.c && this.f6486a != null) {
            try {
                return this.f6486a.getMixedContentMode();
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        Object a2 = com.tencent.smtt.utils.c.a(this.b, "getMixedContentMode", (Class<?>[]) new Class[0], new Object[0]);
        if (a2 != null) {
            i = ((Integer) a2).intValue();
        }
        return i;
    }

    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getNavDump();
        }
        if (this.c || (webSettings = this.b) == null || (a2 = com.tencent.smtt.utils.c.a(webSettings, "getNavDump")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setSupportZoom(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setSupportZoom(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportZoom(z);
        }
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.supportZoom();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportZoom();
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBuiltInZoomControls(z);
        }
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getBuiltInZoomControls();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBuiltInZoomControls();
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setDisplayZoomControls(z);
        } else {
            if (this.c || this.b == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.c.a(this.b, "setDisplayZoomControls", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getDisplayZoomControls();
        }
        if (this.c || this.b == null || Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.c.a(this.b, "getDisplayZoomControls")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAllowFileAccess(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAllowFileAccess(z);
        }
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getAllowFileAccess();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getAllowFileAccess();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAllowContentAccess(z);
        } else {
            if (this.c || this.b == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.c.a(this.b, "setAllowContentAccess", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        if ((!this.c || this.f6486a == null) && !this.c && this.b != null && Build.VERSION.SDK_INT >= 21) {
            com.tencent.smtt.utils.c.a(this.b, "setMixedContentMode", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getAllowContentAccess();
        }
        if (this.c || this.b == null || Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.c.a(this.b, "getAllowContentAccess")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadWithOverviewMode(z);
        }
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getLoadWithOverviewMode();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadWithOverviewMode();
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z);
        } else {
            if (this.c || this.b == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.c.a(this.b, "setEnableSmoothTransition", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.enableSmoothTransition();
        }
        if (this.c || this.b == null || Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.c.a(this.b, "enableSmoothTransition")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.c.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (this.c || (webSettings = this.b) == null || (a2 = com.tencent.smtt.utils.c.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setSaveFormData(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setSaveFormData(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSaveFormData(z);
        }
    }

    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getSaveFormData();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSaveFormData();
    }

    public void setSavePassword(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setSavePassword(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSavePassword(z);
        }
    }

    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getSavePassword();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSavePassword();
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setTextZoom(i);
        } else if (!this.c && this.b != null) {
            if (Build.VERSION.SDK_INT < 14) {
                return;
            }
            try {
                this.b.setTextZoom(i);
            } catch (Exception unused) {
                com.tencent.smtt.utils.c.a(this.b, "setTextZoom", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i));
            }
        }
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getTextZoom();
        }
        if (this.c || this.b == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            return this.b.getTextZoom();
        } catch (Exception unused) {
            Object a2 = com.tencent.smtt.utils.c.a(this.b, "getTextZoom");
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
    }

    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return TextSize.valueOf(iX5WebSettings.getTextSize().name());
        }
        if (this.c || (webSettings = this.b) == null) {
            return null;
        }
        return TextSize.valueOf(webSettings.getTextSize().name());
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return ZoomDensity.valueOf(iX5WebSettings.getDefaultZoom().name());
        }
        if (this.c || (webSettings = this.b) == null) {
            return null;
        }
        return ZoomDensity.valueOf(webSettings.getDefaultZoom().name());
    }

    public void setLightTouchEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setLightTouchEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLightTouchEnabled(z);
        }
    }

    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getLightTouchEnabled();
        }
        if (this.c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLightTouchEnabled();
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (!this.c || (iX5WebSettings = this.f6486a) == null) {
            return (this.c || (webSettings = this.b) == null) ? "" : webSettings.getUserAgentString();
        }
        return iX5WebSettings.getUserAgentString();
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    public void setUseWideViewPort(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setUseWideViewPort(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUseWideViewPort(z);
        }
    }

    public synchronized boolean getUseWideViewPort() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getUseWideViewPort();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getUseWideViewPort();
    }

    public void setSupportMultipleWindows(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportMultipleWindows(z);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.supportMultipleWindows();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.supportMultipleWindows();
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        if (this.c && this.f6486a != null) {
            return LayoutAlgorithm.valueOf(this.f6486a.getLayoutAlgorithm().name());
        }
        if (this.c || this.b == null) {
            return null;
        }
        return LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
    }

    public synchronized void setStandardFontFamily(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setStandardFontFamily(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setStandardFontFamily(str);
        }
    }

    public synchronized String getStandardFontFamily() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getStandardFontFamily();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getStandardFontFamily();
    }

    public synchronized void setFixedFontFamily(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setFixedFontFamily(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setFixedFontFamily(str);
        }
    }

    public synchronized String getFixedFontFamily() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getFixedFontFamily();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getFixedFontFamily();
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setSansSerifFontFamily(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setSansSerifFontFamily(str);
        }
    }

    public synchronized String getSansSerifFontFamily() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getSansSerifFontFamily();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getSansSerifFontFamily();
    }

    public synchronized void setSerifFontFamily(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setSerifFontFamily(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setSerifFontFamily(str);
        }
    }

    public synchronized String getSerifFontFamily() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getSerifFontFamily();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getSerifFontFamily();
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setCursiveFontFamily(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setCursiveFontFamily(str);
        }
    }

    public synchronized String getCursiveFontFamily() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getCursiveFontFamily();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getCursiveFontFamily();
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setFantasyFontFamily(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setFantasyFontFamily(str);
        }
    }

    public synchronized String getFantasyFontFamily() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getFantasyFontFamily();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getFantasyFontFamily();
    }

    public synchronized void setMinimumFontSize(int i) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setMinimumFontSize(i);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setMinimumFontSize(i);
        }
    }

    public synchronized int getMinimumFontSize() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getMinimumFontSize();
        }
        if (this.c || this.b == null) {
            return 0;
        }
        return this.b.getMinimumFontSize();
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setMinimumLogicalFontSize(i);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setMinimumLogicalFontSize(i);
        }
    }

    public synchronized int getMinimumLogicalFontSize() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getMinimumLogicalFontSize();
        }
        if (this.c || this.b == null) {
            return 0;
        }
        return this.b.getMinimumLogicalFontSize();
    }

    public synchronized void setDefaultFontSize(int i) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setDefaultFontSize(i);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setDefaultFontSize(i);
        }
    }

    public synchronized int getDefaultFontSize() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getDefaultFontSize();
        }
        if (this.c || this.b == null) {
            return 0;
        }
        return this.b.getDefaultFontSize();
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setDefaultFixedFontSize(i);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setDefaultFixedFontSize(i);
        }
    }

    public synchronized int getDefaultFixedFontSize() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getDefaultFixedFontSize();
        }
        if (this.c || this.b == null) {
            return 0;
        }
        return this.b.getDefaultFixedFontSize();
    }

    public void setLoadsImagesAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadsImagesAutomatically(z);
        }
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getLoadsImagesAutomatically();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getLoadsImagesAutomatically();
    }

    public void setBlockNetworkImage(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setBlockNetworkImage(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBlockNetworkImage(z);
        }
    }

    public synchronized boolean getBlockNetworkImage() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getBlockNetworkImage();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getBlockNetworkImage();
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setBlockNetworkLoads(z);
        } else {
            if (this.c || this.b == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 8) {
                this.b.setBlockNetworkLoads(z);
            }
        }
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getBlockNetworkLoads();
        }
        if (this.c || this.b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return false;
        }
        return this.b.getBlockNetworkLoads();
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (this.c && this.f6486a != null) {
                this.f6486a.setJavaScriptEnabled(z);
            } else if (this.c || this.b == null) {
            } else {
                this.b.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.c.a(webSettings, "setAllowUniversalAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.c.a(webSettings, "setAllowFileAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setPluginsEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.c.a(webSettings, "setPluginsEnabled", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else {
            if (this.c || this.b == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 8) {
                com.tencent.smtt.utils.c.a(this.b, "setPluginState", (Class<?>[]) new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
            }
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setPluginsPath(str);
        } else if (this.c || this.b == null) {
        } else {
            com.tencent.smtt.utils.c.a(this.b, "setPluginsPath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.c.a(webSettings, "setDatabasePath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAppCacheEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheEnabled(z);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCachePath(str);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheMaxSize(j);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setDatabaseEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDatabaseEnabled(z);
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setDomStorageEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDomStorageEnabled(z);
        }
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getDomStorageEnabled();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getDomStorageEnabled();
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getDatabasePath();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getDatabasePath();
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getDatabaseEnabled();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getDatabaseEnabled();
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setGeolocationEnabled(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized boolean getJavaScriptEnabled() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getJavaScriptEnabled();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getJavaScriptEnabled();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getPluginsEnabled();
        }
        if (this.c || this.b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT <= 17) {
            Object a2 = com.tencent.smtt.utils.c.a(this.b, "getPluginsEnabled");
            if (a2 != null) {
                r1 = ((Boolean) a2).booleanValue();
            }
            return r1;
        }
        if (Build.VERSION.SDK_INT == 18) {
            return WebSettings.PluginState.ON == this.b.getPluginState();
        }
        return false;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        if (this.c && this.f6486a != null) {
            return PluginState.valueOf(this.f6486a.getPluginState().name());
        }
        if (this.c || this.b == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return null;
        }
        Object a2 = com.tencent.smtt.utils.c.a(this.b, "getPluginState");
        if (a2 == null) {
            return null;
        }
        return PluginState.valueOf(((WebSettings.PluginState) a2).name());
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getPluginsPath();
        }
        if (this.c || this.b == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT > 17) {
            return "";
        }
        Object a2 = com.tencent.smtt.utils.c.a(this.b, "getPluginsPath");
        return a2 == null ? null : (String) a2;
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getJavaScriptCanOpenWindowsAutomatically();
        }
        if (this.c || this.b == null) {
            return false;
        }
        return this.b.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (this.c && this.f6486a != null) {
            this.f6486a.setDefaultTextEncodingName(str);
        } else if (this.c || this.b == null) {
        } else {
            this.b.setDefaultTextEncodingName(str);
        }
    }

    public synchronized String getDefaultTextEncodingName() {
        if (this.c && this.f6486a != null) {
            return this.f6486a.getDefaultTextEncodingName();
        }
        if (this.c || this.b == null) {
            return "";
        }
        return this.b.getDefaultTextEncodingName();
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        Object a2;
        r.a();
        if (r.b()) {
            return r.a().c().i(context);
        }
        if (Build.VERSION.SDK_INT >= 17 && (a2 = com.tencent.smtt.utils.c.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context)) != null) {
            return (String) a2;
        }
        return null;
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
        }
        if (this.c || this.b == null || Build.VERSION.SDK_INT < 17 || (a2 = com.tencent.smtt.utils.c.a(this.b, "getMediaPlaybackRequiresUserGesture")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z);
        } else {
            if (this.c || this.b == null || Build.VERSION.SDK_INT < 17) {
                return;
            }
            com.tencent.smtt.utils.c.a(this.b, "setMediaPlaybackRequiresUserGesture", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setNeedInitialFocus(z);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setNeedInitialFocus(z);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public void setCacheMode(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            iX5WebSettings.setCacheMode(i);
        } else {
            if (this.c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setCacheMode(i);
        }
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.c && (iX5WebSettings = this.f6486a) != null) {
            return iX5WebSettings.getCacheMode();
        }
        if (this.c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getCacheMode();
    }
}
