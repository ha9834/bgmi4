package com.tencent.midas.http.core;

/* loaded from: classes.dex */
public interface Call {

    /* loaded from: classes.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    void enqueue(Callback callback);

    void enqueueWithNoCustomInterceptor(Callback callback);

    Response execute();

    Response executeWithAllCustomInterceptor();

    Response executeWithNoCustomInterceptor();

    boolean isCanceled();

    boolean isExecuted();
}
