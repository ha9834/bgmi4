package com.tencent.midas.oversea.business.payhub.gwallet.New;

import android.content.Context;
import com.android.billingclient.api.i;
import com.android.billingclient.api.l;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.midas.oversea.business.APBaseRestore;
import com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper;
import com.tencent.midas.oversea.comm.APBase64;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.data.APPayReceipt;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newapi.response.ICallback;
import com.tencent.midas.oversea.newapi.response.IGetPurchaseCallback;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APRestore extends APBaseRestore implements BillingHelper.OnIabConsumeListener, BillingHelper.OnIabSetupFinishedListener {
    public static final String TAG = "APGWRestore_New";
    private BillingHelper billingHelper;
    private ICallback initCallback;
    private IAPMidasCallback postProvideCallback;
    private long reportStartTime = 0;
    private JSONObject callbackJs = new JSONObject();
    private int mTotalConsumed = 0;
    private int mCurrentIndex = 0;
    private List<l> mPurchases = new ArrayList();
    private StringBuilder consumeReport = new StringBuilder();
    private JSONArray list = new JSONArray();
    private JSONArray forbidList = new JSONArray();

    @Override // com.tencent.midas.oversea.business.APBaseRestore
    public void init(Context context, ICallback iCallback) {
        updateTimer();
        this.initCallback = iCallback;
        this.billingHelper = new BillingHelper(context);
        this.billingHelper.startSetup(this);
    }

    @Override // com.tencent.midas.oversea.business.APBaseRestore
    public void getPurchaseList(Context context, final IGetPurchaseCallback iGetPurchaseCallback) {
        updateTimer();
        BillingHelper billingHelper = this.billingHelper;
        if (billingHelper != null) {
            try {
                billingHelper.queryPurchasesAsync(new BillingHelper.OnIabQueryPurchasesListener() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.APRestore.1
                    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabQueryPurchasesListener
                    public void onQueryPurchasesResponse(WrapperBillingResult wrapperBillingResult, List<l> list) {
                        APLog.i(APRestore.TAG, "onQueryPurchasesResponse: " + wrapperBillingResult);
                        if (wrapperBillingResult.isSuccess()) {
                            if (list != null && !list.isEmpty()) {
                                ArrayList arrayList = new ArrayList();
                                for (l lVar : list) {
                                    APLog.i(APRestore.TAG, lVar.toString());
                                    if (lVar.d() == 1) {
                                        APRestore.this.mPurchases.add(lVar);
                                        APPayReceipt aPPayReceipt = new APPayReceipt();
                                        aPPayReceipt.receipt = APBase64.encode(lVar.e().getBytes());
                                        aPPayReceipt.receipt_sig = lVar.f();
                                        aPPayReceipt.sku = lVar.b();
                                        arrayList.add(aPPayReceipt);
                                    }
                                }
                                iGetPurchaseCallback.callback(arrayList);
                            } else {
                                iGetPurchaseCallback.callback(null);
                            }
                        } else {
                            iGetPurchaseCallback.callback(null);
                        }
                        APRestore.this.reportEnd("queryEnd", wrapperBillingResult.resultCode() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + APRestore.this.mPurchases.size() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + APRestore.this.mPurchases.toString());
                    }
                });
                return;
            } catch (Exception e) {
                e.printStackTrace();
                iGetPurchaseCallback.callback(null);
                reportEnd("queryEnd", e.getMessage());
                return;
            }
        }
        iGetPurchaseCallback.callback(null);
        reportEnd("queryEnd", "mHelper is null or mHelper not setup.");
    }

    @Override // com.tencent.midas.oversea.business.APBaseRestore
    public void postProvide(List<String> list, IAPMidasCallback iAPMidasCallback) {
        this.postProvideCallback = iAPMidasCallback;
        if (list == null || list.isEmpty()) {
            callbackSuper(-1);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            for (l lVar : this.mPurchases) {
                if (lVar.b().equals(str)) {
                    arrayList.add(lVar);
                    APLog.d(TAG, "consumeList add:" + str);
                }
            }
        }
        APLog.d(TAG, "consumeList size:" + arrayList.size());
        if (!arrayList.isEmpty()) {
            consumeAsync(arrayList);
        } else {
            callbackSuper(0);
        }
    }

    private void consumeAsync(List<l> list) {
        updateTimer();
        this.mTotalConsumed = list.size();
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            this.billingHelper.consumeAsync(i.b().a(it.next().c()).a(), this);
        }
    }

    @Override // com.tencent.midas.oversea.business.APBaseRestore
    public void dispose() {
        APLog.i(TAG, "dispose()");
        BillingHelper billingHelper = this.billingHelper;
        if (billingHelper != null) {
            billingHelper.dispose();
            this.billingHelper = null;
        }
        if (!this.mPurchases.isEmpty()) {
            this.mPurchases.clear();
        }
        super.dispose();
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabSetupFinishedListener
    public void onIabSetupFinished(WrapperBillingResult wrapperBillingResult) {
        APLog.d(TAG, "onIabSetupFinished: " + wrapperBillingResult);
        if (wrapperBillingResult.isSuccess()) {
            this.initCallback.callback(0);
        } else {
            this.initCallback.callback(-1);
        }
        reportEnd("initEnd", String.valueOf(wrapperBillingResult.resultCode()));
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabConsumeListener
    public void onConsumeResponse(WrapperBillingResult wrapperBillingResult, String str) {
        APLog.d(TAG, "onConsumeResponse: " + wrapperBillingResult + ",mCurrentIndex=" + this.mCurrentIndex);
        List<l> list = this.mPurchases;
        if (list != null) {
            int size = list.size();
            int i = this.mCurrentIndex;
            if (size > i) {
                l lVar = this.mPurchases.get(i);
                StringBuilder sb = this.consumeReport;
                sb.append(lVar.a());
                sb.append("|");
                sb.append(wrapperBillingResult.isSuccess());
                sb.append("|");
                if (this.forbiddenPrompts.contains(lVar.b())) {
                    this.forbidList.put(lVar.b());
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(APDataReportManager.SDK_FIELD_PRODUCTID, lVar.b());
                    jSONObject.put("gwalletOrderId", lVar.a());
                    this.list.put(jSONObject);
                } catch (JSONException e) {
                    APLog.e(TAG, "JSONException1: " + e.getMessage());
                }
                int i2 = this.mCurrentIndex + 1;
                this.mCurrentIndex = i2;
                if (i2 == this.mTotalConsumed) {
                    reportEnd("consumeEnd", this.consumeReport.toString());
                    try {
                        if (this.list.length() != 0 || this.forbidList.length() != 0) {
                            addCallbackItem("paychannelid", CocosPayHelper.GWALLET);
                            addCallbackItem("products", this.list);
                            addCallbackItem("error_products", this.forbidList);
                        }
                    } catch (JSONException e2) {
                        APLog.e(TAG, "JSONException2: " + e2.getMessage());
                    }
                    callbackSuper(0);
                    return;
                }
                return;
            }
        }
        callbackSuper(-1);
    }

    private void addCallbackItem(String str, Object obj) throws JSONException {
        if (this.callbackJs == null) {
            this.callbackJs = new JSONObject();
        }
        this.callbackJs.put(str, obj);
    }

    private void addSubInfo() {
        if (this.provideSdkRetMap == null || this.provideSdkRetMap.isEmpty()) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.provideSdkRetMap.keySet()) {
                JSONObject jSONObject = new JSONObject(this.provideSdkRetMap.get(str));
                if (jSONObject.has("gw_subscription")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("gw_subscription");
                    jSONObject2.put("productId", str);
                    jSONArray.put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                addCallbackItem("subInfo", APBase64.encode(jSONArray.toString().getBytes()));
            }
        } catch (JSONException e) {
            APLog.d(TAG, "addSubInfo exception: " + e.getMessage());
        }
    }

    private void callbackSuper(int i) {
        if (this.postProvideCallback != null) {
            addSubInfo();
            JSONObject jSONObject = this.callbackJs;
            if (jSONObject != null && jSONObject.length() > 0) {
                this.postProvideCallback.callback(i, this.callbackJs.toString());
            } else {
                this.postProvideCallback.callback(i, "");
            }
        }
    }

    private void updateTimer() {
        this.reportStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEnd(String str, String str2) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_GW_REPROVIDE_TIME_CONSUME_20, "version=2.0&name=" + str + "&times=" + (System.currentTimeMillis() - this.reportStartTime) + "&result=" + str2);
    }
}
