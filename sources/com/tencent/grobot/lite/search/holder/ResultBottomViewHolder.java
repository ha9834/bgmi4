package com.tencent.grobot.lite.search.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.search.OnItemClickListener;
import com.tencent.grobot.lite.search.model.ClickObj;

/* loaded from: classes2.dex */
public class ResultBottomViewHolder extends RecyclerView.w {
    private Context mContext;
    private String mKeyWord;
    private TextView text;

    public ResultBottomViewHolder(Context context, ViewGroup viewGroup, final OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.search_bottom, viewGroup, false));
        this.mContext = context;
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.search.holder.ResultBottomViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onItemClickListener == null || TextUtils.isEmpty(ResultBottomViewHolder.this.mKeyWord)) {
                    return;
                }
                ClickObj clickObj = new ClickObj();
                clickObj.type = 2;
                clickObj.msg = ResultBottomViewHolder.this.mKeyWord;
                onItemClickListener.onItemClick(clickObj);
            }
        });
        this.text = (TextView) this.itemView.findViewById(R.id.text);
        ViewUtils.setBoldTypeface(this.mContext, this.text);
    }

    public void setMsg(String str) {
        this.mKeyWord = str;
        this.text.setText(ToolUtils.getSearchString(this.mContext, str));
    }
}
