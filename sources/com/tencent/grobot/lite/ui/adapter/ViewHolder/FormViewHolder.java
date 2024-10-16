package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.FormNode;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class FormViewHolder extends BaseViewHolder<FormNode> implements View.OnClickListener {
    private Context context;
    private TextView textView;

    public FormViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_form, i, onItemClickListener);
        this.context = context;
        this.textView = (TextView) this.itemView.findViewById(R.id.desc);
        this.itemView.setOnClickListener(this);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(FormNode formNode) {
        if (formNode != null) {
            this.itemView.setTag(formNode);
            ViewUtils.setBoldTypeface(this.context, this.textView);
            new Report().eventType("1001").itemId("7061").report(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clickListener != null) {
            this.clickListener.onItemClick(view, getAdapterPosition(), this.viewHolderType, view.getTag());
        }
    }
}
