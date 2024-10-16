package okhttp3.internal.b;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f7072a = new ThreadLocal<DateFormat>() { // from class: okhttp3.internal.b.d.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(okhttp3.internal.c.g);
            return simpleDateFormat;
        }
    };
    private static final String[] b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] c = new DateFormat[b.length];

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Date a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f7072a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (b) {
            int length = b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(b[i], Locale.US);
                    dateFormat.setTimeZone(okhttp3.internal.c.g);
                    c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String a(Date date) {
        return f7072a.get().format(date);
    }
}
