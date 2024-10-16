package com.nostra13.universalimageloader.core.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class c implements a {

    /* renamed from: a, reason: collision with root package name */
    protected Reference<View> f5743a;
    protected boolean b;

    protected abstract void a(Bitmap bitmap, View view);

    protected abstract void a(Drawable drawable, View view);

    public c(View view) {
        this(view, true);
    }

    public c(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.f5743a = new WeakReference(view);
        this.b = z;
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public int a() {
        View view = this.f5743a.get();
        int i = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.b && layoutParams != null && layoutParams.width != -2) {
            i = view.getWidth();
        }
        return (i > 0 || layoutParams == null) ? i : layoutParams.width;
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public int b() {
        View view = this.f5743a.get();
        int i = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.b && layoutParams != null && layoutParams.height != -2) {
            i = view.getHeight();
        }
        return (i > 0 || layoutParams == null) ? i : layoutParams.height;
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public ViewScaleType c() {
        return ViewScaleType.CROP;
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public View d() {
        return this.f5743a.get();
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public boolean e() {
        return this.f5743a.get() == null;
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public int f() {
        View view = this.f5743a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public boolean a(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f5743a.get();
            if (view != null) {
                a(drawable, view);
                return true;
            }
        } else {
            com.nostra13.universalimageloader.b.c.c("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.c.a
    public boolean a(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f5743a.get();
            if (view != null) {
                a(bitmap, view);
                return true;
            }
        } else {
            com.nostra13.universalimageloader.b.c.c("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }
}
