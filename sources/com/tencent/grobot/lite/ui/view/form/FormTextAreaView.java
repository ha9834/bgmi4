package com.tencent.grobot.lite.ui.view.form;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.ui.view.component.XYEditText;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FormTextAreaView extends FormView {
    private XYEditText inputText;

    public FormTextAreaView(Context context) {
        this(context, null, 0);
    }

    public FormTextAreaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormTextAreaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void buildSubView() {
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.formitem_text, (ViewGroup) this, true);
        this.inputText = (XYEditText) this.rootView.findViewById(R.id.input_content);
        this.inputText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.grobot.lite.ui.view.form.FormTextAreaView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (FormTextAreaView.this.iFormItem != null) {
                    FormTextAreaView.this.iFormItem.onItemEditFinish();
                }
            }
        });
        this.inputText.setKeyEventListener(new XYEditText.OnKeyEventListener() { // from class: com.tencent.grobot.lite.ui.view.form.FormTextAreaView.2
            @Override // com.tencent.grobot.lite.ui.view.component.XYEditText.OnKeyEventListener
            public void onKeyboardHide() {
            }

            @Override // com.tencent.grobot.lite.ui.view.component.XYEditText.OnKeyEventListener
            public void onDeleteClick() {
                String obj = FormTextAreaView.this.inputText.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    FormTextAreaView.this.inputText.setText("");
                } else {
                    FormTextAreaView.this.inputText.setText(obj.substring(0, obj.length() - 1));
                }
                FormTextAreaView.this.inputText.setSelection(FormTextAreaView.this.inputText.getText().length());
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public boolean canCommit() {
        if (this.isMustNeed) {
            return !TextUtils.isEmpty(this.inputText.getText().toString());
        }
        return true;
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void setData(JSONObject jSONObject) {
        super.setData(jSONObject);
        if (jSONObject == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.inputText.getLayoutParams()).height = ViewUtils.dip2px(getContext(), 51.0f);
        this.inputText.setSingleLine(false);
        this.inputText.setScrollbarFadingEnabled(true);
        this.inputText.setGravity(8388611);
        ViewUtils.setBoldTypeface(getContext(), this.inputText);
        this.inputText.setHint(jSONObject.optString("tip"));
        int dip2px = ViewUtils.dip2px(getContext(), 10.0f);
        this.inputText.setPadding(dip2px, dip2px, dip2px, dip2px);
        this.inputText.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.grobot.lite.ui.view.form.FormTextAreaView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public JSONObject getRetObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.oriObj.optString("type"));
            jSONObject.put("msg", this.inputText.getText().toString());
            jSONObject.put("title", this.oriObj.optString("title"));
            jSONObject.put("name", this.oriObj.optString("name"));
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
