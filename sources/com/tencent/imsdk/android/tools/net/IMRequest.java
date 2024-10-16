package com.tencent.imsdk.android.tools.net;

import com.tencent.imsdk.android.tools.net.volley.AuthFailureError;
import com.tencent.imsdk.android.tools.net.volley.NetworkResponse;
import com.tencent.imsdk.android.tools.net.volley.Request;
import com.tencent.imsdk.android.tools.net.volley.Response;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpHeaderParser;
import java.util.Map;

/* loaded from: classes.dex */
public class IMRequest extends Request<byte[]> {
    private final Response.Listener<byte[]> mListener;
    private final Map<String, String> mUrlParams;

    public IMRequest(int i, String str, Map<String, String> map, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.mUrlParams = map;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.mUrlParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public Response<byte[]> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse.data, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public void deliverResponse(byte[] bArr) {
        this.mListener.onResponse(bArr);
    }
}
