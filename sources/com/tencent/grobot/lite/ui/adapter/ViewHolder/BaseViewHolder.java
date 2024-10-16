package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class BaseViewHolder<T> extends RecyclerView.w {
    protected OnItemClickListener clickListener;
    int viewHolderType;

    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i, int i2, Object obj);
    }

    public abstract void bindData(T t);

    public void setIsLastItem(boolean z) {
    }

    public BaseViewHolder(Context context, ViewGroup viewGroup, int i, int i2, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(i, viewGroup, false));
        this.viewHolderType = i2;
        this.clickListener = onItemClickListener;
    }

    public BaseViewHolder(View view, int i, OnItemClickListener onItemClickListener) {
        super(view);
        this.viewHolderType = i;
        this.clickListener = onItemClickListener;
    }
}
