package com.ihoc.mgpa.notch.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class d extends c {

    /* renamed from: a, reason: collision with root package name */
    private static int[] f5684a;

    private int[] a(Context context) {
        String a2;
        if (f5684a == null && (a2 = com.ihoc.mgpa.notch.a.b.a("ro.oppo.screen.heteromorphism")) != null) {
            try {
                String[] split = a2.split("\\:|\\,");
                f5684a = new int[]{Integer.parseInt(split[2]) - Integer.parseInt(split[0]), Integer.parseInt(split[3]) - Integer.parseInt(split[1])};
                return f5684a;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f5684a;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        if (!hasNotchSupport(context, windowInsets)) {
            return null;
        }
        int[] a2 = a(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_oppo", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set((min - a2[0]) / 2, 0, ((min - a2[0]) / 2) + a2[0], a2[1]);
                break;
            case 1:
                rect.set(0, (min - a2[0]) / 2, a2[1], ((min - a2[0]) / 2) + a2[0]);
                break;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_oppo", "rotation is not support.");
                rect.set((min - a2[0]) / 2, max - a2[1], ((min - a2[0]) / 2) + a2[0], max);
                break;
            case 3:
                rect.set(max - a2[1], (min - a2[0]) / 2, max, ((min - a2[0]) / 2) + a2[0]);
                break;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_oppo", "getRotation is error.");
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
        int[] a2 = a(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_oppo", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set(0, a2[1], min, max);
                return rect;
            case 1:
                rect.set(a2[1], 0, max, min);
                return rect;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_oppo", "rotation is not support.");
                rect.set(0, 0, min, max - a2[1]);
                return rect;
            case 3:
                rect.set(0, 0, max - a2[1], min);
                return rect;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_oppo", "getRotation is error.");
                return rect;
        }
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Oppo_O";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
