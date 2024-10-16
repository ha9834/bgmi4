package com.google.android.material.c.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;
import com.google.android.material.c.c;
import com.google.android.material.c.d;

/* loaded from: classes2.dex */
public class a extends CardView implements d {
    private final c e;

    @Override // com.google.android.material.c.d
    public void a() {
        this.e.a();
    }

    @Override // com.google.android.material.c.d
    public void b() {
        this.e.b();
    }

    @Override // com.google.android.material.c.d
    public void setRevealInfo(d.C0115d c0115d) {
        this.e.a(c0115d);
    }

    @Override // com.google.android.material.c.d
    public d.C0115d getRevealInfo() {
        return this.e.c();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealScrimColor(int i) {
        this.e.a(i);
    }

    @Override // com.google.android.material.c.d
    public int getCircularRevealScrimColor() {
        return this.e.d();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.e.e();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.e.a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.e;
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
        c cVar = this.e;
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
