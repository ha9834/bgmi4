package com.tencent.mid.a;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.facebook.internal.ServerProtocol;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.util.AttachmentConstants;
import com.tencent.mid.util.Util;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private HttpHost f6247a;
    private DefaultHttpClient b;
    private String c;
    private Map<String, String> d;
    private com.tencent.mid.util.d e;
    private int f = NetworkConstants.UPLOAD_CONNECT_TIMEOUT;

    public d a(String str, byte[] bArr, String str2, int i) {
        String str3;
        String a2 = a(str);
        this.e.b("[" + a2 + "]Send request(" + bArr.length + "bytes):" + bArr);
        HttpPost httpPost = new HttpPost(a2);
        httpPost.setHeader(Headers.CONNECTION, "Keep-Alive");
        httpPost.removeHeaders(Headers.CACHE_CONTROL);
        httpPost.removeHeaders(HttpHeader.USER_AGENT);
        if (this.f6247a != null) {
            httpPost.addHeader("X-Online-Host", this.c);
            httpPost.addHeader(HttpHeader.ACCEPT, AttachmentConstants.ALLOW_ALL_MIME);
            httpPost.addHeader("Content-Type", "json");
        } else {
            this.b.getParams().removeParameter("http.route.default-proxy");
        }
        if (this.f6247a == null) {
            httpPost.addHeader(Headers.CONTENT_ENCODING, str2);
        } else {
            httpPost.addHeader("X-Content-Encoding", str2);
        }
        httpPost.setEntity(new ByteArrayEntity(bArr));
        HttpResponse execute = this.b.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        int statusCode = execute.getStatusLine().getStatusCode();
        long contentLength = entity.getContentLength();
        this.e.b("recv response status code:" + statusCode + ", content length:" + contentLength);
        byte[] byteArray = EntityUtils.toByteArray(entity);
        str3 = "";
        Header firstHeader = execute.getFirstHeader(Headers.CONTENT_ENCODING);
        if (firstHeader != null) {
            str3 = firstHeader.getValue().toUpperCase().contains(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM) ? new String(c.a(c.a()).a(i).b(byteArray), "UTF-8") : "";
            if (firstHeader.getValue().toUpperCase().contains("RSA")) {
                str3 = com.tencent.mid.util.f.b(byteArray);
            }
            if (firstHeader.getValue().toUpperCase().contains("IDENTITY")) {
                str3 = new String(byteArray, "UTF-8");
            }
        }
        this.e.b("recv response status code:" + statusCode + ", content :" + str3);
        return new d(statusCode, str3);
    }

    public b(String str, Map<String, String> map) {
        this.f6247a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.e = Util.getLogger();
        this.f6247a = Util.getHttpProxy();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f);
        this.b = new DefaultHttpClient(basicHttpParams);
        com.tencent.mid.util.d dVar = this.e;
        StringBuilder sb = new StringBuilder();
        sb.append("proxy==");
        HttpHost httpHost = this.f6247a;
        sb.append(httpHost == null ? Constants.NULL_VERSION_ID : httpHost.getHostName());
        dVar.b(sb.toString());
        if (this.f6247a != null) {
            this.b.getParams().setParameter("http.route.default-proxy", this.f6247a);
        }
        HttpHost httpHost2 = this.f6247a;
        if (httpHost2 != null && httpHost2.getHostName().equals("10.0.0.200")) {
            this.b.getCredentialsProvider().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("ctwap@mycdma.cn", "vnet.mobi"));
        }
        Logger.getLogger("org.apache.http.wire").setLevel(Level.FINEST);
        Logger.getLogger("org.apache.http.headers").setLevel(Level.FINEST);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
        this.b.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() { // from class: com.tencent.mid.a.b.1
            @Override // org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy, org.apache.http.conn.ConnectionKeepAliveStrategy
            public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
                if (keepAliveDuration == -1) {
                    return 20000L;
                }
                return keepAliveDuration;
            }
        });
        this.c = str;
        this.d = map;
    }

    public void a() {
        DefaultHttpClient defaultHttpClient = this.b;
        if (defaultHttpClient != null) {
            defaultHttpClient.getConnectionManager().shutdown();
            this.b = null;
            this.c = null;
            this.d = null;
            this.f6247a = null;
        }
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.d;
        if (map != null && map.size() != 0) {
            int i = 0;
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                String str = i == 0 ? "?" : "&";
                i++;
                sb.append(str);
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public String a(String str) {
        return this.c + str + b();
    }
}
