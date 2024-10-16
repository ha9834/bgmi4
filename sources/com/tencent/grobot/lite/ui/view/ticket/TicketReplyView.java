package com.tencent.grobot.lite.ui.view.ticket;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public class TicketReplyView extends RelativeLayout implements View.OnClickListener, ComponentRef {
    private TextView contentText;
    private Context context;
    private View.OnClickListener submitListener;
    private boolean toggle;
    private TextView tvSubmitted;

    public TicketReplyView(Context context) {
        this(context, null, 0);
    }

    public TicketReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TicketReplyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.toggle = false;
        this.context = context;
        buildSubview();
    }

    private void buildSubview() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ticket_replyview, (ViewGroup) this, true);
        ViewUtils.setBoldTypeface(this.context, (TextView) inflate.findViewById(R.id.title));
        this.contentText = (TextView) inflate.findViewById(R.id.replyText);
        ViewUtils.setBoldTypeface(this.context, this.contentText);
        this.tvSubmitted = (TextView) inflate.findViewById(R.id.tv_submit);
        ViewUtils.setBoldTypeface(this.context, this.tvSubmitted);
        this.tvSubmitted.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ticket_submit_down, 0);
        this.tvSubmitted.setOnClickListener(this);
    }

    public void setReplyText(String str) {
        this.contentText.setText(str);
    }

    public void setSubmitClickListener(View.OnClickListener onClickListener) {
        this.submitListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.submitListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this.toggle = !this.toggle;
        this.tvSubmitted.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.toggle ? R.drawable.ticket_submit_up : R.drawable.ticket_submit_down, 0);
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        this.tvSubmitted.setOnClickListener(null);
        this.submitListener = null;
    }
}
