package com.tencent.grobot.lite.ui.dialog;

import android.widget.TextView;
import com.tencent.grobot.lite.R;

/* loaded from: classes2.dex */
public class TipDialogCompat {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initTipText(TextView textView) {
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.dialog_tx));
    }

    private TipDialogCompat() {
        throw new UnsupportedOperationException("Can not create an object.");
    }
}
