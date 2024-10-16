package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class c extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f206a;

    public c(Drawable drawable) {
        a(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f206a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f206a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f206a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f206a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f206a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f206a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f206a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f206a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f206a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f206a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f206a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        androidx.core.graphics.drawable.a.a(this.f206a);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f206a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f206a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f206a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f206a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f206a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f206a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f206a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f206a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f206a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f206a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        androidx.core.graphics.drawable.a.a(this.f206a, z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return androidx.core.graphics.drawable.a.b(this.f206a);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        androidx.core.graphics.drawable.a.a(this.f206a, i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.f206a, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        androidx.core.graphics.drawable.a.a(this.f206a, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        androidx.core.graphics.drawable.a.a(this.f206a, f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        androidx.core.graphics.drawable.a.a(this.f206a, i, i2, i3, i4);
    }

    public Drawable a() {
        return this.f206a;
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f206a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f206a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
