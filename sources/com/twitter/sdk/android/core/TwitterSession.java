package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;

/* loaded from: classes.dex */
public class TwitterSession extends Session<TwitterAuthToken> {
    public static final long UNKNOWN_USER_ID = -1;
    public static final String UNKNOWN_USER_NAME = "";

    @SerializedName("user_name")
    private final String userName;

    public TwitterSession(TwitterAuthToken twitterAuthToken, long j, String str) {
        super(twitterAuthToken, j);
        this.userName = str;
    }

    public long getUserId() {
        return getId();
    }

    public String getUserName() {
        return this.userName;
    }

    @Override // com.twitter.sdk.android.core.Session
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        TwitterSession twitterSession = (TwitterSession) obj;
        String str = this.userName;
        return str != null ? str.equals(twitterSession.userName) : twitterSession.userName == null;
    }

    @Override // com.twitter.sdk.android.core.Session
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.userName;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    /* loaded from: classes.dex */
    static class Serializer implements SerializationStrategy<TwitterSession> {
        private final Gson gson = new Gson();

        @Override // com.twitter.sdk.android.core.internal.persistence.SerializationStrategy
        public String serialize(TwitterSession twitterSession) {
            if (twitterSession == null || twitterSession.getAuthToken() == null) {
                return "";
            }
            try {
                return this.gson.toJson(twitterSession);
            } catch (Exception e) {
                Twitter.getLogger().d("Twitter", e.getMessage());
                return "";
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.twitter.sdk.android.core.internal.persistence.SerializationStrategy
        public TwitterSession deserialize(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (TwitterSession) this.gson.fromJson(str, TwitterSession.class);
            } catch (Exception e) {
                Twitter.getLogger().d("Twitter", e.getMessage());
                return null;
            }
        }
    }
}
