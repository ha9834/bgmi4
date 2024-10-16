package com.tencent.grobot.lite.ui.dialog;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImagePresenter;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;
import com.tencent.grobot.lite.ui.presenter.MainViewPresenter;
import com.tencent.grobot.lite.ui.view.form.FormSelectView;
import com.tencent.grobot.lite.ui.view.form.FormTextAreaView;
import com.tencent.grobot.lite.ui.view.form.FormTextView;
import com.tencent.grobot.lite.ui.view.form.FormTimeView;
import com.tencent.grobot.lite.ui.view.form.FormUploadView;
import com.tencent.grobot.lite.ui.view.form.FormView;
import com.tencent.grobot.lite.ui.view.form.IFormItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FormDialog extends FrameDialog implements View.OnClickListener, IFormItem {
    private ImageView closeBtn;
    private TextView commitBtn;
    private String email;
    private String formId;
    private String formTemplateType;
    private MainViewPresenter mPresenter;
    private LinearLayout rootContent;
    private List<View> tableViews;
    private String tagId;
    private TextView titleView;

    public FormDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.tableViews = new ArrayList();
        this.formId = "";
        this.tagId = "";
        this.formTemplateType = "";
        this.email = "";
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_form, (ViewGroup) this, false);
        setBackgroundResource(android.R.color.transparent);
        this.titleView = (TextView) inflate.findViewById(R.id.title);
        this.rootContent = (LinearLayout) inflate.findViewById(R.id.content);
        this.closeBtn = (ImageView) inflate.findViewById(R.id.closeBtn);
        this.closeBtn.setOnClickListener(this);
        this.commitBtn = (TextView) inflate.findViewById(R.id.commitBtn);
        this.commitBtn.setOnClickListener(this);
        ViewUtils.setBoldTypeface(getContext(), this.commitBtn);
        return inflate;
    }

    public void clearContent() {
        LinearLayout linearLayout = this.rootContent;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void setPresenter(MainViewPresenter mainViewPresenter) {
        this.mPresenter = mainViewPresenter;
    }

    public void setFormId(String str) {
        this.formId = str;
        this.mPresenter.getFormDetail(str);
    }

    private void commit() {
        String optString;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.rootContent.getChildCount(); i++) {
                View childAt = this.rootContent.getChildAt(i);
                if ((childAt instanceof FormView) && !((FormView) childAt).canCommit()) {
                    this.commitBtn.setBackgroundResource(R.drawable.bg_btn_form_commit_disable);
                    this.commitBtn.setTextColor(getContext().getResources().getColor(R.color.normal_text_disable_color));
                    return;
                }
                JSONObject retObj = ((FormView) childAt).getRetObj();
                if (retObj != null && (optString = retObj.optString("name")) != null && "email".equals(optString)) {
                    this.email = retObj.optString("msg");
                }
                jSONArray.put(i, retObj);
            }
            jSONObject.put("question", jSONArray);
            this.mPresenter.commitForm(jSONObject, this.tagId, this.formId, this.email, this.formTemplateType);
            ImagePresenter.getInstance().onCommitForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildTableItemView(JSONObject jSONObject) {
        FormView formView;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return;
            }
            String optString = optJSONObject.optString("form_template_title");
            if (!TextUtils.isEmpty(optString)) {
                this.titleView.setText(optString);
                ViewUtils.setBoldTypeface(getContext(), this.titleView);
            }
            this.tagId = optJSONObject.optString("tag_id");
            this.formTemplateType = optJSONObject.optString("form_template_type");
            String optString2 = optJSONObject.optString("form_template_detail");
            if (optString2 != null || TextUtils.isEmpty(optString2)) {
                JSONArray jSONArray = new JSONArray(optString2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                    String optString3 = optJSONObject2.optString("type");
                    if (!TextUtils.isEmpty(optString3)) {
                        if (optString3.equals("dropMenu")) {
                            formView = new FormSelectView(getContext());
                            ((FormSelectView) formView).setData(optJSONObject2);
                        } else if (optString3.equals("text")) {
                            formView = new FormTextView(getContext());
                            ((FormTextView) formView).setData(optJSONObject2);
                        } else if (optString3.equals("textarea")) {
                            formView = new FormTextAreaView(getContext());
                            ((FormTextAreaView) formView).setData(optJSONObject2);
                        } else if (optString3.equals("time")) {
                            formView = new FormTimeView(getContext());
                            ((FormTimeView) formView).setData(optJSONObject2);
                        } else if (optString3.equals("upload")) {
                            formView = new FormUploadView(getContext());
                            ((FormUploadView) formView).setData(optJSONObject2);
                        } else {
                            formView = null;
                        }
                        if (formView != null) {
                            formView.setIFormItem(this);
                            this.rootContent.addView(formView);
                            this.tableViews.add(formView);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFormData(int i, JSONObject jSONObject) {
        if (jSONObject == null || i != 0) {
            dismissCustomDialog();
        } else {
            buildContentView(jSONObject);
        }
    }

    private void buildContentView(JSONObject jSONObject) {
        if (jSONObject == null) {
            dismissCustomDialog();
            return;
        }
        if (this.rootContent.getChildCount() > 0) {
            this.rootContent.removeAllViews();
            ViewUtils.clearViews(this.rootContent);
        }
        buildTableItemView(jSONObject);
        this.commitBtn.setVisibility(0);
        updateCommitBtnStatus();
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.closeBtn) {
            dismissCustomDialog();
            ImagePresenter.getInstance().onCommitForm();
        } else if (view == this.commitBtn) {
            commit();
            this.commitBtn.setEnabled(false);
            this.commitBtn.setBackgroundResource(R.drawable.bg_btn_form_commit_disable);
            this.commitBtn.setTextColor(getContext().getResources().getColor(R.color.normal_text_disable_color));
            new Report().eventType("1002").itemId("7063").report(false);
        }
    }

    public void onFormCommitResult(int i, String str) {
        if (i == 0) {
            dismissCustomDialog();
        } else {
            updateCommitBtnStatus();
        }
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected void destoryView() {
        this.titleView = null;
        this.closeBtn.setOnClickListener(null);
        this.closeBtn = null;
        this.rootContent = null;
        this.commitBtn.setOnClickListener(null);
        this.commitBtn = null;
        for (View view : this.tableViews) {
            if (view instanceof FormUploadView) {
                ((FormUploadView) view).onDestroy();
            }
        }
        this.tableViews.clear();
        this.mPresenter = null;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    public void handleCallBackOnActivityForResult(int i, int i2, Intent intent) {
        for (View view : this.tableViews) {
            if (view instanceof FormView) {
                ((FormView) view).handleCallBackOnActivityForResult(i, i2, intent);
            }
        }
    }

    @Override // com.tencent.grobot.lite.ui.view.form.IFormItem
    public void onItemEditFinish() {
        updateCommitBtnStatus();
    }

    private void updateCommitBtnStatus() {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.rootContent.getChildCount()) {
                z = true;
                break;
            }
            View childAt = this.rootContent.getChildAt(i);
            if ((childAt instanceof FormView) && !((FormView) childAt).canCommit()) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            this.commitBtn.setEnabled(true);
            this.commitBtn.setBackgroundResource(R.drawable.bg_btn_form_commit);
            this.commitBtn.setTextColor(getContext().getResources().getColor(R.color.normal_text_color));
        } else {
            this.commitBtn.setEnabled(false);
            this.commitBtn.setBackgroundResource(R.drawable.bg_btn_form_commit_disable);
            this.commitBtn.setTextColor(getContext().getResources().getColor(R.color.normal_text_disable_color));
        }
    }
}
