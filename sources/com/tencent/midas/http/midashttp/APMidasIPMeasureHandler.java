package com.tencent.midas.http.midashttp;

import android.text.TextUtils;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class APMidasIPMeasureHandler extends APMidasBaseHttpHandler {
    private final APMidasNetworkManager newNetworkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasIPMeasureHandler(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
        super.onHttpEnd(request, response);
        if (request == null || response == null || this.newNetworkManager == null || !(request instanceof APMidasHttpRequest)) {
            return;
        }
        String host = request.getHost();
        if (!TextUtils.isEmpty(host) && response.isSuccess()) {
            this.newNetworkManager.updateIPTimes(host);
        }
    }
}
