package com.tencent.midas.http.core;

import android.text.TextUtils;
import android.util.Patterns;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: classes.dex */
public final class HttpURL {
    public String host;
    public String port;
    public String schema;
    public String suffix;

    /* loaded from: classes.dex */
    public interface SCHEMA {
        public static final String HTTP = "http";
        public static final String HTTPS = "https";
    }

    public HttpURL(String str, String str2) {
        this.schema = str;
        this.host = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFullUrlString() {
        StringBuilder sb = new StringBuilder();
        if ("http".equals(this.schema)) {
            sb.append("https://");
        } else if ("https".equals(this.schema)) {
            sb.append("https://");
        }
        if (!TextUtils.isEmpty(this.host)) {
            sb.append(this.host);
        }
        if (!TextUtils.isEmpty(this.port)) {
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.port);
        }
        if (!TextUtils.isEmpty(this.suffix)) {
            if (this.suffix.startsWith("/")) {
                String str = this.suffix;
                this.suffix = str.substring(1, str.length());
            }
            sb.append("/");
            sb.append(this.suffix);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hostIsIP() {
        return !TextUtils.isEmpty(this.host) && Patterns.IP_ADDRESS.matcher(this.host).matches();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSchemaHttps() {
        return "https".equals(this.schema);
    }
}
