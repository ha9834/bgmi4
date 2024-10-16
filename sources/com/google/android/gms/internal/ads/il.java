package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.intlgame.core.INTLMethodID;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
final class il implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final SensorManager f2244a;
    private final Display c;

    @GuardedBy("sensorThreadLock")
    private float[] f;
    private Handler g;
    private in h;
    private final float[] d = new float[9];
    private final float[] e = new float[9];
    private final Object b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public il(Context context) {
        this.f2244a = (SensorManager) context.getSystemService("sensor");
        this.c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.g != null) {
            return;
        }
        Sensor defaultSensor = this.f2244a.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzawz.zzen("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.g = new zzdbh(handlerThread.getLooper());
        if (this.f2244a.registerListener(this, defaultSensor, 0, this.g)) {
            return;
        }
        zzawz.zzen("SensorManager.registerListener failed.");
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.g == null) {
            return;
        }
        this.f2244a.unregisterListener(this);
        this.g.post(new im(this));
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(in inVar) {
        this.h = inVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.b) {
            if (this.f == null) {
                this.f = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.d, fArr);
        switch (this.c.getRotation()) {
            case 1:
                SensorManager.remapCoordinateSystem(this.d, 2, 129, this.e);
                break;
            case 2:
                SensorManager.remapCoordinateSystem(this.d, 129, INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN, this.e);
                break;
            case 3:
                SensorManager.remapCoordinateSystem(this.d, INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN, 1, this.e);
                break;
            default:
                System.arraycopy(this.d, 0, this.e, 0, 9);
                break;
        }
        a(1, 3);
        a(2, 6);
        a(5, 7);
        synchronized (this.b) {
            System.arraycopy(this.e, 0, this.f, 0, 9);
        }
        in inVar = this.h;
        if (inVar != null) {
            inVar.zztk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(float[] fArr) {
        synchronized (this.b) {
            if (this.f == null) {
                return false;
            }
            System.arraycopy(this.f, 0, fArr, 0, this.f.length);
            return true;
        }
    }

    private final void a(int i, int i2) {
        float[] fArr = this.e;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }
}
