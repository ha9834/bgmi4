package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class zae extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private int f3850a;
    private long b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private d j;
    private Drawable k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;

    public zae(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? b.f3845a : drawable;
        this.k = drawable;
        drawable.setCallback(this);
        d dVar = this.j;
        dVar.b = drawable.getChangingConfigurations() | dVar.b;
        drawable2 = drawable2 == null ? b.f3845a : drawable2;
        this.l = drawable2;
        drawable2.setCallback(this);
        d dVar2 = this.j;
        dVar2.b = drawable2.getChangingConfigurations() | dVar2.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zae(d dVar) {
        this.f3850a = 0;
        this.e = 255;
        this.g = 0;
        this.h = true;
        this.j = new d(dVar);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.j.f3846a | this.j.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.g == this.e) {
            this.g = i;
        }
        this.e = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.k.setColorFilter(colorFilter);
        this.l.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.k.getIntrinsicWidth(), this.l.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.k.getIntrinsicHeight(), this.l.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.k.setBounds(rect);
        this.l.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!a()) {
            return null;
        }
        this.j.f3846a = getChangingConfigurations();
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.o) {
            this.p = Drawable.resolveOpacity(this.k.getOpacity(), this.l.getOpacity());
            this.o = true;
        }
        return this.p;
    }

    private final boolean a() {
        if (!this.m) {
            this.n = (this.k.getConstantState() == null || this.l.getConstantState() == null) ? false : true;
            this.m = true;
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            if (!a()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.k.mutate();
            this.l.mutate();
            this.i = true;
        }
        return this;
    }

    public final Drawable zacf() {
        return this.l;
    }

    public final void startTransition(int i) {
        this.c = 0;
        this.d = this.e;
        this.g = 0;
        this.f = 250;
        this.f3850a = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        switch (this.f3850a) {
            case 1:
                this.b = SystemClock.uptimeMillis();
                this.f3850a = 2;
                r1 = false;
                break;
            case 2:
                if (this.b >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.b)) / this.f;
                    r1 = uptimeMillis >= 1.0f;
                    if (r1) {
                        this.f3850a = 0;
                    }
                    this.g = (int) ((this.d * Math.min(uptimeMillis, 1.0f)) + 0.0f);
                    break;
                }
                break;
        }
        int i = this.g;
        boolean z = this.h;
        Drawable drawable = this.k;
        Drawable drawable2 = this.l;
        if (r1) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            int i2 = this.e;
            if (i == i2) {
                drawable2.setAlpha(i2);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.e - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.e);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.e);
        }
        invalidateSelf();
    }
}
