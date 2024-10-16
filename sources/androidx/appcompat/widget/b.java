package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f346a;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f346a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f346a.d) {
            if (this.f346a.c != null) {
                this.f346a.c.draw(canvas);
            }
        } else {
            if (this.f346a.f250a != null) {
                this.f346a.f250a.draw(canvas);
            }
            if (this.f346a.b == null || !this.f346a.e) {
                return;
            }
            this.f346a.b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f346a.d) {
            if (this.f346a.c != null) {
                this.f346a.c.getOutline(outline);
            }
        } else if (this.f346a.f250a != null) {
            this.f346a.f250a.getOutline(outline);
        }
    }
}
