package com.ihoc.mgpa.notch;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes2.dex */
public interface INotchSupport {
    int getDisplayDensityDpi(Context context);

    int[] getDisplayRealSize(Context context);

    List<Rect> getNotchSize(Context context, WindowInsets windowInsets);

    Rect getSafeDisplay(Context context, WindowInsets windowInsets);

    int getStatusBarHeight(Context context);

    String getType();

    boolean hasNotchSupport(Context context, WindowInsets windowInsets);

    boolean isHideNotch(Context context);
}
