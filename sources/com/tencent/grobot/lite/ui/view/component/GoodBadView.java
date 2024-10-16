package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.a;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.LangUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.dialog.BadChoiceDialog;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GoodBadView extends LinearLayout implements View.OnClickListener {
    private String answerKey;
    private BaseViewHolder.OnItemClickListener clickListener;
    private long lastClickTime;
    private ImageView mBtn1;
    private ImageView mBtn2;
    private FrameActivity mContext;
    private EvaluateInfo mEvaluateInfo;
    private String questionId;

    /* loaded from: classes2.dex */
    public static class GoodBadSelectInfo {
        public String firstText = "";
        public String secondText = "";
    }

    public GoodBadView(Context context) {
        this(context, null, 0);
    }

    public GoodBadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoodBadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastClickTime = 0L;
        this.mContext = (FrameActivity) context;
        LayoutInflater.from(context).inflate(R.layout.chat_goodbad_item, this);
        this.mBtn1 = (ImageView) findViewById(R.id.btn_1);
        this.mBtn2 = (ImageView) findViewById(R.id.btn_2);
        this.mBtn1.setOnClickListener(this);
        this.mBtn2.setOnClickListener(this);
    }

    public void setFeedbackInfo(String str, EvaluateInfo evaluateInfo, String str2) {
        this.answerKey = str;
        if (evaluateInfo != null && evaluateInfo.options.size() > 0) {
            this.mEvaluateInfo = evaluateInfo;
            this.questionId = str2;
            setButton();
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void setButton() {
        EvaluateItemInfo selectedItemInfo = getSelectedItemInfo(this.mEvaluateInfo, DataManager.getInstance().getLikeUnlideSelectInfo(this.answerKey));
        String str = "";
        if (selectedItemInfo != null) {
            str = !TextUtils.isEmpty(selectedItemInfo.secondClickText) ? selectedItemInfo.secondClickText : selectedItemInfo.fistClickText;
        }
        EvaluateInfo evaluateInfo = this.mEvaluateInfo;
        if (evaluateInfo == null || evaluateInfo.options.size() <= 0) {
            return;
        }
        EvaluateItemInfo evaluateItemInfo = this.mEvaluateInfo.options.get(0);
        if (evaluateItemInfo != null) {
            this.mBtn1.setTag(evaluateItemInfo);
            updateButton(this.mBtn1, evaluateItemInfo, !TextUtils.isEmpty(str));
        }
        EvaluateItemInfo evaluateItemInfo2 = this.mEvaluateInfo.options.get(1);
        if (evaluateItemInfo2 != null) {
            this.mBtn2.setVisibility(0);
            this.mBtn2.setTag(evaluateItemInfo2);
            updateButton(this.mBtn2, evaluateItemInfo2, !TextUtils.isEmpty(str));
            return;
        }
        this.mBtn2.setVisibility(8);
    }

    private void updateButton(ImageView imageView, EvaluateItemInfo evaluateItemInfo, boolean z) {
        if (evaluateItemInfo != null) {
            if (z) {
                imageView.setEnabled(false);
                imageView.setAlpha(0.4f);
                imageView.setVisibility(8);
            } else {
                imageView.setEnabled(true);
                imageView.setAlpha(1.0f);
                imageView.setVisibility(0);
            }
            if (evaluateItemInfo.iconType.equals("useless")) {
                imageView.setImageDrawable(a.a(this.mContext, R.drawable.icon_bad));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject.put(ReportBridge.KEY_ITEM_ID, "7011");
                    jSONObject.put(ReportBridge.KEY_SUB_ID, this.questionId);
                    ReportBridge.report(jSONObject, false);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (evaluateItemInfo.iconType.equals("helpful")) {
                imageView.setImageDrawable(a.a(this.mContext, R.drawable.icon_good));
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                    jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7010");
                    jSONObject2.put(ReportBridge.KEY_SUB_ID, this.questionId);
                    ReportBridge.report(jSONObject2, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onBtnClick(view);
    }

    private void onBtnClick(View view) {
        int i;
        if (System.currentTimeMillis() - this.lastClickTime < 1000) {
            return;
        }
        this.lastClickTime = System.currentTimeMillis();
        EvaluateItemInfo evaluateItemInfo = null;
        if (view.getTag() != null && (view.getTag() instanceof EvaluateItemInfo)) {
            evaluateItemInfo = (EvaluateItemInfo) view.getTag();
        }
        if (evaluateItemInfo == null) {
            return;
        }
        evaluateItemInfo.fistClickText = evaluateItemInfo.optionText;
        if (evaluateItemInfo.actionType.equals("ext")) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (LangUtils.getLayoutDirectionFromLocale(view.getContext().getResources().getConfiguration().locale) == 1) {
                i = (ViewUtils.getScreenWidthPixels(view.getContext()) - iArr[0]) - ViewUtils.dip2px(view.getContext(), 25.0f);
            } else {
                i = iArr[0];
            }
            int i2 = iArr[1];
            TLog.d(GoodBadView.class.getName(), "x = " + i + " : y = " + i2);
            Iterator<EvaluateItemInfo> it = evaluateItemInfo.extInfos.iterator();
            while (it.hasNext()) {
                it.next().fistClickText = evaluateItemInfo.fistClickText;
            }
            LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(evaluateItemInfo.answerKey);
            if (likeUnlideSelectInfo == null) {
                likeUnlideSelectInfo = new LikeUnlikeSelectInfo();
            }
            if (!TextUtils.isEmpty(evaluateItemInfo.answerKey)) {
                DataManager.getInstance().setLikeUnlikeSelected(evaluateItemInfo.answerKey, likeUnlideSelectInfo);
            }
            BadChoiceDialog badChoiceDialog = (BadChoiceDialog) this.mContext.getDialog(BadChoiceDialog.class);
            Collections.shuffle(evaluateItemInfo.extInfos);
            badChoiceDialog.setFeedbackInfo(this.answerKey, evaluateItemInfo.extInfos, this.questionId);
            badChoiceDialog.setOnItemClickListener(this.clickListener);
            badChoiceDialog.showCustomDialog(true, 0, 0, android.R.color.transparent);
            badChoiceDialog.setMargin(i + view.getWidth(), i2 + view.getHeight());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1002");
                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7011");
                jSONObject.put(ReportBridge.KEY_SUB_ID, this.questionId);
                ReportBridge.report(jSONObject, false);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1002");
            jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7010");
            jSONObject2.put(ReportBridge.KEY_SUB_ID, this.questionId);
            ReportBridge.report(jSONObject2, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.clickListener.onItemClick(view, -1, -1, view.getTag());
    }

    public void setOnItemClickListener(BaseViewHolder.OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
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

    public void hideBadChoiceDialog() {
        BadChoiceDialog badChoiceDialog = (BadChoiceDialog) this.mContext.getDialog(BadChoiceDialog.class);
        if (badChoiceDialog == null || !badChoiceDialog.isShowing()) {
            return;
        }
        badChoiceDialog.dismissCustomDialog();
    }
}
