package com.tencent.grobot.lite.ui.dialog;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.DataManager;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;
import com.tencent.grobot.lite.ui.view.ChatTextView;
import com.tencent.grobot.lite.ui.view.component.GoodBadView;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class TextDialog extends FrameDialog {
    private String answerKey;
    private BaseViewHolder.OnItemClickListener clickListener;
    private ClickableSpan clickableSpan;
    private ImageView closeBtn;
    private ChatTextView contentView;
    private EvaluateInfo evaluateInfo;
    private GoodBadView goodBadView;
    private String questionId;
    private ScrollView scrollView;
    private TextView titleView;

    public TextDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.clickListener = null;
        this.clickableSpan = new ClickableSpan() { // from class: com.tencent.grobot.lite.ui.dialog.TextDialog.2
            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(TextDialog.this.context.getResources().getColor(R.color.chat_msg_url_color));
                textPaint.setUnderlineText(true);
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (TextDialog.this.clickListener != null) {
                    TextDialog.this.dismissCustomDialog();
                    TextDialog.this.clickListener.onItemClick(view, -1, -1, view.getTag());
                }
            }
        };
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_text, (ViewGroup) this, false);
        this.titleView = (TextView) inflate.findViewById(R.id.title);
        this.contentView = (ChatTextView) inflate.findViewById(R.id.content_text);
        this.closeBtn = (ImageView) inflate.findViewById(R.id.closeBtn);
        this.closeBtn.setOnClickListener(this);
        this.scrollView = (ScrollView) inflate.findViewById(R.id.scrollView);
        this.goodBadView = (GoodBadView) inflate.findViewById(R.id.goodBadLayout);
        return inflate;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        dismissCustomDialog();
    }

    public void setData(AnsTextNode ansTextNode) {
        ViewUtils.setBoldTypeface(getContext(), this.titleView);
        ViewUtils.setBoldTypeface(getContext(), this.contentView);
        this.titleView.setText(ansTextNode.quesText);
        this.questionId = ansTextNode.questionId;
        if (ansTextNode.isHyperlink()) {
            SpannableString spannableString = new SpannableString(ansTextNode.rawText);
            spannableString.setSpan(this.clickableSpan, 0, ansTextNode.rawText.length(), 33);
            this.contentView.setText(spannableString);
            this.contentView.setTag(ansTextNode);
            return;
        }
        if (ansTextNode.linkType == 0 || ansTextNode.linkType == 1) {
            SpannableString spannableString2 = new SpannableString(ansTextNode.rawText);
            if (ansTextNode.linkInfos != null) {
                Iterator<AnsTextNode.LinkInfo> it = ansTextNode.linkInfos.iterator();
                while (it.hasNext()) {
                    final AnsTextNode.LinkInfo next = it.next();
                    String str = next.word;
                    int indexOf = ansTextNode.rawText.indexOf(str);
                    int length = str.length() + indexOf;
                    if (indexOf >= 0) {
                        spannableString2.setSpan(new UnderlineSpan(), indexOf, length, 33);
                        spannableString2.setSpan(new ClickableSpan() { // from class: com.tencent.grobot.lite.ui.dialog.TextDialog.1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                if (TextDialog.this.clickListener != null) {
                                    TextDialog.this.dismissCustomDialog();
                                    TextDialog.this.clickListener.onItemClick(TextDialog.this.contentView, -1, -1, next);
                                }
                            }
                        }, indexOf, length, 33);
                        spannableString2.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.chat_msg_url_color)), indexOf, length, 33);
                    }
                }
            }
            this.contentView.setText(spannableString2);
            this.contentView.setTag(ansTextNode);
            return;
        }
        SpannableStringBuilder parseRichText = ansTextNode.parseRichText(ansTextNode.rawText, ansTextNode.actionUrl, ansTextNode.linkWord);
        if (parseRichText != null) {
            this.contentView.setText(parseRichText);
            ViewUtils.setBoldTypeface(this.context, this.contentView);
        }
    }

    public void setFeedbackInfo(String str, EvaluateInfo evaluateInfo, String str2) {
        GoodBadView goodBadView = this.goodBadView;
        if (goodBadView != null) {
            this.answerKey = str;
            this.evaluateInfo = evaluateInfo;
            goodBadView.setFeedbackInfo(str, evaluateInfo, str2);
            return;
        }
        goodBadView.setVisibility(8);
    }

    public void refreshLikeUnlikeView(String str, String str2, String str3) {
        LikeUnlikeSelectInfo likeUnlideSelectInfo = DataManager.getInstance().getLikeUnlideSelectInfo(str);
        if (likeUnlideSelectInfo == null) {
            likeUnlideSelectInfo = new LikeUnlikeSelectInfo();
        }
        likeUnlideSelectInfo.firstText = str2;
        likeUnlideSelectInfo.secondText = str3;
        if (!TextUtils.isEmpty(str)) {
            DataManager.getInstance().setLikeUnlikeSelected(str, likeUnlideSelectInfo);
        }
        this.goodBadView.setFeedbackInfo(this.answerKey, this.evaluateInfo, this.questionId);
    }

    public void setOnItemClickListener(BaseViewHolder.OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
        GoodBadView goodBadView = this.goodBadView;
        if (goodBadView != null) {
            goodBadView.setOnItemClickListener(onItemClickListener);
        }
    }

    public void setIsLastItem(boolean z) {
        if (z) {
            return;
        }
        this.goodBadView.setVisibility(8);
    }
}
