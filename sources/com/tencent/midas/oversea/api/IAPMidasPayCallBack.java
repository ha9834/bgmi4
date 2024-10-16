package com.tencent.midas.oversea.api;

import com.tencent.midas.oversea.business.pay.MidasResponse;

/* loaded from: classes.dex */
public interface IAPMidasPayCallBack {
    void MidasPayCallBack(MidasResponse midasResponse);

    void MidasPayNeedLogin();
}
