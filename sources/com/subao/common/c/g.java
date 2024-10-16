package com.subao.common.c;

import android.text.TextUtils;
import com.subao.common.e.an;
import com.subao.common.e.f;
import com.subao.common.j.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final String f5946a;
    private final an b;
    private final String c;

    protected abstract b.EnumC0172b a();

    protected abstract void a(b.c cVar);

    protected boolean a_() {
        return false;
    }

    protected byte[] b() {
        return null;
    }

    protected abstract String c();

    protected Iterable<Map.Entry<String, String>> h() {
        return null;
    }

    public g(String str, an anVar, String str2) {
        this.f5946a = str;
        this.b = anVar;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.c a2;
        try {
            b.EnumC0172b a3 = a();
            HttpURLConnection a4 = new com.subao.common.j.b(15000, 15000).a(i(), a3, g());
            a(a4);
            switch (a3) {
                case POST:
                case PUT:
                    a2 = com.subao.common.j.b.a(a4, b());
                    break;
                default:
                    a2 = com.subao.common.j.b.b(a4);
                    break;
            }
            a(a2);
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            a((b.c) null);
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        Iterable<Map.Entry<String, String>> h = h();
        if (h != null) {
            for (Map.Entry<String, String> entry : h) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f() {
        return this.f5946a;
    }

    protected String g() {
        return b.a.JSON.e;
    }

    protected final URL i() {
        an anVar = this.b;
        if (anVar == null) {
            return new URL(a_() ? "http" : "https", com.subao.common.e.f.a(f.g.HR).b, -1, c());
        }
        return new URL(anVar.f5971a, this.b.b, this.b.c, c());
    }
}
