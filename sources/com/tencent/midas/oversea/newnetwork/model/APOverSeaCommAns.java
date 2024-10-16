package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.TestConfig;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APToolAES;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APOverSeaCommAns extends APMidasHttpAns {
    public static final String TAG = "APOverSeaCommAns";
    private String billno;
    private String currency_amt;
    private String currency_type;
    private JSONObject info;
    private String infoMsg;
    private String mallMpInfo;
    private String num;
    private String offer_name;
    private String order_info;
    private String product_name;
    private String provideSdkRet;
    private String verifyRes;

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public APOverSeaCommAns(IAPMidasHttpCallback iAPMidasHttpCallback) {
        super(iAPMidasHttpCallback);
        this.verifyRes = "";
        this.infoMsg = "";
        this.mallMpInfo = "";
        this.provideSdkRet = "";
    }

    public String getProvideSdkRet() {
        return this.provideSdkRet;
    }

    public String getVerifyRes() {
        return this.verifyRes;
    }

    public String getBillno() {
        return this.billno;
    }

    public JSONObject getInfo() {
        return this.info;
    }

    public String getAmount() {
        return this.currency_amt;
    }

    public String getCurrentType() {
        return this.currency_type;
    }

    public String getProductName() {
        return this.product_name;
    }

    public String getNum() {
        return this.num;
    }

    public String getMallMpInfo() {
        return this.mallMpInfo;
    }

    public String getOfferName() {
        return this.offer_name;
    }

    public String getInfoMsg() {
        return this.infoMsg;
    }

    public String getOrderInfo() {
        return this.order_info;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleSuccess(Response response) {
        progressJson(response.responseBody);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleFailure(Response response) {
        APLog.e(TAG, "handleFailure(..): request failed.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleStop(Response response) {
        APLog.e(TAG, "handleStop(..): request stop.");
        return true;
    }

    private void progressJson(String str) {
        try {
            String parameter = getAPMidasHttpRequest().getParameter(NetworkManager.CMD_TAG);
            APLog.i(TAG, "CMD: " + parameter + ", resultData: " + str);
            JSONObject jSONObject = new JSONObject(str);
            if (parameter.contains(NetworkManager.CMD_GET_KEY)) {
                analyseGetKey(jSONObject.getJSONObject(NetworkManager.CMD_GET_KEY));
            }
            if (parameter.contains(NetworkManager.CMD_INFO)) {
                analyseInfo(jSONObject.getJSONObject(NetworkManager.CMD_INFO));
            }
            if (parameter.contains(NetworkManager.CMD_ORDER)) {
                analyseOrder(jSONObject.getJSONObject(NetworkManager.CMD_ORDER));
            }
            if (parameter.contains(NetworkManager.CMD_PROVIDE)) {
                analyseProvider(jSONObject.getJSONObject(NetworkManager.CMD_PROVIDE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String decodeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        return APToolAES.doDecode(str.substring(0, indexOf), ((APMidasHttpRequestBase) getAPMidasHttpRequest()).getDecodeKey(), Integer.parseInt(str.substring(indexOf + 1, str.length())));
    }

    private void analyseGetKey(JSONObject jSONObject) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (Integer.parseInt(jSONObject.optString("ret")) == 0) {
            HashMap<String, String> kv2Map = APTools.kv2Map(APToolAES.doDecode(jSONObject.optString("key_info"), GlobalData.singleton().getBaseKey()).substring(0, Integer.valueOf(jSONObject.optString("key_info_len")).intValue()));
            String str = kv2Map.get("key");
            String str2 = kv2Map.get("cryptkey");
            String str3 = kv2Map.get("cryptkeytime");
            String openIDFromRequest = getAPMidasHttpRequest().getOpenIDFromRequest();
            NetworkManager.singleton().saveKeyInfo(getAPMidasHttpRequest().getOfferIDFromRequest(), openIDFromRequest, str, str2, str3);
            return;
        }
        APLog.i(TAG, "get_key retCode is not equals zero.");
    }

    private void analyseInfo(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject.length() == 0) {
            return;
        }
        try {
            this.resultCode = Integer.parseInt(jSONObject.getString("ret"));
            if (this.resultCode == 0) {
                if (jSONObject.has("mp_info")) {
                    if (!TextUtils.isEmpty(TestConfig.getCurTestMpInfo())) {
                        jSONObject2 = new JSONObject(TestConfig.getCurTestMpInfo());
                    } else {
                        jSONObject2 = jSONObject.getJSONObject("mp_info");
                    }
                    if (jSONObject2.has("buycurrency")) {
                        this.mallMpInfo = jSONObject2.toString();
                    }
                }
                if (jSONObject.has("session_token")) {
                    GlobalData.singleton().setNetToken(jSONObject.optString("session_token"));
                }
                this.infoMsg = decodeString(jSONObject.getString("rsp_msg"));
                return;
            }
            this.resultMsg = jSONObject.optString("msg");
            String optString = jSONObject.optString("err_code");
            if (optString.equals("")) {
                return;
            }
            this.resultMsg = APCommMethod.getStringId(APMidasPayNewAPI.singleton().getApplicationContext(), "unipay_pay_busy") + "\n(" + optString + ")";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void analyseOrder(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_NETWORK_CALL_RESPONSE, "name=order&result=" + jSONObject.optString("ret") + "&info=" + jSONObject.toString());
                    this.resultCode = Integer.parseInt(jSONObject.optString("ret"));
                    if (this.resultCode == 0) {
                        orderHandleMsg(new JSONObject(decodeString(jSONObject.optString("rsp_msg"))));
                        return;
                    }
                    this.resultMsg = jSONObject.optString("msg");
                    String optString = jSONObject.optString("err_code");
                    if (optString.equals("")) {
                        return;
                    }
                    this.resultMsg = APCommMethod.getStringId(APMidasPayNewAPI.singleton().getApplicationContext(), "unipay_pay_busy") + "(" + optString + ")";
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_NETWORK_CALL_RESPONSE, "name=order&result=null");
    }

    private void analyseProvider(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_NETWORK_CALL_RESPONSE, "name=provide&result=" + jSONObject.optString("ret") + "&info=" + jSONObject.toString());
                    this.resultCode = Integer.parseInt(jSONObject.getString("ret"));
                    parseProvideRspMsg(jSONObject);
                    if (this.resultCode != 0) {
                        this.resultMsg = jSONObject.optString("msg");
                        String optString = jSONObject.optString("err_code");
                        if (optString.equals("")) {
                            return;
                        }
                        this.resultMsg = APCommMethod.getStringId(APMidasPayNewAPI.singleton().getApplicationContext(), "unipay_pay_busy") + "(" + optString + ")";
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                APLog.e(TAG, "analyseProvider Exception: " + e.getMessage());
                return;
            }
        }
        APDataReportManager.instance().insertData(APDataReportManager.SDK_NETWORK_CALL_RESPONSE, "name=provide&result=null");
    }

    private void orderHandleMsg(JSONObject jSONObject) {
        try {
            if (jSONObject.has("order_info")) {
                this.order_info = jSONObject.getString("order_info");
            }
            if (jSONObject.has(APDataReportManager.SDK_FIELD_BILLNO)) {
                this.billno = jSONObject.getString(APDataReportManager.SDK_FIELD_BILLNO);
            }
            if (jSONObject.has(NetworkManager.CMD_INFO)) {
                this.info = jSONObject.getJSONObject(NetworkManager.CMD_INFO);
                APLog.d(TAG, "orderHandleMsg info:" + this.info);
                GlobalData.singleton().setUserName("");
                if (this.info.has("user_name")) {
                    GlobalData.singleton().setUserName(this.info.getString("user_name"));
                }
            }
            if (jSONObject.has("currency_amt")) {
                this.currency_amt = jSONObject.getString("currency_amt");
            }
            if (jSONObject.has("currency_type")) {
                this.currency_type = jSONObject.getString("currency_type");
            }
            if (jSONObject.has("num")) {
                this.num = jSONObject.getString("num");
            }
            if (jSONObject.has("product_name")) {
                this.product_name = APTools.urlDecode(jSONObject.getString("product_name"), 1);
            }
            if (jSONObject.has("offer_name")) {
                this.offer_name = APTools.urlDecode(jSONObject.getString("offer_name"), 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseProvideRspMsg(JSONObject jSONObject) {
        try {
            String decodeString = decodeString(jSONObject.optString("rsp_msg"));
            APLog.d(TAG, "parseProvideRspMsg: " + decodeString);
            JSONObject jSONObject2 = new JSONObject(decodeString);
            if (jSONObject2.has("verify_res")) {
                this.verifyRes = jSONObject2.getJSONObject("verify_res").toString();
            }
            if (jSONObject2.has("sdk_ret")) {
                this.provideSdkRet = jSONObject2.getJSONObject("sdk_ret").toString();
            }
        } catch (Exception unused) {
        }
    }
}
