package com.tencent.mtt.spcialcall.js;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mtt.spcialcall.ExtraInfo;
import com.tencent.mtt.spcialcall.WebViewSp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SdkJsBridge {
    private static final String FALSE = "false";
    private static final String TAG = "SdkJsBridge";
    private static final String TRUE = "true";
    private static final String UNDEFINED = "undefined";
    private static String[] sDefaultWhiteLists = {"*.qq.com", "*.soso.com", "*.qzone.com", "*.myapp.com", "*.wenwen.com"};
    private String[] mCustomWhiteLists;
    private WebViewSp mWebView;

    public SdkJsBridge(WebViewSp webViewSp) {
        this.mWebView = webViewSp;
        String whiteListPattern = ExtraInfo.getWhiteListPattern();
        if (TextUtils.isEmpty(whiteListPattern)) {
            return;
        }
        this.mCustomWhiteLists = new String[]{whiteListPattern};
    }

    public String nativeExec(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str4)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str4);
            } catch (JSONException e) {
                Log.w(TAG, e);
                return "undefined";
            }
        }
        if ("qb_sdk".equalsIgnoreCase(str) && "isApkInstalled".equals(str2)) {
            return isApkInstalled(jSONObject);
        }
        return null;
    }

    private String isApkInstalled(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "undefined";
        }
        String optString = jSONObject.optString("packagename");
        if (TextUtils.isEmpty(optString)) {
            return "undefined";
        }
        if (!checkDomain()) {
            return "false";
        }
        try {
            return this.mWebView.getContext().getPackageManager().getApplicationInfo(optString, 0) == null ? "false" : "true";
        } catch (Exception e) {
            Log.w(TAG, e);
            return "false";
        }
    }

    private boolean checkDomain() {
        String url = this.mWebView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        String host = Uri.parse(url).getHost();
        for (String str : sDefaultWhiteLists) {
            if (isDomainMatch(str, host)) {
                return true;
            }
        }
        String[] strArr = this.mCustomWhiteLists;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (isDomainMatch(str2, host)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDomainMatch(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.matches("^" + str.replaceAll("\\.", "\\\\.").replaceAll("\\*", ".+") + "$");
    }
}
