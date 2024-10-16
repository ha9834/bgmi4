package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.aw;
import androidx.core.f.t;
import androidx.core.f.v;
import com.google.android.material.a;

/* loaded from: classes2.dex */
public class a extends FrameLayout implements n.a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5243a = {R.attr.state_checked};
    private final int b;
    private float c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private ImageView h;
    private final TextView i;
    private final TextView j;
    private int k;
    private i l;
    private ColorStateList m;

    @Override // androidx.appcompat.view.menu.n.a
    public boolean a() {
        return false;
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(a.h.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(a.e.design_bottom_navigation_item_background);
        this.b = resources.getDimensionPixelSize(a.d.design_bottom_navigation_margin);
        this.h = (ImageView) findViewById(a.f.icon);
        this.i = (TextView) findViewById(a.f.smallLabel);
        this.j = (TextView) findViewById(a.f.largeLabel);
        v.b(this.i, 2);
        v.b(this.j, 2);
        setFocusable(true);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void a(i iVar, int i) {
        this.l = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        aw.a(this, iVar.getTooltipText());
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i) {
        this.k = i;
    }

    public int getItemPosition() {
        return this.k;
    }

    public void setShifting(boolean z) {
        if (this.g != z) {
            this.g = z;
            if (this.l != null) {
                setChecked(this.l.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f != i) {
            this.f = i;
            if (this.l != null) {
                setChecked(this.l.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.l;
    }

    public void setTitle(CharSequence charSequence) {
        this.i.setText(charSequence);
        this.j.setText(charSequence);
        i iVar = this.l;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.j.setPivotX(r0.getWidth() / 2);
        this.j.setPivotY(r0.getBaseline());
        this.i.setPivotX(r0.getWidth() / 2);
        this.i.setPivotY(r0.getBaseline());
        switch (this.f) {
            case -1:
                if (!this.g) {
                    if (z) {
                        a(this.h, (int) (this.b + this.c), 49);
                        a(this.j, 1.0f, 1.0f, 0);
                        TextView textView = this.i;
                        float f = this.d;
                        a(textView, f, f, 4);
                        break;
                    } else {
                        a(this.h, this.b, 49);
                        TextView textView2 = this.j;
                        float f2 = this.e;
                        a(textView2, f2, f2, 4);
                        a(this.i, 1.0f, 1.0f, 0);
                        break;
                    }
                } else {
                    if (z) {
                        a(this.h, this.b, 49);
                        a(this.j, 1.0f, 1.0f, 0);
                    } else {
                        a(this.h, this.b, 17);
                        a(this.j, 0.5f, 0.5f, 4);
                    }
                    this.i.setVisibility(4);
                    break;
                }
            case 0:
                if (z) {
                    a(this.h, this.b, 49);
                    a(this.j, 1.0f, 1.0f, 0);
                } else {
                    a(this.h, this.b, 17);
                    a(this.j, 0.5f, 0.5f, 4);
                }
                this.i.setVisibility(4);
                break;
            case 1:
                if (z) {
                    a(this.h, (int) (this.b + this.c), 49);
                    a(this.j, 1.0f, 1.0f, 0);
                    TextView textView3 = this.i;
                    float f3 = this.d;
                    a(textView3, f3, f3, 4);
                    break;
                } else {
                    a(this.h, this.b, 49);
                    TextView textView4 = this.j;
                    float f4 = this.e;
                    a(textView4, f4, f4, 4);
                    a(this.i, 1.0f, 1.0f, 0);
                    break;
                }
            case 2:
                a(this.h, this.b, 17);
                this.j.setVisibility(8);
                this.i.setVisibility(8);
                break;
        }
        refreshDrawableState();
        setSelected(z);
    }

    private void a(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void a(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.i.setEnabled(z);
        this.j.setEnabled(z);
        this.h.setEnabled(z);
        if (z) {
            v.a(this, t.a(getContext(), 1002));
        } else {
            v.a(this, (t) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        i iVar = this.l;
        if (iVar != null && iVar.isCheckable() && this.l.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f5243a);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, this.m);
        }
        this.h.setImageDrawable(drawable);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.m = colorStateList;
        i iVar = this.l;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.h.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i) {
        androidx.core.widget.i.a(this.i, i);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextAppearanceActive(int i) {
        androidx.core.widget.i.a(this.j, i);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.i.setTextColor(colorStateList);
            this.j.setTextColor(colorStateList);
        }
    }

    private void a(float f, float f2) {
        this.c = f - f2;
        this.d = (f2 * 1.0f) / f;
        this.e = (f * 1.0f) / f2;
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : androidx.core.content.a.a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        v.a(this, drawable);
    }
}
