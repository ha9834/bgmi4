package com.tencent.grobot.lite.recommends;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GRobotEnterManager;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.BitmapPools;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.GiftNode;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.search.SearchSlice;
import com.tencent.grobot.lite.ui.IM;
import com.tencent.grobot.lite.ui.container.Frame;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.Router;
import com.tencent.grobot.lite.ui.dialog.DialogContainer;
import com.tencent.grobot.lite.ui.dialog.LoadingDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class Feeds extends Frame implements View.OnClickListener, ISliceListener {
    public static final int TAB_RECOMMANDS = 0;
    public static final int TAB_SEARCH = 2;
    public static final int TAB_VIDEO = 1;
    private static final String TAG = "Feeds";
    NavigationReqState curNavigationState;
    private int curTab;
    private final FeedTagUnableDrawable feedTagUnableDrawable;
    private boolean firstShow;
    private FrameLayout flMsg;
    private View flRecommands;
    private FrameLayout flSlices;
    private View flVideos;
    private boolean hasCreate;
    private boolean hasInited;
    private ImageView ivGift;
    private ImageView ivTagBand;
    private ImageView ivTagBg;
    private LinearLayout llTags;
    private LoadingDialog loadingDialog;
    private boolean msgFirstClick;
    private String msgInitStr;
    private NavigationSlice navigationSlice;
    private final FeedsPresenter presenter;
    NavigationReqState reqNavigationState;
    private RelativeLayout rlTags;
    private SearchSlice searchSlice;
    private SplashSlice splashSlice;
    private long startTime;
    int tagLayoutWidth;
    int tagLayoutWidthIncludeMargin;
    private DialogContainer topContainer;
    private TextView tvMsg;
    private TextView tvRecommands;
    private TextView tvRedDot;
    private TextView tvVideos;
    private ImageView vClose;
    private View vDivider;

    public Feeds(FrameActivity frameActivity, Bundle bundle) {
        super(frameActivity, bundle);
        this.curNavigationState = new NavigationReqState();
        this.reqNavigationState = new NavigationReqState();
        this.curTab = -1;
        this.hasCreate = false;
        this.hasInited = false;
        this.firstShow = true;
        this.msgInitStr = "";
        this.msgFirstClick = true;
        this.startTime = 0L;
        this.presenter = new FeedsPresenter(this);
        this.feedTagUnableDrawable = new FeedTagUnableDrawable(frameActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public View view() {
        this.topContainer = new DialogContainer(this.context);
        this.topContainer.setBackground(new BitmapDrawable(this.context.getResources(), BitmapPools.getInstance().decodeResource(this.context, ViewUtils.getScreenAspectRatio(this.context) > 2.0f ? R.mipmap.bg_feed_16_10 : R.mipmap.bg_feed_16_9)));
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.feeds, (ViewGroup) this.topContainer, true);
        this.flRecommands = inflate.findViewById(R.id.fl_recommands);
        this.flRecommands.setOnClickListener(this);
        this.tvRecommands = (TextView) inflate.findViewById(R.id.tv_recommands);
        this.flVideos = inflate.findViewById(R.id.fl_videos);
        this.flVideos.setBackground(this.feedTagUnableDrawable);
        this.flVideos.setOnClickListener(this);
        this.tvVideos = (TextView) inflate.findViewById(R.id.tv_videos);
        this.flSlices = (FrameLayout) inflate.findViewById(R.id.fl_slice);
        this.vClose = (ImageView) inflate.findViewById(R.id.iv_close);
        this.vClose.setOnClickListener(this);
        this.vDivider = inflate.findViewById(R.id.v_divider);
        this.llTags = (LinearLayout) inflate.findViewById(R.id.ll_tags);
        this.ivTagBand = (ImageView) inflate.findViewById(R.id.iv_tag_band);
        this.ivTagBand.setImageBitmap(BitmapPools.getInstance().decodeResource(this.context, R.mipmap.feed_tag_band));
        this.ivTagBand.setOnClickListener(this);
        this.ivTagBg = (ImageView) inflate.findViewById(R.id.iv_feed_tag_bg);
        this.ivTagBg.setImageBitmap(BitmapPools.getInstance().decodeResource(this.context, R.mipmap.bg_feed_tag));
        inflate.findViewById(R.id.fl_tag_ask).setOnClickListener(this);
        this.tvRedDot = (TextView) inflate.findViewById(R.id.splash_red_dot);
        this.flMsg = (FrameLayout) inflate.findViewById(R.id.feed_msg);
        this.tvMsg = (TextView) inflate.findViewById(R.id.tv_tip_msg);
        this.tvMsg.setOnClickListener(this);
        this.ivGift = (ImageView) inflate.findViewById(R.id.iv_gift);
        this.ivGift.setOnClickListener(this);
        this.rlTags = (RelativeLayout) inflate.findViewById(R.id.rl_tags);
        this.tagLayoutWidth = ViewUtils.dip2px(this.context, 129.0f);
        this.tagLayoutWidthIncludeMargin = this.tagLayoutWidth;
        this.topContainer.addExceptId(R.id.iv_close);
        this.topContainer.addExceptId(R.id.ll_tags);
        return this.topContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onResume() {
        this.presenter.onResume();
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onPause() {
        this.presenter.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onDestroy() {
        realDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onAttachedToWindow() {
        realCreate();
        fixNotchScreen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.container.Frame
    public void onScreenOrientChange(int i) {
        fixNotchScreen();
        SplashSlice splashSlice = this.splashSlice;
        if (splashSlice != null) {
            splashSlice.fixNotchScreen();
        }
        NavigationSlice navigationSlice = this.navigationSlice;
        if (navigationSlice != null) {
            navigationSlice.fixNotchScreen();
        }
        SearchSlice searchSlice = this.searchSlice;
        if (searchSlice != null) {
            searchSlice.fixNotchScreen();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.fl_recommands) {
            changeTab(0, true);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_MODULE_ID, "30010");
                ReportBridge.report(jSONObject, false);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (id == R.id.fl_videos) {
            changeTab(1, true);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject2.put(ReportBridge.KEY_MODULE_ID, "30011");
                ReportBridge.report(jSONObject2, false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (id == R.id.iv_close) {
            this.context.onBackPressed();
            return;
        }
        if ((id == R.id.iv_tag_band || id == R.id.fl_tag_ask || id == R.id.iv_gift || id == R.id.tv_tip_msg) && !ViewUtils.isFastClick()) {
            this.presenter.clearRedPoint();
            this.flMsg.setVisibility(8);
            gotoIm("");
            Report itemId = new Report().eventType("1002").itemId("7155");
            if (id == R.id.iv_gift) {
                itemId.indexId("7003");
            } else if (id == R.id.tv_tip_msg) {
                itemId.indexId("7002");
            } else {
                itemId.indexId("7001");
            }
            itemId.report(false);
        }
    }

    private void realCreate() {
        if (this.hasCreate) {
            return;
        }
        changeTab(this.args.getInt("default_tab", 0), false);
        init();
        this.hasCreate = true;
        TLog.d(TAG, "realCreate");
    }

    private void realDestroy() {
        if (this.startTime != 0) {
            long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", currentTimeMillis);
                new Report().eventType("1002").itemId("7167").ext(jSONObject.toString()).report(false);
            } catch (JSONException e) {
                TLog.d(TAG, "report duration failed," + e);
            }
        }
        this.topContainer.onDestroy();
        this.presenter.onDestroy();
        this.ivTagBand.setImageBitmap(null);
        this.ivTagBg.setImageBitmap(null);
        GRobotApplication.getInstance().setBackground(true);
        GRobotEnterManager.onClose();
        SystemUtils.doGC();
        GRobotEnterManager.closeGRobtoView(this.context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInitLoadedFinish(int i, boolean z, JSONObject jSONObject, ArrayList<BaseNode> arrayList, String str) {
        if (this.firstShow) {
            this.firstShow = false;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject2.put(ReportBridge.KEY_MODULE_ID, "30010");
                ReportBridge.report(jSONObject2, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (jSONObject != null) {
            updateEntranceView(jSONObject, arrayList, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onGetRecommendResult(int i, String str, List<RecommendsInfo> list) {
        this.loadingDialog.dismiss();
        if (i == 0) {
            if (this.curTab != 0) {
                changeTab(0, true);
            }
            this.splashSlice.start(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetNavigationResult, code=");
        sb.append(i2);
        sb.append(", msg=");
        sb.append(str);
        sb.append(", size=");
        sb.append(navigationInfo == null ? 0 : navigationInfo.items.size());
        TLog.d(TAG, sb.toString());
        this.loadingDialog.dismiss();
        if (i2 == 0) {
            if (TextUtils.isEmpty(this.reqNavigationState.tag)) {
                if (navigationInfo.tags != null && !navigationInfo.tags.isEmpty()) {
                    TagInfo tagInfo = navigationInfo.tags.get(0);
                    this.reqNavigationState.tag = tagInfo.id;
                    if (tagInfo.subs != null && !tagInfo.subs.isEmpty()) {
                        this.reqNavigationState.subTag = tagInfo.subs.get(0).id;
                    }
                }
                boolean z2 = this.reqNavigationState.page > 1;
                setNavigationReqStateValue(this.curNavigationState, this.reqNavigationState.tag, this.reqNavigationState.subTag, this.reqNavigationState.order, this.reqNavigationState.page, navigationInfo.items.isEmpty());
                setNavigationReqStateValue(this.reqNavigationState, null, null, 1, 1, false);
                z = z2;
            } else {
                if (i != this.reqNavigationState.seq) {
                    return;
                }
                z = this.reqNavigationState.page > 1;
                setNavigationReqStateValue(this.curNavigationState, this.reqNavigationState.tag, this.reqNavigationState.subTag, this.reqNavigationState.order, this.reqNavigationState.page, navigationInfo.items.isEmpty());
                this.curNavigationState.seq = i;
                setNavigationReqStateValue(this.reqNavigationState, null, null, 1, 1, false);
            }
            if (this.curTab != 1) {
                changeTab(1, true);
            }
            this.navigationSlice.start(navigationInfo, Boolean.valueOf(z));
            return;
        }
        this.curNavigationState.isEnd = false;
        this.navigationSlice.start(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClearRedPointResult(int i, String str) {
        if (i == 0) {
            this.tvRedDot.setVisibility(8);
        }
    }

    private void changeTab(int i, boolean z) {
        if (i == 0) {
            this.flRecommands.setBackgroundResource(R.drawable.bg_feeds_tab_enable);
            this.tvRecommands.setTextColor(a.c(this.context, R.color.feeds_tag_highlight));
            this.flVideos.setBackground(this.feedTagUnableDrawable);
            this.tvVideos.setTextColor(a.c(this.context, R.color.feeds_tag_normal));
        } else if (i != 2) {
            this.flRecommands.setBackground(this.feedTagUnableDrawable);
            this.tvRecommands.setTextColor(a.c(this.context, R.color.feeds_tag_normal));
            this.flVideos.setBackgroundResource(R.drawable.bg_feeds_tab_enable);
            this.tvVideos.setTextColor(a.c(this.context, R.color.feeds_tag_highlight));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_MODULE_ID, "30011");
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!z || this.curTab == i) {
            return;
        }
        changeSlice(i);
        this.curTab = i;
    }

    private void changeSlice(int i) {
        Slice slice;
        FrameLayout.LayoutParams layoutParams;
        if (i == 0) {
            if (this.splashSlice == null) {
                this.splashSlice = new SplashSlice(this);
                SplashSlice splashSlice = this.splashSlice;
                splashSlice.v = splashSlice.view();
            }
            slice = this.splashSlice;
            NavigationSlice navigationSlice = this.navigationSlice;
            if (navigationSlice != null) {
                navigationSlice.stop(new Object[0]);
            }
            SearchSlice searchSlice = this.searchSlice;
            if (searchSlice != null) {
                searchSlice.stop(new Object[0]);
            }
        } else if (i == 2) {
            if (this.searchSlice == null) {
                this.searchSlice = new SearchSlice(this);
                SearchSlice searchSlice2 = this.searchSlice;
                searchSlice2.v = searchSlice2.view();
                this.searchSlice.setISliceListener(this);
            }
            slice = this.searchSlice;
            NavigationSlice navigationSlice2 = this.navigationSlice;
            if (navigationSlice2 != null) {
                navigationSlice2.stop(new Object[0]);
            }
            SplashSlice splashSlice2 = this.splashSlice;
            if (splashSlice2 != null) {
                splashSlice2.stop(new Object[0]);
            }
            this.searchSlice.start(new Object[0]);
        } else {
            if (this.navigationSlice == null) {
                this.navigationSlice = new NavigationSlice(this);
                this.navigationSlice.setISliceListener(this);
                NavigationSlice navigationSlice3 = this.navigationSlice;
                navigationSlice3.v = navigationSlice3.view();
            }
            slice = this.navigationSlice;
            SplashSlice splashSlice3 = this.splashSlice;
            if (splashSlice3 != null) {
                splashSlice3.stop(new Object[0]);
            }
            SearchSlice searchSlice3 = this.searchSlice;
            if (searchSlice3 != null) {
                searchSlice3.stop(new Object[0]);
            }
            if (TextUtils.isEmpty(this.curNavigationState.tag)) {
                ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.recommends.Feeds.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Feeds feeds = Feeds.this;
                        feeds.getNavigation(null, null, feeds.curNavigationState.order, 1, true);
                    }
                });
            }
        }
        this.flSlices.removeAllViews();
        if (slice.v.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) slice.v.getLayoutParams();
            layoutParams.width = slice.width();
            layoutParams.height = slice.height();
        } else {
            layoutParams = new FrameLayout.LayoutParams(slice.width(), slice.height());
        }
        layoutParams.gravity = 1;
        this.flSlices.addView(slice.v, layoutParams);
        slice.fixNotchScreen();
    }

    private void init() {
        if (this.hasInited) {
            return;
        }
        ThreadManager.get().postToUiThread(new InitRunnable(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getNavigation(String str, String str2, int i, int i2, boolean z) {
        if (z) {
            checkLoadingDialogReady();
            this.loadingDialog.attach(false);
        }
        setNavigationReqStateValue(this.reqNavigationState, str, str2, i, i2, false);
        int navigation = this.presenter.getNavigation(str, str2, i, i2);
        NavigationReqState navigationReqState = this.reqNavigationState;
        if (TextUtils.isEmpty(navigationReqState.tag)) {
            navigation = -1;
        }
        navigationReqState.seq = navigation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLoadingDialogReady() {
        if (this.loadingDialog == null) {
            this.loadingDialog = new LoadingDialog(this.topContainer);
        }
    }

    private void setNavigationReqStateValue(NavigationReqState navigationReqState, String str, String str2, int i, int i2, boolean z) {
        navigationReqState.tag = str;
        navigationReqState.subTag = str2;
        navigationReqState.order = i;
        navigationReqState.page = i2;
        navigationReqState.isEnd = z;
    }

    private void fixNotchScreen() {
        if (SystemUtils.hasNotch(this.context)) {
            int rotation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
            boolean z = LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1;
            TLog.d(TAG, "fixNotchScreen, padding=" + SystemUtils.getStatusBarHeight(this.context) + ", rotation=" + rotation + ", rtl=" + z);
            if (rotation == 1) {
                if (!z) {
                    mergeNotchTabContainer(true);
                    return;
                } else {
                    mergeNotchTabContainerRtl(true);
                    return;
                }
            }
            if (!z) {
                mergeNotchTabContainer(false);
            } else {
                mergeNotchTabContainerRtl(false);
            }
        }
    }

    private void mergeNotchTabContainer(boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            i = Build.VERSION.SDK_INT >= 28 ? SystemUtils.getSafeInsetLeft(this.context) : SystemUtils.getStatusBarHeight(this.context);
        } else {
            i = 0;
        }
        if (!z) {
            i2 = Build.VERSION.SDK_INT >= 28 ? SystemUtils.getSafeInsetRight(this.context) : SystemUtils.getStatusBarHeight(this.context);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.rlTags.getLayoutParams();
        marginLayoutParams.width = this.tagLayoutWidth + i2;
        this.rlTags.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.llTags.getLayoutParams();
        marginLayoutParams2.setMarginEnd(i2);
        this.llTags.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.flSlices.getLayoutParams();
        marginLayoutParams3.setMarginEnd((this.tagLayoutWidth + i2) - ViewUtils.dip2px(this.context, 6.0f));
        this.flSlices.setLayoutParams(marginLayoutParams3);
        this.tagLayoutWidthIncludeMargin = z ? this.tagLayoutWidth + i : this.tagLayoutWidth + i2;
    }

    private void mergeNotchTabContainerRtl(boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            i = 0;
        } else {
            i = Build.VERSION.SDK_INT >= 28 ? SystemUtils.getSafeInsetRight(this.context) : SystemUtils.getStatusBarHeight(this.context);
        }
        if (z) {
            i2 = Build.VERSION.SDK_INT >= 28 ? SystemUtils.getSafeInsetLeft(this.context) : SystemUtils.getStatusBarHeight(this.context);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.rlTags.getLayoutParams();
        marginLayoutParams.width = this.tagLayoutWidth + i2;
        this.rlTags.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.llTags.getLayoutParams();
        marginLayoutParams2.setMarginEnd(i2);
        this.llTags.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.flSlices.getLayoutParams();
        marginLayoutParams3.setMarginEnd((this.tagLayoutWidth + i2) - ViewUtils.dip2px(this.context, 6.0f));
        this.flSlices.setLayoutParams(marginLayoutParams3);
        this.tagLayoutWidthIncludeMargin = !z ? this.tagLayoutWidth + i : this.tagLayoutWidth + i2;
    }

    public void updateEntranceView(JSONObject jSONObject, ArrayList<BaseNode> arrayList, String str) {
        updateUnreadNum(jSONObject.optInt("unreadMsgNum"));
        String optString = jSONObject.optString("setId");
        this.flMsg.setVisibility(8);
        this.ivGift.setVisibility(8);
        this.tvMsg.setVisibility(8);
        this.msgInitStr = str;
        if ("999999".equals(optString)) {
            Iterator<BaseNode> it = arrayList.iterator();
            AnsTextNode ansTextNode = null;
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                BaseNode next = it.next();
                if (next instanceof GiftNode) {
                    z = true;
                }
                if (next instanceof AnsTextNode) {
                    ansTextNode = (AnsTextNode) next;
                    z2 = true;
                }
            }
            if (z) {
                this.flMsg.setVisibility(0);
                this.ivGift.setVisibility(0);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7155");
                    jSONObject2.put(ReportBridge.KEY_INDEX_ID, "7003");
                    ReportBridge.report(jSONObject2, true);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (z2) {
                SpannableStringBuilder parseRichText = ansTextNode.parseRichText(ansTextNode.rawText, ansTextNode.actionUrl, ansTextNode.linkWord);
                if (parseRichText != null) {
                    this.tvMsg.setText(parseRichText);
                }
                this.flMsg.setVisibility(0);
                this.tvMsg.setVisibility(0);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject3.put(ReportBridge.KEY_ITEM_ID, "7155");
                    jSONObject3.put(ReportBridge.KEY_INDEX_ID, "7002");
                    ReportBridge.report(jSONObject3, true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void updateUnreadNum(int i) {
        if (i > 0) {
            this.tvRedDot.setVisibility(0);
            this.tvRedDot.setText(String.valueOf(i));
        } else {
            this.tvRedDot.setVisibility(8);
        }
    }

    private void gotoIm(String str) {
        Bundle bundle = new Bundle();
        if (this.msgFirstClick) {
            bundle.putString(Router.ARGS_INIT_DATA, this.msgInitStr);
            this.msgFirstClick = false;
            this.msgInitStr = "";
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(Router.ARGS_INIT_QUES, str);
        }
        Router.jump(this.context, IM.class, bundle, false, true);
    }

    @Override // com.tencent.grobot.lite.recommends.ISliceListener
    public void changeTab(int i) {
        changeTab(i, true);
    }

    @Override // com.tencent.grobot.lite.recommends.ISliceListener
    public void jumpToIm(String str) {
        gotoIm(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class InitRunnable implements Runnable {
        private final WeakReference<Feeds> targetPtr;

        InitRunnable(Feeds feeds) {
            this.targetPtr = new WeakReference<>(feeds);
        }

        @Override // java.lang.Runnable
        public void run() {
            Feeds feeds = this.targetPtr.get();
            if (feeds == null || feeds.hasInited) {
                return;
            }
            feeds.checkLoadingDialogReady();
            feeds.loadingDialog.attach(false);
            feeds.presenter.init();
            feeds.hasInited = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class NavigationReqState {
        public String subTag;
        public String tag;
        public int seq = -1;
        public int order = 1;
        public int page = -1;
        public boolean isEnd = false;

        NavigationReqState() {
        }
    }
}
