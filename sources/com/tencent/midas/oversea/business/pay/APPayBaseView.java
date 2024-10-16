package com.tencent.midas.oversea.business.pay;

import android.app.Activity;

/* loaded from: classes.dex */
public interface APPayBaseView {
    void callBackError(MidasResponse midasResponse);

    void callBackLoginError();

    void callBackSuccess(MidasResponse midasResponse);

    void dismissWaitDialog();

    Activity getActivity();

    APOrder getOrder();

    int getOrderKey();

    void showErrorMsg(String str, MidasResponse midasResponse);

    void showSandboxDialog();

    void showWaitDialog();
}
