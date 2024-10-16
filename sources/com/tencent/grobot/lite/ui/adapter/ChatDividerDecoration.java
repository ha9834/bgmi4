package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.ui.adapter.HFWrapper;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatQuItemViewHolder;

/* loaded from: classes2.dex */
public final class ChatDividerDecoration extends RecyclerView.h {
    private final int commonOffset;
    private final int selfOffset;

    public ChatDividerDecoration(Context context) {
        this.commonOffset = ViewUtils.dip2px(context, 5.0f);
        this.selfOffset = ViewUtils.dip2px(context, 10.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        RecyclerView.w childViewHolder = recyclerView.getChildViewHolder(view);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (childViewHolder instanceof HFWrapper.HeaderViewHolder) {
            super.getItemOffsets(rect, view, recyclerView, tVar);
            return;
        }
        if (childViewHolder instanceof ChatQuItemViewHolder) {
            int i = this.commonOffset;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition > 0 && adapter.getItemViewType(childAdapterPosition - 1) != 21) {
                i = this.selfOffset;
            }
            rect.set(0, i, 0, 0);
            return;
        }
        int i2 = this.commonOffset;
        int childAdapterPosition2 = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition2 > 0 && adapter.getItemViewType(childAdapterPosition2 - 1) == 21) {
            i2 = this.selfOffset;
        }
        rect.set(0, i2, 0, 0);
    }
}
