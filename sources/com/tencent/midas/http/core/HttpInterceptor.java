package com.tencent.midas.http.core;

import android.text.TextUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HttpInterceptor implements Interceptor {
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    private static final int DEFAULT_READ_TIMEOUT = 15000;
    private static final int MAX_VALID_RETRY_TIME = 5;
    private static final String TAG = "HTTP";
    private final ArrayList<HttpHandler> httpHandlers = new ArrayList<>();
    private final NetworkManager networkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpInterceptor(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    @Override // com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        return request == null ? response : getResponseFromHttpWithRetry(request);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001f, code lost:
    
        if (r0 >= 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.tencent.midas.http.core.Response getResponseFromHttpWithRetry(com.tencent.midas.http.core.Request r8) {
        /*
            r7 = this;
            com.tencent.midas.http.core.Response r0 = new com.tencent.midas.http.core.Response
            r0.<init>()
            if (r8 != 0) goto L8
            return r0
        L8:
            r0.setRequest(r8)
            long r0 = java.lang.System.currentTimeMillis()
            r8.startTime = r0
            com.tencent.midas.http.core.NetworkManager r0 = r7.networkManager
            r1 = 5
            r2 = 0
            if (r0 == 0) goto L22
            int r0 = r0.getDefaultMaxRetryTimes()
            if (r0 <= r1) goto L1f
            r0 = 5
            goto L23
        L1f:
            if (r0 < 0) goto L22
            goto L23
        L22:
            r0 = 0
        L23:
            int r3 = r8.maxRetryTime
            if (r3 <= r1) goto L29
            r0 = 5
            goto L2c
        L29:
            if (r3 < 0) goto L2c
            r0 = r3
        L2c:
            r1 = 1
            if (r0 > 0) goto L31
            r3 = 1
            goto L32
        L31:
            r3 = 0
        L32:
            com.tencent.midas.http.core.Response r3 = r7.getResponseFromHttp(r8, r3)
            if (r3 == 0) goto L3f
            boolean r4 = r3.isSuccess()
            if (r4 == 0) goto L3f
            return r3
        L3f:
            r4 = r3
            r3 = 0
        L41:
            if (r3 >= r0) goto L62
            int r5 = r3 + 1
            r8.retryTimes = r5
            int r6 = r8.retryTimes
            r7.callAllHandlerOnRetry(r6, r0, r8, r4)
            int r4 = r0 + (-1)
            if (r3 != r4) goto L52
            r3 = 1
            goto L53
        L52:
            r3 = 0
        L53:
            com.tencent.midas.http.core.Response r4 = r7.getResponseFromHttp(r8, r3)
            if (r4 == 0) goto L60
            boolean r3 = r4.isSuccess()
            if (r3 == 0) goto L60
            return r4
        L60:
            r3 = r5
            goto L41
        L62:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.http.core.HttpInterceptor.getResponseFromHttpWithRetry(com.tencent.midas.http.core.Request):com.tencent.midas.http.core.Response");
    }

    private void setHeaders(HttpURLConnection httpURLConnection, Request request) {
        HashMap<String, String> httpHeaders;
        if (request == null || (httpHeaders = request.getHttpHeaders()) == null || httpHeaders.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key)) {
                httpURLConnection.setRequestProperty(key, value);
            }
        }
    }

    private void callAllHandlerOnStart(Request request) {
        if (this.httpHandlers.size() == 0) {
            return;
        }
        Iterator<HttpHandler> it = this.httpHandlers.iterator();
        while (it.hasNext()) {
            it.next().onHttpStart(request);
        }
    }

    private void callAllHandlerOnStop(Request request, Response response) {
        if (this.httpHandlers.size() == 0) {
            return;
        }
        ListIterator<HttpHandler> listIterator = this.httpHandlers.listIterator(this.httpHandlers.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().onHttpEnd(request, response);
        }
    }

    private void callAllHandlerOnRetry(int i, int i2, Request request, Response response) {
        if (this.httpHandlers.size() == 0) {
            return;
        }
        Iterator<HttpHandler> it = this.httpHandlers.iterator();
        while (it.hasNext()) {
            it.next().onHttpRetry(i, i2, request, response);
        }
    }

    private static void trySetCustomHttpsVerify(HttpURLConnection httpURLConnection, Request request) {
        if (httpURLConnection != null && request != null && request.isHttpsRequest() && (httpURLConnection instanceof HttpsURLConnection)) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            HostnameVerifier customHostnameVerifier = request.getCustomHostnameVerifier();
            if (customHostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(customHostnameVerifier);
            }
            SSLSocketFactory customSSLSocketFactory = request.getCustomSSLSocketFactory();
            if (customSSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(customSSLSocketFactory);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0712  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x07b2  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.tencent.midas.http.core.HttpInterceptor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.tencent.midas.http.core.Response getResponseFromHttp(com.tencent.midas.http.core.Request r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 2125
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.http.core.HttpInterceptor.getResponseFromHttp(com.tencent.midas.http.core.Request, boolean):com.tencent.midas.http.core.Response");
    }

    private void setHttpTimeout(HttpURLConnection httpURLConnection, Request request) {
        int i;
        int i2;
        if (httpURLConnection == null) {
            return;
        }
        NetworkManager networkManager = this.networkManager;
        if (networkManager != null) {
            i = networkManager.defaultConnectTimeout;
            i2 = this.networkManager.defaultReadTimeout;
        } else {
            i = 15000;
            i2 = 15000;
        }
        if (request != null && request.connectTimeout > 0) {
            i = request.connectTimeout;
        }
        int i3 = (request == null || request.readTimeout <= 0) ? i2 : request.readTimeout;
        if (i <= 0) {
            i = 15000;
        }
        if (i3 <= 0) {
            i3 = 15000;
        }
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i3);
    }

    private void closeStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHttpHandler(HttpHandler httpHandler) {
        if (httpHandler != null) {
            this.httpHandlers.add(httpHandler);
        }
    }
}
