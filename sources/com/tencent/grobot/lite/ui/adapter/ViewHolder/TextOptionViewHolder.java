package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TextOptionViewHolder extends BaseViewHolder<OptionItemInfo> implements View.OnClickListener {
    private Context context;
    private TextView textView;

    public TextOptionViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.option_text_item, i, onItemClickListener);
        this.context = context;
        this.textView = (TextView) this.itemView.findViewById(R.id.option_text_item_layout);
        this.itemView.setOnClickListener(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject.put(ReportBridge.KEY_ITEM_ID, "7001");
            ReportBridge.report(jSONObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(OptionItemInfo optionItemInfo) {
        if (optionItemInfo != null) {
            this.itemView.setTag(optionItemInfo);
            this.textView.setText(optionItemInfo.optionText);
            ViewUtils.setBoldTypeface(this.context, this.textView);
            TextOptionViewHolderCompat.setTvBg(this.textView, getAdapterPosition());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clickListener != null) {
            this.clickListener.onItemClick(view, getAdapterPosition(), this.viewHolderType, view.getTag());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7001");
                jSONObject.put(ReportBridge.KEY_INDEX_ID, String.valueOf(getAdapterPosition() + 7001));
                ReportBridge.report(jSONObject, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
