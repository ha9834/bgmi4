package com.gamesafe.ano;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class k implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private static volatile k f1099a;
    private SensorManager b;
    private boolean c;
    private int d;
    private Set e = new TreeSet();

    private k() {
    }

    public static k a() {
        if (f1099a == null) {
            synchronized (k.class) {
                if (f1099a == null) {
                    f1099a = new k();
                }
            }
        }
        return f1099a;
    }

    public void a(Context context) {
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                return;
            }
            this.b = sensorManager;
            this.d = 0;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
        } catch (Throwable unused) {
            b.a(a.a("Dido NzinjmHvivbzm avdgzy"));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            this.b.unregisterListener(this);
            return;
        }
        this.e.add(Integer.valueOf((int) (fArr[2] * 10.0f)));
        int i = this.d;
        this.d = i + 1;
        if (i > 1024 || (this.d > 64 && this.e.size() > 12)) {
            this.b.unregisterListener(this);
            if (this.d > 1000) {
                b.a(a.a("NzinjmXcvibzOjjHpxc"));
            }
            try {
                b.b(a.a("NzinjmXio:") + this.e.size() + a.a(" XcvibzXio:") + this.d);
            } catch (Throwable unused) {
            }
        }
    }
}
