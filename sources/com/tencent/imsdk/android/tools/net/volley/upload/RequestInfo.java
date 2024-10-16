package com.tencent.imsdk.android.tools.net.volley.upload;

import com.tencent.mtt.engine.http.HttpUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestInfo {
    public final String boundary;
    public Map<String, File> fileParams;
    public Map<String, String> headers;
    public Map<String, String> params;
    public String url;

    public RequestInfo() {
        this.boundary = String.valueOf(System.currentTimeMillis());
        this.params = new HashMap();
        this.headers = new HashMap();
        this.fileParams = new HashMap();
    }

    public RequestInfo(String str, Map<String, String> map) {
        this.boundary = String.valueOf(System.currentTimeMillis());
        this.params = new HashMap();
        this.headers = new HashMap();
        this.fileParams = new HashMap();
        this.url = str;
        this.params = map;
    }

    public String getFullUrl() {
        if (this.url != null && this.params != null) {
            StringBuilder sb = new StringBuilder();
            if (!this.url.contains("?")) {
                this.url += "?";
            } else if (!this.url.endsWith("?")) {
                this.url += "&";
            }
            for (String str : this.params.keySet()) {
                try {
                    if (str != null && this.params.get(str) != null) {
                        sb.append(URLEncoder.encode(str, HttpUtils.DEFAULT_ENCODE_NAME));
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.params.get(str), HttpUtils.DEFAULT_ENCODE_NAME));
                        sb.append("&");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (sb.length() > 0 && sb.lastIndexOf("&") == sb.length() - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return this.url + sb.toString();
        }
        return this.url;
    }

    public String getUrl() {
        return this.url;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public Map<String, File> getFileParams() {
        return this.fileParams;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void put(String str, String str2) {
        this.params.put(str, str2);
    }

    public void put(String str, File file) {
        if (this.fileParams.containsKey(str)) {
            this.fileParams.put(str + this.boundary + this.fileParams.size(), file);
            return;
        }
        this.fileParams.put(str, file);
    }

    public void putFile(String str, String str2) {
        if (this.fileParams.containsKey(str)) {
            this.fileParams.put(str + this.boundary + this.fileParams.size(), new File(str2));
            return;
        }
        this.fileParams.put(str, new File(str2));
    }

    public void putAllParams(Map<String, Object> map) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                put(str, (String) obj);
            } else if (obj instanceof File) {
                put(str, (File) obj);
            }
        }
    }
}
