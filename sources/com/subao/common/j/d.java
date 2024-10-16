package com.subao.common.j;

import android.os.AsyncTask;
import android.util.Log;
import com.subao.common.j.b;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;

/* loaded from: classes2.dex */
public class d {
    public static void a(List<o> list, p pVar, String str) {
        a.b(list, pVar, str, b.EnumC0172b.GET, null);
    }

    public static void a(List<o> list, p pVar, String str, byte[] bArr) {
        a.b(list, pVar, str, b.EnumC0172b.POST, bArr);
    }

    /* loaded from: classes2.dex */
    static final class a extends AsyncTask<Void, Void, b.c> {

        /* renamed from: a, reason: collision with root package name */
        private final String f6071a;
        private final b.EnumC0172b b;
        private final byte[] c;
        private final List<o> d;
        private p e;

        public a(p pVar, String str, b.EnumC0172b enumC0172b, byte[] bArr, List<o> list) {
            this.e = pVar;
            this.f6071a = str;
            this.b = enumC0172b;
            this.c = bArr;
            this.d = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(List<o> list, p pVar, String str, b.EnumC0172b enumC0172b, byte[] bArr) {
            new a(pVar, str, enumC0172b, bArr, list).executeOnExecutor(com.subao.common.m.d.a(), new Void[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b.c doInBackground(Void... voidArr) {
            try {
                return a();
            } catch (IOException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(b.c cVar) {
            if (cVar != null) {
                this.e.a(cVar);
            } else {
                this.e.b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        b.c a() {
            HttpURLConnection httpURLConnection;
            Throwable th;
            OutputStream outputStream = null;
            try {
                try {
                    httpURLConnection = new b(15000, 15000).a(b.a(this.f6071a), this.b, b.a.JSON.e);
                } catch (RuntimeException unused) {
                }
            } catch (Throwable th2) {
                httpURLConnection = outputStream;
                th = th2;
            }
            try {
                if (com.subao.common.d.a("SubaoNet")) {
                    Log.d("SubaoNet", String.format("%s: %s", httpURLConnection.getRequestMethod(), httpURLConnection.getURL().toString()));
                }
                if (this.d != null) {
                    for (o oVar : this.d) {
                        httpURLConnection.addRequestProperty(oVar.f6087a, oVar.b);
                    }
                }
                if (this.c != null && this.c.length > 0) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setFixedLengthStreamingMode(this.c.length);
                    try {
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(this.c);
                        outputStream.flush();
                        com.subao.common.e.a(outputStream);
                    } catch (Throwable th3) {
                        com.subao.common.e.a(outputStream);
                        throw th3;
                    }
                }
                b.c a2 = b.a(httpURLConnection);
                if (httpURLConnection != 0) {
                    httpURLConnection.disconnect();
                }
                return a2;
            } catch (RuntimeException unused2) {
                outputStream = httpURLConnection;
                throw new i();
            } catch (Throwable th4) {
                th = th4;
                if (httpURLConnection != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
