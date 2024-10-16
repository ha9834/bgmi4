package com.nostra13.universalimageloader.b;

import android.opengl.GLES10;
import com.amazonaws.event.ProgressEvent;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static com.nostra13.universalimageloader.core.assist.c f5716a;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], ProgressEvent.PART_COMPLETED_EVENT_CODE);
        f5716a = new com.nostra13.universalimageloader.core.assist.c(max, max);
    }

    public static com.nostra13.universalimageloader.core.assist.c a(com.nostra13.universalimageloader.core.c.a aVar, com.nostra13.universalimageloader.core.assist.c cVar) {
        int a2 = aVar.a();
        if (a2 <= 0) {
            a2 = cVar.a();
        }
        int b = aVar.b();
        if (b <= 0) {
            b = cVar.b();
        }
        return new com.nostra13.universalimageloader.core.assist.c(a2, b);
    }

    public static int a(com.nostra13.universalimageloader.core.assist.c cVar, com.nostra13.universalimageloader.core.assist.c cVar2, ViewScaleType viewScaleType, boolean z) {
        int max;
        int a2 = cVar.a();
        int b = cVar.b();
        int a3 = cVar2.a();
        int b2 = cVar2.b();
        switch (viewScaleType) {
            case FIT_INSIDE:
                if (z) {
                    int i = a2 / 2;
                    int i2 = b / 2;
                    int i3 = 1;
                    while (true) {
                        if (i / i3 <= a3 && i2 / i3 <= b2) {
                            max = i3;
                            break;
                        } else {
                            i3 *= 2;
                        }
                    }
                } else {
                    max = Math.max(a2 / a3, b / b2);
                    break;
                }
                break;
            case CROP:
                if (z) {
                    int i4 = a2 / 2;
                    int i5 = b / 2;
                    int i6 = 1;
                    while (i4 / i6 > a3 && i5 / i6 > b2) {
                        i6 *= 2;
                    }
                    max = i6;
                    break;
                } else {
                    max = Math.min(a2 / a3, b / b2);
                    break;
                }
            default:
                max = 1;
                break;
        }
        if (max < 1) {
            max = 1;
        }
        return a(a2, b, max, z);
    }

    private static int a(int i, int i2, int i3, boolean z) {
        int a2 = f5716a.a();
        int b = f5716a.b();
        while (true) {
            if (i / i3 <= a2 && i2 / i3 <= b) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    public static int a(com.nostra13.universalimageloader.core.assist.c cVar) {
        int a2 = cVar.a();
        int b = cVar.b();
        return Math.max((int) Math.ceil(a2 / f5716a.a()), (int) Math.ceil(b / f5716a.b()));
    }

    public static float b(com.nostra13.universalimageloader.core.assist.c cVar, com.nostra13.universalimageloader.core.assist.c cVar2, ViewScaleType viewScaleType, boolean z) {
        int a2 = cVar.a();
        int b = cVar.b();
        int a3 = cVar2.a();
        int b2 = cVar2.b();
        float f = a2;
        float f2 = f / a3;
        float f3 = b;
        float f4 = f3 / b2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f2 < f4) && (viewScaleType != ViewScaleType.CROP || f2 >= f4)) {
            a3 = (int) (f / f4);
        } else {
            b2 = (int) (f3 / f2);
        }
        if ((z || a3 >= a2 || b2 >= b) && (!z || a3 == a2 || b2 == b)) {
            return 1.0f;
        }
        return a3 / f;
    }
}
