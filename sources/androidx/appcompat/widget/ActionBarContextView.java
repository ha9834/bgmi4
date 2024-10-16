package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public class ActionBarContextView extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ androidx.core.f.z a(int i, long j) {
        return super.a(i, j);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0024a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        au a2 = au.a(context, attributeSet, a.j.ActionMode, i, 0);
        androidx.core.f.v.a(this, a2.a(a.j.ActionMode_background));
        this.n = a2.g(a.j.ActionMode_titleTextStyle, 0);
        this.o = a2.g(a.j.ActionMode_subtitleTextStyle, 0);
        this.e = a2.f(a.j.ActionMode_height, 0);
        this.q = a2.g(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
        a2.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.g();
            this.d.i();
        }
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.j;
        if (view2 != null) {
            removeView(view2);
        }
        this.j = view;
        if (view != null && (linearLayout = this.k) != null) {
            removeView(linearLayout);
            this.k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        e();
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    private void e() {
        if (this.k == null) {
            LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
            this.k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.l = (TextView) this.k.findViewById(a.f.action_bar_title);
            this.m = (TextView) this.k.findViewById(a.f.action_bar_subtitle);
            if (this.n != 0) {
                this.l.setTextAppearance(getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        boolean z = !TextUtils.isEmpty(this.g);
        boolean z2 = !TextUtils.isEmpty(this.h);
        int i = 0;
        this.m.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.k;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.k.getParent() == null) {
            addView(this.k);
        }
    }

    public void a(final androidx.appcompat.view.b bVar) {
        View view = this.i;
        if (view == null) {
            this.i = LayoutInflater.from(getContext()).inflate(this.q, (ViewGroup) this, false);
            addView(this.i);
        } else if (view.getParent() == null) {
            addView(this.i);
        }
        this.i.findViewById(a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                bVar.c();
            }
        });
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.b();
        if (this.d != null) {
            this.d.h();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.a(this.d, this.b);
        this.c = (ActionMenuView) this.d.a(this);
        androidx.core.f.v.a(this.c, (Drawable) null);
        addView(this.c, layoutParams);
    }

    public void b() {
        if (this.i == null) {
            c();
        }
    }

    public void c() {
        removeAllViews();
        this.j = null;
        this.c = null;
    }

    @Override // androidx.appcompat.widget.a
    public boolean a() {
        if (this.d != null) {
            return this.d.e();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.e > 0 ? this.e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, BleSignal.UNKNOWN_TX_POWER);
        View view = this.i;
        if (view != null) {
            int a2 = a(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.c != null && this.c.getParent() == this) {
            paddingLeft = a(this.c, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.k;
        if (linearLayout != null && this.j == null) {
            if (this.p) {
                this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.j;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width != -2 ? 1073741824 : BleSignal.UNKNOWN_TX_POWER;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            int i5 = layoutParams.height == -2 ? BleSignal.UNKNOWN_TX_POWER : 1073741824;
            if (layoutParams.height >= 0) {
                i3 = Math.min(layoutParams.height, i3);
            }
            this.j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i3, i5));
        }
        if (this.e <= 0) {
            int childCount = getChildCount();
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                int measuredHeight = getChildAt(i7).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i6) {
                    i6 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i6);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a2 = ba.a(this);
        int paddingRight = a2 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.i;
        if (view == null || view.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int i6 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = a(paddingRight, i6, a2);
            i5 = a(a3 + a(this.i, a3, paddingTop, paddingTop2, a2), i7, a2);
        }
        LinearLayout linearLayout = this.k;
        int a4 = (linearLayout == null || this.j != null || linearLayout.getVisibility() == 8) ? i5 : i5 + a(this.k, i5, paddingTop, paddingTop2, a2);
        View view2 = this.j;
        if (view2 != null) {
            a(view2, a4, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a(this.c, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.p) {
            requestLayout();
        }
        this.p = z;
    }

    public boolean d() {
        return this.p;
    }
}
