package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.widget.ag;

/* loaded from: classes.dex */
public class AlertDialogLayout extends ag {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.View
    public void onMeasure(int i, int i2) {
        if (a(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    private boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == a.f.topPanel) {
                    view = childAt;
                } else if (id == a.f.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != a.f.contentPanel && id != a.f.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            i3 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i3 = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            i4 = a(view2);
            i5 = view2.getMeasuredHeight() - i4;
            paddingTop += i4;
            i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i6 = view3.getMeasuredHeight();
            paddingTop += i6;
            i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
        } else {
            i6 = 0;
        }
        int i8 = size - paddingTop;
        if (view2 != null) {
            int i9 = paddingTop - i4;
            int min = Math.min(i8, i5);
            if (min > 0) {
                i8 -= min;
                i4 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            paddingTop = i9 + view2.getMeasuredHeight();
            i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
        }
        if (view3 != null && i8 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i6 + i8, mode));
            paddingTop = (paddingTop - i6) + view3.getMeasuredHeight();
            i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                i10 = Math.max(i10, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10 + getPaddingLeft() + getPaddingRight(), i, i3), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        b(childCount, i2);
        return true;
    }

    private void b(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                ag.a aVar = (ag.a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    private static int a(View view) {
        int k = androidx.core.f.v.k(view);
        if (k > 0) {
            return k;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return a(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ag, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & 112;
        int i8 = gravity & 8388615;
        if (i7 == 16) {
            paddingTop = getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
        } else if (i7 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - measuredHeight;
        } else {
            paddingTop = getPaddingTop();
        }
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                ag.a aVar = (ag.a) childAt.getLayoutParams();
                int i10 = aVar.h;
                if (i10 < 0) {
                    i10 = i8;
                }
                int a2 = androidx.core.f.d.a(i10, androidx.core.f.v.f(this)) & 7;
                if (a2 == 1) {
                    i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                } else if (a2 == 5) {
                    i5 = (paddingRight - measuredWidth) - aVar.rightMargin;
                } else {
                    i5 = aVar.leftMargin + paddingLeft;
                }
                if (hasDividerBeforeChildAt(i9)) {
                    paddingTop += intrinsicHeight;
                }
                int i11 = paddingTop + aVar.topMargin;
                a(childAt, i5, i11, measuredWidth, measuredHeight2);
                paddingTop = i11 + measuredHeight2 + aVar.bottomMargin;
            }
        }
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
