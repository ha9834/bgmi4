package com.intlgame.webview;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.util.AttachmentConstants;
import com.intlgame.api.compliance.R;
import com.intlgame.tools.FileUtils;
import com.intlgame.webview.ShareAdapter;
import com.intlgame.webview.ShareAnimMenu;
import com.intlgame.webview.log.WebViewLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebViewActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int CREATE_FILE = 10;
    private static String[] PERMISSIONS_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int REQUESTCODE_FILECHOOSER = 1;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private Bitmap bitmapDownloaded;
    private SimpleAdapter mAdapter;
    private Animation mAnimationTitlebarHide;
    private Animation mAnimationTitlebarShow;
    private Animation mAnimationToolbarHide;
    private Animation mAnimationToolbarShow;
    private ImageButton mBackBtn;
    private ImageButton mBackUnclickableBtn;
    private int mBarHeight;
    private ValueAnimator mColorHide;
    private ValueAnimator mColorShow;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private GestureDetector mDetector;
    private Dialog mDownloadDlg;
    private int mFlingLimitX;
    private int mFlingLimitY;
    private ImageButton mForwardBtn;
    private ImageButton mForwardUnclickableBtn;
    private View mLandMoreBtn;
    private ImageButton mMoreBtn;
    private Dialog mMoreDlg;
    private ImageButton mOpenSystenBrowserBtn;
    private int mOriginalOrientation;
    private int mOriginalSystemUiVisibility;
    private String mOriginalUrl;
    private ViewGroup mParentLayout;
    private ImageButton mRefreshBtn;
    private View mReturnAppBtn;
    private String mShareChannel;
    private ImageButton mStopBtn;
    private RelativeLayout mTitleBar;
    private ValueAnimator mTitleBarHide;
    private ValueAnimator mTitleBarShow;
    private String mTitleStr;
    private LinearLayout mToolBar;
    private ValueAnimator mToolBarHide;
    private ValueAnimator mToolBarShow;
    private CustomWebChromeClient mWebChromeClient;
    private TextView mWebTitle;
    protected WebViewProxy mWebView;
    protected FrameLayout mWebViewFrameLayout;
    private int mWebViewOrientation;
    private String toSaveUrlStr;
    private ValueCallback<Uri> uploadFile;
    private ValueCallback<Uri[]> uploadFileArray;
    private boolean mShareEnable = true;
    private String mUserAgent = null;
    private Boolean titlebarHideable = false;
    private Boolean toolbarPortraitHideable = false;
    private Boolean toolbarLandscapeHideable = false;
    private Boolean mIsShow = true;
    private int mOrientation = -1;
    private boolean isFullScreen = false;
    private boolean isBackDisable = false;
    private ShareAnimMenu mShareAnimMenu = null;
    private RecyclerView mShareRecyclerView = null;
    List<ShareAdapter.ItemData> mShareDataList = null;
    private String extraJson = "";
    private String CAPTURE_LOCATION = "webview_capture";
    private String INTLMETHOD = "IntlMethod";
    private String WXGAMELINE_METHOD = "WGGetWXGameLinePicture";
    private FileUtils fileUtils = new FileUtils();
    private String mGameId = "";
    private String mVersionName = "";
    private boolean mEncryptEnable = true;
    private boolean mIsWebViewInstanced = true;
    private String guestId = "";

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebViewLog.getInstance().bindService(getApplication());
        if (Build.VERSION.SDK_INT >= 28 && Application.getProcessName().contains("intl_inner_webview")) {
            try {
                WebView.setDataDirectorySuffix("intl_inner_webview");
            } catch (Exception e) {
                WebViewLog.getInstance().i(e.getMessage());
            }
        }
        WebViewLog.getInstance().i("BEGIN");
        getWindow().setFormat(-3);
        requestWindowFeature(1);
        WebViewResID.init(this);
        if (WebViewResID.layout_webview_activity == 0) {
            WebViewLog.getInstance().e("WebViewResID.layout_webview_activity == 0x00");
            finish();
            return;
        }
        if (2 == getResources().getConfiguration().orientation) {
            this.mWebViewOrientation = 2;
            getWindow().setFlags(1024, 1024);
        } else {
            this.mWebViewOrientation = 1;
        }
        this.mDetector = new GestureDetector(this, new WebViewGestureListener());
        handleIntent(getIntent());
        setContentView(WebViewResID.layout_webview_activity);
        if (WebViewCommonUtil.isSystemFullScreenSupport(this)) {
            getWindow().addFlags(1024);
        }
        this.mWebViewFrameLayout = (FrameLayout) findViewById(WebViewResID.webViewFrameLayout);
        try {
            this.mWebView = new WebViewProxy(this);
            if (this.mWebView == null) {
                WebViewLog.getInstance().e("Fail to instance webview");
                finish();
                return;
            }
            this.mWebViewFrameLayout.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
            this.mWebView.setBackgroundColor(-1);
            this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.intlgame.webview.WebViewActivity.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    WebViewActivity.this.mDetector.onTouchEvent(motionEvent);
                    return false;
                }
            });
            this.mWebView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.intlgame.webview.WebViewActivity.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    WebView.HitTestResult hitTestResult = WebViewActivity.this.mWebView.getHitTestResult();
                    if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
                        return false;
                    }
                    String extra = hitTestResult.getExtra();
                    if (!TextUtils.isEmpty(extra)) {
                        WebViewLog.getInstance().i("Get image url:" + extra);
                        WebViewActivity.this.savePhotoFromUrl(extra);
                        return true;
                    }
                    WebViewLog.getInstance().e("Image url is null");
                    return true;
                }
            });
            initWebView();
            loadUrl();
            initLayout();
            checkToolbarStatus();
            checkBackForwardBtnState();
            initAnimation();
            setFullScreen(this.isFullScreen);
            HandlerThread handlerThread = new HandlerThread("handler-thread-activity");
            handlerThread.start();
            JsProcessor.getInstance().init(new MsgHandler(handlerThread.getLooper()));
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mIsWebViewInstanced = false;
            String message = e2.getMessage();
            WebViewLog.getInstance().e(message);
            sendMessageToObserver(24, message);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WebViewLog.getInstance().i("onNewIntent invoked");
        if (intent == null || this.mWebView == null) {
            return;
        }
        handleIntent(intent);
        loadUrl();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0109 A[Catch: IOException -> 0x0105, TRY_LEAVE, TryCatch #2 {IOException -> 0x0105, blocks: (B:64:0x00fe, B:57:0x0109), top: B:63:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intlgame.webview.WebViewActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (2 == configuration.orientation) {
            this.mWebViewOrientation = 2;
        } else {
            this.mWebViewOrientation = 1;
        }
        setFullScreen(this.isFullScreen);
        checkToolbarStatus();
        initShareLayoutData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == WebViewResID.back) {
            if (this.mCustomView != null) {
                CustomWebChromeClient customWebChromeClient = this.mWebChromeClient;
                if (customWebChromeClient != null) {
                    customWebChromeClient.onHideCustomView();
                    return;
                }
                return;
            }
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return;
            }
            return;
        }
        if (id == WebViewResID.forward) {
            if (this.mWebView.canGoForward()) {
                this.mWebView.goForward();
                return;
            }
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
            finish();
            return;
        }
        if (id == WebViewResID.more || id == WebViewResID.land_more) {
            initShareLayoutData();
            ShareAnimMenu shareAnimMenu = this.mShareAnimMenu;
            if (shareAnimMenu != null) {
                shareAnimMenu.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebViewLog.getInstance().i("END");
        if (this.mIsWebViewInstanced) {
            sendMessageToObserver(21, "");
        }
        WebViewProxy webViewProxy = this.mWebView;
        if (webViewProxy != null) {
            webViewProxy.removeAllViews();
            ViewGroup viewGroup = this.mParentLayout;
            if (viewGroup != null) {
                viewGroup.removeView(this.mWebView);
            }
            this.mWebView.destroy();
        }
        Dialog dialog = this.mMoreDlg;
        if (dialog != null && dialog.isShowing()) {
            this.mMoreDlg.dismiss();
            this.mMoreDlg = null;
        }
        Dialog dialog2 = this.mDownloadDlg;
        if (dialog2 != null && dialog2.isShowing()) {
            this.mDownloadDlg.dismiss();
            this.mDownloadDlg = null;
        }
        WebViewLog.getInstance().unbindService(getApplication());
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        WebViewProxy webViewProxy = this.mWebView;
        if (webViewProxy != null) {
            webViewProxy.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        WebViewProxy webViewProxy = this.mWebView;
        if (webViewProxy != null) {
            webViewProxy.onResume();
        }
    }

    private void handleIntent(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra(WebViewManager.EXTRA_GAME_ID)) {
                this.mGameId = intent.getStringExtra(WebViewManager.EXTRA_GAME_ID);
            }
            if (intent.hasExtra(WebViewManager.EXTRA_VERSION_NAME)) {
                this.mVersionName = intent.getStringExtra(WebViewManager.EXTRA_VERSION_NAME);
            }
            if (intent.hasExtra(WebViewManager.EXTRA_ENCRYPT_ENABLE)) {
                this.mEncryptEnable = intent.getIntExtra(WebViewManager.EXTRA_ENCRYPT_ENABLE, 1) == 1;
            }
            if (intent.hasExtra("webview_url") && intent.hasExtra(WebViewManager.EXTRA_KEY_WEBVIEW_CONFIG)) {
                this.mOriginalUrl = intent.getStringExtra("webview_url");
                String stringExtra = intent.getStringExtra(WebViewManager.EXTRA_KEY_WEBVIEW_CONFIG);
                WebViewLog.getInstance().i("webview config = " + stringExtra);
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    this.mShareChannel = jSONObject.getString(WebViewManager.CONFIG_KEY_SHARE_CHANNEL);
                    if ("NONE".equals(this.mShareChannel)) {
                        this.mShareEnable = false;
                    }
                    jSONObject.getBoolean(WebViewManager.CONFIG_KEY_X5_CLOSE);
                    jSONObject.getBoolean(WebViewManager.CONFIG_KEY_X5_UPLOAD);
                    this.toolbarPortraitHideable = Boolean.valueOf(jSONObject.getBoolean(WebViewManager.CONFIG_KEY_PORTRAIT_HIDEBAR_ENABLE));
                    this.titlebarHideable = this.toolbarPortraitHideable;
                    this.toolbarLandscapeHideable = Boolean.valueOf(jSONObject.getBoolean(WebViewManager.CONFIG_KEY_LANDSCAPE_HIDEBAR_ENABLE));
                    this.isFullScreen = jSONObject.getBoolean(WebViewManager.CONFIG_KEY_FULLSCREEN_ENABLE);
                    this.isBackDisable = jSONObject.getBoolean(WebViewManager.CONFIG_KEY_BACK_DISABLE);
                } catch (Exception e) {
                    WebViewLog.getInstance().e(e.getMessage());
                }
                this.mOrientation = intent.getIntExtra(WebViewManager.EXTRA_KEY_SCREEN, 1);
                switch (this.mOrientation) {
                    case 1:
                        setRequestedOrientation(4);
                        break;
                    case 2:
                        setRequestedOrientation(7);
                        break;
                    case 3:
                        setRequestedOrientation(6);
                        break;
                    default:
                        WebViewLog.getInstance().i("mOrientation is " + this.mOrientation + ", type error");
                        break;
                }
            } else if (intent.hasExtra(WebViewManager.EXTRA_KEY_CALLJS_CONFIG)) {
                callJs(intent.getStringExtra(WebViewManager.EXTRA_KEY_CALLJS_CONFIG));
            }
            if (intent.hasExtra(WebViewManager.EXTRA_KEY_EXTRA_JSON)) {
                this.extraJson = intent.getStringExtra(WebViewManager.EXTRA_KEY_EXTRA_JSON);
            }
            if (intent.hasExtra(WebViewManager.EXTRA_GUEST_ID)) {
                this.guestId = intent.getStringExtra(WebViewManager.EXTRA_GUEST_ID);
                return;
            }
            return;
        }
        WebViewLog.getInstance().e("Start WebViewActivity error, without intent data");
        finish();
    }

    private void initWebView() {
        this.mWebChromeClient = new CustomWebChromeClient();
        this.mWebView.setWebChromeClient(this.mWebChromeClient);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.intlgame.webview.WebViewActivity.3
            @Override // android.webkit.WebViewClient
            @SuppressLint({"NewApi"})
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WebViewLog.getInstance().i("loading url:" + str);
                return WebViewCommonUtil.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                WebViewActivity.this.checkBackForwardBtnState();
                WebViewActivity.this.refreshUIAfterStop();
                WebViewActivity.this.mWebTitle.setText(WebViewActivity.this.mWebView.getTitle());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                WebViewActivity.this.refreshUIAfterStartLoading();
                WebViewActivity.this.mWebTitle.setText(WebViewActivity.this.mWebView.getTitle());
            }
        });
        this.mWebView.setDownloadListener(new DownloadListener() { // from class: com.intlgame.webview.WebViewActivity.4
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    WebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        if (Build.VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setAppCachePath(getDir("appcache", 0).getPath());
        settings.setDatabasePath(getDir("databases", 0).getPath());
        settings.setGeolocationDatabasePath(getDir("geolocation", 0).getPath());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (this.mUserAgent == null) {
            this.mUserAgent = " INTLBrowser/" + this.mVersionName + " (Android; " + this.mGameId + ")";
        }
        settings.setUserAgentString(settings.getUserAgentString() + this.mUserAgent);
        WebViewLog.getInstance().i("useragent : " + this.mWebView.getSettings().getUserAgentString());
        settings.setTextZoom(100);
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().sync();
    }

    private void loadUrl() {
        if (TextUtils.isEmpty(this.mOriginalUrl)) {
            WebViewLog.getInstance().i("mOriginalUrl is empty!");
        } else {
            this.mWebView.loadUrl(this.mOriginalUrl);
        }
    }

    private void initLayout() {
        this.mParentLayout = (ViewGroup) findViewById(WebViewResID.playout);
        this.mWebTitle = (TextView) findViewById(WebViewResID.webTitle);
        this.mTitleBar = (RelativeLayout) findViewById(WebViewResID.titleBar);
        this.mToolBar = (LinearLayout) findViewById(WebViewResID.toolbar);
        this.mRefreshBtn = (ImageButton) findViewById(WebViewResID.refresh);
        this.mRefreshBtn.setOnClickListener(this);
        this.mStopBtn = (ImageButton) findViewById(WebViewResID.stop);
        this.mStopBtn.setOnClickListener(this);
        this.mBackBtn = (ImageButton) findViewById(WebViewResID.back);
        this.mBackBtn.setOnClickListener(this);
        this.mBackUnclickableBtn = (ImageButton) findViewById(WebViewResID.backUnclickable);
        this.mForwardBtn = (ImageButton) findViewById(WebViewResID.forward);
        this.mForwardBtn.setOnClickListener(this);
        this.mForwardUnclickableBtn = (ImageButton) findViewById(WebViewResID.forwardUnclickable);
        this.mLandMoreBtn = findViewById(WebViewResID.land_more);
        this.mLandMoreBtn.setOnClickListener(this);
        ((View) this.mLandMoreBtn.getParent()).setVisibility(8);
        this.mReturnAppBtn = findViewById(WebViewResID.return_app);
        this.mReturnAppBtn.setOnClickListener(this);
        this.mMoreBtn = (ImageButton) findViewById(WebViewResID.more);
        this.mMoreBtn.setOnClickListener(this);
        this.mMoreBtn.setVisibility(8);
        this.mShareAnimMenu = new ShareAnimMenu(this, R.layout.intl_webview_share_dlg);
        Button button = (Button) this.mShareAnimMenu.findViewById(R.id.share_cancel);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.intlgame.webview.WebViewActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WebViewActivity.this.mShareAnimMenu.dismiss(null);
                }
            });
        }
        this.mShareRecyclerView = (RecyclerView) this.mShareAnimMenu.findViewById(R.id.share_recyclerView);
    }

    public void setFullScreen(boolean z) {
        if (z) {
            this.mTitleBar.setVisibility(8);
            this.mToolBar.setVisibility(8);
        } else {
            this.mTitleBar.setVisibility(0);
            this.mToolBar.setVisibility(0);
            checkToolbarStatus();
        }
        this.isFullScreen = z;
    }

    private void checkToolbarStatus() {
        if (2 == this.mWebViewOrientation) {
            this.mTitleBar.setVisibility(8);
            ((View) this.mLandMoreBtn.getParent()).setVisibility(this.mShareEnable ? 0 : 8);
        } else {
            if (!this.isFullScreen) {
                this.mTitleBar.setVisibility(0);
            }
            ((View) this.mLandMoreBtn.getParent()).setVisibility(8);
            this.mMoreBtn.setVisibility(this.mShareEnable ? 0 : 8);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTitleBar.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.mTitleBar.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mToolBar.getLayoutParams();
        marginLayoutParams2.bottomMargin = 0;
        this.mToolBar.setLayoutParams(marginLayoutParams2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUIAfterStartLoading() {
        if (this.mStopBtn.getVisibility() != 0) {
            this.mStopBtn.setVisibility(0);
        }
        if (this.mRefreshBtn.getVisibility() != 8) {
            this.mRefreshBtn.setVisibility(8);
        }
    }

    private void initAnimation() {
        this.mFlingLimitX = getResources().getDimensionPixelSize(WebViewResID.dimen_fling_limit_x);
        this.mFlingLimitY = getResources().getDimensionPixelSize(WebViewResID.dimen_fling_limit_y);
        if (Build.VERSION.SDK_INT < 11) {
            this.mAnimationToolbarHide = AnimationUtils.loadAnimation(this, WebViewResID.anim_toolbar_hide);
            this.mAnimationToolbarHide.setAnimationListener(new WebViewAnimListener(2));
            this.mAnimationToolbarShow = AnimationUtils.loadAnimation(this, WebViewResID.anim_toolbar_show);
            this.mAnimationToolbarShow.setAnimationListener(new WebViewAnimListener(1));
            this.mAnimationTitlebarHide = AnimationUtils.loadAnimation(this, WebViewResID.anim_titlebar_hide);
            this.mAnimationTitlebarShow = AnimationUtils.loadAnimation(this, WebViewResID.anim_titlebar_show);
            return;
        }
        this.mBarHeight = getResources().getDimensionPixelSize(WebViewResID.dimen_titlebar_height);
        this.mTitleBarHide = ValueAnimator.ofInt(0, -this.mBarHeight);
        this.mTitleBarHide.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.webview.WebViewActivity.6
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) WebViewActivity.this.mTitleBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                WebViewActivity.this.mTitleBar.setLayoutParams(this.lp);
            }
        });
        this.mTitleBarHide.setInterpolator(new AccelerateInterpolator());
        long j = 120;
        this.mTitleBarHide.setDuration(j);
        this.mTitleBarShow = ValueAnimator.ofInt(-this.mBarHeight, 0);
        this.mTitleBarShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.webview.WebViewActivity.7
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) WebViewActivity.this.mTitleBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                WebViewActivity.this.mTitleBar.setLayoutParams(this.lp);
            }
        });
        this.mTitleBarShow.setInterpolator(new DecelerateInterpolator());
        this.mTitleBarShow.setDuration(j);
        this.mToolBarHide = ValueAnimator.ofInt(0, -this.mBarHeight);
        this.mToolBarHide.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.webview.WebViewActivity.8
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) WebViewActivity.this.mToolBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                WebViewActivity.this.mToolBar.setLayoutParams(this.lp);
            }
        });
        this.mToolBarHide.setInterpolator(new AccelerateInterpolator());
        this.mToolBarHide.setDuration(j);
        this.mToolBarShow = ValueAnimator.ofInt(-this.mBarHeight, 0);
        this.mToolBarShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.webview.WebViewActivity.9
            ViewGroup.MarginLayoutParams lp;

            {
                this.lp = (ViewGroup.MarginLayoutParams) WebViewActivity.this.mToolBar.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lp.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                WebViewActivity.this.mToolBar.setLayoutParams(this.lp);
            }
        });
        this.mToolBarShow.setInterpolator(new DecelerateInterpolator());
        this.mToolBarShow.setDuration(j);
        int color = getResources().getColor(WebViewResID.color_toolbar_visible);
        int color2 = getResources().getColor(WebViewResID.color_toolbar_invisible);
        this.mColorHide = ValueAnimator.ofObject(new ColorEvaluator(), Integer.valueOf(color), Integer.valueOf(color2));
        this.mColorHide.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.webview.WebViewActivity.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WebViewActivity.this.mToolBar.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mColorHide.setDuration(j);
        this.mColorShow = ValueAnimator.ofObject(new ColorEvaluator(), Integer.valueOf(color2), Integer.valueOf(color));
        this.mColorShow.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.intlgame.webview.WebViewActivity.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WebViewActivity.this.mToolBar.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mColorShow.setDuration(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationDuration(int i) {
        long j = i;
        this.mTitleBarHide.setDuration(j);
        this.mTitleBarShow.setDuration(j);
        this.mToolBarHide.setDuration(j);
        this.mToolBarShow.setDuration(j);
        this.mColorHide.setDuration(j);
        this.mColorShow.setDuration(j);
    }

    /* loaded from: classes2.dex */
    class WebViewGestureListener extends GestureDetector.SimpleOnGestureListener {
        WebViewGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int contentHeight = (int) (WebViewActivity.this.mWebView.getContentHeight() * WebViewActivity.this.mWebView.getScale());
            if (WebViewActivity.this.mIsShow.booleanValue() && contentHeight < WebViewActivity.this.mWebView.getHeight() + 60) {
                WebViewLog.getInstance().i("contentHeight : " + contentHeight + "WebViewHeight" + (WebViewActivity.this.mWebView.getHeight() + 60));
                return false;
            }
            if (motionEvent.getX() - motionEvent2.getX() > WebViewActivity.this.mFlingLimitX || motionEvent2.getX() - motionEvent.getX() > WebViewActivity.this.mFlingLimitX) {
                return false;
            }
            if (motionEvent.getY() - motionEvent2.getY() > WebViewActivity.this.mFlingLimitY) {
                if (!WebViewActivity.this.mIsShow.booleanValue()) {
                    return false;
                }
                WebViewActivity.this.mIsShow = false;
                try {
                    if (Build.VERSION.SDK_INT >= 11) {
                        WebViewActivity.this.setAnimationDuration((int) (((WebViewActivity.this.mBarHeight * 1000) * 5) / (-f2)));
                        if (WebViewActivity.this.titlebarHideable.booleanValue()) {
                            WebViewActivity.this.mTitleBarHide.start();
                        }
                        if (2 == WebViewActivity.this.mWebViewOrientation) {
                            if (WebViewActivity.this.toolbarLandscapeHideable.booleanValue()) {
                                WebViewActivity.this.mToolBarHide.start();
                                WebViewActivity.this.mColorHide.start();
                            }
                        } else if (WebViewActivity.this.toolbarPortraitHideable.booleanValue()) {
                            WebViewActivity.this.mToolBarHide.start();
                            WebViewActivity.this.mColorHide.start();
                        }
                    } else {
                        if (WebViewActivity.this.titlebarHideable.booleanValue()) {
                            WebViewActivity.this.mTitleBar.startAnimation(WebViewActivity.this.mAnimationTitlebarHide);
                        }
                        if (2 == WebViewActivity.this.mWebViewOrientation) {
                            if (WebViewActivity.this.toolbarLandscapeHideable.booleanValue()) {
                                WebViewActivity.this.mToolBar.startAnimation(WebViewActivity.this.mAnimationToolbarHide);
                            }
                        } else if (WebViewActivity.this.toolbarPortraitHideable.booleanValue()) {
                            WebViewActivity.this.mToolBar.startAnimation(WebViewActivity.this.mAnimationToolbarHide);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (motionEvent2.getY() - motionEvent.getY() <= WebViewActivity.this.mFlingLimitY || WebViewActivity.this.mIsShow.booleanValue()) {
                return false;
            }
            WebViewActivity.this.mIsShow = true;
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    WebViewActivity.this.setAnimationDuration((int) (((WebViewActivity.this.mBarHeight * 1000) * 5) / f2));
                    if (WebViewActivity.this.titlebarHideable.booleanValue()) {
                        WebViewActivity.this.mTitleBarShow.start();
                    }
                    if (2 == WebViewActivity.this.mWebViewOrientation) {
                        if (WebViewActivity.this.toolbarLandscapeHideable.booleanValue()) {
                            WebViewActivity.this.mToolBarShow.start();
                            WebViewActivity.this.mColorShow.start();
                        }
                    } else if (WebViewActivity.this.toolbarPortraitHideable.booleanValue()) {
                        WebViewActivity.this.mToolBarShow.start();
                        WebViewActivity.this.mColorShow.start();
                    }
                } else {
                    if (WebViewActivity.this.titlebarHideable.booleanValue()) {
                        WebViewActivity.this.mTitleBar.startAnimation(WebViewActivity.this.mAnimationTitlebarShow);
                    }
                    if (2 == WebViewActivity.this.mWebViewOrientation) {
                        if (WebViewActivity.this.toolbarLandscapeHideable.booleanValue()) {
                            WebViewActivity.this.mToolBar.startAnimation(WebViewActivity.this.mAnimationToolbarShow);
                        }
                    } else if (WebViewActivity.this.toolbarPortraitHideable.booleanValue()) {
                        WebViewActivity.this.mToolBar.startAnimation(WebViewActivity.this.mAnimationToolbarShow);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class WebViewAnimListener implements Animation.AnimationListener {
        private static final int STATE_HIDE = 2;
        private static final int STATE_SHOW = 1;
        private int state;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        WebViewAnimListener(int i) {
            this.state = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.state == 2) {
                WebViewActivity.this.mToolBar.setVisibility(8);
                if (2 != WebViewActivity.this.mWebViewOrientation) {
                    WebViewActivity.this.mTitleBar.setVisibility(8);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.state == 1) {
                if (WebViewActivity.this.mToolBar.getVisibility() == 8) {
                    WebViewActivity.this.mToolBar.setVisibility(0);
                }
                if (2 == WebViewActivity.this.mWebViewOrientation || WebViewActivity.this.mTitleBar.getVisibility() != 8) {
                    return;
                }
                WebViewActivity.this.mTitleBar.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ColorEvaluator implements TypeEvaluator<Integer> {
        private int getCurrentColor(int i, int i2, float f) {
            return i < i2 ? (int) (i + (f * (i2 - i))) : (int) (i - (f * (i - i2)));
        }

        ColorEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        public Integer evaluate(float f, Integer num, Integer num2) {
            int intValue = (num.intValue() & com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR) >>> 24;
            int intValue2 = (num.intValue() & 16711680) >> 16;
            int intValue3 = (num.intValue() & 65280) >> 8;
            int intValue4 = num.intValue() & 255;
            int intValue5 = ((-16777216) & num2.intValue()) >>> 24;
            int intValue6 = (16711680 & num2.intValue()) >> 16;
            int intValue7 = (65280 & num2.intValue()) >> 8;
            int intValue8 = num2.intValue() & 255;
            int currentColor = getCurrentColor(intValue, intValue5, f);
            int currentColor2 = getCurrentColor(intValue2, intValue6, f);
            int currentColor3 = getCurrentColor(intValue3, intValue7, f);
            return Integer.valueOf((currentColor << 24) + (currentColor2 << 16) + (currentColor3 << 8) + getCurrentColor(intValue4, intValue8, f));
        }
    }

    private void initShareLayoutData() {
        if (this.mShareRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.b(0);
            this.mShareRecyclerView.setLayoutManager(linearLayoutManager);
            this.mShareDataList = ShareManager.getShareListData(this, this.mShareChannel);
            ShareAdapter shareAdapter = new ShareAdapter(this);
            shareAdapter.setShareData(this.mShareDataList);
            shareAdapter.setOnItemClickListener(new ShareAdapter.OnItemClickListener() { // from class: com.intlgame.webview.WebViewActivity.12
                @Override // com.intlgame.webview.ShareAdapter.OnItemClickListener
                public void onItemClick(View view, final int i) {
                    if (WebViewActivity.this.mShareAnimMenu != null) {
                        WebViewActivity.this.mShareAnimMenu.dismiss(new ShareAnimMenu.IDismissListener() { // from class: com.intlgame.webview.WebViewActivity.12.1
                            @Override // com.intlgame.webview.ShareAnimMenu.IDismissListener
                            public void onDismiss() {
                                WebViewActivity.this.handleShareEvent(i);
                            }
                        });
                    }
                }
            });
            this.mShareRecyclerView.setAdapter(shareAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShareEvent(int i) {
        List<ShareAdapter.ItemData> list = this.mShareDataList;
        if (list == null || list.size() == 0) {
            WebViewLog.getInstance().e("handleShareEvent mShareDataList null/size = 0!");
        }
    }

    private String getCurrentUrl() {
        String url = this.mWebView.getUrl();
        if (url != null && this.mOriginalUrl != null) {
            if (url.replace("/", "").toLowerCase().equals(this.mOriginalUrl.replace("/", "").toLowerCase())) {
                WebViewLog.getInstance().i("getCurrentUrl state:true");
                return url;
            }
        } else {
            WebViewLog.getInstance().e("getCurrentUrl = null");
        }
        return url;
    }

    public void callJs(final String str) {
        WebViewLog.getInstance().i("callJs parasJson : " + str);
        if (this.mWebView == null) {
            WebViewLog.getInstance().i("webView instance is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.intlgame.webview.WebViewActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder("INTLJSHandler");
                    sb.append("('");
                    sb.append(str);
                    sb.append("')");
                    if (Build.VERSION.SDK_INT >= 19) {
                        WebViewActivity.this.mWebView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.intlgame.webview.WebViewActivity.13.1
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                WebViewLog.getInstance().i("onReceiveValue = " + str2);
                            }
                        });
                        return;
                    }
                    WebViewActivity.this.mWebView.loadUrl("javascript:" + sb.toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageToObserver(int i, String str) {
        sendMessageToObserver(i, str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageToObserver(int i, String str, String str2) {
        WebViewLog.getInstance().i("what = " + i + ", parasJsonMsg = " + str);
        Intent intent = new Intent(this, (Class<?>) WebViewIPCActivity.class);
        intent.putExtra(WebViewManager.IPC_WEBVIEW_MSG_TYPE, i);
        intent.putExtra(WebViewManager.IPC_WEBVIEW_MSG, str);
        intent.putExtra(WebViewManager.EXTRA_KEY_EXTRA_JSON, this.extraJson);
        intent.putExtra("jsUrl", str2);
        startActivity(intent);
    }

    /* loaded from: classes2.dex */
    class MsgHandler extends Handler {
        public MsgHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x012b  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r7) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.intlgame.webview.WebViewActivity.MsgHandler.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class CustomWebChromeClient extends WebChromeClient {
        CustomWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebViewActivity.this.mTitleStr = str;
            WebViewActivity.this.mWebTitle.setText(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                WebViewActivity.this.checkBackForwardBtnState();
                WebViewActivity.this.refreshUIAfterStop();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (JsProcessor.getInstance().canResolved(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (!jSONObject.has(WebViewActivity.this.INTLMETHOD) || !jSONObject.getString(WebViewActivity.this.INTLMETHOD).equalsIgnoreCase(WebViewActivity.this.WXGAMELINE_METHOD)) {
                        JsProcessor.getInstance().parseMessage(str2, str);
                    }
                    if ("".isEmpty()) {
                        jsPromptResult.confirm();
                        return true;
                    }
                    jsPromptResult.confirm("");
                    return true;
                } catch (Exception e) {
                    WebViewLog.getInstance().e("parse jsonMessage error : " + e.getMessage());
                    return true;
                }
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebViewLog.getInstance().i("onShowFileChooser");
            if (WebViewActivity.this.uploadFileArray != null) {
                WebViewActivity.this.uploadFileArray.onReceiveValue(null);
            }
            WebViewActivity.this.uploadFileArray = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
            try {
                WebViewActivity.this.startActivityForResult(Intent.createChooser(intent, WebViewActivity.this.getResources().getString(WebViewResID.str_upload_file_title)), 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            WebViewLog.getInstance().i("openFileChooser " + str + " " + str2);
            if (WebViewActivity.this.uploadFile != null) {
                WebViewActivity.this.uploadFile.onReceiveValue(null);
            }
            WebViewActivity.this.uploadFile = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
            try {
                WebViewActivity.this.startActivityForResult(Intent.createChooser(intent, WebViewActivity.this.getResources().getString(WebViewResID.str_upload_file_title)), 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            WebViewLog.getInstance().i("onShowCustomView");
            if (WebViewActivity.this.mCustomView == null) {
                WebViewActivity.this.mCustomView = view;
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.mOriginalSystemUiVisibility = webViewActivity.getWindow().getDecorView().getSystemUiVisibility();
                WebViewActivity webViewActivity2 = WebViewActivity.this;
                webViewActivity2.mOriginalOrientation = webViewActivity2.getRequestedOrientation();
                view.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                WebViewActivity.this.mCustomViewCallback = customViewCallback;
                ((ViewGroup) WebViewActivity.this.getWindow().getDecorView()).addView(WebViewActivity.this.mCustomView, new ViewGroup.LayoutParams(-1, -1));
                WebViewActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
                WebViewActivity.this.setRequestedOrientation(6);
                return;
            }
            onHideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            WebViewLog.getInstance().i("onHideCustomView");
            ((ViewGroup) WebViewActivity.this.getWindow().getDecorView()).removeView(WebViewActivity.this.mCustomView);
            WebViewActivity.this.mCustomView = null;
            WebViewActivity.this.getWindow().getDecorView().setSystemUiVisibility(WebViewActivity.this.mOriginalSystemUiVisibility);
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.setRequestedOrientation(webViewActivity.mOriginalOrientation);
            WebViewActivity.this.mCustomViewCallback.onCustomViewHidden();
            WebViewActivity.this.mCustomViewCallback = null;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.isBackDisable) {
            WebViewLog.getInstance().i("onBackPressed disable");
        } else if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePhotoFromUrl(String str) {
        WebViewLog.getInstance().i("Save photo from urlStr:" + str);
        this.toSaveUrlStr = str;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getString(R.string.intl_webview_save_photo);
        String string2 = getString(R.string.intl_webview_sure);
        String string3 = getString(R.string.intl_webview_cancel);
        builder.setMessage(string);
        builder.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.intlgame.webview.WebViewActivity.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                WebViewLog.getInstance().i("Positive button clicked, start to save photo");
                new Thread(new Runnable() { // from class: com.intlgame.webview.WebViewActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebViewActivity.this.verifyStoragePermissions(WebViewActivity.this);
                    }
                }).start();
            }
        });
        builder.setNegativeButton(string3, new DialogInterface.OnClickListener() { // from class: com.intlgame.webview.WebViewActivity.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                WebViewLog.getInstance().i("Negative button clicked, cancel save");
            }
        });
        builder.create().show();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[Catch: IOException -> 0x009d, TRY_LEAVE, TryCatch #8 {IOException -> 0x009d, blocks: (B:47:0x0099, B:40:0x00a1), top: B:46:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap downloadPhotoFromUrl(java.lang.String r8) {
        /*
            r7 = this;
            com.intlgame.webview.log.WebViewLog r0 = com.intlgame.webview.log.WebViewLog.getInstance()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Download photo from url:"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.i(r1)
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r2 = r1
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            int r2 = r2.getContentLength()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r1.connect()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5d
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5d
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            com.intlgame.webview.log.WebViewLog r2 = com.intlgame.webview.log.WebViewLog.getInstance()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r4 = "Download photo success"
            r2.i(r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L48
            goto L4a
        L48:
            r8 = move-exception
            goto L4e
        L4a:
            r3.close()     // Catch: java.io.IOException -> L48
            goto L95
        L4e:
            r8.printStackTrace()
            goto L95
        L52:
            r8 = move-exception
            goto L5b
        L54:
            r2 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L68
        L59:
            r8 = move-exception
            r3 = r0
        L5b:
            r0 = r1
            goto L97
        L5d:
            r2 = move-exception
            r3 = r0
            r0 = r1
            r1 = r3
            goto L68
        L62:
            r8 = move-exception
            r3 = r0
            goto L97
        L65:
            r2 = move-exception
            r1 = r0
            r3 = r1
        L68:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L96
            com.intlgame.webview.log.WebViewLog r2 = com.intlgame.webview.log.WebViewLog.getInstance()     // Catch: java.lang.Throwable -> L96
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r4.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r5 = "Download photo failed! url:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L96
            r4.append(r8)     // Catch: java.lang.Throwable -> L96
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L96
            r2.e(r8)     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L8b
            r0.close()     // Catch: java.io.IOException -> L89
            goto L8b
        L89:
            r8 = move-exception
            goto L91
        L8b:
            if (r3 == 0) goto L94
            r3.close()     // Catch: java.io.IOException -> L89
            goto L94
        L91:
            r8.printStackTrace()
        L94:
            r0 = r1
        L95:
            return r0
        L96:
            r8 = move-exception
        L97:
            if (r0 == 0) goto L9f
            r0.close()     // Catch: java.io.IOException -> L9d
            goto L9f
        L9d:
            r0 = move-exception
            goto La5
        L9f:
            if (r3 == 0) goto La8
            r3.close()     // Catch: java.io.IOException -> L9d
            goto La8
        La5:
            r0.printStackTrace()
        La8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intlgame.webview.WebViewActivity.downloadPhotoFromUrl(java.lang.String):android.graphics.Bitmap");
    }

    public void verifyStoragePermissions(Activity activity) {
        try {
            if (a.b(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                a.a(activity, PERMISSIONS_STORAGE, 1);
            } else {
                saveToAlbum();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr[0] == 0) {
                new Thread(new Runnable() { // from class: com.intlgame.webview.WebViewActivity.16
                    @Override // java.lang.Runnable
                    public void run() {
                        WebViewActivity.this.saveToAlbum();
                    }
                }).start();
            } else {
                Toast.makeText(this, "need external storage permission", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ff -> B:29:0x012f). Please report as a decompilation issue!!! */
    public void saveToAlbum() {
        FileOutputStream fileOutputStream;
        this.bitmapDownloaded = downloadPhotoFromUrl(this.toSaveUrlStr);
        if (this.bitmapDownloaded != null) {
            String str = this.toSaveUrlStr.split("/")[r0.length - 1];
            if (!str.endsWith(".jpg") && !str.endsWith(".jpeg") && !str.endsWith(".png")) {
                str = str + ".jpeg";
            }
            WebViewLog.getInstance().i("Save photo:" + str);
            if (Build.VERSION.SDK_INT > 29) {
                Uri parse = Uri.parse("content://com.android.externalstorage.documents/document/primary:Download");
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
                intent.putExtra("android.intent.extra.TITLE", str);
                intent.putExtra("android.provider.extra.INITIAL_URI", parse);
                startActivityForResult(intent, 10);
                return;
            }
            String str2 = "INTL";
            try {
                str2 = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
            } catch (Exception e) {
                WebViewLog.getInstance().e(e.getMessage());
            }
            File file = new File(Environment.getExternalStorageDirectory(), str2);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, str);
            WebViewLog.getInstance().i("Save photo to path:" + Uri.fromFile(file2).getPath());
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                fileOutputStream2 = fileOutputStream2;
            }
            try {
                this.bitmapDownloaded.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                WebViewLog webViewLog = WebViewLog.getInstance();
                webViewLog.i("Save photo success");
                onSaveSuccess(file2);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream2 = webViewLog;
            } catch (IOException e4) {
                e = e4;
                fileOutputStream3 = fileOutputStream;
                e.printStackTrace();
                WebViewLog.getInstance().e("Save photo failed! fileName:" + str);
                fileOutputStream2 = fileOutputStream3;
                if (fileOutputStream3 != null) {
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                    fileOutputStream2 = fileOutputStream3;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return;
        }
        WebViewLog.getInstance().e("Photo bitmap is null");
    }

    private void onSaveSuccess(final File file) {
        runOnUiThread(new Runnable() { // from class: com.intlgame.webview.WebViewActivity.17
            @Override // java.lang.Runnable
            public void run() {
                WebViewActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                WebViewLog.getInstance().i("Send broadcast done");
            }
        });
    }
}
