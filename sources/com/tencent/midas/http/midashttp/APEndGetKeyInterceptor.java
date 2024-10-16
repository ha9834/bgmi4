package com.tencent.midas.http.midashttp;

import android.text.TextUtils;
import com.tencent.midas.http.core.Callback;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class APEndGetKeyInterceptor extends APMidasGetKeyInterceptor {
    private APMidasNetworkManager newNetworkManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APEndGetKeyInterceptor(APMidasNetworkManager aPMidasNetworkManager) {
        this.newNetworkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasGetKeyInterceptor, com.tencent.midas.http.core.Interceptor
    public synchronized Response intercept(Request request, Response response) {
        if (request == null) {
            return response;
        }
        if (!(request instanceof APMidasHttpRequest)) {
            return response;
        }
        if (!((APMidasHttpRequest) request).needEndGetKeyInterceptor) {
            return response;
        }
        if (this.newNetworkManager == null) {
            return response;
        }
        if (this.newNetworkManager.isRequestInstanceAGetKeyRequest(request)) {
            return response;
        }
        APMidasHttpRequest getKeyRequest = this.newNetworkManager.getGetKeyRequest();
        if (getKeyRequest == null) {
            return response;
        }
        int midasBusinessResultCodeFromResponse = APMidasHttpResponse.getMidasBusinessResultCodeFromResponse(response);
        if (midasBusinessResultCodeFromResponse != 0) {
            if (midasBusinessResultCodeFromResponse == 1094 || midasBusinessResultCodeFromResponse == 1099 || midasBusinessResultCodeFromResponse == 1105) {
                clearKeyForRequestWhenGetKeyFail(this.newNetworkManager, request);
                return processChangeKeyAndNormalRequestAgain((APMidasHttpRequest) request, response);
            }
        } else if (responseHasNeedChangeKey(response.responseBody)) {
            clearCryptKeyAndKeyTimeForNeedChangeKey(this.newNetworkManager, getKeyRequest);
            this.newNetworkManager.executeRequestAsyncWithNoCustomInterceptors(getKeyRequest, new Callback() { // from class: com.tencent.midas.http.midashttp.APEndGetKeyInterceptor.1
                @Override // com.tencent.midas.http.core.Callback
                public void onResponse(Response response2) {
                    if (APMidasHttpResponse.isResponseMidasBusinessSuccess(response2)) {
                        APEndGetKeyInterceptor.this.newNetworkManager.notifyGetKeySuccess(response2);
                    } else {
                        APMidasGetKeyInterceptor.clearKeyForRequestWhenGetKeyFail(APEndGetKeyInterceptor.this.newNetworkManager, response2);
                    }
                }
            });
        }
        return response;
    }

    private Response processChangeKeyAndNormalRequestAgain(APMidasHttpRequest aPMidasHttpRequest, Response response) {
        synchronized (GET_KEY_LOCK) {
            if (this.newNetworkManager == null) {
                return response;
            }
            Response processGetKey = processGetKey(this.newNetworkManager);
            if (APMidasHttpResponse.isResponseMidasBusinessSuccess(processGetKey)) {
                this.newNetworkManager.notifyGetKeySuccess(processGetKey);
                Response executeRequestSyncWithNoCustomInterceptors = this.newNetworkManager.executeRequestSyncWithNoCustomInterceptors(aPMidasHttpRequest);
                int midasBusinessResultCodeFromResponse = APMidasHttpResponse.getMidasBusinessResultCodeFromResponse(executeRequestSyncWithNoCustomInterceptors);
                if (midasBusinessResultCodeFromResponse == 1099 || midasBusinessResultCodeFromResponse == 1094 || midasBusinessResultCodeFromResponse == 1105) {
                    clearKeyForRequestWhenGetKeyFail(this.newNetworkManager, aPMidasHttpRequest);
                }
                return executeRequestSyncWithNoCustomInterceptors;
            }
            clearKeyForRequestWhenGetKeyFail(this.newNetworkManager, processGetKey);
            return response;
        }
    }

    private static boolean responseHasNeedChangeKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject != null && jSONObject.optInt("need_change_key") == 1;
    }
}
