package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f281a;
    private int b;
    private int c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ButtonBarLayout);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, a.j.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0, 0);
        }
        this.f281a = obtainStyledAttributes.getBoolean(a.j.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f281a != z) {
            this.f281a = z;
            if (!this.f281a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.f281a) {
            if (size > this.b && a()) {
                setStacked(false);
            }
            this.b = size;
        }
        if (a() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, BleSignal.UNKNOWN_TX_POWER);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f281a && !a()) {
            if ((getMeasuredWidthAndState() & WebView.NIGHT_MODE_COLOR) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int a2 = a(0);
        if (a2 >= 0) {
            View childAt = getChildAt(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (a()) {
                int a3 = a(a2 + 1);
                i4 = a3 >= 0 ? paddingTop + getChildAt(a3).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) : paddingTop;
            } else {
                i4 = paddingTop + getPaddingBottom();
            }
        }
        if (androidx.core.f.v.k(this) != i4) {
            setMinimumHeight(i4);
        }
    }

    private int a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.c, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(a.f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean a() {
        return getOrientation() == 1;
    }
}
