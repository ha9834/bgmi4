package com.tencent.imsdk.android.webview.qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.google.android.gms.drive.DriveFile;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.webview.IMSDKWebViewActionResult;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WebViewManager {
    protected static final int ACTION_CODE_WEBVIEW_CALLJS_RETURN = 4;
    protected static final int ACTION_CODE_WEBVIEW_CLOSE = 2;
    protected static final int ACTION_CODE_WEBVIEW_CUSTOM_VIEW_ENTER = 5;
    protected static final int ACTION_CODE_WEBVIEW_CUSTOM_VIEW_LEFT = 6;
    protected static final int ACTION_CODE_WEBVIEW_JS_CALL = 3;
    protected static final int ACTION_CODE_WEBVIEW_OPEN = 1;
    public static final int IMSDK_WEBVIEW_DEFAULT_BG_COLOR = -12040120;
    public static final String INTENT_KEY_BG_COLOR = "bg_color";
    public static final String INTENT_KEY_EXTRA_X5_WORK = "extra_x5_work";
    public static final String INTENT_KEY_HEIGHT = "webview_height";
    public static final String INTENT_KEY_IS_LANDSCAPE = "webview_is_landscape";
    public static final String INTENT_KEY_IS_ORIENTATION = "webview_is_orientation";
    public static final String INTENT_KEY_URL = "webview_url";
    public static final String INTENT_KEY_USE_NOTCH = "use_notch";
    public static final String INTENT_KEY_WIDTH = "webview_width";
    protected static final int MSG_ACTIVITY_FINISH = 21;
    protected static final int MSG_ACTIVITY_MESSENGER = 23;
    protected static final String MSG_JAVA_CALL_HIDE_TOOL_BAR = "hideToolBar";
    protected static final int MSG_JAVA_CALL_JS = 24;
    protected static final int MSG_JAVA_CALL_JS_RETURN = 25;
    protected static final String MSG_JAVA_CALL_KEY_JSON = "json_data";
    protected static final int MSG_JAVA_CALL_TOOL_BAR = 26;
    protected static final int MSG_JS_CALL_JAVA = 22;
    private static volatile WebViewManager instance;
    public static IMSDKResultListener<IMSDKWebViewActionResult> mActionListener;
    private static Activity mCurActivity;
    private static FrameLayout.LayoutParams mFrameLayoutParams;
    private DisplayMetrics mDisplayMetrics;
    private boolean mIsToolbar;
    private final String EXTRA_JSON_KEY_CLOSE_BUTTON = "needCloseButton";
    private final String EXTRA_JSON_KEY_BG_COLOR = "bgColor";
    private final String EXTRA_JSON_USE_NOTCH = "useNotch";
    private float mWebViewHeight = 1.0f;
    private float mWebViewWidth = 1.0f;
    private boolean mIsLandscape = true;
    private boolean mIsUserSetOrientation = false;
    private FloatWebView mWebView = null;
    private Context mCtx = null;
    private String mURL = "";
    private boolean mIsLoaded = false;
    private boolean mWaitForClose = false;
    private Messenger mServerMessenger = null;
    private Messenger mClientMessenger = null;

    private void runOnUiThread(Runnable runnable) {
        try {
            if (mCurActivity != null) {
                mCurActivity.runOnUiThread(runnable);
            }
        } catch (Exception e) {
            IMLogger.d(e.getMessage());
        }
    }

    FrameLayout.LayoutParams copyFrameLayoutParams(FrameLayout.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new FrameLayout.LayoutParams(layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        layoutParams2.leftMargin = layoutParams.leftMargin;
        layoutParams2.rightMargin = layoutParams.rightMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        layoutParams2.bottomMargin = layoutParams.bottomMargin;
        layoutParams2.gravity = layoutParams.gravity;
        layoutParams2.layoutAnimationParameters.index = layoutParams.layoutAnimationParameters.index;
        layoutParams2.layoutAnimationParameters.count = layoutParams.layoutAnimationParameters.count;
        return layoutParams2;
    }

    FrameLayout.LayoutParams getLayoutParams() {
        return mFrameLayoutParams;
    }

    @SuppressLint({"JavascriptInterface"})
    private void initWebView(final boolean z, final boolean z2, final int i, final IMSDKResultListener iMSDKResultListener) {
        runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewManager.this.mWebView == null) {
                    WebViewCommonUtil.initX5Environment(WebViewManager.this.mCtx, z);
                    WebViewManager.this.mWebView = new FloatWebView(WebViewManager.mCurActivity);
                    WebViewManager.this.mWebView.setWebViewClient(new FloatWebViewClient() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.1.1
                        @Override // com.tencent.imsdk.android.webview.qq.FloatWebViewClient, com.tencent.smtt.sdk.WebViewClient
                        public void onPageFinished(WebView webView, String str) {
                            super.onPageFinished(webView, str);
                            WebViewManager.this.mIsLoaded = true;
                        }
                    });
                    WebViewManager.this.mWebView.setWebChromeClient(new FloatWebChromeClient());
                    WebViewManager.this.mWebView.setBackgroundColor(i);
                    WebViewCommonUtil.initWebViewSettings(WebViewManager.mCurActivity, WebViewManager.this.mWebView.getWebView(WebViewManager.mCurActivity));
                }
                if (z2) {
                    WebViewManager.this.mWebView.getCloseButton(WebViewManager.mCurActivity).setVisibility(0);
                    WebViewManager.this.mWebView.getCloseButton(WebViewManager.mCurActivity).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            WebViewManager.this.optWebViewOnUIThread(5);
                        }
                    });
                } else {
                    WebViewManager.this.mWebView.getCloseButton(WebViewManager.mCurActivity).setVisibility(8);
                }
                IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                if (iMSDKResultListener2 != null) {
                    iMSDKResultListener2.onResult(new IMSDKResult(1));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrlInWebView(final String str, final boolean z, final boolean z2, final boolean z3) {
        IMLogger.d("loadUrlInWebView start");
        this.mIsLoaded = false;
        runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewManager.this.mWebView != null) {
                    if (WebViewManager.this.mWebView.getParent() != null) {
                        ((ViewGroup) WebViewManager.this.mWebView.getParent()).removeView(WebViewManager.this.mWebView);
                    }
                    FrameLayout.LayoutParams copyFrameLayoutParams = WebViewManager.this.copyFrameLayoutParams(WebViewManager.mFrameLayoutParams);
                    if (z3) {
                        copyFrameLayoutParams.width += WebViewManager.this.mWebView.getCloseButton(WebViewManager.mCurActivity).getLayoutParams().width;
                    }
                    if (WebViewManager.this.mWebView.getParent() == null) {
                        WebViewManager.mCurActivity.getWindow().addContentView(WebViewManager.this.mWebView, copyFrameLayoutParams);
                    } else {
                        WebViewManager.this.mWebView.setLayoutParams(copyFrameLayoutParams);
                    }
                    WebViewManager.this.mWebView.setVisibility(0);
                    WebViewManager.this.mWebView.requestFocus();
                    WebViewManager.this.mWebView.bringToFront();
                    IX5WebViewExtension x5WebViewExtension = WebViewManager.this.mWebView.getX5WebViewExtension();
                    if (!z) {
                        IMLogger.d("showHorizontalScrollBar = " + z);
                        WebViewManager.this.mWebView.getView().setHorizontalScrollBarEnabled(false);
                        if (x5WebViewExtension != null) {
                            x5WebViewExtension.setScrollBarFadingEnabled(false);
                            x5WebViewExtension.setHorizontalScrollBarEnabled(false);
                        }
                    }
                    if (!z2) {
                        IMLogger.d("showVerticalScrollBar = " + z2);
                        WebViewManager.this.mWebView.getView().setVerticalScrollBarEnabled(false);
                        if (x5WebViewExtension != null) {
                            x5WebViewExtension.setScrollBarFadingEnabled(false);
                            x5WebViewExtension.setVerticalScrollBarEnabled(false);
                        }
                    }
                    IMLogger.d("start loading url : " + str);
                    WebViewManager.this.mWebView.loadUrl(str);
                    if (WebViewManager.this.mWaitForClose) {
                        WebViewManager.this.optWebViewOnUIThread(5);
                        return;
                    }
                    return;
                }
                IMLogger.d("web view instance is null !");
            }
        });
    }

    private void loadURLWithToolBar(String str, boolean z, boolean z2, int i) {
        Intent intent = new Intent();
        intent.putExtra("webview_url", str);
        intent.putExtra(INTENT_KEY_HEIGHT, this.mWebViewHeight);
        intent.putExtra(INTENT_KEY_WIDTH, this.mWebViewWidth);
        intent.putExtra(INTENT_KEY_IS_LANDSCAPE, this.mIsLandscape);
        intent.putExtra(INTENT_KEY_IS_ORIENTATION, this.mIsUserSetOrientation);
        intent.putExtra(INTENT_KEY_EXTRA_X5_WORK, z);
        intent.putExtra(INTENT_KEY_USE_NOTCH, z2);
        intent.putExtra(INTENT_KEY_BG_COLOR, i);
        intent.setClass(this.mCtx, WebViewWithFavActivity.class);
        try {
            IMLogger.d("start QQ webView with toolbar.");
            startFavActivity(this.mCtx, intent);
        } catch (ActivityNotFoundException unused) {
            IMLogger.w("can't start WebViewActivity，Make sure you have register \"WebViewWithFavActivity\"", new Object[0]);
        }
    }

    public void optWebViewOnUIThread(final int i) {
        IMLogger.d("optWebViewOnUIThread action=" + i + ", mIsToolbar=" + this.mIsToolbar);
        if (this.mIsToolbar) {
            sendMessageToClient(i, null);
            return;
        }
        if (this.mWebView == null) {
            IMLogger.d("webview instance is null");
            if (i == 5) {
                this.mWaitForClose = false;
                return;
            }
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewManager.this.mWebView == null) {
                    return;
                }
                switch (i) {
                    case 5:
                        if (WebViewManager.this.mWebView.getParent() != null) {
                            ((ViewGroup) WebViewManager.this.mWebView.getParent()).removeView(WebViewManager.this.mWebView);
                        }
                        WebViewManager.this.mWebView.stopLoading();
                        WebViewManager.this.mWebView.setVisibility(8);
                        WebViewManager.this.mWebView.removeAllViews();
                        WebViewManager.this.mWebView.destroy();
                        WebViewManager.this.mWebView = null;
                        WebViewManager.this.mIsLoaded = false;
                        WebViewManager.this.mWaitForClose = false;
                        WebViewManager.this.notifyWebViewClose();
                        return;
                    case 6:
                        WebViewManager.this.mWebView.goBack();
                        return;
                    case 7:
                        WebViewManager.this.mWebView.goForward();
                        return;
                    case 8:
                        WebViewManager.this.mWebView.reload();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public boolean getStatusOfWebView(int i) {
        FloatWebView floatWebView = this.mWebView;
        if (floatWebView == null) {
            IMLogger.d("webView instance is null");
            return false;
        }
        if (i == 9) {
            IMLogger.d("mIsLoaded - " + this.mIsLoaded);
            return this.mIsLoaded;
        }
        if (i != 21) {
            switch (i) {
                case 16:
                    IMLogger.d("canGoForward - " + this.mWebView.canGoBack());
                    return this.mWebView.canGoBack();
                case 17:
                    IMLogger.d("canGoForward - " + this.mWebView.canGoForward());
                    return this.mWebView.canGoForward();
                default:
                    return false;
            }
        }
        boolean z = floatWebView.getVisibility() == 0;
        IMLogger.d("isVisible - " + z);
        return z;
    }

    public String getCurrentUrl() {
        return this.mURL;
    }

    private WebViewManager() {
    }

    public static WebViewManager getInstance() {
        mCurActivity = T.mGlobalActivityUpToDate;
        if (instance == null) {
            synchronized (WebViewManager.class) {
                if (instance == null) {
                    instance = new WebViewManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.mCtx = context;
        this.mDisplayMetrics = new DisplayMetrics();
        mCurActivity.getWindowManager().getDefaultDisplay().getMetrics(this.mDisplayMetrics);
        mFrameLayoutParams = new FrameLayout.LayoutParams(this.mDisplayMetrics.widthPixels, this.mDisplayMetrics.heightPixels);
    }

    public void setZoom(float f, float f2) {
        this.mWebViewHeight = f;
        this.mWebViewWidth = f2;
        setPosition((int) ((this.mDisplayMetrics.widthPixels * (1.0f - f2)) / 2.0f), (int) ((this.mDisplayMetrics.heightPixels * (1.0f - f)) / 2.0f), (int) (this.mDisplayMetrics.widthPixels * f), (int) (this.mDisplayMetrics.heightPixels * f2));
    }

    public void setOrientation(boolean z) {
        this.mIsUserSetOrientation = true;
        this.mIsLandscape = z;
    }

    private void openUrlByBrowser(String str) {
        IMLogger.d("open url by browser : " + str);
        ArrayList arrayList = new ArrayList();
        int arrayId = ResourceUtil.getArrayId(this.mCtx, "urlKeyFilter");
        if (arrayId != 0) {
            for (String str2 : this.mCtx.getResources().getStringArray(arrayId)) {
                arrayList.add(str2.trim());
            }
        } else {
            IMLogger.w("urlKeyFilter not set!", new Object[0]);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.setData(Uri.parse(DisplayUtil.filterUrlParaKey(str, arrayList)));
        Context context = this.mCtx;
        if (context != null) {
            context.startActivity(intent);
        } else {
            IMLogger.e("initialize should be called before open url", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openUrl(java.lang.String r4, boolean r5, java.lang.String r6, boolean r7, boolean r8, final boolean r9, final boolean r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.webview.qq.WebViewManager.openUrl(java.lang.String, boolean, java.lang.String, boolean, boolean, boolean, boolean, java.lang.String):void");
    }

    public void openUrl(String str, String str2, boolean z) {
        openUrl(str, str2, z, false);
    }

    public void openUrl(String str, String str2, boolean z, boolean z2) {
        openUrl(str, z2, str2, z, WebViewCommonUtil.getX5WorkFlag(), true, true, "");
    }

    public void openUrlWithX5(String str, String str2, boolean z, boolean z2) {
        openUrl(str, false, str2, z, z2, true, true, "");
    }

    public void openUrl(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        openUrl(str, z2, str2, z, WebViewCommonUtil.getX5WorkFlag(), z3, z4, "");
    }

    public void openUrlWithX5(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        openUrl(str, false, str2, z, z2, z3, z4, str3);
    }

    public void openUrlWithX5(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3) {
        openUrl(str, z2, str2, z, z3, z4, z5, str3);
    }

    public boolean setCenter(boolean z) {
        IMLogger.d("set center : " + z);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null && z) {
            layoutParams.gravity = 17;
        }
        return z;
    }

    public void setSize(int i, int i2) {
        IMLogger.d("set size : " + i + ", " + i2);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        IMLogger.d("set position : " + i + ", " + i2 + ", " + i3 + ", " + i4);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.mWebViewWidth = i3 / this.mDisplayMetrics.widthPixels;
            this.mWebViewHeight = i4 / this.mDisplayMetrics.heightPixels;
        }
    }

    public void setX(int i) {
        IMLogger.d("set x : " + i);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null) {
            layoutParams.leftMargin = i;
        }
    }

    public void setY(int i) {
        IMLogger.d("set y : " + i);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null) {
            layoutParams.topMargin = i;
        }
    }

    public void setWidth(int i) {
        IMLogger.d("set w : " + i);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null) {
            layoutParams.width = i;
        }
    }

    public void setHeight(int i) {
        IMLogger.d("set h : " + i);
        FrameLayout.LayoutParams layoutParams = mFrameLayoutParams;
        if (layoutParams != null) {
            layoutParams.height = i;
        }
    }

    public void setWebViewActionListener(IMSDKResultListener<IMSDKWebViewActionResult> iMSDKResultListener) {
        mActionListener = iMSDKResultListener;
        IMLogger.d("setWebViewActionListener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWebViewClose() {
        try {
            runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.5
                @Override // java.lang.Runnable
                public void run() {
                    IMSDKWebViewActionResult iMSDKWebViewActionResult = new IMSDKWebViewActionResult(1, 1, "WebView Close Success");
                    iMSDKWebViewActionResult.stateCode = 2;
                    iMSDKWebViewActionResult.retExtraJson = "";
                    if (WebViewManager.mActionListener != null) {
                        WebViewManager.mActionListener.onResult(iMSDKWebViewActionResult);
                    }
                    IMLogger.d("webview close success!");
                }
            });
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWebViewJS(final String str, final int i) {
        try {
            runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                    } catch (Exception e) {
                        IMLogger.d("exception : " + e.toString());
                    }
                    if (new JSONObject(str).has(WebViewManager.MSG_JAVA_CALL_HIDE_TOOL_BAR)) {
                        WebViewManager.this.sendMessageToClient(26, str);
                        return;
                    }
                    IMLogger.d("json has not key:hideToolBar");
                    String str2 = "";
                    switch (i) {
                        case 3:
                            str2 = "js call IMSDK native.";
                            break;
                        case 4:
                            str2 = "return from CallJs";
                            break;
                    }
                    IMSDKWebViewActionResult iMSDKWebViewActionResult = new IMSDKWebViewActionResult(1, 1, str2);
                    iMSDKWebViewActionResult.stateCode = i;
                    String str3 = str;
                    if (str3 == null) {
                        str3 = "";
                    }
                    iMSDKWebViewActionResult.retExtraJson = str3;
                    if (WebViewManager.mActionListener != null) {
                        WebViewManager.mActionListener.onResult(iMSDKWebViewActionResult);
                    }
                }
            });
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
    }

    public void callJs(final String str) {
        IMLogger.d("callJs parasJson : " + str + ", mIsToolbar=" + this.mIsToolbar);
        if (this.mIsToolbar) {
            sendMessageToClient(24, str);
        } else if (this.mWebView == null) {
            IMLogger.d("webView instance is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.7
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder("IMSDKCallJs");
                    sb.append("('");
                    sb.append(str);
                    sb.append("')");
                    if (Build.VERSION.SDK_INT >= 19) {
                        WebViewManager.this.mWebView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.7.1
                            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                WebViewManager.this.notifyWebViewJS(str2, 4);
                            }
                        });
                        return;
                    }
                    WebViewManager.this.mWebView.loadUrl("javascript:" + sb.toString());
                }
            });
        }
    }

    private void startFavActivity(Context context, Intent intent) {
        IMLogger.d("startFavActivity start");
        Activity activity = mCurActivity;
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    @JavascriptInterface
    public void jsCallNative(String str) {
        IMLogger.d("jsCallNative jsParasJson=" + str);
        notifyWebViewJS(str, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MsgHandler extends Handler {
        public MsgHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            IMLogger.d("WebViewManager server receive client messenger : " + message.what);
            switch (message.what) {
                case 21:
                    IMLogger.d("webview is closing : 21");
                    WebViewManager.this.notifyWebViewClose();
                    return;
                case 22:
                case 25:
                    Bundle data = message.getData();
                    String string = data != null ? data.getString(WebViewManager.MSG_JAVA_CALL_KEY_JSON) : "";
                    if (message.what == 22) {
                        WebViewManager.this.notifyWebViewJS(string, 3);
                        return;
                    } else {
                        WebViewManager.this.notifyWebViewJS(string, 4);
                        return;
                    }
                case 23:
                    WebViewManager.this.mClientMessenger = message.replyTo;
                    return;
                case 24:
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageToClient(int i, String str) {
        if (this.mClientMessenger == null) {
            IMLogger.e("mClientMessenger is null!", new Object[0]);
            return;
        }
        Message obtain = Message.obtain((Handler) null, i);
        Bundle bundle = new Bundle();
        if (!T.ckIsEmpty(str)) {
            bundle.putString(MSG_JAVA_CALL_KEY_JSON, str);
        }
        obtain.setData(bundle);
        try {
            this.mClientMessenger.send(obtain);
        } catch (RemoteException e) {
            IMLogger.d(e.getMessage());
        }
    }

    public void setBgColor(final int i) {
        runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewManager.this.mWebView != null) {
                    WebViewManager.this.mWebView.setBackgroundColor(i);
                } else {
                    IMLogger.e("mWebview is null!!!", new Object[0]);
                }
            }
        });
    }

    public void showWebView(final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewManager.this.mWebView == null) {
                    IMLogger.e("mWebview is null!!!", new Object[0]);
                } else if (z) {
                    WebViewManager.this.mWebView.setVisibility(0);
                } else {
                    WebViewManager.this.mWebView.setVisibility(8);
                }
            }
        });
    }
}
