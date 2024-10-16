package com.tencent.grobot.lite.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.grobot.lite.R;

/* loaded from: classes2.dex */
public class ToastUtils {
    private static volatile ToastUtils instance;
    private View tipView;
    private Toast toast;

    private ToastUtils() {
    }

    public static ToastUtils getInstance() {
        if (instance == null) {
            synchronized (ToastUtils.class) {
                if (instance == null) {
                    instance = new ToastUtils();
                }
            }
        }
        return instance;
    }

    public void showErrorTips(Context context, int i) {
        if (this.tipView == null) {
            this.tipView = LayoutInflater.from(context).inflate(R.layout.toast_error_tip, (ViewGroup) null);
        }
        showCustomToast(context, this.tipView, i);
    }

    private void showCustomToast(Context context, View view, int i) {
        if (this.toast == null) {
            this.toast = new Toast(context);
            if (i != 0 && i != 1) {
                i = 0;
            }
            this.toast.setDuration(i);
            this.toast.setGravity(17, 0, 0);
        }
        if (this.toast.getView() != view) {
            this.toast.setView(view);
        }
        this.toast.show();
    }
}
