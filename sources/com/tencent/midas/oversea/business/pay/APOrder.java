package com.tencent.midas.oversea.business.pay;

import com.tencent.midas.oversea.api.IAPMidasPayCallBack;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;

/* loaded from: classes.dex */
public class APOrder {
    public final IAPMidasPayCallBack callBack;
    public final BillingFlowParams request;

    public APOrder(BillingFlowParams billingFlowParams, IAPMidasPayCallBack iAPMidasPayCallBack) {
        this.request = billingFlowParams;
        this.callBack = iAPMidasPayCallBack;
    }
}
