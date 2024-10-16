package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.aw;
import androidx.appcompat.widget.x;

/* loaded from: classes.dex */
public class ActionMenuItemView extends x implements View.OnClickListener, n.a, ActionMenuView.a {

    /* renamed from: a, reason: collision with root package name */
    i f220a;
    g.b b;
    b c;
    private CharSequence e;
    private Drawable f;
    private af g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract p a();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionMenuItemView, i, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = e();
        f();
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.k = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f220a;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void a(i iVar, int i) {
        this.f220a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a((n.a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        af afVar;
        if (this.f220a.hasSubMenu() && (afVar = this.g) != null && afVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.f220a);
        }
    }

    public void setItemInvoker(g.b bVar) {
        this.b = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            i iVar = this.f220a;
            if (iVar != null) {
                iVar.h();
            }
        }
    }

    private void f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.e);
        if (this.f != null && (!this.f220a.m() || (!this.h && !this.i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.e : null);
        CharSequence contentDescription = this.f220a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f220a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f220a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            aw.a(this, z3 ? null : this.f220a.getTitle());
        } else {
            aw.a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.l;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            int i2 = this.l;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return b() && this.f220a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean d() {
        return b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.x, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean b2 = b();
        if (b2 && (i3 = this.k) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.j) : this.j;
        if (mode != 1073741824 && this.j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (b2 || this.f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* loaded from: classes.dex */
    private class a extends af {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.af
        public p a() {
            if (ActionMenuItemView.this.c != null) {
                return ActionMenuItemView.this.c.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.af
        protected boolean b() {
            p a2;
            return ActionMenuItemView.this.b != null && ActionMenuItemView.this.b.a(ActionMenuItemView.this.f220a) && (a2 = a()) != null && a2.e();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
