package com.tencent.midas.http.midashttp;

import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public class APMidasHttpResponseHandler extends APMidasBaseHttpHandler {
    private APMidasNetworkManager newNetworkManager;

    public APMidasHttpResponseHandler(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
        APMidasNetworkManager aPMidasNetworkManager;
        super.onHttpEnd(request, response);
        if (request == null || response == null || (aPMidasNetworkManager = this.newNetworkManager) == null || !(request instanceof APMidasHttpRequest)) {
            return;
        }
        response.setTag(new APMidasHttpResponse(aPMidasNetworkManager.getContext(), response));
    }
}
