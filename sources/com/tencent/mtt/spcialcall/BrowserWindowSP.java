package com.tencent.mtt.spcialcall;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amazonaws.services.s3.internal.Constants;
import com.intlgame.webview.WebViewManager;
import com.tencent.imsdk.android.IR;
import com.tencent.mtt.collect.CollectManager;
import com.tencent.mtt.common.utils.FileUtils;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.engine.AppEngine;
import com.tencent.mtt.engine.IWebView;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import com.tencent.mtt.spcialcall.sdk.RspContent;
import com.tencent.mtt.ui.util.MttCtrlUtil;
import com.twitter.sdk.android.core.internal.scribe.ScribeConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BrowserWindowSP extends RelativeLayout implements View.OnClickListener, IWebViewClientSp {
    private static final String QR_CATCH_PATH = FileUtils.getShareCacheDir().getPath();
    public static int sHeight;
    public static int sWidth;
    private ImageButton mBack;
    private String mCustomJs;
    private boolean mDestroy;
    String mEntryUrl;
    private ImageButton mFav;
    private ImageButton mForward;
    Handler mHandler;
    private Button mMore;
    private DialogSp mMoreDialog;
    private String mNotifyUrlPrefix;
    private ImageButton mPlus;
    private ProgressBar mProgressBar;
    private int mPv;
    private ImageButton mRefresh;
    private Button mRetrun;
    private DialogSp mShareDialog;
    private SpecialCallActivity mSpActivity;
    private ImageButton mStop;
    private TextView mTitle;
    private RelativeLayout mTitleBar;
    private FrameLayout mToolBarHolder;
    private LinearLayout mToolbar;
    private int mWebThumbHeight;
    private int mWebThumbWidth;
    private IWebView mWebView;
    private long mWebViewId;

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void addBookmark() {
    }

    public boolean restoreWebView() {
        return false;
    }

    public BrowserWindowSP(SpecialCallActivity specialCallActivity, String str, Intent intent) {
        super(specialCallActivity);
        this.mWebThumbWidth = ScribeConfig.DEFAULT_SEND_INTERVAL_SECONDS;
        this.mWebThumbHeight = ScribeConfig.DEFAULT_SEND_INTERVAL_SECONDS;
        this.mWebView = new NullInterface();
        this.mPv = 0;
        this.mWebViewId = -1L;
        this.mDestroy = false;
        this.mSpActivity = specialCallActivity;
        this.mEntryUrl = str;
        this.mWebViewId = intent.getLongExtra(MttApi.WEBVIEW_ID, System.currentTimeMillis());
        this.mCustomJs = intent.getStringExtra("js");
        this.mNotifyUrlPrefix = intent.getStringExtra("notifyUrlPrefix");
        this.mDestroy = false;
        this.mHandler = new Handler(Looper.myLooper());
        initTitleBar(specialCallActivity);
        initBottomBar(specialCallActivity);
        if (ExtraInfo.isWebApp() || ExtraInfo.getDisplayType() == 1) {
            this.mToolBarHolder.setVisibility(8);
            this.mToolbar.setVisibility(8);
            this.mTitleBar.setVisibility(8);
        } else if (ExtraInfo.getDisplayType() == 0) {
            this.mToolBarHolder.setVisibility(0);
            this.mToolbar.setVisibility(0);
            this.mTitleBar.setVisibility(8);
        } else {
            this.mToolBarHolder.setVisibility(0);
            this.mToolbar.setVisibility(0);
            this.mTitleBar.setVisibility(0);
        }
        switchTheme();
    }

    public static void updateScreenSize(Activity activity) {
        if (activity == null) {
            return;
        }
        sWidth = activity.getWindowManager().getDefaultDisplay().getWidth();
        sHeight = activity.getWindowManager().getDefaultDisplay().getHeight();
    }

    public void delayInitWebView() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BrowserWindowSP.this.initWebView(BrowserWindowSP.this.getContext());
                    BrowserWindowSP.this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BrowserWindowSP.this.mDestroy) {
                                return;
                            }
                            try {
                                byte[] postData = ExtraInfo.getPostData();
                                if (postData == null) {
                                    BrowserWindowSP.this.openUrl(BrowserWindowSP.this.mEntryUrl);
                                } else {
                                    BrowserWindowSP.this.postUrl(BrowserWindowSP.this.mEntryUrl, postData);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 100L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initTitleBar(Context context) {
        this.mTitleBar = (RelativeLayout) this.mSpActivity.findViewById(MttResources.getId("titlebar"));
        this.mRetrun = (Button) this.mSpActivity.findViewById(MttResources.getId("return_app"));
        this.mMore = (Button) this.mSpActivity.findViewById(MttResources.getId("more"));
        this.mTitle = (TextView) this.mSpActivity.findViewById(MttResources.getId("title"));
        this.mProgressBar = (ProgressBar) this.mSpActivity.findViewById(MttResources.getId("progress"));
        this.mRetrun.setOnClickListener(this);
        this.mMore.setOnClickListener(this);
        if (ExtraInfo.getExtraTitleItem() != null && ExtraInfo.getExtraTitleItem().size() > 0) {
            this.mTitle.setVisibility(8);
            updateTitleItem(ExtraInfo.getExtraTitleItem());
        } else {
            this.mTitle.setVisibility(0);
        }
        if (!TextUtils.isEmpty(ExtraInfo.getTitle())) {
            this.mTitle.setText(ExtraInfo.getTitle());
        }
        if (ExtraInfo.getTitleBarHeight() != -1) {
            ViewGroup.LayoutParams layoutParams = this.mTitleBar.getLayoutParams();
            layoutParams.height = ExtraInfo.getTitleBarHeight();
            this.mTitleBar.setLayoutParams(layoutParams);
        }
        if (ExtraInfo.isHasReadMode() || ExtraInfo.isHasFav() || ExtraInfo.isHasBookmark() || ExtraInfo.isCanShare() || ExtraInfo.isCanCopyLink() || ExtraInfo.isCanOpenMtt() || ExtraInfo.isCanOpenBrowser()) {
            return;
        }
        if (ExtraInfo.getExtraMoreItem() == null || ExtraInfo.getExtraMoreItem().size() < 1) {
            this.mMore.setVisibility(4);
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void updateTitleItem(ArrayList<ExtendItem> arrayList) {
        ArrayList<ExtendItem> extraTitleItem = ExtraInfo.getExtraTitleItem();
        ArrayList arrayList2 = new ArrayList();
        Iterator<ExtendItem> it = extraTitleItem.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().getLabel().toString());
        }
        new ArrayAdapter(getContext(), MttResources.getLayoutId("thrdcall_spinner_title"), arrayList2).setDropDownViewResource(MttResources.getLayoutId("thrdcall_spinner_list"));
    }

    void initWebView(Context context) {
        this.mWebView = WebViewSpBase.createWebView(context, this);
        WebViewSpManager.addWebView(this.mWebViewId, this.mWebView);
        ((WebViewSp) this.mWebView).setWebViewId(this.mWebViewId);
        ((WebViewSp) this.mWebView).init();
        String str = this.mCustomJs;
        if (str != null) {
            ((WebViewSp) this.mWebView).initJs(str);
        }
        addViewToBrowserWindow();
    }

    private void addViewToBrowserWindow() {
        ((FrameLayout) this.mSpActivity.findViewById(MttResources.getId("webview"))).addView((View) this.mWebView);
    }

    private void initBottomBar(Context context) {
        this.mToolBarHolder = (FrameLayout) this.mSpActivity.findViewById(MttResources.getId("toolbar_holder"));
        this.mToolbar = (LinearLayout) this.mSpActivity.findViewById(MttResources.getId("toolbar"));
        this.mBack = (ImageButton) this.mSpActivity.findViewById(MttResources.getId("back"));
        this.mBack.setAlpha(128);
        this.mBack.setOnClickListener(this);
        this.mForward = (ImageButton) this.mSpActivity.findViewById(MttResources.getId("forward"));
        this.mForward.setAlpha(128);
        this.mForward.setOnClickListener(this);
        this.mRefresh = (ImageButton) this.mSpActivity.findViewById(MttResources.getId("refresh"));
        this.mRefresh.setOnClickListener(this);
        this.mStop = (ImageButton) this.mSpActivity.findViewById(MttResources.getId("stop"));
        this.mStop.setOnClickListener(this);
        this.mFav = (ImageButton) this.mSpActivity.findViewById(MttResources.getId("fav"));
        this.mFav.setOnClickListener(this);
        this.mPlus = (ImageButton) this.mSpActivity.findViewById(MttResources.getId("plus"));
        this.mPlus.setOnClickListener(this);
        if (ExtraInfo.getExtraFavItem() != null) {
            this.mFav.setImageDrawable(ThemeSwitcher.initTransDrawable(getContext(), ExtraInfo.getExtraFavItem()));
        } else if (!ExtraInfo.isHasFav()) {
            this.mFav.setVisibility(4);
        }
        if (ExtraInfo.getExtraPlusItem() != null) {
            this.mPlus.setVisibility(0);
            this.mPlus.setBackgroundDrawable(ThemeSwitcher.initTransDrawable(getContext(), ExtraInfo.getExtraPlusItem()));
        } else {
            this.mPlus.setVisibility(4);
        }
        if (ExtraInfo.getToolBarHeight() != -1) {
            ViewGroup.LayoutParams layoutParams = this.mToolBarHolder.getLayoutParams();
            layoutParams.height = ExtraInfo.getToolBarHeight();
            ViewGroup.LayoutParams layoutParams2 = this.mToolbar.getLayoutParams();
            layoutParams2.height = ExtraInfo.getToolBarHeight();
            this.mToolBarHolder.setLayoutParams(layoutParams);
            this.mToolbar.setLayoutParams(layoutParams2);
        }
    }

    private void switchTheme() {
        ArrayList<ExtendItem> extraThemeItem = ExtraInfo.getExtraThemeItem();
        if (extraThemeItem == null || extraThemeItem.size() == 0) {
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(MttResources.getDimensId("thrdcall_titlebar_btn_padding"));
        Iterator<ExtendItem> it = extraThemeItem.iterator();
        while (it.hasNext()) {
            ExtendItem next = it.next();
            int id = next.getID();
            if (id != 30) {
                switch (id) {
                    case 0:
                        ThemeSwitcher.doSwitch(this.mTitleBar, next);
                        if (next.getTextColor() != 0) {
                            this.mTitle.setTextColor(next.getTextColor());
                        }
                        if (next.getTextSize() == 0) {
                            break;
                        } else {
                            this.mTitle.setTextSize(1, next.getTextSize());
                            break;
                        }
                    case 1:
                        ThemeSwitcher.doSwitch(this.mRetrun, next);
                        this.mRetrun.setPadding(dimensionPixelOffset * 2, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
                        this.mRetrun.setHeight(getResources().getDimensionPixelOffset(MttResources.getDimensId("thrdcall_back_btn_height")));
                        break;
                    case 2:
                        ThemeSwitcher.doSwitch(this.mMore, next);
                        int i = dimensionPixelOffset * 2;
                        this.mMore.setPadding(i, dimensionPixelOffset, i, dimensionPixelOffset);
                        this.mRetrun.setHeight(getResources().getDimensionPixelOffset(MttResources.getDimensId("thrdcall_back_btn_height")));
                        break;
                    case 3:
                        break;
                    default:
                        switch (id) {
                            case 10:
                                ThemeSwitcher.doSwitch(this.mToolbar, next);
                                break;
                            case 11:
                                ThemeSwitcher.doSwitch(this.mBack, next);
                                break;
                            case 12:
                                ThemeSwitcher.doSwitch(this.mForward, next);
                                break;
                            default:
                                switch (id) {
                                    case 14:
                                        ThemeSwitcher.doSwitch(this.mRefresh, next);
                                        break;
                                    case 15:
                                        ThemeSwitcher.doSwitch(this.mFav, next);
                                        break;
                                    case 16:
                                        ThemeSwitcher.doSwitch(this.mStop, next);
                                        break;
                                }
                        }
                }
            } else {
                ThemeSwitcher.doSwitch((ImageView) this.mSpActivity.findViewById(MttResources.getId("splash_logo")), next);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRetrun) {
            this.mSpActivity.doExit();
            return;
        }
        if (view == this.mMore) {
            showMore();
            return;
        }
        if (view == this.mBack) {
            this.mWebView.back(true);
            return;
        }
        if (view == this.mForward) {
            this.mWebView.forward();
            return;
        }
        if (view == this.mRefresh) {
            this.mWebView.reload();
            return;
        }
        if (view == this.mStop) {
            this.mWebView.stopLoading();
            return;
        }
        if (view == this.mFav) {
            favPage();
            if (ExtraInfo.getExtraFavItem() != null) {
                sendRsp(ExtraInfo.getExtraFavItem(), MttApi.PLUS_RSP);
                return;
            } else {
                Toast.makeText(getContext(), MttResources.getStringId("thrdcall_menu_fav"), 0).show();
                return;
            }
        }
        if (view == this.mPlus) {
            sendRsp(ExtraInfo.getExtraPlusItem(), MttApi.PLUS_RSP);
        }
    }

    public void onSreenOritationChage() {
        DialogSp dialogSp = this.mShareDialog;
        if (dialogSp == null || !dialogSp.isShowing()) {
            return;
        }
        this.mShareDialog.layoutWindow();
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void showMore() {
        getMoreDialog().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        try {
            if (isUrlValid(str)) {
                this.mWebView.loadUrl(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUrl(String str, byte[] bArr) {
        try {
            if (isUrlValid(str)) {
                this.mWebView.postUrl(str, bArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isUrlValid(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        onPageFinished(null, null);
        Toast.makeText(getContext(), MttResources.getStringId("thrdcall_unfetch_url"), 0).show();
        return false;
    }

    private void refreshToolBar() {
        boolean canGoBack = this.mWebView.canGoBack();
        if (canGoBack) {
            this.mBack.setAlpha(255);
        } else {
            this.mBack.setAlpha(128);
        }
        this.mBack.setClickable(canGoBack);
        boolean canGoForward = this.mWebView.canGoForward();
        if (canGoForward) {
            this.mForward.setAlpha(255);
        } else {
            this.mForward.setAlpha(128);
        }
        this.mForward.setClickable(canGoForward);
    }

    private void doAfterStartLoading() {
        this.mProgressBar.setVisibility(0);
        this.mRefresh.setVisibility(8);
        this.mStop.setVisibility(0);
    }

    private void doAfterStop() {
        this.mProgressBar.setVisibility(8);
        this.mStop.setVisibility(8);
        this.mRefresh.setVisibility(0);
    }

    private void doAfterTitleChange(String str) {
        if (ExtraInfo.isEnableChangeTitle()) {
            this.mTitle.setText(str);
        }
    }

    public void destroy() {
        this.mWebView.destroy();
        this.mDestroy = true;
        WebViewSpManager.removeWebView(this.mWebViewId);
        WebViewProxyManager.getInstance().onWebViewDestroy(this.mWebViewId);
    }

    public void deActive() {
        this.mWebView.deactive();
    }

    public void active() {
        this.mWebView.active();
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onReceivedTitle(IWebView iWebView, String str) {
        doAfterTitleChange(str);
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onBackOrForwardChanged(IWebView iWebView) {
        refreshToolBar();
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public boolean shouldOverrideUrlLoading(IWebView iWebView, String str) {
        String str2 = this.mNotifyUrlPrefix;
        if (str2 == null || str == null || !str.startsWith(str2)) {
            return false;
        }
        return WebViewProxyManager.getInstance().shouldOverrideUrlLoading(this.mWebViewId, str);
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onPageStarted(IWebView iWebView, String str, Bitmap bitmap) {
        WebViewProxyManager.getInstance().onPageStarted(this.mWebViewId, str);
        doAfterStartLoading();
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onPageFinished(IWebView iWebView, String str) {
        WebViewProxyManager.getInstance().onPageFinished(this.mWebViewId, str);
        doAfterStop();
        refreshToolBar();
        this.mPv++;
    }

    public int getPv() {
        return this.mPv;
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void onDownload(String str, String str2, String str3, String str4, long j, String str5) {
        ExtendItem downloadItem = ExtraInfo.getDownloadItem();
        if (downloadItem != null) {
            RspContent rspContent = new RspContent(downloadItem.getID(), this.mWebView.getTitle(), this.mWebView.getUrl());
            rspContent.setDownloadInfo(str, str2, str3, str4, j, str5);
            doSendRsp(MttApi.DOWNLOAD_RSP, downloadItem, rspContent);
            return;
        }
        openByBrowser(str);
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onReceivedError(IWebView iWebView, int i, String str, String str2) {
        WebViewProxyManager.getInstance().onReceivedError(this.mWebViewId, i, str, str2);
    }

    private DialogSp getMoreDialog() {
        if (this.mMoreDialog == null) {
            if (ExtraInfo.getMenuStyle() == 0) {
                this.mMoreDialog = new MoreDialogGridView(getContext(), this);
                this.mMoreDialog.getWindow().setGravity(80);
            } else if (ExtraInfo.getMenuStyle() == 1) {
                this.mMoreDialog = new MoreDialogActionSheet(getContext(), this);
                this.mMoreDialog.getWindow().setGravity(80);
            }
        }
        return this.mMoreDialog;
    }

    private DialogSp getShareDialog(String str) {
        if (str == null) {
            str = this.mWebView.getUrl();
        }
        if (this.mShareDialog == null) {
            this.mShareDialog = new ShareDialogSp(getContext(), this);
        }
        ((ShareDialogSp) this.mShareDialog).setShareUrl(str);
        return this.mShareDialog;
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void sharePage(String str) {
        getShareDialog(str).show();
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void favPage() {
        if (ExtraInfo.getExtraParams() != null) {
            try {
                CollectManager.getInstane().addFavoriteUrl(this.mWebView.getTitle(), this.mWebView.getUrl(), ExtraInfo.getExtraParams().getString(RecommendParams.KEY_UIN), ExtraInfo.getExtraParams().getString(IR.unifiedAccount.UNIFIED_ACCOUNT_SESSION_ID), ExtraInfo.getExtraParams().getInt(WebViewManager.KEY_JS_CHANNEL));
            } catch (Exception e) {
                e.printStackTrace();
            } catch (NoClassDefFoundError e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void saveFlow() {
        new AlertDialog.Builder(getContext()).setTitle(getResources().getString(MttResources.getStringId("thrdcall_recom_mtt_title"))).setMessage(getResources().getString(MttResources.getStringId("thrdcall_recom_mtt_content"))).setNegativeButton(getResources().getString(MttResources.getStringId("thrdcall_cancel")), new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(getResources().getString(MttResources.getStringId("thrdcall_confirm")), new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BrowserWindowSP.this.openUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=");
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void fitScreen() {
        this.mWebView.reload();
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void copyLink() {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setText(this.mWebView.getUrl());
        Toast.makeText(getContext(), MttResources.getStringId("thrdcall_copy_sucsess"), 0).show();
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openByMtt(String str) {
        String validUrl = getValidUrl(str);
        if (TextUtils.isEmpty(validUrl)) {
            Toast.makeText(getContext(), MttResources.getStringId("thrdcall_unfetch_url"), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(validUrl));
        intent.setAction("com.tencent.QQBrowser.action.VIEW");
        try {
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            new AlertDialog.Builder(getContext()).setTitle(getResources().getString(MttResources.getStringId("thrdcall_recom_mtt_title"))).setMessage(getResources().getString(MttResources.getStringId("thrdcall_recom_mtt_content"))).setNegativeButton(getResources().getString(MttResources.getStringId("thrdcall_cancel")), new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setPositiveButton(getResources().getString(MttResources.getStringId("thrdcall_confirm")), new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    BrowserWindowSP.this.openUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=");
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void downloadVideoByMtt(String str, String str2, String str3, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.QQBrowser.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.putExtra("VIDEO_URL", str);
        intent.putExtra("VIDEO_REFER_URL", str2);
        intent.putExtra("VIDEO_TITLE", str3);
        intent.putExtra("VIDEO_LENGTH", i);
        intent.putExtra("VIDEO_TYPE", i2);
        getContext().startActivity(intent);
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openByBrowser(String str) {
        try {
            String validUrl = getValidUrl(str);
            if (TextUtils.isEmpty(validUrl)) {
                Toast.makeText(getContext(), MttResources.getStringId("thrdcall_unfetch_url"), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(validUrl));
            intent.setAction("android.intent.action.VIEW");
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doSendRsp(String str, ExtendItem extendItem, RspContent rspContent) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(str, rspContent);
        intent.putExtras(bundle);
        try {
            intent.setComponent(extendItem.getComponentName());
            getContext().startActivity(intent);
        } catch (Exception unused) {
            this.mSpActivity.setResult(MttApi.RESULT_SHARE_RSP, intent);
            this.mSpActivity.doExit();
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void sendRsp(ExtendItem extendItem, String str) {
        if (extendItem != null) {
            String desUrl = extendItem.getDesUrl();
            if (!TextUtils.isEmpty(desUrl)) {
                openInternalUrl(desUrl);
            } else {
                initRspIntent(extendItem, str, extendItem.isNeedSnapshot() ? MttCtrlUtil.getScaleBitmap(this.mWebView.snapshotWholePage(this.mWebThumbWidth, this.mWebThumbHeight, IWebView.RatioRespect.RESPECT_WIDTH, 1), this.mWebThumbWidth, this.mWebThumbHeight, true, true, Bitmap.Config.RGB_565) : null);
            }
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openInternalUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWebView.loadUrl(str);
    }

    private void initRspIntent(ExtendItem extendItem, String str, Bitmap bitmap) {
        File saveBitmap;
        try {
            String str2 = String.valueOf(QR_CATCH_PATH) + "/" + System.currentTimeMillis() + ".png";
            Intent intent = new Intent();
            String str3 = null;
            if (bitmap != null && (saveBitmap = saveBitmap(str2, bitmap)) != null) {
                str3 = saveBitmap.getAbsolutePath();
            }
            RspContent rspContent = new RspContent(extendItem.getID(), this.mWebView.getTitle(), this.mWebView.getUrl());
            rspContent.setImagePath(str3);
            Bundle bundle = new Bundle();
            bundle.putSerializable(str, rspContent);
            intent.putExtras(bundle);
            try {
                intent.setComponent(extendItem.getComponentName());
                getContext().startActivity(intent);
            } catch (Exception unused) {
                this.mSpActivity.setResult(MttApi.RESULT_SHARE_RSP, intent);
                this.mSpActivity.doExit();
            }
        } catch (Exception unused2) {
        }
    }

    private String getValidUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String url = this.mWebView.getUrl();
        return TextUtils.isEmpty(url) ? this.mEntryUrl : url;
    }

    private File saveBitmap(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            File file = new File(str);
            file.createNewFile();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return file;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void requesetFullScreen() {
        Activity activity = (Activity) getContext();
        if (activity != null) {
            activity.getWindow().setFlags(1024, 1024);
            activity.setRequestedOrientation(0);
            this.mTitleBar.setVisibility(8);
            this.mToolbar.setVisibility(8);
            this.mToolBarHolder.setVisibility(8);
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void exitFullScreen() {
        Activity activity = (Activity) getContext();
        activity.getWindow().clearFlags(1024);
        activity.setRequestedOrientation(-1);
        this.mTitleBar.setVisibility(0);
        this.mToolbar.setVisibility(0);
        this.mToolBarHolder.setVisibility(0);
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void exiteBrowser() {
        this.mSpActivity.doExit();
    }

    public void back() {
        this.mWebView.loadUrl("javascript:try { if(typeof(eval(window.back))==\"function\"){window.back();}else {history.go(-1);}}catch(e){history.go(-1); } ");
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void showImageSaveDialog(String str, Bitmap bitmap) {
        Dialog imageSaveDialogPupUp;
        if (ExtraInfo.getMenuStyle() == 1) {
            imageSaveDialogPupUp = new ImageSaveDialogActionSheet(getContext(), null, bitmap, str);
        } else {
            imageSaveDialogPupUp = new ImageSaveDialogPupUp(getContext(), bitmap, str);
        }
        imageSaveDialogPupUp.show();
    }

    /* loaded from: classes.dex */
    private static class ImageSaveDialogPupUp extends Dialog {
        public ImageSaveDialogPupUp(Context context, final Bitmap bitmap, final String str) {
            super(context);
            Window window = getWindow();
            window.addFlags(2);
            window.clearFlags(Constants.MB);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            setTitle(MttResources.getStringId("thrdcall_save_pic_title"));
            setCanceledOnTouchOutside(true);
            Resources resources = AppEngine.getInstance().getContext().getResources();
            TextView textView = new TextView(AppEngine.getInstance().getContext());
            textView.setClickable(true);
            textView.setText(MttResources.getStringId("thrdcall_save_pic_item"));
            textView.setTextColor(resources.getColor(MttResources.getColorId("thrdcall_black")));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_focused}, resources.getDrawable(R.color.holo_orange_light));
            stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, resources.getDrawable(R.color.holo_orange_light));
            stateListDrawable.addState(new int[0], resources.getDrawable(R.color.white));
            textView.setBackgroundDrawable(stateListDrawable);
            int dimension = (int) resources.getDimension(MttResources.getDimensId("thrdcall_more_text_leftmargin"));
            int i = dimension * 2;
            textView.setPadding(dimension, i, dimension, i);
            textView.setTextSize(1, 16.0f);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.ImageSaveDialogPupUp.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SpecialCallUtility.saveImage(str, bitmap);
                    ImageSaveDialogPupUp.this.dismiss();
                }
            });
            addContentView(textView, new RelativeLayout.LayoutParams(-1, -2));
        }

        @Override // android.app.Dialog
        public void show() {
            super.show();
            getWindow().setLayout((int) (BrowserWindowSP.sWidth * 0.8f), -2);
        }
    }

    /* loaded from: classes.dex */
    private static class ImageSaveDialogActionSheet extends MoreDialogActionSheet {
        private Bitmap mBitmap;
        private String mUrl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mtt.spcialcall.DialogSp
        public void addExtendItems() {
        }

        public ImageSaveDialogActionSheet(Context context, IWebViewClientSp iWebViewClientSp, Bitmap bitmap, String str) {
            super(context, iWebViewClientSp);
            this.mBitmap = bitmap;
            this.mUrl = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mtt.spcialcall.DialogSp
        public void addSystemItems() {
            this.mMoreItems.add(new ExtendItem(0, this.mRes.getString(MttResources.getStringId("thrdcall_save_pic_item"))));
        }

        @Override // com.tencent.mtt.spcialcall.MoreDialogActionSheet, android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof ExtendItem) {
                ExtendItem extendItem = (ExtendItem) view.getTag();
                if (extendItem.getID() == 0 && extendItem.getLabel().toString().equals(this.mRes.getString(MttResources.getStringId("thrdcall_save_pic_item")))) {
                    SpecialCallUtility.saveImage(this.mUrl, this.mBitmap);
                }
            }
            dismiss();
        }
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openReadMode() {
        new AlertDialog.Builder(getContext()).setTitle(getResources().getString(MttResources.getStringId("thrdcall_recom_mtt_title"))).setMessage(getResources().getString(MttResources.getStringId("thrdcall_recom_mtt_content"))).setNegativeButton(getResources().getString(MttResources.getStringId("thrdcall_cancel")), new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(getResources().getString(MttResources.getStringId("thrdcall_confirm")), new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.spcialcall.BrowserWindowSP.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BrowserWindowSP.this.openUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=");
                dialogInterface.dismiss();
            }
        }).show();
    }
}
