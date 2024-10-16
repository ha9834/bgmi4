package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.model.local.ContainerInfo;
import com.tencent.grobot.lite.model.node.ContainerNode;
import com.tencent.grobot.lite.ui.adapter.BaseViewAdapter;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.view.component.HorizontalView;

/* loaded from: classes2.dex */
public class ContainerHolder extends BaseViewHolder<ContainerNode> {
    private static final int TYPE_COMMON = 1;
    private static final int TYPE_QUESTION = 2;
    private BaseViewAdapter adapter;
    private HorizontalView horizontalView;

    public ContainerHolder(Context context, ViewGroup viewGroup, int i, final BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_container, i, onItemClickListener);
        this.horizontalView = (HorizontalView) this.itemView.findViewById(R.id.container_view);
        this.adapter = new BaseViewAdapter<ContainerInfo>(context) { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ContainerHolder.1
            @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
            protected BaseViewHolder buildViewHolder(ViewGroup viewGroup2, int i2) {
                if (i2 == 1) {
                    return new ContainerItemViewHolder(this.context, viewGroup2, ContainerHolder.this.viewHolderType, onItemClickListener);
                }
                return new ContainerQuestionItemViewHolder(this.context, viewGroup2, ContainerHolder.this.viewHolderType, onItemClickListener);
            }

            @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
            protected int getItemViewTypeByPosition(int i2) {
                return ((ContainerInfo) this.datas.get(i2)).itemType == 4 ? 2 : 1;
            }
        };
        this.adapter.setClickListener(onItemClickListener);
        this.horizontalView.setAdapter(this.adapter);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(ContainerNode containerNode) {
        BaseViewAdapter baseViewAdapter;
        if (containerNode == null || containerNode.nodeList.size() <= 0 || (baseViewAdapter = this.adapter) == null) {
            return;
        }
        baseViewAdapter.setDatas(containerNode.nodeList);
    }
}
