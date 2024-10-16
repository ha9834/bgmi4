package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public class RecyclerViewHeader extends LinearLayout {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_REFRESHING = 2;
    private LinearLayout mContainer;
    private RelativeLayout mRealityContent;
    private TextView titleView;

    public RecyclerViewHeader(Context context) {
        this(context, null);
    }

    public RecyclerViewHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.mContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recyclerview_header_layout, (ViewGroup) getParent(), true);
        addView(this.mContainer, layoutParams);
        setGravity(81);
        this.mRealityContent = (RelativeLayout) this.mContainer.findViewById(R.id.pullRefresh_reality_content);
        this.titleView = (TextView) this.mContainer.findViewById(R.id.pullRefresh_text);
        ViewUtils.setBoldTypeface(context, this.titleView);
    }

    public int getRealityHeight() {
        return this.mRealityContent.getHeight();
    }

    public void setVisibleHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public int getVisibleHeight() {
        return this.mContainer.getLayoutParams().height;
    }

    public void setPullText(boolean z) {
        if (z) {
            this.titleView.setText(getContext().getString(R.string.chat_history_text));
        } else {
            this.titleView.setText(getContext().getString(R.string.chat_history_no_more));
        }
        ViewUtils.setBoldTypeface(getContext(), this.titleView);
    }
}
