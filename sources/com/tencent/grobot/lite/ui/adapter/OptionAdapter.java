package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.TextOptionViewHolder;
import java.util.List;

/* loaded from: classes2.dex */
public class OptionAdapter extends BaseViewAdapter<OptionItemInfo> {
    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        return 1;
    }

    public OptionAdapter(Context context) {
        super(context);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        return new TextOptionViewHolder(this.context, viewGroup, i, this.clickListener);
    }

    public void setOptionNode(List<OptionItemInfo> list) {
        setDatas(list);
    }

    public void onDestroy() {
        setDatas(null);
    }
}
