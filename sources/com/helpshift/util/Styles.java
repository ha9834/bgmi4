package com.helpshift.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.content.a;
import androidx.core.f.v;
import com.helpshift.R;

/* loaded from: classes2.dex */
public class Styles {
    public static int getColor(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static String getHexColor(Context context, int i) {
        return getHexColor(getColor(context, i));
    }

    public static String getHexColor(int i) {
        return String.format("#%06X", Integer.valueOf(i & 16777215));
    }

    public static void setActionButtonIconColor(Context context, Drawable drawable) {
        setColorFilter(context, drawable, R.attr.hs__actionButtonIconColor);
    }

    public static void setColorFilter(Context context, Drawable drawable, int i) {
        if (drawable != null) {
            drawable.setColorFilter(getColor(context, i), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static void setColorFilter(Drawable drawable, int i) {
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static float dpToPx(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static void setDrawable(Context context, View view, int i, int i2) {
        Drawable a2 = a.a(context, i);
        setColorFilter(context, a2, i2);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(a2);
        } else {
            view.setBackgroundDrawable(a2);
        }
    }

    public static void setGradientBackground(View view, int i, int i2, GradientDrawable.Orientation orientation) {
        v.a(view, new GradientDrawable(orientation, new int[]{i, i2}));
    }
}
