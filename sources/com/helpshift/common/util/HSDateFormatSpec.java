package com.helpshift.common.util;

import com.helpshift.common.platform.Platform;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSSimpleDateFormat;
import com.helpshift.util.ValuePair;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class HSDateFormatSpec {
    public static final String DISPLAY_DATE_PATTERN = "EEEE, MMMM dd, yyyy";
    public static final String DISPLAY_TIME_PATTERN_12HR = "h:mm a";
    public static final String DISPLAY_TIME_PATTERN_24HR = "H:mm";
    public static final String STORAGE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String TAG = "Helpshift_DFSpec";
    public static final HSSimpleDateFormat STORAGE_TIME_FORMAT = new HSSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "GMT");
    private static final Map<String, HSSimpleDateFormat> formatterCache = new HashMap();

    private HSDateFormatSpec() {
    }

    public static HSSimpleDateFormat getDateFormatter(String str, Locale locale, String str2) {
        String str3 = str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + locale.getLanguage() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2;
        HSSimpleDateFormat hSSimpleDateFormat = formatterCache.get(str3);
        if (hSSimpleDateFormat != null) {
            return hSSimpleDateFormat;
        }
        HSSimpleDateFormat hSSimpleDateFormat2 = new HSSimpleDateFormat(str, locale, str2);
        formatterCache.put(str3, hSSimpleDateFormat2);
        return hSSimpleDateFormat2;
    }

    public static HSSimpleDateFormat getDateFormatter(String str, Locale locale) {
        String str2 = str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + locale.getLanguage();
        HSSimpleDateFormat hSSimpleDateFormat = formatterCache.get(str2);
        if (hSSimpleDateFormat != null) {
            return hSSimpleDateFormat;
        }
        HSSimpleDateFormat hSSimpleDateFormat2 = new HSSimpleDateFormat(str, locale);
        formatterCache.put(str2, hSSimpleDateFormat2);
        return hSSimpleDateFormat2;
    }

    public static long getCurrentAdjustedTimeInMillis(Platform platform) {
        float serverTimeDelta = platform.getNetworkRequestDAO().getServerTimeDelta();
        return System.currentTimeMillis() + ((serverTimeDelta <= -0.001f || serverTimeDelta >= 0.001f) ? serverTimeDelta * 1000.0f : 0L);
    }

    public static Date getCurrentAdjustedTime(Platform platform) {
        return new Date(getCurrentAdjustedTimeInMillis(platform));
    }

    public static ValuePair<String, Long> getCurrentAdjustedTimeForStorage(Platform platform) {
        Long valueOf = Long.valueOf(getCurrentAdjustedTimeInMillis(platform));
        return new ValuePair<>(STORAGE_TIME_FORMAT.format(new Date(valueOf.longValue())), valueOf);
    }

    public static String addMilliSeconds(HSSimpleDateFormat hSSimpleDateFormat, String str, int i) {
        try {
            Date parse = hSSimpleDateFormat.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            return hSSimpleDateFormat.format(new Date(calendar.getTimeInMillis() + i));
        } catch (ParseException e) {
            HSLogger.e(TAG, "Parsing exception on adding millisecond", e);
            return str;
        }
    }

    public static float calculateTimeDelta(String str) {
        Double valueOf = Double.valueOf(Double.parseDouble(str));
        double currentTimeMillis = System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        return (float) (valueOf.doubleValue() - Double.valueOf(currentTimeMillis / 1000.0d).doubleValue());
    }

    public static long convertToEpochTime(String str) {
        try {
            return STORAGE_TIME_FORMAT.parse(str).getTime();
        } catch (ParseException e) {
            HSLogger.e(TAG, "Parsing exception on converting storageTimeFormat to epochTime", e);
            return -1L;
        }
    }
}
