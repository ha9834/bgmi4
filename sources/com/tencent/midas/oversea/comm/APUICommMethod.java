package com.tencent.midas.oversea.comm;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class APUICommMethod {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static BitmapDrawable getAppResDrawable(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    public static <T extends View> T findViewById(Activity activity, String str) {
        return (T) activity.findViewById(APCommMethod.getId(activity, str));
    }

    public static <T extends View> T findViewById(View view, String str) {
        return (T) view.findViewById(APCommMethod.getId(view.getContext(), str));
    }

    public static void clearCoverForStatus(Window window, boolean z) {
        if (z) {
            String str = Build.MANUFACTURER + Build.MODEL;
            if (str != null && str.equals("MeizuPRO 7-S")) {
                setTranslucentStatus(window);
            } else {
                checkImmersiveStatusBar(window);
            }
        }
    }

    private static void setTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
                declaredField.setAccessible(true);
                declaredField.setInt(window.getDecorView(), 0);
            } catch (Exception e) {
                APLog.e("APUICommMethod", "setTranslucentStatus exception: " + e.getMessage());
            }
        }
    }

    private static void checkImmersiveStatusBar(Window window) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(BleSignal.UNKNOWN_TX_POWER);
            window.setStatusBarColor(0);
            return;
        }
        window.addFlags(67108864);
    }
}
