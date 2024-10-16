package com.intlgame.webview;

import android.content.Context;

/* loaded from: classes2.dex */
public class ResourceUtil {
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
}
