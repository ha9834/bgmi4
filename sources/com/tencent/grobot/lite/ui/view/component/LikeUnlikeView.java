package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ViewPools;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.view.component.LikeUnlikeItemView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class LikeUnlikeView extends LinearLayout {
    private String answerKey;
    private BaseViewHolder.OnItemClickListener clickListener;
    private LikeUnlikeItemView.IItemViewListener iItemViewListener;

    public LikeUnlikeView(Context context) {
        this(context, null, 0);
    }

    public LikeUnlikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LikeUnlikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iItemViewListener = new LikeUnlikeItemView.IItemViewListener() { // from class: com.tencent.grobot.lite.ui.view.component.LikeUnlikeView.1
            @Override // com.tencent.grobot.lite.ui.view.component.LikeUnlikeItemView.IItemViewListener
            public void refreshContentView(ArrayList<EvaluateItemInfo> arrayList) {
                LikeUnlikeView.this.buildContentView(arrayList);
            }
        };
        setOrientation(0);
        setMinimumHeight(ViewUtils.dip2px(context, 25.0f));
        int dip2px = ViewUtils.dip2px(context, 15.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            setPaddingRelative(0, 0, dip2px, 0);
        } else {
            setPadding(0, 0, dip2px, 0);
        }
    }

    public void setFeedbackInfo(String str, EvaluateInfo evaluateInfo) {
        this.answerKey = str;
        LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(str);
        EvaluateItemInfo selectedItemInfo = getSelectedItemInfo(evaluateInfo, likeUnlideSelectInfo);
        if (likeUnlideSelectInfo == null || selectedItemInfo == null) {
            if (evaluateInfo != null) {
                buildContentView(evaluateInfo.options);
            }
        } else {
            if (selectedItemInfo.actionType.equals("ext")) {
                buildContentView(selectedItemInfo.extInfos);
                return;
            }
            ArrayList<EvaluateItemInfo> arrayList = new ArrayList<>();
            arrayList.add(selectedItemInfo);
            buildContentView(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildContentView(ArrayList<EvaluateItemInfo> arrayList) {
        LikeUnlikeItemView buildItemView;
        if (arrayList != null) {
            int childCount = getChildCount();
            int size = arrayList.size();
            int i = 0;
            if (childCount >= size) {
                if (childCount <= size) {
                    while (i < size) {
                        updateItemView((LikeUnlikeItemView) getChildAt(i), arrayList.get(i), i);
                        i++;
                    }
                    return;
                }
                int i2 = childCount - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    ViewPools.getInstance().release(0, getChildAt(size + i3));
                }
                removeViews(size, i2);
                while (i < size) {
                    updateItemView((LikeUnlikeItemView) getChildAt(i), arrayList.get(i), i);
                    i++;
                }
                return;
            }
            ArrayList<LikeUnlikeItemView> arrayList2 = new ArrayList(size - childCount);
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 < childCount) {
                    updateItemView((LikeUnlikeItemView) getChildAt(i4), arrayList.get(i4), i4);
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
                    addView(likeUnlikeItemView);
                    ((LinearLayout.LayoutParams) likeUnlikeItemView.getLayoutParams()).setMargins(ViewUtils.dip2px(getContext(), 10.0f), 0, 0, 0);
                }
            }
        }
    }

    private LikeUnlikeItemView buildItemView(EvaluateItemInfo evaluateItemInfo, int i) {
        if (evaluateItemInfo == null) {
            return null;
        }
        LikeUnlikeItemView likeUnlikeItemView = new LikeUnlikeItemView(getContext());
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

    private EvaluateItemInfo getSelectedItemInfo(EvaluateInfo evaluateInfo, LikeUnlikeSelectInfo likeUnlikeSelectInfo) {
        if (evaluateInfo != null && evaluateInfo.options != null) {
            Iterator<EvaluateItemInfo> it = evaluateInfo.options.iterator();
            while (it.hasNext()) {
                EvaluateItemInfo next = it.next();
                next.answerKey = this.answerKey;
                if (next.extInfos != null) {
                    Iterator<EvaluateItemInfo> it2 = next.extInfos.iterator();
                    while (it2.hasNext()) {
                        it2.next().answerKey = this.answerKey;
                    }
                }
            }
        }
        if (evaluateInfo != null && likeUnlikeSelectInfo != null && evaluateInfo.options != null && !TextUtils.isEmpty(likeUnlikeSelectInfo.firstText)) {
            Iterator<EvaluateItemInfo> it3 = evaluateInfo.options.iterator();
            while (it3.hasNext()) {
                EvaluateItemInfo next2 = it3.next();
                if (next2.optionText.equals(likeUnlikeSelectInfo.firstText)) {
                    next2.selected = true;
                    next2.enable = false;
                    if (TextUtils.isEmpty(likeUnlikeSelectInfo.secondText) || next2.extInfos == null) {
                        return next2;
                    }
                    Iterator<EvaluateItemInfo> it4 = next2.extInfos.iterator();
                    while (it4.hasNext()) {
                        EvaluateItemInfo next3 = it4.next();
                        if (next3.optionText.equals(likeUnlikeSelectInfo.secondText)) {
                            next3.enable = false;
                            next3.selected = true;
                            return next3;
                        }
                    }
                    return next2;
                }
            }
        }
        return null;
    }

    public void setOnItemClickListener(BaseViewHolder.OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
    }
}
