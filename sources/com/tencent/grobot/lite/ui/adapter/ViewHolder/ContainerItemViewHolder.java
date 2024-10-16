package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.ContainerInfo;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ContainerItemViewHolder extends BaseViewHolder<ContainerInfo> {
    private TextView descText;
    private boolean firstBind;
    private ImageView image;
    private FrameActivity mContext;
    private View playIcon;
    private View tipIcon;

    public ContainerItemViewHolder(Context context, ViewGroup viewGroup, int i, final BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_container_item, i, onItemClickListener);
        this.firstBind = true;
        this.mContext = (FrameActivity) context;
        this.image = (ImageView) this.itemView.findViewById(R.id.container_image);
        this.playIcon = this.itemView.findViewById(R.id.icon_play);
        this.tipIcon = this.itemView.findViewById(R.id.icon_tip);
        this.descText = (TextView) this.itemView.findViewById(R.id.container_desc);
        ViewUtils.setBoldTypeface(context, this.descText);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ContainerItemViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof ContainerInfo) {
                    onItemClickListener.onItemClick(view, ContainerItemViewHolder.this.getAdapterPosition(), 0, ContainerItemViewHolder.this.itemView.getTag());
                }
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(ContainerInfo containerInfo) {
        if (containerInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7138");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 8001));
                if (containerInfo.itemType == 1) {
                    if (containerInfo.picInfo != null) {
                        ImageBridge.loadImage(this.mContext, containerInfo.picInfo.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.image);
                        this.descText.setText(containerInfo.picInfo.name);
                    }
                    this.playIcon.setVisibility(8);
                    this.tipIcon.setVisibility(8);
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "2");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, containerInfo.picInfo.resourceId);
                } else if (containerInfo.itemType == 2) {
                    if (containerInfo.videoInfo != null) {
                        ImageBridge.loadImage(this.mContext, containerInfo.videoInfo.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.image);
                        this.descText.setText(containerInfo.videoInfo.name);
                    }
                    this.playIcon.setVisibility(0);
                    this.tipIcon.setVisibility(8);
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, containerInfo.videoInfo.resourceId);
                } else if (containerInfo.itemType == 3) {
                    if (containerInfo.tipInfo != null) {
                        ImageBridge.loadImage(this.mContext, containerInfo.tipInfo.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.image);
                        this.descText.setText(containerInfo.tipInfo.title);
                    }
                    this.playIcon.setVisibility(8);
                    this.tipIcon.setVisibility(0);
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, containerInfo.tipInfo.resourceId);
                }
                if (this.firstBind) {
                    ReportBridge.report(jSONObject, false);
                    this.firstBind = false;
                }
                this.itemView.setTag(containerInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
