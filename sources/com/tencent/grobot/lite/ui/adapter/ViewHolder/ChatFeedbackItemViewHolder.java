package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ViewPools;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.node.FeedbackNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.view.component.LikeUnlikeItemView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ChatFeedbackItemViewHolder extends BaseViewHolder<FeedbackNode> {
    private BaseViewHolder.OnItemClickListener clickListener;
    private LinearLayout contentView;
    private Context context;
    private TextView descText;
    private LikeUnlikeItemView.IItemViewListener iItemViewListener;

    public ChatFeedbackItemViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_feedback, i, onItemClickListener);
        this.iItemViewListener = new LikeUnlikeItemView.IItemViewListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatFeedbackItemViewHolder.1
            @Override // com.tencent.grobot.lite.ui.view.component.LikeUnlikeItemView.IItemViewListener
            public void refreshContentView(ArrayList<EvaluateItemInfo> arrayList) {
                ChatFeedbackItemViewHolder.this.buildContentView(arrayList);
            }
        };
        this.context = context;
        this.descText = (TextView) this.itemView.findViewById(R.id.chat_content);
        this.contentView = (LinearLayout) this.itemView.findViewById(R.id.feedbackLayout);
        this.clickListener = onItemClickListener;
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(FeedbackNode feedbackNode) {
        if (feedbackNode != null) {
            this.descText.setText(feedbackNode.desc);
            ViewUtils.setBoldTypeface(this.context, this.descText);
            if (feedbackNode.itemInfo != null) {
                LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(feedbackNode.answerKey);
                EvaluateItemInfo evaluateItemInfo = feedbackNode.itemInfo;
                if (likeUnlideSelectInfo != null) {
                    evaluateItemInfo = getItemInfo(feedbackNode.itemInfo, likeUnlideSelectInfo);
                }
                if (evaluateItemInfo != null) {
                    this.contentView.setVisibility(0);
                    if (evaluateItemInfo.extInfos != null) {
                        buildContentView(evaluateItemInfo.extInfos);
                        return;
                    }
                    ArrayList<EvaluateItemInfo> arrayList = new ArrayList<>();
                    arrayList.add(evaluateItemInfo);
                    buildContentView(arrayList);
                    return;
                }
                this.contentView.setVisibility(8);
                return;
            }
            this.contentView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildContentView(ArrayList<EvaluateItemInfo> arrayList) {
        LikeUnlikeItemView buildItemView;
        if (arrayList != null) {
            int childCount = this.contentView.getChildCount();
            int size = arrayList.size();
            int i = 0;
            if (childCount >= size) {
                if (childCount <= size) {
                    while (i < size) {
                        updateItemView((LikeUnlikeItemView) this.contentView.getChildAt(i), arrayList.get(i), i);
                        i++;
                    }
                    return;
                }
                int i2 = childCount - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    ViewPools.getInstance().release(0, this.contentView.getChildAt(size + i3));
                }
                this.contentView.removeViews(size, i2);
                while (i < size) {
                    updateItemView((LikeUnlikeItemView) this.contentView.getChildAt(i), arrayList.get(i), i);
                    i++;
                }
                return;
            }
            ArrayList<LikeUnlikeItemView> arrayList2 = new ArrayList(size - childCount);
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 < childCount) {
                    updateItemView((LikeUnlikeItemView) this.contentView.getChildAt(i4), arrayList.get(i4), i4);
                } else {
                    View acquire = ViewPools.getInstance().acquire(0);
                    if (acquire instanceof LikeUnlikeItemView) {
                        buildItemView = (LikeUnlikeItemView) acquire;
                        updateItemView(buildItemView, arrayList.get(i4), i4);
                    } else {
                        buildItemView = buildItemView(arrayList.get(i4), i4);
                    }
                    arrayList2.add(buildItemView);
                }
            }
            for (LikeUnlikeItemView likeUnlikeItemView : arrayList2) {
                if (likeUnlikeItemView != null) {
                    this.contentView.addView(likeUnlikeItemView);
                    ((LinearLayout.LayoutParams) likeUnlikeItemView.getLayoutParams()).setMargins(ViewUtils.dip2px(this.context, 10.0f), 0, 0, 0);
                }
            }
        }
    }

    private LikeUnlikeItemView buildItemView(EvaluateItemInfo evaluateItemInfo, int i) {
        if (evaluateItemInfo == null) {
            return null;
        }
        LikeUnlikeItemView likeUnlikeItemView = new LikeUnlikeItemView(this.context);
        likeUnlikeItemView.setData(evaluateItemInfo, i);
        likeUnlikeItemView.setIItemViewListener(this.iItemViewListener);
        likeUnlikeItemView.setOnItemClickListener(this.clickListener);
        return likeUnlikeItemView;
    }

    private void updateItemView(LikeUnlikeItemView likeUnlikeItemView, EvaluateItemInfo evaluateItemInfo, int i) {
        likeUnlikeItemView.setData(evaluateItemInfo, i);
        likeUnlikeItemView.setIItemViewListener(this.iItemViewListener);
        likeUnlikeItemView.setOnItemClickListener(this.clickListener);
    }

    private EvaluateItemInfo getItemInfo(EvaluateItemInfo evaluateItemInfo, LikeUnlikeSelectInfo likeUnlikeSelectInfo) {
        if (evaluateItemInfo != null && likeUnlikeSelectInfo != null) {
            Iterator<EvaluateItemInfo> it = evaluateItemInfo.extInfos.iterator();
            while (it.hasNext()) {
                EvaluateItemInfo next = it.next();
                if (!TextUtils.isEmpty(likeUnlikeSelectInfo.secondText) && next.optionText.equals(likeUnlikeSelectInfo.secondText)) {
                    next.selected = true;
                    next.enable = false;
                    return next;
                }
            }
        }
        return evaluateItemInfo;
    }
}
