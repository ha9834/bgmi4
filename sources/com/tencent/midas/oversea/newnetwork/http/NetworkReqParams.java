package com.tencent.midas.oversea.newnetwork.http;

import android.text.TextUtils;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;

/* loaded from: classes.dex */
public class NetworkReqParams {
    public String reserve = "";
    public String drmInfo = "";
    public String mType = "save";
    public String country = "";
    public String productID = "";
    public String extra = "";
    public String currency = "";
    public String payChannel = "";
    public String goodsZoneID = "";
    public boolean isAutoPay = false;

    public static NetworkReqParams switchParams(Object obj) {
        NetworkReqParams networkReqParams = new NetworkReqParams();
        networkReqParams.goodsZoneID = GlobalData.singleton().goodsZoneID;
        if (obj instanceof BillingFlowParams) {
            BillingFlowParams billingFlowParams = (BillingFlowParams) obj;
            networkReqParams.mType = billingFlowParams.getType();
            networkReqParams.productID = billingFlowParams.getProductID();
            networkReqParams.isAutoPay = billingFlowParams.isAutoPay();
            networkReqParams.country = billingFlowParams.getCountry();
            networkReqParams.currency = billingFlowParams.getCurrencyType();
            networkReqParams.payChannel = billingFlowParams.getPayChannel();
            BillingFlowParams.BillingFlowParamsExtra extra = billingFlowParams.getExtra();
            if (extra != null) {
                networkReqParams.reserve = extra.getAppExtends();
                networkReqParams.drmInfo = extra.getDrmInfo();
                networkReqParams.extra = extra.getChannelExtras();
                if (!TextUtils.isEmpty(extra.getGoodsZoneId())) {
                    networkReqParams.goodsZoneID = extra.getGoodsZoneId();
                }
            }
        }
        return networkReqParams;
    }
}
