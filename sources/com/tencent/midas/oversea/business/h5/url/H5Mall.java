package com.tencent.midas.oversea.business.h5.url;

import android.content.Context;
import android.text.TextUtils;
import com.adjust.sdk.AdjustConfig;
import com.facebook.appevents.UserDataStore;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.open.SocialOperation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class H5Mall extends IH5 {
    public static final String TAG = "H5Mall";
    private String params = "";
    private String country = "";
    private boolean retSuccess = false;
    private String mEnv = "";

    @Override // com.tencent.midas.oversea.business.h5.url.IH5
    public String getRetMsg() {
        return "";
    }

    @Override // com.tencent.midas.oversea.business.h5.url.IH5
    public void setJsResource(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            hashMap.put("appid", jSONObject.optString("offerId"));
            hashMap.put("openid", jSONObject.optString("openId"));
            hashMap.put(SocialOperation.GAME_ZONE_ID, jSONObject.optString("zoneId"));
            hashMap.put(APDataReportManager.SDK_FIELD_PRODUCTID, jSONObject.optString("productId"));
            hashMap.put("midas_sdk", "1");
            this.mEnv = jSONObject.optString("env");
            if (MConstants.TestEnv.equals(this.mEnv)) {
                hashMap.put(AdjustConfig.ENVIRONMENT_SANDBOX, "1");
            } else if (MConstants.DevEnv.equals(this.mEnv)) {
                hashMap.put(AdjustConfig.ENVIRONMENT_SANDBOX, "2");
            }
            this.params = APTools.map2UrlParams(hashMap);
            if (jSONObject.has("channelExtras")) {
                this.params += "&" + jSONObject.getString("channelExtras");
            }
            this.country = jSONObject.optString(UserDataStore.COUNTRY).toLowerCase();
        } catch (JSONException e) {
            APLog.i(TAG, "setJsResource fail: " + e.getMessage());
        }
    }

    @Override // com.tencent.midas.oversea.business.h5.url.IH5
    public String getHost() {
        return (MConstants.TestEnv.equals(this.mEnv) || MConstants.DevEnv.equals(this.mEnv)) ? "sandbox.midasbuy.com" : "www.midasbuy.com";
    }

    @Override // com.tencent.midas.oversea.business.h5.url.IH5
    public String getUrl(Context context) {
        String str;
        String str2 = "https://" + getHost() + "/";
        if (TextUtils.isEmpty(this.country)) {
            str = str2 + "?" + this.params;
        } else {
            str = str2 + this.country + "/?" + this.params;
        }
        APLog.i(TAG, "request url: " + str);
        return str;
    }

    @Override // com.tencent.midas.oversea.business.h5.url.IH5
    public void handleMJsAlert(Map<String, String> map) {
        if (map == null || !AnalyticsEventKey.RESPONSE.equals(map.get("action"))) {
            return;
        }
        boolean equals = "success".equals(map.get("status"));
        if (this.retSuccess || !equals) {
            return;
        }
        this.retSuccess = true;
    }

    @Override // com.tencent.midas.oversea.business.h5.url.IH5
    public int getRetCode() {
        return this.retSuccess ? 0 : -1;
    }
}
