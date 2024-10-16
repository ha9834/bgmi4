package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class i extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    Drawable f5296a;
    Rect b;
    private Rect c;

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b == null || this.f5296a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        this.c.set(0, 0, width, this.b.top);
        this.f5296a.setBounds(this.c);
        this.f5296a.draw(canvas);
        this.c.set(0, height - this.b.bottom, width, height);
        this.f5296a.setBounds(this.c);
        this.f5296a.draw(canvas);
        this.c.set(0, this.b.top, this.b.left, height - this.b.bottom);
        this.f5296a.setBounds(this.c);
        this.f5296a.draw(canvas);
        this.c.set(width - this.b.right, this.b.top, width, height - this.b.bottom);
        this.f5296a.setBounds(this.c);
        this.f5296a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f5296a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f5296a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }
}
