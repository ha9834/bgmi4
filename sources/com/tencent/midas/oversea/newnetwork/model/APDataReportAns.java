package com.tencent.midas.oversea.newnetwork.model;

import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APDataReportAns extends APMidasHttpAns {
    public static final String TAG = "APDataReportAns";

    public APDataReportAns(IAPMidasHttpCallback iAPMidasHttpCallback) {
        super(iAPMidasHttpCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleSuccess(Response response) {
        progressJson(response.responseBody, (APMidasHttpRequestBase) response.request());
        return super.handleSuccess(response);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleFailure(Response response) {
        return super.handleFailure(response);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleStop(Response response) {
        return super.handleStop(response);
    }

    private void progressJson(String str, APMidasHttpRequestBase aPMidasHttpRequestBase) {
        try {
            if (!str.startsWith("{")) {
                str = "{" + str;
            }
            if (!str.endsWith("}")) {
                str = str + "}";
            }
            this.resultCode = new JSONObject(str).getInt("ret");
            APLog.i(TAG, "data report: retCode =" + this.resultCode);
        } catch (Exception unused) {
            this.resultCode = -1;
        }
    }
}
