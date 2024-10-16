package com.tencent.grobot.lite.ui.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.model.local.UploadImageInfo;
import com.tencent.grobot.lite.report.Report;
import com.tencent.grobot.lite.ui.adapter.UploadImageAdapter;
import com.tencent.grobot.lite.ui.presenter.IUploadView;
import com.tencent.grobot.lite.ui.presenter.UploadPresenter;
import com.tencent.grobot.lite.ui.view.component.HorizontalView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FormUploadView extends FormView implements View.OnClickListener, ComponentRef, IUploadView {
    private UploadPresenter mUploadPresenter;
    private int maxAvaliableNum;
    private HorizontalView picHorizontalView;
    private UploadImageAdapter uploadImageAdapter;

    public FormUploadView(Context context) {
        this(context, null, 0);
    }

    public FormUploadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormUploadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUploadPresenter = new UploadPresenter(this);
        this.maxAvaliableNum = 3;
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void buildSubView() {
        this.rootView = LayoutInflater.from(getContext()).inflate(R.layout.formitem_picview, (ViewGroup) this, true);
        this.picHorizontalView = (HorizontalView) this.rootView.findViewById(R.id.picLayout);
        this.uploadImageAdapter = new UploadImageAdapter(getContext());
        UploadImageInfo uploadImageInfo = new UploadImageInfo();
        uploadImageInfo.isAddBtn = true;
        this.uploadImageAdapter.addItems(Collections.singletonList(uploadImageInfo));
        this.uploadImageAdapter.setAddListener(this);
        this.picHorizontalView.setAdapter(this.uploadImageAdapter);
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void setIFormItem(IFormItem iFormItem) {
        this.iFormItem = iFormItem;
        this.uploadImageAdapter.setIFormItem(iFormItem);
        new Report().eventType("1001").itemId("7062").report(false);
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public boolean canCommit() {
        List<UploadImageInfo> datas = this.uploadImageAdapter.getDatas();
        if (this.isMustNeed) {
            if (datas == null || datas.size() <= 1) {
                return false;
            }
            for (UploadImageInfo uploadImageInfo : datas) {
                if (!uploadImageInfo.isAddBtn && (uploadImageInfo.cosName == null || TextUtils.isEmpty(uploadImageInfo.cosName))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public JSONObject getRetObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.oriObj.optString("type"));
            List<UploadImageInfo> datas = this.uploadImageAdapter.getDatas();
            StringBuilder sb = new StringBuilder();
            if (datas == null) {
                return jSONObject;
            }
            for (int i = 0; i < datas.size(); i++) {
                UploadImageInfo uploadImageInfo = datas.get(i);
                String str = uploadImageInfo.cosName;
                if (!TextUtils.isEmpty(str) && !uploadImageInfo.isAddBtn) {
                    sb.append(str);
                    if (i != datas.size() - 1) {
                        sb.append("|");
                    }
                }
            }
            jSONObject.put("msg", sb.toString());
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
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IUploadView
    public void onPhotoSelected(ArrayList<UploadImageInfo> arrayList) {
        List<UploadImageInfo> datas = this.uploadImageAdapter.getDatas();
        int size = datas.size();
        int i = size - 1;
        if (datas.get(i).isAddBtn) {
            this.uploadImageAdapter.addItems(arrayList, i);
            if (size == 3) {
                this.uploadImageAdapter.deleteItem(size);
            }
            if (this.iFormItem != null) {
                this.iFormItem.onItemEditFinish();
            }
        }
    }

    @Override // com.tencent.grobot.lite.ui.presenter.IUploadView
    public void updateUploadImageProgress(final String str, final int i, String str2, String str3) {
        if (i == 100) {
            List<UploadImageInfo> datas = this.uploadImageAdapter.getDatas();
            if (datas == null) {
                return;
            }
            for (UploadImageInfo uploadImageInfo : datas) {
                if (str.equals(uploadImageInfo.imagePath)) {
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        uploadImageInfo.progress = 100;
                        uploadImageInfo.eTag = str2;
                        uploadImageInfo.cosName = str3;
                    } else {
                        uploadImageInfo.progress = i;
                    }
                }
            }
        }
        ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.view.form.FormUploadView.1
            @Override // java.lang.Runnable
            public void run() {
                FormUploadView.this.uploadImageAdapter.refreshItem(str, i);
                if (FormUploadView.this.iFormItem != null) {
                    FormUploadView.this.iFormItem.onItemEditFinish();
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isPermissionGranted()) {
            this.mUploadPresenter.addPic(getContext(), this.maxAvaliableNum);
            new Report().eventType("1002").itemId("7062").report(false);
        }
    }

    private boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (a.b(getContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                if (a.b(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    return true;
                }
            } else {
                final Activity activity = (Activity) getContext();
                ThreadManager.get().postToUiThread(new Runnable() { // from class: com.tencent.grobot.lite.ui.view.form.FormUploadView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
                    }
                });
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        this.titleText = null;
        this.picHorizontalView.setAdapter(null);
        this.picHorizontalView.getRecycledViewPool().a();
        this.picHorizontalView.onDestroy();
        this.picHorizontalView = null;
        this.uploadImageAdapter.setAddListener(null);
        this.uploadImageAdapter = null;
        this.mUploadPresenter = null;
    }

    @Override // com.tencent.grobot.lite.ui.view.form.FormView
    public void handleCallBackOnActivityForResult(int i, int i2, Intent intent) {
        if (i == 4096) {
            if (i2 == -1 && intent != null) {
                this.mUploadPresenter.onAddPicCallBack(getContext(), intent);
            } else {
                this.mUploadPresenter.onAddPicCallBack(getContext(), null);
            }
        }
    }
}
