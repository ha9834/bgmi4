package com.tencent.grobot.lite.ui.view.form;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class FormView extends RelativeLayout {
    public IFormItem iFormItem;
    public boolean isMustNeed;
    public JSONObject oriObj;
    public View rootView;
    public TextView starText;
    public TextView titleText;

    public abstract void buildSubView();

    public abstract boolean canCommit();

    public void handleCallBackOnActivityForResult(int i, int i2, Intent intent) {
    }

    public FormView(Context context) {
        this(context, null, 0);
    }

    public FormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oriObj = null;
        this.isMustNeed = false;
        buildSubView();
        buildTitleAndStarText();
    }

    public void buildTitleAndStarText() {
        this.titleText = (TextView) this.rootView.findViewById(R.id.title);
        this.starText = (TextView) this.rootView.findViewById(R.id.star);
    }

    public JSONObject getRetObj() {
        return this.oriObj;
    }

    public void setData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.oriObj = jSONObject;
        String optString = jSONObject.optString("title");
        this.isMustNeed = jSONObject.optBoolean("is_need");
        if (!TextUtils.isEmpty(optString)) {
            this.titleText.setText(optString);
            ViewUtils.setBoldTypeface(getContext(), this.titleText);
        }
        if (this.isMustNeed) {
            this.starText.setVisibility(0);
        } else {
            this.starText.setVisibility(8);
        }
    }

    public void setIFormItem(IFormItem iFormItem) {
        this.iFormItem = iFormItem;
    }
}
