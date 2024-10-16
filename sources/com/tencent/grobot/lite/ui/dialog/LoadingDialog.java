package com.tencent.grobot.lite.ui.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public final class LoadingDialog extends Dialog {
    private final int length;

    public LoadingDialog(DialogContainer dialogContainer) {
        super(dialogContainer);
        this.length = ViewUtils.dip2px(this.context, 140.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.dialog.Dialog
    public View view() {
        return LayoutInflater.from(this.context).inflate(R.layout.dialog_loading, (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.dialog.Dialog
    public int width() {
        return this.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.ui.dialog.Dialog
    public int heigth() {
        return this.length;
    }
}
