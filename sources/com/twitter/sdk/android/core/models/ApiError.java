package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class ApiError {

    @SerializedName("code")
    public final int code;

    @SerializedName("message")
    public final String message;

    public ApiError(String str, int i) {
        this.message = str;
        this.code = i;
    }
}
