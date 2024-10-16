package com.ihoc.mgpa.notch.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public class b extends e {
    @Override // com.ihoc.mgpa.notch.impl.e, com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    @SuppressLint({"NewApi"})
    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 28) {
            DisplayCutout a2 = a(windowInsets);
            if (a2 != null) {
                int safeInsetTop = a2.getSafeInsetTop();
                int safeInsetBottom = a2.getSafeInsetBottom();
                int safeInsetLeft = a2.getSafeInsetLeft();
                int safeInsetRight = a2.getSafeInsetRight();
                int[] displayRealSize = getDisplayRealSize(context);
                return new Rect(safeInsetLeft, safeInsetTop, displayRealSize[0] - safeInsetRight, displayRealSize[1] - safeInsetBottom);
            }
            if (isHideNotch(context)) {
                int[] displayRealSize2 = getDisplayRealSize(context);
                int min = Math.min(displayRealSize2[0], displayRealSize2[1]);
                int max = Math.max(displayRealSize2[0], displayRealSize2[1]);
                int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
                com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_huawei_P", "getRotation = " + rotation);
                Rect rect = new Rect(0, 0, 0, 0);
                if (rotation == 1 || rotation == 3) {
                    rect.set(0, 0, max - getStatusBarHeight(context), min);
                } else {
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei_P", "getRotation is error.");
                }
                return rect;
            }
        }
        return super.getSafeDisplay(context, windowInsets);
    }

    @Override // com.ihoc.mgpa.notch.impl.e, com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Huawei_Android_P";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean isHideNotch(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) == 1;
    }
}
