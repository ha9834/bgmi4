package androidx.g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ac {

    /* renamed from: a, reason: collision with root package name */
    protected a f703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, ViewGroup viewGroup, View view) {
        this.f703a = new a(context, viewGroup, view, this);
    }

    static ViewGroup c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa d(View view) {
        ViewGroup c = c(view);
        if (c == null) {
            return null;
        }
        int childCount = c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = c.getChildAt(i);
            if (childAt instanceof a) {
                return ((a) childAt).e;
            }
        }
        return new u(c.getContext(), c, view);
    }

    @Override // androidx.g.ac
    public void a(Drawable drawable) {
        this.f703a.a(drawable);
    }

    @Override // androidx.g.ac
    public void b(Drawable drawable) {
        this.f703a.b(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup {

        /* renamed from: a, reason: collision with root package name */
        static Method f704a;
        ViewGroup b;
        View c;
        ArrayList<Drawable> d;
        aa e;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            try {
                f704a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, aa aaVar) {
            super(context);
            this.d = null;
            this.b = viewGroup;
            this.c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.e = aaVar;
        }

        public void a(Drawable drawable) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            if (this.d.contains(drawable)) {
                return;
            }
            this.d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.d) != null && arrayList.contains(drawable));
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.b && viewGroup.getParent() != null && androidx.core.f.v.A(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.b.getLocationOnScreen(iArr2);
                    androidx.core.f.v.f(view, iArr[0] - iArr2[0]);
                    androidx.core.f.v.e(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public void b(View view) {
            super.removeView(view);
            if (a()) {
                this.b.removeView(this);
            }
        }

        boolean a() {
            ArrayList<Drawable> arrayList;
            return getChildCount() == 0 && ((arrayList = this.d) == null || arrayList.size() == 0);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.b.getLocationOnScreen(new int[2]);
            this.c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.d.get(i).draw(canvas);
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.b.getLocationOnScreen(iArr2);
            this.c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
