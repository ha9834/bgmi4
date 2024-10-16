package com.tencent.midas.oversea.business.h5.url;

import android.content.Context;
import android.text.TextUtils;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.h5.webview.InterceptItem;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class IH5 {
    public static final String URL_SCHEME = "oversea://jsbridge?";
    private String localCacheIP = "";
    private ArrayList<InterceptItem> interceptItems = new ArrayList<>();

    public String getHost() {
        return "";
    }

    public abstract int getRetCode();

    public abstract String getRetMsg();

    public abstract String getUrl(Context context);

    public abstract void handleMJsAlert(Map<String, String> map);

    public boolean ifSetLocalCacheIP() {
        return false;
    }

    public abstract void setJsResource(String str);

    public ArrayList<InterceptItem> getInterceptItems() {
        return this.interceptItems;
    }

    public void setLocalCacheIP(String str) {
        this.localCacheIP = str;
    }

    public String getLocalCacheIP() {
        return this.localCacheIP;
    }

    public void onJsAlert(String str) {
        HashMap<String, String> url2Map;
        if (!str.startsWith(URL_SCHEME) || (url2Map = APTools.url2Map(str)) == null) {
            return;
        }
        if (AnalyticsEventKey.RESPONSE.equals(url2Map.get("action"))) {
            parseInterceptProtocol(url2Map.get("intercept"));
        }
        handleMJsAlert(url2Map);
    }

    private void parseInterceptProtocol(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String decode = URLDecoder.decode(str, HttpUtils.DEFAULT_ENCODE_NAME);
            APLog.d("IH5", "interceptMsg: " + decode);
            JSONArray jSONArray = new JSONArray(decode);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                InterceptItem interceptItem = new InterceptItem();
                interceptItem.pattern = jSONObject.getString("rule");
                interceptItem.redirectUrl = jSONObject.optString("url");
                interceptItem.type = jSONObject.getString("type");
                this.interceptItems.add(interceptItem);
            }
        } catch (UnsupportedEncodingException e) {
            APLog.e("IH5", "parseInterceptProtocol UnsupportedEncodingException: " + e.getMessage());
        } catch (JSONException e2) {
            APLog.e("IH5", "parseInterceptProtocol JSONException: " + e2.getMessage());
        }
    }
}
