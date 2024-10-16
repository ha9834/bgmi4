package com.tencent.imsdk.android.webview.qq.notch.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowManager;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.webview.qq.notch.IMSDKNotch;
import com.tencent.imsdk.android.webview.qq.notch.INotch;
import java.util.List;

/* loaded from: classes.dex */
public class AndroidNotch implements INotch {
    @Override // com.tencent.imsdk.android.webview.qq.notch.INotch
    public boolean hasNotch(Activity activity) {
        return true;
    }

    @Override // com.tencent.imsdk.android.webview.qq.notch.INotch
    public void useNotch(final Activity activity) {
        if (Build.VERSION.SDK_INT < 28 || activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.notch.impl.AndroidNotch.1
            @Override // java.lang.Runnable
            public void run() {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                activity.getWindow().setAttributes(attributes);
                IMLogger.d("set layoutInDisplayCutoutMode LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES");
            }
        });
    }

    @Override // com.tencent.imsdk.android.webview.qq.notch.INotch
    public void cancelUsingNotch(final Activity activity) {
        if (Build.VERSION.SDK_INT < 28 || activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.notch.impl.AndroidNotch.2
            @Override // java.lang.Runnable
            public void run() {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 2;
                activity.getWindow().setAttributes(attributes);
                IMLogger.d("set layoutInDisplayCutoutMode LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER");
            }
        });
    }

    @Override // com.tencent.imsdk.android.webview.qq.notch.INotch
    public void getNotchInfo(Activity activity, INotch.NotchInfoCallback notchInfoCallback) {
        DisplayCutout displayCutout = IMSDKNotch.getDisplayCutout();
        if (displayCutout != null) {
            IMLogger.d("get cutout " + displayCutout);
            List<Rect> boundingRects = Build.VERSION.SDK_INT >= 28 ? displayCutout.getBoundingRects() : null;
            if (notchInfoCallback != null) {
                notchInfoCallback.onResult(boundingRects);
            }
        }
    }
}
