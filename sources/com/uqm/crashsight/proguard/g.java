package com.uqm.crashsight.proguard;

import android.content.Context;
import com.helpshift.common.domain.network.NetworkConstants;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public final class g {
    private static g b;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f6615a = null;
    private Context c;

    private g(Context context) {
        this.c = context;
    }

    public static g a(Context context) {
        if (b == null) {
            b = new g(context);
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x018c A[Catch: all -> 0x017f, TRY_LEAVE, TryCatch #12 {all -> 0x017f, blocks: (B:23:0x009b, B:25:0x00a3, B:28:0x00b4, B:38:0x00b2, B:84:0x00dd, B:103:0x00e5, B:90:0x0118, B:93:0x0122, B:51:0x0141, B:56:0x0164, B:69:0x0186, B:71:0x018c), top: B:22:0x009b }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] a(java.lang.String r23, byte[] r24, com.uqm.crashsight.proguard.j r25, java.util.Map<java.lang.String, java.lang.String> r26) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.g.a(java.lang.String, byte[], com.uqm.crashsight.proguard.j, java.util.Map):byte[]");
    }

    private static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                if (str != null && str.toLowerCase().equals("status")) {
                    hashMap.put(str.toLowerCase(), list.get(0));
                } else {
                    hashMap.put(str, list.get(0));
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] b(java.net.HttpURLConnection r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L36
            java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L36
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L33 java.lang.Throwable -> L36
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
            r5.<init>()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
        L16:
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
            if (r3 <= 0) goto L21
            r4 = 0
            r5.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
            goto L16
        L21:
            r5.flush()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L4c
            r1.close()     // Catch: java.lang.Throwable -> L2c
            goto L30
        L2c:
            r0 = move-exception
            r0.printStackTrace()
        L30:
            return r5
        L31:
            r5 = move-exception
            goto L38
        L33:
            r5 = move-exception
            r1 = r0
            goto L4d
        L36:
            r5 = move-exception
            r1 = r0
        L38:
            boolean r2 = com.uqm.crashsight.proguard.m.a(r5)     // Catch: java.lang.Throwable -> L4c
            if (r2 != 0) goto L41
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4c
        L41:
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.lang.Throwable -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            return r0
        L4c:
            r5 = move-exception
        L4d:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Throwable -> L53
            goto L57
        L53:
            r0 = move-exception
            r0.printStackTrace()
        L57:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.g.b(java.net.HttpURLConnection):byte[]");
    }

    private HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            m.e("destUrl is null.", new Object[0]);
            return null;
        }
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.uqm.crashsight.proguard.g.1
            @Override // javax.net.ssl.X509TrustManager
            public final X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str3) throws CertificateException {
                m.c("checkClientTrusted", new Object[0]);
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str3) throws CertificateException {
                m.c("checkServerTrusted", new Object[0]);
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpURLConnection a2 = a(str2, str);
        if (a2 == null) {
            m.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a2.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a2.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), HttpUtils.DEFAULT_ENCODE_NAME));
                }
            }
            a2.setRequestProperty("A37", URLEncoder.encode(str2, HttpUtils.DEFAULT_ENCODE_NAME));
            a2.setRequestProperty("A38", URLEncoder.encode(str2, HttpUtils.DEFAULT_ENCODE_NAME));
            OutputStream outputStream = a2.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a2;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            m.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (n.a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(n.a());
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(NetworkConstants.UPLOAD_CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (m.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
