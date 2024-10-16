package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.x;
import androidx.core.f.v;
import androidx.core.widget.i;
import com.google.android.material.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5341a;
    private final TextInputLayout b;
    private LinearLayout c;
    private int d;
    private FrameLayout e;
    private int f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    boolean a(int i) {
        return i == 0 || i == 1;
    }

    public b(TextInputLayout textInputLayout) {
        this.f5341a = textInputLayout.getContext();
        this.b = textInputLayout;
        this.h = this.f5341a.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        c();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a(this.q, charSequence));
    }

    void a() {
        c();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a(this.q, (CharSequence) null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        c();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a(this.m, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.k = null;
        c();
        if (this.i == 1) {
            if (this.p && !TextUtils.isEmpty(this.o)) {
                this.j = 2;
            } else {
                this.j = 0;
            }
        }
        a(this.i, this.j, a(this.m, (CharSequence) null));
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return v.x(this.b) && this.b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(final int i, final int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.p, this.q, 2, i, i2);
            a(arrayList, this.l, this.m, 1, i, i2);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            final TextView d = d(i);
            final TextView d2 = d(i2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    b.this.i = i2;
                    b.this.g = null;
                    TextView textView = d;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i != 1 || b.this.m == null) {
                            return;
                        }
                        b.this.m.setText((CharSequence) null);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    TextView textView = d2;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            a(i, i2);
        }
        this.b.updateEditTextBackground();
        this.b.updateLabelState(z);
        this.b.updateTextInputBoxState();
    }

    private void a(int i, int i2) {
        TextView d;
        TextView d2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (d2 = d(i2)) != null) {
            d2.setVisibility(0);
            d2.setAlpha(1.0f);
        }
        if (i != 0 && (d = d(i)) != null) {
            d.setVisibility(4);
            if (i == 1) {
                d.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(a(textView, i3 == i));
            if (i3 == i) {
                list.add(a(textView));
            }
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(com.google.android.material.a.a.f5204a);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(com.google.android.material.a.a.d);
        return ofFloat;
    }

    void c() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    private TextView d(int i) {
        switch (i) {
            case 1:
                return this.m;
            case 2:
                return this.q;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (n()) {
            v.b(this.c, v.h(this.b.getEditText()), 0, v.i(this.b.getEditText()), 0);
        }
    }

    private boolean n() {
        return (this.c == null || this.b.getEditText() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TextView textView, int i) {
        if (this.c == null && this.e == null) {
            this.c = new LinearLayout(this.f5341a);
            this.c.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.e = new FrameLayout(this.f5341a);
            this.c.addView(this.e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.c.addView(new androidx.legacy.a.a(this.f5341a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.b.getEditText() != null) {
                d();
            }
        }
        if (a(i)) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.c.addView(textView, i);
        }
        this.c.setVisibility(0);
        this.d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.c == null) {
            return;
        }
        if (a(i) && (frameLayout = this.e) != null) {
            this.f--;
            a(frameLayout, this.f);
            this.e.removeView(textView);
        } else {
            this.c.removeView(textView);
        }
        this.d--;
        a(this.c, this.d);
    }

    private void a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.l == z) {
            return;
        }
        c();
        if (z) {
            this.m = new x(this.f5341a);
            this.m.setId(a.f.textinput_error);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            b(this.n);
            this.m.setVisibility(4);
            v.c(this.m, 1);
            a(this.m, 0);
        } else {
            b();
            b(this.m, 0);
            this.m = null;
            this.b.updateEditTextBackground();
            this.b.updateTextInputBoxState();
        }
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        if (this.p == z) {
            return;
        }
        c();
        if (z) {
            this.q = new x(this.f5341a);
            this.q.setId(a.f.textinput_helper_text);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.q.setTypeface(typeface);
            }
            this.q.setVisibility(4);
            v.c(this.q, 1);
            c(this.r);
            a(this.q, 1);
        } else {
            a();
            b(this.q, 1);
            this.q = null;
            this.b.updateEditTextBackground();
            this.b.updateTextInputBoxState();
        }
        this.p = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return e(this.j);
    }

    private boolean e(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return f(this.i);
    }

    private boolean f(int i) {
        return (i != 2 || this.q == null || TextUtils.isEmpty(this.o)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a(this.m, typeface);
            a(this.q, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.n = i;
        TextView textView = this.m;
        if (textView != null) {
            this.b.setTextAppearanceCompatWithErrorFallback(textView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        TextView textView = this.q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.r = i;
        TextView textView = this.q;
        if (textView != null) {
            i.a(textView, i);
        }
    }
}
