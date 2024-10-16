package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.node.PicNode;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.Pic;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.Router;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PicViewHolder extends BaseViewHolder<PicNode> implements View.OnClickListener {
    private Context context;
    private boolean firstBind;
    private ImageView imageView;

    public PicViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_pic, i, onItemClickListener);
        this.firstBind = true;
        this.context = context;
        this.imageView = (ImageView) this.itemView.findViewById(R.id.container_image);
        this.imageView.setOnClickListener(this);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(PicNode picNode) {
        if (picNode != null) {
            ImageBridge.loadImage(this.context, picNode.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.imageView);
            this.imageView.setTag(picNode);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7043");
                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "2");
                jSONObject.put(ReportBridge.KEY_SUB_ID, picNode.resourceId);
                if (this.firstBind) {
                    ReportBridge.report(jSONObject, false);
                    this.firstBind = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PicNode) {
            Bundle bundle = new Bundle();
            PicNode picNode = (PicNode) tag;
            bundle.putString("img_url", picNode.url);
            bundle.putString("resource_id", picNode.resourceId);
            Router.jump(this.context, Pic.class, bundle, false, true);
            ReportBridge.reportViewsClick(1, picNode.resourceId);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7043");
                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "2");
                jSONObject.put(ReportBridge.KEY_SUB_ID, ((PicNode) tag).resourceId);
                ReportBridge.report(jSONObject, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
