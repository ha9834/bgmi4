package com.shieldtunnel.svpn.common.k;

import com.adjust.sdk.Constants;
import java.util.Calendar;
import java.util.SimpleTimeZone;

/* loaded from: classes2.dex */
public class a {
    static {
        new SimpleTimeZone(0, "UTC");
        new SimpleTimeZone(28800000, "CST");
    }

    public static Calendar a(long j) {
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
