package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class CrashShieldHandler {
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    public static final boolean isDebug() {
        return false;
    }

    public static final void methodFinished(Object obj) {
    }

    private CrashShieldHandler() {
    }

    public static final void enable() {
        enabled = true;
    }

    public static final void disable() {
        enabled = false;
    }

    public static final void handleThrowable(Throwable th, Object obj) {
        h.b(obj, "o");
        if (enabled) {
            crashingObjects.add(obj);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th);
        }
    }

    public static final boolean isObjectCrashing(Object obj) {
        h.b(obj, "o");
        return crashingObjects.contains(obj);
    }

    public static final void reset() {
        resetCrashingObjects();
    }

    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    public static final void scheduleCrashInDebug(final Throwable th) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler$scheduleCrashInDebug$1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        throw new RuntimeException(th);
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        }
    }
}
