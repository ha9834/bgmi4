package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f571a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        if (Build.VERSION.SDK_INT < 18 || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        try {
            f571a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            e = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception e2) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
