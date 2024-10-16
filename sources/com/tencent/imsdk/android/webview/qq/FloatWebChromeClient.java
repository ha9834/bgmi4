package com.tencent.imsdk.android.webview.qq;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewActionResult;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes.dex */
public class FloatWebChromeClient extends WebChromeClient {
    Activity activity;
    View mCustomView;
    IX5WebChromeClient.CustomViewCallback mCustomViewCallback;
    int mOriginalOrientation;
    int mOriginalSystemUiVisibility;

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.activity = T.mGlobalActivityUpToDate;
        if (this.activity == null) {
            IMLogger.e("mGlobalActivityUpToDate is empty", new Object[0]);
            super.onShowCustomView(view, customViewCallback);
            return;
        }
        IMLogger.d("onShowCustomView");
        if (this.mCustomView != null) {
            IMLogger.d("onShowCustomView view is non empty");
            onHideCustomView();
            return;
        }
        this.mCustomView = view;
        this.mCustomView.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.mOriginalSystemUiVisibility = this.activity.getWindow().getDecorView().getSystemUiVisibility();
        this.mOriginalOrientation = this.activity.getRequestedOrientation();
        this.mCustomViewCallback = customViewCallback;
        ((ViewGroup) this.activity.getWindow().getDecorView()).addView(this.mCustomView, new ViewGroup.LayoutParams(-1, -1));
        this.activity.getWindow().getDecorView().setSystemUiVisibility(3846);
        this.activity.setRequestedOrientation(0);
        if (WebViewManager.mActionListener != null) {
            IMSDKWebViewActionResult iMSDKWebViewActionResult = new IMSDKWebViewActionResult(1);
            iMSDKWebViewActionResult.stateCode = 5;
            WebViewManager.mActionListener.onResult(iMSDKWebViewActionResult);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onHideCustomView() {
        IMLogger.d("onHideCustomView");
        if (this.mCustomView != null && WebViewManager.mActionListener != null) {
            IMSDKWebViewActionResult iMSDKWebViewActionResult = new IMSDKWebViewActionResult(1);
            iMSDKWebViewActionResult.stateCode = 6;
            WebViewManager.mActionListener.onResult(iMSDKWebViewActionResult);
        }
        ((ViewGroup) this.activity.getWindow().getDecorView()).removeView(this.mCustomView);
        this.mCustomView = null;
        this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
        this.activity.setRequestedOrientation(this.mOriginalOrientation);
        this.mCustomViewCallback.onCustomViewHidden();
        this.mCustomViewCallback = null;
    }
}
