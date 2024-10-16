package com.tencent.midas.oversea.business.pay;

import android.os.Message;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.TestConfig;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.comm.MRetCode;
import com.tencent.midas.oversea.data.APPayInfo;
import com.tencent.midas.oversea.data.APPayReceipt;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.model.APOverSeaCommAns;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APPayModel {
    public static final String TAG = "APPayModel";
    private String currency_amt;
    private String mBillNo;
    private String mCurrency;
    private JSONObject mInfo;
    private String num;
    private String offer_name;
    private String payAmt;
    private String payCurrency;
    private String productType;
    private String product_name;
    private boolean hasGoodsList = true;
    private String mPayInfo = "";
    private APPayReceipt mProvideReceipt = null;
    private String verifyRes = "";
    private String provideMes = "";
    private String provideSdkRet = "";
    private boolean isErrorConsume = false;
    private XCallback mCallback = null;
    private BillingFlowParams mRequest = null;
    private IAPMidasHttpCallback mOrderObserver = new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.pay.APPayModel.1
        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onStop(APMidasHttpAns aPMidasHttpAns) {
            APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_CANCEL, "Order network cancel");
            APLog.i(APPayModel.TAG, "getOrder onStop.");
        }

        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
            int resultCode = aPMidasHttpAns.getResultCode();
            if (TestConfig.retCodeOrder != 0) {
                resultCode = TestConfig.retCodeOrder;
                APLog.i(APPayModel.TAG, "TestConfig");
            }
            APLog.i(APPayModel.TAG, "getOrder onSuccess: " + resultCode + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + aPMidasHttpAns.getResultMessage());
            if (resultCode != 0) {
                if (resultCode == 1018) {
                    APPayModel.this.notifyOuterLoginErr();
                    return;
                } else if (resultCode != 1145) {
                    APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_GET_ORDER_ERROR, aPMidasHttpAns.getResultMessage());
                    return;
                } else {
                    APPayModel.this.notifyOuterRiskErr(MRetCode.ERR_1145, aPMidasHttpAns.getResultMessage());
                    return;
                }
            }
            APOverSeaCommAns aPOverSeaCommAns = (APOverSeaCommAns) aPMidasHttpAns;
            APPayModel.this.mBillNo = aPOverSeaCommAns.getBillno();
            APPayModel.this.mInfo = aPOverSeaCommAns.getInfo();
            APPayModel.this.currency_amt = aPOverSeaCommAns.getAmount();
            APPayModel.this.mCurrency = aPOverSeaCommAns.getCurrentType();
            APPayModel.this.offer_name = aPOverSeaCommAns.getOfferName();
            APPayModel.this.product_name = aPOverSeaCommAns.getProductName();
            APPayModel.this.num = aPOverSeaCommAns.getNum();
            APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_GET_ORDER_SUCC, null);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("offerid", GlobalData.singleton().offerID);
                jSONObject.put(APDataReportManager.SDK_FIELD_PRODUCTID, APPayModel.this.getRequest().getProductID());
                jSONObject.put("productname", APPayModel.this.product_name);
                jSONObject.put(FirebaseAnalytics.Param.PRICE, APPayModel.this.payAmt);
                jSONObject.put("paychannel", APPayModel.this.getChannelId());
                jSONObject.put(FirebaseAnalytics.Param.CURRENCY, APPayModel.this.payCurrency);
                APPayModel.this.mPayInfo = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onFailure(APMidasHttpAns aPMidasHttpAns) {
            APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_GET_ORDER_ERROR, -4, "Network Exception");
            APLog.i(APPayModel.TAG, "getOrder onFailure: " + aPMidasHttpAns.getResultCode() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + aPMidasHttpAns.getResultMessage());
        }
    };
    private IAPMidasHttpCallback mProvideObserver = new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.pay.APPayModel.2
        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onStop(APMidasHttpAns aPMidasHttpAns) {
            APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_CANCEL, "Provide network cancel");
            APLog.i(APPayModel.TAG, "provide onStop.");
        }

        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
            int resultCode = aPMidasHttpAns.getResultCode();
            APPayModel.this.provideMes = aPMidasHttpAns.getResultMessage();
            APOverSeaCommAns aPOverSeaCommAns = (APOverSeaCommAns) aPMidasHttpAns;
            APPayModel.this.verifyRes = aPOverSeaCommAns.getVerifyRes();
            APPayModel.this.provideSdkRet = aPOverSeaCommAns.getProvideSdkRet();
            if (resultCode == 1138 || resultCode == 5017) {
                APPayModel.this.isErrorConsume = true;
            }
            if (TestConfig.retCodeProvide != 0) {
                resultCode = TestConfig.retCodeProvide;
                APPayModel.this.provideMes = "test error msg:" + resultCode;
                APLog.i(APPayModel.TAG, "TestConfig");
            }
            if (resultCode == 0) {
                APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_PROVIDE_SUCC, null);
            } else if (resultCode == 1018) {
                APPayModel.this.notifyOuterLoginErr();
            } else {
                APPayModel aPPayModel = APPayModel.this;
                aPPayModel.notifyInner(MConstants.MSG_PAYCHANNEL_PROVIDE_ERROR, -3001, aPPayModel.provideMes);
            }
            APLog.i(APPayModel.TAG, "provide onSuccess: " + resultCode + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + APPayModel.this.provideMes);
        }

        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onFailure(APMidasHttpAns aPMidasHttpAns) {
            APPayModel.this.notifyInner(MConstants.MSG_PAYCHANNEL_PROVIDE_ERROR, -3002, "Network Exception");
            APLog.i(APPayModel.TAG, "provide onFailure: " + aPMidasHttpAns.getResultCode() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + aPMidasHttpAns.getResultMessage());
        }
    };

    public void order(Object obj) {
        String str;
        if (this.mRequest != null) {
            String str2 = this.hasGoodsList ? "" : "1";
            String serviceCode = "unimonth".equals(this.mRequest.getType()) ? this.mRequest.getServiceCode() : "";
            if (obj == null) {
                this.payCurrency = "";
                this.payAmt = "";
                str = "";
            } else {
                APPayInfo aPPayInfo = (APPayInfo) obj;
                String str3 = aPPayInfo.amount;
                this.payAmt = aPPayInfo.ext;
                this.payCurrency = aPPayInfo.currency;
                str = str3;
            }
            NetworkManager.singleton().getOrder(this.mRequest.getPayChannel(), this.mRequest.getCurrencyType(), this.payCurrency, this.payAmt, serviceCode, str2, str, this.mRequest, this.mOrderObserver);
        }
    }

    public void provide(Object obj) {
        if (this.mRequest != null) {
            setProvideReceipt((APPayReceipt) obj);
            NetworkManager.singleton().provide(false, this.mCurrency, this.mRequest.getPayChannel(), this.num, this.mBillNo, this.mProvideReceipt.receipt, null, this.mProvideReceipt.receipt_sig, this.mRequest, this.mProvideObserver);
        }
    }

    public void setCallback(XCallback xCallback) {
        this.mCallback = xCallback;
    }

    public void setRequest(BillingFlowParams billingFlowParams) {
        this.mRequest = billingFlowParams;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public void setHasGoodsList(boolean z) {
        this.hasGoodsList = z;
    }

    public BillingFlowParams getRequest() {
        if (this.mRequest == null) {
            this.mRequest = new BillingFlowParams.Builder().build();
        }
        return this.mRequest;
    }

    public String getPayInfo() {
        return this.mPayInfo;
    }

    public JSONObject getMInfo() {
        return this.mInfo;
    }

    public String getCurrencyAmt() {
        return this.currency_amt;
    }

    public String getCurrency() {
        return this.mCurrency;
    }

    public String getOfferName() {
        return this.offer_name;
    }

    public String getProductName() {
        return this.product_name;
    }

    public int getNum() {
        try {
            return Integer.parseInt(this.num);
        } catch (Exception e) {
            APLog.e(TAG, "getNum(): " + e.getMessage());
            return 0;
        }
    }

    public String getBillNo() {
        return this.mBillNo;
    }

    public void setBillNo(String str) {
        this.mBillNo = str;
    }

    public boolean isErrorConsume() {
        return this.isErrorConsume;
    }

    public APPayReceipt getProvideReceipt() {
        if (this.mProvideReceipt == null) {
            this.mProvideReceipt = new APPayReceipt();
        }
        return this.mProvideReceipt;
    }

    public void setProvideReceipt(APPayReceipt aPPayReceipt) {
        this.mProvideReceipt = aPPayReceipt;
    }

    public String getProvideRetMes() {
        return this.provideMes;
    }

    public String getProvideSdkRet() {
        return this.provideSdkRet;
    }

    public String getChannelId() {
        BillingFlowParams billingFlowParams = this.mRequest;
        return billingFlowParams != null ? billingFlowParams.getPayChannel() : "";
    }

    public String getVerifyRes() {
        return this.verifyRes;
    }

    public void release() {
        this.mInfo = null;
        this.mProvideReceipt = null;
        this.mCallback = null;
        this.mRequest = null;
    }

    public void report(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("name=");
        sb.append(str);
        sb.append("&result=");
        sb.append(str2);
        sb.append("&payChannel=");
        sb.append(getChannelId());
        if (!TextUtils.isEmpty(this.productType)) {
            sb.append("&productType=");
            sb.append(this.productType);
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_CHANNEL_PAYRESULT, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInner(int i, Object obj) {
        if (this.mCallback != null) {
            Message message = new Message();
            message.what = i;
            message.obj = obj;
            this.mCallback.notifyInner(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInner(int i, int i2, Object obj) {
        if (this.mCallback != null) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.obj = obj;
            this.mCallback.notifyInner(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOuterLoginErr() {
        XCallback xCallback = this.mCallback;
        if (xCallback != null) {
            xCallback.notifyOuterLoginErr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOuterRiskErr(int i, String str) {
        XCallback xCallback = this.mCallback;
        if (xCallback != null) {
            xCallback.notifyOuterRiskErr(i, str);
        }
    }
}
