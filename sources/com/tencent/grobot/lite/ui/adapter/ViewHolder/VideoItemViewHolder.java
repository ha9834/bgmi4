package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.node.VideoItem;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.youtube.YoutubeParams;
import com.tencent.grobot.lite.youtube.YoutubePlayerDelegate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class VideoItemViewHolder extends BaseViewHolder<VideoItem> implements View.OnClickListener {
    private TextView descText;
    private ImageView imageView;
    private FrameActivity mContext;
    private View playIcon;
    private View tipIcon;

    public VideoItemViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_container_item, i, onItemClickListener);
        this.mContext = (FrameActivity) context;
        this.imageView = (ImageView) this.itemView.findViewById(R.id.container_image);
        this.playIcon = this.itemView.findViewById(R.id.icon_play);
        this.tipIcon = this.itemView.findViewById(R.id.icon_tip);
        this.descText = (TextView) this.itemView.findViewById(R.id.container_desc);
        ViewUtils.setBoldTypeface(context, this.descText);
        this.itemView.setOnClickListener(this);
    }

    private void playVideo(VideoItem videoItem) {
        YoutubePlayerDelegate.play(this.mContext, new YoutubeParams(videoItem.videoId, videoItem.name));
        ReportBridge.reportViewsClick(0, videoItem.resourceId);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7128");
            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
            jSONObject.put(ReportBridge.KEY_SUB_ID, videoItem.resourceId);
            ReportBridge.report(jSONObject, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(VideoItem videoItem) {
        if (videoItem != null) {
            this.descText.setText(videoItem.name);
            ImageBridge.loadImage(this.mContext, videoItem.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.imageView);
            this.itemView.setTag(videoItem);
            this.playIcon.setVisibility(0);
            this.tipIcon.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof VideoItem) {
            playVideo((VideoItem) tag);
        }
    }
}
