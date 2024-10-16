package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.TicketNode;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class TicketViewHolder extends BaseViewHolder<TicketNode> implements View.OnClickListener {
    private Context context;
    private TextView textView;

    public TicketViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_item_form, i, onItemClickListener);
        this.context = context;
        this.textView = (TextView) this.itemView.findViewById(R.id.desc);
        this.itemView.setOnClickListener(this);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(TicketNode ticketNode) {
        if (ticketNode != null) {
            this.itemView.setTag(ticketNode);
            this.textView.setText(this.context.getString(R.string.ticket_entrance));
            ViewUtils.setBoldTypeface(this.context, this.textView);
            new Report().eventType("1001").itemId("7064").report(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clickListener != null) {
            this.clickListener.onItemClick(view, getAdapterPosition(), this.viewHolderType, view.getTag());
        }
    }
}
