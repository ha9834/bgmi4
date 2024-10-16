package com.tencent.imsdk.android.tools.net.volley;

/* loaded from: classes.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 10000;
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;

    public DefaultRetryPolicy() {
        this(10000, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.mCurrentTimeoutMs = i;
        this.mMaxNumRetries = i2;
        this.mBackoffMultiplier = f;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.mCurrentTimeoutMs;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    public float getBackoffMultiplier() {
        return this.mBackoffMultiplier;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.RetryPolicy
    public void retry(VolleyError volleyError) throws VolleyError {
        this.mCurrentRetryCount++;
        int i = this.mCurrentTimeoutMs;
        this.mCurrentTimeoutMs = (int) (i + (i * this.mBackoffMultiplier));
        if (!hasAttemptRemaining()) {
            throw volleyError;
        }
    }

    protected boolean hasAttemptRemaining() {
        return this.mCurrentRetryCount <= this.mMaxNumRetries;
    }
}
