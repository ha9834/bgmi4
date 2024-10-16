package com.tencent.grobot.lite.ui.view.form;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FormTimeView extends FormView {
    private static final String TAG = "FormTimeView";
    private Calendar calendar;
    private EditText etDay;
    private EditText etMonth;
    private EditText etYear;
    private SimpleDateFormat format;
    private String selectTime;

    public FormTimeView(Context context) {
        this(context, null, 0);
    }

    public FormTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void buildSubView() {
        this.calendar = Calendar.getInstance();
        this.format = new SimpleDateFormat("yyyy-MM-dd");
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.formitem_time, (ViewGroup) this, true);
        this.etMonth = (EditText) this.rootView.findViewById(R.id.et_month);
        this.etDay = (EditText) this.rootView.findViewById(R.id.et_day);
        this.etYear = (EditText) this.rootView.findViewById(R.id.et_year);
        this.etMonth.addTextChangedListener(new TextWatcher() { // from class: com.tencent.grobot.lite.ui.view.form.FormTimeView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (FormTimeView.this.iFormItem != null) {
                    FormTimeView.this.iFormItem.onItemEditFinish();
                }
            }
        });
        this.etDay.addTextChangedListener(new TextWatcher() { // from class: com.tencent.grobot.lite.ui.view.form.FormTimeView.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (FormTimeView.this.iFormItem != null) {
                    FormTimeView.this.iFormItem.onItemEditFinish();
                }
            }
        });
        this.etYear.addTextChangedListener(new TextWatcher() { // from class: com.tencent.grobot.lite.ui.view.form.FormTimeView.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (FormTimeView.this.iFormItem != null) {
                    FormTimeView.this.iFormItem.onItemEditFinish();
                }
            }
        });
        this.etMonth.setFilters(new InputFilter[]{new MinMaxFilter(1, 12)});
        this.etDay.setFilters(new InputFilter[]{new MinMaxFilter(1, 31)});
        this.etYear.setFilters(new InputFilter[]{new MinMaxFilter(1, 9999)});
        this.calendar.setTimeInMillis(System.currentTimeMillis());
        this.etMonth.setText(String.valueOf(this.calendar.get(2) + 1));
        this.etDay.setText(String.valueOf(this.calendar.get(5)));
        this.etYear.setText(String.valueOf(this.calendar.get(1)));
        ViewUtils.setBoldTypeface(getContext(), this.etMonth);
        ViewUtils.setBoldTypeface(getContext(), this.etDay);
        ViewUtils.setBoldTypeface(getContext(), this.etYear);
        ViewUtils.setBoldTypeface(getContext(), (TextView) this.rootView.findViewById(R.id.tv_divider));
        ViewUtils.setBoldTypeface(getContext(), (TextView) this.rootView.findViewById(R.id.tv_divider_after));
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public boolean canCommit() {
        if (!this.isMustNeed) {
            return true;
        }
        try {
            this.calendar.set(1, Integer.valueOf(this.etYear.getText().toString()).intValue());
            this.calendar.set(2, Integer.valueOf(this.etMonth.getText().toString()).intValue() - 1);
            this.calendar.set(5, Integer.valueOf(this.etDay.getText().toString()).intValue());
            this.selectTime = this.format.format(this.calendar.getTime());
            if (TextUtils.isEmpty(this.etMonth.getText().toString()) || TextUtils.isEmpty(this.etDay.getText().toString())) {
                return false;
            }
            return !TextUtils.isEmpty(this.etYear.getText().toString());
        } catch (Exception e) {
            TLog.d(TAG, "canCommit failed, " + e.getMessage());
            return false;
        }
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public JSONObject getRetObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.oriObj.optString("type"));
            jSONObject.put("msg", String.valueOf(this.selectTime));
            jSONObject.put("title", this.oriObj.optString("title"));
            jSONObject.put("name", this.oriObj.optString("name"));
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void setData(JSONObject jSONObject) {
        super.setData(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.oriObj = jSONObject;
        String optString = jSONObject.optString("title");
        this.isMustNeed = jSONObject.optBoolean("is_need");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.titleText.setText(optString);
        ViewUtils.setBoldTypeface(getContext(), this.titleText);
    }

    /* loaded from: classes2.dex */
    private static final class MinMaxFilter implements InputFilter {
        private final int max;
        private final int min;

        private boolean isInRange(int i, int i2, int i3) {
            if (i2 > i) {
                if (i3 >= i && i3 <= i2) {
                    return true;
                }
            } else if (i3 >= i2 && i3 <= i) {
                return true;
            }
            return false;
        }

        MinMaxFilter(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            try {
                if (isInRange(this.min, this.max, Integer.parseInt(spanned.toString() + charSequence.toString()))) {
                    return null;
                }
                return "";
            } catch (NumberFormatException e) {
                TLog.d(FormTimeView.TAG, "filter failed, " + e.getMessage());
                return "";
            }
        }
    }
}
