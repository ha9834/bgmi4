package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.TicketStarNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class TicketStarViewHolder extends BaseViewHolder<TicketStarNode> {
    private Context context;
    private int rating;
    private RatingBar ratingBar;
    private TextView titleView;

    public TicketStarViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_ticket_star_item, i, onItemClickListener);
        this.rating = 0;
        this.context = context;
        this.titleView = (TextView) this.itemView.findViewById(R.id.title);
        this.ratingBar = (RatingBar) this.itemView.findViewById(R.id.ratingbar);
        this.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.TicketStarViewHolder.1
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                int i2;
                if (TicketStarViewHolder.this.clickListener == null || (i2 = (int) f) <= 0 || i2 == TicketStarViewHolder.this.rating) {
                    return;
                }
                ratingBar.setIsIndicator(true);
                TicketStarNode ticketStarNode = (TicketStarNode) TicketStarViewHolder.this.itemView.getTag();
                ticketStarNode.rating = i2;
                TicketStarViewHolder.this.clickListener.onItemClick(TicketStarViewHolder.this.itemView, TicketStarViewHolder.this.getAdapterPosition(), TicketStarViewHolder.this.viewHolderType, ticketStarNode);
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(TicketStarNode ticketStarNode) {
        if (ticketStarNode != null) {
            this.itemView.setTag(ticketStarNode);
            ViewUtils.setBoldTypeface(this.context, this.titleView);
            this.rating = DataManager.getInstance().getTicketStarRating(ticketStarNode.ticketId);
            if (this.rating != -1) {
                this.ratingBar.setIsIndicator(true);
                this.ratingBar.setRating(this.rating);
            } else {
                this.ratingBar.setIsIndicator(false);
                this.ratingBar.setRating(0.0f);
            }
        }
    }
}
