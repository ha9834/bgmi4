package com.tencent.grobot.lite.search.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.search.OnItemClickListener;
import com.tencent.grobot.lite.search.model.ClickObj;
import com.tencent.grobot.lite.search.model.TextItem;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class TextItemViewHolder extends BaseViewHolder<TextItem> implements View.OnClickListener {
    private OnItemClickListener itemClickListener;
    private Context mContext;
    private TextItem mData;
    TextView text;

    public TextItemViewHolder(Context context, ViewGroup viewGroup, int i, OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.search_item_text, i, null);
        this.mContext = context;
        this.text = (TextView) this.itemView.findViewById(R.id.text);
        this.text.setOnClickListener(this);
        ViewUtils.setBoldTypeface(context, this.text);
        this.itemClickListener = onItemClickListener;
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(TextItem textItem) {
        if (textItem == null) {
            return;
        }
        this.mData = textItem;
        if (textItem.type == 2) {
            this.text.setText("#" + textItem.desc);
        } else {
            this.text.setText(textItem.desc);
        }
        if (textItem.type == 1) {
            this.text.setTextColor(this.mContext.getResources().getColor(R.color.search_history));
        } else if (textItem.type == 2) {
            this.text.setTextColor(this.mContext.getResources().getColor(R.color.search_hot));
        }
        if (textItem.type == 2) {
            new Report().eventType("1001").itemId("7161").ext(textItem.desc).report(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.text) {
            if (this.itemClickListener != null) {
                ClickObj clickObj = new ClickObj();
                clickObj.type = 1;
                clickObj.msg = this.mData.desc;
                this.itemClickListener.onItemClick(clickObj);
            }
            if (this.mData.type == 2) {
                new Report().eventType("1002").itemId("7161").ext(this.mData.desc).report(false);
            }
        }
    }
}
