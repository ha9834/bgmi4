package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.node.GiftNode;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GiftViewHolder extends BaseViewHolder<GiftNode> {
    private Context context;
    private GiftNode data;
    private TextView descText;
    private ImageView iconImage;
    private TextView receiveBtn;
    private TextView titleText;

    public GiftViewHolder(Context context, ViewGroup viewGroup, int i, final BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_gift, i, null);
        this.context = context;
        this.iconImage = (ImageView) this.itemView.findViewById(R.id.icon);
        this.titleText = (TextView) this.itemView.findViewById(R.id.title);
        this.descText = (TextView) this.itemView.findViewById(R.id.desc);
        this.receiveBtn = (TextView) this.itemView.findViewById(R.id.receiveBtn);
        ViewUtils.setBoldTypeface(context, this.titleText);
        ViewUtils.setBoldTypeface(context, this.descText);
        ViewUtils.setBoldTypeface(context, this.receiveBtn);
        this.clickListener = onItemClickListener;
        this.receiveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.GiftViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseViewHolder.OnItemClickListener onItemClickListener2 = onItemClickListener;
                if (onItemClickListener2 != null) {
                    onItemClickListener2.onItemClick(GiftViewHolder.this.itemView, GiftViewHolder.this.getAdapterPosition(), GiftViewHolder.this.getItemViewType(), GiftViewHolder.this.data);
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7156");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, GiftViewHolder.this.data.amsId + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + GiftViewHolder.this.data.groupId);
                    jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, Constants.VIA_SHARE_TYPE_INFO);
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(GiftNode giftNode) {
        if (giftNode != null) {
            this.data = giftNode;
            this.titleText.setText(giftNode.name);
            this.descText.setText(giftNode.desc);
            ImageBridge.loadImage(this.context, giftNode.imageUrl, R.drawable.bg_defualt_image, -1, 0, this.iconImage);
            if (giftNode.isReceived) {
                this.receiveBtn.setBackgroundResource(R.drawable.bg_gift_received);
                this.receiveBtn.setTextColor(this.context.getResources().getColor(R.color.gift_color_received));
                this.receiveBtn.setEnabled(false);
            } else {
                this.receiveBtn.setBackgroundResource(R.drawable.bg_hot_selected);
                this.receiveBtn.setTextColor(this.context.getResources().getColor(R.color.gift_color_get));
                this.receiveBtn.setEnabled(true);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7156");
                jSONObject.put(ReportBridge.KEY_SUB_ID, giftNode.amsId + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + giftNode.groupId);
                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, Constants.VIA_SHARE_TYPE_INFO);
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
