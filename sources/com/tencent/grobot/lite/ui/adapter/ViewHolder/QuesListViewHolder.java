package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.local.HotTextItemInfo;
import com.tencent.grobot.lite.model.node.QuesListNode;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class QuesListViewHolder extends BaseViewHolder<QuesListNode> implements View.OnClickListener {
    static final int MAX_ITEMS = 4;
    private Context context;
    private TextView itemCutline1;
    private TextView itemCutline2;
    private TextView itemCutline3;
    private RelativeLayout itemLayout1;
    private RelativeLayout itemLayout2;
    private RelativeLayout itemLayout3;
    private RelativeLayout itemLayout4;
    private RelativeLayout[] itemLayouts;
    private TextView itemTitle1;
    private TextView itemTitle2;
    private TextView itemTitle3;
    private TextView itemTitle4;
    private int maxWidth;
    private TextView[] titleViews;

    public QuesListViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_list_option, i, onItemClickListener);
        this.itemLayouts = new RelativeLayout[4];
        this.titleViews = new TextView[4];
        this.context = context;
        this.itemLayout1 = (RelativeLayout) this.itemView.findViewById(R.id.item_1);
        this.itemLayout2 = (RelativeLayout) this.itemView.findViewById(R.id.item_2);
        this.itemLayout3 = (RelativeLayout) this.itemView.findViewById(R.id.item_3);
        this.itemLayout4 = (RelativeLayout) this.itemView.findViewById(R.id.item_4);
        RelativeLayout[] relativeLayoutArr = this.itemLayouts;
        RelativeLayout relativeLayout = this.itemLayout1;
        relativeLayoutArr[0] = relativeLayout;
        relativeLayoutArr[1] = this.itemLayout2;
        relativeLayoutArr[2] = this.itemLayout3;
        relativeLayoutArr[3] = this.itemLayout4;
        relativeLayout.setOnClickListener(this);
        this.itemLayout2.setOnClickListener(this);
        this.itemLayout3.setOnClickListener(this);
        this.itemLayout4.setOnClickListener(this);
        this.itemTitle1 = (TextView) this.itemView.findViewById(R.id.item_title1);
        this.itemTitle2 = (TextView) this.itemView.findViewById(R.id.item_title2);
        this.itemTitle3 = (TextView) this.itemView.findViewById(R.id.item_title3);
        this.itemTitle4 = (TextView) this.itemView.findViewById(R.id.item_title4);
        TextView[] textViewArr = this.titleViews;
        textViewArr[0] = this.itemTitle1;
        textViewArr[1] = this.itemTitle2;
        textViewArr[2] = this.itemTitle3;
        textViewArr[3] = this.itemTitle4;
        this.itemCutline1 = (TextView) this.itemView.findViewById(R.id.item_cutline1);
        this.itemCutline2 = (TextView) this.itemView.findViewById(R.id.item_cutline2);
        this.itemCutline3 = (TextView) this.itemView.findViewById(R.id.item_cutline3);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(QuesListNode quesListNode) {
        if (quesListNode != null) {
            this.maxWidth = ViewUtils.dip2px(this.context, 290.0f);
            new Paint().setTextSize(ViewUtils.dip2px(this.context, 13.0f));
            if (quesListNode.hotQuesItems == null) {
                return;
            }
            for (int i = 0; i < quesListNode.hotQuesItems.size() && i < 4; i++) {
                HotTextItemInfo hotTextItemInfo = quesListNode.hotQuesItems.get(i);
                if (hotTextItemInfo != null) {
                    this.itemLayouts[i].setTag(hotTextItemInfo);
                    this.itemLayouts[i].setVisibility(0);
                    this.titleViews[i].setText(hotTextItemInfo.questionText);
                    ViewUtils.setBoldTypeface(this.context, this.titleViews[i]);
                    new Report().eventType("1001").itemId("7003").indexId(String.valueOf(i + 7001)).report(false);
                } else {
                    this.itemLayouts[i].setVisibility(8);
                }
            }
            int size = quesListNode.hotQuesItems.size();
            if (size == 4) {
                TextView textView = this.itemCutline3;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            } else if (size < 4) {
                TextView textView2 = this.itemCutline2;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.itemCutline3;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                this.itemLayouts[3].setVisibility(8);
                if (size < 3) {
                    TextView textView4 = this.itemCutline2;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                    this.itemLayouts[2].setVisibility(8);
                }
            }
            ((LinearLayout.LayoutParams) this.itemLayout1.getLayoutParams()).width = this.maxWidth;
            ((LinearLayout.LayoutParams) this.itemLayout2.getLayoutParams()).width = this.maxWidth;
            ((LinearLayout.LayoutParams) this.itemLayout3.getLayoutParams()).width = this.maxWidth;
            ((LinearLayout.LayoutParams) this.itemLayout4.getLayoutParams()).width = this.maxWidth;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        Report itemId = new Report().eventType("1002").itemId("7003");
        if (id == R.id.item_1) {
            this.clickListener.onItemClick(view, 0, this.viewHolderType, view.getTag());
            itemId.indexId("7001");
        } else if (id == R.id.item_2) {
            this.clickListener.onItemClick(view, 1, this.viewHolderType, view.getTag());
            itemId.indexId("7002");
        } else if (id == R.id.item_3) {
            this.clickListener.onItemClick(view, 2, this.viewHolderType, view.getTag());
            itemId.indexId("7003");
        } else if (id == R.id.item_4) {
            this.clickListener.onItemClick(view, 3, this.viewHolderType, view.getTag());
            itemId.indexId("7004");
        }
        itemId.report(false);
    }
}
