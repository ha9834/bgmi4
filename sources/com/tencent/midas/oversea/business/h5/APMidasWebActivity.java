package com.tencent.midas.oversea.business.h5;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.h5.AIDLHandler;
import com.tencent.midas.oversea.business.h5.url.IH5;
import com.tencent.midas.oversea.business.h5.url.UrlFactory;
import com.tencent.midas.oversea.business.h5.webview.MUrlIntercept;
import com.tencent.midas.oversea.business.h5.webview.MWebView;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.comm.MUIManager;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.InitParams;

/* loaded from: classes.dex */
public class APMidasWebActivity extends Activity {
    public static final String TAG = "APMidasWebActivity";
    private int orderKey = 0;
    private IH5 h5 = null;
    private AIDLHandler aidlHandler = null;
    private MUrlIntercept mUrlIntercept = null;
    private FrameLayout wvContainer = null;
    private RelativeLayout refreshLayout = null;
    private TextView refreshContent = null;
    private MWebView mWebView = null;
    private MUIManager uiManager = null;
    private String mDebugUrl = "";
    private ProgressBar mProgressBar = null;
    private AIDLHandler.AIDLListener aidlListener = new AIDLHandler.AIDLListener() { // from class: com.tencent.midas.oversea.business.h5.APMidasWebActivity.1
        @Override // com.tencent.midas.oversea.business.h5.AIDLHandler.AIDLListener
        public void OnServiceConnected() {
            if (APMidasWebActivity.this.h5.ifSetLocalCacheIP()) {
                APMidasWebActivity.this.h5.setLocalCacheIP(APMidasWebActivity.this.aidlHandler.queryCacheIP(APMidasWebActivity.this.h5.getHost()));
            }
            MTimer.stop(MTimer.SDK_WEBVIEW_PROCESS_LOAD);
            MTimer.start(MTimer.SDK_WEBVIEW_PAGE_LOAD);
            APMidasWebActivity aPMidasWebActivity = APMidasWebActivity.this;
            if (!TextUtils.isEmpty(aPMidasWebActivity.getDebugModeUrl(aPMidasWebActivity.mDebugUrl))) {
                APLog.d(APMidasWebActivity.TAG, "loadUrl url: " + APMidasWebActivity.this.mDebugUrl);
                APMidasWebActivity.this.mWebView.loadUrl(APMidasWebActivity.this.mDebugUrl);
                return;
            }
            APLog.d(APMidasWebActivity.TAG, "loadUrl url: " + APMidasWebActivity.this.h5.getUrl(APMidasWebActivity.this.getApplicationContext()));
            APMidasWebActivity.this.mWebView.loadUrl(APMidasWebActivity.this.h5.getUrl(APMidasWebActivity.this.getApplicationContext()));
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(APCommMethod.getLayoutId(this, "unipay_abroad_layout_h5"));
        this.refreshLayout = (RelativeLayout) findViewById(APCommMethod.getId(this, "unipay_id_h5_refresh_layout"));
        this.refreshContent = (TextView) findViewById(APCommMethod.getId(this, "unipay_id_h5_err_content"));
        this.wvContainer = (FrameLayout) findViewById(APCommMethod.getId(this, "unipay_id_h5_webview_container"));
        this.mProgressBar = (ProgressBar) findViewById(APCommMethod.getId(this, "progressBar"));
        APLog.d(TAG, "onDestroy()");
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix("midasbuy" + APTools.getProcessName(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MTimer.start(MTimer.SDK_WEBVIEW_LOAD);
        MTimer.start(MTimer.SDK_WEBVIEW_DOM_LOAD);
        MTimer.start(MTimer.SDK_WEBVIEW_PROCESS_LOAD);
        this.mWebView = new MWebView(this);
        this.mWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.wvContainer.addView(this.mWebView);
        this.mUrlIntercept = new MUrlIntercept();
        this.mWebView.setIntercept(this.mUrlIntercept);
        getAidlParams();
        setListeners();
        this.uiManager = new MUIManager(this);
        this.aidlHandler = new AIDLHandler(this);
        this.aidlHandler.setAIDLListener(this.aidlListener);
        this.aidlHandler.bindService();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return true;
            }
            callbackAndDestroy();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        APLog.i(TAG, "onDestroy()");
        this.aidlHandler.release();
        MWebView mWebView = this.mWebView;
        if (mWebView != null && (viewGroup = (ViewGroup) mWebView.getParent()) != null) {
            viewGroup.removeView(this.mWebView);
            this.mWebView.destroy();
        }
        super.onDestroy();
    }

    private void getAidlParams() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            boolean z = extras.getBoolean("LogEnable");
            this.orderKey = extras.getInt("OrderKey");
            String string = extras.getString("PayChannel");
            String string2 = extras.getString("PayParams");
            webProcessInit(string2);
            this.mDebugUrl = extras.getString("debugUrl");
            APMidasPayNewAPI.singleton().setLogEnable(z);
            this.h5 = UrlFactory.create(string);
            IH5 ih5 = this.h5;
            if (ih5 != null) {
                ih5.setJsResource(string2);
            }
            this.mUrlIntercept.setJsResource(string2);
        }
    }

    private void setListeners() {
        this.mWebView.setWebViewClientListener(new MWebView.WebViewClientListener() { // from class: com.tencent.midas.oversea.business.h5.APMidasWebActivity.2
            @Override // com.tencent.midas.oversea.business.h5.webview.MWebView.WebViewClientListener
            public void onPageStarted(WebView webView, String str) {
            }

            @Override // com.tencent.midas.oversea.business.h5.webview.MWebView.WebViewClientListener
            public void onRequestError(String str) {
                APMidasWebActivity.this.wvContainer.setVisibility(4);
                APMidasWebActivity.this.refreshLayout.setVisibility(0);
                APMidasWebActivity.this.mProgressBar.setVisibility(8);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                APMidasWebActivity.this.refreshContent.setText(str);
            }

            @Override // com.tencent.midas.oversea.business.h5.webview.MWebView.WebViewClientListener
            public void onPageFinished(WebView webView, String str) {
                APLog.d(APMidasWebActivity.TAG, "setListeners onPageFinished");
            }
        });
        this.mWebView.setWebChromeClientListener(new MWebView.WebChromeClientListener() { // from class: com.tencent.midas.oversea.business.h5.APMidasWebActivity.3
            @Override // com.tencent.midas.oversea.business.h5.webview.MWebView.WebChromeClientListener
            public void onJsAlert(String str, String str2, JsResult jsResult) {
                APMidasWebActivity.this.h5.onJsAlert(str2);
                APMidasWebActivity.this.mUrlIntercept.setInterceptItems(APMidasWebActivity.this.h5.getInterceptItems());
            }

            @Override // com.tencent.midas.oversea.business.h5.webview.MWebView.WebChromeClientListener
            public void onProgressChanged(int i) {
                Log.d(APMidasWebActivity.TAG, "progress: " + i);
                if (i == 100) {
                    APMidasWebActivity.this.mProgressBar.setVisibility(8);
                } else {
                    APMidasWebActivity.this.mProgressBar.setVisibility(0);
                    APMidasWebActivity.this.mProgressBar.setProgress(i);
                }
            }
        });
        findViewById(APCommMethod.getId(this, "unipay_id_h5_close")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.midas.oversea.business.h5.APMidasWebActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APMidasWebActivity.this.callbackAndDestroy();
            }
        });
        this.refreshLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.midas.oversea.business.h5.APMidasWebActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APMidasWebActivity.this.wvContainer.setVisibility(0);
                APMidasWebActivity.this.refreshLayout.setVisibility(4);
                APMidasWebActivity aPMidasWebActivity = APMidasWebActivity.this;
                if (!TextUtils.isEmpty(aPMidasWebActivity.getDebugModeUrl(aPMidasWebActivity.mDebugUrl))) {
                    APLog.d(APMidasWebActivity.TAG, "loadUrl url: " + APMidasWebActivity.this.mDebugUrl);
                    APMidasWebActivity.this.mWebView.loadUrl(APMidasWebActivity.this.mDebugUrl);
                    return;
                }
                APLog.d(APMidasWebActivity.TAG, "loadUrl url: " + APMidasWebActivity.this.h5.getUrl(APMidasWebActivity.this.getApplicationContext()));
                APMidasWebActivity.this.mWebView.loadUrl(APMidasWebActivity.this.h5.getUrl(APMidasWebActivity.this.getApplicationContext()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAndDestroy() {
        IH5 ih5 = this.h5;
        if (ih5 != null) {
            this.aidlHandler.onResponse(this.orderKey, ih5.getRetCode(), this.h5.getRetMsg());
        } else {
            this.aidlHandler.onResponse(this.orderKey, -1, "");
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDebugModeUrl(String str) {
        APLog.d(TAG, "!!!webview debug mode  isApkInDebug：" + APTools.isApkInDebug(getApplicationContext()));
        APLog.d(TAG, "!!!webview debug mode  debugUrl：" + str);
        if (!APTools.isApkInDebug(getApplicationContext()) || TextUtils.isEmpty(str)) {
            return "";
        }
        APLog.d(TAG, "!!!webview debug mode  custom url is: " + str);
        return str;
    }

    public void webProcessInit(String str) {
        String jsonValue = APTools.getJsonValue(str, "env");
        String jsonValue2 = APTools.getJsonValue(str, "idc");
        String jsonValue3 = APTools.getJsonValue(str, "offerId");
        String jsonValue4 = APTools.getJsonValue(str, "openId");
        String jsonValue5 = APTools.getJsonValue(str, "zoneId");
        APMidasPayNewAPI.singleton().setApplicationContext(this);
        GlobalData.singleton().init(new InitParams.Builder().setEnv(jsonValue).setIDC(jsonValue2).setOfferID(jsonValue3).setOpenID(jsonValue4).setZoneID(jsonValue5).build());
    }
}
