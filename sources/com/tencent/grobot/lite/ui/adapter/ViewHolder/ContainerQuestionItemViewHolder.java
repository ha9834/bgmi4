package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.ContainerInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class ContainerQuestionItemViewHolder extends BaseViewHolder<ContainerInfo> {
    private boolean firstBind;
    private ImageView ivBanner;
    private TextView tvName;

    public ContainerQuestionItemViewHolder(Context context, ViewGroup viewGroup, int i, final BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_container_question_item, i, onItemClickListener);
        this.firstBind = true;
        this.ivBanner = (ImageView) this.itemView.findViewById(R.id.iv_banner);
        this.tvName = (TextView) this.itemView.findViewById(R.id.tv_name);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ContainerQuestionItemViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onItemClickListener.onItemClick(view, 0, 0, ContainerQuestionItemViewHolder.this.itemView.getTag());
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(ContainerInfo containerInfo) {
        if (containerInfo == null || containerInfo.questionInfo == null) {
            return;
        }
        this.tvName.setText(containerInfo.questionInfo.name);
        ImageBridge.loadImage(this.ivBanner.getContext(), containerInfo.questionInfo.image, R.drawable.bg_defualt_image, -1, 0, this.ivBanner);
        this.itemView.setTag(containerInfo);
    }
}
