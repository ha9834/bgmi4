package com.tencent.imsdk.android.tools.net.volley.upload;

import com.tencent.imsdk.android.tools.net.volley.DefaultRetryPolicy;
import com.tencent.imsdk.android.tools.net.volley.NetworkResponse;
import com.tencent.imsdk.android.tools.net.volley.Request;
import com.tencent.imsdk.android.tools.net.volley.Response;
import java.io.File;

/* loaded from: classes.dex */
public abstract class MultiPartRequest<T> extends Request<T> {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 3;
    private static final String PROTOCOL_CHARSET = "utf-8";
    public static final int TIMEOUT_MS = 50000;
    private Response.Listener<T> mListener;
    private MultipartEntity uploadEntity;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public MultiPartRequest(int i, String str, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.uploadEntity = new MultipartEntity();
        setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_MS, 3, 1.0f));
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public String getBodyContentType() {
        return this.uploadEntity.getContentType().getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imsdk.android.tools.net.volley.Request
    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    public void addPart(String str, String str2) {
        this.uploadEntity.addPart(new StringPart(str, str2, "utf-8"));
    }

    public void addPart(String str, File file) {
        this.uploadEntity.addPart(new FilePart(str, file, null, null));
    }

    public MultipartEntity getMultipartEntity() {
        return this.uploadEntity;
    }
}
