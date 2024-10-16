package com.tencent.midas.http.midashttp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public class APFrontGetKeyInterceptor extends APMidasGetKeyInterceptor {
    private static final int ERROR_FRONT_GET_KEY_PARAM = 20007;
    private APMidasNetworkManager newNetworkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APFrontGetKeyInterceptor(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasGetKeyInterceptor, com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        if (request == null) {
            return generateInterruptResponseWhenParamError();
        }
        if (!(request instanceof APMidasHttpRequest)) {
            return response;
        }
        APMidasHttpRequest aPMidasHttpRequest = (APMidasHttpRequest) request;
        if (!aPMidasHttpRequest.needFrontGetKeyInterceptor || !aPMidasHttpRequest.hasEncodeParameters()) {
            return response;
        }
        APMidasNetworkManager aPMidasNetworkManager = this.newNetworkManager;
        if (aPMidasNetworkManager == null) {
            return generateInterruptResponseWhenParamError();
        }
        if (aPMidasNetworkManager.getGetKeyRequest() == null || this.newNetworkManager.isRequestInstanceAGetKeyRequest(request)) {
            return response;
        }
        IAPMidasCommonInfoGetter midasCommonInfoGetter = this.newNetworkManager.getMidasCommonInfoGetter();
        if (midasCommonInfoGetter == null) {
            return generateInterruptResponseWhenParamError();
        }
        Context context = this.newNetworkManager.getContext();
        if (context == null) {
            return generateInterruptResponseWhenParamError();
        }
        String offerIDFromRequest = aPMidasHttpRequest.getOfferIDFromRequest();
        if (TextUtils.isEmpty(offerIDFromRequest)) {
            return generateInterruptResponseWhenParamError();
        }
        String sdkVersion = midasCommonInfoGetter.getSdkVersion();
        if (TextUtils.isEmpty(sdkVersion)) {
            return generateInterruptResponseWhenParamError();
        }
        String openIDFromRequest = aPMidasHttpRequest.getOpenIDFromRequest();
        if (TextUtils.isEmpty(openIDFromRequest)) {
            return generateInterruptResponseWhenParamError();
        }
        if (!this.newNetworkManager.needChangeKey(context, openIDFromRequest, offerIDFromRequest, sdkVersion)) {
            return response;
        }
        synchronized (GET_KEY_LOCK) {
            if (!this.newNetworkManager.needChangeKey(context, openIDFromRequest, offerIDFromRequest, sdkVersion)) {
                return response;
            }
            Response processGetKey = processGetKey(this.newNetworkManager);
            if (APMidasHttpResponse.isResponseMidasBusinessSuccess(processGetKey)) {
                this.newNetworkManager.notifyGetKeySuccess(processGetKey);
                return response;
            }
            clearKeyForRequestWhenGetKeyFail(this.newNetworkManager, processGetKey);
            processGetKey.needBreakOtherInterceptors = true;
            return processGetKey;
        }
    }

    private static Response generateInterruptResponseWhenParamError() {
        Response generateFakeMidasResponse = APMidasHttpResponse.generateFakeMidasResponse(ERROR_FRONT_GET_KEY_PARAM, "内部参数错误！");
        generateFakeMidasResponse.needBreakOtherInterceptors = true;
        return generateFakeMidasResponse;
    }
}
