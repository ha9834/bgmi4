package com.tencent.grobot.lite.ui.dialog;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;

/* loaded from: classes2.dex */
public final class TipDialog extends FrameDialog {
    private LinearLayout rootContent;
    private ScrollView scrollView;
    private TextView titleView;

    public TipDialog(FrameActivity frameActivity) {
        super(frameActivity);
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.dialog_tip, (ViewGroup) this, false);
        setBackgroundResource(android.R.color.transparent);
        this.titleView = (TextView) inflate.findViewById(R.id.title);
        ViewUtils.setBoldTypeface(getContext(), this.titleView);
        this.rootContent = (LinearLayout) inflate.findViewById(R.id.content);
        inflate.findViewById(R.id.closeBtn).setOnClickListener(this);
        this.scrollView = (ScrollView) inflate.findViewById(R.id.contentLayout);
        return inflate;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.closeBtn) {
            dismissCustomDialog();
        }
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    public void showCustomDialog() {
        ScrollView scrollView = this.scrollView;
        if (scrollView != null) {
            scrollView.scrollTo(0, 0);
        }
        super.showCustomDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.widget.LinearLayout] */
    public void setData(String str, MixTipInfo mixTipInfo) {
        ?? textView;
        LinearLayout.LayoutParams layoutParams;
        if (TextUtils.isEmpty(str) || mixTipInfo == null || mixTipInfo.items == null || mixTipInfo.items.isEmpty()) {
            dismissCustomDialog();
            return;
        }
        this.titleView.setText(str);
        ViewUtils.setBoldTypeface(getContext(), this.titleView);
        if (this.rootContent.getChildCount() > 0) {
            this.rootContent.removeAllViews();
        }
        for (MixTipInfo.Item item : mixTipInfo.items) {
            if (item.type == 0) {
                textView = new ImageView(this.context);
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                layoutParams.topMargin = ViewUtils.dip2px(this.context, 10.0f);
                textView.setLayoutParams(layoutParams);
                textView.setAdjustViewBounds(true);
                ImageBridge.loadImage(this.context, item.source, R.drawable.bg_defualt_image, -1, 0, textView);
            } else {
                textView = new TextView(this.context);
                TipDialogCompat.initTipText(textView);
                textView.setText(item.source);
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                ViewUtils.setTypeface(this.context, textView);
            }
            this.rootContent.addView(textView, layoutParams);
        }
    }
}
