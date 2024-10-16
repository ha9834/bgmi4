package com.twitter.sdk.android.core;

import a.l;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.models.ApiError;
import com.twitter.sdk.android.core.models.ApiErrors;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;

/* loaded from: classes.dex */
public class TwitterApiException extends TwitterException {
    public static final int DEFAULT_ERROR_CODE = 0;
    private final ApiError apiError;
    private final int code;
    private final l response;
    private final TwitterRateLimit twitterRateLimit;

    public TwitterApiException(l lVar) {
        this(lVar, readApiError(lVar), readApiRateLimit(lVar), lVar.a());
    }

    TwitterApiException(l lVar, ApiError apiError, TwitterRateLimit twitterRateLimit, int i) {
        super(createExceptionMessage(i));
        this.apiError = apiError;
        this.twitterRateLimit = twitterRateLimit;
        this.code = i;
        this.response = lVar;
    }

    public int getStatusCode() {
        return this.code;
    }

    public int getErrorCode() {
        ApiError apiError = this.apiError;
        if (apiError == null) {
            return 0;
        }
        return apiError.code;
    }

    public String getErrorMessage() {
        ApiError apiError = this.apiError;
        if (apiError == null) {
            return null;
        }
        return apiError.message;
    }

    public TwitterRateLimit getTwitterRateLimit() {
        return this.twitterRateLimit;
    }

    public l getResponse() {
        return this.response;
    }

    public static TwitterRateLimit readApiRateLimit(l lVar) {
        return new TwitterRateLimit(lVar.b());
    }

    public static ApiError readApiError(l lVar) {
        try {
            String p = lVar.e().d().c().clone().p();
            if (TextUtils.isEmpty(p)) {
                return null;
            }
            return parseApiError(p);
        } catch (Exception e) {
            Twitter.getLogger().e("Twitter", "Unexpected response", e);
            return null;
        }
    }

    static ApiError parseApiError(String str) {
        try {
            ApiErrors apiErrors = (ApiErrors) new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).create().fromJson(str, ApiErrors.class);
            if (apiErrors.errors.isEmpty()) {
                return null;
            }
            return apiErrors.errors.get(0);
        } catch (JsonSyntaxException e) {
            Twitter.getLogger().e("Twitter", "Invalid json: " + str, e);
            return null;
        }
    }

    static String createExceptionMessage(int i) {
        return "HTTP request failed, Status: " + i;
    }
}
