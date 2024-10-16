package com.google.android.material.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.google.android.material.c.d;

/* loaded from: classes2.dex */
public class b extends FrameLayout implements d {

    /* renamed from: a, reason: collision with root package name */
    private final c f5255a;

    @Override // com.google.android.material.c.d
    public void a() {
        this.f5255a.a();
    }

    @Override // com.google.android.material.c.d
    public void b() {
        this.f5255a.b();
    }

    @Override // com.google.android.material.c.d
    public d.C0115d getRevealInfo() {
        return this.f5255a.c();
    }

    @Override // com.google.android.material.c.d
    public void setRevealInfo(d.C0115d c0115d) {
        this.f5255a.a(c0115d);
    }

    @Override // com.google.android.material.c.d
    public int getCircularRevealScrimColor() {
        return this.f5255a.d();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealScrimColor(int i) {
        this.f5255a.a(i);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f5255a.e();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f5255a.a(drawable);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f5255a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.c.c.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f5255a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.c.c.a
    public boolean c() {
        return super.isOpaque();
    }
}
