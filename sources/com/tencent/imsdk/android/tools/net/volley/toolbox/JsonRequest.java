package com.tencent.imsdk.android.tools.net.volley.toolbox;

import com.tencent.imsdk.android.tools.net.volley.NetworkResponse;
import com.tencent.imsdk.android.tools.net.volley.Request;
import com.tencent.imsdk.android.tools.net.volley.Response;
import com.tencent.imsdk.android.tools.net.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class JsonRequest<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", "utf-8");
    private Response.Listener<T> mListener;
    private final String mRequestBody;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(1, str, str2, listener, errorListener);
    }

    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.mRequestBody = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, "utf-8");
            return null;
        }
    }
}
