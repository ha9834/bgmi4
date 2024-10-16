package com.tencent.midas.http.midashttp;

import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public class APMidasHttpTimeReportHandler extends APMidasBaseHttpHandler {
    private final APMidasNetworkManager midasNetworkManager;

    public APMidasHttpTimeReportHandler(APMidasNetworkManager aPMidasNetworkManager) {
        this.midasNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
        super.onHttpEnd(request, response);
        if (this.midasNetworkManager == null) {
            return;
        }
        if (response != null && response.isSuccess()) {
            this.midasNetworkManager.notifyNetworkSuccess(request, response);
        } else {
            this.midasNetworkManager.notifyNetworkFailure(request, response);
        }
    }
}
