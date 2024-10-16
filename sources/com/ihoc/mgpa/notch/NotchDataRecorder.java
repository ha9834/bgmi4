package com.ihoc.mgpa.notch;

import android.content.Context;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class NotchDataRecorder {
    private int densityDpi;
    private INotchSupport iNotch;
    private Context mContext;
    private int[] screenWh;
    private int statusBarHeight;
    private String supportType;
    private boolean hasNotchSupport = false;
    private List<Rect> notchSize = null;

    public NotchDataRecorder(Context context, INotchSupport iNotchSupport) {
        this.iNotch = iNotchSupport;
        this.mContext = context;
        this.supportType = iNotchSupport.getType();
        this.statusBarHeight = iNotchSupport.getStatusBarHeight(context);
        this.densityDpi = iNotchSupport.getDisplayDensityDpi(context);
        this.screenWh = iNotchSupport.getDisplayRealSize(context);
    }

    public List<Rect> getNotchSize() {
        return this.notchSize;
    }

    public boolean isHasNotchSupport() {
        return this.hasNotchSupport;
    }

    public void setHasNotchSupport(boolean z) {
        this.hasNotchSupport = z;
    }

    public void setNotchSize(List<Rect> list) {
        this.notchSize = list;
    }

    public String toString() {
        try {
            if (this.iNotch == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("notchInfo ");
            sb.append("hasNotch:");
            sb.append(this.hasNotchSupport);
            sb.append(", isHideNotch:");
            sb.append(this.iNotch.isHideNotch(this.mContext));
            sb.append(", notchSupportType:");
            sb.append(this.supportType);
            if (this.hasNotchSupport) {
                sb.append(", notchSize:");
                if (this.notchSize != null) {
                    Iterator<Rect> it = this.notchSize.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().toString());
                    }
                }
            }
            sb.append(", statusBarHeight:");
            sb.append(this.statusBarHeight);
            sb.append(", densityDpi:");
            sb.append(this.densityDpi);
            sb.append(", screenWidth:");
            sb.append(this.screenWh[0]);
            sb.append(", screenHeight:");
            sb.append(this.screenWh[1]);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
