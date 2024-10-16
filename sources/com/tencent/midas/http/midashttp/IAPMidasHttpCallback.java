package com.tencent.midas.http.midashttp;

/* loaded from: classes.dex */
public interface IAPMidasHttpCallback {
    void onFailure(APMidasHttpAns aPMidasHttpAns);

    void onStop(APMidasHttpAns aPMidasHttpAns);

    void onSuccess(APMidasHttpAns aPMidasHttpAns);
}
