package com.tencent.midas.http.midashttp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.http.core.Interceptor;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class APMidasGetKeyInterceptor implements Interceptor {
    static final Object GET_KEY_LOCK = new Object();
    static final int RET_DECRYPT_FAIL = 1105;
    static final int RET_SECKEYERROR = 1094;
    static final int RET_SECKEYVALID = 1099;

    @Override // com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Response processGetKey(APMidasNetworkManager aPMidasNetworkManager) {
        APMidasHttpRequest getKeyRequest;
        Response response = new Response();
        if (aPMidasNetworkManager == null || (getKeyRequest = aPMidasNetworkManager.getGetKeyRequest()) == null) {
            return response;
        }
        Response executeRequestSyncWithNoCustomInterceptors = aPMidasNetworkManager.executeRequestSyncWithNoCustomInterceptors(getKeyRequest);
        if (APMidasHttpResponse.isResponseMidasBusinessSuccess(executeRequestSyncWithNoCustomInterceptors)) {
            return executeRequestSyncWithNoCustomInterceptors;
        }
        APMidasHttpRequest getKeyRequest2 = aPMidasNetworkManager.getGetKeyRequest();
        if (getKeyRequest2 == null) {
            return response;
        }
        getKeyRequest2.needUseBaseKeyToEncode = true;
        return aPMidasNetworkManager.executeRequestSyncWithNoCustomInterceptors(getKeyRequest2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearKeyForRequestWhenGetKeyFail(APMidasNetworkManager aPMidasNetworkManager, Response response) {
        Request request;
        if (aPMidasNetworkManager == null || response == null || (request = response.request()) == null || !aPMidasNetworkManager.isRequestInstanceAGetKeyRequest(request)) {
            return;
        }
        int midasBusinessResultCodeFromResponse = APMidasHttpResponse.getMidasBusinessResultCodeFromResponse(response);
        if (midasBusinessResultCodeFromResponse == 1099 || midasBusinessResultCodeFromResponse == 1094 || midasBusinessResultCodeFromResponse == RET_DECRYPT_FAIL) {
            clearKeyForRequestWhenGetKeyFail(aPMidasNetworkManager, request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearCryptKeyAndKeyTimeForNeedChangeKey(APMidasNetworkManager aPMidasNetworkManager, APMidasHttpRequest aPMidasHttpRequest) {
        Context context;
        IAPMidasCommonInfoGetter midasCommonInfoGetter;
        if (aPMidasNetworkManager == null || aPMidasHttpRequest == null || (context = aPMidasNetworkManager.getContext()) == null || (midasCommonInfoGetter = aPMidasNetworkManager.getMidasCommonInfoGetter()) == null) {
            return;
        }
        String sdkVersion = midasCommonInfoGetter.getSdkVersion();
        if (TextUtils.isEmpty(sdkVersion)) {
            return;
        }
        String offerIDFromRequest = aPMidasHttpRequest.getOfferIDFromRequest();
        if (TextUtils.isEmpty(offerIDFromRequest)) {
            return;
        }
        String openIDFromRequest = aPMidasHttpRequest.getOpenIDFromRequest();
        if (TextUtils.isEmpty(openIDFromRequest)) {
            return;
        }
        aPMidasNetworkManager.clearCryptKeyAndKeyTime(context, openIDFromRequest, offerIDFromRequest, sdkVersion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearKeyForRequestWhenGetKeyFail(APMidasNetworkManager aPMidasNetworkManager, Request request) {
        IAPMidasCommonInfoGetter midasCommonInfoGetter;
        if (aPMidasNetworkManager == null || request == null || !(request instanceof APMidasHttpRequest)) {
            return;
        }
        APMidasHttpRequest aPMidasHttpRequest = (APMidasHttpRequest) request;
        Context context = aPMidasNetworkManager.getContext();
        if (context == null || (midasCommonInfoGetter = aPMidasNetworkManager.getMidasCommonInfoGetter()) == null) {
            return;
        }
        String sdkVersion = midasCommonInfoGetter.getSdkVersion();
        if (TextUtils.isEmpty(sdkVersion)) {
            return;
        }
        String offerIDFromRequest = aPMidasHttpRequest.getOfferIDFromRequest();
        if (TextUtils.isEmpty(offerIDFromRequest)) {
            return;
        }
        String openIDFromRequest = aPMidasHttpRequest.getOpenIDFromRequest();
        if (TextUtils.isEmpty(openIDFromRequest)) {
            return;
        }
        if (aPMidasHttpRequest.isEncodeWithSecretKey()) {
            aPMidasNetworkManager.clearAllKey(context, openIDFromRequest, offerIDFromRequest, sdkVersion);
        } else if (aPMidasHttpRequest.isEncodeWithCryptKey()) {
            aPMidasNetworkManager.clearCryptKeyAndKeyTime(context, openIDFromRequest, offerIDFromRequest, sdkVersion);
        }
    }
}
