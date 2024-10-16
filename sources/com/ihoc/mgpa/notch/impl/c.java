package com.ihoc.mgpa.notch.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.ihoc.mgpa.notch.INotchSupport;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class c implements INotchSupport {
    @SuppressLint({"NewApi"})
    private DisplayMetrics getDisplayRealMetrics(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public final int getDisplayDensityDpi(Context context) {
        return getDisplayRealMetrics(context).densityDpi;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public final int[] getDisplayRealSize(Context context) {
        int[] iArr = {0, 0};
        DisplayMetrics displayRealMetrics = getDisplayRealMetrics(context);
        iArr[0] = displayRealMetrics.widthPixels;
        iArr[1] = displayRealMetrics.heightPixels;
        return iArr;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public abstract List<Rect> getNotchSize(Context context, WindowInsets windowInsets);

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        int[] displayRealSize = getDisplayRealSize(context);
        return new Rect(0, 0, displayRealSize[0], displayRealSize[1]);
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public final int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public abstract String getType();

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public abstract boolean hasNotchSupport(Context context, WindowInsets windowInsets);

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public boolean isHideNotch(Context context) {
        return false;
    }
}
