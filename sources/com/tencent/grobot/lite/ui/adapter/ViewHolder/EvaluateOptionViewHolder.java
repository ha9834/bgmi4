package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EvaluateOptionViewHolder extends BaseViewHolder<EvaluateItemInfo> implements View.OnClickListener {
    private Context context;
    private TextView textView;

    public EvaluateOptionViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
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
    public void bindData(EvaluateItemInfo evaluateItemInfo) {
        if (evaluateItemInfo != null) {
            this.itemView.setTag(evaluateItemInfo);
            this.textView.setText(evaluateItemInfo.optionText);
            ViewUtils.setBoldTypeface(this.context, this.textView);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clickListener != null) {
            EvaluateItemInfo evaluateItemInfo = (EvaluateItemInfo) view.getTag();
            if (evaluateItemInfo.itemLevel == 1) {
                evaluateItemInfo.fistClickText = evaluateItemInfo.optionText;
            }
            if (evaluateItemInfo.itemLevel == 2) {
                evaluateItemInfo.secondClickText = evaluateItemInfo.optionText;
            }
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
