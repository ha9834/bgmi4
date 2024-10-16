package com.devbrackets.android.exomedia.b;

import com.helpshift.util.ErrorReportProvider;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static StringBuilder f1006a = new StringBuilder();
    private static Formatter b = new Formatter(f1006a, Locale.getDefault());

    public static String a(long j) {
        if (j < 0) {
            return "--:--";
        }
        long j2 = (j % 60000) / 1000;
        long j3 = (j % 3600000) / 60000;
        long j4 = (j % ErrorReportProvider.BATCH_TIME) / 3600000;
        f1006a.setLength(0);
        return j4 > 0 ? b.format("%d:%02d:%02d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString() : b.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j2)).toString();
    }
}
