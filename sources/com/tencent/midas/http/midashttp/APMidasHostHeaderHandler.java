package com.tencent.midas.http.midashttp;

import android.text.TextUtils;
import android.util.Patterns;
import com.amazonaws.http.HttpHeader;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class APMidasHostHeaderHandler extends APMidasBaseHttpHandler {
    private final ThreadLocal<String> hasSetHostHeader = new ThreadLocal<String>() { // from class: com.tencent.midas.http.midashttp.APMidasHostHeaderHandler.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public String initialValue() {
            return "";
        }
    };
    private final APMidasNetworkManager newNetworkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasHostHeaderHandler(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public final void onHttpStart(Request request) {
        IAPMidasCommonInfoGetter midasCommonInfoGetter;
        super.onHttpStart(request);
        if (request == null || !(request instanceof APMidasHttpRequest) || this.newNetworkManager == null) {
            return;
        }
        APMidasHttpRequest aPMidasHttpRequest = (APMidasHttpRequest) request;
        if (aPMidasHttpRequest.needMidasHostHeader && (midasCommonInfoGetter = this.newNetworkManager.getMidasCommonInfoGetter()) != null) {
            String httpHostHeaderDomain = midasCommonInfoGetter.getHttpHostHeaderDomain(aPMidasHttpRequest);
            if (TextUtils.isEmpty(httpHostHeaderDomain) || Patterns.IP_ADDRESS.matcher(httpHostHeaderDomain).matches() || !Patterns.WEB_URL.matcher(httpHostHeaderDomain).matches()) {
                return;
            }
            request.addHttpHeader(HttpHeader.HOST, httpHostHeaderDomain);
            this.hasSetHostHeader.set(httpHostHeaderDomain);
        }
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public final void onHttpEnd(Request request, Response response) {
        super.onHttpEnd(request, response);
        String str = this.hasSetHostHeader.get();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        request.removeHttpHeader(HttpHeader.HOST, str);
        this.hasSetHostHeader.set("");
    }
}
