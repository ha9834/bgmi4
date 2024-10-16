package com.tencent.kgvmp.notch;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import com.ihoc.mgpa.notch.INotchSupport;
import java.util.List;

/* loaded from: classes.dex */
public final class NotchManager {
    private static volatile NotchManager mNotchManager;

    private NotchManager() {
    }

    public static NotchManager getInstance() {
        if (mNotchManager == null) {
            synchronized (NotchManager.class) {
                if (mNotchManager == null) {
                    mNotchManager = new NotchManager();
                }
            }
        }
        return mNotchManager;
    }

    public INotchSupport createNotchSupport(Context context) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().createNotchSupport(context);
    }

    public int getDisplayDensityDpi(Context context) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getDisplayDensityDpi(context);
    }

    public int[] getDisplayRealSize(Context context) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getDisplayRealSize(context);
    }

    public String getNotchInfo() {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getNotchInfo();
    }

    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getNotchSize(context, windowInsets);
    }

    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getSafeDisplay(context, windowInsets);
    }

    public int getStatusBarHeight(Context context) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getStatusBarHeight(context);
    }

    public String getType() {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().getType();
    }

    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().hasNotchSupport(context, windowInsets);
    }

    public boolean isHideNotch(Context context) {
        return com.ihoc.mgpa.notch.NotchManager.getInstance().isHideNotch(context);
    }

    public void notchProbe(Context context) {
        com.ihoc.mgpa.notch.NotchManager.getInstance().notchProbe(context);
    }
}
