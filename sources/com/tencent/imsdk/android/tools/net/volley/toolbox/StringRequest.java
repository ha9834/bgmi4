package com.tencent.imsdk.android.tools.net.volley.toolbox;

import com.tencent.imsdk.android.tools.net.volley.NetworkResponse;
import com.tencent.imsdk.android.tools.net.volley.Request;
import com.tencent.imsdk.android.tools.net.volley.Response;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class StringRequest extends Request<String> {
    private final Response.Listener<String> mListener;

    public StringRequest(int i, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
    }

    public StringRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public void deliverResponse(String str) {
        this.mListener.onResponse(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
