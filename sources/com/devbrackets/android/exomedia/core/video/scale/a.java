package com.devbrackets.android.exomedia.core.video.scale;

import android.graphics.Point;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Point f1034a = new Point(0, 0);
    protected int b = 0;
    protected ScaleType c = ScaleType.FIT_CENTER;
    protected Integer d = null;
    protected ScaleType e = null;
    protected WeakReference<View> f = new WeakReference<>(null);

    public boolean a() {
        return this.f1034a.x > 0 && this.f1034a.y > 0;
    }

    public void a(int i, int i2) {
        boolean z = (this.b / 90) % 2 == 1;
        this.f1034a.x = z ? i2 : i;
        Point point = this.f1034a;
        if (!z) {
            i = i2;
        }
        point.y = i;
        if (a()) {
            c();
        }
    }

    public ScaleType b() {
        ScaleType scaleType = this.e;
        return scaleType != null ? scaleType : this.c;
    }

    public void a(View view, int i) {
        if (!a()) {
            this.d = Integer.valueOf(i);
            this.f = new WeakReference<>(view);
            return;
        }
        if (((i / 90) % 2 == 1) != ((this.b / 90) % 2 == 1)) {
            int i2 = this.f1034a.x;
            Point point = this.f1034a;
            point.x = point.y;
            this.f1034a.y = i2;
            a(view, this.c);
        }
        this.b = i;
        view.setRotation(i);
    }

    public boolean a(View view, ScaleType scaleType) {
        if (!a()) {
            this.e = scaleType;
            this.f = new WeakReference<>(view);
            return false;
        }
        if (view.getHeight() == 0 || view.getWidth() == 0) {
            Log.d("MatrixManager", "Unable to apply scale with a view size of (" + view.getWidth() + ", " + view.getHeight() + ")");
            return false;
        }
        this.c = scaleType;
        switch (scaleType) {
            case CENTER:
                a(view);
                return true;
            case CENTER_CROP:
                b(view);
                return true;
            case CENTER_INSIDE:
                c(view);
                return true;
            case FIT_CENTER:
                d(view);
                return true;
            case FIT_XY:
                e(view);
                return true;
            case NONE:
                a(view, 1.0f, 1.0f);
                return true;
            default:
                return true;
        }
    }

    protected void a(View view) {
        a(view, this.f1034a.x / view.getWidth(), this.f1034a.y / view.getHeight());
    }

    protected void b(View view) {
        float width = view.getWidth() / this.f1034a.x;
        float height = view.getHeight() / this.f1034a.y;
        float max = Math.max(width, height);
        a(view, max / width, max / height);
    }

    protected void c(View view) {
        if (this.f1034a.x <= view.getWidth() && this.f1034a.y <= view.getHeight()) {
            a(view);
        } else {
            d(view);
        }
    }

    protected void d(View view) {
        float width = view.getWidth() / this.f1034a.x;
        float height = view.getHeight() / this.f1034a.y;
        float min = Math.min(width, height);
        a(view, min / width, min / height);
    }

    protected void e(View view) {
        a(view, 1.0f, 1.0f);
    }

    protected void a(View view, float f, float f2) {
        if ((this.b / 90) % 2 == 1) {
            float height = (f2 * view.getHeight()) / view.getWidth();
            f2 = (f * view.getWidth()) / view.getHeight();
            f = height;
        }
        view.setScaleX(f);
        view.setScaleY(f2);
    }

    protected void c() {
        View view = this.f.get();
        if (view != null) {
            Integer num = this.d;
            if (num != null) {
                a(view, num.intValue());
                this.d = null;
            }
            ScaleType scaleType = this.e;
            if (scaleType != null) {
                a(view, scaleType);
                this.e = null;
            }
        }
        this.f = new WeakReference<>(null);
    }
}
