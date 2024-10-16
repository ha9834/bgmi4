package com.tencent.midas.oversea.business.payhub.gwallet.New;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.p;
import com.android.billingclient.api.q;
import com.android.vending.billing.util.IabHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.game.gamekit.b.a;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.IGetProduct;
import com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.response.InfoCallback;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APProductInfo implements IGetProduct, BillingHelper.OnIabQuerySkuDetailsListener, BillingHelper.OnIabSetupFinishedListener {
    private static final String ERROR = "-1";
    private static final String ERROR_DATA = "-2";
    private static final String ERROR_PARAM = "-3";
    private static final String SUCCESS = "0";
    private static final String TAG = "APProductInfo_New";
    private BillingHelper billingHelper;
    private InfoCallback mCallback;
    private Context mContext;
    private List<String> mSkus = null;
    private int callbackCount = 1;
    private final int CALLBACK_TIMES = 2;
    private JSONArray jsRes = new JSONArray();

    @Override // com.tencent.midas.oversea.business.IGetProduct
    public void getProductInfo(Context context, List<String> list, InfoCallback infoCallback) {
        this.mCallback = infoCallback;
        this.mSkus = list;
        this.mContext = context;
        List<String> list2 = this.mSkus;
        if (list2 != null && !list2.isEmpty()) {
            init(this.mContext);
        } else {
            callback(ERROR_PARAM, "query productList is empty");
        }
    }

    private void init(Context context) {
        APLog.d(TAG, "init");
        this.billingHelper = new BillingHelper(context);
        this.billingHelper.startSetup(this);
    }

    private void queryProductsInfo() {
        APLog.d(TAG, "queryProductsInfo");
        q a2 = q.c().a(IabHelper.ITEM_TYPE_SUBS).a(this.mSkus).a();
        q a3 = q.c().a("inapp").a(this.mSkus).a();
        BillingHelper billingHelper = this.billingHelper;
        if (billingHelper == null) {
            callback("-1", "billingHelper is null");
        } else {
            billingHelper.querySkuDetailsAsync(a2, this);
            this.billingHelper.querySkuDetailsAsync(a3, this);
        }
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabSetupFinishedListener
    public void onIabSetupFinished(WrapperBillingResult wrapperBillingResult) {
        APLog.i(TAG, "onIabSetupFinished:" + wrapperBillingResult);
        if (wrapperBillingResult.isSuccess()) {
            queryProductsInfo();
        } else {
            callback("-1", wrapperBillingResult.resultMsg());
        }
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabQuerySkuDetailsListener
    public void onSkuDetailsResponse(WrapperBillingResult wrapperBillingResult, List<p> list) {
        APLog.i(TAG, "onSkuDetailsResponse:" + wrapperBillingResult + ",callbackCount=" + this.callbackCount);
        if (wrapperBillingResult.isSuccess() && list != null && !list.isEmpty()) {
            try {
                for (p pVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("productId", pVar.b());
                    jSONObject.put(FirebaseAnalytics.Param.PRICE, pVar.d());
                    jSONObject.put(FirebaseAnalytics.Param.CURRENCY, pVar.f());
                    jSONObject.put("microprice", pVar.e());
                    jSONObject.put("originalPrice", pVar.g());
                    jSONObject.put("originalMicroprice", pVar.h());
                    this.jsRes.put(jSONObject);
                }
                GlobalData.singleton().setCurrencyInGw(TextUtils.isEmpty(list.get(0).f()) ? a.f5471a : list.get(0).f());
            } catch (JSONException e) {
                APLog.e(TAG, "onSkuDetailsResponse exception: " + e.getMessage());
            }
        }
        int i = this.callbackCount;
        this.callbackCount = i + 1;
        if (i == 2) {
            callback("0", "success");
        }
    }

    private void callback(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", str);
            jSONObject.put("msg", str2);
            jSONObject.put("productInfo", this.jsRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "callback:" + jSONObject.toString());
        InfoCallback infoCallback = this.mCallback;
        if (infoCallback != null) {
            infoCallback.callback(jSONObject.toString());
        }
        BillingHelper billingHelper = this.billingHelper;
        if (billingHelper != null) {
            billingHelper.dispose();
            this.billingHelper = null;
        }
    }
}
