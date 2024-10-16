package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LikeUnlikeItemView extends TextView implements View.OnClickListener {
    private BaseViewHolder.OnItemClickListener clickListener;
    private Context context;
    private IItemViewListener iItemViewListener;
    private int mPos;

    /* loaded from: classes2.dex */
    public interface IItemViewListener {
        void refreshContentView(ArrayList<EvaluateItemInfo> arrayList);
    }

    public LikeUnlikeItemView(Context context) {
        this(context, null, 0);
    }

    public LikeUnlikeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LikeUnlikeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        buildView();
    }

    private void buildView() {
        ViewUtils.setBoldTypeface(this.context, this);
        setHeight(ViewUtils.dip2px(this.context, 17.0f));
        setMaxLines(1);
        setPadding(ViewUtils.dip2px(this.context, 10.0f), 0, ViewUtils.dip2px(this.context, 10.0f), 0);
        setTextColor(this.context.getResources().getColor(R.color.option_text_color));
        setTextSize(10.0f);
        setCompoundDrawablePadding(ViewUtils.dip2px(this.context, 5.0f));
        setGravity(17);
    }

    public void setData(EvaluateItemInfo evaluateItemInfo, int i) {
        if (evaluateItemInfo != null) {
            this.mPos = i;
            setOnClickListener(this);
            setTag(evaluateItemInfo);
            setText(evaluateItemInfo.optionText);
            if (evaluateItemInfo.iconType.equals("useless")) {
                Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_useless);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(drawable, null, null, null);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7011");
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (evaluateItemInfo.iconType.equals("helpful")) {
                Drawable drawable2 = this.context.getResources().getDrawable(R.drawable.icon_useful);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(drawable2, null, null, null);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7010");
                    ReportBridge.report(jSONObject2, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                setCompoundDrawables(null, null, null, null);
            }
            new Report().eventType("1001").itemId("7048").ext(evaluateItemInfo.optionText).report(false);
            setEnabled(evaluateItemInfo.enable);
            if (evaluateItemInfo.enable) {
                setTextColor(this.context.getResources().getColor(R.color.feedback_text_normal));
                setBackgroundResource(R.drawable.bg_feedback_item_enable);
                return;
            } else {
                setTextColor(this.context.getResources().getColor(R.color.feedback_text_disable));
                setBackgroundResource(R.drawable.bg_feedback_item_disable);
                return;
            }
        }
        setOnClickListener(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clickListener != null) {
            EvaluateItemInfo evaluateItemInfo = (EvaluateItemInfo) view.getTag();
            if (evaluateItemInfo.itemLevel == 1) {
                evaluateItemInfo.fistClickText = evaluateItemInfo.optionText;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7010");
                    ReportBridge.report(jSONObject, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (evaluateItemInfo.itemLevel == 2) {
                evaluateItemInfo.secondClickText = evaluateItemInfo.optionText;
                new Report().eventType("1002").itemId("7048").ext(evaluateItemInfo.optionText).report(false);
            }
            if (evaluateItemInfo.actionType.equals("ext")) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                    jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7011");
                    ReportBridge.report(jSONObject2, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Iterator<EvaluateItemInfo> it = evaluateItemInfo.extInfos.iterator();
                while (it.hasNext()) {
                    it.next().fistClickText = evaluateItemInfo.fistClickText;
                }
                LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(evaluateItemInfo.answerKey);
                if (likeUnlideSelectInfo == null) {
                    likeUnlideSelectInfo = new LikeUnlikeSelectInfo();
                }
                if (evaluateItemInfo.itemLevel == 1) {
                    likeUnlideSelectInfo.firstText = evaluateItemInfo.optionText;
                } else if (evaluateItemInfo.itemLevel == 2) {
                    likeUnlideSelectInfo.secondText = evaluateItemInfo.optionText;
                }
                if (!TextUtils.isEmpty(evaluateItemInfo.answerKey)) {
                    DataManager.getInstance().setLikeUnlikeSelected(evaluateItemInfo.answerKey, likeUnlideSelectInfo);
                }
                IItemViewListener iItemViewListener = this.iItemViewListener;
                if (iItemViewListener != null) {
                    iItemViewListener.refreshContentView(evaluateItemInfo.extInfos);
                    return;
                }
                return;
            }
            this.clickListener.onItemClick(view, -1, -1, view.getTag());
        }
    }

    public void setOnItemClickListener(BaseViewHolder.OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
    }

    public void setIItemViewListener(IItemViewListener iItemViewListener) {
        this.iItemViewListener = iItemViewListener;
    }
}
