package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.common.ViewPools;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.core.IServiceCallback;
import com.tencent.grobot.lite.detail.DetailDialog;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.IM;
import com.tencent.grobot.lite.ui.adapter.BaseViewAdapter;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.Router;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class SplashAdapter extends BaseViewAdapter<RecommendsInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SplashAdapter(Context context) {
        super(context);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new NodeA(this.context, viewGroup, null);
        }
        if (i == 1) {
            return new NodeB(this.context, viewGroup, null);
        }
        if (i == 2) {
            return new NodeC(this.context, viewGroup, null);
        }
        return new NodeC(this.context, viewGroup, null);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        if (i < this.datas.size()) {
            return ((RecommendsInfo) this.datas.get(i)).type;
        }
        return 1;
    }

    /* loaded from: classes2.dex */
    static final class NodeA extends BaseViewHolder<RecommendsInfo> implements ViewPager.f {
        private static final int COLOR_DOT_HIGHLIGHT = Color.parseColor("#FBB403");
        private static final int COLOR_DOT_NORMAL = Color.parseColor("#5F6266");
        final NodeAVPAdapter adapter;
        int curIndex;
        final DateFormat dateFormat;
        private boolean firstShow;
        final TimeOutIcon iconTimeout;
        RecommendsInfo info;
        final LinearLayout llIndicator;
        final LinearLayout llSub;
        private final int picWidth;
        private int scrollState;
        final TextView tvDate;
        final TextView tvIcon;
        final TextView tvTitle;
        final TextView tvViews;
        final View vDot;
        final View vDot1;
        final View vDot2;
        final ViewPager vpBanner;

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrolled(int i, float f, int i2) {
        }

        NodeA(Context context, ViewGroup viewGroup, BaseViewHolder.OnItemClickListener onItemClickListener) {
            super(context, viewGroup, R.layout.splash_node_a, 0, onItemClickListener);
            this.curIndex = -1;
            this.firstShow = true;
            this.scrollState = 0;
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            int width = recyclerView.getWidth();
            this.picWidth = (recyclerView.getItemDecorationAt(0) instanceof DividerDecoration ? width - ((DividerDecoration) recyclerView.getItemDecorationAt(0)).offset : width) / 2;
            this.vpBanner = (ViewPager) this.itemView.findViewById(R.id.vp_banner);
            this.adapter = new NodeAVPAdapter(context, this.picWidth);
            this.vpBanner.setAdapter(this.adapter);
            this.vpBanner.setOnPageChangeListener(this);
            this.tvTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.tvIcon = (TextView) this.itemView.findViewById(R.id.tv_icon);
            this.tvViews = (TextView) this.itemView.findViewById(R.id.tv_views);
            this.tvDate = (TextView) this.itemView.findViewById(R.id.tv_date);
            this.llIndicator = (LinearLayout) this.itemView.findViewById(R.id.ll_indicator);
            this.vDot = this.itemView.findViewById(R.id.v_indicator_dot);
            this.vDot1 = this.itemView.findViewById(R.id.v_indicator_dot_1);
            this.vDot2 = this.itemView.findViewById(R.id.v_indicator_dot_2);
            this.iconTimeout = (TimeOutIcon) this.itemView.findViewById(R.id.icon_timeout);
            this.llSub = (LinearLayout) this.itemView.findViewById(R.id.ll_sub);
            this.dateFormat = DateFormat.getDateInstance(1, context.getResources().getConfiguration().locale);
            if (LangUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1) {
                this.tvViews.setTextDirection(4);
            }
        }

        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
        public void bindData(RecommendsInfo recommendsInfo) {
            this.info = recommendsInfo;
            this.adapter.setData(recommendsInfo.items);
            if (this.firstShow) {
                this.firstShow = false;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7140");
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            RecommendsInfo recommendsInfo2 = this.info;
            if (recommendsInfo2 != null && !recommendsInfo2.items.isEmpty()) {
                this.curIndex = 0;
                setBannerText(this.info.items.get(0));
                this.llIndicator.setVisibility(0);
                this.vDot.setVisibility(0);
                this.vDot.setBackgroundColor(COLOR_DOT_HIGHLIGHT);
                if (this.info.items.size() > 2) {
                    this.vDot1.setVisibility(0);
                    this.vDot2.setVisibility(0);
                } else if (this.info.items.size() > 1) {
                    this.vDot1.setVisibility(0);
                    this.vDot2.setVisibility(8);
                } else {
                    this.vDot1.setVisibility(8);
                    this.vDot2.setVisibility(8);
                }
                this.vDot1.setBackgroundColor(COLOR_DOT_NORMAL);
                this.vDot2.setBackgroundColor(COLOR_DOT_NORMAL);
                return;
            }
            this.curIndex = -1;
            this.llIndicator.setVisibility(8);
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageSelected(int i) {
            RecommendsInfo recommendsInfo = this.info;
            if (recommendsInfo != null && i < recommendsInfo.items.size()) {
                this.curIndex = i;
                setBannerText(this.info.items.get(i));
                if (i == 0) {
                    this.vDot.setBackgroundColor(COLOR_DOT_HIGHLIGHT);
                    this.vDot1.setBackgroundColor(COLOR_DOT_NORMAL);
                    this.vDot2.setBackgroundColor(COLOR_DOT_NORMAL);
                    return;
                } else if (i == 1) {
                    this.vDot.setBackgroundColor(COLOR_DOT_NORMAL);
                    this.vDot1.setBackgroundColor(COLOR_DOT_HIGHLIGHT);
                    this.vDot2.setBackgroundColor(COLOR_DOT_NORMAL);
                    return;
                } else {
                    if (i == 2) {
                        this.vDot.setBackgroundColor(COLOR_DOT_NORMAL);
                        this.vDot1.setBackgroundColor(COLOR_DOT_NORMAL);
                        this.vDot2.setBackgroundColor(COLOR_DOT_HIGHLIGHT);
                        return;
                    }
                    return;
                }
            }
            this.curIndex = -1;
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrollStateChanged(int i) {
            this.scrollState = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void next() {
            RecommendsInfo recommendsInfo;
            if (this.scrollState != 0) {
                return;
            }
            if (this.curIndex != -1 && (recommendsInfo = this.info) != null && recommendsInfo.items != null && !this.info.items.isEmpty()) {
                if (this.curIndex < this.info.items.size() - 1) {
                    this.curIndex++;
                } else {
                    this.curIndex = 0;
                }
            }
            this.vpBanner.a(this.curIndex, true);
        }

        void setBannerText(RecommendsInfo.Item item) {
            int c;
            TextView buildSubItem;
            if (!TextUtils.isEmpty(item.recommendTitle)) {
                try {
                    c = Color.parseColor(item.recommendTitle);
                } catch (IllegalArgumentException unused) {
                    c = a.c(this.tvTitle.getContext(), R.color.recommends_node_title);
                }
            } else {
                c = a.c(this.tvTitle.getContext(), R.color.recommends_node_title);
            }
            this.tvTitle.setTextColor(c);
            this.tvTitle.setText(item.name);
            int i = 0;
            if (item.icon == 1) {
                this.tvIcon.setVisibility(0);
                this.tvIcon.setBackgroundResource(R.drawable.icon_recommend_icon_new);
                this.tvIcon.setText(R.string.splash_news);
            } else if (item.icon == 0) {
                this.tvIcon.setVisibility(0);
                this.tvIcon.setBackgroundResource(R.drawable.icon_recommend_icon_hot);
                this.tvIcon.setText(R.string.splash_hot);
            } else {
                this.tvIcon.setVisibility(8);
            }
            if (item.type == 10) {
                this.iconTimeout.setTime(item.vt);
                this.iconTimeout.setVisibility(0);
            } else {
                this.iconTimeout.setVisibility(8);
            }
            this.tvViews.setText(ToolUtils.getViews(this.tvTitle.getContext(), item.views) + " " + this.tvTitle.getContext().getString(R.string.video_suffix));
            if (item.updateTime != -1) {
                Date date = new Date(item.updateTime * 1000);
                this.tvDate.setVisibility(0);
                this.tvDate.setText(this.dateFormat.format(date));
            } else {
                this.tvDate.setVisibility(8);
            }
            if (!item.subtitle.isEmpty()) {
                this.llSub.setVisibility(0);
                int childCount = this.llSub.getChildCount();
                int size = item.subtitle.size();
                if (childCount >= size) {
                    if (childCount <= size) {
                        while (i < size) {
                            ((TextView) this.llSub.getChildAt(i)).setText("#" + item.subtitle.get(i));
                            i++;
                        }
                        return;
                    }
                    int i2 = childCount - size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        ViewPools.getInstance().release(1, this.llSub.getChildAt(size + i3));
                    }
                    this.llSub.removeViews(size, i2);
                    while (i < size) {
                        ((TextView) this.llSub.getChildAt(i)).setText("#" + item.subtitle.get(i));
                        i++;
                    }
                    return;
                }
                ArrayList<TextView> arrayList = new ArrayList(size - childCount);
                for (int i4 = 0; i4 < size; i4++) {
                    if (i4 < childCount) {
                        ((TextView) this.llSub.getChildAt(i4)).setText("#" + item.subtitle.get(i4));
                    } else {
                        View acquire = ViewPools.getInstance().acquire(1);
                        if (acquire instanceof TextView) {
                            buildSubItem = (TextView) acquire;
                        } else {
                            buildSubItem = buildSubItem();
                        }
                        buildSubItem.setText("#" + item.subtitle.get(i4));
                        arrayList.add(buildSubItem);
                    }
                }
                for (TextView textView : arrayList) {
                    if (textView != null) {
                        this.llSub.addView(textView);
                        ((LinearLayout.LayoutParams) textView.getLayoutParams()).setMargins(ViewUtils.dip2px(this.tvTitle.getContext(), 7.0f), 0, 0, 0);
                    }
                }
                return;
            }
            this.llSub.setVisibility(8);
        }

        private TextView buildSubItem() {
            Context context = this.tvTitle.getContext();
            TextView textView = new TextView(context);
            textView.setTextSize(2, 9.0f);
            textView.setTextColor(a.c(context, R.color.recommends_node_sub));
            ViewUtils.setBoldTypeface(context, textView);
            int dip2px = ViewUtils.dip2px(context, 7.0f);
            int dip2px2 = ViewUtils.dip2px(context, 2.0f);
            textView.setPadding(dip2px, dip2px2, dip2px, dip2px2);
            textView.setBackgroundResource(R.drawable.bg_recommends_nod_sub);
            return textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class NodeAVPAdapter extends androidx.viewpager.widget.a {
        final Context context;
        final int picWidth;
        boolean firstShow = true;
        boolean secondShow = true;
        boolean thirdShow = true;
        final List<RecommendsInfo.Item> items = new ArrayList(3);

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        NodeAVPAdapter(Context context, int i) {
            this.context = context;
            this.picWidth = i;
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return Math.min(this.items.size(), 3);
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, final int i) {
            RecommendsInfo.Item item = this.items.get(i);
            ViewPager.c cVar = new ViewPager.c();
            ((ViewGroup.LayoutParams) cVar).width = this.picWidth;
            ((ViewGroup.LayoutParams) cVar).height = ViewUtils.dip2px(this.context, 156.0f);
            ImageView imageView = new ImageView(this.context);
            imageView.setLayoutParams(cVar);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageBridge.loadImage(this.context, item.image, R.drawable.bg_defualt_image, -1, 0, imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.recommends.SplashAdapter.NodeAVPAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DetailDialog detailDialog = (DetailDialog) ((FrameActivity) NodeAVPAdapter.this.context).getDialog(DetailDialog.class);
                    detailDialog.setData(NodeAVPAdapter.this.items.get(i), "", "", "0", 0);
                    detailDialog.showCustomDialog();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                        jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 7001));
                        jSONObject.put(ReportBridge.KEY_ITEM_ID, "7154");
                        if (NodeAVPAdapter.this.items.get(i).type == 10) {
                            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                        } else if (NodeAVPAdapter.this.items.get(i).type == 11) {
                            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                        }
                        jSONObject.put(ReportBridge.KEY_SUB_ID, NodeAVPAdapter.this.items.get(i).resourceId);
                        ReportBridge.report(jSONObject, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            viewGroup.addView(imageView);
            if (this.firstShow || this.secondShow || this.thirdShow) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(i + 7001));
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7154");
                    if (this.items.get(i).type == 10) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    } else if (this.items.get(i).type == 11) {
                        jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    }
                    jSONObject.put(ReportBridge.KEY_SUB_ID, this.items.get(i).resourceId);
                    if ((i == 0 && this.firstShow) || ((i == 1 && this.secondShow) || (i == 2 && this.thirdShow))) {
                        ReportBridge.report(jSONObject, false);
                    }
                    if (i == 0) {
                        this.firstShow = false;
                    }
                    if (i == 1) {
                        this.secondShow = false;
                    }
                    if (i == 2) {
                        this.thirdShow = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return imageView;
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof FrameLayout) {
                viewGroup.removeView((FrameLayout) obj);
            }
        }

        void setData(List<RecommendsInfo.Item> list) {
            this.items.clear();
            this.items.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    static final class NodeB extends BaseViewHolder<RecommendsInfo> {
        final FrameLayout flTop;
        final LinearLayout llContainer;
        private Context mContext;
        final TextView tvTitle;

        NodeB(Context context, ViewGroup viewGroup, BaseViewHolder.OnItemClickListener onItemClickListener) {
            super(context, viewGroup, R.layout.splash_node_b, 1, onItemClickListener);
            this.mContext = context;
            this.flTop = (FrameLayout) this.itemView.findViewById(R.id.fl_top);
            this.tvTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.flTop.setPaddingRelative(ViewUtils.dip2px(context, ViewUtils.getScreenAspectRatio(context) > 2.0f ? 8.0f : 5.0f), 0, 0, 0);
            this.llContainer = (LinearLayout) this.itemView.findViewById(R.id.ll_container);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
        public void bindData(RecommendsInfo recommendsInfo) {
            SplashNodeItemView buildItemView;
            if (recommendsInfo == null) {
                return;
            }
            this.tvTitle.setText(recommendsInfo.name);
            if (!recommendsInfo.items.isEmpty()) {
                this.llContainer.setVisibility(0);
                int childCount = this.llContainer.getChildCount();
                int size = recommendsInfo.items.size();
                if (childCount < size) {
                    ArrayList<SplashNodeItemView> arrayList = new ArrayList(size - childCount);
                    int i = 0;
                    while (i < size) {
                        if (i < childCount) {
                            bindItemView((SplashNodeItemView) this.llContainer.getChildAt(i), recommendsInfo.items.get(i), true, getAdapterPosition());
                        } else {
                            View acquire = ViewPools.getInstance().acquire(2);
                            if (acquire instanceof SplashNodeItemView) {
                                buildItemView = (SplashNodeItemView) acquire;
                            } else {
                                buildItemView = buildItemView();
                            }
                            bindItemView(buildItemView, recommendsInfo.items.get(i), i != size + (-1), getAdapterPosition());
                            arrayList.add(buildItemView);
                        }
                        i++;
                    }
                    for (SplashNodeItemView splashNodeItemView : arrayList) {
                        if (splashNodeItemView != null) {
                            this.llContainer.addView(splashNodeItemView);
                        }
                    }
                } else if (childCount > size) {
                    int i2 = childCount - size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        ViewPools.getInstance().release(2, this.llContainer.getChildAt(size + i3));
                    }
                    this.llContainer.removeViews(size, i2);
                    int i4 = 0;
                    while (i4 < size) {
                        bindItemView((SplashNodeItemView) this.llContainer.getChildAt(i4), recommendsInfo.items.get(i4), i4 != size + (-1), getAdapterPosition());
                        i4++;
                    }
                } else {
                    int i5 = 0;
                    while (i5 < size) {
                        bindItemView((SplashNodeItemView) this.llContainer.getChildAt(i5), recommendsInfo.items.get(i5), i5 != size + (-1), getAdapterPosition());
                        i5++;
                    }
                }
            } else {
                this.llContainer.setVisibility(8);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 7001));
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7141");
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private SplashNodeItemView buildItemView() {
            Context context = this.tvTitle.getContext();
            SplashNodeItemView splashNodeItemView = new SplashNodeItemView(this.mContext);
            splashNodeItemView.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(context, 76.0f)));
            return splashNodeItemView;
        }

        private void bindItemView(SplashNodeItemView splashNodeItemView, RecommendsInfo.Item item, boolean z, int i) {
            splashNodeItemView.setContent(item, i, z);
            Report subId = new Report().eventType("1001").itemId("7142").indexId(String.valueOf(i + 7001)).subId(item.resourceId);
            if (item.type == 10) {
                subId.itemSub1("3");
            } else if (item.type == 11) {
                subId.itemSub1("1");
            }
            subId.report(false);
        }
    }

    /* loaded from: classes2.dex */
    static final class NodeC extends BaseViewHolder<RecommendsInfo> implements View.OnClickListener, IServiceCallback {
        final Matrix displayMatrix;
        private RecommendsInfo info;
        final ImageView ivBanner;

        NodeC(Context context, ViewGroup viewGroup, BaseViewHolder.OnItemClickListener onItemClickListener) {
            super(context, viewGroup, R.layout.splash_node_c, 2, onItemClickListener);
            this.ivBanner = (ImageView) this.itemView.findViewById(R.id.iv_banner);
            this.displayMatrix = new Matrix();
            this.itemView.setOnClickListener(this);
            new Report().eventType("1001").itemId("7158").indexId("7001").report(false);
        }

        @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
        public void bindData(RecommendsInfo recommendsInfo) {
            RecommendsInfo.Item item;
            this.info = recommendsInfo;
            Iterator<RecommendsInfo.Item> it = recommendsInfo.items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    item = null;
                    break;
                } else {
                    item = it.next();
                    if (item.type == 12) {
                        break;
                    }
                }
            }
            if (item != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivBanner.getLayoutParams();
                layoutParams.width = -1;
                this.ivBanner.setLayoutParams(layoutParams);
                ImageBridge.loadImage(this.ivBanner.getContext(), item.image, R.drawable.bg_defualt_image, -1, 0, this.ivBanner, this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewUtils.isFastClick()) {
                return;
            }
            RecommendsInfo.Item item = null;
            int i = 7001;
            Iterator<RecommendsInfo.Item> it = this.info.items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RecommendsInfo.Item next = it.next();
                if (next.type == 12) {
                    item = next;
                    break;
                }
                i++;
            }
            Bundle bundle = new Bundle();
            if (item != null && !TextUtils.isEmpty(item.question)) {
                bundle.putString(Router.ARGS_INIT_QUES, item.question);
            }
            Router.jump(this.ivBanner.getContext(), IM.class, bundle, false, true);
            new Report().eventType("1002").itemId("7158").indexId(String.valueOf(i)).report(false);
        }

        @Override // com.tencent.grobot.lite.core.IServiceCallback
        public void onResult(int i, String str, Object... objArr) {
            Bitmap bitmap;
            if (i == 1) {
                Drawable drawable = this.ivBanner.getDrawable();
                if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                    return;
                }
                float dip2px = (ViewUtils.dip2px(this.ivBanner.getContext(), 71.0f) * 1.0f) / bitmap.getHeight();
                this.displayMatrix.setScale(dip2px, dip2px);
                this.ivBanner.setImageMatrix(this.displayMatrix);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivBanner.getLayoutParams();
                layoutParams.width = (int) (bitmap.getWidth() * dip2px);
                this.ivBanner.setLayoutParams(layoutParams);
            }
        }
    }
}
