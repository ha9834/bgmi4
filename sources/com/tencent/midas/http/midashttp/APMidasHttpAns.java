package com.tencent.midas.http.midashttp;

import android.text.TextUtils;
import com.tencent.midas.http.core.Callback;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public class APMidasHttpAns implements Callback {
    public Exception exception;
    private IAPMidasHttpCallback midasHttpCallback;
    private APMidasHttpRequest midasHttpRequest;
    protected String resultData;
    protected int resultCode = -1;
    protected String resultMsg = "";
    protected String errorMsg = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleFailure(Response response) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleStop(Response response) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleSuccess(Response response) {
        return true;
    }

    public APMidasHttpAns(IAPMidasHttpCallback iAPMidasHttpCallback) {
        this.midasHttpCallback = iAPMidasHttpCallback;
    }

    public void setAPMidasHttpRequest(APMidasHttpRequest aPMidasHttpRequest) {
        this.midasHttpRequest = aPMidasHttpRequest;
    }

    public APMidasHttpRequest getAPMidasHttpRequest() {
        return this.midasHttpRequest;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMsg;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getResultData() {
        return this.resultData;
    }

    @Override // com.tencent.midas.http.core.Callback
    public void onResponse(Response response) {
        if (response != null) {
            this.resultData = response.responseBody;
            this.exception = response.exception;
            APMidasHttpResponse midasHttpResponseFromResponse = APMidasHttpResponse.getMidasHttpResponseFromResponse(response);
            if (midasHttpResponseFromResponse != null) {
                this.resultMsg = midasHttpResponseFromResponse.midasBusinessResultMsg;
                this.resultCode = midasHttpResponseFromResponse.midasBusinessResultCode;
                this.errorMsg = midasHttpResponseFromResponse.midasBusinessResultMsg;
            }
        }
        if (response != null && response.isStopped) {
            boolean handleStop = handleStop(response);
            IAPMidasHttpCallback iAPMidasHttpCallback = this.midasHttpCallback;
            if (iAPMidasHttpCallback == null || !handleStop) {
                return;
            }
            iAPMidasHttpCallback.onStop(this);
            return;
        }
        if (response != null && response.isSuccess()) {
            boolean handleSuccess = handleSuccess(response);
            IAPMidasHttpCallback iAPMidasHttpCallback2 = this.midasHttpCallback;
            if (iAPMidasHttpCallback2 == null || !handleSuccess) {
                return;
            }
            iAPMidasHttpCallback2.onSuccess(this);
            return;
        }
        boolean handleFailure = handleFailure(response);
        IAPMidasHttpCallback iAPMidasHttpCallback3 = this.midasHttpCallback;
        if (iAPMidasHttpCallback3 == null || !handleFailure) {
            return;
        }
        iAPMidasHttpCallback3.onFailure(this);
    }

    protected String getDecodeKey() {
        APMidasEncodeKey encodeKey;
        APMidasHttpRequest aPMidasHttpRequest = this.midasHttpRequest;
        return (aPMidasHttpRequest == null || (encodeKey = aPMidasHttpRequest.getEncodeKey()) == null || TextUtils.isEmpty(encodeKey.key)) ? "" : encodeKey.key;
    }

    public static APMidasHttpAns generateFakeAPMidasHttpAns(int i, String str) {
        APMidasHttpAns aPMidasHttpAns = new APMidasHttpAns(null);
        aPMidasHttpAns.resultCode = i;
        aPMidasHttpAns.resultMsg = str;
        aPMidasHttpAns.errorMsg = str;
        return aPMidasHttpAns;
    }
}
