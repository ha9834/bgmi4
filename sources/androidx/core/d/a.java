package androidx.core.d;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f503a;
    private static Method b;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f503a = cls.getMethod("getScript", String.class);
                    b = cls.getMethod("addLikelySubtags", String.class);
                    return;
                }
                return;
            } catch (Exception e) {
                f503a = null;
                b = null;
                Log.w("ICUCompat", e);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            try {
                b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String b2 = b(locale);
        if (b2 != null) {
            return a(b2);
        }
        return null;
    }

    private static String a(String str) {
        try {
            if (f503a != null) {
                return (String) f503a.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (b != null) {
                return (String) b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }
}
