package com.tencent.msdk.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.Arrays;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    private static StatLogger d = com.tencent.msdk.stat.common.j.b();
    private static k e = null;
    private static Context f = null;

    /* renamed from: a, reason: collision with root package name */
    DefaultHttpClient f6330a;
    Handler b;
    StringBuilder c = new StringBuilder(4096);
    private long g;

    private k(Context context) {
        this.f6330a = null;
        this.b = null;
        this.g = 0L;
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            this.b = new Handler(handlerThread.getLooper());
            f = context.getApplicationContext();
            this.g = System.currentTimeMillis() / 1000;
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f6330a = new DefaultHttpClient(basicHttpParams);
            this.f6330a.setKeepAliveStrategy(new l(this));
        } catch (Throwable th) {
            d.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context a() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        f = context.getApplicationContext();
    }

    private void a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (com.tencent.msdk.a.a.i.c(optString)) {
                if (StatConfig.isDebugEnable()) {
                    d.i("update mid:" + optString);
                }
                com.tencent.msdk.a.a.d dVar = new com.tencent.msdk.a.a.d();
                dVar.f6280a = aj.a(f).b(f).b();
                dVar.b = aj.a(f).b(f).c();
                dVar.d = System.currentTimeMillis();
                dVar.c = optString;
                com.tencent.msdk.a.a.h.a(f).a(dVar);
            }
            if (!jSONObject.isNull("cfg")) {
                StatConfig.a(f, jSONObject.getJSONObject("cfg"));
            }
            if (jSONObject.isNull("ncts")) {
                return;
            }
            int i = jSONObject.getInt("ncts");
            int currentTimeMillis = (int) (i - (System.currentTimeMillis() / 1000));
            if (StatConfig.isDebugEnable()) {
                d.i("server time:" + i + ", diff time:" + currentTimeMillis);
            }
            com.tencent.msdk.stat.common.j.y(f);
            com.tencent.msdk.stat.common.j.a(f, currentTimeMillis);
        } catch (Throwable th) {
            d.w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k b(Context context) {
        if (e == null) {
            synchronized (k.class) {
                if (e == null) {
                    e = new k(context);
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.msdk.stat.a.d dVar, j jVar) {
        b(Arrays.asList(dVar.g()), jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.List<?> r10, com.tencent.msdk.stat.j r11) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.k.a(java.util.List, com.tencent.msdk.stat.j):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<?> list, j jVar) {
        Handler handler = this.b;
        if (handler != null) {
            handler.post(new m(this, list, jVar));
        }
    }
}
