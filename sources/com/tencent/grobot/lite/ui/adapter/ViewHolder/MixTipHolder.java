package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.model.node.MixTipNode;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.dialog.TipDialog;
import com.tencent.grobot.lite.ui.view.ChatTextView;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class MixTipHolder extends BaseViewHolder<MixTipNode> implements View.OnClickListener {
    private FrameActivity context;
    private TextView descText;
    private boolean firstBind;
    private ImageView ivThumb;
    private TextView moreText;
    private ChatTextView titleText;

    public MixTipHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_mixtip, i, onItemClickListener);
        this.firstBind = true;
        this.context = (FrameActivity) context;
        this.titleText = (ChatTextView) this.itemView.findViewById(R.id.chat_content);
        this.titleText.setMaxLines(2);
        ViewUtils.setBoldTypeface(this.context, this.titleText);
        this.ivThumb = (ImageView) this.itemView.findViewById(R.id.iv);
        this.itemView.setOnClickListener(this);
        this.descText = (TextView) this.itemView.findViewById(R.id.descText);
        ViewUtils.setBoldTypeface(this.context, this.descText);
        this.moreText = (TextView) this.itemView.findViewById(R.id.moreText);
        ViewUtils.setBoldTypeface(this.context, this.moreText);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(MixTipNode mixTipNode) {
        this.titleText.setText(mixTipNode.info.title);
        ImageBridge.loadImage(this.context, mixTipNode.info.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.ivThumb);
        this.itemView.setTag(mixTipNode.info);
        if (mixTipNode.info.items != null && !mixTipNode.info.items.isEmpty()) {
            for (int i = 0; i < mixTipNode.info.items.size(); i++) {
                MixTipInfo.Item item = mixTipNode.info.items.get(i);
                if (item.type == 1) {
                    this.descText.setText(item.source);
                    break;
                }
            }
        } else {
            this.descText.setText(mixTipNode.info.title);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7130");
            jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
            jSONObject.put(ReportBridge.KEY_SUB_ID, mixTipNode.info.resourceId);
            if (this.firstBind) {
                ReportBridge.report(jSONObject, false);
                this.firstBind = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof MixTipInfo) {
            MixTipInfo mixTipInfo = (MixTipInfo) view.getTag();
            TipDialog tipDialog = (TipDialog) this.context.getDialog(TipDialog.class);
            tipDialog.setData(mixTipInfo.title, mixTipInfo);
            tipDialog.showCustomDialog();
            ReportBridge.reportViewsClick(2, mixTipInfo.resourceId);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7130");
                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, "1");
                jSONObject.put(ReportBridge.KEY_SUB_ID, mixTipInfo.resourceId);
                ReportBridge.report(jSONObject, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
