package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import java.io.IOException;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes.dex */
public class ApacheHttpClient implements HttpClient {
    private final org.apache.http.client.HttpClient httpClient;
    private HttpParams params = null;

    public ApacheHttpClient(ClientConfiguration clientConfiguration) {
        this.httpClient = new HttpClientFactory().createHttpClient(clientConfiguration);
        ((AbstractHttpClient) this.httpClient).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        ((SSLSocketFactory) this.httpClient.getConnectionManager().getSchemeRegistry().getScheme("https").getSocketFactory()).setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        org.apache.http.HttpResponse execute = this.httpClient.execute(createHttpRequest(httpRequest));
        HttpResponse.Builder content = HttpResponse.builder().statusCode(execute.getStatusLine().getStatusCode()).statusText(execute.getStatusLine().getReasonPhrase()).content(execute.getEntity() != null ? execute.getEntity().getContent() : null);
        for (Header header : execute.getAllHeaders()) {
            content.header(header.getName(), header.getValue());
        }
        return content.build();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
        this.httpClient.getConnectionManager().shutdown();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpUriRequest createHttpRequest(HttpRequest httpRequest) {
        HttpRequestBase httpRequestBase;
        String method = httpRequest.getMethod();
        if ("POST".equals(method)) {
            HttpPost httpPost = new HttpPost(httpRequest.getUri());
            httpRequestBase = httpPost;
            if (httpRequest.getContent() != null) {
                httpPost.setEntity(new InputStreamEntity(httpRequest.getContent(), httpRequest.getContentLength()));
                httpRequestBase = httpPost;
            }
        } else if ("GET".equals(method)) {
            httpRequestBase = new HttpGet(httpRequest.getUri());
        } else if ("PUT".equals(method)) {
            HttpPut httpPut = new HttpPut(httpRequest.getUri());
            httpRequestBase = httpPut;
            if (httpRequest.getContent() != null) {
                httpPut.setEntity(new InputStreamEntity(httpRequest.getContent(), httpRequest.getContentLength()));
                httpRequestBase = httpPut;
            }
        } else if ("DELETE".equals(method)) {
            httpRequestBase = new HttpDelete(httpRequest.getUri());
        } else if ("HEAD".equals(method)) {
            httpRequestBase = new HttpHead(httpRequest.getUri());
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + method);
        }
        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals(HttpHeader.HOST)) {
                    httpRequestBase.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.params == null) {
            this.params = new BasicHttpParams();
            this.params.setParameter("http.protocol.handle-redirects", false);
        }
        httpRequestBase.setParams(this.params);
        return httpRequestBase;
    }
}
