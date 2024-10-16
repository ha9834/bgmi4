package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.e.a.a;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

/* loaded from: classes.dex */
public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    private void open() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            a.a(this.applicationContext).a(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void close() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            a.a(this.applicationContext).a(this);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            if (_instance != null) {
                return _instance;
            }
            _instance = new BoltsMeasurementEventListener(context);
            _instance.open();
            return _instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    protected void finalize() throws Throwable {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                close();
            } finally {
                super.finalize();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
            String str = BOLTS_MEASUREMENT_EVENT_PREFIX + intent.getStringExtra(MEASUREMENT_EVENT_NAME_KEY);
            Bundle bundleExtra = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
            Bundle bundle = new Bundle();
            for (String str2 : bundleExtra.keySet()) {
                bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
            }
            internalAppEventsLogger.logEvent(str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
