package com.tencent.mtt.spcialcall;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Vibrator;
import android.widget.FrameLayout;
import com.tencent.mtt.engine.AppEngine;
import com.tencent.mtt.engine.IWebView;
import com.tencent.mtt.engine.IWebViewClient;

/* loaded from: classes.dex */
public abstract class WebViewSpBase extends FrameLayout implements IWebView {
    public IWebViewClientSp mWebViewClient;

    public void active() {
    }

    public void back(boolean z) {
    }

    public boolean canGoBack() {
        return false;
    }

    public boolean canGoForward() {
        return false;
    }

    public void destroy() {
    }

    public void forward() {
    }

    public String getTitle() {
        return null;
    }

    public String getUrl() {
        return null;
    }

    protected abstract void initDownload();

    protected abstract void initWebChromClient();

    protected abstract void initWebSetting();

    protected abstract void initWebView();

    protected abstract void initWebViewClient();

    public void loadUrl(String str) {
    }

    public void reload() {
    }

    public void stopLoading() {
    }

    public static WebViewSpBase createWebView(Context context, IWebViewClientSp iWebViewClientSp) {
        return new WebViewSp(context, iWebViewClientSp);
    }

    private WebViewSpBase(Context context) {
        super(context);
    }

    public WebViewSpBase(Context context, IWebViewClientSp iWebViewClientSp) {
        super(context);
        setWebViewClient(iWebViewClientSp);
    }

    public void init() {
        initWebView();
        initWebSetting();
        initWebViewClient();
        initWebChromClient();
        initDownload();
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void setWebViewClient(IWebViewClient iWebViewClient) {
        this.mWebViewClient = (IWebViewClientSp) iWebViewClient;
    }

    public IWebViewClientSp getWebViewClient() {
        return this.mWebViewClient;
    }

    protected void performLongClick(String str, Bitmap bitmap) {
        performViberate();
        if (bitmap == null && str == null) {
            return;
        }
        showImageSaveDialog(str, bitmap);
    }

    public void showImageSaveDialog(String str, Bitmap bitmap) {
        this.mWebViewClient.showImageSaveDialog(str, bitmap);
    }

    public void performViberate() {
        AudioManager audioManager = (AudioManager) AppEngine.getInstance().getContext().getSystemService("audio");
        boolean z = false;
        if (audioManager != null && audioManager.getVibrateSetting(0) != 0) {
            z = true;
        }
        if (z) {
            ((Vibrator) AppEngine.getInstance().getContext().getSystemService("vibrator")).vibrate(new long[]{10, 20}, -1);
        }
    }

    public void deactive() {
        clearFocus();
    }
}
