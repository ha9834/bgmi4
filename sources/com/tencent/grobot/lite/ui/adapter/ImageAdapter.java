package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.ImageHolder;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ImageAdapter extends BaseViewAdapter<String> {
    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        return 1;
    }

    public ImageAdapter(Context context) {
        super(context);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        return new ImageHolder(this.context, viewGroup, i, null);
    }

    public void onDestroy() {
        setDatas(null);
    }

    public void setImages(ArrayList<String> arrayList) {
        setDatas(arrayList);
    }
}
