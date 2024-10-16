package com.tencent.midas.oversea.business.payhub.gwallet.New;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import com.amazonaws.services.s3.internal.Constants;
import com.android.billingclient.api.g;
import com.android.billingclient.api.i;
import com.android.billingclient.api.l;
import com.android.billingclient.api.p;
import com.android.billingclient.api.q;
import com.android.vending.billing.util.IabHelper;
import com.huawei.game.gamekit.b.a;
import com.tencent.imsdk.android.IR;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.pay.APPayBaseChannel;
import com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper;
import com.tencent.midas.oversea.comm.APBase64;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.comm.MRetCode;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.data.APPayInfo;
import com.tencent.midas.oversea.data.APPayReceipt;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APPay extends APPayBaseChannel implements BillingHelper.OnIabConsumeListener, BillingHelper.OnIabPurchaseListener, BillingHelper.OnIabQueryPurchasesListener, BillingHelper.OnIabQuerySkuDetailsListener, BillingHelper.OnIabSetupFinishedListener {
    private l mOldPurchase;
    private l mPurchase;
    private p mSkuDetails;
    private final String TAG = "APPay_New";
    private String openId = "";
    private String productId = "";
    private boolean isAutoPay = true;
    private String midasType = "";
    private String googleType = "inapp";
    private int SubcribeProrationMode = 4;
    private String OldSku = "";
    private BillingHelper billingHelper = null;

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    protected boolean isSdkProvide() {
        return true;
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    protected boolean needShowSucc() {
        return false;
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    protected void init() {
        MTimer.start(MTimer.GW_PROCESS_INIT);
        BillingFlowParams request = this.mModel.getRequest();
        this.openId = GlobalData.singleton().openID;
        this.productId = request.getProductID();
        this.isAutoPay = request.isAutoPay();
        this.midasType = request.getType();
        this.googleType = this.isAutoPay ? IabHelper.ITEM_TYPE_SUBS : "inapp";
        APLog.i("APPay_New", "productId:" + this.productId + ",googleType: " + this.googleType + ",midasType:" + this.midasType);
        this.billingHelper = new BillingHelper(this.mView.getActivity());
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_CALL, "name=startSetup");
        this.billingHelper.startSetup(this);
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    public void prePay() {
        MTimer.start(MTimer.GW_PROCESS_PREPAY);
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_CALL, "name=queryPurchasesAsync");
        this.billingHelper.queryPurchasesAsync(this);
    }

    private void querySkuDetails() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.productId);
        q a2 = q.c().a(this.googleType).a(arrayList).a();
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_CALL, "name=querySkuDetailsAsync");
        this.billingHelper.querySkuDetailsAsync(a2, this);
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    public void pay(Activity activity, JSONObject jSONObject) {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString(IR.preferences.PREFS_CHANNEL_KEY))) {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, 0, APCommMethod.getStringId(activity, "unipay_pay_error_tip"));
            reportResult("payerr", "pay info error");
            return;
        }
        APLog.d("APPay_New", "pay user_name============" + GlobalData.singleton().getUserName());
        MTimer.start(MTimer.GW_PROCESS_PAY);
        MTimer.start(MTimer.GW_PROCESS_SHOW_DIALOG);
        g.a e = g.e();
        e.a(this.mSkuDetails);
        e.a(GlobalData.singleton().getUserName());
        e.b(GlobalData.singleton().zoneID);
        if (!TextUtils.isEmpty(this.OldSku)) {
            l lVar = this.mOldPurchase;
            if (lVar == null || TextUtils.isEmpty(lVar.c())) {
                sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, MRetCode.ERR_GW_SUB_UPGRADE_OLD_PURCHASE_TOKEN_NULL, APCommMethod.getStringId(this.mView.getActivity(), "unipay_error_sub_upgrade_purchase_null"));
                return;
            } else {
                e.a(this.OldSku, this.mOldPurchase.c());
                e.a(this.SubcribeProrationMode);
            }
        }
        try {
            g a2 = e.a();
            APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_CALL, "name=launchPurchaseFlow");
            this.billingHelper.launchPurchaseFlow(this.mView.getActivity(), a2, this);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, 0, APCommMethod.getStringId(activity, "unipay_pay_error_tip"));
            reportResult("payerr", e2.getMessage());
        }
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    public void postPay() {
        if (IabHelper.ITEM_TYPE_SUBS.equals(this.googleType)) {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_POSTPAY_SUCC, 0, null);
            return;
        }
        MTimer.start(MTimer.GW_PROCESS_POSTPAY);
        i a2 = i.b().a(this.mPurchase.c()).a();
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_CALL, "name=consumeParams");
        this.billingHelper.consumeAsync(a2, this);
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    protected String getProductType() {
        return this.googleType;
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    protected JSONObject addChannelExtra(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (this.mPurchase != null && !TextUtils.isEmpty(this.mPurchase.a())) {
                jSONObject.put("gwalletOrderId", this.mPurchase.a());
            }
            String provideSdkRet = this.mModel.getProvideSdkRet();
            if (!TextUtils.isEmpty(provideSdkRet)) {
                JSONObject jSONObject2 = new JSONObject(provideSdkRet);
                if (jSONObject2.has("gw_subscription")) {
                    String jSONObject3 = jSONObject2.getJSONObject("gw_subscription").toString();
                    if (!TextUtils.isEmpty(jSONObject3)) {
                        jSONObject.put("subInfo", APBase64.encode(jSONObject3.getBytes()));
                    }
                }
            }
        } catch (JSONException e) {
            APLog.e("APPay_New", "addChannelExtra exception: " + e.getMessage());
        }
        return jSONObject;
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseChannel
    public void dispose() {
        super.dispose();
        BillingHelper billingHelper = this.billingHelper;
        if (billingHelper != null) {
            billingHelper.dispose();
            this.billingHelper = null;
        }
        this.mPurchase = null;
        this.mSkuDetails = null;
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabSetupFinishedListener
    public void onIabSetupFinished(WrapperBillingResult wrapperBillingResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("onIabSetupFinished:");
        sb.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.toString());
        APLog.d("APPay_New", sb.toString());
        MTimer.stop(MTimer.GW_PROCESS_INIT);
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onIabSetupFinished&result=" + wrapperBillingResult.resultCode() + "&msg=" + wrapperBillingResult.resultMsg());
        if (wrapperBillingResult.isSuccess()) {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_INIT_SUCC, 0, null);
            reportResult("initsucc", "");
            reportTime("initsucc", MTimer.duration(MTimer.GW_PROCESS_INIT));
        } else {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_INIT_ERROR, wrapperBillingResult.unifyErrCode(), wrapperBillingResult.resultMsg());
            reportResult("initerr", wrapperBillingResult.resultMsg());
            reportTime("initerr", MTimer.duration(MTimer.GW_PROCESS_INIT));
        }
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabQueryPurchasesListener
    public void onQueryPurchasesResponse(WrapperBillingResult wrapperBillingResult, List<l> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("onQueryPurchasesResponse:");
        sb.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.toString());
        APLog.d("APPay_New", sb.toString());
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onQueryPurchasesResponse&result=" + wrapperBillingResult.resultCode() + "&msg=" + wrapperBillingResult.resultMsg() + "&purchaseList=" + list.toString());
        if (wrapperBillingResult.isSuccess()) {
            onQueryPurchasesSuccess(wrapperBillingResult, list);
        } else {
            onQueryPurchasesFailed(wrapperBillingResult);
        }
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabQuerySkuDetailsListener
    public void onSkuDetailsResponse(WrapperBillingResult wrapperBillingResult, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSkuDetailsResponse:");
        sb.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.toString());
        APLog.d("APPay_New", sb.toString());
        MTimer.stop(MTimer.GW_PROCESS_PREPAY);
        APDataReportManager instance = APDataReportManager.instance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("name=onSkuDetailsResponse&result=");
        sb2.append(wrapperBillingResult.resultCode());
        sb2.append("&msg=");
        sb2.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.toString());
        sb2.append("&skuDetailsList=");
        sb2.append(list == null ? Constants.NULL_VERSION_ID : list.toString());
        instance.insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, sb2.toString());
        if (wrapperBillingResult.isSuccess()) {
            onQuerySkuDetailsSuccess(wrapperBillingResult, list);
            reportResult("prepaysucc", "");
            reportTime("prepaysucc", MTimer.duration(MTimer.GW_PROCESS_PREPAY));
        } else {
            onQuerySkuDetailsFailed(wrapperBillingResult);
            reportResult("prepayerr", wrapperBillingResult.resultMsg());
            reportTime("prepaysucc", MTimer.duration(MTimer.GW_PROCESS_PREPAY));
        }
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabPurchaseListener
    public void onPurchaseResponse(WrapperBillingResult wrapperBillingResult, List<l> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPurchaseResponse:");
        sb.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.toString());
        APLog.d("APPay_New", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("purchasesList:");
        sb2.append(list == null ? Constants.NULL_VERSION_ID : list.toString());
        APLog.d("APPay_New", sb2.toString());
        MTimer.stop(MTimer.GW_PROCESS_PAY);
        APDataReportManager instance = APDataReportManager.instance();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("name=onPurchaseResponse&result=");
        sb3.append(wrapperBillingResult.resultCode());
        sb3.append("&msg=");
        sb3.append(wrapperBillingResult.resultMsg());
        sb3.append("&purchasesList=");
        sb3.append(list == null ? Constants.NULL_VERSION_ID : list.toString());
        instance.insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, sb3.toString());
        if (wrapperBillingResult.isSuccess()) {
            onPurchaseSuccess(wrapperBillingResult, list);
            reportResult("paysucc", wrapperBillingResult.resultMsg());
            reportTime("paysucc", MTimer.duration(MTimer.GW_PROCESS_PAY));
        } else {
            onPurchaseFailed(wrapperBillingResult);
            reportResult("payerr", wrapperBillingResult.resultMsg());
            reportTime("payerr", MTimer.duration(MTimer.GW_PROCESS_PAY));
        }
        reportTime(MTimer.GW_FIRST_SCREEN_SHOWDIALOG, MTimer.duration(MTimer.GW_FIRST_SCREEN_SHOWDIALOG));
        reportTime(MTimer.GW_PROCESS_SHOW_DIALOG, MTimer.duration(MTimer.GW_PROCESS_SHOW_DIALOG));
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabConsumeListener
    public void onConsumeResponse(WrapperBillingResult wrapperBillingResult, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onConsumeResponse:");
        sb.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.toString());
        APLog.d("APPay_New", sb.toString());
        MTimer.stop(MTimer.GW_PROCESS_POSTPAY);
        APDataReportManager instance = APDataReportManager.instance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("name=onPurchaseResponse&result=");
        sb2.append(wrapperBillingResult.resultCode());
        sb2.append("&msg=");
        sb2.append(wrapperBillingResult.resultMsg());
        sb2.append("&purchaseToken=");
        sb2.append(str == null ? Constants.NULL_VERSION_ID : str.toString());
        instance.insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, sb2.toString());
        APDataReportManager instance2 = APDataReportManager.instance();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("version=2.0&result=");
        sb3.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : Integer.valueOf(wrapperBillingResult.resultCode()));
        sb3.append("&msg=");
        sb3.append(wrapperBillingResult == null ? Constants.NULL_VERSION_ID : wrapperBillingResult.resultMsg());
        sb3.append("&billno=");
        sb3.append(this.mModel.getBillNo());
        sb3.append("&productid=");
        sb3.append(this.mModel.getRequest().getProductID());
        instance2.insertData(APDataReportManager.SDK_OVERSEA_GW_CONSUME_RESULT, sb3.toString());
        if (wrapperBillingResult.isSuccess()) {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_POSTPAY_SUCC, 0, str);
            reportResult("consumesucc", wrapperBillingResult.resultMsg());
            reportTime("consumesucc", MTimer.duration(MTimer.GW_PROCESS_POSTPAY));
        } else {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_POSTPAY_ERROR, 0, wrapperBillingResult.resultMsg());
            reportResult("consumeerr", wrapperBillingResult.resultMsg());
            reportTime("consumeerr", MTimer.duration(MTimer.GW_PROCESS_POSTPAY));
        }
    }

    private void onQueryPurchasesSuccess(WrapperBillingResult wrapperBillingResult, List<l> list) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onQueryPurchasesSuccess&result=" + wrapperBillingResult.resultCode() + "&purchaselist=" + list.toString());
        BillingFlowParams.BillingFlowParamsExtra extra = this.mModel.getRequest().getExtra();
        subcribeUpgrate(extra.getChannelExtras());
        APLog.d("APPay_New", "onQueryPurchasesSuccess ChannelExtras: " + extra.getChannelExtras());
        if (list != null && !list.isEmpty() && IabHelper.ITEM_TYPE_SUBS.equals(this.googleType)) {
            for (l lVar : list) {
                if (this.productId.equals(lVar.b()) && lVar.d() == 1) {
                    MTimer.stop(MTimer.GW_PROCESS_PREPAY);
                    String str = "";
                    int i = MRetCode.ERR_GW_SUB_OWNED_SAME_USER;
                    String a2 = lVar.g().a();
                    if (!TextUtils.isEmpty(a2) && !GlobalData.singleton().openID.equals(a2)) {
                        str = APCommMethod.getStringId(this.mView.getActivity(), "unipay_error_sub_owned_diffuser");
                        i = MRetCode.ERR_GW_SUB_OWNED_DIFF_USER;
                    }
                    sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, i, str);
                    reportResult("prepayerr", "SubValidErr_" + i);
                    reportTime("prepayerr", MTimer.duration(MTimer.GW_PROCESS_PREPAY));
                    return;
                }
                if (!TextUtils.isEmpty(this.OldSku) && this.OldSku.equals(lVar.b()) && lVar.d() == 1 && lVar != null) {
                    this.mOldPurchase = lVar;
                    MTimer.stop(MTimer.GW_PROCESS_PREPAY);
                    String a3 = lVar.g().a();
                    if (!TextUtils.isEmpty(a3) && !GlobalData.singleton().openID.equals(a3)) {
                        sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, MRetCode.ERR_GW_SUB_OWNED_DIFF_USER, APCommMethod.getStringId(this.mView.getActivity(), "unipay_error_sub_owned_diffuser"));
                        reportResult("prepayerr", "SubValidErr_" + MRetCode.ERR_GW_SUB_OWNED_DIFF_USER);
                        reportTime("prepayerr", MTimer.duration(MTimer.GW_PROCESS_PREPAY));
                        return;
                    }
                }
            }
        }
        querySkuDetails();
    }

    private void onQueryPurchasesFailed(WrapperBillingResult wrapperBillingResult) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onQueryPurchasesFailed&result=" + wrapperBillingResult.resultCode());
        querySkuDetails();
    }

    private void onQuerySkuDetailsSuccess(WrapperBillingResult wrapperBillingResult, List<p> list) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onQuerySkuDetailsSuccess&result=" + wrapperBillingResult.resultCode() + "&skuDetailsList=" + list);
        if (list != null && !list.isEmpty()) {
            for (p pVar : list) {
                if (this.productId.equals(pVar.b())) {
                    APLog.i("APPay_New", pVar.toString());
                    this.mSkuDetails = pVar;
                    APPayInfo aPPayInfo = new APPayInfo();
                    aPPayInfo.currency = pVar.f();
                    aPPayInfo.amount = APTools.urlEncode(pVar.d(), 1);
                    aPPayInfo.ext = APTools.urlEncode(String.valueOf(pVar.e()), 1);
                    sendMesUIH(MConstants.MSG_PAYCHANNEL_PREPAY_SUCC, 0, aPPayInfo);
                }
            }
            return;
        }
        onQuerySkuDetailsFailed(wrapperBillingResult);
    }

    private void onQuerySkuDetailsFailed(WrapperBillingResult wrapperBillingResult) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onQuerySkuDetailsFailed&result=" + wrapperBillingResult.resultCode());
        APPayInfo aPPayInfo = new APPayInfo();
        aPPayInfo.currency = a.f5471a;
        aPPayInfo.amount = "0.0";
        aPPayInfo.ext = "0.0";
        sendMesUIH(MConstants.MSG_PAYCHANNEL_PREPAY_SUCC, 0, aPPayInfo);
    }

    private void onPurchaseSuccess(WrapperBillingResult wrapperBillingResult, List<l> list) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onPurchaseSuccess&result=" + wrapperBillingResult.resultCode() + "&purchasesList=" + list);
        if (list != null && !list.isEmpty()) {
            for (l lVar : list) {
                if (this.productId.equals(lVar.b())) {
                    if (lVar.d() == 1) {
                        this.mPurchase = lVar;
                        APPayReceipt aPPayReceipt = new APPayReceipt();
                        String f = this.mPurchase.f();
                        aPPayReceipt.receipt = APBase64.encode(this.mPurchase.e().getBytes());
                        aPPayReceipt.receipt_sig = f;
                        aPPayReceipt.sku = this.mPurchase.b();
                        sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_SUCC, 0, aPPayReceipt);
                        APLog.i("APPay_New", "purchase info: " + lVar.toString());
                    } else {
                        APLog.e("APPay_New", "Purchased State Error: " + lVar.d());
                        sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, wrapperBillingResult.unifyErrCode(), wrapperBillingResult.resultMsg());
                    }
                }
            }
            return;
        }
        sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_SUCC, 100, "purchasesList is null");
    }

    private void onPurchaseFailed(WrapperBillingResult wrapperBillingResult) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW20_SDK_RESPONSE, "name=onPurchaseFailed&result=" + wrapperBillingResult.resultCode());
        int resultCode = wrapperBillingResult.resultCode();
        if (APTools.isTestEnv()) {
            wrapperBillingResult.showSandboxErrTips();
        }
        if (resultCode == 1) {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_CANCEL, -2001, wrapperBillingResult.resultMsg());
        } else {
            sendMesUIH(MConstants.MSG_PAYCHANNEL_PAY_ERROR, wrapperBillingResult.unifyErrCode(), wrapperBillingResult.resultMsg());
        }
    }

    private void sendMesUIH(int i, int i2, Object obj) {
        if (this.UIHandler != null) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.obj = obj;
            this.UIHandler.sendMessage(message);
        }
    }

    private void reportTime(String str, long j) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_GW_TIME_20, "version=2.0&name=" + str + "&times=" + j + "&productType=" + this.googleType + "&midasType=" + this.midasType);
    }

    private void reportResult(String str, String str2) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_GW_RESULT_20, "version=2.0&name=" + str + "&result=" + str2 + "&productType=" + this.googleType + "&midasType=" + this.midasType);
    }

    private void subcribeUpgrate(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                HashMap<String, String> kv2Map = APTools.kv2Map(str);
                if (!TextUtils.isEmpty(kv2Map.get("SubcribeProrationMode")) && !TextUtils.isEmpty(kv2Map.get("OldSku"))) {
                    this.OldSku = kv2Map.get("OldSku");
                    this.SubcribeProrationMode = Integer.parseInt(kv2Map.get("SubcribeProrationMode"));
                }
            } else {
                APLog.i("APPay_New", "APPay channelExtras is null ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            APLog.i("APPay_New", "subcribeUpgrate errr:" + e.toString());
        }
    }
}
