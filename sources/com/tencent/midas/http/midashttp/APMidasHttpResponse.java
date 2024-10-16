package com.tencent.midas.http.midashttp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.http.core.Response;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APMidasHttpResponse {
    private static final int ERROR_NETWORK_CONTIMEOUT = 20001;
    private static final int ERROR_NETWORK_HTTPSCMWAP = 20101;
    private static final int ERROR_NETWORK_HTTPSTIMES = 20100;
    private static final int ERROR_NETWORK_HTTPSWIFIPROXY = 20102;
    private static final int ERROR_NETWORK_IOEXCEPTION = 20005;
    private static final int ERROR_NETWORK_READTIMEOUT = 20002;
    private static final int ERROR_NETWORK_SYSTEM = 20000;
    private static final int RESULT_CODE_ERROR_JSON = -101;
    private static final int RESULT_CODE_JSON_CONSTRUCT_ERROR = -104;
    private static final int RESULT_CODE_JSON_RET_EMPTY = -102;
    private static final int RESULT_CODE_JSON_RET_NOT_NUM = -103;
    private static final String RESULT_MSG_SYSTEM_BUSY = "系统繁忙，请稍后再试";
    public Exception exception;
    int httpResultCode;
    int midasBusinessResultCode = -1;
    String midasBusinessResultMsg;
    public String resultData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasHttpResponse(Context context, Response response) {
        this.httpResultCode = 100;
        this.midasBusinessResultMsg = "default_resultMsg";
        this.resultData = "";
        if (response == null) {
            return;
        }
        this.resultData = response.responseBody;
        this.exception = response.exception;
        this.httpResultCode = response.resultCode;
        if (response.isSuccess()) {
            handleSuccess(response);
            return;
        }
        if (response.hasException()) {
            handleException(context, response);
            return;
        }
        if (!response.isResultCodeOK()) {
            this.midasBusinessResultMsg = "网络错误(错误码" + response.resultCode + ")";
            return;
        }
        if (response.hasNotEmptyBody()) {
            return;
        }
        this.midasBusinessResultMsg = "网络连接返回空结果,请稍后再试";
    }

    private void handleException(Context context, Response response) {
        Exception exc = response.exception;
        if (exc instanceof ConnectTimeoutException) {
            this.midasBusinessResultMsg = "网络连接超时,请检查网络";
            this.midasBusinessResultCode = 20001;
        } else if (exc instanceof SocketTimeoutException) {
            this.midasBusinessResultMsg = "网络响应超时,请检查网络";
            this.midasBusinessResultCode = 20002;
        } else if (exc instanceof IOException) {
            this.midasBusinessResultMsg = "网络连接异常,请检查网络";
            this.midasBusinessResultCode = 20005;
        } else {
            this.midasBusinessResultMsg = "网络错误，请稍后再试";
            this.midasBusinessResultCode = 20000;
        }
        if (response.isHttpsResponse()) {
            for (Throwable th = response.exception; th != null; th = th.getCause()) {
                if (APMidasHttpModuleTools.isTimeError(th)) {
                    this.midasBusinessResultCode = ERROR_NETWORK_HTTPSTIMES;
                    this.midasBusinessResultMsg = "您的设备系统时间不正确，请更改" + getErrorCode(ERROR_NETWORK_HTTPSTIMES);
                }
                if (APMidasHttpModuleTools.isWifiProxy(th, context)) {
                    this.midasBusinessResultCode = ERROR_NETWORK_HTTPSWIFIPROXY;
                    this.midasBusinessResultMsg = "您的wifi设置了代理，请更改" + getErrorCode(ERROR_NETWORK_HTTPSWIFIPROXY);
                }
                if (!(th instanceof ConnectTimeoutException) && !(th instanceof SocketTimeoutException) && !(th instanceof UnknownHostException)) {
                    this.midasBusinessResultCode = ERROR_NETWORK_HTTPSCMWAP;
                    this.midasBusinessResultMsg = RESULT_MSG_SYSTEM_BUSY + getErrorCode(ERROR_NETWORK_HTTPSCMWAP);
                }
            }
        }
    }

    private void handleSuccess(Response response) {
        if (!TextUtils.isEmpty(response.responseBody) && !response.responseBody.startsWith("{") && !response.responseBody.endsWith("}")) {
            response.responseBody = "{" + response.responseBody + "}";
        }
        try {
            JSONObject jSONObject = new JSONObject(response.responseBody);
            String optString = jSONObject.optString("ret");
            if (TextUtils.isEmpty(optString)) {
                this.midasBusinessResultCode = -102;
                this.midasBusinessResultMsg = RESULT_MSG_SYSTEM_BUSY;
                return;
            }
            try {
                this.midasBusinessResultCode = Integer.parseInt(optString);
                this.midasBusinessResultMsg = jSONObject.optString("msg");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.midasBusinessResultCode = -103;
                this.midasBusinessResultMsg = RESULT_MSG_SYSTEM_BUSY;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.midasBusinessResultCode = -101;
            this.midasBusinessResultMsg = RESULT_MSG_SYSTEM_BUSY;
        }
    }

    private static String generateFakeJson(int i, String str) {
        return "{\"ret\": \"" + i + "\", \"msg\":\"" + str + "\"}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Response generateFakeMidasResponse(int i, String str) {
        Response response = new Response();
        response.exception = null;
        response.resultCode = 100;
        response.responseBody = generateFakeJson(i, str);
        return response;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static APMidasHttpResponse getMidasHttpResponseFromResponse(Response response) {
        Object tag;
        if (response == null || (tag = response.getTag()) == null || !(tag instanceof APMidasHttpResponse)) {
            return null;
        }
        return (APMidasHttpResponse) tag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMidasBusinessResultCodeFromResponse(Response response) {
        if (response == null || !response.isSuccess()) {
            return -1;
        }
        try {
            return Integer.parseInt(new JSONObject(response.responseBody).optString("ret"));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isResponseMidasBusinessSuccess(Response response) {
        return response != null && getMidasBusinessResultCodeFromResponse(response) == 0;
    }

    private static String getErrorCode(int i) {
        return "(100-100-" + i + ")";
    }
}
