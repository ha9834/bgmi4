package com.ihoc.mgpa.notch.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class g extends c {
    private int a(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_xiaomi", "get notch height fail");
        return 0;
    }

    private int b(Context context) {
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_xiaomi", "get notch width fail");
        return 0;
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
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_xiaomi", "getRotation = " + rotation);
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
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_xiaomi", "rotation is not support.");
                int i3 = (min - b) / 2;
                rect.set(i3, max - a2, b + i3, max);
                break;
            case 3:
                int i4 = (min - b) / 2;
                rect.set(max - a2, i4, max, b + i4);
                break;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_xiaomi", "getRotation is error.");
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
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_xiaomi", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                if (isHideNotch(context)) {
                    rect.set(0, getStatusBarHeight(context), min, max);
                } else {
                    rect.set(0, a2, min, max);
                }
                return rect;
            case 1:
                rect.set(a2, 0, max, min);
                return rect;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_xiaomi", "rotation is not support.");
                rect.set(0, 0, min, max - a2);
                return rect;
            case 3:
                rect.set(0, 0, max - a2, min);
                return rect;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_xiaomi", "getRotation is error.");
                return rect;
        }
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Xiaomi_O";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        String a2 = com.ihoc.mgpa.notch.a.b.a("ro.miui.notch", "0");
        if (a2 == null || a2.length() <= 0) {
            return false;
        }
        try {
            return 1 == Integer.parseInt(a2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    @SuppressLint({"NewApi"})
    public boolean isHideNotch(Context context) {
        return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(context.getContentResolver(), "force_black", 0) == 1;
    }
}
