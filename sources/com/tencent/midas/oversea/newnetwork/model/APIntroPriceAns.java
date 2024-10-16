package com.tencent.midas.oversea.newnetwork.model;

import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;

/* loaded from: classes.dex */
public class APIntroPriceAns extends APMidasHttpAns {
    public static final String TAG = "APIntroPriceAns";
    private String jIntroInfo;

    public String getJsIntroInfo() {
        return this.jIntroInfo;
    }

    public APIntroPriceAns(IAPMidasHttpCallback iAPMidasHttpCallback) {
        super(iAPMidasHttpCallback);
        this.jIntroInfo = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleSuccess(Response response) {
        APLog.d(TAG, "response data: " + response.responseBody);
        this.jIntroInfo = response.responseBody;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleStop(Response response) {
        APLog.e(TAG, "handleFailure(..): request stop.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleFailure(Response response) {
        APLog.e(TAG, "handleFailure(..): request failed.");
        return true;
    }
}
