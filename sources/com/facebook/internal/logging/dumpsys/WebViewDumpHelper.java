package com.facebook.internal.logging.dumpsys;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

@SuppressLint({"NewApi", "StringFormatUse", "DefaultLocale", "BadMethodUse-java.lang.String.length"})
/* loaded from: classes.dex */
public final class WebViewDumpHelper {
    public static final Companion Companion = new Companion(null);
    public static final String GET_WEBVIEW_HTML_JS_SCRIPT = "(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();";
    private final Set<WebViewData> webViews = new LinkedHashSet();
    private final Map<String, String> webViewHTMLs = new LinkedHashMap();

    public final void handle(WebView webView) {
        h.b(webView, "view");
        final WebViewData webViewData = new WebViewData(webView);
        this.webViews.add(webViewData);
        Resources resources = webView.getResources();
        h.a((Object) resources, "view.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        l lVar = l.f6973a;
        Object[] objArr = {Integer.valueOf(webViewData.getLeft()), Integer.valueOf(webViewData.getTop()), Float.valueOf(displayMetrics.scaledDensity)};
        String format = String.format(GET_WEBVIEW_HTML_JS_SCRIPT, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        webView.evaluateJavascript(format, new ValueCallback<String>() { // from class: com.facebook.internal.logging.dumpsys.WebViewDumpHelper$handle$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String str) {
                Map map;
                map = WebViewDumpHelper.this.webViewHTMLs;
                String key = webViewData.getKey();
                h.a((Object) str, "html");
                map.put(key, str);
            }
        });
    }

    public final void dump(PrintWriter printWriter) {
        h.b(printWriter, "writer");
        try {
            for (WebViewData webViewData : this.webViews) {
                String str = this.webViewHTMLs.get(webViewData.getKey());
                if (str != null) {
                    printWriter.print("WebView HTML for ");
                    printWriter.print(webViewData);
                    printWriter.println(CertificateUtil.DELIMITER);
                    printWriter.println(Companion.fixHtmlString(webViewData, str));
                }
            }
        } catch (Exception unused) {
        }
        this.webViews.clear();
        this.webViewHTMLs.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class WebViewData {
        public static final Companion Companion = new Companion(null);
        private static final int[] location = new int[2];
        private final int height;
        private final String key;
        private final int left;
        private final int top;
        private final int width;

        public WebViewData(WebView webView) {
            h.b(webView, "webView");
            l lVar = l.f6973a;
            Object[] objArr = {webView.getClass().getName(), Integer.toHexString(webView.hashCode())};
            String format = String.format("%s{%s}", Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            this.key = format;
            webView.getLocationOnScreen(location);
            int[] iArr = location;
            this.left = iArr[0];
            this.top = iArr[1];
            this.width = webView.getWidth();
            this.height = webView.getHeight();
        }

        public final String getKey() {
            return this.key;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String fixHtmlString(WebViewData webViewData, String str) {
            String a2 = kotlin.text.l.a(kotlin.text.l.a(kotlin.text.l.a(str, "\\u003C", "<", false, 4, (Object) null), "\\n", "", false, 4, (Object) null), "\\\"", "\"", false, 4, (Object) null);
            l lVar = l.f6973a;
            Object[] objArr = new Object[6];
            objArr[0] = webViewData.getKey();
            objArr[1] = Integer.valueOf(webViewData.getLeft());
            objArr[2] = Integer.valueOf(webViewData.getTop());
            objArr[3] = Integer.valueOf(webViewData.getWidth());
            objArr[4] = Integer.valueOf(webViewData.getHeight());
            int length = a2.length() - 1;
            if (a2 != null) {
                String substring = a2.substring(1, length);
                h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                objArr[5] = substring;
                String format = String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", Arrays.copyOf(objArr, objArr.length));
                h.a((Object) format, "java.lang.String.format(format, *args)");
                return format;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
