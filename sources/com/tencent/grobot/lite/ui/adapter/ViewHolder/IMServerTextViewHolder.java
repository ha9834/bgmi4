package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.IMServerTextNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class IMServerTextViewHolder extends BaseViewHolder<IMServerTextNode> {
    private Context context;
    private TextView msgText;
    private TextView nameText;
    private TextView pointText;

    public IMServerTextViewHolder(Context context, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, null, R.layout.im_server_text, i, onItemClickListener);
        this.context = context;
        this.pointText = (TextView) this.itemView.findViewById(R.id.statusPoint);
        this.nameText = (TextView) this.itemView.findViewById(R.id.staffName);
        this.msgText = (TextView) this.itemView.findViewById(R.id.server_content);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(IMServerTextNode iMServerTextNode) {
        if (iMServerTextNode != null) {
            if (!TextUtils.isEmpty(iMServerTextNode.agentName)) {
                this.nameText.setText(iMServerTextNode.agentName);
                ViewUtils.setBoldTypeface(this.context, this.nameText);
                this.pointText.setVisibility(0);
                this.nameText.setVisibility(0);
            } else {
                this.pointText.setVisibility(8);
                this.nameText.setVisibility(8);
            }
            this.msgText.setText(iMServerTextNode.msg);
            ViewUtils.setBoldTypeface(this.context, this.msgText);
        }
    }
}
