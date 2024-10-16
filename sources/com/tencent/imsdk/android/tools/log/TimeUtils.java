package com.tencent.imsdk.android.tools.log;

import android.text.format.DateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class TimeUtils {
    private TimeUtils() {
    }

    public static Calendar getCalendar(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar;
    }

    public static long getCurUtcMillis() {
        return System.currentTimeMillis();
    }

    public static long getUtcMillis(long j) {
        return j - getCalendar(j).get(15);
    }

    public static long getMillis(long j, long j2) {
        return getUtcMillis(j) + j2;
    }

    public static long getCurMillis(long j) {
        return getMillis(System.currentTimeMillis(), j);
    }

    public static String getCurDate(long j) {
        return format(getCurMillis(j), "yyyy-MM-dd");
    }

    public static String format(long j, String str) {
        return DateFormat.format(str, j).toString();
    }

    public static String getCurTime(String str) {
        return format(System.currentTimeMillis(), str);
    }

    public static int getCurHour(long j) {
        return getCalendar(getCurMillis(j)).get(11);
    }
}
