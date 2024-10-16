package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Interceptor;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpRequest;
import com.tencent.midas.http.midashttp.APMidasNetworkManager;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APEndGetKeyInterceptor implements Interceptor {
    public static final int SECRET_KEY_ERR = 1094;
    public static final int SECRET_KEY_INVALID = 1099;
    public static final String TAG = "APEndGetKeyInterceptor";
    private APMidasNetworkManager networkManager;

    public APEndGetKeyInterceptor(APMidasNetworkManager aPMidasNetworkManager) {
        this.networkManager = aPMidasNetworkManager;
    }

    @Override // com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        if (request == null || !(request instanceof APMidasHttpRequest)) {
            return response;
        }
        APMidasHttpRequest aPMidasHttpRequest = (APMidasHttpRequest) request;
        if (response == null || TextUtils.isEmpty(response.responseBody)) {
            return response;
        }
        try {
            if (needGetKeyAgain(response.responseBody)) {
                APLog.i(TAG, "NeedChangeKey|" + response.responseBody);
                clearAllKey(aPMidasHttpRequest);
                return requestAgain(aPMidasHttpRequest, response);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response;
    }

    private boolean needGetKeyAgain(String str) throws JSONException {
        int optInt;
        JSONObject jSONObject = new JSONObject(str);
        String[] strArr = {NetworkManager.CMD_ORDER, NetworkManager.CMD_PROVIDE, NetworkManager.CMD_GET_IP_LIST, NetworkManager.CMD_GET_KEY, NetworkManager.CMD_INFO};
        for (int i = 0; i < strArr.length; i++) {
            if (jSONObject.has(strArr[i]) && ((optInt = jSONObject.getJSONObject(strArr[i]).optInt("ret")) == 1094 || optInt == 1099)) {
                return true;
            }
        }
        return false;
    }

    private Response requestAgain(APMidasHttpRequest aPMidasHttpRequest, Response response) {
        if (!(aPMidasHttpRequest instanceof APMidasHttpRequestBase)) {
            return response;
        }
        ((APMidasHttpRequestBase) aPMidasHttpRequest).addGetKey();
        return this.networkManager.executeRequestSyncWithNoCustomInterceptors(aPMidasHttpRequest);
    }

    private void clearAllKey(APMidasHttpRequest aPMidasHttpRequest) {
        if (this.networkManager == null || aPMidasHttpRequest == null) {
            return;
        }
        String offerIDFromRequest = aPMidasHttpRequest.getOfferIDFromRequest();
        this.networkManager.clearAllKey(APMidasPayNewAPI.singleton().getApplicationContext(), aPMidasHttpRequest.getOpenIDFromRequest(), offerIDFromRequest, GlobalData.SDK_VERSION);
    }
}
