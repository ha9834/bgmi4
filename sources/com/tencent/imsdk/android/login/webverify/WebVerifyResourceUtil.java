package com.tencent.imsdk.android.login.webverify;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class WebVerifyResourceUtil {
    private static final String FORMAT_TYPEFACE_NAME = "fonts/%s.ttf";

    public static Typeface getTypeface(Context context, String str) {
        String format = String.format(FORMAT_TYPEFACE_NAME, str.toLowerCase());
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), format);
            IMLogger.d("get TTF " + format + " success!");
            return typeface;
        } catch (RuntimeException unused) {
            IMLogger.d("no TTF found : " + format);
            return typeface;
        }
    }

    public static int getLayoutId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", context.getPackageName());
    }

    public static int getStringId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    public static int getDrawableId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getStyleId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName());
    }

    public static int getId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }

    public static int getArrayId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "array", context.getPackageName());
    }

    public static Drawable getDrawable(Context context, String str) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        int drawableId = getDrawableId(context, str);
        if (drawableId != 0) {
            return resources.getDrawable(drawableId);
        }
        return null;
    }

    public static int getColorId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "color", context.getPackageName());
    }

    public static int getDimenId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", context.getPackageName());
    }

    public static int getAnimId(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return (int[]) Class.forName(context.getPackageName() + ".R$styleable").getDeclaredField(str).get(null);
        } catch (Throwable th) {
            IMLogger.e(th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static int getStyleableIntArrayIndex(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            return ((Integer) Class.forName(context.getPackageName() + ".R$styleable").getDeclaredField(str).get(null)).intValue();
        } catch (Throwable th) {
            IMLogger.e(th.getMessage(), new Object[0]);
            return 0;
        }
    }
}
