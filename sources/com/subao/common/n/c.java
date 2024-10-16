package com.subao.common.n;

import com.adjust.sdk.Constants;
import com.helpshift.util.ErrorReportProvider;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f6133a = new SimpleTimeZone(0, "UTC");
    public static final TimeZone b = new SimpleTimeZone(28800000, "CST");

    public static int a(long j) {
        return (int) (j / ErrorReportProvider.BATCH_TIME);
    }

    public static int a() {
        return a(System.currentTimeMillis() + 28800000);
    }

    public static Calendar b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar;
    }

    public static String a(Calendar calendar, int i) {
        StringBuilder sb = new StringBuilder(64);
        boolean z = (i & 1) != 0;
        if (z) {
            a(sb, calendar.get(1)).append('-');
            a(sb, calendar.get(2) + 1).append('-');
            a(sb, calendar.get(5));
        }
        boolean z2 = (i & 2) != 0;
        if (z2) {
            if (z) {
                sb.append(' ');
            }
            a(sb, calendar.get(11)).append(':');
            a(sb, calendar.get(12)).append(':');
            a(sb, calendar.get(13));
        }
        if ((i & 4) != 0) {
            if (z || z2) {
                sb.append(' ');
            }
            int i2 = calendar.get(15) / Constants.ONE_HOUR;
            if (i2 >= 0) {
                sb.append('+');
            }
            sb.append(i2);
        }
        return sb.toString();
    }

    private static StringBuilder a(StringBuilder sb, int i) {
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
        return sb;
    }
}
