package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.detail.DetailDialog;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.BaseViewAdapter;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.view.EndlessRecyclerView;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class NavigationSlice extends Slice implements View.OnClickListener, BaseViewHolder.OnItemClickListener, EndlessRecyclerView.CreateExtraViewHolder, EndlessRecyclerView.LoadMoreListener {
    private static final int RV_TYPE_ITEM = 1003;
    private static final int RV_TYPE_SUBTAG = 1002;
    private static final int RV_TYPE_TAG = 1001;
    private static final int START_INDEX_ID = 8001;
    private static final String TAG = "NavigationSlice";
    private final float aspectRatio;
    private boolean collectPadding;
    private final int horizonPadding;
    private ItemAdapter itemAdapter;
    private ImageView ivUp;
    private ISliceListener mISliceListener;
    private MainTagAdapter mainTagAdapter;
    private EndlessRecyclerView rvItems;
    private RecyclerView rvMainTag;
    private RecyclerView rvSecTag;
    private ItemsScrollListener scrollListener;
    private View searchView;
    private SecTagAdapter secTagAdapter;
    private HeaderViewHolder tagVH;
    private View vSecDivider;

    @Override // com.tencent.grobot.lite.ui.view.EndlessRecyclerView.CreateExtraViewHolder
    public int footerCount() {
        return 1;
    }

    @Override // com.tencent.grobot.lite.ui.view.EndlessRecyclerView.CreateExtraViewHolder
    public int headerCount() {
        return 1;
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void stop(Object... objArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavigationSlice(Feeds feeds) {
        super(feeds);
        this.collectPadding = false;
        this.mISliceListener = null;
        this.aspectRatio = ViewUtils.getScreenAspectRatio(this.context);
        this.horizonPadding = ViewUtils.dip2px(this.context, 6.0f);
    }

    public void setISliceListener(ISliceListener iSliceListener) {
        this.mISliceListener = iSliceListener;
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public View view() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.slice_navigation, (ViewGroup) null, false);
        this.rvMainTag = (RecyclerView) inflate.findViewById(R.id.rv_main_tag);
        this.rvMainTag.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        this.mainTagAdapter = new MainTagAdapter(this);
        this.rvMainTag.setAdapter(this.mainTagAdapter);
        this.rvSecTag = (RecyclerView) inflate.findViewById(R.id.rv_sec_tag);
        this.rvSecTag.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        this.secTagAdapter = new SecTagAdapter(this);
        this.rvSecTag.setAdapter(this.secTagAdapter);
        this.rvItems = (EndlessRecyclerView) inflate.findViewById(R.id.rv_items);
        this.rvItems.setLayoutManager(new GridLayoutManager(this.context, 2, 1, false));
        this.rvItems.addItemDecoration(new DividerDecoration(this.context, this.aspectRatio >= 2.0f ? 10.0f : 7.0f));
        this.rvItems.setLoadMoreListener(this);
        this.itemAdapter = new ItemAdapter(this);
        this.rvItems.setAdapter(this.itemAdapter);
        this.rvItems.setDelegate(this);
        this.scrollListener = new ItemsScrollListener(this);
        this.rvItems.addOnScrollListener(this.scrollListener);
        this.tagVH = new HeaderViewHolder(this.context, this.rvItems);
        this.tagVH.btnHot.setOnClickListener(this);
        this.tagVH.btnNew.setOnClickListener(this);
        this.vSecDivider = inflate.findViewById(R.id.v_sec_tag_divider);
        this.ivUp = (ImageView) inflate.findViewById(R.id.iv_up);
        this.ivUp.setOnClickListener(this);
        this.searchView = inflate.findViewById(R.id.rv_search_layout);
        this.searchView.setOnClickListener(this);
        return inflate;
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void fixNotchScreen() {
        if (SystemUtils.hasNotch(this.context)) {
            int rotation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
            boolean z = LangUtils.getLayoutDirectionFromLocale(this.context.getResources().getConfiguration().locale) == 1;
            TLog.d(TAG, "fixNotchScreen, padding=" + SystemUtils.getStatusBarHeight(this.context) + ", rotation=" + rotation + ", rtl=" + z);
            int safeInsetLeft = Build.VERSION.SDK_INT >= 28 ? SystemUtils.getSafeInsetLeft(this.context) : SystemUtils.getStatusBarHeight(this.context);
            if (rotation == 1) {
                if (!z) {
                    EndlessRecyclerView endlessRecyclerView = this.rvItems;
                    int i = this.horizonPadding;
                    endlessRecyclerView.setPadding(safeInsetLeft + i, 0, i, 0);
                    return;
                } else {
                    EndlessRecyclerView endlessRecyclerView2 = this.rvItems;
                    int i2 = this.horizonPadding;
                    endlessRecyclerView2.setPadding(i2, 0, i2, 0);
                    return;
                }
            }
            if (!z) {
                EndlessRecyclerView endlessRecyclerView3 = this.rvItems;
                int i3 = this.horizonPadding;
                endlessRecyclerView3.setPadding(i3, 0, i3, 0);
            } else {
                EndlessRecyclerView endlessRecyclerView4 = this.rvItems;
                int i4 = this.horizonPadding;
                endlessRecyclerView4.setPadding(safeInsetLeft + i4, 0, i4, 0);
            }
        }
    }

    @Override // com.tencent.grobot.lite.recommends.Slice
    public void start(Object... objArr) {
        TagInfo tagInfo = null;
        if (objArr[0] instanceof NavigationInfo) {
            NavigationInfo navigationInfo = (NavigationInfo) objArr[0];
            if (!this.collectPadding) {
                int left = this.rvItems.getLeft();
                this.rvMainTag.setPadding(left, 0, left, 0);
                this.rvSecTag.setPadding(left, 0, left, 0);
                this.vSecDivider.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.vSecDivider.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.leftMargin = left;
                    layoutParams.rightMargin = left;
                    this.vSecDivider.setLayoutParams(layoutParams);
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivUp.getLayoutParams();
                if (layoutParams2 != null) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.setMarginEnd(left);
                    } else {
                        layoutParams2.rightMargin = left;
                    }
                    this.ivUp.setLayoutParams(layoutParams2);
                }
                this.collectPadding = true;
                TLog.d(TAG, "start, collect padding, v=" + left);
            }
            this.mainTagAdapter.setDatas(navigationInfo.tags);
            Iterator<TagInfo> it = navigationInfo.tags.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TagInfo next = it.next();
                if (next.id.equals(this.container.curNavigationState.tag)) {
                    tagInfo = next;
                    break;
                }
            }
            if (tagInfo != null) {
                this.secTagAdapter.setDatas(tagInfo.subs);
            }
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (this.rvItems.getState() != 0) {
                this.rvItems.setState(0);
            }
            if (booleanValue) {
                this.itemAdapter.addItems(navigationInfo.items);
            } else {
                this.itemAdapter.setDatas(navigationInfo.items);
                this.scrollListener.distance = 0;
            }
            changeBtnType(this.container.curNavigationState.order);
            return;
        }
        if (this.rvItems.getState() != 0) {
            this.rvItems.setState(0);
        }
        if (TextUtils.isEmpty(this.container.curNavigationState.tag) || TextUtils.isEmpty(this.container.curNavigationState.subTag) || this.container.curNavigationState.page != 1) {
            return;
        }
        this.itemAdapter.setDatas(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ISliceListener iSliceListener;
        int id = view.getId();
        if (id == R.id.btn_new) {
            changeType(1);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7147");
                ReportBridge.report(jSONObject, false);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (id == R.id.btn_hot) {
            changeType(0);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7146");
                ReportBridge.report(jSONObject2, false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (id == R.id.iv_up) {
            this.rvItems.smoothScrollToPosition(0);
        } else {
            if (id != R.id.rv_search_layout || (iSliceListener = this.mISliceListener) == null) {
                return;
            }
            iSliceListener.changeTab(2);
            new Report().eventType("1002").itemId("7159").report(false);
        }
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder.OnItemClickListener
    public void onItemClick(View view, int i, int i2, Object obj) {
        if (i2 == 1001) {
            if (obj instanceof TagInfo) {
                TagInfo tagInfo = (TagInfo) obj;
                if (tagInfo.subs.isEmpty()) {
                    return;
                }
                this.container.getNavigation(tagInfo.id, tagInfo.subs.get(0).id, 1, 1, true);
                return;
            }
            return;
        }
        if (i2 == 1002 && (obj instanceof TagInfo)) {
            TagInfo tagInfo2 = (TagInfo) obj;
            if (TextUtils.isEmpty(tagInfo2.parent)) {
                return;
            }
            this.container.getNavigation(tagInfo2.parent, tagInfo2.id, 1, 1, true);
        }
    }

    @Override // com.tencent.grobot.lite.ui.view.EndlessRecyclerView.CreateExtraViewHolder
    public RecyclerView.w createHeader(ViewGroup viewGroup, int i) {
        return this.tagVH;
    }

    @Override // com.tencent.grobot.lite.ui.view.EndlessRecyclerView.CreateExtraViewHolder
    public RecyclerView.w createFooter(ViewGroup viewGroup, int i) {
        return new FooterViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_loading, viewGroup, false));
    }

    @Override // com.tencent.grobot.lite.ui.view.EndlessRecyclerView.LoadMoreListener
    public void onLoadMore() {
        TLog.d(TAG, "onLoadMore, cur=" + this.container.curNavigationState.tag + ", req=" + this.container.reqNavigationState.tag + ", isEnd=" + this.container.curNavigationState.isEnd);
        if (TextUtils.isEmpty(this.container.curNavigationState.tag) || !TextUtils.isEmpty(this.container.reqNavigationState.tag) || this.container.curNavigationState.isEnd) {
            return;
        }
        this.rvItems.setState(1);
        this.container.getNavigation(this.container.curNavigationState.tag, this.container.curNavigationState.subTag, this.container.curNavigationState.order, this.container.curNavigationState.page + 1, false);
    }

    private void changeType(int i) {
        if (this.container.curNavigationState.order != i) {
            changeBtnType(i);
            this.container.getNavigation(this.container.curNavigationState.tag, this.container.curNavigationState.subTag, i, 1, true);
        }
    }

    private void changeBtnType(int i) {
        if (i == 1) {
            this.tagVH.btnNew.setTextColor(this.context.getResources().getColor(R.color.navigation_btn_highlight));
            this.tagVH.btnNew.setBackgroundResource(R.drawable.bg_navigation_type_btn_clicked);
            this.tagVH.btnHot.setTextColor(this.context.getResources().getColor(R.color.navigation_btn_normal));
            this.tagVH.btnHot.setBackgroundResource(R.drawable.bg_navigation_type_right_btn);
            return;
        }
        this.tagVH.btnNew.setTextColor(this.context.getResources().getColor(R.color.navigation_btn_normal));
        this.tagVH.btnNew.setBackgroundResource(R.drawable.bg_navigation_type_left_btn);
        this.tagVH.btnHot.setTextColor(this.context.getResources().getColor(R.color.navigation_btn_highlight));
        this.tagVH.btnHot.setBackgroundResource(R.drawable.bg_navigation_type_btn_clicked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MainTagAdapter extends BaseViewAdapter<TagInfo> {
        final NavigationSlice slice;

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
        protected int getItemViewTypeByPosition(int i) {
            return 1001;
        }

        MainTagAdapter(NavigationSlice navigationSlice) {
            super(navigationSlice.context);
            this.slice = navigationSlice;
        }

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
        protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
            TextView textView = new TextView(this.context);
            textView.setGravity(17);
            textView.setTextSize(2, 11.0f);
            ViewUtils.setBoldTypeface(this.context, textView);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2px(this.context, 120.0f), -1));
            return new MainTagNode(textView, i, this.slice);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter, androidx.recyclerview.widget.RecyclerView.a
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            if (baseViewHolder instanceof MainTagNode) {
                MainTagNode mainTagNode = (MainTagNode) baseViewHolder;
                mainTagNode.curTagId = this.slice.container.curNavigationState.tag;
                mainTagNode.pos = i;
            }
            super.onBindViewHolder(baseViewHolder, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MainTagNode extends BaseViewHolder<TagInfo> implements View.OnClickListener {
        private static final int COLOR_TEXT = Color.parseColor("#9FBBC6");
        private static final int COLOR_TEXT_HIGHLIGHT = Color.parseColor("#000000");
        String curTagId;
        int pos;
        private final TextView tvTitle;

        MainTagNode(TextView textView, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
            super(textView, i, onItemClickListener);
            this.tvTitle = textView;
            this.tvTitle.setOnClickListener(this);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
        public void bindData(TagInfo tagInfo) {
            this.tvTitle.setBackgroundResource(tagInfo.id.equals(this.curTagId) ? R.drawable.bg_navigation_main_tag_item : 0);
            this.tvTitle.setTextColor(tagInfo.id.equals(this.curTagId) ? COLOR_TEXT_HIGHLIGHT : COLOR_TEXT);
            this.tvTitle.setText(tagInfo.name);
            this.tvTitle.setTag(tagInfo);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7149");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 8001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.clickListener.onItemClick(view, getAdapterPosition(), getItemViewType(), view.getTag());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7149");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 8001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SecTagAdapter extends BaseViewAdapter<TagInfo> {
        final NavigationSlice slice;
        private static final int COLOR_NORMAL = Color.parseColor("#FFFFFF");
        private static final int COLOR_HIGHTLIGHT = Color.parseColor("#F2A900");

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
        protected int getItemViewTypeByPosition(int i) {
            return 1002;
        }

        SecTagAdapter(NavigationSlice navigationSlice) {
            super(navigationSlice.context);
            this.slice = navigationSlice;
        }

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
        protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout = new FrameLayout(this.context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2px(this.context, 100.0f), -1));
            TextView textView = new TextView(this.context);
            textView.setGravity(8388627);
            textView.setTextSize(2, 11.0f);
            textView.setLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            ViewUtils.setBoldTypeface(this.context, textView);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int dip2px = ViewUtils.dip2px(this.context, 10.0f);
            FrameLayout.LayoutParams layoutParams2 = layoutParams;
            layoutParams2.setMarginStart(dip2px);
            layoutParams2.setMarginEnd(dip2px);
            layoutParams2.gravity = 17;
            frameLayout.addView(textView, layoutParams);
            View view = new View(this.context);
            view.setBackgroundColor(COLOR_HIGHTLIGHT);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(this.context, 1.5f));
            layoutParams3.gravity = 81;
            frameLayout.addView(view, layoutParams3);
            return new SecTagNode(frameLayout, textView, view, i, this.slice);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter, androidx.recyclerview.widget.RecyclerView.a
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            if (baseViewHolder instanceof SecTagNode) {
                ((SecTagNode) baseViewHolder).curTagId = this.slice.container.curNavigationState.subTag;
            }
            super.onBindViewHolder(baseViewHolder, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SecTagNode extends BaseViewHolder<TagInfo> implements View.OnClickListener {
        private final int DIFF;
        private final int MAX_WITDH;
        private final int MIN_WIDTH;
        String curTagId;
        private final TextView tvTitle;
        private final View vLine;

        SecTagNode(FrameLayout frameLayout, TextView textView, View view, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
            super(frameLayout, i, onItemClickListener);
            this.tvTitle = textView;
            this.tvTitle.setOnClickListener(this);
            this.vLine = view;
            this.MAX_WITDH = ViewUtils.dip2px(frameLayout.getContext(), 110.0f);
            this.MIN_WIDTH = ViewUtils.dip2px(frameLayout.getContext(), 90.0f);
            this.DIFF = ViewUtils.dip2px(frameLayout.getContext(), 20.0f);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
        public void bindData(TagInfo tagInfo) {
            if (tagInfo.id.equals(this.curTagId)) {
                this.tvTitle.setTextColor(SecTagAdapter.COLOR_HIGHTLIGHT);
                this.vLine.setVisibility(0);
            } else {
                this.tvTitle.setTextColor(SecTagAdapter.COLOR_NORMAL);
                this.vLine.setVisibility(8);
            }
            this.tvTitle.setText(tagInfo.name);
            this.tvTitle.setGravity(17);
            this.tvTitle.setTag(tagInfo);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            int measureTextWidth = ViewUtils.measureTextWidth(tagInfo.name, ViewUtils.sp2px(this.tvTitle.getContext(), 11.0f), Typeface.DEFAULT_BOLD);
            int i = this.MAX_WITDH;
            if (measureTextWidth >= i) {
                layoutParams.width = i + this.DIFF;
                this.itemView.setLayoutParams(layoutParams);
            } else if (measureTextWidth > this.MIN_WIDTH && measureTextWidth < i) {
                layoutParams.width = measureTextWidth + this.DIFF;
                this.itemView.setLayoutParams(layoutParams);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7150");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 8001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.clickListener.onItemClick(view, getAdapterPosition(), getItemViewType(), view.getTag());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7150");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 8001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ItemAdapter extends BaseViewAdapter<RecommendsInfo.Item> {
        final NavigationSlice slice;

        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
        protected int getItemViewTypeByPosition(int i) {
            return 1003;
        }

        ItemAdapter(NavigationSlice navigationSlice) {
            super(navigationSlice.context);
            this.slice = navigationSlice;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
        public ItemNode buildViewHolder(ViewGroup viewGroup, int i) {
            return new ItemNode(this.context, viewGroup, i, this.slice, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ItemNode extends BaseViewHolder<RecommendsInfo.Item> {
        final DateFormat dateFormat;
        private final FrameLayout flPic;
        private final TimeOutIcon iconTimeout;
        private final ImageView ivPic;
        private final View rootView;
        private final NavigationSlice slice;
        private final TextView tvSubTitle;
        private final TextView tvTitle;

        ItemNode(Context context, ViewGroup viewGroup, int i, NavigationSlice navigationSlice, BaseViewHolder.OnItemClickListener onItemClickListener) {
            super(context, viewGroup, R.layout.item_navigation_list, i, onItemClickListener);
            this.slice = navigationSlice;
            this.rootView = this.itemView;
            this.flPic = (FrameLayout) this.itemView.findViewById(R.id.fl_pic);
            this.ivPic = (ImageView) this.itemView.findViewById(R.id.iv_pic);
            this.iconTimeout = (TimeOutIcon) this.itemView.findViewById(R.id.icon_timeout);
            this.tvTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.tvSubTitle = (TextView) this.itemView.findViewById(R.id.tv_subtitles);
            ViewUtils.setBoldTypeface(context, this.tvTitle);
            this.dateFormat = android.text.format.DateFormat.getDateFormat(context);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
        public void bindData(final RecommendsInfo.Item item) {
            this.iconTimeout.setVisibility(item.type == 10 ? 0 : 8);
            ImageBridge.loadImage(this.ivPic.getContext(), item.image, R.drawable.bg_defualt_image, -1, 0, this.ivPic);
            this.iconTimeout.setTime(item.vt);
            if (!item.subtitle.isEmpty()) {
                this.tvSubTitle.setVisibility(0);
                this.tvSubTitle.setText("#" + item.subtitle.get(0));
            } else {
                this.tvSubTitle.setVisibility(8);
            }
            this.tvTitle.setText(item.name);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7145");
                if (item.type == 10) {
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                } else if (item.type == 11) {
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                }
                jSONObject.put(ReportBridge.KEY_SUB_ID, item.resourceId);
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 8001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.recommends.NavigationSlice.ItemNode.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DetailDialog detailDialog = (DetailDialog) ((FrameActivity) ItemNode.this.slice.context).getDialog(DetailDialog.class);
                    detailDialog.setData(item, ItemNode.this.slice.container.curNavigationState.tag, ItemNode.this.slice.container.curNavigationState.subTag, "2", 0);
                    detailDialog.showCustomDialog();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                        jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7145");
                        if (item.type == 10) {
                            jSONObject2.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                        } else if (item.type == 11) {
                            jSONObject2.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                        }
                        jSONObject2.put(ReportBridge.KEY_SUB_ID, item.resourceId);
                        jSONObject2.put(ReportBridge.KEY_INDEX_ID, String.valueOf(ItemNode.this.getAdapterPosition() + 8001));
                        ReportBridge.report(jSONObject2, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class HeaderViewHolder extends RecyclerView.w {
        final Button btnHot;
        final Button btnNew;

        HeaderViewHolder(Context context, ViewGroup viewGroup) {
            super(LayoutInflater.from(context).inflate(R.layout.item_navigation_tag, viewGroup, false));
            this.btnHot = (Button) this.itemView.findViewById(R.id.btn_hot);
            ViewUtils.setBoldTypeface(context, this.btnHot);
            this.btnNew = (Button) this.itemView.findViewById(R.id.btn_new);
            ViewUtils.setBoldTypeface(context, this.btnNew);
        }
    }

    /* loaded from: classes2.dex */
    private static final class FooterViewHolder extends RecyclerView.w {
        FooterViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ItemsScrollListener extends RecyclerView.n {
        int distance = 0;
        final WeakReference<NavigationSlice> ptr;
        int screenHeight;
        int state;

        ItemsScrollListener(NavigationSlice navigationSlice) {
            this.ptr = new WeakReference<>(navigationSlice);
            this.screenHeight = ViewUtils.getScreenHeightPixels(navigationSlice.context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            this.state = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            this.distance += i2;
            NavigationSlice navigationSlice = this.ptr.get();
            if (navigationSlice != null) {
                if (this.distance > this.screenHeight / 2) {
                    if (navigationSlice.ivUp.getVisibility() != 0) {
                        navigationSlice.ivUp.setVisibility(0);
                    }
                } else if (navigationSlice.ivUp.getVisibility() != 8) {
                    navigationSlice.ivUp.setVisibility(8);
                }
            }
        }
    }
}
