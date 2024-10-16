package com.tencent.imsdk.android.login.webverify;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WebVerifyActivity extends Activity {
    private WebSettings webSettings;
    private WebView webview;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hideSystemNavigationBar();
        setContentView(WebVerifyResourceUtil.getLayoutId(this, WebVerifyConst.ACTIVITY_WEB_VERIFY_LAYOUT_NAME));
        String orMetaData = IMSDKConfig.getOrMetaData(WebVerifyConst.IMSDK_WEB_VERIFY_URL, WebVerifyConst.IMSDK_WEB_VERIFY_URL, "");
        if (T.ckIsEmpty(orMetaData)) {
            IMLogger.e("needs to configure IMSDK_WEB_VERIFY_URL in AndroidManifest.xml, please configure and retry...", new Object[0]);
            finish();
        } else {
            initView(getUrlWithOptions(orMetaData, getIntent().getStringExtra(WebVerifyConst.IMSDK_VERIFY_OPTIONS)));
        }
    }

    String getUrlWithOptions(String str, String str2) {
        JSONObject jSONObject;
        Iterator<String> keys;
        if (T.ckIsEmpty(str)) {
            IMLogger.e("url is empty", new Object[0]);
            return "";
        }
        if (T.ckIsEmpty(str2)) {
            IMLogger.d("options is empty");
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        try {
            jSONObject = new JSONObject(str2);
            keys = jSONObject.keys();
        } catch (JSONException e) {
            IMLogger.e("json parsing error in urlWithOptions, " + str2 + ", " + e.getMessage(), new Object[0]);
        }
        if (keys.hasNext()) {
            String next = keys.next();
            String str3 = (String) jSONObject.get(next);
            sb.append("?");
            sb.append(next);
            sb.append("=");
            sb.append(str3);
            while (keys.hasNext()) {
                String next2 = keys.next();
                String str4 = (String) jSONObject.get(next2);
                if (!T.ckIsEmpty(str4)) {
                    sb.append("&");
                    sb.append(next2);
                    sb.append("=");
                    sb.append(str4);
                }
            }
            return sb.toString();
        }
        return sb.toString();
    }

    private void initView(String str) {
        this.webview = (WebView) findViewById(WebVerifyResourceUtil.getId(this, WebVerifyConst.WIDGET_WEBVIEW_NAME));
        findViewById(WebVerifyResourceUtil.getId(this, WebVerifyConst.CLOSE_WEBVIEW_NAME)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.imsdk.android.login.webverify.WebVerifyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("msg", "user click close");
                WebVerifyActivity.this.setResult(0, intent);
                WebVerifyActivity.this.finish();
            }
        });
        this.webSettings = this.webview.getSettings();
        this.webSettings.setUseWideViewPort(true);
        this.webSettings.setLoadWithOverviewMode(true);
        this.webSettings.setCacheMode(2);
        this.webview.setWebViewClient(new WebViewClient() { // from class: com.tencent.imsdk.android.login.webverify.WebVerifyActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                webView.loadUrl(str2);
                return true;
            }
        });
        this.webSettings.setJavaScriptEnabled(true);
        this.webview.addJavascriptInterface(new JsBridge(), WebVerifyConst.JS_BRIDGE_NAME);
        this.webview.loadUrl(str);
    }

    private void hideSystemNavigationBar() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            getWindow().getDecorView().setSystemUiVisibility(8);
        } else if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
    }

    /* loaded from: classes.dex */
    public class JsBridge {
        public JsBridge() {
        }

        @JavascriptInterface
        public void getData(String str) {
            IMLogger.d("callback from webverify, result is: " + str);
            Intent intent = new Intent();
            if (str == null) {
                IMLogger.d("web verify data is null");
                intent.putExtra("ret", 2);
                intent.putExtra("msg", "web verify data is null");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i = jSONObject.getInt("ret");
                    String string = jSONObject.getString("msg");
                    if (i == 0) {
                        intent.putExtra("ret", 1);
                        intent.putExtra("msg", string);
                        intent.putExtra(WebVerifyConst.IMSDK_WEB_VERIFY_CAPTCHA, str);
                    } else {
                        intent.putExtra("ret", 2);
                        intent.putExtra("msg", string);
                        intent.putExtra(WebVerifyConst.IMSDK_WEB_VERIFY_CAPTCHA, str);
                    }
                } catch (JSONException unused) {
                    IMLogger.d("web verify data json parsing error");
                    intent.putExtra("ret", 2);
                    intent.putExtra("msg", "web verify data json parsing error");
                }
            }
            WebVerifyActivity.this.setResult(136, intent);
            WebVerifyActivity.this.finish();
        }
    }
}
