package com.shieldtunnel.svpn.common.i;

import android.util.Log;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.util.Mimetypes;
import com.shieldtunnel.svpn.common.LogTag;
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
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f5838a;
    private final int b;

    /* renamed from: com.shieldtunnel.svpn.common.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0156a {
        ANY("*"),
        HTML(Mimetypes.MIMETYPE_HTML),
        JSON("application/json"),
        PROTOBUF("application/x-protobuf");


        /* renamed from: a, reason: collision with root package name */
        public final String f5839a;

        EnumC0156a(String str) {
            this.f5839a = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum b {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE");


        /* renamed from: a, reason: collision with root package name */
        public final String f5840a;

        b(String str) {
            this.f5840a = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f5841a;
        public final byte[] b;

        public c(int i, byte[] bArr) {
            this.f5841a = i;
            this.b = bArr;
        }

        public String toString() {
            Locale locale = com.shieldtunnel.svpn.common.f.f.b;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.f5841a);
            byte[] bArr = this.b;
            objArr[1] = Integer.valueOf(bArr != null ? bArr.length : 0);
            return String.format(locale, "[Response: Code=%d, Data Length=%d])", objArr);
        }
    }

    public a(int i, int i2) {
        this.f5838a = i;
        this.b = i2;
    }

    public static URL a(String str) {
        try {
            return new URL(str);
        } catch (RuntimeException unused) {
            throw new f();
        }
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
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
                com.shieldtunnel.svpn.common.c.a(outputStream);
            } catch (RuntimeException unused) {
                throw new f();
            }
        } catch (Throwable th) {
            com.shieldtunnel.svpn.common.c.a((Closeable) null);
            throw th;
        }
    }

    public static c c(HttpURLConnection httpURLConnection) {
        byte[] e;
        try {
            try {
                int b2 = b(httpURLConnection);
                try {
                    e = d(httpURLConnection);
                } catch (IOException unused) {
                    e = e(httpURLConnection);
                }
                if (com.shieldtunnel.svpn.common.b.a(LogTag.NET)) {
                    Locale locale = com.shieldtunnel.svpn.common.f.f.b;
                    Object[] objArr = new Object[3];
                    int i = 0;
                    objArr[0] = httpURLConnection.getURL().toString();
                    objArr[1] = Integer.valueOf(b2);
                    if (e != null) {
                        i = e.length;
                    }
                    objArr[2] = Integer.valueOf(i);
                    Log.d(LogTag.NET, String.format(locale, "[%s] response: code=%d, data size=%d", objArr));
                }
                return new c(b2, e);
            } catch (RuntimeException e2) {
                a(httpURLConnection, e2);
                throw new IOException(e2.getMessage());
            }
        } catch (IOException e3) {
            a(httpURLConnection, e3);
            throw e3;
        }
    }

    private static byte[] d(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] a2 = com.shieldtunnel.svpn.common.c.a(inputStream);
                com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
                return a2;
            } catch (Throwable th) {
                th = th;
                com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private static byte[] e(HttpURLConnection httpURLConnection) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream != null) {
            try {
                return com.shieldtunnel.svpn.common.c.a(errorStream);
            } catch (IOException unused) {
            } finally {
                com.shieldtunnel.svpn.common.c.a((Closeable) errorStream);
            }
        }
        return null;
    }

    private static void f(HttpURLConnection httpURLConnection) {
        if (com.shieldtunnel.svpn.common.b.a(LogTag.NET)) {
            Log.d(LogTag.NET, String.format("Try HTTP request (%s): %s", httpURLConnection.getRequestMethod(), httpURLConnection.getURL().toString()));
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Exception exc) {
        if (com.shieldtunnel.svpn.common.b.a(LogTag.NET)) {
            URL url = httpURLConnection.getURL();
            if (url != null) {
                com.shieldtunnel.svpn.common.b.c(LogTag.NET, url.toString());
            }
            com.shieldtunnel.svpn.common.b.c(LogTag.NET, exc.getMessage());
        }
    }

    public static c a(HttpURLConnection httpURLConnection) {
        f(httpURLConnection);
        try {
            return c(httpURLConnection);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static c a(HttpURLConnection httpURLConnection, byte[] bArr) {
        return a(httpURLConnection, bArr, false);
    }

    public static c a(HttpURLConnection httpURLConnection, byte[] bArr, boolean z) {
        f(httpURLConnection);
        try {
            b(httpURLConnection, bArr, z);
            return c(httpURLConnection);
        } catch (IOException e) {
            a(httpURLConnection, e);
            throw e;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, String str) {
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeader.ACCEPT, str);
        }
    }

    public HttpURLConnection a(URL url, b bVar, String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (bVar != null) {
                httpURLConnection.setRequestMethod(bVar.f5840a);
            }
            httpURLConnection.setConnectTimeout(this.f5838a);
            httpURLConnection.setReadTimeout(this.b);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            b(httpURLConnection, str);
            return httpURLConnection;
        } catch (RuntimeException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static void b(HttpURLConnection httpURLConnection, String str) {
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
    }

    public static int b(HttpURLConnection httpURLConnection) {
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
}
