package com.tencent.imsdk.android.api.pay;

import com.tencent.imsdk.android.tools.json.JsonSerializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMPayMidasReq extends JsonSerializable {
    public String country;
    public String currencyType;
    public String drmInfo;
    public String extras;
    public String iChannel;
    public String offerId;
    public String openId;
    public String openKey;
    public String payChannel;
    public String payType;
    public String pf;
    public String pfKey;
    public ArrayList<String> productInfoList;
    public String productid;
    public String resId;
    public String serviceCode;
    public String serviceName;
    public String serviceType;
    public String sessionId;
    public String sessionType;
    public String userExtend;
    public String zoneId;

    public IMPayMidasReq() {
    }

    public IMPayMidasReq(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMPayMidasReq(String str) throws JSONException {
        super(str);
    }
}
