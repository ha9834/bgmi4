package com.gamesafe.ano;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mtt.engine.http.HttpUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class TouchListenerProxy implements View.OnTouchListener {
    private static volatile TouchListenerProxy f;

    /* renamed from: a, reason: collision with root package name */
    private View.OnTouchListener f1092a;
    private int b;
    private int c;
    private int d;
    private boolean e = false;

    private TouchListenerProxy() {
    }

    private void a(MotionEvent motionEvent) {
        AnoSdk.ioctl(String.format(Locale.ENGLISH, a.a("VyyVijOjpxcZqzio:dy=%y|zo=%y|yo=%y|hd=%.1a|hv=%.1a"), Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())), Long.valueOf(motionEvent.getDownTime()), Long.valueOf(motionEvent.getEventTime()), Float.valueOf(motionEvent.getTouchMinor()), Float.valueOf(motionEvent.getTouchMajor())));
    }

    private void a(String str) {
        try {
            byte[] bytes = ("*#06#:" + str).getBytes(HttpUtils.DEFAULT_ENCODE_NAME);
            AnoSdk.onruntimeinfo(bytes, bytes.length);
        } catch (Exception unused) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        if (this.b == 0 || this.c == 0) {
            Context b = c.b();
            if (b == null) {
                return;
            }
            try {
                DisplayMetrics displayMetrics = b.getResources().getDisplayMetrics();
                this.b = displayMetrics.widthPixels;
                this.c = displayMetrics.heightPixels;
            } catch (Throwable unused) {
                this.b = 1;
                this.c = 1;
            }
        }
        if (this.b < 2 || this.c < 2) {
            return;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int i = this.b;
        int i2 = this.c;
        int deviceId = motionEvent.getDeviceId();
        InputDevice device = motionEvent.getDevice();
        String format = String.format(Locale.ENGLISH, "AddTouchEvent:col=%d|row=%d|col_max=%d|row_max=%d|id=%d|name=%s|source=%d|external=%d", Integer.valueOf(rawX), Integer.valueOf(rawY), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(deviceId), device == null ? "unavailable" : device.getName(), Integer.valueOf(motionEvent.getSource()), 0);
        AnoSdk.ioctl(format);
        int i3 = this.d;
        this.d = i3 + 1;
        if (i3 < 4) {
            a(format);
        }
    }

    public static TouchListenerProxy getInstance() {
        if (f == null) {
            synchronized (TouchListenerProxy.class) {
                if (f == null) {
                    f = new TouchListenerProxy();
                }
            }
        }
        return f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null) {
            switch (motionEvent.getAction()) {
                case 0:
                case 1:
                case 2:
                    b(motionEvent);
                    break;
            }
            if (motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 1) {
                a(motionEvent);
            }
        }
        View.OnTouchListener onTouchListener = this.f1092a;
        return onTouchListener != null ? onTouchListener.onTouch(view, motionEvent) : this.e;
    }

    public void setOntouchRetVal(boolean z) {
        this.e = z;
    }

    public void setRawListener(View.OnTouchListener onTouchListener) {
        this.f1092a = onTouchListener;
    }
}
