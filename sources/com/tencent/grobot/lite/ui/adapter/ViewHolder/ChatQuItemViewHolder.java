package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.view.CircleImageView;

/* loaded from: classes2.dex */
public class ChatQuItemViewHolder extends BaseViewHolder<QuTextNode> implements View.OnClickListener {
    private Context context;
    private CircleImageView ivUser;
    private ImageView sendErr;
    private ProgressBar sending;
    private TextView textView;

    public ChatQuItemViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_text_self, i, onItemClickListener);
        this.context = context;
        this.textView = (TextView) this.itemView.findViewById(R.id.chat_content);
        this.sending = (ProgressBar) this.itemView.findViewById(R.id.sending_layout);
        this.sendErr = (ImageView) this.itemView.findViewById(R.id.send_err_layout);
        this.sendErr.setOnClickListener(this);
        this.ivUser = (CircleImageView) this.itemView.findViewById(R.id.iv_user);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(QuTextNode quTextNode) {
        if (quTextNode != null) {
            if (quTextNode.text.equals("evaluate:helpfull")) {
                SpannableString spannableString = new SpannableString(quTextNode.text);
                Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_good);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableString.setSpan(new ImageSpan(drawable), 0, quTextNode.text.length(), 33);
                this.textView.setText(spannableString);
            } else {
                this.textView.setText(quTextNode.text);
                ViewUtils.setBoldTypeface(this.context, this.textView);
            }
            if (quTextNode.quSendingState == 0) {
                this.sending.setVisibility(0);
                this.sendErr.setVisibility(8);
            } else if (quTextNode.quSendingState == 2) {
                this.sending.setVisibility(8);
                this.sendErr.setVisibility(0);
            } else {
                this.sending.setVisibility(8);
                this.sendErr.setVisibility(8);
            }
            this.sendErr.setTag(quTextNode);
            if (this.ivUser == null || TextUtils.isEmpty(GRobotApplication.getInstance().headerUrl())) {
                return;
            }
            ImageBridge.loadImage(this.context, GRobotApplication.getInstance().headerUrl(), R.drawable.bg_defualt_image, -1, 0, this.ivUser);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clickListener != null) {
            this.clickListener.onItemClick(view, getAdapterPosition(), this.viewHolderType, view.getTag());
        }
    }
}
