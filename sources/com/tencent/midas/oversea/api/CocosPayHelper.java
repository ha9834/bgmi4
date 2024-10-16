package com.tencent.midas.oversea.api;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.intlgame.webview.WebViewManager;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.request.APMidasBaseRequest;
import com.tencent.midas.oversea.api.request.APMidasGameRequest;
import com.tencent.midas.oversea.api.request.APMidasGoodsRequest;
import com.tencent.midas.oversea.api.request.APMidasMonthRequest;
import com.tencent.midas.oversea.api.request.IProductInfoCallback;
import com.tencent.midas.oversea.business.pay.MidasResponse;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CocosPayHelper {
    public static final String AP_MIDAS_RESP_PAY_SUCC_POST_ERR = "4";
    public static final String AP_MIDAS_RESP_RESULT_CANCEL = "1";
    public static final String AP_MIDAS_RESP_RESULT_CHANNEL_ERR = "100";
    public static final String AP_MIDAS_RESP_RESULT_ERROR = "-1";
    public static final String AP_MIDAS_RESP_RESULT_NET_ERROR = "3";
    public static final String AP_MIDAS_RESP_RESULT_OK = "0";
    public static final String AP_MIDAS_RESP_RESULT_PARAM_ERROR = "2";
    public static final String GWALLET = "gwallet";
    private static final String LOGTAG = "CocosPayHelper";
    public static final String NET_FAILED = "{\"ret\":-1,\"err_code\":\"\",\"msg\":\"get info failed\"}";
    public static final String OFFICAL = "os_offical";
    public static final int PAYRESULT_CANCEL = 2;
    public static final int PAYRESULT_ERROR = -1;
    public static final int PAYRESULT_PARAMERROR = 3;
    public static final int PAYRESULT_PAY_SUCC_POST_ERR = -3001;
    public static final int PAYRESULT_PAY_SUCC_POST_NET_ERR = -3002;
    public static final int PAYRESULT_SUCC = 0;
    public static final int PAYRESULT_UNKOWN = 4;
    public static final String RES_CODE = "resultCode";
    public static final String RES_MSG = "resultMsg";
    public static final int RET_OK = 0;
    public static String mAppExtends = "";

    public static native void OnInitializeResult(String str);

    public static native void OnMidasGetInfoFinished(String str);

    public static native void OnMidasGetIntroPrice(String str);

    public static native void OnMidasGetProdcut(String str);

    public static native void OnMidasLoginExpired();

    public static native void OnMidasPayFinished(CocosAPMidasResponse cocosAPMidasResponse);

    public static native void OnReprovideResult(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static String errAdapter(int i) {
        String str;
        switch (i) {
            case -3002:
            case -3001:
                str = "4";
                break;
            case -1:
                str = AP_MIDAS_RESP_RESULT_ERROR;
                break;
            case 0:
                str = "0";
                break;
            case 2:
                str = "1";
                break;
            case 3:
                str = "2";
                break;
            case 4:
                str = AP_MIDAS_RESP_RESULT_ERROR;
                break;
            default:
                str = AP_MIDAS_RESP_RESULT_ERROR;
                break;
        }
        return (i > -2000 || i <= -3000) ? str : AP_MIDAS_RESP_RESULT_CHANNEL_ERR;
    }

    private static APMidasGameRequest getInitReq(CocosAPMidasInitRequest cocosAPMidasInitRequest) throws JSONException {
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.offerId = cocosAPMidasInitRequest.offerId;
        aPMidasGameRequest.openId = cocosAPMidasInitRequest.openId;
        aPMidasGameRequest.openKey = cocosAPMidasInitRequest.openKey;
        aPMidasGameRequest.sessionId = cocosAPMidasInitRequest.sessionId;
        aPMidasGameRequest.sessionType = cocosAPMidasInitRequest.sessionType;
        aPMidasGameRequest.zoneId = cocosAPMidasInitRequest.zoneId;
        aPMidasGameRequest.pf = cocosAPMidasInitRequest.pf;
        aPMidasGameRequest.pfKey = cocosAPMidasInitRequest.pfKey;
        if (!TextUtils.isEmpty(cocosAPMidasInitRequest.appExtends)) {
            aPMidasGameRequest.reserv = cocosAPMidasInitRequest.appExtends;
            mAppExtends = aPMidasGameRequest.reserv;
        } else {
            mAppExtends = "";
        }
        if (!TextUtils.isEmpty(cocosAPMidasInitRequest.channelExtras)) {
            aPMidasGameRequest.extras = cocosAPMidasInitRequest.channelExtras;
        }
        if (!TextUtils.isEmpty(cocosAPMidasInitRequest.goodsZoneId)) {
            aPMidasGameRequest.goodsZoneId = cocosAPMidasInitRequest.goodsZoneId;
        }
        return aPMidasGameRequest;
    }

    private static APMidasGameRequest getGameReq(CocosAPMidasBasePayRequest cocosAPMidasBasePayRequest) throws JSONException {
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.offerId = cocosAPMidasBasePayRequest.offerId;
        aPMidasGameRequest.openId = cocosAPMidasBasePayRequest.openId;
        aPMidasGameRequest.openKey = cocosAPMidasBasePayRequest.openKey;
        aPMidasGameRequest.sessionId = cocosAPMidasBasePayRequest.sessionId;
        aPMidasGameRequest.sessionType = cocosAPMidasBasePayRequest.sessionType;
        aPMidasGameRequest.zoneId = cocosAPMidasBasePayRequest.zoneId;
        aPMidasGameRequest.pf = cocosAPMidasBasePayRequest.pf;
        aPMidasGameRequest.pfKey = cocosAPMidasBasePayRequest.pfKey;
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.appExtends)) {
            aPMidasGameRequest.reserv = cocosAPMidasBasePayRequest.appExtends;
            mAppExtends = aPMidasGameRequest.reserv;
        } else {
            mAppExtends = "";
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.channelExtras)) {
            aPMidasGameRequest.extras = cocosAPMidasBasePayRequest.channelExtras;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.country)) {
            aPMidasGameRequest.country = cocosAPMidasBasePayRequest.country;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.currencyType)) {
            aPMidasGameRequest.currency_type = cocosAPMidasBasePayRequest.currencyType;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.goodsZoneId)) {
            aPMidasGameRequest.goodsZoneId = cocosAPMidasBasePayRequest.goodsZoneId;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.productId)) {
            aPMidasGameRequest.mpInfo.productid = cocosAPMidasBasePayRequest.productId;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.payChannel)) {
            aPMidasGameRequest.mpInfo.payChannel = cocosAPMidasBasePayRequest.payChannel;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.resId)) {
            try {
                aPMidasGameRequest.resId = Integer.parseInt(cocosAPMidasBasePayRequest.resId);
            } catch (Exception e) {
                APLog.e(LOGTAG, "resid error:" + e.toString());
            }
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.drmInfo)) {
            aPMidasGameRequest.mpInfo.drmInfo = cocosAPMidasBasePayRequest.drmInfo;
        }
        return aPMidasGameRequest;
    }

    private static APMidasGoodsRequest getGoodsReq(CocosAPMidasBasePayRequest cocosAPMidasBasePayRequest) throws JSONException {
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.offerId = cocosAPMidasBasePayRequest.offerId;
        aPMidasGoodsRequest.openId = cocosAPMidasBasePayRequest.openId;
        aPMidasGoodsRequest.openKey = cocosAPMidasBasePayRequest.openKey;
        aPMidasGoodsRequest.sessionId = cocosAPMidasBasePayRequest.sessionId;
        aPMidasGoodsRequest.sessionType = cocosAPMidasBasePayRequest.sessionType;
        aPMidasGoodsRequest.zoneId = cocosAPMidasBasePayRequest.zoneId;
        aPMidasGoodsRequest.pf = cocosAPMidasBasePayRequest.pf;
        aPMidasGoodsRequest.pfKey = cocosAPMidasBasePayRequest.pfKey;
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.appExtends)) {
            aPMidasGoodsRequest.reserv = cocosAPMidasBasePayRequest.appExtends;
            mAppExtends = aPMidasGoodsRequest.reserv;
        } else {
            mAppExtends = "";
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.channelExtras)) {
            aPMidasGoodsRequest.extras = cocosAPMidasBasePayRequest.channelExtras;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.country)) {
            aPMidasGoodsRequest.country = cocosAPMidasBasePayRequest.country;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.currencyType)) {
            aPMidasGoodsRequest.currency_type = cocosAPMidasBasePayRequest.currencyType;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.productId)) {
            aPMidasGoodsRequest.mpInfo.productid = cocosAPMidasBasePayRequest.productId;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.goodsZoneId)) {
            aPMidasGoodsRequest.goodsZoneId = cocosAPMidasBasePayRequest.goodsZoneId;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.payChannel)) {
            aPMidasGoodsRequest.mpInfo.payChannel = cocosAPMidasBasePayRequest.payChannel;
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.resId)) {
            try {
                aPMidasGoodsRequest.resId = Integer.parseInt(cocosAPMidasBasePayRequest.resId);
            } catch (Exception e) {
                APLog.e(LOGTAG, "resid error:" + e.toString());
            }
        }
        if (!TextUtils.isEmpty(cocosAPMidasBasePayRequest.drmInfo)) {
            aPMidasGoodsRequest.mpInfo.drmInfo = cocosAPMidasBasePayRequest.drmInfo;
        }
        return aPMidasGoodsRequest;
    }

    private static APMidasMonthRequest getSubsReq(CocosAPMidasSubscribeRequest cocosAPMidasSubscribeRequest) throws JSONException {
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        aPMidasMonthRequest.offerId = cocosAPMidasSubscribeRequest.offerId;
        aPMidasMonthRequest.openId = cocosAPMidasSubscribeRequest.openId;
        aPMidasMonthRequest.openKey = cocosAPMidasSubscribeRequest.openKey;
        aPMidasMonthRequest.sessionId = cocosAPMidasSubscribeRequest.sessionId;
        aPMidasMonthRequest.sessionType = cocosAPMidasSubscribeRequest.sessionType;
        aPMidasMonthRequest.zoneId = cocosAPMidasSubscribeRequest.zoneId;
        aPMidasMonthRequest.pf = cocosAPMidasSubscribeRequest.pf;
        aPMidasMonthRequest.pfKey = cocosAPMidasSubscribeRequest.pfKey;
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.appExtends)) {
            aPMidasMonthRequest.reserv = cocosAPMidasSubscribeRequest.appExtends;
            mAppExtends = aPMidasMonthRequest.reserv;
        } else {
            mAppExtends = "";
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.channelExtras)) {
            aPMidasMonthRequest.extras = cocosAPMidasSubscribeRequest.channelExtras;
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.country)) {
            aPMidasMonthRequest.country = cocosAPMidasSubscribeRequest.country;
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.currencyType)) {
            aPMidasMonthRequest.currency_type = cocosAPMidasSubscribeRequest.currencyType;
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.goodsZoneId)) {
            aPMidasMonthRequest.goodsZoneId = cocosAPMidasSubscribeRequest.goodsZoneId;
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.productId)) {
            aPMidasMonthRequest.mpInfo.productid = cocosAPMidasSubscribeRequest.productId;
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.payChannel)) {
            aPMidasMonthRequest.mpInfo.payChannel = cocosAPMidasSubscribeRequest.payChannel;
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.resId)) {
            try {
                aPMidasMonthRequest.resId = Integer.parseInt(cocosAPMidasSubscribeRequest.resId);
            } catch (Exception e) {
                APLog.e(LOGTAG, "resid error:" + e.toString());
            }
        }
        if (!TextUtils.isEmpty(cocosAPMidasSubscribeRequest.drmInfo)) {
            aPMidasMonthRequest.mpInfo.drmInfo = cocosAPMidasSubscribeRequest.drmInfo;
        }
        aPMidasMonthRequest.serviceCode = cocosAPMidasSubscribeRequest.serviceCode;
        aPMidasMonthRequest.serviceName = cocosAPMidasSubscribeRequest.serviceName;
        aPMidasMonthRequest.autoPay = cocosAPMidasSubscribeRequest.autoPay;
        return aPMidasMonthRequest;
    }

    public static void SetLogEnable(boolean z) {
        APLog.d("UnityPayHelper", "SetLogEnable enable: " + z);
        APMidasPayAPI.singleton().setLogEnable(z);
    }

    public static void Initialize(final Activity activity, final String str, final String str2, final String str3, final CocosAPMidasInitRequest cocosAPMidasInitRequest) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.1
            @Override // java.lang.Runnable
            public void run() {
                CocosPayHelper._Initialize(activity, str, str3, str2, cocosAPMidasInitRequest);
            }
        });
    }

    public static void Initialize(final Activity activity, final String str, final String str2, final CocosAPMidasInitRequest cocosAPMidasInitRequest) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.2
            @Override // java.lang.Runnable
            public void run() {
                CocosPayHelper._Initialize(activity, str, "", str2, cocosAPMidasInitRequest);
            }
        });
    }

    public static void ShowUI(String str) {
        APMidasPayAPI.singleton().showMidasUI(Integer.valueOf(str).intValue());
    }

    public static void GetProductInfo(Activity activity, final String str, final String str2) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.3
            @Override // java.lang.Runnable
            public void run() {
                CocosPayHelper._GetProductInfo(str, str2);
            }
        });
    }

    public static void GetInfo(final Activity activity, final String str, final String str2, final CocosAPMidasBaseRequest cocosAPMidasBaseRequest) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.4
            @Override // java.lang.Runnable
            public void run() {
                CocosPayHelper._GetInfo(activity, str, str2, cocosAPMidasBaseRequest);
            }
        });
    }

    public static void GetIntroPriceInfo(Activity activity, final String str, final String str2) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.5
            @Override // java.lang.Runnable
            public void run() {
                CocosPayHelper._GetIntroPriceInfo(str, str2);
            }
        });
    }

    public static void _GetIntroPriceInfo(String str, String str2) {
        APLog.d("_GetProductInfo", "channel: " + str + "productList: " + str2);
        if (str.equals(OFFICAL)) {
            str = GWALLET;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            APMidasPayAPI.singleton().getIntroPriceInfo(str, arrayList, new IProductInfoCallback() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.6
                @Override // com.tencent.midas.oversea.api.request.IProductInfoCallback
                public void onProductInfoResp(String str3) {
                    APLog.d("_GetIntroPriceInfo", "getIntroPriceInfo: " + str3);
                    CocosPayHelper.OnMidasGetIntroPrice(str3);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void _GetProductInfo(String str, String str2) {
        APLog.d("_GetProductInfo", "channel: " + str + "productList: " + str2);
        if (str.equals(OFFICAL)) {
            str = GWALLET;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            APMidasPayAPI.singleton().getProductInfo(str, arrayList, new IProductInfoCallback() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.7
                @Override // com.tencent.midas.oversea.api.request.IProductInfoCallback
                public void onProductInfoResp(String str3) {
                    APLog.d("_GetProductInfo", "onProductInfoResp: " + str3);
                    CocosPayHelper.OnMidasGetProdcut(str3);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void _Initialize(Activity activity, String str, String str2, String str3, CocosAPMidasInitRequest cocosAPMidasInitRequest) {
        APMidasPayAPI.singleton().setEnv(str3);
        APMidasPayAPI.singleton().setReleaseIDC(str, str2);
        APLog.d("UnityPayHelper", "Initialize message idc: " + str);
        APLog.d("UnityPayHelper", "Initialize message env: " + str3);
        APLog.d("UnityPayHelper", "Initialize message req: " + cocosAPMidasInitRequest);
        try {
            APMidasPayAPI.singleton().init(activity, getInitReq(cocosAPMidasInitRequest), new IAPPayUpdateCallBack() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.8
                @Override // com.tencent.midas.oversea.api.IAPPayUpdateCallBack
                public void onUpdate(int i, String str4) {
                    if (i == 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(str4);
                            if (jSONObject.getString("paychannelid").equals(CocosPayHelper.GWALLET)) {
                                jSONObject.put("paychannelid", CocosPayHelper.OFFICAL);
                            }
                            CocosPayHelper.OnInitializeResult(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (JSONException e) {
            APLog.e(LOGTAG, "InitReq error:" + e.toString());
        }
    }

    public static void Pay(final Activity activity, final String str, final CocosAPMidasBasePayRequest cocosAPMidasBasePayRequest) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.9
            @Override // java.lang.Runnable
            public void run() {
                APLog.d("UnityPayHelper", "Initialize Current Thread: " + Thread.currentThread().getName());
                CocosPayHelper._Pay(activity, str, cocosAPMidasBasePayRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void _GetInfo(Activity activity, String str, String str2, CocosAPMidasBaseRequest cocosAPMidasBaseRequest) {
        if (getBaseRequest(str2, cocosAPMidasBaseRequest) == null) {
            OnMidasGetInfoFinished(NET_FAILED);
        } else {
            APMidasPayAPI.singleton().net(str, new IAPMidasNetCallBack() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.10
                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetError(String str3, int i, String str4) {
                    CocosPayHelper.OnMidasGetInfoFinished(CocosPayHelper.NET_FAILED);
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetStop(String str3) {
                    CocosPayHelper.OnMidasGetInfoFinished(CocosPayHelper.NET_FAILED);
                }

                @Override // com.tencent.midas.oversea.api.IAPMidasNetCallBack
                public void MidasNetFinish(String str3, String str4) {
                    CocosPayHelper.OnMidasGetInfoFinished(str4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void _Pay(Activity activity, String str, CocosAPMidasBasePayRequest cocosAPMidasBasePayRequest) {
        APMidasBaseRequest baseRequest = getBaseRequest(str, cocosAPMidasBasePayRequest);
        if (baseRequest == null) {
            CocosAPMidasResponse cocosAPMidasResponse = new CocosAPMidasResponse();
            cocosAPMidasResponse.resultCode = "2";
            cocosAPMidasResponse.resultMsg = "not support bizType";
            OnMidasPayFinished(cocosAPMidasResponse);
            return;
        }
        APLog.d("UnityPayHelper", "payReq payChannel: " + baseRequest.mpInfo.payChannel);
        APLog.d("UnityPayHelper", "payReq ProductID: " + baseRequest.mpInfo.productid);
        if (baseRequest.mpInfo.payChannel.equals(OFFICAL)) {
            baseRequest.mpInfo.payChannel = GWALLET;
        }
        APMidasPayAPI.singleton().pay(activity, baseRequest, new IAPMidasPayCallBack() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.11
            @Override // com.tencent.midas.oversea.api.IAPMidasPayCallBack
            public void MidasPayNeedLogin() {
                APLog.d("UnityPayHelper", "MidasPayNeedLogin callback");
                CocosPayHelper.OnMidasLoginExpired();
            }

            @Override // com.tencent.midas.oversea.api.IAPMidasPayCallBack
            public void MidasPayCallBack(MidasResponse midasResponse) {
                APLog.d("UnityPayHelper", "MidasPayCallBack resp " + midasResponse.getResultMsg());
                CocosAPMidasResponse cocosAPMidasResponse2 = new CocosAPMidasResponse();
                cocosAPMidasResponse2.resultCode = CocosPayHelper.errAdapter(midasResponse.getResultCode());
                cocosAPMidasResponse2.resultInerCode = midasResponse.getResultCode() + "";
                cocosAPMidasResponse2.resultMsg = midasResponse.getResultMsg();
                try {
                    Log.d(CocosPayHelper.LOGTAG, midasResponse.getExtra());
                    JSONObject jSONObject = new JSONObject(midasResponse.getExtra());
                    if (jSONObject.has("billNo")) {
                        cocosAPMidasResponse2.billno = (String) jSONObject.get("billNo");
                    }
                    if (jSONObject.has(WebViewManager.KEY_JS_CHANNEL)) {
                        String str2 = (String) jSONObject.get(WebViewManager.KEY_JS_CHANNEL);
                        if (CocosPayHelper.GWALLET.equals(str2)) {
                            cocosAPMidasResponse2.payChannel = CocosPayHelper.OFFICAL;
                        } else {
                            cocosAPMidasResponse2.payChannel = str2;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cocosAPMidasResponse2.appExtends = midasResponse.getAPPExtends();
                APLog.d("UnityPayHelper", "MidasPayCallBack unityResp" + cocosAPMidasResponse2.resultMsg);
                CocosPayHelper.OnMidasPayFinished(cocosAPMidasResponse2);
            }
        });
    }

    public static void Reprovide(Activity activity) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.12
            @Override // java.lang.Runnable
            public void run() {
                APLog.d("reprre", "Reprovide Current Thread: " + Thread.currentThread().getName());
                CocosPayHelper._Reprovide();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void _Reprovide() {
        APLog.d("UnityPayHelper", "Reprovide called");
        APMidasPayNewAPI.singleton().reProvide(new IAPMidasCallback() { // from class: com.tencent.midas.oversea.api.CocosPayHelper.13
            @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
            public void callback(int i, String str) {
                APLog.d("UnityPayHelper", "ReprovideCallback：" + str);
                if (i == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.getString("paychannelid").equals(CocosPayHelper.GWALLET)) {
                            jSONObject.put("paychannelid", CocosPayHelper.OFFICAL);
                        }
                        CocosPayHelper.OnReprovideResult(str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static APMidasBaseRequest getBaseRequest(String str, CocosAPMidasBaseRequest cocosAPMidasBaseRequest) {
        APLog.d("UnityPayHelper", "Pay message req: " + cocosAPMidasBaseRequest);
        try {
            if (str.equals("APMidasGameRequest")) {
                return getGameReq((CocosAPMidasGameRequest) cocosAPMidasBaseRequest);
            }
            if (str.equals("APMidasGoodsRequest")) {
                return getGoodsReq((CocosAPMidasGoodsRequest) cocosAPMidasBaseRequest);
            }
            if (str.equals("APMidasSubscribeRequest")) {
                return getSubsReq((CocosAPMidasSubscribeRequest) cocosAPMidasBaseRequest);
            }
            APLog.e("UnityPayHelper", "not support bizType");
            return null;
        } catch (JSONException e) {
            APLog.e(LOGTAG, "payReq error:" + e.toString());
            return null;
        }
    }
}
