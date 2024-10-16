package com.tencent.midas.oversea.newnetwork.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.data.APProductItem;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APMpAns extends APMidasHttpAns {
    public static final String TAG = "APMpAns";
    private String beginTime;
    private String endTime;
    private String firstsave_present_count;
    private List<APProductItem> mGoodsList;
    private String mpJson;
    private List<String> mpList;
    private List<String> mpPresentList;
    private List<String> mpValueList;
    private String rate;

    public APMpAns(IAPMidasHttpCallback iAPMidasHttpCallback) {
        super(iAPMidasHttpCallback);
        this.rate = "";
        this.firstsave_present_count = "";
        this.beginTime = "";
        this.endTime = "";
        this.mpJson = "";
        this.mpValueList = new ArrayList();
        this.mpPresentList = new ArrayList();
        this.mpList = new ArrayList();
        this.mGoodsList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleSuccess(Response response) {
        progressJson(response.responseBody);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleStop(Response response) {
        APLog.e(TAG, "handleFailure(..): request stop.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.http.midashttp.APMidasHttpAns
    public boolean handleFailure(Response response) {
        APLog.e(TAG, "handleFailure(..): request failed.");
        return true;
    }

    private void progressJson(String str) {
        APLog.i(TAG, "resultData: " + str);
        this.mpJson = str;
        try {
            JSONObject jSONObject = new JSONObject(this.resultData);
            this.resultCode = Integer.parseInt(jSONObject.getString("ret"));
            if (this.resultCode == 0) {
                if (jSONObject.has("product_list")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("product_list");
                    this.mGoodsList.clear();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        APProductItem aPProductItem = new APProductItem();
                        aPProductItem.name = jSONObject2.optString("name");
                        aPProductItem.productId = jSONObject2.optString(APDataReportManager.SDK_FIELD_PRODUCTID);
                        aPProductItem.price = jSONObject2.optString(FirebaseAnalytics.Param.PRICE);
                        aPProductItem.num = jSONObject2.optString("num");
                        this.mGoodsList.add(aPProductItem);
                    }
                }
                this.rate = jSONObject.optString("rate");
                APCommMethod.transformStrToList(jSONObject.optString("list"), this.mpList);
                this.firstsave_present_count = jSONObject.optString("firstsave_present_count");
                APCommMethod.transformStrToMpInfoList(jSONObject.optString("present_level"), this.mpValueList, this.mpPresentList);
                this.beginTime = jSONObject.optString("begin_time");
                this.endTime = jSONObject.optString("end_time");
                return;
            }
            this.resultMsg = jSONObject.optString("msg");
            String string = jSONObject.getString("err_code");
            if (string.equals("")) {
                return;
            }
            this.resultMsg = APCommMethod.getStringId(APMidasPayNewAPI.singleton().getApplicationContext(), "unipay_pay_busy") + "\n(" + string + ")";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getMpList() {
        return this.mpList;
    }

    public void setMpList(List<String> list) {
        this.mpList = list;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String str) {
        this.rate = str;
    }

    public String getFirstsave_present_count() {
        return this.firstsave_present_count;
    }

    public void setFirstsave_present_count(String str) {
        this.firstsave_present_count = str;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public List<String> getMpValueList() {
        return this.mpValueList;
    }

    public void setMpValueList(List<String> list) {
        this.mpValueList = list;
    }

    public List<String> getMpPresentList() {
        return this.mpPresentList;
    }

    public void setMpPresentList(List<String> list) {
        this.mpPresentList = list;
    }

    public List<APProductItem> getProductList() {
        return this.mGoodsList;
    }

    public String getMpJson() {
        return this.mpJson;
    }
}
