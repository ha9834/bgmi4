package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class c extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    final String f6196a;
    public boolean b;
    private Matrix c;
    private Matrix d;
    private int e;
    private float f;
    private float g;
    private Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private PointF l;
    private PointF m;
    private float n;
    private float o;
    private Rect p;

    private void a() {
    }

    public c(Context context) {
        super(context);
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.f6196a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        this.p = new Rect();
        getDrawingRect(this.p);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        float f4 = this.p.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - this.p.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float width2 = ((this.p.width() * f4) / (f5 + f4)) + this.p.left;
        float f6 = this.p.top - f2;
        float f7 = (f2 + height) - this.p.bottom;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        pointF.set(width2, ((this.p.height() * f6) / (f7 + f6)) + this.p.top);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.c.set(getImageMatrix());
                this.d.set(this.c);
                this.l.set(motionEvent.getX(), motionEvent.getY());
                this.e = 1;
                break;
            case 1:
            case 6:
                b();
                this.e = 0;
                break;
            case 2:
                int i = this.e;
                if (i != 1) {
                    if (i == 2) {
                        Matrix matrix = this.c;
                        matrix.set(matrix);
                        float a2 = a(motionEvent);
                        if (a2 > 10.0f) {
                            this.c.set(this.d);
                            float f = a2 / this.n;
                            this.c.postScale(f, f, this.m.x, this.m.y);
                        }
                        setImageMatrix(this.c);
                        break;
                    }
                } else {
                    this.c.set(this.d);
                    this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                    setImageMatrix(this.c);
                    break;
                }
                break;
            case 5:
                this.n = a(motionEvent);
                if (this.n > 10.0f) {
                    this.d.set(this.c);
                    a(this.m);
                    this.e = 2;
                    break;
                }
                break;
        }
        this.b = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Animation animation;
        if (this.h == null) {
            return;
        }
        float width = this.p.width();
        float height = this.p.height();
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        boolean z = false;
        float f3 = fArr[0];
        float f4 = this.f;
        if (f3 > f4) {
            this.o = f4 / f3;
            Matrix matrix = this.c;
            float f5 = this.o;
            matrix.postScale(f5, f5, this.m.x, this.m.y);
            setImageMatrix(this.c);
            float f6 = this.o;
            animation = new ScaleAnimation(1.0f / f6, 1.0f, 1.0f / f6, 1.0f, this.m.x, this.m.y);
        } else {
            float f7 = this.g;
            if (f3 < f7) {
                this.o = f7 / f3;
                Matrix matrix2 = this.c;
                float f8 = this.o;
                matrix2.postScale(f8, f8, this.m.x, this.m.y);
                float f9 = this.o;
                animation = new ScaleAnimation(1.0f, f9, 1.0f, f9, this.m.x, this.m.y);
            } else {
                float width2 = this.h.getWidth() * f3;
                float height2 = this.h.getHeight() * f3;
                float f10 = this.p.left - f;
                float f11 = this.p.top - f2;
                if (f10 < 0.0f) {
                    f = this.p.left;
                    z = true;
                }
                if (f11 < 0.0f) {
                    f2 = this.p.top;
                    z = true;
                }
                float f12 = height2 - f11;
                if (width2 - f10 < width) {
                    f = this.p.left - (width2 - width);
                    z = true;
                }
                if (f12 < height) {
                    f2 = this.p.top - (height2 - height);
                    z = true;
                }
                if (z) {
                    float f13 = fArr[2] - f;
                    float f14 = fArr[5] - f2;
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    animation = new TranslateAnimation(f13, 0.0f, f14, 0.0f);
                } else {
                    setImageMatrix(this.c);
                    animation = null;
                }
            }
        }
        if (animation != null) {
            this.i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        this.c.getValues(r0);
        float max = Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * max) - this.p.width()) / 2.0f);
        this.k = this.p.top - (((this.h.getHeight() * max) - this.p.height()) / 2.0f);
        float[] fArr = {max, 0.0f, this.j, 0.0f, max, this.k};
        this.c.setValues(fArr);
        this.f = Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.g = max;
        float f = this.f;
        float f2 = this.g;
        if (f < f2) {
            this.f = f2;
        }
        setImageMatrix(this.c);
    }
}
