package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.report.ReportBridge;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.dialog.TextDialog;
import com.tencent.grobot.lite.ui.presenter.MainViewPresenter;
import com.tencent.grobot.lite.ui.view.ChatTextView;
import com.tencent.grobot.lite.ui.view.component.GoodBadView;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ChatTextItemViewHolder extends BaseViewHolder<AnsTextNode> {
    static int MAX_LINES = 6;
    private ClickableSpan clickableSpan;
    private GoodBadView goodBadView;
    private boolean isLastItem;
    private AnsTextNode lastData;
    private BaseViewHolder.OnItemClickListener listener;
    Context mContext;
    private TextView moreText;
    private AnsTextNode textNode;
    private ChatTextView textView;

    public ChatTextItemViewHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.chat_text_server, i, onItemClickListener);
        int optInt;
        this.textNode = null;
        this.listener = null;
        this.isLastItem = false;
        this.lastData = null;
        this.clickableSpan = new ClickableSpan() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatTextItemViewHolder.3
            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ChatTextItemViewHolder.this.mContext.getResources().getColor(R.color.chat_msg_url_color));
                textPaint.setUnderlineText(true);
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (ChatTextItemViewHolder.this.clickListener != null) {
                    ChatTextItemViewHolder.this.clickListener.onItemClick(view, ChatTextItemViewHolder.this.getAdapterPosition(), ChatTextItemViewHolder.this.viewHolderType, view.getTag());
                }
            }
        };
        this.mContext = context;
        this.textView = (ChatTextView) this.itemView.findViewById(R.id.chat_content);
        this.moreText = (TextView) this.itemView.findViewById(R.id.moreText);
        this.goodBadView = (GoodBadView) this.itemView.findViewById(R.id.goodBadLayout);
        this.goodBadView.setOnItemClickListener(onItemClickListener);
        this.listener = onItemClickListener;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(MainViewPresenter.KEY_SHAREPERF_SETTINGS, "");
        if (sharedParam != null) {
            try {
                if (TextUtils.isEmpty(sharedParam) || (optInt = new JSONObject(sharedParam).optInt("longTextLimitNum")) <= 0) {
                    return;
                }
                MAX_LINES = optInt;
                this.textView.setMaxLines(MAX_LINES);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(AnsTextNode ansTextNode) {
        this.textNode = ansTextNode;
        String str = ansTextNode.quesText;
        if (ansTextNode.evaluateInfo != null && ansTextNode.showGoodBad) {
            this.goodBadView.setVisibility(0);
            this.goodBadView.setFeedbackInfo(String.valueOf(ansTextNode.answerKey), ansTextNode.evaluateInfo, ansTextNode.questionId);
        } else {
            this.goodBadView.setVisibility(8);
        }
        if (ansTextNode.isHyperlink()) {
            SpannableString spannableString = new SpannableString(ansTextNode.rawText);
            spannableString.setSpan(this.clickableSpan, 0, ansTextNode.rawText.length(), 33);
            this.textView.setText(spannableString);
            this.textView.setTag(ansTextNode);
            ViewUtils.setBoldTypeface(this.mContext, this.textView);
            updateMoreText(ansTextNode, spannableString);
        } else if (ansTextNode.linkType == 0 || ansTextNode.linkType == 1 || ansTextNode.linkType == 2) {
            SpannableString spannableString2 = new SpannableString(ansTextNode.rawText);
            if (ansTextNode.linkInfos != null) {
                Iterator<AnsTextNode.LinkInfo> it = ansTextNode.linkInfos.iterator();
                while (it.hasNext()) {
                    final AnsTextNode.LinkInfo next = it.next();
                    String str2 = next.word;
                    int indexOf = ansTextNode.rawText.indexOf(str2);
                    int length = str2.length() + indexOf;
                    if (indexOf >= 0) {
                        spannableString2.setSpan(new UnderlineSpan(), indexOf, length, 33);
                        spannableString2.setSpan(new ClickableSpan() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatTextItemViewHolder.1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                if (ChatTextItemViewHolder.this.listener != null) {
                                    ChatTextItemViewHolder.this.listener.onItemClick(ChatTextItemViewHolder.this.textView, ChatTextItemViewHolder.this.getAdapterPosition(), ChatTextItemViewHolder.this.viewHolderType, next);
                                }
                            }
                        }, indexOf, length, 33);
                        spannableString2.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.chat_msg_url_color)), indexOf, length, 33);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(ReportBridge.KEY_EVENT_TYPE, "1001");
                            if (ansTextNode.linkType == 0) {
                                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7047");
                                jSONObject.put(ReportBridge.KEY_SUB_ID, next.questionId);
                            } else if (ansTextNode.linkType == 1) {
                                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7045");
                                jSONObject.put("ext", next.url);
                            } else if (ansTextNode.linkType == 2) {
                                jSONObject.put(ReportBridge.KEY_ITEM_ID, "7172");
                                jSONObject.put("ext", next.url);
                            }
                            if (this.lastData == null || !this.lastData.equals(ansTextNode)) {
                                ReportBridge.report(jSONObject, false);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.textView.setText(spannableString2);
            this.textView.setTag(ansTextNode);
            ViewUtils.setBoldTypeface(this.mContext, this.textView);
            updateMoreText(ansTextNode, spannableString2);
        } else {
            CharSequence parseRichText = ansTextNode.parseRichText(ansTextNode.rawText, ansTextNode.actionUrl, ansTextNode.linkWord);
            if (parseRichText != null) {
                this.textView.setText(parseRichText);
                ViewUtils.setBoldTypeface(this.mContext, this.textView);
                updateMoreText(ansTextNode, parseRichText);
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ReportBridge.KEY_EVENT_TYPE, "1001");
            jSONObject2.put(ReportBridge.KEY_ITEM_ID, "7139");
            if (this.lastData == null || !this.lastData.equals(ansTextNode)) {
                ReportBridge.report(jSONObject2, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.lastData = ansTextNode;
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void setIsLastItem(boolean z) {
        this.isLastItem = z;
        if (z) {
            return;
        }
        this.goodBadView.setVisibility(8);
    }

    private void updateMoreText(final AnsTextNode ansTextNode, CharSequence charSequence) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(ViewUtils.dip2px(this.mContext, 13.0f));
        if (new StaticLayout(charSequence.toString(), textPaint, ViewUtils.dip2px(this.mContext, 370.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getHeight() > MAX_LINES * ViewUtils.dip2px(this.mContext, 16.0f)) {
            this.moreText.setVisibility(0);
            ViewUtils.setBoldTypeface(this.mContext, this.moreText);
            this.moreText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.grobot.lite.ui.adapter.ViewHolder.ChatTextItemViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TextDialog textDialog = (TextDialog) ((FrameActivity) ChatTextItemViewHolder.this.mContext).getDialog(TextDialog.class);
                    textDialog.showCustomDialog();
                    textDialog.setData(ansTextNode);
                    textDialog.setOnItemClickListener(ChatTextItemViewHolder.this.listener);
                    textDialog.setFeedbackInfo(String.valueOf(ansTextNode.answerKey), ansTextNode.evaluateInfo, ansTextNode.questionId);
                    textDialog.setIsLastItem(ChatTextItemViewHolder.this.isLastItem);
                }
            });
            ((LinearLayout.LayoutParams) this.textView.getLayoutParams()).bottomMargin = ViewUtils.dip2px(this.mContext, 5.0f);
            this.goodBadView.setVisibility(8);
            return;
        }
        this.moreText.setVisibility(8);
        ((LinearLayout.LayoutParams) this.textView.getLayoutParams()).bottomMargin = ViewUtils.dip2px(this.mContext, 7.0f);
    }
}
