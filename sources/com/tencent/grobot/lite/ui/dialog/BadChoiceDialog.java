package com.tencent.grobot.lite.ui.dialog;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;
import com.tencent.grobot.lite.ui.view.component.GoodBadView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class BadChoiceDialog extends FrameDialog {
    private static final String TAG = "BadChoiceDialog";
    private static final int mItemMaxWidth = 128;
    private BaseViewHolder.OnItemClickListener clickListener;
    protected FrameActivity context;
    private TextView mChoice1;
    private TextView mChoice2;
    private TextView mChoice3;
    private TextView mChoice4;
    private TextView mChoice5;
    private TextView mChoice6;
    private View mContentView;
    private Handler mHandler;
    private int mItemSize;
    private int mItemWidth;
    private int mLeftMargin;
    private View mRootView;
    private int mTopMargin;
    private Runnable marginRunnable;
    private final TextPaint measurePaint;
    private String questionId;

    public BadChoiceDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.mLeftMargin = 0;
        this.mTopMargin = 0;
        this.mHandler = null;
        this.mItemWidth = 0;
        this.mItemSize = 0;
        this.marginRunnable = new Runnable() { // from class: com.tencent.grobot.lite.ui.dialog.BadChoiceDialog.1
            @Override // java.lang.Runnable
            public void run() {
                BadChoiceDialog.this.mHandler.removeCallbacks(BadChoiceDialog.this.marginRunnable);
                int contentHeight = BadChoiceDialog.this.getContentHeight();
                int dip2px = ViewUtils.dip2px(BadChoiceDialog.this.context, 25.0f) + (BadChoiceDialog.this.mItemWidth * 2);
                int dip2px2 = BadChoiceDialog.this.mTopMargin + ViewUtils.dip2px(BadChoiceDialog.this.getContext(), 5.0f);
                TLog.d(GoodBadView.class.getName(), "topOffset = " + dip2px2);
                if (dip2px2 + contentHeight >= ViewUtils.getScreenHeightPixels(BadChoiceDialog.this.getContext())) {
                    dip2px2 = (BadChoiceDialog.this.mTopMargin - contentHeight) - ViewUtils.dip2px(BadChoiceDialog.this.getContext(), 0.0f);
                    TLog.d(GoodBadView.class.getName(), "topOffset = " + dip2px2);
                    BadChoiceDialog.this.mContentView.setBackgroundResource(R.drawable.bg_goodbad_down);
                    BadChoiceDialog.this.mContentView.setPadding(ViewUtils.dip2px(BadChoiceDialog.this.context, 10.0f), ViewUtils.dip2px(BadChoiceDialog.this.context, 10.0f), ViewUtils.dip2px(BadChoiceDialog.this.context, 10.0f), ViewUtils.dip2px(BadChoiceDialog.this.context, 15.0f));
                } else {
                    BadChoiceDialog.this.mContentView.setBackgroundResource(R.drawable.bg_goodbad_up);
                    BadChoiceDialog.this.mContentView.setPadding(ViewUtils.dip2px(BadChoiceDialog.this.context, 10.0f), ViewUtils.dip2px(BadChoiceDialog.this.context, 15.0f), ViewUtils.dip2px(BadChoiceDialog.this.context, 10.0f), ViewUtils.dip2px(BadChoiceDialog.this.context, 10.0f));
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BadChoiceDialog.this.mContentView.getLayoutParams();
                layoutParams.setMarginStart(BadChoiceDialog.this.mLeftMargin - dip2px);
                layoutParams.leftMargin = BadChoiceDialog.this.mLeftMargin - dip2px;
                layoutParams.topMargin = dip2px2;
                BadChoiceDialog.this.mContentView.setLayoutParams(layoutParams);
                BadChoiceDialog.this.mRootView.setVisibility(0);
            }
        };
        this.context = frameActivity;
        this.measurePaint = new TextPaint();
        this.measurePaint.setTypeface(ViewUtils.getCustomBoldFont(this.context));
        this.measurePaint.setAntiAlias(true);
        this.measurePaint.setTextSize(ViewUtils.dip2px(this.context, 11.0f));
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_badchoice, (ViewGroup) this, false);
        this.mRootView.setOnClickListener(this);
        this.mContentView = this.mRootView.findViewById(R.id.content);
        this.mContentView.setOnClickListener(this);
        this.mChoice1 = (TextView) this.mRootView.findViewById(R.id.choice_1);
        this.mChoice1.setOnClickListener(this);
        this.mChoice2 = (TextView) this.mRootView.findViewById(R.id.choice_2);
        this.mChoice2.setOnClickListener(this);
        this.mChoice3 = (TextView) this.mRootView.findViewById(R.id.choice_3);
        this.mChoice3.setOnClickListener(this);
        this.mChoice4 = (TextView) this.mRootView.findViewById(R.id.choice_4);
        this.mChoice4.setOnClickListener(this);
        this.mChoice5 = (TextView) this.mRootView.findViewById(R.id.choice_5);
        this.mChoice5.setOnClickListener(this);
        this.mChoice6 = (TextView) this.mRootView.findViewById(R.id.choice_6);
        this.mChoice6.setOnClickListener(this);
        this.mRootView.setVisibility(8);
        return this.mRootView;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof EvaluateItemInfo) {
            EvaluateItemInfo evaluateItemInfo = (EvaluateItemInfo) view.getTag();
            evaluateItemInfo.secondClickText = evaluateItemInfo.optionText;
            BaseViewHolder.OnItemClickListener onItemClickListener = this.clickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, -1, -1, view.getTag());
            }
            report(evaluateItemInfo, "1002");
            dismissCustomDialog();
            return;
        }
        if (view.getId() == R.id.root) {
            dismissCustomDialog();
        }
    }

    public void setFeedbackInfo(String str, ArrayList<EvaluateItemInfo> arrayList, String str2) {
        this.questionId = str2;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.mItemSize = arrayList.size();
        this.mChoice2.setVisibility(8);
        this.mChoice3.setVisibility(8);
        this.mChoice4.setVisibility(8);
        this.mChoice5.setVisibility(8);
        this.mChoice6.setVisibility(8);
        getMaxWidh(arrayList);
        TLog.d(TAG, "setFeedbackInfo, w=" + this.mItemWidth);
        if (arrayList.size() >= 1) {
            this.mChoice1.setText(arrayList.get(0).optionText);
            this.mChoice1.setTag(arrayList.get(0));
            ViewUtils.setBoldTypeface(this.context, this.mChoice1);
            if (this.mChoice1.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mChoice1.getLayoutParams();
                layoutParams.width = this.mItemWidth;
                this.mChoice1.setLayoutParams(layoutParams);
            }
        }
        if (arrayList.size() >= 2) {
            this.mChoice2.setVisibility(0);
            this.mChoice2.setText(arrayList.get(1).optionText);
            this.mChoice2.setTag(arrayList.get(1));
            ViewUtils.setBoldTypeface(this.context, this.mChoice2);
            if (this.mChoice2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mChoice2.getLayoutParams();
                layoutParams2.width = this.mItemWidth;
                this.mChoice2.setLayoutParams(layoutParams2);
            }
        }
        if (arrayList.size() >= 3) {
            this.mChoice3.setVisibility(0);
            this.mChoice3.setText(arrayList.get(2).optionText);
            this.mChoice3.setTag(arrayList.get(2));
            ViewUtils.setBoldTypeface(this.context, this.mChoice3);
            if (this.mChoice3.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mChoice3.getLayoutParams();
                layoutParams3.width = this.mItemWidth;
                this.mChoice3.setLayoutParams(layoutParams3);
            }
        }
        if (arrayList.size() >= 4) {
            this.mChoice4.setVisibility(0);
            this.mChoice4.setText(arrayList.get(3).optionText);
            this.mChoice4.setTag(arrayList.get(3));
            ViewUtils.setBoldTypeface(this.context, this.mChoice4);
            if (this.mChoice4.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mChoice4.getLayoutParams();
                layoutParams4.width = this.mItemWidth;
                this.mChoice4.setLayoutParams(layoutParams4);
            }
        }
        if (arrayList.size() >= 5) {
            this.mChoice5.setVisibility(0);
            this.mChoice5.setText(arrayList.get(4).optionText);
            this.mChoice5.setTag(arrayList.get(4));
            ViewUtils.setBoldTypeface(this.context, this.mChoice5);
            if (this.mChoice5.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.mChoice5.getLayoutParams();
                layoutParams5.width = this.mItemWidth;
                this.mChoice5.setLayoutParams(layoutParams5);
            }
        }
        if (arrayList.size() >= 6) {
            this.mChoice6.setVisibility(0);
            this.mChoice6.setText(arrayList.get(5).optionText);
            this.mChoice6.setTag(arrayList.get(5));
            ViewUtils.setBoldTypeface(this.context, this.mChoice6);
            if (this.mChoice6.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.mChoice6.getLayoutParams();
                layoutParams6.width = this.mItemWidth;
                this.mChoice6.setLayoutParams(layoutParams6);
            }
        }
    }

    private int getMaxWidh(ArrayList<EvaluateItemInfo> arrayList) {
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.good_bad_choice_text_max);
        int dimensionPixelSize2 = this.context.getResources().getDimensionPixelSize(R.dimen.good_bad_choice_text_padding);
        Rect rect = new Rect();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<EvaluateItemInfo> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EvaluateItemInfo next = it.next();
                if (!TextUtils.isEmpty(next.optionText)) {
                    this.measurePaint.getTextBounds(next.optionText, 0, next.optionText.length(), rect);
                    int i = rect.left + rect.right + dimensionPixelSize2;
                    if (i >= dimensionPixelSize) {
                        this.mItemWidth = dimensionPixelSize;
                        break;
                    }
                    this.mItemWidth = Math.max(i, this.mItemWidth);
                }
            }
        }
        return this.mItemWidth;
    }

    public void setOnItemClickListener(BaseViewHolder.OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
    }

    public void setMargin(int i, int i2) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLeftMargin = i;
        this.mTopMargin = i2;
        this.mHandler.post(this.marginRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentHeight() {
        int i = this.mItemSize % 2 == 0 ? 0 : 1;
        int i2 = (this.mItemSize / 2) + i + i;
        return ViewUtils.dip2px(this.context, ((i2 - 1) * 10) + 25 + (i2 * 20));
    }

    private void report(EvaluateItemInfo evaluateItemInfo, String str) {
        new Report().eventType(str).itemId("7048").subId(this.questionId).ext(evaluateItemInfo.optionText).report(false);
    }
}
