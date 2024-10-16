package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import androidx.customview.a.a;

/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a, reason: collision with root package name */
    androidx.customview.a.a f5228a;
    a b;
    private boolean g;
    private boolean i;
    private float h = 0.0f;
    int c = 2;
    float d = 0.5f;
    float e = 0.0f;
    float f = 0.5f;
    private final a.AbstractC0051a j = new a.AbstractC0051a() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        private int b;
        private int c = -1;

        @Override // androidx.customview.a.a.AbstractC0051a
        public boolean b(View view, int i) {
            return this.c == -1 && SwipeDismissBehavior.this.a(view);
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(View view, int i) {
            this.c = i;
            this.b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(int i) {
            if (SwipeDismissBehavior.this.b != null) {
                SwipeDismissBehavior.this.b.a(i);
            }
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(View view, float f, float f2) {
            int i;
            boolean z;
            this.c = -1;
            int width = view.getWidth();
            if (a(view, f)) {
                int left = view.getLeft();
                int i2 = this.b;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.b;
                z = false;
            }
            if (SwipeDismissBehavior.this.f5228a.a(i, view.getTop())) {
                v.a(view, new b(view, z));
            } else {
                if (!z || SwipeDismissBehavior.this.b == null) {
                    return;
                }
                SwipeDismissBehavior.this.b.a(view);
            }
        }

        private boolean a(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.d);
            }
            boolean z = v.f(view) == 1;
            if (SwipeDismissBehavior.this.c == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.c == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (SwipeDismissBehavior.this.c != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public int a(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = v.f(view) == 1;
            if (SwipeDismissBehavior.this.c == 0) {
                if (z) {
                    width = this.b - view.getWidth();
                    width2 = this.b;
                } else {
                    width = this.b;
                    width2 = view.getWidth() + width;
                }
            } else if (SwipeDismissBehavior.this.c != 1) {
                width = this.b - view.getWidth();
                width2 = view.getWidth() + this.b;
            } else if (z) {
                width = this.b;
                width2 = view.getWidth() + width;
            } else {
                width = this.b - view.getWidth();
                width2 = this.b;
            }
            return SwipeDismissBehavior.a(width, i, width2);
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.a.a.AbstractC0051a
        public void a(View view, int i, int i2, int i3, int i4) {
            float width = this.b + (view.getWidth() * SwipeDismissBehavior.this.e);
            float width2 = this.b + (view.getWidth() * SwipeDismissBehavior.this.f);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f), 1.0f));
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);

        void a(View view);
    }

    static float b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public boolean a(View view) {
        return true;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(float f) {
        this.e = a(0.0f, f, 1.0f);
    }

    public void b(float f) {
        this.f = a(0.0f, f, 1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[RETURN] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            boolean r0 = r4.g
            int r1 = r7.getActionMasked()
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L21
            switch(r1) {
                case 0: goto Le;
                case 1: goto L21;
                default: goto Ld;
            }
        Ld:
            goto L23
        Le:
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r6 = r5.a(r6, r0, r1)
            r4.g = r6
            boolean r0 = r4.g
            goto L23
        L21:
            r4.g = r3
        L23:
            if (r0 == 0) goto L2f
            r4.a(r5)
            androidx.customview.a.a r5 = r4.f5228a
            boolean r5 = r5.a(r7)
            return r5
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        androidx.customview.a.a aVar = this.f5228a;
        if (aVar == null) {
            return false;
        }
        aVar.b(motionEvent);
        return true;
    }

    private void a(ViewGroup viewGroup) {
        androidx.customview.a.a a2;
        if (this.f5228a == null) {
            if (this.i) {
                a2 = androidx.customview.a.a.a(viewGroup, this.h, this.j);
            } else {
                a2 = androidx.customview.a.a.a(viewGroup, this.j);
            }
            this.f5228a = a2;
        }
    }

    /* loaded from: classes2.dex */
    private class b implements Runnable {
        private final View b;
        private final boolean c;

        b(View view, boolean z) {
            this.b = view;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.f5228a != null && SwipeDismissBehavior.this.f5228a.a(true)) {
                v.a(this.b, this);
            } else {
                if (!this.c || SwipeDismissBehavior.this.b == null) {
                    return;
                }
                SwipeDismissBehavior.this.b.a(this.b);
            }
        }
    }

    static float a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
