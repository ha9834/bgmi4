package com.ihoc.mgpa.notch.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes2.dex */
public class e extends c {
    @SuppressLint({"NewApi"})
    public DisplayCutout a(WindowInsets windowInsets) {
        if (windowInsets != null) {
            return windowInsets.getDisplayCutout();
        }
        return null;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    @SuppressLint({"NewApi"})
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        DisplayCutout a2;
        if (Build.VERSION.SDK_INT < 28 || (a2 = a(windowInsets)) == null) {
            return null;
        }
        return a2.getBoundingRects();
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    @SuppressLint({"NewApi"})
    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        DisplayCutout a2;
        if (Build.VERSION.SDK_INT < 28 || (a2 = a(windowInsets)) == null) {
            return super.getSafeDisplay(context, windowInsets);
        }
        int safeInsetTop = a2.getSafeInsetTop();
        int safeInsetBottom = a2.getSafeInsetBottom();
        int safeInsetLeft = a2.getSafeInsetLeft();
        int safeInsetRight = a2.getSafeInsetRight();
        int[] displayRealSize = getDisplayRealSize(context);
        return new Rect(safeInsetLeft, safeInsetTop, displayRealSize[0] - safeInsetRight, displayRealSize[1] - safeInsetBottom);
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Android_P";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    @SuppressLint({"NewApi"})
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        DisplayCutout a2;
        return (Build.VERSION.SDK_INT < 28 || (a2 = a(windowInsets)) == null || a2.getBoundingRects().isEmpty()) ? false : true;
    }
}
