package com.tencent.grobot.lite.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LangUtils {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    private static final String TAG = "LangUtils";

    private LangUtils() {
        throw new UnsupportedOperationException("Can not create an object.");
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        Locale locale2 = new Locale("", "");
        if (locale != null && !locale.equals(locale2)) {
            String maximizeAndGetScript = maximizeAndGetScript(locale);
            if (maximizeAndGetScript == null) {
                switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                    case 1:
                    case 2:
                        return 1;
                    default:
                        return 0;
                }
            }
            if (maximizeAndGetScript.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    public static Context getAttachBaseContext(Context context, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return changeResLanguageAfterN(context, locale);
        }
        changeResLanguageBeforeN(context, locale);
        return context;
    }

    @TargetApi(24)
    private static Context changeResLanguageAfterN(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    private static void changeResLanguageBeforeN(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    private static String maximizeAndGetScript(Locale locale) {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            String str = (String) cls.getMethod("addLikelySubtags", String.class).invoke(null, locale.toString());
            if (str != null) {
                return (String) cls.getMethod("getScript", String.class).invoke(null, str);
            }
            return null;
        } catch (Exception e) {
            TLog.d(TAG, "maximizeAndGetScript failed, " + e.getMessage());
            return null;
        }
    }
}
