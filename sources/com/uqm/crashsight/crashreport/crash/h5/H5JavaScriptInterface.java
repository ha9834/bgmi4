package com.uqm.crashsight.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.security.CertificateUtil;
import com.uqm.crashsight.crashreport.CrashReport;
import com.uqm.crashsight.crashreport.inner.InnerApi;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f6598a = new HashSet<>();
    private String b = null;
    private Thread c = null;
    private String d = null;
    private Map<String, String> e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || f6598a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f6598a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.c = Thread.currentThread();
        Thread thread = h5JavaScriptInterface.c;
        if (thread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 2; i < thread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = thread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.e = hashMap;
        return h5JavaScriptInterface;
    }

    private static a a(String str) {
        String string;
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.f6599a = jSONObject.getString("projectRoot");
            if (aVar.f6599a == null) {
                return null;
            }
            aVar.b = jSONObject.getString("context");
            if (aVar.b == null) {
                return null;
            }
            aVar.c = jSONObject.getString("url");
            if (aVar.c == null) {
                return null;
            }
            aVar.d = jSONObject.getString("userAgent");
            if (aVar.d == null) {
                return null;
            }
            aVar.e = jSONObject.getString("language");
            if (aVar.e == null) {
                return null;
            }
            aVar.f = jSONObject.getString("name");
            if (aVar.f == null || aVar.f.equals(Constants.NULL_VERSION_ID) || (string = jSONObject.getString("stacktrace")) == null) {
                return null;
            }
            int indexOf = string.indexOf("\n");
            if (indexOf < 0) {
                m.d("H5 crash stack's format is wrong!", new Object[0]);
                return null;
            }
            aVar.h = string.substring(indexOf + 1);
            aVar.g = string.substring(0, indexOf);
            int indexOf2 = aVar.g.indexOf(CertificateUtil.DELIMITER);
            if (indexOf2 > 0) {
                aVar.g = aVar.g.substring(indexOf2 + 1);
            }
            aVar.i = jSONObject.getString(TransferTable.COLUMN_FILE);
            if (aVar.f == null) {
                return null;
            }
            aVar.j = jSONObject.getLong("lineNumber");
            if (aVar.j < 0) {
                return null;
            }
            aVar.k = jSONObject.getLong("columnNumber");
            if (aVar.k < 0) {
                return null;
            }
            m.a("H5 crash information is following: ", new Object[0]);
            m.a("[projectRoot]: " + aVar.f6599a, new Object[0]);
            m.a("[context]: " + aVar.b, new Object[0]);
            m.a("[url]: " + aVar.c, new Object[0]);
            m.a("[userAgent]: " + aVar.d, new Object[0]);
            m.a("[language]: " + aVar.e, new Object[0]);
            m.a("[name]: " + aVar.f, new Object[0]);
            m.a("[message]: " + aVar.g, new Object[0]);
            m.a("[stacktrace]: \n" + aVar.h, new Object[0]);
            m.a("[file]: " + aVar.i, new Object[0]);
            m.a("[lineNumber]: " + aVar.j, new Object[0]);
            m.a("[columnNumber]: " + aVar.k, new Object[0]);
            return aVar;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        m.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            m.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String a2 = q.a(str.getBytes());
        String str2 = this.b;
        if (str2 != null && str2.equals(a2)) {
            m.d("Same payload from js. Please check whether you've injected crashSight.js more than one times.", new Object[0]);
            return;
        }
        this.b = a2;
        m.d("Handling JS exception ...", new Object[0]);
        a a3 = a(str);
        if (a3 == null) {
            m.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (a3.f6599a != null) {
            linkedHashMap2.put("[JS] projectRoot", a3.f6599a);
        }
        if (a3.b != null) {
            linkedHashMap2.put("[JS] context", a3.b);
        }
        if (a3.c != null) {
            linkedHashMap2.put("[JS] url", a3.c);
        }
        if (a3.d != null) {
            linkedHashMap2.put("[JS] userAgent", a3.d);
        }
        if (a3.i != null) {
            linkedHashMap2.put("[JS] file", a3.i);
        }
        if (a3.j != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(a3.j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.e);
        linkedHashMap.put("Java Stack", this.d);
        Thread thread = this.c;
        if (a3 != null) {
            InnerApi.postH5CrashAsync(thread, a3.f, a3.g, a3.h, linkedHashMap);
        }
    }
}
