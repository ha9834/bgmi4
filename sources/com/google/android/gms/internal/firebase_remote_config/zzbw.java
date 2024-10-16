package com.google.android.gms.internal.firebase_remote_config;

import java.io.Serializable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzbw implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f4138a = TimeZone.getTimeZone("GMT");
    private static final Pattern b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private final long value;
    private final boolean zzfq;
    private final int zzfr;

    public zzbw(long j) {
        this(false, 0L, null);
    }

    private zzbw(boolean z, long j, Integer num) {
        int offset;
        this.zzfq = z;
        this.value = j;
        if (z) {
            offset = 0;
        } else {
            offset = num == null ? TimeZone.getDefault().getOffset(j) / 60000 : num.intValue();
        }
        this.zzfr = offset;
    }

    public final String zzbx() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f4138a);
        gregorianCalendar.setTimeInMillis(this.value + (this.zzfr * 60000));
        a(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        a(sb, gregorianCalendar.get(5), 2);
        if (!this.zzfq) {
            sb.append('T');
            a(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                a(sb, gregorianCalendar.get(14), 3);
            }
            int i = this.zzfr;
            if (i == 0) {
                sb.append('Z');
            } else {
                if (i > 0) {
                    sb.append('+');
                } else {
                    sb.append('-');
                    i = -i;
                }
                a(sb, i / 60, 2);
                sb.append(':');
                a(sb, i % 60, 2);
            }
        }
        return sb.toString();
    }

    public final String toString() {
        return zzbx();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbw)) {
            return false;
        }
        zzbw zzbwVar = (zzbw) obj;
        return this.zzfq == zzbwVar.zzfq && this.value == zzbwVar.value && this.zzfr == zzbwVar.zzfr;
    }

    public final int hashCode() {
        long[] jArr = new long[3];
        jArr[0] = this.value;
        jArr[1] = this.zzfq ? 1L : 0L;
        jArr[2] = this.zzfr;
        return Arrays.hashCode(jArr);
    }

    public static zzbw zzaf(String str) throws NumberFormatException {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw new NumberFormatException(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new String("Invalid date/time format: "));
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        int parseInt2 = Integer.parseInt(matcher.group(2)) - 1;
        int parseInt3 = Integer.parseInt(matcher.group(3));
        boolean z2 = matcher.group(4) != null;
        String group = matcher.group(9);
        boolean z3 = group != null;
        Integer num = null;
        if (z3 && !z2) {
            String valueOf2 = String.valueOf(str);
            throw new NumberFormatException(valueOf2.length() != 0 ? "Invalid date/time format, cannot specify time zone shift without specifying time: ".concat(valueOf2) : new String("Invalid date/time format, cannot specify time zone shift without specifying time: "));
        }
        if (z2) {
            int parseInt4 = Integer.parseInt(matcher.group(5));
            int parseInt5 = Integer.parseInt(matcher.group(6));
            int parseInt6 = Integer.parseInt(matcher.group(7));
            if (matcher.group(8) != null) {
                z = z2;
                double pow = Math.pow(10.0d, matcher.group(8).substring(1).length() - 3);
                Double.isNaN(r2);
                i4 = (int) (r2 / pow);
                i2 = parseInt5;
                i3 = parseInt6;
                i = parseInt4;
            } else {
                z = z2;
                i2 = parseInt5;
                i3 = parseInt6;
                i4 = 0;
                i = parseInt4;
            }
        } else {
            z = z2;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f4138a);
        gregorianCalendar.set(parseInt, parseInt2, parseInt3, i, i2, i3);
        gregorianCalendar.set(14, i4);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (z && z3) {
            if (Character.toUpperCase(group.charAt(0)) == 'Z') {
                i5 = 0;
            } else {
                int parseInt7 = (Integer.parseInt(matcher.group(11)) * 60) + Integer.parseInt(matcher.group(12));
                int i6 = matcher.group(10).charAt(0) == '-' ? -parseInt7 : parseInt7;
                timeInMillis -= i6 * 60000;
                i5 = i6;
            }
            num = Integer.valueOf(i5);
        }
        return new zzbw(!z, timeInMillis, num);
    }

    private static void a(StringBuilder sb, int i, int i2) {
        if (i < 0) {
            sb.append('-');
            i = -i;
        }
        int i3 = i2;
        int i4 = i;
        while (i4 > 0) {
            i4 /= 10;
            i3--;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            sb.append('0');
        }
        if (i != 0) {
            sb.append(i);
        }
    }
}
