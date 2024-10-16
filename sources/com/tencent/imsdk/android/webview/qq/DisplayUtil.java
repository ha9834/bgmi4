package com.tencent.imsdk.android.webview.qq;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DisplayUtil {
    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String filterUrlParaKey(String str, List<String> list) {
        IMLogger.d("filterUrlParaKey -|- origin url = " + str + ", keyArray = " + list);
        if (T.ckIsEmpty(str) || !str.contains("?") || list.size() == 0) {
            IMLogger.d("filterUrlParaKey -|- do not need process!");
            return str;
        }
        String substring = str.substring(str.indexOf("?") + 1);
        String substring2 = str.substring(0, str.indexOf("?"));
        String[] split = substring.split("&");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            arrayList.add(str2);
        }
        IMLogger.d("filterUrlParaKey -|- paraList start = " + arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str3.contains("=") && list.contains(str3.substring(0, str3.indexOf("=")))) {
                it.remove();
            }
        }
        IMLogger.d("filterUrlParaKey -|- paraList end = " + arrayList);
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() > 0) {
            String str4 = substring2 + "?";
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append((String) arrayList.get(i));
                sb.append("&");
            }
            String str5 = str4 + sb.toString();
            substring2 = str5.substring(0, str5.lastIndexOf("&"));
        }
        IMLogger.d("filterUrlParaKey -|- target url = " + substring2);
        return substring2;
    }
}
