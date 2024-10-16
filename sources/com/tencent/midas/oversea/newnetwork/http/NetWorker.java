package com.tencent.midas.oversea.newnetwork.http;

import android.content.Context;
import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APSPTools;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newnetwork.model.APDataReportReq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NetWorker {
    public static final String TAG = "NetWorker";

    public static void parseConnectTimeout(JSONObject jSONObject) {
        int i;
        int i2;
        int i3;
        try {
            NetTimeoutHelper NetTimeout = GlobalData.singleton().NetTimeout();
            if (jSONObject.has("to4") && (i3 = jSONObject.getInt("to4")) != 0) {
                NetTimeout.setConnectTimeout("wifi", i3);
                NetTimeout.setConnectTimeout("4g", i3);
            }
            if (jSONObject.has("to3") && (i2 = jSONObject.getInt("to3")) != 0) {
                NetTimeout.setConnectTimeout("3g", i2);
            }
            if (jSONObject.has("to2") && (i = jSONObject.getInt("to2")) != 0) {
                NetTimeout.setConnectTimeout("2g", i);
            }
            float floatValue = jSONObject.has("alpha1") ? Float.valueOf(jSONObject.getString("alpha1")).floatValue() : 0.0f;
            float floatValue2 = jSONObject.has("alpha2") ? Float.valueOf(jSONObject.getString("alpha2")).floatValue() : 0.0f;
            if (jSONObject.has("domain_first")) {
                APSPTools.putInt(APMidasPayNewAPI.singleton().getApplicationContext(), "domain_first", jSONObject.getInt("domain_first"));
            }
            if (jSONObject.has("detect_domain")) {
                APLog.d("detect_domain from cgi", "succ:" + jSONObject.getString("detect_domain"));
                APSPTools.putString(APMidasPayNewAPI.singleton().getApplicationContext(), "detect_domain", jSONObject.getString("detect_domain"));
            }
            NetTimeout.saveAlpha(floatValue, floatValue2);
        } catch (JSONException e) {
            APLog.e(TAG, "parseConnectTimeout(): " + e.getMessage());
        }
    }

    public static int getTimeOut(String str) {
        String str2;
        Context applicationContext = APMidasPayNewAPI.singleton().getApplicationContext();
        int i = 1500;
        try {
            if (!APTools.isNetworkConnect(applicationContext)) {
                return 1500;
            }
            if (APTools.isNetworkWIFI(applicationContext)) {
                str2 = "wifi";
            } else if (APTools.isNetwork4G(applicationContext)) {
                str2 = "4g";
            } else {
                str2 = APTools.isNetwork3G(applicationContext) ? "3g" : "2g";
            }
            i = GlobalData.singleton().NetTimeout().getConnectTimeout(str2, str);
            APLog.i(TAG, "NetworkType: " + str2 + " TimeOutValue: " + i);
            return i;
        } catch (Exception e) {
            APLog.e(TAG, "getTimeOut(): " + e.getMessage());
            return i;
        }
    }

    public static void sendReportData(Request request, int i, int i2, String str, Response response) {
        String str2;
        if (request == null) {
            APLog.e(TAG, "Cannot send data report with null request!");
            return;
        }
        if (request instanceof APDataReportReq) {
            APLog.d(TAG, "Current request is data report, no need to send data report!");
            return;
        }
        if (TextUtils.isEmpty(request.getUrlSuffix())) {
            APLog.e(TAG, "Suffix is empty while sending data report!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("name=");
        try {
            String urlSuffix = request.getUrlSuffix();
            sb.append(urlSuffix.substring(urlSuffix.lastIndexOf(47) + 1, urlSuffix.length()));
        } catch (Exception unused) {
            sb.append(request.getUrlSuffix());
        }
        sb.append("&");
        try {
            sb.append("cmd=");
            sb.append(request.getParameters().get(NetworkManager.CMD_TAG));
            sb.append("&");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("reqip=");
        sb.append(request.getHost());
        sb.append("&");
        sb.append("code=");
        sb.append(i2);
        sb.append("&");
        sb.append("json=");
        try {
            if (TextUtils.isEmpty(response.responseBody)) {
                sb.append("norsp");
            } else {
                JSONObject jSONObject = new JSONObject(response.responseBody);
                if (jSONObject.has("ret")) {
                    sb.append(jSONObject.getString("ret"));
                } else {
                    sb.append("ok");
                }
            }
        } catch (JSONException e2) {
            sb.append(e2.toString());
        } catch (Exception e3) {
            sb.append(e3.toString());
        }
        sb.append("&");
        sb.append("times=");
        sb.append(request.currentTryTimeConsume);
        sb.append("&");
        sb.append("network=");
        sb.append(APTools.getNetWorkType(APMidasPayNewAPI.singleton().getApplicationContext()));
        sb.append("&");
        sb.append("errorCode=");
        sb.append(i);
        sb.append("&");
        sb.append("retrytimes=");
        sb.append(request.retryTimes);
        if (i2 == 200) {
            str2 = "yes";
        } else {
            str2 = request.isAllRetriesFailed ? "yes" : "no";
        }
        sb.append("&");
        sb.append("isresult=");
        sb.append(str2);
        sb.append("&");
        sb.append("uuid=");
        sb.append(GlobalData.singleton().getNetToken());
        sb.append("&");
        sb.append("errorMsg=");
        sb.append(str);
        try {
            String defaultHost = Proxy.getDefaultHost();
            if (TextUtils.isEmpty(defaultHost)) {
                defaultHost = "";
            }
            sb.append("&");
            sb.append("proxyip=");
            sb.append(defaultHost);
            int defaultPort = Proxy.getDefaultPort();
            sb.append("&");
            sb.append("proxyport=");
            sb.append(defaultPort);
            sb.append("&getInputStreamTime=");
            sb.append(request.currentGetInputStreamTime);
            sb.append("&getOutputStreamTime=");
            sb.append(request.currentGetOutputStreamTime);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            APDataReportManager.instance().insertData(APDataReportManager.NETWORK_REQUEST, sb.toString());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
