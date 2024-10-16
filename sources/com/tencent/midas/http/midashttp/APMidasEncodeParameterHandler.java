package com.tencent.midas.http.midashttp;

import android.text.TextUtils;
import com.tencent.midas.http.core.Request;

/* loaded from: classes.dex */
public final class APMidasEncodeParameterHandler extends APMidasBaseHttpHandler {
    private final APMidasNetworkManager networkManager;

    public APMidasEncodeParameterHandler(APMidasNetworkManager aPMidasNetworkManager) {
        this.networkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpStart(Request request) {
        super.onHttpStart(request);
        handleEncodeParameters(request);
    }

    private void handleEncodeParameters(Request request) {
        if (request == null || !(request instanceof APMidasHttpRequest) || this.networkManager == null) {
            return;
        }
        APMidasHttpRequest aPMidasHttpRequest = (APMidasHttpRequest) request;
        if (aPMidasHttpRequest.hasEncodeParameters()) {
            String tryGetEncodeKeyTime = tryGetEncodeKeyTime(aPMidasHttpRequest);
            APMidasEncodeKey tryGetEncodeKey = tryGetEncodeKey(aPMidasHttpRequest);
            if (TextUtils.isEmpty(tryGetEncodeKey.key)) {
                return;
            }
            aPMidasHttpRequest.doEncodeParameters(this.networkManager, tryGetEncodeKey, tryGetEncodeKeyTime);
        }
    }

    private APMidasEncodeKey tryGetEncodeKey(APMidasHttpRequest aPMidasHttpRequest) {
        APMidasEncodeKey aPMidasEncodeKey = new APMidasEncodeKey();
        APMidasNetworkManager aPMidasNetworkManager = this.networkManager;
        if (aPMidasNetworkManager == null || aPMidasHttpRequest == null) {
            return aPMidasEncodeKey;
        }
        String baseKey = aPMidasNetworkManager.getBaseKey();
        aPMidasEncodeKey.keyType = IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_BASE;
        aPMidasEncodeKey.key = baseKey;
        if (aPMidasHttpRequest.needUseBaseKeyToEncode || this.networkManager.getMidasCommonInfoGetter() == null) {
            return aPMidasEncodeKey;
        }
        String openIDFromRequest = aPMidasHttpRequest.getOpenIDFromRequest();
        if (TextUtils.isEmpty(openIDFromRequest)) {
            return aPMidasEncodeKey;
        }
        boolean isCanUseCryptoKeyToEncodeGetKeyRequest = this.networkManager.isCanUseCryptoKeyToEncodeGetKeyRequest();
        String offerIDFromRequest = aPMidasHttpRequest.getOfferIDFromRequest();
        if (TextUtils.isEmpty(offerIDFromRequest)) {
            return aPMidasEncodeKey;
        }
        String secretKeyFromRam = this.networkManager.getSecretKeyFromRam(openIDFromRequest, offerIDFromRequest);
        if (!TextUtils.isEmpty(secretKeyFromRam)) {
            aPMidasEncodeKey.keyType = IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET;
            aPMidasEncodeKey.key = secretKeyFromRam;
        }
        String cryptKeyFromRam = this.networkManager.getCryptKeyFromRam(openIDFromRequest, offerIDFromRequest);
        if (isCanUseCryptoKeyToEncodeGetKeyRequest) {
            if (!TextUtils.isEmpty(cryptKeyFromRam)) {
                aPMidasEncodeKey.keyType = IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_CRYPT;
                aPMidasEncodeKey.key = cryptKeyFromRam;
            }
        } else {
            boolean isRequestInstanceAGetKeyRequest = this.networkManager.isRequestInstanceAGetKeyRequest(aPMidasHttpRequest);
            if (!TextUtils.isEmpty(cryptKeyFromRam) && !isRequestInstanceAGetKeyRequest) {
                aPMidasEncodeKey.keyType = IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_CRYPT;
                aPMidasEncodeKey.key = cryptKeyFromRam;
            }
        }
        return aPMidasEncodeKey;
    }

    private String tryGetEncodeKeyTime(APMidasHttpRequest aPMidasHttpRequest) {
        APMidasNetworkManager aPMidasNetworkManager = this.networkManager;
        if (aPMidasNetworkManager == null || aPMidasHttpRequest == null || aPMidasNetworkManager.getMidasCommonInfoGetter() == null) {
            return "";
        }
        String openIDFromRequest = aPMidasHttpRequest.getOpenIDFromRequest();
        if (TextUtils.isEmpty(openIDFromRequest)) {
            return "";
        }
        String offerIDFromRequest = aPMidasHttpRequest.getOfferIDFromRequest();
        if (TextUtils.isEmpty(offerIDFromRequest)) {
            return "";
        }
        String keyTimeFromRam = this.networkManager.getKeyTimeFromRam(openIDFromRequest, offerIDFromRequest);
        return TextUtils.isEmpty(keyTimeFromRam) ? "" : keyTimeFromRam;
    }
}
