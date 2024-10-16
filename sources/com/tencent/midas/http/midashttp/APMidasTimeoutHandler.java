package com.tencent.midas.http.midashttp;

import com.tencent.midas.http.core.Request;

/* loaded from: classes.dex */
public final class APMidasTimeoutHandler extends APMidasBaseHttpHandler {
    private APMidasNetworkManager newNetworkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasTimeoutHandler(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public final void onHttpStart(Request request) {
        APMidasNetworkManager aPMidasNetworkManager;
        super.onHttpStart(request);
        if (request == null || (aPMidasNetworkManager = this.newNetworkManager) == null) {
            return;
        }
        aPMidasNetworkManager.updateConnectAndReadTimeout();
    }
}
