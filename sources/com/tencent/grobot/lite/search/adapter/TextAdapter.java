package com.tencent.grobot.lite.search.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.grobot.lite.search.OnItemClickListener;
import com.tencent.grobot.lite.search.holder.TextItemViewHolder;
import com.tencent.grobot.lite.search.model.TextItem;
import com.tencent.grobot.lite.ui.adapter.BaseViewAdapter;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class TextAdapter extends BaseViewAdapter<TextItem> {
    private OnItemClickListener itemClickListener;

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        return 1;
    }

    public TextAdapter(Context context, OnItemClickListener onItemClickListener) {
        super(context);
        this.itemClickListener = onItemClickListener;
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        return new TextItemViewHolder(this.context, viewGroup, i, this.itemClickListener);
    }

    public void onDestroy() {
        setDatas(null);
    }
}
