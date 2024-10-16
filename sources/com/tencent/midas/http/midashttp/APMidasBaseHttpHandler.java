package com.tencent.midas.http.midashttp;

import com.tencent.midas.http.core.HttpHandler;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public class APMidasBaseHttpHandler implements HttpHandler {
    @Override // com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
    }

    @Override // com.tencent.midas.http.core.HttpHandler
    public void onHttpRetry(int i, int i2, Request request, Response response) {
    }

    @Override // com.tencent.midas.http.core.HttpHandler
    public void onHttpStart(Request request) {
    }
}
