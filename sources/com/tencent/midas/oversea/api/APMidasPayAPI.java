package com.tencent.midas.oversea.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.api.request.APMidasBaseRequest;
import com.tencent.midas.oversea.api.request.APMidasMonthRequest;
import com.tencent.midas.oversea.api.request.IProductInfoCallback;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newapi.params.InitParams;
import com.tencent.midas.oversea.newapi.params.NetParams;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newapi.response.InfoCallback;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes.dex */
public class APMidasPayAPI {
    public static final int CLOSE_ALL = 3;
    public static final int CLOSE_LOADING = 1;
    public static final int CLOSE_RESULT = 2;
    public static final int SAVETYPE_GAME = 0;
    public static final int SAVETYPE_GOODS = 1;
    public static final int SAVETYPE_MONTH = 4;
    public static final String TAG = "APMidasPayAPI";
    private String env = "";
    private String idc = "";
    private String idcInfo = "";
    private boolean logEnable = false;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MUILevel {
    }

    private void APMidasPayAPI() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InstanceHolder {
        private static APMidasPayAPI instance = new APMidasPayAPI();

        private InstanceHolder() {
        }
    }

    public static APMidasPayAPI singleton() {
        return InstanceHolder.instance;
    }

    public void showMidasUI(@MUILevel int i) {
        APMidasPayNewAPI.singleton().showMidasUI(i);
        APLog.i("APMidasPayAPI", "showMidasUI(),MidasUILevel: " + i);
    }

    public void setEnv(String str) {
        this.env = str;
        APLog.i("APMidasPayAPI", "setEnv(),env: " + str);
    }

    public String getEnv() {
        return APMidasPayNewAPI.singleton().getEnv();
    }

    public void setLogEnable(boolean z) {
        APMidasPayNewAPI.singleton().setLogEnable(z);
    }

    public boolean isLogEnable() {
        return APMidasPayNewAPI.singleton().isLogEnable();
    }

    public void setReleaseIDC(String str) {
        this.idc = str;
        APLog.i("APMidasPayAPI", "setReleaseIDC(),idc: " + str);
    }

    public void setReleaseIDC(String str, String str2) {
        this.idc = str;
        this.idcInfo = str2;
        APLog.i("APMidasPayAPI", "setReleaseIDC(),idc: " + str + " idcInfo: " + str2);
    }

    public String getReleaseIDC() {
        return APMidasPayNewAPI.singleton().getReleaseIDC();
    }

    public Context getApplicationContext() {
        return APMidasPayNewAPI.singleton().getApplicationContext();
    }

    public void init(Activity activity, APMidasBaseRequest aPMidasBaseRequest, final IAPPayUpdateCallBack iAPPayUpdateCallBack) {
        InitParams.InitParamsExtra initParamsExtra = new InitParams.InitParamsExtra();
        initParamsExtra.setIDCInfo(this.idcInfo);
        initParamsExtra.setGoodsZoneID(aPMidasBaseRequest.goodsZoneId);
        initParamsExtra.setOpenKey(aPMidasBaseRequest.openKey);
        initParamsExtra.setPF(aPMidasBaseRequest.pf);
        initParamsExtra.setPFKey(aPMidasBaseRequest.pfKey);
        initParamsExtra.setSessionID(aPMidasBaseRequest.sessionId);
        initParamsExtra.setSessionType(aPMidasBaseRequest.sessionType);
        APMidasPayNewAPI.singleton().init(activity, new InitParams.Builder().setEnv(this.env).setIDC(this.idc).setOfferID(aPMidasBaseRequest.offerId).setOpenID(aPMidasBaseRequest.openId).setZoneID(aPMidasBaseRequest.zoneId).setExtra(initParamsExtra).build());
        APMidasPayNewAPI.singleton().reProvide(new IAPMidasCallback() { // from class: com.tencent.midas.oversea.api.APMidasPayAPI.1
            @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
            public void callback(int i, String str) {
                iAPPayUpdateCallBack.onUpdate(i, str);
            }
        });
    }

    public void getProductInfo(String str, List<String> list, final IProductInfoCallback iProductInfoCallback) {
        APLog.i("APMidasPayAPI", "getProductInfo()");
        APMidasPayNewAPI.singleton().getProductInfo(str, list, new InfoCallback() { // from class: com.tencent.midas.oversea.api.APMidasPayAPI.2
            @Override // com.tencent.midas.oversea.newapi.response.InfoCallback
            public void callback(String str2) {
                iProductInfoCallback.onProductInfoResp(str2);
            }
        });
    }

    public void getIntroPriceInfo(String str, List<String> list, final IProductInfoCallback iProductInfoCallback) {
        APLog.i("APMidasPayAPI", "getIntroPriceInfo()");
        APMidasPayNewAPI.singleton().getIntroPriceInfo(str, list, new InfoCallback() { // from class: com.tencent.midas.oversea.api.APMidasPayAPI.3
            @Override // com.tencent.midas.oversea.newapi.response.InfoCallback
            public void callback(String str2) {
                IProductInfoCallback iProductInfoCallback2 = iProductInfoCallback;
                if (iProductInfoCallback2 != null) {
                    iProductInfoCallback2.onProductInfoResp(str2);
                }
            }
        });
    }

    public void reProvide(final IAPPayUpdateCallBack iAPPayUpdateCallBack) {
        APLog.i("APMidasPayAPI", "reProvide()");
        APMidasPayNewAPI.singleton().reProvide(new IAPMidasCallback() { // from class: com.tencent.midas.oversea.api.APMidasPayAPI.4
            @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
            public void callback(int i, String str) {
                iAPPayUpdateCallBack.onUpdate(i, str);
                NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.api.APMidasPayAPI.4.1
                    @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                    public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                        APLog.d("reprovide", "data report succ");
                    }

                    @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                    public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                        APLog.d("reprovide\"", "data report failed; ret" + aPMidasHttpAns.getResultCode() + "&msg=" + aPMidasHttpAns.getResultMessage());
                    }

                    @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                    public void onStop(APMidasHttpAns aPMidasHttpAns) {
                        APLog.d("reprovide\"", "data report stopped");
                    }
                });
            }
        });
    }

    public void pay(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        GlobalData singleton = GlobalData.singleton();
        singleton.offerID = aPMidasBaseRequest.offerId;
        singleton.openID = aPMidasBaseRequest.openId;
        singleton.openKey = aPMidasBaseRequest.openKey;
        singleton.pf = aPMidasBaseRequest.pf;
        singleton.pfKey = aPMidasBaseRequest.pfKey;
        singleton.sessionID = aPMidasBaseRequest.sessionId;
        singleton.sessionType = aPMidasBaseRequest.sessionType;
        singleton.zoneID = aPMidasBaseRequest.zoneId;
        singleton.goodsZoneID = aPMidasBaseRequest.goodsZoneId;
        BillingFlowParams.BillingFlowParamsExtra billingFlowParamsExtra = new BillingFlowParams.BillingFlowParamsExtra();
        billingFlowParamsExtra.setDrmInfo(aPMidasBaseRequest.getDrmInfo());
        billingFlowParamsExtra.setGoodsZoneId(aPMidasBaseRequest.goodsZoneId);
        billingFlowParamsExtra.setAppExtends(aPMidasBaseRequest.reserv);
        billingFlowParamsExtra.setChannelExtras(aPMidasBaseRequest.extras);
        BillingFlowParams.Builder builder = new BillingFlowParams.Builder();
        builder.setCountry(aPMidasBaseRequest.country).setCurrencyType(aPMidasBaseRequest.currency_type).setPayChannel(aPMidasBaseRequest.getPayChannel()).setProductID(aPMidasBaseRequest.getAssignProductid()).setType(aPMidasBaseRequest.mType).setExtra(billingFlowParamsExtra);
        if (aPMidasBaseRequest instanceof APMidasMonthRequest) {
            APMidasMonthRequest aPMidasMonthRequest = (APMidasMonthRequest) aPMidasBaseRequest;
            builder.setIsAutoPay(aPMidasMonthRequest.autoPay).setServiceCode(aPMidasMonthRequest.serviceCode).setServiceName(aPMidasMonthRequest.serviceName);
        }
        APMidasPayNewAPI.singleton().pay(activity, builder.build(), iAPMidasPayCallBack);
    }

    public void net(String str, IAPMidasNetCallBack iAPMidasNetCallBack) {
        APLog.i("APMidasPayAPI", "net()");
        APMidasPayNewAPI.singleton().net(new NetParams.Builder().setMpReqType(str).build(), iAPMidasNetCallBack);
    }

    public void deinit() {
        APLog.i("APMidasPayAPI", "deinit()");
        APMidasPayNewAPI.singleton().dispose();
    }
}
