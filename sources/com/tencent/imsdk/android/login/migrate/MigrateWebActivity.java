package com.tencent.imsdk.android.login.migrate;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MigrateWebActivity extends Activity {
    private View mBtnBack;
    private View mBtnClose;
    private LinearLayout mContentView;
    private ProgressBar mProgressBar;
    private TextView mTvTitle;
    private WebView mWebView;
    private String seqID = "";

    /* loaded from: classes.dex */
    private class MigrateWebClient extends WebViewClient {
        private MigrateWebClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String title = webView.getTitle();
            if (!T.ckIsEmpty(title)) {
                MigrateWebActivity.this.mTvTitle.setText(title);
            }
            if (webView.canGoBack()) {
                MigrateWebActivity.this.mBtnBack.setEnabled(true);
            } else {
                MigrateWebActivity.this.mBtnBack.setEnabled(false);
            }
        }
    }

    /* loaded from: classes.dex */
    private class MigrateWebChrome extends WebChromeClient {
        private MigrateWebChrome() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i < 100) {
                MigrateWebActivity.this.mProgressBar.setVisibility(0);
            } else {
                MigrateWebActivity.this.mProgressBar.setVisibility(8);
            }
            MigrateWebActivity.this.mProgressBar.setProgress(i);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String orMetaData = IMSDKConfig.getOrMetaData(MigrateWebConsts.MIGRATE_WEB_WEB_URL_KEY, MigrateWebConsts.MIGRATE_WEB_WEB_URL_KEY, "");
        if (T.ckIsEmpty(orMetaData)) {
            IMLogger.e("Migrate login needs to configure SELF_WEB_URL in MSDKConfig.ini file, please configure and retry...", new Object[0]);
            return;
        }
        setContentView(MigrateResourceUtil.getLayoutId(this, MigrateWebConsts.MIGRATE_ACTIVITY_WEB));
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.seqID = getIntent().getExtras().getString(MigrateWebConsts.MIGRATE_WEB_INTENT_SEQ);
        }
        IMLogger.d("[ " + this.seqID + "] start Migrate webview activity ");
        this.mWebView = (WebView) findViewById(MigrateResourceUtil.getId(this, MigrateWebConsts.MIGRATE_WEB_VIEW));
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.mWebView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        setWebSetting(this.mWebView.getSettings());
        this.mTvTitle = (TextView) findViewById(MigrateResourceUtil.getId(this, MigrateWebConsts.MIGRATE_TV_TITLE));
        this.mBtnBack = findViewById(MigrateResourceUtil.getId(this, MigrateWebConsts.MIGRATE_BTN_BACK));
        this.mBtnBack.setEnabled(false);
        this.mBtnBack.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.imsdk.android.login.migrate.MigrateWebActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MigrateWebActivity.this.mWebView.canGoBack()) {
                    MigrateWebActivity.this.mWebView.goBack();
                }
            }
        });
        this.mWebView.setWebViewClient(new MigrateWebClient());
        this.mProgressBar = (ProgressBar) findViewById(MigrateResourceUtil.getId(this, MigrateWebConsts.MIGRATE_BAR_PROGRESS));
        this.mWebView.setWebChromeClient(new MigrateWebChrome());
        this.mBtnClose = findViewById(MigrateResourceUtil.getId(this, MigrateWebConsts.MIGRATE_BTN_CLOSE));
        this.mBtnClose.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.imsdk.android.login.migrate.MigrateWebActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("msg", "user click close");
                MigrateWebActivity.this.setResult(0, intent);
                MigrateWebActivity.this.finish();
            }
        });
        this.mWebView.addJavascriptInterface(new MSDKJavascript(), MigrateWebConsts.MIGRATE_WEB_JS_CLASS);
        IMLogger.d("[ " + this.seqID + "] start loading url " + orMetaData);
        this.mWebView.loadUrl(orMetaData);
    }

    private void setWebSetting(WebSettings webSettings) {
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(2);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSavePassword(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUserAgentString(IMSDKConfig.getOrMetaData(MigrateWebConsts.MIGRATE_WEB_USER_AGENT_STRING_KEY, MigrateWebConsts.MIGRATE_WEB_USER_AGENT_STRING_KEY, MigrateWebConsts.MIGRATE_WEB_USER_AGENT_DEFT_VALUE));
        webSettings.setTextZoom(100);
    }

    /* loaded from: classes.dex */
    private class MSDKJavascript {
        private MSDKJavascript() {
        }

        @JavascriptInterface
        public void onResult(String str) {
            IMLogger.d("[ " + MigrateWebActivity.this.seqID + "] on Migrate web page result : " + str);
            Intent intent = new Intent();
            try {
                JSONObject jSONObject = new JSONObject(str);
                intent.putExtra("openid", jSONObject.getString("openid"));
                intent.putExtra(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_INNER_TOKEN, jSONObject.getString(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_INNER_TOKEN));
                intent.putExtra(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID, jSONObject.getString(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID));
                intent.putExtra("channelId", jSONObject.getString("channelId"));
                intent.putExtra("ret", 0);
                intent.putExtra("msg", "Success");
                MigrateWebActivity.this.setResult(-1, intent);
                MigrateWebActivity.this.finish();
            } catch (Exception e) {
                IMLogger.d("[ " + MigrateWebActivity.this.seqID + "] Migrate web page data parse with exception : " + e.getMessage());
                intent.putExtra("ret", -1);
                StringBuilder sb = new StringBuilder();
                sb.append("parse Migrate result error : ");
                sb.append(e.getMessage());
                intent.putExtra("msg", sb.toString());
                MigrateWebActivity.this.setResult(-1, intent);
                MigrateWebActivity.this.finish();
            }
        }
    }
}
