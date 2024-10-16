package com.tencent.grobot.lite.network.access.http;

import android.util.Pair;
import com.helpshift.common.domain.network.NetworkConstants;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class HttpConnectionStack {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e3  */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void enqueue(java.lang.String r10, com.tencent.grobot.lite.network.access.AccessRequest r11, com.tencent.grobot.lite.network.access.http.NetCallback r12) {
        /*
            r9 = this;
            r0 = -1
            r1 = 0
            if (r11 != 0) goto La
            r10 = -800(0xfffffffffffffce0, float:NaN)
            r9.notifyReponse(r0, r10, r1, r12)
            return
        La:
            r2 = -827(0xfffffffffffffcc5, float:NaN)
            java.lang.String r3 = r11.getMethod()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L79 java.lang.Exception -> L84 java.io.IOException -> L8f java.net.SocketException -> L9c java.net.SocketTimeoutException -> La9 java.net.ConnectException -> Lb6 org.apache.http.conn.ConnectTimeoutException -> Lc3 java.net.MalformedURLException -> Ld0
            java.util.ArrayList r4 = r11.getHeaders()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L79 java.lang.Exception -> L84 java.io.IOException -> L8f java.net.SocketException -> L9c java.net.SocketTimeoutException -> La9 java.net.ConnectException -> Lb6 org.apache.http.conn.ConnectTimeoutException -> Lc3 java.net.MalformedURLException -> Ld0
            java.net.HttpURLConnection r10 = r9.createHttpURLConnection(r10, r3, r4)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L79 java.lang.Exception -> L84 java.io.IOException -> L8f java.net.SocketException -> L9c java.net.SocketTimeoutException -> La9 java.net.ConnectException -> Lb6 org.apache.http.conn.ConnectTimeoutException -> Lc3 java.net.MalformedURLException -> Ld0
            byte[] r3 = r11.getBody()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            if (r3 == 0) goto L2f
            java.io.OutputStream r3 = r10.getOutputStream()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            byte[] r4 = r11.getBody()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r3.write(r4)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r3.flush()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r3.close()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
        L2f:
            int r3 = r10.getResponseCode()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L66
            java.io.InputStream r3 = r10.getInputStream()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r5.<init>()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
        L49:
            int r7 = r4.read(r6)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r8 = 0
            if (r7 == r0) goto L54
            r5.write(r6, r8, r7)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            goto L49
        L54:
            r4.close()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r3.close()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            int r0 = r11.getRequestId()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            byte[] r3 = r5.toByteArray()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r9.notifyReponse(r0, r8, r3, r12)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            goto L71
        L66:
            int r0 = r11.getRequestId()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            int r3 = r10.getResponseCode()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
            r9.notifyReponse(r0, r3, r1, r12)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L85 java.io.IOException -> L90 java.net.SocketException -> L9d java.net.SocketTimeoutException -> Laa java.net.ConnectException -> Lb7 org.apache.http.conn.ConnectTimeoutException -> Lc4 java.net.MalformedURLException -> Ld1 java.lang.Throwable -> Le0
        L71:
            if (r10 == 0) goto Ldf
            goto Ldc
        L75:
            r11 = move-exception
            r10 = r1
            goto Le1
        L79:
            r10 = r1
        L7a:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r9.notifyReponse(r11, r2, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        L84:
            r10 = r1
        L85:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r9.notifyReponse(r11, r2, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        L8f:
            r10 = r1
        L90:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r0 = -826(0xfffffffffffffcc6, float:NaN)
            r9.notifyReponse(r11, r0, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        L9c:
            r10 = r1
        L9d:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r0 = -825(0xfffffffffffffcc7, float:NaN)
            r9.notifyReponse(r11, r0, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        La9:
            r10 = r1
        Laa:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r0 = -823(0xfffffffffffffcc9, float:NaN)
            r9.notifyReponse(r11, r0, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        Lb6:
            r10 = r1
        Lb7:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r0 = -824(0xfffffffffffffcc8, float:NaN)
            r9.notifyReponse(r11, r0, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        Lc3:
            r10 = r1
        Lc4:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r0 = -822(0xfffffffffffffcca, float:NaN)
            r9.notifyReponse(r11, r0, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
            goto Ldc
        Ld0:
            r10 = r1
        Ld1:
            int r11 = r11.getRequestId()     // Catch: java.lang.Throwable -> Le0
            r0 = -820(0xfffffffffffffccc, float:NaN)
            r9.notifyReponse(r11, r0, r1, r12)     // Catch: java.lang.Throwable -> Le0
            if (r10 == 0) goto Ldf
        Ldc:
            r10.disconnect()
        Ldf:
            return
        Le0:
            r11 = move-exception
        Le1:
            if (r10 == 0) goto Le6
            r10.disconnect()
        Le6:
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.grobot.lite.network.access.http.HttpConnectionStack.enqueue(java.lang.String, com.tencent.grobot.lite.network.access.AccessRequest, com.tencent.grobot.lite.network.access.http.NetCallback):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpURLConnection createHttpURLConnection(String str, String str2, ArrayList<Pair<String, String>> arrayList) throws Exception {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            if (arrayList != null) {
                Iterator<Pair<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair<String, String> next = it.next();
                    httpURLConnection.setRequestProperty((String) next.first, (String) next.second);
                }
            }
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(NetworkConstants.UPLOAD_CONNECT_TIMEOUT);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            return httpURLConnection;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private void notifyReponse(int i, int i2, byte[] bArr, NetCallback netCallback) {
        if (netCallback != null) {
            netCallback.onFinish(i, i2, bArr);
        }
    }
}
