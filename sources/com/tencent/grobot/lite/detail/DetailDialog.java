package com.tencent.grobot.lite.detail;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.games.GamesStatusCodes;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.DetailInfo;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;
import com.tencent.grobot.lite.youtube.YoutubeParams;
import com.tencent.grobot.lite.youtube.YoutubePlayerDelegate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DetailDialog extends FrameDialog implements IDetailDialog {
    private static final String TAG = "DetailDialog";
    public static final String TAG_A = "0";
    public static final String TAG_B = "1";
    public static final String TAG_NAVI = "2";
    public static final String TAG_Search = "4";
    public static final String TAG_Sec = "3";
    private ImageView closeIcon;
    private TextView contentTitle;
    private boolean firstScroll;
    private int likeCount;
    private boolean liked;
    private DetailRecommendAdapter mAdapter;
    private RecommendsInfo.Item mDetailInfo;
    private DetailRecommendPresenter mPresenter;
    private ListView recommendContent;
    private TextView recommendTitle;
    private int reportIndex;
    private String reportType;
    private LinearLayout rootContent;
    private View rootView;
    private View scrollView;
    private long startTime;
    private String subTagId;
    private String tagId;
    private View vVote;

    public DetailDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.mPresenter = new DetailRecommendPresenter(this);
        this.firstScroll = true;
        this.tagId = "";
        this.subTagId = "";
        this.vVote = null;
        this.liked = false;
        this.likeCount = 0;
        this.reportType = null;
        this.reportIndex = 0;
        this.startTime = 0L;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_detail, (ViewGroup) this, false);
        this.scrollView = this.rootView.findViewById(R.id.contentLayout);
        if (Build.VERSION.SDK_INT >= 23) {
            this.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.grobot.lite.detail.DetailDialog.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (DetailDialog.this.firstScroll) {
                        DetailDialog.this.firstScroll = false;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (DetailDialog.this.mDetailInfo.type == 11) {
                                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, NativeContentAd.ASSET_LOGO);
                                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7153");
                                jSONObject.put(ReportBridge.KEY_SUB_ID, DetailDialog.this.mDetailInfo.resourceId);
                                ReportBridge.report(jSONObject, false);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        this.contentTitle = (TextView) this.rootView.findViewById(R.id.content_title);
        ViewUtils.setBoldTypeface(this.context, this.contentTitle);
        this.rootContent = (LinearLayout) this.rootView.findViewById(R.id.content);
        this.closeIcon = (ImageView) this.rootView.findViewById(R.id.closeBtn);
        this.recommendTitle = (TextView) this.rootView.findViewById(R.id.recommend_title);
        ViewUtils.setBoldTypeface(this.context, this.recommendTitle);
        this.recommendTitle.setText(R.string.detail_trends);
        this.recommendContent = (ListView) this.rootView.findViewById(R.id.recommend_content);
        this.mAdapter = new DetailRecommendAdapter(this.context);
        this.recommendContent.setAdapter((ListAdapter) this.mAdapter);
        this.recommendContent.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.grobot.lite.detail.DetailDialog.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DetailDialog.this.mAdapter.setSelectedPos(i);
                RecommendsInfo.Item item = DetailDialog.this.mAdapter.getItem(i);
                if (item != null) {
                    DetailDialog.this.updateContentView(item);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7042");
                    if (item.type == 10) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    } else if (item.type == 11) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    }
                    jSONObject.put(ReportBridge.KEY_SUB_ID, item.resourceId);
                    jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED));
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                DetailDialog.this.reportType = "3";
                DetailDialog.this.reportIndex = 0;
            }
        });
        this.closeIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.detail.DetailDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailDialog.this.dismissCustomDialog();
            }
        });
        return this.rootView;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.ll_vote || this.vVote == null) {
            return;
        }
        this.mPresenter.setLikeRecommend(this.mDetailInfo, !this.liked);
        new Report().eventType("1002").itemId(!this.liked ? "7164" : "7165").itemSub1(this.mDetailInfo.type == 10 ? "3" : "1").subId(this.mDetailInfo.resourceId).report(false);
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    public void showCustomDialog() {
        super.showCustomDialog();
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    public void showCustomDialog(boolean z, int i, int i2, int i3) {
        super.showCustomDialog(z, i, i2, i3);
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    public void dismissCustomDialog() {
        super.dismissCustomDialog();
        if (this.startTime != 0) {
            long currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", currentTimeMillis);
                new Report().eventType("1002").itemId("7166").ext(jSONObject.toString()).report(false);
            } catch (JSONException e) {
                TLog.d(TAG, "report duration failed," + e);
            }
        }
    }

    public void setData(RecommendsInfo.Item item, String str, String str2, String str3, int i) {
        this.tagId = str;
        this.subTagId = str2;
        this.mAdapter.setSelectedPos(-1);
        this.mAdapter.setData(null);
        updateContentView(item);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            if (item.type == 10) {
                jSONObject.put(ReportBridge.KEY_MODULE_ID, "30012");
            } else if (item.type == 11) {
                jSONObject.put(ReportBridge.KEY_MODULE_ID, "30013");
            }
            ReportBridge.report(jSONObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.reportType = str3;
        this.reportIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContentView(RecommendsInfo.Item item) {
        if (item == null) {
            dismissCustomDialog();
            return;
        }
        this.mDetailInfo = item;
        if (item.type == 10) {
            buildVideoContentView(this.mDetailInfo);
        } else if (item.type == 11) {
            buildTipContentView(this.mDetailInfo);
        }
        fetchRecommendInfo(this.mDetailInfo, this.tagId, this.subTagId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.widget.ImageView] */
    private void buildTipContentView(RecommendsInfo.Item item) {
        ?? textView;
        LinearLayout.LayoutParams layoutParams;
        if (item == null) {
            return;
        }
        this.rootContent.removeAllViews();
        this.rootContent.setBackgroundResource(R.drawable.bg_item_detail_video);
        this.rootContent.setPadding(ViewUtils.dip2px(this.context, 10.0f), 0, ViewUtils.dip2px(this.context, 10.0f), 0);
        clearVote();
        this.contentTitle.setText(item.name);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_detail_tips, (ViewGroup) this.rootContent, true);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_views);
        if (LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1) {
            textView2.setTextDirection(4);
        }
        textView2.setText(ToolUtils.getViewsAndTimeString(this.context, item.views, item.updateTime * 1000));
        this.vVote = inflate.findViewById(R.id.ll_vote);
        for (MixTipInfo.Item item2 : item.tips) {
            if (item2.type == 0) {
                textView = new ImageView(this.context);
                layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(this.context, 143.0f));
                layoutParams.gravity = 1;
                textView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ImageBridge.loadImage(this.context, item2.source, R.drawable.bg_defualt_image, -1, 0, textView);
            } else {
                textView = new TextView(this.context);
                textView.setTextSize(2, 11.0f);
                textView.setTextColor(this.context.getResources().getColor(R.color.dialog_detail_views_normal));
                textView.setText(item2.source);
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = ViewUtils.dip2px(this.context, 5.0f);
                ViewUtils.setBoldTypeface(this.context, textView);
            }
            this.rootContent.addView(textView, layoutParams);
        }
        this.rootContent.addView(new TextView(this.context), new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(this.context, 10.0f)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7153");
            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
            jSONObject.put(ReportBridge.KEY_SUB_ID, item.resourceId);
            ReportBridge.report(jSONObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildVideoContentView(final RecommendsInfo.Item item) {
        if (item == null) {
            return;
        }
        this.rootContent.removeAllViews();
        this.rootContent.setBackgroundResource(0);
        this.rootContent.setPadding(0, 0, 0, 0);
        clearVote();
        this.contentTitle.setVisibility(0);
        this.contentTitle.setText(item.name);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_detail_video, (ViewGroup) this.rootContent, true);
        ImageBridge.loadImage(this.context, item.image, R.drawable.bg_defualt_image, -1, 0, (ImageView) inflate.findViewById(R.id.iv_banner));
        ((ImageView) inflate.findViewById(R.id.iv_player)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.detail.DetailDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YoutubePlayerDelegate.play(DetailDialog.this.context, new YoutubeParams(item.videoId, item.name));
                ReportBridge.reportViewsClick(0, item.resourceId);
                DetailDialog.this.report("1002", item);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_views);
        if (LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1) {
            textView.setTextDirection(4);
        }
        textView.setText(ToolUtils.getViewsAndTimeString(this.context, item.views, item.updateTime * 1000));
        this.vVote = inflate.findViewById(R.id.ll_vote);
        report("1001", item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(String str, RecommendsInfo.Item item) {
        Report subId = new Report().eventType(str).itemId("7152").itemSub1("3").subId(item.resourceId);
        if (!TextUtils.isEmpty(this.reportType)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("videoSource", this.reportType);
                if ("1".equals(this.reportType)) {
                    jSONObject.put("indexId", this.reportIndex);
                }
                subId.ext(jSONObject.toString());
            } catch (JSONException e) {
                TLog.d(TAG, "report failed," + e);
            }
        }
        subId.report(false);
    }

    private void fetchRecommendInfo(RecommendsInfo.Item item, String str, String str2) {
        if (item == null) {
            return;
        }
        this.mPresenter.getRecommendDetail(item, str, str2);
    }

    @Override // com.tencent.grobot.lite.detail.IDetailDialog
    public void onGetRecommendInfo(int i, RecommendsInfo recommendsInfo) {
        if (recommendsInfo != null && recommendsInfo.items != null && recommendsInfo.items.size() > 0) {
            for (int i2 = 0; i2 < recommendsInfo.items.size(); i2++) {
                RecommendsInfo.Item item = recommendsInfo.items.get(i2);
                item.selected = false;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7042");
                    if (item.type == 10) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    } else if (item.type == 11) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    }
                    jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i2 + GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED));
                    jSONObject.put(ReportBridge.KEY_SUB_ID, item.resourceId);
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mAdapter.setData(recommendsInfo.items);
            this.mAdapter.setSelectedPos(-1);
            return;
        }
        this.mAdapter.setData(null);
        this.mAdapter.setSelectedPos(-1);
    }

    @Override // com.tencent.grobot.lite.detail.IDetailDialog
    public void onGetRecommendDetailInfo(int i, DetailInfo detailInfo) {
        if (detailInfo != null && detailInfo.items != null && detailInfo.items.size() > 0) {
            for (int i2 = 0; i2 < detailInfo.items.size(); i2++) {
                RecommendsInfo.Item item = detailInfo.items.get(i2);
                item.selected = false;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7042");
                    if (item.type == 10) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    } else if (item.type == 11) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    }
                    jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i2 + GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED));
                    jSONObject.put(ReportBridge.KEY_SUB_ID, item.resourceId);
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mAdapter.setData(detailInfo.items);
            this.mAdapter.setSelectedPos(-1);
            setVote(detailInfo.isLike, detailInfo.likeNum);
            return;
        }
        this.mAdapter.setData(null);
        this.mAdapter.setSelectedPos(-1);
    }

    @Override // com.tencent.grobot.lite.detail.IDetailDialog
    public void onSetLikeRecommend(int i) {
        if (i == 0) {
            boolean z = this.liked;
            setVote(!z, z ? this.likeCount - 1 : this.likeCount + 1);
        }
    }

    private void clearVote() {
        this.liked = false;
        this.likeCount = 0;
        View view = this.vVote;
        if (view != null) {
            view.setOnClickListener(null);
        }
        this.vVote = null;
    }

    private void setVote(boolean z, int i) {
        this.liked = z;
        this.likeCount = i;
        View view = this.vVote;
        if (view != null) {
            view.setVisibility(0);
            View findViewById = this.vVote.findViewById(R.id.v_vote);
            TextView textView = (TextView) this.vVote.findViewById(R.id.tv_vote_count);
            this.vVote.setOnClickListener(this);
            findViewById.setBackgroundResource(this.liked ? R.drawable.icon_vote_clicked : R.drawable.icon_vote);
            textView.setText(String.valueOf(this.likeCount));
        }
    }
}
