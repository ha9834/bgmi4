package com.amazonaws.http.impl.client;

import java.io.IOException;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes.dex */
public final class HttpRequestNoRetryHandler extends DefaultHttpRequestRetryHandler {
    public static final HttpRequestNoRetryHandler Singleton = new HttpRequestNoRetryHandler();

    @Override // org.apache.http.impl.client.DefaultHttpRequestRetryHandler, org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        return false;
    }

    private HttpRequestNoRetryHandler() {
    }
}
