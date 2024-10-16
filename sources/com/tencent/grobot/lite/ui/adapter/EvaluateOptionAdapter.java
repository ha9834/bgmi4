package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.EvaluateOptionViewHolder;
import java.util.List;

/* loaded from: classes2.dex */
public class EvaluateOptionAdapter extends BaseViewAdapter<EvaluateItemInfo> {
    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        return 1;
    }

    public EvaluateOptionAdapter(Context context) {
        super(context);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        return new EvaluateOptionViewHolder(this.context, viewGroup, i, this.clickListener);
    }

    public void setOptionNode(List<EvaluateItemInfo> list) {
        setDatas(list);
    }

    public void onDestroy() {
        setDatas(null);
    }
}
