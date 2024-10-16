package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.a;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] e = {R.attr.colorBackground};
    private static final e f;

    /* renamed from: a, reason: collision with root package name */
    int f410a;
    int b;
    final Rect c;
    final Rect d;
    private boolean g;
    private boolean h;
    private final d i;

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f = new b();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f = new a();
        } else {
            f = new c();
        }
        f.a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0038a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        this.c = new Rect();
        this.d = new Rect();
        this.i = new d() { // from class: androidx.cardview.widget.CardView.1
            private Drawable b;

            @Override // androidx.cardview.widget.d
            public void a(Drawable drawable) {
                this.b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.d
            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.d
            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.d
            public void a(int i2, int i3, int i4, int i5) {
                CardView.this.d.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                CardView.super.setPadding(i2 + cardView.c.left, i3 + CardView.this.c.top, i4 + CardView.this.c.right, i5 + CardView.this.c.bottom);
            }

            @Override // androidx.cardview.widget.d
            public void a(int i2, int i3) {
                if (i2 > CardView.this.f410a) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.b) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // androidx.cardview.widget.d
            public Drawable c() {
                return this.b;
            }

            @Override // androidx.cardview.widget.d
            public View d() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.e.CardView, i, a.d.CardView);
        if (obtainStyledAttributes.hasValue(a.e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(a.e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(e);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(a.b.cardview_light_background);
            } else {
                color = getResources().getColor(a.b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(a.e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(a.e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(a.e.CardView_cardMaxElevation, 0.0f);
        this.g = obtainStyledAttributes.getBoolean(a.e.CardView_cardUseCompatPadding, false);
        this.h = obtainStyledAttributes.getBoolean(a.e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPadding, 0);
        this.c.left = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.c.top = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingTop, dimensionPixelSize);
        this.c.right = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingRight, dimensionPixelSize);
        this.c.bottom = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f410a = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_android_minWidth, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f.a(this.i, context, valueOf, dimension, dimension2, f2);
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.g != z) {
            this.g = z;
            f.g(this.i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(f instanceof b)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f.b(this.i)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f.c(this.i)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f410a = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.b = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f.a(this.i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f.a(this.i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f.i(this.i);
    }

    public int getContentPaddingLeft() {
        return this.c.left;
    }

    public int getContentPaddingRight() {
        return this.c.right;
    }

    public int getContentPaddingTop() {
        return this.c.top;
    }

    public int getContentPaddingBottom() {
        return this.c.bottom;
    }

    public void setRadius(float f2) {
        f.a(this.i, f2);
    }

    public float getRadius() {
        return f.d(this.i);
    }

    public void setCardElevation(float f2) {
        f.c(this.i, f2);
    }

    public float getCardElevation() {
        return f.e(this.i);
    }

    public void setMaxCardElevation(float f2) {
        f.b(this.i, f2);
    }

    public float getMaxCardElevation() {
        return f.a(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.h) {
            this.h = z;
            f.h(this.i);
        }
    }
}
