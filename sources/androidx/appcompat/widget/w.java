package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.core.content.a.f;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f369a;
    private as b;
    private as c;
    private as d;
    private as e;
    private as f;
    private as g;
    private as h;
    private final y i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TextView textView) {
        this.f369a = textView;
        this.i = new y(this.f369a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        String str;
        ColorStateList colorStateList;
        String str2;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        ColorStateList colorStateList3;
        j jVar;
        j jVar2;
        Drawable drawable;
        int i2;
        Context context = this.f369a.getContext();
        j b = j.b();
        au a2 = au.a(context, attributeSet, a.j.AppCompatTextHelper, i, 0);
        int g = a2.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.g(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, b, a2.g(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.g(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, b, a2.g(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.g(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, b, a2.g(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.g(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, b, a2.g(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a2.g(a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, b, a2.g(a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a2.g(a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, b, a2.g(a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a2.a();
        boolean z3 = this.f369a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            au a3 = au.a(context, g, a.j.TextAppearance);
            if (z3 || !a3.g(a.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a3.a(a.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList e = a3.g(a.j.TextAppearance_android_textColor) ? a3.e(a.j.TextAppearance_android_textColor) : null;
                colorStateList = a3.g(a.j.TextAppearance_android_textColorHint) ? a3.e(a.j.TextAppearance_android_textColorHint) : null;
                if (a3.g(a.j.TextAppearance_android_textColorLink)) {
                    ColorStateList colorStateList4 = e;
                    colorStateList3 = a3.e(a.j.TextAppearance_android_textColorLink);
                    colorStateList2 = colorStateList4;
                } else {
                    colorStateList2 = e;
                    colorStateList3 = null;
                }
            } else {
                colorStateList = null;
                colorStateList2 = null;
                colorStateList3 = null;
            }
            str = a3.g(a.j.TextAppearance_textLocale) ? a3.d(a.j.TextAppearance_textLocale) : null;
            str2 = (Build.VERSION.SDK_INT < 26 || !a3.g(a.j.TextAppearance_fontVariationSettings)) ? null : a3.d(a.j.TextAppearance_fontVariationSettings);
            a3.a();
        } else {
            str = null;
            colorStateList = null;
            str2 = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
            colorStateList3 = null;
        }
        au a4 = au.a(context, attributeSet, a.j.TextAppearance, i, 0);
        if (!z3 && a4.g(a.j.TextAppearance_textAllCaps)) {
            z2 = a4.a(a.j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.g(a.j.TextAppearance_android_textColor)) {
                colorStateList2 = a4.e(a.j.TextAppearance_android_textColor);
            }
            if (a4.g(a.j.TextAppearance_android_textColorHint)) {
                colorStateList = a4.e(a.j.TextAppearance_android_textColorHint);
            }
            if (a4.g(a.j.TextAppearance_android_textColorLink)) {
                colorStateList3 = a4.e(a.j.TextAppearance_android_textColorLink);
            }
        }
        if (a4.g(a.j.TextAppearance_textLocale)) {
            str = a4.d(a.j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && a4.g(a.j.TextAppearance_fontVariationSettings)) {
            str2 = a4.d(a.j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT < 28) {
            jVar = b;
        } else if (!a4.g(a.j.TextAppearance_android_textSize)) {
            jVar = b;
        } else if (a4.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            jVar = b;
            this.f369a.setTextSize(0, 0.0f);
        } else {
            jVar = b;
        }
        a(context, a4);
        a4.a();
        if (colorStateList2 != null) {
            this.f369a.setTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.f369a.setHintTextColor(colorStateList);
        }
        if (colorStateList3 != null) {
            this.f369a.setLinkTextColor(colorStateList3);
        }
        if (!z3 && z) {
            a(z2);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f369a.setTypeface(typeface, this.j);
            } else {
                this.f369a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            this.f369a.setFontVariationSettings(str2);
        }
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f369a.setTextLocales(LocaleList.forLanguageTags(str));
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f369a.setTextLocale(Locale.forLanguageTag(str.substring(0, str.indexOf(44))));
            }
        }
        this.i.a(attributeSet, i);
        if (androidx.core.widget.b.d && this.i.a() != 0) {
            int[] e2 = this.i.e();
            if (e2.length > 0) {
                if (this.f369a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f369a.setAutoSizeTextTypeUniformWithConfiguration(this.i.c(), this.i.d(), this.i.b(), 0);
                } else {
                    this.f369a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        au a5 = au.a(context, attributeSet, a.j.AppCompatTextView);
        int g2 = a5.g(a.j.AppCompatTextView_drawableLeftCompat, -1);
        if (g2 != -1) {
            jVar2 = jVar;
            drawable = jVar2.a(context, g2);
        } else {
            jVar2 = jVar;
            drawable = null;
        }
        int g3 = a5.g(a.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable a6 = g3 != -1 ? jVar2.a(context, g3) : null;
        int g4 = a5.g(a.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable a7 = g4 != -1 ? jVar2.a(context, g4) : null;
        int g5 = a5.g(a.j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a8 = g5 != -1 ? jVar2.a(context, g5) : null;
        int g6 = a5.g(a.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable a9 = g6 != -1 ? jVar2.a(context, g6) : null;
        int g7 = a5.g(a.j.AppCompatTextView_drawableEndCompat, -1);
        a(drawable, a6, a7, a8, a9, g7 != -1 ? jVar2.a(context, g7) : null);
        if (a5.g(a.j.AppCompatTextView_drawableTint)) {
            androidx.core.widget.i.a(this.f369a, a5.e(a.j.AppCompatTextView_drawableTint));
        }
        if (a5.g(a.j.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            androidx.core.widget.i.a(this.f369a, ac.a(a5.a(a.j.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i2 = -1;
        }
        int e3 = a5.e(a.j.AppCompatTextView_firstBaselineToTopHeight, i2);
        int e4 = a5.e(a.j.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int e5 = a5.e(a.j.AppCompatTextView_lineHeight, i2);
        a5.a();
        if (e3 != i2) {
            androidx.core.widget.i.b(this.f369a, e3);
        }
        if (e4 != i2) {
            androidx.core.widget.i.c(this.f369a, e4);
        }
        if (e5 != i2) {
            androidx.core.widget.i.d(this.f369a, e5);
        }
    }

    public void a(Typeface typeface) {
        if (this.m) {
            this.f369a.setTypeface(typeface);
            this.l = typeface;
        }
    }

    public void a(Runnable runnable) {
        this.f369a.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends f.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<w> f370a;
        private final int b;
        private final int c;

        @Override // androidx.core.content.a.f.a
        public void a(int i) {
        }

        /* renamed from: androidx.appcompat.widget.w$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class RunnableC0033a implements Runnable {
            private final WeakReference<w> b;
            private final Typeface c;

            RunnableC0033a(WeakReference<w> weakReference, Typeface typeface) {
                this.b = weakReference;
                this.c = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                w wVar = this.b.get();
                if (wVar == null) {
                    return;
                }
                wVar.a(this.c);
            }
        }

        a(w wVar, int i, int i2) {
            this.f370a = new WeakReference<>(wVar);
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.core.content.a.f.a
        public void a(Typeface typeface) {
            int i;
            w wVar = this.f370a.get();
            if (wVar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i = this.b) != -1) {
                typeface = Typeface.create(typeface, i, (this.c & 2) != 0);
            }
            wVar.a(new RunnableC0033a(this.f370a, typeface));
        }
    }

    private void a(Context context, au auVar) {
        String d;
        this.j = auVar.a(a.j.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            this.k = auVar.a(a.j.TextAppearance_android_textFontWeight, -1);
            if (this.k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (auVar.g(a.j.TextAppearance_android_fontFamily) || auVar.g(a.j.TextAppearance_fontFamily)) {
            this.l = null;
            int i = auVar.g(a.j.TextAppearance_fontFamily) ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            int i2 = this.k;
            int i3 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface a2 = auVar.a(i, this.j, new a(this, i2, i3));
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                            this.l = Typeface.create(Typeface.create(a2, 0), this.k, (this.j & 2) != 0);
                        } else {
                            this.l = a2;
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l != null || (d = auVar.d(i)) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                this.l = Typeface.create(Typeface.create(d, 0), this.k, (this.j & 2) != 0);
                return;
            } else {
                this.l = Typeface.create(d, this.j);
                return;
            }
        }
        if (auVar.g(a.j.TextAppearance_android_typeface)) {
            this.m = false;
            switch (auVar.a(a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.l = Typeface.SANS_SERIF;
                    return;
                case 2:
                    this.l = Typeface.SERIF;
                    return;
                case 3:
                    this.l = Typeface.MONOSPACE;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        String d;
        ColorStateList e;
        au a2 = au.a(context, i, a.j.TextAppearance);
        if (a2.g(a.j.TextAppearance_textAllCaps)) {
            a(a2.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.g(a.j.TextAppearance_android_textColor) && (e = a2.e(a.j.TextAppearance_android_textColor)) != null) {
            this.f369a.setTextColor(e);
        }
        if (a2.g(a.j.TextAppearance_android_textSize) && a2.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.f369a.setTextSize(0, 0.0f);
        }
        a(context, a2);
        if (Build.VERSION.SDK_INT >= 26 && a2.g(a.j.TextAppearance_fontVariationSettings) && (d = a2.d(a.j.TextAppearance_fontVariationSettings)) != null) {
            this.f369a.setFontVariationSettings(d);
        }
        a2.a();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f369a.setTypeface(typeface, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f369a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f369a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f369a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, as asVar) {
        if (drawable == null || asVar == null) {
            return;
        }
        j.a(drawable, asVar, this.f369a.getDrawableState());
    }

    private static as a(Context context, j jVar, int i) {
        ColorStateList b = jVar.b(context, i);
        if (b == null) {
            return null;
        }
        as asVar = new as();
        asVar.d = true;
        asVar.f335a = b;
        return asVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.d) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (androidx.core.widget.b.d || d()) {
            return;
        }
        b(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.i.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.i.g();
    }

    private void b(int i, float f) {
        this.i.a(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.i.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.i.a(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, int i) throws IllegalArgumentException {
        this.i.a(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.i.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.i.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] i() {
        return this.i.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        as asVar = this.h;
        if (asVar != null) {
            return asVar.f335a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new as();
        }
        as asVar = this.h;
        asVar.f335a = colorStateList;
        asVar.d = colorStateList != null;
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        as asVar = this.h;
        if (asVar != null) {
            return asVar.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new as();
        }
        as asVar = this.h;
        asVar.b = mode;
        asVar.c = mode != null;
        l();
    }

    private void l() {
        as asVar = this.h;
        this.b = asVar;
        this.c = asVar;
        this.d = asVar;
        this.e = asVar;
        this.f = asVar;
        this.g = asVar;
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f369a.getCompoundDrawablesRelative();
            TextView textView = this.f369a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f369a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f369a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f369a.getCompoundDrawables();
        TextView textView3 = this.f369a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
}
