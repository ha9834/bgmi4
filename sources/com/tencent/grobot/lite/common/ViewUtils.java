package com.tencent.grobot.lite.common;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a.f;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.R;

/* loaded from: classes2.dex */
public class ViewUtils {
    private static final int FAST_CLICK_DELAY_TIME = 300;
    private static final String TAG = "ViewUtils";
    private static long lastClickTime = 0;
    private static float sAspectRatio = -1.0f;

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static Typeface getCustomFont(Context context) {
        return f.a(context, R.font.agency);
    }

    public static Typeface getCustomBoldFont(Context context) {
        return f.a(context, R.font.agency_bold);
    }

    public static void setTypeface(Context context, TextView textView) {
        if (context == null || textView == null) {
            return;
        }
        textView.setTypeface(getCustomFont(context));
    }

    public static void setBoldTypeface(Context context, TextView textView) {
        if (context == null || textView == null) {
            return;
        }
        textView.setTypeface(getCustomBoldFont(context));
    }

    public static int getScreenWidthPixels(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeightPixels(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static float getScreenAspectRatio(Context context) {
        if (sAspectRatio == -1.0f) {
            sAspectRatio = (getScreenWidthPixels(context) * 1.0f) / getScreenHeightPixels(context);
        }
        return sAspectRatio;
    }

    public static void clearViews(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                clearViews(viewGroup.getChildAt(i));
            }
            if (!(viewGroup instanceof AdapterView) && !(viewGroup instanceof RecyclerView)) {
                viewGroup.removeAllViews();
            }
        } else if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setCallback(null);
            }
            imageView.setImageDrawable(null);
        }
        view.setBackgroundResource(0);
    }

    public static int measureTextWidth(String str, float f, Typeface typeface) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setTypeface(typeface);
        return (int) paint.measureText(str);
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - lastClickTime < 300;
        lastClickTime = currentTimeMillis;
        return z;
    }
}
