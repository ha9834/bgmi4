package com.ihoc.mgpa.notch;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;
import com.ihoc.mgpa.notch.impl.CloudNotch;
import com.ihoc.mgpa.notch.impl.NotSupportNotch;
import java.util.List;

/* loaded from: classes2.dex */
public final class NotchManager implements INotchSupport {
    private static volatile NotchManager mNotchManager;
    private INotchSupport mNotchSupport = null;
    private NotchDataRecorder mNotchDataRecorder = null;

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
        NotchCloudConfig notchCloudConfig = new NotchCloudConfig();
        NotchCloudData notchCloudData = notchCloudConfig.getNotchCloudData();
        this.mNotchSupport = notchCloudConfig.isNotchBlack() ? new NotSupportNotch() : (Build.VERSION.SDK_INT >= 28 || notchCloudData == null) ? NotchFactory.createNotch(context) : new CloudNotch(notchCloudData.getNotchWidth(), notchCloudData.getNotchHeight());
        this.mNotchDataRecorder = new NotchDataRecorder(context, this.mNotchSupport);
        return this.mNotchSupport;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public int getDisplayDensityDpi(Context context) {
        return this.mNotchSupport.getDisplayDensityDpi(context);
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public int[] getDisplayRealSize(Context context) {
        return this.mNotchSupport.getDisplayRealSize(context);
    }

    public String getNotchInfo() {
        NotchDataRecorder notchDataRecorder = this.mNotchDataRecorder;
        if (notchDataRecorder != null) {
            return notchDataRecorder.toString();
        }
        return null;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        try {
            List<Rect> notchSize = this.mNotchSupport.getNotchSize(context, windowInsets);
            if (this.mNotchDataRecorder.getNotchSize() == null && notchSize != null) {
                this.mNotchDataRecorder.setNotchSize(notchSize);
            }
            return notchSize;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        try {
            return this.mNotchSupport.getSafeDisplay(context, windowInsets);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public int getStatusBarHeight(Context context) {
        return this.mNotchSupport.getStatusBarHeight(context);
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return this.mNotchSupport.getType();
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        Exception e;
        boolean z;
        try {
            z = this.mNotchSupport.hasNotchSupport(context, windowInsets);
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            if (!this.mNotchDataRecorder.isHasNotchSupport() && z) {
                this.mNotchDataRecorder.setHasNotchSupport(true);
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    @Override // com.ihoc.mgpa.notch.INotchSupport
    public boolean isHideNotch(Context context) {
        try {
            return this.mNotchSupport.isHideNotch(context);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void notchProbe(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            this.mNotchSupport = NotchFactory.createNotch(context);
            this.mNotchDataRecorder = new NotchDataRecorder(context, this.mNotchSupport);
            hasNotchSupport(context, null);
            getNotchSize(context, null);
        }
    }
}
