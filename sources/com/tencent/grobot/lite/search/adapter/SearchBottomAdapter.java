package com.tencent.grobot.lite.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.search.OnItemClickListener;
import com.tencent.grobot.lite.search.holder.ResultBottomViewHolder;
import com.tencent.grobot.lite.search.holder.ResultViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SearchBottomAdapter extends RecyclerView.a<RecyclerView.w> {
    public static final int ITEM_TYPE_BOTTOM = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    private Context mContext;
    private OnItemClickListener mItemClickListener;
    private LayoutInflater mLayoutInflater;
    private ArrayList<RecommendsInfo.Item> mData = new ArrayList<>();
    private int mBottomCount = 1;
    private String mKeyword = "";

    public SearchBottomAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mItemClickListener = onItemClickListener;
    }

    public void setData(String str, List<RecommendsInfo.Item> list) {
        this.mKeyword = str;
        this.mData.clear();
        this.mData.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        return (this.mBottomCount == 0 || i < getContentItemCount()) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ResultBottomViewHolder(this.mContext, viewGroup, this.mItemClickListener);
        }
        if (i == 1) {
            return new ResultViewHolder(this.mContext, viewGroup, this.mItemClickListener);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (getItemViewType(i) == 1) {
            if (wVar instanceof ResultViewHolder) {
                ((ResultViewHolder) wVar).bindData(this.mData.get(i));
            }
        } else if (getItemViewType(i) == 0 && (wVar instanceof ResultBottomViewHolder)) {
            ((ResultBottomViewHolder) wVar).setMsg(this.mKeyword);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.mBottomCount + getContentItemCount();
    }

    private int getContentItemCount() {
        ArrayList<RecommendsInfo.Item> arrayList = this.mData;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
