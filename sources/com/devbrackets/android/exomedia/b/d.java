package com.devbrackets.android.exomedia.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: classes.dex */
public class d {
    public static Drawable a(Context context, int i, int i2) {
        return a(context, a(context, i).mutate(), i2);
    }

    public static Drawable a(Context context, Drawable drawable, int i) {
        Drawable g = androidx.core.graphics.drawable.a.g(drawable);
        androidx.core.graphics.drawable.a.a(g, b(context, i));
        return g;
    }

    public static Drawable a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(i, context.getTheme());
        }
        return context.getResources().getDrawable(i);
    }

    public static ColorStateList b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColorStateList(i, context.getTheme());
        }
        return context.getResources().getColorStateList(i);
    }
}
