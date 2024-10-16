package com.tencent.midas.oversea.comm;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.CocosPayHelper;
import java.text.DecimalFormat;
import java.util.List;

/* loaded from: classes.dex */
public class APCommMethod {
    public static final String TAG = "APCommMethod";

    public static void transformStrToMpInfoList(String str, List<String> list, List<String> list2) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
            return;
        }
        String substring = str.substring(indexOf + 1, indexOf2);
        if (substring.length() == 0) {
            list.clear();
            list2.clear();
            return;
        }
        String[] split = substring.split(",");
        int length = split.length;
        if (length <= 0 || length % 2 != 0) {
            return;
        }
        list.clear();
        list2.clear();
        for (int i = 0; i < length / 2; i++) {
            int i2 = i * 2;
            String str2 = split[i2];
            String str3 = split[i2 + 1];
            list.add(str2);
            list2.add(str3);
        }
    }

    public static void transformStrToList(String str, List<String> list) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        list.clear();
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
            return;
        }
        String substring = str.substring(indexOf + 1, indexOf2);
        if (substring.length() != 0) {
            for (String str2 : substring.split(",")) {
                list.add(str2);
            }
        }
    }

    public static String fenToYuan(String str, int i, String str2) {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        if (i == 0) {
            decimalFormat.applyPattern("0");
        } else if (i == 1) {
            decimalFormat.applyPattern("0.0");
        } else if (i == 2) {
            decimalFormat.applyPattern("0.00");
        }
        try {
            float floatValue = Float.valueOf(str).floatValue();
            if (str2.equalsIgnoreCase("VND")) {
                return decimalFormat.format(floatValue / 100000.0f) + "K";
            }
            return decimalFormat.format(floatValue / 100.0f);
        } catch (Exception e) {
            APLog.e(TAG, "fenToYuan(): " + e.getMessage());
            return "";
        }
    }

    public static int getLayoutId(Context context, String str) {
        return context.getResources().getIdentifier(str, "layout", context.getPackageName());
    }

    public static String getStringId(Context context, String str) {
        return context.getResources().getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }

    public static int getDrawableId(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Drawable getDrawable(Context context, String str) {
        return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
    }

    public static int getStyleId(Context context, String str) {
        return context.getResources().getIdentifier(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName());
    }

    public static int getDimenID(Context context, String str) {
        return context.getResources().getIdentifier(str, "dimen", context.getPackageName());
    }

    public static int getId(Context context, String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }

    public static int getColorId(Context context, String str) {
        return context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName()));
    }

    public static int getAnimId(Context context, String str) {
        return context.getResources().getIdentifier(str, "anim", context.getApplicationContext().getPackageName());
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return (int[]) Class.forName(context.getPackageName() + ".R$styleable").getDeclaredField(str).get(null);
        } catch (Throwable th) {
            APLog.e(TAG, "getStyleableIntArray(): " + th.getMessage());
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
            APLog.e(TAG, "getStyleableIntArrayIndex(): " + th.getMessage());
            return 0;
        }
    }

    public static void sendLocalBroadcast(Context context, String str, int i, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("androidx.e.a.a");
                Object invoke = cls.getMethod("getInstance", Context.class).invoke(cls, context);
                Intent intent = new Intent(str);
                intent.putExtra(CocosPayHelper.RES_CODE, i);
                intent.putExtra(CocosPayHelper.RES_MSG, str2);
                cls.getDeclaredMethod("sendBroadcast", Intent.class).invoke(invoke, intent);
            } catch (Exception unused) {
                Class<?> cls2 = Class.forName("androidx.e.a.a");
                Object invoke2 = cls2.getMethod("getInstance", Context.class).invoke(cls2, context);
                Intent intent2 = new Intent(str);
                intent2.putExtra(CocosPayHelper.RES_CODE, i);
                intent2.putExtra(CocosPayHelper.RES_MSG, str2);
                cls2.getDeclaredMethod("sendBroadcast", Intent.class).invoke(invoke2, intent2);
            }
        } catch (Exception e) {
            APLog.e(TAG, "createReflectObject(): reflect exception." + e.getMessage());
        }
    }
}
