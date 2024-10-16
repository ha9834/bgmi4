package com.tencent.imsdk.android.webview.qq.notch;

import android.app.Activity;
import android.graphics.Rect;
import java.util.List;

/* loaded from: classes.dex */
public interface INotch {

    /* loaded from: classes.dex */
    public interface NotchInfoCallback {
        void onResult(List<Rect> list);
    }

    void cancelUsingNotch(Activity activity);

    void getNotchInfo(Activity activity, NotchInfoCallback notchInfoCallback);

    boolean hasNotch(Activity activity);

    void useNotch(Activity activity);
}
