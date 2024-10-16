package com.tencent.mtt.spcialcall;

import MTT.a;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.engine.AppEngine;
import com.tencent.mtt.engine.http.HttpUtils;
import com.tencent.smtt.sdk.WebView;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes.dex */
public class SpecialCallActivity extends Activity {
    public static final int FILE_UPLOAD = 1014;
    public static final int FLAG_HARDWARE_ACCELERATED = 16777216;
    private static final String MX2 = "Meizu_M040";
    private BrowserWindowSP mBrowserWindow;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private String mEntryUrl;
    private boolean mIsWebViewInit = false;
    private boolean mNeedKill = false;
    private BroadcastReceiver mReceiver;
    protected ValueCallback<Uri> uploadFile;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setFormat(-3);
        String str = String.valueOf(Build.MANUFACTURER) + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + Build.MODEL;
        if (Build.VERSION.SDK_INT > 10 && !MX2.equals(str)) {
            window.addFlags(FLAG_HARDWARE_ACCELERATED);
        }
        AppEngine.sCallMode = true;
        AppEngine.getInstance().setContext(this);
        setContentView(MttResources.getLayoutId("thrdcall_window"));
        window.setLayout(-1, -1);
        try {
            ExtraInfo.setDefaultFunc(getIntent());
        } catch (Exception unused) {
        }
        this.mEntryUrl = getIntent().getDataString();
        this.mBrowserWindow = new BrowserWindowSP(this, this.mEntryUrl, getIntent());
        BrowserWindowSP.updateScreenSize(this);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mBrowserWindow != null) {
            BrowserWindowSP.updateScreenSize(this);
            this.mBrowserWindow.onSreenOritationChage();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AppEngine.sCallMode = true;
        ValueCallback<Uri> valueCallback = this.uploadFile;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.uploadFile = null;
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mBrowserWindow.active();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mBrowserWindow.deActive();
        getWindow().setWindowAnimations(MttResources.getStyleId("ThrdCallActivityAnimationNone"));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        BrowserWindowSP browserWindowSP;
        super.onWindowFocusChanged(z);
        if (this.mIsWebViewInit || (browserWindowSP = this.mBrowserWindow) == null) {
            return;
        }
        this.mIsWebViewInit = true;
        browserWindowSP.delayInitWebView();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCustomViewContainer != null) {
                try {
                    ((ViewGroup) getWindow().getDecorView()).removeView(this.mCustomViewContainer);
                    this.mCustomViewContainer = null;
                    if (this.mCustomViewCallback != null) {
                        this.mCustomViewCallback.onCustomViewHidden();
                        this.mCustomViewCallback = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
            doExit();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void doExit() {
        a aVar = new a();
        aVar.f6a = ExtraInfo.getOriPkg();
        if (this.mBrowserWindow != null) {
            aVar.f = r1.getPv();
        }
        HttpUtils.post(aVar);
        getWindow().setWindowAnimations(MttResources.getStyleId("ThrdCallActivityAnimationOut"));
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1014 && this.uploadFile != null) {
            this.uploadFile.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
            this.uploadFile = null;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            this.mBrowserWindow.destroy();
            if (this.mReceiver != null) {
                unregisterReceiver(this.mReceiver);
            }
        } catch (Exception unused) {
        }
        if (this.mNeedKill) {
            Process.killProcess(Process.myPid());
        }
    }

    public void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = this.mCustomViewContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        WebChromeClient.CustomViewCallback customViewCallback2 = this.mCustomViewCallback;
        if (customViewCallback2 != null) {
            customViewCallback2.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        if (this.mCustomViewContainer == null) {
            this.mCustomViewContainer = new FrameLayout(this);
            this.mCustomViewContainer.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            viewGroup.addView(this.mCustomViewContainer);
        }
        this.mCustomViewContainer.addView(view);
        this.mCustomViewCallback = customViewCallback;
    }
}
