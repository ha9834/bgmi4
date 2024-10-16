package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.f.v;
import androidx.customview.a.a;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int activePointerId;
    private a callback;
    int collapsedOffset;
    private final a.AbstractC0051a dragCallback;
    private boolean fitToContents;
    int fitToContentsOffset;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    androidx.customview.a.a viewDragHelper;
    WeakReference<V> viewRef;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    public BottomSheetBehavior() {
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new a.AbstractC0051a() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // androidx.customview.a.a.AbstractC0051a
            public boolean b(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                    return false;
                }
                return ((BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == i && (view2 = BottomSheetBehavior.this.nestedScrollingChildRef.get()) != null && view2.canScrollVertically(-1)) || BottomSheetBehavior.this.viewRef == null || BottomSheetBehavior.this.viewRef.get() != view) ? false : true;
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public void a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public void a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public void a(View view, float f, float f2) {
                int i;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i = BottomSheetBehavior.this.fitToContentsOffset;
                        i2 = 3;
                    } else if (view.getTop() > BottomSheetBehavior.this.halfExpandedOffset) {
                        i = BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        i = 0;
                        i2 = 3;
                    }
                } else if (BottomSheetBehavior.this.hideable && BottomSheetBehavior.this.shouldHide(view, f2) && (view.getTop() > BottomSheetBehavior.this.collapsedOffset || Math.abs(f) < Math.abs(f2))) {
                    i = BottomSheetBehavior.this.parentHeight;
                    i2 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.fitToContentsOffset;
                            i2 = 3;
                        } else {
                            i = BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else if (top < BottomSheetBehavior.this.halfExpandedOffset) {
                        if (top < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i = 0;
                            i2 = 3;
                        } else {
                            i = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                        i = BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        i = BottomSheetBehavior.this.collapsedOffset;
                    }
                } else {
                    i = BottomSheetBehavior.this.collapsedOffset;
                }
                if (BottomSheetBehavior.this.viewDragHelper.a(view.getLeft(), i)) {
                    BottomSheetBehavior.this.setStateInternal(2);
                    v.a(view, new b(view, i2));
                } else {
                    BottomSheetBehavior.this.setStateInternal(i2);
                }
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public int b(View view, int i, int i2) {
                return androidx.core.b.a.a(i, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public int a(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public int b(View view) {
                if (BottomSheetBehavior.this.hideable) {
                    return BottomSheetBehavior.this.parentHeight;
                }
                return BottomSheetBehavior.this.collapsedOffset;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new a.AbstractC0051a() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // androidx.customview.a.a.AbstractC0051a
            public boolean b(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                    return false;
                }
                return ((BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == i && (view2 = BottomSheetBehavior.this.nestedScrollingChildRef.get()) != null && view2.canScrollVertically(-1)) || BottomSheetBehavior.this.viewRef == null || BottomSheetBehavior.this.viewRef.get() != view) ? false : true;
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public void a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public void a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public void a(View view, float f, float f2) {
                int i;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i = BottomSheetBehavior.this.fitToContentsOffset;
                        i2 = 3;
                    } else if (view.getTop() > BottomSheetBehavior.this.halfExpandedOffset) {
                        i = BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        i = 0;
                        i2 = 3;
                    }
                } else if (BottomSheetBehavior.this.hideable && BottomSheetBehavior.this.shouldHide(view, f2) && (view.getTop() > BottomSheetBehavior.this.collapsedOffset || Math.abs(f) < Math.abs(f2))) {
                    i = BottomSheetBehavior.this.parentHeight;
                    i2 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i = BottomSheetBehavior.this.fitToContentsOffset;
                            i2 = 3;
                        } else {
                            i = BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else if (top < BottomSheetBehavior.this.halfExpandedOffset) {
                        if (top < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i = 0;
                            i2 = 3;
                        } else {
                            i = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                        i = BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        i = BottomSheetBehavior.this.collapsedOffset;
                    }
                } else {
                    i = BottomSheetBehavior.this.collapsedOffset;
                }
                if (BottomSheetBehavior.this.viewDragHelper.a(view.getLeft(), i)) {
                    BottomSheetBehavior.this.setStateInternal(2);
                    v.a(view, new b(view, i2));
                } else {
                    BottomSheetBehavior.this.setStateInternal(i2);
                }
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public int b(View view, int i, int i2) {
                return androidx.core.b.a.a(i, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public int a(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.a.a.AbstractC0051a
            public int b(View view) {
                if (BottomSheetBehavior.this.hideable) {
                    return BottomSheetBehavior.this.parentHeight;
                }
                return BottomSheetBehavior.this.collapsedOffset;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && peekValue.data == -1) {
            setPeekHeight(peekValue.data);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.state);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.a());
        if (savedState.f5247a == 1 || savedState.f5247a == 2) {
            this.state = 4;
        } else {
            this.state = savedState.f5247a;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (v.q(coordinatorLayout) && !v.q(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.b(v, i);
        this.parentHeight = coordinatorLayout.getHeight();
        if (this.peekHeightAuto) {
            if (this.peekHeightMin == 0) {
                this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min);
            }
            this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.lastPeekHeight = this.peekHeight;
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - v.getHeight());
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int i2 = this.state;
        if (i2 == 3) {
            v.e(v, getExpandedOffset());
        } else if (i2 == 6) {
            v.e(v, this.halfExpandedOffset);
        } else if (this.hideable && i2 == 5) {
            v.e(v, this.parentHeight);
        } else {
            int i3 = this.state;
            if (i3 == 4) {
                v.e(v, this.collapsedOffset);
            } else if (i3 == 1 || i3 == 2) {
                v.e(v, top - v.getTop());
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = androidx.customview.a.a.a(coordinatorLayout, this.dragCallback);
        }
        this.viewRef = new WeakReference<>(v);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r9, V r10, android.view.MotionEvent r11) {
        /*
            r8 = this;
            boolean r0 = r10.isShown()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Lb
            r8.ignoreEvents = r2
            return r1
        Lb:
            int r0 = r11.getActionMasked()
            if (r0 != 0) goto L14
            r8.reset()
        L14:
            android.view.VelocityTracker r3 = r8.velocityTracker
            if (r3 != 0) goto L1e
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r8.velocityTracker = r3
        L1e:
            android.view.VelocityTracker r3 = r8.velocityTracker
            r3.addMovement(r11)
            r3 = 3
            r4 = 0
            r5 = -1
            if (r0 == r3) goto L6c
            switch(r0) {
                case 0: goto L2c;
                case 1: goto L6c;
                default: goto L2b;
            }
        L2b:
            goto L77
        L2c:
            float r3 = r11.getX()
            int r3 = (int) r3
            float r6 = r11.getY()
            int r6 = (int) r6
            r8.initialY = r6
            java.lang.ref.WeakReference<android.view.View> r6 = r8.nestedScrollingChildRef
            if (r6 == 0) goto L43
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L44
        L43:
            r6 = r4
        L44:
            if (r6 == 0) goto L5a
            int r7 = r8.initialY
            boolean r6 = r9.a(r6, r3, r7)
            if (r6 == 0) goto L5a
            int r6 = r11.getActionIndex()
            int r6 = r11.getPointerId(r6)
            r8.activePointerId = r6
            r8.touchingScrollingChild = r2
        L5a:
            int r6 = r8.activePointerId
            if (r6 != r5) goto L68
            int r5 = r8.initialY
            boolean r10 = r9.a(r10, r3, r5)
            if (r10 != 0) goto L68
            r10 = 1
            goto L69
        L68:
            r10 = 0
        L69:
            r8.ignoreEvents = r10
            goto L77
        L6c:
            r8.touchingScrollingChild = r1
            r8.activePointerId = r5
            boolean r10 = r8.ignoreEvents
            if (r10 == 0) goto L77
            r8.ignoreEvents = r1
            return r1
        L77:
            boolean r10 = r8.ignoreEvents
            if (r10 != 0) goto L86
            androidx.customview.a.a r10 = r8.viewDragHelper
            if (r10 == 0) goto L86
            boolean r10 = r10.a(r11)
            if (r10 == 0) goto L86
            return r2
        L86:
            java.lang.ref.WeakReference<android.view.View> r10 = r8.nestedScrollingChildRef
            if (r10 == 0) goto L91
            java.lang.Object r10 = r10.get()
            r4 = r10
            android.view.View r4 = (android.view.View) r4
        L91:
            r10 = 2
            if (r0 != r10) goto Lca
            if (r4 == 0) goto Lca
            boolean r10 = r8.ignoreEvents
            if (r10 != 0) goto Lca
            int r10 = r8.state
            if (r10 == r2) goto Lca
            float r10 = r11.getX()
            int r10 = (int) r10
            float r0 = r11.getY()
            int r0 = (int) r0
            boolean r9 = r9.a(r4, r10, r0)
            if (r9 != 0) goto Lca
            androidx.customview.a.a r9 = r8.viewDragHelper
            if (r9 == 0) goto Lca
            int r9 = r8.initialY
            float r9 = (float) r9
            float r10 = r11.getY()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            androidx.customview.a.a r10 = r8.viewDragHelper
            int r10 = r10.d()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto Lca
            r1 = 1
        Lca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.a.a aVar = this.viewDragHelper;
        if (aVar != null) {
            aVar.b(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.d()) {
            this.viewDragHelper.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.nestedScrollingChildRef.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < getExpandedOffset()) {
                    iArr[1] = top - getExpandedOffset();
                    v.e(v, -iArr[1]);
                    setStateInternal(3);
                } else {
                    iArr[1] = i2;
                    v.e(v, -i2);
                    setStateInternal(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i5 = this.collapsedOffset;
                if (i4 <= i5 || this.hideable) {
                    iArr[1] = i2;
                    v.e(v, -i2);
                    setStateInternal(1);
                } else {
                    iArr[1] = top - i5;
                    v.e(v, -iArr[1]);
                    setStateInternal(4);
                }
            }
            dispatchOnSlide(v.getTop());
            this.lastNestedScrollDy = i2;
            this.nestedScrolled = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        if (view == this.nestedScrollingChildRef.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                i2 = getExpandedOffset();
            } else if (this.hideable && shouldHide(v, getYVelocity())) {
                i2 = this.parentHeight;
                i3 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top = v.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                } else {
                    int i4 = this.halfExpandedOffset;
                    if (top < i4) {
                        if (top < Math.abs(top - this.collapsedOffset)) {
                            i2 = 0;
                        } else {
                            i2 = this.halfExpandedOffset;
                            i3 = 6;
                        }
                    } else if (Math.abs(top - i4) < Math.abs(top - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                        i3 = 6;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                }
            } else {
                i2 = this.collapsedOffset;
                i3 = 4;
            }
            if (this.viewDragHelper.a((View) v, v.getLeft(), i2)) {
                setStateInternal(2);
                v.a(v, new b(v, i3));
            } else {
                setStateInternal(i3);
            }
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.nestedScrollingChildRef.get() && (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
    }

    public final void setPeekHeight(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            }
            z = false;
        } else {
            if (this.peekHeightAuto || this.peekHeight != i) {
                this.peekHeightAuto = false;
                this.peekHeight = Math.max(0, i);
                this.collapsedOffset = this.parentHeight - i;
            }
            z = false;
        }
        if (!z || this.state != 4 || (weakReference = this.viewRef) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public void setHideable(boolean z) {
        this.hideable = z;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setBottomSheetCallback(a aVar) {
        this.callback = aVar;
    }

    public final void setState(final int i) {
        if (i == this.state) {
            return;
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                this.state = i;
                return;
            }
            return;
        }
        final V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && v.A(v)) {
            v.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.startSettlingAnimation(v, i);
                }
            });
        } else {
            startSettlingAnimation(v, i);
        }
    }

    public final int getState() {
        return this.state;
    }

    void setStateInternal(int i) {
        a aVar;
        if (this.state == i) {
            return;
        }
        this.state = i;
        if (i == 6 || i == 3) {
            updateImportantForAccessibility(true);
        } else if (i == 5 || i == 4) {
            updateImportantForAccessibility(false);
        }
        V v = this.viewRef.get();
        if (v == null || (aVar = this.callback) == null) {
            return;
        }
        aVar.onStateChanged(v, i);
    }

    private void calculateCollapsedOffset() {
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - this.lastPeekHeight;
        }
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        return view.getTop() >= this.collapsedOffset && Math.abs((((float) view.getTop()) + (f * HIDE_FRICTION)) - ((float) this.collapsedOffset)) / ((float) this.peekHeight) > HIDE_THRESHOLD;
    }

    View findScrollingChild(View view) {
        if (v.v(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return 0;
    }

    void startSettlingAnimation(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.collapsedOffset;
        } else if (i == 6) {
            int i4 = this.halfExpandedOffset;
            if (!this.fitToContents || i4 > (i3 = this.fitToContentsOffset)) {
                i2 = i4;
            } else {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else if (this.hideable && i == 5) {
            i2 = this.parentHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        if (this.viewDragHelper.a(view, view.getLeft(), i2)) {
            setStateInternal(2);
            v.a(view, new b(view, i));
        } else {
            setStateInternal(i);
        }
    }

    void dispatchOnSlide(int i) {
        a aVar;
        V v = this.viewRef.get();
        if (v == null || (aVar = this.callback) == null) {
            return;
        }
        if (i > this.collapsedOffset) {
            aVar.onSlide(v, (r2 - i) / (this.parentHeight - r2));
        } else {
            aVar.onSlide(v, (r2 - i) / (r2 - getExpandedOffset()));
        }
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private final View b;
        private final int c;

        b(View view, int i) {
            this.b = view;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.viewDragHelper != null && BottomSheetBehavior.this.viewDragHelper.a(true)) {
                v.a(this.b, this);
            } else {
                BottomSheetBehavior.this.setStateInternal(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        final int f5247a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5247a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f5247a = i;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5247a);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.e)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.b b2 = ((CoordinatorLayout.e) layoutParams).b();
        if (!(b2 instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior) b2;
    }

    private void updateImportantForAccessibility(boolean z) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.viewRef.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.importantForAccessibilityMap;
                        if (map != null && map.containsKey(childAt)) {
                            v.b(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        v.b(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }
}
