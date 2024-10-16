package com.tencent.grobot.lite.ui.view.ticket;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TicketTextView extends TicketView {
    private TextView contentText;

    public TicketTextView(Context context) {
        this(context, null, 0);
    }

    public TicketTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TicketTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.tencent.grobot.lite.ui.view.ticket.TicketView
    public void buildSubView() {
        this.rootView = LayoutInflater.from(this.context).inflate(R.layout.ticketitem_text, (ViewGroup) this, true);
        this.contentText = (TextView) this.rootView.findViewById(R.id.input_content);
    }

    @Override // com.tencent.grobot.lite.ui.view.ticket.TicketView
    public void setData(JSONObject jSONObject) {
        super.setData(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.contentText.setText(jSONObject.optString("msg"));
        ViewUtils.setBoldTypeface(this.context, this.contentText);
    }
}
