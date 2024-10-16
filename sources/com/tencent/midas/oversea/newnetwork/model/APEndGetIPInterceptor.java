package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Interceptor;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpRequest;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newnetwork.http.NetWorker;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.mtt.engine.http.HttpUtils;
import com.uqm.crashsight.CrashSight;
import java.net.URLDecoder;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APEndGetIPInterceptor implements Interceptor {
    public static final String TAG = "APEndGetIPInterceptor";

    @Override // com.tencent.midas.http.core.Interceptor
    public Response intercept(Request request, Response response) {
        if (request == null || !(request instanceof APMidasHttpRequest)) {
            return response;
        }
        APMidasHttpRequest aPMidasHttpRequest = (APMidasHttpRequest) request;
        if (response == null || TextUtils.isEmpty(response.responseBody)) {
            return response;
        }
        String str = response.responseBody;
        if (aPMidasHttpRequest.getParameter(NetworkManager.CMD_TAG).contains(NetworkManager.CMD_GET_IP_LIST)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject(NetworkManager.CMD_GET_IP_LIST);
                if (Integer.parseInt(jSONObject.optString("ret")) == 0) {
                    if (jSONObject.has("comm_config")) {
                        JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(jSONObject.getString("comm_config"), HttpUtils.DEFAULT_ENCODE_NAME));
                        try {
                            GlobalData.singleton().heartBeat = Long.parseLong(jSONObject2.optString("heartbeat"));
                        } catch (NumberFormatException e) {
                            APLog.e(TAG, "parse heartbeat fail: " + e.getMessage());
                        }
                        boolean z = true;
                        if (jSONObject2.has("is_google_new")) {
                            GlobalData.isGoogleNew = jSONObject2.optBoolean("is_google_new", true);
                        }
                        if (jSONObject2.has("use_highest_google_api")) {
                            if (jSONObject2.optInt("use_highest_google_api", 1) == 0) {
                                z = false;
                            }
                            GlobalData.useHighestGoogleApi = z;
                            APSPTools.putString(APMidasPayNewAPI.singleton().getApplicationContext(), "use_highest_google_api", GlobalData.useHighestGoogleApi ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : CrashSight.SDK_IS_DEV);
                        }
                        if (jSONObject2.has("detect_domain")) {
                            APLog.d("GetIpInterceptor", "detect_domain " + jSONObject2.getString("detect_domain"));
                            APSPTools.putString(APMidasPayNewAPI.singleton().getApplicationContext(), "detect_domain", jSONObject2.getString("detect_domain"));
                        }
                        NetWorker.parseConnectTimeout(jSONObject2);
                    }
                    if (jSONObject.has(NetworkManager.CMD_INFO)) {
                        GlobalData.singleton().IPManager().updateIp(APMidasPayNewAPI.singleton().getApplicationContext(), jSONObject.getJSONArray(NetworkManager.CMD_INFO).toString());
                    }
                } else {
                    APLog.i(TAG, "retCode is not zero.");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return response;
    }
}
