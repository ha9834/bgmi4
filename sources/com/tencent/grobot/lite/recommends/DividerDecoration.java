package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.recommends.SplashAdapter;
import com.tencent.grobot.lite.ui.view.EndlessRecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class DividerDecoration extends RecyclerView.h {
    final int offset;
    private final boolean rtl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DividerDecoration(Context context, float f) {
        this.offset = ViewUtils.dip2px(context, f);
        this.rtl = LangUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (recyclerView.getAdapter() instanceof EndlessRecyclerView.EndlessAdapterWrapper) {
            int headerCount = childAdapterPosition - ((EndlessRecyclerView.EndlessAdapterWrapper) recyclerView.getAdapter()).headerCount();
            if (headerCount >= 0) {
                if (headerCount % 2 == 1) {
                    if (this.rtl) {
                        int i = this.offset;
                        rect.set(i, 0, 0, i);
                        return;
                    } else {
                        rect.set(0, 0, 0, this.offset);
                        return;
                    }
                }
                if (this.rtl) {
                    int i2 = this.offset;
                    rect.set(i2, 0, 0, i2);
                    return;
                } else {
                    int i3 = this.offset;
                    rect.set(0, 0, i3, i3);
                    return;
                }
            }
            return;
        }
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            int b = ((StaggeredGridLayoutManager.b) view.getLayoutParams()).b();
            RecyclerView.w childViewHolder = recyclerView.getChildViewHolder(view);
            if (b == 0) {
                rect.set(0, (childAdapterPosition <= 1 || (childViewHolder instanceof SplashAdapter.NodeC)) ? 0 : this.offset, this.offset, 0);
                return;
            } else {
                rect.set(0, (childAdapterPosition <= 1 || (childViewHolder instanceof SplashAdapter.NodeC)) ? 0 : this.offset, 0, 0);
                return;
            }
        }
        if (childAdapterPosition % 2 == 1) {
            rect.set(0, 0, 0, this.offset);
        } else if (this.rtl) {
            int i4 = this.offset;
            rect.set(i4, 0, 0, i4);
        } else {
            int i5 = this.offset;
            rect.set(0, 0, i5, i5);
        }
    }
}
