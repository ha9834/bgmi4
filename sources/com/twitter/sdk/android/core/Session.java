package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

/* loaded from: classes.dex */
public class Session<T extends AuthToken> {

    @SerializedName("auth_token")
    private final T authToken;

    @SerializedName("id")
    private final long id;

    public Session(T t, long j) {
        if (t == null) {
            throw new IllegalArgumentException("AuthToken must not be null.");
        }
        this.authToken = t;
        this.id = j;
    }

    public T getAuthToken() {
        return this.authToken;
    }

    public long getId() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Session session = (Session) obj;
        if (this.id != session.id) {
            return false;
        }
        T t = this.authToken;
        return t != null ? t.equals(session.authToken) : session.authToken == null;
    }

    public int hashCode() {
        T t = this.authToken;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.id;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
