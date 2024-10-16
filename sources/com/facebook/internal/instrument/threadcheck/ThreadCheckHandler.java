package com.facebook.internal.instrument.threadcheck;

import android.os.Looper;
import android.util.Log;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public final class ThreadCheckHandler {
    public static final ThreadCheckHandler INSTANCE = new ThreadCheckHandler();
    private static final String TAG = ThreadCheckHandler.class.getCanonicalName();
    private static boolean enabled;

    private ThreadCheckHandler() {
    }

    public static final void enable() {
        enabled = true;
    }

    public static final void uiThreadViolationDetected(Class<?> cls, String str, String str2) {
        h.b(cls, "clazz");
        h.b(str, "methodName");
        h.b(str2, "methodDesc");
        INSTANCE.log("@UiThread", cls, str, str2);
    }

    public static final void workerThreadViolationDetected(Class<?> cls, String str, String str2) {
        h.b(cls, "clazz");
        h.b(str, "methodName");
        h.b(str2, "methodDesc");
        INSTANCE.log("@WorkerThread", cls, str, str2);
    }

    private final void log(String str, Class<?> cls, String str2, String str3) {
        if (enabled) {
            l lVar = l.f6973a;
            Locale locale = Locale.US;
            Object[] objArr = {str, cls.getName(), str2, str3, Looper.myLooper(), Looper.getMainLooper()};
            String format = String.format(locale, "%s annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(locale, format, *args)");
            Exception exc = new Exception();
            Log.e(TAG, format, exc);
            InstrumentData.Builder.build(exc, InstrumentData.Type.ThreadCheck).save();
        }
    }
}
