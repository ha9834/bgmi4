package com.twitter.sdk.android.core;

import okhttp3.s;

/* loaded from: classes.dex */
public class TwitterRateLimit {
    private static final String LIMIT_KEY = "x-rate-limit-limit";
    private static final String REMAINING_KEY = "x-rate-limit-remaining";
    private static final String RESET_KEY = "x-rate-limit-reset";
    private int remainingRequest;
    private int requestLimit;
    private long resetSeconds;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterRateLimit(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("headers must not be null");
        }
        for (int i = 0; i < sVar.a(); i++) {
            if (LIMIT_KEY.equals(sVar.a(i))) {
                this.requestLimit = Integer.valueOf(sVar.b(i)).intValue();
            } else if (REMAINING_KEY.equals(sVar.a(i))) {
                this.remainingRequest = Integer.valueOf(sVar.b(i)).intValue();
            } else if (RESET_KEY.equals(sVar.a(i))) {
                this.resetSeconds = Long.valueOf(sVar.b(i)).longValue();
            }
        }
    }

    public int getLimit() {
        return this.requestLimit;
    }

    public int getRemaining() {
        return this.remainingRequest;
    }

    public long getReset() {
        return this.resetSeconds;
    }
}
