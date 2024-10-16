package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Interceptor;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpRequest;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;

/* loaded from: classes.dex */
public class APFrontGetIPInterceptor implements Interceptor {
    public static final String TAG = "APFrontGetIPInterceptor";

    @Override // com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        if (request != null && (request instanceof APMidasHttpRequest) && (request instanceof APOverSeaCommReq)) {
            String parameter = request.getParameter(NetworkManager.CMD_TAG);
            if ((TextUtils.isEmpty(parameter) || !parameter.contains(NetworkManager.CMD_GET_IP_LIST)) && GlobalData.singleton().IPManager().isIPOutdated()) {
                APLog.i(TAG, parameter + " need get_ip.");
                if (!TextUtils.isEmpty(parameter)) {
                    parameter = parameter + "|";
                }
                request.addHttpParameters(NetworkManager.CMD_TAG, parameter + NetworkManager.CMD_GET_IP_LIST);
            }
        }
        return response;
    }
}
