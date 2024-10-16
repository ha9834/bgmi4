package com.tencent.imsdk.android.tools.net.volley.toolbox;

import com.tencent.imsdk.android.tools.net.volley.AuthFailureError;
import com.tencent.imsdk.android.tools.net.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

/* loaded from: classes.dex */
public interface HttpStack {
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
