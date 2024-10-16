package com.tencent.grobot.lite.ui.adapter;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class HFWrapper extends RecyclerView.a<RecyclerView.w> {
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;
    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private RecyclerView.a mInnerAdapter;
    public SparseArray<View> mHeaderViews = new SparseArray<>();
    private SparseIntArray mFooterIds = new SparseIntArray();
    private boolean footerShowed = false;

    public HFWrapper(RecyclerView.a aVar) {
        this.mInnerAdapter = aVar;
    }

    private boolean isHeaderViewPos(int i) {
        return i < getHeadersCount();
    }

    private boolean isFooterViewPos(int i) {
        return this.footerShowed && i >= getHeadersCount() + getRealItemCount();
    }

    public void addHeaderView(View view) {
        SparseArray<View> sparseArray = this.mHeaderViews;
        sparseArray.put(sparseArray.size() + BASE_ITEM_TYPE_HEADER, view);
    }

    public void addFooter(int i) {
        SparseIntArray sparseIntArray = this.mFooterIds;
        sparseIntArray.put(sparseIntArray.size() + BASE_ITEM_TYPE_FOOTER, i);
    }

    public int getHeadersCount() {
        return this.mHeaderViews.size();
    }

    public int getFootersCount() {
        if (this.footerShowed) {
            return this.mFooterIds.size();
        }
        return 0;
    }

    private int getRealItemCount() {
        return this.mInnerAdapter.getItemCount();
    }

    public void showFooter(boolean z) {
        this.footerShowed = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mHeaderViews.get(i) != null) {
            return new HeaderViewHolder(this.mHeaderViews.get(i));
        }
        if (this.mFooterIds.get(i) != 0) {
            return new FooterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.mFooterIds.get(i), viewGroup, false));
        }
        return this.mInnerAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        if (isHeaderViewPos(i)) {
            return this.mHeaderViews.keyAt(i);
        }
        if (isFooterViewPos(i)) {
            return this.mFooterIds.keyAt((i - getHeadersCount()) - getRealItemCount());
        }
        return this.mInnerAdapter.getItemViewType(i - getHeadersCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (isHeaderViewPos(i) || isFooterViewPos(i)) {
            return;
        }
        this.mInnerAdapter.onBindViewHolder(wVar, i - getHeadersCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return getHeadersCount() + getRealItemCount() + getFootersCount();
    }

    /* loaded from: classes2.dex */
    static final class HeaderViewHolder extends RecyclerView.w {
        HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* loaded from: classes2.dex */
    static final class FooterViewHolder extends RecyclerView.w {
        FooterViewHolder(View view) {
            super(view);
        }
    }
}
