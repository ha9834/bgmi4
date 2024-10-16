package com.twitter.sdk.android.core;

import a.l;

/* loaded from: classes.dex */
public class Result<T> {
    public final T data;
    public final l response;

    public Result(T t, l lVar) {
        this.data = t;
        this.response = lVar;
    }
}
