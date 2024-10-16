package com.ihoc.mgpa.notch.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudNotch extends c {

    /* renamed from: a, reason: collision with root package name */
    private int f5682a;
    private int b;

    public CloudNotch(int i, int i2) {
        this.f5682a = 0;
        this.b = 0;
        this.f5682a = i;
        this.b = i2;
    }

    private int a(Context context) {
        return this.b;
    }

    private int b(Context context) {
        return this.f5682a;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        int b = b(context);
        int a2 = a(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        if ((b == 0 || a2 == 0) && hasNotchSupport(context, windowInsets)) {
            a2 = getStatusBarHeight(context);
            b = min;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_cloud", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                int i = (min - b) / 2;
                rect.set(i, 0, b + i, a2);
                break;
            case 1:
                int i2 = (min - b) / 2;
                rect.set(0, i2, a2, b + i2);
                break;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_cloud", "rotation is not support.");
                int i3 = (min - b) / 2;
                rect.set(i3, max - a2, b + i3, max);
                break;
            case 3:
                int i4 = (min - b) / 2;
                rect.set(max - a2, i4, max, b + i4);
                break;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_cloud", "getRotation is error.");
                break;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(rect);
        return arrayList;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        if (!hasNotchSupport(context, windowInsets)) {
            return super.getSafeDisplay(context, windowInsets);
        }
        int b = b(context);
        int a2 = a(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        if ((b == 0 || a2 == 0) && hasNotchSupport(context, windowInsets)) {
            a2 = getStatusBarHeight(context);
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_cloud", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set(0, a2, min, max);
                return rect;
            case 1:
                rect.set(a2, 0, max, min);
                return rect;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_cloud", "rotation is not support.");
                rect.set(0, 0, min, max - a2);
                return rect;
            case 3:
                rect.set(0, 0, max - a2, min);
                return rect;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_cloud", "getRotation is error.");
                return rect;
        }
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Cloud_O";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        return true;
    }
}
