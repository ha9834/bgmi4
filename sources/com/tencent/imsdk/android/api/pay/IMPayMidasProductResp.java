package com.tencent.imsdk.android.api.pay;

import com.tencent.imsdk.android.api.IMSDKResult;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMPayMidasProductResp extends IMSDKResult {
    public List<IMPayMidasResp> productList;

    public IMPayMidasProductResp() {
    }

    public IMPayMidasProductResp(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public IMPayMidasProductResp(String str) throws JSONException {
        super(str);
    }
}
