package com.tencent.grobot.lite.ui.view.form;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FormSelectView extends FormView {
    private int selectPos;
    private String selectText;
    private Spinner spinner;

    public FormSelectView(Context context) {
        this(context, null, 0);
    }

    public FormSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectText = "";
        this.selectPos = -1;
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void buildSubView() {
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.formitem_select, (ViewGroup) this, true);
        this.spinner = (Spinner) this.rootView.findViewById(R.id.spinner);
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public boolean canCommit() {
        if (this.isMustNeed) {
            return !TextUtils.isEmpty(this.selectText);
        }
        return true;
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void setData(JSONObject jSONObject) {
        super.setData(jSONObject);
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        final ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optJSONObject(i).optString("label"));
            if (optJSONArray.optJSONObject(i).optBoolean("selected")) {
                this.selectPos = i;
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.form_sipnner_layout, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.form_spinner_item);
        if (Build.VERSION.SDK_INT >= 16) {
            this.spinner.setDropDownVerticalOffset(ViewUtils.dip2px(getContext(), 4.0f));
        }
        this.spinner.setBackgroundColor(0);
        this.spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.tencent.grobot.lite.ui.view.form.FormSelectView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                FormSelectView.this.selectText = (String) arrayList.get(i2);
                FormSelectView.this.selectPos = i2;
                if (FormSelectView.this.iFormItem != null) {
                    FormSelectView.this.iFormItem.onItemEditFinish();
                }
            }
        });
        this.spinner.setSelection(this.selectPos);
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public JSONObject getRetObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.oriObj.optString("type"));
            jSONObject.put("title", this.oriObj.optString("title"));
            jSONObject.put("name", this.oriObj.optString("name"));
            jSONObject.put("msg", this.selectText);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
