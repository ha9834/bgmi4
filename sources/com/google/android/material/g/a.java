package com.google.android.material.g;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.core.graphics.b;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f5275a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;

    static {
        f5275a = Build.VERSION.SDK_INT >= 21;
        b = new int[]{R.attr.state_pressed};
        c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        d = new int[]{R.attr.state_focused};
        e = new int[]{R.attr.state_hovered};
        f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        h = new int[]{R.attr.state_selected, R.attr.state_focused};
        i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        j = new int[]{R.attr.state_selected};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f5275a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f), a(colorStateList, b)});
        }
        int[] iArr = f;
        int[] iArr2 = g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = b;
        int[] iArr6 = c;
        int[] iArr7 = d;
        int[] iArr8 = e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f5275a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    private static int a(int i2) {
        return b.b(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
