package com.intlgame.view;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.helpshift.util.AttachmentConstants;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import com.intlgame.view.ShareView;
import com.intlgame.webview.WebViewCommonUtil;
import com.intlgame.webview.WebViewIPCActivity;
import com.intlgame.webview.WebViewManager;
import com.intlgame.webview.WebViewProxy;
import com.intlgame.webview.WebViewResID;
import com.intlgame.webview.log.WebViewLog;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class ToolBarWebView implements View.OnClickListener {
    private static final int REQUESTCODE_FILECHOOSER = 1;
    private Activity mActivity;
    private ImageButton mBackBtn;
    private ImageButton mBackUnclickableBtn;
    private FrameLayout mContainer;
    private View mCustomView;
    private ImageButton mForwardBtn;
    private ImageButton mForwardUnclickableBtn;
    private ImageButton mRefreshBtn;
    private ImageButton mReturnAppBtn;
    private String mShareChannels;
    private ShareView mShareView;
    private ImageButton mStopBtn;
    private ToolBarListener mToolBarListener;
    private ToolBarAmin mToolBarView;
    private TextView mWebTitle;
    private WebViewProxy mWebView;
    protected FrameLayout mWebViewFrameLayout;
    private Window mWindow;
    private ValueCallback<Uri> uploadFile;
    private ValueCallback<Uri[]> uploadFileArray;
    private Dialog webViewDialog = null;
    private WebChromeClient mWebChromeClient = new WebChromeClient() { // from class: com.intlgame.view.ToolBarWebView.3
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility = 0;

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            ToolBarWebView.this.mWebTitle.setText(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (ToolBarWebView.this.mToolBarListener != null && ToolBarWebView.this.mToolBarListener.onJsPrompt(str2)) {
                jsPromptResult.confirm();
                return true;
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            String str = "";
            if (webView != null) {
                String url = webView.getUrl();
                if (url == null) {
                    url = "";
                }
                str = url;
            }
            INTLLog.i("progress:" + i + " url:" + str);
            if (ToolBarWebView.this.mToolBarListener != null) {
                ToolBarWebView.this.mToolBarListener.onProgress(i);
            }
            if (i >= 100) {
                ToolBarWebView.this.checkBackForwardBtnState();
                ToolBarWebView.this.refreshUIAfterStop();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            INTLLog.i("onShowFileChooser");
            if (ToolBarWebView.this.uploadFileArray != null) {
                ToolBarWebView.this.uploadFileArray.onReceiveValue(null);
            }
            ToolBarWebView.this.uploadFileArray = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
            try {
                ToolBarWebView.this.mActivity.startActivityForResult(Intent.createChooser(intent, ToolBarWebView.this.mActivity.getResources().getString(WebViewResID.str_upload_file_title)), 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            INTLLog.i("openFileChooser " + str + " " + str2);
            if (ToolBarWebView.this.uploadFile != null) {
                ToolBarWebView.this.uploadFile.onReceiveValue(null);
            }
            ToolBarWebView.this.uploadFile = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
            try {
                ToolBarWebView.this.mActivity.startActivityForResult(Intent.createChooser(intent, ToolBarWebView.this.mActivity.getResources().getString(WebViewResID.str_upload_file_title)), 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            INTLLog.i("onShowCustomView");
            if (ToolBarWebView.this.mCustomView == null) {
                ToolBarWebView.this.mCustomView = view;
                view.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                this.mCustomViewCallback = customViewCallback;
                if (ToolBarWebView.this.mWindow != null) {
                    this.mOriginalSystemUiVisibility = ToolBarWebView.this.mWindow.getDecorView().getSystemUiVisibility();
                    ((ViewGroup) ToolBarWebView.this.mWindow.getDecorView()).addView(ToolBarWebView.this.mCustomView, new ViewGroup.LayoutParams(-1, -1));
                    ToolBarWebView.this.mWindow.getDecorView().setSystemUiVisibility(3846);
                }
                this.mOriginalOrientation = ToolBarWebView.this.mActivity.getResources().getConfiguration().orientation;
                ToolBarWebView.this.mActivity.setRequestedOrientation(6);
                return;
            }
            onHideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            INTLLog.i("onHideCustomView");
            if (ToolBarWebView.this.mWindow != null) {
                ToolBarWebView.this.mWindow.getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
                ((ViewGroup) ToolBarWebView.this.mWindow.getDecorView()).removeView(ToolBarWebView.this.mCustomView);
                ToolBarWebView.this.mCustomView = null;
            }
            ToolBarWebView.this.mActivity.setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }
    };
    private ComponentCallback mComponentCallback = new ComponentCallback();

    /* loaded from: classes2.dex */
    public interface ToolBarListener extends ShareView.ShareListener {
        void onClose();

        boolean onJsPrompt(String str);

        void onProgress(int i);
    }

    public ToolBarWebView(Activity activity, String str, boolean z, boolean z2) {
        this.mShareChannels = "";
        this.mShareChannels = str;
        INTLLog.i("ToolBar WebView start");
        this.mActivity = activity;
        this.mWindow = activity.getWindow();
        WebViewResID.init(this.mActivity);
        if (WebViewResID.layout_webview_activity == 0) {
            INTLLog.e("WebViewResID.layout_webview_activity == 0x00");
            return;
        }
        initView();
        initEvent();
        ToolBarWebViewSetting.initWebViewSetting(this.mWebView);
        this.mWebView.setWebChromeClient(this.mWebChromeClient);
        this.mWebView.setWebViewClient(new WebViewXClient());
        this.mToolBarView.setTitleBarHideable(z);
        this.mToolBarView.setToolBarPortraitHideable(z);
        this.mToolBarView.setToolBarLandscapeHideable(z2);
        this.mActivity.getApplication().registerComponentCallbacks(this.mComponentCallback);
    }

    public void showWithDialog(boolean z, final boolean z2) {
        INTLLog.i("show with dialog：canPressedBack:" + z + " isFullscreen:" + z2);
        if (isShown()) {
            INTLLog.i("already shown");
            return;
        }
        if (this.webViewDialog == null) {
            int i = R.style.Theme.Translucent.NoTitleBar;
            if (z2) {
                i = R.style.Theme.Translucent.NoTitleBar.Fullscreen;
            }
            this.webViewDialog = new Dialog(this.mActivity, i) { // from class: com.intlgame.view.ToolBarWebView.1
                @Override // android.app.Dialog
                public void onBackPressed() {
                    super.onBackPressed();
                    if (ToolBarWebView.this.mCustomView == null || ToolBarWebView.this.mWebChromeClient == null) {
                        return;
                    }
                    ToolBarWebView.this.mWebChromeClient.onHideCustomView();
                }

                @Override // android.app.Dialog, android.view.Window.Callback
                public void onWindowFocusChanged(boolean z3) {
                    super.onWindowFocusChanged(z3);
                    if (z3) {
                        ToolBarWebView.this.setFullscreen(z2);
                    }
                }
            };
            this.webViewDialog.setContentView(this.mContainer);
            this.webViewDialog.setCancelable(z);
            this.webViewDialog.setCanceledOnTouchOutside(false);
            if (this.webViewDialog.getWindow() != null) {
                this.webViewDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                this.webViewDialog.getWindow().setLayout(-1, -1);
            }
            this.mWindow = this.webViewDialog.getWindow();
            setFullscreen(z2);
            this.webViewDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.intlgame.view.ToolBarWebView.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    INTLLog.i("Dialog dismiss");
                    if (ToolBarWebView.this.mToolBarListener != null) {
                        ToolBarWebView.this.mToolBarListener.onClose();
                    }
                }
            });
        }
        if (this.mActivity.isFinishing() || this.webViewDialog.isShowing()) {
            return;
        }
        INTLLog.i("Dialog show");
        this.webViewDialog.show();
    }

    public void showWithActivity(Activity activity) {
        INTLLog.i("show ToolBarWebView with Activity" + activity);
        if (isShown()) {
            INTLLog.i("already shown");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewGroup == null) {
            INTLLog.e("can not find content: android.R.id.content");
        } else if (this.mContainer.getParent() == null) {
            viewGroup.addView(this.mContainer);
        } else {
            INTLLog.e("Tool Bar WebView already has parent!");
        }
    }

    public void setFullscreen(boolean z) {
        INTLLog.i("set fullscreen:" + z);
        if (this.mWindow == null) {
            INTLLog.e("fullscreen failed");
            return;
        }
        if (z) {
            if (WebViewCommonUtil.isSystemFullScreenSupport(this.mActivity)) {
                this.mWindow.addFlags(1024);
            }
        } else if (WebViewCommonUtil.isSystemFullScreenSupport(this.mActivity)) {
            this.mWindow.clearFlags(1024);
        }
    }

    public boolean isShown() {
        return this.mContainer.getParent() != null;
    }

    public void setToolBarListener(ToolBarListener toolBarListener) {
        this.mToolBarListener = toolBarListener;
        this.mShareView.setShareListener(this.mToolBarListener);
    }

    public void setToolBarEnable(boolean z) {
        this.mToolBarView.setToolBarEnable(z);
    }

    public String getUrl() {
        return this.mWebView.getUrl();
    }

    public String getTitle() {
        return this.mWebView.getTitle();
    }

    public void goBack() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            INTLLog.e("There is no back page");
        }
    }

    public void goForward() {
        if (this.mWebView.canGoForward()) {
            this.mWebView.goForward();
        } else {
            INTLLog.e("There is no forward page");
        }
    }

    public void setWebViewBackground(Bitmap bitmap) {
        if (bitmap == null) {
            this.mWebView.setBackgroundColor(this.mActivity.getResources().getColor(R.color.transparent));
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mActivity.getResources(), bitmap);
        bitmapDrawable.setAntiAlias(true);
        this.mWebView.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.mWebView.setBackground(null);
            INTLLog.i("mBitmapDrawable isnot null, set background");
            this.mWebView.setBackground(bitmapDrawable);
        } else {
            this.mWebView.setBackgroundDrawable(null);
            this.mWebView.setBackgroundDrawable(bitmapDrawable);
        }
    }

    public void close() {
        setConfigCallback(null);
        this.mWebView.clearHistory();
        this.mWebView.getSettings().setJavaScriptEnabled(false);
        this.mWebView.stopLoading();
        this.mWebView.destroy();
        if (this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        Dialog dialog = this.webViewDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.webViewDialog = null;
        } else {
            ToolBarListener toolBarListener = this.mToolBarListener;
            if (toolBarListener != null) {
                toolBarListener.onClose();
            }
        }
        this.mActivity.getApplication().unregisterComponentCallbacks(this.mComponentCallback);
    }

    public void onPause() {
        this.mWebView.onPause();
    }

    public void onResume() {
        this.mWebView.onResume();
    }

    public void loadUrl(String str) {
        if (EmptyUtils.isEmpty(str)) {
            INTLLog.e("url should not empty");
            return;
        }
        INTLLog.i("WebView load url:" + str);
        this.mWebView.loadUrl(str);
    }

    private void setConfigCallback(WindowManager windowManager) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                return;
            }
            Field declaredField2 = declaredField.getType().getDeclaredField("mWindowManager");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, windowManager);
        } catch (Exception e) {
            INTLLog.e(e.getMessage());
        }
    }

    private void initEvent() {
        this.mRefreshBtn.setOnClickListener(this);
        this.mStopBtn.setOnClickListener(this);
        this.mBackBtn.setOnClickListener(this);
        this.mForwardBtn.setOnClickListener(this);
        this.mReturnAppBtn.setOnClickListener(this);
        this.mShareView.setShareListener(this.mToolBarListener);
    }

    private void sendMessageToObserver(int i, String str) {
        WebViewLog.getInstance().i("what = " + i + ", parasJsonMsg = " + str);
        Intent intent = new Intent(this.mActivity, (Class<?>) WebViewIPCActivity.class);
        intent.putExtra(WebViewManager.IPC_WEBVIEW_MSG_TYPE, i);
        intent.putExtra(WebViewManager.IPC_WEBVIEW_MSG, str);
        this.mActivity.startActivity(intent);
    }

    private void initView() {
        this.mContainer = new FrameLayout(this.mActivity);
        LayoutInflater.from(this.mActivity).inflate(WebViewResID.layout_webview_activity, (ViewGroup) this.mContainer, true);
        this.mWebViewFrameLayout = (FrameLayout) this.mContainer.findViewById(WebViewResID.webViewFrameLayout);
        try {
            this.mWebView = new WebViewProxy(this.mActivity);
            if (this.mWebViewFrameLayout != null) {
                this.mWebViewFrameLayout.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
                this.mWebView.setBackgroundColor(-1);
            }
            this.mWebTitle = (TextView) this.mContainer.findViewById(WebViewResID.webTitle);
            RelativeLayout relativeLayout = (RelativeLayout) this.mContainer.findViewById(WebViewResID.titleBar);
            LinearLayout linearLayout = (LinearLayout) this.mContainer.findViewById(WebViewResID.toolbar);
            this.mRefreshBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.refresh);
            this.mStopBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.stop);
            this.mBackBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.back);
            this.mBackUnclickableBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.backUnclickable);
            this.mForwardBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.forward);
            this.mForwardUnclickableBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.forwardUnclickable);
            this.mReturnAppBtn = (ImageButton) this.mContainer.findViewById(WebViewResID.return_app);
            this.mToolBarView = new ToolBarAmin(relativeLayout, linearLayout, this.mWebView);
            this.mShareView = new ShareView(this.mActivity, this.mShareChannels);
        } catch (Exception | UnsatisfiedLinkError e) {
            e.printStackTrace();
            String message = e.getMessage();
            WebViewLog.getInstance().e(message);
            sendMessageToObserver(24, message);
            this.mActivity.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebChromeClient webChromeClient;
        int id = view.getId();
        if (id == WebViewResID.back) {
            if (this.mCustomView != null && (webChromeClient = this.mWebChromeClient) != null) {
                webChromeClient.onHideCustomView();
                return;
            } else {
                goBack();
                return;
            }
        }
        if (id == WebViewResID.forward) {
            goForward();
            return;
        }
        if (id == WebViewResID.refresh) {
            this.mWebView.reload();
            return;
        }
        if (id == WebViewResID.stop) {
            this.mWebView.stopLoading();
            return;
        }
        if (id == WebViewResID.return_app) {
            close();
        } else if (id == WebViewResID.more || id == WebViewResID.land_more) {
            this.mShareView.show(this.mContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBackForwardBtnState() {
        if (this.mWebView.canGoForward()) {
            this.mForwardBtn.setVisibility(0);
            this.mForwardUnclickableBtn.setVisibility(8);
        } else {
            this.mForwardBtn.setVisibility(8);
            this.mForwardUnclickableBtn.setVisibility(0);
        }
        if (this.mWebView.canGoBack()) {
            this.mBackBtn.setVisibility(0);
            this.mBackUnclickableBtn.setVisibility(8);
        } else {
            this.mBackBtn.setVisibility(8);
            this.mBackUnclickableBtn.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUIAfterStop() {
        if (this.mStopBtn.getVisibility() != 8) {
            this.mStopBtn.setVisibility(8);
        }
        if (this.mRefreshBtn.getVisibility() != 0) {
            this.mRefreshBtn.setVisibility(0);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        INTLLog.i("WebViewActivity onActivityResult, requestCode = " + i + ", resultCode = " + i2);
        if (i2 == -1) {
            if (i != 1) {
                return;
            }
            if (this.uploadFileArray != null) {
                this.uploadFileArray.onReceiveValue(intent == null ? null : new Uri[]{intent.getData()});
                this.uploadFileArray = null;
                return;
            } else {
                if (this.uploadFile != null) {
                    this.uploadFile.onReceiveValue(intent == null ? null : intent.getData());
                    this.uploadFile = null;
                    return;
                }
                return;
            }
        }
        if (i == 0) {
            ValueCallback<Uri[]> valueCallback = this.uploadFileArray;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                this.uploadFileArray = null;
            }
            ValueCallback<Uri> valueCallback2 = this.uploadFile;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
                this.uploadFile = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    class WebViewXClient extends WebViewClient {
        WebViewXClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            INTLLog.i("loading url:" + str);
            if (!str.contains("://")) {
                INTLLog.e("url format error");
                return false;
            }
            if (str.startsWith("http") || str.startsWith("https") || str.startsWith(TransferTable.COLUMN_FILE) || str.startsWith("ftp")) {
                return false;
            }
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    parseUri.setSelector(null);
                }
                ToolBarWebView.this.mActivity.startActivity(parseUri);
                return true;
            } catch (Exception e) {
                INTLLog.e(e.getMessage());
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            INTLLog.i("onPageFinished");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            INTLLog.i("onPageStarted");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ComponentCallback implements ComponentCallbacks {
        private ComponentCallback() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            INTLLog.i("Toolbar WebView onConfigurationChanged");
            if (ToolBarWebView.this.mToolBarView == null) {
                return;
            }
            if (2 == configuration.orientation) {
                ToolBarWebView.this.mToolBarView.showTitleBar(false);
            } else {
                ToolBarWebView.this.mToolBarView.showTitleBar(true);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            INTLLog.e("onLowMemory");
        }
    }
}
