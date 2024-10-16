package com.tencent.imsdk.android.tools.net.volley;

/* loaded from: classes.dex */
public interface RetryPolicy {
    int getCurrentRetryCount();

    int getCurrentTimeout();

    void retry(VolleyError volleyError) throws VolleyError;
}
