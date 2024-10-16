package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap {
    private static final ThreadLocal<TypedValue> i = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    static final int[] f333a = {-16842910};
    static final int[] b = {R.attr.state_focused};
    static final int[] c = {R.attr.state_activated};
    static final int[] d = {R.attr.state_pressed};
    static final int[] e = {R.attr.state_checked};
    static final int[] f = {R.attr.state_selected};
    static final int[] g = {-16842919, -16842908};
    static final int[] h = new int[0];
    private static final int[] j = new int[1];

    public static int a(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        au a2 = au.a(context, (AttributeSet) null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.a();
        }
    }

    public static ColorStateList b(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        au a2 = au.a(context, (AttributeSet) null, iArr);
        try {
            return a2.e(0);
        } finally {
            a2.a();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null && b2.isStateful()) {
            return b2.getColorForState(f333a, b2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, a2, true);
        return a(context, i2, a2.getFloat());
    }

    private static TypedValue a() {
        TypedValue typedValue = i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        i.set(typedValue2);
        return typedValue2;
    }

    static int a(Context context, int i2, float f2) {
        return androidx.core.graphics.b.b(a(context, i2), Math.round(Color.alpha(r0) * f2));
    }
}
