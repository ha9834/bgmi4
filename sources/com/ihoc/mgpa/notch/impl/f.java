package com.ihoc.mgpa.notch.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class f extends c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5685a = false;
    private static int[] b = null;
    private static boolean c = true;

    private int a(Context context) {
        try {
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtDeviceInfo");
                        return ((Integer) loadClass.getDeclaredMethod("getEarDnWidth", Context.class).invoke(loadClass, context)).intValue();
                    } catch (Exception e) {
                        com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarDnWidth Exception");
                        e.printStackTrace();
                        return 0;
                    }
                } catch (NoSuchMethodException unused) {
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarDnWidth NoSuchMethodException: getEarDnWidth");
                    return 0;
                }
            } catch (ClassNotFoundException unused2) {
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarDnWidth ClassNotFoundException: FtDeviceInfo");
                return 0;
            }
        } catch (Throwable unused3) {
            return 0;
        }
    }

    private int b(Context context) {
        try {
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtDeviceInfo");
                        return ((Integer) loadClass.getDeclaredMethod("getEarHeight", Context.class).invoke(loadClass, context)).intValue();
                    } catch (Exception e) {
                        com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarHeight Exception");
                        e.printStackTrace();
                        return 0;
                    }
                } catch (NoSuchMethodException unused) {
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarHeight NoSuchMethodException: getEarHeight");
                    return 0;
                }
            } catch (ClassNotFoundException unused2) {
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarHeight ClassNotFoundException: FtDeviceInfo");
                return 0;
            }
        } catch (Throwable unused3) {
            return 0;
        }
    }

    private int c(Context context) {
        try {
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtDeviceInfo");
                        return ((Integer) loadClass.getDeclaredMethod("getEarUpWidth", Context.class).invoke(loadClass, context)).intValue();
                    } catch (Exception e) {
                        com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarUpWidth Exception");
                        e.printStackTrace();
                        return 0;
                    }
                } catch (NoSuchMethodException unused) {
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarUpWidth NoSuchMethodException: getEarUpWidth");
                    return 0;
                }
            } catch (ClassNotFoundException unused2) {
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getEarUpWidth ClassNotFoundException: FtDeviceInfo");
                return 0;
            }
        } catch (Throwable unused3) {
            return 0;
        }
    }

    private int[] d(Context context) {
        if (b == null) {
            int c2 = c(context);
            int a2 = a(context);
            b = new int[]{Math.max(c2, a2), b(context)};
        }
        return b;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        int[] d = d(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_vivo", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set((min - d[0]) / 2, 0, ((min - d[0]) / 2) + d[0], d[1]);
                break;
            case 1:
                rect.set(0, (min - d[0]) / 2, d[1], ((min - d[0]) / 2) + d[0]);
                break;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "rotation is not support.");
                rect.set((min - d[0]) / 2, max - d[1], ((min - d[0]) / 2) + d[0], max);
                break;
            case 3:
                rect.set(max - d[1], (min - d[0]) / 2, max, ((min - d[0]) / 2) + d[0]);
                break;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getRotation is error.");
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
        int[] d = d(context);
        int[] displayRealSize = getDisplayRealSize(context);
        int min = Math.min(displayRealSize[0], displayRealSize[1]);
        int max = Math.max(displayRealSize[0], displayRealSize[1]);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_vivo", "getRotation = " + rotation);
        Rect rect = new Rect(0, 0, 0, 0);
        switch (rotation) {
            case 0:
                rect.set(0, d[1], min, max);
                return rect;
            case 1:
                rect.set(d[1], 0, max, min);
                return rect;
            case 2:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "rotation is not support.");
                rect.set(0, 0, min, max - d[1]);
                return rect;
            case 3:
                rect.set(0, 0, max - d[1], min);
                return rect;
            default:
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "getRotation is error.");
                return rect;
        }
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "Vivo_O";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        String str;
        String str2;
        if (!c) {
            return f5685a;
        }
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                boolean booleanValue = ((Boolean) loadClass.getDeclaredMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
                c = false;
                f5685a = booleanValue;
                return booleanValue;
            } catch (ClassNotFoundException unused) {
                str = "NOTCHSDK_vivo";
                str2 = "hasNotchInScreen ClassNotFoundException: FtFeature";
                com.ihoc.mgpa.notch.a.a.a(str, str2);
                c = false;
                f5685a = false;
                return false;
            } catch (NoSuchMethodException unused2) {
                str = "NOTCHSDK_vivo";
                str2 = "hasNotchInScreen NoSuchMethodException: isFeatureSupport";
                com.ihoc.mgpa.notch.a.a.a(str, str2);
                c = false;
                f5685a = false;
                return false;
            } catch (Exception e) {
                com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_vivo", "hasNotchInScreen Exception");
                e.printStackTrace();
                c = false;
                f5685a = false;
                return false;
            }
        } catch (Throwable unused3) {
            c = false;
            f5685a = false;
            return false;
        }
    }
}
