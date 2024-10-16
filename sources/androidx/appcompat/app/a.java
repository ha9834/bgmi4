package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.b;

/* loaded from: classes.dex */
public abstract class a {

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }

    public abstract int a();

    public androidx.appcompat.view.b a(b.a aVar) {
        return null;
    }

    public void a(int i) {
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public Context b() {
        return null;
    }

    public void b(CharSequence charSequence) {
    }

    public void b(boolean z) {
    }

    public boolean c() {
        return false;
    }

    public void d(boolean z) {
    }

    public boolean d() {
        return false;
    }

    public void e(boolean z) {
    }

    public boolean e() {
        return false;
    }

    public void f(boolean z) {
    }

    public boolean f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
    }

    public void c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f175a;

        public C0027a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f175a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBarLayout);
            this.f175a = obtainStyledAttributes.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0027a(int i, int i2) {
            super(i, i2);
            this.f175a = 0;
            this.f175a = 8388627;
        }

        public C0027a(C0027a c0027a) {
            super((ViewGroup.MarginLayoutParams) c0027a);
            this.f175a = 0;
            this.f175a = c0027a.f175a;
        }

        public C0027a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f175a = 0;
        }
    }
}
