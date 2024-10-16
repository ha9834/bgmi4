package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.TextInfoNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class ChatTextInfoViewHolder extends BaseViewHolder<TextInfoNode> {
    private Context context;
    private TextView textView;

    public ChatTextInfoViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_text_info, i, onItemClickListener);
        this.context = context;
        this.textView = (TextView) this.itemView.findViewById(R.id.infoText);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(TextInfoNode textInfoNode) {
        if (textInfoNode != null) {
            this.itemView.setTag(textInfoNode);
            this.textView.setText(textInfoNode.msg);
            ViewUtils.setBoldTypeface(this.context, this.textView);
        }
    }
}
