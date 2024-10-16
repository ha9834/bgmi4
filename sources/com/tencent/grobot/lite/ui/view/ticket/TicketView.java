package com.tencent.grobot.lite.ui.view.ticket;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class TicketView extends RelativeLayout {
    public Context context;
    public JSONObject oriObj;
    public View rootView;
    public TextView titleText;

    public abstract void buildSubView();

    public TicketView(Context context) {
        this(context, null, 0);
    }

    public TicketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TicketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oriObj = null;
        this.context = context;
        buildSubView();
        buildTitleText();
    }

    public void buildTitleText() {
        this.titleText = (TextView) this.rootView.findViewById(R.id.title);
    }

    public void setData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.oriObj = jSONObject;
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.titleText.setText(optString);
        ViewUtils.setBoldTypeface(this.context, this.titleText);
    }
}
