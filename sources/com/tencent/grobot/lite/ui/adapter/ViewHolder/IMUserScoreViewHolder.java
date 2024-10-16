package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.IMStarNode;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class IMUserScoreViewHolder extends BaseViewHolder<IMStarNode> {
    private Context context;
    private int rating;
    private RatingBar ratingBar;
    private TextView titleView;

    public IMUserScoreViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_ticket_star_item, i, onItemClickListener);
        this.rating = 0;
        this.context = context;
        this.titleView = (TextView) this.itemView.findViewById(R.id.title);
        this.ratingBar = (RatingBar) this.itemView.findViewById(R.id.ratingbar);
        this.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.IMUserScoreViewHolder.1
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                int i2;
                if (IMUserScoreViewHolder.this.clickListener == null || (i2 = (int) f) <= 0 || i2 == IMUserScoreViewHolder.this.rating) {
                    return;
                }
                ratingBar.setIsIndicator(true);
                IMStarNode iMStarNode = (IMStarNode) IMUserScoreViewHolder.this.itemView.getTag();
                iMStarNode.rating = i2;
                IMUserScoreViewHolder.this.clickListener.onItemClick(IMUserScoreViewHolder.this.itemView, IMUserScoreViewHolder.this.getAdapterPosition(), IMUserScoreViewHolder.this.viewHolderType, iMStarNode);
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(IMStarNode iMStarNode) {
        if (iMStarNode != null) {
            this.itemView.setTag(iMStarNode);
            ViewUtils.setBoldTypeface(this.context, this.titleView);
            this.rating = DataManager.getInstance().getSessionRating(iMStarNode.sessionId);
            if (this.rating != -1) {
                this.ratingBar.setIsIndicator(true);
                this.ratingBar.setRating(iMStarNode.rating);
            } else {
                this.ratingBar.setIsIndicator(false);
                this.ratingBar.setRating(0.0f);
            }
            new Report().eventType("1001").itemId("7059").report(false);
        }
    }
}
