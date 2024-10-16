package com.tencent.imsdk.android.tools.net.volley.upload;

import com.tencent.imsdk.android.tools.net.volley.AuthFailureError;
import com.tencent.imsdk.android.tools.net.volley.Request;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes.dex */
public class HttpClientStack implements HttpStack {
    int CONNECTION_TIME_OUT_MS = 15000;
    protected final HttpClient mClient;

    protected void onPrepareRequest(HttpUriRequest httpUriRequest) throws IOException {
    }

    public HttpClientStack(HttpClient httpClient) {
        this.mClient = httpClient;
    }

    private static void addHeaders(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    private static List<NameValuePair> getPostParameterPairs(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            arrayList.add(new BasicNameValuePair(str, map.get(str)));
        }
        return arrayList;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpEntity entity;
        Header contentEncoding;
        HttpUriRequest createHttpRequest = createHttpRequest(request, map);
        if (request.isShouldGzip()) {
            createHttpRequest.addHeader(HttpStack.HEADER_ACCEPT_ENCODING, HttpStack.ENCODING_GZIP);
        }
        addHeaders(createHttpRequest, map);
        addHeaders(createHttpRequest, request.getHeaders());
        onPrepareRequest(createHttpRequest);
        HttpParams params = createHttpRequest.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, this.CONNECTION_TIME_OUT_MS);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        HttpResponse execute = this.mClient.execute(createHttpRequest);
        if (execute != null && (entity = execute.getEntity()) != null && (contentEncoding = entity.getContentEncoding()) != null) {
            HeaderElement[] elements = contentEncoding.getElements();
            int length = elements.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (elements[i].getName().equalsIgnoreCase(HttpStack.ENCODING_GZIP)) {
                    execute.setEntity(new HttpEntityWrapper(execute.getEntity()));
                    break;
                }
                i++;
            }
        }
        return execute;
    }

    static HttpUriRequest createHttpRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                HttpPost httpPost = new HttpPost(request.getUrl());
                httpPost.addHeader("Content-Type", request.getBodyContentType());
                setEntityIfNonEmptyBody(httpPost, request);
                return httpPost;
            case 2:
                HttpPut httpPut = new HttpPut(request.getUrl());
                httpPut.addHeader("Content-Type", request.getBodyContentType());
                setEntityIfNonEmptyBody(httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.getUrl());
            case 4:
                return new HttpHead(request.getUrl());
            case 5:
                return new HttpOptions(request.getUrl());
            case 6:
                return new HttpTrace(request.getUrl());
            case 7:
                HttpPatch httpPatch = new HttpPatch(request.getUrl());
                httpPatch.addHeader("Content-Type", request.getBodyContentType());
                setEntityIfNonEmptyBody(httpPatch, request);
                return httpPatch;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void setEntityIfNonEmptyBody(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws IOException, AuthFailureError {
        if (request instanceof MultiPartRequest) {
            httpEntityEnclosingRequestBase.setEntity(((MultiPartRequest) request).getMultipartEntity());
            return;
        }
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    /* loaded from: classes.dex */
    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "PATCH";

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return METHOD_NAME;
        }

        public HttpPatch() {
        }

        public HttpPatch(URI uri) {
            setURI(uri);
        }

        public HttpPatch(String str) {
            setURI(URI.create(str));
        }
    }
}
