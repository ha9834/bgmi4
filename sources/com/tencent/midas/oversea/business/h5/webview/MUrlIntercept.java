package com.tencent.midas.oversea.business.h5.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Toast;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.MConstants;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MUrlIntercept implements IIntercept {
    private final String TAG = "MUrlIntercept";
    private String env = MConstants.DevEnv;
    private ArrayList<InterceptItem> interceptItems;

    @Override // com.tencent.midas.oversea.business.h5.webview.IIntercept
    public int level() {
        return 1;
    }

    @Override // com.tencent.midas.oversea.business.h5.webview.IIntercept
    public WebResourceResponse queryCache(String str) {
        return null;
    }

    public void setInterceptItems(ArrayList<InterceptItem> arrayList) {
        this.interceptItems = arrayList;
    }

    public void setJsResource(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.env = new JSONObject(str).optString("env");
        } catch (JSONException e) {
            APLog.d("MUrlIntercept", "setJsResource exception: " + e.getMessage());
        }
    }

    private void showErrMessage(Context context) {
        Toast.makeText(context, APCommMethod.getStringId(context, "unipay_error_not_installed"), 1).show();
    }

    private boolean handleCustomUrl(WebView webView, InterceptItem interceptItem, String str) {
        if (interceptItem == null) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(63);
        String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
        String str2 = interceptItem.redirectUrl.replace("{env}", switchEnv()) + substring;
        APLog.d("MUrlIntercept", "handleCustomUrl matched url: " + str);
        APLog.d("MUrlIntercept", "handleCustomUrl integerUrl url: " + str2);
        webView.loadUrl(str2);
        return true;
    }

    private boolean handleCustomScheme(WebView webView, InterceptItem interceptItem, String str) {
        try {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception unused) {
            showErrMessage(webView.getContext());
            return true;
        }
    }

    private boolean handleIntent(WebView webView, InterceptItem interceptItem, String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setComponent(null);
            if (Build.VERSION.SDK_INT >= 15) {
                parseUri.setSelector(null);
            }
            if (webView.getContext().getPackageManager().resolveActivity(parseUri, 0) == null) {
                showErrMessage(webView.getContext());
                return true;
            }
            try {
                webView.getContext().startActivity(parseUri);
                return true;
            } catch (Exception e) {
                Log.e("MUrlIntercept", "ActivityNotFoundException: " + e.getLocalizedMessage());
                showErrMessage(webView.getContext());
                return true;
            }
        } catch (URISyntaxException e2) {
            Log.e("MUrlIntercept", "URISyntaxException: " + e2.getLocalizedMessage());
            showErrMessage(webView.getContext());
            return true;
        }
    }

    private boolean handleCommScheme(WebView webView, String str) {
        if (str.startsWith("sms:") || str.startsWith("smsto:") || str.startsWith("mms:") || str.startsWith("mmsto:")) {
            try {
                APLog.d("MUrlIntercept", "handleCommScheme url:" + str);
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
            try {
                APLog.d("MUrlIntercept", "handleCommScheme url:" + str);
                webView.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
        if (!str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_MAILTO)) {
            return false;
        }
        APLog.d("MUrlIntercept", "handleCommScheme url:" + str);
        try {
            webView.getContext().startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return true;
    }

    private boolean handleReferrer(WebView webView, InterceptItem interceptItem, String str) {
        HashMap hashMap = new HashMap();
        try {
            int lastIndexOf = str.lastIndexOf(63);
            String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
            String str2 = interceptItem.redirectUrl.replace("{env}", switchEnv()) + substring;
            APLog.d("MUrlIntercept", " handleReferrer matched url: " + str);
            APLog.d("MUrlIntercept", "handleReferrer integerUrl url: " + str2);
            hashMap.put("Referer", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webView.loadUrl(str, hashMap);
        return true;
    }

    @Override // com.tencent.midas.oversea.business.h5.webview.IIntercept
    public String handleUrl(WebView webView, String str) {
        ArrayList<InterceptItem> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.interceptItems) != null && !arrayList.isEmpty()) {
            InterceptItem interceptItem = null;
            Iterator<InterceptItem> it = this.interceptItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InterceptItem next = it.next();
                if (Pattern.matches(next.pattern, str)) {
                    interceptItem = next;
                    break;
                }
            }
            if (interceptItem != null) {
                if (interceptItem.type.equals("scheme")) {
                    handleCustomScheme(webView, interceptItem, str);
                } else if (interceptItem.type.equals(SDKConstants.PARAM_INTENT)) {
                    handleIntent(webView, interceptItem, str);
                } else if (interceptItem.type.equals(Constants.REFERRER)) {
                    handleReferrer(webView, interceptItem, str);
                } else if (!handleCustomUrl(webView, interceptItem, str)) {
                    webView.loadUrl(str);
                }
            } else if (!handleCommScheme(webView, str)) {
                webView.loadUrl(str);
            }
        } else if (!handleCommScheme(webView, str)) {
            webView.loadUrl(str);
        }
        return str;
    }

    private String switchEnv() {
        return "release".equals(this.env) ? "hk" : MConstants.DevEnv.equals(this.env) ? this.env : AdjustConfig.ENVIRONMENT_SANDBOX;
    }
}
