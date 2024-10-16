package com.subao.common.j;

import android.util.Log;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.util.Mimetypes;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f6063a;
    private final int b;

    public b(int i, int i2) {
        this.f6063a = i;
        this.b = i2;
    }

    public static URL a(String str) {
        try {
            return new URL(str);
        } catch (RuntimeException unused) {
            throw new i();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static c a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        InputStream errorStream;
        try {
            int c2 = c(httpURLConnection);
            InputStream inputStream2 = null;
            r1 = null;
            byte[] bArr = null;
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                bArr = com.subao.common.e.a(inputStream);
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                com.subao.common.e.a((Closeable) inputStream2);
                throw th;
            }
            com.subao.common.e.a((Closeable) inputStream);
            if (bArr == null && (errorStream = httpURLConnection.getErrorStream()) != null) {
                try {
                    bArr = com.subao.common.e.a(errorStream);
                    com.subao.common.e.a((Closeable) errorStream);
                } catch (Throwable th3) {
                    com.subao.common.e.a((Closeable) errorStream);
                    throw th3;
                }
            }
            try {
                if (com.subao.common.d.a("SubaoNet")) {
                    Locale locale = com.subao.common.e.r.f6001a;
                    Object[] objArr = new Object[3];
                    int i = 0;
                    objArr[0] = httpURLConnection.getURL().toString();
                    objArr[1] = Integer.valueOf(c2);
                    if (bArr != null) {
                        i = bArr.length;
                    }
                    objArr[2] = Integer.valueOf(i);
                    Log.d("SubaoNet", String.format(locale, "[%s] response: code=%d, data size=%d", objArr));
                }
            } catch (Exception unused3) {
            }
            return new c(c2, bArr);
        } catch (IOException e) {
            a(httpURLConnection, e);
            throw e;
        } catch (RuntimeException e2) {
            a(httpURLConnection, e2);
            throw new IOException(e2.getMessage());
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Exception exc) {
        if (com.subao.common.d.a("SubaoNet")) {
            URL url = httpURLConnection.getURL();
            if (url != null) {
                com.subao.common.d.b("SubaoNet", url.toString());
            }
            com.subao.common.d.b("SubaoNet", exc.getMessage());
        }
    }

    public static c b(HttpURLConnection httpURLConnection) {
        d(httpURLConnection);
        try {
            return a(httpURLConnection);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private static void d(HttpURLConnection httpURLConnection) {
        if (com.subao.common.d.a("SubaoNet", 3)) {
            com.subao.common.d.a("SubaoNet", String.format("Try HTTP request (%s): %s", httpURLConnection.getRequestMethod(), httpURLConnection.getURL().toString()));
        }
    }

    public static c a(HttpURLConnection httpURLConnection, byte[] bArr) {
        return a(httpURLConnection, bArr, false);
    }

    private static c a(HttpURLConnection httpURLConnection, byte[] bArr, boolean z) {
        d(httpURLConnection);
        if (bArr != null && bArr.length > 0) {
            if (z) {
                httpURLConnection.setRequestProperty(Headers.CONTENT_ENCODING, HttpStack.ENCODING_GZIP);
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            }
            httpURLConnection.setDoOutput(true);
            try {
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (z) {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                    } else {
                        outputStream.write(bArr);
                        outputStream.flush();
                    }
                    com.subao.common.e.a(outputStream);
                } catch (RuntimeException unused) {
                    throw new i();
                }
            } catch (Throwable th) {
                com.subao.common.e.a((Closeable) null);
                throw th;
            }
        }
        return a(httpURLConnection);
    }

    public static void a(HttpURLConnection httpURLConnection, String str) {
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
    }

    public static void b(HttpURLConnection httpURLConnection, String str) {
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeader.ACCEPT, str);
        }
    }

    public static int c(HttpURLConnection httpURLConnection) {
        int i;
        try {
            try {
                i = httpURLConnection.getResponseCode();
            } catch (IOException unused) {
                i = httpURLConnection.getResponseCode();
            }
        } catch (RuntimeException unused2) {
            i = -1;
        }
        if (i >= 0) {
            return i;
        }
        throw new IOException("No valid response code.");
    }

    public HttpURLConnection a(URL url, EnumC0172b enumC0172b, String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (enumC0172b != null) {
                httpURLConnection.setRequestMethod(enumC0172b.e);
            }
            httpURLConnection.setConnectTimeout(this.f6063a);
            httpURLConnection.setReadTimeout(this.b);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            a(httpURLConnection, str);
            httpURLConnection.setRequestProperty(Headers.CONNECTION, "Close");
            return httpURLConnection;
        } catch (RuntimeException unused) {
            throw new IOException("网络权限被禁用");
        }
    }

    public c a(URL url, String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = a(url, EnumC0172b.GET, str);
            return b(httpURLConnection);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: com.subao.common.j.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0172b {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE");

        public final String e;

        EnumC0172b(String str) {
            this.e = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum a {
        ANY("*"),
        HTML(Mimetypes.MIMETYPE_HTML),
        JSON("application/json"),
        PROTOBUF("application/x-protobuf");

        public final String e;

        a(String str) {
            this.e = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f6066a;
        public final byte[] b;

        public c(int i, byte[] bArr) {
            this.f6066a = i;
            this.b = bArr;
        }

        public String toString() {
            Locale locale = com.subao.common.e.r.f6001a;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.f6066a);
            byte[] bArr = this.b;
            objArr[1] = Integer.valueOf(bArr != null ? bArr.length : 0);
            return String.format(locale, "[Response: Code=%d, Data Length=%d])", objArr);
        }
    }
}
