package com.tencent.midas.http.core;

/* loaded from: classes.dex */
public interface HttpHandler {
    void onHttpEnd(Request request, Response response);

    void onHttpRetry(int i, int i2, Request request, Response response);

    void onHttpStart(Request request);
}
