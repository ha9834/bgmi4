package com.ihoc.mgpa.notch.impl;

import android.content.Context;
import android.graphics.Rect;
import android.provider.Settings;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5683a = false;
    private static int[] b = null;
    private static boolean c = true;

    private int[] a(Context context) {
        int[] iArr = b;
        if (iArr == null) {
            iArr = new int[]{0, 0};
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                        int[] iArr2 = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
                        b = iArr2;
                        return iArr2;
                    } catch (NoSuchMethodException unused) {
                        com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "getNotchSize NoSuchMethodException: getNotchSize");
                        b = iArr;
                        return iArr;
                    }
                } catch (ClassNotFoundException unused2) {
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "getNotchSize ClassNotFoundException: HwNotchSizeUtil");
                    b = iArr;
                    return iArr;
                } catch (Exception e) {
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "getNotchSize Exception");
                    e.printStackTrace();
                    b = iArr;
                    return iArr;
                }
            } catch (Throwable unused3) {
                b = iArr;
            }
        }
        return iArr;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        int[] a2 = a(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_huawei", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set((min - a2[0]) / 2, 0, ((min - a2[0]) / 2) + a2[0], a2[1]);
                break;
            case 1:
                rect.set(0, (min - a2[0]) / 2, a2[1], ((min - a2[0]) / 2) + a2[0]);
                break;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "rotation is not support.");
                rect.set((min - a2[0]) / 2, max - a2[1], ((min - a2[0]) / 2) + a2[0], max);
                break;
            case 3:
                rect.set(max - a2[1], (min - a2[0]) / 2, max, ((min - a2[0]) / 2) + a2[0]);
                break;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "getRotation is error.");
                break;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(rect);
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public Rect getSafeDisplay(Context context, WindowInsets windowInsets) {
        if (!hasNotchSupport(context, windowInsets)) {
            return super.getSafeDisplay(context, windowInsets);
        }
        a(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_huawei", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set(0, getStatusBarHeight(context), min, max);
                break;
            case 1:
                if (!isHideNotch(context)) {
                    rect.set(getStatusBarHeight(context), 0, max, min);
                    break;
                }
                rect.set(0, 0, max - getStatusBarHeight(context), min);
                break;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "rotation is not support.");
                rect.set(0, 0, min, max - getStatusBarHeight(context));
                break;
            case 3:
                rect.set(0, 0, max - getStatusBarHeight(context), min);
                break;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "getRotation is error.");
                break;
        }
        return rect;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Huawei_O";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        String str;
        String str2;
        if (!c) {
            return f5683a;
        }
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                boolean booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
                c = false;
                f5683a = booleanValue;
                return booleanValue;
            } catch (ClassNotFoundException unused) {
                str = "NOTCHSDK_huawei";
                str2 = "hasNotchInScreen ClassNotFoundException: HwNotchSizeUtil";
                com.ihoc.mgpa.notch.a.a.a(str, str2);
                c = false;
                f5683a = false;
                return false;
            } catch (NoSuchMethodException unused2) {
                str = "NOTCHSDK_huawei";
                str2 = "hasNotchInScreen NoSuchMethodException: hasNotchInScreen";
                com.ihoc.mgpa.notch.a.a.a(str, str2);
                c = false;
                f5683a = false;
                return false;
            } catch (Exception e) {
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_huawei", "hasNotchInScreen Exception");
                e.printStackTrace();
                c = false;
                f5683a = false;
                return false;
            }
        } catch (Throwable unused3) {
            c = false;
            f5683a = false;
            return false;
        }
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean isHideNotch(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) == 1;
    }
}
