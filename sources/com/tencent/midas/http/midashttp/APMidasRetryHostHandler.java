package com.tencent.midas.http.midashttp;

import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class APMidasRetryHostHandler extends APMidasBaseHttpHandler {
    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpStart(Request request) {
        super.onHttpStart(request);
        request.onHttpStart();
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
        super.onHttpEnd(request, response);
        request.onHttpEnd(response);
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpRetry(int i, int i2, Request request, Response response) {
        super.onHttpRetry(i, i2, request, response);
        if (request == null) {
            return;
        }
        request.onHttpRetry(i, i2, request, response);
    }
}
