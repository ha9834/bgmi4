package com.subao.common.j;

import android.text.TextUtils;
import android.util.JsonReader;
import com.subao.common.j.b;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.g.c f6067a;
    private final int b;

    public c(com.subao.common.g.c cVar, int i) {
        this.f6067a = cVar;
        this.b = i;
    }

    public void a(int i, String str, String str2, byte[] bArr, String str3) {
        com.subao.common.m.d.a(new b(i, str, str2, bArr, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, byte[] bArr) {
        this.f6067a.a(this.b, i, bArr == null ? "" : new String(bArr));
    }

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f6069a = {"GET", "POST", "PUT", "DELETE"};
        private static final b.EnumC0172b[] b = {b.EnumC0172b.GET, b.EnumC0172b.POST, b.EnumC0172b.PUT, b.EnumC0172b.DELETE};

        static b.EnumC0172b a(String str) {
            int length = f6069a.length;
            for (int i = 0; i < length; i++) {
                if (f6069a[i].compareToIgnoreCase(str) == 0) {
                    return b[i];
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private final int b;
        private final String c;
        private final String d;
        private final byte[] e;
        private final String f;

        b(int i, String str, String str2, byte[] bArr, String str3) {
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = bArr;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                c.this.a(-2, null);
                return;
            }
            b.EnumC0172b a2 = a.a(this.d);
            if (a2 == null) {
                c.this.a(-2, null);
                return;
            }
            try {
                b.c a3 = a(a2);
                c.this.a(a3.f6066a, a3.b);
            } catch (IOException unused) {
                c.this.a(-1, null);
            }
        }

        private b.c a(b.EnumC0172b enumC0172b) {
            int i = this.b;
            HttpURLConnection a2 = new com.subao.common.j.b(i, i).a(com.subao.common.j.b.a(this.c), enumC0172b, (String) null);
            a(a2, this.f);
            switch (enumC0172b) {
                case GET:
                case DELETE:
                    return com.subao.common.j.b.b(a2);
                default:
                    return com.subao.common.j.b.a(a2, this.e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void a(HttpURLConnection httpURLConnection, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    httpURLConnection.addRequestProperty(jsonReader.nextName(), jsonReader.nextString());
                }
                jsonReader.endObject();
            } finally {
                com.subao.common.e.a(jsonReader);
            }
        }
    }
}
