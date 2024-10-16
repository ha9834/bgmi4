package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public abstract class AuthToken {

    @SerializedName("created_at")
    protected final long createdAt;

    public abstract boolean isExpired();

    public AuthToken() {
        this(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AuthToken(long j) {
        this.createdAt = j;
    }
}
