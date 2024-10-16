package com.tencent.imsdk.android.api.pay;

import com.tencent.imsdk.android.api.IMSDKResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMPayMidasResp extends IMSDKResult {
    public String extendInfo;
    public int innerCode;
    public int payChannel;
    public String payReserve1;
    public String payReserve2;
    public String payReserve3;
    public int payState;
    public int provideState;
    public int realSaveNum;
    public int retBillNo;

    public IMPayMidasResp() {
    }

    public IMPayMidasResp(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMPayMidasResp(String str) throws JSONException {
        super(str);
    }
}
