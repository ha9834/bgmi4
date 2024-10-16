package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.detail.DetailDialog;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.container.FrameActivity;

/* loaded from: classes2.dex */
public class SplashNodeItemView extends FrameLayout implements View.OnClickListener {
    final TimeOutIcon iconTimeout;
    RecommendsInfo.Item info;
    final ImageView ivDisplay;
    final View llViews;
    int parentIndex;
    final TextView tvTag;
    final TextView tvTitle;
    final TextView tvViews;
    final View vDivider;

    public SplashNodeItemView(Context context) {
        this(context, null);
    }

    public SplashNodeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplashNodeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.splash_node_item, (ViewGroup) this, true);
        this.ivDisplay = (ImageView) findViewById(R.id.iv_display);
        this.iconTimeout = (TimeOutIcon) findViewById(R.id.icon_timeout);
        this.tvTitle = (TextView) findViewById(R.id.tv_title);
        this.tvTag = (TextView) findViewById(R.id.tv_tag);
        this.llViews = findViewById(R.id.ll_views);
        this.tvViews = (TextView) findViewById(R.id.tv_views);
        this.vDivider = findViewById(R.id.v_divider);
        setOnClickListener(this);
        if (LangUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1) {
            this.tvViews.setTextDirection(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.info == null || !(getContext() instanceof FrameActivity)) {
            return;
        }
        DetailDialog detailDialog = (DetailDialog) ((FrameActivity) getContext()).getDialog(DetailDialog.class);
        detailDialog.setData(this.info, "", "", "1", this.parentIndex + 7001);
        detailDialog.showCustomDialog();
        Report subId = new Report().eventType("1001").itemId("7142").indexId(String.valueOf(this.parentIndex + 7001)).subId(this.info.resourceId);
        if (this.info.type == 10) {
            subId.itemSub1("3");
        } else if (this.info.type == 11) {
            subId.itemSub1("1");
        }
        subId.report(false);
    }

    public void setContent(RecommendsInfo.Item item, int i, boolean z) {
        this.info = item;
        ImageBridge.loadImage(getContext(), item.image, R.drawable.bg_defualt_image, -1, 0, this.ivDisplay);
        if (item.type == 10) {
            this.iconTimeout.setVisibility(0);
            this.iconTimeout.setTime(item.vt);
        } else {
            this.iconTimeout.setVisibility(8);
        }
        if (item.icon == -1) {
            this.tvTitle.setText(item.name);
        } else {
            String string = getContext().getString(item.icon == 1 ? R.string.splash_news : R.string.splash_hot);
            SpannableString spannableString = new SpannableString(string + " " + item.name);
            Drawable b = a.b(getContext(), item.icon == 1 ? R.drawable.icon_recommend_icon_new : R.drawable.icon_recommend_icon_hot);
            if (b != null) {
                spannableString.setSpan(new IconSpan(getContext(), b, androidx.core.content.a.c(getContext(), R.color.recommends_node_title), 7), 0, string.length(), 33);
                this.tvTitle.setText(spannableString);
            } else {
                this.tvTitle.setText(item.name);
            }
        }
        if (!item.subtitle.isEmpty()) {
            this.tvTag.setVisibility(0);
            this.tvTag.setText("#" + item.subtitle.get(0));
        } else {
            this.tvTag.setVisibility(8);
        }
        if (item.views > 0) {
            this.llViews.setVisibility(0);
            this.tvViews.setText(ToolUtils.getViews(getContext(), item.views) + " " + this.tvTitle.getContext().getString(R.string.video_suffix));
        } else {
            this.llViews.setVisibility(8);
        }
        this.vDivider.setVisibility(z ? 0 : 8);
    }
}
