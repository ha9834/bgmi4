package com.shieldtunnel.svpn.common.k;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class d {
    public static Locale a() {
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            if (!localeList.isEmpty()) {
                return localeList.get(0);
            }
        }
        return Locale.getDefault();
    }

    public static Locale b() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            if (!locales.isEmpty()) {
                return locales.get(0);
            }
        }
        return configuration.locale;
    }

    public static boolean a(Locale locale) {
        String country = locale.getCountry();
        return "CN".compareToIgnoreCase(country) == 0 || "CHS".compareToIgnoreCase(country) == 0;
    }

    public static boolean b(Locale locale) {
        return "zh".compareToIgnoreCase(locale.getLanguage()) == 0;
    }
}
