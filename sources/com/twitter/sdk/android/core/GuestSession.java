package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;

/* loaded from: classes.dex */
public class GuestSession extends Session<GuestAuthToken> {
    public static final long LOGGED_OUT_USER_ID = 0;

    public GuestSession(GuestAuthToken guestAuthToken) {
        super(guestAuthToken, 0L);
    }

    /* loaded from: classes.dex */
    public static class Serializer implements SerializationStrategy<GuestSession> {
        private final Gson gson = new GsonBuilder().registerTypeAdapter(GuestAuthToken.class, new AuthTokenAdapter()).create();

        @Override // com.twitter.sdk.android.core.internal.persistence.SerializationStrategy
        public String serialize(GuestSession guestSession) {
            if (guestSession == null || guestSession.getAuthToken() == null) {
                return "";
            }
            try {
                return this.gson.toJson(guestSession);
            } catch (Exception e) {
                Twitter.getLogger().d("Twitter", "Failed to serialize session " + e.getMessage());
                return "";
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.twitter.sdk.android.core.internal.persistence.SerializationStrategy
        public GuestSession deserialize(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (GuestSession) this.gson.fromJson(str, GuestSession.class);
            } catch (Exception e) {
                Twitter.getLogger().d("Twitter", "Failed to deserialize session " + e.getMessage());
                return null;
            }
        }
    }
}
