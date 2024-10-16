package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.model.node.VideoItem;
import com.tencent.grobot.lite.model.node.VideoNode;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.BaseViewAdapter;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.view.component.HorizontalView;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class VideoViewHolder extends BaseViewHolder<VideoNode> {
    private BaseViewAdapter adapter;
    private boolean firstBind;
    private HorizontalView horizontalView;

    public VideoViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_video, i, onItemClickListener);
        this.firstBind = true;
        this.horizontalView = (HorizontalView) this.itemView.findViewById(R.id.video_view);
        this.adapter = new BaseViewAdapter<VideoItem>(context) { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.VideoViewHolder.1
            @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
            protected int getItemViewTypeByPosition(int i2) {
                return 1;
            }

            @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
            protected BaseViewHolder buildViewHolder(ViewGroup viewGroup2, int i2) {
                return new VideoItemViewHolder(this.context, viewGroup2, VideoViewHolder.this.viewHolderType, new BaseViewHolder.OnItemClickListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.VideoViewHolder.1.1
                    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder.OnItemClickListener
                    public void onItemClick(View view, int i3, int i4, Object obj) {
                        AnonymousClass1.this.clickListener.onItemClick(view, i3, i4, obj);
                    }
                });
            }
        };
        this.adapter.setClickListener(onItemClickListener);
        this.horizontalView.setAdapter(this.adapter);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(VideoNode videoNode) {
        if (videoNode == null || videoNode.videoItemList.size() <= 0) {
            return;
        }
        BaseViewAdapter baseViewAdapter = this.adapter;
        if (baseViewAdapter != null) {
            baseViewAdapter.setDatas(videoNode.videoItemList);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            if (videoNode.videoItemList.size() == 1) {
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7128");
            } else {
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7129");
            }
            Iterator<VideoItem> it = videoNode.videoItemList.iterator();
            while (it.hasNext()) {
                VideoItem next = it.next();
                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "3");
                jSONObject.put(ReportBridge.KEY_SUB_ID, next.resourceId);
                if (this.firstBind) {
                    ReportBridge.report(jSONObject, false);
                }
            }
            this.firstBind = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
