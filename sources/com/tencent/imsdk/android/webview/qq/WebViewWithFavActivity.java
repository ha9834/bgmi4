package com.tencent.imsdk.android.webview.qq;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.helpshift.util.AttachmentConstants;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.webview.qq.FloatButton;
import com.tencent.imsdk.android.webview.qq.ShareAnimMenu;
import com.tencent.imsdk.android.webview.qq.notch.IMSDKNotch;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WebViewWithFavActivity extends Activity {
    private static final int FILE_CHOOSER_REQUEST_CODE = 78;
    private static final int FILE_CHOOSER_REQUEST_CODE_FOR_ANDROID5 = 79;
    private static final String IMSDK_WEBVIEW_QQ_NAV_HIDE = "IMSDK_WEBVIEW_QQ_NAV_HIDE";
    private static final String IMSDK_WEBVIEW_QQ_NAV_NEST_SCROLL = "IMSDK_WEBVIEW_QQ_NAV_NEST_SCROLL";
    private static final String INNER_PROCESS = "imsdk_inner_webview";
    private static final int SHARE_GRID_COLUMN_LANDSCAPE = 5;
    private static final int SHARE_GRID_COLUMN_PORTRAIT = 4;
    private Drawable mBackDrawable;
    private Drawable mBackOnDrawable;
    private int mBgColor;
    private ImageButton mBottomBackBtn;
    private BottomBehaviorLand mBottomBehaviorLand;
    private BottomBehaviorPortrait mBottomBehaviorPortrait;
    private ImageButton mBottomForwardBtn;
    private ProgressBar mBottomProgressBar;
    private RelativeLayout mBottomRefreshLayout;
    private LinearLayout mBottomToolBarLayout;
    private View mCustomView;
    private IX5WebChromeClient.CustomViewCallback mCustomViewCallback;
    private Drawable mForwardDrawable;
    private Drawable mForwardOnDrawable;
    private NestedWebView mNestWebView;
    private AppBarLayout.ScrollingViewBehavior mNestWebViewBehavior;
    private int mOriginalOrientation;
    private int mOriginalSystemUiVisibility;
    private List<Map<String, Object>> mShareDataList;
    private ProgressBar mTopProgressBar;
    private ViewGroup mTopRefreshViewGroup;
    private TextView mTopTitleTv;
    private AppBarLayout mTopToolBarLayout;
    private AppBarLayout.b mTopToolbarInnerLayoutParams;
    private ValueCallback<Uri> mUploadFile;
    private ValueCallback<Uri[]> mUploadFileAndroid5;
    private CustomWebChromeClient mWebChromeClient;
    private ImageButton mTopRefreshBtn = null;
    private ImageButton mTopStopBtn = null;
    private boolean mTopToolBarCanLandShow = false;
    private ImageButton mBottomRefreshBtn = null;
    private ImageButton mBottomStopBtn = null;
    private CoordinatorLayout.e mBottomBarLayoutParams = null;
    private GridView mShareGridView = null;
    private ShareAnimMenu mShareAnimMenu = null;
    private CoordinatorLayout.e mNestWebViewLayoutParams = null;
    private float mZoomHeight = 1.0f;
    private float mZoomWidth = 1.0f;
    private boolean mToolBarJsHide = false;
    private boolean mIsX5Work = false;
    private IMSDKNotch.NotchStatus mUseNotch = IMSDKNotch.NotchStatus.DEFAULT;
    private Messenger mServerMessenger = null;
    private Messenger mClientMessenger = null;
    private MsgHandler mMsgHandler = null;
    private boolean mBound = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.9
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IMLogger.d("onServiceConnected iBinder=" + iBinder);
            if (iBinder != null) {
                WebViewWithFavActivity.this.mServerMessenger = new Messenger(iBinder);
                WebViewWithFavActivity.this.mBound = true;
                WebViewWithFavActivity webViewWithFavActivity = WebViewWithFavActivity.this;
                webViewWithFavActivity.sendMessageToServer(23, "", webViewWithFavActivity.mClientMessenger);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IMLogger.d("onServiceDisconnected");
            WebViewWithFavActivity.this.mServerMessenger = null;
            WebViewWithFavActivity.this.mBound = false;
        }
    };

    private void loadUrl(Intent intent) {
        NestedWebView nestedWebView;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("webview_url");
            IMLogger.d("loadUrl = " + stringExtra);
            if (stringExtra == null || (nestedWebView = this.mNestWebView) == null) {
                return;
            }
            nestedWebView.loadUrl(stringExtra);
            return;
        }
        IMLogger.w("loadUrl intent is null!", new Object[0]);
    }

    private void initLayout() {
        this.mNestWebView = (NestedWebView) findViewById(ResourceUtil.getId(this, "nested_webview_container"));
        NestedWebView nestedWebView = this.mNestWebView;
        if (nestedWebView != null) {
            this.mNestWebViewLayoutParams = (CoordinatorLayout.e) nestedWebView.getLayoutParams();
        }
        initDynamicRes();
        adjustNotchScreen();
        setNavNestScrollEnable();
        updateWebViewToolBar();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                IMLogger.d("status bar change " + i);
                if (i == 0) {
                    WebViewWithFavActivity.this.setFullScreenCompat();
                } else {
                    IMLogger.d("not visibility");
                }
            }
        });
    }

    private void initDynamicRes() {
        this.mBackDrawable = ResourceUtil.getDrawable(this, "back");
        this.mBackOnDrawable = ResourceUtil.getDrawable(this, "back_on");
        this.mForwardDrawable = ResourceUtil.getDrawable(this, "forward");
        this.mForwardOnDrawable = ResourceUtil.getDrawable(this, "forward_on");
        this.mBottomForwardBtn = (ImageButton) findViewById(ResourceUtil.getId(this, "forward"));
        this.mBottomBackBtn = (ImageButton) findViewById(ResourceUtil.getId(this, "back"));
        this.mTopTitleTv = (TextView) findViewById(ResourceUtil.getId(this, "tv_title"));
        this.mTopToolBarLayout = (AppBarLayout) findViewById(ResourceUtil.getId(this, "qq_webview_top_toolbar"));
        AppBarLayout appBarLayout = this.mTopToolBarLayout;
        if (appBarLayout != null) {
            this.mTopToolBarCanLandShow = Boolean.parseBoolean((String) appBarLayout.getTag());
            IMLogger.d("mToolBarCanLandShow = " + this.mTopToolBarCanLandShow);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResourceUtil.getId(this, "top_toolbar_inner"));
        if (linearLayout != null) {
            this.mTopToolbarInnerLayoutParams = (AppBarLayout.b) linearLayout.getLayoutParams();
        }
        this.mBottomToolBarLayout = (LinearLayout) findViewById(ResourceUtil.getId(this, "qq_webview_bottom_toolbar"));
        LinearLayout linearLayout2 = this.mBottomToolBarLayout;
        if (linearLayout2 != null) {
            this.mBottomBarLayoutParams = (CoordinatorLayout.e) linearLayout2.getLayoutParams();
        }
        this.mTopProgressBar = (ProgressBar) findViewById(ResourceUtil.getId(this, "progressbar_top"));
        this.mBottomProgressBar = (ProgressBar) findViewById(ResourceUtil.getId(this, "progressbar_bottom"));
        this.mTopRefreshViewGroup = (ViewGroup) findViewById(ResourceUtil.getId(this, "view_refresh_top"));
        ViewGroup viewGroup = this.mTopRefreshViewGroup;
        if (viewGroup != null) {
            this.mTopRefreshBtn = (ImageButton) viewGroup.findViewById(ResourceUtil.getId(this, "refresh"));
            this.mTopStopBtn = (ImageButton) this.mTopRefreshViewGroup.findViewById(ResourceUtil.getId(this, "stop"));
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById(ResourceUtil.getId(this, "view_refresh_bottom"));
        if (viewGroup2 != null) {
            this.mBottomRefreshBtn = (ImageButton) viewGroup2.findViewById(ResourceUtil.getId(this, "refresh"));
            this.mBottomStopBtn = (ImageButton) viewGroup2.findViewById(ResourceUtil.getId(this, "stop"));
        }
        this.mBottomRefreshLayout = (RelativeLayout) findViewById(ResourceUtil.getId(this, "layout_refresh_bottom"));
        int layoutId = ResourceUtil.getLayoutId(this, "layout_share_view");
        if (layoutId != 0) {
            this.mShareAnimMenu = new ShareAnimMenu(this, layoutId);
            Button button = (Button) this.mShareAnimMenu.findViewById(ResourceUtil.getId(this, "share_cancel"));
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WebViewWithFavActivity.this.mShareAnimMenu.dismiss(null);
                    }
                });
                Typeface typeface = ResourceUtil.getTypeface(this, "share_cancel");
                if (typeface != null) {
                    button.setTypeface(typeface);
                }
            }
            this.mShareGridView = (GridView) this.mShareAnimMenu.findViewById(ResourceUtil.getId(this, "share_gridview"));
        }
        new FloatButton(this, new FloatButton.Callback() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.3
            @Override // com.tencent.imsdk.android.webview.qq.FloatButton.Callback
            public void onClick(View view) {
                if (WebViewWithFavActivity.this.mCustomView != null) {
                    if (WebViewWithFavActivity.this.mWebChromeClient != null) {
                        WebViewWithFavActivity.this.mWebChromeClient.onHideCustomView();
                        return;
                    }
                    return;
                }
                WebViewWithFavActivity.this.finish();
            }
        }).addViewToGroup((ViewGroup) findViewById(ResourceUtil.getId(this, "qq_webview_root_layout")));
    }

    private void initShareLayoutData() {
        if (this.mShareGridView != null) {
            if (DisplayUtil.isPortrait(this)) {
                this.mShareGridView.setNumColumns(4);
            } else {
                this.mShareGridView.setNumColumns(5);
            }
            this.mShareDataList = ShareManager.getChannelListData(this);
            if (this.mShareDataList != null) {
                String[] strArr = {"image", com.intlgame.webview.WebViewManager.KEY_JS_CHANNEL};
                int[] iArr = {ResourceUtil.getId(this, "share_channel_icon"), ResourceUtil.getId(this, "share_channel_title")};
                int layoutId = ResourceUtil.getLayoutId(this, "layout_share_grid_item");
                if (layoutId != 0) {
                    this.mShareGridView.setAdapter((ListAdapter) new SimpleAdapter(this, this.mShareDataList, layoutId, strArr, iArr));
                    this.mShareGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.4
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                            IMLogger.d("handleShareEvent, onItemClick=" + i);
                            if (WebViewWithFavActivity.this.mShareAnimMenu != null) {
                                WebViewWithFavActivity.this.mShareAnimMenu.dismiss(new ShareAnimMenu.IDismissListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.4.1
                                    @Override // com.tencent.imsdk.android.webview.qq.ShareAnimMenu.IDismissListener
                                    public void onDismiss() {
                                        WebViewWithFavActivity.this.handleShareEvent(i);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShareEvent(int i) {
        List<Map<String, Object>> list = this.mShareDataList;
        if (list == null || list.size() == 0) {
            IMLogger.e("handleShareEvent mShareDataList null/size = 0!", new Object[0]);
            return;
        }
        Map<String, Object> map = this.mShareDataList.get(i);
        if (map == null) {
            IMLogger.e("handleShareEvent get item:" + i + " error!", new Object[0]);
            return;
        }
        if (this.mNestWebView == null) {
            IMLogger.e("mWebView is null, please check!!!", new Object[0]);
            return;
        }
        int intValue = ((Integer) map.get("id")).intValue();
        if (intValue == 99) {
            ShareManager.shareToBrowser(this, this.mNestWebView.getUrl());
            return;
        }
        try {
            ShareManager.shareToChannel(this, map.get(com.intlgame.webview.WebViewManager.KEY_JS_CHANNEL).toString(), this.mNestWebView.getTitle(), this.mNestWebView.getUrl());
        } catch (Exception e) {
            IMLogger.w("share " + intValue + " failed : " + e.getMessage(), new Object[0]);
        }
    }

    public void refreshOnclick(View view) {
        NestedWebView nestedWebView = this.mNestWebView;
        if (nestedWebView != null) {
            nestedWebView.reload();
        }
    }

    public void stopOnclick(View view) {
        NestedWebView nestedWebView = this.mNestWebView;
        if (nestedWebView != null) {
            nestedWebView.stopLoading();
        }
    }

    public void shareOnclick(View view) {
        initShareLayoutData();
        ShareAnimMenu shareAnimMenu = this.mShareAnimMenu;
        if (shareAnimMenu != null) {
            shareAnimMenu.show();
        }
    }

    public void closeOnClick(View view) {
        processWebViewEvent(5);
    }

    public void backOnClick(View view) {
        processWebViewEvent(6);
    }

    public void forwardOnClick(View view) {
        processWebViewEvent(7);
    }

    private void parseAndDealIntentValue(Intent intent) {
        if (intent != null) {
            this.mZoomHeight = intent.getFloatExtra(WebViewManager.INTENT_KEY_HEIGHT, 1.0f);
            this.mZoomWidth = intent.getFloatExtra(WebViewManager.INTENT_KEY_WIDTH, 1.0f);
            this.mIsX5Work = intent.getBooleanExtra(WebViewManager.INTENT_KEY_EXTRA_X5_WORK, false);
            if (intent.getExtras().containsKey(WebViewManager.INTENT_KEY_USE_NOTCH)) {
                this.mUseNotch = intent.getBooleanExtra(WebViewManager.INTENT_KEY_USE_NOTCH, false) ? IMSDKNotch.NotchStatus.USING : IMSDKNotch.NotchStatus.NEVER;
            }
            IMLogger.d("getIntentValue Height x Width : " + this.mZoomHeight + "x" + this.mZoomHeight + ", mIsX5Work = " + this.mIsX5Work + ", mUseNotch = " + this.mUseNotch);
            if (intent.getExtras().containsKey(WebViewManager.INTENT_KEY_BG_COLOR)) {
                this.mBgColor = intent.getIntExtra(WebViewManager.INTENT_KEY_BG_COLOR, WebViewManager.IMSDK_WEBVIEW_DEFAULT_BG_COLOR);
            }
            boolean booleanExtra = intent.getBooleanExtra(WebViewManager.INTENT_KEY_IS_LANDSCAPE, true);
            if (intent.getBooleanExtra(WebViewManager.INTENT_KEY_IS_ORIENTATION, false)) {
                setRequestedOrientation(!booleanExtra ? 1 : 0);
            }
        }
    }

    private void processZoom() {
        if (this.mZoomHeight == 1.0f && this.mZoomWidth == 1.0f) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = (int) (i2 * this.mZoomHeight);
        attributes.width = (int) (i * this.mZoomWidth);
        getWindow().setAttributes(attributes);
    }

    private void initWebView() {
        if (this.mNestWebView == null) {
            IMLogger.e("mNestWebView is null, please check !!!", new Object[0]);
            return;
        }
        this.mWebChromeClient = new CustomWebChromeClient();
        this.mNestWebView.setWebChromeClient(this.mWebChromeClient);
        this.mNestWebView.setBackgroundColor(this.mBgColor);
        this.mNestWebView.setWebViewClient(new WebViewClient() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.5
            @Override // com.tencent.smtt.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return WebViewCommonUtil.shouldOverrideUrlLoading(webView, str);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                WebViewWithFavActivity.this.changeBackForwardBtnState();
                WebViewWithFavActivity.this.displayRefreshBtn(true);
                if (WebViewWithFavActivity.this.mNestWebView != null) {
                    String title = WebViewWithFavActivity.this.mNestWebView.getTitle();
                    if (WebViewWithFavActivity.this.mTopTitleTv == null || T.ckIsEmpty(title)) {
                        return;
                    }
                    WebViewWithFavActivity.this.mTopTitleTv.setText(title);
                    Typeface typeface = ResourceUtil.getTypeface(WebViewWithFavActivity.this, "webview_title");
                    if (typeface != null) {
                        WebViewWithFavActivity.this.mTopTitleTv.setTypeface(typeface);
                    }
                }
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                WebViewWithFavActivity.this.displayRefreshBtn(false);
            }
        });
        WebViewCommonUtil.initWebViewSettings(this, this.mNestWebView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayRefreshBtn(boolean z) {
        ImageButton imageButton = this.mBottomRefreshBtn;
        if (imageButton != null && this.mBottomStopBtn != null) {
            imageButton.setVisibility(z ? 0 : 8);
            this.mBottomStopBtn.setVisibility(!z ? 0 : 8);
        }
        ImageButton imageButton2 = this.mTopRefreshBtn;
        if (imageButton2 == null || this.mTopStopBtn == null) {
            return;
        }
        imageButton2.setVisibility(z ? 0 : 8);
        this.mTopStopBtn.setVisibility(z ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeBackForwardBtnState() {
        NestedWebView nestedWebView = this.mNestWebView;
        if (nestedWebView != null) {
            if (this.mBottomForwardBtn != null) {
                if (nestedWebView.canGoForward()) {
                    Drawable drawable = this.mForwardOnDrawable;
                    if (drawable != null) {
                        this.mBottomForwardBtn.setImageDrawable(drawable);
                    }
                } else {
                    Drawable drawable2 = this.mForwardDrawable;
                    if (drawable2 != null) {
                        this.mBottomForwardBtn.setImageDrawable(drawable2);
                    }
                }
            }
            if (this.mBottomBackBtn != null) {
                if (this.mNestWebView.canGoBack()) {
                    Drawable drawable3 = this.mBackOnDrawable;
                    if (drawable3 != null) {
                        this.mBottomBackBtn.setImageDrawable(drawable3);
                        return;
                    }
                    return;
                }
                Drawable drawable4 = this.mBackDrawable;
                if (drawable4 != null) {
                    this.mBottomBackBtn.setImageDrawable(drawable4);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            setFullScreenCompat();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        setFullScreenCompat();
        this.mNestWebView.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mNestWebView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void setFullScreenCompat() {
        IMLogger.d("current version number is " + Build.VERSION.SDK_INT);
        setFullScreenCompatBefore();
        if (T.Meta.readFromApplication((Context) this, IMSDK_WEBVIEW_QQ_NAV_HIDE, false)) {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                View decorView = getWindow().getDecorView();
                IMLogger.d("setSystemUiVisibility : 4871");
                decorView.setSystemUiVisibility(4871);
            }
        }
        IMLogger.d("CustomCoordinator decor view height:" + getWindow().getDecorView().getHeight());
    }

    private void setFullScreenCompatBefore() {
        IMLogger.d("current version number is " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT < 16) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(T.Meta.readFromApplication((Context) this, IMSDK_WEBVIEW_QQ_NAV_HIDE, false) ? 5895 : 5381);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private boolean isIndependentProcess() {
        try {
            IMLogger.d("isIndependentProcess start");
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses().iterator();
            while (it.hasNext()) {
                if (it.next().processName.contains(INNER_PROCESS)) {
                    IMLogger.d("isIndependentProcess return true");
                    return true;
                }
            }
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
        return false;
    }

    private boolean killWebViewInSingleProcess() {
        try {
            IMLogger.d("killWebViewInSingleProcess start");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.contains(INNER_PROCESS)) {
                    if (AndroidRomUtil.autoKillMultiProcess()) {
                        return true;
                    }
                    IMLogger.d("killWebViewInSingleProcess");
                    Process.killProcess(runningAppProcessInfo.pid);
                    return true;
                }
            }
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
        return false;
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isIndependentProcess()) {
            IMSDKConfig.initialize(this);
            if (Build.VERSION.SDK_INT >= 28 && Application.getProcessName().contains(INNER_PROCESS)) {
                try {
                    IMLogger.d("on Android P setDataDirectorySuffix start");
                    android.webkit.WebView.setDataDirectorySuffix(INNER_PROCESS);
                } catch (Exception e) {
                    IMLogger.d("on Android P setDataDirectorySuffix error: " + e.getMessage());
                }
            }
        }
        IMLogger.d("LifeCycle onCreate, thread = " + Thread.currentThread().getName());
        parseAndDealIntentValue(getIntent());
        WebViewCommonUtil.initX5Environment(this, this.mIsX5Work);
        IMSDKNotch.init(this);
        processZoom();
        getWindow().setFlags(1024, 1024);
        setContentView(ResourceUtil.getLayoutId(this, "com_tencent_msdk_webview_window"));
        initLayout();
        initWebView();
        changeBackForwardBtnState();
        loadUrl(getIntent());
        HandlerThread handlerThread = new HandlerThread("handler-thread-client");
        handlerThread.start();
        WebViewService.setClientHandlerThread(handlerThread);
        this.mMsgHandler = new MsgHandler(handlerThread.getLooper());
        this.mClientMessenger = new Messenger(this.mMsgHandler);
        bindWebViewService();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || this.mNestWebView == null) {
            return;
        }
        loadUrl(intent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IMLogger.d("LifeCycle onDestroy");
        sendMessageToServer(21, "", null);
        try {
            if (this.mNestWebView != null) {
                this.mNestWebView.stopLoading();
                this.mNestWebView.removeAllViews();
                this.mNestWebView.destroy();
                this.mNestWebView = null;
            }
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
        }
        super.onDestroy();
        unBindWebViewService();
        killWebViewInSingleProcess();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IMLogger.d("WebView onConfigurationChanged");
        setNavNestScrollEnable();
        processZoom();
        setFullScreenCompat();
        this.mNestWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                WebViewWithFavActivity.this.updateWebViewToolBar();
                if (Build.VERSION.SDK_INT >= 16) {
                    WebViewWithFavActivity.this.mNestWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    WebViewWithFavActivity.this.mNestWebView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWebViewToolBar() {
        if (this.mToolBarJsHide) {
            this.mTopToolBarLayout.setVisibility(8);
            this.mBottomToolBarLayout.setVisibility(8);
            CoordinatorLayout.e eVar = this.mNestWebViewLayoutParams;
            eVar.topMargin = 0;
            eVar.bottomMargin = 0;
            return;
        }
        if (DisplayUtil.isPortrait(this)) {
            IMLogger.d("onConfigurationChanged isPortrait");
            this.mShareGridView.setNumColumns(4);
            RelativeLayout relativeLayout = this.mBottomRefreshLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            ViewGroup viewGroup = this.mTopRefreshViewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            AppBarLayout appBarLayout = this.mTopToolBarLayout;
            if (appBarLayout != null) {
                appBarLayout.setVisibility(0);
                this.mNestWebViewLayoutParams.topMargin = 0;
            }
        } else if (DisplayUtil.isLandscape(this)) {
            IMLogger.d("onConfigurationChanged isLandscape");
            this.mShareGridView.setNumColumns(5);
            RelativeLayout relativeLayout2 = this.mBottomRefreshLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            ViewGroup viewGroup2 = this.mTopRefreshViewGroup;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(4);
            }
            if (this.mTopToolBarCanLandShow) {
                AppBarLayout appBarLayout2 = this.mTopToolBarLayout;
                if (appBarLayout2 != null) {
                    appBarLayout2.setVisibility(0);
                }
            } else if (this.mTopToolBarLayout != null) {
                this.mNestWebViewLayoutParams.a((CoordinatorLayout.b) null);
                this.mTopToolBarLayout.setVisibility(8);
            }
        }
        LinearLayout linearLayout = this.mBottomToolBarLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.mNestWebViewLayoutParams.bottomMargin = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mBottomToolBarLayout v:");
        sb.append(this.mBottomToolBarLayout.getVisibility() == 0);
        IMLogger.d(sb.toString());
    }

    private void adjustNotchScreen() {
        switch (this.mUseNotch) {
            case USING:
                IMLogger.d("using notch");
                IMSDKNotch.useNotch();
                return;
            case NEVER:
                IMLogger.d("cancel notch");
                IMSDKNotch.cancelUseNotch();
                return;
            case DEFAULT:
                IMLogger.d("use default notch status");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processWebViewEvent(int i) {
        if (this.mNestWebView == null) {
            IMLogger.e("mNestWebView is null , please check init.", new Object[0]);
            return;
        }
        IMLogger.d("eventId = " + i);
        switch (i) {
            case 5:
                finish();
                return;
            case 6:
                if (this.mCustomView != null) {
                    CustomWebChromeClient customWebChromeClient = this.mWebChromeClient;
                    if (customWebChromeClient != null) {
                        customWebChromeClient.onHideCustomView();
                        return;
                    }
                    return;
                }
                if (this.mNestWebView.canGoBack()) {
                    this.mNestWebView.goBack();
                    return;
                }
                return;
            case 7:
                if (this.mNestWebView.canGoForward()) {
                    this.mNestWebView.goForward();
                    return;
                }
                return;
            case 8:
                refreshOnclick(null);
                return;
            default:
                IMLogger.w("not support eventId = " + i, new Object[0]);
                return;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        IMLogger.d("onActivityResult, requestCode : " + i + ", resultCode:" + i2);
        if (i2 == -1) {
            switch (i) {
                case 78:
                    if (this.mUploadFile != null) {
                        this.mUploadFile.onReceiveValue(intent == null ? null : intent.getData());
                        this.mUploadFile = null;
                        return;
                    }
                    return;
                case 79:
                    if (this.mUploadFileAndroid5 != null) {
                        onActivityResultAboveL(i, i2, intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if (i2 == 0) {
            switch (i) {
                case 78:
                    ValueCallback<Uri> valueCallback = this.mUploadFile;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(null);
                        this.mUploadFile = null;
                        return;
                    }
                    return;
                case 79:
                    ValueCallback<Uri[]> valueCallback2 = this.mUploadFileAndroid5;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(null);
                        this.mUploadFileAndroid5 = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @TargetApi(21)
    private void onActivityResultAboveL(int i, int i2, Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        if (i != 79 || this.mUploadFileAndroid5 == null) {
            return;
        }
        if (i2 != -1 || intent == null) {
            uriArr = null;
        } else {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                uriArr2 = new Uri[clipData.getItemCount()];
                for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                    uriArr2[i3] = clipData.getItemAt(i3).getUri();
                }
            } else {
                uriArr2 = null;
            }
            uriArr = dataString != null ? new Uri[]{Uri.parse(dataString)} : uriArr2;
        }
        this.mUploadFileAndroid5.onReceiveValue(uriArr);
        this.mUploadFileAndroid5 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CustomWebChromeClient extends WebChromeClient {
        CustomWebChromeClient() {
        }

        private void dealWithFileChooser(int i) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(AttachmentConstants.ALLOW_ALL_MIME);
            try {
                int stringId = ResourceUtil.getStringId(WebViewWithFavActivity.this, "msdk_upload_file_title");
                WebViewWithFavActivity.this.startActivityForResult(Intent.createChooser(intent, stringId != 0 ? WebViewWithFavActivity.this.getResources().getString(stringId) : "update file"), i);
            } catch (ActivityNotFoundException e) {
                IMLogger.d(e.getMessage());
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                WebViewWithFavActivity.this.changeBackForwardBtnState();
                if (WebViewWithFavActivity.this.mTopProgressBar != null && WebViewWithFavActivity.this.mTopProgressBar.getVisibility() != 8) {
                    WebViewWithFavActivity.this.mTopProgressBar.setVisibility(8);
                }
                if (WebViewWithFavActivity.this.mBottomProgressBar == null || WebViewWithFavActivity.this.mBottomProgressBar.getVisibility() == 8) {
                    return;
                }
                WebViewWithFavActivity.this.mBottomProgressBar.setVisibility(8);
                return;
            }
            if (WebViewWithFavActivity.this.mTopProgressBar == null || WebViewWithFavActivity.this.mBottomProgressBar == null) {
                if (WebViewWithFavActivity.this.mTopProgressBar != null) {
                    if (WebViewWithFavActivity.this.mTopProgressBar.getVisibility() == 8) {
                        WebViewWithFavActivity.this.mTopProgressBar.setVisibility(0);
                    }
                    WebViewWithFavActivity.this.mTopProgressBar.setProgress(i);
                }
                if (WebViewWithFavActivity.this.mBottomProgressBar != null) {
                    if (WebViewWithFavActivity.this.mBottomProgressBar.getVisibility() == 8) {
                        WebViewWithFavActivity.this.mBottomProgressBar.setVisibility(0);
                    }
                    WebViewWithFavActivity.this.mBottomProgressBar.setProgress(i);
                    return;
                }
                return;
            }
            if (DisplayUtil.isPortrait(WebViewWithFavActivity.this)) {
                if (WebViewWithFavActivity.this.mTopProgressBar.getVisibility() == 8) {
                    WebViewWithFavActivity.this.mTopProgressBar.setVisibility(0);
                }
                WebViewWithFavActivity.this.mTopProgressBar.setProgress(i);
            } else {
                if (WebViewWithFavActivity.this.mBottomProgressBar.getVisibility() == 8) {
                    WebViewWithFavActivity.this.mBottomProgressBar.setVisibility(0);
                }
                WebViewWithFavActivity.this.mBottomProgressBar.setProgress(i);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, com.tencent.smtt.sdk.ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            IMLogger.d("onShowFileChooser");
            if (WebViewWithFavActivity.this.mUploadFileAndroid5 != null) {
                WebViewWithFavActivity.this.mUploadFileAndroid5.onReceiveValue(null);
                WebViewWithFavActivity.this.mUploadFileAndroid5 = null;
            }
            WebViewWithFavActivity.this.mUploadFileAndroid5 = valueCallback;
            dealWithFileChooser(79);
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> valueCallback, String str, String str2) {
            WebViewWithFavActivity.this.mUploadFile = valueCallback;
            dealWithFileChooser(78);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IMLogger.d("onShowCustomView");
            if (WebViewWithFavActivity.this.mCustomView == null) {
                WebViewWithFavActivity.this.mCustomView = view;
                WebViewWithFavActivity webViewWithFavActivity = WebViewWithFavActivity.this;
                webViewWithFavActivity.mOriginalSystemUiVisibility = webViewWithFavActivity.getWindow().getDecorView().getSystemUiVisibility();
                WebViewWithFavActivity webViewWithFavActivity2 = WebViewWithFavActivity.this;
                webViewWithFavActivity2.mOriginalOrientation = webViewWithFavActivity2.getRequestedOrientation();
                WebViewWithFavActivity.this.mCustomViewCallback = customViewCallback;
                ((ViewGroup) WebViewWithFavActivity.this.getWindow().getDecorView()).addView(WebViewWithFavActivity.this.mCustomView, new ViewGroup.LayoutParams(-1, -1));
                WebViewWithFavActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
                WebViewWithFavActivity.this.setRequestedOrientation(0);
                return;
            }
            onHideCustomView();
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            IMLogger.d("onHideCustomView");
            ((ViewGroup) WebViewWithFavActivity.this.getWindow().getDecorView()).removeView(WebViewWithFavActivity.this.mCustomView);
            WebViewWithFavActivity.this.mCustomView = null;
            WebViewWithFavActivity.this.getWindow().getDecorView().setSystemUiVisibility(WebViewWithFavActivity.this.mOriginalSystemUiVisibility);
            WebViewWithFavActivity webViewWithFavActivity = WebViewWithFavActivity.this;
            webViewWithFavActivity.setRequestedOrientation(webViewWithFavActivity.mOriginalOrientation);
            WebViewWithFavActivity.this.mCustomViewCallback.onCustomViewHidden();
            WebViewWithFavActivity.this.mCustomViewCallback = null;
        }

        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> valueCallback, String str) {
            WebViewWithFavActivity.this.mUploadFile = valueCallback;
            dealWithFileChooser(78);
        }

        public void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> valueCallback) {
            WebViewWithFavActivity.this.mUploadFile = valueCallback;
            dealWithFileChooser(78);
        }
    }

    @JavascriptInterface
    public void jsCallNative(String str) {
        IMLogger.d("jsCallNative jsParasJson = " + str);
        sendMessageToServer(22, str, null);
    }

    public void callJs(final String str) {
        IMLogger.d("callJs parasJson : " + str);
        if (this.mNestWebView == null) {
            IMLogger.d("webView instance is null");
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder("IMSDKCallJs");
                    sb.append("('");
                    sb.append(str);
                    sb.append("')");
                    if (Build.VERSION.SDK_INT >= 19) {
                        WebViewWithFavActivity.this.mNestWebView.evaluateJavascript(sb.toString(), new com.tencent.smtt.sdk.ValueCallback<String>() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.7.1
                            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                            public void onReceiveValue(String str2) {
                                WebViewWithFavActivity.this.sendMessageToServer(4, str2, null);
                            }
                        });
                        return;
                    }
                    WebViewWithFavActivity.this.mNestWebView.loadUrl("javascript:" + sb.toString());
                }
            });
        }
    }

    public void javascriptOperateToolBar(final String str) {
        IMLogger.d("javascriptOperateToolBar parasJson : " + str);
        runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("hideToolBar")) {
                        WebViewWithFavActivity.this.mToolBarJsHide = jSONObject.getBoolean("hideToolBar");
                        if (WebViewWithFavActivity.this.mToolBarJsHide) {
                            FloatButton.show();
                        } else {
                            FloatButton.hide();
                        }
                        WebViewWithFavActivity.this.setNavNestScrollEnable();
                        WebViewWithFavActivity.this.updateWebViewToolBar();
                    }
                } catch (Exception e) {
                    IMLogger.e("javascriptOperateToolBar exception : " + e.toString(), new Object[0]);
                }
            }
        });
    }

    private void bindWebViewService() {
        bindService(new Intent(this, (Class<?>) WebViewService.class), this.mServiceConnection, 1);
    }

    private void unBindWebViewService() {
        IMLogger.d("unBindWebViewService mBound=" + this.mBound);
        if (this.mBound) {
            unbindService(this.mServiceConnection);
            this.mBound = false;
        }
    }

    private void sendMessageToHandler(int i, int i2) {
        MsgHandler msgHandler = this.mMsgHandler;
        if (msgHandler != null) {
            if (msgHandler.hasMessages(i)) {
                this.mMsgHandler.removeMessages(i);
            }
            Message obtainMessage = this.mMsgHandler.obtainMessage(i);
            obtainMessage.arg1 = i2;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageToServer(int i, String str, Messenger messenger) {
        if (!this.mBound) {
            bindWebViewService();
            return;
        }
        Message obtain = Message.obtain((Handler) null, i);
        Bundle bundle = new Bundle();
        if (!T.ckIsEmpty(str)) {
            bundle.putString("json_data", str);
        }
        if (messenger != null) {
            obtain.replyTo = messenger;
        }
        obtain.setData(bundle);
        try {
            this.mServerMessenger.send(obtain);
        } catch (RemoteException e) {
            IMLogger.d(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavNestScrollEnable() {
        if (T.Meta.readFromApplication((Context) this, IMSDK_WEBVIEW_QQ_NAV_NEST_SCROLL, false)) {
            IMLogger.d("nest scroll effect enabled");
            if (this.mNestWebViewBehavior == null) {
                this.mNestWebViewBehavior = new AppBarLayout.ScrollingViewBehavior(this, null);
            }
            if (this.mToolBarJsHide) {
                this.mNestWebViewLayoutParams.a((CoordinatorLayout.b) null);
            } else {
                this.mNestWebViewLayoutParams.a(this.mNestWebViewBehavior);
            }
            if (this.mBottomBehaviorPortrait == null) {
                this.mBottomBehaviorPortrait = new BottomBehaviorPortrait(this, null);
            }
            if (this.mBottomBehaviorLand == null) {
                this.mBottomBehaviorLand = new BottomBehaviorLand(this, null);
            }
            if (DisplayUtil.isPortrait(this)) {
                this.mBottomBarLayoutParams.a(this.mBottomBehaviorPortrait);
                return;
            } else {
                if (DisplayUtil.isLandscape(this)) {
                    this.mBottomBarLayoutParams.a(this.mBottomBehaviorLand);
                    return;
                }
                return;
            }
        }
        IMLogger.d("nest scroll effect disable");
        this.mBottomBehaviorPortrait = null;
        this.mBottomBehaviorLand = null;
        this.mNestWebViewBehavior = null;
        CoordinatorLayout.e eVar = this.mNestWebViewLayoutParams;
        if (eVar != null) {
            eVar.a((CoordinatorLayout.b) null);
        }
        CoordinatorLayout.e eVar2 = this.mBottomBarLayoutParams;
        if (eVar2 != null) {
            eVar2.a((CoordinatorLayout.b) null);
        }
        AppBarLayout.b bVar = this.mTopToolbarInnerLayoutParams;
        if (bVar != null) {
            bVar.a(0);
        }
    }

    /* loaded from: classes.dex */
    class MsgHandler extends Handler {
        public MsgHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            IMLogger.d("handleMessage, msg=" + message.what);
            if (WebViewWithFavActivity.this.mNestWebView == null) {
                IMLogger.e("mWebView is null , unknown problem happen", new Object[0]);
                return;
            }
            int i = message.what;
            if (i == 24) {
                Bundle data = message.getData();
                WebViewWithFavActivity.this.callJs(data != null ? data.getString("json_data") : "");
            } else if (i == 26) {
                Bundle data2 = message.getData();
                WebViewWithFavActivity.this.javascriptOperateToolBar(data2 != null ? data2.getString("json_data") : "");
            } else {
                final int i2 = message.what;
                WebViewWithFavActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.WebViewWithFavActivity.MsgHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebViewWithFavActivity.this.processWebViewEvent(i2);
                    }
                });
            }
        }
    }
}
