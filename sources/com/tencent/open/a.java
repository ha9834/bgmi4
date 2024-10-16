package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, b> f6356a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0208a {

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<WebView> f6358a;
        protected long b;
        protected String c;

        public C0208a(WebView webView, long j, String str) {
            this.f6358a = new WeakReference<>(webView);
            this.b = j;
            this.c = str;
        }

        public void a(Object obj) {
            WebView webView = this.f6358a.get();
            if (webView == null) {
                return;
            }
            String str = "'undefined'";
            if (obj instanceof String) {
                str = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                str = obj.toString();
            } else if (obj instanceof Boolean) {
                str = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str + "});");
        }

        public void a() {
            WebView webView = this.f6358a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f6358a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public boolean customCallback() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0135, code lost:
        
            r12.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0138, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void call(java.lang.String r10, java.util.List<java.lang.String> r11, com.tencent.open.a.C0208a r12) {
            /*
                Method dump skipped, instructions count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.b.call(java.lang.String, java.util.List, com.tencent.open.a$a):void");
        }
    }

    public void a(b bVar, String str) {
        this.f6356a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0208a c0208a) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = this.f6356a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0208a);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0208a != null) {
                c0208a.a();
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        C0208a c0208a = new C0208a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, c0208a);
        return true;
    }
}
