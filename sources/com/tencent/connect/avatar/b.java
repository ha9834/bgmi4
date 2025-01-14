package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes2.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private Rect f6195a;
    private Paint b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.b = new Paint();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a2 = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(Color.argb(100, 0, 0, 0));
        float f = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f, a2.top, this.b);
        canvas.drawRect(0.0f, a2.bottom, f, measuredHeight, this.b);
        canvas.drawRect(0.0f, a2.top, a2.left, a2.bottom, this.b);
        canvas.drawRect(a2.right, a2.top, f, a2.bottom, this.b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(-1);
        canvas.drawRect(a2.left, a2.top, a2.right - 1, a2.bottom, this.b);
    }

    public Rect a() {
        if (this.f6195a == null) {
            this.f6195a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.f6195a.set(i, i2, i + min, min + i2);
        }
        return this.f6195a;
    }
}
