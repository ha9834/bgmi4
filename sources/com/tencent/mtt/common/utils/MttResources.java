package com.tencent.mtt.common.utils;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mtt.engine.AppEngine;

/* loaded from: classes.dex */
public class MttResources {
    private static Context sContext = AppEngine.getInstance().getApplicationContex();

    public static int getLayoutId(String str) {
        return sContext.getResources().getIdentifier(str, "layout", sContext.getPackageName());
    }

    public static int getStringId(String str) {
        return sContext.getResources().getIdentifier(str, "string", sContext.getPackageName());
    }

    public static int getDrawableId(String str) {
        try {
            return sContext.getResources().getIdentifier(str, "drawable", sContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return sContext.getResources().getIdentifier(str, "thrdcall_transparent", sContext.getPackageName());
        }
    }

    public static int getStyleId(String str) {
        return sContext.getResources().getIdentifier(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, sContext.getPackageName());
    }

    public static int getId(String str) {
        return sContext.getResources().getIdentifier(str, "id", sContext.getPackageName());
    }

    public static int getColorId(String str) {
        return sContext.getResources().getIdentifier(str, "color", sContext.getPackageName());
    }

    public static int getDimensId(String str) {
        return sContext.getResources().getIdentifier(str, "dimen", sContext.getPackageName());
    }

    public static int getAttrId(String str) {
        return sContext.getResources().getIdentifier(str, "attr", sContext.getPackageName());
    }
}
