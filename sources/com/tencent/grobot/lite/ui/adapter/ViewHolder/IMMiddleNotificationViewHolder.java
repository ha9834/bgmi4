package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.IMNotifacationNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class IMMiddleNotificationViewHolder extends BaseViewHolder<IMNotifacationNode> {
    private Context context;
    private TextView descText;

    public IMMiddleNotificationViewHolder(Context context, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, null, R.layout.im_notification, i, onItemClickListener);
        this.context = context;
        this.descText = (TextView) this.itemView.findViewById(R.id.text);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(IMNotifacationNode iMNotifacationNode) {
        if (iMNotifacationNode != null) {
            this.descText.setText(iMNotifacationNode.msg);
            ViewUtils.setBoldTypeface(this.context, this.descText);
        }
    }
}
