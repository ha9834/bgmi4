package com.tencent.midas.http.core;

import android.os.Looper;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class Request {
    public Delivery delivery;
    private HostnameVerifier hostnameVerifier;
    HttpURLConnection httpURLConnection;
    private HttpURL httpUrl;
    private SSLSocketFactory sslSocketFactory;
    public long startTime = 0;
    public long currentTryTime = 0;
    public long currentTryTimeConsume = 0;
    public long currentGetOutputStreamTime = -1;
    public long currentGetInputStreamTime = -1;
    public int retryTimes = 0;
    public boolean isAllRetriesFailed = false;
    public int maxRetryTime = -1;
    private AtomicBoolean stopped = new AtomicBoolean(false);
    public String method = "POST";
    private HashMap<String, String> headers = new HashMap<>();
    private HashMap<String, String> parameters = new HashMap<>();
    public int connectTimeout = 0;
    public int readTimeout = 0;

    /* loaded from: classes.dex */
    public interface Method {
        public static final String GET = "GET";
        public static final String POST = "POST";
    }

    public void onHttpEnd(Response response) {
    }

    public void onHttpRetry(int i, int i2, Request request, Response response) {
    }

    public void onHttpStart() {
    }

    public void resetGetOutputStreamTimeAndGetInputStreamTime() {
        this.currentGetOutputStreamTime = -1L;
        this.currentGetInputStreamTime = -1L;
    }

    public final void setCustomHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (hostnameVerifier != null) {
            this.hostnameVerifier = hostnameVerifier;
        }
    }

    public final void clearCustomHostnameVerifier() {
        this.hostnameVerifier = null;
    }

    public final void clearCustomSSLSocketFactory() {
        this.sslSocketFactory = null;
    }

    public void setCustomSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory != null) {
            this.sslSocketFactory = sSLSocketFactory;
        }
    }

    public HostnameVerifier getCustomHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public SSLSocketFactory getCustomSSLSocketFactory() {
        return this.sslSocketFactory;
    }

    public void setURL(HttpURL httpURL) {
        if (httpURL == null) {
            return;
        }
        this.httpUrl = httpURL;
    }

    public final void addHttpHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.headers.put(str, str2);
    }

    public final boolean hasHttpHeader(String str, String str2) {
        String str3;
        return (TextUtils.isEmpty(str) || str2 == null || (str3 = this.headers.get(str)) == null || !str2.equals(str3)) ? false : true;
    }

    public final void removeHttpHeader(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || str2 == null || (str3 = this.headers.get(str)) == null || !str2.equals(str3)) {
            return;
        }
        this.headers.remove(str);
    }

    public final void addHttpParameters(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.parameters.put(str, str2);
    }

    public String constructAllParams() {
        if (this.parameters.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public HashMap<String, String> getHttpHeaders() {
        return this.headers;
    }

    public HashMap<String, String> getParameters() {
        return this.parameters;
    }

    public String getParameter(String str) {
        return (!TextUtils.isEmpty(str) && this.parameters.containsKey(str)) ? this.parameters.get(str) : "";
    }

    public HttpURL getHttpUrl() {
        return this.httpUrl;
    }

    public boolean isHttpsRequest() {
        HttpURL httpURL = this.httpUrl;
        return httpURL != null && httpURL.isSchemaHttps();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPostRequest() {
        return "POST".equals(this.method);
    }

    public boolean isRequestWithIP() {
        HttpURL httpURL = this.httpUrl;
        return httpURL != null && httpURL.hostIsIP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean hasParameters() {
        return this.parameters.size() > 0;
    }

    public String getFullURLString() {
        HttpURL httpURL = this.httpUrl;
        if (httpURL == null) {
            return "";
        }
        String fullUrlString = httpURL.getFullUrlString();
        if (!isGetRequest() || !hasParameters()) {
            return fullUrlString;
        }
        return fullUrlString + "?" + constructAllParams();
    }

    public void setHost(String str) {
        HttpURL httpURL = this.httpUrl;
        if (httpURL != null) {
            httpURL.host = str;
        }
    }

    public void setPort(String str) {
        HttpURL httpURL = this.httpUrl;
        if (httpURL != null) {
            httpURL.port = str;
        }
    }

    public String getHost() {
        HttpURL httpURL = this.httpUrl;
        return httpURL != null ? httpURL.host : "";
    }

    public String getUrlSuffix() {
        HttpURL httpURL = this.httpUrl;
        return httpURL != null ? httpURL.suffix : "";
    }

    public void stopRequest() {
        this.stopped.set(true);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new Runnable() { // from class: com.tencent.midas.http.core.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Request.this.httpURLConnection != null) {
                        Request.this.httpURLConnection.disconnect();
                    }
                }
            }).start();
            return;
        }
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public boolean isStopped() {
        return this.stopped.get();
    }
}
