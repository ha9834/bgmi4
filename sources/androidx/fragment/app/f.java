package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.f.ad;
import androidx.fragment.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<View> f667a;
    private ArrayList<View> b;
    private View.OnApplyWindowInsetsListener c;
    private boolean d;

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        this.d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(a.c.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(a.c.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment d = fragmentManager.d(id);
        if (classAttribute != null && d == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment c = fragmentManager.E().c(context.getClassLoader(), classAttribute);
            c.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.a().c(true).a(this, c, string).e();
        }
        fragmentManager.a(this);
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        ad a2;
        ad a3 = ad.a(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.c;
        if (onApplyWindowInsetsListener != null) {
            a2 = ad.a(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            a2 = androidx.core.f.v.a(this, a3);
        }
        if (!a2.e()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                androidx.core.f.v.b(getChildAt(i), a2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.d && this.f667a != null) {
            for (int i = 0; i < this.f667a.size(); i++) {
                super.drawChild(canvas, this.f667a.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (!this.d || (arrayList = this.f667a) == null || arrayList.size() <= 0 || !this.f667a.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(view);
        }
        super.startViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f667a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.d = true;
            }
        }
        super.endViewTransition(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrawDisappearingViewsLast(boolean z) {
        this.d = z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.a(view) == null) {
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (FragmentManager.a(view) == null) {
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
        }
        return super.addViewInLayout(view, i, layoutParams, z);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f667a == null) {
            this.f667a = new ArrayList<>();
        }
        this.f667a.add(view);
    }
}
